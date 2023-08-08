package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.persiapandataperusahaan.PersiapanDataParam;

public class PersiapanDataPerusahaanTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PersiapanDataPerusahaanTool.class);

	public static void isiForm(WebDriver driver, PersiapanDataParam param) {
		log.info("PersiapanData.Isi");

		String w = AccurateModule.PERSIAPAN_DATA.getXpath();
		
		AccTool.checkbox(driver, w, "@name='companyNoDataSetup'", param.cbtidaktampil);
	}
	
	
	public static void saveData(WebDriver driver, PersiapanDataParam param) {
		log.info("PersiapanData.SaveData");


		
		
	}

}
