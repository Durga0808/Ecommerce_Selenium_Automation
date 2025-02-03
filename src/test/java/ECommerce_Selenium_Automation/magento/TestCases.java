package ECommerce_Selenium_Automation.magento;

import org.testng.annotations.Test;

import ECommerce_Selenium_Automation.magento.Pages.CreateAccountPage;
import ECommerce_Selenium_Automation.magento.Pages.HomePage;
import ECommerce_Selenium_Automation.magento.Pages.Utility;

public class TestCases extends Utility{
	
@Test
public void test1() throws Exception {
	driver.get("https://magento.softwaretestingboard.com/");
	wait.wait(5000);
	HomePage homePage = new HomePage();
	homePage.getCreateAccount().click();
	wait.wait(5000);
	CreateAccountPage createAccountPage = new CreateAccountPage();
	createAccountPage.getFirstName().sendKeys("durga");
	createAccountPage.getLastName().sendKeys("prasad");
	createAccountPage.getEmailAddress().sendKeys("test123456@gmail.com");
	createAccountPage.getPassword().sendKeys("Dp143$$$");
	createAccountPage.getPasswordConfirmation().sendKeys("Dp143$$$");
	createAccountPage.getSubmitBtn().click();
}

}
