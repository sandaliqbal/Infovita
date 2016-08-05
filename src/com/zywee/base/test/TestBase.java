package com.zywee.base.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

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
	
	@BeforeMethod
	public void setUp(Method method) throws Exception {	
//		Logger logger = Logger.getLogger(method.getDeclaringClass());
//		logger.setLevel(Level.INFO);
		System.out.println("Executing: "+method.getDeclaringClass()+"."+method.getName());
	}
	
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
			
			if(propertyMap.get("browser").equals("firefox")) {
				final FirefoxProfile profile = new FirefoxProfile();
				JavaScriptError.addExtension(profile);
				driver = new FirefoxDriver(profile);
			} else {
				DesiredCapabilities caps = new DesiredCapabilities();
                caps.setJavascriptEnabled(true);  
				setPhantomJsBinaryPath(caps);
				String[] phantomArgs = new  String[] {
					    "--webdriver-loglevel=NONE"
					};
				caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
				driver = new PhantomJSDriver(caps);
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
	
	private void setPhantomJsBinaryPath(DesiredCapabilities caps) {
		File file = new File("phantomjs/mac/bin/phantomjs");
		if(propertyMap.get("platform").equals("mac")) {
			file = new File("phantomjs/mac/bin/phantomjs");
			System.setProperty("phantomjs.binary.path", file.getAbsolutePath()); 
		} else if(propertyMap.get("platform").equals("linux_64")) {
			file = new File("phantomjs/linux64/bin/phantomjs");
			System.setProperty("phantomjs.binary.path", file.getAbsolutePath()); 
		} else if(propertyMap.get("platform").equals("linux_32")) {
			file = new File("phantomjs/linux32/bin/phantomjs");
			System.setProperty("phantomjs.binary.path", file.getAbsolutePath()); 
		} else if(propertyMap.get("platform").equals("windows")) {
			file = new File("phantomjs/windows/bin/phantomjs.exe");
			System.setProperty("phantomjs.binary.path", file.getAbsolutePath()); 
		}		
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, file.getAbsolutePath());
	}
}
