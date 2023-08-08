package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penerimaanbarang.PenerimaanBarangParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PenerimaanBarangTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(PenerimaanBarangParam.class);
	
	
	public static void klikUrutanGridPO(WebDriver driver, PenerimaanBarangParam param){
		AccTool.click(getWebDriver(), "//div[contains(@id, 'copy-purchase-order')]//div[contains(@id,'copy-item-grid')]//div[@class='grid-canvas']/div["+param.urutan+"]//span[@class='check  checkbox-grid']");
	}
	
	public static void klikUrutanGridREVPI(WebDriver driver, PenerimaanBarangParam param){
		AccTool.click(getWebDriver(), "//div[contains(@id, 'copy-reverse-invoice')]//div[contains(@id,'copy-item-grid')]//div[@class='grid-canvas']/div["+param.urutan+"]//span[@class='check  checkbox-grid']");
	}
	
	public static void klikRincianPenerimaan1(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[1]");
	}
	
	public static void klikRincianPenerimaan2(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[2]");
	}
	
	public static void klikRincianPenerimaan3(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[3]");
	}
	
	public static void klikRincianPenerimaan4(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[4]");
	}
	
	public static void klikRincianPenerimaan5(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[5]");
	}
	
	public static void klikRincianPenerimaan6(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[6]");
	}
	
	public static void klikRincianPenerimaan7(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[7]");
	}
	
	public static void klikRincianPenerimaan8(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[8]");
	}
	
	public static void klikRincianPenerimaan9(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[9]");
	}
	

	public static void klikProsesFaktur(WebDriver driver) {

		String w = AccurateModule.PENERIMAAN_BARANG.getXpath();
		AccTool.click(getWebDriver(), w + "//button[text() = 'Faktur']");
	}
	public static void klikBtnLanjutAmbilTagihanDimuka(WebDriver driver){
		String path = "//div[contains(@id,'copy-reverse-invoice')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(),  path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikBtnLanjutFavorit(WebDriver driver){
		String path = "//div[contains(@id,'accurate__company__save-memorize-transaction-dialog')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(),  path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		AccTool.click(driver, "//button[@name='btnOk' or text()='Ya']");
	}
	
	public static void klikBtnLanjutAmbilFavorit(WebDriver driver){
		String path = "//*[contains(@id,'copy-memorize-transaction')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnLanjutPenerimaan(WebDriver driver){
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
//		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		AccTool.waitLoaderMedium(driver);
	}
	
	public static void klikButtonLanjutTabDetailSerialNumber(WebDriver driver) {
		WaitTool.delay(100);
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
	}
	
	public static void klikOKPopUpWarning(WebDriver driver) {
		String path = "//*[@name='btnOk']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikHapusBarangPenerimaan(WebDriver driver){
		String path = "//div[contains(@id, 'detail-item')]//*[@name='btnDelete']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		
	}
	
	public static void klikBtnLanjutAmbilPesanan(WebDriver driver)
	{
		String path = "//div[contains(@id,'copy-purchase-order')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		
	}
	
	public static void klikTambahFavorit(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[@id='module-accurate__vendor__receive-item']//div[contains(@class,'tile half dropdown-toggle bg-green')]//div[contains(@class,'tile-content icon')]");
		AccTool.click(getWebDriver(), "//*[@id='module-accurate__vendor__receive-item']//*[contains(@class,'dropdown-menu')]//*[contains(text(),'Tambah ke Favorit')]");
		AccTool.click(getWebDriver(), "//div[contains(@id,'accurate__company__save-memorize-transaction-dialog')]//span[@class='check']");

	}
	
	public static void klikAmbilPesanan(WebDriver driver, PenerimaanBarangParam param)
	{
//		AccTool.dropDown(driver, AccurateModule.PENERIMAAN_BARANG.getXpath(), 
//				"//div[@class='offset4 span8']/div[1]", "Pesanan");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id,'copy-purchase-order')]", "@name='lookup'", param.search);
		

		//ui baru
		String w = AccurateModule.PENERIMAAN_BARANG.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENERIMAAN_BARANG.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-purchase-order')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pesanan']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-purchase-order')]//input[@name='lookup']"), 10);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-purchase-order')]", "@name='lookup'", param.search);
	}
	
	
	public static void klikAmbilTagihanDimuka(WebDriver driver, PenerimaanBarangParam param)
	{
//		AccTool.dropDown(driver, AccurateModule.PENERIMAAN_BARANG.getXpath(), 
//				"//div[@class='offset4 span8']/div[1]", "Tagihan Dimuka");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id,'copy-reverse-invoice')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.PENERIMAAN_BARANG.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENERIMAAN_BARANG.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-reverse-invoice')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Tagihan Dimuka']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-reverse-invoice')]//input[@name='lookup']"), 10);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-reverse-invoice')]", "@name='lookup'", param.search);
	}
	
	public static void klikAmbilFavorit(WebDriver driver, PenerimaanBarangParam param)
	{
//		AccTool.dropDown(driver, AccurateModule.PENERIMAAN_BARANG.getXpath(), 
//				"//div[@class='offset4 span8']/div[1]", "Favorit");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id,'copy-memorize-transaction')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.PENERIMAAN_BARANG.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENERIMAAN_BARANG.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-memorize-transaction')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Favorit']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-memorize-transaction')]//input[@name='lookup']"), 10);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
	}
	
	public static void klikSimpanLookup(WebDriver driver, PenerimaanBarangParam param)
	{
		log.info("PenerimaanBarang.SimpanLookup");
		
		String w = AccurateModule.PENERIMAAN_BARANG.getXpath();		
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		if (param.fob != null) {
			AccTool.lookup(driver, tab, "@name='fob'", param.fob);
			AccTool.click(driver, AccurateModule.PENERIMAAN_BARANG.getXpath() + "//li[@data-bind='click: saveItem']");
		}
		if (param.pengiriman != null) {
			AccTool.lookup(driver, tab, "@name='shipment'", param.pengiriman);
			AccTool.click(driver, AccurateModule.PENERIMAAN_BARANG.getXpath() + "//li[@data-bind='click: saveItem']");
		}
	}
	
	public static void klikFaktur(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PENERIMAAN_BARANG.getXpath() + "//*[contains(@id, 'btnProcess')]");
	}
	
	public static void klikTabDetailBarang(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PENERIMAAN_BARANG.getXpath() +
				"//a[contains(@href, '#tab-item')]");
	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTabSerialNumberBarang(WebDriver driver)
	{
		log.info("masuk sn");
		AccTool.click(driver, "//a[contains(@href, '#tab-serial-number')]");
	}
	
	public static void klikTabInfoLainnya(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PENERIMAAN_BARANG.getXpath() +
				"//a[contains(@href, '#tab-otherheader')]");
	}
	
	public static void klikTabInfoLainBarang(WebDriver driver)
	{
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
	}
	
	public static void klikBtnCetak(WebDriver driver){
		AccTool.click(driver, AccurateModule.PENERIMAAN_BARANG.getXpath() +
				"//i[contains(@class, 'icon-attachment')]"); 	
	}
	
	public static void isiSortingListTanggal(WebDriver driver, PenerimaanBarangParam param)
	{
		AccTool.click(getWebDriver(), "//*[@id='module-accurate__vendor__receive-item']//div[contains(@class,'filter-item button small no-margin active')]");
		
		if(param.radiobutton!=null)
			AccTool.radioButton(getWebDriver(), "//div[starts-with(@id,'module-accurate__vendor__receive-item')", "Tanggal", param.radiobutton);
		
	}
	
	public static void isiFavorit(WebDriver driver, PenerimaanBarangParam param)
	{
		log.info("PenerimaanBarang.IsiFavorit");
		
		String tab="//div[starts-with(@id,'accurate__company__save-memorize-transaction-dialog')]";
					
		if(param.favorit != null)
			AccTool.textField(driver, tab, "@name='name'", param.favorit);							
	}
		
	public static void detailBarang(WebDriver driver, PenerimaanBarangParam param)
	{
		String tab= "";
		if(param.tab != null)
		switch((param.tab).toLowerCase()){
		case "detail barang":
			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			if(param.nama != null)
				AccTool.textField(driver, tab, "@name='detailName'", param.nama);						
			if(param.unit != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
			if(param.kuantitas != null) {
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
				//AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.click(getWebDriver(),
						"//div[starts-with(@id, 'detail-item')]//label[@data-bind='text: ft.quantity.title']");
				WaitTool.delay(500);
			}
			if(param.gudang != null)
				AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);		
			if(param.departemenmandatory != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if(param.proyekmandatory != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);				
			break;
		case "keterangan":
			tab = "//*[starts-with(@id,'tab-customfield')]";			
//			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			//ui baru
			AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
			if(param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if(param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);	
			if(param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);			
			break;
		}
	}
	
	
	public static void detailBarang2(WebDriver driver, PenerimaanBarangParam param)
	{
		String tab= "";
		if(param.tab != null)
		switch((param.tab).toLowerCase()){
		case "detail barang":
			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			if(param.nama != null)
				AccTool.textField(driver, tab, "@name='detailName'", param.nama);						
			if(param.unit != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
			if(param.kuantitas != null) {
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
				//AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.click(getWebDriver(),
						"//div[starts-with(@id, 'detail-item')]//label[@data-bind='text: ft.quantity.title']");
				WaitTool.delay(500);
			}
			if(param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if(param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);				
			break;
		case "keterangan":
			tab = "//div[starts-with(@id,'tab-notes')]";			
//			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			//ui baru
			AccTool.click(driver, "//*[contains(@data-bind,'detailNotes')]/*[.='Info lainnya']");
			if(param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);			
			break;
		}
	}
	public static void isiForm(WebDriver driver, PenerimaanBarangParam param)
	{
		log.info("PenerimaanBarang.Isi");
		
		String w = AccurateModule.PENERIMAAN_BARANG.getXpath();			
		if(param.terimadari != null) {
			AccTool.lookup(driver, w, "@name='vendor'", param.terimadari);
			AccTool.waitProgressBar(driver);
			AccTool.waitProgressBar(driver);
		}
		if(param.tanggal != null) {
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
			AccTool.waitProgressBar(driver);
		}
		if(param.noterima != null)
			AccTool.textField(driver, w, "@name='receiveNumber'", param.noterima);			
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);	
		if(param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if(param.matauang != null)
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
	}
	
	public static void isiFormEdit(WebDriver driver, PenerimaanBarangParam param)
	{
		log.info("PenerimaanBarang.IsiEdit");
		
		String w = AccurateModule.PENERIMAAN_BARANG.getXpath();			
		if(param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if(param.noterima != null)
			AccTool.textField(driver, w, "@name='receiveNumber'", param.noterima);			
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);	
		if(param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
	}
	
	public static void isiDetailBarang(WebDriver driver, PenerimaanBarangParam param)
	{
		log.info("PenerimaanBarang.IsiDetailBarang");
		
		String w = AccurateModule.PENERIMAAN_BARANG.getXpath();	
		String tab = w + "//*[contains(@id,'tab-item')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-item')]");
		if(param.search != null)		
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void isiNoSeri(WebDriver driver, PenerimaanBarangParam param) {
		log.info("Penerimaan Barang. Isi No Seri");
		
		String tab =  "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
		
		if (param.jumlahsn != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.jumlahsn);
		if (param.sn != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.sn);
		if (param.tglkadaluarsa != null)
			AccTool.datePicker(driver, tab, "@name='expiredDateSn'", param.tglkadaluarsa);
	}
	
	public static void klikBtnNoSeriBerurutan(WebDriver driver, PenerimaanBarangParam param) {
		log.info("Penerimaan Barang. Isi No Seri Berurutan");
		
		AccTool.dropDown(driver, "//div[contains(@id, 'tab-serial-number')]", 
				"", " Nomor Seri berurutan");
	}
	
	public static void isiNoSeriBerurutan(WebDriver driver, PenerimaanBarangParam param) {
		log.info("Penerimaan Barang. Isi No Seri Berurutan");
		
		String tab =  "//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]";
		
		if (param.noseri != null)
			AccTool.textField(driver, tab, "@name='textField'", param.noseri);
		if (param.urut != null)
			AccTool.numberField(driver, tab, "@name='consecutiveCount'", param.urut);
		if (param.stok != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.stok);
		if (param.tglexpired != null)
			AccTool.datePicker(driver, tab, "@name='expiredDate'", param.tglexpired);
	}
	
	public static void klikBtnBuatIsiNoSeriBerurutan(WebDriver driver, PenerimaanBarangParam param) {
		String path = "//*[contains(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]//*[@name='btnCreateSn']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void isiInfoLain(WebDriver driver, PenerimaanBarangParam param)
	{
		log.info("PenerimaanBarang.IsiInfoLain");
		
		String w = AccurateModule.PENERIMAAN_BARANG.getXpath();		
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		if(param.tglpengiriman != null)
			AccTool.datePicker(driver, tab, "@name='shipDate'", param.tglpengiriman);
		if(param.pengiriman != null)
			AccTool.lookup(driver, tab, "@name='shipment'", param.pengiriman);
		if(param.syaratpembayaran != null)
			AccTool.lookup(driver, tab, "@name='paymentTerm'", param.syaratpembayaran);
		if(param.fob != null)
			AccTool.lookup(driver, tab, "@name='fob'", param.fob);
		if(param.alamat != null)
			AccTool.textarea(driver, tab, "@name='toAddress'", param.alamat);
		if(param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);	
		if(param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
	}
	
	public static void saveDetailNoSeriBerurutan(WebDriver driver,  String filename)
	{
		log.info("PenerimaanBarang.SaveDetailNoSeriBerurutan");
		
		String tab = "";
		String content = "Nomor Seri Berurutan  : " + "\r\n";

		tab = "//div[contains(@id, 'tab-serial-number')]";
		content = content
				+ "\r\n" 
				+ "No Seri/Produksi : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "textField", tab)
				+ "Diurutkan berulang sebanyak : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "consecutiveCount", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetail(WebDriver driver,  String filename)
	{
		log.info("PenerimaanBarang.SaveDetail");

		String content = "PenerimaanBarang.SaveDetail : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		AccTool.waitLoaderMedium(getWebDriver());

		content = content
				+ "\r\n" 
				+ "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
				+ "Unit : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
				+ "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
				+ "Departemen : "
	        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
            	+ "Proyek : "
            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span")
				+ "\r\n";
		//ui baru
		tab = "//*[starts-with(@id,'tab-customfield')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[starts-with(@id,'detail-item')]//*[starts-with(@id,'tabcustomfield')]");
		
		String dept = "//*[contains(@id,'details-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
			content = content + "Departemen :"
		        	+ AccTool.getTextValue(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span");
		}
		
		String proy = "//*[contains(@id,'details-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
			content = content+ "Proyek :"
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span");
		}
		
		content = content
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiHeader(WebDriver driver,  String filename)
	{
		//Mata Uang Untuk Simpan Sesudah Save Form
		log.info("PenerimaanBarang.SaveIsiHeader");
		String tab = "";
		String content = "PenerimaanBarang.SaveIsiHeader : " + "\r\n";
		content = content
				+ "\r\n" 
				+ "Terima Dari : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.LOOKUP, "vendor", tab)	
				+ "Mata Uang : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.SUMMARY, "text: formData.currency().code", tab)
				+ "Tanggal : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.DATEPICKER, "transDate", tab)
				+ "No Terima : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.TEXTFIELD, "receiveNumber", tab)
				+ "No Form # : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.TEXTFIELD, "number", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiInfoLain(WebDriver driver,  String filename)
	{
		log.info("PenerimaanBarang.SaveIsiInfoLain");
		String tab = "";
		String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		String content = "PenerimaanBarang.SaveIsi : " + "\r\n";
		tab = "//*[contains(@id,'tab-otherheader')]";
		content = content
				+ "Tanggal Kirim : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.DATEPICKER, "shipDate", tab)
				+ "Pengiriman : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.LOOKUP, "shipment", tab)
				+ "FOB : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.LOOKUP, "fob", tab)
				+ "Alamat : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.TEXTAREA, "toAddress", tab)
				+ "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.TEXTAREA, "description", tab);
				if(WebElementTool.isElementExists(driver, By.xpath(namacabang)))
				{
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.COMBOBOX, "branch", tab) + "\r\n";
				} else {
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_BARANG, ElementType.SUMMARY, "branchListOption", tab) + "\r\n";
				}
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveList(WebDriver driver,  String filename)
	{
		log.info("PenerimaanBarang.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "PenerimaanBarang.SaveList : " + "\r\n";
		
		content = content + AccTool.getGridValue(driver, AccurateModule.PENERIMAAN_BARANG, tab) + "\r\n";

		AccTool.writeTextFile(filename,  content);
	}

	public static void saveListDetailBarang(WebDriver driver,  String filename)
	{
		log.info("PenerimaanBarang.saveListDetailBarang");

	String content = "PenerimaanBarang.SaveListDetailBarang : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-item')]";
	content = content 
			+ "\r\n" 
			+ AccTool.getGridValue(driver, AccurateModule.PENERIMAAN_BARANG,
					tab) + "\r\n";
	AccTool.writeTextFile(filename, content);

	}
	
	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("Penerimaan Barang.SaveIsiDetailSerialNumber");

		String grid = "";
		String content = "Nomor Seri Detail Barang  : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";
		content = content
				+ "\r\n" 
				+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	public static void klikOKPopUpWarningSN(WebDriver driver) {
		String path = "//div[contains(@id, 'error-dialog')]//*[@name='btnOk']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void saveNotifNoseri(WebDriver driver, String fileName)
	{
		log.info("PenerimaanBarang.SaveNotifNoSeri");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
	String content = "PenerimaanBarang.SaveNotifNoSeri : " + "\r\n";
	content = content
			+ "\r\n"
			+ AccTool.getTextValue(driver, ElementType.REPORT, " ", tab)+ "\r\n";
		
        AccTool.writeTextFile(fileName, content);
     }
	
	public static void saveIsiPopup(WebDriver driver, String fileName)
	{
		log.info("Save Isi Popup Nomer Seri ");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	String content = "Penerimaan Barang.Warning : " + "\r\n";
	content = content
			+ "Notifikasi"
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
	AccTool.writeTextFile(fileName, content);
	}
}
