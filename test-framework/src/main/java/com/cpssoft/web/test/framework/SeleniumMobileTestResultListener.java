package com.cpssoft.web.test.framework;

import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener2;

import com.cpssoft.web.test.framework.tools.WebDriverTool;
import com.cpssoft.web.util.StringUtil;

public class SeleniumMobileTestResultListener implements IResultListener2 {

	private static final Logger log = Logger.getLogger(SeleniumMobileTestResultListener.class);

	public static final String ERROR_SCREENSHOT_FILE = "error-screenshot.png";
	public static final String ERROR_PAGE_SOURCE_FILE = "error-page-source.html";

	@Override
	public void onTestStart(ITestResult result) {
		log.debug("Executing Method: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Succeed executing method: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// AbstractAppiumTestCase.getAndroidDriver();
		handleOnError(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (result != null) {
			log.warn("Skipping method: " + result.getMethod().getMethodName() + ", Cause: " + (result.getThrowable() != null ? result.getThrowable().getMessage() : "-"));
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		handleOnError(result);
	}

	@Override
	public void onStart(ITestContext context) {
		log.debug("Start Test Case: " + context.getName() + ", Included: " + StringUtil.parseJson(context.getIncludedGroups()) + ", Excluded: " + StringUtil.parseJson(context.getExcludedGroups()));
	}

	@Override
	public void onFinish(ITestContext context) {
		log.debug("Finish Test Case " + context.getName());
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeConfiguration(ITestResult tr) {
		// TODO Auto-generated method stub

	}

	protected void handleOnError(ITestResult result) {
		log.error("Error occured when executing method: " + result.getMethod().getMethodName() + ", Cause: " + result.getThrowable().getMessage(), result.getThrowable());
		try {
			if (AbstractAppiumTestCase.getAndroidDriver() != null) {
				// Dump Appium server logs
				log.info("Appium Server Logs");
				log.info("========================");
				LogEntries logEntries = AbstractAppiumTestCase.getAndroidDriver().manage().logs().get("server");
				for (LogEntry entry : logEntries) {
					//log.info(new Date(entry.getTimestamp()) + " (" + entry.getLevel() + "): " + entry.getMessage());
				}

//				log.info("Client Logs");
//				log.info("========================");
//				logEntries = AbstractAppiumTestCase.getAndroidDriver().manage().logs().get("logcat");
//				for (LogEntry entry : logEntries) {
//					log.info(new Date(entry.getTimestamp()) + " (" + entry.getLevel() + "): " + entry.getMessage());
//				}

//				log.info("Driver Logs");
//				log.info("========================");
//				logEntries = AbstractAppiumTestCase.getAndroidDriver().manage().logs().get(LogType.DRIVER);
//				for (LogEntry entry : logEntries) {
//					log.info(new Date(entry.getTimestamp()) + " (" + entry.getLevel() + "): " + entry.getMessage());
//				}

				// Take screenshot of error page
				try {
					WebDriverTool.takeScreenshot(AbstractAppiumTestCase.getAndroidDriver(), result.getTestContext().getOutputDirectory() + "/" + ERROR_SCREENSHOT_FILE);
				} catch (Exception e) {
					log.error("Cannot take error screenshot: " + e.getMessage(), e);
				}

				// Dump page source of error page
				try {
					WebDriverTool.dumpPageSource(AbstractAppiumTestCase.getAndroidDriver(), result.getTestContext().getOutputDirectory() + "/" + ERROR_PAGE_SOURCE_FILE);
				} catch (Exception e) {
					log.error("Cannot dumping error page source: " + e.getMessage(), e);
				}
			}
		} finally {
			AbstractAppiumTestCase.getAndroidDriver().quit();
		}
	}
}
