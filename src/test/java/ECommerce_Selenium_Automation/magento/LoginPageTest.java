package ECommerce_Selenium_Automation.magento;

import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Selenium_Automation.magento.Pages.HomePage;
import ECommerce_Selenium_Automation.magento.Pages.LoginPage;
import io.qameta.allure.Description;

public class LoginPageTest extends BaseTest {

	@Test
	@Description("Verify the ability to login in")
	public void LoginTest() {
		LoginPage loginPage = homePage.clickSignIn();
		HomePage homePage = loginPage.login("automationdurga08@gmail.com", "Dp143$$$");
		Assert.assertTrue(homePage.isLoggedInMsgDisplayed(), "Login msg not displayed");
		Assert.assertTrue(homePage.getloggedInMsg().getText().contains("Welcome"));
	}
}
