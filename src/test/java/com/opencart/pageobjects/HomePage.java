package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.opencart.driverfactory.DriverFactory;

public class HomePage extends BasePage {

	WebDriver driver = DriverFactory.getDriver();
	private static HomePage homePageInstance;

	public HomePage() {

	}

	public static HomePage getInstance() {
		if (homePageInstance == null) {
			homePageInstance = new HomePage();

		}

		return homePageInstance;
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(linkText = "Login") // Login link added in step0
	WebElement linkLogin;

	@FindBy(xpath = "//input[@name='search']")
	WebElement searchBar;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement searchButton;

	@FindBy(xpath = "//a[@href='http://localhost/opencart/upload/index.php?route=common/home']")
	WebElement homeButton;

	@FindBy(xpath = "((//div[@class='button-group']//button)[2]")
	WebElement wishListTT;

	@FindBy(xpath = "((//div[@class='button-group']//button)[3]")
	WebElement compareTT;

	@FindBy(xpath = "(//i[@class='fa fa-shopping-cart']/following-sibling::span)[1]")
	WebElement shoppingcartHeaderLink;

	@FindBy(xpath = "//a[@href='http://localhost/opencart/upload/index.php?route=information/sitemap']")
	WebElement sitemapFooterLink;

	@FindBy(xpath = "//div[@class='col-sm-12']//h3[1]")
	WebElement featuredText;

	@FindBy(css = "div#cart")
	WebElement cartButton;

	@FindBy(xpath = "//button[@title='Remove']")
	WebElement removeButton;

	public void clickMyAccount() {

		jSClick(lnkMyaccount);

	}

	public void clickRegister() {

		jSClick(lnkRegister);

	}

	public void clickLogin() {

		jSClick(linkLogin);

	}

	public void enterProductName(String productname) {
		searchBar.sendKeys(productname);

	}

	public void clickSearchButton() {

		jSClick(searchButton);

	}

	public void clearSearchBar() {
		searchBar.clear();

	}

	public void enterInvalidProductName(String productname) {
		waitForVisibilityOfElement(searchBar, 0);
		searchBar.sendKeys(productname);

	}

	public void clickHomeBtn() {

		waitForElement(homeButton, 0).click();
		;

	}

	public String getAddtoWishListToolTip() {
		Actions a = new Actions(driver);
		a.moveToElement(wishListTT);
		return wishListTT.getAttribute("data-original-title");

	}

	public String getCompareProductToolTip() {
		Actions a = new Actions(driver);
		a.moveToElement(compareTT);
		return compareTT.getAttribute("data-original-title");

	}

	public void clickshoppingcartHeaderLink() {

		jSClick(shoppingcartHeaderLink);

	}

	public void clicksitemapFooterLink() {

		jSClick(sitemapFooterLink);

	}

	public boolean isfeaturedtextIsDisplayed() {
		return featuredText.isDisplayed();

	}

	public void clickCartButton() {
		jSClick(cartButton);

	}

	public void clickRemoveButton() {
		javaScriptClick(removeButton, 4);

	}

}
