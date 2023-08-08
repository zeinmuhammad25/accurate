package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.satuanbarang.SatuanBarangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.SatuanBarangTool;

public class PraOtomPersediaanSatuanBarang extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanSatuanBarang.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Satuan Barang.txt";

	@Test()
	public void isiSatuanBarang() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.SATUAN_BARANG);
		SatuanBarangParam param = new SatuanBarangParam();
		
		param.nama = "Coba";
		SatuanBarangTool.isiForm(getWebDriver(), param);
		SatuanBarangTool.SaveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.SATUAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.SATUAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "isiSatuanBarang" })
	public void editSatuanBarang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.SATUAN_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.SATUAN_BARANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.SATUAN_BARANG, "Coba");
		SatuanBarangParam param = new SatuanBarangParam();
		
		param.nama = "Baru";
		SatuanBarangTool.isiForm(getWebDriver(), param);
		SatuanBarangTool.SaveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.SATUAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.SATUAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "editSatuanBarang" })
	public void hapusSatuanBarang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.SATUAN_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.SATUAN_BARANG, "Data Baru");
				
		//cek print list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.SATUAN_BARANG);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);

		NavigationTool.cariListData(getWebDriver(), AccurateModule.SATUAN_BARANG, "Baru");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.SATUAN_BARANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.SATUAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "hapusSatuanBarang" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
