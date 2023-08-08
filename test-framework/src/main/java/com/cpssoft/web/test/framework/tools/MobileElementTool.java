package com.cpssoft.web.test.framework.tools;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileElementTool {
	
	public static void sendKeys(AndroidDriver<MobileElement> driver, final By by, CharSequence... keyStroke) {
		WaitTool.waitForElementVisible(driver, by, 10);
		checkVisible(driver, by);
		MobileElement element = driver.findElement(by);
		element.sendKeys(keyStroke);

	}
	
	public static void checkVisible(AndroidDriver<MobileElement> driver, final By by) {
		MobileElement element = driver.findElement(by);
		Assert.assertTrue(element.isDisplayed(), "Element not visible: " + element);
	}
	
	public static void click(AndroidDriver<MobileElement> driver, final By by) {
		WaitTool.waitForElementVisible(driver, by, 60);
		// checkVisible(driver, by);
		MobileElement element = (MobileElement) WaitTool.waitForElementClickable(driver, by, 60);

//		if (driver instanceof HasCapabilities && CompareUtil.equals(((HasCapabilities) driver).getCapabilities().getPlatform(), Platform.ANDROID)) {
//			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//			jsExecutor.executeScript("var element = arguments[0]; element.focus(); setTimeout(function() { element.click(); }, 10);", element);
//		} else {
			// Actions actions = new Actions(driver);
			// actions.moveToElement(element);
			// actions.click().perform();
			element.click();
//		}
	}
	
	public static void clearValue(AndroidDriver<MobileElement> driver, final By by) {
		WaitTool.waitForElementVisible(driver, by, 10);
		MobileElement element = driver.findElement(by);
		element.clear();
	}

}
