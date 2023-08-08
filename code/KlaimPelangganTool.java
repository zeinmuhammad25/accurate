package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.klaimpelanggan.KlaimPelangganParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class KlaimPelangganTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(KlaimPelangganParam.class);

//	public static void pilihDetailItem(WebDriver driver, KlaimPelangganParam param)
//	{
//		AccTool.click(driver, "//*[contains(@id,'')]");
//		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-vendor-claim-grid-list')]//div[@class='grid-canvas']/div["+param.urutan+"]");
//	} 
	
	public static void klikButtonLanjutDetailBarang(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 5);
		AccTool.waitProgressBar(driver);
	}
		
	public static void klikbtnHapusItem()
	{
		AccTool.click(getWebDriver(), "//div[contains(@id,'detail-item')]//*[@name='btnDelete']");
	}
			
	public static void klikButtonLanjutTerimaBarang(WebDriver driver) {
		String xpath = "//div[contains(@id,'copy-customer-claim')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 3);
	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void isiHeader(WebDriver driver, KlaimPelangganParam param)
	{
		log.info("klaimPelanggan.Isi");
		String w = AccurateModule.KLAIM_PELANGGAN.getXpath();
		
		if(param.noklaim != null)
			AccTool.textField(driver, w, "@name='number'", param.noklaim);
		
		if(param.no != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.no);

		if(param.tanggal != null) {
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
			AccTool.waitProgressBar(driver);
		}
		
		if (param.pelanggan != null) {
			AccTool.lookup(driver, w, "@name='customer'", param.pelanggan);
			AccTool.waitProgressBar(driver);}
			
		if(param.tipeklaim == "Terima Barang"){
			AccTool.combobox(driver, w, "@name='customerClaimType'", param.tipeklaim);
		}else if (param.tipeklaim == "Kirim Barang"){
			AccTool.combobox(driver, w, "@name='customerClaimType'", param.tipeklaim);
			WaitTool.waitForElementClickable(getWebDriver(), By.xpath("//div[contains(@id, 'copy-customer-claim')]//input[@name='lookup']"), 10);
			if (param.search != null)
				AccTool.lookup(driver, "//div[contains(@id, 'copy-customer-claim')]", "@name='lookup'", param.search);
		}
		
	}
	
	public static void isiDetailBarang(WebDriver driver, KlaimPelangganParam param)
	{
		String tab = AccurateModule.KLAIM_PELANGGAN.getXpath() + "//*[contains(@id,'tab-item')]";	
		//WaitTool.waitForElementClickable(driver, By.xpath(tab + "//input[@name='searchDetailItem']"), 6);
		
		AccTool.click(driver, AccurateModule.KLAIM_PELANGGAN.getXpath() + "//a[contains(@href,'tab-item')]");
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void detailBarang(WebDriver driver, KlaimPelangganParam param)
	{
		String tab= "";
		
		switch((param.tab).toLowerCase()){
		case "detail barang":
			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			if(param.namabarang != null)
				AccTool.textField(driver, tab, "@name='detailName'", param.namabarang);					
			if(param.kuantitas != null) {
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
//				WaitTool.delay(500);
			}
			if(param.satuan != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);
			if(param.gudang != null)
				AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);				
			break;
			
		case "keterangan":
			tab = "//div[starts-with(@id,'tab-notes')]";			
			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			if(param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);			
			break;
		}
	}
	
	public static void detailNoSeri(WebDriver driver, KlaimPelangganParam param) {
		log.info("KlaimPelanggan.DetailNOSERI");
		
		String tab =  "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
		
		if (param.kuantitasnoseri != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.kuantitasnoseri);
		if (param.noseri != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.noseri);
		if (param.tglkadaluarsa != null)
			AccTool.numberField(driver, tab, "@name='expiredDateSn'", param.tglkadaluarsa);
	}
	
	public static void klikButtonLanjutTabDetailSerialNumber(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		
	}
		
	public static void isiInfoLain(WebDriver driver, KlaimPelangganParam param)
	{		
		if(param.alamatpelanggan != null)
			AccTool.textarea(driver, "", "@name='toAddress'", param.alamatpelanggan);	
		if(param.keterangan != null)
			AccTool.textarea(driver, "", "@name='description'", param.keterangan);	
		if (param.cabang != null)
			AccTool.combobox(driver, "", "@name='branch'", param.cabang);
		
	}
		
	public static void klikAmbilFavorit(WebDriver driver, KlaimPelangganParam param)
	{
		AccTool.dropDown(driver, AccurateModule.KLAIM_PELANGGAN.getXpath(), 
				"//div[@class='offset4 span8']/div[1]", "Favorit");
		if(param.tab != null)
			switch(param.tab.toLowerCase()){
			case "detail barang":
				String xpath = "//div[contains(@id,'copy-memorize-transaction')]//a[text()='Detail Barang']";
				AccTool.click(driver, xpath);
				if(param.search != null)
					AccTool.lookup(driver, "//div[contains(@id,'copy-memorize-transaction')]", "@name='lookup'", param.search);
				break;
			case "biaya lainnya":
				xpath = "//div[contains(@id,'copy-memorize-transaction')]//a[text()='Biaya Lainnya']";
				AccTool.click(driver, xpath);
				if(param.search != null)
					AccTool.lookup(driver, "//div[contains(@id,'copy-memorize-transaction')]", "@name='lookup'", param.search);
				break;
			}
	}
	
	public static void klikTabDetailBarang(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.KLAIM_PELANGGAN.getXpath() +
				"//a[contains(@href, '#tab-item')]");
	}
	
	public static void klikTabInfoLainnya(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.KLAIM_PELANGGAN.getXpath() +
				"//a[contains(@href, '#tab-otherheader')]");
	}
	
	public static void klikTabInformasiKlaim(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.KLAIM_PELANGGAN.getXpath() +
				"//a[contains(@href, '#tab-summary')]");
	}
		
	public static void saveDetailBarang(WebDriver driver, String filename)
	{
		log.info("KlaimPelanggan.SaveDetailBarang");
//		WaitTool.delay(1000);
		
		String tab = "";
		String content = "KlaimPelanggan.SaveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		
		//pastikan window detail barang Klaim Pelanggan sudah visible
		WaitTool.waitForElementVisible(driver, By.xpath(tab), 5);
		
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content
				+ "Nama Barang: " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
				+ "Satuan : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
				+ "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveKeteranganDetailBarang(WebDriver driver, String filename)
	{
		log.info("KlaimPelanggan.SaveDetailBarang");
		
		String tab = "//div[starts-with(@id,'tab-notes')]";
		String content = "KlaimPelanggan.SaveKeteranganDetailBarang : " + "\r\n";
		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		content = content
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
		
	public static void saveIsiHeader(WebDriver driver, String filename)
	{
//		AccTool.click(getWebDriver(), "//label[contains(@data-bind,'text: ft.vendor.title')]");
		log.info("KlaimPelanggan.SaveIsiHeader");
		
		String tab = "";
		String content = "KlaimPelanggan.SaveIsiHeader : " + "\r\n";
		content = content				
				+ "Tipe Klaim: " + AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN,"//div[@name='customerClaimType']")
				+ "Pelanggan : " + AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN, ElementType.LOOKUP, "customer", tab)
				+ "Nomor : " + AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN, ElementType.TEXTFIELD, "number", tab)
				+ "Tanggal : " + AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN, ElementType.DATEPICKER, "transDate", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiDetailBarang(WebDriver driver, String filename)
	{
		log.info("KlaimPelanggan.SaveIsiDetailBarang");
		
		String tab = "";
		String content = "KlaimPelanggan.SaveIsiDetailBarang : " + "\r\n";
		tab = "//*[contains(@id,'tab-item')]";
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.KLAIM_PELANGGAN, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
		
	public static void saveIsiInfoLain(WebDriver driver, String filename)
	{
		log.info("KlaimPelanggan.SaveIsiInfoLain");
		
		String tab = "";
		String content = "KlaimPelanggan.SaveIsiInfoLain : " + "\r\n";
		tab ="//*[contains(@id,'tab-otherheader')]";
		content = content
				+ "Alamat : " + AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN, ElementType.TEXTAREA, "toAddress");
				
				//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN, ElementType.SUMMARY, "branchListOption", tab);
				}
				
				content = content + "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN, ElementType.TEXTAREA, "description")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveIsiRingkasanKlaim(WebDriver driver, String filename)
	{
		log.info("KlaimPelanggan.SaveRingkasanKlaim");
		
		//String tab = "";
		String content = "KlaimPelanggan.SaveRingkasanKlaim : " + "\r\n";
		content = content
				+ "Penerimaan Barang : " + AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN, ElementType.SPAN, "text: formData.receiveHistory()()")
				+ "Status : " + AccTool.getTextValue(driver, AccurateModule.KLAIM_PELANGGAN, ElementType.SPAN, "text: formData.statusName()")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveList(WebDriver driver, String filename)
	{
		log.info("KlaimPelanggan.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "KlaimPelanggan.SaveList : " + "\r\n";
		
		content = content + AccTool.getGridValue(driver, AccurateModule.KLAIM_PELANGGAN, tab)+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListDetailBarang(WebDriver driver,String filename)
	{
		log.info("KlaimPelanggan.saveListDetailBarang");

	String content = "KlaimPelanggan.SaveListDetailBarang : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-item')]";
	content = content 
			+ AccTool.getGridValue(driver, AccurateModule.KLAIM_PELANGGAN,
					tab) + "\r\n";
	AccTool.writeTextFile(filename, content);
	}
	
	public static void klikButtonCloseTabDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void saveIsiPopup(WebDriver driver, String fileName)
	{
		log.info("Save isi popup ");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	String content = "KlaimPelanggan.Warning : " + "\r\n";
	content = content
			+ "Notifikasi"
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
	AccTool.writeTextFile(fileName, content);
	}
	
	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("KlaimPelanggan.SaveIsiDetailSerialNumber");

		String grid = "";
		String content = "Nomor Seri Detail Barang  : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";
		content = content
				+ "\r\n"
				+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	public static void klikTabSN(WebDriver driver){
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
	}
	
	public static void klikListBaris(WebDriver driver, int Urutan) {
		AccTool.click(getWebDriver(), "//div[contains(@id,'module-grid-list')]//div[@class='grid-canvas']/div["+ Urutan +"]");
		AccTool.waitLoadingMask(driver);
	}
}
