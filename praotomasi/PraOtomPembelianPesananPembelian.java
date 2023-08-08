package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pesananpembelian.PesananPembelianParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PesananPembelianTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPembelianPesananPembelian extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPembelianPesananPembelian.class);
	
	private String TARGET_FILE = "PraOtomasi Pembelian - Pesanan Pembelian.txt";
	
	@Test()
	public void buatPO()
	{
		//hapus target lama
		Log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		PesananPembelianParam param = new PesananPembelianParam();
		
		param.pemasok = "Vendor-Dimas";
		param.tanggal = "24042022";
		PesananPembelianTool.isiHeader(getWebDriver(), param);
		PesananPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.search = "ACCURATE 4 DE";
		PesananPembelianTool.isiDetailBarang(getWebDriver(), param);
		
		param.tab = "detail barang";
		param.nama = "ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 01234567"
				+ "89ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 0123456789";
		param.kuantitas = "999999999999";
		param.harga = "1";
		param.diskonpersen = "100";
		PesananPembelianTool.detailBarang(getWebDriver(), param);
		PesananPembelianTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");
		
		PesananPembelianTool.klikTabInfoLainnya(getWebDriver());
		param.alamat = "Kavling Polri Blok C no 729 Kavling Polri Blok C no 729 Kavling Polri Blok "
				+ "C no 729 Kavling Polri Blok C no 729 Kavling Polri Blok C no 729 Kavling Polri Blo"
				+ "k C no 729 Kavling Polri Blok C no 729 Kavling Polri Blok C no 729";
		param.kenapajak = false;
		param.tglpengiriman = "24042022";
		param.keterangan = "Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keteranga"
				+ "n 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keteranga";
		PesananPembelianTool.isiInfoLain(getWebDriver(), param);
		PesananPembelianTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		PesananPembelianTool.klikTabBiayaLainnya(getWebDriver());
		param.search = "600001";
		PesananPembelianTool.isiBiayaLainnya(getWebDriver(), param);
		
		param.tab = "biaya lain";
		param.nama = "Beban Iklan";
		param.jumlah = "999999999999";
		PesananPembelianTool.detailBiayaLainnya(getWebDriver(), param);
		param.tab = "keterangan";
		param.keterangan = "Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan "
				+ "0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 012345";
		PesananPembelianTool.detailBiayaLainnya(getWebDriver(), param);
		
		PesananPembelianTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		PesananPembelianTool.saveKeteranganDetailBiayaLain(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//*[contains(@class,'window shadow')]//div[contains(@id,'detail-expense')]");
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "buatPO" })
	public void editPO()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN, "Vendor-Dimas");
		PesananPembelianParam param = new PesananPembelianParam();
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN, "ACCURATE 4 DE Nama 0123456789ACC"
				+ "URATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 012"
				+ "3456789ACCURATE 4 DE Nama 0123456789");
		NavigationTool.hapusListData(getWebDriver(), "//div[contains(@id,'detail-item')]");
		
		param.search = "ACCURATE 4 EE";
		PesananPembelianTool.isiDetailBarang(getWebDriver(), param);
		
		param.tab = "detail barang";
		param.nama = "ACCURATE 4 EE";
		param.kuantitas = "3";
		param.harga = "20000000";
		PesananPembelianTool.detailBarang(getWebDriver(), param);
		PesananPembelianTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), " //div[contains(@id,'detail-item')]");
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "editPO" })
	public void cekNavPO() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN, "Vendor-Dimas");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "cekNavPO" })
	public void buatPO2()
	{
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		PesananPembelianParam param = new PesananPembelianParam();
		
		param.pemasok = "Vendor-Dimas";
		param.tanggal = "24042022";
		PesananPembelianTool.isiHeader(getWebDriver(), param);
		PesananPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.search = "ACCURATE 4 DE";
		PesananPembelianTool.isiDetailBarang(getWebDriver(), param);
		
		param.tab = "detail barang";
		param.nama = "ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 01234567"
				+ "89ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 0123456789ACCURATE 4 DE Nama 0123456789";
		param.kuantitas = "999999999999";
		param.harga = "1";
		param.diskonpersen = "100";
		PesananPembelianTool.detailBarang(getWebDriver(), param);
		PesananPembelianTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");
		
		PesananPembelianTool.klikTabInfoLainnya(getWebDriver());
		param.alamat = "Kavling Polri Blok C no 729 Kavling Polri Blok C no 729 Kavling Polri Blok "
				+ "C no 729 Kavling Polri Blok C no 729 Kavling Polri Blok C no 729 Kavling Polri Blo"
				+ "k C no 729 Kavling Polri Blok C no 729 Kavling Polri Blok C no 729";
		param.kenapajak = false;
		param.tglpengiriman = "24042022";
		param.keterangan = "Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keteranga"
				+ "n 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keteranga";
		PesananPembelianTool.isiInfoLain(getWebDriver(), param);
		PesananPembelianTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		PesananPembelianTool.klikTabBiayaLainnya(getWebDriver());
		param.search = "600001";
		PesananPembelianTool.isiBiayaLainnya(getWebDriver(), param);
		
		param.tab = "biaya lain";
		param.nama = "Beban Iklan";
		param.jumlah = "999999999999";
		PesananPembelianTool.detailBiayaLainnya(getWebDriver(), param);
		param.tab = "keterangan";
		param.keterangan = "Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan "
				+ "0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 012345";
		PesananPembelianTool.detailBiayaLainnya(getWebDriver(), param);
		
		PesananPembelianTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		PesananPembelianTool.saveKeteranganDetailBiayaLain(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//*[contains(@class,'window shadow')]//div[contains(@id,'detail-expense')]");
		
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "buatPO2" })
	public void hapusPO()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN, "Vendor-Dimas");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN, "Vendor-Dimas");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PESANAN_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "hapusPO" })
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
