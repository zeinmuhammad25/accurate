package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.cabang.CabangParam;

public class CabangTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(CabangTool.class);

	public static void isiCabang(WebDriver driver, CabangParam param) {
		log.info("cabang.Isi");

		
		String w = AccurateModule.CABANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Cabang']");

		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);

		if (param.jalan != null)
			AccTool.textarea(driver, tab, "@name='street'", param.jalan);

		if (param.kota != null)
			AccTool.textField(driver, tab, "@name='city'", param.kota);

		if (param.kodepos != null)
			AccTool.textField(driver, tab, "@name='zipCode'", param.kodepos);

		if (param.propinsi != null)
			AccTool.textField(driver, tab, "@name='province'", param.propinsi);

		if (param.negara != null)
			AccTool.textField(driver, tab, "@name='country'", param.negara);
	}

	public static void klikDaftarPengguna(WebDriver driver) {
		AccTool.click(driver, AccurateModule.CABANG.getXpath()
				+ "//a[text()='Daftar Pengguna']");
	}

	public static void isiDaftarPengguna(WebDriver driver, CabangParam param) {
		log.info("Cabang.IsiDaftarPengguna");

		String w = AccurateModule.CABANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, w + "//a[text()='Daftar Pengguna']");

		if (param.semua != null)
			AccTool.checkbox(getWebDriver(), tab, "@name='usedAllUser'", param.semua);

		if (param.daftar != null)
			AccTool.lookup(driver, tab, "@name='useUserAccessList'",
					param.daftar);
	}

	public static void saveIsiCabang(WebDriver driver, String filename) {
		String w = AccurateModule.CABANG.getXpath();
		String tab = "";
		String content = "Cabang.SaveIsiCabang : " + "\r\n";

		AccTool.click(driver, w + "//a[text()='Cabang']");
		tab = "//*[contains(@id,'tab-general')]";
		content = content
				+ "Nama	: "
				+ AccTool.getTextValue(driver, AccurateModule.CABANG,
						ElementType.TEXTFIELD, "name", tab)
				+ "Jalan : "
				+ AccTool.getTextValue(driver, AccurateModule.CABANG,
						ElementType.TEXTAREA, "street", tab)
				+ "Kota : "
				+ AccTool.getTextValue(driver, AccurateModule.CABANG,
						ElementType.TEXTFIELD, "city", tab)
				+ "Kode Pos : "
				+ AccTool.getTextValue(driver, AccurateModule.CABANG,
						ElementType.TEXTFIELD, "zipCode", tab)
				+ "Propinsi : "
				+ AccTool.getTextValue(driver, AccurateModule.CABANG,
						ElementType.TEXTFIELD, "province", tab)
				+ "Negara : "
				+ AccTool.getTextValue(driver, AccurateModule.CABANG,
						ElementType.TEXTFIELD, "country", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiDaftarPengguna(WebDriver driver, String filename) {
		String w = AccurateModule.CABANG.getXpath();
		String tab = "";
		String content = "Cabang.SaveDaftarPengguna : " + "\r\n";

		AccTool.click(driver, w + "//a[text()='Daftar Pengguna']");
		tab = "//*[contains(@id,'tab-others')]";
		content = content
				+ "Semua Pengguna : "
				+ AccTool.getTextValue(driver, AccurateModule.CABANG,
						ElementType.CHECKBOX, "usedAllUser", tab)
				+ "User : "
				+ AccTool.getTextValue(driver, AccurateModule.CABANG,
						ElementType.LOOKUP, "useUserAccessList", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	/*
	 * menambah akses pengguna baru tanpa menghapus pengguna yg ada sebelumnya
	 */
	public static void isiDaftarPengguna2(WebDriver driver, CabangParam param) {
		log.info("Cabang.IsiDaftarPengguna2");

		String w = AccurateModule.CABANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, w + "//a[text()='Daftar Pengguna']");
		if (param.semua != null)
			AccTool.checkbox(driver, tab, "@name='usedAllUser'", param.semua);
		if (param.daftar != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='useUserAccessList'", param.daftar);

	}

	
}
