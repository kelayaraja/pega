import common.annotation.FlushCookies;
import common.annotation.WithBrowser;
import common.environment.driver.Browser;
import common.environment.UiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Cookie;

@WithBrowser(browser = Browser.chrome)
@RunWith(UiRunner.class)
public class InvalidLoginCookiesTest extends BaseTest {

	@Test
	@FlushCookies(before = true, after = true)
	public void testIfCookiesMissingMsgIsDisplayedWhenNoCookie() throws Exception {
		getBrowserUtil().launchWelcomePage();
		getWelcomeAssert().assertCookiesMissingOrWrongIsDisplayed();
	}

	@FlushCookies
	@Test
	public void testIfCookiesMissingMsgIsDisplayedWhenEditingCookie() throws Exception {
		//Adding cookies with invalid info
		Cookie cookie = new Cookie.Builder("tdses", "INVALID_VALUE")
				.domain("testing-ground.scraping.pro")
				.path("/").isSecure(false).isHttpOnly(false).build();
		getCookiesUtil().add(cookie);

		getBrowserUtil().launchWelcomePage();
		getWelcomeAssert().assertCookiesMissingOrWrongIsDisplayed();
	}

	@FlushCookies(before = true, after = true)
	@Test
	public void testIfAccessDeniedMsgDisplayedWithInvalidCredentials() throws Exception {
		getBrowserUtil().launchLoginPage();
		getLoginUi().login("admin", "admin");
		getLoginAssert().assertLoginIsNotSuccessfulWithAccessDenied();
		getCookiesAssert().assertCookiesAreEmpty();
	}

	@Test
	public void testIfAccessDeniedMsgDisplayedWithLoginMode() throws Exception {
		getBrowserUtil().open("http://testing-ground.scraping.pro/login?mode=login");
		getLoginAssert().assertLoginIsNotSuccessfulWithAccessDenied();
		getCookiesAssert().assertCookiesAreEmpty();
	}
}
