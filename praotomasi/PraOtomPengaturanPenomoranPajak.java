package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penomoranpajak.PenomoranPajakParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PenomoranPajakTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPengaturanPenomoranPajak extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomPengaturanPenomoranPajak.class);

	private String TARGET_FILE = "PraOtomasi Pengaturan - Penomoran Pajak.txt";

	@Test()
	public void buatPenomoranPajak() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENOMORAN_PAJAK);
		PenomoranPajakParam param = new PenomoranPajakParam();

		param.darinomor = "1111111111111";
		param.sampainomor = "1111199999999";
		PenomoranPajakTool.isiForm(getWebDriver(), param);
		PenomoranPajakTool.saveData(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENOMORAN_PAJAK);
	}

	@Test(dependsOnMethods = { "buatPenomoranPajak" })
	public void editPenomoranPajak() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENOMORAN_PAJAK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK, "Data Baru");

		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK, "111-11.11111111");

		AccTool.click(getWebDriver(),
				"//*[contains(@id,'tab-general')]//div[input[@name='fromNumber']]//*[@class='btn-clear']");
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'tab-general')]//div[input[@name='toNumber']]//*[@class='btn-clear']");
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK);
		WaitTool.delay(100);
		GeneralTool.simpanPesanError(getWebDriver(), TARGET_FILE);
		NavigationTool.klikErrorOK(getWebDriver());
		WaitTool.delay(100);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK, "111-11.11111111");
		NavigationTool.klikKonfirmasiYa(getWebDriver());
	}

	@Test(dependsOnMethods = { "editPenomoranPajak" })
	public void editPenomoranPajak2() {
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK, "111-11.11111111");

		AccTool.click(getWebDriver(),
				"//*[contains(@id,'tab-general')]//div[input[@name='toNumber']]//*[@class='btn-clear']");
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK);
		WaitTool.delay(100);
		GeneralTool.simpanPesanError(getWebDriver(), TARGET_FILE);
		NavigationTool.klikErrorOK(getWebDriver());
		WaitTool.delay(100);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK, "111-11.11111111");
		NavigationTool.klikKonfirmasiYa(getWebDriver());
	}

	@Test(dependsOnMethods = { "editPenomoranPajak2" })
	public void editPenomoranPajak3() {

		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK, "111-11.11111111");

		AccTool.click(getWebDriver(),
				"//*[contains(@id,'tab-general')]//div[input[@name='fromNumber']]//*[@class='btn-clear']");
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK);
		WaitTool.delay(100);
		GeneralTool.simpanPesanError(getWebDriver(), TARGET_FILE);
		NavigationTool.klikErrorOK(getWebDriver());
		WaitTool.delay(100);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK, "111-11.11111111");
		NavigationTool.klikKonfirmasiYa(getWebDriver());
	}

	@Test(dependsOnMethods = { "editPenomoranPajak3" })
	public void hapusPenomoranPajak() {
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK, "111-11.11111111");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENOMORAN_PAJAK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENOMORAN_PAJAK);
	}

	@Test(dependsOnMethods = { "hapusPenomoranPajak" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
