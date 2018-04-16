package common.environment;

import common.environment.driver.Browser;
import common.util.PropertiesUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static common.environment.driver.Browser.chrome;
import static common.environment.driver.Browser.fireFox;
import static common.util.PropertiesUtil.*;

public class DriverProvider {

	private static final Logger LOGGER = Logger.getLogger(DriverProvider.class);

	static Driver getDriver(Browser browser, boolean enableCookies) throws IOException {
		return new Driver(browser, enableCookies);
	}

	private DriverProvider() {
	}

	static class Driver {
		private WebDriver fDriver;
		private final Browser fBrowser;
		private final boolean fEnableCookies;

		Driver(Browser browser, boolean enableCookies) throws IOException {
			this.fBrowser = browser;
			this.fEnableCookies = enableCookies;
			initializeDriver();
		}

		WebDriver getWebDriver() {
			return fDriver;
		}

		void quitDriver() {
			fDriver.quit();
			LOGGER.info("Driver quit successfully");
		}

		private void initializeDriver() throws IOException {
			switch (fBrowser) {
				case chrome:
					initializeChromeDriver();
					break;
				case fireFox:
					initializeFirefoxDriver();
					break;
				default:
					LOGGER.info("Initializing default common.environment.driver");
					initializeFirefoxDriver();
			}
		}

		private void initializeFirefoxDriver() throws IOException {
			System.setProperty(PATH_PROPERTY_FIREFOX_DRIVER, PropertiesUtil.getProperty(fireFox));
			if (fEnableCookies) {
				fDriver = new FirefoxDriver();
			} else {
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference(FIREFOX_NETWORK_COOKIE_BEHAVIOR, 2);

				FirefoxOptions options = new FirefoxOptions();
				options.setProfile(profile);

				fDriver = new FirefoxDriver(options);
			}
			LOGGER.info("Successfully launched fireFox common.environment.driver");
		}

		private void initializeChromeDriver() throws IOException {
			LOGGER.info("Initializing Chrome webDriver");
			System.setProperty(PATH_PROPERTY_CHROME_DRIVER, PropertiesUtil.getProperty(chrome));
			ChromeDriverService driverService = ChromeDriverService.createDefaultService();

			ChromeOptions options = new ChromeOptions();
			options.addArguments(Arrays.asList("allow-running-insecure-content", "ignore-certificate-errors"));

			if (!fEnableCookies) {
				Map<String, Integer> preference = new HashMap<>();
				preference.put(CHROME_NETWORK_COOKIES_BEHAVIOR, 2);
				options.setExperimentalOption("prefs", preference);
			}

			fDriver = new ChromeDriver(driverService, options);
			LOGGER.info("Successfully launched chrome common.environment.driver");
		}

	}
}
