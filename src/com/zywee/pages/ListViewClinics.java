package com.zywee.pages;

import org.openqa.selenium.WebDriver;

public class ListViewClinics extends ListViewPage {

	public ListViewClinics(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ListViewClinics(WebDriver driver,int diagnosticNum) {
		super(driver, diagnosticNum);
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
            assertionErrors.append(er.getMessage());
        }
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

}
