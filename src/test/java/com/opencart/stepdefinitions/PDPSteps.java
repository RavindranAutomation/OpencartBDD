package com.opencart.stepdefinitions;

import java.awt.AWTException;

import org.testng.Assert;

import com.opencart.driverfactory.DriverFactory;
import com.opencart.pageobjects.PDP_Page;
import com.opencart.pageobjects.SearchResultsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PDPSteps {

	@When("User clicks on product image")
	public void user_clicks_on_product_image() {
		Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Search - iMac");
		SearchResultsPage.getInstance().clickImacImg();
	}

	@Then("User should get product related details")
	public void user_should_get_product_related_details() {
		Assert.assertEquals(PDP_Page.getInstance().getProductName(), "iMac");
		Assert.assertEquals(PDP_Page.getInstance().getProductBrand(), "Apple");
		Assert.assertEquals(PDP_Page.getInstance().getProductCode(), "Product Code: Product 14");

		Assert.assertEquals(PDP_Page.getInstance().getProductAvailability(), "Availability: Out Of Stock");

		Assert.assertEquals(PDP_Page.getInstance().getProductPrice(), "$122.00");
		Assert.assertEquals(PDP_Page.getInstance().getDefaultQty(), "1");
		Assert.assertEquals(PDP_Page.getInstance().getProductDescription(),
				"Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo processors. And more memory standard. "
						+ "Combine this with Mac OS X Leopard and iLife ´08, and it´s more all-in-one than ever. "
						+ "iMac packs amazing performance into a stunningly slim space.");
//		HomePage.getInstance().clickMyAccount();
//	    MyAccountPage.getInstance().clickLogout();

	}

}
