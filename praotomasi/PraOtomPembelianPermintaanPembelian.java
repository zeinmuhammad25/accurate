package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.permintaanbarang.PermintaanBarangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PermintaanBarangTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPembelianPermintaanPembelian extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPembelianPermintaanPembelian.class);
	
	private String TARGET_FILE = "PraOtomasi Pembelian - Permintaan Pembelian.txt";
	
	@Test()
	public void buatPR()
	{
		//hapus target lama
		Log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PERMINTAAN_BARANG);
		PermintaanBarangParam param = new PermintaanBarangParam();
		param.tanggal = "23022015";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PERMINTAAN_BARANG);
		param.penomoran = "PR-01";
		param.tipediminta = "Beli Barang";
		PermintaanBarangTool.Isi(getWebDriver(), param);
		PermintaanBarangTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		//barang1
		param.search = "ACCURATE 4 SE";
		PermintaanBarangTool.IsiDetailBarang(getWebDriver(), param);
		param.tab = "detail barang";
		param.tanggal = "24022015";
		param.nama = "ACCURATE 4 SE XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
				+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY"
				+ "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"
				+ "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZKJLKJKLJLL";
		param.kuantitas = "999999999999";
		PermintaanBarangTool.detailBarang(getWebDriver(), param);		
		
		param.tab = "Keterangan";
		param.keterangan = "Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0123"
				+ "456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan01234567"
				+ "89Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Ke"
				+ "terangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Keteran"
				+ "gan0123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan012"
				+ "3456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789";
		PermintaanBarangTool.keteranganBarang(getWebDriver(), param);
		PermintaanBarangTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		PermintaanBarangTool.klikButtonLanjutDetailBarang(getWebDriver());
		WaitTool.delay(1000);
		
		PermintaanBarangTool.klikTabInfoLainnya(getWebDriver());
		PermintaanBarangParam param2 = new PermintaanBarangParam();
		param2.keterangan = "Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789"
				+ "Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0"
				+ "123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789";
		PermintaanBarangTool.isiInfoLain(getWebDriver(), param2);
		PermintaanBarangTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PERMINTAAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PERMINTAAN_BARANG);
	}
	

	@Test(dependsOnMethods = { "buatPR" })
	public void hapusPR()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PERMINTAAN_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PERMINTAAN_BARANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PERMINTAAN_BARANG, "Keterangan0123456789Keterangan0123"
				+ "456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0"
				+ "123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterangan0123456789Keterang"
				+ "an0123456789");
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PERMINTAAN_BARANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PERMINTAAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "hapusPR" })
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
