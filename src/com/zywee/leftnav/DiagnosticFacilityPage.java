package com.zywee.leftnav;

import org.openqa.selenium.WebDriver;

public class DiagnosticFacilityPage extends FacilityPage {

	public DiagnosticFacilityPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	protected String getChildBlock() {
		return "div:nth-child(2)";
	}

}
