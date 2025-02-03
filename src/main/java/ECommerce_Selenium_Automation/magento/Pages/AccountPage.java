package ECommerce_Selenium_Automation.magento.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

	public AccountPage() {
		super();
	}

    @FindBy(className = "success")
    private WebElement registrationMsg;

    @FindBy(css = ".nav li:nth-of-type(6) a")
    private WebElement addressBookBtn;
    
    @FindBy(xpath = "//div[@class='box-content']//p")
    private WebElement contactInfo;
    
    public String getContactInfo() {
    	return this.contactInfo.getText();
    }
    public AddressPage clickAddressBookBtn() {
        addressBookBtn.click();
        return new AddressPage();
    }

    public boolean isRegistrationMsgDisplayed() {
        return registrationMsg.isDisplayed();
    }
}
