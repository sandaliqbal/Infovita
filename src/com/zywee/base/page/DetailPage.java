package com.zywee.base.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.pages.AppointmentPage;

public class DetailPage extends PageBase {
	
	protected OverviewTab overviewTab = new OverviewTab(driver) {
	};
	
	protected SpecialistTab specialistTab = new SpecialistTab(driver) {
	};
	
	protected PackageTab packageTab = new PackageTab(driver) {
	};
	
	protected FacilityTab facilityTab = new FacilityTab(driver) {
	};
	
	protected ReviewsTab reviewTab = new ReviewsTab(driver) {
	};
	
	protected RoomsTab  roomTab = new RoomsTab(driver) {
	};

	public DetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected WebElement backButton = driver.findElement(By.cssSelector("#content > div.HOSPITAL > span > img"));
	protected WebElement logo = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div:nth-child(1) > div > div.col-md-5 > div > div.col-xs-3 > img"));
	protected WebElement name = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div:nth-child(1) > div > div.col-md-5 > div > div.col-xs-9.Header1.top_margin"));
	protected WebElement type = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div:nth-child(1) > div > div.col-md-7 > div > div.col-xs-4.top_margin > h5"));
	protected WebElement location = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div:nth-child(1) > div > div.col-md-7 > div > div.col-xs-3.top_margin > h5"));
	protected WebElement rating = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div:nth-child(1) > div > div.col-md-7 > div > div.col-xs-5.top_margin > div"));
	protected WebElement overview = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div.tabbable > div.scrollable > ul > li:nth-child(1) > a"));
	protected WebElement specialists = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div.tabbable > div.scrollable > ul > li:nth-child(2) > a"));
	protected WebElement rooms = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div.tabbable > div.scrollable > ul > li:nth-child(3) > a"));
	protected WebElement packages = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div.tabbable > div.scrollable > ul > li:nth-child(3) > a"));
	protected WebElement facilities = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div.tabbable > div.scrollable > ul > li:nth-child(4) > a"));
	protected WebElement reviews = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div.tabbable > div.scrollable > ul > li:nth-child(5) > a"));
	protected WebElement address = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div:nth-child(3) > div > div.col-md-3 > div > address"));
	protected WebElement bookButton = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div:nth-child(3) > div > div.col-md-3 > div > div > div > button"));
	protected WebElement addressMap = driver.findElement(By.cssSelector("#content > div.HOSPITAL > div > div > " +
			"div:nth-child(3) > div > div.col-md-9"));
	
	public AppointmentPage bookAppointment() {
		return overviewTab.clickBookAppointment();
	}
	
	public AppointmentPage bookAddressAppointment() {
		bookButton.click();
		return new AppointmentPage(driver);
	}
	
	public void clickOverview() {
		overview.click();
	}
	
	public void clickSpecialists() {
		specialists.click();
	}
	
	public void clickRooms() {
		rooms.click();
	}
	
	public void clickPackages() {
		packages.click();
	}
	
	public void clickFacilities() {
		facilities.click();
	}

	public void clickReviews() {
		reviews.click();
	}
	
	public void goBack() {
		backButton.click();
	}
	
	public void testReviews() {
		clickReviews();
		reviewTab.testReviews();
	}
	
	public void testSpecialists() {
		System.out.println(specialistTab.getNumSpecialists());
		specialistTab.clickAllSpecialists();
	}
	
	public void testRooms() {
		clickRooms();
		roomTab.checkRoomPrices();
	}
		
}
