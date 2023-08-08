package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.penawaranpenjualan.PenawaranPenjualanParam;
import com.cpssoft.web.test.accurate.penerimaanpenjualan.PenerimaanPenjualanParam;
import com.cpssoft.web.test.accurate.pengirimanpesanan.PengirimanPesananParam;
import com.cpssoft.web.test.accurate.pesananpenjualan.PesananPenjualanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.FakturPenjualanTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PenawaranPenjualanTool;
import com.cpssoft.web.test.accurate.tool.PenerimaanPenjualanTool;
import com.cpssoft.web.test.accurate.tool.PengirimanPesananTool;
import com.cpssoft.web.test.accurate.tool.PesananPenjualanTool;

public class PraOtomPenjualanSeluruhProsesPenjualan extends AbstractAccurateTestCase {
	static Logger Log = LogManager.getLogger(PraOtomPenjualanSeluruhProsesPenjualan.class);

	private String TARGET_FILE = "PraOtomasi Penjualan - Seluruh Proses Penjualan.txt";

	@Test()
	public void buatPenawaran() {
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);

		PenawaranPenjualanParam param = new PenawaranPenjualanParam();
		param.dipesanoleh = "ABC";
		param.tanggal = "20042022";
		param.no = "SQ-01";
		PenawaranPenjualanTool.isiForm(getWebDriver(), param);

		param.search = "Indomie";
		PenawaranPenjualanTool.isiDetailBarang(getWebDriver(), param);

		param.tab = "detail barang";
		param.kuantitas = "5";
		param.harga = "2500";
		PenawaranPenjualanTool.detailBarang(getWebDriver(), param);
		PenawaranPenjualanTool.klikLanjutItem(getWebDriver());
				
		PenawaranPenjualanTool.klikProsesPesan(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}

	@Test(dependsOnMethods = { "buatPenawaran" })
	public void buatPesanan() {
		NavigationTool.klikPindahTabModule(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		PesananPenjualanParam pesanan = new PesananPenjualanParam();
		NavigationTool.klikPindahTabModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		pesanan.no = "SO-01";
		pesanan.tanggal = "21042022";
		PesananPenjualanTool.isiForm(getWebDriver(), pesanan);

		PesananPenjualanTool.klikProsesPengiriman(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		
	}

	@Test(dependsOnMethods = { "buatPesanan" })
	public void buatpengiriman() {
		NavigationTool.klikPindahTabModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);

		NavigationTool.klikPindahTabModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		PengirimanPesananParam param = new PengirimanPesananParam();
		param.tanggal = "22042022";
		param.no = "DO-01";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		PengirimanPesananTool.isiForm(getWebDriver(), param);

		PengirimanPesananTool.klikFaktur(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}

	@Test(dependsOnMethods = { "buatpengiriman" })
	public void buatFaktur() {
		NavigationTool.klikPindahTabModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);

		NavigationTool.klikPindahTabModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		FakturPenjualanParam param = new FakturPenjualanParam();
		param.no = "SI-01";
		param.tanggal = "23042022";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		FakturPenjualanTool.isiForm(getWebDriver(), param);
		
		FakturPenjualanTool.klikProsesPembayaran(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}

	@Test(dependsOnMethods = { "buatFaktur" })
	public void buatPembayaran() {
		NavigationTool.klikPindahTabModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);

		NavigationTool.klikPindahTabModule(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		PenerimaanPenjualanParam bayar = new PenerimaanPenjualanParam();
		
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		bayar.tglpembayaran = "24042022";
		bayar.no = "CR-01";
		bayar.bank = "Bank";
//		bayar.metodebayar = "Tunai/Lainnya";
		PenerimaanPenjualanTool.isiForm(getWebDriver(), bayar);
		PenerimaanPenjualanTool.klikHitung(getWebDriver());
		PenerimaanPenjualanTool.klikTabInfoLain(getWebDriver());
		
		bayar.metodebayar = "Tunai";
		PenerimaanPenjualanTool.isiInfoLain(getWebDriver(), bayar);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "buatPembayaran" })
	public void simpanPenawaran() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "SQ-01");
		PenawaranPenjualanTool.saveHeader(getWebDriver(), TARGET_FILE);
		PenawaranPenjualanTool.saveListDetailBarang(getWebDriver(), TARGET_FILE);
		PenawaranPenjualanTool.saveFooterPPN11(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "simpanPenawaran" })
	public void simpanPesanan() {
		// save pesanan penjualan
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "Data Baru");
		NavigationTool.cariList(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "SO-01");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "SO-01");
		PesananPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		PesananPenjualanTool.saveListDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "simpanPesanan" })
	public void simpanPengiriman() {
		// DO
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "DO-01");
		PengirimanPesananTool.saveheader(getWebDriver(), TARGET_FILE);
		PengirimanPesananTool.saveListDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
	}

	@Test(dependsOnMethods = { "simpanPengiriman" })
	public void simpanFaktur() {
	// save faktur penjualan
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Data Baru");
		NavigationTool.cariList(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "SI-01");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "SI-01");
		FakturPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		FakturPenjualanTool.saveListDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
	}

	@Test(dependsOnMethods = { "simpanFaktur" })
	public void simpanPenerimaan() {
		// save penerimaan penjualan
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "Data Baru");
		NavigationTool.cariList(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "CR-01");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "CR-01");
		PenerimaanPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		PenerimaanPenjualanTool.saveListDetail(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "simpanPenerimaan" })
	public void hapusTransaksi() {
		// hapus Penerimaan
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "Data Baru");
		NavigationTool.cariList(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "CR-01");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "CR-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);

		// hapus Faktur		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Data Baru");
		NavigationTool.cariList(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "SI-01");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "SI-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);

		// hapus Pengiriman		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "Data Baru");
		NavigationTool.cariList(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "DO-01");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN, "DO-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN);

		// hapus Pesanan		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "Data Baru");
		NavigationTool.cariList(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "SO-01");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN, "SO-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PENJUALAN);
		
		// hapus Penawaran		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "Data Baru");
		NavigationTool.cariList(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "SQ-01");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN, "SQ-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN);
	}

	@Test(dependsOnMethods = { "hapusTransaksi" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
