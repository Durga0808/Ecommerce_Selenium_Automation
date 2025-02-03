package ECommerce_Selenium_Automation.magento.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage() {
		super();
	}

	
	@FindBy(linkText = "Create an Account")
	private WebElement createAccountBtn;
	
	@FindBy(css = "li.authorization-link a")
	private WebElement signInBtn;
	
    @FindBy(className = "logged-in")
    private WebElement loggedInMsg;
    
    @FindBy(className = "switch")
    private WebElement accountMenuBtn;

    @FindBy(css = ".customer-menu li:nth-of-type(1)")
    private WebElement myAccountBtn;

	public WebElement getCreateAccount() {
		return createAccountBtn;
	}

	public WebElement getSignIn() {
		return signInBtn;
	}
	
	public WebElement getloggedInMsg() {
		return loggedInMsg;
	}
    public CreateAccountPage clickCreateAnAccountButton() {
    	createAccountBtn.click();
        return new CreateAccountPage();
    }
    public LoginPage clickSignIn() {
        signInBtn.click();
        return new LoginPage();
    }

    public boolean isLoggedInMsgDisplayed() {
        return loggedInMsg.isDisplayed();
    }

    public void clickAccountMenuBtn() {
        accountMenuBtn.click();
    }
    public AccountPage clickMyAccountBtn() {
        clickAccountMenuBtn();
        myAccountBtn.click();
        return new AccountPage();
    }
    
    public void gotoHomePage() {
		driver.get("https://magento.softwaretestingboard.com/");
    }

    public NavBar getNavBar() {
        return new NavBar();
    }
    
}
