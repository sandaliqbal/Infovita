package com.zywee.base.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ChargeBase extends PageBase {

	public ChargeBase(WebDriver driver) {
		super(driver);
		setChargeHeading("Charges");
	}

	private WebElement title = getChargeTitle();
	private WebElement collapseButton = getCollapseButton();
	private WebElement chargeType = getChargeType();
	private String chargeHeading = getChargeHeading();
	private WebElement slider = getSlider();
	private WebElement amount = getAmount();
	private String chargeTypeText = getChargeTypeText();
	
	protected void validate() {
		softAssert.assertTrue(title.isDisplayed(),"Title should be displayed");
		softAssert.assertTrue(title.getText().trim().contains(chargeHeading),
				"Title should contain " + chargeHeading);
		softAssert.assertTrue(chargeType.isDisplayed(),"Type of charge should be displayed");
		softAssert.assertTrue(chargeType.getText().contains(chargeTypeText),"Title of charge type should be displayed");
		softAssert.assertTrue(collapseButton.isDisplayed(),"Expand/Collapse should be displayed");
		softAssert.assertTrue(amount.isDisplayed(),"Charge amount should be displayed");
		softAssert.assertTrue(slider.isDisplayed(),"Slider should be displayed");
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
			addAssertionError(er.getMessage());
		}
	}
	
	public abstract WebElement getChargeTitle();
	public abstract WebElement getCollapseButton();
	public abstract WebElement getChargeType();
	public abstract String getChargeTypeText();
	public abstract WebElement getSlider();
	public abstract WebElement getAmount();
	
	public String getChargeHeading() {
		return chargeHeading;
	}
	
	public void setChargeHeading(String heading) {
		chargeHeading = heading;
	}
	
	public void setChargeTypeText(String text) {
		chargeTypeText = text;
	}
}
