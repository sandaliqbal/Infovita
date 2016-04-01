package com.zywee.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.zywee.base.page.PageBase;
import com.zywee.tools.WaitTool;


public class HospitalListView extends PageBase {
	
	protected static String items = "#content > div.container-fluid.HOSPITAL > div > " +
			"div.col-xs-9.right-box > div.render > div";
	protected String hospBlock = "#content > div.container-fluid.HOSPITAL > div > div.col-xs-9.right-box > " +
			"div.render > div:nth-child(2) > ";	
	protected String hospImage = hospBlock + "div:nth-child(3) > div.col-sm-4 > img";
	protected String hospName = hospBlock + "div:nth-child(1) > div > div:nth-child(1) > div > " +
			"div.col-xs-9 > h5";
	protected String category = hospBlock + "div:nth-child(1) > div > div:nth-child(2) > div > " +
			"div:nth-child(1) > h5";
	protected String location = hospBlock + "div:nth-child(1) > div > div:nth-child(2) > div > " +
			"div.col-xs-4.text-center.wordwrap_1 > h5";
	protected String rating = hospBlock + "div:nth-child(1) > div > div:nth-child(2) > div > " +
			"div.col-xs-4.pad1 > div";
	protected String consultFee = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(1) > div.col-xs-6.price > span";
	protected String wardCharge = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(2) > div.col-xs-6.price > span";
	protected String contact = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
			"div:nth-child(3) > div.col-xs-6.price > span";
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
	
	public HospitalListView(WebDriver driver) {
		super(driver);
	}
	
	public HospitalListView(WebDriver driver,int hospNum) {
		this(driver);
		setithHospital(hospNum);
	}
	
	public void validateListView() {
		validatePage();
		//doErrorValidation();
	}
	
	public void validateGridView() {
		validatePage();
		doErrorValidation();
	}
	
	private void validatePage() {	
	    softAssert.assertTrue(isElementPresent(hospImage),"Hospital Image not found");
		softAssert.assertTrue(isElementPresent(hospName),"Hospital Name not found");
		String hospname = getText(hospName);
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
		//validateFacilities();
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
	
	public static List<HospitalListView> getHospitalList() {
		List<HospitalListView> listViewHospitals = new ArrayList();
		numItems = driver.findElements(By.cssSelector(items)).size();
		for(int i=2;i<=numItems-2;i++) {
			HospitalListView hosp = new HospitalListView(driver, i);
			listViewHospitals.add(hosp);
		}
		return listViewHospitals;
	}
	
	public void validateAll() {
	    List<HospitalListView> listViewHospitals = getHospitalList();
	    for(HospitalListView eachHospital: listViewHospitals) {
	        eachHospital.validatePage();
	    }
	    //doErrorValidation();
	}
	
	public AppointmentPage bookAppointment(int id) {
		List<HospitalListView> listViewHospitals = getHospitalList();
		driver.findElement(By.cssSelector(listViewHospitals.get(id).bookNowButton)).click();
		windowFocus();
		WaitTool.waitForPageLoad(driver);
		return new AppointmentPage(driver);
	}
	
	protected void setithHospital(int i) {
		hospBlock = String.format("#content > div.container-fluid.HOSPITAL > div > div.col-xs-9.right-box > " +
        "div.render > div:nth-child(%d) > ",i);	
		hospImage = hospBlock + "div:nth-child(3) > div.col-sm-4 > img";
	    hospName = hospBlock + "div:nth-child(1) > div > div:nth-child(1) > div > " +
	            "div.col-xs-9 > h5";
	    category = hospBlock + "div:nth-child(1) > div > div:nth-child(2) > div > " +
	            "div:nth-child(1) > h5";
	    location = hospBlock + "div:nth-child(1) > div > div:nth-child(2) > div > " +
	            "div.col-xs-4.text-center.wordwrap_1 > h5";
	    rating = hospBlock + "div:nth-child(1) > div > div:nth-child(2) > div > " +
	            "div.col-xs-4.pad1 > div";
	    consultFee = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
	            "div:nth-child(1) > div.col-xs-6.price > span";
	    wardCharge = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
	            "div:nth-child(2) > div.col-xs-6.price > span";
	    contact = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
	            "div:nth-child(3) > div.col-xs-6.price > span";
	    facility = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
	            "div:nth-child(4) > div.col-xs-6.regular_text > div > div.col-xs-10.cons";
	        
	    facilityAmbulance = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
	            "div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(1) > img";
	    facilityCafeteria = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
	    "div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(2) > img";
	    facilityICU = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
	            "div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(3) > img";
	    facilityLab = hospBlock + "div:nth-child(3) > div.col-sm-8.right_charges > " +
	            "div:nth-child(4) > div.col-xs-6.LOG > ul > li:nth-child(4) > img";
	    facilityBloodBank = hospBlock + "div.icon-section > #icons-wrapper > " +
	            "div:nth-child(5) > img";
	    viewMoreInfo = hospBlock + "div:nth-child(4) > div > div.col-xs-4.view_details > p";
	    bookNowButton = hospBlock + "div:nth-child(4) > div > div.col-xs-8.buttons > button";
	}
	
	protected void populateFacilities() {
		facilityMap.put("ambulance", facilityAmbulance);
		facilityMap.put("lab", facilityLab);
		//facilityMap.put("pharmacy", facilityPharmacy);
		facilityMap.put("cafeteria", facilityCafeteria);
		facilityMap.put("bloodbank", facilityBloodBank);
	}
	
}
