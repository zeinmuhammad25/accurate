package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.praotomasi.DesainCetakanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class DesainCetakanTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(DesainCetakanTool.class);
	
	public static void isiForm (WebDriver driver, DesainCetakanParam param) {
		
		log.info("DesainCetakan.IsiForm");
		
		if(param.nama != null)
			AccTool.textField(driver, "", "@name='name'", 
		param.nama);
		if(param.tipe != null){
			AccTool.combobox(driver, "", "@name='transactionType'", 
		param.tipe);
			WaitTool.waitForElementVisible(getWebDriver(), By.xpath("//div[contains(@id, 'copy-from-template-dialog')]"), 30);
			if(param.layout != null){
				AccTool.combobox(driver, "", "@data-bind='metroCombobox: {}, options: availableTemplate, value: selectedTemplate'", 
			param.layout);}

		}
		AccTool.click(getWebDriver(), "//div[@class='content']//button[@class='button primary']");

	}
	public static void isiAksesPengguna (WebDriver driver, DesainCetakanParam param) {
		log.info("DesainCetakanTool.isiAksesPengguna");
		
		if (param.cbpengguna != null) {
			AccTool.checkbox(driver, "", "@name='usedAllUser'", param.cbpengguna);
		}
		if(param.role != null)
			AccTool.lookup(driver, "", "@name='useUserRoleAccessList'", 
		param.role);
		
		if(param.pengguna != null)
			AccTool.lookup(driver, "", "@name='useUserAccessList'", 
		param.pengguna);


	}
	
	public static void isiTemplateEmail (WebDriver driver, DesainCetakanParam param, AccurateModule module) {

		log.info("DesainCetakanTool.isiTemplateEmail");

		String tab = "//div[contains(@id,'tab-email-transaction')]";
		
		AccTool.click(driver, "//*[contains(@href,'tab-email-transaction')]");

		if (param.variable != null) {
		AccTool.dropDown(driver, module.getXpath(), "detailOpt", param.variable);
		}
		
		if(param.pengguna != null){
			AccTool.textField(driver, tab, "@name='emailTransSubject'", param.pengguna);
		}
		
		if (param.pesan != null) {
			AccTool.textarea(driver, "" , "@name='emailTransMessage'", param.pesan);
		}
		
	}
	
	public static void saveIsiForm(WebDriver driver,  String filename)
	{
		log.info("DesainCetakanTool.saveIsiForm");
		
		String tab = "";
		String content = "DesainCetakan.SaveisiForm : " + "\r\n";
		tab = "//*[contains(@id,'tab-general')]";
		content = content  
				+ "\r\n"
				+ AccTool.getTextValue(driver, "//*[@for='name']").replace("\r\n", " : ") + AccTool.getTextValue(driver, AccurateModule.DESAIN_CETAKAN, ElementType.TEXTFIELD, "name", tab)
				+ AccTool.getTextValue(driver, "//div[.='Tipe']").replace("\r\n", " : ") + AccTool.getTextValue(driver, AccurateModule.DESAIN_CETAKAN, ElementType.COMBOBOX, "transactionType",tab);
			
		String AksesPengguna =  AccTool.getTextValue(driver, ElementType.CHECKBOX, "usedAllUser", tab);
		//akses pengguna ada 2 kondisi,ketika true or false
		if (AksesPengguna.contains("true")) {
					
			content = content 		
					//Akses Pengguna semua pengguna
					+ AccTool.getTextValue(driver, "//input[@value='true']/following-sibling::span[2]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "usedAllUser", tab);

		}else {
					content = content 
							//Akses Pengguna pilih pengguna dan grup/cabang
							+ AccTool.getTextValue(driver, "//input[@value='true']/following-sibling::span[2]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "usedAllUser", tab)
							+ AccTool.getTextValue(driver, "//label[@for='useUserRoleAccessList']").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.DESAIN_CETAKAN, ElementType.LOOKUP, "useUserRoleAccessList", tab)
							+ AccTool.getTextValue(driver, "//label[@for='useUserAccessList']").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.DESAIN_CETAKAN, ElementType.LOOKUP, "useUserAccessList", tab);

				}
		AccTool.writeTextFile(filename,  content);
	}
}