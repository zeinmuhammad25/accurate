package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;

import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.akunperkiraan.AkunPerkiraanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AkunPerkiraanTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomBukuBesarAkunPerkiraan extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomBukuBesarAkunPerkiraan.class);

	private String TARGET_FILE = "PraOtomasi Buku Besar - Akun Perkiraan.txt";

	@Test()
	public void buatAkunPerkiraan()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		AkunPerkiraanParam param = new AkunPerkiraanParam();
		
		param.tipe = "Kas & Bank";
		param.no = "Akun 1";
		param.nama = "Rapunzel would wrap her long, fair hair around a hook beside the window, dropping it down to Dame Gothel, who would then climb up the hair to Rapunzel's tower room.";
		AkunPerkiraanTool.isiForm(getWebDriver(), param);
		AkunPerkiraanTool.saveIsiUmumPakaiKurs(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		NavigationTool.klikBatalAntrian(getWebDriver());
		WaitTool.delay(1000);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	
		
		param.tipe = "Kas & Bank";
		param.no = "Akun 2";
		param.nama = "Z";
		AkunPerkiraanTool.isiForm(getWebDriver(), param);
		AkunPerkiraanTool.saveIsiUmumPakaiKurs(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		NavigationTool.klikBatalAntrian(getWebDriver());
		WaitTool.delay(1000);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);	
		
		param.tipe = "Kas & Bank";
		param.no = "11111";
		param.nama = "Rapunzel would wrap her long, fair hair around a hook beside the window, dropping it down to Dame Gothel, who would then climb up the hair to Rapunzel's tower room.";
		AkunPerkiraanTool.isiForm(getWebDriver(), param);
		AkunPerkiraanTool.saveIsiUmumPakaiKurs(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		param.tipe = "Kas & Bank";
		param.no = "22222";
		param.nama = "Z";
		AkunPerkiraanTool.isiForm(getWebDriver(), param);
		AkunPerkiraanTool.saveIsiUmumPakaiKurs(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);	
		
	    NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
	}
	
	@Test(dependsOnMethods = { "buatAkunPerkiraan" })
	public void editKategoriAkunPerkiraan2()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN, "Data Baru");
		NavigationTool.cariList(getWebDriver(), AccurateModule.AKUN_PERKIRAAN, "Z");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN, "Z");
		
		AkunPerkiraanParam param = new AkunPerkiraanParam();
		
//		param.tipe = "Kas & Bank";
		param.cbsubakun = true;
		param.namasubakun = "Kas Kecil";
//		param.kodeotomatis = false;
		param.no = "33333";
		param.nama = "The Little Mermaid, The Little Match Girl, The Steadfast Tin Soldier, The Snow Queen, Thumbelina, The Ugly Duckling, The Red Shoes, and The Emperor's New Clothes";
		param.ob = "9999999999999";
		param.tanggalob = "27012015";	
		AkunPerkiraanTool.isiForm(getWebDriver(), param);
		AkunPerkiraanTool.saveIsiUmumPakaiKurs(getWebDriver(), TARGET_FILE);
		
		param.tab = "Lain - lain";
		AkunPerkiraanParam lain = new AkunPerkiraanParam();
		lain.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a merm"
				+ "aid turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters "
				+ "become old enough, each of them visits the upper world every year. As each of them returns, the Little"
				+ " Mermaid listens longingly to their various descriptions"
				+ " of the surface and of human beings.";
		AkunPerkiraanTool.isiLainLain(getWebDriver(), lain);
		AkunPerkiraanTool.saveIsiLain(getWebDriver(), TARGET_FILE);
	
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
	}
	
	@Test(dependsOnMethods = { "editKategoriAkunPerkiraan2" })
	public void hapusAkunPerkiraan() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		NavigationTool.klikPilihKelompokData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN, "Kelompok Data 1 (1 s/d 100)");
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariList(getWebDriver(), AccurateModule.AKUN_PERKIRAAN, "33333");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN, "33333");
		WaitTool.delay(100);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariList(getWebDriver(), AccurateModule.AKUN_PERKIRAAN, "11111");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN, "11111");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.AKUN_PERKIRAAN);
	}
	
	
	@Test(dependsOnMethods = { "hapusAkunPerkiraan" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
