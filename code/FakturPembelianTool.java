package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpembelian.FakturPembelianParam;
import com.cpssoft.web.test.accurate.pesananpembelian.PesananPembelianParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class FakturPembelianTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(FakturPembelianParam.class);
	
	public static void klikRincianFaktur1(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[1]");
	}
	
	public static void klikRincianFaktur2(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[2]");
	}
	
	public static void klikRincianFaktur3(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[3]");
	}
	
	public static void klikRincianFaktur4(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[4]");
	}
	
	public static void klikRincianFaktur5(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[5]");
	}
	
	public static void klikRincianFaktur6(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[6]");
	}
	
	public static void klikRincianFaktur7(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[7]");
	}
	
	public static void klikRincianFaktur8(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[8]");
	}
	
	public static void klikRincianFaktur9(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[9]");
	}
	
	public static void klikRincianFakturBarisAkhir(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[last()]");
	}
	
	public static void klikBebanFaktur1(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-expense')]//div[@class='grid-canvas']/div[1]");
	}
	
	public static void klikBebanFaktur2(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-expense')]//div[@class='grid-canvas']/div[2]");
	}
	
	public static void klikBebanFaktur3(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-expense')]//div[@class='grid-canvas']/div[3]");
	}
	
	public static void klikDPfaktur1(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-down-payment-grid-list')]//div[@class='grid-canvas']/div[1]");
	}
	
	public static void klikDPfaktur2(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-down-payment-grid-list')]//div[@class='grid-canvas']/div[2]");
	}
	
	public static void klikDPfaktur3(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-down-payment-grid-list')]//div[@class='grid-canvas']/div[3]");
	}
	
	public static void klikBtnCalculate(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='unitPrice']]//*[@class='btn-calculate']");
		WaitTool.waitForElementDisapear(driver, By.xpath("//img[contains(@src, 'loader-medium.gif')]"), 10);
	}
	
	public static void klikBtnLanjutUangMuka(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-down-payment')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnLanjutFakturPembelian(WebDriver driver)
	{
		String path = "//div[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikButtonLanjutTabDetailSerialNumber(WebDriver driver) {
		WaitTool.delay(100);
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
	}
	
	public static void klikbtnHapusItemFakturPembelian(WebDriver driver)
	{
		String path = "//div[contains(@id,'detail-item')]//*[@name='btnDelete']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnLanjutAmbilPesanan(WebDriver driver)
	{
		String path = "//div[contains(@id,'copy-purchase-order')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnLanjutAmbilPenerimaan(WebDriver driver)
	{
		String path = "//div[contains(@id,'copy-receive-item')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnLanjutBiayaPembelian(WebDriver driver)
	{
		String path = "//div[contains(@id,'detail-expense')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnLanjutBiayaPembelianPemasok(WebDriver driver)
	{
		String path = "//div[contains(@id,'copy-expense-bill')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnHapusDPFaktur(WebDriver driver)
	{
		String path = "//div[contains(@id,'detail-down-payment')]//*[@name='btnDelete']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTransaksiBerulang(WebDriver driver){
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@class='icon-briefcase-2']");
		AccTool.click(getWebDriver(), w + "//*[text()='Transaksi Berulang']");
	}
	
	public static void pilihDetailBiaya(WebDriver driver, FakturPembelianParam param)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-expense-grid-list')]//div[@class='grid-canvas']/div["+param.urutan+"]");
	} 
	
	public static void klikAmbilPesanan(WebDriver driver, FakturPembelianParam param)
	{
//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN.getXpath(), 
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Pesanan");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-purchase-order')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PEMBELIAN.getXpath()
			+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-purchase-order')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pesanan']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
			By.xpath("//div[contains(@id, 'copy-purchase-order')]//input[@name='lookup']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-purchase-order')]", "@name='lookup'", param.search);
	}
	
	public static void klikAmbilUangMuka(WebDriver driver)
	{
//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN.getXpath(), 
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Pesanan");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-purchase-order')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PEMBELIAN.getXpath()
			+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-purchase-order')]"), 3);
		AccTool.click(getWebDriver(), w + "//ul[contains(@class,'dropdown-menu')]//a[text() = 'Uang Muka']");
		
		AccTool.click(getWebDriver(), "//div[contains(@id, 'accurate__vendor__down-payment-for-invoice')]//button");
	}
	
	public static void klikAmbilPesananKosong(WebDriver driver, FakturPembelianParam param)
	{
//		AccTool.dropDown(driver, AccurateModule.FAKTUR_PEMBELIAN.getXpath(), 
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Pesanan");
//		if(param.search != null)
//			AccTool.lookupWithoutClear(driver, "//div[contains(@id, 'copy-purchase-order')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PEMBELIAN.getXpath()
			+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-purchase-order')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pesanan']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
			By.xpath("//div[contains(@id, 'copy-purchase-order')]//input[@name='lookup']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-purchase-order')]", "@name='lookup'", param.search);
		WaitTool.delay(500);
	}
	
	public static void klikAmbilPenerimaan(WebDriver driver, FakturPembelianParam param)
	{
//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN.getXpath(), 
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Penerimaan");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-receive-item')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PEMBELIAN.getXpath()
			+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-receive-item')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Penerimaan']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
			By.xpath("//div[contains(@id, 'copy-receive-item')]//input[@name='lookup']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-receive-item')]", "@name='lookup'", param.search);
	}
	
	public static void klikAmbilBiayaPembelian(WebDriver driver, FakturPembelianParam param)
	{
//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN.getXpath(), 
//				"//div[contains(@class, 'offset4 span8')]/div[1]", " Pembelian");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-expense-bill')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PEMBELIAN.getXpath()
			+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-expense-bill')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Biaya Pembelian']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
			By.xpath("//div[contains(@id, 'copy-expense-bill')]//input[@name='lookup']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-expense-bill')]", "@name='lookup'", param.search);
	}
	
	public static void klikAmbilFavorit(WebDriver driver, FakturPembelianParam param)
	{
//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN.getXpath(), 
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Favorit");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name=''", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PEMBELIAN.getXpath()
			+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-memorize-transaction')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Favorit']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
			By.xpath("//div[contains(@id, 'copy-memorize-transaction')]//input[@name='lookup']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
	}
	
	public static void klikLanjutTabFavorit(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'copy-memorize-transaction')]//*[@name='btnNext']");
	}
	
	public static void klikProsesPembayaran(WebDriver driver)
	{
//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PEMBELIAN.getXpath(), 
//				"//div[@class='offset4 span8']/div[2]", "Pembayaran");
		AccTool.click(getWebDriver(), "//*[@name='btnProcess']");
		AccTool.click(getWebDriver(), "//a[text() = 'Pembayaran']");
	
	}
	
	public static void klikTabDetailBarang(WebDriver driver)
	{
		WaitTool.waitForElementClickable(driver, By.xpath("//a[contains(@href,'tab-item')]"), 1);
		AccTool.click(driver, AccurateModule.FAKTUR_PEMBELIAN.getXpath() +
				"//a[contains(@href,'tab-item')]");
	}
	
	public static void klikTabInfoLainBarang(WebDriver driver)
	{
	
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
	}
	
	public static void klikTabInfoLainBiaya(WebDriver driver)
	{
	
//		AccTool.click(driver, "//a[contains(@href,'tab-customfieldexpense')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[contains(@id,'tabcustomfield')]");
	}
	
	public static void klikTabInfoLainnya(WebDriver driver)
	{
//		AccTool.click(driver, AccurateModule.FAKTUR_PEMBELIAN.getXpath() +
//				"//a[contains(@href, '#tab-otherheader')]/*[@class='acc-icon-other-info']");
		//ui baru
		AccTool.click(driver, AccurateModule.FAKTUR_PEMBELIAN.getXpath() +
				"//*[contains(@class,'icn-transaction-header')]");
	}
	
	public static void klikTabBiayaLainnya(WebDriver driver)
	{
//		AccTool.click(driver, AccurateModule.FAKTUR_PEMBELIAN.getXpath() +
//				"//a[contains(@href, '#tab-expense')]/*[@class='acc-icon-expense']");
		//ui baru
		AccTool.click(driver, AccurateModule.FAKTUR_PEMBELIAN.getXpath() +
				"//i[@class='icn-transaction-expense']");
	}
	
	public static void klikTabInformasiPesanan(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.FAKTUR_PEMBELIAN.getXpath() +
				"//a[contains(@href, '#tab-summary')]");
	}
	
	public static void klikTabUangMuka(WebDriver driver){
//		AccTool.click(getWebDriver(), "//div[@class='trans-detail position-left tab-control']//a[contains(@href,'#tab-downpayment')]/*[@class='acc-icon-downpayment']");
		//ui baru
		AccTool.click(getWebDriver(), "//div[@class='trans-detail position-left tab-control']//a[contains(@href,'#tab-downpayment')]/*[@class='icn-transaction-down-payment']");
	}
	
	public static void klikTabSerialNumberBarang(WebDriver driver)
	{
		AccTool.click(driver, "//a[contains(@href, '#tab-serial-number')]");
	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void detailBarang(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.DetailBarang");
		
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
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
			}
			
			if(param.harga != null) {
				AccTool.numberField(driver, tab, "@name='unitPrice'", param.harga);
//				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
			}
			if(param.diskonpersen != null) {
				AccTool.numberField(driver, tab, "@name='itemDiscPercent'", param.diskonpersen);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
			}	
			if(param.diskon != null) {
				AccTool.numberField(driver, tab, "@name='itemCashDiscount'", param.diskon);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
			}
			
			if(param.pajak1 != null)
				AccTool.checkbox(driver, tab, "@name='useTax1'", param.pajak1);
			if(param.pajak2 != null)
				AccTool.checkbox(driver, tab, "@name='useTax2'", param.pajak2);
			if(param.gudang != null)
				AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);			
			if(param.departemenmandatory != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if(param.proyekmandatory != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);				
			break;
			
		case "no seri":
			tab = "//div[starts-with(@id,'tab-serial-number')]";
			
			AccTool.click(driver,"//a[contains(@href,'tab-serial-number')]");
			AccTool.click(getWebDriver(),"//*[contains(@id,'tab-serial-number')]//button[@name='btnImportSn']");
			WaitTool.delay(500);
			AccTool.click(getWebDriver(),"//a[contains(@href,'')]//i[@class='icon-list']");
			tab = "//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]";
			if(param.sn!=null)
			AccTool.textField(driver, tab, "@name='textField'", param.sn);
			if(param.jumlahsn!=null)
			AccTool.numberField(driver, tab, "@name='consecutiveCount'", param.jumlahsn);
			AccTool.click(driver, "//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]//*[@name='btnCreateSn']");
			break;
			
		case "keterangan":
			tab = "//*[starts-with(@id,'tab-customfield')]";			
			
//			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			//ui baru
			AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[contains(@id,'tabcustomfield')]");
			if(param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if(param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);		
			if(param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);			
			break;
		}
	}
	
	public static void detailBiayaLainnya(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.DetailBiayaLainnya");

		String tab= "";
		if(param.tab != null)
		switch((param.tab).toLowerCase()){
		
		case "biaya lain":
			tab = "//div[starts-with(@id,'tab-detailexpense')]";
			AccTool.click(driver, "//*[contains(@id,'tabdetailexpense')]");			
			if(param.nama != null)
				AccTool.textField(driver, tab, "@name='expenseName'", param.nama);	
			if(param.alokasi != null)
				AccTool.checkbox(driver, tab, "@name='allocateToItemCost'", param.alokasi);
			if(param.tagihanpemasok != null)
				AccTool.lookup(driver, tab, "@name='chargedVendor'", param.tagihanpemasok);
			if(param.kurstagihanpemasok != null)
				AccTool.combobox(driver, tab, "@name='expenseCurrency'", param.kurstagihanpemasok);
			if(param.jumlah != null)
				AccTool.numberField(driver, tab, "@name='amountCurrency'", param.jumlah);	
			if(param.departemenmandatory != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if(param.proyekmandatory != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);				
			break;
			
		case "keterangan":
			tab = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]";			
//			AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
			//ui baru
			AccTool.click(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tabcustomfield')]");
			if(param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if(param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);	
			if(param.keterangan != null)
				AccTool.textarea(driver, "", "@name='expenseNotes'", param.keterangan);			
			break;
		}
	}
	
	public static void detailUangMuka(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.DetailUangMuka");
		String tab= "//div[starts-with(@id,'tab-detaildownpayment')]";
		if(param.jumlah != null) {
			AccTool.numberField(driver, tab, "@name='paymentAmount'", param.jumlah);
			AccTool.click(getWebDriver(), tab + "//label[@data-bind='text: ft.dpAmount.title']");
//			WaitTool.delay(500);
		}
	}
	
	public static void isiForm(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.IsiForm");
		
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		if(param.pemasok != null) {
			AccTool.lookup(driver, w, "@name='vendor'", param.pemasok);
			AccTool.waitProgressBar(driver);
			AccTool.waitProgressBar(driver);
		}
		if(param.matauang != null) {
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
			AccTool.waitProgressBar(driver);
		}
		if(param.tanggal != null) {
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
			AccTool.waitProgressBar(driver);
		}
		if (param.kursritel != null) {
			AccTool.numberField(driver, w, "@name='rate'", param.kursritel);
			AccTool.click(getWebDriver(), w + "//label[@data-bind='text: ft.transDate.title']");
//			WaitTool.delay(300);
			WaitTool.waitForElementClickable(driver, By.xpath(w), 1);
		}
		
		if (param.kurspajak != null) {
			AccTool.numberField(driver, w, "@name='fiscalRate'", param.kurspajak);
			AccTool.click(getWebDriver(), w + "//label[@data-bind='text: ft.transDate.title']");
//			WaitTool.delay(300);
			WaitTool.waitForElementClickable(driver, By.xpath(w), 1);
		}
		
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if(param.noform != null)
			AccTool.textField(driver, w, "@name='number'", param.noform);
		//dikarenakan pada ui baru nofaktur di isi pada infolainnya
//		if(param.nofaktur != null)
//			AccTool.textField(driver, w, "@name='billNumber'", param.nofaktur);	
		if (param.diskonbawah!=null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskonbawah);
	}	
	
	public static void isiDiskonBawahPersen(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.IsiDiskonBawahPersen");
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		
		if (param.diskonbawah!=null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskonbawah);
		if (param.diskonbawahpersen!=null) 
			AccTool.click(getWebDriver(), "//div[contains(@id,'module-accurate__vendor__purchase-invoice')]//*[@name='btnDiscPercent']");
			AccTool.textField(driver,"//*[@class='mask-wrapper']", "@name='discountPercent'", param.diskonbawahpersen);
			NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'accurate__input-percentage')]");
	}
	
	public static void isiDiskonBawah(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.IsiDiskonBawah");
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		
		if (param.diskonbawah!=null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskonbawah);
		
		AccTool.waitProgressBar(getWebDriver());
		
	}
	
	public static void isiBiayaLain(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.isiBiayaLain");
		
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-expense')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-expense')]");
		if(param.search != null)	
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void isiDetailBarang(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.IsiDetailBarang");
		
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-item')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-item')]");
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void isiInfoLain(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.IsiInfoLain");

		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
     	String tab = w + "//*[contains(@id,'tab-otherheader')]";
    	
		AccTool.click(driver, w + "//*[contains(@href,'tab-otherheader')]");
		if(param.nofaktur != null)
			AccTool.textField(driver, w, "@name='billNumber'", param.nofaktur);	
		if (param.fakturdimuka != null)
			AccTool.checkbox(driver, tab, "@name='reverseInvoiceCheck'", param.fakturdimuka);
		
		if(param.kenapajak != null) {
			AccTool.checkbox(driver, tab, "@name='taxable'", param.kenapajak);
			AccTool.waitProgressBar(driver);
		}
		if(param.totaltermasukpajak != null) {
			AccTool.checkbox(driver, tab, "contains(@data-bind,'inclusiveTax')", param.totaltermasukpajak);
			AccTool.waitProgressBar(driver);
		}
		if (param.tipepajak != null)
			AccTool.combobox(driver, tab, "@name='vendorTaxType'", param.tipepajak);
		if(param.syaratpembayaran != null)
			AccTool.lookup(driver, tab, "@name='paymentTerm'", param.syaratpembayaran);
		
		if(param.tglpengiriman != null){
			WebElement element = driver.findElement(By.xpath("//input[@name='fob']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
			AccTool.moveToElementAndClick(getWebDriver(), "//input[@name='fob']");
			AccTool.datePicker(driver, tab, "@name='shipDate'", param.tglpengiriman);
		}
		if(param.pengiriman != null)
			AccTool.lookup(driver, tab, "@name='shipment'", param.pengiriman);
		if(param.fob != null)
			AccTool.lookup(driver, tab, "@name='fob'", param.fob);
		if(param.tglpajak != null) {
			WebElement element = driver.findElement(By.xpath("//select[@name='branch']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
            AccTool.datePicker(driver, tab, "@name='taxDate'", param.tglpajak);
		}
			
		if(param.nopajak != null)
			AccTool.textField(driver, tab, "@name='taxNumber'", param.nopajak);
		if(param.alamat != null)
			AccTool.textarea(driver, tab, "@name='toAddress'", param.alamat);
		if(param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if(param.akunhutang != null)
			AccTool.lookup(driver, tab, "@name='apAccount'", param.akunhutang);
		if(param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
		
		
		
	}
	
	public static void isiUangMuka(WebDriver driver, FakturPembelianParam param)
	{
		log.info("FakturPembelian.IsiUangMuka");
		
		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-downpayment')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-downpayment')]");
		if(param.search != null)		
			AccTool.lookup(driver, tab, "@name='searchDownPayment'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void isiNoSeri(WebDriver driver, FakturPembelianParam param) {
		log.info("Faktur Pembelian. Isi No Seri");
		
		String tab =  "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
		
		if (param.jumlahsn != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.jumlahsn);
		if (param.sn != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.sn);
		if (param.tglkadaluarsa != null)
			AccTool.datePicker(driver, tab, "@name='expiredDateSn'", param.tglkadaluarsa);
	}
	
	public static void saveDetailBarang(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveDetailBarang");
		
		String content = "FakturPembelian.SaveDetailBarang : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		String gudang = "//input[@name = 'warehouse']";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		AccTool.waitLoaderMedium(getWebDriver());
		
		content = content
				+ "\r\n"
				+ "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
				+ "Unit : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
				+ "Harga : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab)
				+ "Diskon Persen : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab)
				+ "Diskon : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab)
				+ "Pajak 1 : " + AccTool.getTextValue(driver, ElementType.CHECKBOX, "useTax1", tab)
				+ "Pajak 2 : " + AccTool.getTextValue(driver, ElementType.CHECKBOX, "useTax2", tab);
				if(WebElementTool.isElementExists(driver, By.xpath(gudang)))
				{
					content = content 
							+ "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
							+ "Departemen : "
				        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
			            	+ "Proyek : "
			            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span")
							+ "\r\n";
				} else {
					content = content 
							+ "Gudang : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.warehouse().name", tab)
							+ "Departemen : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.department().name", tab)
							+ "Proyek : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.project().name", tab)
							+ "\r\n";
				}
				
			
		
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveSerialNumber(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveSerialNumber");

//		WaitTool.delay(500);
		
		String grid = "";
		String content = "FakturPembelian.SaveSerialNumber : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";

		//baris di bawah ini untuk memastikan grid detail SN nya sudah visible		
		WaitTool.waitForElementVisible(driver, By.xpath("//div[contains(@id, 'detail-item')]"+grid), 500);

		content = content
				+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
		
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveKeteranganDetailBarang(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveKeteranganDetailBarang");
		String tab = "";
		String content = "FakturPembelian.SaveKeteranganDetailBarang : " + "\r\n";
		tab = "//*[contains(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tabcustomfield')]");
		
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
            	+ "\r\n"
				+ "Keterangan Detail Barang : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";
		
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveDetailBiayaLain(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveDetailBiayaLain");

		String tab = "";
		String content = "FakturPembelian.SaveDetailBiayaLain : " + "\r\n";
		tab = "//div[contains(@id,'detail-expense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		content = content
				+ "\r\n"
				+ "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab)
				+ "Jumlah : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amountCurrency", tab)
				+ "Alokasi ke Barang : " + AccTool.getTextValue(driver, ElementType.CHECKBOX, "allocateToItemCost", tab)
				+ "Tagih ke Pemasok : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "chargedVendor", tab)
				+ "Mata Uang Beban Pemasok : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "expenseCurrency", tab)
				+ "Departemen : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span")
				+ "\r\n";

		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveKeteranganBiayaLain(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveKeteranganBiayaLain");
		
		String content = "FakturPembelian.SaveKeteranganBiayaLain : " + "\r\n";
		String tab = "//*[contains(@id,'detail-expense')]//*[contains(@id,'tab-customfield')]";
		
//		AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[contains(@id,'tabcustomfield')]");
		
		String dept = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
			content = content + "Departemen : "
		        	+ AccTool.getTextValue(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span");
		}
		
		String proy = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
			content = content+ "Proyek : "
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span");
		}
		
		content = content
				+ "\r\n"
				+ "Keterangan  Lain : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab)
				+ "\r\n";
				
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveIsiHeader(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveIsiHeader");
//		WaitTool.delay(500);
		
		//pastikan field Nomor Form Faktur Pembelian sudah visible
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.FAKTUR_PEMBELIAN.getXpath()+"//*[contains(@id,'header-panel')]"), 500);
		
		String tab = "";
		String content = "FakturPembelian.SaveIsiHeader : " + "\r\n";
		content = content
				+ "\r\n"
				+ "Pemasok : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.LOOKUP, "vendor", tab)
				+ "Mata Uang : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SUMMARY, "text: formData.currency().code", tab)
				+ "Kurs Ritel : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.NUMBERFIELD, "rate", tab)
				+ "Kurs Pajak : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.NUMBERFIELD, "fiscalRate", tab)	
				+ "Tanggal : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.DATEPICKER, "transDate", tab);
				
				String noTransakasi = "//*[contains(@id,'header-panel')]//*[contains(@data-bind,'text: formData.number')]";
				if (WebElementTool.isElementExists(driver, By.xpath(noTransakasi))) {
					content = content 
							+ "No Form # : "
							+ AccTool.getTextValue(driver,  "//*[contains(@id,'header-panel')]//*[contains(@data-bind,'text: formData.number')]");
				} else {
					content = content
							+ "No Form # : "
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.TEXTFIELD, "number", tab);
				}	
				
				content = content
				+ "\r\n";
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveIsiDiskonBawahPersen(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveIsiDiskonBawahPersen");
		String tab2 ="//div[text()='Sub Total']/following-sibling::div";
		
		AccTool.click(getWebDriver(), tab2);
//		WaitTool.delay(500);
		AccTool.waitProgressBar(getWebDriver());
		
		//Pastikan diskon faktur sudah visible
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.FAKTUR_PEMBELIAN.getXpath()+"//button[@name='btnDiscPercent']"), 500);
		
		String tab = "";
		String content = "FakturPembelian.SaveIsiDiskonBawahPersen : " + "\r\n";
		content = content
				+ "\r\n"
				+ "Diskon Bawah : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.NUMBERFIELD, "itemCashDiscount", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveIsiBiayaLain(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveisiBiayaLain");
		
		String tab = "";
		String content = "FakturPembelian.SaveIsiBiayaLain : " + "\r\n";
		tab = "//*[contains(@id,'tab-expense')]";
		content = content  
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.FAKTUR_PEMBELIAN, tab) + "\r\n";
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveIsiInfoLain(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveIsiInfoLain");
		
		String tab = "";
		String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		String content = "FakturPembelian.SaveIsiInfoLain : " + "\r\n";
		tab = "//*[contains(@id,'tab-otherheader')]";
		content = content
				+ "\r\n"
				+ "No Faktur : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.TEXTFIELD, "billNumber", tab)
				+ "Faktur Dimuka : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, "//div[contains(@id, 'tab-otherheader')]//label[@class = 'nowrap value']")
				+ "Tanggal Pengiriman : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.DATEPICKER, "shipDate", tab)
				+ "Kena Pajak : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.CHECKBOX, "taxable", tab)
				+ "Termasuk Pajak : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.CHECKBOX, "inclusiveTax", tab)
				+ "Tipe Pajak : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.COMBOBOX, "vendorTaxType",tab)
				+ "Pengiriman : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.LOOKUP, "shipment", tab)
				+ "Syarat Pembayaran : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.LOOKUP, "paymentTerm", tab)
				+ "FOB : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.LOOKUP, "fob", tab)
				+ "Alamat : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.TEXTAREA, "toAddress", tab)
				+ "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.TEXTAREA, "description", tab)
				+ "Akun Hutang : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.LOOKUP, "apAccount", tab);
				if(WebElementTool.isElementExists(driver, By.xpath(namacabang)))
				{
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.COMBOBOX, "branch", tab) + "\r\n";
				} else {
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SUMMARY, "branchListOption", tab) + "\r\n";
				}
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveDetailUangMuka(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveDetailUangMuka");
//		WaitTool.delay(500);
				
		String tab = "";
		String content = "FakturPembelian.SaveDetailUangMuka : " + "\r\n";
		tab = "//*[contains(@id,'detail-down-payment')]";
		
		//pastikan detail down payment sudah visible
		WaitTool.waitForElementVisible(driver, By.xpath(tab), 500);
		content = content
				+ "\r\n"
				+ "Uang Muka : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "paymentAmount", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveIsiUangMuka(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveIsiUangMuka");
		
		String tab = "";
		String content = "FakturPembelian.SaveIsi : " + "\r\n";
		tab = "//*[contains(@id,'tab-otherheader')]";
		tab = "//*[contains(@id,'tab-downpayment')]";
		content = content + "Uang Muka" + "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.FAKTUR_PEMBELIAN, tab) + "\r\n";
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveList(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "FakturPembelian.SaveList : " + "\r\n";
		
		content = content + AccTool.getGridValue(driver, AccurateModule.FAKTUR_PEMBELIAN, tab) + "\r\n";

		AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveIsiInformasiFaktur(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.Save Informasi Faktur Pembelian");
		
		//String tab = "";
		String content = "FakturPembelian.Save Informasi Faktur Pembelian : " + "\r\n";
//		tab = AccurateModule.FAKTUR_PEMBELIAN.getXpath() + "//*[contains(@id,'#tab-summary')]";
		
		AccTool.click(getWebDriver(), "//i[@class='icn-transaction-info']");
		content = content
				+ "\r\n"
				+ "Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.totalAmount())")
				+ "Uang Muka : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.totalDownPayment())")
				+ "Pembayaran: " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.primePayment())")
				+ "Retur : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.primeReturn())")
				+ "Utang : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.primeOwing())")
				+ "Utang Pajak : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.taxOwing())")
				+ "Status : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SPAN, "text: formData.statusName(), click: function() {doShowTransactionHistoryStatus();}")
				+ "Dicetak/email : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, ElementType.SPAN, "text: formData.printUserName");
		
		AccTool.moveToElementAndClick(getWebDriver(), "//div[@class='span12 transaction-info-panel']//div[@class='span6']/div[contains(.,'Status')]");
//		
//		content = content
//				+ "Status : " + AccTool.getTextValue(driver, "//*[contains(@class,'transaction-info')]//*[contains(@data-bind,'TransactionHistoryStatus')]")
//				+ "\r\n";
		
		AccTool.writeTextFile(filename,  content);
		

	}
	
	public static void saveListDetailBarang(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.saveListDetailBarang");

		String content = "FakturPembelian.SaveListDetailBarang : " + "\r\n";
		String tab = "//*[contains(@id,'tab-item')]";
		content = content 
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.FAKTUR_PEMBELIAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListDetailBiaya(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.saveListDetailBiaya");

		String content = "FakturPembelian.SaveListDetailBiaya : " + "\r\n";
		String tab = "//*[contains(@id,'tab-expense')]";
		content = content
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.FAKTUR_PEMBELIAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListUangMuka(WebDriver driver,  String filename)
	{
		log.info("FakturPembelian.saveListUangMuka");

		String content = "FakturPembelian.SaveListUangMuka : " + "\r\n";
		String tab = "//*[contains(@id,'tab-downpayment')]";
		content = content
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.FAKTUR_PEMBELIAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveFooter(WebDriver driver,  String filename)
	{
		log.info("Save Footer");
//		WaitTool.delay(500);
		
		String content = "FakturPembelian.saveFooter ; " + "\r\n";
		
		String tab ="//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[1]";
		String tab11 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[2]";
		String tab2 ="//div[text()='Total Biaya']/following-sibling::div";
		String tab3 ="//div[text()='Total']/following-sibling::div";
		String tab4 ="";
		String tabpph = "//div[contains(@class, 'title') and text()[contains(.,'PPh')]]";
		String tab5="//div[text()='PPNBM 25%']/following-sibling::div";
		
//		WebElement temp = driver.findElement(By.xpath(tabpph));
		List<WebElement> temp = driver.findElements(By.xpath(tabpph));
		boolean exists = temp.size() > 0;
		
		if (exists) {
			WebElement temppph = driver.findElement(By.xpath(tabpph));
			String valuetabpph = temppph.getAttribute("textContent");
			log.info("cek cuyy " + tabpph);
			
			switch (valuetabpph) {
			case "PPh 4(2)" : 
				tab4 = "//div[text()='PPh 4(2)']/following-sibling::div";
				break;
			case "PPh 15" : 
				tab4 = "//div[text()='PPh 15']/following-sibling::div";
				break;
			case "PPh 23" : 
				tab4 = "//div[text()='PPh 23']/following-sibling::div";
				break;
			case "PPh 22 1%" :
			case "PPh 22 10%" :	
				tab4 = "//div[text()[contains(.,'PPh 22')]]/following-sibling::div";
				break;
			case "PPh 21" : 
				tab4 = "//div[text()='PPh 21']/following-sibling::div";
				break;
			}
		} else {
			log.info("tidak masuk exists");
			
			tab4 = "//div[text()='PPh']/following-sibling::div";
		}		
		
		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());
		
		//pastikan footer sudah tampil
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.FAKTUR_PEMBELIAN.getXpath()+"//div[contains(@id, 'summary-panel')]"), 500);
		
		content = content
				+ "\r\n"
				+ "Sub Total : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.FAKTUR_PEMBELIAN,tab )
				+ "Diskon : "
				+ ""
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN,ElementType.NUMBERFIELD, "itemCashDiscount");
		
				//untuk PPN
				String PPN = "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]";
				if(WebElementTool.isElementExists(driver, By.xpath(PPN)))
				{
					content = content 
							+ AccTool.getTextValue(driver, "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, tab1).replace("\r\n", " ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, tab11);
				} else {
					content = content 
							+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, "ppn");
				}
				
				//untuk PPNBM
				String PPNBM = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]";
				if(WebElementTool.isElementExists(driver, By.xpath(PPNBM)))
				{
					content = content 
							+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[1]").replace("\r\n", " ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[2]");
				}
				
				content = content
				+ "Total Biaya : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.FAKTUR_PEMBELIAN,tab2 )
				+ "Total : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.FAKTUR_PEMBELIAN,tab3 );
				
				//untuk PPh
				String PPH = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]";
				if(WebElementTool.isElementExists(driver, By.xpath(PPH)))
				{
					content = content 
							+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, tab4);
				} else {
					content = content 
							+ "PPh : "
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PEMBELIAN, "pph");
				}
				
				content = content
				+ "PPnBM : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.FAKTUR_PEMBELIAN, tab5)
				+ "\r\n";
		AccTool.writeTextFile(filename,  content);		
	}
	
	public static void isiNoSeriBerurutan(WebDriver driver, FakturPembelianParam param)
	{
		String tab = "";
		tab = "//div[starts-with(@id,'tab-serial-number')]";

//		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
//		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-serial-number')]//button[@name='btnImportSn']");
//		AccTool.click(getWebDriver(), "//a[contains(@href,'')]//i[@class='icon-list']");
		
		tab = "//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]";
		
		if (param.noseri != null)
			AccTool.textField(driver, tab, "@name='textField'", param.noseri);
		if (param.stok != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.stok);
		if (param.tglexpired != null)
			AccTool.datePicker(driver, tab, "@name='expiredDate'", param.tglexpired);
		if (param.ktsnoseri != null)
			AccTool.textField(driver, tab, "@name='consecutiveCount'", param.ktsnoseri);
		
//		AccTool.click(driver,
//				"//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]//*[@name='btnCreateSn']");
	}
	
	public static void klikButtonCloseTabDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikButtonCloseTabDetailBiayaLain(WebDriver driver) {
		String path = "//*[text()='Biaya Lainnya']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikOKPopUpWarningSN(WebDriver driver) {
		WaitTool.delay(500);
		String path = "//*[contains(@id,'error-dialog')]//*[@name='btnOk']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		
	}
	
	public static void saveNotifNoseri(WebDriver driver, String fileName)
	{
		log.info("PengisianNoSeri.SaveNotifNoSeri");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
	String content = "FakturPembelian.SaveNotifNoSeri : " + "\r\n";
	content = content
			+ "Notifikasi"
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
        AccTool.writeTextFile(fileName, content);
     }
	
	public static void klikBtnLanjutNoSeri(WebDriver driver)
	{
		String path = "//div[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
	}
	
	public static void klikBtnBuatIsiNoSeriBerurutan(WebDriver driver, FakturPembelianParam param) {
		String path = "//*[contains(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]//*[@name='btnCreateSn']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnNoSeriBerurutan(WebDriver driver, FakturPembelianParam param) {
		log.info("Faktur Pembelian. Isi No Seri Berurutan");
		
		AccTool.dropDown(driver, "//div[contains(@id, 'tab-serial-number')]", 
				"", " Nomor Seri berurutan");
	}
	
	public static void pilihDetailItem(WebDriver driver, FakturPembelianParam param)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//div[@class='grid-canvas']/div["+param.urutan+"]");
	} 
	
	public static void klikButtonPembelianAset(WebDriver driver){
		String xpath = "//button[@name='btnBuyFA']";
		String dialogkonfirm = "//div[contains(@id,'confirm-dialog')]";
		AccTool.click(driver, xpath);
		
		if (WebElementTool.isElementVisible(driver, By.xpath(dialogkonfirm))) {
			AccTool.click(driver, "//button[@name='btnOk' and text()='Ya']");
		}

	}
	
	public static void detailAset(WebDriver driver, FakturPembelianParam param){
		String tab= "";
		switch((param.tab).toLowerCase()){
		case "detail barang":
			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			if(param.nama != null)
				AccTool.textField(driver, tab, "@name='detailName'", param.nama);					
			if(param.kuantitas != null) {
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
				//WaitTool.delay(500);
				WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
			}
			if(param.harga != null) {
				AccTool.numberField(driver, tab, "@name='unitPrice'", param.harga);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
				//WaitTool.delay(500);
				WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
			}
			if(param.diskonpersen != null) {
				AccTool.numberField(driver, tab, "@name='itemDiscPercent'", param.diskonpersen);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
			}	
			if(param.diskon != null)
				AccTool.numberField(driver, tab, "@name='itemCashDiscount'", param.diskon);	
			if(param.pajak1 != null)
				AccTool.checkbox(getWebDriver(), tab, "@name='useTax1'", param.pajak1);
			if(param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if(param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);				
			break;
		case "keterangan":
			tab = "//div[starts-with(@id,'tab-notes')]";			
//			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			//ui baru
			AccTool.click(driver, "//*[contains(@data-bind,'reservedDetailTransactionExist')]/*[.='Info lainnya']");
			if(param.keterangan != null)
				AccTool.textarea(driver, "", "@name='detailNotes'", param.keterangan);			
			break;
		}
	}
	
	public static void saveDetailAset(WebDriver driver, String filename){
		log.info("FakturPembelian.SaveDetailAset");
		WaitTool.delay(1000);
		
		String tab = "";
		String content = "FakturPembelian.SaveDetailAset : " + "\r\n";
		String kodeaset = "//div[contains(@data-bind,'text: formData.fixedAsset().number')]";
		String nomorPO = "//div[contains(@data-bind,'text: formData.purchaseOrder().number')]";
		String nomorRI = "//div[contains(@data-bind,'text: formData.receiveItem().number')]";
		String departemen = "//div[contains(@data-bind,'text: formData.department().name')]";
		String proyek = "//div[contains(@data-bind,'text: formData.project().name')]";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content
				+ "Nama Aset : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
				+ "Harga : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab)
				+ "Diskon Persen : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab)
				+ "Diskon : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab)
				+ "PPN : " + AccTool.getTextValue(driver, ElementType.CHECKBOX, "useTax1", tab);
				if(WebElementTool.isElementExists(driver, By.xpath(departemen)))
				{
					content = content 
							+ "Departemen : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.department().name", tab);
				}else {
					content = content 
							+ "Departemen : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab);
				}
				if(WebElementTool.isElementExists(driver, By.xpath(proyek)))
				{
					content = content 
							+ "Proyek : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.project().name", tab);
				}else {
					content = content 
							+ "Proyek : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab);
				}
				if(WebElementTool.isElementExists(driver, By.xpath(nomorPO)))
				{
					content = content 
							+ "No Pesanan : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.purchaseOrder().number", tab);
				}
				if(WebElementTool.isElementExists(driver, By.xpath(nomorRI)))
				{
					content = content 
							+ "No Penerimaan : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.receiveItem().number", tab);
				}
				if(WebElementTool.isElementExists(driver, By.xpath(kodeaset)))
				{
					content = content 
							+ "Kode Aset : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.fixedAsset().number", tab);
				}
				
				content = content + "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikBaris(WebDriver driver, Integer urutan) {
		String path = "//*[contains(@id,'tab-item')]//div[contains(@class, 'slick-row')][" + urutan + "]";
		AccTool.click(driver, path);
	}
	
	public static void klikRiwayatPembayaran(WebDriver driver) {
		AccTool.click(driver, AccurateModule.FAKTUR_PEMBELIAN.getXpath() + "//*[contains(@data-bind, 'data.historyNumber')]");
	}

	public static void ubahTarifPPN(WebDriver driver, FakturPembelianParam param) {
		log.info("PenawaranPenjualan.UbahTarifPPN");

		String w = AccurateModule.FAKTUR_PEMBELIAN.getXpath();

		String u = "";

		AccTool.click(getWebDriver(), w + "//*[@name='btnPpnPercent']");
		if (param.tarifppn != null)
			AccTool.combobox(driver, u, "@name='tax1Rate'", param.tarifppn);
		AccTool.click(getWebDriver(), "//div[starts-with(@id,'accurate__input-ppn-percentage')]//*[@name='btnNext']");
	}
	
	
}

