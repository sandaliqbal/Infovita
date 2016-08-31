package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.page.ListViewPage;
import com.zywee.base.test.TestBase;
import com.zywee.pages.ZyweeHomePage;



@Test
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
	
	public void testHomePage() {
		zyweeHome.open();
		zyweeHome.validatePage();
		zyweeHome.validateMenu();
		zyweeHome.doErrorValidation();
		//zyweeHome.validateSearch();
		//buzzHome.verifyPageLinks();
	}
	
	public void testSearchHospitals(){
		zyweeHome.open();
		ListViewPage hospitals = zyweeHome.clickSearchHospitals();
		hospitals.validatePage();
		hospitals.validateAll();
		hospitals.doErrorValidation();
	}
	
	public void testSearchDiagnostics(){
		zyweeHome.open();
		ListViewPage diagnostics = zyweeHome.clickSearchDiagnostics();
		diagnostics.validatePage();
		diagnostics.validateAll();
		diagnostics.doErrorValidation();
	}
	
	public void testSearchClinics(){
		zyweeHome.open();
		ListViewPage clinics = zyweeHome.clickSearchClinics();
		clinics.validatePage();
		clinics.validateAll();
		clinics.doErrorValidation();
	}
	
	public void testSearchPackages(){
		zyweeHome.open();
		ListViewPage packages = zyweeHome.clickSearchPackages();
		packages.validatePage();
		packages.validateAll();
		packages.doErrorValidation();
	}
	
	public void testSearchDoctors(){
		zyweeHome.open();
		ListViewPage doctors = zyweeHome.clickSearchDoctors();
		doctors.validatePage();
		doctors.validateAll();
		doctors.doErrorValidation();
	}
	
	public void testSearchTests(){
		zyweeHome.open();
		ListViewPage tests = zyweeHome.clickSearchTests();
		tests.validatePage();
		tests.validateAll();
		tests.doErrorValidation();
	}
	

	public void testSearchTransport(){
		zyweeHome.open();
		ListViewPage transport = zyweeHome.clickSearchTransport();
		transport.validatePage();
		transport.validateAll();
		transport.doErrorValidation();
	}
//TODO//	
//	public void testSearchEquipments(){
//		zyweeHome.open();
//		ListViewPage equipments = zyweeHome.clickSearchEquipments();
//		equipments.validatePage();
//		equipments.validateAll();
//		equipments.doErrorValidation();
//	}
	
//	@Test
//	public void testSearchHomeServices(){
//		zyweeHome.open();
//		ListViewPage homeServices = zyweeHome.clickSearchHomeServices();
//		homeServices.validatePage();
//		homeServices.validateAll();
//		homeServices.doErrorValidation();
//	}
}

