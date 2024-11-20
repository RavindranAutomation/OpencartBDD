package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverManager.DriverManager;

public class TestCasesPage {
	WebDriver driver = DriverManager.getDriver();
	private static TestCasesPage testCasesPageInstance;

	public TestCasesPage() {

	}

	public static TestCasesPage getInstance() {
		if (testCasesPageInstance == null) {
			testCasesPageInstance = new TestCasesPage();

		}

		return testCasesPageInstance;
	}
	
	By testCasesHeader = By.xpath("//h2[@class='title text-center']//b[1]");
	
	By testCasesList = By.xpath("/div[@class='panel-group']/div/div/h4/a/u");
	
	public String getTestCasesHeader(){
		String text = driver.findElement(testCasesHeader).getText();
		return text;
	}
	public List<WebElement> getListOfTC() {
		List<WebElement> TCList = driver.findElements(testCasesList);
        return TCList;
	}

}
