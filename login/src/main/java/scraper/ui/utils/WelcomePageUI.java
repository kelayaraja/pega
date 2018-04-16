package scraper.ui.utils;

import common.elements.UiElementsFactory;
import common.elements.interfaces.ILink;
import common.environment.TestEnvironment;
import org.openqa.selenium.support.PageFactory;
import scraper.ui.pagefactory.WelcomePageUIElements;

public class WelcomePageUI {

	private static final WelcomePageUI ourInstance = new WelcomePageUI();

	public static WelcomePageUI getInstance() {
		return ourInstance;
	}

	private WelcomePageUI() {
	}

	private WelcomePageUIElements getPage() {
		return PageFactory.initElements(TestEnvironment.getDriver(), WelcomePageUIElements.class);
	}

	public void clickGoBackLink() throws Exception {
		ILink goBackLink = UiElementsFactory.getLink(getPage().getGoBackLink());
		goBackLink.assertDisplayed().click();
	}

}
