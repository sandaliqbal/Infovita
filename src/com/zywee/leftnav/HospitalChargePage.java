package com.zywee.leftnav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.base.page.ChargeBase;

public class HospitalChargePage extends ChargeBase {

	public HospitalChargePage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement wardCharge = driver.findElement(By.cssSelector("#sidebar > div:nth-child(2) > " +
			"div.panel-body.aa > div.content-left1.charges > div.panel_head1"));
	private WebElement wardChargeAmt = driver.findElement(By.cssSelector("#amount1"));
	private WebElement wardChargeSlider = driver.findElement(By.cssSelector("#slider-range1 > div"));
	
	@Override
	public WebElement getChargeTitle() {
		return driver.findElement(By.cssSelector("#sidebar > div:nth-child(2) > div.panel-heading.panel_head > span > span"));
	}

	@Override
	public WebElement getCollapseButton() {
		return driver.findElement(By.cssSelector("#sidebar > div:nth-child(2) > div.panel-heading.panel_head"));
	}

	@Override
	public WebElement getChargeType() {
		return driver.findElement(By.cssSelector("#sidebar > div:nth-child(2) > div.panel-body.aa > div.panel_head1"));
	}

	@Override
	public String getChargeTypeText() {
		return getChargeType().getText();
	}

	@Override
	public WebElement getSlider() {
		return driver.findElement(By.cssSelector("#slider-range > div"));
	}

	@Override
	public WebElement getAmount() {
		return driver.findElement(By.cssSelector("#amount"));
	}
	
	@Override
	protected void validate() {
		super.validate();
		softAssert.assertTrue(getChargeType().getText().trim().contains(getChargeTypeText())
				,getChargeTypeText() + " not found");
//		softAssert.assertTrue(getAmount().getText().trim().contains("100 - 1000")
//				,"Amount should be in range 100 - 1000");
		softAssert.assertTrue(wardCharge.getText().trim().contains("Ward Charges")
				,"Ward Charges not found");
//		softAssert.assertTrue(wardChargeAmt.getText().trim().contains("100 - 10000")
//				,"Amount for ward charge should be in range 100 - 10000");
		softAssert.assertTrue(wardChargeSlider.isDisplayed(),"slider for ward charge not found");
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
			addAssertionError(er.getMessage());
		}
	}

}
