package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountRegistrationPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.CommonUtils;

public class RegistrationSteps {

	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		HomePage.getInstance().clickMyAccount();
		HomePage.getInstance().clickRegister();
	}

	@When("User enters the values in the mandatory fields")
	public void user_enters_the_values_in_the_mandatory_fields() {
		AccountRegistrationPage.getInstance().setFirstName(CommonUtils.randomString());
		AccountRegistrationPage.getInstance().setLastName(CommonUtils.randomString());
		AccountRegistrationPage.getInstance().setEmail(CommonUtils.randomString() + "@gmail.com");
		AccountRegistrationPage.getInstance().setTelephone(CommonUtils.randomNumber());
		AccountRegistrationPage.getInstance().setPassword("Test@12345");
		AccountRegistrationPage.getInstance().setConfirmPassword("Test@12345");

	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		AccountRegistrationPage.getInstance().setPrivacyPolicy();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		AccountRegistrationPage.getInstance().clickContinue();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		String confirmationMsg = AccountRegistrationPage.getInstance().getConfirmationMsg();
		Assert.assertEquals("Your Account Has Been Created!", confirmationMsg);
		HomePage.getInstance().clickMyAccount();
		MyAccountPage.getInstance().clickLogout();

	}
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(io.cucumber.datatable.DataTable dataTable) {
	    Map<String, String> registrationData = dataTable.asMap();
	    AccountRegistrationPage.getInstance().setFirstName( registrationData.get("firstName"));
		AccountRegistrationPage.getInstance().setLastName(registrationData.get("lastName"));
		AccountRegistrationPage.getInstance().setEmail(registrationData.get("email"));
		AccountRegistrationPage.getInstance().setTelephone(registrationData.get("telephone"));
		AccountRegistrationPage.getInstance().setPassword("Test@12345");
		AccountRegistrationPage.getInstance().setConfirmPassword("Test@12345");
	    
	}
	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		String alreadyRegisteredMsg = AccountRegistrationPage.getInstance().getAlreadyRegisteredMsg();
		Assert.assertEquals("Warning: E-Mail Address is already registered!", alreadyRegisteredMsg);
	
	}


}
