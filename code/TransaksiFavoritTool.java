package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.transaksifavorit.TransaksiFavoritParam;
import com.cpssoft.web.test.framework.tools.WaitTool;



public class TransaksiFavoritTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger( TransaksiFavoritTool.class);
	
   public static void isiDetailTransaksiFavorit(WebDriver driver,TransaksiFavoritParam param)
{
	log.info("TransaksiFavorit.isiDetailTransaksiFavorit");
	String w ="//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]";	
	if(param.namafavorit != null)
		AccTool.textField(driver, w, "@name='name'", param.namafavorit);	
	if(param.grupcabang != null)
		AccTool.lookup(driver, w, "@name='useUserRoleAccessList'", param.grupcabang);	
	if(param.pengguna != null)
		AccTool.textField(driver, w, "@name='useUserAccessList'", param.pengguna);	
}

   public static void klikLanjut() {
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'accurate__company__save-memorize-transaction-dialog')]");
		WaitTool.waitForElementDisapear(getWebDriver(), By.xpath("//div[contains(@id,'accurate__company__save-memorize-transaction-dialog')]"), 1);
		//WaitTool.delay(500);
	}
	
   public static void klikLanjutSalinFavorit() {
	NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'copy-memorize-transaction')]");
	WaitTool.waitForElementDisapear(getWebDriver(), By.xpath("//div[contains(@id,'copy-memorize-transaction')]"), 1);
	//WaitTool.delay(500);
}

	public static void klikOk() {
		AccTool.click(getWebDriver(), "//div[contains(@id,'info-dialog')]//button[@name='btnOk']");
		WaitTool.waitForElementDisapear(getWebDriver(), By.xpath("//div[contains(@id,'info-dialog')]//button[@name='btnOk']"), 1);
		WaitTool.delay(2000);
	}
	
	public static void saveList(WebDriver driver, String filename ){
		log.info("transaksifavorit.SaveList");	
		
		String tab  = "//div[contains(@class,'grid fluid')]";
		String content = "TransaksiFavorit.SaveList : " + "\r\n";
		content = content 
				+ AccTool.getGridValue(driver, AccurateModule.TRANSAKSI_FAVORIT, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}


}
