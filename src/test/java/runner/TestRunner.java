package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/featureFiles",
		glue= {"stepDefinitions","hooks"},
		dryRun=!true,
		monochrome=true,
		publish = true,

		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failedscenario.txt",
				"html:target/Cucumber.html",
		"json:target/Cucumber.json"}
		)

public class TestRunner {
    

}
