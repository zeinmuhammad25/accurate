package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;;
import com.cpssoft.web.test.accurate.tool.PreferensiTool;

public class PraOtomPreferensiFitur extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomPreferensiFitur .class);

	private String TARGET_FILE = "PraOtomasi Preferensi - Fitur.txt";
	
	@Test()
	public void fiturNonAktif()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.cbcabang = false;
		param.cbmatauang = false;
		param.cbpajak = false;
		param.cbapproval = false;
		param.cbcatatasset = false;
		param.cbanggaran = false;
		param.cbdepartemen = false;
		param.cbtawarjual = false;
		param.cbreturjual = false;
		param.cbsesuaiharga = false;
		param.fakturdimuka = false;
		param.cbsalesman = false;
		param.cbkonsinyasi = false;
		param.cbjasakirim = false;
		param.cbsyaratbayar = false;
		param.cbpesanbeli = false;
		param.cbdaftarhargapemasok = false;
		param.cbtagihandimuka = false;
		param.cbbiayabeli = false;
		param.cbmintabarang = false;
		param.cbmultigudang = false;
		param.cbmultibarang = false;
		param.cbnomorserial = false;
		param.cbprodsederhana = false;
		PreferensiTool.isiFitur(getWebDriver(), param);
		PreferensiTool.saveIsiFitur(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
//		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikErrorOK(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PREFERENSI);
	}
	
	@Test(dependsOnMethods = { "fiturNonAktif" })
	public void fiturAktif()
	{		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param2 = new PreferensiParam();
		
		param2.cbcabang = true;
		param2.cbmatauang = true;
		param2.cbpajak = true;
		param2.cbapproval = true;
		param2.cbcatatasset = true;
		param2.cbanggaran = true;
		param2.cbdepartemen = true;
		param2.cbtawarjual = true;
		param2.cbreturjual = true;
		param2.cbsesuaiharga = true;
		param2.fakturdimuka = true;
		param2.cbsalesman = true;
		param2.cbkonsinyasi = true;
		param2.cbjasakirim = true;
		param2.cbsyaratbayar = true;
		param2.cbpesanbeli = true;
		param2.cbdaftarhargapemasok = true;
		param2.cbtagihandimuka = true;
		param2.cbbiayabeli = true;
		param2.cbmintabarang = true;
		param2.cbmultigudang = true;
		param2.cbmultibarang = true;
		param2.cbnomorserial = true;
		param2.cbprodsederhana = true;
		PreferensiTool.isiFitur(getWebDriver(), param2);
		PreferensiTool.saveIsiFitur(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = { "fiturAktif" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
