package com.cpssoft.web.test.accurate.tool;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.billing.BillingParam;
import com.cpssoft.web.test.framework.tools.WaitTool;


public class BillingTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(BillingTool.class);
	public WebDriver driver = getWebDriver();
	
	public static void klikPengaturanDB () {
		AccTool.click(getWebDriver(), "//div[@class='tile-group']/div[2]//i[@class='icon-cog']");
	}
	
	public static void klikTagihanDB () {
		AccTool.click(getWebDriver(), "//div[@class='tile-group']/div[2]//i[@class='icon-credit-card']");
	}
	
	public static void pindahTabChrome (WebDriver driver, int x) {
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    if (x < tabs.size()) {
	    	 driver.switchTo().window(tabs.get(x));
	    }
	}
	
	public static void waitHalamanAreaPenagihanAktivasi () {
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath("//div[@class='row mb-2 ']//div[@class='p-0 ms-50']/div[contains(.,'Kode Billing')]"), 100);
	}
	
	public static void menuBilling(WebDriver driver,BillingParam param) {
		if (param.menu != null) {
			   log.info("PilihMenu");
			   	switch((param.menu).toLowerCase()) {
			case "dashboard":
				AccTool.click(driver, "//div[@class='list-box-menu']/a[contains(.,'Dashboard')]");
				break;
			case "profil billing":
				AccTool.click(driver, "//div[@class='list-box-menu']/a[contains(.,'Profil Billing')]");
				break;
			case "informasi tagihan":
				AccTool.click(driver, "//div[@class='list-box-menu']/a[contains(.,'Informasi Tagihan')]");
				break;
			case "informasi add on":
				AccTool.click(driver, "//div[@class='list-box-menu']/a[contains(.,'Informasi Add On')]");
				break;
			case "informasi layanan":
				AccTool.click(driver, "//div[@class='list-box-menu']/a[contains(.,'Informasi Layanan')]");
				break;
			case "daftar mutasi":
				AccTool.click(driver, "//div[@class='list-box-menu']/a[contains(.,'Daftar Mutasi')]");
				break;
			case "histori database":
				AccTool.click(driver, "//div[@class='list-box-menu']/a[contains(.,'Histori Database')]");
			default:
				break;
				}
			 }
		}
	
	//Halaman Dashboard
	
	public static void saldoDeposit(WebDriver driver,BillingParam param) {
		if (param.saldo != null) {
			   log.info("TambahSaldo");
			   	switch((param.saldo).toLowerCase()) {
			case "redeem voucer":
				AccTool.click(driver, "//button[@class='btn btn-outline-default  form-control waves-effect']");
				break;
			case "tambah deposit":
				AccTool.click(driver, "//a[.='Tambah Deposit']");
			default:
				break;
				}
			   	WaitTool.delay(10000);
			 }
		}
	
	
	
}
