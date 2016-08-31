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
import com.zywee.pages.ServiceProviderDetailPage;
import com.zywee.pages.ListViewTransports;

public class TestTransportsPage extends TestBase {
	private WebDriver driver;
	private ListViewTransports transport;

	@BeforeMethod
	public void setUp() throws Exception {
		init();
		driver = super.driver;
		transport= new ListViewTransports(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
	driver.close();
	driver.quit();
	}

	@Test
	public void testTransportsDetailPage() {
	transport.open();
	ServiceProviderDetailPage serviceDetailPage = transport.clickTransportName();
	}
	
	@Test
	public void testTransportAppointmentPage() {
	transport.open();
	AppointmentPage appointPage = transport.clickBookAppointment();
	//hospDetailPage.validatePage();
}
	@Test
	public void testExpandCollapseLeftNav() {
		transport.open();
		LeftNavPage leftNav = transport.getLeftNav();
		leftNav.collapseLeftNav();
		leftNav.collapseLeftNav();
		transport.doErrorValidation();
	}
	@Test
	public void testLeftNavCategories() {
		transport.open();
		LeftNavPage leftNav = transport.getLeftNav();
		leftNav.selectTransportAccessories("Freezer Normal");
		leftNav.selectTransportAccessories("Freezer Normal");
		leftNav.selectTransportAccessories("Freezer VIP");
		leftNav.selectTransportAccessories("Freezer VIP");
		leftNav.selectTransportAccessories("Freezer VVIP");
		leftNav.selectTransportAccessories("Freezer VVIP");
		leftNav.selectTransportAccessories("NICU");
		leftNav.selectTransportAccessories("NICU");
		leftNav.selectTransportAccessories("Oxygen");
		leftNav.selectTransportAccessories("Oxygen");
		leftNav.selectTransportAccessories("Ventilator");
		leftNav.selectTransportAccessories("Ventilator");
		leftNav.selectTransportAccessories("Wheelchair");
		leftNav.selectTransportAccessories("Wheelchair");
		
		
		leftNav.selectTransportDistance("Full Day");
		leftNav.selectTransportDistance("Full Day");
		leftNav.selectTransportDistance("Half Day");
		leftNav.selectTransportDistance("Half Day");
		leftNav.selectTransportDistance("Rs/Km");
		leftNav.selectTransportDistance("Rs/Km");
		transport.doErrorValidation();
	}

	@Test
	public void testSortDropdown() {
		transport.open();
		//transport.sortByRating();
		transport.doErrorValidation();
	}
}

