package com.opencart.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.opencart.constants.Cons;
import com.opencart.driverfactory.DriverFactory;
import com.opencart.pageobjects.AccountRegistrationPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.MyAccountPage;
import com.opencart.pageobjects.PDP_Page;
import com.opencart.pageobjects.SearchResultsPage;
import com.opencart.pageobjects.WishlistPage;

public class CommonUtils {

	public static void loadProperties() {
		FileReader file = null;
		try {
			file = new FileReader("src/test/resources/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Cons.BrowserName = p.getProperty("Browser");
		Cons.Url = p.getProperty("Url");
		Cons.Email = p.getProperty("Email");
		Cons.Password = p.getProperty("Password");

	}

	public static void initWebElement() {
		PageFactory.initElements(DriverFactory.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverFactory.getDriver(), MyAccountPage.getInstance());
		PageFactory.initElements(DriverFactory.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverFactory.getDriver(), SearchResultsPage.getInstance());
		PageFactory.initElements(DriverFactory.getDriver(), AccountRegistrationPage.getInstance());
		PageFactory.initElements(DriverFactory.getDriver(), PDP_Page.getInstance());
		PageFactory.initElements(DriverFactory.getDriver(), WishlistPage.getInstance());
	}

	public static void takeScreenshot(String screenshotNameWithExtension) {
		TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriver();
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(screenshotNameWithExtension));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String randomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public static String randomNumber() {
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public static String randomAlphaNumberic() {
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring + "@" + generatednumber);
	}

}
