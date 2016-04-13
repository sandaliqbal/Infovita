package com.zywee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zywee.base.page.ListViewPage;
import com.zywee.base.page.SpecialityBase;
import com.zywee.leftnav.FacilityPage;
import com.zywee.leftnav.HospitalChargePage;
import com.zywee.leftnav.LeftNavPage;
import com.zywee.leftnav.SpecialityPage;

public class ListViewHospitals extends ListViewPage {

	public ListViewHospitals(WebDriver driver) {
		super(driver);
		URL = URL + "/bangalore/hospitals";
		// TODO Auto-generated constructor stub
	}
	
	public ListViewHospitals(WebDriver driver,int hospNum) {
		super(driver, hospNum);
	}

	@Override
	protected void validatePageHeaders() {
		softAssert.assertTrue(getText(resultTitle).trim().contains("Hospitals"),"Title does not contain Hospitals");
		softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Hospitals"),"Bread crumb does not end with Hospitals");
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
        	addAssertionError(er.getMessage());
        }
	}
	
	@Override
	public void validatePage() {
		super.validatePage();
		softAssert.assertTrue(isElementPresent(hospImage),"Hospital Image not found");
		softAssert.assertTrue(isElementPresent(hospName),"Hospital Name not found");
		String hospname = null;
		try {
			hospname = getText(hospName);
		} catch (Exception ex) {
			addAssertionError(ex.getMessage());
		}
		softAssert.assertTrue(isElementPresent(category),"Hospital category not found for " + hospname);
		softAssert.assertTrue(isElementPresent(location),"Hospital location not found for " + hospname);
		softAssert.assertTrue(isElementPresent(rating),"Hospital rating not found for " + hospname);
		softAssert.assertTrue(isElementPresent(consultFee),"Consultation fee not found for " + hospname);
		softAssert.assertTrue(isElementPresent(wardCharge),"Ward charge not found for " + hospname);
		softAssert.assertTrue(isElementPresent(contact),"Contact number not found for " + hospname);
		softAssert.assertTrue(isElementPresent(facility),"Facilities not found for " + hospname);
		softAssert.assertTrue(isElementPresent(viewMoreInfo),"View More Info link not found for " + hospname);
		softAssert.assertTrue(isElementPresent(bookNowButton),"Book Appointment button not found for " + hospname);
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
			addAssertionError(er.getMessage());
		}
		/*FacilityPage sp = new FacilityPage(driver);
		sp.getCheckboxes();
		sp.selectCheckboxes("MRI");*/
		LeftNavPage leftNav = new LeftNavPage(driver);
		leftNav = leftNav.getHospitalLeftNav();
		leftNav.selectSpeciality("Super Speciality");
	}
	
	public HospitalsDetailPage clickHospitalName() {
		driver.findElement(By.cssSelector(hospName)).click();
		return new HospitalsDetailPage(driver);
	}
	
	public HospitalsDetailPage clickViewMoreInfo() {
		driver.findElement(By.cssSelector(viewMoreInfo)).click();
		return new HospitalsDetailPage(driver);
	}
	
	public AppointmentPage clickBookAppointment() {
		driver.findElement(By.cssSelector(bookNowButton)).click();
		return new AppointmentPage(driver);
	}
	
	public LeftNavPage getLeftNav() {
		LeftNavPage leftNav = new LeftNavPage(driver);
		return leftNav.getHospitalLeftNav();
	}
}
