package ECommerce_Selenium_Automation.magento;

import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Selenium_Automation.magento.Data.User;
import ECommerce_Selenium_Automation.magento.Pages.AccountPage;
import ECommerce_Selenium_Automation.magento.Pages.CreateAccountPage;
import io.qameta.allure.Description;

public class CreateAccountPageTest extends BaseTest{
	
	@Test
	 @Description("Verify the ability to create an account")
	public void verifyCreateAccount() {
		CreateAccountPage createAccountPage = homePage.clickCreateAnAccountButton();
		User user = new User().createFakeUser();
		AccountPage accountPage = createAccountPage.registerAccount(user);
		Assert.assertTrue(accountPage.isRegistrationMsgDisplayed(), "Registration msg not displayed");
		Assert.assertTrue(accountPage.getContactInfo().contains(user.getEmail()), "user email not shown in contact info");
	}

}
