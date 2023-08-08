package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penawaranpenjualan.PenawaranPenjualanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PenawaranPenjualanTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPenjualanPenawaranPenjualan extends AbstractAccurateTestCase {
	static Logger Log = LogManager.getLogger(PraOtomPenjualanPenawaranPenjualan.class);

	private String TARGET_FILE = "PraOtomasi Penjualan - Penawaran Penjualan.txt";

	@Test()
	public void BuatPenawaran() {
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);

		PenawaranPenjualanParam param = new PenawaranPenjualanParam();
		param.dipesanoleh = "ABC";
		param.tanggal = "20042022";
		param.no = "SQ-01";
		PenawaranPenjualanTool.isiForm(getWebDriver(), param);
		PenawaranPenjualanTool.saveHeader(getWebDriver(), TARGET_FILE);

		param.search = "Indomie";
		PenawaranPenjualanTool.isiDetailBarang(getWebDriver(), param);

		param.tab = "detail barang";
		param.harga = "2500";
		PenawaranPenjualanTool.detailBarang(getWebDriver(), param);
		PenawaranPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		param.tab = "Keterangan";
		param.keterangan = "The Little Mermaid";		
		PenawaranPenjualanTool.detailBarang(getWebDriver(), param);
		PenawaranPenjualanTool.saveKeteranganDetailBarang(getWebDriver(), TARGET_FILE);
		PenawaranPenjualanTool.klikLanjutItem(getWebDriver());
				
		PenawaranPenjualanTool.saveFooterPPN11(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "BuatPenawaran" })
	public void editPenawaran() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "SQ-01");
		
		PenawaranPenjualanTool.saveHeader(getWebDriver(), TARGET_FILE);
		
		PenawaranPenjualanParam param = new PenawaranPenjualanParam();
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "Indomie");

		param.tab = "detail barang";
//		param.kuantitas= "1";
		param.harga = "999999999999";
		param.diskonpersen = "100";
		param.cbpajak1 = true;
//		param.cbpajak2 = true;
		param.penjual = "Brad Pitt";
		PenawaranPenjualanTool.detailBarang(getWebDriver(), param);
		PenawaranPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		param.tab = "Keterangan";
		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns "
				+ "15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		PenawaranPenjualanTool.detailBarang(getWebDriver(), param);
		PenawaranPenjualanTool.saveKeteranganDetailBarang(getWebDriver(), TARGET_FILE);
		PenawaranPenjualanTool.klikLanjutItem(getWebDriver());
		
		PenawaranPenjualanTool.klikTabInfoLainnya(getWebDriver());
		PenawaranPenjualanParam info = new PenawaranPenjualanParam();
		
		info.alamat = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid "
				+ "turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become"
				+ " old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid"
				+ " listens longingly to their various descriptions of the surface and of human beings.";
		info.cbtermasukpajak = true;
		info.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid"
				+ " turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become "
				+ "old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid "
				+ "listens longingly to their various descriptions of the surface and of human beings.";		
		//info.cabang = "Cabang1";
		PenawaranPenjualanTool.isiInfoLain(getWebDriver(), info);
		PenawaranPenjualanTool.saveInfoLainnya(getWebDriver(), TARGET_FILE);
		
		PenawaranPenjualanTool.klikTabBiayaLainnya(getWebDriver());
		PenawaranPenjualanParam biayalain = new PenawaranPenjualanParam();
		biayalain.search = "Beban Iklan";
		PenawaranPenjualanTool.isiBiayaLain(getWebDriver(), biayalain);
		biayalain.tab = "biaya lain";
		biayalain.jumlah = "99999999999999";
		PenawaranPenjualanTool.detailBiayaLain(getWebDriver(), biayalain);
		PenawaranPenjualanTool.saveDetailBiaya(getWebDriver(), TARGET_FILE);
		biayalain.tab = "keterangan";
		biayalain.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns"
				+ " 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough"
				+ ", each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingl"
				+ "y to their various descriptions of the surface and of human beings.";
		PenawaranPenjualanTool.detailBiayaLain(getWebDriver(), biayalain);
		PenawaranPenjualanTool.saveKeteranganDetailBiayaLain(getWebDriver(), TARGET_FILE);
		PenawaranPenjualanTool.klikLanjutBiaya(getWebDriver());
		AccTool.waitProgressBar(getWebDriver());
		
		PenawaranPenjualanTool.saveFooterPPN11(getWebDriver(), TARGET_FILE);
		WaitTool.delay(1000);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		WaitTool.delay(2000);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "editPenawaran" })
	public void cekPenawaran() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "ABC");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "cekPenawaran" })
	public void hapusPenawaran() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "ABC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "hapusPenawaran" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
