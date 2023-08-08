package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangpergudang.BarangPerGudangParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class BarangPerGudangTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(BarangPerGudangTool.class);

	public static void klikbtnrefresh(WebDriver driver){
		AccTool.click(getWebDriver(), "//*[contains(@name,'btnRefresh')]");
//		WaitTool.delay(500);
		AccTool.waitLoadingMask(getWebDriver());
	}
	
	public static void isiForm(WebDriver driver, BarangPerGudangParam param) {
		log.info("BarangPerGudang.isiForm");
		
		String w = AccurateModule.BARANG_PER_GUDANG.getXpath();
		String tab = w + "//div[starts-with(@class,'module-body')]";
		
		if (param.sortby != null)
			AccTool.combobox(driver, tab, "@name='perType'", 
		param.sortby);
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='item'", 
		param.search);
		if (param.sampaitanggal != null)
			AccTool.datePicker(driver, tab, "@name='asOfDate'", 
		param.sampaitanggal);		
	}
	
	public static void ubahSatuanKuantitas(WebDriver driver, BarangPerGudangParam param){
		String w = AccurateModule.BARANG_PER_GUDANG.getXpath();
		String tab = w + "//div[starts-with(@class,'module-body')]";
		
		if(param.satuankuantitas!=null)
			AccTool.combobox(driver, tab, "@name='itemUnit'", param.satuankuantitas);
	}
	
	public static void saveList(WebDriver driver, String filename)
	{
		log.info("BarangPerGudang.SaveList");

		String tab = "";
		String content = "BarangPerGudang.SaveList : " + "\r\n";
		
		content = content + AccTool.getGridValue(driver, AccurateModule.BARANG_PER_GUDANG, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

}
