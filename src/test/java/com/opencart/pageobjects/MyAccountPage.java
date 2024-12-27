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

	@FindBy(xpath = "//a[@href='http://localhost/opencart/upload/index.php?route=account/logout']") // added in step6
	WebElement lnkLogout;

	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {

		jSClick(lnkLogout);

	}

}
