package com.zywee.leftnav;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zywee.base.page.ListViewPage;
import com.zywee.base.page.PageBase;
import com.zywee.tools.WaitTool;


public class LeftNavPage extends PageBase {
	
	
	private static final String catBlock = "#serarch-left > div:nth-child(1) > ";
	private static final String categoryTitle = catBlock + "div.content-module-heading.cf > div";
	private static final String catExpand  = catBlock + "div.content-module-heading.cf > " +
			"span.fr.expand-collapse-text.initial-expand";
	private static final String catCollapse = catBlock + "div.content-module-heading.cf > span:nth-child(2)";
	private static final String catCheckbox = catBlock + "div.content-module-main.cf > label";
	
	private static final String facBlock = "#serarch-left > div:nth-child(2) > ";
	private static final String facilityTitle = facBlock + "div.content-module-heading.cf > div";
	private static final String facExpand = facBlock + "div.content-module-heading.cf > " +
			"span.fr.expand-collapse-text.initial-expand";
	private static final String facCollapse = facBlock + "div.content-module-heading.cf > span:nth-child(2)";
	private static final String facCheckbox = facBlock + "div.content-module-main.cf > label";
	
	private static final String costCatBlock = "#serarch-left > div:nth-child(3) > ";
	private static final String costCatTitle = costCatBlock + "div.content-module-heading.cf > div";
	private static final String costCatExpand = costCatBlock + "div.content-module-heading.cf > " +
			"span.fr.expand-collapse-text.initial-expand";
	private static final String costCatCollapse = costCatBlock + "div.content-module-heading.cf > span:nth-child(2)";
	private static final String costCatCheckbox = costCatBlock + "div.content-module-main.cf > label";
	
	private static final String specialityBlock = "#serarch-left > div:nth-child(4) > ";
	private static final String specialityTitle = specialityBlock + "div.content-module-heading.cf > div";
	private static final String specialityExpand = specialityBlock + "div.content-module-heading.cf > " +
			"span.fr.expand-collapse-text.initial-expand";
	private static final String specialityCollapse = specialityBlock + "div.content-module-heading.cf > " +
			"span:nth-child(2)";
	private static final String specialityCheckbox = specialityBlock + "div.content-module-main.cf > label";
	
	private WebElement hideButton = driver.findElement(By.cssSelector("#desktop_filter"));
	private By sideBar = By.cssSelector("#sidebar");
	private CenterTypePage centerType;// = new CenterTypePage(driver);
	private ClinicChargePage clinicCharge;// = new ClinicChargePage(driver);
	private DiagnosticChargePage diagCharge;// = new DiagnosticChargePage(driver);
	private HospitalChargePage hospCharge;
	private PackageChargePage packCharge;// = new PackageChargePage(driver);
	private FacilityPage facilityPage;
	private SpecialityPage specialityPage;
	
	public LeftNavPage(WebDriver driver) {
		super(driver);
	}
	
	public static void validateLeftNav() {
		validateCategory();
		validateCostCategory();
		validateFacility();
		validateSpeciality();
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
	}
	
	public void selectCenterType(String centerTypeName) {
		centerType.selectCheckboxes(centerTypeName);
	}
	
	public void selectFacility(String facilityName) {
		facilityPage.selectCheckboxes(facilityName);
	}
	
	public void collapseLeftNav() {
		hideButton.click();
		//Assert.assertFalse("Side bar should  be hidden", isElementPresent(sideBar));
	}
	
	public static void validateCategory() {
		Assert.assertTrue(isElementPresent(categoryTitle));
		Assert.assertTrue(isElementPresent(catExpand));
		Assert.assertTrue(isElementPresent(catCollapse));
		Assert.assertTrue(isElementPresent(catCheckbox));
	}
	
	public static void validateFacility() {
		Assert.assertTrue(isElementPresent(facilityTitle));
		Assert.assertTrue(isElementPresent(facExpand));
		Assert.assertTrue(isElementPresent(facCollapse));
		Assert.assertTrue(isElementPresent(facCheckbox));
	}
	
	public static void validateCostCategory() {
		Assert.assertTrue(isElementPresent(costCatTitle));
		Assert.assertTrue(isElementPresent(costCatExpand));
		Assert.assertTrue(isElementPresent(costCatCollapse));
		Assert.assertTrue(isElementPresent(costCatCheckbox));
	}
	
	public static void validateSpeciality() {
		Assert.assertTrue(isElementPresent(specialityTitle));
		Assert.assertTrue(isElementPresent(specialityExpand));
		Assert.assertTrue(isElementPresent(specialityCollapse));
		Assert.assertTrue(isElementPresent(specialityCheckbox));
	}
	
	public static void clickExpandCollapse() {
		driver.findElement(By.cssSelector(catExpand)).click();
		driver.findElement(By.cssSelector(facExpand)).click();
		driver.findElement(By.cssSelector(costCatExpand)).click();
		driver.findElement(By.cssSelector(specialityExpand)).click();
		Assert.assertTrue(driver.findElement(By.cssSelector(catCollapse)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(facCollapse)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(costCatCollapse)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(specialityCollapse)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(catExpand)).isDisplayed());
		findCategoryCheckboxes();
	}
	
	public static void selectMultiSpeciality() {
		clickCheckbox(findCategoryCheckboxes(),0,"Multi Speciality");
		validateResult("Multi Speciality");
	}

	public static void unselectMultiSpeciality() {
		clickCheckbox(findCategoryCheckboxes(),0,"Multi Speciality");
	}
	
	public static void selectSuperSpeciality() {
		clickCheckbox(findCategoryCheckboxes(),1,"Super Speciality");
		validateResult("Super Speciality");
	}
	
	public static void unselectSuperSpeciality() {
		clickCheckbox(findCategoryCheckboxes(),1,"Super Speciality");
	}
	
	public static void selectGeneral() {
		clickCheckbox(findCategoryCheckboxes(),2,"General");
		validateResult("General");
	}
	
	public static void unselectGeneral() {
		clickCheckbox(findCategoryCheckboxes(),2,"General");
	}
	
	public static void selectAmbulance() {
		clickCheckbox(findFacilityCheckboxes(),0,"Ambulance Service");
		validateFacilityResult(1, "Ambulance Available");
	}

	public static void unselectAmbulance() {
		clickCheckbox(findFacilityCheckboxes(),0,"Ambulance Service");
	}
	
	public static void selectLab() {
		clickCheckbox(findFacilityCheckboxes(),1,"In House Laboratory");
		validateFacilityResult(2, "Laboratory Available");
	}

	public static void unselectLab() {
		clickCheckbox(findFacilityCheckboxes(),1,"In House Laboratory");
	}
	
	public static void selectPharmacy() {
		clickCheckbox(findFacilityCheckboxes(),2,"Pharmacy");
		validateFacilityResult(3, "Pharmacy Available");
	}

	public static void unselectPharmacy() {
		clickCheckbox(findFacilityCheckboxes(),2,"Pharmacy");
	}
	
	public static void selectBloodBank() {
		clickCheckbox(findFacilityCheckboxes(),3,"Blood Bank");
		validateFacilityResult(5, "Blood Bank Available");
	}

	public static void unselectBloodBank() {
		clickCheckbox(findFacilityCheckboxes(),3,"Blood Bank");
	}
	
	public static void selectICU() {
		clickCheckbox(findFacilityCheckboxes(),4,"ICU");
		//validateResult("Multi Speciality");
	}

	public static void unselectICU() {
		clickCheckbox(findFacilityCheckboxes(),4,"ICU");
	}
	
	public static void selectOperationTheatre() {
		clickCheckbox(findFacilityCheckboxes(),5,"Operation Theatre");
		//validateResult("Multi Speciality");
	}

	public static void unselectOperationTheatre() {
		clickCheckbox(findFacilityCheckboxes(),5,"Operation Theatre");
	}
	
	public static void selectEyeBank() {
		clickCheckbox(findFacilityCheckboxes(),6,"Eye Bank");
		//validateResult("Multi Speciality");
	}

	public static void unselectEyeBank() {
		clickCheckbox(findFacilityCheckboxes(),6,"Eye Bank");
	}
	
	public static void selectATM() {
		clickCheckbox(findFacilityCheckboxes(),7,"ATM");
		//validateResult("Multi Speciality");
	}

	public static void unselectATM() {
		clickCheckbox(findFacilityCheckboxes(),7,"ATM");
	}
	
	public static void selectCafeteria() {
		clickCheckbox(findFacilityCheckboxes(),8,"Cafeteria");
		validateFacilityResult(4, "Cafeteria Available");
	}

	public static void unselectCafeteria() {
		clickCheckbox(findFacilityCheckboxes(),8,"Cafeteria");
	}
	
	public static void selectParking() {
		clickCheckbox(findFacilityCheckboxes(),9,"Parking");
		//validateResult("Multi Speciality");
	}

	public static void unselectParking() {
		clickCheckbox(findFacilityCheckboxes(),9,"Parking");
	}
	
	public static void selectCost100To1000() {
		clickCheckbox(findCostCatCheckboxes(),0,"Rs 101 - Rs 1000");
		validateCostCatResult("Rs 101 - Rs 1000");
	}

	public static void unselectCost100To1000() {
		clickCheckbox(findCostCatCheckboxes(),0,"Rs 101 - Rs 1000");
	}
	
	public static void selectCost1001To5000() {
		clickCheckbox(findCostCatCheckboxes(),1,"Rs 1001 - Rs 5000");
		validateCostCatResult("Rs 1001 - Rs 5000");
	}

	public static void unselectCost1001To5000() {
		clickCheckbox(findCostCatCheckboxes(),1,"Rs 1001 - Rs 5000");
	}
	
	public static void selectCancer() {
		clickCheckbox(findSpecialityCheckboxes(),0,"Cancer");
	}

	public static void unselectCancer() {
		clickCheckbox(findSpecialityCheckboxes(),0,"Cancer");
	}
	
	public static void selectEyeCare() {
		clickCheckbox(findSpecialityCheckboxes(),1,"Eye Care");
	}

	public static void unselectEyeCare() {
		clickCheckbox(findSpecialityCheckboxes(),1,"Eye Care");
	}
	
	public static void selectMaternity() {
		clickCheckbox(findSpecialityCheckboxes(),2,"Maternity");
	}
	
	public static void unselectMaternity() {
		clickCheckbox(findSpecialityCheckboxes(),2,"Maternity");
	}

	public static void selectCardiac() {
		clickCheckbox(findSpecialityCheckboxes(),3,"Cardiac");
	}
	
	public static void unselectCardiac() {
		clickCheckbox(findSpecialityCheckboxes(),3,"Cardiac");
	}
	

	public static void selectOrtho() {
		clickCheckbox(findSpecialityCheckboxes(),4,"Ortho");
	}

	public static void unselectOrtho() {
		clickCheckbox(findSpecialityCheckboxes(),4,"Ortho");
	}
	
	private static void clickCheckbox(List<WebElement> checkboxList, int id, String category) {
		WebElement checkbox = checkboxList.get(id);
		Assert.assertEquals(checkbox.getText(),category);
		checkbox.click();
		WaitTool.waitForJQueryProcessing(driver, 60);
	}
	
	private static void validateResult(String category) {
		List<ListViewPage> hospitals = null;// ListViewPage.getHospitalList();
		Assert.assertNotEquals("No results found",hospitals.size(),0);
		for (ListViewPage hosp:hospitals) {
			Assert.assertTrue("Correct category not found",getText(hosp.getTitle()/*.category*/).contains(category));
		}
	}
	
	private static void validateFacilityResult(int faccilityId,String facilityTitle) {
		List<ListViewPage> hospitals = null;// ListViewPage.getHospitalList();
		Assert.assertNotEquals("No results found",hospitals.size(),0);
		for (ListViewPage hosp:hospitals) {
			String locator = null;//hosp.facilityAmbulance.replace("child(1)", String.format("child(%d)",faccilityId));
			WebElement element = driver.findElement(By.cssSelector(locator));
			WebElement parent = element.findElement(By.xpath("..")); 
			Assert.assertTrue("Correct facility not found",element.isDisplayed());
			Assert.assertTrue("Correct facility not found",element.getAttribute("title").equals(facilityTitle));
			Assert.assertTrue("Correct facility not found",parent.getAttribute("class").equals("icons-siact"));
		}
	}
	
	private static void validateCostCatResult(String costCategory) {
		List<ListViewPage> hospitals = null;// ListViewPage.getHospitalList();
		String range = costCategory.replaceAll("Rs", "");
		int index = range.indexOf('-');
		int min = Integer.parseInt(range.substring(0, index).trim());
		int max = Integer.parseInt(range.substring(index+1, range.length()).trim());
		Assert.assertNotEquals("No results found",hospitals.size(),0);
		for (ListViewPage hosp:hospitals) {
			String consultFee = getText(hosp.getTitle()/*.consultFee*/);
			Assert.assertNotNull("Consult fee not found",consultFee);
			int fee = Integer.parseInt(consultFee.replaceAll("\\D+",""));
			Assert.assertTrue("consult fee should lie in the range",fee<=max && fee >=min);
		}
	}
	
	private static void validateResult(List<String> category) {
		List<ListViewPage> hospitals = null;//ListViewPage.getHospitalList();
		Assert.assertNotEquals("No results found",hospitals.size(),0);
		for (ListViewPage hosp:hospitals) {
			Assert.assertTrue("Correct category not found",category.contains(getText(hosp.getTitle()/*.category*/)));
		}
	}
	
	private static List<WebElement> findCategoryCheckboxes() {
		List<WebElement> catCheckboxes = driver.findElements(By.cssSelector(catCheckbox));
		return catCheckboxes;
	}
	
	private static List<WebElement> findFacilityCheckboxes() {
		List<WebElement> facCheckboxes = driver.findElements(By.cssSelector(facCheckbox));
		return facCheckboxes;
	}
	
	private static List<WebElement> findCostCatCheckboxes() {
		List<WebElement> facCheckboxes = driver.findElements(By.cssSelector(costCatCheckbox));
		return facCheckboxes;
	}

	private static List<WebElement> findSpecialityCheckboxes() {
		List<WebElement> facCheckboxes = driver.findElements(By.cssSelector(specialityCheckbox));
		return facCheckboxes;
	}
}
