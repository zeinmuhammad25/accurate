package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.pengirimanpesanan.PengirimanPesananParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PengirimanPesananTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PengirimanPesananTool.class);
	
	public static void klikDetailItemBaris1(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-item')]//*[@class='grid-canvas']/div[1]");
	}
	
	public static void klikDetailItemBaris2(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-item')]//*[@class='grid-canvas']/div[2]");
	}
	public static void klikRincianDO1(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class = 'grid-canvas']/div[1]");
	}
	
	public static void klikRincianDO2(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class = 'grid-canvas']/div[2]");
	}
	
	public static void klikRincianDO3(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class = 'grid-canvas']/div[3]");
	}

	public static void klikRincianDO4(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class = 'grid-canvas']/div[4]");
	}
	
	public static void klikRincianDO5(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class = 'grid-canvas']/div[5]");
	}
	
	public static void klikAmbilPesanan(WebDriver driver, PengirimanPesananParam param) {
//		AccTool.dropDown(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Pesanan");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-order')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.PENGIRIMAN_PESANAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENGIRIMAN_PESANAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-sales-order')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pesanan']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-sales-order')]//input[@name='lookup']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-order')]", "@name='lookup'", param.search);
	}

	public static void klikambilFavorit(WebDriver driver, PengirimanPesananParam param) {
//		AccTool.dropDown(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Favorit");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.PENGIRIMAN_PESANAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENGIRIMAN_PESANAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-memorize-transaction')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Favorit']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-memorize-transaction')]//input[@name='lookup']"), 10);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
		
		
	}

	public static void klikambilPenawaran(WebDriver driver, PengirimanPesananParam param) {
//		AccTool.dropDown(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Penawaran");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-quotation')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.PENGIRIMAN_PESANAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENGIRIMAN_PESANAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-sales-quotation')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Penawaran']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-sales-quotation')]//input[@name='lookup']"), 10);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-quotation')]", "@name='lookup'", param.search);		
	}

	public static void klikAmbilFakturDimuka(WebDriver driver, PengirimanPesananParam param) {
//		AccTool.dropDown(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Faktur Dimuka");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-reverse-invoice')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.PENGIRIMAN_PESANAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENGIRIMAN_PESANAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-reverse-invoice')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Faktur Dimuka']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-reverse-invoice')]//input[@name='lookup']"), 10);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-reverse-invoice')]", "@name='lookup'", param.search);		
	}

	public static void klikLanjutItem(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 30);
		AccTool.waitLoadingMask(driver);
		AccTool.waitProgressBar(driver);
	}

	public static void klikLanjutItemSN(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		AccTool.waitLoaderMedium(driver);
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikLanjutDimuka(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'copy-reverse-invoice')]//*[@name='btnNext']");
	}

	public static void klikHapusItem(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[@name='btnDelete']");
	}

	public static void klikFaktur(WebDriver driver) {
		String w = AccurateModule.PENGIRIMAN_PESANAN.getXpath();
		AccTool.click(getWebDriver(), w + "//button[text() = 'Faktur']");
	}

	public static void klikLanjutTabPesanan(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'copy-sales-order')]//*[@name='btnNext']");
	}

	public static void klikLanjutTabPenawaran(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'copy-sales-quotation')]//*[@name='btnNext']");
	}

	public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver,
				AccurateModule.PENGIRIMAN_PESANAN.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}

	public static void klikLanjutTabFavorit(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'copy-memorize-transaction')]//*[@name='btnNext']");
	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void isiForm(WebDriver driver, PengirimanPesananParam param) {
		log.info("PengirimanPesanan.Isi");

		String w = AccurateModule.PENGIRIMAN_PESANAN.getXpath();

		if (param.kirimke != null) {
			AccTool.lookup(driver, w, "@name='customer'", param.kirimke);
			AccTool.waitProgressBar(driver);}	
		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if (param.pengiriman != null)
			AccTool.lookup(driver, w, "@name='shipment'", param.pengiriman);
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if (param.diskon != null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskon);
		if (param.matauang != null)
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
	}

	public static void isiDetailBarang(WebDriver driver, PengirimanPesananParam param) {
		log.info("PengirimanPesanan.IsiDetailBarang");

		String w = AccurateModule.PENGIRIMAN_PESANAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-item')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-item')]");
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}

	public static void isiInfoLain(WebDriver driver, PengirimanPesananParam param) {
		log.info("PengirimanPesanan.IsiInfoLain");

		String tab = AccurateModule.PENGIRIMAN_PESANAN.getXpath() + "//*[contains(@id,'tab-otherheader')]";
		AccTool.click(driver, tab);

		if (param.alamat != null)
			AccTool.textarea(driver, tab, "@name='toAddress'", param.alamat);
		if (param.nopo != null)
			AccTool.textField(driver, tab, "@name='poNumber'", param.nopo);
		if (param.fob != null)
			AccTool.lookup(driver, tab, "@name='fob'", param.fob);
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
	}

	public static void detailBarang(WebDriver driver, PengirimanPesananParam param) {
		log.info("PengirimanPesanan.DetailBarang");

		String tab = "";

		switch ((param.tab).toLowerCase()) {
		case "detail barang":
			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			if (param.nama != null)
				AccTool.textField(driver, tab, "@name='detailName'", param.nama);
			if (param.kuantitas != null)
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
			if (param.unit != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
			if (param.gudang != null)
				AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
			if (param.departemenmandatory != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if (param.proyekmandatory != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
			break;

		// case "no seri":
		// tab = "//div[starts-with(@id,'tab-serial-number')]";
		// AccTool.click(driver,"//a[contains(@href,'tab-serial-number')]");
		// AccTool.click(getWebDriver(),"//*[contains(@id,'tab-serial-number')]//button[@name='btnImportSn']");
		// AccTool.click(getWebDriver(),"//a[contains(@href,'')]//i[@class='icon-list']");
		// tab =
		// "//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]";
		// if(param.sn!=null)
		// AccTool.textField(driver, tab, "@name='textField'", param.sn);
		// if(param.jumlahsn!=null)
		// AccTool.numberField(driver, tab, "@name='consecutiveCount'",
		// param.jumlahsn);
		// AccTool.click(driver,
		// "//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]//*[@name='btnCreateSn']");
		// break;

		case "keterangan":
			tab = "//*[starts-with(@id,'tab-customfield')]";
//			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			//ui baru
			AccTool.click(driver, "	//*[contains(@id,'tabcustomfield')]");
			if (param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if (param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
			break;
		}
	}
	
	public static void isiNoSeri(WebDriver driver, PengirimanPesananParam param) {
		log.info("Pengiriman Barang. Isi No Seri");
		
		String tab =  "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
		
		if (param.jumlahsn != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.jumlahsn);
		if (param.sn != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.sn);
	}

	public static void saveheader(WebDriver driver, String filename) {
		log.info("save header");

		String tab = "";
		String content = "PengirimanPesanan.SaveHeader : " + "\r\n";
		content = content 
				+ "Kirim Ke : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.LOOKUP, "customer")
				+ "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.SUMMARY, "text: formData.currency().code", tab)
				+ "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.DATEPICKER, "transDate")
				+ "Pengiriman : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.LOOKUP, "shipment")
				+ "No Pengiriman : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.TEXTFIELD, "number")
				// + "Diskon : "
				// + AccTool.getTextValue(driver,
				// AccurateModule.PENGIRIMAN_PESANAN,
				// ElementType.NUMBERFIELD, "itemCashDiscount")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveInfoLain(WebDriver driver, String filename) {
		log.info("saveinfoLain");

		//String tab = "";
		String content = "PengirimanPesanan.SaveInfoLain : " + "\r\n";
		//tab = AccurateModule.PENGIRIMAN_PESANAN.getXpath() + "//*[contains(@id,'tab-otherheader')]";
		content = content 
				+ "Alamat : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.TEXTAREA, "toAddress")
				// + "Tanggal : " + AccTool.getTextValue(driver,
				// AccurateModule.PESANAN_PEMBELIAN, ElementType.DATEPICKER,
				// "shipDate")
				// + AccTool.getTextValue(driver,
				// AccurateModule.PENGIRIMAN_PESANAN,
				// ElementType.TEXTAREA, "toAddress")
				+ "No.PO : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.TEXTFIELD, "poNumber")
				+ "FOB : " + AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.LOOKUP, "fob")
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.TEXTAREA, "description");
				 String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		        if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.COMBOBOX, "branch");
		        } else {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.SUMMARY, "branchListOption");
		        }
                
		        content = content + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetail(WebDriver driver, String filename) {
		log.info("PengirimanPesanan.SaveDetail");

		String content = "PengirimanPesanan.SaveDetailBarang : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		
		content = content 
				+ "Nama : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
				+ "Unit : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
				+ "Gudang : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab); 
		
		        String namadept = "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]";
                if (WebElementTool.isElementExists(driver, By.xpath(namadept))) {
                content = content 
                + "Departemen : "
        		+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span");
                } else {
                content = content 
                + "Departemen : "
                + AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.department().name", tab);
                 }
                
                String namaproj = "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]";
                if (WebElementTool.isElementExists(driver, By.xpath(namaproj))) {
                    content = content 
            	+ "Proyek : "
            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span");
                } else {
                    content = content 
                + "Proyek : "
                + AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.project().name", tab);
                }
                
		// tab = "//div[starts-with(@id,'tab-serial-number')]";
		// AccTool.click(driver,"//a[contains(@href,'tab-serial-number')]");
		// content = content
		// + "Serial Number"
		// + "\r\n"
		// + "Serial Number :" + AccTool.getTextValue(driver,
		// ElementType.TEXTFIELD, "textField", tab)
		// + "Jumlah SN :" + AccTool.getTextValue(driver,
		// ElementType.NUMBERFIELD, "consecutiveCount", tab)
		// + "\r\n";

		tab = "//*[contains(@id,'tab-customfield')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
				
		String dept = "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
			content = content + "\r\n" + "Departemen : "
		        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span");
		}
		
		String proy = "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
			content = content + "Proyek : "
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span");
		}
		content = content 
				+ "Keterangan : " 
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveListDetailBarang(WebDriver driver, String filename) {
		log.info("PengirimanPesanan.SaveGridDetailBarang");

		String content = " PengirimanPesanan.SaveGridDetailBarang : " + "\r\n";
		String tab = "//*[contains(@id,'tab-item')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.PENGIRIMAN_PESANAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	public static void detailNoSeri(WebDriver driver, PengirimanPesananParam param) {
		log.info("PengirimanPesanan.DetailNOSERI");
		
		String tab =  "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
		if (param.sn != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.sn);
		
	}

	public static void klikTabNoSeri(WebDriver driver) {
		log.info("PengirimanPesanan.DetailNOSERI");
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");

	}
	
	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("PengirimanPesanan.SaveIsiDetailSerialNumber");

		String grid = "";
		String content = "Nomor Seri Detail Barang  : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";
		content = content
				+ "\r\n"
				+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	public static void klikTabInformasiPengiriman(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PENGIRIMAN_PESANAN.getXpath() +
				"//a[contains(@href, '#tab-summary')]");
	}
	
	public static void saveInformasiPengiriman(WebDriver driver, String filename){
		log.info("Save Informasi Pengiriman");
		String content = "PengirimanPesanan.saveInformasiPengiriman : " + "\r\n";

				String diProses= "//*[contains(@data-bind,'data.historyNumber')]";
				if (WebElementTool.isElementExists(driver, By.xpath(diProses))) {
				content = content 
						+ "Diproses Oleh : "
						+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'data.historyNumber')]").replace("\r\n", " , ")
						+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'data.historyDate')]");
				} else {
				content = content 
						+ "Diproses Oleh : "
						+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, ElementType.SPAN, "processHistory");
				}			
				
				content = content
				+ "Status : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, "//*[contains(@data-bind,'ShowTransactionHistoryStatus')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);		
	}
	
	public static void saveInformasiPengirimanPengepakan(WebDriver driver, String filename){
		log.info("Save Informasi Pengiriman Pengepakan");
		
		String iconInformasi = "//*[@class='icn-transaction-info']";
		if (WebElementTool.isElementVisible(driver, By.xpath(iconInformasi))) {
			AccTool.click(driver, "//*[@class='icn-transaction-info']");
		}
		
		String content = "PengirimanPesanan.saveInformasiPengirimanPengepakan : " + "\r\n";
		
		content = content//span[contains(@data-bind, 'text: formData.deliveryPackingNumber')]
				+ "Pengepakan Barang : "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "text: formData.deliveryPackingNumber", "")
//				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, "//*[contains(@id,'tab-summary')]//*[contains(@data-bind,'text: formData.deliveryPackingNumber')]")
				+ "Status : "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "text: formData.statusName", "")
//				+ AccTool.getTextValue(driver, AccurateModule.PENGIRIMAN_PESANAN, "//*[contains(@id,'tab-summary')]//*[contains(@data-bind,'text: formData.statusName()')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);		
	}
	
	public static void klikUbahGudang(WebDriver driver, PengirimanPesananParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PENGIRIMAN_PESANAN.getXpath(),
				"//div[contains(@class, 'span1')]/div[1]", "Ubah Gudang");

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id,'tab-set-warehouse')]//input[@name='warehouse']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'tab-set-warehouse')]", "@name='warehouse'", param.search);
	}
	
	public static void klikLanjutUbahGudang(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-set-warehouse')]//*[@name='btnSet']");
		AccTool.waitProgressBar(getWebDriver());

	}
}
