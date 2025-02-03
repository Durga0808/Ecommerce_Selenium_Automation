package ECommerce_Selenium_Automation.magento.Pages;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	@FindBy(className = "item-info")
    private List<WebElement> productList;

    @FindBy(css = ".price .cart-price .price")
    private List<WebElement> productPrices;

    @FindBy(css = ".input-text.qty")
    private List<WebElement> productQuantities;

    @FindBy(css = ".subtotal .cart-price .price")
    private List<WebElement> productSubtotals;

    @FindBy(css = "td[data-th='Discount'] .price")
    private List<WebElement> discount;

    @FindBy(css = ".totals-tax .price")
    private List<WebElement> tax;

    @FindBy(css = ".sub .price")
    private WebElement cartSubtotal;

    @FindBy(css = ".grand .price")
    private WebElement grandTotal;

    public CartPage() {
        super();
    }

    public NavBar getNavBar() {
        return new NavBar();
    }

    @SuppressWarnings("deprecation")
	public int getProductQuantity() {
        int initialQuantity = 0;
        for (WebElement productQuantity : productQuantities) {
			int quantity = Integer.parseInt(productQuantity.getAttribute("value"));
            initialQuantity += quantity;
        }
        return initialQuantity;
    }

    @SuppressWarnings("deprecation")
	public boolean isProductSubtotalValid() throws Exception {
        for (int i = 0; i < productList.size(); i++) {
            WebElement productPrice = productPrices.get(i);
            double price = extractDouble(productPrice.getText());
            WebElement productQuantity = productQuantities.get(i);
            int quantity = Integer.parseInt(productQuantity.getAttribute("value"));
            WebElement productSubtotal = productSubtotals.get(i);
            double subtotal = extractDouble(productSubtotal.getText());
            if (price * quantity != subtotal) {
                return false;
            }
        }
        return true;
    }

    public boolean isCartSubtotalValid() throws Exception {
        double expectedSubtotal = extractDouble(cartSubtotal.getText());
        double actualSubtotal = 0;
        for (WebElement productSubtotal : productSubtotals) {
            double subtotal = extractDouble(productSubtotal.getText());
            actualSubtotal += subtotal;
        }
        return actualSubtotal == expectedSubtotal;
    }

    public boolean isProductQuantityValid(int initialQuantity, int addedQuantity) {
        int finalQuantity = getProductQuantity();
        return initialQuantity + addedQuantity == finalQuantity;
    }

    public boolean isTotalValid() throws Exception {
        double totalValue = extractDouble(grandTotal.getText());
        double subtotalValue = extractDouble(cartSubtotal.getText());
        double discountValue = 0;
        double taxValue = 0;
        if (!discount.isEmpty()) {
            discountValue = extractDouble(discount.get(0).getText());
        }
        if (!tax.isEmpty()) {
            taxValue = extractDouble(tax.get(0).getText());
        }
        return subtotalValue - discountValue + taxValue == totalValue;
    }

    public static String extractMoneyValue(String text) throws Exception {
    	try {
        return DecimalFormat.getCurrencyInstance(Locale.US).parse(text).toString();
    	}catch(Exception e) {
    		return e.getMessage();
    	}
    }

    @SuppressWarnings("null")
	public double extractDouble(String text) throws Exception {
    	try {
        return Double.parseDouble(extractMoneyValue(text));
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	return (Double) null;
    	}
    }
}
