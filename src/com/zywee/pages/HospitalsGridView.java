package com.zywee.pages;

import org.openqa.selenium.WebDriver;

public class HospitalsGridView extends ListViewPage {
	
	public HospitalsGridView(WebDriver driver) {
		super(driver);
		hospName = hospBlock + "div.search-view-title > div.search-view-name > a";
		category = hospBlock + "div.search-view-dics";
		rating = hospBlock + "div.search-view-vote > span";
		viewMoreInfo = hospBlock + "div.srch-rslt-view-dtls > a";
		bookNowButton = hospBlock + "div.srch-rslt-book-now";
		facilityAmbulance = hospBlock + "#icons-wrapper > div:nth-child(1) > img";
		facilityLab = hospBlock + "#icons-wrapper > div:nth-child(2) > img";
		//facilityPharmacy = hospBlock + "#icons-wrapper > div:nth-child(3) > img";
		facilityCafeteria = hospBlock + "#icons-wrapper > div:nth-child(4) > img";
		facilityBloodBank = hospBlock + "#icons-wrapper > div:nth-child(5) > img";
		populateFacilities();
	}
	
}
