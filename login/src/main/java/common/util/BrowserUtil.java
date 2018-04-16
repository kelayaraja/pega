package common.util;

import common.environment.TestEnvironment;

public class BrowserUtil {

	private static final BrowserUtil ourInstance = new BrowserUtil();

	public static BrowserUtil getInstance() {
		return ourInstance;
	}

	private BrowserUtil() {
	}

	public void open(String url) {
		TestEnvironment.getDriver().navigate().to(url);
	}

	public void refresh() {
		TestEnvironment.getDriver().navigate().refresh();
	}

	public void back() {
		TestEnvironment.getDriver().navigate().back();
	}

	public void launchLoginPage() {
		this.open("http://testing-ground.scraping.pro/login");
	}

	public void launchWelcomePage() {
		this.open("http://testing-ground.scraping.pro/login?mode=welcome");
	}
}
