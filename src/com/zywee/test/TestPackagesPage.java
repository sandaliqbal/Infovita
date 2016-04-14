package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.test.TestBase;
import com.zywee.leftnav.LeftNavPage;
import com.zywee.pages.AppointmentPage;
import com.zywee.pages.HospitalsDetailPage;
import com.zywee.pages.ListViewPackages;

public class TestPackagesPage extends TestBase {
	
	private WebDriver driver;
	private ListViewPackages packages;

	@BeforeMethod
	public void setUp() throws Exception {
		init();
		driver = super.driver;
		packages = new ListViewPackages(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testPackageDetailPage() {
		packages.open();
		HospitalsDetailPage hospDetailPage = packages.clickPackageName();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testPackageAppointmentPage() {
		packages.open();
		AppointmentPage appointPage = packages.clickBookAppointment();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testExpandCollapseLeftNav() {
		packages.open();
		LeftNavPage leftNav = packages.getLeftNav();
		leftNav.collapseLeftNav();
		leftNav.collapseLeftNav();
		packages.doErrorValidation();
	}
	
	@Test
	public void testLeftNavCategories() {
		packages.open();
		LeftNavPage leftNav = packages.getLeftNav();
		leftNav.selectCenterType("Hospitals");
		leftNav.selectCenterType("Hospitals");
		leftNav.selectCenterType("Diagnostics Centres");
		leftNav.selectCenterType("Diagnostics Centres");
		leftNav.selectCenterType("Clinics");
		leftNav.selectCenterType("Clinics");
		packages.doErrorValidation();
	}
	
	@Test
	public void testSortDropdown() {
		packages.open();
		packages.sortByNameAsc();
		packages.sortByOrder();
		packages.sortByRating();
		packages.doErrorValidation();
	}
}
