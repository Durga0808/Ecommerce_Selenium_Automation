package ECommerce_Selenium_Automation.magento;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ECommerce_Selenium_Automation.magento.Data.Address;
import ECommerce_Selenium_Automation.magento.Pages.AccountPage;
import ECommerce_Selenium_Automation.magento.Pages.AddressPage;
import io.qameta.allure.Description;

public class AddressTest extends BaseTest {
	@BeforeClass
	public static void accessAccount() {
		homePage.clickSignIn().login("automationdurga08@gmail.com", "Dp143$$$");
	}

	@Test
	@Description("Check if new address is successfully added")
	public void addNewAddressTest() {
		AccountPage accountPage = homePage.clickMyAccountBtn();
		AddressPage addressPage = accountPage.clickAddressBookBtn();
		addressPage.addNewAddress(new Address().createFakeAddress());
		Assert.assertTrue(addressPage.isAddressSavedMsgDisplayed(), "Address save confirmation message not displayed!");
	}

}
