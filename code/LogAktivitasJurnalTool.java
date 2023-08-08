package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.logaktivitasjurnal.LogAktivitasJurnalParam;

public class LogAktivitasJurnalTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(LogAktivitasJurnalTool.class);

	public static void isi(WebDriver driver,LogAktivitasJurnalParam param) {
		log.info("LogAktivitasJurnal.isiForm");
		
		String w = AccurateModule.LOG_AKTIVITAS_JURNAL.getXpath();
		String tab = w + "//div[starts-with(@class,'module-list')]";
		
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='formData.item'", 
		param.search);
				
	}
	

}
