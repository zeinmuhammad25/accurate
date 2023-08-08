package com.cpssoft.web.test.framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.TestNG;
import org.testng.internal.IResultListener2;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.util.CompareUtil;
import com.cpssoft.web.util.StringUtil;

public class TestExecutor {

	private static final Logger log = LogManager.getLogger(TestExecutor.class);

	protected String name;

	protected String outputLocation;

	protected String tcPackage;

	protected String phantomJsPath;

	protected String chromePath;

	protected TestBrowser testBrowser;
	protected String testBrowserVersion;
	protected TestPlatform testPlatform;

	protected String initUrl;

	private TestDriver driver;
	private WebDriver webDriver;
	private Integer implicitWaitTimeout;
	private Integer resolutionWidth = 1024;
	private Integer resolutionHeight = 768;

	protected List<TestSuiteDefinition> testSuiteList = new ArrayList<TestSuiteDefinition>();

	protected static final int TC_CLASS_COLUMN_NO = 0;

	public static final String ERROR_SCREENSHOT_FILE = "error-screenshot.png";

	public static final String ERROR_PAGE_SOURCE_FILE = "error-page-source.html";

	private static Map<TestArgs, Object> testArguments = new HashMap<TestArgs, Object>();

	public TestExecutor(Map<TestArgs, Object> args) {
		testArguments = args;
		name = getStringArgs(TestArgs.NAME);

		if (isArgContains(TestArgs.PHANTOMJS_BIN))
			setPhantomJsBinaryPath(getStringArgs(TestArgs.PHANTOMJS_BIN));
		if (isArgContains(TestArgs.CHROME_BIN))
			setChromeDriverPath(getStringArgs(TestArgs.CHROME_BIN));
		if (isArgContains(TestArgs.BROWSER))
			testBrowser = (TestBrowser) testArguments.get(TestArgs.BROWSER);
		if (isArgContains(TestArgs.BROWSER_VERSION))
			testBrowserVersion = getStringArgs(TestArgs.BROWSER_VERSION);
		if (isArgContains(TestArgs.PLATFORM))
			testPlatform = (TestPlatform) testArguments.get(TestArgs.PLATFORM);
		if (isArgContains(TestArgs.FILE))
			setOutputLocation(TestNG.DEFAULT_OUTPUTDIR + "/" + (getStringArgs(TestArgs.FILE)).replace(".xml", ""));

		setDriver((TestDriver) testArguments.get(TestArgs.DRIVER), getStringArgs(TestArgs.URL));

		if (isArgContains(TestArgs.RESOLUTION)) {
			String[] res = getStringArgs(TestArgs.RESOLUTION).split("x");

			if (res.length == 2) {
				setResolution(Integer.valueOf(res[0]), Integer.valueOf(res[1]));
			}
		}

		setImplicitWaitTimeout(getIntegerArgs(TestArgs.IMPLICIT_WAIT));

		if (isArgContains(TestArgs.TEST_CASE_PACKAGE))
			setTcPackage(getStringArgs(TestArgs.TEST_CASE_PACKAGE));

		@SuppressWarnings("unchecked")
		List<String> tcList = (List<String>) testArguments.get(TestArgs.TEST_CASE);

		for (String tc : tcList) {
			addTestSuite(tc);
		}
	}

	public boolean isArgContains(TestArgs key) {
		return testArguments.containsKey(key);
	}

	public static Map<String, String> getData() {
		Map<String, String> result = new HashMap<String, String>();
		if (testArguments.containsKey(TestArgs.DATA)) {
			String data = getStringArgs(TestArgs.DATA);
			String[] tokenList = data.split("\\|");

			for (String token : tokenList) {
				String[] entry = token.split(":=", 2);
				if (entry.length == 2) {
					result.put(entry[0], entry[1]);
				}
			}

		}

		return result;
	}

	public static String getStringArgs(TestArgs key) {
		return (String) testArguments.get(key);
	}

	public static Integer getIntegerArgs(TestArgs key) {
		return (Integer) testArguments.get(key);
	}

	public void setDriver(TestDriver driver, String initUrl) {
		if (driver == TestDriver.PHANTOMJS && CompareUtil.isBlank(phantomJsPath))
			throw new RuntimeException("Phantom JS Binary Path is not defined yet");
		if (driver == TestDriver.CHROME && CompareUtil.isBlank(chromePath))
			throw new RuntimeException("Chrome Driver Path is not defined yet");
		if (driver == TestDriver.REMOTE && CompareUtil.isBlank(testBrowser))
			throw new RuntimeException("Test Browser is not defined yet");

		this.driver = driver;
		this.initUrl = initUrl;
	}

	protected WebDriver getWebDriver() {
		if (driver == null)
			throw new RuntimeException("Web Driver is not defined yet");

		if (webDriver == null) {
			switch (driver) {
			case CHROME:
				webDriver = new ChromeDriver();
				break;

			case HTMLUNIT:
				webDriver = new HtmlUnitDriver();
				break;

			case PHANTOMJS:
				webDriver = new PhantomJSDriver();
				break;

			case REMOTE:
				DesiredCapabilities browser = null;

				switch (testBrowser) {
				case CHROME:
					browser = DesiredCapabilities.chrome();
					break;
				case FIREFOX:
					browser = DesiredCapabilities.firefox();
					break;
				case IE:
					browser = DesiredCapabilities.internetExplorer();
					break;
				case OPERA:
					browser = DesiredCapabilities.operaBlink();
					break;
				case SAFARI:
					browser = DesiredCapabilities.safari();
					break;
				default:
					throw new RuntimeException("Test Browser is not defined yet");
				}

				if (testPlatform != null) {
					switch (testPlatform) {
					case LINUX:
						browser.setPlatform(Platform.LINUX);
						break;
					case MAC:
						browser.setPlatform(Platform.MAC);
						break;
					case WINDOWS:
						browser.setPlatform(Platform.WINDOWS);
						break;
					case XP:
						browser.setPlatform(Platform.XP);
						break;
					case WIN8:
						browser.setPlatform(Platform.WIN8);
						break;
					case ANY:
						browser.setPlatform(Platform.ANY);
						break;
					default:
						throw new RuntimeException("Invalid test platform");

					}
				} else {
					browser.setPlatform(Platform.ANY);
				}

				if (testBrowserVersion != null) {
					browser.setVersion(testBrowserVersion);
				}

				try {
					webDriver = new RemoteWebDriver(new URL(getStringArgs(TestArgs.SELENIUM_HUB_URL)), browser);
				} catch (MalformedURLException e) {
					throw new RuntimeException(e);
				}
				break;

			default:
				webDriver = new FirefoxDriver();
				break;
			}

			// Set Implicit Wait Timeout
			log.info("Set browser implicit wait: " + implicitWaitTimeout);
			WaitTool.setImplicitWait(webDriver, implicitWaitTimeout);

			// Set Screen Resolution
			log.info("Set browser resolution: " + resolutionWidth + " x " + resolutionHeight);
			webDriver.manage().window().setSize(new Dimension(resolutionWidth, resolutionHeight));

			// Open init URL
			log.info("Set browser URL: " + initUrl);
			webDriver.get(initUrl);

			WaitTool.waitDOMReady(webDriver);
		}

		return webDriver;
	}

	public void setResolution(int width, int height) {
		resolutionWidth = width;
		resolutionHeight = height;
	}

	public void setOutputLocation(String outputLocation) {
		log.info("Set output to: " + outputLocation);
		this.outputLocation = outputLocation;
	}

	public void setImplicitWaitTimeout(int wait) {
		implicitWaitTimeout = wait;
	}

	public void setTcPackage(String tcPackage) {
		this.tcPackage = tcPackage;
	}

	public void setPhantomJsBinaryPath(String path) {
		phantomJsPath = path;
		System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJsPath);
	}

	public void setChromeDriverPath(String path) {
		chromePath = path;
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromePath);
	}

	public void addTestSuite(String testSuiteFile) {
		InputStream in = null;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			in = new FileInputStream(testSuiteFile);

			// URL resoureUrl = classLoader.getResource(testSuiteFile);
			// if (resoureUrl == null)
			// throw new RuntimeException("Resource not exists: " +
			// testSuiteFile);

			log.info("Processing Test Suite: " + testSuiteFile);

			// in = classLoader.getResourceAsStream(testSuiteFile);

			// Get the workbook instance for XLS file
			Workbook workbook = null;

			if (testSuiteFile.toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(in);
			} else if (testSuiteFile.toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(in);
			}

			// Get first sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);

			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.iterator();

			TestSuiteDefinition testSuite = new TestSuiteDefinition(testSuiteFile);

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getRowNum() > 0) {
					TestCaseDefinition testCase = null;

					// For each row, iterate through each columns
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Handling TC Class
						if (cell.getColumnIndex() == TC_CLASS_COLUMN_NO) {
							String temp = cell.getStringCellValue();
							if (!CompareUtil.isBlank(temp) && !temp.startsWith("//")) {
								String[] splitData = temp.split("\\|");

								for (String data : splitData) {
									data = data.trim();
									if (!CompareUtil.isBlank(data)) {
										// Handle include group
										if (data.startsWith("inc:")) {
											data = data.replaceFirst("inc:", "");
											String[] included = data.split(",");

											for (String group : included) {
												testCase.addIncludedGroup(group.trim());
											}
										}
										// Handle exclude group
										else if (data.startsWith("exc:")) {
											data = data.replaceFirst("exc:", "");
											String[] excluded = data.split(",");

											for (String group : excluded) {
												testCase.addExcludedGroup(group.trim());
											}
										} else {
											if (tcPackage != null)
												data = tcPackage + "." + data;

											try {
												Class.forName(data, false, classLoader);
											} catch (ClassNotFoundException e) {
												throw new RuntimeException("TC Class is invalid in: " + testSuiteFile + ", Row: " + row.getRowNum() + ", Value: " + data);
											}

											testCase = new TestCaseDefinition("#" + row.getRowNum() + ": " + data, data);
										}
									}
								}
							} else {
								continue;
							}
						}
						// Handling TC Params
						else {
							if (testCase != null) {
								String temp = cell.getStringCellValue();
								if (!CompareUtil.isBlank(temp)) {
									String[] splitData = temp.split(":=");
									if (splitData.length != 2)
										throw new RuntimeException(
												"Invalid parameter format in: " + testSuiteFile + ", Row: " + row.getRowNum() + ", Col: " + cell.getColumnIndex() + ", Value: " + temp);
									testCase.addParameter(splitData[0].trim(), splitData[1].trim());
								}
							}
						}
					}

					if (testCase != null) {
						log.debug("Adding Test Case #" + (testSuite.getTestCaseList().size() + 1) + ": " + testCase.getClassName() + ", Inc: " + StringUtil.parseJson(testCase.getIncludedGroupList())
								+ ", Exc: " + StringUtil.parseJson(testCase.getExcludedGroupList()) + ", Params: " + StringUtil.parseJson(testCase.getParameters()));

						testSuite.addTestCase(testCase);
					}
				}
			}
			testSuiteList.add(testSuite);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Throwable t) {
					throw new RuntimeException(t);
				}
			}
		}
	}

	public void runTest() {
		log.info("Start Test Executor: " + name);
		final StopWatch executorSw = new StopWatch();
		executorSw.start();

		try {
			List<XmlSuite> suites = new ArrayList<XmlSuite>();
			for (TestSuiteDefinition ts : testSuiteList) {
				XmlSuite suite = new XmlSuite();
				suite.setName(ts.getName());
				suite.setPreserveOrder(true);
				suite.setGroupByInstances(true);

				for (TestCaseDefinition tc : ts.getTestCaseList()) {
					// Handle included groups
					for (String group : tc.getIncludedGroupList()) {
						suite.addIncludedGroup(group);
					}

					// Handle excluded groups
					for (String group : tc.getExcludedGroupList()) {
						suite.addExcludedGroup(group);
					}

					XmlTest test = new XmlTest(suite);
					test.setName(tc.getName());
					test.setPreserveOrder(true);
					test.setGroupByInstances(true);

					// Handle parameters
					for (Entry<String, String> entry : tc.getParameters().entrySet()) {
						test.addParameter(entry.getKey(), entry.getValue());
					}

					// Handle classes
					List<XmlClass> classes = new ArrayList<XmlClass>();
					classes.add(new XmlClass(tc.getClassName()));
					test.setXmlClasses(classes);
				}
				suites.add(suite);
			}
			final SeleniumTestSuiteListener tsl = new SeleniumTestSuiteListener() {
				final StopWatch tsSw = new StopWatch();

				@Override
				public void onStart(ISuite suite) {
					tsSw.start();
					super.onFinish(suite);
					log.info("Start Test Suite: " + suite.getName());
				}

				@Override
				public void onFinish(ISuite suite) {
					tsSw.stop();
					super.onFinish(suite);
					log.info("Finish Test Suite: " + suite.getName() + ", Duration: " + parseDuration(tsSw.getTime()));
					tsSw.reset();
				}
			};
			IResultListener2 tla = new SeleniumTestResultListener() {
				final StopWatch tcSw = new StopWatch();
				final StopWatch tcmSw = new StopWatch();

				@Override
				public void onStart(ITestContext testContext) {
					tcSw.start();
					super.onStart(testContext);
					log.debug("Start Test Case " + testContext.getName() + ", Included: " + StringUtil.parseJson(testContext.getIncludedGroups()) + ", Excluded: "
							+ StringUtil.parseJson(testContext.getExcludedGroups()));
					testContext.setAttribute("webDriver", getWebDriver());
				}

				@Override
				public void onFinish(ITestContext testContext) {
					tcSw.stop();
					super.onStart(testContext);
					log.debug("Finish Test Case " + testContext.getName() + ", Duration: " + parseDuration(tcSw.getTime()));
					tcSw.reset();
				}

				@Override
				public void onTestStart(ITestResult result) {
					if (tsl.hasError())
						throw new SkipException("Skipping Method: " + result.getMethod().getMethodName() + ", Reason: error has occured in previous method execution");

					tcmSw.start();
					log.debug("Executing Method: " + result.getMethod().getMethodName());
				}

				@Override
				public void onTestSuccess(ITestResult result) {
					tcmSw.stop();
					log.info(" Method: " + result.getMethod().getMethodName() + ", Duration: " + parseDuration(tcmSw.getTime()) + ", Result: OK");
					tcmSw.reset();
				}

				@Override
				public void onTestFailure(ITestResult result) {
					handleOnError(result);
				}

				@Override
				public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
					handleOnError(result);
				}

				@Override
				public void onTestSkipped(ITestResult result) {
					log.warn("Method: " + result.getMethod().getMethodName() + ", Result: " + result.getThrowable().getMessage());
				}
			};

			// Running TestNG
			TestNG tng = new TestNG();
			if (outputLocation != null)
				tng.setOutputDirectory(outputLocation);
			tng.setXmlSuites(suites);
			tng.addListener(tsl);
			tng.addListener(tla);

			tng.run();
		} finally {
			// Stop timer
			executorSw.stop();
			log.info("Finish Test Executor: " + name + ", Duration: " + parseDuration(executorSw.getTime()));
			executorSw.reset();

			// Closing web driver
			getWebDriver().quit();
		}
	}

	private String parseDuration(Long duration) {
		return DurationFormatUtils.formatDuration(duration, "dd 'days' HH 'hours' mm 'minutes' ss.SS 'seconds'");
	}
}
