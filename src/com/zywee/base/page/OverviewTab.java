package com.zywee.base.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zywee.pages.AppointmentPage;

public abstract class OverviewTab extends PageBase {

	public OverviewTab(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected WebElement image = driver.findElement(By.cssSelector("#Overview > div:nth-child(2) > " +
			"div:nth-child(1) > div > img"));
	protected WebElement bookButton = driver.findElement(By.cssSelector("#Overview > div:nth-child(1) > div > div > button"));
	protected WebElement desc = driver.findElement(By.cssSelector("#Overview > div:nth-child(2) > div.row.booking_row > div"));
	protected WebElement consultFee = driver.findElement(By.cssSelector("#Overview > div:nth-child(2) > div:nth-child(3) > " +
			"div:nth-child(2) > div.col-xs-6.regular_text > div > div.col-xs-10.cons"));
	protected WebElement wardCharge = driver.findElement(By.cssSelector("#Overview > div:nth-child(2) > div:nth-child(3) > " +
			"div:nth-child(4) > div.col-xs-6.regular_text > div > div.col-xs-10.cons"));
	protected WebElement contact = driver.findElement(By.cssSelector("#Overview > div:nth-child(2) > div:nth-child(3) > " +
			"div:nth-child(6) > div.col-xs-6.regular_text > div > div.col-xs-10.cons"));
	protected WebElement facility = driver.findElement(By.cssSelector("#Overview > div:nth-child(2) > div:nth-child(4)"));
	
	protected void validate() {
		Assert.assertTrue(isPageLoad(),"Failed to load page");
	}
	
	protected AppointmentPage clickBookAppointment() {
		bookButton.click();
		return new AppointmentPage(driver);
	}

}
