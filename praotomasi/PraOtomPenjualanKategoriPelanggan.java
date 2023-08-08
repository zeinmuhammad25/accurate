package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoripelanggan.KategoriPelangganParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriPelangganTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPenjualanKategoriPelanggan extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPenjualanKategoriPelanggan.class);
	
	private String TARGET_FILE = "PraOtomasi Penjualan - Kategori Pelanggan.txt";
	
	@Test()
	public void buatKategoriPelanggan()
	{
		//hapus target lama
		Log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		
		KategoriPelangganParam param = new KategoriPelangganParam();
		param.nama = "test";
		KategoriPelangganTool.isiForm(getWebDriver(), param);
		KategoriPelangganTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		param.nama = "123";
		KategoriPelangganTool.isiForm(getWebDriver(), param);
		KategoriPelangganTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
	}
	
	@Test(dependsOnMethods = { "buatKategoriPelanggan" })
	public void editKategoriPelanggan()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN, "123");
		KategoriPelangganParam param = new KategoriPelangganParam();
		
		param.nama = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters";
		param.defaultKategori = true;
		param.subKategori = true;
		param.namaSubKategori = "test";
		KategoriPelangganTool.isiForm(getWebDriver(), param);
		KategoriPelangganTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
	}
	
	@Test(dependsOnMethods = { "editKategoriPelanggan" })
	public void editKategoriPelanggan2()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN, "The Little Mermaid dwells in an underwater kingdom with her");
		KategoriPelangganParam param = new KategoriPelangganParam();
		
		param.subKategori = false;
		KategoriPelangganTool.isiForm(getWebDriver(), param);
		KategoriPelangganTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
	}	

	@Test(dependsOnMethods = { "editKategoriPelanggan2" })
	public void editKategoriPelanggan3()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN, "Umum");
		KategoriPelangganParam param = new KategoriPelangganParam();
		
		param.defaultKategori = true;
		KategoriPelangganTool.isiForm(getWebDriver(), param);
		KategoriPelangganTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
	}
		
	@Test(dependsOnMethods = { "editKategoriPelanggan3" })
	public void hapusKategoriPelanggan()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN, "test");
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN, "The Little Mermaid dwells in an underwater kingdom with her");
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_PELANGGAN);
	}
	
	@Test(dependsOnMethods = { "hapusKategoriPelanggan" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
