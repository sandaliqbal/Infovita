package com.zywee.base.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import com.thoughtworks.selenium.webdriven.commands.GetText;
import com.zywee.tools.WaitTool;



/**
 * Test base class.  
 * What are the each test common  properties : implicitlyWait, WebDriver
 * @author owner
 *
 */
public class TestBase {

	/** This page's WebDriver */ 
	protected WebDriver driver;
	
	protected static Map<String,String> propertyMap = new HashMap<String,String>();
	
	/** 
	 * Initialize test properties ( WebDriver, implicitlyWait, and etc).  
	 * 
	 * Note: for some project you can initialize the test setting based on property files or excel fille.*/ 
	protected void initialize(WebDriver driver){
		//implicitlyWait will poll the DOM every 500 milliseconds until the element is found (or timeout after 9 seconds)
		driver.manage().timeouts().implicitlyWait(WaitTool.DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); 
		this.driver = driver; 
	}
	
	protected void init() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			//
			String dir = System.getProperty("user.dir");
			input = new FileInputStream(dir+"/src/config.properties");
			//input = getClass().getClassLoader().getResourceAsStream(dir+"/Users/i309187/Downloads/wtbox-master/src/wtbox/test/config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			propertyMap.put("baseUrl", prop.getProperty("baseUrl"));
			propertyMap.put("browser", prop.getProperty("browser"));
			propertyMap.put("platform", prop.getProperty("platform"));
			System.out.println(prop.getProperty("baseUrl"));
			System.out.println(prop.getProperty("browser"));
			
			if(propertyMap.get("browser").equals("firefox")) {
				final FirefoxProfile profile = new FirefoxProfile();
				JavaScriptError.addExtension(profile);
				driver = new FirefoxDriver(profile);
			} else {
				setPhantomJsBinaryPath(); 
				driver = new PhantomJSDriver();
			}
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String getBaseURL() {
	    return propertyMap.get("baseUrl");
	}
	
	public void checkJSErrors() {
		List jsErrors = JavaScriptError.readErrors(driver);
		Assert.assertTrue(jsErrors.isEmpty());	
	}
	

	/**
	 * Set the driver implicitlyWait time.  
	 * @param waitTimeInSeconds
	 */
	public void setImplicitlyWaitTime(int waitTimeInSeconds){
		driver.manage().timeouts().implicitlyWait(waitTimeInSeconds, TimeUnit.SECONDS); 
	}
	
	public static void main(String[] args) {

        BufferedReader br = null;

        try {

            String sCurrentLine;
            String next;
            
            String dir = System.getProperty("user.dir");
            br = new BufferedReader(new FileReader(dir+"/Users/i309187/Downloads/wtbox-master/src/wtbox/test/testing.txt"));
            sCurrentLine = br.readLine();
            System.out.print(sCurrentLine+"-");
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.print(sCurrentLine);
                System.out.println();
                System.out.print(sCurrentLine+"-");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
	
	private void setPhantomJsBinaryPath() {
		if(propertyMap.get("platform").equals("mac")) {
			File file = new File("phantomjs-2.1.1-macosx/bin/phantomjs");
			System.setProperty("phantomjs.binary.path", file.getAbsolutePath()); 
		} else if(propertyMap.get("platform").equals("linux")) {
			File file = new File("phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
			System.setProperty("phantomjs.binary.path", file.getAbsolutePath()); 
		}
	}
}
