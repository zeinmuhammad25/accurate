package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pajak.PajakParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PajakTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PerusahaanPajak extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PerusahaanPajak .class);

	private String TARGET_FILE = "PraOtomasi Perusahaan - Pajak.txt";
	
	@Test()
	public void buatPajak()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PAJAK);
		PajakParam param = new PajakParam();
		param.tipe = "Pajak Pertambahan Nilai";
		param.keterangan = "Keterangan Pajak 0123456789Pajak 01234567Keterangan Pajak 0123456789Pajak 012345";
		param.persentase = "999999999999";
		param.akunpajakpenjualan = "210201";
		param.akunpajakpembelian = "110504";
		PajakTool.isi(getWebDriver(), param);
		PajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PAJAK);
	}
	
	@Test(dependsOnMethods = { "buatPajak" })
	public void editPajak()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PAJAK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PAJAK, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PAJAK, "Keterangan Pajak 0123456789Pajak 01234567Keterangan Pajak 0123456789Pajak 012345");
		PajakParam param2 = new PajakParam();
		
		param2.keterangan = "Keterangan Pajak XXX";
		param2.persentase = "0.9999";
		PajakTool.isi(getWebDriver(), param2);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PAJAK);
	}
	
	@Test(dependsOnMethods = { "editPajak" })
	public void hapusPajak()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PAJAK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PAJAK, "Data Baru");
		
		//cek print list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PAJAK);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
				
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PAJAK, "Keterangan Pajak XXX");
		PajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PAJAK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PAJAK);
	}
	
	@Test(dependsOnMethods = { "hapusPajak" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
