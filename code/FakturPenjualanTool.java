package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.pesananpenjualan.PesananPenjualanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class FakturPenjualanTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(FakturPenjualanTool.class);
	static String footer = "//*[contains(@class,'summary-panel')]";

	public static void klikRincianFaktur1(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[1]");
	}

	public static void klikRincianFaktur2(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[2]");
	}

	public static void klikRincianFaktur3(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[3]");
	}

	public static void klikRincianFaktur4(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[4]");
	}

	public static void klikAmbilPesanan(WebDriver driver, FakturPenjualanParam param) {
//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Pesanan");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-order')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath()
			+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-sales-order')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pesanan']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
			By.xpath("//div[contains(@id, 'copy-sales-order')]//input[@name='lookup']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-order')]", "@name='lookup'", param.search);
	}
	
	public static void klikAmbilPesananTanpaKlik(WebDriver driver, FakturPenjualanParam param, String filename) {
//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Pesanan");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-order')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath()
			+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-sales-order')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pesanan']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
			By.xpath("//div[contains(@id, 'copy-sales-order')]//input[@name='lookup']"), 3);
		
		String content = "" + "\r\n";
		content = content 
				+ AccTool.getTextValue(driver, "//div[text() = 'Tidak ditemukan data yang cocok']")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void klikLanjutDiskonBawah(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__input-percentage')]//*[@name='btnNext']");

	}

	public static void klikAmbilPengiriman(WebDriver driver, FakturPenjualanParam param) {
		// AccTool.dropDown(getWebDriver(),
		// AccurateModule.FAKTUR_PENJUALAN.getXpath(),
		// "//div[contains(@class, 'offset4 span8')]/div[1]", "Pengiriman");
		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-delivery-order')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pengiriman']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id,'copy-delivery-order')]//input[@name='lookup']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-delivery-order')]", "@name='lookup'", param.search);
	}

	public static void klikTabSatu(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-item')]//*[@class='grid-canvas']/div[2]");
	}

	public static void klikTabDua(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-item')]//*[@class='grid-canvas']/div[2]");
	}

	public static void klikTabTiga(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-item')]//*[@class='grid-canvas']/div[3]");
	}

	public static void klikLanjutPesanan(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-sales-order')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);

	}

	public static void klikLanjutDP(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-down-payment')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);

	}

	public static void klikLanjutPengiriman(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-delivery-order')]//*[@name='btnNext']");
		AccTool.waitProgressBar(getWebDriver());

	}

	public static void klikLanjutPenawaran(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-sales-quotation')]//*[@name='btnNext']");

	}

	public static void klikAmbilPenawaran(WebDriver driver, FakturPenjualanParam param) {

//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Penawaran");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-quotation')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-sales-quotation')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Penawaran']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-sales-quotation')]//input[@name='lookup']"), 10);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-quotation')]", "@name='lookup'", param.search);
	}
	
	public static void klikAmbilPenawaranTanpaKlik(WebDriver driver, FakturPenjualanParam param, String filename) {

//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Penawaran");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-quotation')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-sales-quotation')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Penawaran']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-sales-quotation')]//input[@name='lookup']"), 10);
		driver.findElement(By.xpath("//div[contains(@id, 'copy-sales-quotation')]//input[@name='lookup']")).sendKeys(param.search);
		
		String content = "" + "\r\n";
		content = content 
				+ AccTool.getTextValue(driver, "//div[text() = 'Tidak ditemukan data yang cocok']")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void klikAmbilFavorit(WebDriver driver, FakturPenjualanParam param) {
//		AccTool.dropDown(driver, AccurateModule.FAKTUR_PENJUALAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Favorit");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-memorize-transaction')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Favorit']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-memorize-transaction')]//input[@name='lookup']"), 10);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
	}

	public static void klikProsesPembayaran(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[@name='btnProcess']");
		AccTool.click(getWebDriver(), "//a[text() = 'Pembayaran']");
	}

	public static void klikProsesPemotonganPPh(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[@name='btnProcess']");
		AccTool.click(getWebDriver(), "//a[text() = 'Pemotongan PPh']");
	}

	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void SaveNotifNoseri(WebDriver driver, String fileName) {
		log.info("Faktur Penjualan.SaveNotifNoSeri");

		String tab = "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
		String content = "Faktur Penjualan.SaveNotifNoSeri : " + "\r\n";
		content = content + "Notifikasi" + "\r\n" + AccTool.getTextValue(driver, ElementType.REPORT, " ", tab) + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}

	public static void isiForm(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.IsiForm");

		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();

		// String u = "";
		if (param.pelanggan != null) {
			AccTool.lookup(driver, w, "@name='customer'", param.pelanggan);
			AccTool.waitLoaderMedium(driver);
			AccTool.waitProgressBar(driver);
//			AccTool.waitProgressBar(driver);
//			WaitTool.delay(500);
		}
		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if (param.matauang != null)
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
		AccTool.waitProgressBar(driver);
		if (param.kursritel != null)
			AccTool.numberField(driver, w, "@name='rate'", param.kursritel);
//		AccTool.waitProgressBar(driver);
		if (param.kurspajak != null)
			AccTool.numberField(driver, w, "@name='fiscalRate'", param.kurspajak);
		AccTool.waitProgressBar(driver);
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if (param.diskon != null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskon);
	}

	public static void isiDiskon(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.IsiDiskon");

		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();

		String u = "";

		if (param.diskonpop != null)
			AccTool.click(getWebDriver(), w + "//*[@name='btnDiscPercent']");
		AccTool.textField(driver, u, "@name='discountPercent'", param.diskonpop);
		// AccTool.click(getWebDriver(),
		// "//*[contains(@id,'accurate__input-percentage')]//*[@name='btnNext']");
	}

	public static void klikTabDetailBarang(WebDriver driver) {
		AccTool.click(driver, AccurateModule.FAKTUR_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-item')]");
	}

	// mengambil harga terakhir barang

	public static void klikHistoryHarga(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[@name='btnPriceHistory']");

		AccTool.click(driver, "//button[@name='btnPriceHistory']/following-sibling::ul//a");
	}

	public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver, AccurateModule.FAKTUR_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}

	public static void klikTabBiayaLainnya(WebDriver driver) {
		AccTool.click(driver, AccurateModule.FAKTUR_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-expense')]");
	}

	public static void klikTabDP(WebDriver driver) {
		AccTool.click(driver, AccurateModule.FAKTUR_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-downpayment')]");
	}

	public static void klikTabInformasiPesanan(WebDriver driver) {
		AccTool.click(driver, AccurateModule.FAKTUR_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-summary')]");
	}

	public static void klikLanjutItem(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 30);
		AccTool.waitProgressBar(driver);
		AccTool.waitLoadingMask(driver);
	}

	public static void klikManualNoPajak(WebDriver driver) {
//		AccTool.click(driver, "//*[contains(@id,'tab-otherheader')]//*[@name='btnManualTaxNumber']");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'btnManualTaxNumber')] /ancestor::label/span");
	}

	public static void klikLanjutBiaya(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);
	}

	public static void klikHapusItem(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[@name='btnDelete']");
		AccTool.waitLoadingMask(driver);
	}

	public static void klikHapusDP(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-down-payment')]//*[@name='btnDelete']");
		AccTool.waitLoadingMask(driver);
		AccTool.waitProgressBar(getWebDriver());
	}

	public static void klikHapusBiaya(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[@name='btnDelete']");
		AccTool.waitLoadingMask(driver);
		AccTool.waitProgressBar(getWebDriver());
	}

	public static void isiDetailBarang(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.IsiDetailBarang");

		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-item')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-item')]");
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}

	public static void isiDetailDP(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.IsiDetailDP");

		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-downpayment')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-downpayment')]");
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDownPayment'", param.search);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}

	public static void isiInfoLain(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.IsiInfoLain");

		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");

		if (param.fakturdimuka != null)
			AccTool.checkbox(driver, tab, "@name='reverseInvoiceCheck'", param.fakturdimuka);
		if (param.cbkenapajak != null)
			AccTool.checkbox(driver, tab, "@name='taxable'", param.cbkenapajak);
		if (param.cbtermasukpajak != null)
			AccTool.checkbox(driver, tab, "@name='inclusiveTax'", param.cbtermasukpajak);
		if (param.tipepajak != null)
			AccTool.combobox(driver, tab, "@name='taxType'", param.tipepajak);
		if (param.kodedokumen != null)
			AccTool.combobox(driver, tab, "@name='documentCode'", param.kodedokumen);
		if (param.namawp != null)
			AccTool.textField(driver, tab, "@name='retailWpName'", param.namawp);
		if (param.nik != null)
			AccTool.textField(driver, tab, "@name='retailIdCard'", param.nik);
		if (param.tglfakturpajak != null)
			AccTool.datePicker(driver, tab, "@name='taxDate'", param.tglfakturpajak);
		if (param.nopo != null)
			AccTool.textField(driver, tab, "@name='poNumber'", param.nopo);
		if (param.tglpengiriman != null)
			AccTool.datePicker(driver, tab, "@name='shipDate'", param.tglpengiriman);
		if (param.pengiriman != null)
			AccTool.lookup(driver, tab, "@name='shipment'", param.pengiriman);
		if (param.syaratpembayaran != null)
			AccTool.lookup(driver, tab, "@name='paymentTerm'", param.syaratpembayaran);
		if (param.fob != null)
			AccTool.lookup(driver, tab, "@name='fob'", param.fob);
		if (param.tglpajak != null)
			AccTool.datePicker(driver, tab, "@name='taxDate'", param.tglpajak);
		if (param.alamat != null)
			AccTool.textarea(driver, tab, "@name='toAddress'", param.alamat);
		if (param.keterangan != null)
			AccTool.textarea(driver, "", "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
		if (param.nopajak != null)
			AccTool.textField(driver, w, "@name='taxNumber'", param.nopajak);
		if (param.akunpiutang != null)
			AccTool.lookup(driver, tab, "@name='arAccount'", param.akunpiutang);

	}

	public static void isiBiayaLain(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.IsiBiayaLain");

		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-expense')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-expense')]");
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}

	public static void detailBarang(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.DetailBarang");

		String tab = "";
		if (param.tab != null)
			switch ((param.tab).toLowerCase()) {

			case "detail barang":
				WaitTool.waitForElementVisible(driver, By.xpath("//div[contains(@id,'detail-item')]"), 10);
				tab = "//div[starts-with(@id,'tab-detailitem')]";
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				if (param.nama != null)
					AccTool.textField(driver, tab, "@name='detailName'", param.nama);
				if (param.unit != null)
					AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
				if (param.kuantitas != null)
					AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
				AccTool.click(getWebDriver(), "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(getWebDriver());
				if (param.harga != null) {
					AccTool.numberField(driver, tab, "@name='unitPrice'", param.harga);
					// AccTool.click(getWebDriver,
					// "//div[starts-with(@id, 'detail-item')]//label[@data-bind='text:
					// ft.unitPrice.title']");
//					AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
					AccTool.waitLoaderMedium(getWebDriver());
				}
				if (param.diskonpersen != null) {
					AccTool.numberField(driver, tab, "@name='itemDiscPercent'", param.diskonpersen);
					AccTool.click(getWebDriver(),
							"//div[starts-with(@id, 'detail-item')]//label[@data-bind='text: ft.itemDiscount.title']");
					AccTool.waitLoaderMedium(driver);
				}
				if (param.diskoncash != null)
					AccTool.numberField(driver, tab, "@name='itemCashDiscount'", param.diskoncash);
				if (param.gudang != null)
					AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
				AccTool.waitLoadingMask(driver);
				if (param.ppn != null)
					AccTool.checkbox(driver, tab, "@name='useTax1'", param.ppn);
				if (param.pph22 != null)
					AccTool.checkbox(driver, tab, "@name='useTax4'", param.pph22);
				if (param.penjual != null)
					AccTool.lookupWithoutClear(driver, tab, "@name='salesmanList'", param.penjual);
				if (param.departemenmandatory != null)
					AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
				if (param.proyekmandatory != null)
					AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);

				break;
			case "keterangan":
				tab = "//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]";
//				AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
				//ui baru
				AccTool.click(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tabcustomfield')]");
				if (param.departemen != null)
					AccTool.lookup(driver, tab, "@name='department'", param.departemen);
				if (param.proyek != null)
					AccTool.lookup(driver, tab, "@name='project'", param.proyek);
				if (param.keterangan != null)
					AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
				break;

			case "no seri":
				tab = "//div[starts-with(@id,'tab-serial-number')]";
				AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
				// AccTool.click(getWebDriver(),"//*[contains(@id,'tab-serial-number')]//button[@name='btnImportSn']");
				AccTool.click(getWebDriver(), "//a[contains(@href,'')]//i[@class='icon-list']");
				tab = "//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]";
				if (param.sn != null)
					AccTool.textField(driver, tab, "@name='textField'", param.sn);
				if (param.jumlahsn != null)
					AccTool.numberField(driver, tab, "@name='consecutiveCount'", param.jumlahsn);
				AccTool.click(driver,
						"//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]//*[@name='btnCreateSn']");
				break;

			case "no seriisi":
				tab = "//div[starts-with(@id,'tab-serial-number')]";
				AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");

				AccTool.textField(driver, tab, "@name='numberSn'", param.sn);

				break;
			}
	}

	public static void detailBiayaLain(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.DetailBiayaLain");

		String tab = "";

		if (param.tab != null)
			switch ((param.tab).toLowerCase()) {

			case "biaya lain":
				tab = "//div[starts-with(@id,'tab-detailexpense')]";
				AccTool.click(driver, "//*[contains(@id,'tabdetailexpense')]");
				if (param.nama != null)
					AccTool.textField(driver, tab, "@name='expenseName'", param.nama);
				if (param.jumlah != null)
					AccTool.numberField(driver, tab, "@name='expenseAmount'", param.jumlah);
				if (param.departemenmandatory != null)
					AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
				if (param.proyekmandatory != null)
					AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
				break;

			case "keterangan":
				tab = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]";
//				AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
				//ui baru
				AccTool.click(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tabcustomfield')]");
				if (param.departemen != null)
					AccTool.lookup(driver, tab, "@name='department'", param.departemen);
				if (param.proyek != null)
					AccTool.lookup(driver, tab, "@name='project'", param.proyek);
				if (param.keterangan != null)
					AccTool.textarea(driver, tab, "@name='expenseNotes'", param.keterangan);
				break;
			}
	}

	public static void detailUangMuka(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.DetailUangMuka");
		String tab = "//div[starts-with(@id,'tab-detaildownpayment')]";
		if (param.jumlah != null)
			AccTool.numberField(driver, tab, "@name='paymentAmount'", param.jumlah);
	}

	public static void saveKeteranganDetailBarang(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveKeteranganDetailBarang");

		String tab = "//*[starts-with(@id,'detail-item')]//div[starts-with(@id,'tab-customfield')]";
		String content = "FakturPenjualan.SaveKeteranganDetailBarang : " + "\r\n";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tabcustomfield')]");
		
		String dept = "//*[contains(@id,'customfield-item')]//div[input[@name='department']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
			content = content + "Departemen : "
		        	+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-item')]//div[input[@name='department']]/ul/li/label/span");
		}
		
		String dept1 = "//*[contains(@id, 'customfield-item')]//*[contains(@data-bind, 'text: formData.department().name')]";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept1))) {
			content = content + "Departemen : "
		        	+ AccTool.getTextValue(driver, "//*[contains(@id, 'customfield-item')]//*[contains(@data-bind, 'text: formData.department().name')]");
		}
		
		String proy = "//*[contains(@id,'customfield-item')]//div[input[@name='project']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
			content = content+ "Proyek : "
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-item')]//div[input[@name='project']]/ul/li/label/span");
		}
		
		String proy1 = "//*[contains(@id, 'customfield-item')]//*[contains(@data-bind, 'formData.project')]";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy1))) {
			content = content+ "Proyek : "
	            	+ AccTool.getTextValue(driver, "//*[contains(@id, 'customfield-item')]//*[contains(@data-bind, 'formData.project')]");
		}
		
		content = content 
				+ "Keterangan : " 
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailBiayaLain(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveDetailBiayaLain");

		String tab = "";
		String content = "FakturPenjualan.SaveDetailBiayaLain : " + "\r\n";
		tab = "//div[contains(@id,'detail-expense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		content = content + "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab)
				+ "Jumlah : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "expenseAmount", tab)
				+ "Departemen : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span") + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailDP(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveDetailDP");

		String tab = "";
		String content = "FakturPenjualan.SaveDetailDP : " + "\r\n";
		tab = "//div[contains(@id,'detail-down-payment')]";
		// AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		content = content + "Uang Muka : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "paymentAmount", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveKeteranganBiayaLain(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveKeteranganBiayaLain");

		String content = "";
		String tab = "//div[starts-with(@id,'tab-customfield')]";
//		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[contains(@href,'tab-customfield')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[contains(@href,'tab-customfield')]");
		
		String dept = "//div[starts-with(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
			content = content + "Departemen :"
		        	+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span");
		}
		
		String proy = "//div[starts-with(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
			content = content+ "Proyek :"
	            	+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span");
		}
		
		content = content 
				+ "Keterangan : " 
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveIsiHeader");

		String tab = "";
		String content = "FakturPenjualan.SaveIsiHeader : " + "\r\n";
		content = content + "Pelanggan : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.LOOKUP, "customer", tab)
				+ "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SUMMARY,
						"text: formData.currency().code", tab)
				+ "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.DATEPICKER, "transDate",
						tab)
				+ "Kurs Rtl : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD, "rate", tab)
				+ "Kurs Pjk : "
				+ AccTool.getTextValue(
						driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD, "fiscalRate", tab)
				+ "Penomoran : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.COMBOBOX, "typeAutoNumber",
						tab);
				
			String nofaktur = "//*[@id='module-accurate__customer__sales-invoice']//div[@class='input-control text']/input[@name='number']";
			if (WebElementTool.isElementVisible(driver, By.xpath(nofaktur))) {
				content = content + "No Faktur# : "
						+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.TEXTFIELD, "number", tab);
				}
			else {
				content = content + "No Faktur# : "
						+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'text: formData.number')]");
				}
			
		content = content +
				"\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveButtonProsees(WebDriver driver, String filename) {
		log.info("FakturPenjualan.saveButtonProsees");

		String tab = "";
		String content = "" ;
				
			String btnProses = "//button[contains(@class, 'button outline-disabled')]";
			if (WebElementTool.isElementVisible(driver, By.xpath(btnProses))) {
				content = content + "\r\n" + "Button proses disable ";
				}
			else {
				content = content + "\r\n" + "Button proses tidak disable ";
				}
			
		content = content +
				"\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiDetailBarang(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveIsiDetailBarang");

		String tab = "";
		String content = "FakturPenjualan.SaveIsiDetailBarang : " + "\r\n";
		tab = "//*[contains(@id,'tab-item')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiBiayaLain(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveIsiBiayaLain");

		String tab = "";
		String content = "FakturPenjualan.SaveIsiBiayaLain : " + "\r\n";
		tab = "//*[contains(@id,'tab-expense')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiInfoLain(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveIsiInfoLain");

		String tab = "";
		String content = "FakturPenjualan.SaveIsiInfoLain : " + "\r\n";
		tab = "//*[contains(@id,'tab-otherheader')]";

		content = content + "Faktur Dimuka : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
						"//div[contains(@id, 'tab-otherheader')]//label[@class = 'nowrap value']");
				String akunpiutang = "//*[contains(@id,'tab-otherheader')]//div[input[@name='arAccount']]";
				if (WebElementTool.isElementExists(driver, By.xpath(akunpiutang))) {
		content = content + "Akun Piutang : " 
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,ElementType.LOOKUP, "arAccount", tab);
					}
				content = content+ "Kena Pajak : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.CHECKBOX, "taxable", tab)
				+ "Termasuk Pajak : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
						ElementType.CHECKBOX, "inclusiveTax", tab);

		String kodepajak = "//*[contains(@id,'tab-otherheader')]//select[@name = 'taxType']";
		if (WebElementTool.isElementVisible(driver, By.xpath(kodepajak))) {
			content = content + "Kode Pajak : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
					ElementType.COMBOBOX, "taxType", tab);
		}

		String kodedokumen = "//*[contains(@id,'tab-otherheader')]//select[@name = 'documentCode']";
		if (WebElementTool.isElementVisible(driver, By.xpath(kodedokumen))) {
			content = content + "Kode Dokumen : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
					ElementType.COMBOBOX, "documentCode", tab);
		}

		String namawp = "//*[contains(@id,'tab-otherheader')]//input[@name = 'retailWpName']";
		if (WebElementTool.isElementVisible(driver, By.xpath(namawp))) {
			content = content + "Nama Wajib Pajak : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
					ElementType.TEXTFIELD, "retailWpName", tab);
		}

		String nik = "//*[contains(@id,'tab-otherheader')]//input[@name = 'retailIdCard']";
		if (WebElementTool.isElementVisible(driver, By.xpath(nik))) {
			content = content + "NIK : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
					ElementType.TEXTFIELD, "retailIdCard", tab);
		}

		String tanggalfakturpajak = "//*[contains(@id,'tab-otherheader')]//input[@name = 'taxDate']";
		if (WebElementTool.isElementVisible(driver, By.xpath(tanggalfakturpajak))) {
			content = content + "Tanggal Faktur Pajak : " + AccTool.getTextValue(driver,
					AccurateModule.FAKTUR_PENJUALAN, ElementType.DATEPICKER, "taxDate", tab);
		}

		content = content + "No. PO : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.TEXTFIELD, "poNumber", tab)
				+ "Tanggal Pengiriman : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.DATEPICKER, "shipDate", tab)
				+ "Pengiriman : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.LOOKUP, "shipment", tab)
				+ "Syarat Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.LOOKUP, "paymentTerm", tab)
				+ "FOB : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.LOOKUP, "fob", tab)
				+ "Alamat : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.TEXTAREA, "toAddress", tab);

		// Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda
		// kondisi
		String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
			content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
					ElementType.COMBOBOX, "branch", tab);
		} else {
			content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
					ElementType.SUMMARY, "branchListOption", tab);
		}

		content = content + "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
				ElementType.TEXTAREA, "description", tab)
		// + "Akun Hutang : "
		// + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
		// ElementType.LOOKUP, "apAccount", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
		log.info(content);
	}

	public static void saveIsiUangMuka(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveIsiUangMuka");

		String tab = "";
		String content = "FakturPenjualan.SaveIsiUangMuka : " + "\r\n";
		tab = "//*[contains(@id,'tab-otherheader')]";
		tab = "//*[contains(@id,'tab-downpayment')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveList(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "FakturPenjualan.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailBarang(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveDetailBarang");

		String content = "FakturPenjualan.SaveDetailBarang : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content + "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) + "Penjual : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "salesmanList", tab) + "Unit : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) + "Harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab) + "Diskon Persen : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab) + "Diskon : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab) + "Pajak 1 : "
				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "useTax1", tab) + "Pajak 2 : "
				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "useTax2", tab);

		// Gudang ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namagudang = "//*[contains(@id,'tab-detailitem')]//div[input[@name='warehouse']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namagudang))) {
			content = content + "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab);
		} else {
			content = content + "Gudang : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.warehouse().name", tab);
		}

		// Dept ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namadept = "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namadept))) {
			content = content + "Departemen : "
	        		+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span");
		} else {
			content = content + "Departemen : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.department().name", tab);
		}

		// Proj ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namaproj = "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namaproj))) {
			content = content + "Proyek : "
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span");
		} else {
			content = content + "Proyek : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.project().name", tab);
		}

		content = content + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	// untuk menyimpan detail dan tambahan informasi stok dapat dijual setelah
	// disimpan
	public static void saveDetailBarang2(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveDetailBarang");

		String content = "FakturPenjualan.SaveDetailBarang : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content + "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) + "Penjual : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "salesmanList", tab) + "Unit : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) + "Harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab) + "Diskon Persen : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab) + "Diskon : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab) + "Total Harga : "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "totalPrice", tab) + "Pajak 1 : "
				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "useTax1", tab) + "Pajak 2 : "
				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "useTax2", tab) + "Stok Dapat Dijual : "
				+ AccTool.getTextValue(driver, "//label[@class='label-no-wrap']//span[contains(@data-bind, 'formData.availableStockUnit')]");

		// Gudang ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namagudang = "//*[contains(@id,'tab-detailitem')]//div[input[@name='warehouse']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namagudang))) {
			content = content + "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab);
		} else {
			content = content + "Gudang : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.warehouse().name", tab);
		}

		// Dept ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namadept = "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namadept))) {
			content = content + "Departemen : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab);
		} else {
			content = content + "Departemen : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.department().name", tab);
		}

		// Proj ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namaproj = "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namaproj))) {
			content = content + "Proyek : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab);
		} else {
			content = content + "Proyek : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.project().name", tab);
		}

		content = content + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	// untuk menyimpan detail dan tambahan informasi stok dapat dijual dan stok
	// digudang sebelum simpan
	public static void saveDetailBarang3(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveDetailBarang");

		String content = "FakturPenjualan.SaveDetailBarang : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content + "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) + "Penjual : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "salesmanList", tab) + "Unit : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) + "Harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab) + "Diskon Persen : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab) + "Diskon : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab) + "Total Harga : "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "totalPrice", tab) + "Pajak 1 : "
				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "useTax1", tab) + "Pajak 2 : "
				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "useTax2", tab) + "Stok Dapat Dijual : "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "availableStockUnit", tab) + "Stok Gudang: "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "warehouseStockUnit", tab);

		// Gudang ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namagudang = "//*[contains(@id,'tab-detailitem')]//div[input[@name='warehouse']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namagudang))) {
			content = content + "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab);
		} else {
			content = content + "Gudang : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.warehouse().name", tab);
		}

		// Dept ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namadept = "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namadept))) {
			content = content + "Departemen : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab);
		} else {
			content = content + "Departemen : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.department().name", tab);
		}

		// Proj ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namaproj = "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namaproj))) {
			content = content + "Proyek : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab);
		} else {
			content = content + "Proyek : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.project().name", tab);
		}

		content = content + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailBarangPPH22(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveDetailBarang");

		String content = "FakturPenjualan.SaveDetailBarang : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content + "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) + "Penjual : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "salesmanList", tab) + "Unit : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) + "Harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab) + "Diskon Persen : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab) + "Diskon : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab) + "PPN 10% : "
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "useTax1", tab) + "PPh 22 2% : "
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "useTax4", tab);

		// Gudang ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namagudang = "//*[contains(@id,'tab-detailitem')]//div[input[@name='warehouse']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namagudang))) {
			content = content + "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab);
		} else {
			content = content + "Gudang : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.warehouse().name", tab);
		}

		// Dept ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namadept = "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namadept))) {
			content = content + "Departemen : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab);
		} else {
			content = content + "Departemen : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.department().name", tab);
		}

		// Proj ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
		String namaproj = "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]";
		if (WebElementTool.isElementExists(driver, By.xpath(namaproj))) {
			content = content + "Proyek : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab);
		} else {
			content = content + "Proyek : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.project().name", tab);
		}

		content = content + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooter(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[1]";
		String tab11 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[2]";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "";
		String tabpph = "//div[contains(@class, 'title') and text()[contains(.,'PPh')]]";

//		WebElement temp = driver.findElement(By.xpath(tabpph));
		List<WebElement> temp = driver.findElements(By.xpath(tabpph));
		boolean exists = temp.size() > 0;

		if (exists) {
			WebElement temppph = driver.findElement(By.xpath(tabpph));
			String valuetabpph = temppph.getAttribute("textContent");
			log.info("cek cuyy " + tabpph);

			switch (valuetabpph) {
			case "PPh 4(2)":
				tab4 = "//div[text()='PPh 4(2)']/following-sibling::div";
				break;
			case "PPh 15":
				tab4 = "//div[text()='PPh 15']/following-sibling::div";
				break;
			case "PPh 23":
				tab4 = "//div[text()='PPh 23']/following-sibling::div";
				break;
			case "PPh 22 1%":
			case "PPh 22 10%":
				tab4 = "//*[text()[contains(.,'PPh 22')]]/following-sibling::div";
				break;
			case "PPh 21":
				tab4 = "//div[text()='PPh 21']/following-sibling::div";
				break;
			}
		} else {
			log.info("tidak masuk exists");

			tab4 = "//div[text()='PPh']/following-sibling::div";
		}

		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());

		// pastikan Total sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				2);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount");
		
				//untuk PPN
				String PPN = "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]";
				if(WebElementTool.isElementExists(driver, By.xpath(PPN)))
				{
					content = content 
							+ AccTool.getTextValue(driver, "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1).replace("\r\n", " ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab11);
				} else {
					content = content 
							+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, "ppn");
				}
				
				//untuk PPNBM
				String PPNBM = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]";
				if(WebElementTool.isElementExists(driver, By.xpath(PPNBM)))
				{
					content = content 
							+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[1]").replace("\r\n", " ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[2]");
				}
				
				content = content 
				+ "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3);
				
				//untuk PPh
				String PPH = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]";
				if(WebElementTool.isElementExists(driver, By.xpath(PPH)))
				{
					content = content 
							+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4);
				} else {
					content = content 
							+ "PPh : "
							+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4);
				}
				
				content = content
						+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveListDetailBarang(WebDriver driver, String filename) {
		log.info("FakturPenjualan.saveListDetailBarang");

		String content = "FakturPenjualan.SaveListDetailBarang : " + "\r\n";
		String tab = "//*[contains(@id,'tab-item')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	public static void detailNoSeri(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.DetailNOSERI");

		String tab = "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");

		if (param.jumlahsn != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.jumlahsn);
		if (param.sn != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.sn);

	}

	public static void klikTabNoSeri(WebDriver driver) {
		log.info("FakturPenjualan.DetailNOSERI");
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
	}

	public static void pilihDariDO(WebDriver driver, String bariske) {
		log.info("FakturPenjualan.AmbilDariDOBaris1");
		String window = "//div[contains(@id, 'copy-delivery-order')]";
		String tab = window + "//div[contains(@id, 'copy-item-grid')]";
		String baris = tab + "//div[contains(@class, 'ui-widget-content')][" + bariske + "]";

		AccTool.click(driver, baris + "//label/span");

	}

	public static void klikLanjutItemSN(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		AccTool.waitLoaderMedium(driver);
		AccTool.waitProgressBar(driver);
	}

	public static void klikTabInformasiFaktur(WebDriver driver) {
		AccTool.click(driver, AccurateModule.FAKTUR_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-summary')]");
	}

	public static void saveInformasiFaktur(WebDriver driver, String filename) {
		log.info("Save Informasi Faktur");
		String content = "FakturPenjualan.saveInformasiFaktur : " + "\r\n";
		content = content + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "totalAmount")
				+ "Uang Muka : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "totalDownPayment")
				+ "Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "primeReceipt")
				+ "Retur : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "primeReturn")
				+ "Piutang : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "primeOwing")
				+ "Status : " 
				+ AccTool.getTextValue(driver,AccurateModule.FAKTUR_PENJUALAN, "//span[contains(@data-bind,'text: formData.statusName()')]")
				//UI Baru menambah cetak 
//				+ "Dicetak/email : "
//				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "printUserName")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveInformasiFakturPengepakan(WebDriver driver, String filename) {
		log.info("Save Informasi Faktur");
		String content = "FakturPenjualan.saveInformasiFaktur : " + "\r\n";
		content = content + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "totalAmount")
				+ "Uang Muka : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "totalDownPayment")
				+ "Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "primeReceipt")
				+ "Retur : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "primeReturn")
				+ "Piutang : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "primeOwing")
				+ "Status : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
						"//span[contains(@data-bind,'text: formData.statusName()')]")
				+ "Pengepakan Barang : " 
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
						"//span[contains(@data-bind,'formData.deliveryPackingNumber()')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveInformasiFakturPajak(WebDriver driver, String filename) {
		log.info("Save Informasi Faktur");
		String content = "FakturPenjualan.saveInformasiFaktur : " + "\r\n";
		content = content + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "totalAmount")
				+ "Uang Muka : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "totalDownPayment")
				+ "Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "primeReceipt")
				+ "Terima Pajak : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "taxReceipt")
				+ "Retur : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "primeReturn")
				+ "Piutang : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "primeOwing")
				+ "Piutang Pajak: "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.SPAN, "taxOwing")
				+ "Status : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN,
						"//div[contains(@data-bind,'text: formData.statusName()')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("FakturPenjualan.SaveIsiDetailSerialNumber");

		String grid = "";
		String content = "Nomor Seri Detail Barang  : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";
		content = content + "\r\n" + "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid)
				+ "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	public static void isiDetailTransaksiFavorit(WebDriver driver, FakturPenjualanParam param) {
		log.info("JurnalUmum.isiDetailTransaksiFavorit");
		String w = "//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]";
//		AccTool.click(driver, AccurateModule.JURNAL_UMUM.getXpath() + "//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]");	
		if (param.nama != null)
			AccTool.textField(driver, w, "@name='name'", param.nama);
		if (param.grup != null)
			AccTool.lookup(driver, w, "@name='useUserRoleAccessList'", param.grup);
		if (param.user != null)
			AccTool.textField(driver, w, "@name='useUserAccessList'", param.user);
//		if (param.Komentar != null)				
//	    AccTool.textarea(driver, a, "@name='comment'", param.Komentar);	

	}

	public static void saveFooterpph23(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";

		// pastikan pph23 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				2);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPh 23 : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveFooterpph23ppn11(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";

		// pastikan pph23 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				2);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPh 23 : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooterpph15(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "//div[text()='PPh 15']/following-sibling::div";

		// pastikan pph23 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				2);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPh 15 : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	// 27 maret 2020 = di edit di tab 4 karna ada pph 22 yang gak pakai 2% jadi
	// dieit bisa nyimpen untuk berapa persen pun

	public static void saveFooterpph22(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		// String tab4 = "//div[text()='PPh 22 2%']/following-sibling::div";
		String tab4 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";

		// pastikan pph22 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);
		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "PPh 22 : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveFooterpph22PPN11(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		// String tab4 = "//div[text()='PPh 22 2%']/following-sibling::div";
		String tab4 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";

		// pastikan pph22 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);
		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "PPh 22 : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooterpphPs4ayat2(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "//div[text()='PPh 4(2)']/following-sibling::div";

		// pastikan pph23 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				2);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPh 4(2) : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooterPPh22danPPh23(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab2 = "//div[text()='Total']/following-sibling::div";
		String tab3 = "//div[text()='PPh 22 2%']/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";

		// pastikan pph22 dan pph23 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "PPh 22 2% : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPh 23 : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooterPPh22danPPh23PPN11(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab2 = "//div[text()='Total']/following-sibling::div";
		String tab3 = "//div[text()='PPh 22 2%']/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";

		// pastikan pph22 dan pph23 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "PPh 22 2% : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPh 23 : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	//untuk PPH22 yang nilainya 1.5%
	public static void saveFooterPPh22danPPh23ke2(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab2 = "//div[text()='Total']/following-sibling::div";
		String tab3 = "//div[text()='PPh 22 1.5%']/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";

		// pastikan pph22 dan pph23 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "PPh 22 1.5% : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPh 23 : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	//untuk PPH22 yang nilainya 1.5%
		public static void saveFooterPPh22danPPh23ke2PPN11(WebDriver driver, String filename) {
			log.info("Faktur Penjualan Save Footer");
//			WaitTool.delay(1000);
			WaitTool.checkPageIsReady(driver);

			String content = "FakturPenjualan.saveFooter ; " + "\r\n";

			String tab = "//div[text()='Sub Total']/following-sibling::div";
			String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
			String tab2 = "//div[text()='Total']/following-sibling::div";
			String tab3 = "//div[text()='PPh 22 1.5%']/following-sibling::div";
			String tab4 = "//div[text()='PPh 23']/following-sibling::div";

			// pastikan pph22 dan pph23 sudah visible
			WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
					3);
			WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
					3);

			content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
					+ "Diskon : "
					+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
							"itemCashDiscount")
					+ "PPN 11% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "PPh 22 1.5% : "
					+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPh 23 : "
					+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "Total : "
					+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "\r\n";
			AccTool.writeTextFile(filename, content);
		}

	
	
	public static void saveFooterpph22DP(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab2 = "//div[text()='Uang Muka']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "//div[text()='PPh 22 2%']/following-sibling::div";

		// pastikan pph22 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "Uang Muka : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "PPN 10% : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "PPh 22 2% : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooterpph22danBiaya(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab3 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab4 = "//div[text()='Total']/following-sibling::div";
		String tab5 = "//div[text()='PPh 22 2%']/following-sibling::div";

		// pastikan pph22 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				3);
		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "Total Biaya : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPN 10% : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "PPh 22 2% : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab5) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	// 1 agustus 2019, untuk detail barang dari klik edit dari indikator notifikasi
	// (klik edit)

	public static void detailBarang2(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.DetailBarang");

		String tab = "";
		if (param.tab != null)
			switch ((param.tab).toLowerCase()) {

			case "detail barang":
				// WaitTool.waitForElementVisible(driver,
				// By.xpath("//div[contains(@id,'detail-item')]"), 10);
				tab = "//div[starts-with(@id,'tab-detailitem')]";
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				if (param.nama != null)
					AccTool.textField(driver, tab, "@name='detailName'", param.nama);
				if (param.unit != null)
					AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
				if (param.kuantitas != null)
					AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
				if (param.harga != null) {
					AccTool.numberField(driver, tab, "@name='unitPrice'", param.harga);
					AccTool.click(getWebDriver(),
							"//div[starts-with(@id, 'detail-item')]//label[@data-bind='text: ft.unitPrice.title']");
					AccTool.waitLoaderMedium(driver);
				}
				if (param.diskonpersen != null) {
					AccTool.numberField(driver, tab, "@name='itemDiscPercent'", param.diskonpersen);
					AccTool.click(getWebDriver(),
							"//div[starts-with(@id, 'detail-item')]//label[@data-bind='text: ft.itemDiscount.title']");
					AccTool.waitLoaderMedium(driver);
				}
				if (param.diskoncash != null)
					AccTool.numberField(driver, tab, "@name='itemCashDiscount'", param.diskoncash);
				if (param.gudang != null)
					AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
				AccTool.waitLoadingMask(driver);
				if (param.ppn != null)
					AccTool.checkbox(driver, tab, "@name='useTax1'", param.ppn);
				if (param.pph22 != null)
					AccTool.checkbox(driver, tab, "@name='useTax4'", param.pph22);
				if (param.penjual != null)
					AccTool.lookup(driver, tab, "@name='salesmanList'", param.penjual);
				if (param.departemen != null)
					AccTool.lookup(driver, tab, "@name='department'", param.departemen);
				if (param.proyek != null)
					AccTool.lookup(driver, tab, "@name='project'", param.proyek);

				break;
			case "keterangan":
				tab = "//div[starts-with(@id,'tab-notes')]";
//				AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
				//ui baru
				AccTool.click(driver, "//*[contains(@data-bind,'detailNotes')]/*[.='Info lainnya']");
				if (param.keterangan != null)
					AccTool.textarea(driver, "", "@name='detailNotes'", param.keterangan);
				break;

			case "no seri":
				tab = "//div[starts-with(@id,'tab-serial-number')]";
				AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
				// AccTool.click(getWebDriver(),"//*[contains(@id,'tab-serial-number')]//button[@name='btnImportSn']");
				AccTool.click(getWebDriver(), "//a[contains(@href,'')]//i[@class='icon-list']");
				tab = "//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]";
				if (param.sn != null)
					AccTool.textField(driver, tab, "@name='textField'", param.sn);
				if (param.jumlahsn != null)
					AccTool.numberField(driver, tab, "@name='consecutiveCount'", param.jumlahsn);
				AccTool.click(driver,
						"//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]//*[@name='btnCreateSn']");
				break;

			case "no seriisi":
				tab = "//div[starts-with(@id,'tab-serial-number')]";
				AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");

				AccTool.textField(driver, tab, "@name='numberSn'", param.sn);

				break;
			}
	}

	// klik hapus penjual di detail barang
	public static void klikHapusPenjual(WebDriver driver, String keyword) {
		AccTool.clearLookup2(getWebDriver(), "@name='salesmanList'", keyword);
	}

	// 02 maret 2020 klik list

	public static void klikListBaris(WebDriver driver) {
		// .click(getWebDriver(), "//*[contains(@class,'ui-widget-content slick-row
		// odd')]");
		AccTool.click(getWebDriver(), "//div[contains(@id,'module-grid-list')]//div[@class='grid-canvas']/div[1]");
		AccTool.waitLoadingMask(driver);
	}

	public static void klikListBaris2() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'ui-widget-content slick-row even')]");

	}

	public static void klikListBaris3() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'ui-widget-content slick-row even')][2]");

	}

	public static void klikImportFakturPenjualan(WebDriver driver, String importfrom) {
		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		String buttonImport = w + "//button[@name='btnImport']";
		String importmerchant = buttonImport + "/following-sibling::ul//a[text() = '" + importfrom + "']";
		WaitTool.waitForElementClickable(driver, By.xpath(buttonImport), 5);
		AccTool.click(driver, buttonImport);
		WaitTool.waitForElementClickable(driver, By.xpath(importmerchant), 5);
		AccTool.click(driver, importmerchant);
	}
	
	public static void ubahTarifPPN(WebDriver driver, FakturPenjualanParam param) {
		log.info("FakturPenjualan.UbahTarifPPN");

		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();

		String u = "";
		
		AccTool.click(getWebDriver(), w + "//*[@name='btnPpnPercent']");
		if (param.tarifppn != null)
			AccTool.combobox(driver, u, "@name='tax1Rate'", param.tarifppn);
		AccTool.click(getWebDriver(),"//div[starts-with(@id,'accurate__input-ppn-percentage')]//*[@name='btnNext']");
		
	}
	
	public static void saveFooterPPN11(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
//		WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "";
		String tabpph = "//div[@class='title' and text()[contains(.,'PPh')]]";

//		WebElement temp = driver.findElement(By.xpath(tabpph));
		List<WebElement> temp = driver.findElements(By.xpath(tabpph));
		boolean exists = temp.size() > 0;

		if (exists) {
			WebElement temppph = driver.findElement(By.xpath(tabpph));
			String valuetabpph = temppph.getAttribute("textContent");
			log.info("cek cuyy " + tabpph);

			switch (valuetabpph) {
			case "PPh 4(2)":
				tab4 = "//div[text()='PPh 4(2)']/following-sibling::div";
				break;
			case "PPh 15":
				tab4 = "//div[text()='PPh 15']/following-sibling::div";
				break;
			case "PPh 23":
				tab4 = "//div[text()='PPh 23']/following-sibling::div";
				break;
			case "PPh 22 1%":
			case "PPh 22 10%":
				tab4 = "//div[text()[contains(.,'PPh 22')]]/following-sibling::div";
				break;
			case "PPh 21":
				tab4 = "//div[text()='PPh 21']/following-sibling::div";
				break;
			}
		} else {
			log.info("tidak masuk exists");

			tab4 = "//div[text()='PPh']/following-sibling::div";
		}

		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());

		// pastikan Total sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.FAKTUR_PENJUALAN.getXpath() + footer),
				2);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : " + AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab1) + "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab2) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab3) + "PPh : "
				+ AccTool.getTextValue(driver, AccurateModule.FAKTUR_PENJUALAN, tab4) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikImportApos(WebDriver driver) {
		AccTool.click(getWebDriver(), "//button[@name='btnManagePosImport']");
	}
	
	public static void klikUbahPenjual(WebDriver driver, FakturPenjualanParam param) {
		
		//ui baru
		String w = AccurateModule.FAKTUR_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//div[contains(@id,'tab-item')]//*[@name = 'btnGetFrom']");
		
		AccTool.click(getWebDriver(), w + "//a[.='Ubah Tenaga Penjual']");
		
//		ini ui lama
//		AccTool.dropDown(getWebDriver(), AccurateModule.FAKTUR_PENJUALAN.getXpath(),
//				"//div[contains(@class, 'span1')]/div[1]", "Ubah Tenaga Penjual");
//
		// pastikan window popup cari penjual sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id,'set-salesman-detail')]//input[@name='salesmanList']"), 5);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'set-salesman-detail')]", "@name='salesmanList'", param.search);
	}
	
	public static void klikLanjutUbahPenjual(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'set-salesman-detail')]//*[@name='btnSet']");
		AccTool.waitProgressBar(getWebDriver());
	}
	
	public static void saveRiwayatRetur(WebDriver driver, String filename) {
		log.info("Save Riwayat Retur");
		String content = "FakturPenjualan.saveRiwayatRetur : " + "\r\n";
		content = content 
				+ AccTool.getTextValue(driver, "//h3[contains(.,'Riwayat Retur')]/ancestor::div[2]/following-sibling::div//*[contains(@data-bind,'data.historyNumber')]")
				+ AccTool.getTextValue(driver, "//h3[contains(.,'Riwayat Retur')]/ancestor::div[2]/following-sibling::div//*[contains(@data-bind,'data.historyDate')]")
				+ AccTool.getTextValue(driver, "//h3[contains(.,'Riwayat Retur')]/ancestor::div[2]/following-sibling::div//*[contains(@data-bind,'data.historyAmount')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikInformasiPembayaran(WebDriver driver) {
		AccTool.click(driver, AccurateModule.FAKTUR_PENJUALAN.getXpath() + "//*[contains(@data-bind, 'data.historyNumber')]");
	}
}
