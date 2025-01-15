package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.driverfactory.DriverFactory;

public class WishlistPage extends BasePage {

	WebDriver driver = DriverFactory.getDriver();
	private static WishlistPage wishlistPageInstance;

	public WishlistPage() {

	}

	public static WishlistPage getInstance() {
		if (wishlistPageInstance == null) {
			wishlistPageInstance = new WishlistPage();

		}

		return wishlistPageInstance;
	}

	@FindBy(xpath = "//div[@id='content']/h2")
	private WebElement wishlistHeader;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr/td[2]")
	private WebElement wishlistedProductName;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr/td[3]")
	private WebElement wishlistedProductModel;

	@FindBy(xpath = "//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=account/wishlist&remove=41']")
	private WebElement wishlistRemoveBtn;

	public String verifyWishlistTitle() {
		return driver.getCurrentUrl();

	}

	public boolean idWishlistHeaderIsDisplayed() {
		return wishlistHeader.isDisplayed();

	}

	public String getWishlistedProductName() {
		return wishlistedProductName.getText();
	}

	public String getWishlistedProductModel() {
		return wishlistedProductModel.getText();

	}

	public void clickOnWishlistRemoveBtn() {
		jSClick(wishlistRemoveBtn);

	}
}
