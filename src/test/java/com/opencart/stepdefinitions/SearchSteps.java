package com.opencart.stepdefinitions;

import org.junit.Assert;

import com.opencart.constants.Cons;
import com.opencart.driverfactory.DriverFactory;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.SearchResultsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	@Given("User opens the Application")
	public void user_opens_the_application() {
		HomePage.getInstance().clickMyAccount();
		HomePage.getInstance().clickLogin();
		LoginPage.getInstance().setEmail(Cons.Email);
		LoginPage.getInstance().setPassword(Cons.Password);
		LoginPage.getInstance().clickLogin();
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String productName) {
		HomePage.getInstance().enterProductName();
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		HomePage.getInstance().clickSearchButton();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() throws InterruptedException {
		Assert.assertEquals("Search - iMac", DriverFactory.getDriver().getTitle());
		boolean iMacImage = SearchResultsPage.getInstance().isiMacDisplayed();
		boolean iMacName = SearchResultsPage.getInstance().isiMacNameDisplayed();
		Assert.assertEquals(true, iMacImage);
		Assert.assertEquals(true, iMacName);
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductName) {

		HomePage.getInstance().clearSearchBar();
		HomePage.getInstance().enterInvalidProductName();
		HomePage.getInstance().clickSearchButton();
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {

		boolean noResultsMessage = SearchResultsPage.getInstance().isNoSearchResultsDisplayed();
		Assert.assertEquals(true, noResultsMessage);

	}
	
	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		HomePage.getInstance().clearSearchBar();
	}


}
