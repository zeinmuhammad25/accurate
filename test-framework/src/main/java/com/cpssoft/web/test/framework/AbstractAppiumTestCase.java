package com.cpssoft.web.test.framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AbstractAppiumTestCase {
	private static final Logger log = LogManager.getLogger(AbstractAppiumTestCase.class);

	public static AndroidDriver<MobileElement> driver;
	public static WebDriverWait wait;
	
	private static ThreadLocal<XmlTest> localXmlTest = new ThreadLocal<XmlTest>();
	
	@BeforeClass
	protected void beforeClass() {
		log.info("MULAI TC = " + "\r\n"
				+ "*********************************" + "\r\n"
				+ "     " + getClass().getSimpleName() + "\r\n"
				+ "*********************************");

	}

	@AfterClass
	protected void afterClass() {
		log.info("AKHIR TC = " + "\r\n"
				+ "*********************************" + "\r\n"
				+ "     " + getClass().getSimpleName() + "\r\n"
				+ "*********************************");
	}

	//String appPackage = "com.cpssoft.mobile.alpha";

	// before Test Annotation makes a java function to run every time before a
	// TestNG test case
	@BeforeTest
	public void beforeTest(ITestContext context) throws MalformedURLException, InterruptedException {
		
		localXmlTest.set(context.getCurrentXmlTest());

		log.info("Before Test XML: " + localXmlTest.get().getName());
		
		String namadevice = getTestParam("selenium.devicename");
		String aplikasi = getTestParam("selenium.apps");
		String platformversion = getTestParam("selenium.platformVersion");
		String apppackage = getTestParam("selenium.appPackage");
		String appactivity = getTestParam("selenium.appActivity");
		
		// relative path to apk file
		final File classpathRoot = new File(System.getProperty("user.dir"));
		final File appDir = new File(classpathRoot, "src/test/resources/app/");
		final File app = new File(appDir, aplikasi);

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "");
		caps.setCapability("platformName", "ANDROID");
//		caps.setCapability("platformVersion", platformversion);
//		caps.setCapability("deviceName", namadevice);
//		caps.setCapability("platformVersion", "8.1");
//		caps.setCapability("deviceName", "c621caa4");
		caps.setCapability("platformVersion", "10.0");
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("appPackage", apppackage);
		caps.setCapability("appActivity", appactivity);
		caps.setCapability("autoGrantPermissions", true);
		caps.setCapability("noReset", true);
		caps.setCapability("fullReset", false);
			
		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);

		// initializing explicit wait object
		wait = new WebDriverWait(driver, 10);

	}

	// After Test Annotation makes a java function to run every time after a TestNG
	// test case
	@AfterTest
	public void afterTest() {
		if (getAndroidDriver() != null) {
			AndroidDriver<?> androidDriver = getAndroidDriver();
			boolean hasQuit = androidDriver.toString().contains("(null)");

			if (!hasQuit) {
				androidDriver.quit();
			}
			// quit the driver
			//driver.quit();
			
			localXmlTest.remove();
		}
	}
	
	protected String getTestParam(String key) {
		String result = localXmlTest.get().getParameter(key);
		return result != null && !result.startsWith("${") ? result : null;
	}

	public static AndroidDriver<?> getAndroidDriver() {
		return driver;
	}

}
