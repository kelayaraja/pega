package common.elements.interfaces.base;

public interface IBaseText<U> extends IBaseWebElement<U> {

	U assertTextEqualsTo(String stringToAssert) throws Exception;

	U assertTextContains(String stringToAssert) throws Exception;
}
