package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class ImportAposTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(ImportAposTool.class);

	public static void klikImport(WebDriver driver) {
		String xpath = "//span[@class='busy-load-text']";
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 30);
		AccTool.click(getWebDriver(), "//button[@name='btnExport']");
		WaitTool.delay(4000);
	}
	
	public static void pilihKategori(WebDriver driver, String kategori) {
		String loadingscreen = "//span[@class='busy-load-text']";
		WaitTool.waitForElementDisapear(driver, By.xpath(loadingscreen), 30);
		
		AccTool.click(getWebDriver(), "//select[@name='status']");
		
		String xpath = "//option[.='Semua']";
		WaitTool.waitForElementPresent(driver, By.xpath(xpath), 30);
		AccTool.click(getWebDriver(), "//option[.='"+ kategori +"']");
	}
	
	public static void saveListDetailTransaksiGagal(WebDriver driver, String filename) {
		log.info("ImportAposTool.saveListDetailTransaksiGagal");

		String tab = "";
		String content = "ImportAposTool.saveListDetailTransaksiGagal : " + "\r\n";
		tab = "//*[contains(@id,'manage-pos-import')]";
		content = content  
				+ AccTool.getGridValue(driver, AccurateModule.IMPOR_ACCURATE_POS, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
}
