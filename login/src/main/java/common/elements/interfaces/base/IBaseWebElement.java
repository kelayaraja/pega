package common.elements.interfaces.base;

public interface IBaseWebElement<T> {
	T assertDisplayed() throws Exception;

	T assertNotDisplayed() throws Exception;

	T assertEnabled() throws Exception;

	T assertNotEnabled() throws Exception;
}
