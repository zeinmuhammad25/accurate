package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.ProsesAkhirBulanTool;
import com.cpssoft.web.test.accurate.prosesakhirbulan.ProsesAkhirBulanParam;


public class PraOtomPerusahaanProsesAkhirBulan extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomPerusahaanProsesAkhirBulan.class);

	private String TARGET_FILE = "PraOtomasi Perusahaan - Proses Akhir Bulan.txt";

	@Test
	public void buatBaru() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN);

		// Buat Data Baru
		log.info("Buat data baru");
		ProsesAkhirBulanParam param = new ProsesAkhirBulanParam();
		param.bulan = "Juni";
		param.tahun = "2016";
		ProsesAkhirBulanTool.isi(getWebDriver(), param);
		ProsesAkhirBulanTool.saveIsi(getWebDriver(), TARGET_FILE);
		param.matauang = "US";
		ProsesAkhirBulanTool.klikMataUang(getWebDriver(), param);
		param.nilaitukar = "1200";
		ProsesAkhirBulanTool.detailNilaiTukar(getWebDriver(), param);
		ProsesAkhirBulanTool.saveListPeriodEnd(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN);
	}

	@Test(dependsOnMethods = "buatBaru")
	public void Edit() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN, "Juni 2016");

		ProsesAkhirBulanParam param = new ProsesAkhirBulanParam();
		param.matauang = "US";
		ProsesAkhirBulanTool.klikMataUang(getWebDriver(), param);
		param.nilaitukar = "99999999999";
		ProsesAkhirBulanTool.detailNilaiTukar(getWebDriver(), param);
		ProsesAkhirBulanTool.saveListPeriodEnd(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN);
	}

	@Test(dependsOnMethods = "Edit")
	public void hapus() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN, "Juni 2016");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PROSES_AKHIR_BULAN);
	}

	@Test(dependsOnMethods = "hapus")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
