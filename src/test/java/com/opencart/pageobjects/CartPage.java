package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.driverfactory.DriverFactory;

public class CartPage extends BasePage {
	WebDriver driver = DriverFactory.getDriver();
	private static CartPage cartPageInstance;

	public CartPage() {

	}

	public static CartPage getInstance() {
		if (cartPageInstance == null) {
			cartPageInstance = new CartPage();

		}

		return cartPageInstance;
	}

	@FindBy(xpath = "(//a[@href='http://localhost/opencart/upload/index.php?route=checkout/cart'])[3]")
	WebElement shoppingSubHeaderMenu;

	@FindBy(xpath = "(//a[@href='http://localhost/opencart/upload/index.php?route=product/product&product_id=41'])[4]")
	WebElement shoppingCartProductname;

	@FindBy(xpath = "(//a[@href='http://localhost/opencart/upload/index.php?route=product/product&product_id=41'])[3]")
	WebElement shoppingCartProductImage;

	@FindBy(xpath = "(//span[@class='input-group-btn']/button)[3]")
	WebElement removeBtn;

	@FindBy(xpath = "//div[@class='pull-left']/a")
	WebElement continueShoppingBtn;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement checkoutBtn;

	public boolean isShoppingSubHeaderMenuDisplayed() {
		return shoppingSubHeaderMenu.isDisplayed();

	}

	public boolean isShoppingCartProductImageDisplayed() {
		return shoppingCartProductImage.isDisplayed();

	}

	public String getShoppingCartProductname() {
		return shoppingCartProductname.getText();
	}

	public void clickRemoveBtn() {
		
			jSClick(removeBtn);
	
		

	}

	public void clickcontinueShoppingBtn() {
		
			jSClick(continueShoppingBtn);
	
		
	}

	public void clickcheckoutBtn() {
		
			jSClick(checkoutBtn);
			
		
	}

}
