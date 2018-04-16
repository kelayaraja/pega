package common.annotation.implementation;

import common.annotation.AddWebScrapperCookie;
import common.util.BrowserUtil;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Cookie;
import scraper.ui.utils.CookiesUtil;

public class AddWebScrapperCookieRule extends TestWatcher {

	@Override
	protected void starting(Description description) {
		try {
			AddWebScrapperCookie addCookie = description.getTestClass().getMethod(description.getMethodName())
					.getAnnotation(AddWebScrapperCookie.class);
			if (addCookie != null)
				setCookies();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		super.starting(description);
	}

	private void setCookies() {
		BrowserUtil.getInstance().launchLoginPage();
		Cookie cookie = new Cookie.Builder("tdsess", "TEST_DRIVE_SESSION")
				.domain("testing-ground.scraping.pro")
				.path("/").isSecure(false).isHttpOnly(false).build();
		CookiesUtil.getInstance().add(cookie);
	}
}
