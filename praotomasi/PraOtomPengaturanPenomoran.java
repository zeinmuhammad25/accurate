package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penomoran.PenomoranParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;;
import com.cpssoft.web.test.accurate.tool.PenomoranTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPengaturanPenomoran extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomPengaturanPenomoran .class);

	private String TARGET_FILE = "PraOtomasi Pengaturan - Penomoran.txt";
	
	@Test()
	public void buatPenomoran()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENOMORAN);
		PenomoranParam param = new PenomoranParam();
		param.tab = "Penomoran";
		param.nama = "Nama Penomoran 0123456789 Nama Penomoran 0123456789 Nama Penomoran 0123456789 Na";
		param.tipetransaksi = "Faktur Penjualan";
		param.tipepenomoran = "Tidak Reset";
		param.jumlahdigitcounter = "5";
		param.komponenpenomoran = "Counter";
		PenomoranTool.isiForm(getWebDriver(), param);
		AccTool.click(getWebDriver(),"//*[contains(@id,'tab-general')]//*[@name='btnAdd']//i[@class='icon-plus-2']");
		PenomoranTool.saveData(getWebDriver(), TARGET_FILE);
		
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENOMORAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENOMORAN);
	}
	
	@Test(dependsOnMethods = { "buatPenomoran" })
	public void editPenomoran()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENOMORAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENOMORAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENOMORAN, "Nama Penomoran 0123456789 Nama Penomoran 0123456789 Nama Penomoran 0123456789 Na");
		
		
		PenomoranParam param2 = new PenomoranParam();
		
		param2.nama = "Penomoran Coba";
		PenomoranTool.isiForm(getWebDriver(), param2);
		PenomoranTool.saveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENOMORAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENOMORAN);
	}
	
	@Test(dependsOnMethods = { "editPenomoran" })
	public void hapusPenomoran()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENOMORAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENOMORAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENOMORAN, "Penomoran Coba");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENOMORAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		WaitTool.delay(100);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENOMORAN);
	}
	
	@Test(dependsOnMethods = { "hapusPenomoran" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
