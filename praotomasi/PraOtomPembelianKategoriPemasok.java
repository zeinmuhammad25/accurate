package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoripemasok.KategoriPemasokParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriPemasokTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPembelianKategoriPemasok extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPembelianKategoriPemasok.class);
	
	private String TARGET_FILE = "PraOtomasi Pembelian - Kategori Pemasok.txt";
	
	@Test()
	public void buatKategoriPemasok()
	{
		//hapus target lama
		Log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_PEMASOK);
		
		KategoriPemasokParam param = new KategoriPemasokParam();
		
		param.nama = "Kategori 123456789Kategori 123456789Kategori 123456789Katego";
		KategoriPemasokTool.isiForm(getWebDriver(), param);
		KategoriPemasokTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		param.nama = "Kategori-01";
		param.cbsubkategori = true;
		param.namasubkategori = "Kategori 123456789Kategori 123456789Kategori 123456789Katego";
		KategoriPemasokTool.isiForm(getWebDriver(), param);
		KategoriPemasokTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_PEMASOK);
	}
	

	@Test(dependsOnMethods = { "buatKategoriPemasok" })
	public void hapusKategoriPemasok()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_PEMASOK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_PEMASOK, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.KATEGORI_PEMASOK);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
				
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_PEMASOK, "Kategori-01");
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_PEMASOK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_PEMASOK, "Kategori 123456789Kategori 123456789Kategori 123456789Katego");
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_PEMASOK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_PEMASOK);
	}
	
	@Test(dependsOnMethods = { "hapusKategoriPemasok" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
