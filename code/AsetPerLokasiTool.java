package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.asetperlokasi.AsetPerLokasiParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class AsetPerLokasiTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger( AsetPerLokasiTool.class);

	public static void isi(WebDriver driver, AsetPerLokasiParam param) {
		log.info("asetperlokasi.Isi");
		
		String w = AccurateModule.ASET_PER_LOKASI.getXpath();
		
		if(param.tipe != null)
			AccTool.combobox(driver, w, "@name='perType'", 
		param.tipe);
		
		if(param.pilihaset != null)
			AccTool.lookup(driver, w, "@name='asset'", 
		param.pilihaset);
		
		if(param.alamat != null)
			AccTool.lookup(driver, w, "@name='location'", 
		param.alamat);
		
		if(param.tanggalaset != null)
			AccTool.datePicker(driver, w, "@name='asOfDate'", 
		param.tanggalaset);
		
		AccTool.click(getWebDriver(), w + "//*[@name='btnRefresh']");
	}
	public static void saveIsi(WebDriver driver, String filename) {
		log.info("asetperlokasi.SaveIsi");

		String content = "asetperlokasi.SaveKonten : " + "\n";

		content = content
				+ "Total		: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_PER_LOKASI, ElementType.SUMMARY,
						"totalQuantity()") + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void isiTanggalHistori(WebDriver driver, AsetPerLokasiParam param){
		
		String w ="//*[contains(@id,'tab-location-asset-history')]";
		if(param.tanggalawal != null)
			AccTool.datePicker(driver, w, "@name='fromDate'", param.tanggalawal);
		if(param.sampaitanggal != null)
			AccTool.datePicker(driver, w, "@name='toDate'", param.sampaitanggal);
		
	}
	
	public static void saveGridHistori(WebDriver driver, String filename){
		AccTool.waitGridMask(driver);
		AccTool.waitLoadingMask(driver);
		
		String content = "asetperlokasi.SaveGrid History :" + "\n";
		
		content = content		
				+ "Aset Per Lokasi : "
				+ AccTool.getGridValue(driver, AccurateModule.UMUM,"//*[contains(@id,'tab-location-asset-history')]");
		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[text()='Histori per Aset per Lokasi']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void savegrid(WebDriver driver, String filename){
		AccTool.waitGridMask(driver);
		AccTool.waitLoadingMask(driver);
		
		String content = "asetperlokasi. save grid list :" + "\n";
		
		content = content		
				+ "Aset Per Lokasi : "
				+ AccTool.getGridValue(driver, AccurateModule.ASET_PER_LOKASI,"//*[contains(@class,'asset-location-content')]");
		
		AccTool.writeTextFile(filename, content);
	}
	
}
