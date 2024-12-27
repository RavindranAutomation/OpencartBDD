package com.opencart.stepdefinitions;

import org.testng.Assert;

import com.opencart.driverfactory.DriverFactory;
import com.opencart.pageobjects.CartPage;
import com.opencart.pageobjects.SearchResultsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartSteps {
	
	@When("User clicks shopping cart link from popup message")
	public void user_clicks_shopping_cart_link_from_popup_message() {
		SearchResultsPage.getInstance().clickShoppingCartLink();		
	}

	@Then("User should be taken to the Shopping cart page")
	public void user_should_be_taken_to_the_shopping_cart_page() {
		boolean actual = CartPage.getInstance().isShoppingSubHeaderMenuDisplayed();
		Assert.assertEquals(actual, true);
		Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Shopping Cart");
		
	}
	@When("User clicks on the Continue shopping button")
	public void user_clicks_on_the_continue_shopping_button() {
	   CartPage.getInstance().clickcontinueShoppingBtn();
	}
	
	@Then("User clicks on the checkout button")
	public void user_clicks_on_the_checkout_button() {
		CartPage.getInstance().clickcheckoutBtn();
	}
	
	
}
