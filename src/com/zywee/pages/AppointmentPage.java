package com.zywee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.zywee.base.page.PageBase;


public class AppointmentPage extends PageBase {
	
	private String logo = "#subpage-content > div.hsptls-cntr > div.hsptls-cntr-hdr > div.hsptls-cntr-hdr-logo > img";
	private String hospName = "#subpage-content > div.hsptls-cntr > div.hsptls-cntr-hdr > div:nth-child(2) > h4";
	private String docTab = "#subpage-content > div.hsptls-cntr > div.doctors_block > div > div.hsptls-dtrs-cntr-hdr > " +
			"div.hsptls-dtrs-tab > span.pointer.trigger-doctor";
	private String treatmentPkgTab = "#subpage-content > div.hsptls-cntr > div.doctors_block > div > " +
			"div.hsptls-dtrs-cntr-hdr > div.hsptls-dtrs-tab > span.pointer.trigger-treatment";
	private static String title = "Book Appointment With BuzzHospitals.com Appointment scheduling System";
	
	public AppointmentPage(WebDriver driver) {
		super(driver,title);	
	}
	
	public void validatePage() {
		Assert.assertTrue(isPageLoad());
		Assert.assertTrue(isElementPresent(By.cssSelector(logo)));
		Assert.assertTrue(isElementPresent(By.cssSelector(hospName)));
		Assert.assertTrue(isElementPresent(By.cssSelector(docTab)));
		Assert.assertTrue(isElementPresent(By.cssSelector(treatmentPkgTab)));
		Assert.assertTrue(TopNavPage.getBreadCrumbText().endsWith("Online Appointment"));
	}

}
