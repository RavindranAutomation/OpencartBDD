package com.opencart.stepdefinitions;

import org.junit.Assert;

import com.opencart.driverfactory.DriverFactory;
import com.opencart.pageobjects.HomePage;

import io.cucumber.java.en.Then;

public class HomePageSteps {
	
	@Then("user should be taken to the home page")
	public void user_should_be_taken_to_the_home_page() {
	   Assert.assertEquals("Your Store", DriverFactory.getDriver().getTitle());
	   Assert.assertTrue(HomePage.getInstance().isfeaturedtextIsDisplayed());
	
	}

}
