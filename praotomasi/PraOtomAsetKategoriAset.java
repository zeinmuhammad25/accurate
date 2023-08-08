package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoriaset.KategoriAsetParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriAsetTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
public class PraOtomAsetKategoriAset extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomAsetKategoriAset.class);

	private String TARGET_FILE = "PraOtomasi Aset - Kategori Aset.txt";

	@Test()
	public void buatKategoriAset()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_ASET);
		KategoriAsetParam aset = new KategoriAsetParam();
		
		aset.nama = "Coba";
		KategoriAsetTool.isi(getWebDriver(), aset);
		KategoriAsetTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_ASET);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	    NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET);
	}
	
	@Test(dependsOnMethods = { "buatKategoriAset" })
	public void editKategoriAset() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_ASET);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_ASET, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_ASET, "Coba");
		
		KategoriAsetParam aset = new KategoriAsetParam();
		aset.nama = "Baru";
		KategoriAsetTool.isi(getWebDriver(), aset);
		KategoriAsetTool.saveIsi(getWebDriver(), TARGET_FILE);
	
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_ASET);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET);
	}

	@Test(dependsOnMethods = { "editKategoriAset" })
	public void hapusKategoriAset() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_ASET);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_ASET, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.KATEGORI_ASET);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_ASET, "Baru");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_ASET);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET);
	}
	
	@Test(dependsOnMethods = { "hapusKategoriAset" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
