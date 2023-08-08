package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pesananpenjualan.PesananPenjualanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PesananPenjualanTool;

public class PraOtomPenjualanPesananPenjualan extends AbstractAccurateTestCase {
	static Logger Log = LogManager.getLogger(PraOtomPenjualanPesananPenjualan.class);

	private String TARGET_FILE = "PraOtomasi Penjualan - Pesanan Penjualan.txt";

	@Test()
	public void buatSO() {
		// hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);

		PesananPenjualanParam param = new PesananPenjualanParam();
		param.dipesanoleh = "ABC";
		param.tanggal = "20042022";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		param.no = "SO-01";
		PesananPenjualanTool.isiForm(getWebDriver(), param);
		PesananPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);

		param.search = "Indomie";
		PesananPenjualanTool.isiDetailBarang(getWebDriver(), param);
		param.tab = "detail barang";
		param.kuantitas = "1";
		param.harga = "2500";
		PesananPenjualanTool.detailBarang(getWebDriver(), param);
		PesananPenjualanTool.klikLanjutItem(getWebDriver());
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "Indomie");
		PesananPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		PesananPenjualanTool.klikLanjutItem(getWebDriver());


		PesananPenjualanTool.saveFooterPPN11(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "buatSO" })
	public void editSO() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "ABC");
		
		PesananPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		PesananPenjualanParam param = new PesananPenjualanParam();
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "Indomie");
		
		param.tab = "detail barang";
		// param.kuantitas = "1";
		param.harga = "999999999999";
		param.diskonpersen = "";
		param.cbpajak1 = true;
//		param.cbpajak2 = true ;		
		PesananPenjualanTool.detailBarang(getWebDriver(), param);
		PesananPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		param.tab = "keterangan";
		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns"
				+ " 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingl"
				+ "y to their various descriptions of the surface and of human beings.";
		PesananPenjualanTool.detailBarang(getWebDriver(), param);
		PesananPenjualanTool.saveKeteranganDetailBarang(getWebDriver(), TARGET_FILE);
		PesananPenjualanTool.klikLanjutItem(getWebDriver());
		
		PesananPenjualanTool.klikTabInfoLainnya(getWebDriver());
		param.alamat = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns"
				+ " 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old "
				+ "enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid listens"
				+ " longingly to their various descriptions of the surface and of human beings.";
		param.cbtermasukpajak = true;
		param.nopo = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid "
				+ "turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become"
				+ " old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid "
				+ "listens longingly to their various descriptions of the surface and of human beings.";
		param.pengiriman = "dhl";
		param.fob = "destination";
		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns"
				+ " 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		PesananPenjualanTool.isiInfoLain(getWebDriver(), param);
		PesananPenjualanTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		PesananPenjualanTool.klikTabBiayaLainnya(getWebDriver());
		param.search = "Beban Telekomunikasi";
		PesananPenjualanTool.isiBiayaLain(getWebDriver(), param);
		param.tab = "biaya lain";
		param.jumlah = "999999999999";
//		param.departemen = "Dept 1";
		PesananPenjualanTool.detailBiayaLainnya(getWebDriver(), param);
		PesananPenjualanTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		param.tab = "keterangan";
		param.departemen = "Dept 1";
		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns"
				+ " 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		PesananPenjualanTool.detailBiayaLainnya(getWebDriver(), param);
		PesananPenjualanTool.saveKeteranganDetailBiayaLain(getWebDriver(), TARGET_FILE);
		PesananPenjualanTool.klikLanjutBiaya(getWebDriver());
		AccTool.waitProgressBar(getWebDriver());
		
		PesananPenjualanTool.saveFooterPPN11(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "editSO" })
	public void cekNavSO() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "ABC");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "cekNavSO" })
	public void buatSO2() {
		// hapus target lama

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);

		PesananPenjualanParam param = new PesananPenjualanParam();
		param.dipesanoleh = "ABC";
		param.tanggal = "20042022";
		PesananPenjualanTool.isiForm(getWebDriver(), param);
		PesananPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);

		param.search = "Indomie";
		PesananPenjualanTool.isiDetailBarang(getWebDriver(), param);
		param.tab = "detail barang";
		param.kuantitas = "1";
		param.harga = "2500";
		PesananPenjualanTool.detailBarang(getWebDriver(), param);
		PesananPenjualanTool.klikLanjutItem(getWebDriver());
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "Indomie");
		PesananPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		PesananPenjualanTool.klikLanjutItem(getWebDriver());


		PesananPenjualanTool.saveFooterPPN11(getWebDriver(), TARGET_FILE);
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "buatSO2" })
	public void hapusSO() {
		// hapus SO
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "ABC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "ABC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "hapusSO" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
