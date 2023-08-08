package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.gaji.GajiParam;

public class GajiTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(GajiTool.class);

	public static void isi(WebDriver driver, GajiParam param) {
		log.info("Gaji.Isi");
		String w = AccurateModule.GAJI.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";
		
		AccTool.click(driver, w + "//a[text()='Gaji/Tunjangan']");
		
		if(param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", 
		param.nama);
		
		if(param.tipegaji != null)
			AccTool.combobox(driver, tab, "@name='feeType'", 
		param.tipegaji);
		
		if(param.akunbeban != null)
			AccTool.lookup(driver, tab, "@name='expenseAccount'", 
		param.akunbeban);
	}
	
	public static void saveIsi(WebDriver driver, String filename) {
		log.info("Gaji.SaveIsi");

//		String w = AccurateModule.GAJI.getXpath();
		String tab ="//*[contains(@id,'tab-general')]";
		String content = "Gaji.SaveIsi : " + "\r\n";

		content = content
				+ "Nama	: "
				+ AccTool.getTextValue(driver, AccurateModule.GAJI, ElementType.TEXTFIELD,
						"name", tab)
				+ "Tipe Gaji	: "
				+ AccTool.getTextValue(driver, AccurateModule.GAJI, ElementType.COMBOBOX,
						"feeType", tab)
				+ "Akun Beban	: "
				+ AccTool.getTextValue(driver, AccurateModule.GAJI, ElementType.LOOKUP,
						"expenseAccount", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

}
