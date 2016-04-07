package com.zywee.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zywee.base.page.ListViewPage;

public class ListViewTests extends ListViewPage {

	public ListViewTests(WebDriver driver) {
		super(driver);
		setithItem(2);
	}
	
	public ListViewTests(WebDriver driver,int testNum) {
		super(driver, testNum);
	}
	
	protected String testName;
	protected String fee;
	protected String bookNow;
	
	@Override
	protected void setithItem(int index) {
		String startBlock = "#content > div.container-fluid.HOSPITAL > div > "
				+ "div.col-xs-9.right-box > div.render > div:nth-child(%d) > ";
		super.hospBlock = String.format(startBlock, index);
		testName = super.hospBlock
				+ "div.row.package_head > div.col-xs-7.packages_smartphone_heading > h4";
		fee = super.hospBlock
				+ "div.row.package_row > div > div > div.col-xs-4.packages_smartphone > " +
						"div > div.col-md-6.text-center > div > span";
		bookNow = super.hospBlock
				+ "div.row.package_row > div > div > div.col-xs-4.packages_smartphone > div > div:nth-child(2) > button";
	}
	
	@Override
	protected String getEntityName() {
		return super.hospBlock + "div.row.package_row > div > div > div.col-xs-6.packages_smartphone > " +
				"div > div.col-lg-8 > h5";
	}
	
	@Override
	protected String getLocation() {
		return super.hospBlock + "div.row.package_row > div > div > div.col-xs-6.packages_smartphone > " +
				"div > div.col-lg-4 > h5";
	}
	
	@Override
	protected String getRating() {
		return super.hospBlock + "div.row.package_row > div > div > div.col-xs-2.packages_smartphone > div";
	}
	
	@Override
	protected void validatePageHeaders() {
		softAssert.assertTrue(getText(resultTitle).trim().contains("Tests"),"Title does not contain Tests");
		softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Tests"),"Bread crumb does not end with Tests");
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
        	addAssertionError(er.getMessage());
        }
	}
	
	@Override
	public List<ListViewPage> getResultList() {
		List<ListViewPage> resultList = new ArrayList();
		numItems = driver.findElements(By.cssSelector(items)).size();
		for(int i=2;i<=numItems;i++) {
			ListViewPage test = new ListViewTests(driver, i);
			resultList.add(test);
		}
		return resultList;
	}
	
	@Override
	public void validatePage() {	
		super.validatePage();
		softAssert.assertTrue(isElementPresent(testName),"Test Name not found");
		softAssert.assertTrue(isElementPresent(getEntityName()),"Center Name not found");
		softAssert.assertTrue(isElementPresent(getLocation()),"Test Center location not found");
		softAssert.assertTrue(isElementPresent(getRating()),"Rating rating not found");
		softAssert.assertTrue(isElementPresent(fee),"Test fee not found");
		softAssert.assertTrue(isElementPresent(bookNow),"Book button not found");
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
        	addAssertionError(er.getMessage());
        }
	}

}
