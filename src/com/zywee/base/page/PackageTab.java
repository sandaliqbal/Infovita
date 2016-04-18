package com.zywee.base.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PackageTab extends PageBase {

	public PackageTab(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected WebElement searchBox = driver.findElement(By.cssSelector("#search_pack_name"));
	protected WebElement packageList = driver.findElement(By.cssSelector("#Packages > div.col-xs-12.listed_packages"));

}
