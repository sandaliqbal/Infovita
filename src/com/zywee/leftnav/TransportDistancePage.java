package com.zywee.leftnav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.base.page.SpecialityBase;


public class TransportDistancePage extends SpecialityBase {

	public TransportDistancePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public WebElement getSpecialityTitle() {
		return driver.findElement(By.cssSelector("#panel-head3"));
	}
	
	@Override
	public WebElement getCollapseButton() {
		return driver.findElement(By.cssSelector("#panel-head3"));
	
}
	@Override
	public String getItems() {
		return ("#panel-body3 > ul >li");
	}
	
	@Override
	public String getTitleText() {
		return "Distance";
	}

}
	
