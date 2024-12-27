package com.opencart.stepdefinitions;

import org.junit.Assert;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.MyAccountPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	boolean targetPage;
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		HelperSteps.LoginApp();
	}
	@When("User enters email address {string} into email field")
	public void user_enters_email_address_into_email_field(String email) {
		LoginPage.getInstance().setEmail(email);
	}
	@When("User enters password {string} into password field")
	public void user_enters_password_into_password_field(String pass) {
		LoginPage.getInstance().setPassword(pass);
	}
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		LoginPage.getInstance().clickLogin();
	
	}
	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		targetPage = MyAccountPage.getInstance().isMyAccountPageExists();
		Assert.assertTrue(targetPage);
	}
	@Then("User should logout")
	public void user_should_logout() {
		HelperSteps.logoutApp();
	}

	

	@Then("User should not get successfully logged in")
	public void user_should_not_get_successfully_logged_in() {
		boolean incorrectLoginMessage = LoginPage.getInstance().isIncorrectLoginMessageDisplayed();

		if (incorrectLoginMessage == true) {
			Assert.assertTrue(incorrectLoginMessage);

			if (targetPage == true) {
				Assert.assertTrue(targetPage);
			}
		} else {
			Assert.fail("Testcase is failed");
		}
	}

	

	@When("User enters email as {string}")
	public void user_enters_email_as(String email) {
		LoginPage.getInstance().setEmail(email);
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String pass) {
		LoginPage.getInstance().setPassword(pass);
	}

	@Then("If incorrect credentials are entered, User should not get successfully logged in")
	public void if_incorrect_credentials_are_entered_user_should_not_get_successfully_logged_in() {
		boolean incorrectLoginMessage = LoginPage.getInstance().isIncorrectLoginMessageDisplayed();

		if (incorrectLoginMessage == true) {
			Assert.assertTrue(incorrectLoginMessage);

			if (targetPage == true) {
				Assert.assertTrue(targetPage);
			}
		} else {
			Assert.fail("Testcase is failed");
		}
	}
	
}
