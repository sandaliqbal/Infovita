package com.zywee.leftnav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.base.page.ChargeBase;

/**
 * Matches with doctor page, tests page
 * @author i309187
 *
 */
public class PackageChargePage extends ChargeBase {

	public PackageChargePage(WebDriver driver) {
		super(driver);
		super.setChargeTypeText("Package Charges");
	}
	
	private String chargeType;

	@Override
	public WebElement getChargeTitle() {
		return driver.findElement(By.cssSelector("#panel-head2 > span"));
	}

	@Override
	public WebElement getCollapseButton() {
		return driver.findElement(By.cssSelector("#panel-head2"));
	}

	@Override
	public WebElement getChargeType() {
		return driver.findElement(By.cssSelector("#panel-body2 > div > div.panel_head1"));
	}

	@Override
	public String getChargeTypeText() {
		return chargeType;
	}
	
	@Override
	public void setChargeTypeText(String text) {
		super.setChargeTypeText(text);
	}

	@Override
	public WebElement getAmount() {
		return driver.findElement(By.cssSelector("#amount1"));
	}
	
	@Override
	public WebElement getSlider() {
		return driver.findElement(By.cssSelector("#slider-range1 > div"));
	}
	
	@Override
	protected void validate() {
		super.validate();
		softAssert.assertTrue(getChargeType().getText().trim().contains(getChargeTypeText())
				,getChargeTypeText() + " not found");
		softAssert.assertTrue(getChargeTitle().getText().trim().contains(getChargeHeading())
				,getChargeHeading() + " not found");
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
			addAssertionError(er.getMessage());
		}
	}

}
