package com.zywee.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.zywee.base.page.ListViewPage;
import com.zywee.base.page.PageBase;
import com.zywee.tools.WaitTool;


public class ZyweeHomePage extends PageBase{
	
	private final static By searchDropdown = By.cssSelector("#search_sel");
	private final static By searchLocation = By.cssSelector("#location_srch");
	private final static By searchSpeciality = By.cssSelector("#hospital_cat_id");
	private final static By searchHospital = By.cssSelector("#hosp_name");
	private final static By searchButton = By.cssSelector("#search_query");
	private final static By searchButtonDiag = By.cssSelector("#search_query_diag"); 
	private final static By searchButtonClinic = By.cssSelector("#search_query_clinic");
	private final static By searchButtonPack = By.cssSelector("#search_query_pack");
	private final static By searchButtonDoc = By.cssSelector("#search_query_doc");
	private final static By searchButtonTest = By.cssSelector("#search_query_test");
	
	private final static By headerLogo =By.xpath("//img[@src='/img/images/zywee_logo.png']");
	private final static By helpline = By.cssSelector("#header > div.container-fluid.top-bar > div > span > span.text1.top_text_margin");
	private final static By emergency = By.cssSelector("#header > div.container-fluid.top-bar > div > span > span.review_heading");
	private final static By cityDropdown = By.cssSelector("#header > div > div > div.col-sm-8 > div > ul > li > select");
	private final static By menuButton = By.cssSelector("#menu");
	
	private final static By mostViewedhospitalsLink = By.cssSelector("#content > div:nth-child(5)");
	private final static By healthPackageLink = By.cssSelector("#content > div:nth-child(7)");
	private final static By commonTestsLink = By.cssSelector("#content > div:nth-child(9)");
	private final static By doctorsLink = By.cssSelector("#content > div:nth-child(11)");
	
	private final static By aboutUsLink = By.cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(1) > div:nth-child(2) > ul > li > span");
	private final static By fbLink = By.xpath("//img[@src='/img/images/facebook.png']");//cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(1) > div:nth-child(5) > ul > li:nth-child(1) > span");
	private final static By twitLink = By.xpath("//div[@id='footer']//ul//li//span//img[@src='/img/images/twitter.png']");//By.cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(1) > div:nth-child(5) > ul > li:nth-child(2) > span");
	private final static By googLink = By.xpath("//div[@id='footer']//ul//li//span//img[@src='/img/images/google.png']");
	private final static By blogLink = By.cssSelector("#footer > div > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > ul > li.top_blog > span > img");
	private final static By findHospLink = By.cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(2) > div:nth-child(2) > ul > li:nth-child(1) > span");
	private final static By findDocLink = By.cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(2) > div:nth-child(2) > ul > li:nth-child(2) > span");
	private final static By findClinicLink = By.cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(2) > div:nth-child(2) > ul > li:nth-child(3) > span");
	private final static By findDiagnosticLink = By.cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(2) > div:nth-child(2) > ul > li:nth-child(4) > span");
	private final static By findTreatmentLink = By.cssSelector("#footer > div > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(5) > span");
	private final static By findMedTestLink = By.cssSelector("#footer > div > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(6) > span");
	private final static By findTransportLink = By.cssSelector("#footer > div > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(7) > span");
	private final static By findEquipmentLink = By.cssSelector("#footer > div > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(8) > span");
	private final static By findHomeServicesLink = By.cssSelector("#footer > div > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(9) > span");
	private final static By addHospLink = By.cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(1) > span");
	private final static By advertizeLink = By.cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(2) > span");
	private final static By termsLink = By.cssSelector("#footer > div > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > ul > li:nth-child(1) > span");
	private final static By privacyLink = By.cssSelector("#footer > div > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > ul > li:nth-child(2) > span");
	private final static By certLink = By.cssSelector("#footer > div.container-fluid.footer > div > div:nth-child(3) > div:nth-child(6) > div > a > img");
	private final static By footerTM = By.cssSelector("body > div.container-fluid > div > p");
	
	private final static By facebookLink = By.cssSelector("#content > div.container-fluid.blue_back > div > div > div > div.row.social_media.aa > ul > li:nth-child(1) > span > img");
	private final static By gplusLink = By.cssSelector("#content > div.container-fluid.blue_back > div > div > div > div.row.social_media.aa > ul > li:nth-child(2) > span > img");
	private final static By twitterLink = By.cssSelector("#content > div.container-fluid.blue_back > div > div > div > div.row.social_media.aa > ul > li:nth-child(3) > span > img");
	
	private final static By questionFlyout = By.cssSelector("body > div > div > div > div.meshim_widget_components_chatButton_Bubble.bubble > div > div > div.jx_ui_Widget.bubble_title");
	private final static By chatFlyout = By.cssSelector("body > div > div > div > div.meshim_widget_components_chatButton_Button.ltr > div > div.border_overlay.meshim_widget_widgets_BorderOverlay");
	
	private final static By menuItems = By.cssSelector("#header > div:nth-child(5) > div > div > div.container-fluid.dropdown_menu > div");
	private final static By healthcenter = By.cssSelector("#menu_head1 > h2");
	private final static By menuitemHosp = By.cssSelector("#menu_content1 > div > ul > li:nth-child(1) > span");
	private final static By menuitemDiag = By.cssSelector("#menu_content1 > div > ul > li:nth-child(2) > span");
	private final static By menuitemClinics = By.cssSelector("#menu_content1 > div > ul > li:nth-child(3) > span");
	private final static By healthservice = By.cssSelector("#menu_head2 > h2");
	private final static By docAppointment = By.cssSelector("#menu_content2 > div > ul > li:nth-child(1) > span");
	private final static By healthpackBooking = By.cssSelector("#menu_content2 > div > ul > li:nth-child(2) > span");
	private final static By medTestScheduling = By.cssSelector("#menu_content2 > div > ul > li:nth-child(3) > span");
	private final static By healthTools = By.cssSelector("#menu_head4 > h2");
	private final static By appLink = By.cssSelector("#menu_content4 > div > ul > li > span");
	
	private final static By resultCount = By.cssSelector("#content > div.container-fluid.Ab > div > div.col-sm-3.no_of_hosp");
	
	private static Map<String,String> headerLinks = new HashMap<String,String>();
	private static Map<String,String> footerLinks = new HashMap<String,String>();
	
	private List<String> brokenUrls = new ArrayList();
	
	public ZyweeHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void validatePage() {
		softAssert.assertTrue(isPageLoad(),"expected: "+pageTitle+" got: "+driver.getTitle());	
		softAssert.assertTrue(isElementPresent(searchDropdown),"search dropdown not found");
		softAssert.assertTrue(isElementPresent(searchLocation),"search location not found");
		softAssert.assertTrue(isElementPresent(searchSpeciality),"search speciality not found");
		softAssert.assertTrue(isElementPresent(searchHospital),"search hospital not found");
		softAssert.assertTrue(isElementPresent(searchButton),"search button not found");
		softAssert.assertTrue(isElementPresent(facebookLink),"facebook link not found");
		softAssert.assertTrue(isElementPresent(gplusLink),"googleplus link not found");
		softAssert.assertTrue(isElementPresent(twitterLink),"twitter link not found");
		softAssert.assertTrue(isElementPresent(mostViewedhospitalsLink),"Block for most viewed hospitals not found");
		softAssert.assertTrue(isElementPresent(healthPackageLink),"Block for health packages not found");
		softAssert.assertTrue(isElementPresent(mostViewedhospitalsLink),"Block for most viewed hospitals not found");
		softAssert.assertTrue(isElementPresent(commonTestsLink),"Block for common tests not found");
		softAssert.assertTrue(isElementPresent(doctorsLink),"Block for doctors not found");
		try {
		    softAssert.assertAll();
		} catch (AssertionError er) {
		    addAssertionError(er.getMessage());
		}
		validateHeader();
		validateSearchOptions();
		//softAssert.assertTrue(isElementPresent(By.cssSelector(questionFlyout)),"Questions popup not found");
		//softAssert.assertTrue(isElementPresent(By.cssSelector(chatFlyout)),"Chat popup not found");
		validateFooter();
	}
	
	public static void validateHeader() {
	    Assert.assertTrue(isElementPresent(headerLogo),"header logo not found");
	    Assert.assertTrue(isElementPresent(helpline),"helpline number not found");
	    Assert.assertTrue(isElementPresent(emergency),"emergency number not found");
        Assert.assertTrue(isElementPresent(cityDropdown),"city dropdown not found");
        Assert.assertTrue(isElementPresent(menuButton),"menu button not found");
        /*
		for (Map.Entry<String, String> entry : headerLinks.entrySet())
		{
		    softAssert.assertTrue(isElementPresent(By.cssSelector(entry.getValue())),entry.getValue() + " not found");
		}
		*/
	}
	
	public static void validateFooter() {
	    Assert.assertTrue(isElementPresent(aboutUsLink),"About Us link  in footer not found");
	    Assert.assertTrue(isElementPresent(fbLink),"Facebook link in footer not found");
	    Assert.assertTrue(isElementPresent(twitLink),"Twitter link in footer not found");
	    Assert.assertTrue(isElementPresent(googLink),"Google plus link in footer not found");
	    Assert.assertTrue(isElementPresent(blogLink),"Blog link in footer not found");
	    Assert.assertTrue(isElementPresent(findHospLink),"Find Hospitals link in footer not found");
	    Assert.assertTrue(isElementPresent(findDocLink),"Find Doctors link in footer not found");
	    Assert.assertTrue(isElementPresent(findClinicLink),"Find Clinics link in footer not found");
	    Assert.assertTrue(isElementPresent(findDiagnosticLink),"Find Diagnostic Centers link in footer not found");
	    Assert.assertTrue(isElementPresent(findTreatmentLink),"Find Treatment Packages link in footer not found");
	    Assert.assertTrue(isElementPresent(findMedTestLink),"Find Medical Tests link in footer not found");
	    Assert.assertTrue(isElementPresent(findTransportLink),"Find Transport link in footer not found"); 
	    Assert.assertTrue(isElementPresent(findEquipmentLink),"Find Equipment link in footer not found");
	    Assert.assertTrue(isElementPresent(findHomeServicesLink),"Find Home Services link in footer not found");
	  
	    Assert.assertTrue(isElementPresent(addHospLink),"Add hospital link in footer not found");
	    Assert.assertTrue(isElementPresent(advertizeLink),"Advertize link in footer not found");
	    Assert.assertTrue(isElementPresent(termsLink),"Terms of Use link in footer not found");
	    Assert.assertTrue(isElementPresent(privacyLink),"Privacy link in footer not found");
	    // TODO: Check Assert.assertTrue(isElementPresent(certLink),"Certificate link in footer not found");
	    Assert.assertTrue(isElementPresent(footerTM),"Trademark in footer not found");
	    /*
		for (Map.Entry<String, String> entry : footerLinks.entrySet())
		{
		    softAssert.assertTrue(isElementPresent(By.cssSelector(entry.getValue())));
		}
		*/
	}
	
	public void validateMenu() {
	    driver.findElement(menuButton).click();
	    softAssert.assertTrue(isElementPresent(menuItems),"Menu not found!");
	    softAssert.assertTrue(isElementPresent(healthcenter),"Health Centers not found!");
	    softAssert.assertTrue(isElementPresent(menuitemHosp),"Hospitals not found!");
	    softAssert.assertTrue(isElementPresent(menuitemDiag),"Diagnostics not found!");
	    softAssert.assertTrue(isElementPresent(menuitemClinics),"Clinics not found!");
	    softAssert.assertTrue(isElementPresent(healthservice),"Health Services not found!");
	    softAssert.assertTrue(isElementPresent(docAppointment),"Doctor Appointment not found!");
	    softAssert.assertTrue(isElementPresent(healthpackBooking),"Heatlth package booking not found!");
	    softAssert.assertTrue(isElementPresent(medTestScheduling),"Medical Test Scheduling not found!");
	    softAssert.assertTrue(isElementPresent(healthTools),"Health Tools not found!");
	    softAssert.assertTrue(isElementPresent(appLink),"Zywee app link not found!");
	    try {
            softAssert.assertAll();
        } catch (AssertionError er) {
        	addAssertionError(er.getMessage());
        }
	}
	
	public void validateSearch() {
	    Select dropdown = new Select(driver.findElement(searchDropdown));
	    dropdown.selectByVisibleText("Search Hospitals");
	    driver.findElement(searchLocation).click();
	    driver.findElement(searchLocation).sendKeys("Bellandur");
	    driver.findElement(searchSpeciality).click();
	    driver.findElement(searchSpeciality).sendKeys("Eye Hospitals");
	    ListViewPage hospPage = clickSearchHospitals();
	    hospPage.validatePage();
	}
	
	public ListViewPage clickSearchHospitals() {
	    Select dropdown = new Select(driver.findElement(searchDropdown));
        dropdown.selectByVisibleText("Search Hospitals");
	    driver.findElement(searchButton).click();
        WaitTool.waitForPageLoad(driver);
        return new ListViewHospitals(driver);
	}
	
	public ListViewPage clickSearchDiagnostics() {
	    Select dropdown = new Select(driver.findElement(searchDropdown));
        dropdown.selectByVisibleText("Search Diagnostics");
	    driver.findElement(searchButtonDiag).click();
        WaitTool.waitForPageLoad(driver);
        return new ListViewDiagnostics(driver);
	}
	
	public ListViewPage clickSearchClinics() {
	    Select dropdown = new Select(driver.findElement(searchDropdown));
        dropdown.selectByVisibleText("Search Clinics");
	    driver.findElement(searchButtonClinic).click();
        WaitTool.waitForPageLoad(driver);
        return new ListViewClinics(driver);
	}
	
	public ListViewPage clickSearchPackages() {
	    Select dropdown = new Select(driver.findElement(searchDropdown));
        dropdown.selectByVisibleText("Search Packages");
	    driver.findElement(searchButtonPack).click();
        WaitTool.waitForPageLoad(driver);
        return new ListViewPackages(driver);
	}
	
	public ListViewPage clickSearchDoctors() {
	    Select dropdown = new Select(driver.findElement(searchDropdown));
        dropdown.selectByVisibleText("Search Doctors");
	    driver.findElement(searchButtonDoc).click();
        WaitTool.waitForPageLoad(driver);
        return new ListViewDoctors(driver);
	}
	
	public ListViewPage clickSearchTests() {
	    Select dropdown = new Select(driver.findElement(searchDropdown));
        dropdown.selectByVisibleText("Search Tests");
	    driver.findElement(searchButtonTest).click();
        WaitTool.waitForPageLoad(driver);
        return new ListViewTests(driver);
	}
	
	public void verifyPageLinks() {
	    List<WebElement> anchorTags = getAnchorLinks();
		for (WebElement element: anchorTags) {
			String href = element.getAttribute("href");
			try {
				if (href.startsWith("http")) {
					verifyLinkActive((href));
				} else {
					String url = URL + href;
					verifyLinkActive((url));
				}
			} catch (NotFoundException ex) {
				brokenUrls.add(ex.getMessage());
			}
		}
		List<WebElement> otherLinks = getOtherLinks();
		String pattern = "'(.*)'";
		Pattern pat = Pattern.compile(pattern);
		for (WebElement element: otherLinks) {   
		    Matcher m = pat.matcher(element.getAttribute("onclick"));
		    String suburl = "";
		    if(m.find()) {
		        suburl = m.group(1);
		    }
		    try {
		    if (suburl.startsWith("http")) {
                verifyLinkActive((suburl));
            } else {
                String url = URL + suburl;
                verifyLinkActive((url));
            }
		    } catch (NotFoundException ex) {
                brokenUrls.add(ex.getMessage());
            }
        }
		/*
		for (Map.Entry<String, String> entry : footerLinks.entrySet()) {
			String href = driver.findElement(By.cssSelector(entry.getValue()))
					.getAttribute("href");
			try {
				if (href.startsWith("http")) {
					verifyLinkActive((href));
				} else {
					String url = URL + href;
					verifyLinkActive((url));
				}
			} catch (NotFoundException ex) {
				brokenUrls.add(ex.getMessage());
			}
		}
		*/
		if(!brokenUrls.isEmpty()) {
			System.out.println("Broken links on the page:");
			for(String url:brokenUrls) {
				System.out.println(url);
			}
		}
	}
	
	private List<WebElement> getAnchorLinks() {
	    return driver.findElements(By.tagName("a"));
	}
	
	private List<WebElement> getOtherLinks() {
        return driver.findElements(By.cssSelector("*[onclick]"));
    }
	
	private void validateSearchOptions() {
		Select dropdown = new Select(driver.findElement(searchDropdown));
		List<WebElement> selectList = dropdown.getOptions();
		List<String> options = new ArrayList<String>();
		for(WebElement element:selectList) {
			options.add(element.getText().trim());
		}
		softAssert.assertEquals(options.size(),6,"There should be 6 options in the dropdown");
		softAssert.assertTrue(options.contains("Search Hospitals"), "Search Hospitals option not found");
		softAssert.assertTrue(options.contains("Search Packages"), "Search Packages option not found");
		softAssert.assertTrue(options.contains("Search Diagnostics"), "Search Diagnostics option not found");
		softAssert.assertTrue(options.contains("Search Doctors"), "Search Doctors option not found");
		softAssert.assertTrue(options.contains("Search Tests"), "Search Tests option not found");
		softAssert.assertTrue(options.contains("Search Clinics"), "Search Clinics option not found");
		try {
            softAssert.assertAll();
        } catch (AssertionError er) {
        	addAssertionError(er.getMessage());
        }
	}

}
