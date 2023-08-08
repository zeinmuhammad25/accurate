package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.departemen.DepartemenParam;

public class DepartemenTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(DepartemenTool.class);

	public static void klikSaldoAwal(WebDriver driver) {
		AccTool.click(driver, AccurateModule.DEPARTEMEN.getXpath() + "//a[text()='Saldo Awal']");
	}

	public static void klikDaftarPengguna(WebDriver driver) {
		AccTool.click(driver, AccurateModule.DEPARTEMEN.getXpath() + "//a[text()='Daftar Pengguna']");
	}

	public static void hapusSaldoAwal(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-open-balance')]//*[@name='btnDelete']");
		AccTool.waitLoaderMedium(driver);
	}

	public static void klikFilterNonAktif(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'accurate__dynamic-filter')]//*[text()='Non Aktif']");
	}

	public static void klikYaNonAktif(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@data-bind,'text: $root.filterPanel.selectedFilter().trueLabel')]");
	}

	public static void klikTidakNonAktif(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@data-bind,'text: $root.filterPanel.selectedFilter().falseLabel')]");
	}

	// klik kosongkan filter non aktif
	public static void klikKosongkanPilihanFilterNonAktif(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@class,'button mini link')]");
	}

	public static void isiDepartemen(WebDriver driver, DepartemenParam param) {
		log.info("Departemen.IsiDepartemen");

		String w = AccurateModule.DEPARTEMEN.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";
		AccTool.click(driver, w + "//a[text()='Departemen']");

		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.cbsubdepartemen != null)
			AccTool.checkbox(driver, tab, "@name='sub'", param.cbsubdepartemen);
		if (param.namasubdepartemen != null)
			AccTool.lookup(driver, tab, "@name='parent'", param.namasubdepartemen);
		if (param.cbnonaktif != null)
			AccTool.checkbox(driver, tab, "@name='suspended'", param.cbnonaktif);
	}

	public static void saveDepartemen(WebDriver driver, String filename) {
		String w = AccurateModule.DEPARTEMEN.getXpath();
		String tab = "";
		String content = "Departemen.SaveDepartemen : " + "\r\n";

		AccTool.click(driver, w + "//a[text()='Departemen']");
		tab = "//*[contains(@id,'tab-general')]";
		content = content + "Nama	: "
				+ AccTool.getTextValue(driver, AccurateModule.DEPARTEMEN, ElementType.TEXTFIELD, "name", tab)
				+ "Keterangan	: "
				+ AccTool.getTextValue(driver, AccurateModule.DEPARTEMEN, ElementType.TEXTAREA, "description", tab)
				+ "Sub Dept	: "
				+ AccTool.getTextValue(driver, AccurateModule.DEPARTEMEN, ElementType.CHECKBOX, "sub", tab)
				+ "Nama Sub Dept : "
				+ AccTool.getTextValue(driver, AccurateModule.DEPARTEMEN, ElementType.LOOKUP, "parent", tab)
				+ "Non Aktif : "
				+ AccTool.getTextValue(driver, AccurateModule.DEPARTEMEN, ElementType.CHECKBOX, "suspended", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void isiSaldoAwal(WebDriver driver, DepartemenParam param) {
		log.info("Departemen.IsiSaldoAwal");

		String w = AccurateModule.DEPARTEMEN.getXpath();
		String tab = w + "//*[contains(@id,'tab-openbalance')]";
		AccTool.click(driver, w + "//a[text()='Saldo Awal']");

		if (param.tanggal != null)
			AccTool.datePicker(driver, tab, "@name='asOf'", param.tanggal);
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
	}

	public static void isiDetailSaldoAwal(WebDriver driver, DepartemenParam param) {
		log.info("Departemen.IsiDetailSaldoAwal");
		String tab = "//*[@class='window shadow']//div[contains(@id,'detail-open-balance')]";

		if (param.nilai != null)
			AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
		NavigationTool.klikButtonLanjut(getWebDriver(), tab);
	}

	public static void saveListSaldoAwal(WebDriver driver, String filename) {
		AccTool.click(driver, "//*[contains(@href,'tab-openbalance')]");
		String tab = "";
		String content = "Departemen.SaveListSaldoAwal : " + "\r\n";
		tab = "//*[contains(@id,'tab-openbalance')]";
		content = content + "Saldo Awal" + "\r\n" + "Per Tanggal :"
				+ AccTool.getTextValue(driver, AccurateModule.DEPARTEMEN, ElementType.DATEPICKER, "asOf", tab) + "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.DEPARTEMEN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void isiDaftarPengguna(WebDriver driver, DepartemenParam param) {
		log.info("Departemen.IsiDaftarPengguna");

		String w = AccurateModule.DEPARTEMEN.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, w + "//a[text()='Daftar Pengguna']");

		if (param.semua != null)
			AccTool.checkbox(driver, tab, "@name='usedAllUser'", param.semua);
		if (param.daftar != null)
			AccTool.lookup(driver, tab, "@name='useUserAccessList'", param.daftar);
		if (param.group != null)
			AccTool.lookup(driver, tab, "@name='useUserRoleAccessList'", param.group);
	}

	/*
	 * menambah akses pengguna baru tanpa menghapus pengguna yg ada sebelumnya
	 */
	public static void isiDaftarPengguna2(WebDriver driver, DepartemenParam param) {
		log.info("Departemen.IsiDaftarPengguna2");

		String w = AccurateModule.DEPARTEMEN.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, w + "//a[text()='Daftar Pengguna']");
		if (param.semua != null)
			AccTool.checkbox(driver, tab, "@name='usedAllUser'", param.semua);
		if (param.daftar != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='useUserAccessList'", param.daftar);
		if (param.group != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='useUserRoleAccessList'", param.group);
	}

	public static void saveDaftarPengguna(WebDriver driver, String filename) {
		String w = AccurateModule.DEPARTEMEN.getXpath();
		String tab = "";
		String content = "Departemen.SaveDaftarPengguna : " + "\r\n";

		AccTool.click(driver, w + "//a[text()='Daftar Pengguna']");
		tab = "//*[contains(@id,'tab-others')]";
		content = content + "Akses Pengguna" + "\r\n" + "Semua Pengguna : "
				+ AccTool.getTextValue(driver, AccurateModule.DEPARTEMEN, ElementType.CHECKBOX, "usedAllUser", tab)
				+ "User : "
				+ AccTool.getTextValue(driver, AccurateModule.DEPARTEMEN, ElementType.LOOKUP, "useUserAccessList", tab)
				+ "Group/Cabang : " + AccTool.getTextValue(driver, AccurateModule.DEPARTEMEN, ElementType.LOOKUP,
						"useUserRoleAccessList", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}


}
