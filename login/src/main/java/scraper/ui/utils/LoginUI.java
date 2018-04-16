package scraper.ui.utils;

import common.elements.UiElementsFactory;
import common.elements.interfaces.ITextBox;
import common.environment.TestEnvironment;
import org.openqa.selenium.support.PageFactory;
import scraper.ui.pagefactory.LoginPageUIElements;

public class LoginUI {

	private static final LoginUI ourInstance = new LoginUI();

	public static LoginUI getInstance() {
		return ourInstance;
	}

	private LoginUI() {
	}

	private LoginPageUIElements getPage() {
		return PageFactory.initElements(TestEnvironment.getDriver(), LoginPageUIElements.class);
	}

	public void loginAsAdmin() throws Exception {
		this.login("admin", "12345");
	}

	public void login(String userName, String password) throws Exception {
		ITextBox userNameField = UiElementsFactory.getTextBox(getPage().getUserName());
		userNameField.assertDisplayed().setText(userName);

		ITextBox pwdField = UiElementsFactory.getTextBox(getPage().getPassword());
		pwdField.assertDisplayed().setText(password);

		UiElementsFactory.getButton(getPage().getLoginButton()).assertDisplayed().click();
	}

}
