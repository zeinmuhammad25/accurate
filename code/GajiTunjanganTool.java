package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.gajitunjangan.GajiTunjanganParam;

public class GajiTunjanganTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(GajiTunjanganTool.class);

	public static void isi(WebDriver driver, GajiTunjanganParam param) {
		log.info("GajiTunjangan.Isi");

		String w = AccurateModule.GAJI_TUNJANGAN.getXpath();
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
		
		if(param.bayar != null)
			AccTool.combobox(getWebDriver(), tab, "@name='monthlyFee'", 
		param.bayar);
	}
	
	public static void saveIsi(WebDriver driver, String filename) {
	log.info("GajiTunjangan.SaveIsi");

//	String w = AccurateModule.GAJI_TUNJANGAN.getXpath();
	String tab = "//*[contains(@id,'tab-general')]";
	String content = "GajiTunjangan.SaveIsi : " + "\r\n";

	content = content
			+ "Nama	: "
			+ AccTool.getTextValue(driver, AccurateModule.GAJI_TUNJANGAN, ElementType.TEXTFIELD,
					"name", tab)
			+ "Tipe Gaji/Tunjangan	: "
			+ AccTool.getTextValue(driver, AccurateModule.GAJI_TUNJANGAN, ElementType.COMBOBOX,
					"feeType", tab)
			+ "Bayar/Potongan	: "
			+ AccTool.getTextValue(driver, AccurateModule.GAJI_TUNJANGAN, ElementType.COMBOBOX,
					"monthlyFee", tab)
			+ "Akun Beban	: "
			+ AccTool.getTextValue(driver, AccurateModule.GAJI_TUNJANGAN, ElementType.LOOKUP,
					"expenseAccount", tab)		
			+ "\r\n";

	AccTool.writeTextFile(filename, content);
	}

}
