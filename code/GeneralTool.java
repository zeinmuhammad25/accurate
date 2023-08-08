package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.akunperkiraan.AkunPerkiraanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class GeneralTool {
	private static final Logger log = Logger.getLogger(GeneralTool.class);

	public static void simpanNotifikasi(WebDriver driver, String fileName) {
		log.info("SaveNotification");
		Assert.assertNotNull(fileName);

		String content = AccTool.getNotification(driver) + "\r\n";
		AccTool.writeTextFile(fileName, content);

		//WaitTool.waitForElementDisapear(driver,
		//		By.xpath("/html/body/div[@class='metro notify-container']/div[contains(@class,'notify')]"), 4);
	}

	public static void simpanListData(WebDriver driver, AccurateModule module,
			String fileName) {
		log.info("List : " + module);
		
		AccTool.waitGridMask(driver, true);

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = module + ": " + "\r\n";

		content = content + AccTool.getGridValue(driver, module, tab) + "\r\n";
        
		AccTool.writeTextFile(fileName, content);
		WaitTool.delay(1000);
	}

	public static void simpanPesanError(WebDriver driver, String filename) {
		String content = "Error Message : ";

		WebElement errorwindow = driver.findElement(By
				.xpath("//div[contains(@id,'error-dialog-')]//li"));
		content = content + "\r\n" + errorwindow.getText() + "\r\n" + "\r\n";
		log.info(content);

		AccTool.writeTextFile(filename, content);
	}

	public static void simpanPesanKonfirmasi(WebDriver driver, String filename) {
		String content = "Confirmation Message : ";

		WebElement confirmwindow = driver.findElement(By
				.xpath("//div[contains(@id,'confirm-dialog-')]//li"));
		content = content + "\r\n" + confirmwindow.getText() + "\r\n" + "\r\n";
		log.info(content);

		AccTool.writeTextFile(filename, content);
	}

	public static void simpanPesanAntrian(WebDriver driver, String filename) {
		String content = "Queue Message : ";
		
//		String notify = "//div[@class='queue-content']/div[1]//*[ul[@class='messages']]//li";
//		List<WebElement> daftarSaldo = driver.findElements(By.xpath(notify));
//		int n = daftarSaldo.size();
//		
//		if (n == 0) {
			AccTool.click(driver, "//div[contains(@class,'queue-indicator')]");
//		}

		WaitTool.waitForElementVisible(driver, By.xpath("//div[@class='queue-content']/div[1]//*[ul[@class='messages']]//li"), 10);
		
		WebElement queuemessage = driver
				.findElement(By
						.xpath("//div[@class='queue-content']/div[1]//*[ul[@class='messages']]//li"));
		content = content + "\r\n" + queuemessage.getText() + "\r\n" + "\r\n";
//		log.info(n);
		log.info(content);
		
		AccTool.click(driver, "//a[contains(@class,'element accurate-logo')]");

		AccTool.writeTextFile(filename, content);
	}
}
