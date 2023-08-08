package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.historibank.HistoriBankParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.HistoriBankTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;

public class PraOtomKasBankHistoriBank extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomKasBankHistoriBank.class);

	private String TARGET_FILE = "PraOtomasi Kas Ban - kHistori Bank.txt";

	@Test
	public void isiHistori() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.HISTORI_BANK);
		
		HistoriBankParam param = new HistoriBankParam();
		
		param.search = "Kas Kecil";
		param.daritanggal = "01012015";
		param.sampaitanggal = "20032017";
		HistoriBankTool.isiForm(getWebDriver(), param);
		HistoriBankTool.saveList(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = "isiHistori")
	public void executeFinal() {
	}

}
