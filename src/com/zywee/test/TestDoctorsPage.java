package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.test.TestBase;
import com.zywee.leftnav.LeftNavPage;
import com.zywee.pages.AppointmentPage;
import com.zywee.pages.HospitalsDetailPage;
import com.zywee.pages.ListViewDoctors;

public class TestDoctorsPage extends TestBase {

	private WebDriver driver;
	private ListViewDoctors doctors;

	@BeforeMethod
	public void setUp() throws Exception {
		init();
		driver = super.driver;
		doctors = new ListViewDoctors(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testDoctorDetailPage() {
		doctors.open();
		HospitalsDetailPage hospDetailPage = doctors.clickDoctorName();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testDoctorAppointmentPage() {
		doctors.open();
		AppointmentPage appointPage = doctors.clickBookAppointment();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testExpandCollapseLeftNav() {
		doctors.open();
		LeftNavPage leftNav = doctors.getLeftNav();
		leftNav.collapseLeftNav();
		leftNav.collapseLeftNav();
		doctors.doErrorValidation();
	}
	
	@Test
	public void testLeftNavCategories() {
		doctors.open();
		LeftNavPage leftNav = doctors.getLeftNav();
		leftNav.selectCenterType("Hospitals");
		leftNav.selectCenterType("Hospitals");
		leftNav.selectCenterType("Diagnostics Center");
		leftNav.selectCenterType("Diagnostics Center");
		leftNav.selectCenterType("Clinics");
		leftNav.selectCenterType("Clinics");
		doctors.doErrorValidation();
	}
	
	@Test
	public void testSortDropdown() {
		doctors.open();
		doctors.sortByNameAsc();
		doctors.sortByOrder();
		doctors.sortByRating();
		doctors.doErrorValidation();
	}
}
