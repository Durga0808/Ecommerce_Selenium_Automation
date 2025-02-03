package ECommerce_Selenium_Automation.magento;

import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import ECommerce_Selenium_Automation.magento.DriverSetUp.LocalDriver;
import ECommerce_Selenium_Automation.magento.Pages.HomePage;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static String browserInformation;
    protected static byte[] screenshot;
    
    
    @BeforeClass
    public static void setupDriver() {
        driver = LocalDriver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       homePage = new HomePage();
       homePage.gotoHomePage();
    }
    
    @AfterMethod
    public void getTestInformation() {
        browserInformation = getBrowserInformation();
        screenshot = getScreenshot();
    }

    @AfterClass
    public static void closeBrowser() {
        LocalDriver.tearDown();
    }

    private static String getBrowserInformation() {
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String browserVersion = capabilities.getBrowserVersion();
        return "Browser Name: " + browserName + ", Browser Version: " + browserVersion;
    }

    private static byte[] getScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
