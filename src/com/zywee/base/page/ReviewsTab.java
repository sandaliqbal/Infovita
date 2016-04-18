package com.zywee.base.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ReviewsTab extends PageBase {

	public ReviewsTab(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//#Reviews > div > div
	
	protected List<WebElement> reviewList = driver.findElements(By.cssSelector("div[class='row review_row']"));
	private String rating = "div.col-md-3 > div:nth-child(1) > span";
	private String reviewerName = "div.col-md-3 > div:nth-child(3) > p";
	private String reviewDate = "div.col-md-9 > div > div:nth-child(1) > p";
	private String reviewTitle = "div.col-md-9 > div > div:nth-child(2) > p";
	private String reviewText = "div.col-md-9 > div > div:nth-child(3) > p";
	
	public int getNumReviews() {
		return reviewList.size();
	}
	
	public void testReviews() {
		for(WebElement review:reviewList) {
			WebElement rate=review.findElement(By.cssSelector(rating));
			WebElement name=review.findElement(By.cssSelector(reviewerName));
			WebElement date=review.findElement(By.cssSelector(reviewDate));
			WebElement title=review.findElement(By.cssSelector(reviewTitle));
			WebElement text=review.findElement(By.cssSelector(reviewText));
			System.out.println(name.getText());
			System.out.println(date.getText());
			System.out.println(title.getText());
			System.out.println(text.getText());
		}
	}

}
