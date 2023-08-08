package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoripelanggan.KategoriPelangganParam;

public class KategoriPelangganTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(KategoriPelangganTool.class);

	public static void isiForm(WebDriver driver, KategoriPelangganParam param) {
		log.info("KategoriPelanggan.IsiHeader");

		String w = AccurateModule.KATEGORI_PELANGGAN.getXpath();

		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Kategori Pelanggan']");

		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);
		if (param.defaultKategori != null)
			AccTool.checkbox(driver, tab, "@name='isDefault'",
					param.defaultKategori);
		if (param.subKategori != null)
			AccTool.checkbox(driver, tab, "@name='sub'", param.subKategori);
		if (param.namaSubKategori != null)
			AccTool.lookup(driver, tab, "@name='parent'", param.namaSubKategori);
	}

	public static void saveData(WebDriver driver, String fileName) {
		log.info("Save Isi: " + fileName);

		String content = "KategoriPelanggan.SaveData : " + "\r\n";

		String tab = "//*[contains(@id,'tab-general')]";

		content = content
				+ "Nama : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_PELANGGAN,
						ElementType.TEXTFIELD, "name", tab)
				+ "Sub Kategori : "		
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_PELANGGAN,
						ElementType.CHECKBOX, "sub", tab)
				+ "Nama Sub : "		
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_PELANGGAN,
						ElementType.LOOKUP, "parent", tab) + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}

}
