package stepDefinitions;

import java.awt.AWTException;

import org.testng.Assert;

import driverManager.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyAccountPage;
import pages.PDP_Page;
import pages.SearchResultsPage;

public class PDPSteps {

	@When("User clicks on product image")
	public void user_clicks_on_product_image() {
		Assert.assertEquals(DriverManager.getDriver().getTitle(), "Search - iMac");
		SearchResultsPage.getInstance().clickImacImg();
	}

	@Then("User should get thumbnail images")
	public void user_should_get_thumbnail_images() throws AWTException, InterruptedException {
		if (PDP_Page.getInstance().verifyThumbnail() == true) {
			PDP_Page.getInstance().clickImacThumbnailImg();
			PDP_Page.getInstance().clickNextArrowButton();
			Assert.assertTrue(true);

		}

		if (PDP_Page.getInstance().verifyImacSideView() == true) {
			PDP_Page.getInstance().clickiMacSideView();
			Assert.assertTrue(true);

			if (PDP_Page.getInstance().verifyiMacTiltView() == true) {
				PDP_Page.getInstance().clickiMacTiltVieww();
				Assert.assertTrue(true);
			}

		} else {
			Assert.fail();
		}
	}
	
	@Then("User should get product related details")
	public void user_should_get_product_related_details() {
		Assert.assertEquals(PDP_Page.getInstance().getProductName(), "iMac");
		Assert.assertEquals(PDP_Page.getInstance().getProductBrand(), "Apple");
		Assert.assertEquals(PDP_Page.getInstance().getProductCode(), "Product Code: Product 14");

		Assert.assertEquals(PDP_Page.getInstance().getProductAvailability(), "Availability: In Stock");

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
