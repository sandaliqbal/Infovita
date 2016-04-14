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
		URL = URL + "/bangalore/diagnostics-centres";
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
		softAssert.assertTrue(isElementPresent(hospImage),"Diagnostic Image not found");
		softAssert.assertTrue(isElementPresent(hospName),"Diagnostic Name not found");
		String hospname = null;
		try {
			hospname = getText(hospName);
		} catch (Exception ex) {
			addAssertionError(ex.getMessage());
		}
		softAssert.assertTrue(isElementPresent(category),"Diagnostic category not found for " + hospname);
		softAssert.assertTrue(isElementPresent(location),"Diagnostic location not found for " + hospname);
		softAssert.assertTrue(isElementPresent(rating),"Diagnostic rating not found for " + hospname);
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
	}
	
	@Override
	protected String getEntityName() {
		return hospBlock + "div:nth-child(1) > div > div.col-md-5 > div > div.col-xs-9.Header1.top_margin";
	}
	
	@Override
	public List<ListViewPage> getResultList() {
		List<ListViewPage> listViewHospitals = new ArrayList();
		numItems = driver.findElements(items).size();
		for(int i=1;i<=numItems;i++) {
			ListViewPage hosp = new ListViewDiagnostics(driver, i);
			listViewHospitals.add(hosp);
		}
		return listViewHospitals;
	}
	
	public LeftNavPage getLeftNav() {
		LeftNavPage leftNav = new LeftNavPage(driver);
		return leftNav.getDiagnosticLeftNav();
	}
	
	public HospitalsDetailPage clickDiagnosticName() {
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
}
