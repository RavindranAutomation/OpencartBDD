package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driverManager.DriverManager;

public class PDP_Page extends BasePage {

	

	WebDriver driver = DriverManager.getDriver();
	private static PDP_Page pdpPageInstance;

	public PDP_Page() {

	}

	public static PDP_Page getInstance() {
		if (pdpPageInstance == null) {
			pdpPageInstance = new PDP_Page();

		}

		return pdpPageInstance;
	}

	@FindBy(xpath = "//img[@src='http://localhost/opencart/upload/image/cache/catalog/demo/imac_1-228x228.jpg']")
	WebElement imacThumbnailImg;

	@FindBy(xpath = "//button[@title='Next (Right arrow key)']")
	WebElement nextArrowBtn;

	@FindBy(xpath = "//img[@src='http://localhost/opencart/upload/image/cache/catalog/demo/imac_3-74x74.jpg']")
	WebElement iMacSideView;

	@FindBy(xpath = "//img[@src='http://localhost/opencart/upload/image/cache/catalog/demo/imac_2-74x74.jpg']")
	WebElement iMacTiltView;

	@FindBy(xpath = "//div[@class='btn-group']//following::h1")
	WebElement productName;

	@FindBy(xpath = "//div[@class='col-sm-4']//ul[1]/li/a")
	WebElement getBrandName;

	@FindBy(xpath = "//div[@class='col-sm-4']//ul[1]/li[2]")
	WebElement productCode;

	@FindBy(xpath = "//div[@class='col-sm-4']//ul[1]/li[3]")
	WebElement productAvailability;

	@FindBy(xpath = "//div[@class='col-sm-4']//ul[2]/li/h2")
	WebElement productPrice;

	@FindBy(xpath = "//label[@for='input-quantity']//following::input[1]")
	WebElement defaultQtyInputBox;

	@FindBy(xpath = "//div[@id='tab-description']")
	WebElement iMacProductDescription;

	public boolean verifyThumbnail() {
		return imacThumbnailImg.isDisplayed();

	}

	public void clickImacThumbnailImg() {
		imacThumbnailImg.click();

	}

	public void clickNextArrowButton() throws AWTException {
		for (int i = 0; i <= 1; i++) {
			try {
				clickOnElement(nextArrowBtn, 0);
			} catch (Exception e) {
				jSClick(nextArrowBtn);
				e.printStackTrace();
			}
		}

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

	}

	public boolean verifyImacSideView() {
		return iMacSideView.isDisplayed();

	}

	public void clickiMacSideView() throws AWTException, InterruptedException {
		try {
			clickOnElement(iMacSideView, 0);
		} catch (Exception e) {
			jSClick(iMacSideView);
	
		}
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

	}

	public boolean verifyiMacTiltView() {
		return iMacTiltView.isDisplayed();

	}

	public void clickiMacTiltVieww() throws AWTException, InterruptedException {
		
			jSClick(iMacTiltView);
	

		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

	}

	public String getProductName() {
		return productName.getText();

	}

	public String getProductBrand() {
		return getBrandName.getText();

	}

	public String getProductCode() {
		return productCode.getText();

	}

	public String getProductAvailability() {
		return productAvailability.getText();

	}

	public String getProductPrice() {
		return productPrice.getText();

	}

	public String getDefaultQty() {
		return defaultQtyInputBox.getAttribute("value");

	}

	public String getProductDescription() {
		return iMacProductDescription.getText();
	}

}
