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
import com.cpssoft.web.test.framework.tools.WaitTool;

public class TCCabangPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCCabangPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Cabang.txt";

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

		// isi nama cabang dengan karakter maksimum
		CabangTool.isiCabang(getWebDriver(), cabangawal);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.CABANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		log.info("simpan notifikasi");
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.CABANG,
				"Data Baru");

		// save list dulu
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.CABANG, TARGET_FILE);
		log.info("simpan list cabang");

		// buka cabang
		NavigationTool.cariListData(getWebDriver(), AccurateModule.CABANG,
				cabangawal.nama);
		CabangTool.saveIsiCabang(getWebDriver(), TARGET_FILE);
		log.info("simpan isi cabang");

		CabangParam cabangedit = new CabangParam();
		cabangedit.nama = "blank";
		cabangedit.jalan = "blank";
		cabangedit.kota = "blank";
		cabangedit.kodepos = "blank";
		cabangedit.propinsi = "blank";
		cabangedit.negara = "blank";
		CabangTool.isiCabang(getWebDriver(), cabangedit);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.CABANG);
		GeneralTool.simpanPesanError(getWebDriver(), TARGET_FILE);
		NavigationTool.klikErrorOK(getWebDriver());
		
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.CABANG,
				"Cabang0123456789Cabang0123456789Cabang0123456789Cabang0123456789Cabang0123456789");
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		
		//hapus cabang
		NavigationTool.cariListData(getWebDriver(), AccurateModule.CABANG,
				cabangawal.nama);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.CABANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.CABANG);

	}

}
