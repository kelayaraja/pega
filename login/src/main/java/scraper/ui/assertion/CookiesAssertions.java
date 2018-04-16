package scraper.ui.assertion;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Cookie;
import scraper.ui.utils.CookiesUtil;

import java.util.Set;

public class CookiesAssertions {

	private static final CookiesAssertions ourInstance = new CookiesAssertions();

	public static CookiesAssertions getInstance() {
		return ourInstance;
	}

	private CookiesAssertions() {
	}

	private CookiesUtil fCookiesUtil = CookiesUtil.getInstance();

	public CookiesAssertions assertCookiesAreNotEmpty() {
		Assertions.assertThat(fCookiesUtil.get().size()).as("Cookies are empty").isGreaterThan(0);
		return this;
	}

	public CookiesAssertions assertNumberOfCookies(int expectedCount) {
		Assertions.assertThat(fCookiesUtil.get().size()).isEqualTo(expectedCount);
		return this;
	}

	public CookiesAssertions assertCookiesAreEmpty() {
		Assertions.assertThat(fCookiesUtil.get().size()).as("Cookies are not empty").isEqualTo(0);
		return this;
	}

	public CookiesAssertions assertCookieName(String expectedCookieName) {
		assertCookiesAreNotEmpty();
		Cookie cookie = fCookiesUtil.getCookieByName(expectedCookieName);
		Assertions.assertThat(cookie).as("Cookie is not present for name: " + expectedCookieName).isNotNull();
		Assertions.assertThat(cookie.getName()).isEqualTo(expectedCookieName);
		return this;
	}

	public CookiesAssertions assertCookieValue(String expectedValue) {
		boolean found = false;
		assertCookiesAreNotEmpty();
		Set<Cookie> cookies = fCookiesUtil.get();
		for (Cookie cookie : cookies) {
			if (cookie.getValue().contains(expectedValue)) {
				found = true;
				break;
			}
		}
		Assertions.assertThat(found).as("Cookie is not present for value: " + expectedValue).isTrue();
		return this;
	}

	public CookiesAssertions assertCookieDomain(String expectedDomain) {
		boolean found = false;
		assertCookiesAreNotEmpty();
		Set<Cookie> cookies = fCookiesUtil.get();
		for (Cookie cookie : cookies) {
			if (cookie.getDomain().contains(expectedDomain)) {
				found = true;
				break;
			}
		}
		Assertions.assertThat(found).as("Cookie is not present for domain: " + expectedDomain).isTrue();
		return this;
	}

	public CookiesAssertions assertCookiePath(String expectedPath) {
		boolean found = false;
		assertCookiesAreNotEmpty();
		Set<Cookie> cookies = fCookiesUtil.get();
		for (Cookie cookie : cookies) {
			if (cookie.getPath().contains(expectedPath))
				found = true;
		}
		Assertions.assertThat(found).as("Cookie is not present for path: " + expectedPath).isTrue();
		return this;
	}

	public CookiesAssertions assertUserCredentialsNotStored(String cookieName, String userName, String password) {
		assertCookiesAreNotEmpty();
		Assertions.assertThat(fCookiesUtil.getCookiesAsString(cookieName))
				.doesNotContain(userName)
				.doesNotContain(password);
		return this;
	}
}
