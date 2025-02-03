package ECommerce_Selenium_Automation.magento.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhisListPage extends BasePage {

	@FindBy(className = "message-success")
	private WebElement productWishlistMsg;

	public WhisListPage() {
		super();
	}

	public boolean isProductWishlistMsgDisplayed() {
		return productWishlistMsg.isDisplayed();
	}

}
