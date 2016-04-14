package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.test.TestBase;
import com.zywee.leftnav.LeftNavPage;
import com.zywee.pages.AppointmentPage;
import com.zywee.pages.HospitalsDetailPage;
import com.zywee.pages.ListViewTests;

public class TestTestsPage extends TestBase {
	
	private WebDriver driver;
	private ListViewTests tests;

	@BeforeMethod
	public void setUp() throws Exception {
		init();
		driver = super.driver;
		tests = new ListViewTests(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testTestDetailPage() {
		tests.open();
		HospitalsDetailPage hospDetailPage = tests.clickTestName();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testAppointmentPage() {
		tests.open();
		AppointmentPage appointPage = tests.clickBookAppointment();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testExpandCollapseLeftNav() {
		tests.open();
		LeftNavPage leftNav = tests.getLeftNav();
		leftNav.collapseLeftNav();
		leftNav.collapseLeftNav();
		tests.doErrorValidation();
	}
	
	@Test
	public void testSortDropdown() {
		tests.open();
		tests.sortByNameAsc();
		tests.sortByOrder();
		tests.sortByRating();
		tests.doErrorValidation();
	}

}
