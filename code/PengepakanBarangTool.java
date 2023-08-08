package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pengepakanbarang.PengepakanBarangParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;


public class PengepakanBarangTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger( PengepakanBarangTool.class);

    public static void isiHeader(WebDriver driver, PengepakanBarangParam param){
	log.info("PengepakanBarang.IsiHeader");
	
	String w = AccurateModule.PENGEPAKAN_BARANG.getXpath();
	
	if(param.tglpengiriman != null) {
		AccTool.datePicker(driver, w, "@name='deliveryDate'", param.tglpengiriman);
	}
	if(param.penanggungjawab != null) {
		AccTool.lookup(driver, w, "@name='personInCharge'", param.penanggungjawab);
		AccTool.waitLoaderMedium(driver);
	}
	
	if(param.nopengepakan != null){
		AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.nopengepakan);
	}
    if(param.nomormanual != null){
	AccTool.textField(driver, w, "@name='number'", param.nomormanual);
    }
 }
    public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("PengepakanBarang.SaveIsiHeader");

		String tab = "";
		String content = "PengepakanBarang.SaveHeader : " + "\r\n";
		content = content 
		        + "Tgl Pengiriman : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGEPAKAN_BARANG,ElementType.DATEPICKER, "deliveryDate",tab)
				+ "Penanggung Jawab : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGEPAKAN_BARANG, ElementType.LOOKUP, "personInCharge",tab)
				+ "Nomor : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGEPAKAN_BARANG, ElementType.TEXTFIELD, "number",tab)
				+ "Tgl Dokumen : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGEPAKAN_BARANG, ElementType.SUMMARY, "text: formData.transDate",tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
   
    public static void klikAmbilFakturPenjualan(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-packing')]//*[@name='btnGetFromUnPack']");
		AccTool.click(getWebDriver(), "//a[text() = 'Faktur Penjualan']");
		AccTool.waitLoadingMask(getWebDriver());
	}
    
    public static void klikAmbilPengirimanPesanan(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-packing')]//*[@name='btnGetFromUnPack']");
		AccTool.click(getWebDriver(), "//a[text() = 'Pengiriman Pesanan']");
		AccTool.waitLoadingMask(getWebDriver());
	}
    
    public static void isiTglFilterListRincianSI(WebDriver driver, PengepakanBarangParam param){
    	log.info("PengepakanBarang.IsiTglFilterListRincian");
    	
    	String w = "//*[contains(@id,'accurate__customer__unpack-invoice-for-delivery-packing')]";
    	
    	if(param.filtertgldari != null) {
    		AccTool.datePicker(driver, w, "@name='filterFromDate'", param.filtertgldari);
    	}
    	AccTool.waitLoadingMask(getWebDriver());
    	if(param.filtertglsampai != null) {
    		AccTool.datePicker(driver, w, "@name='filterToDate'", param.filtertglsampai);
    	}
    	AccTool.waitLoadingMask(getWebDriver());
    }
    
    public static void isiTglFilterListRincianDO(WebDriver driver, PengepakanBarangParam param){
    	log.info("PengepakanBarang.IsiTglFilterListRincian");
    	
    	String w = "//*[contains(@id,'accurate__customer__unpack-delivery-for-delivery-packing')]";
    	
    	if(param.filtertgldari != null) {
    		AccTool.datePicker(driver, w, "@name='filterFromDate'", param.filtertgldari);
    	}
    	AccTool.waitLoadingMask(getWebDriver());
    	if(param.filtertglsampai != null) {
    		AccTool.datePicker(driver, w, "@name='filterToDate'", param.filtertglsampai);
    	}
    	AccTool.waitLoadingMask(getWebDriver());
    }
    
    public static void klikPilihListBaris1ItemSIDO(WebDriver driver, String value) {
		
		String xpath = "//*[contains(@id,'tab-copy-item')]//*[@class='grid-canvas']/div[1]";
		AccTool.click(getWebDriver(), xpath);
	}
    
    public static void klikPilihListBaris2ItemSIDO(WebDriver driver, String value) {
		
		String xpath = "//*[contains(@id,'tab-copy-item')]//*[@class='grid-canvas']/div[2]";
		AccTool.click(getWebDriver(), xpath);
	}
   
    public static void klikPilihListBaris3ItemSIDO(WebDriver driver, String value) {
	 	
		String xpath = "//*[contains(@id,'tab-copy-item')]//*[@class='grid-canvas']/div[3]";
		AccTool.click(getWebDriver(), xpath);
	}
    
    public static void klikPilihSemuaListSI(WebDriver driver) {
		
		String xpath = "//*[contains(@id,'accurate__customer__unpack-invoice-for-delivery-packing')]//*[@class='input-control checkbox no-margin']";
		AccTool.click(getWebDriver(), xpath);
	}
    
    public static void klikPilihSemuaListDO(WebDriver driver) {
		
		String xpath = "//*[contains(@id,'accurate__customer__unpack-delivery-for-delivery-packing')]//*[@class='input-control checkbox no-margin']";
		AccTool.click(getWebDriver(), xpath);
	}
    
    public static void klikButtonLanjutSI(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__customer__unpack-invoice-for-delivery-packing')]//*[@name='btnNext']");
        AccTool.waitProgressBar(getWebDriver());
	}
    
    public static void klikButtonLanjutDO(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__customer__unpack-delivery-for-delivery-packing')]//*[@name='btnNext']");
        AccTool.waitProgressBar(getWebDriver());
	}
    
    public static void klikButtonLanjutRincian(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-packing')]//*[@name='btnNext']");
		AccTool.waitLoaderMedium(getWebDriver());
	}
    
    public static void klikHapusItemPengepakan(WebDriver driver) {

  		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-packing')]//*[@name='btnDelete']");
          AccTool.waitLoaderMedium(getWebDriver());
  	}
    
    public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PENGEPAKAN_BARANG.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}
    
    public static void isiInfoLain(WebDriver driver, PengepakanBarangParam param) {
		log.info("PengepakanBarang.IsiInfoLain");

		String w = AccurateModule.PENGEPAKAN_BARANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		
		if (param.pengiriman != null)
			AccTool.lookup(driver, "", "@name='shipment'", param.pengiriman);		
		if (param.keterangan != null)
			AccTool.textarea(driver, "", "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
	}
    
    public static void saveDaftarDOSI(WebDriver driver, String filename) {
		log.info("PengepakanBarang.SaveDaftarDOSI");

		String grid = "";
		String content = "PengepakanBarang.SaveDaftarDOSI : " + "\r\n";
		grid = "//div[contains(@id, 'accurate__customer__unpack-invoice-for-delivery-packing')]";
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
    
    public static void saveListRincianDOSI(WebDriver driver, String filename) {
		log.info("PengepakanBarang.SaveListRincianDOSI");

		String grid = "";
		String content = "PengepakanBarang.SaveListRincianDOSI : " + "\r\n";
		grid = "//div[contains(@id, 'tab-packing')]";
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
    
    public static void saveRincianFaktur(WebDriver driver, String filename) {
		log.info("PengepakanBarang.SaveIsiRincianDO/Faktur");
		String tab = "";
		String content = "PengepakanBarang.SaveRincianDO/Faktur : " + "\r\n";
		content = content 
			    + "Pelanggan : "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.customerName",tab)
				+ "Alamat Pengiriman : "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.invoice().toAddress",tab)
				+ "Nomor DO/Faktur : "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.invoice().number",tab)
				+ "Tgl DO/Faktur : "
				+ AccTool.getTextValue(driver, ElementType.LABEL, "text: formData.invoice().transDate",tab)
				+ "\r\n";
			AccTool.writeTextFile(filename, content);
	}
    
    public static void saveRincianDO(WebDriver driver, String filename) {
		log.info("PengepakanBarang.SaveIsiRincianDO/Faktur");
		String tab = "";
		String content = "PengepakanBarang.SaveRincianDO/Faktur : " + "\r\n";
		content = content 
			    + "Pelanggan : "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.customerName",tab)
				+ "Alamat Pengiriman : "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.delivery().toAddress",tab)
				+ "Nomor DO/Faktur : "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.delivery().number",tab)
				+ "Tgl DO/Faktur : "
				+ AccTool.getTextValue(driver, ElementType.LABEL, "text: formData.delivery().transDate",tab)
				+ "\r\n";
			AccTool.writeTextFile(filename, content);
	}
    
    public static void saveInfolain(WebDriver driver, String filename) {
		String content = "PengepakanBarang.SaveInfoLain : " + "\r\n";
//		AccTool.click(driver, AccurateModule.PENGEPAKAN_BARANG.getXpath() + "//*[contains(@class,'acc-icon-other-info')]");
		//ui baru
		AccTool.click(driver, AccurateModule.PENGEPAKAN_BARANG.getXpath() + "//*[@class='icn-transaction-header']");
		String tab = "//*[contains(@id,'tab-otherheader')]";
		content = content 
			     + "Pengiriman : "
			     + AccTool.getTextValue(driver, AccurateModule.PENGEPAKAN_BARANG, ElementType.LOOKUP, "shipment",tab)
				 + "Keterangan	: " 
				 + AccTool.getTextValue(driver, AccurateModule.PENGEPAKAN_BARANG, ElementType.TEXTAREA, "description", tab); 
				 String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
					if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
						content = content 
								+ "Cabang : "
								+ AccTool.getTextValue(driver, AccurateModule.PENGEPAKAN_BARANG, ElementType.COMBOBOX, "branch", tab);
					} else {
						content = content 
								+ "Cabang : "
								+ AccTool.getTextValue(driver, AccurateModule.PENGEPAKAN_BARANG, ElementType.SUMMARY, "branchListOption", tab);
					}
					
		AccTool.writeTextFile(filename, content);
	}
    
    
    public static void klikKomentar(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, module.getXpath() + "//i[@id='btnCommentAttachment']");
		
		String komentar = "//span[.='Komentar']";
		if (WebElementTool.isElementVisible(driver, By.xpath(komentar))) {
			AccTool.click(driver, module.getXpath() + "//span[.='Komentar']");
		} else {
			AccTool.click(driver, module.getXpath() + "//span[.='Komentar *']");
		}
		
		
		
		
	}
    
    public static void isiKomentar(WebDriver driver,PengepakanBarangParam param)
	{
		log.info("PengepakanBarang.IsiKomentar");
		String a ="//*[contains(@id,'accurate__company__comment')]";

		if (param.komentar != null)				
	    AccTool.textarea(driver, a, "@name='comment'", param.komentar);	
	}
    
    public static void saveKomentar(WebDriver driver, String filename) {
		String content = "PengepakanBarang.SaveKomentar : " + "\r\n";
		content = content 
				 + "Komentar : " 
				 + AccTool.getTextValue(driver, AccurateModule.PENGEPAKAN_BARANG, "//*[contains(@id,'accurate__company__comment')]//*[@class='span12 comment-small-text']"); 
					
		AccTool.writeTextFile(filename, content);
	}
    
    public static void klikTutupKomentar(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//div[text()='Komentar transaksi']/preceding-sibling::*");
        WaitTool.waitForElementDisapear(driver, By.xpath("//div[text()='Komentar transaksi']/preceding-sibling::*"), 6);
	}

	public static void klikSaveKomentar(WebDriver driver) 
	{
		String path = "//*[contains(@id,'accurate__company__comment')]" + "//button[@name='btnSave']";
		AccTool.click(driver, path);
	}
	
	public static void klikLinkNoSIDO(WebDriver driver) 
	{
		AccTool.click(driver, "//*[contains(@id,'detail-packing')]//*[@class='text-panel-value-link']");
	}
}

