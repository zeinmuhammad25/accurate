package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.perintahstokopname.PerintahStokOpnameParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.PerintahStokOpnameTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;

public class PraOtomPersediaanPerintahStokOpname extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PraOtomPersediaanPerintahStokOpname.class);
	private static String TARGET_FILE = "PraOtomasi Persediaan - Perintah Stok Opname.txt";

	@Test
	public static void buatPSOBaru() {

		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);

		PerintahStokOpnameParam param = new PerintahStokOpnameParam();
		param.no = "PSO01";
		param.tanggalspk = "02022016";
		PerintahStokOpnameTool.isiHeader(getWebDriver(), param);
		PerintahStokOpnameTool.saveIsiHeaderNoManual(getWebDriver(), TARGET_FILE);

//		param.tanggal= "03022016";
		param.penanggungjawab = "Dimas";
		param.dikerjakanoleh = "Husni";
		param.gudang = "Utama";
		param.kategoribarang = "Umum";
		param.pemasok = "Vendor-Dimas";
		PerintahStokOpnameTool.isidetail(getWebDriver(), param);
		PerintahStokOpnameTool.SaveIsiDetail(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
	}

	@Test(dependsOnMethods = "buatPSOBaru")
	public static void editPSO() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME, "PSO01");

		PerintahStokOpnameParam param = new PerintahStokOpnameParam();
		param.no = "PerintahStokOpname01PerintahStokOpname01PerintahStokOpname01PerintahStokOpname01";
		param.tanggalspk = "02022016";
		PerintahStokOpnameTool.isiHeader(getWebDriver(), param);
		PerintahStokOpnameTool.saveIsiHeaderNoManual(getWebDriver(), TARGET_FILE);

//		param.tanggal = "03022016";
		param.penanggungjawab = "PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 "
				+ "PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 PenanggungJawab123456 ";
		param.dikerjakanoleh = "Husni";
		param.keterangan = "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 "
				+ "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 "
				+ "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 "
				+ "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 "
				+ "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 ";

		PerintahStokOpnameTool.isidetail(getWebDriver(), param);
		PerintahStokOpnameTool.SaveIsiDetail(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);

	}
	
	@Test(dependsOnMethods = "editPSO")
	public static void editPSO2() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME, "PSO01");

		PerintahStokOpnameParam param = new PerintahStokOpnameParam();
		param.no = "PerintahStokOpname01PerintahStokOpname01PerintahStokOpname01PerintahStokOpname01";
		param.tanggalspk = "02022016";
		PerintahStokOpnameTool.isiHeader(getWebDriver(), param);
		PerintahStokOpnameTool.saveIsiHeaderNoManual(getWebDriver(), TARGET_FILE);

//		param.tanggal = "03022016";
		param.penanggungjawab = "PenanggungJawab123456 ";
		param.dikerjakanoleh = "Husni";
		param.keterangan = "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 "
				+ "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 "
				+ "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 "
				+ "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 "
				+ "Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 Keterangan Perintah Stok Opname 123456597814 ";

		PerintahStokOpnameTool.isidetail(getWebDriver(), param);
		PerintahStokOpnameTool.SaveIsiDetail(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
	}

	@Test(dependsOnMethods = "editPSO2")
	public static void hapusPSO() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME,
				"PerintahStokOpname01PerintahSt");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PERINTAH_STOK_OPNAME);
	}
	
	@Test(dependsOnMethods = "hapusPSO")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
