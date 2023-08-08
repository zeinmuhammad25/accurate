package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.cabang.CabangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.CabangTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;

public class PraOtomPerusahaanCabang extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomPerusahaanCabang.class);

	private String TARGET_FILE = "PraOtomasi Perusahaan - Cabang.txt";

	@Test
	public void isiCabang() {

		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.CABANG);
		CabangParam cabangawal = new CabangParam();
		cabangawal.nama = "Cabang0123456789Cabang0123456789Cabang0123456789Cabang0123456789Cabang0123456789";
		cabangawal.jalan = "Jalan 0123456789 Jalan 0123456789 Jalan 0123456789 Jalan 0123456789 Jalan 0123456789 Jalan 0123456789 Jalan 0123456789 Jalan 0123456789 Jalan 0123456789 Jalan 0123456789 Jalan 0123456789 Jalan 0123456";
		cabangawal.kota = "Kota 0123456789 Kota 0123456789 Kota 0123456789 Ko";
		cabangawal.kodepos = "1234567890";
		cabangawal.propinsi = "Propinsi 0123456789 Propinsi 0123456789 Propinsi 0";
		cabangawal.negara = "Negara 0123456789 Negara 0123456789 Negara 0123456";
		CabangTool.isiCabang(getWebDriver(), cabangawal);
		CabangTool.saveIsiCabang(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.CABANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.CABANG);
	}
	
	@Test(dependsOnMethods = "isiCabang")
	public void editCabang() {

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.CABANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.CABANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.CABANG, "Cabang0123456789Cabang0123456789Cabang0123456789Cabang0123456789Cabang0123456789");
		CabangParam cabangedit = new CabangParam();
		cabangedit.nama = "blank";
		cabangedit.jalan = "blank";
		cabangedit.kota = "blank";
		cabangedit.kodepos = "blank";
		cabangedit.propinsi = "blank";
		cabangedit.negara = "blank";
		CabangTool.isiCabang(getWebDriver(), cabangedit);
		CabangTool.saveIsiCabang(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.CABANG);
		GeneralTool.simpanPesanError(getWebDriver(), TARGET_FILE);
		NavigationTool.klikErrorOK(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.CABANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
	}

	@Test(dependsOnMethods = "editCabang")
	public void hapusCabang() {

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.CABANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.CABANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.CABANG, "Cabang0123456789Cabang0123456789Cabang0123456789Cabang0123456789Cabang0123456789");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.CABANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.CABANG);
	}
	
	@Test(dependsOnMethods = "hapusCabang")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
