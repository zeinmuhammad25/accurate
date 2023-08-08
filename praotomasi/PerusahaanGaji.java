package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.gajitunjangan.GajiTunjanganParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GajiTunjanganTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PerusahaanGaji extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PerusahaanGaji .class);

	private String TARGET_FILE = "PraOtomasi Perusahaan - Gaji.txt";
	
	@Test()
	public void buatGaji1()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
		GajiTunjanganParam param = new GajiTunjanganParam();
		param.nama = "Nama Gaji 0123456789 Nama Gaji 0123456789 Nama Gaji 0123456789 Nama Gaji 0123456";
		param.tipegaji = "Tunjangan PPh";
		param.akunbeban = "600004";
		GajiTunjanganTool.isi(getWebDriver(), param);
		GajiTunjanganTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
	}
	
	@Test(dependsOnMethods = { "buatGaji1" })
	public void buatGaji2()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
		GajiTunjanganParam param = new GajiTunjanganParam();
		param.nama = "gaji edit";
		param.tipegaji = "Subsidi PPh";
		param.akunbeban = "600004";
		GajiTunjanganTool.isi(getWebDriver(), param);
		GajiTunjanganTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
	}
	
	@Test(dependsOnMethods = { "buatGaji2" })
	public void hapusGaji()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.GAJI_TUNJANGAN, "Data Baru");
		
		//cek print list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
				
		NavigationTool.cariListData(getWebDriver(), AccurateModule.GAJI_TUNJANGAN, "gaji edit");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.GAJI_TUNJANGAN, "Nama Gaji 0123456789 Nama Gaji 0123456789 Nama Gaji 0123456789 Nama Gaji 0123456");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GAJI_TUNJANGAN);
	}
	
	@Test(dependsOnMethods = { "hapusGaji" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
