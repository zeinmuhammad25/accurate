package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fob.FOBParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.FOBTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PerusahaanFOB extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PerusahaanFOB .class);

	private String TARGET_FILE = "PraOtomasi Perusahaan - FOB.txt";
	
	@Test()
	public void buatFOB()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FOB);
		FOBParam param = new FOBParam();
		param.nama = "fob 0123456789fob 0123456789fob 0123456789fob 0123456789fob 0123456789fob 012345";
		FOBTool.isi(getWebDriver(), param);
		FOBTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.FOB);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FOB);
	}
	
	@Test(dependsOnMethods = { "buatFOB" })
	public void editFOB()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FOB);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FOB, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FOB, "fob 0123456789fob 0123456789fob 0123456789fob 0123456789fob 0123456789fob 012345");

		FOBParam param = new FOBParam();
		param.nama = "fob edit";
		FOBTool.isi(getWebDriver(), param);
		FOBTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.FOB);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FOB);
	}
	
	@Test(dependsOnMethods = { "editFOB" })
	public void hapusFOB()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.FOB);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.FOB, "Data Baru");
		//cek print list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.FOB);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.FOB, "fob edit");
		FOBTool.saveIsi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.FOB);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.FOB);
	}
	
	@Test(dependsOnMethods = { "hapusFOB" })
	public void executeCompare() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
