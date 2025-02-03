package ECommerce_Selenium_Automation.magento;

import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce_Selenium_Automation.magento.Pages.HomePage;
import ECommerce_Selenium_Automation.magento.Pages.LoginPage;
import ECommerce_Selenium_Automation.magento.Pages.StorePage;
import ECommerce_Selenium_Automation.magento.Pages.WhisListPage;
import io.qameta.allure.Description;

public class WhisListPageTest extends BaseTest {

	@Test
	@Description("Verify the ability to add products to Wishlist")
	public void verifyAddProductToWishlist() {

		LoginPage loginPage = homePage.clickSignIn();
		HomePage homePage = loginPage.login("automationdurga08@gmail.com", "Dp143$$$");
        StorePage storePage = homePage.getNavBar().selectCategory("What's New");
        WhisListPage wishlistPage = storePage.goToProductPage("Random").wishlistProduct();
        Assert.assertTrue(wishlistPage.isProductWishlistMsgDisplayed());
        storePage = homePage.getNavBar().selectCategory("Men", "Tops", "Tees");
        wishlistPage = storePage.goToProductPage("Zoltan Gym Tee").wishlistProduct();
        Assert.assertTrue(wishlistPage.isProductWishlistMsgDisplayed());
	}

}
