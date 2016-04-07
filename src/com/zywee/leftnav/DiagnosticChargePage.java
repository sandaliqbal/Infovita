package com.zywee.leftnav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.base.page.ChargeBase;

public class DiagnosticChargePage extends ChargeBase {

	public DiagnosticChargePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebElement getChargeTitle() {
		return driver.findElement(By.cssSelector("#sidebar > div:nth-child(1) > div.panel-heading.panel_head > span"));
	}

	@Override
	public WebElement getCollapseButton() {
		return driver.findElement(By.cssSelector("#sidebar > div:nth-child(1) > div.panel-heading.panel_head"));
	}

	@Override
	public WebElement getChargeType() {
		return driver.findElement(By.cssSelector("#sidebar > div:nth-child(1) > div.panel-body.aa > div > div.panel_head1"));
	}

	@Override
	public String getChargeTypeText() {
		return "Centre Charges";
	}
	
	@Override
	public WebElement getSlider() {
		return driver.findElement(By.cssSelector("#slider-range1 > div"));
	}
	
	@Override
	public WebElement getAmount() {
		return driver.findElement(By.cssSelector("#amount1"));
	}
	
	@Override
	protected void validate() {
		super.validate();
		softAssert.assertTrue(getChargeType().getText().trim().contains(getChargeTypeText())
				,getChargeTypeText() + " not found");
		softAssert.assertTrue(getAmount().getText().trim().contains("100 - 30000")
				,"Amount should be in range 100 - 30000");
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
			addAssertionError(er.getMessage());
		}
	}

}
