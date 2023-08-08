package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.perintahkerja.PerintahKerjaParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PerintahKerjaTool extends AbstractAccurateTestCase {
		static Logger log = LogManager.getLogger(PerintahKerjaTool.class);
		
		public static void klikHapusSatuan(WebDriver driver) {
			AccTool.clearLookup(getWebDriver(),"", "@name='itemUnit'");
		}
		
		
		public static void klikHapusRencana(WebDriver driver) {
			AccTool.clearLookup(getWebDriver(),"", "@name='manufactureOrderDetail'");
			WaitTool.delay(500);
		}
		
		public static void klikTambahBahanBaku(WebDriver driver, AccurateModule modul) {
			String path = modul.getXpath() + "//*[contains(@id,'tab-item')]//button[@name='btnAdd']";
			AccTool.click(driver, path);
		}
		
		public static void klikTambahBiaya(WebDriver driver, AccurateModule modul) {
			String path = modul.getXpath() + "//*[contains(@id,'tab-expense')]//button[@name='btnAdd']";
			AccTool.click(driver, path);
		}
		
		public static void klikTambahProdukLain(WebDriver driver, AccurateModule modul) {
			String path = modul.getXpath() + "//*[contains(@id,'tab-extra-finish-good')]//button[@name='btnAdd']";
			AccTool.click(driver, path);
		}
		
		public static void klikTabTahapan(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@href,'tab-process')]");
		}

		
		public static void klikTabBahanBaku(WebDriver driver){
			AccTool.click(driver, "//*[contains(@href,'tab-item')]");
		}
		
		public static void klikTabBiaya(WebDriver driver){
			AccTool.click(driver, "//*[contains(@href,'tab-expense')]");
		}
		
		public static void klikTabHasil(WebDriver driver){
			AccTool.click(driver, "//*[contains(@href,'tab-extra-finish-good')]");
		}
		
		public static void klikTabInfoLain(WebDriver driver){
			AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
		}
		
		public static void klikTabInfoLainModul(WebDriver driver){
			AccTool.click(driver, "//*[@id='module-accurate__fabrication__work-order']//*[contains(@href,'tab-otherheader')]");
		}
		
		
		public static void klikTabInformasiPerintah(WebDriver driver){
			AccTool.click(driver, "//*[contains(@href,'tab-summary')]");
		}
		
		public static void klikHapusBahanBaku(WebDriver driver) {
			
			String path = "//*[contains(@id,'detail-material')]//*[@name='btnDelete']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		

		public static void klikHapusBiaya(WebDriver driver) {
			
			String path = "//*[contains(@id,'detail-expense')]//*[@name='btnDelete']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		
		public static void klikHapusProdukLainnya(WebDriver driver) {
			AccTool.click(driver, "//*[contains(@id,'detail-extra-finish-good')]//*[@name='btnDelete']");
			AccTool.waitProgressBar(driver);
		}
		
		public static void klikHapusIsiTahapan(WebDriver driver, String keyword) {
			AccTool.clearLookup2(getWebDriver(), "@name='processCategory'", keyword);
		}

		public static void klikOKPopUpWarning(WebDriver driver) {
			
			String path = "//*[@name='btnOk']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		// konfirmasi tutup tab data saat ada data terisi
		public static void klikOKPadaWarningTutupTab(WebDriver driver) {
			AccTool.click(driver, "//*[contains(@id,'confirm-dialog')]//*[@name='btnOk']");
			WaitTool.delay(1000);
		}
		
		public static void klikTutupPopupDetailBarang(WebDriver driver) {
			String path = "//*[text()='Rincian Bahan Baku']/parent::*//*[@class='btn-close']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		}
		
		
		public static void klikTutupPopupDetailBiaya(WebDriver driver) {
			String path = "//*[text()='Rincian Biaya']/parent::div//*[@class='btn-close']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		}
		
		public static void klikTutupPopupDetailHasil(WebDriver driver) {
			String path = "//*[text()='Rincian Produk Lainnya']/parent::div//*[@class='btn-close']";
			AccTool.click(driver, path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		}

		public static void klikLanjutDetailBarang(WebDriver driver) {
			
			String path = "//*[contains(@id,'detail-material')]//*[@name='btnNext']";
			AccTool.click(driver, path);
			AccTool.waitProgressBar(getWebDriver());
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		//tanpa disappear
		public static void klikLanjutBarang(WebDriver driver) {
			
			String path = "//*[contains(@id,'detail-material')]//*[@name='btnNext']";
			AccTool.click(driver, path);
			AccTool.waitProgressBar(getWebDriver());
		}
		
		public static void klikLanjutBarang2(WebDriver driver) {
		
			String path = "//*[contains(@id,'detail-material')]//*[@name='btnNext']";
			AccTool.click(driver, path);
			AccTool.waitProgressBar(getWebDriver());
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		public static void klikLanjutBiaya(WebDriver driver) {
			AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[@name='btnNext']");
			AccTool.waitProgressBar(driver);
		}
		
		public static void klikLanjutHasil(WebDriver driver) {
			AccTool.click(driver, "//*[contains(@id,'detail-extra-finish-good')]//*[@name='btnNext']");
			AccTool.waitProgressBar(driver);
		}
		
		public static void klikRancanganFormulir(WebDriver driver){
			AccTool.click(driver, "//*[contains(@id,'btn-form-template--')]");
		}
		
		
		public static void klikLanjutTahapan(WebDriver driver) {
			
			String path = "//*[contains(@id,'detail-process')]//*[@name='btnNext']";
			AccTool.click(driver, path);
			AccTool.waitProgressBar(getWebDriver());
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
		}
		
		public static void klikTahapan(WebDriver driver, int index) {
			AccTool.click(driver, "//div[@class='work-order-process-container']/div/div["+ index+"]//div[@class='stages']");
			AccTool.waitProgressBar(driver);
		}
		
		public static void isiHeader (WebDriver driver, PerintahKerjaParam param){
			
			String tab = "";
			
			if(param.rencanaproduksi != null)
				AccTool.lookup(driver, tab, "@name='manufactureOrderDetail'", param.rencanaproduksi);
			if(param.kuantitas != null)
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
			if(param.no != null)
				AccTool.textField(driver, tab, "@name='number'", param.no);	
			if(param.tanggal != null)
				AccTool.datePicker(driver, tab, "@name='transDate'", param.tanggal);	
		
		}
		
		public static void isiHeader2 (WebDriver driver, PerintahKerjaParam param){
			
			String tab = "";
			String w = AccurateModule.PERINTAH_KERJA.getXpath();
			
			if(param.tipe != null)
			{
				switch (param.tipe.toLowerCase()) {
				
				case "rencana produksi":
					AccTool.combobox(driver, w, "@name='workOrderType'", "Rencana Produksi");
					WaitTool.delay(500);
					if(param.carirencana != null)
						AccTool.lookup(driver, w, "@name='manufactureOrderDetail'", param.carirencana);
					if(param.scrollrencana != null)
						AccTool.scrollRowDetail(driver, w, param.scrollrencana);	
					break;
					
				case "formula produksi":
					AccTool.combobox(driver, w, "@name='workOrderType'", "Formula Produksi");
					WaitTool.delay(500);
					if(param.cariformula != null)
						AccTool.lookup(driver, w, "@name='billOfMaterial'", param.cariformula);
					if(param.scrollformula != null)
						AccTool.scrollRowDetail(driver, w, param.scrollformula);
					break; 
					
				case "produk":
					AccTool.combobox(driver, w, "@name='workOrderType'", "Produk");
					if(param.searchitem != null)
						AccTool.lookup(driver, w, "@name='item'", param.searchitem);
					if(param.scroll != null)
						AccTool.scrollRowDetail(driver, w, param.scroll);
				
					break;
				}	
				
			if(param.kuantitas != null)
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
			if(param.satuan != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);
			if(param.no != null)
				AccTool.textField(driver, tab, "@name='number'", param.no);	
			if(param.tanggal != null)
				AccTool.datePicker(driver, tab, "@name='transDate'", param.tanggal);	
		
		}
		}
		
		
		public static void isiTahapan (WebDriver driver, PerintahKerjaParam param) {
			
			String tab = "//div[starts-with(@id,'tab-process')]";
			AccTool.click(driver, "//*[contains(@href,'tab-process')]");

			if (param.searchitem != null)
				AccTool.lookup(driver, tab, "@name='searchProcessCategory'", param.searchitem);
			AccTool.waitLoadingMask(driver);
			if (param.scroll != null)
				AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
		}
		
		public static void detailTahapan(WebDriver driver, PerintahKerjaParam param) {
			
			String tab = "//div[starts-with(@id,'detail-process')]";
			
			if (param.tahapan != null)
				AccTool.combobox(driver, tab, "@name='sortNumber'", param.tahapan);
			if (param.subkon != null)
				AccTool.checkbox(driver, tab, "@name='subcon'", param.subkon);
		
		}
		public static void isiInfoLain(WebDriver driver, PerintahKerjaParam param){
			
			String tab = "";
			
			if (param.tutup != null)
				AccTool.checkbox(driver, tab, "@name='manualClosed'", param.tutup);
			if(param.akunperintahkerja != null)
				AccTool.lookup(driver, tab, "@name='workAccount'", param.akunperintahkerja);
			if(param.akunselisih != null)
				AccTool.lookup(driver, tab, "@name='varianceAccount'", param.akunselisih);
			if (param.kualitasprodukkedua != null)
				AccTool.lookupWithoutClear(driver, tab, "@name='secondQulityProduct'", param.kualitasprodukkedua);
			if(param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='description'", param.keterangan);	
		
		}
		
	    public static void detailBahanBaku(WebDriver driver, PerintahKerjaParam param){
			
	    	String tab = "//div[starts-with(@id,'tab-item')]";
			AccTool.click(driver, "//*[contains(@href,'tab-item')]");

			if (param.searchitem != null)
				AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
			AccTool.waitLoadingMask(driver);
			if (param.scroll != null)
				AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
		
		}
	    
	    public static void detailBiaya(WebDriver driver, PerintahKerjaParam param){
				
		    	String tab = "//div[starts-with(@id,'tab-expense')]";
				AccTool.click(driver, "//*[contains(@href,'tab-expense')]");
	
				if (param.searchitem != null)
					AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
				AccTool.waitLoadingMask(driver);
				if (param.scroll != null)
					AccTool.scrollRowDetail(driver, tab, param.scroll);
				AccTool.waitLoadingMask(driver);
			
			}
	    
	    
	    public static void detailProdukLain(WebDriver driver, PerintahKerjaParam param){
			
	    	String tab = "//div[starts-with(@id,'tab-extra-finish-good')]";
			AccTool.click(driver, "//*[contains(@href,'tab-extra-finish-good')]");
	
			if (param.searchitem != null)
				AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
			AccTool.waitLoadingMask(driver);
			if (param.scroll != null)
				AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
		
		}
	    
		public static void isiBahanBaku(WebDriver driver, PerintahKerjaParam param) {
			
			String tab = "//div[starts-with(@id,'tab-detailitem')]";
			
			if (param.kuantitasdetail != null)
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitasdetail);
			if (param.satuandetail != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuandetail);
			if (param.tahapan != null)
				AccTool.lookup(driver, tab, "@name='processCategory'", param.tahapan);
		
		}
		
	    public static void isiKeteranganBahanbaku(WebDriver driver, PerintahKerjaParam param){
			
		String tab = "//*[contains(@id,'detail-material')]//*[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'detail-material')]//*[contains(@id,'tabcustomfield')]");
			
			if(param.keterangandetail != null)
				AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangandetail);
		
		}
	    
	    
		public static void isiBiaya(WebDriver driver, PerintahKerjaParam param) {
			
			String tab = "//div[starts-with(@id,'tab-detailitem')]";
			
			if (param.kuantitasdetail != null)
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitasdetail);
			if (param.satuandetail != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuandetail);
			if (param.tahapan != null)
				AccTool.lookup(driver, tab, "@name='processCategory'", param.tahapan);

		}
	    
	  public static void isiKeteranganBiaya(WebDriver driver, PerintahKerjaParam param)
			{
				
				String tab = "//*[starts-with(@id,'detail-expense')]//*[starts-with(@id,'tab-customfield')]";
//				AccTool.click(driver, "//div[starts-with(@id, 'detail-expense')]//a[contains(@href, 'tab-notes')]");
				//ui baru
				AccTool.click(driver, "//*[starts-with(@id,'detail-expense')]//a[starts-with(@id,'tabcustomfield')]");			

				if(param.keterangandetail != null)
					
					AccTool.textarea(driver, tab, "@name='expenseNotes'", param.keterangandetail);
			}
	    
	    
	  
	  public static void isiProdukLain(WebDriver driver, PerintahKerjaParam param) {
			
			String tab = "//div[starts-with(@id,'tab-detailitem')]";
		
			
			if (param.kuantitasdetail != null)
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitasdetail);
			if (param.satuandetail != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuandetail);
			if (param.porsi != null)
				AccTool.numberField(driver, tab, "@name='portion'", param.porsi);
		
		}
	    
		
		public static void isiKeteranganProdukLain(WebDriver driver, PerintahKerjaParam param)
		{
			
			String tab = "//*[starts-with(@id,'detail-extra-finish-good')]//*[starts-with(@id,'tab-customfield')]";
//			AccTool.click(driver, "//div[starts-with(@id, 'detail-extra-finish-good-')]//a[contains(@href, 'tab-notes')]");
			//ui baru
			AccTool.click(driver, "//*[starts-with(@id,'detail-extra-finish-good')]//*[starts-with(@id,'tabcustomfield')]");
			if(param.keterangandetail != null)
				
				AccTool.textarea(driver, tab, "@name='expenseNotes'", param.keterangandetail);
		}
	    
		
		public static void saveIsiPopup(WebDriver driver, String fileName) {
			
			String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
			String content = "Perintah Kerja.Warning : " + "\r\n";
			content = content
					+ "Notifikasi"
					+ "\r\n"
					+ AccTool.getTextValue(driver, 
							ElementType.REPORT, " ", tab)+ "\r\n";
				
			AccTool.writeTextFile(fileName, content);
		}
		
		public static void saveList(WebDriver driver, String fileName) {

			
			String tab = "//div[starts-with(@class,'module-list')]";
			String content = "Perintah Kerja.SaveList : " + "\r\n";
			content = content 
				
					+ "\r\n" 
					+ AccTool.getGridValue(driver, AccurateModule.PERINTAH_KERJA, tab)
					+ "\r\n";
		
			AccTool.writeTextFile(fileName, content);
		}
		
		
		public static void saveIsiHeader(WebDriver driver, String fileName) {
			WaitTool.delay(1000);
			String tab = "";
			String content = "Perintah Kerja.SaveHeader : " + "\r\n";
			content = content

					+ "\r\n" 
					+ "Tipe : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA,"//*[text()='Tipe']/parent::div/following-sibling::div//div[@class='text-panel-disabled']");
					
					String rencanaPro = "//span[contains(@data-bind,'detailName')]";
					if (WebElementTool.isElementVisible(driver, By.xpath(rencanaPro))) {
						content = content + "Produk : "			
								+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, "//span[contains(@data-bind,'detailName')]").replace("\r\n", ",")
								+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, "//div[contains(@data-bind,'item')]");
						
					} else {
						content = content + "Produk : "							
								+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, "//div[contains(@data-bind,'item')]");
					}
					
			content = content		
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Satuan : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.SUMMARY, "itemUnit",tab)
					+ "No. Batch : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.TEXTFIELD, "number", tab)
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.DATEPICKER, "transDate", tab)
					+ "\r\n";
			
			AccTool.writeTextFile(fileName, content);
		}
		
		//sebelumsimpan
		public static void saveIsiHeader2(WebDriver driver, String fileName) {

			String tab = "";
			String content = "Perintah Kerja.SaveHeader : " + "\r\n";
			content = content

					+ "\r\n" 
					+ "Tipe : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA,"//*[text()='Tipe']/parent::div/following-sibling::div//div[@class='text-panel-disabled']")
					+ "Produk : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.LOOKUP, "manufactureOrderDetail", tab)
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Satuan : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.TEXTFIELD, "itemUnit",tab)
					+ "No. Batch : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.TEXTFIELD, "number", tab)
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.DATEPICKER, "transDate", tab)
					+ "\r\n";
			
			AccTool.writeTextFile(fileName, content);
		}
		
		public static void saveIsiFooter(WebDriver driver, String fileName) {

			String tab ="//div[text()='Biaya']/following-sibling::div";
			String tab2 ="//div[text()='Bahan Baku']/following-sibling::div";
			String tab3 ="//div[text()='Total']/following-sibling::div";
			String tab4 ="//div[text()='Produk']/following-sibling::div";
			String tab5 ="//div[text()='Produk lainnya']/following-sibling::div";
			String content = "PerintahKerja.SaveFooter : " + "\r\n";
			content = content

					+ "\r\n" 
					+ "Total Biaya : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab)
					+ "Total Bahan Baku : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab2)
					+ "Total : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab3)
					+ "Total Produk  : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab4)
					+ "Total Produk Lainnya  : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab5)
					+ "\r\n";
			
			AccTool.writeTextFile(fileName, content);
		}
		
		public static void saveIsiFooterSelisih(WebDriver driver, String fileName) {

			String tab ="//div[text()='Biaya']/following-sibling::div";
			String tab2 ="//div[text()='Bahan Baku']/following-sibling::div";
			String tab3 ="//div[text()='Total']/following-sibling::div";
			String tab4 ="//div[text()='Produk']/following-sibling::div";
			String tab5 ="//div[text()='Produk lainnya']/following-sibling::div";
			String tab6 ="//div[text()='Selisih']/following-sibling::div";
			String content = "PerintahKerja.SaveFooter : " + "\r\n";
			content = content

					+ "\r\n" 
					+ "Total Biaya : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab)
					+ "Total Bahan Baku : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab2)
					+ "Total : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab3)
					+ "Total Produk  : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab4)
					+ "Total Produk Lainnya  : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab5)
					+ "Selisih  : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab6)
					+ "\r\n";
			
			AccTool.writeTextFile(fileName, content);
		}
		
		public static void saveListTahapan(WebDriver driver, String fileName) {

			AccTool.click(driver, AccurateModule.PERINTAH_KERJA.getXpath() + "//*[contains(@href,'tab-process')]");
			String tab = "//*[contains(@id,'tab-process')]";
			String content = "PerintahKerja.SaveTahapan : " + "\r\n";
			content = content 
				
					+ "\r\n" 
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab)
					+ "\r\n";

			AccTool.writeTextFile(fileName, content);
		}
		
		
		public static void saveListDetail(WebDriver driver, String fileName) {

			AccTool.click(driver, AccurateModule.PERINTAH_KERJA.getXpath() + "//*[contains(@href,'tab-item')]");
			String tab = "//*[contains(@id,'tab-item')]";
			String content = "PerintahKerja.SaveListBahanBaku : " + "\r\n";
			content = content 
				
					+ "\r\n" 
					+ AccTool.getGridValue(driver, AccurateModule.PERINTAH_KERJA, tab)
					+ "\r\n";

			AccTool.writeTextFile(fileName, content);
		}
		
		public static void saveDetailBahanBaku(WebDriver driver, String filename) {
		
			String tab = "";
			String tab2 ="";
			String content = "PerintahKerja.SaveDetail : " + "\r\n";

			tab = "//div[starts-with(@id,'detail-material')]//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//div[starts-with(@id,'detail-material')]//a[contains(@href,'tab-detailitem')]");
			content = content

					+ "\r\n" 
					+ "Nama Barang : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.item().name", tab)
					+ "Kuantitas : " 
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
					+ "Harga Standar : "
					+ AccTool.getTextValue(driver, ElementType.DATEPICKER, "standardCost", tab) 
					+ "Total Harga Standar : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "totalStandardCost", tab)
					+ "\r\n";
			
			tab2 = "//div[starts-with(@id,'tab-customfield')]";
			AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
			content = content
					+ "Catatan	: "
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "detailNotes", tab2) 
					+ "\r\n";

			AccTool.writeTextFile(filename, content);
		}
		
		public static void saveListDetailBiaya(WebDriver driver, String fileName) {

			AccTool.click(driver, AccurateModule.PERINTAH_KERJA.getXpath() + "//*[contains(@href,'tab-expense')]");
			String tab = "//*[contains(@id,'tab-expense')]";
			String content = "PerintahKerja.SaveListBiayaProduksi : " + "\r\n";
			content = content 
				
					+ "\r\n" 
					+ AccTool.getGridValue(driver, AccurateModule.PERINTAH_KERJA, tab)
					+ "\r\n";

			AccTool.writeTextFile(fileName, content);
		}
		
		
		public static void saveDetailBiaya(WebDriver driver, String filename) {
		
			String tab = "";
			String tab2 ="";
			String content = "PerintahKerja.SaveDetailBiaya : " + "\r\n";

			tab = "//div[starts-with(@id,'detail-expense')]";
			AccTool.click(driver, "//div[starts-with(@id,'detail-expense')]//a[contains(@href,'tab-detailitem')]");
			content = content

					+ "\r\n" 
					//Nama Biaya 
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'expenseName.title')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.item().name", tab)
					//Kuantitas
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'expenseQuantity.title')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
					//Satuan
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'expenseItemUnit.title')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
					//Harga Standar
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'expenseCost.title')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "standardCost", tab) 
					//Total Harga Standar
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'expenseTotalStandardCost.title')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "totalStandardCost", tab) 
					+ "\r\n";
			
			tab2 = "//div[starts-with(@id,'detail-expense')]//*[starts-with(@id,'tab-customfield')]";
			AccTool.click(driver, "//div[starts-with(@id,'detail-expense')]//a[contains(@href,'tab-customfield')]");
			content = content
					//Catatan
					+ AccTool.getTextValue(driver, "//div[starts-with(@id,'detail-expense')]//*[contains(@data-bind,'expenseNotes.title')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "expenseNotes", tab2) 
					+ "\r\n";
	
			AccTool.writeTextFile(filename, content);
		}
		
		public static void saveDetailBiaya2(WebDriver driver, String filename) {
			
			String tab = "";
			String tab2 ="";
			String content = "PerintahKerja.SaveDetailBiaya : " + "\r\n";

			tab = "//div[starts-with(@id,'detail-expense')]";
			AccTool.click(driver, "//div[starts-with(@id,'detail-expense')]//a[contains(@href,'tab-detailitem')]");
			content = content

					+ "\r\n" 
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab)
					
					+ "\r\n";
			
			tab2 = "//div[starts-with(@id,'detail-expense')]//*[starts-with(@id,'tab-customfield')]";
			AccTool.click(driver, "//div[starts-with(@id,'detail-expense')]//a[contains(@href,'tab-customfield')]");
			content = content
					+ "Catatan	: "
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "expenseNotes", tab2) 
					+ "\r\n";
	
			AccTool.writeTextFile(filename, content);
		}
		
		public static void saveListDetailHasil(WebDriver driver, String fileName) {

			AccTool.click(driver, AccurateModule.PERINTAH_KERJA.getXpath() + "//*[contains(@href,'tab-extra-finish-good')]");
			String tab = "//*[contains(@id,'tab-extra-finish-good')]";
			String content = "PerintahKerja.SaveListHasilSampingan : " + "\r\n";
			content = content 
				
					+ "\r\n" 
					+ AccTool.getGridValue(driver, AccurateModule.PERINTAH_KERJA, tab)
					+ "\r\n";

			AccTool.writeTextFile(fileName, content);
		}
		
		public static void saveDetailHasil(WebDriver driver, String filename) {
					
			String tab = "";
			String tab2 ="";
			String content = "PerintahKerja.SaveDetailHasil : " + "\r\n";

			tab = "//div[starts-with(@id,'detail-extra-finish-good')]";
			AccTool.click(driver, "//div[starts-with(@id,'detail-extra-finish-good')]//a[contains(@href,'tab-detailitem')]");
			content = content

					+ "\r\n" 
					+ "Nama Barang : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.item().name", tab)
					+ "Kuantitas : " 
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
					+ "Porsi : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "portion", tab)
					+ "Harga Standar : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "standardCost", tab) 
					+ "Total Harga Standar : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "totalStandardCost", tab) 
					+ "\r\n";
			
			tab2 = "//div[starts-with(@id,'detail-extra-finish-good')]//*[starts-with(@id,'tab-customfield')]";
			AccTool.click(driver, "//div[starts-with(@id,'detail-extra-finish-good')]//a[contains(@href,'tab-customfield')]");
			content = content
					+ "Catatan	: "
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "expenseNotes", tab2) 
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
		}
	/*	
		public static void saveInfoLainnya (WebDriver driver, String filename)
		{
			
			String content = "PerintahKerja.saveInfoLainnya :" + "\r\n";
		
			String tab = "//*[contains(@id,'tab-otherheader')]";
			content = content
					+ "\r\n"
					+ "Tutup Perintah Kerja :"
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.CHECKBOX, "manualClosed", tab)
					+ "Berlaku di Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, "//div[contains(@data-bind,'text: formData.branch()')]")
					+ "Akun Perintah Kerja : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.LOOKUP, "workAccount", tab)
					+ "Akun Selisih Biaya : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.LOOKUP, "varianceAccount", tab)
					+ "Keterangan : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.TEXTAREA, "description", tab)
					+ "\r\n";

			AccTool.writeTextFile(filename, content);
		}
	*/	
		public static void saveInfoLainnya (WebDriver driver, String filename)
		{
			
			String content = "PerintahKerja.saveInfoLainnya :" + "\r\n";
			String akunperintah = "//*[contains(@id,'tab-otherheader')]//*[contains(@name,'workAccount')]";
			String akunselisih = "//*[contains(@id,'tab-otherheader')]//*[contains(@name,'varianceAccount')]";	
			String tab = "//*[contains(@id,'tab-otherheader')]";
			
			String checkBox = "//input[@name='manualClosed']";
			if (WebElementTool.isElementExists(driver, By.xpath(checkBox))) {
				WebElement checkBoxElement = driver.findElement(By.xpath("//input[@name='manualClosed']"));
				boolean isSelected = checkBoxElement.isSelected();
				if(isSelected == false)
				{
					content = content + "\r\n" + "Tutup Perintah Kerja :" + "false" + "\r\n" ; 
				} else {
					content = content + "\r\n" + "Tutup Perintah Kerja :" + "true" + "\r\n" ; 
				}
				
			}
			else {
				content = content + "\r\n" + "Tutup Perintah Kerja :" + "false" + "\r\n" ; 
			}
			
			content = content
					+ "Berlaku di Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, "//div[contains(@data-bind,'text: formData.branch()')]");

					if(WebElementTool.isElementExists(driver, By.xpath(akunperintah)))
					{
						content = content + "Akun Perintah Kerja : " + AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.LOOKUP, "workAccount", tab) ;
					}
					else
					{
						content = content + "Akun Perintah Kerja: " + AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, "//div[contains(@data-bind,'text: formData.workAccount()')]") ;
					} 
					
					if(WebElementTool.isElementExists(driver, By.xpath(akunselisih)))
					{
						content = content + "Akun Selisih Biaya : " + AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.LOOKUP, "varianceAccount", tab) ;
					}
					else
					{
						content = content + "Akun Selisih Biaya: " + AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, "//div[contains(@data-bind,'text: formData.varianceAccount()')]") ;
					} 
			
			content = content
					+ "Kualitas Produk Kedua : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.LOOKUP, "secoundQulityProduct", tab)
					+ "Keterangan : "
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, ElementType.TEXTAREA, "description", tab)
					+ "\r\n";
			
			
			AccTool.writeTextFile(filename, content);
		}
		
		public static void saveInformasiPerintahKerja(WebDriver driver, String filename)
		{
			//ui baru flownya berubah
					
			AccTool.click(driver, "//a[contains(@href, 'tab-summary')]/i[@class='icn-transaction-info']");
			
			String content = "PerintahKerja.saveInformasiPerintahKerja:" + "\r\n";
			WaitTool.delay(1000);
			content = content
					+ "\r\n"
					+ "Status :"
					+ AccTool.getTextValue(driver,AccurateModule.PERINTAH_KERJA, "//span[contains(@data-bind,'text: formData.statusName()')]")
					+ "Progres : "
					+ AccTool.getTextValue(driver,AccurateModule.PERINTAH_KERJA, ElementType.SUMMARY, "formData.progress()")
					+ "Diproses Oleh : "
					+ "\r\n"		
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, "//div[contains(@data-bind, 'data.historyNumber')]")
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, "//div[contains(@data-bind, 'data.historyDate')]")
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
	
		}
		
		public static void saveTahapan(WebDriver driver, String fileName) {

			AccTool.click(driver, AccurateModule.PERINTAH_KERJA.getXpath() + "//*[contains(@href,'tab-process')]");
			String tab = "//*[contains(@id,'tab-process')]";
			String content = "PerintahKerja.saveTahapan : " + "\r\n";
			content = content 
				
					+ "\r\n" 
					+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_KERJA, tab)
					+ "\r\n";

			AccTool.writeTextFile(fileName, content);
		}
		

}
