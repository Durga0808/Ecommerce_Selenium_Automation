package ECommerce_Selenium_Automation.magento.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {

	public static WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Iam in beforetest");
		wait = new WebDriverWait(driver, null);
	}
	
	public void launchURL(String URL) {
		driver.get(URL);
	}
	@Test
	public void sampleTest() {
		System.out.println("Iam in test");
		this.launchURL("https://www.google.com/");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("Iam in aftertest");

	}
}
