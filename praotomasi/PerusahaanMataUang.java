package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.matauang.MataUangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.MataUangTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PerusahaanMataUang extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PerusahaanMataUang .class);

	private String TARGET_FILE = "PraOtomasi Perusahaan - MataUang.txt";
	
	@Test()
	public void buatMataUang()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.MATA_UANG);
		MataUangParam param = new MataUangParam();
		param.nama = "Australia Dollar";
		MataUangTool.isi(getWebDriver(), param);
		MataUangTool.saveIsiMataUang(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.MATA_UANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.MATA_UANG);
	}
	
	@Test(dependsOnMethods = { "buatMataUang" })
	public void editMataUang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.MATA_UANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.MATA_UANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.MATA_UANG, "AUD");
		MataUangParam param = new MataUangParam();
		
		param.tab = "default akun";
		param.hutang= "210105";
		param.piutang = "110305";
		param.uangmukapembelian = "110306";
		param.uangmukapenjualan = "210106";
		param.diskonpenjualan = "440103";
		param.labarugiterealisir = "Laba/Rugi Terealisasi AUD";
		param.labarugibelumterealisir = "Laba/Rugi Belum Terealisasi AUD";
		MataUangTool.isiDefaultAkun(getWebDriver(), param);
		MataUangTool.saveIsiDefaultAkun(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.MATA_UANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.MATA_UANG);
	}
	
	@Test(dependsOnMethods = { "editMataUang" })
	public void hapusMataUang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.MATA_UANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.MATA_UANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.MATA_UANG, "AUD");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.MATA_UANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.MATA_UANG);
	}
	
	@Test(dependsOnMethods = { "hapusMataUang" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
