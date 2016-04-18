package com.zywee.base.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class SpecialistTab extends PageBase {

	public SpecialistTab(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected WebElement searchBox = driver.findElement(By.cssSelector("#search_doc_name"));
	protected List<WebElement> specialistList = driver.findElements(By.cssSelector("#Specialists > " +
			"div.col-xs-12.listed_doctors > div"));
	
	public int getNumSpecialists() {
		return specialistList.size();
	}

	public void clickAllSpecialists() {
		for(WebElement element:specialistList) {
			element.findElement(By.tagName("a")).click();
		}
	}
}
