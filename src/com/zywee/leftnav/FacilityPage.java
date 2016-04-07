package com.zywee.leftnav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.base.page.SpecialityBase;

public class FacilityPage extends SpecialityBase {

	public FacilityPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebElement getSpecialityTitle() {		
		return driver.findElement(By.cssSelector("#sidebar > " + getChildBlock() + " > div.panel-heading.panel_head > span"));
	}
	
	@Override
	public WebElement getCollapseButton() {
		return driver.findElement(By.cssSelector("#sidebar > " + getChildBlock() + " > div.panel-heading.panel_head"));
	}
	
	@Override
	public String getItems() {
		return "#sidebar > " + getChildBlock() + " > div.panel-body.aa > ul > li";
	}

	@Override
	public String getTitleText() {
		return "Facilities";
	}
	
	protected String getChildBlock() {
		return "div:nth-child(3)";
	}

}
