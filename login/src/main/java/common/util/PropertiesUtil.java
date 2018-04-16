package common.util;

import common.environment.driver.Browser;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static final String PATH_PROPERTY_CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String PATH_PROPERTY_FIREFOX_DRIVER = "webdriver.gecko.driver";
	public static final String FIREFOX_NETWORK_COOKIE_BEHAVIOR = "network.cookie.cookieBehavior";
	public static final String CHROME_NETWORK_COOKIES_BEHAVIOR = "profile.default_content_settings.cookies";

	private PropertiesUtil() {
	}

	public static String getProperty(Browser browser) throws IOException {
		Properties properties = new Properties();
		InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("driver.properties");
		properties.load(resourceAsStream);
		switch (browser) {
			case chrome:
				return properties.getProperty(PATH_PROPERTY_CHROME_DRIVER);
			case fireFox:
				return properties.getProperty(PATH_PROPERTY_FIREFOX_DRIVER);
		}
		Assertions.fail(String.format("Provided choice %s is not valid", browser));
		return null;
	}

}
