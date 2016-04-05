package com.zywee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.zywee.base.page.PageBase;
import com.zywee.tools.WaitTool;


public class HospitalsPage extends PageBase {
	
	private static final By breadCrumb = By.cssSelector("#content > div.row.grey > div > ul > li:nth-child(2)");
	private static final By resultTitle = By.cssSelector("#content > div.container-fluid.Ab > div > div.col-sm-3.no_of_hosp");
	private static final By sortDropdown = By.cssSelector("#content > div.container-fluid.Ab > div > div.col-sm-9 > select");
	
	public HospitalsPage(WebDriver driver) {
		super(driver);
	}
	
	public void validatePage() {
		softAssert.assertTrue(isPageLoad());
		softAssert.assertTrue(isElementPresent(breadCrumb),"Breadcrumb not found");
		softAssert.assertTrue(isElementPresent(resultTitle),"Result heading not found");
		softAssert.assertTrue(isElementPresent(sortDropdown),"Sort dropdown not found");
		softAssert.assertTrue(getText(resultTitle).trim().contains("Hospitals"),"Title does not contain Hospitals");
		softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Hospitals"),"Bread crumb does not end with Hospitals");		
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
            assertionErrors.append(er.getMessage());
        }
        //doErrorValidation();
		ZyweeHomePage.validateHeader();
		//LeftNavPage.validateLeftNav();
		ZyweeHomePage.validateFooter();
		ListViewPage listView = new ListViewHospitals(driver);
		listView.validateAll();
	}
	
	
	public void sortOnCost() {
		selectDropdown("Cost");
	}

	public void sortOnNameAsc() {
		selectDropdown("A - Z");
	}
	
	public void sortOnNameDesc() {
		selectDropdown("Sort By Order");
	}
	
	public void sortOnRating() {
		selectDropdown("Rating");
	}
	
	public HospitalsDetailPage gotoDetailPage() {
		ListViewPage listView = new ListViewPage(driver);
		return listView.gotoDetailPage();
	}
		
	private void selectDropdown(String visibleText) {
		Select dropdown = new Select(driver.findElement(sortDropdown));
		dropdown.selectByVisibleText(visibleText);
		WaitTool.waitForJQueryProcessing(driver, 30);
		ListViewPage listView = new ListViewPage(driver);
		softAssert.assertNotNull(listView, "No result found");
		softAssert.assertNotEquals(listView.getHospitalList().size(),0,"No hospitals found");
	}
}
