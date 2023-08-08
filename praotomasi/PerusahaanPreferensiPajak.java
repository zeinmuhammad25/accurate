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

public class PerusahaanPreferensiPajak extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PerusahaanPreferensiPajak.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Pajak.txt";

	@Test
	public void isiPajak() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.namapersh = "coba nama";
		param.tanggalpkp = "03072013";
		param.nopengukuhan = "700800";
//		param.kodecabang = "kode1";
		param.tipeusaha = "tipe saya";
//		param.noserifaktur = "100200";
		param.npwp = "123123";
		param.klu = "7654321";
//		param.metode = "Dibulatkan kebawah";
//		param.sebesar = "20";
		param.pajakbarangmewah = true;
//		param.penghitunganpajak = true;
		param.jalan = "jalan saya";
		param.kota = "kota saya";
		param.propinsi = "propinsi saya";
		param.kodepos = "321321";
		param.negara = "indocafe";
		PreferensiTool.isiPajak(getWebDriver(), param);
		PreferensiTool.saveIsiPajak(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	@Test(dependsOnMethods = "isiPajak")
	public void editPajak() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.namapersh = "PT DIMAS";
		param.tanggalpkp = "03072013";
//		param.kodecabang = "kode2";
		param.tipeusaha = "tipe saya";
//		param.noserifaktur = "100200";
		param.npwp = "123123";
		param.nopengukuhan = "700800";
		param.klu = "7654321";
//		param.metode = "Tidak Dibulatkan";
//		param.sebesar = "20";
		param.pajakbarangmewah = false;
//		param.penghitunganpajak = false;
		param.jalan = "jalan saya";
		param.kota = "kota saya";
		param.propinsi = "propinsi saya";
		param.kodepos = "321321";
		param.negara = "indocafe";
		PreferensiTool.isiPajak(getWebDriver(), param);
		PreferensiTool.saveIsiPajak(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = "editPajak")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
