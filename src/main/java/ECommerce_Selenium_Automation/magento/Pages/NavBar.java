package ECommerce_Selenium_Automation.magento.Pages;

import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NavBar extends BasePage {

	@FindBy(css = "a.level-top")
	private List<WebElement> categories;

	@FindBy(css = ".parent .category-item a")
	private List<WebElement> subcategories;

	public NavBar() {
		super();
	}

	public StorePage selectCategory(String categoryName, String... subcategoryNames) {
		// if category passed as param matches, will be stored in variable, otherwise
		// will throw exception
		WebElement selectedCategory = categories.stream().filter(c -> categoryName.equals(c.getText())).findFirst()
				.orElseThrow(RuntimeException::new);
		// check if varargs are passed to the method
		if (!ArrayUtils.isEmpty(subcategoryNames)) {
			hover(selectedCategory);
			for (String subcategoryName : subcategoryNames) {
				selectedCategory = subcategories.stream().filter(sc -> subcategoryName.equals(sc.getText())).findFirst()
						.orElseThrow(RuntimeException::new);
				hover(selectedCategory);
			}
		}
		selectedCategory.click();
		return new StorePage();
	}

	public CartPage goToCart() {
		// TODO Auto-generated method stub
        driver.get("https://magento.softwaretestingboard.com/checkout/cart/");
        return new CartPage();
	}
}
