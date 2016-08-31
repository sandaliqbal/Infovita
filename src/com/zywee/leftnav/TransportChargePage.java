package com.zywee.leftnav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.base.page.ChargeBase;

public class TransportChargePage  extends ChargeBase{
	public TransportChargePage(WebDriver driver) {
		super(driver);
}
	@Override
	public WebElement getSlider() {
		return driver.findElement(By.cssSelector("#slider-range1"));
	}
	
	@Override
	public WebElement getAmount() {
		return driver.findElement(By.cssSelector("#amount1"));
	}
	
	@Override
	public WebElement getChargeType() {
		return driver.findElement(By.cssSelector("#panel-body2 > div > div.panel_head1"));
	}
	
	@Override
	public String getChargeTypeText() {
		return "Transport Charges";
	}
	
	@Override
	protected void validate() {
		super.validate();
		softAssert.assertTrue(getChargeType().getText().trim().contains(getChargeTypeText())
				,getChargeTypeText() + " not found");
		softAssert.assertTrue(getAmount().getText().trim().contains("1000 - 50000")
				,"Amount should be in range 1000 - 50000");
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
			addAssertionError(er.getMessage());
		}
	}
	@Override
	public WebElement getChargeTitle() {
		return driver.findElement(By.cssSelector("#panel-head2"));
	}
			
	@Override
	public WebElement getCollapseButton() {
		return driver.findElement(By.cssSelector("#panel-head2"));
		
	}

}
	
