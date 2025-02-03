package ECommerce_Selenium_Automation.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import ECommerce_Selenium_Automation.magento.DriverSetUp.LocalDriver;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage() {
		this.driver=LocalDriver.getDriver();
		PageFactory.initElements(driver,this);
	}
    public void hover(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
}
