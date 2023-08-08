package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class MarketplaceTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(MarketplaceTool.class);
	
	static WebDriver driver = getWebDriver();

	
	//Karena field searchnya di dalam iframe, jadi perlu switchTo frame dulu
	public static void setFocusToMarketplaceIFrame() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'application-frame')]")));
	}
	
	//untuk kembali ke window default 
	public static void setFocusBackToDefault() {
		driver.switchTo().defaultContent();
	}
	
	public static void klikSwitchTabMarketplace(String tab) {
		String tab_name = "//nav[@class='top-toolbar']";
		WaitTool.waitForElementClickable(driver, By.xpath(tab_name), 5);
		
		switch(tab.toLowerCase()) {
		case "marketplace":
			AccTool.click(driver, tab_name + "//a[text()='Marketplace']");
			break;
		case "aplikasi saya":
			AccTool.click(driver, tab_name + "//a[text()='Aplikasi Saya']");
			break;
		}
	}

	public static void cariAplikasi(String nama_aplikasi) {
	
		String fieldsearch = "//form[@class='search-box']//input[@id='input-keyword']";
		String app_name = "//article[@class='app-list-item']//a[text()='"+nama_aplikasi+"']";
		WaitTool.waitForElementClickable(driver, By.xpath(fieldsearch), 4);
		WebElement element = driver.findElement(By.xpath(fieldsearch));
		AccTool.textField(driver, "", "@id='input-keyword'", nama_aplikasi);
		WaitTool.delay(300);
		element.sendKeys(Keys.ENTER);
		WaitTool.waitForElementClickable(driver, By.xpath(app_name), 5);
		AccTool.click(driver, app_name);
				
	}
	
	public static void installAplikasi(String nama_aplikasi) {
		String app_name="//div[@class='app-detail-header-info']/h2[text()='"+nama_aplikasi+"']";
		String button_install = app_name  + "/following-sibling::a[@id='buttonInstall']";
		
		WaitTool.waitForElementClickable(driver, By.xpath(button_install), 5);
		AccTool.click(driver, button_install);
		WaitTool.delay(300);
	}
	
	public static void konfirmasiInstall(String konfirmasi) {
		String halaman_konfirmasi = "//div[@class='install-confirm']";
		switch(konfirmasi.toLowerCase()) {
		case "batal":
			AccTool.click(driver, halaman_konfirmasi + "//button[@id='buttonBack']");
			break;
		case "install":
			AccTool.click(driver, halaman_konfirmasi + "//button[@id='buttonInstall']");
			break;
		}
		
		WaitTool.waitForElementDisapear(driver, By.xpath(halaman_konfirmasi), 5);
	}

	public static void uninstallFromSearch(String nama_aplikasi) {
		String app_name="//div[@class='app-detail-header-info']/h2[text()='"+nama_aplikasi+"']";
		String button_uninstall = app_name  + "/following-sibling::a[@id='buttonUninstall']";
		
		WaitTool.waitForElementClickable(driver, By.xpath(button_uninstall), 5);
		AccTool.click(driver, button_uninstall);
		WaitTool.delay(300);
	}
	
	public static void konfirmasiUnInstall(String konfirmasi) {
		String halaman_konfirmasi = "//div[@class='uninstall-confirm']";
		switch(konfirmasi.toLowerCase()) {
		case "batal":
			AccTool.click(driver, halaman_konfirmasi + "//button[@id='buttonBack']");
			break;
		case "uninstall":
			AccTool.click(driver, halaman_konfirmasi + "//button[@id='buttonUninstall']");
			break;
		}
		
		WaitTool.waitForElementDisapear(driver, By.xpath(halaman_konfirmasi), 5);
	}
	
}
