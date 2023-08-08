package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kontak.KontakParam;

public class KontakTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(KontakTool.class);

	public static void klikLainnya(WebDriver driver) {
//		AccTool.click(driver, AccurateModule.KONTAK.getXpath()
//				+ "//a[text()='tab-others']");
		AccTool.click(driver, AccurateModule.KONTAK.getXpath() +
				"//a[contains(@href, '#tab-others')]");
	}

	public static void isi(WebDriver driver, KontakParam param) {
		log.info("Kontak.Isi");

		String w = AccurateModule.KONTAK.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Kontak']");

		if (param.sapaan != null)
			AccTool.combobox(driver, tab, "@name='salutation'", param.sapaan);

		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);

		if (param.jabatan != null)
			AccTool.textField(driver, tab, "@name='position'", param.jabatan);

		if (param.email != null)
			AccTool.textField(driver, tab, "@name='email'", param.email);

		if (param.handphone != null)
			AccTool.textField(driver, tab, "@name='mobilePhone'",
					param.handphone);

		if (param.teleponbisnis != null)
			AccTool.textField(driver, tab, "@name='workPhone'",
					param.teleponbisnis);
		
		if (param.faximili != null)
			AccTool.textField(driver, tab, "@name='fax'",
					param.faximili);

		if (param.teleponrumah != null)
			AccTool.textField(driver, tab, "@name='homePhone'",
					param.teleponrumah);

		if (param.pinbbm != null)
			AccTool.textField(driver, tab, "@name='bbmPin'", param.pinbbm);

		if (param.faximili != null)
			AccTool.textField(driver, tab, "@name='fax'", param.faximili);

		if (param.website != null)
			AccTool.textField(driver, tab, "@name='website'", param.website);
	}

	public static void isiLainnya(WebDriver driver, KontakParam param) {
		log.info("Kontak.Isi");

		String w = AccurateModule.KONTAK.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, w + "//a[text()='Lainnya']");
		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='notes'", param.catatan);

	}

	public static void saveIsiKontak(WebDriver driver, String filename) {
		log.info("Kontak.SaveIsi");

		// String w = AccurateModule.KONTAK.getXpath();
		String tab = "//*[contains(@id,'tab-general')]";
		String content = "Kontak.SaveIsiKontak : " + "\r\n";

		AccTool.click(driver, AccurateModule.KONTAK.getXpath()
				+ "//a[contains(@href,'tab-general')]");

		content = content
				+ "Sapaan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.COMBOBOX, "salutation", tab)
				+ "Nama	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTFIELD, "name", tab)
				+ "Jabatan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTFIELD, "position", tab)
				+ "Email	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTFIELD, "email", tab)
				+ "Handphone	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTFIELD, "mobilePhone", tab)
				+ "Telepon Bisnis	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTFIELD, "workPhone", tab)
				+ "Faxilimi	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTFIELD, "fax", tab)
				+ "Telepon Rumah	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTFIELD, "homePhone", tab)
				+ "Pin BBM	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTFIELD, "bbmPin", tab)
				+ "Website	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTFIELD, "website", tab) 		
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiLainnya(WebDriver driver, String filename) {
		log.info("Kontak.SaveIsi");

		// String w = AccurateModule.KONTAK.getXpath();
		String tab = "//*[contains(@id,'tab-others')]";
		String content = "Kontak.SaveIsiLainnya : " + "\r\n";

		AccTool.click(driver, AccurateModule.KONTAK.getXpath()
				+ "//a[contains(@href,'tab-others')]");

		content = content

				+ "Catatan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KONTAK,
						ElementType.TEXTAREA, "notes", tab) + "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}

}
