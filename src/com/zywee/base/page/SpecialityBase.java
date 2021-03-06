package com.zywee.base.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zywee.tools.WaitTool;

public abstract class SpecialityBase extends PageBase {

	public SpecialityBase(WebDriver driver) {
		super(driver);
	}
	
	private WebElement title = getSpecialityTitle();
	private WebElement collapseButton = getCollapseButton();
	private String items = getItems();
	private List<WebElement> list = driver.findElements(By.cssSelector(items));
	
	public abstract WebElement getSpecialityTitle();
	public abstract WebElement getCollapseButton();
	public abstract String getItems();
	public abstract String getTitleText();
	
	public void validate() {
		softAssert.assertTrue(title.isDisplayed(),"Title should be displayed");
		softAssert.assertTrue(getSpecialityTitle().getText().trim().contains(getTitleText()),
				"Title should contain " + getTitleText());
		softAssert.assertTrue(collapseButton.isDisplayed(),"Expand/Collapse should be displayed");
		softAssert.assertFalse(list.isEmpty(),"No options found for Specialities");
		try {
		    softAssert.assertAll();
		} catch(AssertionError er) {
			addAssertionError(er.getMessage());
		}
	}
	
	public void getCheckboxes() {
		for(WebElement elt:list) {
			System.out.println(elt.getText());
		}
	}
	
	public void selectCheckboxes(String optionName) {
		WebElement checkbox=null;
		for(WebElement elt:list) {
			if(elt.getText().equals(optionName)) {
				checkbox = elt.findElement(By.tagName("input"));
				checkbox.click();
				softAssert.assertTrue(checkbox.isSelected(),"Checkbox should be selected");
				try {
				    softAssert.assertAll();
				} catch(AssertionError er) {
					addAssertionError(er.getMessage());
				}
				WaitTool.waitForJQueryProcessing(driver, 30);
				break;
			}
		}
		if (checkbox == null) {
			Assert.fail(optionName+" option could not be found");
		}
	}
	
	public void clickCollapse() {
		getCollapseButton().click();
	}

}
