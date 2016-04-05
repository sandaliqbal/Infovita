package com.zywee.pages;

import org.openqa.selenium.WebDriver;

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
            assertionErrors.append(er.getMessage());
        }
	}
	
	@Override
	protected String getEntityName() {
		return hospBlock + "div:nth-child(1) > div > div.col-md-5 > div > div.col-xs-9.Header1.top_margin";
	}
}
