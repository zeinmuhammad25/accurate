package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpembelian.FakturPembelianParam;
import com.cpssoft.web.test.accurate.pembayaranpemasok.PembayaranPemasokParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.FakturPembelianTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.accurate.tool.PembayaranPembelianTool;

public class PraOtomPembelianPembayaranPembelian extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPembelianPembayaranPembelian.class);
	
	private String TARGET_FILE = "PraOtomasi Pembelian - Pembayaran Pembelian.txt";
	
	@Test()
	public void buatPI()
	{
		//hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		
		FakturPembelianParam param = new FakturPembelianParam(); 
		
		param.pemasok="Vendor-Dimas";
		param.matauang="IDR";
		param.tanggal="01042022";
		param.noform="PI-01";
//		param.nofaktur="PI-01";
		FakturPembelianTool.isiForm(getWebDriver(), param);
		FakturPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
	
		param.search="ACCURATE 4 EE";
		FakturPembelianTool.isiDetailBarang(getWebDriver(), param);

		param.tab="detail barang";
		param.nama="ACCURATE 4 EE";
		param.kuantitas="5";
		param.harga="12000000";
		param.gudang="Utama";
		FakturPembelianTool.detailBarang(getWebDriver(), param);
		FakturPembelianTool.klikBtnCalculate(getWebDriver());
		FakturPembelianTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");
		
		FakturPembelianTool.klikTabInfoLainnya(getWebDriver());
		param.nofaktur="PI-01";
		FakturPembelianTool.isiInfoLain(getWebDriver(), param);
		FakturPembelianTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "buatPI" })
	public void buatVP()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		
		PembayaranPemasokParam param2 = new PembayaranPemasokParam();
		
		param2.pembayaranke="Vendor-Dimas";
		param2.matauang="IDR";
		param2.bank="Bank IDR";
		//param2.nocek="No Cek 0123456789 No Cek 01234";
		//param2.tanggalcek="02032015";
		param2.tglpembayaran = "02042022";
		param2.nobukti="CR-01";
		PembayaranPembelianTool.isi(getWebDriver(), param2);
		PembayaranPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param2.search="PI-01";
		PembayaranPembelianTool.isiDetailFaktur(getWebDriver(), param2);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-invoice')]");
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK, "PI-01");
		param2.pembayaran = "60000000";
		PembayaranPembelianTool.detailFaktur(getWebDriver(), param2);
		PembayaranPembelianTool.saveIsiDetailFaktur(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-invoice')]");
		
		PembayaranPembelianTool.klikHitungNilaiCek(getWebDriver());
		
		param2.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 012345678";
		PembayaranPembelianTool.isiInfoLain(getWebDriver(), param2);
		PembayaranPembelianTool.saveDetailInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
	}
	
	@Test(dependsOnMethods = { "buatVP" })
//	@Test
	public void cekNavVP() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK, "Data Baru");

//		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK, "CR-01");
//		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email udah kaga ada
//		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
//		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
	}
	
	
	@Test(dependsOnMethods = { "cekNavVP" })
	public void hapusPI()
	{
		//hapus VP
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK, "CR-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMBAYARAN_PEMASOK);
		
		//hapus PI
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "PI-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "hapusPI" })
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
