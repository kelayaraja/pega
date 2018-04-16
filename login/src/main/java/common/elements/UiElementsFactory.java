package common.elements;

import common.elements.implementation.*;
import common.elements.interfaces.*;
import org.openqa.selenium.WebElement;

public class UiElementsFactory {

	public static IWebElement getCustomWebElement(final WebElement element) {
		return new AbstractWebElement() {
			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}

	public static IText getText(final WebElement element) {
		return new AbstractText() {
			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}

	public static ITextBox getTextBox(final WebElement element) {
		return new AbstractTextBox() {
			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}

	public static IButton getButton(final WebElement element) {
		return new AbstractButton() {
			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}

	public static ILink getLink(final WebElement element) {
		return new AbstractLink() {
			@Override
			protected WebElement getWebElement() {
				return element;
			}
		};
	}
}
