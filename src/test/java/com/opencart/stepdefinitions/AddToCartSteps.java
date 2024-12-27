package com.opencart.stepdefinitions;

import org.junit.Assert;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.SearchResultsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {

	@When("User clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() {
		SearchResultsPage.getInstance().clickiMacAddToCartBtn();
	}

	@Then("User should see {string} message")
	public void user_should_see_message(String successMessage) {
		boolean cartAddedSuccessMessageDisplayed = SearchResultsPage.getInstance().isCartAddedSuccessMessageDisplayed();
		Assert.assertEquals(true, cartAddedSuccessMessageDisplayed);


	}

	@When("User clicks on CartButton")
	public void user_clicks_on_cart_button() {
		SearchResultsPage.getInstance().clickCartBtn();
	}

	@Then("User should see added product in the popup")
	public void user_should_see_added_product_in_the_popup() throws InterruptedException {
		boolean productNameVisibleOnPopup = SearchResultsPage.getInstance().isProductNameVisibleOnPopup();
		Assert.assertEquals(true, productNameVisibleOnPopup);
		Thread.sleep(2000);
		SearchResultsPage.getInstance().clickCloseBtn();
		
	}

}
