package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.komisipenjual.KomisiPenjualParam;
import com.cpssoft.web.test.accurate.targetpenjualan.TargetPenjualanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KomisiPenjualTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.TargetPenjualanTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPenjualanTargetPenjualan extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPenjualanTargetPenjualan.class);
	
	private String TARGET_FILE = "PraOtomasi Penjualan - Target Penjualan.txt";
	
	@Test
	public void buatTargetPerBarang()
	{
		//hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
		
		TargetPenjualanParam param = new TargetPenjualanParam();
		
		param.nama = "Target Per Barang";
		param.tipetarget = "Per Barang";
		param.penjualancabang = "[Semua Cabang]";
		param.daritanggal = "01012015";
		param.sampaitanggal = "30012015";
		TargetPenjualanTool.isiForm(getWebDriver(), param);
		
		param.search = "Accurate 4 DE";
		TargetPenjualanTool.isiRincianBarang(getWebDriver(), param);
		param.tab = "Target Per Barang";
		param.kuantitas = "99999999999";
		param.nilai = "1000001010100";
		TargetPenjualanTool.detailRincianBarang(getWebDriver(), param);
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item')]//*[@name='btnNext']");
		
		param.catatan = "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 ";
		param.penganalisa = "Penganalisa123456789";
		TargetPenjualanTool.isiCatatan(getWebDriver(), param);
		
		TargetPenjualanTool.saveData(getWebDriver(), param);	
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
	}
	
	@Test(dependsOnMethods = "buatTargetPerBarang")
	public void buatTargetPerKategoriBarang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
		
		TargetPenjualanParam param = new TargetPenjualanParam();
		
		param.nama = "Target Per Kategori Barang";
		param.tipetarget = "Per Kategori Barang";
		param.penjualancabang = "[Semua Cabang]";
		param.daritanggal = "01012015";
		param.sampaitanggal = "30012015";
		TargetPenjualanTool.isiForm(getWebDriver(), param);
		
		param.search = "Umum";
		TargetPenjualanTool.isiRincianKategoriBarang(getWebDriver(), param);
		param.nilai = "1000001010100";
		TargetPenjualanTool.detailRincianKategoriBarang(getWebDriver(), param);
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-category')]//*[@name='btnNext']");
		
		param.catatan = "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 ";
		param.penganalisa = "Penganalisa123456789";
		TargetPenjualanTool.isiCatatan(getWebDriver(), param);
		
		TargetPenjualanTool.saveData(getWebDriver(), param);	
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
	}
	
	@Test(dependsOnMethods = "buatTargetPerKategoriBarang")
	public void buatTargetPerPenjual()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
		
		TargetPenjualanParam param = new TargetPenjualanParam();
		
		param.nama = "Target Per Penjual";
		param.tipetarget = "Per Penjual";
		param.penjualancabang = "Semua Cabang";
		param.daritanggal = "01012015";
		param.sampaitanggal = "30012015";
		TargetPenjualanTool.isiForm(getWebDriver(), param);
		
		param.search = "Brad Pitt";
		TargetPenjualanTool.isiRincianPenjual(getWebDriver(), param);
		param.nilai = "1000001010100";
		TargetPenjualanTool.detailRincianPenjual(getWebDriver(), param);
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-salesman')]//*[@name='btnNext']");
		
		param.catatan = "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 ";
		param.penganalisa = "Penganalisa123456789";
		TargetPenjualanTool.isiCatatan(getWebDriver(), param);
		
		TargetPenjualanTool.saveData(getWebDriver(), param);	
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
	}
	
	@Test(dependsOnMethods = "buatTargetPerPenjual")
	public void buatTargetPerBulan()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
		
		TargetPenjualanParam param = new TargetPenjualanParam();
		
		param.nama = "Target Per Bulan";
		param.tipetarget = "Per Bulan";
		param.penjualancabang = "Semua Cabang";
		param.tahun = "2017";
		TargetPenjualanTool.isiForm(getWebDriver(), param);
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.TARGET_PENJUALAN, "Januari");
		param.nilai = "1000001010100";
		TargetPenjualanTool.detailRincianBulan(getWebDriver(), param);
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-general')]//*[@name='btnNext']");
		
		param.catatan = "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 "
				+ "Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 Target penjualan per brang 13216549516 ";
		param.penganalisa = "Penganalisa123456789";
		TargetPenjualanTool.isiCatatan(getWebDriver(), param);
		
		TargetPenjualanTool.saveData(getWebDriver(), param);	
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.TARGET_PENJUALAN);
	}
	

	
//	@Test(dependsOnMethods = "buatTargetPerBulan")
	public void hapustarget()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KOMISI_PENJUAL, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KOMISI_PENJUAL, "The Little Mermaid dwells in an underwa"
				+ "ter kingdom with her father (the sea king");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
	}
	
	@Test(dependsOnMethods = "hapustarget")
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
