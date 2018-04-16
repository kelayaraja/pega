package scraper.ui.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageUIElements {

	@FindBy(css = Locators.TXT_BOX_USER_NAME)
	private WebElement userName;

	@FindBy(css = Locators.TXT_BOX_PASSWORD)
	private WebElement password;

	@FindBy(css = Locators.BTN_LOGIN)
	private WebElement loginButton;

	@FindBy(xpath = Locators.TXT_ACCESS_DENIED)
	private WebElement accessDeniedText;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getAccessDeniedText() {
		return accessDeniedText;
	}
}
