package com.cpssoft.web.test.framework.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.cpssoft.web.util.CompareUtil;

public class WebElementTool {

	public static void sendKeys(WebDriver driver, final By by, CharSequence... keyStroke) {
		WaitTool.waitForElementVisible(driver, by, 10);
		checkVisible(driver, by);
		WebElement element = driver.findElement(by);
		element.sendKeys(keyStroke);

		if (driver instanceof HasCapabilities) {
			if (CompareUtil.equals(((HasCapabilities) driver).getCapabilities().getBrowserName(), BrowserType.SAFARI)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("$(arguments[0]).change();", element);
			}
		}
	}

	public static void setFileField(WebDriver driver, final By by, String absolutePathToFile) {
		WaitTool.waitForElementVisible(driver, by, 10);
		checkVisible(driver, by);
		WebElement fileField = driver.findElement(by);
		if (fileField instanceof RemoteWebElement) {
			((RemoteWebElement) fileField).setFileDetector(new LocalFileDetector());
		}

		// Cth absolutePathToFile: "C:/path/to/file.jpg"
		fileField.sendKeys(absolutePathToFile);
	}

	public static void doubleClick(WebDriver driver, final By by) {
		WaitTool.waitForElementVisible(driver, by, 10);
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(by)).perform();
	}

	public static void click(WebDriver driver, final By by) {
		WaitTool.waitForElementVisible(driver, by, 60);
		// checkVisible(driver, by);
		WebElement element = WaitTool.waitForElementClickable(driver, by, 60);

		if (driver instanceof HasCapabilities && CompareUtil.equals(((HasCapabilities) driver).getCapabilities().getBrowserName(), BrowserType.FIREFOX)) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("var element = arguments[0]; element.focus(); setTimeout(function() { element.click(); }, 10);", element);
		} else {
			// Actions actions = new Actions(driver);
			// actions.moveToElement(element);
			// actions.click().perform();
			element.click();
		}
	}

	public static void checkVisible(WebDriver driver, final By by) {
		WebElement element = driver.findElement(by);
		Assert.assertTrue(element.isDisplayed(), "Element not visible: " + element);
	}

	public static boolean isElementExists(WebDriver driver, final By by) {
		try {
			WaitTool.nullifyImplicitWait(driver);
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			WaitTool.setDefaultImplicitWait(driver);
		}
	}

	public static boolean isElementVisible(WebDriver driver, final By by) {
		try {
			WaitTool.nullifyImplicitWait(driver);
			WebElement element = driver.findElement(by);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			WaitTool.setDefaultImplicitWait(driver);
		}
	}

	// public static void clearValue(WebDriver driver, final By by) {
	// WaitTool.waitForElementVisible(driver, by, 10);
	// WebElement element = driver.findElement(by);
	// element.clear();
	// }
	
	//jika ada spaci tidak menghapus semua isi
	public static void clearValue(WebDriver driver, final By by) {
		WaitTool.waitForElementVisible(driver, by, 10);
		WebElement element = driver.findElement(by);
		element.click();
		element.sendKeys(Keys.HOME);
		WaitTool.waitForElementClickable(driver, by, 1);
		element.sendKeys(Keys.CONTROL + "a");
		WaitTool.waitForElementClickable(driver, by, 1);
		element.sendKeys(Keys.DELETE);
	}
	
	//hapus semua isi field
	public static void clearValueaAll(WebDriver driver, final By by) {
		WaitTool.waitForElementVisible(driver, by, 10);
		WebElement element = driver.findElement(by);
		element.click();
		element.clear();
	}

	public static void scrollToView(WebDriver driver, final By by) {
		WaitTool.waitForElementVisible(driver, by, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(by);
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}
}
