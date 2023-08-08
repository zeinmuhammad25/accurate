package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.UangMukaPenjualanTool;
import com.cpssoft.web.test.accurate.uangmukapenjualan.UangMukaPenjualanParam;

public class PraOtomPenjualanUangMukaPenjualan extends AbstractAccurateTestCase {
	static Logger Log = LogManager.getLogger(PraOtomPenjualanUangMukaPenjualan.class);

	private String TARGET_FILE = "PraOtomasi Penjualan - Uang Muka Penjualan.txt";

	@Test()
	public void buatDP() {
		// hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		UangMukaPenjualanParam param = new UangMukaPenjualanParam();

		param.pelanggan = "ABC";
		param.tanggal = "20042022";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		param.no = "No Faktur 01234567890123456789";
		UangMukaPenjualanTool.isiForm(getWebDriver(), param);
		UangMukaPenjualanTool.saveHeader(getWebDriver(), TARGET_FILE);

		param.uangmuka = "2000";
		param.kenapajak = false;
//		param.syaratpembayaran = "C.O.D";
		UangMukaPenjualanTool.isiUangMuka(getWebDriver(), param);
		UangMukaPenjualanTool.saveUangMuka(getWebDriver(), TARGET_FILE);
		
		UangMukaPenjualanTool.klikTabInfoLainnya(getWebDriver());

		param.keterangan = "the little mermaid";
		param.syaratpembayaran = "C.O.D";
		UangMukaPenjualanTool.isiInfoLain(getWebDriver(), param);
		UangMukaPenjualanTool.saveInfoLainnya(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
	}

	@Test(dependsOnMethods = { "buatDP" })
	public void editDP() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN, "the little mermaid");
		
		UangMukaPenjualanTool.saveHeader(getWebDriver(), TARGET_FILE);
		
		UangMukaPenjualanParam param = new UangMukaPenjualanParam();

		param.uangmuka = "999999999999";
		param.nopo = "The Little Mermaid dwells in an underwater kingdom";
		param.kenapajak = false;
		param.syaratpembayaran = "C.O.D";
		UangMukaPenjualanTool.isiUangMuka(getWebDriver(), param);
		UangMukaPenjualanTool.saveUangMuka(getWebDriver(), TARGET_FILE);
		
		UangMukaPenjualanTool.klikTabInfoLainnya(getWebDriver());

		param.alamat = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her dowager grandmother, and her five older sisters, each of whom had been born one year apart. When "
				+ "a mermaid turns 15, she is permitted to swim to the surface for the first time to watch the world above,"
				+ " and when the sisters become old enough, each of them visits the upper world one at a time every year. ";
		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her dowager grandmother, and her five older sisters, each of whom had been born one year apart. When a"
				+ " mermaid turns 15, she is permitted to swim to the surface for the first time to watch the world above";
		param.cabang = "Cabang1";
		UangMukaPenjualanTool.isiInfoLain(getWebDriver(), param);
		UangMukaPenjualanTool.saveInfoLainnya(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
	}

	@Test(dependsOnMethods = { "editDP" })
	public void cekNavUangMuka() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN, "ABC");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "cekNavUangMuka" })
	public void hapusDP() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN, "The Little Mermaid dwells in an underwater"
				+ " kingdom with her father (the sea king or mer-king), her dowager grandmother, and her five older sisters, "
				+ "each of whom had been born one year apart. When a mermaid turns 15, she is permitted to swim to the surface for the first time to watch the world above");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
	}

	@Test(dependsOnMethods = { "hapusDP" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
