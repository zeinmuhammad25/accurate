package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penomoran.PenomoranParam;

public class PenomoranTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PenomoranTool.class);

	public static void isiForm(WebDriver driver, PenomoranParam param) {
		log.info("Penomoran.Isi");

		String w = AccurateModule.PENOMORAN.getXpath();
		String tab = w + "//div[contains(@id,'tab-general')]";		
		
		AccTool.click(driver, w + "//a[text()='Penomoran']");
		
		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);
		if (param.cbdefault != null)
			AccTool.checkbox(driver, tab, "@name='defaults'", param.cbdefault);
		if (param.tipetransaksi != null)
			AccTool.combobox(driver, tab, "@name='transactionType'", param.tipetransaksi);
		if (param.tipepenomoran != null)
			AccTool.combobox(driver, tab, "@name='autoNumberType'", param.tipepenomoran);
		if (param.jumlahdigitcounter != null)
			AccTool.numberField(driver, tab, "@name='counterDigit'", param.jumlahdigitcounter);
		if (param.komponenpenomoran != null)
			AccTool.combobox(driver, tab, "@name='detailOpt'", param.komponenpenomoran);
		
	}	
	
	public static void saveData(WebDriver driver, String filename) {
		log.info("Penomoran.SaveData");

		String tab = "//*[contains(@id,'tab-general')]" + "\r\n";
		String content = "Penomoran.SaveIsi : " + "\r\n";

		content = content
				+ "Nama Penomoran		: "
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN,
						ElementType.TEXTFIELD, "name", tab)
				+ "Default			: "		
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN,
						ElementType.CHECKBOX, "defaults", tab)
				+ "Tipe Transaksi		: "		
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN,
						ElementType.COMBOBOX, "transactionType", tab)
				+ "Tipe Penomoran		: "		
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN,
						ElementType.COMBOBOX, "autoNumberType", tab)
				+ "Digit Counter		: "		
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN,
						ElementType.NUMBERFIELD, "counterDigit", tab)
				+ "Detail Penmoran	: "		
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN,
						ElementType.LOOKUP, "detailList", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	
	public static void saveIsiLainLain(WebDriver driver, String filename) {
		log.info("Penomoran.SaveIsiLainLain");

		String w = AccurateModule.PENOMORAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";		
		String content = "Penomoran.SaveLainLain : " + "\r\n";

		content = content
				+ "Semua Pengguna	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN,
						ElementType.CHECKBOX, "usedAllUser", tab)
				+ "Akses Grup	: "		
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN,
						ElementType.LOOKUP, "useUserRoleAccessList", tab)
				+ "Akses User	: "		
				+ AccTool.getTextValue(driver, AccurateModule.PENOMORAN,
						ElementType.LOOKUP, "useUserAccessList", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikTambah(WebDriver driver) {
		String xpath = "//*[@id ='module-accurate__company__auto-number']//*[contains(@id,'tab-general')]//*[@name='btnAdd']";
		AccTool.click(driver, xpath);
	}
}
