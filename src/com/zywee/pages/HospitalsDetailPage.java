package com.zywee.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.zywee.base.page.PageBase;


public class HospitalsDetailPage extends PageBase {
	
	private static final String hospName = "#search-headr > div.search-view-title > div.single-view-name";
	private static final String contactEmergency = "#cont-info > strong:nth-child(1)";
	private static final String contactAppointment = "#cont-info > strong:nth-child(2)";
	private static final String numVotes = "#tp > strong";
	private static final String voteRating = "#tp > span";
	private static final String addToCompareButton = "#tp > div";
	private static final String onlineApptButton = "#appoint-info > a:nth-child(1)"; 
	private static final String infoTab = "#tab_1";
	private static final String specialistTab = "#tab_2";
	private static final String facilitiesTab = "#tab_3";
	private static final String roomTariffTab = "#tab_4";
	private static final String treatPkgTab = "#tab_5";
	private static final String insuranceTab = "#tab_6";
	private static final String mainImage = "#gallery > div.ad-image-wrapper > div.ad-image > img";
	private static final String thumbImages = "#gallery > div.ad-nav > div.ad-thumbs";
	private static final String description = "#single_information > p";
	private static final String bed = "#single_information > ul > li:nth-child(1)";
	private static final String facilities = "#single_information > ul > li:nth-child(2)";
	private static final String address = "#single_information > ul > li:nth-child(3)";
	private static final String website = "#single_information > ul > li:nth-child(4)";
	private static final String email = "#single_information > ul > li:nth-child(5)";
	private static final String socialMedia = "#single_information > div.social-media-con";
	private static final String mediaLikes = "#single_information > div.social-media-con";
	private static final String map = "#single-map > div > div:nth-child(1) > div:nth-child(2)";
	private static final String review = "#single-left > div.review-container";
	private static final String writeReviewButton = "#single-left > div.review-container > " +
			"div.review-cont > div.review-right > a.review-btn";
	private static final String advertize = "#sponsered > img";
	private static final String nearbyFacilityHotel = "#single-right > div:nth-child(2) > li:nth-child(2)";
	private static final String nearbyFacilityATM = "#single-right > div:nth-child(2) > li:nth-child(3)";
	private static final String nearbyFacilityBus = "#single-right > div:nth-child(2) > li:nth-child(4)";
	private static final String nearbyFacilityRestaurant = "#single-right > div:nth-child(2) > li:nth-child(5)";
	private static final String nearbyFacilityRail = "#single-right > div:nth-child(2) > li:nth-child(6)";
	private static final String nearbyFacilityAirport = "#single-right > div:nth-child(2) > li:nth-child(7)";
	private static final String similarHosp = "#single-right > div:nth-child(3)";
	private static final String newsEvent = "#single-right > div:nth-child(4)";
	
	private static final String specialization = "#specialization";
	private static final String specialists = "#specialists";
	private static final String facilityDetails = "#tab3 > div > div";
	private static final String roomTypes = "#room_types";
	private static final String roomTariff = "#room_tarrif";
	private static final String treatmentPkgTariffTxt = "Tariff";
	private static final String insuranceTxt = "Insurance Companies";
	
	public HospitalsDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public void validatePage() {
		//BuzzHomePage.validateHeader();
		//TopNavPage.validateTopNav();
	    verifyThumbImages(thumbImages+"> ul > a");
		Assert.assertTrue(isElementPresent(hospName));
		Assert.assertTrue(isElementPresent(contactEmergency));
		Assert.assertTrue(isElementPresent(contactAppointment));
		Assert.assertTrue(isElementPresent(numVotes));
		Assert.assertTrue(isElementPresent(voteRating));
		Assert.assertTrue(isElementPresent(addToCompareButton));
		Assert.assertTrue(isElementPresent(onlineApptButton));
		Assert.assertTrue(isElementPresent(infoTab));
		Assert.assertTrue(isElementPresent(specialistTab));
		Assert.assertTrue(isElementPresent(facilitiesTab));
		Assert.assertTrue(isElementPresent(roomTariffTab));
		Assert.assertTrue(isElementPresent(treatPkgTab));
		Assert.assertTrue(isElementPresent(insuranceTab));
		Assert.assertTrue(isElementPresent(mainImage));
		Assert.assertTrue(isElementPresent(thumbImages));
		Assert.assertTrue(isElementPresent(description));
		Assert.assertTrue(isElementPresent(bed));
		Assert.assertTrue(isElementPresent(facilities));
		Assert.assertTrue(isElementPresent(address));
		Assert.assertTrue(isElementPresent(website));
		Assert.assertTrue(isElementPresent(email));
		Assert.assertTrue(isElementPresent(socialMedia));
		Assert.assertTrue(isElementPresent(mediaLikes));
		Assert.assertTrue(isElementPresent(map));
		Assert.assertTrue(isElementPresent(review));
		Assert.assertTrue(isElementPresent(writeReviewButton));
		Assert.assertTrue(isElementPresent(advertize));
		Assert.assertTrue(isElementPresent(nearbyFacilityHotel));
		Assert.assertTrue(isElementPresent(nearbyFacilityATM));
		Assert.assertTrue(isElementPresent(nearbyFacilityBus));
		Assert.assertTrue(isElementPresent(nearbyFacilityRestaurant));
		Assert.assertTrue(isElementPresent(nearbyFacilityRail));
		Assert.assertTrue(isElementPresent(nearbyFacilityAirport));
		Assert.assertTrue(isElementPresent(similarHosp));
		Assert.assertTrue(isElementPresent(newsEvent));
		ZyweeHomePage.validateFooter();
	}
	
	public void clickSpecialists() {
	    Assert.assertTrue(isElementPresent(specialistTab));
	    driver.findElement(By.cssSelector(specialistTab)).click();
	    Assert.assertTrue(isElementPresent(specialization));
	    Assert.assertTrue(isElementPresent(specialists));
	}
	
	public void clickFacilities() {
        Assert.assertTrue(isElementPresent(facilitiesTab));
        driver.findElement(By.cssSelector(facilitiesTab)).click();
        Assert.assertTrue(isElementPresent(facilityDetails));
    }
	
	public void clickRoomTariff() {
        Assert.assertTrue(isElementPresent(roomTariffTab));
        driver.findElement(By.cssSelector(roomTariffTab)).click();
        Assert.assertTrue(isElementPresent(roomTariff));
        Assert.assertTrue(isElementPresent(roomTypes));
    }
	
	public void clickTreatmentPackages() {
        Assert.assertTrue(isElementPresent(treatPkgTab));
        driver.findElement(By.cssSelector(treatPkgTab)).click();
        Assert.assertTrue(isElementPresent(roomTariff));
        //Assert.assertEquals(getText(roomTariff), treatmentPkgTariffTxt);
    }
	
	public void clickInsurance() {
        Assert.assertTrue(isElementPresent(insuranceTab));
        driver.findElement(By.cssSelector(insuranceTab)).click();
        Assert.assertTrue(isElementPresent(roomTariff));
        //Assert.assertEquals(getText(roomTypes), insuranceTxt);
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
