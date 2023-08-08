package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.logaktivitasjurnal.LogAktivitasJurnalParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class LogAktifitasTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(LogAktifitasTool.class);
	
	public static void klikGridPalingAtas(WebDriver driver) {
		String xpath = "//div[@class='grid-canvas']/div[1]/div[@class='slick-cell l0 r0']";
		WaitTool.waitForElementPresent(driver, By.xpath(xpath), 10);
		AccTool.click(driver, xpath);
	}
	
	public static void saveListDetailLogAktivitas(WebDriver driver, String filename) {
		log.info("LogAktivitas.saveListDetailLogAktivitas");

		String tab = "";
		String content = "LogAktivitas.saveListDetailLogAktivitas : " + "\r\n";
		tab = "//*[contains(@id,'tab-general')]";
		content = content  
				+ AccTool.getGridValue(driver, AccurateModule.LOG_AKTIVITAS, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveIsiHeader(WebDriver driver, String filename) {
		
		String content = "LogAktivitas.SaveHeader : " + "\r\n";
		WaitTool.waitForElementPresent(driver, By.xpath("//div[@data-bind='text: formData.createdBy']"), 10);
		content = content 
				+ "Pengguna : "
				+ AccTool.getTextValue(driver, "//div[@data-bind='text: formData.createdBy']") 
				+ "Transaksi : "
				+ AccTool.getTextValue(driver, "//div[@data-bind='text: formData.transactionTypeText']") 
				+ "No/Nama Referensi : "
				+ AccTool.getTextValue(driver, "//div[@data-bind='text: formData.description']") 
				+ "Jenis : "
				+ AccTool.getTextValue(driver, "//div[@data-bind='text: formData.operationTypeText']") 
				+ "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

}
