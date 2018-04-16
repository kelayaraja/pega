package scraper.ui.pagefactory;

interface Locators {
	//Login page
	String TXT_BOX_USER_NAME = "#usr";
	String TXT_BOX_PASSWORD = "#pwd";
	String BTN_LOGIN = "input[type='submit']";
	String TXT_ACCESS_DENIED = "//div[@id='case_login']/h3[contains(text(), 'ACCESS DENIED')]";

	//Welcome page
	String TXT_WELCOME = "//div[@id='case_login']/h3[contains(text(), 'WELCOME')]";
	String LINK_GO_BACK = "//div[@id='case_login']/a[contains(text(), 'BACK')]";
	String TXT_COOKING_MISSING = "//div[@id='case_login']/h3[contains(text(), 'THE SESSION COOKIE IS MISSING OR HAS A WRONG VALUE')]";
}
