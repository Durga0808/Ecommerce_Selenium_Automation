package ECommerce_Selenium_Automation.magento.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ECommerce_Selenium_Automation.magento.Data.User;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage() {

	}

	@FindBy(id = "firstname")
	private WebElement firstNameField;

	@FindBy(id = "lasttname")
	private WebElement lastNameField;

	@FindBy(id = "email_address")
	private WebElement emailField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "password-confirmation")
	private WebElement confirmPasswordField;

	@FindBy(className = "submit")
	private WebElement submitBtn;

	public WebElement getFirstName() {
		return firstNameField;
	}

	public WebElement getLastName() {
		return lastNameField;
	}

	public WebElement getEmailAddress() {
		return emailField;
	}

	public WebElement getPassword() {
		return passwordField;
	}

	public WebElement getPasswordConfirmation() {
		return confirmPasswordField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public AccountPage registerAccount(User user) {
		fillRegistrationFields(user);
		submitBtn.click();
		return new AccountPage();
	}

	private void fillRegistrationFields(User user) {
		// TODO Auto-generated method stub
		firstNameField.sendKeys(user.getFirstName());
		lastNameField.sendKeys(user.getLastName());
		emailField.sendKeys(user.getEmail());
		passwordField.sendKeys(user.getPassword());
		confirmPasswordField.sendKeys(user.getPassword());

	}

}
