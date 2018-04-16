package scraper.ui.assertion;

import common.elements.UiElementsFactory;
import common.elements.interfaces.ILink;
import common.elements.interfaces.IText;
import common.environment.TestEnvironment;
import org.openqa.selenium.support.PageFactory;
import scraper.ui.pagefactory.WelcomePageUIElements;

public class WelcomeAssertions {

	private static final WelcomeAssertions ourInstance = new WelcomeAssertions();

	public static WelcomeAssertions getInstance() {
		return ourInstance;
	}

	private WelcomeAssertions() {
	}

	private WelcomePageUIElements getPage() {
		return PageFactory.initElements(TestEnvironment.getDriver(), WelcomePageUIElements.class);
	}

	public WelcomeAssertions assertGoBackLinkDisplayed() throws Exception {
		ILink goBack = UiElementsFactory.getLink(getPage().getGoBackLink());
		goBack.assertDisplayed().assertEnabled();
		return this;
	}

	public WelcomeAssertions assertCookiesMissingOrWrongIsDisplayed() throws Exception {
		IText cookieMissingTxt = UiElementsFactory.getText(getPage().getCookingMissingText());
		cookieMissingTxt.assertDisplayed()
				.assertTextEqualsTo("THE SESSION COOKIE IS MISSING OR HAS A WRONG VALUE!");
		return this;
	}

	public WelcomeAssertions assertWelcomeIsDisplayed() throws Exception {
		IText welcomeText = UiElementsFactory.getText(getPage().getWelcomeText());
		welcomeText.assertDisplayed().assertTextEqualsTo("WELCOME :)");
		return this;
	}
}
