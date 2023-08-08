package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penyelesaianbarangjadi.PenyelesaianBarangJadiParam;
import com.cpssoft.web.test.framework.tools.WaitTool;


public class PenyelesaianBarangJadiTool extends AbstractAccurateTestCase {
		static Logger log = LogManager.getLogger(PenyelesaianBarangJadiTool.class);
		
		
		public static void klikHapusGudang(WebDriver driver) {
			AccTool.clearLookup(getWebDriver(),"", "@name='warehouse'");
		}
		
		
		public static void klikOKPopUpWarning(WebDriver driver) {
			
			String path = "//*[@name='btnOk']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		//klik konfirmasi ya
		public static void klikKonfirmasiYa(WebDriver driver) {
			
			String path = "//button[@class='button success meddium']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		
		public static void klikKonfirmasiTidak(WebDriver driver) {
			
			String path = "//button[@class='button warning meddium']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		// konfirmasi tutup tab data saat ada data terisi
		public static void klikOKPadaWarningTutupTab(WebDriver driver) {
			AccTool.click(driver, "//*[contains(@id,'confirm-dialog')]//*[@name='btnOk']");
			WaitTool.delay(1000);
		}
		
		public static void klikTutupPopupDetailBarang(WebDriver driver) {
			String path = "//*[text()='Rincian Barang']/parent::*//*[@class='btn-close']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		}
		

		public static void klikLanjutDetailBarang(WebDriver driver) {
			
			String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
			AccTool.click(driver, path);
			AccTool.waitProgressBar(getWebDriver());
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		//tanpa disappear
		public static void klikLanjutBarang(WebDriver driver) {
			
			String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
			AccTool.click(driver, path);
			AccTool.waitProgressBar(getWebDriver());
		}
		
		public static void klikHapusDetailBarang(WebDriver driver) {
			
			String path = "//*[contains(@id,'detail-item')]//*[@name='btnDelete']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		
		public static void klikIconSubstitusi(WebDriver driver) {
					
			AccTool.click(driver, "//button[@name='usedSecondQuality']");
			
		}
	
	   
	   public static void klikPilihSubstitusi(WebDriver driver,String kolom) {

		   String path = "//div[text()='" + kolom +"']";
			AccTool.click(getWebDriver(), path);
			
			
		}
	   
	   
		public static void klikTabSerialNumberBarang(WebDriver driver)
		{
	
			AccTool.click(driver, "//a[contains(@href, '#tab-serial-number')]");
		}
		
		public static void klikTabInfoLain(WebDriver driver){
			AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
		}
		
		public static void klikButtonLanjutTabDetailSerialNumber(WebDriver driver) {
			WaitTool.delay(100);
			String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
			AccTool.click(driver, path);
			WaitTool.delay(200);
		}
	  
	   
	    public static void isiHeader (WebDriver driver, PenyelesaianBarangJadiParam param){
			
			String tab = "";
			
			
			if(param.perintahkerja != null)
				AccTool.lookup(driver, tab, "@name='workOrder'", param.perintahkerja);
			if(param.tanggal != null)
				AccTool.datePicker(driver, tab, "@name='transDate'", param.tanggal);
			if(param.no != null)
				AccTool.textField(driver, tab, "@name='number'", param.no);
				
		}
		
	    public static void isiDetail(WebDriver driver, PenyelesaianBarangJadiParam param){
			
	    	String tab = "//div[starts-with(@id,'tab-item')]";
			AccTool.click(driver, "//*[contains(@href,'tab-item')]");

			if (param.searchitem != null)
				AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
			AccTool.waitLoadingMask(driver);
			if (param.scroll != null)
				AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
		
		}
		
	   
	    public static void detailBarang(WebDriver driver, PenyelesaianBarangJadiParam param) {
			
			String tab = "//div[starts-with(@id,'detail-item')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			
	
			if (param.kuantitas != null)
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
			if (param.satuandetail != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuandetail);
			if (param.gudang != null)
				AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
		
			
			String tab2 = "//div[starts-with(@id,'detail-item')]";
			AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
			if(param.keterangandetail != null)
				AccTool.textarea(driver, tab2, "@name='detailNotes'", param.keterangandetail);
		}
	   
	   
		public static void isiNoSeri(WebDriver driver, PenyelesaianBarangJadiParam param) {
		
			String tab = "//div[starts-with(@id,'tab-serial-number')]";
			AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");

			if (param.kuantitasnoseri != null)
				AccTool.numberField(driver, tab, "@name='quantitySn'", param.kuantitasnoseri);
			if (param.noseri != null)
				AccTool.textField(driver, tab, "@name='numberSn'", param.noseri);
		}

	   
		
		public static void isiInfoLain(WebDriver driver, PenyelesaianBarangJadiParam param){
			
			String tab = "";
			
			if(param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='description'", param.keterangan);	
		
		}
		
	 
		
	    public static void saveIsiPopup(WebDriver driver, String fileName) {
			
			String content = "PenyelesaianBarangJadi.Konfirmasi : " + "\r\n";
			WaitTool.waitForElementVisible(driver,
					By.xpath("//*[contains(@id,'accurate__fabrication__finished-good-slip-confirm-force-finish')]//*[@class='row no-margin']//*[@class='span12']"), 5);
			WebElement confirmwindow = driver.findElement(By
					.xpath("//*[contains(@id,'accurate__fabrication__finished-good-slip-confirm-force-finish')]//*[@class='row no-margin']//*[@class='span12']"));
				content = content + "\r\n" + confirmwindow.getText() + "\r\n" + "\r\n";
			log.info(content);

			AccTool.writeTextFile(fileName, content);
		}
		
	   
	    public static void SaveNotifNoseri(WebDriver driver, String fileName) {
		log.info("PindahBarang.SaveNotifNoSeri");

		String tab = "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
		String content = "PindahBarang.SaveNotifNoSeri : " + "\r\n";
		content = content + "Notifikasi" + "\r\n" + AccTool.getTextValue(driver, ElementType.REPORT, " ", tab) + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
	
		
		public static void saveList(WebDriver driver, String fileName) {

			
			String tab = "//div[starts-with(@class,'module-list')]";
			String content = "Penyelesaian Barang Jadi.SaveList : " + "\r\n";
			content = content 
				
					+ "\r\n" 
					+ AccTool.getGridValue(driver, AccurateModule.PENYELESAIAN_BARANG_JADI, tab)
					+ "\r\n";
		
			AccTool.writeTextFile(fileName, content);
		}
		
		
		public static void saveIsiHeader(WebDriver driver, String fileName) {

			String tab = "";
			String content = "Penyelesaian Barang Jadi.SaveHeader : " + "\r\n";
			content = content

					+ "\r\n" 
					+ "Perintah Kerja : "
					+ AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_BARANG_JADI,"//div[contains(@data-bind,'workOrder().number')]")
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_BARANG_JADI, ElementType.DATEPICKER, "transDate", tab)
					+ "No. Batch : "
					+ AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_BARANG_JADI, ElementType.TEXTFIELD, "number", tab)
					+ "\r\n";
			
			AccTool.writeTextFile(fileName, content);
		}
		
	
		
		public static void saveListDetail(WebDriver driver, String fileName) {

			AccTool.click(driver, AccurateModule.PENYELESAIAN_BARANG_JADI.getXpath() + "//*[contains(@href,'tab-item')]");
			String tab = "//*[contains(@id,'tab-item')]";
			String content = "PenyelesaianBarangJadi.SaveListBarang: " + "\r\n";
			content = content 
				
					+ "\r\n" 
					+ AccTool.getGridValue(driver, AccurateModule.PENYELESAIAN_BARANG_JADI, tab)
					+ "\r\n";

			AccTool.writeTextFile(fileName, content);
		}
		
		public static void saveDetailBarang(WebDriver driver, String filename) {
		
			String tab = "";
			String tab2 ="";
			String content = "PenyelesaianBarangJadi.SaveDetail : " + "\r\n";

			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			content = content

					+ "\r\n" 
					+ "Nama Barang : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.detailName", tab)
					+ "Kuantitas : " 
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
					+ "Nilai Satuan : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: app.util.parseNumber(formData.standardCost())", tab) 
					+ "Total Harga : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: app.util.parseNumber(formData.totalStandardCost())", tab) 
					+ "Gudang : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
					+ "\r\n";
			
			tab2 = "//div[starts-with(@id,'tab-customfield')]";
			AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
			content = content
					+ "Catatan	: "
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "detailNotes", tab2) 
					+ "\r\n";

			AccTool.writeTextFile(filename, content);
		}
		
		public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
			log.info("PenyelesaianBarangJadi. SaveIsiDetailSerialNumber");

			String grid = "";
			String content = "Nomor Seri Barang : " + "\r\n";

			
			grid = "//div[contains(@id,'detail-item')]";
			content = content
					+ "\r\n" 
					+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
			AccTool.writeTextFile(filename, content);

		}
		
	
		public static void saveInformasiLainnya(WebDriver driver, String filename)
		{
			String tab = "";
			
			String content = "PenyelesaianBarangJadi.saveInformasiLainnya:" + "\r\n";
			content = content
					+ "\r\n"
					+ "Berlaku di Cabang :"
					+ AccTool.getTextValue(driver,ElementType.SUMMARY, "text: formData.branch().name", tab)
					+ "Keterangan : "
					+ AccTool.getTextValue(driver,AccurateModule.PENYELESAIAN_BARANG_JADI, ElementType.TEXTAREA, "description")
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
	
		}

}
