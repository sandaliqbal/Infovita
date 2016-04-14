package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.test.TestBase;
import com.zywee.leftnav.LeftNavPage;
import com.zywee.pages.AppointmentPage;
import com.zywee.pages.HospitalsDetailPage;
import com.zywee.pages.ListViewClinics;

public class TestClinicsPage extends TestBase {

	private WebDriver driver;
	private ListViewClinics clinics;

	@BeforeMethod
	public void setUp() throws Exception {
		init();
		driver = super.driver;
		clinics = new ListViewClinics(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testClinicsDetailPage() {
		clinics.open();
		HospitalsDetailPage hospDetailPage = clinics.clickClinicName();
		clinics.open();
		hospDetailPage = clinics.clickViewMoreInfo();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testClinicsAppointmentPage() {
		clinics.open();
		AppointmentPage appointPage = clinics.clickBookAppointment();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testExpandCollapseLeftNav() {
		clinics.open();
		LeftNavPage leftNav = clinics.getLeftNav();
		leftNav.collapseLeftNav();
		leftNav.collapseLeftNav();
		clinics.doErrorValidation();
	}
	
	@Test
	public void testLeftNavCategories() {
		clinics.open();
		LeftNavPage leftNav = clinics.getLeftNav();
		leftNav.selectFacility("Ambulance Service");
		leftNav.selectFacility("Ambulance Service");
		leftNav.selectFacility("Fully Automatic Dental Chairs");
		leftNav.selectFacility("Fully Automatic Dental Chairs");
		leftNav.selectFacility("Pharmacy");
		leftNav.selectFacility("Pharmacy");
		clinics.doErrorValidation();
	}
	
	@Test
	public void testSortDropdown() {
		clinics.open();
		clinics.sortByNameAsc();
		clinics.sortByOrder();
		clinics.sortByRating();
		clinics.doErrorValidation();
	}

}
