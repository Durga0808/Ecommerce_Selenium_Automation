package ECommerce_Selenium_Automation.magento.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import ECommerce_Selenium_Automation.magento.Data.Address;

public class AddressPage extends BasePage {
	@FindBy(id = "telephone")
	private WebElement phoneNumberField;

	@FindBy(id = "street_1")
	private WebElement streetAddressField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "region_id")
	private WebElement stateList;
	
	@FindBy(id = "region")
	private WebElement stateInputField;

	@FindBy(id = "zip")
	private WebElement zipCodeField;

	@FindBy(id = "country")
	private WebElement countryList;

	@FindBy(className = "save")
	private WebElement saveAddressBtn;

	@FindBy(className = "page-title")
	private WebElement pageTitle;
	
	@FindBy(className = "add")
	private WebElement addAddressBtn;

	@FindBy(className = "message-success")
	private WebElement addressSavedMsg;

	public AddressPage() {
		super();
	}

	public void addNewAddress(Address address) {
		if(isAddAddressBtnDisplayed()) {
			addAddressBtn.click();
		}
		fillAddressFields(address);
		saveAddressBtn.click();
	}

	public void fillAddressFields(Address address) {
		phoneNumberField.sendKeys(address.getPhoneNumber());
		streetAddressField.sendKeys(address.getStreetAddress());
		cityField.sendKeys(address.getCity());
		Select countrySelect = new Select(countryList);
		countrySelect.selectByVisibleText(address.getCountry());
		Select stateSelect = new Select(stateList);
		if(stateSelect.getOptions().size()>1) {
			stateSelect.selectByVisibleText(address.getState());

		}else {
			stateInputField.sendKeys(address.getState());
		}
		zipCodeField.sendKeys(address.getZipCode());
	}

	public boolean isPageTitileDisplayed() {
		return pageTitle.isDisplayed();
	}
	
	public boolean isAddAddressBtnDisplayed() {
		return addAddressBtn.isDisplayed();
	}

	public boolean isAddressSavedMsgDisplayed() {
		return addressSavedMsg.isDisplayed();
	}
}
