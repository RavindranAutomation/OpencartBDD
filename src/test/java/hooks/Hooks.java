package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import constantAttributes.Cons;
import driverFactory.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonUtils;

public class Hooks {

	@Before
	public void beforeScenario() {
		CommonUtils.loadProperties();
		if (DriverFactory.getDriver() == null) {
			DriverFactory.launchBrowser();
			DriverFactory.getDriver().get(Cons.Url);
			DriverFactory.getDriver().manage().window().maximize();
			DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			CommonUtils.initWebElement();
		}

	}

	@AfterStep
	public static void takeScreenshot(Scenario scenario) {
		String scenarioName = scenario.getName();
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failed  - " + scenarioName);
		}

	}
	
	

	@AfterAll
	public static void tearDown() {
		DriverFactory.getDriver().quit();
	}



}
