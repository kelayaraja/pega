package common.environment;

import common.annotation.WithBrowser;
import common.environment.driver.Browser;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.rules.TestRule;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import java.util.List;

public class UiRunner extends BlockJUnit4ClassRunner {

	private static final Logger LOGGER = Logger.getLogger(UiRunner.class);

	public UiRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected List<TestRule> classRules() {
		BasicConfigurator.configure();
		List<TestRule> rules = super.classRules();
		WithBrowser browser = getTestClass().getJavaClass().getAnnotation(WithBrowser.class);
		TestEnvironment environment;
		if (browser != null) {
			environment = new TestEnvironment(browser.browser(), browser.withCookies());
		} else {
			LOGGER.info("Browser is not set in test, initializing firefox as default");
			environment = new TestEnvironment(Browser.fireFox, true);
		}
		rules.add(environment);
		return rules;
	}

}
