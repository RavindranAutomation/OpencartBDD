package com.opencart.stepdefinitions;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.MyAccountPage;

public class HelperSteps {

	public static void LoginApp() {
		HomePage.getInstance().clickMyAccount();
		HomePage.getInstance().clickLogin();
	}

	public static void logoutApp() {
//		HomePage.getInstance().clickCartButton();
//		HomePage.getInstance().clickRemoveButton();
		HomePage.getInstance().clickMyAccount();
		MyAccountPage.getInstance().clickLogout();

	}

}
