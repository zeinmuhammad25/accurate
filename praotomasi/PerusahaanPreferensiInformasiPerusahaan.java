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

public class PerusahaanPreferensiInformasiPerusahaan extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PerusahaanPreferensiInformasiPerusahaan.class);

	private String TARGET_FILE = "PraOtomasi Preferensi - Informasi Perusahaan.txt";

	@Test()
	public void isiInformasiPerusahaan() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);

		PreferensiParam param = new PreferensiParam();
		param.nama = "coba";
		param.telepon = "021123456";
		param.fax = "031778899";
		param.email = "test@cpssoft.com";
		param.jalan = "jalanjalanwae";
		param.kota = "DKI Jakarta";
		param.kodepos = "54321";
		param.propinsi = "propinsi mane";
		param.negara = "indocafe";
		PreferensiTool.isiInfoPerusahaan(getWebDriver(), param);
		PreferensiTool.saveIsiPerusahaan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	@Test(dependsOnMethods = { "isiInformasiPerusahaan" })
	public void editInformasiPerusahaan()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param2 = new PreferensiParam();
		
		param2.nama = "PT Dimas";
		param2.telepon = "08989199915";
		param2.fax = "08989199915";
		param2.email = "dimas@cpssoft.com";
		param2.jalan = "Pondok Arum Blok B11 no 20";
		param2.kota = "Tangerang";
		param2.kodepos = "15112";
		param2.propinsi = "Banten";
		param2.negara = "Indonesia";
		PreferensiTool.isiInfoPerusahaan(getWebDriver(), param2);
		PreferensiTool.saveIsiPerusahaan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = { "editInformasiPerusahaan" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
