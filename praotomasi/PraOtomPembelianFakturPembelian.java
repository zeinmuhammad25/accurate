package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpembelian.FakturPembelianParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.FakturPembelianTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPembelianFakturPembelian extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPembelianFakturPembelian.class);
	
	private String TARGET_FILE = "PraOtomasi Pembelian - Faktur Pembelian.txt";
	
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
		param.noform="No Faktur 01234567890123456789";
//		param.nofaktur="No Faktur 01234567890123456789";
		FakturPembelianTool.isiForm(getWebDriver(), param);
		FakturPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
	
		param.search="ACCURATE 4 EE";
		FakturPembelianTool.isiDetailBarang(getWebDriver(), param);

		param.tab="detail barang";
		param.nama="ACCURATE 4 EE 012345678901234567890123456789012345678901234567890123456789012345"
				+ "67890123456789012345678901234567890123456789012345678901234567890123456789012345678"
				+ "90123456789012345678901234567890123456789012345678901234567890123456789012345";
		param.kuantitas="999999999999";
		param.harga="1";
		param.diskonpersen="100";
		param.gudang="Utama";
		FakturPembelianTool.detailBarang(getWebDriver(), param);
		FakturPembelianTool.klikBtnCalculate(getWebDriver());
		FakturPembelianTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		param.tab = "keterangan";
		param.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ " Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan "
				+ "0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ " Keterangan 01234";
		FakturPembelianTool.detailBarang(getWebDriver(), param);
		FakturPembelianTool.saveKeteranganDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");
		
		FakturPembelianTool.klikTabInfoLainnya(getWebDriver());
		param.nofaktur="No Faktur 01234567890123456789";
		param.tglpengiriman = "03032015";
		param.kenapajak = true;
		param.totaltermasukpajak = true;
		param.pengiriman = "DHL";
		param.fob = "Destination";
		param.tglpajak = "04042022";
		param.nopajak = "No Pajak 0123456789 No Pajak 0";
		param.alamat = "Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 "
				+ "Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat"
				+ " 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789"
				+ " Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 ";
		param.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ " Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 012345678";
		FakturPembelianTool.isiInfoLain(getWebDriver(), param);
		FakturPembelianTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		FakturPembelianTool.klikTabBiayaLainnya(getWebDriver());
		
		param.search = "600001";
		FakturPembelianTool.isiBiayaLain(getWebDriver(), param);
		
		param.tab = "biaya lain";
		param.nama = "biaya 012345678901234567890123456789012345678901234567890123456789012345";
		param.jumlah = "999999999999";
		FakturPembelianTool.detailBiayaLainnya(getWebDriver(), param);
		FakturPembelianTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		param.tab = "keterangan";
		param.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ " Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan "
				+ "0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ "Keterangan 01234";
		FakturPembelianTool.detailBiayaLainnya(getWebDriver(), param);
		FakturPembelianTool.saveKeteranganBiayaLain(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-expense')]");		
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		
	}

	
	@Test(dependsOnMethods = { "buatPI" })
	public void editPI()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "Vendor-Dimas");

		FakturPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
	
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "ACCURATE 4 EE 012345678901234567890123456789012345678901234567890123456789012345"
				+ "67890123456789012345678901234567890123456789012345678901234567890123456789012345678"
				+ "90123456789012345678901234567890123456789012345678901234567890123456789012345");
		FakturPembelianTool.saveDetailBarang(getWebDriver(), TARGET_FILE);

		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");
		
		FakturPembelianTool.klikTabInfoLainnya(getWebDriver());
		FakturPembelianTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		FakturPembelianTool.klikTabBiayaLainnya(getWebDriver());
		
		NavigationTool.klikListGridDetailFormBiayaLain(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "biaya 012345678901234567890123456789012345678901234567890123456789012345");		
		FakturPembelianTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-expense')]");		

		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
	}
	
	@Test(dependsOnMethods = { "editPI" })
//	@Test
	public void cekNavPI() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakDaftarList(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "Vendor-Dimas");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
//		//cek email
//		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
//		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "cekNavPI" })
	public void buatPI2()
	{
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		
		FakturPembelianParam param = new FakturPembelianParam(); 
		
		param.pemasok="Vendor-Dimas";
		param.matauang="IDR";
		param.tanggal="01042022";
		FakturPembelianTool.isiForm(getWebDriver(), param);
		FakturPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
			
		FakturPembelianTool.klikTabInfoLainnya(getWebDriver());
		param.nofaktur="No Faktur ke 2";
		param.tglpengiriman = "03032015";
		FakturPembelianTool.isiInfoLain(getWebDriver(), param);
		FakturPembelianTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		FakturPembelianTool.klikTabBiayaLainnya(getWebDriver());
		
		param.search = "600001";
		FakturPembelianTool.isiBiayaLain(getWebDriver(), param);
		
		param.tab = "biaya lain";
		param.nama = "biaya 012345678901234567890123456789012345678901234567890123456789012345";
		param.jumlah = "999999999999";
		FakturPembelianTool.detailBiayaLainnya(getWebDriver(), param);
		FakturPembelianTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		param.tab = "keterangan";
		param.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789";
		FakturPembelianTool.detailBiayaLainnya(getWebDriver(), param);
		FakturPembelianTool.saveKeteranganBiayaLain(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-expense')]");		
		
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		
	}
	@Test(dependsOnMethods = { "buatPI2" })
	public void hapusPI()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "Vendor-Dimas");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN, "Vendor-Dimas");
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
