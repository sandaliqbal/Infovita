package com.zywee.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.zywee.base.page.ListViewPage;
import com.zywee.leftnav.LeftNavPage;

public class ListViewEquipments extends ListViewPage {
	
	protected String equipmentName;
	protected String description;
	protected String fee;
	
	public ListViewEquipments(WebDriver driver) {
		super(driver);
		setithItem(2);
		URL = URL + "/bangalore/equipments";
	}
	public ListViewEquipments(WebDriver driver,int equipmentNum) {
		super(driver, equipmentNum);
	}

	@Override
	protected void validatePageHeaders() {
		softAssert.assertTrue(getText(resultTitle).trim().contains("Equipments"),"Title does not contain Equipments");
		softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Equipments"),"Bread crumb does not end with Equipments");
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
        	addAssertionError(er.getMessage());
        }
	}
	protected String getImage() {
		return super.hospBlock + "#content > div.container-fluid.HOSPITAL > div > div.col-xs-9.right-box > div.render >"
	+ "div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > img" ;
		
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
		equipmentName = super.hospBlock
				+ "div.row.package_head > div.col-xs-7.packages_smartphone_heading > h4";
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
			ListViewPage equipments = new ListViewEquipments(driver, i);
			resultList.add(equipments);
		}
		return resultList;
	}
	
	@Override
	public void validatePage() {	
		super.validatePage();
		softAssert.assertTrue(isElementPresent(equipmentName),"Equipment Name not found");
		softAssert.assertTrue(isElementPresent(getImage()),"Equipments Image not found");
		softAssert.assertTrue(isElementPresent(description),"Equipments description not found");
		softAssert.assertTrue(isElementPresent(getImage()),"equipments Image not found");
		softAssert.assertTrue(isElementPresent(getEntityName()),"Hospital Name not found");
		softAssert.assertTrue(isElementPresent(getLocation()),"equipments location not found");
		softAssert.assertTrue(isElementPresent(getRating()),"equipments rating not found");
		softAssert.assertTrue(isElementPresent(fee),"equipments fee not found");
		softAssert.assertTrue(isElementPresent(getBookButton()),"Book button not found");
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
        	addAssertionError(er.getMessage());
        }
	}

	// TODO 
//	public LeftNavPage getLeftNav() {
//		LeftNavPage leftNav = new LeftNavPage(driver);
//		return leftNav.getequipmentLeftNav();
//	}
//	
//	public EquipmentDetailPage clickEquipmentsName() {
//		driver.findElement(By.cssSelector(equipmentName)).click();
//		return new EquipmentDetailPage(driver);
//	}
//	
//	public EquipmentsPage clickBookEquipments() {
//		driver.findElement(By.cssSelector(getBookButton())).click();
//		return new EquipmentsPage(driver);
//	}

}
	
		


