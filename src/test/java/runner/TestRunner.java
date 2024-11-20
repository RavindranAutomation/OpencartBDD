package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/featureFiles/Login.feature",
		glue= {"stepDefinitions","hooks"},
		dryRun=!true,
		//		tags = "~@NewUserRegistration",
		monochrome=true,
		publish = true,

		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failedscenario.txt",
				"html:target/cucumber-reports/Cucumber.html",
		"json:target/cucumber-reports/Cucumber.json"}
		)

public class TestRunner {
    

}
