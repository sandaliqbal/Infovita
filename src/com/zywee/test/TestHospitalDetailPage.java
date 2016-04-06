package com.zywee.test;

import java.util.List;
import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.zywee.base.test.TestBase;
import com.zywee.pages.HospitalsDetailPage;
import com.zywee.pages.ListViewHospitals;
import com.zywee.tools.WaitTool;


public class TestHospitalDetailPage extends TestBase {

    private static WebDriver driver;
    private static ListViewHospitals hospitals;
    private static HospitalsDetailPage hospitalDetail;

    @Before
    public void setUp() throws Exception {
        init();
        driver = super.driver;
        hospitals = new ListViewHospitals(driver);
        hospitals.open();
        WaitTool.waitForPageLoad(driver);
        hospitalDetail = hospitals.gotoDetailPage();
    }

    @After
    public void tearDown() throws Exception {
        List<JavaScriptError> jsErrors = JavaScriptError.readErrors(driver);
        System.out.println("###start displaying errors");
        for(int i = 0; i < jsErrors.size(); i++)
        {
        System.out.println(jsErrors.get(i).getErrorMessage());
        System.out.println(jsErrors.get(i).getLineNumber());
        System.out.println(jsErrors.get(i).getSourceName());
        }
        System.out.println("###stop displaying errors");
        driver.close(); 
        driver.quit();
    }
    
    @Test
    public void testInformationTab() {
        hospitalDetail.validatePage();
        checkJSErrors();
    }
    
    @Test
    public void testAllTabs() {
        hospitalDetail.clickSpecialists();
        hospitalDetail.clickFacilities();
        hospitalDetail.clickRoomTariff();
        hospitalDetail.clickTreatmentPackages();
        hospitalDetail.clickInsurance();
    }
}
