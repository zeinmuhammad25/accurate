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

public class PerusahaanPreferensiLainLain extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PerusahaanPreferensiLainLain.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Lain Lain.txt";

	@Test
	public void isiLainLain() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.rentangumurhutang = "10";
		param.umurtanggalfaktur = true;
		param.umurjatuhtempo = false;
		param.rentangumurpersediaan = "20";
		param.komisipenjualan = "Faktur sudah lunas";
		PreferensiTool.isiLainLain(getWebDriver(), param);
		PreferensiTool.saveIsiLainLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	@Test(dependsOnMethods = "isiLainLain")
	public void editLainLain() {
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.rentangumurhutang = "30";
		param.umurtanggalfaktur = false;
		param.umurjatuhtempo = true;
		param.rentangumurpersediaan = "30";
		param.komisipenjualan = "Semua Faktur";
		PreferensiTool.isiLainLain(getWebDriver(), param);
		PreferensiTool.saveIsiLainLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = "editLainLain")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
