package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
//import com.cpssoft.web.test.accurate.kategoripelanggan.KategoriPelangganParam;
//import com.cpssoft.web.test.accurate.matauang.Isi;
//import com.cpssoft.web.test.accurate.matauang.IsiDefaultAkun;
import com.cpssoft.web.test.accurate.kategoriaset.KategoriAsetParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class KategoriAsetTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(KategoriAsetTool.class);
	
	public static void isi(WebDriver driver, KategoriAsetParam param) {
		log.info("kategoriaset.Isi");
		
		String w = AccurateModule.KATEGORI_ASET.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";
		
		AccTool.click(driver, w + "//a[text()='Informasi Umum']");

		AccTool.textField(driver, tab, "@name='name'", param.nama);	
		WaitTool.delay(1000);
	}
	
	public static void saveIsi(WebDriver driver, String filename) {
		log.info("kategoriaset.SaveIsi");

//		String w = AccurateModule.KATEGORI_ASET.getXpath();
		String tab = "//*[contains(@id,'tab-general')]/div";
		String content = "kategoriaset.SaveKonten : " + "\r\n";
		
		content = content
				+ "Nama	: "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_ASET, ElementType.TEXTFIELD,
						"name", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
}
