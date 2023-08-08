package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pesananpenjualan.PesananPenjualanParam;
import com.cpssoft.web.test.accurate.widgets.WidgetParam;
import com.cpssoft.web.test.accurate.widgets.WidgetsName;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class WidgetTools extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(WidgetTools.class);

	public static void tambahWidget(WebDriver driver, WidgetParam param) {
		log.info("Tambah Widget");
		

		boolean exists = false;
		Actions action = new Actions(driver);
		String widgetroot = "//div[contains(@id, 'dashboard-module')]";
		String xpathwidget = widgetroot + "//span[starts-with(text(), '"+ param.namaWidget +"')]";
		String buttoncontainer = xpathwidget + "/ancestor::div[@class='widget-header']/following-sibling::div[1]/a[2]";
		
		do {
			// HAPUS WIDGET KALAU MASIH ADA
			List<WebElement> widgetexists = driver.findElements(By.xpath(xpathwidget));
			log.info("Jumlah widget " + param.namaWidget + " : "+ widgetexists.size());

			exists = widgetexists.size() > 0;
			if (exists) 
			{	
				WaitTool.waitForElementVisible(driver, By.xpath(xpathwidget), 20);
				action.moveToElement(widgetexists.get(0)).click().perform();
		
				WaitTool.waitForElementVisible(driver, By.xpath(buttoncontainer), 30);
				AccTool.click(getWebDriver(), buttoncontainer);
				WaitTool.waitForElementVisible(driver, By.xpath(buttoncontainer + "/following-sibling::ul//i[@class='icn-sub-menu-edit']"), 20);
				AccTool.click(getWebDriver(), buttoncontainer + "/following-sibling::ul//i[@class='icn-sub-menu-edit']");
				
				AccTool.click(getWebDriver(), "//button[@name='btnDelete']");
				
				NavigationTool.klikKonfirmasiYa(getWebDriver());
				
				log.info("Widget " + param.namaWidget +" telah dihapus");
			}
		}
		while (exists);
		
		//MULAI TAMBAH WIDGET
		//cek ada bar tambah widget atau tidak
		String arrowdown = widgetroot + "//button[contains(@data-bind, 'click: showAddWidgetDialog')]";		
	
		AccTool.click(getWebDriver(), arrowdown);
		WaitTool.waitForElementVisible(driver, By.xpath("//form[@class='form']"), 10);
		WaitTool.delay(200);
		AccTool.textField(driver, "", "@name='textField'", param.namaWidget);		
		
		AccTool.click(getWebDriver(), "//a[starts-with(text(), '"+ param.namaWidget +"')]");
		
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(xpathwidget), 20);
		log.info("widget " + param.namaWidget+ " sudah ditambahkan");
	}
	
	public static void hapusWidget(WebDriver driver, String namaWidget) {
		log.info("Hapus Widget");
		
		String widgetroot = "//div[contains(@id, 'dashboard-module')]";
		String xpathwidget = widgetroot + "//span[starts-with(text(), '"+ namaWidget +"')]";
		String buttoncontainer = xpathwidget + "/ancestor::div[@class='widget-header']/following-sibling::div[1]/a[2]";
		
		WaitTool.waitForElementVisible(driver, By.xpath(xpathwidget), 20);
		AccTool.moveToElementAndClick(driver, xpathwidget);
		
		WaitTool.waitForElementVisible(driver, By.xpath(buttoncontainer), 20);
		AccTool.click(getWebDriver(), buttoncontainer);
		WaitTool.waitForElementVisible(driver, By.xpath(buttoncontainer + "/following-sibling::ul//i[@class='icn-sub-menu-edit']"), 10);
		AccTool.click(getWebDriver(), buttoncontainer + "/following-sibling::ul//i[@class='icn-sub-menu-edit']");
				
		AccTool.click(getWebDriver(), "//button[@name='btnDelete']");
				
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		
		log.info("Widget " + namaWidget +" telah dihapus");
	}
	
	public static void ubahWidget(WebDriver driver, String namaWidget) {
		log.info("Ubah Widget");

		String widgetroot = "//div[contains(@id, 'dashboard-module')]";
		String xpathwidget = widgetroot + "//span[starts-with(text(), '"+ namaWidget +"')]";
		String buttoncontainer = xpathwidget + "/ancestor::div[@class='widget-header']/following-sibling::div[1]/a[2]";	
	
		WaitTool.waitForElementVisible(driver, By.xpath(xpathwidget), 20);	
		AccTool.moveToElementAndClick(driver, xpathwidget);
		
		WaitTool.waitForElementVisible(driver, By.xpath(buttoncontainer), 20);
		AccTool.click(getWebDriver(), buttoncontainer);
		WaitTool.waitForElementVisible(driver, By.xpath(buttoncontainer + "/following-sibling::ul//i[@class='icn-sub-menu-edit']"), 10);
		AccTool.click(getWebDriver(), buttoncontainer + "/following-sibling::ul//i[@class='icn-sub-menu-edit']");
		WaitTool.delay(500);
	
		
		log.info("Sudah Berada di halaman ubah pilihan");
	}


	
	public static void saveWidgetHutangUsaha(WebDriver driver, String filename){
		log.info("Save Widget Hutang Usaha");

		String content = "Widget.HutangUsaha : " + "\r\n";
		content = content + AccTool.getWidgetValue(getWebDriver() ,WidgetsName.HUTANG_USAHA)
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveWidgetBarangPerluDipesan(WebDriver driver, String filename){
		log.info("Save Widget Barang Perlu Dipesan");
		String content = "Widget Barang Perlu Dipesan : " + "\r\n";
		String widget = WidgetsName.BARANG_PERLU_DIPESAN.getXpath()+"//div[contains(@id,'content')]";

		content = content +
				"Barang	: " + AccTool.getTextValue(getWebDriver(), widget + "//label[contains(@data-bind, '$data.itemName')]") +
				"Qty	: " + AccTool.getTextValue(getWebDriver(), widget + "//label[contains(@data-bind, '$data.quantity')]");
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveAllCardWidgetReady(WebDriver driver, String filename){
		log.info("saveAllCardWidgetReady");
		String content3 = "- - - -SIMPAN KESELURUHAN CARD PADA DASHBOARD- - - -" + "\r\n" + "\r\n";
		String content1 = "Total Keseluruhan Card : " ;
		String content = "" ;
		String xpathwidget = "//span[contains(@data-bind, 'text: widgetCaption')]";
		
		List<WebElement> widgetexists = driver.findElements(By.xpath(xpathwidget));

		int a = widgetexists.size();
		
		content1 = content1
					+ a
					+ "\r\n"
					+ "\r\n";
		
		content = content 	
				+ "Nama-nama Card Widget Yang Tampil : " + "\r\n"
				+ "- " +AccTool.getTextValue(driver, "//span[contains(@data-bind, 'text: widgetCaption')]").replace(",", "\r\n" + "- ")
				+ "\r\n";
				
		AccTool.writeTextFile(filename, content3 + content1 + content);
	}
	
	public static void ubahPilihanAktifitasTerakhir(WebDriver driver, WidgetParam param) {
		log.info("Widgets.ubahPilihanAktifitasTerakhir");

		String tab =  "//*[contains(@id,'editor')]";
		AccTool.click(driver, "//button[@class='btn-clear']");
		{
		if (param.judul != null) 
			AccTool.numberField(driver, tab, "@type='text'", param.judul);
		}	
		
		AccTool.click(driver, "//button[.='Simpan']");
		
		WaitTool.waitForElementDisapear(driver, By.xpath(tab), 10);
	}
	
	public static void saveWidgetAktifitasTerakhir(WebDriver driver, String filename){
		log.info("save Widget Aktifitas Terakhir");
		String content3 = "- - - - " + AccTool.getTextValue(getWebDriver(), "//span[contains(text(), 'Aktifitas Terakhir')]").replace("\r\n","") + " - - - -" + "\r\n" + "\r\n";
		String content1 = "Jumlah Keseluruhan Aktifitas : " ;
		String content = "" ;
		String xpathwidget = "//span[contains(text(), 'Aktifitas Terakhir')]/ancestor::div[starts-with(@id, 'c_accurate__widget__recently-transaction-widget')]//span[contains(@data-bind, 'transactionTypeName')]/ancestor::label";
		
		List<WebElement> widgetexists = driver.findElements(By.xpath(xpathwidget));
		int a = widgetexists.size();

		content = content + "Nama Aktifitas : "
				+ "\r\n"
				+ "\r\n"
				+ "- "+ AccTool.getTextValue(getWebDriver(), "//span[contains(text(), 'Aktifitas Terakhir')]/ancestor::div[starts-with(@id, 'c_accurate__widget__recently-transaction-widget')]//span[contains(@data-bind, 'transactionTypeName')]/ancestor::label").replace(",", "\r\n" + "- ")
				+ "\r\n" ;
		
		content1 = content1	
				+ a
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content3 + content1 + content );
	}
	
	public static void saveWidgetKegiatanMendatang(WebDriver driver, String filename){
		log.info("save Widget Kegiatan Mendatang");
		String content3 = "- - - - " +  AccTool.getTextValue(getWebDriver(), "//span[contains(text(), 'Kegiatan Mendatang')]").replace("\r\n","") + " - - - -" + "\r\n" + "\r\n";
		String content1 = "Jumlah Keseluruhan Aktifitas : " ;
		String content = "" ;
		String xpathwidget = "//span[contains(text(), 'Kegiatan Mendatang')]/ancestor::div[starts-with(@id, 'c_accurate__widget__upcoming-events-widget')]//span[contains(@data-bind, 'transactionTypeName')]/ancestor::label";
		
		List<WebElement> widgetexists = driver.findElements(By.xpath(xpathwidget));
		int a = widgetexists.size();
		
		content = content + "Nama Aktifitas : "
				+ "\r\n"
				+ "\r\n"
				+ "- "+ AccTool.getTextValue(getWebDriver(), "//span[contains(text(), 'Kegiatan Mendatang')]/ancestor::div[starts-with(@id, 'c_accurate__widget__upcoming-events-widget')]//span[contains(@data-bind, 'transactionTypeName')]/ancestor::label").replace(",", "\r\n" + "- ")
				+ "\r\n" ;
		
		content1 = content1	
				+ a
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content3 + content1 + content );
	}
	
	public static void saveWidgetLabaRugi(WebDriver driver, String filename){
		log.info("save Widget Laba Rugi");
		String content3 = "- - - - " +  AccTool.getTextValue(getWebDriver(), "//span[contains(text(), 'Laba/Rugi')]").replace("\r\n","") + " - - - -" + "\r\n" + "\r\n";
		String content = "" ;
		
		content = content 
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__profit-loss-widget')]//label[contains(@data-bind, 'data.lineDescription')]").replace("," ,  "  -  ")
				+ "\r\n" 
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__profit-loss-widget')]//label[@class='text-right label-no-wrap']").replace("," , "  -  ")
				+ "\r\n" 
				+ "\r\n" 
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__profit-loss-widget')]//*[contains(@data-bind,'totalDescription')]").replace("\r\n" , " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__profit-loss-widget')]//*[contains(@class,'text-right dashboard')]")
				+ "\r\n" 
				;
		
		AccTool.writeTextFile(filename, content3 + content );
	}
	
	public static void saveWidgetPenjualan(WebDriver driver, String filename){
		log.info("save Widget Piutang Usaha");
		String content3 = "- - - - " +  AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//div[contains(@class, 'widget-header-title')]").replace("\r\n","") + " - - - -" + "\r\n" + "\r\n";
		String content = "" ;
		
		content = content 
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'leftLine1LeftLabel')]/ancestor::div[1]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'leftLine1LeftLabel')]/ancestor::div[1]/following-sibling::div")
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'leftLine2LeftLabel')]/ancestor::div[1]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'leftLine2LeftLabel')]/ancestor::div[1]/following-sibling::div")
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'leftLine3LeftLabel')]/ancestor::div[1]").replace("\r\n", " ---> ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'leftLine3LeftLabel')]/ancestor::div[1]/following-sibling::div")
				+ "\r\n" 
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'rightLine1LeftLabel')]/ancestor::div[1]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'rightLine1LeftLabel')]/ancestor::div[1]/following-sibling::div")
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'rightLine2LeftLabel')]/ancestor::div[1]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'rightLine2LeftLabel')]/ancestor::div[1]/following-sibling::div")
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'rightLine3LeftLabel')]/ancestor::div[1]").replace("\r\n", " ---> ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__sales-widget')]//label[contains(@data-bind, 'rightLine3LeftLabel')]/ancestor::div[1]/following-sibling::div")
				+ "\r\n" ;
		
		AccTool.writeTextFile(filename, content3 + content );
	}
	
	public static void saveWidgetPembelian(WebDriver driver, String filename){
		log.info("save Widget Piutang Usaha");
		String content3 = "- - - - " +  AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//div[contains(@class, 'widget-header-title')]").replace("\r\n","") + " - - - -" + "\r\n" + "\r\n";
		String content = "" ;
		
		content = content 
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'leftLine1LeftLabel')]/ancestor::div[1]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'leftLine1LeftLabel')]/ancestor::div[1]/following-sibling::div")
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'leftLine2LeftLabel')]/ancestor::div[1]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'leftLine2LeftLabel')]/ancestor::div[1]/following-sibling::div")
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'leftLine3LeftLabel')]/ancestor::div[1]").replace("\r\n", " ---> ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'leftLine3LeftLabel')]/ancestor::div[1]/following-sibling::div")
				+ "\r\n" 
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'rightLine1LeftLabel')]/ancestor::div[1]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'rightLine1LeftLabel')]/ancestor::div[1]/following-sibling::div")
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'rightLine2LeftLabel')]/ancestor::div[1]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'rightLine2LeftLabel')]/ancestor::div[1]/following-sibling::div")
				
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'rightLine3LeftLabel')]/ancestor::div[1]").replace("\r\n", " ---> ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__purchase-widget')]//label[contains(@data-bind, 'rightLine3LeftLabel')]/ancestor::div[1]/following-sibling::div")
				+ "\r\n" ;
		
		AccTool.writeTextFile(filename, content3 + content );
	}
	
	public static void saveBebanPerusahaan(WebDriver driver, String filename){
		log.info("save Widget Piutang Usaha");
		String content3 = "- - - - " +  AccTool.getTextValue(getWebDriver(), "//span[contains(text(), 'Beban Perusahaan')]").replace("\r\n","") + " - - - -" + "\r\n" + "\r\n";
		String content = "" ;
		
		content = content 
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//span[contains(@data-bind, 'comparePercentLabel')]").replace("\r\n", " - - ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//label[contains(@data-bind, 'compareLabel')]").replace("\r\n", " - - ")
				+ "\r\n" 
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//label[contains(@data-bind, 'totalDescription')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//span[contains(@data-bind, 'totalAmount')]/ancestor::label")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//label[contains(@data-bind, 'lineDescription')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//span[contains(@data-bind, 'lineAmount')]/ancestor::label")
				+ "\r\n" 
				;
		
		AccTool.writeTextFile(filename, content3 + content );
	}
	
	public static void saveAsetSaatIni(WebDriver driver, String filename){
		log.info("save Widget Aset Saat Ini");
		String content3 = "- - - - " +  AccTool.getTextValue(getWebDriver(), "//span[contains(text(), 'Aset saat ini')]").replace("\r\n","") + " - - - -" + "\r\n" + "\r\n";
		String content = "" ;
		
		content = content 
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__asset-growth-widget')]//label[contains(@class, 'fs-bold fs-xlarge')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__asset-growth-widget')]//span[contains(@data-bind, 'currencySymbol')]/ancestor::label")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//label[contains(@data-bind, 'totalDescription')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//span[contains(@data-bind, 'totalAmount')]/ancestor::label")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//label[contains(@data-bind, 'lineDescription')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'accurate__widget__top-expense-widget')]//span[contains(@data-bind, 'lineAmount')]/ancestor::label")
				+ "\r\n" 
				;
		
		AccTool.writeTextFile(filename, content3 + content );
	}
	
	
}
