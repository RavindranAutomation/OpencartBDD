package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import basetTest.ElementUtils;
import driverManager.DriverManager;

public class ProductsPage extends ElementUtils{
	WebDriver driver = DriverManager.getDriver();
	private static ProductsPage productsPageInstance;

	public ProductsPage() {

	}

	public static ProductsPage getInstance() {
		if (productsPageInstance == null) {
			productsPageInstance = new ProductsPage();

		}

		return productsPageInstance;
	}

	By bannerImage = By.xpath("//img[@alt='Website for practice']");
	By searchBox = By.xpath("//input[@class='form-control input-lg']");
	By searchButton = By.xpath("(//button[contains(@class,'btn btn-default')])[1]");
	By allProductsHeader = By.xpath("//h2[@class='title text-center']");
	By allProductsList = By.xpath("//div[@class='single-products']/div/p");
	By menTshirtView = By.xpath("//a[@href='/product_details/2']");
	By reviewtext = By.xpath("//li[@class='active']//a[1]");
	By menTshirtName = By.xpath("//div[@class='product-information']//h2[1]");
	By menTshirtCategory = By.xpath("//div[@class='product-information']//p[1]");
	By menTshirtPrice = By.xpath("(//div[@class='product-information']//span)[2]");
	By menTshirtvailability = By.xpath("(//div[@class='product-information']//p)[2]");
	By menTshirtCondition = By.xpath("(//div[@class='product-information']//b)[2]");
	By menTshirtBrand = By.xpath("(//div[@class='product-information']//b)[3]");
	By searchedProductsHeader = By.xpath("//h2[normalize-space(text())='Searched Products']");
	By cottonTshirt = By.xpath("//div[@class='productinfo text-center']/p");
	By GreenSideTshirt = By.xpath("//div[@class='productinfo text-center']/p");
	By blueTopsProduct = By.xpath("//a[@data-product-id='1']");
	By blueTopsAddToCart = By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]");
	By ContinueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");

	public void clickContinueButton() {
		driver.findElement(ContinueShoppingButton).click();

	}

	public void addBlueTopsToCart() {
		WebElement blueTops= driver.findElement(blueTopsProduct);
		Actions a = new Actions(driver);
		a.moveToElement(blueTops).build().perform();
		ElementUtils.clickOnElement(blueTopsAddToCart, 5);

	}


	public boolean verifyGreenSideTshirt() {
		return driver.findElement(GreenSideTshirt).isDisplayed();

	}
	public boolean verifyCottonTshirt() {
		return driver.findElement(cottonTshirt).isDisplayed();

	}
	public boolean verfiySearchResultsHeader() {
		return driver.findElement(searchedProductsHeader).isDisplayed();

	}


	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}

	public void clickSearchButon() {
		driver.findElement(searchButton).click();;

	}
	public void clickOnmenTshirtView() {
		driver.findElement(menTshirtView).click();

	}
	public boolean verifyWriteReview() {
		boolean displayed = driver.findElement(reviewtext).isDisplayed();
		return displayed;
	}

	public boolean verifyBannerImg() {
		boolean displayed = driver.findElement(bannerImage).isDisplayed();
		return displayed;

	}

	public boolean verifyHeader() {
		boolean displayed = driver.findElement(allProductsHeader).isDisplayed();
		return displayed;
	}

	public List<WebElement> getAllProductsList() {
		List<WebElement> elements = driver.findElements(allProductsList);
		return elements;
	}
}
