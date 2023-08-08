package com.cpssoft.web.test.framework.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriverTool {

	private static final Logger log = LogManager.getLogger(WebDriverTool.class);

	public static File takeScreenshot(WebDriver driver) {
		if (driver instanceof TakesScreenshot) {
			log.info("Taking screenshots...");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			return scrFile;
		}

		return null;
	}

	public static void takeScreenshot(WebDriver driver, String fileName) {
		File screenshot = takeScreenshot(driver);
		if (screenshot != null) {
			try {
				FileUtils.copyFile(screenshot, new File(fileName));
			} catch (IOException e) {
				log.warn(e.getMessage(), e);
			}
		}
	}

	public static void dumpPageSource(WebDriver driver, String fileName) {
		try {
			File f = new File(fileName);
			FileWriter writer = new FileWriter(f, true);
			writer.write(driver.getPageSource());
			writer.close();
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
		}
	}

	/**
	 * Switch's to a window that is already in existance.
	 * 
	 * @param regex
	 *            Regex / Contain String. Url of the window, or title.
	 * @return
	 */
	public static void switchToWindow(WebDriver driver, String regex) {
		Pattern p = null;
		try {
			p = Pattern.compile(regex);
		} catch (PatternSyntaxException exception) {
			log.warn("Error while compile REGEX: "
					+ regex
					+ ". If you are intend to use regular expression, please check your regex syntax.");
		}

		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			log.info("Check pattern in Window: " + regex + ", URL: " + driver.getCurrentUrl()
					+ ", Title:" + driver.getTitle());

			// Check contains string in Title / URL
			if (driver.getTitle().indexOf(regex) != -1
					|| driver.getCurrentUrl().indexOf(regex) != -1)
				return;

			if (p != null) {
				// Check regex in Title
				Matcher m = p.matcher(driver.getTitle());
				if (!m.find()) {
					// Check regex in URL
					m = p.matcher(driver.getCurrentUrl());
				}

				if (m.find())
					return;
			}
		}

		throw new RuntimeException("Could not switch to window with title / url: " + regex);
	}

	public static void goToUrl(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	public static void browseForward(WebDriver driver) {
		driver.navigate().forward();
	}

	public static void browseBack(WebDriver driver) {
		driver.navigate().back();
	}

	public static void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public static void closeBrowser(WebDriver driver) {
		driver.close();
	}
}
