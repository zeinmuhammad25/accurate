package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.asetperlokasi.AsetPerLokasiParam;
import com.cpssoft.web.test.accurate.asettetap.AsetTetapParam;
import com.cpssoft.web.test.accurate.pindahaset.PindahAsetParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AsetPerLokasiTool;
import com.cpssoft.web.test.accurate.tool.AsetTetapTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PindahAsetTool;

public class PraOtomAsetPerLokasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomAsetPerLokasi.class);

	private String TARGET_FILE = "PraOtomasi Aset - Aset Per Lokasi.txt";

	@Test
	public void buatAset() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);

		// Buat Data Baru
		log.info("Buat data");
		AsetTetapParam param = new AsetTetapParam();
		param.keterangan = "Kendaraan";
		param.tanggalbeli = "02022015";
		param.tanggalpakai = "02022015";
		param.penomoran = "KD1";
		String w = AccurateModule.ASET_TETAP.getXpath();
		AccTool.click(getWebDriver(), w + "//button[@name='btnManualNumber']");
		AsetTetapTool.isi(getWebDriver(), param);

		param.cbasettidakberwujud = true;
		param.kuantitas = "9999999";
		param.metodepenyusutan = "Tidak Terdepresiasi";
		param.akunaset = "Kendaraan";
		AsetTetapTool.isiInfoUmum(getWebDriver(), param);
		AsetTetapTool.saveIsiInformasiUmum(getWebDriver(), TARGET_FILE);

		param.kategoriaset = "test";
		AsetTetapTool.isiInfoLain(getWebDriver(), param);
		AsetTetapTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);

		 param.searchakun = "Perlengkapan Kantor";
		 AsetTetapTool.isiAkun(getWebDriver(), param);
		
		
		 param.tab = "pengeluaran";
		 param.jumlah="22555666";
		 AsetTetapTool.detailAkun(getWebDriver(), param);
		 NavigationTool.klikButtonLanjut(getWebDriver(),
		 "//div[starts-with(@id,'detail-expenditure')]");
		 AccTool.click(getWebDriver(),"//*[contains(@id,'detail-expenditure-grid-list')]//div[@class='grid-canvas']/div[1]");
		 AccTool.click(getWebDriver(),"//*[contains(@id,'detail-expenditure')]//*[text()='Lanjut']");
		 AsetTetapTool.saveListPengeluaran(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.ASET_TETAP);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, "Data Baru");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.ASET_TETAP, TARGET_FILE);
		log.info("simpan list cabang");
		NavigationTool.cariList(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		AsetTetapTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		AsetTetapTool.saveAll(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ASET_TETAP);

	}

	@Test(dependsOnMethods = "buatAset")
	public void asetPerLokasi() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_PER_LOKASI);

		// Buat Data Baru
		log.info("Buat data baru");
		AsetPerLokasiParam param = new AsetPerLokasiParam();
		param.tipe = "Aset";
		param.pilihaset = "KD1";
		param.tanggalaset = "10052016";
		AsetPerLokasiTool.isi(getWebDriver(), param);
		AsetPerLokasiTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikPerbaruiData(getWebDriver(), AccurateModule.ASET_PER_LOKASI);

		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.ASET_PER_LOKASI);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_PER_LOKASI, "Data Baru");
	}

	@Test(dependsOnMethods = "asetPerLokasi")
	public void hapusData() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PINDAH_ASET);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PINDAH_ASET, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PINDAH_ASET, "PindahAset01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PINDAH_ASET);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PINDAH_ASET);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "KD1");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ASET_TETAP);
	}
	
	@Test(dependsOnMethods = "hapusData")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
