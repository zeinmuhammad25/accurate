package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pengirimanpesanan.PengirimanPesananParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PengirimanPesananTool;

public class PraOtomPenjualanPengirimanPesanan extends AbstractAccurateTestCase {
	static Logger Log = LogManager.getLogger(PraOtomPenjualanPengirimanPesanan.class);

	private String TARGET_FILE = "PraOtomasi Penjualan - Pengiriman Pesanan.txt";

	@Test()
	public void buatDO() {
		// hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);

		PengirimanPesananParam param = new PengirimanPesananParam();
		param.kirimke = "ABC";
		param.tanggal = "20032015";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		param.no = "DO-01";
		PengirimanPesananTool.isiForm(getWebDriver(), param);

		param.search = "Indomie";
		PengirimanPesananTool.isiDetailBarang(getWebDriver(), param);

		param.tab = "detail barang";
		param.nama = "Indomie";
		param.kuantitas = "2";
		PengirimanPesananTool.detailBarang(getWebDriver(), param);
		PengirimanPesananTool.saveDetail(getWebDriver(), TARGET_FILE);
		PengirimanPesananTool.klikLanjutItem(getWebDriver());
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
	}

	@Test(dependsOnMethods = { "buatDO" })
	public void editDO() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "ABC");

		PengirimanPesananParam param = new PengirimanPesananParam();
		param.pengiriman = "POS";
		PengirimanPesananTool.isiForm(getWebDriver(), param);
		PengirimanPesananTool.saveheader(getWebDriver(), TARGET_FILE);

		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "Indomie");
		param.tab = "detail barang";
		param.nama = "Indomie";
		param.kuantitas = "999999999999";
		PengirimanPesananTool.detailBarang(getWebDriver(), param);

		param.tab = "keterangan";
		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king "
				+ "or mer-king), her grandmother, and her five sisters. Her five sisters are each born one yea"
				+ "r apart. When a mermaid turns 15, she is permitted to swim to the surface to watch the world"
				+ " above, and when the sisters become old enough, each of them visits the upper world every yea"
				+ "r. As each of them returns, the Little Mermaid listens longingly to their various description"
				+ "s of the surface and of human beings.";
		PengirimanPesananTool.detailBarang(getWebDriver(), param);
		PengirimanPesananTool.saveDetail(getWebDriver(), TARGET_FILE);
		PengirimanPesananTool.klikLanjutItem(getWebDriver());
		
		PengirimanPesananTool.klikTabInfoLainnya(getWebDriver());
		param.alamat = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly to their various descriptions of the surface and of human beings.";
		param.nopo = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly to their various descriptions of the surface and of human beings.";
		param.fob = "destination";
		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly to their various descriptions of the surface and of human beings.";
		PengirimanPesananTool.isiInfoLain(getWebDriver(), param);
		PengirimanPesananTool.saveInfoLain(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
	}
	
	@Test(dependsOnMethods = { "editDO" })
	public void cekNavPengiriman() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakDaftarList(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "ABC");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
	}

	@Test(dependsOnMethods = { "cekNavPengiriman" })
	public void buatDO2() {
		// hapus target lama

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);

		PengirimanPesananParam param = new PengirimanPesananParam();
		param.kirimke = "ABC";
		param.tanggal = "20032015";
		PengirimanPesananTool.isiForm(getWebDriver(), param);

		param.search = "Indomie";
		PengirimanPesananTool.isiDetailBarang(getWebDriver(), param);

		param.tab = "detail barang";
		param.nama = "Indomie";
		param.kuantitas = "2";
		PengirimanPesananTool.detailBarang(getWebDriver(), param);
		PengirimanPesananTool.saveDetail(getWebDriver(), TARGET_FILE);
		PengirimanPesananTool.klikLanjutItem(getWebDriver());
		
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
	}
	
	@Test(dependsOnMethods = { "cekNavPengiriman" })
	public void hapusDO() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "ABC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "ABC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
	}

	@Test(dependsOnMethods = { "hapusDO" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
