package com.zywee.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zywee.base.page.ListViewPage;
import com.zywee.leftnav.LeftNavPage;

public class ListViewClinics extends ListViewPage {

	public ListViewClinics(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ListViewClinics(WebDriver driver,int clinicNum) {
		super(driver, clinicNum);
	}
	
	@Override
	protected String getBlockString() {
		return "div:nth-child(1)";
	}

	@Override
	protected void validatePageHeaders() {
		softAssert.assertTrue(getText(resultTitle).trim().contains("Clinics"),"Title does not contain Clinics");
		softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Clinics"),"Bread crumb does not end with Clinics");
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
		/*DiagnosticFacilityPage sp = new DiagnosticFacilityPage(driver);
		sp.getCheckboxes();
		sp.selectCheckboxes("Hearing Aid Servicing");*/
		
		LeftNavPage leftNav = new LeftNavPage(driver);
		leftNav = leftNav.getClinicLeftNav();
		leftNav.selectFacility("Hearing Aid Servicing");
		leftNav.collapseLeftNav();
	}
	
	@Override
	protected String getEntityName() {
		return hospBlock + "div:nth-child(1) > div > div.col-md-5 > div > div.col-xs-9 > h5";
	}
	
	@Override
	protected String getCategory() {
		return hospBlock + "div:nth-child(1) > div > div.col-md-7 > div > div:nth-child(1) > h5";
	}
	
	@Override
	protected String getLocation() {
		return hospBlock + "div:nth-child(1) > div > div.col-md-7 > div > div.col-xs-4.text-center.wordwrap_1 > h5";
	}
	
	@Override
	protected String getRating() {
		return hospBlock + "div:nth-child(1) > div > div.col-md-7 > div > div.col-xs-4.pad1 > div > img:nth-child(2)";
	}

	@Override
	public List<ListViewPage> getResultList() {
		List<ListViewPage> listViewHospitals = new ArrayList();
		numItems = driver.findElements(items).size();
		for(int i=1;i<=numItems;i++) {
			ListViewPage hosp = new ListViewClinics(driver, i);
			listViewHospitals.add(hosp);
		}
		return listViewHospitals;
	}
}
