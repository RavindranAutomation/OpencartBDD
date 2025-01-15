package com.opencart.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import com.opencart.pageobjects.SearchResultsPage;
import com.opencart.pageobjects.WishlistPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistSteps {
	
	@When("User clicks on the wishlish page link")
	public void user_clicks_on_the_wishlish_page_link() {
		SearchResultsPage.getInstance().clickWishlistButton();
		SearchResultsPage.getInstance().clickWishlistLink();
		Assert.assertTrue(WishlistPage.getInstance().idWishlistHeaderIsDisplayed());
	    
	}
	@Then("User should see the added product from the list")
	public void user_should_see_the_added_product_from_the_list() {
		
		String wishlistedProductName = WishlistPage.getInstance().getWishlistedProductName();
		Assert.assertEquals("iMac", wishlistedProductName);
		
		String wishlistedProductModel = WishlistPage.getInstance().getWishlistedProductModel();
		Assert.assertEquals("Product 14", wishlistedProductModel);
		
	    
	}
	@Then("User should be clear the wishlist")
	public void user_should_be_clear_the_wishlist() {
		
		WishlistPage.getInstance().clickOnWishlistRemoveBtn();
	    
	}


}
