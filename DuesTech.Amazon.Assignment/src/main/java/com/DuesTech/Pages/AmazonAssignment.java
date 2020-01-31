package com.DuesTech.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.DuesTech.Library.BasePage;
import com.DuesTech.Utility.WebActionUtil;

public class AmazonAssignment extends BasePage {

	public AmazonAssignment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

  // Click on search box	
	@FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
	private WebElement productSerchTextBox;

	// clicking on search button
	//
	@FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']/descendant::input[@type='submit']")
	private WebElement productSerchButton;
	// getting on list of releated products
	
	@FindBy(xpath = "//div[@class='a-section a-spacing-none']/h2/a[@class='a-link-normal a-text-normal']/span[text()='Apple iPhone XR (64GB) - Yellow']")
	private WebElement productDetail;
	// get the price
	@FindBy(xpath = "//span[@id='priceblock_ourprice']")
	private WebElement price;
	//Click on Flipkart Cross Button
	@FindBy(xpath="//div[@class='_3Njdz7']/button[@class='_2AkmmA _29YdH8']")
	private WebElement Crossbtn;
	// typing product name in search text box flipkart
	@FindBy(xpath = "//div[@class='O8ZS_U']/input[@title='Search for products, brands and more']")
	private WebElement IPhoneX;
	//Click on searchbtn;
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement ClickonSearch;
	//Click on Iphone 
	@FindBy(xpath="//div[@class='col col-7-12']/div[@class='_3wU53n']")
	private WebElement IphoneClickLnk;
	// Get The Price 
	@FindBy(xpath="//div[@class='_1uv9Cb']/div[@class='_1vC4OE _3qQ9m1']")
	private WebElement FlipkartPrice;
	// typing product name in search text box flipkart
	
	public void ActionPerformed() {
    // Type the Product NAme 
		WebActionUtil.SendKeys(productSerchTextBox, "iPhone XR (64GB) - Yellow.", "Iphone");
		WebActionUtil.sleep(2000);
//Click on search Button
		WebActionUtil.clickOnElement(productSerchButton, "SearchSymbol");
		WebActionUtil.sleep(2000);
		//Click on Product
		WebActionUtil.clickOnElement(productDetail, "Click on the selected product");
		WebActionUtil.sleep(5000);
		//Switch To another window
		WebActionUtil.switchToWindow(driver);
		WebActionUtil.sleep(2000);
		//Get the Price 
		WebActionUtil.clickOnElement(productDetail, "Click on the selected product");
		String AmazonPrice = WebActionUtil.get_Text(price);
		System.out.println(AmazonPrice);
		/*AmazonPrice= AmazonPrice.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(AmazonPrice);*/
		String price1 = AmazonPrice.split("\\s")[1];
		int value = Integer.parseInt(price1.split("\\,")[0]);
		double value1 = Double.parseDouble(price1.split("\\,")[1]);
		double amazonFinalPrice = value * 1000 + value1;

		//int AmazonFinalPrice = Integer.parseInt(AmazonPrice);
		//go to flipkart
		driver.navigate().to("http://www.flipkart.com");
		WebActionUtil.sleep(1000);
		//Click on cross button
		WebActionUtil.clickOnElement(Crossbtn, "Logincrossbutton");
		WebActionUtil.sleep(1000);
		//Type The product name in searchBox
		WebActionUtil.SendKeys(IPhoneX, "iPhone XR (64GB) - Yellow.", "Iphone");
		WebActionUtil.sleep(2000);
		// Click on search Box
		WebActionUtil.clickOnElement(ClickonSearch, "Clicking On Iphone");
		WebActionUtil.sleep(1000);
		//Again click on iphone product
		
		WebActionUtil.clickOnElement(IphoneClickLnk, "Clicking On Iphone");
		WebActionUtil.sleep(2000);
		//Switch to the another window
		WebActionUtil.switchToWindow(driver);
		WebActionUtil.sleep(3000);
		String FlipkartPriceIphone = WebActionUtil.get_Text(FlipkartPrice);
		System.out.println(FlipkartPriceIphone);
		FlipkartPriceIphone= FlipkartPriceIphone.replaceAll("[^a-zA-Z0-9]", "");

		int flipkartFinalPrice = Integer.parseInt(FlipkartPriceIphone);
		System.out.println(flipkartFinalPrice);
		
		//int AmazonPrice1=Integer.parseInt(AmazonPrice);
		if (amazonFinalPrice == flipkartFinalPrice) {
			System.out.println("Both the Application have same price");
			WebActionUtil.logger.info("Both the Application have same price");
		} else if (amazonFinalPrice > flipkartFinalPrice) {
			System.out.println("amazon have  the more  price compare to flipkart");
			WebActionUtil.logger.info("amazon have  the more  price compare to flipkart");
		} else {
			WebActionUtil.logger.info("flipkart have  the more  price compare to amazon");
			System.out.println("flipkart have  the more  price compare to amazon");
		}
		driver.close();
		//driver.switchTo().window(tabs2.get(0));
		
		
		
	}

}
