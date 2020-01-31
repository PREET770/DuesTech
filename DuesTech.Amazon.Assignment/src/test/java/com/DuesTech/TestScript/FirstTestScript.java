package com.DuesTech.TestScript;

import org.testng.annotations.Test;

import com.DuesTech.Library.BaseTest;
import com.DuesTech.Pages.AmazonAssignment;


public class FirstTestScript extends BaseTest {
	
	@Test (groups = { "Amazon" })
	public void iphonePriceInAmazonAndFlipkartTest() 
	{	// creating object for Iphone price comparison POM class
		//AmazonScript amazon = new AmazonScript(driver);
			AmazonAssignment amazon = new AmazonAssignment(driver);
			amazon.ActionPerformed();
	
	//amazon.iphonePriceInAmazonAndFlipkart();
		
	}

}
