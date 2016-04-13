package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.page.ListViewPage;
import com.zywee.base.test.TestBase;
import com.zywee.pages.ZyweeHomePage;


public class TestZyweeHomePage extends TestBase {

	private WebDriver driver;
	ZyweeHomePage zyweeHome;
	
	@BeforeMethod
	public void setUp() throws Exception {
		init();
		driver = super.driver;
		zyweeHome = new ZyweeHomePage(driver);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testHomePage() {
		zyweeHome.open();
		zyweeHome.validatePage();
		zyweeHome.validateMenu();
		zyweeHome.doErrorValidation();
		//zyweeHome.validateSearch();
		//buzzHome.verifyPageLinks();
	}
	
	@Test
	public void testSearchHospitals(){
		zyweeHome.open();
		ListViewPage hospitals = zyweeHome.clickSearchHospitals();
		hospitals.validatePage();
		hospitals.validateAll();
		hospitals.doErrorValidation();
	}
	
	@Test
	public void testSearchDiagnostics(){
		zyweeHome.open();
		ListViewPage diagnostics = zyweeHome.clickSearchDiagnostics();
		diagnostics.validatePage();
		diagnostics.validateAll();
		diagnostics.doErrorValidation();
	}
	
	@Test
	public void testSearchClinics(){
		zyweeHome.open();
		ListViewPage clinics = zyweeHome.clickSearchClinics();
		clinics.validatePage();
		clinics.validateAll();
		clinics.doErrorValidation();
	}
	
	@Test
	public void testSearchPackages(){
		zyweeHome.open();
		ListViewPage packages = zyweeHome.clickSearchPackages();
		packages.validatePage();
		packages.validateAll();
		packages.doErrorValidation();
	}
	
	@Test
	public void testSearchDoctors(){
		zyweeHome.open();
		ListViewPage doctors = zyweeHome.clickSearchDoctors();
		doctors.validatePage();
		doctors.validateAll();
		doctors.doErrorValidation();
	}
	
	@Test
	public void testSearchTests(){
		zyweeHome.open();
		ListViewPage tests = zyweeHome.clickSearchTests();
		tests.validatePage();
		tests.validateAll();
		tests.doErrorValidation();
	}
}
