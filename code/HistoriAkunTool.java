package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.historiakun.HistoriAkunParam;


public class HistoriAkunTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(HistoriAkunTool.class);

	public static void isiForm(WebDriver driver, HistoriAkunParam param) {
		log.info("HistoriAkun.isiForm");
		
		String tab = AccurateModule.HISTORI_AKUN.getXpath();
	//String tab = tab + "//div[starts-with(@class,'module-list')]";
		
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='account'", param.search);
		if (param.daritanggal != null)
			AccTool.datePicker(driver, tab, "@name='fromDate'", param.daritanggal);
		if (param.sampaitanggal != null)
			AccTool.datePicker(driver, tab, "@name='toDate'",param.sampaitanggal);		
	}
	public static void saveList(WebDriver driver, String filename) {
		log.info("Historiakun.SaveList");

	//	String w = param.w;
		String tab ="//div[starts-with(@class,'account-history-content')]";
		String content = "HistoriAkun.SaveList : " + "\r\n";
		
		content = content  + AccTool.getGridValue(driver, AccurateModule.HISTORI_AKUN, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikButtonRefresh(WebDriver driver, HistoriAkunParam param)
	{
		AccTool.click(driver, AccurateModule.HISTORI_AKUN.getXpath()
				+ "//button[@name='btnRefresh']");
		AccTool.waitProgressBar(driver);
		AccTool.waitGridMask(driver);
	}
	
	public static void klikCentang(WebDriver driver, HistoriAkunParam param)
	{
		AccTool.click(driver, AccurateModule.HISTORI_AKUN.getXpath()
				+ "//i[@class='icon-checkmark fg-green']");
	}

	public static void saveIsiForm(WebDriver driver, String fileName)
	{
		log.info("Save Isi Form: " + fileName);

		String content = "HistoriAkun.SaveIsiForm : " + "\r\n";
		String tab ="";

		content = content
				+ "Akun Perkiraan : "
				+ AccTool.getTextValue(driver, AccurateModule.HISTORI_AKUN, ElementType.LOOKUP, "account",
						tab)
				+ "Dari Tanggal"
				+ " : "
				+ AccTool.getTextValue(driver, AccurateModule.HISTORI_AKUN, ElementType.DATEPICKER, "fromDate",
						tab)
				+ "Sampai Tanggal"
				+ " : "
				+ AccTool.getTextValue(driver, AccurateModule.HISTORI_AKUN, ElementType.DATEPICKER, "toDate",
						tab)
				+ "\r\n";
		
		AccTool.writeTextFile(fileName, content);
	}
	
}



