package com.cpssoft.web.test.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.cpssoft.web.util.CompareUtil;
import com.cpssoft.web.util.StringUtil;

public class Main {
	private static Logger log = LogManager.getLogger(Main.class);

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		Map<TestArgs, Object> arguments = new HashMap<TestArgs, Object>();

		if (args != null) {
			for (String arg : args) {
				arg = arg.trim();
				if (CompareUtil.isBlank(arg))
					continue;

				log.info("Processing argument: " + arg);

				String[] temp = arg.split("=", 2);
				if (temp.length == 0 || temp.length > 2)
					throw new RuntimeException("Invalid argument (will be ignored): " + arg);

				TestArgs key = TestArgs.get(temp[0].toLowerCase().trim());

				if (key == null) {
					log.warn("Invalid arguments (will be ignored): " + temp[0]);
					continue;
				}

				if (temp.length == 1 && !arg.contains("=")) {
					arguments.put(key, true);
				} else {
					String value = "";
					if (temp.length > 1)
						value = temp[1].trim();

					if (CompareUtil.isBlank(value)) {
						log.warn("Argument without value (will be ignored): " + temp[0]);
						continue;
					}

					if (key == TestArgs.TEST_CASE) {
						List<String> tcList;
						if (!arguments.containsKey(key)) {
							tcList = new ArrayList<String>();
						} else {
							tcList = (List<String>) arguments.get(key);
						}
						tcList.add(value);
						arguments.put(key, tcList);
					} else if (key == TestArgs.IMPLICIT_WAIT) {
						arguments.put(key, Integer.parseInt(value));
					} else {
						arguments.put(key, value);
					}
				}
			}
		}

		if (arguments.containsKey(TestArgs.FILE)) {
			// Set Log Path
			PatternLayout logLayout = new PatternLayout();
			logLayout.setConversionPattern("%d - %5p (%c:%L) - %m%n");

			DailyRollingFileAppender fileAppender = new DailyRollingFileAppender();
			fileAppender.setFile("logs/"
					+ ((String) arguments.get(TestArgs.FILE)).replace(".xml", "") + ".log");
			fileAppender.setImmediateFlush(true);
			fileAppender.setThreshold(Level.DEBUG);
			fileAppender.setAppend(true);
			fileAppender.setDatePattern("'.'yyyy-MM-dd-a'.log'");
			fileAppender.setLayout(logLayout);
			fileAppender.activateOptions();

			Logger.getRootLogger().addAppender(fileAppender);
		}

		log.info("Run test executor with arguments: " + StringUtil.parseJson(args));

		if (!arguments.containsKey(TestArgs.NAME))
			throw new RuntimeException(TestArgs.NAME.getId() + " argument is required");

		if (!arguments.containsKey(TestArgs.FILE))
			throw new RuntimeException(TestArgs.FILE.getId() + " argument is required");

		if (!arguments.containsKey(TestArgs.DRIVER))
			throw new RuntimeException(TestArgs.DRIVER.getId() + " argument is required");
		else if (CompareUtil.equals((String) arguments.get(TestArgs.DRIVER),
				TestDriver.PHANTOMJS.toString(), true)
				&& !arguments.containsKey(TestArgs.PHANTOMJS_BIN)) {
			throw new RuntimeException(TestArgs.PHANTOMJS_BIN.getId() + " argument is required");
		} else if (CompareUtil.equals((String) arguments.get(TestArgs.DRIVER),
				TestDriver.CHROME.toString(), true)
				&& !arguments.containsKey(TestArgs.CHROME_BIN)) {
			throw new RuntimeException(TestArgs.CHROME_BIN.getId() + " argument is required");
		} else if (CompareUtil.equals((String) arguments.get(TestArgs.DRIVER),
				TestDriver.REMOTE.toString(), true)) {
			if (!arguments.containsKey(TestArgs.SELENIUM_HUB_URL))
				throw new RuntimeException(TestArgs.SELENIUM_HUB_URL.getId()
						+ " argument is required");

			if (!arguments.containsKey(TestArgs.BROWSER))
				throw new RuntimeException(TestArgs.BROWSER.getId() + " argument is required");

			TestBrowser testBrowser = null;
			for (TestBrowser browser : TestBrowser.values()) {
				if (CompareUtil.equals((String) arguments.get(TestArgs.BROWSER),
						browser.toString(), true)) {
					testBrowser = browser;
				}
			}

			if (testBrowser == null)
				throw new RuntimeException("Unsupported browser: "
						+ arguments.get(TestArgs.BROWSER));

			arguments.put(TestArgs.BROWSER, testBrowser);

			if (arguments.containsKey(TestArgs.PLATFORM)) {
				TestPlatform testPlatform = null;
				for (TestPlatform platform : TestPlatform.values()) {
					if (CompareUtil.equals((String) arguments.get(TestArgs.PLATFORM),
							platform.toString(), true)) {
						testPlatform = platform;
					}
				}

				if (testPlatform == null)
					throw new RuntimeException("Unsupported platform: "
							+ arguments.get(TestArgs.PLATFORM));

				arguments.put(TestArgs.PLATFORM, testPlatform);
			}
		}

		if (arguments.containsKey(TestArgs.DRIVER)) {
			TestDriver selectedDriver = null;
			for (TestDriver driver : TestDriver.values()) {
				if (CompareUtil.equals((String) arguments.get(TestArgs.DRIVER), driver.toString(),
						true)) {
					selectedDriver = driver;
					break;
				}
			}

			if (selectedDriver == null)
				throw new RuntimeException("Unsupported driver: " + arguments.get(TestArgs.DRIVER));

			arguments.put(TestArgs.DRIVER, selectedDriver);
		}

		if (!arguments.containsKey(TestArgs.IMPLICIT_WAIT))
			arguments.put(TestArgs.IMPLICIT_WAIT, 60);

		if (!arguments.containsKey(TestArgs.TEST_CASE))
			throw new RuntimeException(TestArgs.TEST_CASE.getId() + " argument is required");

		if (!arguments.containsKey(TestArgs.URL))
			throw new RuntimeException(TestArgs.URL.getId() + " argument is required");

		TestExecutor ts = new TestExecutor(arguments);
		ts.runTest();
	}
}
