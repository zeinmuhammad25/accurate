package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.departemen.DepartemenParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.DepartemenTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PerusahaanDepartemen extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PerusahaanDepartemen .class);

	private String TARGET_FILE = "PraOtomasi Perusahaan - Departemen.txt";
	
	@Test
	public void buatDept()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DEPARTEMEN);
		DepartemenParam param = new DepartemenParam();
		param.tab = "Departemen";
		param.nama = "Departemen 01234567890Departemen 01234567890Departemen 01234";
		param.keterangan = "Keterangan Departemen 0123456789Keterangan Departemen 0123456789Keterangan Departemen 0123456789Keterangan Departemen 0123456789Keterangan Departemen 0123456789Keterangan Departemen 0123456789Keterangan Departemen 0123456789Keterangan Depar";
		DepartemenTool.isiDepartemen(getWebDriver(), param);
		DepartemenTool.saveDepartemen(getWebDriver(), TARGET_FILE);
		
		param.tab = "Saldo Awal";
		DepartemenParam param2 = new DepartemenParam();
		
		param2.search = "Beban Listrik";
		WaitTool.delay(1000);
		DepartemenTool.isiSaldoAwal(getWebDriver(), param2);
		param2.nilai = "999999999999";
		DepartemenTool.isiDetailSaldoAwal(getWebDriver(), param2);
		DepartemenTool.saveListSaldoAwal(getWebDriver(), TARGET_FILE);
		
//		param.tab = "Saldo Awal";
		DepartemenParam param3 = new DepartemenParam();
		param3.search = "Penjualan";
		WaitTool.delay(1000);
		DepartemenTool.isiSaldoAwal(getWebDriver(), param3);
		param3.nilai = "999999999999";
		DepartemenTool.isiDetailSaldoAwal(getWebDriver(), param3);
		DepartemenTool.saveListSaldoAwal(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.DEPARTEMEN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DEPARTEMEN);
	}
	
	@Test(dependsOnMethods = "buatDept")
	public void hapusDept()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DEPARTEMEN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.DEPARTEMEN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.DEPARTEMEN, "Departemen 01234567890Departemen 01234567890Departemen 01234");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.DEPARTEMEN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DEPARTEMEN);
	}
	
	@Test(dependsOnMethods = "hapusDept")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
