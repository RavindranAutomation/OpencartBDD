package com.opencart.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.opencart.constants.Cons;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static WebDriver driver=null;


	public static WebDriver getDriver() {
		return driver;
	}


	public static void launchBrowser() {
		switch (Cons.BrowserName) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new
					String[]{"enable-automation"});
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		}

	}
}
