package com.zywee.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zywee.base.page.ListViewPage;
import com.zywee.leftnav.LeftNavPage;

public class ListViewDiagnostics extends ListViewPage {
	
	public ListViewDiagnostics(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ListViewDiagnostics(WebDriver driver,int diagnosticNum) {
		super(driver, diagnosticNum);
	}
	
	@Override
	protected String getBlockString() {
		return "div:nth-child(1)";
	}

	@Override
	protected void validatePageHeaders() {
		softAssert.assertTrue(getText(resultTitle).trim().contains("Diagnostics"),"Title does not contain Diagnostics");
		softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Diagnostics"),"Bread crumb does not end with Diagnostics");
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
		/*
		DiagnosticFacilityPage sp = new DiagnosticFacilityPage(driver);
		sp.getCheckboxes();
		sp.selectCheckboxes("C T Scan");*/
		
		LeftNavPage leftNav = new LeftNavPage(driver);
		leftNav = leftNav.getDiagnosticLeftNav();
		leftNav.selectFacility("C T Scan");
	}
	
	@Override
	protected String getEntityName() {
		return hospBlock + "div:nth-child(1) > div > div.col-md-5 > div > div.col-xs-9.Header1.top_margin";
	}
	
	@Override
	public List<ListViewPage> getResultList() {
		List<ListViewPage> listViewHospitals = new ArrayList();
		numItems = driver.findElements(By.cssSelector(items)).size();
		for(int i=1;i<=numItems;i++) {
			ListViewPage hosp = new ListViewDiagnostics(driver, i);
			listViewHospitals.add(hosp);
		}
		return listViewHospitals;
	}
}
