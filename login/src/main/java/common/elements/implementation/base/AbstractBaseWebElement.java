package common.elements.implementation.base;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import common.elements.interfaces.base.IBaseWebElement;
import common.services.FluentWaitService;

public abstract class AbstractBaseWebElement<T> implements IBaseWebElement<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T assertDisplayed() throws Exception {
		Assertions.assertThat(isDisplayed(10)).as("Element is not displayed").isTrue();
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T assertNotDisplayed() throws Exception {
		Assertions.assertThat(isDisplayed(5)).as("Element is displayed").isFalse();
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T assertEnabled() throws Exception {
		Assertions.assertThat(isEnabled(10)).as("Element is not enabled").isTrue();
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T assertNotEnabled() throws Exception {
		Assertions.assertThat(isEnabled(5)).as("Element is enabled").isFalse();
		return (T) this;
	}

	protected boolean isDisplayed(long duration) {
		return FluentWaitService.fluentWaitIsDisplayed(getWebElement(), duration);
	}

	protected boolean isEnabled(long duration) {
		return FluentWaitService.fluentWaitIsEnabled(getWebElement(), duration);
	}

	protected WebElement getWebElementEnabledWithWait() {
		if (isEnabled(30)) {
			return getWebElement();
		} else {
			Assertions.fail("Element is not enabled to perform action");
			return null;
		}
	}

	protected abstract WebElement getWebElement();
}
