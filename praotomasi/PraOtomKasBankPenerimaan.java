package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penerimaan.PenerimaanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PenerimaanTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomKasBankPenerimaan extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomKasBankPenerimaan.class);
	
	private String TARGET_FILE = "PraOtomasi Kas Bank - Penerimaan.txt";
	
	@Test()
	public void buatPenerimaan()
	{
		//hapus target lama
		Log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN);
		
		PenerimaanParam param = new PenerimaanParam();
		
		param.tab="Header";
		param.kasbank="Kas Kecil";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENERIMAAN);
		param.no="OD.01";
		param.tanggal="30012015";
		PenerimaanTool.isiForm(getWebDriver(), param);
		PenerimaanTool.SaveHeader(getWebDriver(), TARGET_FILE);
		
		param.search="Persediaan";
		PenerimaanTool.IsiDetail(getWebDriver(), param);
		
		param.tab="rincian Penerimaan";
		param.nilai="1000";
		WaitTool.delay(1000);
//		param.departemen="Dept 1";
		PenerimaanTool.detailPenerimaan(getWebDriver(), param);
		
		param.tab="catatan";
		param.departemen="Dept 1";
		param.catatan="when if you say goodbye today";
		PenerimaanTool.detailPenerimaan(getWebDriver(), param);
		PenerimaanTool.saveDetail(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//*[contains(@id,'detail-other-deposit')]");
		PenerimaanTool.saveListRincianPenerimaan(getWebDriver(), TARGET_FILE);
		
		AccTool.click(getWebDriver(), "//a[contains(@href,'#tab-otherheader')]");
		param.catatan="One Little Panda";
		PenerimaanTool.IsiInfoLain(getWebDriver(), param);
		PenerimaanTool.saveInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENERIMAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN);
	}
	
	@Test(dependsOnMethods = { "buatPenerimaan" })
	public void editPenerimaan()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENERIMAAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENERIMAAN, "OD.01");
		PenerimaanParam param = new PenerimaanParam();
		
		param.tab="Header";
		param.kasbank="Kas kecil";
		param.no="The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters";
//		param.nocek = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
//				+ "her grandmother, and her five sisters";
//		param.tanggalcek = "30012015";
		param.tanggal="30012015";
		PenerimaanTool.isiForm(getWebDriver(), param);
		PenerimaanTool.SaveHeader(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PENERIMAAN, "Persediaan");
		
		param.tab="rincian penerimaan";
		param.nilai="9999999999999999999999";
		WaitTool.delay(1000);
		PenerimaanTool.detailPenerimaan(getWebDriver(), param);
		
		param.tab="catatan";
		param.catatan="The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid"
				+ " turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become "
				+ "old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid"
				+ " listens longingly to their various descriptions of the surface and of human beings.";
		PenerimaanTool.saveDetail(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//*[contains(@id,'detail-other-deposit')]");
		PenerimaanTool.saveListRincianPenerimaan(getWebDriver(), TARGET_FILE);
		
		AccTool.click(getWebDriver(), "//a[contains(@href,'#tab-otherheader')]");
		
		PenerimaanParam param2 = new PenerimaanParam();
		param2.catatan="The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid "
				+ "turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become"
				+ " old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid"
				+ " listens longingly to their various descriptions of the surface and of human beings.";
		param2.pemberi="The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid"
				+ " turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters"
				+ " become old enough, each of them visits the upper world every year. As each of them returns, the "
				+ "Little Mermaid listens longingly to their various descriptions of the surface and of human beings.";
		param2.nocek = "The Little Mermaid dwells in an underwater kingdom";
		param2.tanggalcek = "30012015";
		param2.cbvoid = true;
		param2.cabang = "Cabang1";
		PenerimaanTool.IsiInfoLain(getWebDriver(), param2);
		PenerimaanTool.saveInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENERIMAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN);
	}
	
	@Test(dependsOnMethods = { "editPenerimaan" })
	public void hapusPenerimaan() throws AWTException
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENERIMAAN, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PENERIMAAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENERIMAAN, "The Little Mermaid dwells in an underwater kingdom");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PENERIMAAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		//NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PENERIMAAN);
		//NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PENERIMAAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PENERIMAAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENERIMAAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN);
	}
	
	@Test(dependsOnMethods = { "hapusPenerimaan" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
