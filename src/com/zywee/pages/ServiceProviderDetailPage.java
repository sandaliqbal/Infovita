package com.zywee.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zywee.base.page.DetailPage;
import com.zywee.base.page.PageBase;

public class ServiceProviderDetailPage extends DetailPage {
	
	private static final String serviceProviderName = "#search-headr > div.search-view-title > div.single-view-name";
	private static final String contactEmergency = "#cont-info > strong:nth-child(1)";
	private static final String contactAppointment = "#cont-info > strong:nth-child(2)";
	private static final String numVotes = "#tp > strong";
	private static final String voteRating = "#tp > span";
	private static final String addToCompareButton = "#tp > div";
	private static final String onlineApptButton = "#appoint-info > a:nth-child(1)"; 
	private static final String infoTab = "#tab_1";
	private static final String vehicleTab = "#tab_2";
	private static final String accessoriesTab = "#tab_3";
	private static final String facilitiesTab = "#tab_3";
	private static final String mainImage = "#gallery > div.ad-image-wrapper > div.ad-image > img";
	private static final String thumbImages = "#gallery > div.ad-nav > div.ad-thumbs";
	private static final String description = "#single_information > p";
	private static final String facilities = "#single_information > ul > li:nth-child(2)";
	private static final String address = "#single_information > ul > li:nth-child(3)";
	private static final String map = "#single-map > div > div:nth-child(1) > div:nth-child(2)";
	private static final String review = "#single-left > div.review-container";
	private static final String writeReviewButton = "#single-left > div.review-container > " +
			"div.review-cont > div.review-right > a.review-btn";
	private static final String advertize = "#sponsered > img";
	
	
	public ServiceProviderDetailPage(WebDriver driver) {
	super(driver);
	}
	 
	public void validatePage() {
		//BuzzHomePage.validateHeader();
		//TopNavPage.validateTopNav();
	    verifyThumbImages(thumbImages+"> ul > a");
		Assert.assertTrue(isElementPresent(serviceProviderName));
		Assert.assertTrue(isElementPresent(contactEmergency));
		Assert.assertTrue(isElementPresent(contactAppointment));
		Assert.assertTrue(isElementPresent(numVotes));
		Assert.assertTrue(isElementPresent(voteRating));
		Assert.assertTrue(isElementPresent(addToCompareButton));
		Assert.assertTrue(isElementPresent(onlineApptButton));
		Assert.assertTrue(isElementPresent(infoTab));
		Assert.assertTrue(isElementPresent(vehicleTab));
		Assert.assertTrue(isElementPresent(facilitiesTab));
		Assert.assertTrue(isElementPresent(accessoriesTab));
		Assert.assertTrue(isElementPresent(mainImage));
		Assert.assertTrue(isElementPresent(thumbImages));
		Assert.assertTrue(isElementPresent(description));
		Assert.assertTrue(isElementPresent(facilities));
		Assert.assertTrue(isElementPresent(address));
		Assert.assertTrue(isElementPresent(map));
		Assert.assertTrue(isElementPresent(review));
		Assert.assertTrue(isElementPresent(writeReviewButton));
		Assert.assertTrue(isElementPresent(advertize));
		ZyweeHomePage.validateFooter();
	}
	public void verifyThumbImages(String locator) {
	    int numImages = getCssCount(locator);
	    //:nth-child(2)
	    for (int i=1;i<=numImages;i++) {
	        String image = locator+":nth-child("+i+")";
	        Assert.assertTrue(isElementPresent(image), "image "+ image + " not found");
	    }
	}
	private int getCssCount(String locator) {
	    List<WebElement> elements = driver.findElements(By.cssSelector(locator));
	    int count = elements.size();
	    return count;
	}

}

		
		


