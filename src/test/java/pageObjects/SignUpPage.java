package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;

public class SignUpPage {
	WebDriver driver = DriverFactory.getDriver();
	private static SignUpPage signUpPageInstance;

	public SignUpPage() {

	}

	By loginAccountTitle = By.xpath("//div[@class='login-form']//h2[1]");
	By loginEmailAddress = By.xpath("//input[@data-qa='login-email']");
	By loginPassword = By.xpath("//input[@data-qa='login-password']");
	By loginButton = By.xpath("//button[@data-qa='login-button']");
	By loginErrorMessage = By.xpath("//input[@data-qa='login-password']/following-sibling::p[1]");

	By signUpTitle = By.xpath("//div[@class='signup-form']//h2[1]");
	By signUpName = By.xpath("//input[@data-qa='signup-name']");
	By signUpEmail = By.xpath("//input[@data-qa='signup-email']");
	By signUpButton = By.xpath("//button[@data-qa='signup-button']");
	By accountInfoTitle = By.xpath("(//h2[@class='title text-center']//b)[1]");

	By createAccountbutton = By.xpath("//button[@data-qa='create-account']");

	By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']//b[1]");
	By continueButton = By.xpath("//div[@class='pull-right']//a[1]");
	By accountDeletedMessage = By.xpath("//h2[@data-qa='account-deleted']//b[1]");
	By loginAsUser = By.xpath("//ul[@class='nav navbar-nav']/li[10]/a");
    By emailExistsMessage = By.xpath("//div[@class='signup-form']//p[1]");

	public void clickContinuebutton() {
		driver.findElement(continueButton).click();

	}

	public String getLoginAccTitle() {
		String loginAccTitle = driver.findElement(loginAccountTitle).getText();
		return loginAccTitle;

	}
	public WebElement enterLoginEmail() {
		return driver.findElement(loginEmailAddress);

	}
	public WebElement enterPassword() {
		return driver.findElement(loginPassword);

	}
	public void clickLoginButton() {
		 driver.findElement(loginButton).click();

	}
	public String getLoginErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginErrorMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage));
		String loginErrorMsg = loginErrorMsgElement.getText();
		return loginErrorMsg;
	}


	public String getSignUpTitle() {
		String signUptitle = driver.findElement(signUpTitle).getText();
		return signUptitle;

	}
	public String getAccountInfoTitle() {
		String accountTitle = driver.findElement(accountInfoTitle).getText();
		return accountTitle;

	}

	public WebElement enterSignUpUsername() {
		return driver.findElement(signUpName);

	}
	public WebElement enterSignUpEmail() {
		return driver.findElement(signUpEmail);
		

	}

	public void clickSignUpButton() {
		driver.findElement(signUpButton).click();

	}
	public void clickCreateAccountButton() {
		driver.findElement(createAccountbutton).click();

	}

	public String getAccountCreatedMessage() {
		String accCreatedMsg = driver.findElement(accountCreatedMessage).getText();
		return accCreatedMsg;
	}
	public String getAccountDeletedMessage() {
		String accDeletedMsg = driver.findElement(accountDeletedMessage).getText();
		return accDeletedMsg;
	}
	public String getEmailExistsMessage() {
		String emailMessage = driver.findElement(emailExistsMessage).getText();
		return emailMessage;
	}

	public static SignUpPage getInstance() {
		if (signUpPageInstance == null) {
			signUpPageInstance = new SignUpPage();

		}

		return signUpPageInstance;
	}



}
