package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zywee.base.test.TestBase;
import com.zywee.pages.ZyweeHomePage;
import com.zywee.pages.HospitalsPage;




public class TestZyweeHomePage extends TestBase {

	private static WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		init();
		driver = super.driver;
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testHomePage() {
		ZyweeHomePage zyweeHome = new ZyweeHomePage(driver);
		zyweeHome.open();
		zyweeHome.validatePage();
		zyweeHome.validateMenu();
		zyweeHome.doErrorValidation();
		//zyweeHome.validateSearch();
		//buzzHome.verifyPageLinks();
	}
	
	@Test
	public void testSearchHospitals(){
		ZyweeHomePage zyweeHome = new ZyweeHomePage(driver);
		zyweeHome.open();
		HospitalsPage hospitals = zyweeHome.clickSearchHospitals();
		hospitals.validatePage();
		hospitals.doErrorValidation();
	}
}
