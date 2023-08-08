package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoriharga.KategoriHargaParam;

public class KategoriHargaTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(KategoriHargaTool.class);

	public static void isiForm(WebDriver driver, KategoriHargaParam param) {
		log.info("KategoriHarga.IsiForm");

		String w = AccurateModule.KATEGORI_HARGA.getXpath();

		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Kategori Penjualan']");
		AccTool.textField(driver, tab, "@name='name'", param.nama);
	}

	public static void saveData(WebDriver driver, String fileName) {
		log.info("Save Data: " + fileName);

		String content = "KategoriHarga.SaveData : " + "\r\n";

		content = content
				+ "Nama : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_HARGA,
						ElementType.TEXTFIELD, "name") + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
}
