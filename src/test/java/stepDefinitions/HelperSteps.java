package stepDefinitions;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;

public class HelperSteps {
	
	public static void logoutApp() {
		HomePage.getInstance().clickMyAccount();
		MyAccountPage.getInstance().clickLogout();

	}
	
	public static void clearCart() {
		
	}

}
