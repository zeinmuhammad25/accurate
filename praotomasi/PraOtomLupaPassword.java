package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.asettetap.AsetTetapParam;
import com.cpssoft.web.test.accurate.kategoriaset.KategoriAsetParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AsetTetapTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriAsetTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;

public class PraOtomLupaPassword extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomLupaPassword.class);

	private String TARGET_FILE = "PraOtomasi Lupa Password.txt";

	@Test()
	public void lupaPassword()
	{
	
		NavigationTool.klikLupapassword(getWebDriver());		
		NavigationTool.inputEmailAkun(getWebDriver(), "otomasipraotomasi@bisnis2030.com");	
		NavigationTool.klikResetPassword(getWebDriver());
		
	}
	
}
