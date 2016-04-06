package com.zywee.base.page;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.beust.jcommander.Strings;
import com.zywee.base.test.TestBase;



/**
 * Page Object base class.  It provides the base structure 
 * and properties for a page object to extend.  
 * 
 * @author Chon Chung
 */
public class PageBase {
	  /** Default URL */
	  protected String URL = TestBase.getBaseURL();	
	  
	  /** This page's WebDriver */ 
	  protected static WebDriver driver; 
	  
	  /** Expected Page Title.  This will be used in isPageLoad() 
	   * to check if page is loaded. */
	  protected static String pageTitle = "Find Hospitals, Diagnostics, Clinics, Doctors, Health Packages book online - Zywee"; 
	  
	  private List<String> brokenUrls = new ArrayList();
	  
	  protected static StringBuilder assertionErrors = new StringBuilder();
	  
	  protected static SoftAssert softAssert = new SoftAssert();
	  
	  
	  /** Constructor */ 
	  public PageBase(WebDriver driver) {
		  this.driver = driver; 
	  }
	  
	  public PageBase(WebDriver driver, String pageTitle) {
		  this.driver = driver; 
		  this.pageTitle = pageTitle; 
	  }
	  
	  /** 
	   * Check if page is loaded by comparing 
	   * the expected page-title with an actual page-title. 
	   **/ 
	  public static boolean isPageLoad(){
		  return (driver.getTitle().contains(pageTitle)); 
	  }
	  
	  
	  /** Open the default page */ 
	  public void open() {
	      driver.manage().window().maximize();
		  driver.get(URL); 
	  }
	  
	  
	  /** Returns the page title */ 
	  public String getTitle() {
		  //return pageTitle; 
		  return driver.getTitle();
	  }
	  
	  /** Returns the default URL */ 
	  public String getURL() {
		return URL;
	  }
	  
	  public void setURL(String url) {
			URL = url;
	  }
	  
	  /** 
	   * Send text keys to the element that finds by cssSelector.  
	   * It shortens "driver.findElement(By.cssSelector()).sendKeys()". 
	   * @param cssSelector
	   * @param text
	   */
	  protected void sendText(String cssSelector, String text) {
			driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
	  }
	  
	  public static String getText(String cssSelector) {
		  return driver.findElement(By.cssSelector(cssSelector)).getText();
	  }
	  
	  public static String getText(By selector) {
          return driver.findElement(selector).getText();
      }
	  
	  /** Is the text present in page. */ 
	  public boolean isTextPresent(String text){
		  return driver.getPageSource().contains(text); 
	  }
	  
	  /** Is the Element in page. */
	  public static boolean isElementPresent(By by) {
			try {
				driver.findElement(by);//if it does not find the element throw NoSuchElementException, thus returns false. 
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}
	  }

	  /** 
	   * Is the Element present in the DOM. 
	   * 
	   * @param _cssSelector 		element locater
	   * @return					WebElement
	   */
	  public static boolean isElementPresent(String _cssSelector){
			try {
				driver.findElement(By.cssSelector(_cssSelector));
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}
	  }
	  

	  /**
		* Checks if the elment is in the DOM and displayed. 
		* 
		* @param by - selector to find the element
		* @return true or false
		*/
	  public boolean isElementPresentAndDisplay(By by) {
			try {			
				return driver.findElement(by).isDisplayed();
			} catch (NoSuchElementException e) {
				return false;
			}
	  }
	  
	  /** 
	   * Returns the first WebElement using the given method.  	   
	   * It shortens "driver.findElement(By)". 
	   * @param by 		element locater. 
	   * @return 		the first WebElement
	   */
	  public WebElement getWebElement(By by){
		  	return driver.findElement(by); 			
	  }
	  
	public void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url
					.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				String msg = linkUrl + " - "
				+ httpURLConnect.getResponseMessage() + " - "
				+ HttpURLConnection.HTTP_NOT_FOUND;
				brokenUrls.add(msg);
				System.out.println(msg);
				throw new NotFoundException(msg);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void checkJSErrors() {
		List jsErrors = JavaScriptError.readErrors(driver);
		Assert.assertTrue(jsErrors.isEmpty());
	}
	
	public void windowFocus(String windowTitle) {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			String currentTitle = driver.switchTo().window(handle).getTitle();
			if (currentTitle.equals(windowTitle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}
	
	public void windowFocus() {
		Set<String> handles = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		for (String handle : handles) {
			String currentTitle = driver.switchTo().window(handle).getTitle();
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}
	
	public void returnToMainWindow() {
		driver.switchTo().defaultContent();
	}
	
	public void doErrorValidation() {
        String errors = assertionErrors.toString();
        if(!Strings.isStringEmpty(errors)) {
            errors = errors.replaceAll("The following asserts failed:", "");
            Assert.fail("The following asserts failed: " + errors);
        }
    }
	
	public  static void addAssertionError(String msg) {
        if(assertionErrors.indexOf(msg) == -1) {
        	assertionErrors.append(msg);
        }
    }
}
/**
 * Further reading: 
 * 1. Selenium webdriver page object: 
 * 		http://stackoverflow.com/questions/10315894/selenium-webdriver-page-object
 * 2. Using Page Objects with Selenium and Web Driver 2.0
 * 		http://www.summa-tech.com/blog/2011/10/10/using-page-objects-with-selenium-and-web-driver-20/
 * 3. PageFactory
 * 		http://code.google.com/p/selenium/wiki/PageFactory
 */