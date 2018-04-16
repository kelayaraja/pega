package common.elements.implementation;

import common.elements.implementation.base.AbstractBaseText;
import common.elements.interfaces.ITextBox;

public abstract class AbstractTextBox extends AbstractBaseText<ITextBox> implements ITextBox {

	@Override
	public void setText(String value) throws Exception {
		getWebElementEnabledWithWait().clear();
		getWebElementEnabledWithWait().sendKeys(value);
	}
}
