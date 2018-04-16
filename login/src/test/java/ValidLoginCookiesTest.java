import common.annotation.AddWebScrapperCookie;
import common.annotation.FlushCookies;
import common.annotation.WithBrowser;
import common.environment.driver.Browser;
import common.environment.UiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@WithBrowser(browser = Browser.fireFox)
@RunWith(UiRunner.class)
public class ValidLoginCookiesTest extends BaseTest {

	@FlushCookies
	@Test
	public void testIfLoginSuccessAndCookiesStored() throws Exception {

		getBrowserUtil().launchLoginPage();
		getLoginAssert().assertLoginPageIsLoaded();
		getCookiesAssert().assertCookiesAreEmpty();

		getLoginUi().loginAsAdmin();
		getWelcomeAssert().assertWelcomeIsDisplayed().assertGoBackLinkDisplayed();
		getCookiesAssert().assertNumberOfCookies(1)
				.assertCookieName("tdsess")
				.assertCookieValue("TEST_DRIVE_SESSION")
				.assertCookieDomain("testing-ground.scraping.pro")
				.assertCookiePath("/");
	}

	@Test
	@AddWebScrapperCookie
	@FlushCookies
	public void testIfSessionIsPreservedWhenRefreshing() throws Exception {
		getCookiesAssert().assertCookiesAreNotEmpty().assertNumberOfCookies(1);
		getBrowserUtil().launchWelcomePage();
		getWelcomeAssert().assertWelcomeIsDisplayed();

		getBrowserUtil().refresh();
		getWelcomeAssert().assertWelcomeIsDisplayed();
		getCookiesAssert().assertCookiesAreNotEmpty().assertNumberOfCookies(1);
	}

	@Test
	public void testIfCookiesDeletedWhenClickingGoBackLink() throws Exception {
		getBrowserUtil().launchLoginPage();
		getLoginUi().loginAsAdmin();
		getWelcomeAssert().assertWelcomeIsDisplayed();
		getCookiesAssert().assertCookiesAreNotEmpty().assertNumberOfCookies(1);

		getWelcomeUI().clickGoBackLink();
		getLoginAssert().assertLoginPageIsLoaded();
		getCookiesAssert().assertNumberOfCookies(0).assertCookiesAreEmpty();
	}

	@FlushCookies
	@Test
	public void testIfCookiesPreservedWhenClickingBackButton() throws Exception {
		getBrowserUtil().launchLoginPage();
		getLoginUi().loginAsAdmin();
		getWelcomeAssert().assertWelcomeIsDisplayed();
		getCookiesAssert().assertCookiesAreNotEmpty().assertNumberOfCookies(1);

		getBrowserUtil().back();
		getCookiesAssert().assertCookiesAreNotEmpty()
				.assertNumberOfCookies(1)
				.assertCookieName("tdsess");
	}

	@FlushCookies
	@Test
	public void testIfCookiesDoNotContainSensitiveInfo() throws Exception {
		getBrowserUtil().launchLoginPage();
		getLoginUi().loginAsAdmin();
		getLoginAssert().assertLoginIsSuccessful();
		getCookiesAssert().assertCookiesAreNotEmpty()
				.assertNumberOfCookies(1)
				.assertUserCredentialsNotStored("tdsess", "admin", "12345");
	}

}
