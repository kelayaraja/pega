package common.environment;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends TestWatcher {
	private static final Logger LOGGER = Logger.getLogger(ScreenShot.class);

	@Override
	protected void failed(Throwable e, Description description) {
		try {
			takesScreenshot(description);
		} catch (IOException e1) {
			LOGGER.error("Error while taking screenshot", e1);
		}
		super.failed(e, description);
	}

	private void takesScreenshot(Description description) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) TestEnvironment.getDriver();
		File newFile = new File("target/screenshots/" + description.getMethodName() + ".png");
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, newFile);
	}
}
