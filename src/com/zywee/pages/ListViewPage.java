package com.zywee.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.zywee.base.page.PageBase;
import com.zywee.tools.WaitTool;


public class ListViewPage extends PageBase {
	
	protected static final By breadCrumb = By.cssSelector("#content > div.row.grey > div > ul > li:nth-child(2)");
	protected static final By resultTitle = By.cssSelector("#content > div.container-fluid.Ab > div > div.col-sm-3.no_of_hosp");
	protected static final By sortDropdown = By.cssSelector("#content > div.container-fluid.Ab > div > div.col-sm-9 > select");
	
	protected String items = "#content > div.container-fluid.HOSPITAL > div > " +
			"div.col-xs-9.right-box > div.render > div";
	protected String hospBlock = "#content > div.container-fluid.HOSPITAL > div > div.col-xs-9.right-box > " +
			 "div.render > "+getBlockString()+" > ";	
	protected String hospImage = hospBlock + "div:nth-child(3) > div.col-sm-4 > img";
	protected String hospName = getEntityName();
	protected String category = getCategory();
	protected String location = getLocation();
	protected String rating = getRating();
	protected String consultFee = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(1) > div.col-xs-6.regular_text > div > div.col-xs-10.cons";
	protected String wardCharge = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(2) > div.col-xs-6.regular_text > div > div.col-xs-10.cons";
	protected String contact = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(3) > div.col-xs-6.regular_text > div > div.col-xs-10.cons";
	protected String facility = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(4) > div.col-xs-6.regular_text > div > div.col-xs-10.cons";
		
	protected String facilityAmbulance = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(1) > img";
	protected String facilityCafeteria = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
    "div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(2) > img";
	protected String facilityICU = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(3) > img";
	protected String facilityLab = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(4) > img";
	protected String facilityBloodBank = hospBlock + "div.icon-section > #icons-wrapper > " +
			"div:nth-child(5) > img";
	protected String viewMoreInfo = hospBlock + "div:nth-child(4) > div > div.col-xs-4.view_details > p";
    protected String bookNowButton = hospBlock + "div:nth-child(4) > div > div.col-xs-8.buttons > button";
	
	protected static Map<String,String> facilityMap = new HashMap<String,String>();
	public static int numItems;
	
	{
		populateFacilities();
	}
	
	public ListViewPage(WebDriver driver) {
		super(driver);
	}
	
	public ListViewPage(WebDriver driver,int itemNum) {
		this(driver);
		setithItem(itemNum);
	}
	
	public void validateListView() {
		validatePage();
		//doErrorValidation();
	}
	
	public void validateGridView() {
		validatePage();
		doErrorValidation();
	}
	
	public void validatePage() {	
		softAssert.assertTrue(isPageLoad());
		softAssert.assertTrue(isElementPresent(breadCrumb),"Breadcrumb not found");
		softAssert.assertTrue(isElementPresent(resultTitle),"Result heading not found");
		softAssert.assertTrue(isElementPresent(sortDropdown),"Sort dropdown not found");
		try {
            softAssert.assertAll();
        } catch(AssertionError er) {
            assertionErrors.append(er.getMessage());
        }
		validatePageHeaders();		
        //doErrorValidation();
		ZyweeHomePage.validateHeader();
		//LeftNavPage.validateLeftNav();
		ZyweeHomePage.validateFooter();
	    softAssert.assertTrue(isElementPresent(hospImage),"Hospital Image not found");
		softAssert.assertTrue(isElementPresent(hospName),"Hospital Name not found");
		String hospname = null;
		try {
			hospname = getText(hospName);
		} catch (Exception ex) {
			assertionErrors.append(ex.getMessage());
		}
		softAssert.assertTrue(isElementPresent(category),"Hospital category not found for " + hospname);
		softAssert.assertTrue(isElementPresent(location),"Hospital location not found for " + hospname);
		softAssert.assertTrue(isElementPresent(rating),"Hospital rating not found for " + hospname);
		softAssert.assertTrue(isElementPresent(consultFee),"Consultation fee not found for " + hospname);
		softAssert.assertTrue(isElementPresent(wardCharge),"Ward charge not found for " + hospname);
		softAssert.assertTrue(isElementPresent(contact),"Contact number not found for " + hospname);
		softAssert.assertTrue(isElementPresent(facility),"Facilities not found for " + hospname);
		softAssert.assertTrue(isElementPresent(viewMoreInfo),"View More Info link not found for " + hospname);
		softAssert.assertTrue(isElementPresent(bookNowButton),"Book Appointment button not found for " + hospname);
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
		    assertionErrors.append(er.getMessage());
		}
		/*
		ListViewPage listView = new ListViewHospitals(driver);
		listView.validateAll();
		*/
		//validateFacilities();
	}

	protected void validatePageHeaders() {
		softAssert.assertTrue(getText(resultTitle).trim().contains("Hospitals"),"Title does not contain Hospitals");
		softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Hospitals"),"Bread crumb does not end with Hospitals");
	}
	
	public void validateFacilities() {
		softAssert.assertFalse(facilityMap.isEmpty(),"No facilities found");
		for(Map.Entry<String, String> entry:facilityMap.entrySet()) {
			softAssert.assertTrue(isElementPresent(entry.getValue()));
		}
	}
	
	public HospitalsDetailPage gotoDetailPage() {
		driver.findElement(By.cssSelector(viewMoreInfo)).click();
		return new HospitalsDetailPage(driver);
	}
	
	public List<ListViewPage> getHospitalList() {
		List<ListViewPage> listViewHospitals = new ArrayList();
		numItems = driver.findElements(By.cssSelector(items)).size();
		for(int i=2;i<=numItems-2;i++) {
			ListViewPage hosp = new ListViewPage(driver, i);
			listViewHospitals.add(hosp);
		}
		return listViewHospitals;
	}
	
	public void validateAll() {
	    List<ListViewPage> listViewHospitals = getHospitalList();
	    for(ListViewPage eachHospital: listViewHospitals) {
	        eachHospital.validatePage();
	    }
	    //doErrorValidation();
	}
	
	public AppointmentPage bookAppointment(int id) {
		List<ListViewPage> listViewHospitals = getHospitalList();
		driver.findElement(By.cssSelector(listViewHospitals.get(id).bookNowButton)).click();
		windowFocus();
		WaitTool.waitForPageLoad(driver);
		return new AppointmentPage(driver);
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
		
	private void selectDropdown(String visibleText) {
		Select dropdown = new Select(driver.findElement(sortDropdown));
		dropdown.selectByVisibleText(visibleText);
		WaitTool.waitForJQueryProcessing(driver, 30);
		ListViewPage listView = new ListViewPage(driver);
		softAssert.assertNotNull(listView, "No result found");
		softAssert.assertNotEquals(listView.getHospitalList().size(),0,"No hospitals found");
	}
	
	protected void setithItem(int i) {
		String str = "#content > div.container-fluid.HOSPITAL > div > div.col-xs-9.right-box > "
				+ getBlockString() + " > div:nth-child(%d) > ";
		hospBlock = String.format(str, i);
		hospImage = hospBlock + "div:nth-child(3) > div.col-sm-4 > img";
		hospName = getEntityName();
		category = getCategory();
		location = getLocation();
		rating = getRating();
		consultFee = hospBlock
				+ "div:nth-child(3) > div.col-sm-8.right_charges > "
				+ "div:nth-child(1) > div.col-xs-6.regular_text > div > div.col-xs-10.cons";
		wardCharge = hospBlock
				+ "div:nth-child(3) > div.col-sm-8.right_charges > "
				+ "div:nth-child(2) > div.col-xs-6.regular_text > div > div.col-xs-10.cons";
		contact = hospBlock
				+ "div:nth-child(3) > div.col-sm-8.right_charges > "
				+ "div:nth-child(3) > div.col-xs-6.regular_text > div > div.col-xs-10.cons";
		facility = hospBlock
				+ "div:nth-child(3) > div.col-sm-8.right_charges > "
				+ "div:nth-child(4) > div.col-xs-6.regular_text > div > div.col-xs-10.cons";

		facilityAmbulance = hospBlock
				+ "div:nth-child(3) > div.col-sm-8.right_charges > "
				+ "div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(1) > img";
		facilityCafeteria = hospBlock
				+ "div:nth-child(3) > div.col-sm-8.right_charges > "
				+ "div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(2) > img";
		facilityICU = hospBlock
				+ "div:nth-child(3) > div.col-sm-8.right_charges > "
				+ "div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(3) > img";
		facilityLab = hospBlock
				+ "div:nth-child(3) > div.col-sm-8.right_charges > "
				+ "div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(4) > img";
		facilityBloodBank = hospBlock + "div.icon-section > #icons-wrapper > "
				+ "div:nth-child(5) > img";
		viewMoreInfo = hospBlock
				+ "div:nth-child(4) > div > div.col-xs-4.view_details > p";
		bookNowButton = hospBlock
				+ "div:nth-child(4) > div > div.col-xs-8.buttons > button";
	}
	
	protected void populateFacilities() {
		facilityMap.put("ambulance", facilityAmbulance);
		facilityMap.put("lab", facilityLab);
		//facilityMap.put("pharmacy", facilityPharmacy);
		facilityMap.put("cafeteria", facilityCafeteria);
		facilityMap.put("bloodbank", facilityBloodBank);
	}
	
	protected String getBlockString() {
		return "div:nth-child(2)";
	}
	
	protected String getEntityName() {
		return hospBlock + "div:nth-child(1) > div > div:nth-child(1) > div > div.col-xs-9 > h5";
	}
	
	protected String getCategory() {
		return hospBlock + "div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(1) > h5";
	}
	
	protected String getLocation() {
		return hospBlock + "div:nth-child(1) > div > div:nth-child(2) > div > div.col-xs-4.text-center.wordwrap_1 > h5";
	}
	
	protected String getRating() {
		return hospBlock + "div:nth-child(1) > div > div:nth-child(2) > div > div.col-xs-4.pad1 > div";
	}
	
}
