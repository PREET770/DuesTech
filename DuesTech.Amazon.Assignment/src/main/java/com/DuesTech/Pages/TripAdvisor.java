package com.DuesTech.Pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.DuesTech.Utility.WebActionUtil;

public class TripAdvisor extends com.DuesTech.Library.BasePage {

	public TripAdvisor(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// clicking on search button top corner
			@FindBy(xpath = "//div[@title='Search']/span[text()='Search']")
			private WebElement clickOnSearch;
			// typing text in search box
			@FindBy(xpath = "//div[@class='input_box activeInput']//input[@id='mainSearch']")
			private WebElement clickOnMainSearchTextBtn;
			// clicking search button
			@FindBy(xpath = "//div[@class='ui_column is-2 search_line_block is-gapless']/button[@id='SEARCH_BUTTON']")
			private WebElement clickOnMainSearch;
			// clicking search result which is coming first
			@FindBy(xpath = "//div[@class='result-title']/span[contains(.,'Madikeri')]")
			private WebElement clickOnFirstElement;
			// clicking on writing review
			@FindBy(xpath = "//div[@class='was-ssr-only']//div[@class='hotels-community-content-common-ContextualCTA__currentOption--3Wd5D']/a[contains(text(),'Write a review')]")
			private WebElement clickOnWriteReview;
			// selecting overall rating
			@FindBy(xpath = "//div[@class='easyClear bigRatingParent']/span[@id='bubble_rating']")
			private WebElement clickRating;
			// selecting 5 rating
			@FindBy(xpath = "//span[@id='bubble_rating']/img")
			private WebElement clickOnRating5;
			// selecting 5 rating in hotel ratings
			@FindBy(xpath = "//span[@id='qid12_bubbles']/img")
			private WebElement clickHotelRating5;

			// typing title of your review
			@FindBy(xpath = "//div[@id='REVIEW_TITLE']/input[@id='ReviewTitle']")
			private WebElement titleYourReview;
			// typing of your review
			@FindBy(xpath = "//div[@id='REVIEW_TEXT']/textarea[@id='ReviewText']")
			private WebElement YourReview;

			// selecting check box in submit your review
			@FindBy(xpath = "//div[@class='willing ']/input[@id='noFraud']")
			private WebElement checkboxSelectReview;
				
		public void tripAdvisor1()
		{
				WebActionUtil.sleep(600);
				WebActionUtil.clickOnElement(clickOnSearch, "clickingOnSearch");
				WebActionUtil.sleep(700);
				System.out.println(clickOnMainSearchTextBtn.isDisplayed());
				WebActionUtil.SendKeys(clickOnMainSearchTextBtn, "Club Mahindra", "typing clubmahindra");
				WebActionUtil.clickOnElement(clickOnMainSearch, "clicking on search");
				WebActionUtil.sleep(900);
				WebActionUtil.clickOnElement(clickOnFirstElement, "selecting first visibility search result");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				// navigating to next tab
				driver.switchTo().window(tabs2.get(1));
				WebActionUtil.sleep(700);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).perform();
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,2750)");
				WebActionUtil.sleep(200);

				WebActionUtil.clickOnElement(clickOnWriteReview, "Writing the review");
				ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
				// navigating to next tab
				driver.switchTo().window(tabs3.get(2));

				action.moveToElement(clickOnRating5, 155, 0).click().build().perform();
				WebActionUtil.SendKeys(titleYourReview, "Wonderful stay", "typing your review");
				WebActionUtil.SendKeys(YourReview,"We liked the hotel, personal, and particularly Furkan and Dilip and Kontal from housekeeping. Room service was very well, kitchen was very tasty. Swimming pool was clean, towels always fresh. "+ "Recommend everybody to visit",	"typing review");
				jse.executeScript("window.scrollBy(0,1250)");
				action.moveToElement(clickHotelRating5, 115, 32).click().build().perform();
				jse.executeScript("window.scrollBy(0,1450)");
				WebActionUtil.clickOnElement(checkboxSelectReview, "selecting check box");
		}
	}
	


