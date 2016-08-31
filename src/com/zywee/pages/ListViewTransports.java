package com.zywee.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zywee.base.page.ListViewPage;
import com.zywee.leftnav.LeftNavPage;

  public class ListViewTransports extends ListViewPage {
	private static final By Name = null;
	protected String vehicleName;
	protected String description;
	protected String fee;
	protected String transportName;
	
	
	public ListViewTransports(WebDriver driver) {
		super(driver);
		setithItem(2);
		URL = URL + "/bangalore/transports";
	}

		public ListViewTransports(WebDriver driver,int transportNum) {
		super(driver, transportNum);
		}
		

		@Override
		protected void validatePageHeaders() {
			softAssert.assertTrue(getText(resultTitle).trim().contains("Transport"),"Title does not contain Transport");
			softAssert.assertTrue(getText(breadCrumb).trim().endsWith("Transport"),"Bread crumb does not end with Transport");
			try {
	            softAssert.assertAll();
	        } catch(AssertionError er) {
	        	addAssertionError(er.getMessage());
	        }
		}
		protected String getImage() {
			return super.hospBlock +  "div:nth-child(1) > div:nth-child(3) > div:nth-child(1) "+
					" div.col-md-6.padding_left_zero.aa > img";
		}
		
			@Override
			protected String getEntityName() {
				return super.hospBlock + "div:nth-child(2) > div.row.transport_row > div > div:nth-child(1) > " +
						"div.col-xs-5.transport_smartphone > div > div.col-lg-8 > h5";
			}
			
			@Override
			protected String getLocation() {
				return super.hospBlock + "div:nth-child(2) > div.row.transport_row > div > div:nth-child(1) > " +
						"div.col-xs-5.transport_smartphone > div > div.col-lg-4 > h5";
			}
			
			@Override
			protected String getRating() {
				return super.hospBlock + "div:nth-child(2) > div.row.transport_row > div > div:nth-child(1) > " +
						"div.col-xs-3.transport_smartphone > h5";
			}
			
			protected String getBookButton() {
				return super.hospBlock + " div:nth-child(5) > div > div > div:nth-child(3) > div > div:nth-child(2) > a > button";
			}
			

			@Override
			protected void setithItem(int index) {
				String startBlock = "#content > div.container-fluid.HOSPITAL > div > "
						+ "div.col-xs-9.right-box > div.render > div:nth-child(%d) > ";
				super.hospBlock = String.format(startBlock, index);
				transportName = super.hospBlock
						+ "div.row.transport_head > div.col-xs-7.transport_smartphone_heading > h4";
				description = super.hospBlock
						+"div:nth-child(2) >  div:nth-child(1) >  div:nth-child(3) > "+ "div:nth-child(3)> p ";
				fee = super.hospBlock
						+ "div:nth-child(2) > div.row.transport_row > div > div:nth-child(1) > "
						+ "div.col-xs-4.transport_smartphone > div > div:nth-child(1) > span.text1";
			}
			
			@Override
			public List<ListViewPage> getResultList() {
				List<ListViewPage> resultList = new ArrayList();
				numItems = driver.findElements(items).size();
				for(int i=2;i<=numItems;i+=2) {
					ListViewPage transport = new ListViewTransports(driver, i);
					resultList.add(transport);
				}
				return resultList;
			}

				@Override
				public void validatePage() {	
					super.validatePage();
					softAssert.assertTrue(isElementPresent(Name),"Service Provider Name not found");
					softAssert.assertTrue(isElementPresent(getImage()),"Transport Image not found");
					softAssert.assertTrue(isElementPresent(description),"Transport description not found");
					softAssert.assertTrue(isElementPresent(getImage()),"Vehicle Image not found");
					softAssert.assertTrue(isElementPresent(getEntityName()),"Hospital Name not found");
					softAssert.assertTrue(isElementPresent(getLocation()),"Transport location not found");
					softAssert.assertTrue(isElementPresent(getRating()),"Transport rating not found");
					softAssert.assertTrue(isElementPresent(fee),"Transport fee not found");
					softAssert.assertTrue(isElementPresent(getBookButton()),"Book button not found");
					try {
			            softAssert.assertAll();
			        } catch(AssertionError er) {
			        	addAssertionError(er.getMessage());
			        }
				}	
				
				public LeftNavPage getLeftNav() {
					LeftNavPage leftNav = new LeftNavPage(driver);
					return leftNav.getTransportLeftNav();
				}
				
				public ServiceProviderDetailPage clickTransportName() {
					driver.findElement(By.cssSelector(vehicleName)).click();
					return new ServiceProviderDetailPage(driver);
				}
				
				public AppointmentPage clickBookAppointment() {
					driver.findElement(By.cssSelector(getBookButton())).click();
					return new AppointmentPage(driver);
				}

			}

