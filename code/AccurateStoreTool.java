package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebDriverTool;

public class AccurateStoreTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(AccurateStoreTool.class);
	
	public static void cariNamaAplikasi (WebDriver driver, String NamaAplikasi) {
		
		String w = AccurateModule.ACCURATE_STORE.getXpath();
		AccTool.textField(driver, w, "@id='input-keyword'", NamaAplikasi);
		
		String xpath = w + "//input[@id='input-keyword']";
		WebElement element = driver.findElement(By.xpath(xpath));
		element.sendKeys(Keys.ENTER);
		
	}

	
	public static void installAplikasi(WebDriver driver, String NamaAplikasi) {
		log.info("Klik Install Aplikasi");

		// pilih Aplikasi
		String xpath = "//a[contains(.,'"+ NamaAplikasi +"')]";
		log.info(xpath);
		WaitTool.waitForElementVisible(driver, By.xpath(xpath), 5);
		log.info("click");
		AccTool.click(driver, xpath);
		
		//install aplikasi
		WaitTool.waitForElementVisible(driver, By.xpath("//a[@id='buttonInstall']"), 200);
		AccTool.click(driver, "//a[@id='buttonInstall']");
		log.info("Muncul Konfirmasi Install");
		
		WaitTool.waitForElementVisible(driver, By.xpath("//button[@id='buttonInstall']"), 200);
		AccTool.click(driver, "//button[@id='buttonInstall']");
		
		// Tunggu loading mask hilang
		AccTool.waitLoadingMask(driver);

	}
	
}