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

public class PerusahaanAlamat extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PerusahaanAlamat.class);

	private String TARGET_FILE = "Perusahaan - Alamat.txt";
	
	@Test
	public void isiAlamat()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		param.nama = "Vendor-Dimas";
		param.jalan = "Jalan Alamat 0123456789 Jalan Alamat 0123456789 Jalan Alamat 0123456789 Jalan Alamat 0123456789 Jalan Alamat 0123456789 Jalan Alamat 0123456789 Jalan Alamat 0123456789 Jalan Alamat 0123456789 Jalan Al";
		param.kota = "Kota 0123456789 Kota 0123456789 Kota 0123456789 Ko";
		param.propinsi = "Propinsi 0123456789 Propinsi 0123456789 Propinsi 0";
		param.kodepos = "0123456789";
		param.negara = "Negara 0123456789 Negara 0123456789 Negara 0123456";
		PreferensiTool.isiInfoPerusahaan(getWebDriver(), param);
		PreferensiTool.saveIsiPerusahaan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
//		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PREFERENSI);
	}
	
	@Test(dependsOnMethods = "isiAlamat")
	public void EditisiAlamat() 
	{		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		param.jalan = "Pondok Arum";
		param.kota = "blank";
		param.propinsi = "blank";
		param.kodepos = "blank";
		param.negara = "blank";
		PreferensiTool.isiInfoPerusahaan(getWebDriver(), param);
		PreferensiTool.saveIsiPerusahaan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
//		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PREFERENSI);

	}
	
	@Test(dependsOnMethods = "EditisiAlamat")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
