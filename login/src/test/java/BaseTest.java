import common.annotation.implementation.AddWebScrapperCookieRule;
import common.annotation.implementation.FlushCookiesRule;
import common.environment.ScreenShot;
import common.util.BrowserUtil;
import org.junit.Rule;
import scraper.ui.assertion.AssertionFactory;
import scraper.ui.assertion.CookiesAssertions;
import scraper.ui.assertion.LoginAssertions;
import scraper.ui.assertion.WelcomeAssertions;
import scraper.ui.utils.CookiesUtil;
import scraper.ui.utils.LoginUI;
import scraper.ui.utils.WelcomePageUI;

public abstract class BaseTest {

	@Rule
	public ScreenShot screenshot = new ScreenShot();

	@Rule
	public AddWebScrapperCookieRule addCookie = new AddWebScrapperCookieRule();

	@Rule
	public FlushCookiesRule flushCookies = new FlushCookiesRule();

	private BrowserUtil fBrowserUtil = BrowserUtil.getInstance();
	private LoginUI fLoginUi = LoginUI.getInstance();
	private LoginAssertions fLoginAssert = AssertionFactory.getLoginAssert();
	private WelcomeAssertions fWelcomeAssert = AssertionFactory.getWelcomeAssert();
	private CookiesAssertions fCookiesAssert = AssertionFactory.getCookiesAssert();
	private CookiesUtil fCookiesUtil = CookiesUtil.getInstance();
	private WelcomePageUI fWelcomeUI = WelcomePageUI.getInstance();

	protected ScreenShot getScreenshot() {
		return screenshot;
	}

	protected AddWebScrapperCookieRule getAddCookie() {
		return addCookie;
	}

	protected FlushCookiesRule getFlushCookies() {
		return flushCookies;
	}

	protected BrowserUtil getBrowserUtil() {
		return fBrowserUtil;
	}

	protected LoginUI getLoginUi() {
		return fLoginUi;
	}

	protected LoginAssertions getLoginAssert() {
		return fLoginAssert;
	}

	protected WelcomeAssertions getWelcomeAssert() {
		return fWelcomeAssert;
	}

	protected CookiesAssertions getCookiesAssert() {
		return fCookiesAssert;
	}

	protected CookiesUtil getCookiesUtil() {
		return fCookiesUtil;
	}

	protected WelcomePageUI getWelcomeUI() {
		return fWelcomeUI;
	}
}
