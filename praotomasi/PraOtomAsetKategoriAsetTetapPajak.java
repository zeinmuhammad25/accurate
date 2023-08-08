package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoriasettetappajak.KategoriAsetTetapPajakParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriAsetTetapPajakTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
public class PraOtomAsetKategoriAsetTetapPajak extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomAsetKategoriAset.class);

	private String TARGET_FILE = "PraOtomasi Aset - Kategori Aset Tetap Pajak.txt";

	@Test()
	public void buatKategoriAsetTetapPajak()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		KategoriAsetTetapPajakParam aset = new KategoriAsetTetapPajakParam();
		
		aset.nama = "coba";
		aset.perkiraanumur = "1";
		KategoriAsetTetapPajakTool.isi(getWebDriver(), aset);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	    NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
	}
	
	@Test(dependsOnMethods = { "buatKategoriAsetTetapPajak" })
	public void editKategoriAsetTetapPajak() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "coba");
		
		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		KategoriAsetTetapPajakParam aset2 = new KategoriAsetTetapPajakParam();
		
		aset2.nama = "abcde12345abcde12345abcde12345abcde12345";
		aset2.metodepenyusutan = "Metode Saldo Menurun";
		aset2.perkiraanumur = "5";
		KategoriAsetTetapPajakTool.isi(getWebDriver(), aset2);
	
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
	}

	@Test(dependsOnMethods = { "editKategoriAsetTetapPajak" })
	public void hapusKategoriAsetTetapPajak() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "abcde12345abcde12345abcde12345abcde12345");
		
		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
	}
	
	@Test(dependsOnMethods = { "hapusKategoriAsetTetapPajak" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
