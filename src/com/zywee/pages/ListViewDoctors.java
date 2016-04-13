package com.zywee.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zywee.base.page.ListViewPage;
import com.zywee.leftnav.LeftNavPage;

public class ListViewDoctors extends ListViewPage {

	public ListViewDoctors(WebDriver driver) {
		super(driver);
		setithItem(1);
	}
	
	public ListViewDoctors(WebDriver driver,int docNum) {
		super(driver, docNum);
	}
	
	protected String docName;
	protected String degree;
	protected String speciality;
	protected String image;
	protected String qualification;
	protected String experience;
	protected String timing;
	protected String fee;
	protected String bookNow;
	
	@Override
	protected String getEntityName() {
		return super.hospBlock + "div:nth-child(6) > div > div > div.col-xs-5.packages_smartphone > div > div:nth-child(1) > h5";
	}

	@Override
	protected String getLocation() {
		return super.hospBlock + "div:nth-child(6) > div > div > div.col-xs-5.packages_smartphone > div > div:nth-child(2) > h5";
	}
	
	@Override
	protected String getRating() {
		return super.hospBlock + "div.row.package_head > div.col-sm-3 > h4";
	}
	
	@Override
	protected void setithItem(int index) {
		String startBlock = "#content > div.container-fluid.HOSPITAL > div > "
				+ "div.col-xs-9.right-box > div.render > div:nth-child(%d) > ";
		super.hospBlock = String.format(startBlock, index);
		docName = super.hospBlock
				+ "div.row.package_head > div.col-sm-8 > div > div:nth-child(1) > h4";
		degree = super.hospBlock
				+ "div.row.package_head > div.col-sm-8 > div > div:nth-child(2) > h4";
		speciality = super.hospBlock
				+ "div.row.package_head > div.col-sm-8 > div > div:nth-child(3) > h4";
		image = super.hospBlock
				+ "div:nth-child(3) > div.col-md-4 > img";
		qualification = super.hospBlock + "div:nth-child(3) > div.col-md-8 > div:nth-child(1) > div.col-sm-5 > span";
		experience = super.hospBlock + "div:nth-child(3) > div.col-md-8 > div:nth-child(2) > div.col-sm-5 > span";
		timing = super.hospBlock + "div:nth-child(6) > div > div > div.col-xs-3.packages_smartphone > h5";
		fee = super.hospBlock
				+ "div:nth-child(6) > div > div > div.col-xs-4.packages_smartphone > div > div.col-md-6.regular_text";
		bookNow = super.hospBlock + "div:nth-child(6) > div > div > div.col-xs-4.packages_smartphone > " +
				"div > div:nth-child(2) > button";
	}
	
	@Override
	protected void validatePageHeaders() {
		softAssert.assertTrue(getText(resultTitle).trim().contains("Doctors"),"Title does not contain Doctors");
		softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Doctors"),"Bread crumb does not end with Doctors");
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
        	addAssertionError(er.getMessage());
        }
	}
	
	@Override
	public void validatePage() {
		super.validatePage();
		softAssert.assertTrue(isElementPresent(docName),"Doctor Name not found");
		softAssert.assertTrue(isElementPresent(image),"Doctor image not found");
		String docname = null;
		try {
			docname = getText(docName);
		} catch (Exception ex) {
			addAssertionError(ex.getMessage());
		}
		softAssert.assertTrue(isElementPresent(degree),"Doctor degree not found for " + docname);
		softAssert.assertTrue(isElementPresent(speciality),"Doctor speciality not found for " + docname);
		softAssert.assertTrue(isElementPresent(getRating()),"Dcotor rating not found for " + docname);
		softAssert.assertTrue(isElementPresent(getEntityName()),"Dcotor association not found for " + docname);
		softAssert.assertTrue(isElementPresent(getLocation()),"Dcotor location not found for " + docname);
		softAssert.assertTrue(isElementPresent(fee),"Consultation fee not found for " + docname);
		softAssert.assertTrue(isElementPresent(qualification),"Qualification not found for " + docname);
		softAssert.assertTrue(isElementPresent(experience),"Experience not found for " + docname);
		softAssert.assertTrue(isElementPresent(timing),"Timing not found for " + docname);
		softAssert.assertTrue(isElementPresent(bookNow),"Book Appointment button not found for " + docname);
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
			addAssertionError(er.getMessage());
		}
		/*
		CenterTypePage sp = new CenterTypePage(driver);
		sp.getCheckboxes();
		sp.selectCheckboxes("Clinics");*/
		
		LeftNavPage leftNav = new LeftNavPage(driver);
		leftNav = leftNav.getDoctorLeftNav();
		leftNav.selectCenterType("Clinics");
	}
	
	@Override
	public List<ListViewPage> getResultList() {
		List<ListViewPage> resultList = new ArrayList();
		numItems = driver.findElements(items).size();
		for(int i=1;i<=numItems;i++) {
			ListViewPage doc = new ListViewDoctors(driver, i);
			resultList.add(doc);
		}
		return resultList;
	}
}
