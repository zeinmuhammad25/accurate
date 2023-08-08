package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.api.APIParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebDriverTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class APITool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(APIParam.class);
	static public final String DB_TITLE_AFTER_LOGIN = "API Test - Pilih Database";

	public static void setFocusOnCurrentURL(WebDriver driver) {
		driver.getCurrentUrl();
		log.info("current URL: " + driver.getCurrentUrl());
	}

	public static void clickSubmitConnect(WebDriver driver) {
		AccTool.click(driver, "//div[@id='app']//button");
	}

	public static void oAuthLogin(WebDriver driver, String email, String password) {
		String urlAwal = driver.getCurrentUrl();
		log.info("current URL: " + urlAwal);

		AccTool.waitLoadingMask(driver);
		AccTool.textField(driver, "", "@name='email'", email);
		AccTool.textField(driver, "", "@name='password'", password);
		AccTool.click(driver, "//button[@id='login-button']");

		WaitTool.wait(driver, ExpectedConditions.titleContains(DB_TITLE_AFTER_LOGIN));
		log.info("Cek title page: " + DB_TITLE_AFTER_LOGIN);
		Assert.assertEquals(driver.getTitle(), DB_TITLE_AFTER_LOGIN,
				"Invalid page title: " + driver.getTitle());
		log.info("Berhasil Login");
		
		log.info("Pindah ke window DB ACCURATE...");
		// WebDriverTool.switchToWindow(driver, "/accurate/index.do");
		int ctr = 3;
		do {
			try {
				WebDriverTool.switchToWindow(driver, "/accurate/");
				ctr = 0;
			} catch (Throwable t) {
				if (ctr > 0) {
					ctr--;
					log.warn("Fail switching to Accurate tab. Maybe the server is busy, will retry " + ctr + " times: "
							+ t.getMessage());
					WaitTool.delay(5000);
				} else {
					throw t;
				}
			}
		} while (ctr > 0);
	}

	public static void authApp(WebDriver driver, APIParam param) {
		String button_deny = "//button[@name='deny' and text()='Tolak']";
		String button_allow = "//button[@id='authorize-button' and text()='Beri Akses']";
		switch (param.authorize.toLowerCase()) {
		case "tolak":
			WaitTool.waitForElementClickable(driver, By.xpath(button_deny), 3);
			AccTool.click(driver, button_deny);
			break;
		case "beri akses":
			WaitTool.waitForElementClickable(driver, By.xpath(button_allow), 3);
			AccTool.click(driver, button_allow);
			break;
		}
	}

	public static void connectDB(WebDriver driver, APIParam param) {
				
		String container_dblist = "//div[@id='app']/div[2]/label[text()='Pilih Database :']";
		String dbname = "/following-sibling::ul/li/a[text()='" + param.namadb + "']";
		String input_page = "//div[@id='app']/div[@class='form-group']//label[text()='Accurate API Endpoint']";

		WaitTool.waitForElementClickable(driver, By.xpath(container_dblist + dbname), 5);
		log.info("tungguin nama db muncul");
		log.info("klik DB: " + container_dblist + dbname);
		WaitTool.delay(5000);
		WebElementTool.click(driver, By.xpath(container_dblist + dbname));
		
		WaitTool.waitForElementPresent(driver, By.xpath(input_page), 5);
	}

	public static void setEndPoint(WebDriver driver, APIParam param) {
		String field_endpoint = "//div[@id='app']//div[@class='input-group']/input[@id='endpoint']";
		WaitTool.waitForElementPresent(driver, By.xpath(field_endpoint), 3);
		AccTool.textField(driver, "", "@id='endpoint'", param.endpoint);

	}

	public static void hitAPI(WebDriver driver, APIParam param) {
		String field_param = "//div[@id='app']//div[@class='input-group']/textarea[@id='param']";
		WaitTool.waitForElementPresent(driver, By.xpath(field_param), 3);
		AccTool.textarea(driver, "", "@id='param'", param.inputparam);
		WaitTool.delay(500);
	}

	public static void clickTestAPI(WebDriver driver) {
		String button_testapi = "//div[@id='app']//button[text()='TEST API']";
		WaitTool.waitForElementClickable(driver, By.xpath(button_testapi), 3);
		AccTool.click(driver, button_testapi);
	}

	public static void saveOutput(WebDriver driver, String filename) {
		String xpath_output = "//div[@id='app']//pre[@id='output']";
		String content = "";
		WaitTool.waitForElementVisible(driver, By.xpath(xpath_output), 3);
		content = content + AccTool.getTextValue(driver, xpath_output);
		AccTool.writeTextFile(filename, content);
	}
	
	public static void clickLogout(WebDriver driver) {
		String button_logout = "//div[@id='app']//a[text()='Logout']";
		WaitTool.waitForElementClickable(driver, By.xpath(button_logout), 3);
		AccTool.click(driver, button_logout);
	}
	
	public static void clickGantiDB(WebDriver driver) {
		String button_gantidb = "//div[@id='app']//a[text()='Ganti Database']";
		WaitTool.waitForElementClickable(driver, By.xpath(button_gantidb), 3);
		AccTool.click(driver, button_gantidb);
	}

}
