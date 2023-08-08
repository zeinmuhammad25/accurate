package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.gudang.GudangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.GudangTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;

public class PraOtomPersediaanGudang extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanGudang.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Gudang.txt";

	@Test()
	public void isiGudang() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GUDANG);
		GudangParam param = new GudangParam();
		
		param.nama = "Coba";
		GudangTool.isiForm(getWebDriver(), param);
		GudangTool.SaveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.GUDANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GUDANG);
	}
	
	@Test(dependsOnMethods = { "isiGudang" })
	public void editGudang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.GUDANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.GUDANG, "Coba");
		GudangParam param = new GudangParam();
		
		param.nama = "Baru";
		GudangTool.isiForm(getWebDriver(), param);
		GudangTool.SaveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.GUDANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GUDANG);
	}
	
	@Test(dependsOnMethods = { "editGudang" })
	public void hapusGudang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.GUDANG, "Data Baru");
		
		//cek print list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);

		NavigationTool.cariListData(getWebDriver(), AccurateModule.GUDANG, "Baru");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GUDANG);
	}
	
	@Test(dependsOnMethods = { "hapusGudang" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
