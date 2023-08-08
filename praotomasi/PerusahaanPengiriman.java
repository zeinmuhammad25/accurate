package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pengiriman.PengirimanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PengirimanTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PerusahaanPengiriman extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PerusahaanPengiriman .class);

	private String TARGET_FILE = "PraOtomasi Perusahaan - Pengiriman.txt";
	
	@Test()
	public void buatPengiriman()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN);
		PengirimanParam param = new PengirimanParam();
		
		param.nama = "Pengiriman Pengiriman 0123456789Pengiriman 0123456789Pengiriman 0123450123456789";
		PengirimanTool.isi(getWebDriver(), param);
		PengirimanTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENGIRIMAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN);
	}
	
	@Test(dependsOnMethods = { "buatPengiriman" })
	public void editPengiriman()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENGIRIMAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENGIRIMAN, "Pengiriman Pengiriman 0123456789Pengiriman 0123456789Pengiriman 0123450123456789");
		PengirimanParam param = new PengirimanParam();
		
		param.nama = "Pengiriman Baru";
		PengirimanTool.isi(getWebDriver(), param);
		PengirimanTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENGIRIMAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN);
	}
	
	@Test(dependsOnMethods = { "editPengiriman" })
	public void hapusPengiriman()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENGIRIMAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENGIRIMAN, "Data Baru");
		
		//cek print list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PENGIRIMAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
	
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENGIRIMAN, "Pengiriman Baru");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENGIRIMAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		WaitTool.delay(100);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENGIRIMAN);
	}
	
	@Test(dependsOnMethods = { "hapusPengiriman" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
