package com.cpssoft.web.test.framework.tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Wait tool class. Provides Wait methods for an elements, and AJAX elements to
 * load. It uses WebDriverWait (explicit wait) for waiting an element or
 * javaScript.
 * 
 * To use implicitlyWait() and WebDriverWait() in the same test, we would have
 * to nullify implicitlyWait() before calling WebDriverWait(), and reset after
 * it. This class takes care of it.
 * 
 * 
 * Generally relying on implicitlyWait slows things down so use WaitTool�s
 * explicit wait methods as much as possible. Also, consider
 * (DEFAULT_WAIT_4_PAGE = 0) for not using implicitlyWait for a certain test.
 * 
 * http://chon.techliminal.com/ajax_wait/
 * 
 * @author Chon Chung, Mark Collin, Andre, Tarun Kumar
 * 
 * @todo check FluentWait --
 *       http://seleniumsimplified.com/2012/08/22/fluentwait-with-webelement/
 * 
 *       Copyright [2012] [Chon Chung]
 * 
 *       Licensed under the Apache Open Source License, Version 2.0
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 */
public class WaitTool {

	static Logger log = LogManager.getLogger(WaitTool.class);

	/** Default wait time for an element. 7 seconds. */
	public static final int DEFAULT_WAIT_4_ELEMENT = 5;
	/**
	 * Default wait time for a page to be displayed. 12 seconds. The average
	 * webpage load time is 6 seconds in 2012. Based on your tests, please set
	 * this value. "0" will nullify implicitlyWait and speed up a test.
	 */
	public static final int DEFAULT_WAIT_4_PAGE = 5;

	/**
	 * Wait for the element to be present in the DOM, and displayed on the page.
	 * And returns the first WebElement using the given method.
	 * 
	 * @param WebDriver
	 *            The driver object to be used
	 * @param By
	 *            selector to find the element
	 * @param int
	 *            The time in seconds to wait until returning a failure
	 * 
	 * @return WebElement the first WebElement using the given method, or null
	 *         (if the timeout is reached)
	 */
	public static WebElement waitForElementVisible(WebDriver driver, final By by, int timeOutInSeconds) {
		try {
			// To use WebDriverWait(), we would have to nullify
			// implicitlyWait().
			// Because implicitlyWait time also set "driver.findElement()" wait
			// time.
			// info from:
			// https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
			nullifyImplicitWait(driver);

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

			return element; // return the element
		} catch (org.openqa.selenium.TimeoutException e) {
			//log.warn(e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			setDefaultImplicitWait(driver);
		}
	}

	public static WebElement waitForElementClickable(WebDriver driver, final By by, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));

		return element;
	}

	/**
	 * Wait for the element to be present in the DOM, regardless of being
	 * displayed or not. And returns the first WebElement using the given
	 * method.
	 * 
	 * @param WebDriver
	 *            The driver object to be used
	 * @param By
	 *            selector to find the element
	 * @param int
	 *            The time in seconds to wait until returning a failure
	 * 
	 * @return WebElement the first WebElement using the given method, or null
	 *         (if the timeout is reached)
	 */
	public static WebElement waitForElementPresent(WebDriver driver, final By by, int timeOutInSeconds) {
		try {
			nullifyImplicitWait(driver);

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

			return element; // return the element
		} catch (org.openqa.selenium.TimeoutException e) {
			log.warn(e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			setDefaultImplicitWait(driver);
		}
	}

	public static void waitForElementDisapear(WebDriver driver, final By by, int timeOutInSeconds) {
		try {
			nullifyImplicitWait(driver);

			// If element does not exists, return
			if (driver.findElements(by).size() == 0)
				return;

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (org.openqa.selenium.TimeoutException e) {
			log.warn(e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			setDefaultImplicitWait(driver);
		}
	}

	/**
	 * Wait for the List<WebElement> to be present in the DOM, regardless of
	 * being displayed or not. Returns all elements within the current page DOM.
	 * 
	 * @param WebDriver
	 *            The driver object to be used
	 * @param By
	 *            selector to find the element
	 * @param int
	 *            The time in seconds to wait until returning a failure
	 * 
	 * @return List<WebElement> all elements within the current page DOM, or
	 *         null (if the timeout is reached)
	 */
	public static List<WebElement> waitForListElementsPresent(WebDriver driver, final By by, int timeOutInSeconds) {
		try {
			nullifyImplicitWait(driver);

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until((new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject) {
					return areElementsPresent(driverObject, by);
				}
			}));

			List<WebElement> elements = driver.findElements(by);
			return elements; // return the element
		} catch (org.openqa.selenium.TimeoutException e) {
			log.warn(e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			setDefaultImplicitWait(driver);
		}
	}

	/**
	 * Wait for an element to appear on the refreshed web-page. And returns the
	 * first WebElement using the given method.
	 * 
	 * This method is to deal with dynamic pages.
	 * 
	 * Some sites I (Mark) have tested have required a page refresh to add
	 * additional elements to the DOM. Generally you (Chon) wouldn't need to do
	 * this in a typical AJAX scenario.
	 * 
	 * @param WebDriver
	 *            The driver object to use to perform this element search
	 * @param locator
	 *            selector to find the element
	 * @param int
	 *            The time in seconds to wait until returning a failure
	 * 
	 * @return WebElement the first WebElement using the given method, or
	 *         null(if the timeout is reached)
	 * 
	 * @author Mark Collin
	 */
	public static WebElement waitForElementRefresh(WebDriver driver, final By by, int timeOutInSeconds) {
		try {
			nullifyImplicitWait(driver);

			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver driverObject) {
					driverObject.navigate().refresh(); // refresh the page
														// ****************
					return isElementPresentAndDisplay(driverObject, by);
				}
			});
			WebElement element = driver.findElement(by);
			return element; // return the element
		} catch (org.openqa.selenium.TimeoutException e) {
			log.warn(e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			setDefaultImplicitWait(driver);
		}
	}

	/**
	 * Wait for the Text to be present in the given element, regardless of being
	 * displayed or not.
	 * 
	 * @param WebDriver
	 *            The driver object to be used to wait and find the element
	 * @param locator
	 *            selector of the given element, which should contain the text
	 * @param String
	 *            The text we are looking
	 * @param int
	 *            The time in seconds to wait until returning a failure
	 * 
	 * @return boolean
	 */
	public static boolean waitForTextPresent(WebDriver driver, final By by, final String text, int timeOutInSeconds) {
		boolean isPresent = false;
		try {
			nullifyImplicitWait(driver);

			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver driverObject) {
					return isTextPresent(driverObject, by, text); // is the Text
																	// in the
																	// DOM
				}
			});
			isPresent = isTextPresent(driver, by, text);
			return isPresent;
		} catch (org.openqa.selenium.TimeoutException e) {
			log.warn(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			setDefaultImplicitWait(driver);
		}
		return false;
	}

	/**
	 * Waits for the Condition of JavaScript.
	 * 
	 * 
	 * @param WebDriver
	 *            The driver object to be used to wait and find the element
	 * @param String
	 *            The javaScript condition we are waiting. e.g. "return
	 *            (xmlhttp.readyState >= 2 && xmlhttp.status == 200)"
	 * @param int
	 *            The time in seconds to wait until returning a failure
	 * 
	 * @return boolean true or false(condition fail, or if the timeout is
	 *         reached)
	 **/
	public static boolean waitForJavaScriptCondition(WebDriver driver, final String javaScript, int timeOutInSeconds) {
		boolean jscondition = false;
		try {
			nullifyImplicitWait(driver);

			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject).executeScript(javaScript);
				}
			});
			jscondition = (Boolean) ((JavascriptExecutor) driver).executeScript(javaScript);
			return jscondition;
		} catch (org.openqa.selenium.TimeoutException e) {
			log.warn(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			setDefaultImplicitWait(driver);
		}
		return false;
	}

	/**
	 * Waits for the completion of Ajax jQuery processing by checking "return
	 * jQuery.active == 0" condition.
	 * 
	 * @param WebDriver
	 *            - The driver object to be used to wait and find the element
	 * @param int
	 *            - The time in seconds to wait until returning a failure
	 * 
	 * @return boolean true or false(condition fail, or if the timeout is
	 *         reached)
	 */
	public static boolean waitForJQueryProcessing(WebDriver driver, int timeOutInSeconds) {
		boolean jQcondition = false;
		try {
			nullifyImplicitWait(driver);

			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
				}
			});
			jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
			return jQcondition;
		} catch (org.openqa.selenium.TimeoutException e) {
			log.warn(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			setDefaultImplicitWait(driver);
		}
		return jQcondition;
	}
	
	public static void checkPageIsReady(WebDriver driver) {

		  JavascriptExecutor js = (JavascriptExecutor)driver;


		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   System.out.println("Page Is loaded.");
		   return; 
		  } 

		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<10; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }
		 }	

	public static void delay(int millisecondToWait) {
		try {
			log.info("Delay: " + millisecondToWait);
			Thread.sleep(millisecondToWait);
		} catch (InterruptedException ex) {
			log.warn(ex.getMessage(), ex);
		}
	}

	public static void waitDOMReady(WebDriver driver) {
		waitDOMReady(driver, DEFAULT_WAIT_4_PAGE);
	}

	public static void waitDOMReady(WebDriver driver, int timeOutInSeconds) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		wait(driver, pageLoadCondition, timeOutInSeconds);
	}

	public static void wait(WebDriver driver, ExpectedCondition<?> condition) {
		wait(driver, condition, DEFAULT_WAIT_4_PAGE);
	}

	public static void wait(WebDriver driver, ExpectedCondition<?> condition, int timeOutInSeconds) {
		new WebDriverWait(driver, timeOutInSeconds).until(condition);
	}

	/**
	 * Coming to implicit wait, If you have set it once then you would have to
	 * explicitly set it to zero to nullify it -
	 */
	public static void nullifyImplicitWait(WebDriver driver) {
		setImplicitWait(driver, 0);
	}

	public static void setDefaultImplicitWait(WebDriver driver) {
		setImplicitWait(driver, DEFAULT_WAIT_4_PAGE);
	}

	/**
	 * Set driver implicitlyWait() time.
	 */
	public static void setImplicitWait(WebDriver driver, int waitTime_InSeconds) {
		driver.manage().timeouts().implicitlyWait(waitTime_InSeconds, TimeUnit.SECONDS);
	}

	/**
	 * Checks if the text is present in the element.
	 * 
	 * @param driver
	 *            - The driver object to use to perform this element search
	 * @param by
	 *            - selector to find the element that should contain text
	 * @param text
	 *            - The Text element you are looking for
	 * @return true or false
	 */
	private static boolean isTextPresent(WebDriver driver, By by, String text) {
		try {
			return driver.findElement(by).getText().contains(text);
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks if the elment is in the DOM, regardless of being displayed or not.
	 * 
	 * @param driver
	 *            - The driver object to use to perform this element search
	 * @param by
	 *            - selector to find the element
	 * @return boolean
	 */
	private static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);// if it does not find the element throw
									// NoSuchElementException, which calls
									// "catch(Exception)" and returns false;
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if the List<WebElement> are in the DOM, regardless of being
	 * displayed or not.
	 * 
	 * @param driver
	 *            - The driver object to use to perform this element search
	 * @param by
	 *            - selector to find the element
	 * @return boolean
	 */
	private static boolean areElementsPresent(WebDriver driver, By by) {
		try {
			driver.findElements(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if the elment is in the DOM and displayed.
	 * 
	 * @param driver
	 *            - The driver object to use to perform this element search
	 * @param by
	 *            - selector to find the element
	 * @return boolean
	 */
	private static boolean isElementPresentAndDisplay(WebDriver driver, By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
/*
 * References: 1. Mark Collin's post on:
 * https://groups.google.com/forum/?fromgroups
 * #!topic/webdriver/V9KqskkHmIs%5B1-25%5D Mark's code inspires me to write this
 * class. Thank you! Mark. 2. Andre, and Tarun Kumar's post on:
 * https://groups.google
 * .com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY 3. Explicit and
 * Implicit Waits: http://seleniumhq.org/docs/04_webdriver_advanced.html
 * 
 * Note: 1. Instead of creating new WebDriverWait() instance every time in each
 * methods, I tried to reuse a single WebDriverWait() instance, but I found and
 * tested that creating 100 WebDriverWait() instances takes less than one
 * millisecond. So, it seems not necessary.
 */
