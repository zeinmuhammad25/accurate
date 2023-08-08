package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.asettetap.AsetTetapParam;
import com.cpssoft.web.test.accurate.pindahaset.PindahAsetParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AsetTetapTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PindahAsetTool;

public class PraOtomAsetPindahAset extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomAsetPindahAset.class);

	private String TARGET_FILE = "PraOtomasi Aset - Pindah Aset.txt";

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
		param.tanggalbeli = "01012013";
		param.tanggalpakai = "01012013";
		param.penomoran = "KD1";
		String w = AccurateModule.ASET_TETAP.getXpath();
		AccTool.click(getWebDriver(), w + "//button[@name='btnManualNumber']");
		AsetTetapTool.isi(getWebDriver(), param);

		param.cbasettidakberwujud = false;
		param.kuantitas = "30";
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
	public void pindahASet() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PINDAH_ASET);

		// Buat Data Baru
		log.info("Buat 2 buah data baru");
		PindahAsetParam param = new PindahAsetParam();
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PINDAH_ASET);
		param.tanggal = "02022015";
		param.alamatasal = "Kantor Pusat";
		param.alamattujuan = "Utama";
		param.no = "PindahAset01";
		PindahAsetTool.isi(getWebDriver(), param);
		PindahAsetTool.saveIsiHeader(getWebDriver(), TARGET_FILE);

		param.search = "Kendaraan";
		PindahAsetTool.isiDetailAset(getWebDriver(), param);

		param.tab = "detailaset";
		param.kuantitas = "20";
		PindahAsetTool.detailAset(getWebDriver(), param);
		param.tab = "keterangan";
		param.note = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns "
				+ "15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		PindahAsetTool.detailAset(getWebDriver(), param);
//		PindahAsetTool.saveDetail(getWebDriver(), TARGET_FILE);
		AccTool.click(getWebDriver(),"//*[contains(@id,'detail-asset')]//*[@name='btnNext']" );
		PindahAsetTool.saveIsiDetailAset(getWebDriver(), TARGET_FILE);

		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns "
				+ "15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		PindahAsetTool.isiInfoLain(getWebDriver(), param);
		PindahAsetTool.saveIsiInfoLainnya(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PINDAH_ASET);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PINDAH_ASET);
	}

	@Test(dependsOnMethods = "pindahASet")
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
