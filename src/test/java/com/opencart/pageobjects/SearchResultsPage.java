package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.driverfactory.DriverFactory;

public class SearchResultsPage extends BasePage{

	WebDriver driver = DriverFactory.getDriver();
	private static SearchResultsPage searchResultsPageInstance;

	public SearchResultsPage() {

	}

	public static SearchResultsPage getInstance() {
		if (searchResultsPageInstance == null) {
			searchResultsPageInstance = new SearchResultsPage();

		}

		return searchResultsPageInstance;
	}

	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement searchResultsHeader;

	
	@FindBy(xpath = "(//img[@class='img-responsive'])[2]")
	private WebElement iMacImage;

	@FindBy(xpath = "//div[@class='caption']//a[1]")
	WebElement iMacName;
	
	@FindBy(xpath = "(//div[@id='content']//p)[2]")
	WebElement searchResluts;
	
	@FindBy(xpath = "(//div[@class='button-group']//button)[2]")
	WebElement iMacWishListBtn;
	
	@FindBy(xpath = "(//div[@class='button-group']//i)[3]")
	WebElement iMacCompareBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement compareSuccessMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a[contains(text(), 'iMac')]")
	WebElement wishListSuccessMessage;
	
	@FindBy(xpath = "(//div[contains(@class,'alert alert-success')]//a)[2]")
	WebElement wishListLink;
	
	@FindBy(xpath = "(//div[contains(@class,'alert alert-success')]//a)[2]")
	WebElement productComparisonLink;
	
	@FindBy(xpath = "//div[@class='product-thumb']")
	WebElement productTile;
	
	@FindBy(xpath = "(//img[@class='img-responsive'])[2]")
	WebElement iMacImgLink;
	
	
	@FindBy(xpath = "//div[@class='button-group']//button[1]")
	WebElement iMacAddToCartBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement cartAddedSuccessMessage;
	
	@FindBy(xpath = "//a[text()='iMac']/following-sibling::a")
	WebElement shoppingCartLink;
	
	@FindBy(xpath = "//input[@id='button-search']//following::p[1]")
	WebElement searchCriteriaNotMetMessage;
	
	@FindBy(xpath ="//div[@id='cart']")
	WebElement cartButton;
	
	@FindBy(xpath = "//button[@title='Remove']")
	WebElement cartButtonPopupCloseBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped']//tr/td[2]/a")
	WebElement cartButtonProductName;
	
	
	public String verifyResultsHeader() {
		return searchResultsHeader.getText();

	}
	
	public boolean isiMacDisplayed() {
		waitForVisibilityOfElement(iMacImage, 3);
		return iMacImage.isDisplayed();

	}
	
	public boolean isiMacNameDisplayed() {
		waitForVisibilityOfElement(iMacName, 3);
		return iMacName.isDisplayed();

	}
	
	public boolean isNoSearchResultsDisplayed() {
		return searchResluts.isDisplayed();

	}
	
	public String getImacAddtoWishListToolTip() {
	
		return iMacWishListBtn.getAttribute("data-original-title");

	}
	
	public String getImacCompareProductToolTip() {
		mouseHoverToElement(iMacCompareBtn,0);
		return iMacCompareBtn.getAttribute("data-original-title");

	}
	
	public void clickImacCompareBtn() {
		
		
			jSClick(iMacCompareBtn);
		
	
	}
	
	public boolean verifyCompareSuccessMessage() {
		return compareSuccessMessage.isDisplayed();

	}
	
	
	public void clickProductComparisonLink() {
		
			jSClick(productComparisonLink);
			
	

	}
	
	public boolean verifyProductTile() {
		return productTile.isDisplayed();

	}

	public void clickImacImg() {
		jSClick(iMacImgLink);

	}
	
	public void clickiMacAddToCartBtn() {
		jSClick(iMacAddToCartBtn);

	}
	
	public boolean isCartAddedSuccessMessageDisplayed() {
		return cartAddedSuccessMessage.isDisplayed();

	}
	
	public void clickShoppingCartLink() {
		jSClick(shoppingCartLink);

	}
	
	public void clickWishlistButton() {
		jSClick(iMacWishListBtn);

	}
	
	public boolean iswishListSuccessMessageDisplayed() {
		return wishListSuccessMessage.isDisplayed();

	}
	
	public void clickWishlistLink() {
		
			jSClick(wishListLink);
	


	}
	
	public String getSearchCriteriaNotMetMessage() {
	return getTextFromElement(searchCriteriaNotMetMessage, 2);
	}
	
	public void clickCartBtn() {
		clickOnElement(cartButton, 2);

	}
	
	public boolean isProductNameVisibleOnPopup() {
		return cartButtonProductName.isDisplayed();

	}
	
	public void clickCloseBtn() {
		javaScriptClick(cartButtonPopupCloseBtn, 3);

	}
}


