package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoriharga.KategoriHargaParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriHargaTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPenjualanKategoriHarga extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPenjualanKategoriHarga.class);
	
	private String TARGET_FILE = "PraOtomasi Penjualan - Kategori Harga.txt";
	
	@Test()
	public void buatKategoriHarga()
	{
		//hapus target lama
		Log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_HARGA);
		
		KategoriHargaParam param = new KategoriHargaParam();
		
		param.nama = "123";
		KategoriHargaTool.isiForm(getWebDriver(), param);
		KategoriHargaTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_HARGA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_HARGA);
	}
	
	@Test(dependsOnMethods = { "buatKategoriHarga" })
	public void editKategoriHarga()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_HARGA);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_HARGA, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_HARGA, "123");
		KategoriHargaParam param = new KategoriHargaParam();
		
		param.nama = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters";
		KategoriHargaTool.isiForm(getWebDriver(), param);
		KategoriHargaTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_HARGA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_HARGA);
	}
			
	@Test(dependsOnMethods = { "editKategoriHarga" })
	public void hapusKategoriHarga()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_HARGA);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_HARGA, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.KATEGORI_HARGA);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_HARGA, "The Little Mermaid dwells in an underwater kingdom with her father (the sea king");
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_HARGA);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_HARGA);
	}
	
	@Test(dependsOnMethods = { "hapusKategoriHarga" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
