package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driverFactory.DriverFactory;

public class LoginPage extends BasePage  {

	WebDriver driver = DriverFactory.getDriver();
	private static LoginPage loginPageInstance;

	public LoginPage() {

	}

	public static LoginPage getInstance() {
		if (loginPageInstance == null) {
			loginPageInstance = new LoginPage();

		}

		return loginPageInstance;
	}


	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath = "(//div[@id='account-login']//div)[1]")
	WebElement incorrectLoginMessage;

	public void setEmail(String email) {
		typeTextIntoElement(txtEmailAddress, email, 0);
	}

	public void setPassword(String pwd) {
		typeTextIntoElement(txtPassword, pwd, 0);
	}

	public void clickLogin() {

		jSClick(btnLogin);

	}
	
	public boolean isIncorrectLoginMessageDisplayed() {
		return incorrectLoginMessage.isDisplayed();
	}

}
