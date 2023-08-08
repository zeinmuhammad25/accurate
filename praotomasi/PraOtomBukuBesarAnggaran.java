package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.anggaran.AnggaranParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AnggaranTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;
public class PraOtomBukuBesarAnggaran extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomBukuBesarAnggaran.class);

	private String TARGET_FILE = "PraOtomasi Buku Besar - Anggaran.txt";

	@Test
	public void buatAnggaran()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ANGGARAN);
		AnggaranParam header = new AnggaranParam();
		
		header.tahun = "2016";
		header.bulan = "Januari";
		header.tipe = "Umum";
		AnggaranTool.isiAkun(getWebDriver(), header);
		AnggaranTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		AnggaranParam keterangan = new AnggaranParam();
		keterangan.tab = "Info Lainnya";
		keterangan.penganalisa = "Dimas";
		keterangan.catatan = "Catatan Catatan Catatan Catatan Catatan Catatan Catatan CatatanCatatanCatatan Catatan Catatan"
				+ "CatatanCatatanCatatan Catatan Catatan Catatan Catatan CatatanCatatanCatatan Catatan Catatan Catatan ";
		AnggaranTool.isiCatatan(getWebDriver(), keterangan);
		AnggaranTool.saveIsiLain(getWebDriver(), TARGET_FILE);
		
		AnggaranParam detail = new AnggaranParam();
		detail.search = "Diskon Penjualan IDR";
		AnggaranTool.isiDetail(getWebDriver(), detail);
		detail.anggarantarget = "10000";
		AnggaranTool.detail(getWebDriver(), detail);
		AnggaranTool.saveDetail(getWebDriver(), TARGET_FILE);
		AnggaranTool.klikButtonLanjutDetailAnggaran(getWebDriver());
				
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.ANGGARAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
	    NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ANGGARAN);
	}
	
	@Test(dependsOnMethods = "buatAnggaran")
	public void editAnggaran()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ANGGARAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ANGGARAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ANGGARAN, "Dimas");
		
		AnggaranParam lain = new AnggaranParam();
		lain.tab = "Lain - lain";
		lain.penganalisa = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns "
				+ "15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		lain.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a merm"
				+ "aid turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters "
				+ "become old enough, each of them visits the upper world every year. As each of them returns, the Little"
				+ " Mermaid listens longingly to their various descriptions"
				+ " of the surface and of human beings.";
		AnggaranTool.isiCatatan(getWebDriver(), lain);
		AnggaranTool.saveIsiLain(getWebDriver(), TARGET_FILE);
	
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.ANGGARAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ANGGARAN);
	}

	@Test(dependsOnMethods = "editAnggaran")
	public void hapusAnggaran() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ANGGARAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ANGGARAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ANGGARAN, "The Little Mermaid dwells in an underwater kingdom with her father (the sea king");
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.ANGGARAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ANGGARAN);
	}
	
	@Test(dependsOnMethods = "hapusAnggaran")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
