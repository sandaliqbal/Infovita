package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.test.TestBase;
import com.zywee.pages.ListViewPage;
import com.zywee.pages.ZyweeHomePage;


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
		ListViewPage hospitals = zyweeHome.clickSearchHospitals();
		hospitals.validatePage();
		hospitals.doErrorValidation();
	}
	
	@Test
	public void testSearchDiagnostics(){
		ZyweeHomePage zyweeHome = new ZyweeHomePage(driver);
		zyweeHome.open();
		ListViewPage diagnostics = zyweeHome.clickSearchDiagnostics();
		diagnostics.validatePage();
		diagnostics.doErrorValidation();
	}
	
	@Test
	public void testSearchClinics(){
		ZyweeHomePage zyweeHome = new ZyweeHomePage(driver);
		zyweeHome.open();
		ListViewPage clinics = zyweeHome.clickSearchClinics();
		clinics.validatePage();
		clinics.doErrorValidation();
	}
	
	@Test
	public void testSearchPackages(){
		ZyweeHomePage zyweeHome = new ZyweeHomePage(driver);
		zyweeHome.open();
		ListViewPage packages = zyweeHome.clickSearchPackages();
		packages.validatePage();
		packages.validateAll();
		packages.doErrorValidation();
	}
	
	@Test
	public void testSearchDoctors(){
		ZyweeHomePage zyweeHome = new ZyweeHomePage(driver);
		zyweeHome.open();
		ListViewPage doctors = zyweeHome.clickSearchDoctors();
		doctors.validatePage();
		doctors.validateAll();
		doctors.doErrorValidation();
	}
	
	@Test
	public void testSearchTests(){
		ZyweeHomePage zyweeHome = new ZyweeHomePage(driver);
		zyweeHome.open();
		ListViewPage tests = zyweeHome.clickSearchTests();
		tests.validatePage();
		tests.validateAll();
		tests.doErrorValidation();
	}
}
