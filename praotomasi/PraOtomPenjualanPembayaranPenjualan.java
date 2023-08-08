package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.penerimaanpenjualan.PenerimaanPenjualanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.FakturPenjualanTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.accurate.tool.PenerimaanPenjualanTool;
import com.cpssoft.web.test.accurate.tool.DesainCetakanTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPenjualanPembayaranPenjualan extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPenjualanPembayaranPenjualan.class);
	
	private String TARGET_FILE = "PraOtomasi Penjualan - Pembayaran Penjualan.txt";
	
	@Test()
	public void buatDesainCetakan1(){
		//hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		//cetak 1
		DesainCetakanParam param = new DesainCetakanParam();
		param.nama ="coba1";
		param.tipe ="Penerimaan Penjualan";
		param.layout ="Default";
		DesainCetakanTool.isiForm(getWebDriver(), param);
		DesainCetakanTool.saveIsiForm(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DESAIN_CETAKAN);



	}
	
	@Test(dependsOnMethods = { "buatDesainCetakan1" })
	public void buatDesainCetakan2(){
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		//cetak 2
		DesainCetakanParam param = new DesainCetakanParam();
		param.nama ="coba2";
		param.tipe ="Penerimaan Penjualan";
		param.layout ="Default";
		DesainCetakanTool.isiForm(getWebDriver(), param);
		DesainCetakanTool.saveIsiForm(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DESAIN_CETAKAN);



	}
	
	@Test(dependsOnMethods = { "buatDesainCetakan2" })
	public void buatDesainCetakan3(){
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		//cetak 3
		DesainCetakanParam param = new DesainCetakanParam();
		param.nama ="coba3";
		param.tipe ="Penerimaan Penjualan";
		param.layout ="Default";
		DesainCetakanTool.isiForm(getWebDriver(), param);
		DesainCetakanTool.saveIsiForm(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DESAIN_CETAKAN);



	}
	
	@Test(dependsOnMethods = { "buatDesainCetakan3" })
	public void buatDesainCetakan4(){
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		//cetak 4
		DesainCetakanParam param = new DesainCetakanParam();
		param.nama ="coba4";
		param.tipe ="Penerimaan Penjualan";
		param.layout ="Default";
		DesainCetakanTool.isiForm(getWebDriver(), param);
		WaitTool.delay(1000);
		DesainCetakanParam akses = new DesainCetakanParam();
		akses.cbpengguna = false;
		akses.pengguna = "otomasiPraotomasi@bisnis2030.com";
		DesainCetakanTool.isiAksesPengguna(getWebDriver(), akses);

		DesainCetakanTool.saveIsiForm(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DESAIN_CETAKAN);

	}
	
	@Test(dependsOnMethods = { "buatDesainCetakan4" })
	public void buatSI()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		
		FakturPenjualanParam param = new FakturPenjualanParam();
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		
		param.pelanggan ="ABC";
		param.matauang="IDR";
		param.tanggal="01042022";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		param.no = "SI-01";
		FakturPenjualanTool.isiForm(getWebDriver(), param);
		FakturPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
	
		param.search="ACCURATE 4 EE";
		FakturPenjualanTool.isiDetailBarang(getWebDriver(), param);
		param.tab="detail barang";
		param.kuantitas="5";
		param.harga="12000000";
		param.gudang="Utama";
		FakturPenjualanTool.detailBarang(getWebDriver(), param);
		AccTool.click(getWebDriver(), "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='unitPrice']]//*[@class='btn-calculate']");
		FakturPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		WaitTool.delay(1000);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "buatSI" })
	
	
	public void buatCR()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		
		PenerimaanPenjualanParam param2 = new PenerimaanPenjualanParam();
		
		param2.terimadari="ABC";
		param2.matauang="IDR";
		param2.bank="Bank IDR";
		//param2.nocek="No Cek 0123456789 No Cek 01234";
		//param2.tanggalcek="02032015";
		param2.tglpembayaran = "02042022";
		param2.no="CR-01";
		PenerimaanPenjualanTool.isiForm(getWebDriver(), param2);
		PenerimaanPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param2.search="SI-01";
		PenerimaanPenjualanTool.isiDetailFaktur(getWebDriver(), param2);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-invoice')]");
		
		PenerimaanPenjualanTool.klikHitung(getWebDriver());
		
		
		param2.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 012345678";
		param2.metodebayar="Cek/Giro";
		param2.nocek="No Cek 0123456789 No Cek 01234";
		param2.tanggalcek="02032015";
		PenerimaanPenjualanTool.isiInfoLain(getWebDriver(), param2);
		PenerimaanPenjualanTool.saveInfolain(getWebDriver(), TARGET_FILE);
		
		PenerimaanPenjualanTool.saveFooter(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "buatCR" })
	public void cekNavCR() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "CR-01");
		//cetak form belum di buatkan tc buat design cetakan
		NavigationTool.klikCetakFormLainnya(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.klikPilihDesainCetakanForm(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "Penerimaan Penjualan - Default");
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "cekNavCR" })
	public void hapusCRSI()
	{
		//hapus CR
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN, "CR-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_PENJUALAN);
		
		//hapus SI
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN, "SI-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN);
		
		//hapus design cetakan
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.DESAIN_CETAKAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.DESAIN_CETAKAN, "coba1");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.DESAIN_CETAKAN, "coba2");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.DESAIN_CETAKAN, "coba3");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.DESAIN_CETAKAN, "coba4");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.DESAIN_CETAKAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
	}
	
	@Test(dependsOnMethods = { "hapusCRSI" })
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
