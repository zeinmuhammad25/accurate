package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.historibank.HistoriBankParam;

public class HistoriBankTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(HistoriBankTool.class);

	public static void isiForm(WebDriver driver, HistoriBankParam param) {
		log.info("HistoriBank.isiForm");
		
		String w = AccurateModule.HISTORI_BANK.getXpath();
		
		if (param.search != null)
			AccTool.lookup(driver, w, "@name='bank'", param.search);
		if (param.daritanggal != null)
			AccTool.datePicker(driver, w, "@name='fromDate'", param.daritanggal);
		if (param.sampaitanggal != null)
			AccTool.datePicker(driver, w, "@name='toDate'", param.sampaitanggal);		
	}
	
	public static void saveList(WebDriver driver, String filename) {
		log.info("BukuBank.SaveList");

//		String w = param.w;
		AccTool.waitGridMask(driver, true);
		String tab ="//div[starts-with(@class,'row no-margin bank-book-grid')]";
		String content = "HistoriBank.SaveList : " + "\r\n";
		
		content = content  + AccTool.getGridValue(driver, AccurateModule.HISTORI_BANK, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikButtonRefresh(WebDriver driver, HistoriBankParam param)
	{
		AccTool.click(driver, AccurateModule.HISTORI_BANK.getXpath()
				+ "//button[@name='btnRefresh']");
	}
	
	public static void klikCentang(WebDriver driver, HistoriBankParam param)
	{
		AccTool.click(driver, AccurateModule.HISTORI_BANK.getXpath()
				+ "//i[@class='icon-checkmark fg-green']");
	}

	public static void saveIsiForm(WebDriver driver, String fileName)
	{
		log.info("Save Isi Form: " + fileName);

		String content = "HistoriBank.SaveIsiForm : " + "\r\n";
		String tab ="";

		content = content
				+ "Akun Kas & Bank : "
				+ AccTool.getTextValue(driver, AccurateModule.HISTORI_BANK, ElementType.LOOKUP, "bank",
						tab)
				+ "Dari Tanggal"
				+ " : "
				+ AccTool.getTextValue(driver, AccurateModule.HISTORI_BANK, ElementType.DATEPICKER, "fromDate",
						tab)
				+ "Sampai Tanggal"
				+ " : "
				+ AccTool.getTextValue(driver, AccurateModule.HISTORI_BANK, ElementType.DATEPICKER, "toDate",
						tab)
				+ "\r\n";
		
		AccTool.writeTextFile(fileName, content);
	}
	
}
