package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.jurnalumum.JurnalUmumParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.JurnalUmumTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
public class PraOtomBukuBesarJurnalUmum extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomBukuBesarJurnalUmum.class);

	private String TARGET_FILE = "PraOtomasi Buku Besar - Jurnal Umum.txt";

	@Test()
	public void buatJurnalUmum()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.JURNAL_UMUM);
		
		JurnalUmumParam param = new JurnalUmumParam();
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.JURNAL_UMUM);
		param.tanggal = "30012015";
		param.no = "JV.01";
		JurnalUmumTool.isi(getWebDriver(), param);
		JurnalUmumTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.search = "Persediaan";
		JurnalUmumTool.isiDetail(getWebDriver(), param);
//		param.debit = true;
		param.nilai = "1000";
		param.departemen = "test doang";
		param.proyek = "a1";
		JurnalUmumTool.detailJurnal(getWebDriver(), param);
//		JurnalUmumTool.saveDetail(getWebDriver(), TARGET_FILE);
		JurnalUmumTool.klikLanjutTabDetailAkun(getWebDriver(), AccurateModule.JURNAL_UMUM);
				
		param.search = "Piutang Usaha IDR";
		JurnalUmumTool.isiDetail(getWebDriver(), param);
//		param.kredit = true;
		param.nilai = "1000";
		param.pelanggan = true;
		param.namapelanggan = "ABC";
		param.departemen = "test doang";
		param.proyek = "a1";
		JurnalUmumTool.detailJurnal(getWebDriver(), param);
//		JurnalUmumTool.saveDetail(getWebDriver(), TARGET_FILE);		
		JurnalUmumTool.klikLanjutTabDetailAkun(getWebDriver(), AccurateModule.JURNAL_UMUM);
		
		JurnalUmumTool.saveList(getWebDriver(), TARGET_FILE);
		
		param.tab = "Info lain";
		param.keterangan = "One Little Panda";
		JurnalUmumTool.isiInfoLain(getWebDriver(), param);	
		JurnalUmumTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.JURNAL_UMUM);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
	    NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.JURNAL_UMUM);
	}
	
	@Test(dependsOnMethods = { "buatJurnalUmum" })
	public void editJurnalUmum()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.JURNAL_UMUM);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.JURNAL_UMUM, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.JURNAL_UMUM, "JV.01");
		
		JurnalUmumParam param = new JurnalUmumParam();
		
		param.no = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters";
		JurnalUmumTool.isi(getWebDriver(), param);
		JurnalUmumTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.JURNAL_UMUM, "Persediaan");
		param.tab = "Detail Akun";
//		param.debit = true;
		param.nilai = "9999999999999999999999";
		JurnalUmumTool.detailJurnal(getWebDriver(), param);
		
		param.tab = "Catatan Detail";
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid "
				+ "turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become "
				+ "old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid "
				+ "listens longingly to their various descriptions of the surface and of human beings.";
		JurnalUmumTool.detailCatatan(getWebDriver(), param);
		JurnalUmumTool.saveCatatanDetail(getWebDriver(), TARGET_FILE);		
		JurnalUmumTool.klikLanjutTabDetailAkun(getWebDriver(), AccurateModule.JURNAL_UMUM);
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.JURNAL_UMUM, "Piutang Usaha IDR");
		param.tab = "Catatan Detail";
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid "
				+ "turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become "
				+ "old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid "
				+ "listens longingly to their various descriptions of the surface and of human beings.";
//		param.departemen = "test doang";
//		param.proyek = "a1";
		JurnalUmumTool.detailCatatan(getWebDriver(), param);
		JurnalUmumTool.saveCatatanDetail(getWebDriver(), TARGET_FILE);
		JurnalUmumTool.klikLanjutTabDetailAkun(getWebDriver(), AccurateModule.JURNAL_UMUM);
		
		JurnalUmumTool.saveList(getWebDriver(), TARGET_FILE);
		
		param.tab = "Info lain";
		param.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns"
				+ " 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		JurnalUmumTool.isiInfoLain(getWebDriver(), param);	
		JurnalUmumTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
	
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.JURNAL_UMUM);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikBatalAntrian(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.JURNAL_UMUM);
	}

	@Test(dependsOnMethods = { "editJurnalUmum" })
	public void hapusJurnalUmum() throws AWTException 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.JURNAL_UMUM);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.JURNAL_UMUM, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.JURNAL_UMUM, "JV.01");
		
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.JURNAL_UMUM);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
//		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.JURNAL_UMUM);
//		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.JURNAL_UMUM);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.JURNAL_UMUM);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.JURNAL_UMUM);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.JURNAL_UMUM);
	}
	
	@Test(dependsOnMethods = { "hapusJurnalUmum" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
