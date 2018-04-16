package common.elements.implementation;

import common.elements.implementation.base.AbstractBaseWebElement;
import common.elements.interfaces.IButton;

public abstract class AbstractButton extends AbstractBaseWebElement<IButton> implements IButton {

	@Override
	public void click() throws Exception {
		getWebElementEnabledWithWait().click();
	}


}
