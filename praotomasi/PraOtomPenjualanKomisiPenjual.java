package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.komisipenjual.KomisiPenjualParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KomisiPenjualTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPenjualanKomisiPenjual extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPenjualanKomisiPenjual.class);
	
	private String TARGET_FILE = "PraOtomasi Penjualan - Komisi Penjual.txt";
	
	@Test()
	public void buatKomisi()
	{	
		KomisiPenjualTool.overrideLocalWebDriver(getWebDriver());
		//hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
		
		KomisiPenjualParam param = new KomisiPenjualParam();
		param.nama = "123";
		param.cbpertama = true;
		param.nilaipersen = "3";
		KomisiPenjualTool.isiForm(getWebDriver(), param);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
	}
	
	@Test(dependsOnMethods = { "buatKomisi" })
	public void editKomisi()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KOMISI_PENJUAL, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KOMISI_PENJUAL, "123");
		
		KomisiPenjualTool.saveData(getWebDriver(), TARGET_FILE);
		
		KomisiPenjualParam param = new KomisiPenjualParam();
		
		param.nama = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-ki"
				+ "ng), her grandmother, and her five sisters. Her five sisters are each born one year apart. When"
				+ " a mermaid turns 15, she is permitted to swim to the surface to watch the world above, and when"
				+ " the sisters become old enough, each of them visits the upper world every year. As each of the"
				+ "m returns, the Little Mermaid listens longingly to their various descriptions of the surface a"
				+ "nd of human beings.";
		param.berlakuuntukbarang = "Pilih Kategori Barang";
		param.namakategori = "Umum";
		param.nilaipenjualan = true;
		param.nilaiantara = "999999999999";
		param.nilaisampaidengan = "999999999999";
		param.kuantitaspenjualan = true;
		param.kuantitasantara = "999999999999";
		param.kuantitassampaidengan = "999999999999";
		param.kuantitasterjual = true;
		param.perunit = "999999999999";
		param.akanmendapatkomisi = "Persentase";
		param.nilaipersen = "3";
		param.daripersen = "Nilai Penjualan";
//		param.nilaitetap = "999999999999";
		param.cbpertama = true;
		param.cbkedua = true;
		param.cbketiga = true;
		param.cbkeempat = true;
		param.cbkelima = true;
		
		KomisiPenjualTool.isiForm(getWebDriver(), param);
		
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father "
				+ "(the sea king or mer-king), her grandmother, and her five sisters. Her five "
				+ "sisters are each born one year apart. When a mermaid turns 15, she is permit"
				+ "ted to swim to the surface to watch the world above, and when the sisters bec"
				+ "ome old enough, each of them visits the upper world every year. As each of them"
				+ " returns, the Little Mermaid listens longingly to their various descriptions of"
				+ " the surface and of human beings.";
		KomisiPenjualTool.isiLainLain(getWebDriver(), param);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
	}
	
	@Test(dependsOnMethods = { "editKomisi" })
	public void hapusKomisi()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KOMISI_PENJUAL, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KOMISI_PENJUAL, "The Little Mermaid dwells in an underwa"
				+ "ter kingdom with her father (the sea king");

		KomisiPenjualTool.saveData(getWebDriver(), TARGET_FILE);
		KomisiPenjualTool.saveLainLain(getWebDriver(), TARGET_FILE);		
		
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KOMISI_PENJUAL);
	}
	
	@Test(dependsOnMethods = { "hapusKomisi" })
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
