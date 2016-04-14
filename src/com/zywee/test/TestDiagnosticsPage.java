package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.test.TestBase;
import com.zywee.leftnav.LeftNavPage;
import com.zywee.pages.AppointmentPage;
import com.zywee.pages.HospitalsDetailPage;
import com.zywee.pages.ListViewDiagnostics;

public class TestDiagnosticsPage extends TestBase {
	
	private WebDriver driver;
	private ListViewDiagnostics diagnostics;

	@BeforeMethod
	public void setUp() throws Exception {
		init();
		driver = super.driver;
		diagnostics = new ListViewDiagnostics(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testDiagnosticsDetailPage() {
		diagnostics.open();
		HospitalsDetailPage hospDetailPage = diagnostics.clickDiagnosticName();
		diagnostics.open();
		hospDetailPage = diagnostics.clickViewMoreInfo();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testDiagnosticsAppointmentPage() {
		diagnostics.open();
		AppointmentPage appointPage = diagnostics.clickBookAppointment();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testExpandCollapseLeftNav() {
		diagnostics.open();
		LeftNavPage leftNav = diagnostics.getLeftNav();
		leftNav.collapseLeftNav();
		leftNav.collapseLeftNav();
		diagnostics.doErrorValidation();
	}
	
	@Test
	public void testLeftNavCategories() {
		diagnostics.open();
		LeftNavPage leftNav = diagnostics.getLeftNav();
		leftNav.selectFacility("Bone Denistometry");
		leftNav.selectFacility("Bone Denistometry");
		leftNav.selectFacility("Mammography");
		leftNav.selectFacility("Mammography");
		leftNav.selectFacility("X-Ray");
		leftNav.selectFacility("X-Ray");
		diagnostics.doErrorValidation();
	}
	
	@Test
	public void testSortDropdown() {
		diagnostics.open();
		diagnostics.sortByNameAsc();
		diagnostics.sortByOrder();
		diagnostics.sortByRating();
		diagnostics.doErrorValidation();
	}

}
