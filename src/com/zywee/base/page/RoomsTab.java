package com.zywee.base.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class RoomsTab extends PageBase {

	public RoomsTab(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected List<WebElement> roomList = driver.findElements(By.cssSelector("#Rooms > div"));
	private String cost = "div > div.col-sm-4 > span";
	private String desc = "div > div.col-sm-8.packages_smartphone_heading";
	
	public int getNumRooms() {
		return roomList.size();
	}
	
	public void checkRoomPrices() {
		for(WebElement room:roomList) {
			WebElement price = room.findElement(By.cssSelector(cost));
			WebElement roomdesc = room.findElement(By.cssSelector(desc));
			System.out.println(price.getText());
			System.out.println(roomdesc.getText());
		}
	}
}
