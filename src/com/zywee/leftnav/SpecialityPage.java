package com.zywee.leftnav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.base.page.SpecialityBase;

public class SpecialityPage extends SpecialityBase {

	public SpecialityPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebElement getSpecialityTitle() {
		return driver.findElement(By.cssSelector("#sidebar > div:nth-child(1) > " +
				"div.panel-heading.panel_head > span"));
	}
	
	@Override
	public WebElement getCollapseButton() {
		return driver.findElement(By.cssSelector("#sidebar > div:nth-child(1) > " +
				"div.panel-heading.panel_head"));
	}

	@Override
	public String getItems() {
		return "#sidebar > div:nth-child(1) > div.panel-body.aa > ul > li";
	}
	
	@Override
	public String getTitleText() {
		return "Specialities";
	}

}
