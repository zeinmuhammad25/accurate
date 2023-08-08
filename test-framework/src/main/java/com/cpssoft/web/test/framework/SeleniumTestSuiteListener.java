package com.cpssoft.web.test.framework;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.log4testng.Logger;

public class SeleniumTestSuiteListener implements ISuiteListener {

	private static final Logger log = Logger.getLogger(SeleniumTestSuiteListener.class);

	private boolean hasError = false;

	@Override
	public void onStart(ISuite suite) {
		log.info("Start Test Suite: " + suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {
		log.info("Finish Test Suite: " + suite.getName());
	}

	public void setHasError() {
		hasError = true;
	}

	public boolean hasError() {
		return hasError;
	}
}
