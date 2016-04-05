package com.zywee.pages;

import org.openqa.selenium.WebDriver;

public class ListViewHospitals extends ListViewPage {

	public ListViewHospitals(WebDriver driver) {
		super(driver);
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
            assertionErrors.append(er.getMessage());
        }
	}
}
