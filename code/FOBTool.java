package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fob.FOBParam;

public class FOBTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(FOBTool.class);

	public static void isi(WebDriver driver, FOBParam param) {
		log.info("FOB.Isi");
		
		String w = AccurateModule.FOB.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";
		
		AccTool.click(driver, w + "//a[text()='FOB']");
		
		AccTool.textField(driver, tab, "@name='name'", param.nama);
	}
	
	public static void saveIsi(WebDriver driver, String filename) {
		log.info("FOB.SaveIsi");

//		String w = AccurateModule.FOB.getXpath();
		String tab = "//*[contains(@id,'tab-general')]";
		String content = "FOB.SaveIsi : " + "\r\n";

		content = content
				+ "Nama FOB	: "
				+ AccTool.getTextValue(driver, AccurateModule.FOB, ElementType.TEXTFIELD,
						"name", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
}
