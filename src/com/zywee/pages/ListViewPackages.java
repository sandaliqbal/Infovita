package com.zywee.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zywee.base.page.ListViewPage;
import com.zywee.leftnav.LeftNavPage;

public class ListViewPackages extends ListViewPage {
	
	protected String packName;
	protected String showLess;
	protected String showMore;
	protected String description;
	protected String fee;
	
	public ListViewPackages(WebDriver driver) {
		super(driver);
		setithItem(2);
	}
	
	public ListViewPackages(WebDriver driver,int packNum) {
		super(driver, packNum);
	}

	@Override
	protected void validatePageHeaders() {
		softAssert.assertTrue(getText(resultTitle).trim().contains("Packages"),"Title does not contain Packages");
		softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Packages"),"Bread crumb does not end with Packages");
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
        	addAssertionError(er.getMessage());
        }
	}
	
	protected String getImage() {
		return super.hospBlock + "div:nth-child(2) > div:nth-child(1) > div:nth-child(2) >" +
				" div.col-md-6.padding_left_zero.aa > img";
	}
	
	@Override
	protected String getEntityName() {
		return super.hospBlock + "div:nth-child(2) > div.row.package_row > div > div:nth-child(1) > " +
				"div.col-xs-5.packages_smartphone > div > div.col-lg-8 > h5";
	}
	
	@Override
	protected String getLocation() {
		return super.hospBlock + "div:nth-child(2) > div.row.package_row > div > div:nth-child(1) > " +
				"div.col-xs-5.packages_smartphone > div > div.col-lg-4 > h5";
	}
	
	@Override
	protected String getRating() {
		return super.hospBlock + "div:nth-child(2) > div.row.package_row > div > div:nth-child(1) > " +
				"div.col-xs-3.packages_smartphone > h5";
	}
	
	protected String getBookButton() {
		return super.hospBlock + "div:nth-child(2) > div.row.package_row > div > div:nth-child(1) > " +
				"div.col-xs-4.packages_smartphone > div > div:nth-child(2) > button";
	}
	
	@Override
	protected void setithItem(int index) {
		String startBlock = "#content > div.container-fluid.HOSPITAL > div > "
				+ "div.col-xs-9.right-box > div.render > div:nth-child(%d) > ";
		super.hospBlock = String.format(startBlock, index);
		packName = super.hospBlock
				+ "div.row.package_head > div.col-xs-7.packages_smartphone_heading > h4";
		showLess = super.hospBlock
				+ "div.row.package_head > div.col-xs-4.packages_arrow > p:nth-child(1)";
		showMore = super.hospBlock
				+ "div.row.package_head > div.col-xs-4.packages_arrow > p:nth-child(2)";
		description = super.hospBlock
				+ "div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > "
				+ "div:nth-child(2) > p";
		fee = super.hospBlock
				+ "div:nth-child(2) > div.row.package_row > div > div:nth-child(1) > "
				+ "div.col-xs-4.packages_smartphone > div > div:nth-child(1) > span.text1";
	}
	
	@Override
	public List<ListViewPage> getResultList() {
		List<ListViewPage> resultList = new ArrayList();
		numItems = driver.findElements(items).size();
		for(int i=2;i<=numItems;i+=2) {
			ListViewPage pack = new ListViewPackages(driver, i);
			resultList.add(pack);
		}
		return resultList;
	}
	
	@Override
	public void validatePage() {	
		super.validatePage();
		softAssert.assertTrue(isElementPresent(packName),"Package Name not found");
		softAssert.assertTrue(isElementPresent(getImage()),"Package Image not found");
		softAssert.assertTrue(isElementPresent(showLess),"Show less button not found");
		softAssert.assertTrue(isElementPresent(description),"Package description not found");
		softAssert.assertTrue(isElementPresent(getImage()),"Package Image not found");
		softAssert.assertTrue(isElementPresent(getEntityName()),"Hospital Name not found");
		softAssert.assertTrue(isElementPresent(getLocation()),"Package location not found");
		softAssert.assertTrue(isElementPresent(getRating()),"Package rating not found");
		softAssert.assertTrue(isElementPresent(fee),"Package fee not found");
		softAssert.assertTrue(isElementPresent(getBookButton()),"Book button not found");
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
        	addAssertionError(er.getMessage());
        }
        /*
        CenterTypePage sp = new CenterTypePage(driver);
		sp.getCheckboxes();
		sp.selectCheckboxes("Diagnostics Centres");
		*/
		LeftNavPage leftNav = new LeftNavPage(driver);
		leftNav = leftNav.getPackageLeftNav();
		leftNav.selectCenterType("Diagnostics Centres");
	}		

}
