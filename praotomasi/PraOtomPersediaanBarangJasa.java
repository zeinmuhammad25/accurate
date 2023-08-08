package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.BarangJasaTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPersediaanBarangJasa extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanBarangJasa.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Barang Jasa.txt";

	@Test()
	public void isiBarangJasa() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		BarangJasaParam param = new BarangJasaParam();
		
		param.namabarang = "Coba";
		WaitTool.delay(1000);
		param.jenisitem ="Persediaan";
		WaitTool.delay(1000);
		BarangJasaTool.isiUmum(getWebDriver(), param);
		WaitTool.delay(1000);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = { "isiBarangJasa" })
	public void editBarangJasa()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.BARANG_JASA, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.BARANG_JASA, "Coba");
		BarangJasaParam param2 = new BarangJasaParam();
		
		param2.namabarang = "Baru";
		BarangJasaTool.isiUmum(getWebDriver(), param2);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = { "editBarangJasa" })
	public void hapusBarangJasa()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.BARANG_JASA, "Data Baru");
		
		//cek print list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);		
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.BARANG_JASA, "Baru");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = { "hapusBarangJasa" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
