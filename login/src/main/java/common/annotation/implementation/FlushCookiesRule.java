package common.annotation.implementation;

import common.annotation.FlushCookies;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import scraper.ui.utils.CookiesUtil;

public class FlushCookiesRule extends TestWatcher {

	@Override
	protected void starting(Description description) {
		try {
			FlushCookies flushCookies = description.getTestClass().getMethod(description.getMethodName())
					.getAnnotation(FlushCookies.class);
			if (flushCookies != null && flushCookies.before())
				deleteAllCookies();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		super.starting(description);
	}

	@Override
	protected void finished(Description description) {
		try {
			FlushCookies flushCookies = description.getTestClass().getMethod(description.getMethodName())
					.getAnnotation(FlushCookies.class);
			if (flushCookies != null && flushCookies.after())
				deleteAllCookies();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		super.finished(description);
	}

	private void deleteAllCookies() {
		CookiesUtil.getInstance().deleteAllCookies();
	}

}
