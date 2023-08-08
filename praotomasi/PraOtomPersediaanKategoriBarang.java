package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoribarang.KategoriBarangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriBarangTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;

public class PraOtomPersediaanKategoriBarang extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanKategoriBarang.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Kategori Barang.txt";

	@Test()
	public void isiKategoriBarang() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_BARANG);
		KategoriBarangParam param = new KategoriBarangParam();
		
		param.nama = "Coba";
		KategoriBarangTool.isiForm(getWebDriver(), param);
		KategoriBarangTool.SaveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_BARANG);
	}
	
	@Test(dependsOnMethods = { "isiKategoriBarang" })
	public void editKategoriBarang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_BARANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_BARANG, "Coba");
		KategoriBarangParam param = new KategoriBarangParam();
		
		param.nama = "Baru";
		KategoriBarangTool.isiForm(getWebDriver(), param);
		KategoriBarangTool.SaveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_BARANG);
	}
	
	@Test(dependsOnMethods = { "editKategoriBarang" })
	public void hapusKategoriBarang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_BARANG, "Data Baru");
		
		//cek print list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.KATEGORI_BARANG);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);

		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_BARANG, "Baru");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_BARANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_BARANG);
	}
	
	@Test(dependsOnMethods = { "hapusKategoriBarang" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
