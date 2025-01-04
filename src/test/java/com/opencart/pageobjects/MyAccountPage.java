package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.driverfactory.DriverFactory;

public class MyAccountPage extends BasePage {

	WebDriver driver = DriverFactory.getDriver();
	private static MyAccountPage myAccPageInstance;

	public MyAccountPage() {

	}

	public static MyAccountPage getInstance() {
		if (myAccPageInstance == null) {
			myAccPageInstance = new MyAccountPage();

		}

		return myAccPageInstance;
	}

	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=account/logout']")   //added in step6
	WebElement logoutOption;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li[1]/a")
	private WebElement myAccountOption;

	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {

		jSClick(logoutOption);

	}

}
