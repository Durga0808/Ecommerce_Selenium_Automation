package ECommerce_Selenium_Automation.magento.DriverSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalDriver {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public LocalDriver() {

	}

	public static void setupDriver() {
		if (driver.get() == null) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver()); // Each thread gets its own driver instance
		}
	}

	public static WebDriver getDriver() {
		if (driver.get() == null) {
			setupDriver();
		}
		return driver.get(); // Retrieves the driver for the current thread
	}

	public static void tearDown() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove(); // Removes WebDriver instance from ThreadLocal
		}
	}
}
