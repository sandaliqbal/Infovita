package com.zywee.leftnav;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.base.page.ListViewPage;


public class LeftNavPage extends ListViewPage {
		
	private WebElement hideButton = driver.findElement(By.cssSelector("#desktop_filter"));
	private By sideBar = By.cssSelector("#sidebar");
	private CenterTypePage centerType;
	private ClinicChargePage clinicCharge;
	private DiagnosticChargePage diagCharge;
	private HospitalChargePage hospCharge;
	private PackageChargePage packCharge;
	private FacilityPage facilityPage;
	private SpecialityPage specialityPage;
	
	public LeftNavPage(WebDriver driver) {
		super(driver);
	}
	
	public LeftNavPage getHospitalLeftNav() {
		specialityPage = new SpecialityPage(driver);
		hospCharge = new HospitalChargePage(driver);
		facilityPage = new FacilityPage(driver);
		specialityPage.validate();
		hospCharge.validate();
		facilityPage.validate();
		return this;
	}
	
	public LeftNavPage getPackageLeftNav() {
		packCharge = new PackageChargePage(driver);
		centerType = new CenterTypePage(driver);
		return this;
	}
	
	public LeftNavPage getDiagnosticLeftNav() {
		diagCharge = new DiagnosticChargePage(driver);
		facilityPage = new DiagnosticFacilityPage(driver);
		return this;
	}
	
	public LeftNavPage getDoctorLeftNav() {
		packCharge = new PackageChargePage(driver);
		centerType = new CenterTypePage(driver);
		packCharge.setChargeHeading("Fee");
		packCharge.setChargeTypeText("Doctor");
		//packCharge.validate();
		return this;
	}
	
	public LeftNavPage getTestLeftNav() {
		packCharge = new PackageChargePage(driver);
		packCharge.setChargeTypeText("Test Charges");
		return this;
	}
	
	public LeftNavPage getClinicLeftNav() {
		clinicCharge = new ClinicChargePage(driver);
		facilityPage = new DiagnosticFacilityPage(driver);
		return this;
	}
	
	public void selectSpeciality(String specialityName) {
		specialityPage.selectCheckboxes(specialityName);
		validateSelection(specialityName);
	}
	
	public void selectCenterType(String centerTypeName) {
		centerType.selectCheckboxes(centerTypeName);
		validateSelection(centerTypeName);
	}
	
	public void selectFacility(String facilityName) {
		facilityPage.selectCheckboxes(facilityName);
		validateSelection(facilityName);
	}
	
	public void collapseLeftNav() {
		hideButton.click();
		//Assert.assertFalse("Side bar should  be hidden", isElementPresent(sideBar));
	}
}
