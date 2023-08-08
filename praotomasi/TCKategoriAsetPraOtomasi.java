package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoriaset.KategoriAsetParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriAsetTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class TCKategoriAsetPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCKategoriAsetPraOtomasi.class);

	private String TARGET_FILE = "Aset-KategoriAset.txt";

	@Test
	public void buatBaru() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.KATEGORI_ASET);

		// Buat Data Baru
		log.info("Buat 2 buah data baru");
		KategoriAsetParam param = new KategoriAsetParam();
		param.nama = "1234!@#$ki";
		KategoriAsetTool.isi(getWebDriver(), param);
		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.KATEGORI_ASET);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		param.nama = "khusus ini adalah percobaan";
		KategoriAsetTool.isi(getWebDriver(), param);
		NavigationTool.klikSimpanData(getWebDriver(), 
				AccurateModule.KATEGORI_ASET);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		log.info("simpan notifikasi");
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_ASET,
				"Data Baru");
		log.info("simpan list ");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KATEGORI_ASET, TARGET_FILE);
		log.info("simpan list berhasil");
		
		NavigationTool.cariList(getWebDriver(), AccurateModule.KATEGORI_ASET,
				"1234!@#$ki");

		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET, "1234!@#$ki");

		KategoriAsetTool.saveIsi(getWebDriver(), TARGET_FILE);
		log.info("simpan isi KATEGORI ASET");

		KategoriAsetParam KategoriAsetedit = new KategoriAsetParam();
		KategoriAsetedit.nama = "khusus ini adalah percobaan";
		KategoriAsetTool.isi(getWebDriver(), KategoriAsetedit);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_ASET);
		
		//hapus
		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET, "1234!@#$ki");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_ASET);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET);
	}
	
	@Test(dependsOnMethods = "buatBaru")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}

