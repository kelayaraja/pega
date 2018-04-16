package common.environment;

import common.environment.DriverProvider.Driver;
import common.environment.driver.Browser;
import org.apache.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestEnvironment extends TestWatcher {

	private static final Logger LOGGER = Logger.getLogger(TestEnvironment.class);
	private static final ThreadLocal<Driver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

	private final Browser fBrowser;
	private final boolean fEnableCookies;

	TestEnvironment(Browser browser, boolean enableCookies) {
		fBrowser = browser;
		fEnableCookies = enableCookies;
	}

	@Override
	protected void starting(Description description) {
		try {
			Driver driver = DriverProvider.getDriver(fBrowser, fEnableCookies);
			DRIVER_THREAD_LOCAL.set(driver);
		} catch (IOException e) {
			LOGGER.error("Error while initiating driver", e);
		}
		super.starting(description);
	}

	@Override
	protected void finished(Description description) {
		DRIVER_THREAD_LOCAL.get().quitDriver();
		super.finished(description);
	}

	public static WebDriver getDriver() {
		return DRIVER_THREAD_LOCAL.get().getWebDriver();
	}
}
