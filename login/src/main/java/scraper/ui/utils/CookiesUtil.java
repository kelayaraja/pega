package scraper.ui.utils;

import common.environment.TestEnvironment;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class CookiesUtil {

	private static final CookiesUtil ourInstance = new CookiesUtil();

	public static CookiesUtil getInstance() {
		return ourInstance;
	}

	private CookiesUtil() {
	}

	public Set<Cookie> get() {
		return TestEnvironment.getDriver().manage().getCookies();
	}

	public Cookie getCookieByName(String cookieName) {
		return TestEnvironment.getDriver().manage().getCookieNamed(cookieName);
	}

	public void add(Cookie cookie) {
		TestEnvironment.getDriver().manage().addCookie(cookie);
	}

	public void deleteCookie(Cookie cookie) {
		TestEnvironment.getDriver().manage().deleteCookie(cookie);
	}

	public void deleteAllCookies() {
		TestEnvironment.getDriver().manage().deleteAllCookies();
	}

	public void deleteCookieByName(String cookieName) {
		TestEnvironment.getDriver().manage().deleteCookieNamed(cookieName);
	}

	public String getCookiesAsString(String cookieName) {
		return getCookieByName(cookieName).toString();
	}

}
