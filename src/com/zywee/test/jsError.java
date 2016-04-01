package com.zywee.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class jsError {
    WebDriver driver;

    
    public void setup() throws Exception {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.CLIENT, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        logs.enable(LogType.PERFORMANCE, Level.ALL);
        logs.enable(LogType.PROFILER, Level.ALL);
        logs.enable(LogType.SERVER, Level.ALL);

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        desiredCapabilities.setJavascriptEnabled(true);

        //WebDriver driver = new FirefoxDriver(desiredCapabilities);
     FirefoxProfile profile = new FirefoxProfile();
     JavaScriptError.addExtension(profile);
     desiredCapabilities.setCapability(FirefoxDriver.PROFILE, profile);
     driver = new FirefoxDriver(desiredCapabilities);
     
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.get("http://only-testing-blog.blogspot.com/2015/01/table-with-checkbox.html");
    }
    
   
    public void tearDown() {
        Logs logs = driver.manage().logs();
        LogEntries logEntries = logs.get(LogType.DRIVER);

        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry.getMessage());
        }
        driver.close();
        driver.quit();
    }

    public void printPageErrors() throws Exception {
     //Capture all errors and store them In array.
     List<JavaScriptError> Errors = JavaScriptError.readErrors(driver);
     System.out.println("Total No Of JavaScript Errors : " + Errors.size());
     //Print Javascript Errors one by one from array.
     for (int i = 0; i < Errors.size(); i++) {
      System.out.println("Error Message : "
        + Errors.get(i).getErrorMessage());
      System.out.println("Error Line No : "
        + Errors.get(i).getLineNumber());
      System.out.println(Errors.get(i).getSourceName());
      System.out.println();
     }
    }
   }
