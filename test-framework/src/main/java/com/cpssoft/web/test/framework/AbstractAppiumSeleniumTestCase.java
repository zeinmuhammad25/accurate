package com.cpssoft.web.test.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import com.cpssoft.web.test.framework.tools.OSTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

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
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractAppiumSeleniumTestCase {
	private static final Logger log = LogManager.getLogger(AbstractAppiumSeleniumTestCase.class);

	protected static final String DEFAULT_PROVIDER = "defaultProvider";

	private static ThreadLocal<WebDriver> localWebDriver = new ThreadLocal<WebDriver>();

	private static ThreadLocal<XmlTest> localXmlTest = new ThreadLocal<XmlTest>();
	
	public static AndroidDriver<MobileElement> driver;
	public static WebDriverWait wait;
	

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

	// @BeforeSuite
	// protected void beforeSuite(ITestContext context) {

	@BeforeTest
	protected void beforeTest(ITestContext context) throws MalformedURLException, InterruptedException {
		
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
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability("deviceName", "");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("appPackage", apppackage);
		caps.setCapability("appActivity", appactivity);
		caps.setCapability("autoGrantPermissions", true);
		caps.setCapability("noReset", true);
		caps.setCapability("fullReset", false);
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 360000);

		log.info("Before Test XML apppackage: " + apppackage);
		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);

		log.info("Before Test XML apppackage: " + apppackage);
		// initializing explicit wait object
		wait = new WebDriverWait(driver, 10);
		
		
		 // web
		if (getWebDriver() == null) {
			log.info("sudah masuk beforetest");

			String driver = getTestParam("selenium.driver");
			String browser = getTestParam("selenium.browser");
			String platform = getTestParam("selenium.platform");
			String browserVersion = getTestParam("selenium.browserVersion");
			String seleniumHub = getTestParam("selenium.hub");
			String implicitWait = getTestParam("selenium.implicitWait");
			String initUrl = getTestParam("selenium.initUrl");
			String windowWidth = getTestParam("selenium.windowWidth");
			String windowHeight = getTestParam("selenium.windowHeight");

			if (driver == null)
				throw new RuntimeException("Web Driver is not defined yet");

			if (initUrl == null)
				throw new RuntimeException("Init URL is not defined yet");

			synchronized (localWebDriver) {

				if (localWebDriver.get() == null) {
					log.info("Initialize Local Web Driver: " + localWebDriver + ", Thread: " + Thread.currentThread().getId());

					DesiredCapabilities browserCapability = new DesiredCapabilities();

					// ditambahin oleh dimas supaya waktu export report,
					// otomatis ke
					// folder /target
					// sepertinya hanya bisa buat di CHROME
					// dan belum ditest di environment selain windows
					String getpath = System.getProperty("user.dir");
					String downloadFilepath = getpath + "\\target";
					log.info(downloadFilepath);
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("download.default_directory", downloadFilepath);
					chromePrefs.put("credentials_enable_service", false);
					chromePrefs.put("profile.password_manager_enabled", false);
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-backgrounding-occluded-windows");  //ditambahkan sejak Chromedriver 87 bermasalah
					options.setExperimentalOption("prefs", chromePrefs);
					// options.addArguments("disable-infobars");

					// mulai chrome 76, tidak bisa pake disable-infobars lagi
//					options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//					options.setExperimentalOption("useAutomationExtension", false);
					// ditambah Dhanu manual karena update Dimas tidak keliatan
					options.setExperimentalOption("useAutomationExtension", false);
					options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
					// ditambah oleh Dhanu untuk headless CHROME
					/*
					 * options.addArguments("--no-sandbox");
					 * options.addArguments("--headless");
					 * options.addArguments("disable-gpu");
					 * options.addArguments("--window-size=1920,1080");
					 */
					// akhir dari tambahan dhanu

					browserCapability.setAcceptInsecureCerts(true);

					// ini juga buat export report
					browserCapability.setCapability(ChromeOptions.CAPABILITY, options);

					if (platform != null) {
						if (Platform.valueOf(platform) == null) {
							throw new RuntimeException("Invalid test platform");
						}

						browserCapability.setPlatform(Platform.valueOf(platform));
					} else {
						browserCapability.setPlatform(Platform.ANY);
					}

					if (browserVersion != null) {
						browserCapability.setVersion(browserVersion);
					}

					switch (TestDriver.valueOf(driver)) {
					case CHROME:
						if (OSTool.isWindows()) {
							 WebDriverManager.chromedriver().setup();
						     ChromeOptions co = new ChromeOptions();
						     co.addArguments("--remote-allow-origins=*");
						} else if (OSTool.isMac()) {
							 WebDriverManager.chromedriver().setup();
						     ChromeOptions co = new ChromeOptions();
						     co.addArguments("--remote-allow-origins=*");
						} else if (OSTool.isUnix()) {
							 WebDriverManager.chromedriver().setup();
						     ChromeOptions co = new ChromeOptions();
						     co.addArguments("--remote-allow-origins=*");
						}

						localWebDriver.set(new ChromeDriver(browserCapability));
						break;

					case FIREFOX:
						if (OSTool.isWindows()) {
							System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,
									"drivers/gecko/windows/geckodriver.exe");
						} else if (OSTool.isMac()) {
							System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,
									"drivers/gecko/mac/geckodriver");
						} else if (OSTool.isUnix()) {
							System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,
									"drivers/gecko/unix/geckodriver");
						}
						localWebDriver.set(new FirefoxDriver(browserCapability));
						break;

					case SAFARI:
						localWebDriver.set(new SafariDriver(browserCapability));
						break;

					case IE:
						System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,
								"drivers/ie/IEDriverServer.exe");
						localWebDriver.set(new InternetExplorerDriver(browserCapability));
						break;

					case OPERA:
						if (OSTool.isWindows()) {
							System.setProperty(OperaDriverService.OPERA_DRIVER_EXE_PROPERTY,
									"drivers/opera/windows/operadriver.exe");
						} else if (OSTool.isMac()) {
							System.setProperty(OperaDriverService.OPERA_DRIVER_EXE_PROPERTY,
									"drivers/opera/mac/operadriver");
						} else if (OSTool.isUnix()) {
							System.setProperty(OperaDriverService.OPERA_DRIVER_EXE_PROPERTY,
									"drivers/opera/unix/operadriver");
						}
						localWebDriver.set(new OperaDriver(browserCapability));
						break;

					case HTMLUNIT:
						localWebDriver.set(new HtmlUnitDriver(browserCapability));
						break;

					case PHANTOMJS:
						if (OSTool.isWindows()) {
							System.setProperty(
									PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
									"drivers/phantomjs/windows/phantomjs.exe");
						} else if (OSTool.isMac()) {
							System.setProperty(
									PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
									"drivers/phantomjs/mac/phantomjs");
						} else if (OSTool.isUnix()) {
							System.setProperty(
									PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
									"drivers/phantomjs/unix/phantomjs");
						}
						localWebDriver.set(new PhantomJSDriver());
						break;

					case REMOTE:
						if (seleniumHub == null)
							throw new RuntimeException("Selenium Hub is not defined yet");

						switch (TestBrowser.valueOf(browser)) {
						case CHROME:
							browserCapability.setBrowserName(BrowserType.CHROME);
							break;
						case FIREFOX:
							browserCapability.setBrowserName(BrowserType.FIREFOX);
							break;
						case IE:
							browserCapability.setBrowserName(BrowserType.IE);
							break;
						case OPERA:
							browserCapability.setBrowserName(BrowserType.OPERA_BLINK);
							break;
						case SAFARI:
							browserCapability.setBrowserName(BrowserType.SAFARI);
							break;
						default:
							throw new RuntimeException("Test Browser is not defined yet");
						}

						try {
							localWebDriver.set(new RemoteWebDriver(new URL(seleniumHub), browserCapability));
						} catch (MalformedURLException e) {
							throw new RuntimeException(e);
						}
						break;

					default:
						throw new RuntimeException("Test Browser is not defined yet");
					}

					WebDriver webDriver = getWebDriver();

					// Set Implicit Wait Timeout
					if (implicitWait != null) {
						log.info("Set browser implicit wait: " + implicitWait);
						WaitTool.setImplicitWait(webDriver, Integer.valueOf(implicitWait));
					}

					// Set Screen Resolution
					if (windowWidth != null && windowHeight != null) {
						log.info("Set browser resolution: " + windowWidth + " x " + windowHeight);
						webDriver
								.manage()
								.window()
								.setSize(
										new Dimension(Integer.valueOf(windowWidth), Integer
												.valueOf(windowHeight)));
					} else {
						webDriver.manage().window().maximize();
						log.info("Browser set to maximize");
					}
				}
			}

			// Open init URL
			log.info("Set browser URL: " + initUrl);
			getWebDriver().get(initUrl);
			WaitTool.waitDOMReady(getWebDriver());
		}
	}

	@AfterTest
	public void afterTest() {
		if (getWebDriver() != null) {
			WebDriver webDriver = getWebDriver();
			boolean hasQuit = webDriver.toString().contains("(null)");

			if (!hasQuit) {
				webDriver.quit();
			}
			
			localWebDriver.remove();
			localXmlTest.remove();
			// WaitTool.delay(15000);
			// log.info("delay 15s utk melepas memory webdriver");
		}
		
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

	public static AndroidDriver<?> getAndroidDriver() {
		return driver;
	}
	

	protected String getTestParam(String key) {
		String result = localXmlTest.get().getParameter(key);
		return result != null && !result.startsWith("${") ? result : null;
	}

	public static WebDriver getWebDriver() {
		return localWebDriver != null ? localWebDriver.get() : null;
	}

	
}
