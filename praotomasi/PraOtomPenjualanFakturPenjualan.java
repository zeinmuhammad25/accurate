package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.FakturPenjualanTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;

public class PraOtomPenjualanFakturPenjualan extends AbstractAccurateTestCase {
	static Logger Log = LogManager.getLogger(PraOtomPenjualanFakturPenjualan.class);

	private String TARGET_FILE = "PraOtomasi Penjualan - Faktur Penjualan.txt";

	@Test()
	public void buatSI() {
		// hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);

		FakturPenjualanParam param = new FakturPenjualanParam();

		param.pelanggan = "ABC";
		param.matauang = "IDR";
		param.tanggal = "20042022";
		param.no = "SI-01";
		FakturPenjualanTool.isiForm(getWebDriver(), param);
		FakturPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);

		param.search = "Indomie";
		FakturPenjualanTool.isiDetailBarang(getWebDriver(), param);
		param.tab = "detail barang";
		param.harga = "2500";
		param.gudang = "Utama";
		FakturPenjualanTool.detailBarang(getWebDriver(), param);
		AccTool.click(getWebDriver(),
				"//div[starts-with(@id,'tab-detailitem')]//div[input[@name='unitPrice']]//*[@class='btn-calculate']");
		FakturPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		
		// klik link departemen
//		AccTool.click(getWebDriver(),
//				"//div[@class='mask-wrapper']//div[11]//span[@class='fs-smaller text-right']");
		
		
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
	}

	@Test(dependsOnMethods = { "buatSI" })
	public void editSI() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "ABC");

		FakturPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		FakturPenjualanParam param2 = new FakturPenjualanParam();

		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Indomie");
		param2.tab = "detail barang";		
		param2.kuantitas = "999999999999";
		param2.harga = "2500";
		param2.cbpajak1 = true;
		param2.cbpajak2 = true;
		param2.penjual = "Brad Pitt";
		param2.gudang = "Utama";
		FakturPenjualanTool.detailBarang(getWebDriver(), param2);
		AccTool.click(getWebDriver(),
				"//div[starts-with(@id,'tab-detailitem')]//div[input[@name='unitPrice']]//*[@class='btn-calculate']");
		FakturPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		param2.tab = "keterangan";
		param2.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid t"
				+ "urns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become "
				+ "old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid"
				+ " listens longingly to their various descriptions of the surface and of human beings.";
		FakturPenjualanTool.detailBarang(getWebDriver(), param2);		
		FakturPenjualanTool.saveKeteranganDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");

		FakturPenjualanTool.klikTabInfoLainnya(getWebDriver());
		param2.cbtermasukpajak = true;
		param2.nopo = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a merm"
				+ "aid turns 15, she is permitted to swim to the surface to watch the world above, and when the siste"
				+ "rs become old enough, each of them visits the upper world every year. As each of them returns, the "
				+ "Little Mermaid listens longingly to their various descriptions of the surface and of human beings.";
		param2.pengiriman = "dhl";
		param2.fob = "destination";
		param2.alamat = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermai"
				+ "d turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters b"
				+ "ecome old enough, each of them visits the upper world every year. As each of them returns, the Littl"
				+ "e Mermaid listens longingly to their various descriptions of the surface and of human beings.";
		param2.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king"
				+ "), her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermai"
				+ "d turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters b"
				+ "ecome old enough, each of them visits the upper world every year. As each of them returns, the Littl"
				+ "e Mermaid listens longingly to their various descriptions of the surface and of human beings.";
		FakturPenjualanTool.isiInfoLain(getWebDriver(), param2);
		FakturPenjualanTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);

		FakturPenjualanTool.klikTabBiayaLainnya(getWebDriver());

		param2.search = "beban komisi";
		FakturPenjualanTool.isiBiayaLain(getWebDriver(), param2);

		param2.tab = "biaya lain";
		param2.jumlah = "999999999999";
		FakturPenjualanTool.detailBiayaLain(getWebDriver(), param2);
		FakturPenjualanTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		param2.tab = "keterangan";
		param2.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ " Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan "
				+ "0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ "Keterangan 01234";
		FakturPenjualanTool.detailBiayaLain(getWebDriver(), param2);
		FakturPenjualanTool.saveKeteranganBiayaLain(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-expense')]");

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
	}

	
	@Test(dependsOnMethods = { "editSI" })
	public void saveAfterEditSI() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "ABC");

		FakturPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Indomie");
		FakturPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");

		FakturPenjualanTool.klikTabInfoLainnya(getWebDriver());
		FakturPenjualanTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);

		FakturPenjualanTool.klikTabBiayaLainnya(getWebDriver());
		NavigationTool.klikListGridDetailFormBiayaLain(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Beban Komisi");
		FakturPenjualanTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-expense')]");
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
	}
	
	@Test(dependsOnMethods = { "saveAfterEditSI" })
	public void cekNavFaktur() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Data Baru");
		
		//import SI dari excel
		NavigationTool.klikTombolImporFakturFile(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.ImporPenjualanDariFile(getWebDriver(), getDirectory(), "sales-invoice-import-file.xlsx", TARGET_FILE);

		//cetak list
		NavigationTool.klikCetakDaftarList(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "ABC");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "cekNavFaktur" })
	public void buatSI2() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);

		FakturPenjualanParam param = new FakturPenjualanParam();

		param.pelanggan = "ABC";
		param.matauang = "IDR";
		param.tanggal = "20042022";
		FakturPenjualanTool.isiForm(getWebDriver(), param);
		FakturPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);

		param.search = "Indomie";
		FakturPenjualanTool.isiDetailBarang(getWebDriver(), param);
		param.tab = "detail barang";
		param.harga = "2500";
		param.gudang = "Utama";
		FakturPenjualanTool.detailBarang(getWebDriver(), param);
		AccTool.click(getWebDriver(),
				"//div[starts-with(@id,'tab-detailitem')]//div[input[@name='unitPrice']]//*[@class='btn-calculate']");
		FakturPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");

		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikTutupNotifikasi(getWebDriver()); 
		NavigationTool.klikIndikatorLanjutkan(getWebDriver()); 
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
	}

	@Test(dependsOnMethods = { "buatSI2" })
	public void hapusSI() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Data Baru");
//		NavigationTool.cariList(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "SI-01");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "ABC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "ABC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
	}

	@Test(dependsOnMethods = { "hapusSI" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
