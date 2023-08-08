package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.accuratepos.POSBiayaParam;
import com.cpssoft.web.test.accurate.accuratepos.TipePenjualanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class BiayaPOSTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(BiayaPOSTool.class);

	
	public static void isiKategoriBiaya(WebDriver driver, POSBiayaParam param) {
		log.info("TipePenjualan.isiTipePenjualan");

		String w = AccurateModule.BIAYA.getXpath();
//		String tab = w + "//*[contains(@id,'tab-widget')]";

//		AccTool.click(driver, w + "//a[contains(@href,'tab-general')]");
		log.info("Klik Tab Kategori Biaya");
		
		if (param.namakategoribiaya != null)
			AccTool.textField(driver, w, "@name='name'", param.namakategoribiaya);
		if (param.akunbeban != null)
			AccTool.lookup(driver, w, "@name='expenseAccount'", param.akunbeban);
		if (param.cbsemuaoutlet != null)
			AccTool.checkbox(driver, w, "@name='isUsedAllOutlet'", param.cbsemuaoutlet);
		if (param.outlet != null)
			AccTool.lookup(driver, w, "@name='outletList'", param.outlet);
			}
	
	public static void saveTerjadiPermasalahanDalamPemrosesan(WebDriver driver, String filename) {
		log.info("BiayaTool.saveTerjadiPermasalahanDalamPemrosesan");

		String content = "BiayaTool.saveTerjadiPermasalahanDalamPemrosesan : " + "\r\n";
		WaitTool.waitForElementPresent(driver, By.xpath("//*[contains(@href,'tab-general')]"), 10);
		content = content + "\r\n"
				+ AccTool.getTextValue(driver, "//label[@class='no-margin']")
				+ AccTool.getTextValue(driver, "//label[@class='fg-crimson']")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikOKTerjadiPermasalahanDalamPemrosesan(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'error-dialog')]//button[.='OK']");
		WaitTool.waitForElementDisapear(driver,
				By.xpath("//*[contains(@id,'error-dialog')]//button[.='OK']"), 7);
	}
	
	public static void klikHilangkanCabang(WebDriver driver) {
		AccTool.click(driver, "//div[@class='span4 offset3']//li[1]//i[@class='icon-cancel-2']");
//		WaitTool.waitForElementDisapear(driver,
//				By.xpath("//div[@class='span4 offset3']//li[1]//i[@class='icon-cancel-2']"), 7);
	}
	
	public static void saveDetailBiaya(WebDriver driver, String filename) {
		log.info("BiayaPOS.saveDetailBiaya");
		String content = "BiayaPOS.saveDetailBiaya : " + "\r\n";
		String checkbox = "";
		String namaoutlet = "";
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath("//label[@for='name']"), 10);
		
		content = content  
				+ "Nama Kategori Biaya : "
				+ AccTool.getTextValue(getWebDriver(), "//span[@data-bind='text: getTitle(), attr: {title: getTitle()}']")
				+ "Akun Beban : "
				+ AccTool.getTextValue(getWebDriver(), "//div[@class='span4']//span[@data-bind='text: name']");
				WebElement radioButton = driver.findElement(By.xpath("//input[@name='isUsedAllOutlet']"));
		        boolean isSelected = radioButton.isSelected();
		        
		        if (isSelected) {
		        	checkbox = "Outlet Terceklis : True" + "\r\n";
		        } else {
		        	checkbox = "Outlet Terceklis : False" + "\r\n";
		        }
				
		namaoutlet = namaoutlet
					+ AccTool.getTextValue(getWebDriver(), "//div[@class='span4 offset3']//span[@data-bind='text: name']");
		        
				AccTool.writeTextFile(filename,  content + checkbox + namaoutlet + "\r\n" + "\r\n");
	}
	
}
	

