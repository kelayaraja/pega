package common.elements.implementation.base;

import common.elements.interfaces.base.IBaseText;
import org.assertj.core.api.Assertions;

public abstract class AbstractBaseText<U> extends AbstractBaseWebElement<U> implements IBaseText<U> {

	@SuppressWarnings("unchecked")
	@Override
	public U assertTextEqualsTo(String stringToAssert) throws Exception {
		Assertions.assertThat(getText()).as("Actual and expected are not same").isEqualTo(stringToAssert);
		return (U) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public U assertTextContains(String stringToAssert) throws Exception {
		Assertions.assertThat(getText()).as("Actual does not contain expected").contains(stringToAssert);
		return (U) this;
	}

	protected String getText() throws Exception {
		return getWebElementEnabledWithWait().getText();
	}
}
