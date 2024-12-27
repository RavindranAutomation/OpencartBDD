package com.opencart.stepdefinitions;

import com.opencart.pageobjects.CheckoutPage;

import io.cucumber.java.en.Then;

public class CheckoutSteps {
	@Then("User should be taken to the Checkoutpage")
	public void user_should_be_taken_to_the_checkoutpage() {
	   CheckoutPage.getInstance().isCheckoutSubHeaderIsDisplayed();
	}
}
