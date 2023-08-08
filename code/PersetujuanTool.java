package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.persetujuan.PersetujuanParam;
//import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PersetujuanTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PersetujuanParam.class);
	static String w = AccurateModule.PERSETUJUAN.getXpath();

//	public static void isi(WebDriver driver, PersetujuanParam param) {
//		log.info("aduh.Isi");
//
//		String w = "";
//
//		switch (param.tab.toLowerCase()) {
//		case "setuju":
//			w = "//*[@class='grid-container']//*[@class = 'slick-viewport']//div[contains(@class,'r3') and text()='"
//					+ param.noreferensi + "']/parent::*";
//			String tab = w + "//*[contains(@class,'r1')]";
//			AccTool.click(driver, tab);
//			break;
//
//		case "tolak":
//			w = "//*[@class='grid-container']//*[@class = 'slick-viewport']//div[contains(@class,'r3') and text()='"
//					+ param.noreferensi + "']/parent::*";
//			String A = w + "//*[contains(@class,'r2')]";
//			AccTool.click(driver, A);
//			break;
//		}
//
//	}

	public static void isi(WebDriver getWebDriver, PersetujuanParam param) {
		log.info("aduh.Isi");

		String w = "";

		switch (param.tab.toLowerCase()) {

		case "setuju":

			w = "//div[contains(text(),'[" + param.nofaktur + "]')]/preceding-sibling::div[2]/div/label";
			String tab = w + "//span[@class='check']";
			AccTool.click(getWebDriver, tab);

			break;

		case "tolak":
			w = "//div[contains(text(),'[" + param.nofaktur + "]')]/preceding-sibling::div[1]/div/label";
			String A =  w + "//span[@class='check']";
			AccTool.click(getWebDriver, A);
		}

	}

	public static void klikJalankan(WebDriver driver, PersetujuanParam param) {
		String w = "//*[@id='module-accurate__company__approval']//button[@name='btnSave']";
		AccTool.click(getWebDriver(), w);
	}

	public static void klikData(WebDriver driver, PersetujuanParam param) {
		String w = "//*[@id='module-accurate__company__approval']//*[@class='grid-container']//*[@class = 'slick-viewport']//div[contains(@class,'r4') and text()='"
				+ param.noreferensi + "']";
		AccTool.click(getWebDriver(), w);
	}

	// 26 Juli 2019 tombol proses & tombol refresh

	public static void klikProses(WebDriver driver, PersetujuanParam param) {
		String w = "//*[@id='module-accurate__company__approval']//button[@name='btnProcess']";
		// AccTool.waitProgressBar(driver);
		AccTool.click(getWebDriver(), w);
	}

	public static void klikRefresh(WebDriver driver, PersetujuanParam param) {
		String w = "//*[@id='module-accurate__company__approval']//button[@name='btnRefresh']";
		AccTool.click(getWebDriver(), w);
	}

	/*
	  //27 februari 2020 perubahan karna penomoran pakai Darf untuk manual
	 
	 public static void klikSetujuManual() { 
		 //AccTool.click(getWebDriver(),"//*[contains(@class,'slick-cell l1 r1')]");
      AccTool.click(getWebDriver(),"//div[contains(text(),'[\"+nomorfaktur+\"]')]/preceding-sibling::div[2]/div/label"
	 );
	  
	  }
	  
	  
	 
	  public static void klikTolakManual() { 
		  //AccTool.click(getWebDriver(),"//*[contains(@class,'slick-cell l2 r2')]");
	  AccTool.click(getWebDriver(), "//div[contains(text(),'[\"+nomorfaktur+\"]')]/preceding-sibling::div[1]/div/label"
	  );
	  
	  }
	  
	 
	 public static void klikProsesManual() { AccTool.click(getWebDriver(),
	 "//*[@id='module-accurate__company__approval']//button[@name='btnProcess']");
	 
	  }
	 */

}
