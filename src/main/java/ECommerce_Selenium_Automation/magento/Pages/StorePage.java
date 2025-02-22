package ECommerce_Selenium_Automation.magento.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends BasePage {
	@FindBy(className = "product-item-link")
	private List<WebElement> products;

	public StorePage() {
		super();
	}

	public ProductPage goToProductPage(String productName) {
		if (productName.equals("Random")) {
			return selectRandomProduct();
		}
		return selectProduct(productName);
	}

	public NavBar getNavBar() {
		return new NavBar();
	}

	public ProductPage selectRandomProduct() {
		Random random = new Random();
		WebElement randomProduct = products.get(random.nextInt(products.size() - 1));
		randomProduct.click();
		return new ProductPage();
	}

	public ProductPage selectProduct(String productName) {
		WebElement selectedProduct = products.stream().filter(p -> productName.equals(p.getText())).findFirst()
				.orElseThrow(RuntimeException::new);
		selectedProduct.click();
		return new ProductPage();
	}

	public void addProductsToCart(int quantity) {
		for (int i = 0; i < quantity; i++) {
			ProductPage productPage = this.selectRandomProduct();
			productPage.addProductToCart();
			productPage.goBackToCategory();
		}
	}
}
