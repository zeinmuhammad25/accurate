package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.accurate.tool.UangMukaPembelianTool;
import com.cpssoft.web.test.accurate.uangmukapembelian.UangMukaPembelianParam;

public class PraOtomPembelianUangMuka extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPembelianPenerimaanBarang.class);
	
	private String TARGET_FILE = "PraOtomasi Pembelian - Uang Muka.txt";
	
	@Test()
	public void buatDP()
	{
		//hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);
		UangMukaPembelianParam param = new UangMukaPembelianParam();
		
		param.pemasok = "Vendor-Dimas";
		param.tanggal = "01042022";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);
		param.nofaktur = "No Faktur 01234567890123456789";		
		param.no = "No Faktur 01234567890123456789";
		UangMukaPembelianTool.isiForm(getWebDriver(), param);
		UangMukaPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.uangmuka = "999999999999";
		param.kenapajak= false;
		param.syaratpembayaran = "C.O.D";
		UangMukaPembelianTool.isiUangMuka(getWebDriver(), param);
		UangMukaPembelianTool.saveIsiUangMuka(getWebDriver(), TARGET_FILE);
		
		param.alamat = "Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789"
				+ " Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alama"
				+ "t 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 01234"
				+ "56789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789 Alamat 0123456789A";
		param.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan "
				+ "0123456789 Keterangan 0123456789 Keterangan 012345678";
		UangMukaPembelianTool.isiInfoLain(getWebDriver(), param);
		UangMukaPembelianTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);	
	}
	
	@Test(dependsOnMethods = { "buatDP" })
	public void editDP()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN, "Vendor-Dimas");
		
		UangMukaPembelianParam param = new UangMukaPembelianParam();
	
		param.nofaktur = "DP-01";		
		param.no = "DP-01";
		UangMukaPembelianTool.isiForm(getWebDriver(), param);
		UangMukaPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.uangmuka = "100000";
		param.kenapajak= false;
		param.syaratpembayaran = "C.O.D";
		UangMukaPembelianTool.isiUangMuka(getWebDriver(), param);
		UangMukaPembelianTool.saveIsiUangMuka(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "editDP" })
	public void hapusDP()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN, "DP-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "hapusDP" })
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
