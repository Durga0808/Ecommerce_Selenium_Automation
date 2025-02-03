package ECommerce_Selenium_Automation.magento;

import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Selenium_Automation.magento.Pages.CartPage;
import ECommerce_Selenium_Automation.magento.Pages.HomePage;
import ECommerce_Selenium_Automation.magento.Pages.LoginPage;
import ECommerce_Selenium_Automation.magento.Pages.StorePage;
import io.qameta.allure.Description;

public class CartTest extends BaseTest {

	@Test
	@Description("Verify the ability to add products to cart")
	public void verifyAddProductsToCart() throws Exception {
		LoginPage loginPage = homePage.clickSignIn();
		HomePage homePage = loginPage.login("automationdurga08@gmail.com", "Dp143$$$");
		int productQuantity = 3;
		StorePage storePage = homePage.getNavBar().selectCategory("Men", "Tops", "Tees");
		storePage.addProductsToCart(productQuantity);
		CartPage cartPage = storePage.getNavBar().goToCart();
		Assert.assertTrue(cartPage.isProductSubtotalValid());
		Assert.assertTrue(cartPage.isCartSubtotalValid());
		Assert.assertTrue(cartPage.isTotalValid());
	}

}
