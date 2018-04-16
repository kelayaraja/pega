package common.elements.interfaces;

import common.elements.interfaces.base.IBaseText;

public interface ITextBox extends IBaseText<ITextBox> {
	void setText(String value) throws Exception;
}
