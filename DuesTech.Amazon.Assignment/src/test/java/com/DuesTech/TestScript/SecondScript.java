package com.DuesTech.TestScript;

import org.testng.annotations.Test;

import com.DuesTech.Library.BaseTest;

import com.DuesTech.Pages.TripAdvisor;

public class SecondScript  extends BaseTest {
	@Test (groups = { "TripAdvisor" })
	public void iphonePriceInAmazonAndFlipkartTest() 
	{	// creating object for Iphone price comparison POM class
		TripAdvisor trip = new TripAdvisor(driver);
			trip.tripAdvisor1();
	
		
		
	}


}
