package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.syaratpembayaran.SyaratPembayaranParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.SyaratPembayaranTool;

public class PerusahaanSyaratPembayaran extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PerusahaanSyaratPembayaran .class);

	private String TARGET_FILE = "Perusahaan - SyaratPembayaran.txt";
	
	@Test()
	public void buatSyaratPembayaran()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
		SyaratPembayaranParam param = new SyaratPembayaranParam();
		
		param.jikamembayarantara = "999";
		param.akanmendapatdiskon = "100";
		param.masajatuhtempo = "999";
		param.keterangan = "Keterangan Syarat Pembayaran 0123456789 Keterangan Syarat Pembayaran 0123456789 Keterangan Syarat Pembayaran 0123456789 Keterangan Syarat Pembayaran 0123456789 Keterangan Syarat Pembayaran 0123456789 Keterangan Syarat Pembayaran 0123456789 ";
		SyaratPembayaranTool.isi(getWebDriver(), param);
		SyaratPembayaranTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
	}
	
	@Test(dependsOnMethods = { "buatSyaratPembayaran" })
	public void editSyaratPembayaran()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN, "100");
		
		SyaratPembayaranParam param2 = new SyaratPembayaranParam();
		
		param2.jikamembayarantara = "999";
		param2.akanmendapatdiskon = "99";
		param2.masajatuhtempo = "999";
		SyaratPembayaranTool.isi(getWebDriver(), param2);
		SyaratPembayaranTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
	}
	
	@Test(dependsOnMethods = { "editSyaratPembayaran" })
	public void hapusSyaratPembayaran()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN, "Data Baru");
				
		//cek print list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);

		NavigationTool.cariListData(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN, "99");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.SYARAT_PEMBAYARAN);
	}
	
	@Test(dependsOnMethods = { "hapusSyaratPembayaran" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
