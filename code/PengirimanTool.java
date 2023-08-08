package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pengiriman.PengirimanParam;

public class PengirimanTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(PengirimanTool.class);
	
	public static void isi(WebDriver driver, PengirimanParam param) {
		log.info("pengiriman.Isi");
		
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-general')]";
		
		AccTool.click(driver, w + "//a[text()='Pengiriman']");
		
		AccTool.textField(driver, tab, "@name='name'", param.nama);
	}
	
	public static void saveIsi(WebDriver driver, String filename) {
		log.info("pengiriman.SaveIsi");

		String tab = "//*[contains(@id,'tab-general')]";
		String content = "pengiriman.SaveIsi : " + "\r\n";

		content = content
				+ "Nama Pengiriman	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN, ElementType.TEXTFIELD,
						"name", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
}
