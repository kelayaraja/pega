package scraper.ui.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePageUIElements {

	@FindBy(xpath = Locators.TXT_WELCOME)
	private WebElement welcomeText;

	@FindBy(xpath = Locators.LINK_GO_BACK)
	private WebElement goBackLink;

	@FindBy(xpath = Locators.TXT_COOKING_MISSING)
	private WebElement cookingMissingText;

	public WebElement getWelcomeText() {
		return welcomeText;
	}

	public WebElement getGoBackLink() {
		return goBackLink;
	}

	public WebElement getCookingMissingText() {
		return cookingMissingText;
	}
}
