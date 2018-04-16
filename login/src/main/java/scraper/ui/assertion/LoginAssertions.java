package scraper.ui.assertion;

import common.elements.UiElementsFactory;
import common.elements.interfaces.IText;
import common.elements.interfaces.ITextBox;
import common.environment.TestEnvironment;
import org.openqa.selenium.support.PageFactory;
import scraper.ui.pagefactory.LoginPageUIElements;
import scraper.ui.pagefactory.WelcomePageUIElements;

public class LoginAssertions {

	private static final LoginAssertions ourInstance = new LoginAssertions();

	public static LoginAssertions getInstance() {
		return ourInstance;
	}

	private LoginAssertions() {
	}

	public LoginAssertions assertLoginPageIsLoaded() throws Exception {
		ITextBox userName = UiElementsFactory.getTextBox(getLoginPage().getUserName());
		userName.assertDisplayed().assertEnabled();

		ITextBox password = UiElementsFactory.getTextBox(getLoginPage().getPassword());
		password.assertDisplayed().assertEnabled();
		return this;
	}

	public LoginAssertions assertLoginIsSuccessful() throws Exception {
		IText welcomeText = UiElementsFactory.getText(getWelcomePage().getWelcomeText());
		welcomeText.assertDisplayed().assertTextEqualsTo("WELCOME :)");
		return this;
	}

	public LoginAssertions assertLoginIsNotSuccessfulWithAccessDenied() throws Exception {
		IText accessDenied = UiElementsFactory.getText(getLoginPage().getAccessDeniedText());
		accessDenied.assertDisplayed().assertTextEqualsTo("ACCESS DENIED!");
		return this;
	}

	private LoginPageUIElements getLoginPage() {
		return PageFactory.initElements(TestEnvironment.getDriver(), LoginPageUIElements.class);
	}

	private WelcomePageUIElements getWelcomePage() {
		return PageFactory.initElements(TestEnvironment.getDriver(), WelcomePageUIElements.class);
	}
}
