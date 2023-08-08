package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penomoranpajak.PenomoranPajakParam;

public class PenomoranPajakTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PenomoranPajakTool.class);

	public static void isiForm(WebDriver driver, PenomoranPajakParam param) {
		log.info("PenomoranPajak.Isi");

		String w = AccurateModule.PENOMORAN_PAJAK.getXpath();
		String tab = w + "//div[contains(@id,'tab-general')]";		
		
		AccTool.click(driver, w + "//a[text()='Penomoran Faktur Pajak']");
		
		if (param.darinomor != null)
		AccTool.textField(driver, tab, "@name='fromNumber'", param.darinomor);
		if (param.sampainomor != null)
		AccTool.textField(driver, tab, "@name='toNumber'", param.sampainomor);
	}
	
	
	public static void saveData(WebDriver driver, String filename) {
		log.info("Penomoran.SaveData");

		String w = AccurateModule.PENOMORAN_PAJAK.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";
		String content = "PenomoranPajak.SaveIsi : " + "\r\n";

		content = content
				+ "Dari nomor	:"
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN_PAJAK,
						ElementType.TEXTFIELD, "fromNumber", tab)
				+ "Sampai nomor	:"		
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN_PAJAK,
						ElementType.TEXTFIELD, "toNumber", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	
}
