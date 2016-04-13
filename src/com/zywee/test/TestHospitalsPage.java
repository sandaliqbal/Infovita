package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.page.ListViewPage;
import com.zywee.base.test.TestBase;
import com.zywee.leftnav.LeftNavPage;
import com.zywee.pages.AppointmentPage;
import com.zywee.pages.ListViewHospitals;
import com.zywee.pages.HospitalsDetailPage;
import com.zywee.tools.WaitTool;


public class TestHospitalsPage extends TestBase {

	private WebDriver driver;
	private ListViewHospitals hospitals;

	@BeforeMethod
	public void setUp() throws Exception {
		init();
		driver = super.driver;
		hospitals = new ListViewHospitals(driver);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testHospitalsDetailPage() {
		hospitals.open();
		HospitalsDetailPage hospDetailPage = hospitals.clickHospitalName();
		hospitals.open();
		hospDetailPage = hospitals.clickViewMoreInfo();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testHospitalsAppointmentPage() {
		hospitals.open();
		AppointmentPage hospDetailPage = hospitals.clickBookAppointment();
		//hospDetailPage.validatePage();
	}
	
	@Test
	public void testExpandCollapseLeftNav() {
		hospitals.open();
		LeftNavPage leftNav = hospitals.getLeftNav();
		leftNav.collapseLeftNav();
		leftNav.collapseLeftNav();
		hospitals.doErrorValidation();
	}
	
	
	public void testLeftNavCategories() {
		hospitals.open();
		LeftNavPage.selectMultiSpeciality();
		LeftNavPage.unselectMultiSpeciality();
		LeftNavPage.selectSuperSpeciality();
		LeftNavPage.unselectSuperSpeciality();
		LeftNavPage.selectGeneral();
		LeftNavPage.unselectGeneral();
		LeftNavPage.selectAmbulance();
		LeftNavPage.unselectAmbulance();
		LeftNavPage.selectLab();
		LeftNavPage.unselectLab();
		LeftNavPage.selectPharmacy();
		LeftNavPage.unselectPharmacy();
		LeftNavPage.selectBloodBank();
		LeftNavPage.unselectBloodBank();
		LeftNavPage.selectICU();
		LeftNavPage.unselectICU();
		LeftNavPage.selectOperationTheatre();
		LeftNavPage.unselectOperationTheatre();
		LeftNavPage.selectEyeBank();
		LeftNavPage.unselectEyeBank();
		LeftNavPage.selectATM();
		LeftNavPage.unselectATM();
		LeftNavPage.selectCafeteria();
		LeftNavPage.unselectCafeteria();
		LeftNavPage.selectParking();
		LeftNavPage.unselectParking();
		LeftNavPage.selectCost100To1000();
		LeftNavPage.unselectCost100To1000();
		LeftNavPage.selectCost1001To5000();
		LeftNavPage.unselectCost1001To5000();
		LeftNavPage.selectCancer();
		LeftNavPage.unselectCancer();
		LeftNavPage.selectEyeCare();
		LeftNavPage.unselectEyeCare();
		LeftNavPage.selectMaternity();
		LeftNavPage.unselectMaternity();
		LeftNavPage.selectCardiac();
		LeftNavPage.unselectCardiac();
		LeftNavPage.selectOrtho();
		LeftNavPage.unselectOrtho();
	}
	
	@Test
	public void testSortDropdown() {
		hospitals.open();
		hospitals.sortByNameAsc();
		hospitals.sortByOrder();
		hospitals.sortByRating();
		hospitals.doErrorValidation();
	}
	
	
	public void testAppointmentPage() {
		hospitals.open();
		WaitTool.waitForPageLoad(driver);
		ListViewPage listView = new ListViewPage(driver);
		AppointmentPage apptPage = listView.bookAppointment(0);
		apptPage.validatePage();
	}

}
