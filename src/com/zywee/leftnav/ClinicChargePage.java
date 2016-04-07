package com.zywee.leftnav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClinicChargePage extends DiagnosticChargePage {

	public ClinicChargePage(WebDriver driver) {
		super(driver);
	}
		
	@Override
	public WebElement getSlider() {
		return driver.findElement(By.cssSelector("#slider-range"));
	}
	
	@Override
	public WebElement getAmount() {
		return driver.findElement(By.cssSelector("#amount"));
	}
	
	@Override
	public WebElement getChargeType() {
		return driver.findElement(By.cssSelector("#sidebar > div:nth-child(1) > div.panel-body.aa > div.panel_head1"));
	}
	
	@Override
	public String getChargeTypeText() {
		return "Consultation Fees";
	}
	
	@Override
	protected void validate() {
		super.validate();
		softAssert.assertTrue(getChargeType().getText().trim().contains(getChargeTypeText())
				,getChargeTypeText() + " not found");
		softAssert.assertTrue(getAmount().getText().trim().contains("100 - 1000")
				,"Amount should be in range 100 - 1000");
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
			addAssertionError(er.getMessage());
		}
	}

}
