package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.asettetap.AsetTetapParam;
import com.cpssoft.web.test.accurate.perubahanasettetap.PerubahanAsetTetapParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AsetTetapTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PerubahanAsetTetapTool;

public class PraOtomAsetPerubahanAsetTetap extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomAsetPerubahanAsetTetap.class);

	private String TARGET_FILE = "PraOtomasi Aset Tetap - Perubahan Aset Tetap.txt";

	@Test
	public void buatBaru() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);

		// Buat Data Baru
		log.info("Buat data");
		AsetTetapParam param = new AsetTetapParam();
		param.keterangan = "Gedung";
		param.tanggalbeli = "01012013";
		param.tanggalpakai = "01012013";
		param.penomoran = "GD1";
		String w = AccurateModule.ASET_TETAP.getXpath();
		AccTool.click(getWebDriver(), w + "//button[@name='btnManualNumber']");
		AsetTetapTool.isi(getWebDriver(), param);

		param.kuantitas = "10";
		param.umurasettahun = "4";
		param.metodepenyusutan = "Metode Garis Lurus";
		param.akunaset = "Gedung";
		param.akunakumulasipenyusutan = "Akumulasi Penyusutan Gedung";
		param.akunbebanpenyusutan = "beban penyusutan Gedung";
		AsetTetapTool.isiInfoUmum(getWebDriver(), param);
		AsetTetapTool.saveIsiInformasiUmum(getWebDriver(), TARGET_FILE);

		param.kategoriaset = "test";
		AsetTetapTool.isiInfoLain(getWebDriver(), param);
		AsetTetapTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);

		param.searchakun = "Sewa Gedung Dibayar Dimuka";
		AsetTetapTool.isiAkun(getWebDriver(), param);

		param.tab = "pengeluaran";
		param.jumlah = "50000000";
		AsetTetapTool.detailAkun(getWebDriver(), param);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-expenditure')]");
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-expenditure-grid-list')]//div[@class='grid-canvas']/div[1]");
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-expenditure')]//*[text()='Lanjut']");
		AsetTetapTool.saveListPengeluaran(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.ASET_TETAP);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, "Data Baru");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.ASET_TETAP, TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.ASET_TETAP, "Gedung");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "Gedung");
		AsetTetapTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		AsetTetapTool.saveAll(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ASET_TETAP);

	}

	@Test(dependsOnMethods = "buatBaru")
	public void perubahanAset() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PERUBAHAN_ASET_TETAP);
		log.info("buat perubahan");
		PerubahanAsetTetapParam param = new PerubahanAsetTetapParam();
		param.aset = "Gedung";
		param.tanggal = "31012013";
		param.penomoran = "PGD1";
		String w = AccurateModule.PERUBAHAN_ASET_TETAP.getXpath();
		AccTool.click(getWebDriver(), w + "//button[@name='btnManualNumber']");
		PerubahanAsetTetapTool.isi(getWebDriver(), param);
		PerubahanAsetTetapTool.saveIsiHeader(getWebDriver(), TARGET_FILE);

		param.jenisperubahan = "Perubahan Semua";
		param.metodepenyusutan = "Metode Saldo Menurun";
		param.umurasettahun = "3";
		param.umurasetbulan = "11";
		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns "
				+ "15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		PerubahanAsetTetapTool.isiInfoUmum(getWebDriver(), param);
		PerubahanAsetTetapTool.saveIsiInfoUmum(getWebDriver(), TARGET_FILE);
		
		param.jumlahrevaluasi = "99999999";
		param.akunlabarugi = "Penjualan";
		PerubahanAsetTetapTool.isiRevaluasi(getWebDriver(), param);
		PerubahanAsetTetapTool.saveIsiRevaluasi(getWebDriver(), TARGET_FILE);
		
		param.search = "Sewa Gedung Dibayar Dimuka";
		PerubahanAsetTetapTool.isiPengeluaran(getWebDriver(), param);
		
		param.jumlah = "9999999999999999";
		PerubahanAsetTetapTool.detailPengeluaran(getWebDriver(), param);
		AccTool.click(getWebDriver(),"//*[contains(@id,'detail-edited-grid')]//div[@class='grid-canvas']/div[1]");
		PerubahanAsetTetapTool.saveDetailPengeluaran(getWebDriver(), TARGET_FILE);
		AccTool.click(getWebDriver(),"//*[contains(@id,'detail-edited')]//*[text()='Lanjut']");
	
		PerubahanAsetTetapTool.saveIsiInfoLainnya(getWebDriver(), TARGET_FILE);		

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PERUBAHAN_ASET_TETAP);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PERUBAHAN_ASET_TETAP);
	}

	@Test(dependsOnMethods = "perubahanAset")
	public void hapusData() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PERUBAHAN_ASET_TETAP);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PERUBAHAN_ASET_TETAP, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PERUBAHAN_ASET_TETAP, "PGD1");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PERUBAHAN_ASET_TETAP);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PERUBAHAN_ASET_TETAP);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "GD1");
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
