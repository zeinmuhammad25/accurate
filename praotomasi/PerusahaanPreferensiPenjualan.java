package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PreferensiTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PerusahaanPreferensiPenjualan extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PerusahaanPreferensiPenjualan.class);

	private String TARGET_FILE = "PraOtomasi Preferensi - Penjualan.txt";

	@Test()
	public void isiPreferensiPenjualan() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.cbreturpenjualan = true;
		WaitTool.delay(1000);
		PreferensiTool.isiPenjualan(getWebDriver(), param);
		PreferensiTool.saveIsiPenjualan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	@Test(dependsOnMethods = { "isiPreferensiPenjualan" })
	public void editPreferensiPenjualan() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.cbreturpenjualan = false;
		PreferensiTool.isiPenjualan(getWebDriver(), param);
		PreferensiTool.saveIsiPenjualan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = { "editPreferensiPenjualan" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
