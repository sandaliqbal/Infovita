package com.zywee.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zywee.base.test.TestBase;
import com.zywee.pages.HospitalsDetailPage;
import com.zywee.pages.ListViewHospitals;


public class TestHospitalDetailPage extends TestBase {

    private WebDriver driver;
    private ListViewHospitals hospitals;
    private HospitalsDetailPage hospitalDetail;

    @BeforeMethod
    public void setUp() throws Exception {
        init();
        driver = super.driver;
        hospitals = new ListViewHospitals(driver);
        hospitals.open();
        hospitalDetail = hospitals.gotoDetailPage();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        /*List<JavaScriptError> jsErrors = JavaScriptError.readErrors(driver);
        System.out.println("###start displaying errors");
        for(int i = 0; i < jsErrors.size(); i++)
        {
        System.out.println(jsErrors.get(i).getErrorMessage());
        System.out.println(jsErrors.get(i).getLineNumber());
        System.out.println(jsErrors.get(i).getSourceName());
        }
        System.out.println("###stop displaying errors");*/
        driver.close(); 
        driver.quit();
    }
    
    @Test
    public void testBookAppointment() {
        hospitalDetail.bookAddressAppointment();
    }
    
    @Test
    public void testAllTabs() {
        hospitalDetail.clickSpecialists();
        hospitalDetail.clickPackages();
        hospitalDetail.clickFacilities();
        hospitalDetail.clickReviews();
        hospitalDetail.clickOverview();
    }
    
    @Test
    public void testBackButton() {
    	hospitalDetail.goBack();
    	hospitals.validatePage();
    }
    
    @Test
    public void testSpecialist() {
    	hospitalDetail.clickSpecialists();
    	hospitalDetail.testSpecialists();
    }
    
    @Test
    public void testRooms() {
    	hospitalDetail.testRooms();
    }
    
    @Test
    public void testReviews() {
    	hospitalDetail.testReviews();
    }
}
