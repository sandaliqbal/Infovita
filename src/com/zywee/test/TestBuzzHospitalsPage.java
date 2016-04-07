package com.zywee.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.zywee.base.page.ListViewPage;
import com.zywee.base.test.TestBase;
import com.zywee.leftnav.LeftNavPage;
import com.zywee.pages.AppointmentPage;
import com.zywee.pages.ListViewHospitals;
import com.zywee.pages.HospitalsDetailPage;
import com.zywee.tools.WaitTool;


public class TestBuzzHospitalsPage extends TestBase {

	private static WebDriver driver;
	private static ListViewHospitals hospitals;

	@Before
	public void setUp() throws Exception {
		init();
		driver = super.driver;
		hospitals = new ListViewHospitals(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testHospitalsPage() {
		hospitals.open();
		WaitTool.waitForPageLoad(driver);
		checkJSErrors();
		hospitals.validatePage();
		//hospitals.clickAndVerifyGridView();
	}
	
	@Test
	public void testHospitalsDetailPage() {
		hospitals.open();
		WaitTool.waitForPageLoad(driver);
		HospitalsDetailPage hospDetailPage = hospitals.gotoDetailPage();
		hospDetailPage.validatePage();
	}
	
	@Test
	public void testExpandCollapseLeftNav() {
		hospitals.open();
		WaitTool.waitForPageLoad(driver);
		LeftNavPage.clickExpandCollapse();
		LeftNavPage.selectMultiSpeciality();
	}
	
	@Test
	public void testLeftNavCategories() {
		hospitals.open();
		WaitTool.waitForPageLoad(driver);
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
		WaitTool.waitForPageLoad(driver);
		hospitals.sortOnCost();
		hospitals.sortOnNameAsc();
		hospitals.sortOnNameDesc();
		hospitals.sortOnRating();
	}
	
	@Test
	public void testAppointmentPage() {
		hospitals.open();
		WaitTool.waitForPageLoad(driver);
		ListViewPage listView = new ListViewPage(driver);
		AppointmentPage apptPage = listView.bookAppointment(0);
		apptPage.validatePage();
	}

}
