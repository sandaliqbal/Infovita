package com.zywee.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.zywee.base.page.PageBase;


public class TopNavPage extends PageBase {
	
	private static final String breadCrumb = "#page-link > div";
	private static final String searchCatSelector = "#select1";
	private static final String searchBox = "#q";
	private static final String searchButton = "#yw0 > div > div.search-box > form > input.submit-button";
	private static final String myFavImage = "#fav-right > img";
	private static final String myFavLink = "#fav-right > a";
	
	TopNavPage(WebDriver driver) {
		super(driver);
	}
	
	public static void validateTopNav() {
		Assert.assertTrue(isElementPresent(breadCrumb));
		Assert.assertTrue(isElementPresent(searchCatSelector));
		Assert.assertTrue(isElementPresent(searchBox));
		Assert.assertTrue(isElementPresent(searchButton));
		Assert.assertTrue(isElementPresent(myFavImage));
		Assert.assertTrue(isElementPresent(myFavLink));
	}
	
	public static String getBreadCrumbText() {
		return getText(breadCrumb);
	}

}
