package common.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class FluentWaitService {
	private static final Logger LOGGER = Logger.getLogger(FluentWaitService.class);

	public static boolean fluentWaitIsDisplayed(WebElement element, long duration) {
		final boolean[] isDisplayed = new boolean[1];
		isDisplayed[0] = false;
		try {
			new FluentWait<>(element)
					.withTimeout(Duration.ofSeconds(duration))
					.pollingEvery(Duration.ofMillis(500))
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.until(element1 -> {
						LOGGER.info("### Waiting for element to be displayed ###: " + element);
						try {
							isDisplayed[0] = element1.isEnabled() && element1.isDisplayed();
							return isDisplayed[0];
						} catch (Exception e) {
							isDisplayed[0] = false;
							return isDisplayed[0];
						}
					});
			return isDisplayed[0];
		} catch (TimeoutException timeoutException) {
			LOGGER.info(timeoutException.getMessage());
			return isDisplayed[0];
		}
	}

	public static boolean fluentWaitIsEnabled(WebElement element, long duration) {
		final boolean[] isEnabled = new boolean[1];
		isEnabled[0] = false;
		try {
			new FluentWait<>(element)
					.withTimeout(Duration.ofSeconds(duration))
					.pollingEvery(Duration.ofMillis(500))
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.until(element1 -> {
						LOGGER.info("### Waiting for element to be enabled ###: " + element);
						try {
							isEnabled[0] = element1.isEnabled();
							return isEnabled[0];
						} catch (Exception e) {
							isEnabled[0] = false;
							return isEnabled[0];
						}
					});
			return isEnabled[0];
		} catch (TimeoutException timeoutException) {
			LOGGER.info(timeoutException.getMessage());
			return isEnabled[0];
		}
	}
}
