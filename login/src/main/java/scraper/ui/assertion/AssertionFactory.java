package scraper.ui.assertion;

public class AssertionFactory {

	public static LoginAssertions getLoginAssert() {
		return LoginAssertions.getInstance();
	}

	public static WelcomeAssertions getWelcomeAssert() {
		return WelcomeAssertions.getInstance();
	}

	public static CookiesAssertions getCookiesAssert() {
		return CookiesAssertions.getInstance();
	}
}
