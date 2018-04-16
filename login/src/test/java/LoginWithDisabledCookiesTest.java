import common.annotation.WithBrowser;
import common.environment.driver.Browser;
import common.environment.UiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@WithBrowser(browser = Browser.fireFox, withCookies = false)
@RunWith(UiRunner.class)
public class LoginWithDisabledCookiesTest extends BaseTest {

	@Test
	public void testIfLoginIsSuccessfulAndCookiesAreNotStored() throws Exception {

		getBrowserUtil().launchLoginPage();
		getLoginAssert().assertLoginPageIsLoaded();
		getCookiesAssert().assertCookiesAreEmpty();

		getLoginUi().loginAsAdmin();
		getCookiesAssert().assertCookiesAreEmpty();
		getWelcomeAssert().assertCookiesMissingOrWrongIsDisplayed();
	}

}
