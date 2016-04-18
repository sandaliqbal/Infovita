package com.zywee.base.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class FacilityTab extends PageBase {

	public FacilityTab(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected WebElement facilityList = driver.findElement(By.cssSelector("#accordion"));

}
