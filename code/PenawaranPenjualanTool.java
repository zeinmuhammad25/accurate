package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penawaranpenjualan.PenawaranPenjualanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PenawaranPenjualanTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PenawaranPenjualanTool.class);
	// static String footer = "//div[@class='trans-summary']";

	public static void isiForm(WebDriver driver, PenawaranPenjualanParam param) {
		log.info("PenawaranPenjualan.Isi");

		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		if (param.dipesanoleh != null)
			AccTool.lookup(driver, w, "@name='customer'", param.dipesanoleh);
		if (param.matauang != null)
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			// AccTool.click(getWebDriver(),
			// "//*[@id='module-accurate__customer__sales-quotation']//*[@name='btnManualNumber']");
			AccTool.textField(driver, w, "@name='number'", param.no);
		if (param.diskon != null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskon);
	}

	public static void isiDiskonBawah(WebDriver driver, PenawaranPenjualanParam param) {
		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		String u = "";
		if (param.diskonpop != null)
			AccTool.click(getWebDriver(), w + "//*[@name='btnDiscPercent']");
		AccTool.textField(driver, u, "@name='discountPercent'", param.diskonpop);
		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__input-percentage')]//*[@name='btnNext']");
	}

	public static void isiDetailBarang(WebDriver driver, PenawaranPenjualanParam param) {
		log.info("PenawaranPenjualan.IsiDetailBarang");

		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-item')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-item')]");
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}

	public static void klikLanjutItem(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 30);
		// AccTool.waitLoadingMask(driver);
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikLanjutItem2(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		AccTool.waitProgressBar(driver);
	}

	public static void klikLanjutBiaya(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[@name='btnNext']");
		AccTool.waitProgressBar(getWebDriver());
	}

	public static void klikHapusItem(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[@name='btnDelete']");
	}

	public static void klikHapusBiaya(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[@name='btnDelete']");
	}

	public static void klikHapusKarakter2(WebDriver driver) {
		AccTool.clearLookup(getWebDriver(), "//*[contains(@id,'tab-detailitem')]", "@name='charField2'");
		WaitTool.delay(400);
	}

	public static void klikHapusKarakter1(WebDriver driver) {
		AccTool.clearLookup(getWebDriver(), "//*[contains(@id,'tab-detailitem')]", "@name='charField1'");
		WaitTool.delay(400);
	}
	
	public static void klikHapusKarakter1InfoLainnya(WebDriver driver) {
		AccTool.clearLookup(getWebDriver(), "//*[contains(@id,'tab-otherheader')]", "@name='charField1'");
		WaitTool.delay(400);
	}
	
	public static void klikHapusKarakter2InfoLainnya(WebDriver driver) {
		AccTool.clearLookup(getWebDriver(), "//*[contains(@id,'tab-otherheader')]", "@name='charField2'");
		WaitTool.delay(400);
	}

	public static void klikTabInfoLainRincian(WebDriver driver) {
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
	}

	public static void isiInfoLain(WebDriver driver, PenawaranPenjualanParam param) {
		log.info("PenawaranPenjualan.IsiInfoLain");

		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
//		String tabinfo = "";
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");

		if (param.syaratpembayaran != null)
			AccTool.lookup(driver, tab, "@name='paymentTerm'", param.syaratpembayaran);
		if (param.alamat != null)
			AccTool.textarea(driver, tab, "@name='toAddress'", param.alamat);
		if (param.cbkenapajak != null)
			AccTool.checkbox(driver, tab, "@name='taxable'", param.cbkenapajak);
		if (param.cbtermasukpajak != null)
			AccTool.checkbox(driver, tab, "@name='inclusiveTax'", param.cbtermasukpajak);
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
		// karakter 1
		try {
			WebElement combobox = driver
					.findElement(By.xpath("//div[@class='trans-detail-tab frame-left-tab frames']//select[1]"));
			if (param.karakter1 != null)
				AccTool.combobox(driver, tab, "@name='charField1'", param.karakter1);
			log.info("Try done");
		} catch (NoSuchElementException z) {

			if (param.karakter1 != null)
				AccTool.lookup(driver, tab, "@name='charField1'", param.karakter1);
			log.info("Catch done");
		}

		// karakter 2
		try {
			WebElement combobox = driver
					.findElement(By.xpath("//div[@class='trans-detail-tab frame-left-tab frames']//select[1]"));

			if (param.karakter2 != null)
				AccTool.combobox(driver, tab, "@name='charField2'", param.karakter2);

			log.info("if done");
		} catch (NoSuchElementException z) {
			if (param.karakter2 != null)
				AccTool.lookup(driver, tab, "@name='charField2'", param.karakter2);

			log.info("Catch done");
		}
	}

	public static void isiBiayaLain(WebDriver driver, PenawaranPenjualanParam param) {
		log.info("PenawaranPenjualan.IsiBiayaLain");

		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-expense')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-expense')]");

		AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
		AccTool.scrollRowDetail(driver, tab, param.scroll);
	}

	public static void detailBarang(WebDriver driver, PenawaranPenjualanParam param) {
		log.info("PenawaranPenjualan.DetailBarang");

		String tab = "";

		switch ((param.tab).toLowerCase()) {
		case "detail barang":
			WaitTool.waitForElementVisible(driver, By.xpath("//div[contains(@id,'detail-item')]"), 10);

			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'#tab-detailitem')]");
			if (param.nama != null)
				AccTool.textField(driver, tab, "@name='detailName'", param.nama);
			if (param.kuantitas != null) {
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
				// WaitTool.delay(100);
				// WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
				// AccTool.waitLoaderMedium(getWebDriver());
			}
			if (param.unit != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
			if (param.harga != null) {
				AccTool.numberField(driver, tab, "@name='unitPrice'", param.harga);
				// WaitTool.delay(100);
				WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
				AccTool.waitLoaderMedium(getWebDriver());
			}
			if (param.cbpajak1 != null)
				AccTool.checkbox(driver, tab, "@name='useTax1'", param.cbpajak1);
			if (param.cbpajak2 != null)
				AccTool.checkbox(driver, tab, "@name='useTax2'", param.cbpajak2);
			if (param.penjual != null)
				AccTool.lookupWithoutClear(driver, tab, "@name='salesmanList'", param.penjual);
			if (param.departemenmandatory != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if (param.proyekmandatory != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
			if (param.diskonpersen != null) {
				AccTool.numberField(driver, tab, "@name='itemDiscPercent'", param.diskonpersen);
				AccTool.click(getWebDriver(),
						"//div[starts-with(@id, 'detail-item')]//label[@data-bind='text: ft.itemDiscount.title']");
				AccTool.waitLoaderMedium(driver);
			}
			if (param.diskon != null)
				AccTool.numberField(driver, tab, "@name='itemCashDiscount'", param.diskon);

			// AccTool.click(driver, "//a[contains(@href,'#tab-detailitem')]");
			try {
				WebElement lookup = driver
						.findElement(By.xpath("//*[contains(@id,'tab-detailitem')]"));
				if (param.karakter1mandatory != null)
					AccTool.lookup(driver, tab, "@name='charField1'", param.karakter1mandatory);
				log.info("Try done");
			} catch (NoSuchElementException z) {
				if (param.karakter1mandatory != null)
					AccTool.combobox(driver, tab, "@name='charField1'", param.karakter1mandatory);
				log.info("Catch done");
			}

			// karakter 2
			try {
				WebElement lookup = driver
						.findElement(By.xpath("//*[contains(@id,'tab-detailitem')]"));
				if (param.karakter2mandatory != null)
					AccTool.lookup(driver, tab, "@name='charField2'", param.karakter2mandatory);
				log.info("if done");
			} catch (NoSuchElementException z) {
				if (param.karakter2mandatory != null)
					AccTool.combobox(driver, tab, "@name='charField2'", param.karakter2mandatory);
				log.info("Catch done");
			}
			break;
			
			
		case "infolain":
			tab = "//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]";
			AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");

			// karakter 1
			try {
				WebElement lookup = driver.findElement(By.xpath(
						"//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]"));

				if (param.karakter1 != null)
					AccTool.lookup(driver, tab, "@name='charField1'", param.karakter1);
				log.info("if done");
			} catch (NoSuchElementException z) {

				if (param.karakter1 != null)
					AccTool.combobox(driver, tab, "@name='charField1'", param.karakter1);
			}

			// karakter 2
			try {
				WebElement lookup = driver.findElement(By.xpath(
						"//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]"));

				if (param.karakter2 != null)
					AccTool.lookup(driver, tab, "@name='charField2'", param.karakter2);
				log.info("if done");
			} catch (NoSuchElementException z) {

				if (param.karakter2 != null)
					AccTool.combobox(driver, tab, "@name='charField2'", param.karakter2);
			}
			break;
		//ui lama
//		case "keterangan":
//			tab = "//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]";
//			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
//			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
		//ui baru
			
		case "keterangan":
			tab = "//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]";
			AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
			if (param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if (param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);		
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
			break;
		}
	}

	public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver,
				AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@href, 'tab-otherheader')]");
	}

	public static void klikTabInfoLain(WebDriver driver) {
		AccTool.click(driver,
				AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}

	public static void detailBiayaLain(WebDriver driver, PenawaranPenjualanParam param) {
		log.info("PenawaranPenjualan.detailBiayaLain");

		String tab = "";

		switch ((param.tab).toLowerCase()) {
		case "biaya lain":
			tab = "//*[contains(@id,'tab-detailexpense')]";
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
			//ui lama
//			AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
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

	public static void saveHeader(WebDriver driver, String filename) {
		log.info("save header");
		String content = "PenawaranPenjualan.saveHeader ; " + "\r\n";
		content = content + "\r\n" + "Dipesan Oleh : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.LOOKUP, "customer")
				+ "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.SUMMARY,
						"text: formData.currency().code")
				+ "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.DATEPICKER, "transDate")
				+ "NO : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.TEXTFIELD, "number")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveInfoLainnya(WebDriver driver, String filename) {
		log.info("save InfoLain");
		String content = "PenawaranPenjualan.saveInfoLain ; " + "\r\n";
		content = content + "\r\n" + "Syarat Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.LOOKUP, "paymentTerm")
				+ "Alamat : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.TEXTAREA, "toAddress")
				+ "Kena Pajak : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.CHECKBOX, "taxable")
				+ "Total Termasuk Pajak : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN,
						ElementType.CHECKBOX, "inclusiveTax");

		String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
			content = content + "Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.COMBOBOX, "branch");
		} else {
			content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN,
					ElementType.SUMMARY, "branchListOption");
		}

		content = content + "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.TEXTAREA, "description")

				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveAtributTambahanInfoLainnya(WebDriver driver, String filename) {
		log.info("save InfoLain");
		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		String content = "PenawaranPenjualan.saveAtributTambahanInfoLainnya ; " + "\r\n";

		content = content + "\r\n";

		String atribut1 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomCharReserved1')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut1))) {
			content = content + "Karakter 1 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField1", tab);
		} 
//		else {
//			content = content + "Karakter 1 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField1", tab);
//		}
		String atribut2 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomCharReserved2')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut2))) {
			content = content + "Karakter 2 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField2", tab);
		} 
//		else {
//			content = content + "Karakter 2 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField2", tab);
//		}
		
		String atribut3 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomCharReserved3')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut3))) {
			content = content + "Karakter 3 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField3", tab);
		} 
//		else {
//			content = content + "Karakter 3 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField3", tab);
//		}

		String atribut4 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomCharReserved4')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut4))) {
			content = content + "Karakter 4 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField4", tab);
		} 
//		else {
//			content = content + "Karakter 4 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField4", tab);
//		}
		
		String atribut5 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomCharReserved5')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut5))) {
			content = content + "Karakter 5 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField5", tab);
		} 
//		else {
//			content = content + "Karakter 5 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField5", tab);
//		}

		String atribut6 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomCharReserved6')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut6))) {
			content = content + "Karakter 6 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField6", tab);
		} 
//		else {
//			content = content + "Karakter 6 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField6", tab);
//		}
		
		String atribut7 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomCharReserved7')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut7))) {
			content = content + "Karakter 7 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField7", tab);
		} 
//		else {
//			content = content + "Karakter 7 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField7", tab);
//		}

		String atribut8 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomCharReserved8')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut8))) {
			content = content + "Karakter 8 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField8", tab);
		} 
//		else {
//			content = content + "Karakter 8 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField8", tab);
//		}
		
		String atribut9 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomCharReserved9')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut9))) {
			content = content + "Karakter 9 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField9", tab);
		} 
//		else {
//			content = content + "Karakter 9 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField9", tab);
//		}

		if (WebElementTool.isElementExists(driver, By.xpath(atribut9))) {
			content = content + "Karakter 10 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField10", tab);
		} 
//		else {
//			content = content + "Karakter 10 : "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField10", tab);
//		}

		String angka = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesQuotationCustomNumericReserved')]";	
		if (WebElementTool.isElementExists(driver, By.xpath(angka))) {
		content = content + "Angka 1 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField1", tab)
				+ "Angka 2 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField2", tab)
				+ "Angka 3 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField3", tab)
				+ "Angka 4 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField4", tab)
				+ "Angka 5 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField5", tab)
				+ "Angka 6 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField6", tab)
				+ "Angka 7 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField7", tab)
				+ "Angka 8 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField8", tab)
				+ "Angka 9 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField9", tab)
				+ "Angka 10 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField10", tab)
				+ "Tanggal 1 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "dateField1", tab)
				+ "Tanggal 2 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "dateField2", tab);
		}
		content = content
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailBarang(WebDriver driver, String filename) {
		log.info("save DetailBarang");
		String content = "PenawaranPenjualan.saveDetailBarang ; " + "\r\n";
		String tab = "//*[contains(@id,'detail-item')]";
		AccTool.click(driver, "//a[contains(@href,'#tab-detailitem')]");
		content = content + "\r\n" + "Nama Barang : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab) + "Kuantitas : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) + "Unit : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) + "@Harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab) + "Diskon % : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab) + "Diskon harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab) + "Pajak : "
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "useTax1", tab) + "Penjual : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "salesmanList", tab) 
				+ "Departemen : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span") + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveAtributTambahanRincianBarang(WebDriver driver, String filename) {

		String content = "PenawaranPenjualan.saveAtributTambahanRincianBarang ; " + "\r\n";

		String tab = "//div[starts-with(@id,'details-tab')]//div[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[starts-with(@id,'details-tab')]//*[starts-with(@id,'tabcustomfield')]");
		content = content + "\r\n";

		String atribut1 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved1')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut1))) {
			content = content + "Karakter 1 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField1", tab);
		} 
//		else {
//			content = content + "Karakter 1 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField1", tab);
//		}
		String atribut2 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved2')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut2))) {
			content = content + "Karakter 2 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField2", tab);

		}
//		else {
//			content = content + "Karakter 2 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField2", tab);
//		}
		String atribut3 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved3')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut3))) {
			content = content + "Karakter 3 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField3", tab);
		} 
//		else {
//			content = content + "Karakter 3 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField3", tab);
//		}
		String atribut4 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved4')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut4))) {
			content = content + "Karakter 4 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField4", tab);
		} 
//		else {
//			content = content + "Karakter 4 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField4", tab);
//		}
		String atribut5 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved5')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut5))) {
			content = content + "Karakter 5 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField5", tab);
		} 
//		else {
//			content = content + "Karakter 5 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField5", tab);
//		}
		String atribut6 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved6')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut6))) {
			content = content + "Karakter 6 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField6", tab);
		} 
//		else {
//			content = content + "Karakter 6 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField6", tab);
//		}
		String atribut7 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved7')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut7))) {
			content = content + "Karakter 7 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField7", tab);
		}
//		else {
//			content = content + "Karakter 7 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField7", tab);
//		}
		String atribut8 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved8')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut8))) {
			content = content + "Karakter 8 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField8", tab);
		}
//		else {
//			content = content + "Karakter 8 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField8", tab);
//		}
		String atribut9 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved9')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut9))) {
			content = content + "Karakter 9 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField9", tab);
		}
//		else {
//			content = content + "Karakter 9 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField9", tab);
//		}
		String atribut10 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved10')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut10))) {
			content = content + "Karakter 10 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField10", tab);
		} 
//		else {
//			content = content + "Karakter 10 : "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField10", tab);
//		}
		String atribut11 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved11')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 11 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField11", tab);
		} 
//		else {
//			content = content + "Karakter 11 : "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField11", tab);
//		}

		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 12 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField12", tab);
		}
//		else {
//			content = content + "Karakter 12 : "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField12", tab);
//		}
		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 13 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField13", tab);
		} 
//		else {
//			content = content + "Karakter 13 : "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField13", tab);
//		}

		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 14 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField14", tab);
		}
//		else {
//			content = content + "Karakter 14 : "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField14", tab);
//		}
		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 15 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField15", tab);
		} 
//		else {
//			content = content + "Karakter 15 : "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField15", tab);
//		}

		
		String angka = "//div[starts-with(@id,'tab-customfield')]//label[contains(@data-bind,'detailTransactionCustomNumericReserved')]";
		if (WebElementTool.isElementExists(driver, By.xpath(angka))) {
		content = content + "Angka 1 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField1", tab)
				+ "Angka 2 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField2", tab)
				+ "Angka 3 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField3", tab)
				+ "Angka 4 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField4", tab)
				+ "Angka 5 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField5", tab)
				+ "Angka 6 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField6", tab)
				+ "Angka 7 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField7", tab)
				+ "Angka 8 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField8", tab)
				+ "Angka 9 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField9", tab)
				+ "Angka 10 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField10", tab)
				+ "Tanggal 1 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "dateField1", tab)
				+ "Tanggal 2 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "dateField2", tab);
		}
			content = content 
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveAtributTambahanRincianBarangMandatory(WebDriver driver, String filename) {
		
		String content = "PenawaranPenjualan.saveAtributTambahanRincianBarangMandatory ; " + "\r\n";
		
		String tab = "";
		String tab1 = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//*[contains(@id,'tabdetailitem')]");
		content = content + "\r\n";

		String atribut1 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField1')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut1))) {
			content = content + "Karakter 1 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField1", tab1);
		}
//		else {
//			content = content + "Karakter 1 Mandatory: " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField1", tab1);
//		}
		String atribut2 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField2')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut2))) {
			content = content + "Karakter 2 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField2", tab1);

		}
//		else {
//			content = content + "Karakter 2 Mandatory: " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField2", tab1);
//		}
		String atribut3 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField3')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut3))) {
			content = content + "Karakter 3 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField3", tab1);
		}
//		else {
//			content = content + "Karakter 3 Mandatory: " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField3", tab1);
//		}
		String atribut4 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField4')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut4))) {
			content = content + "Karakter 4 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField4", tab1);
		}
//		else {
//			content = content + "Karakter 4 Mandatory: " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField4", tab1);
//		}
		String atribut5 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField5')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut5))) {
			content = content + "Karakter 5 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField5", tab1);
		}
//		else {
//			content = content + "Karakter 5 Mandatory: " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField5", tab1);
//		}
		String atribut6 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField6')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut6))) {
			content = content + "Karakter 6 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField6", tab1);
		}
//		else {
//			content = content + "Karakter 6 Mandatory: " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField6", tab1);
//		}
		String atribut7 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField7')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut7))) {
			content = content + "Karakter 7 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField7", tab1);
		} 
//		else {
//			content = content + "Karakter 7 Mandatory: " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField7", tab1);
//		}
		String atribut8 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField8')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut8))) {
			content = content + "Karakter 8 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField8", tab1);
		} 
//		else {
//			content = content + "Karakter 8 Mandatory: " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField8", tab1);
//		}
		String atribut9 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField9')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut9))) {
			content = content + "Karakter 9 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField9", tab1);
		}
//		else {
//			content = content + "Karakter 9 Mandatory: " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField9", tab1);
//		}
		String atribut10 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField10')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut10))) {
			content = content + "Karakter 10 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField10", tab1);
		}
//		else {
//			content = content + "Karakter 10 Mandatory: "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField10", tab1);
//		}
		String atribut11 = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'charField11')]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 11 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField11", tab1);
		} 
//		else {
//			content = content + "Karakter 11 Mandatory: "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField11", tab1);
//		}

		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 12 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField12", tab1);
		} 
//		else {
//			content = content + "Karakter 12 Mandatory: "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField12", tab1);
//		}
		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 13 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField13", tab1);
		}
//		else {
//			content = content + "Karakter 13 Mandatory: "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField13", tab1);
//		}

		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 14 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField14", tab1);
		}
//		else {
//			content = content + "Karakter 14 Mandatory: "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField14", tab);
//		}
		if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
			content = content + "Karakter 15 Mandatory: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField15", tab1);
		} 
//		else {
//			content = content + "Karakter 15 Mandatory: "
//					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField15", tab1);
//		}

		String angka = "//div[starts-with(@id,'tab-detailitem')]//label[contains(@for,'numericField')]";
		if (WebElementTool.isElementExists(driver, By.xpath(angka))) {
		content = content + "Angka 1 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField1", tab1)
				+ "Angka 2 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField2", tab1)
				+ "Angka 3 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField3", tab1)
				+ "Angka 4 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField4", tab1)
				+ "Angka 5 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField5", tab1)
				+ "Angka 6 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField6", tab1)
				+ "Angka 7 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField7", tab1)
				+ "Angka 8 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField8", tab1)
				+ "Angka 9 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField9", tab1)
				+ "Angka 10 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "numericField10", tab1)
				+ "Tanggal 1 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "dateField1", tab1)
				+ "Tanggal 2 : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "dateField2", tab1);
		}
		
		content = content
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
		
	}

	public static void saveKeteranganDetailBarang(WebDriver driver, String filename) {
		log.info("PenawaranPenjualan.SaveKeteranganDetailBarang");

		String tab = "//div[starts-with(@id,'tab-customfield')]";
		String content = "PenawaranPenjualan.SaveKeteranganDetailBarang : " + "\r\n";
		//ui lama
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tabcustomfield')]");
		content = content 
				+ "Departemen : "
				+ AccTool.getTextValue(driver, "//div[contains(@id,'customfield-item')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek : "
				+ AccTool.getTextValue(driver, "//div[contains(@id,'customfield-item')]//div[input[@name='project']]/ul/li/label/span") 
				+ "Keterangan :" 
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) 
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailBiaya(WebDriver driver, String filename) {
		log.info("save DetailBarang");
		String content = "PenawaranPenjualan.saveDetailBiaya ; " + "\r\n";
		String tab = "//*[contains(@id,'detail-expense')]";
		AccTool.click(driver, "//*[contains(@class,'window shadow')]//div[contains(@id,'detail-expense')]");
		content = content + "\r\n" + "Nama Biaya : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab) + "Jumlah : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "expenseAmount", tab) 
				+ "Departemen : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span") + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveKeteranganDetailBiayaLain(WebDriver driver, String filename) {
		log.info("PenawaranPenjualan.SaveKeteranganDetailBiayaLain");

		String content = "PenawaranPenjualan.SaveKeteranganDetailBiayaLain :";
		String tab = "//*[contains(@id,'expenses-tab')]//div[starts-with(@id,'tab-customfield')]";
		//ui lama
//		AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tabcustomfield')]");
		content = content + "\r\n"
				+ "Departemen : "
				+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-expense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek : "
				+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-expense')]//div[input[@name='project']]/ul/li/label/span")
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab) 
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooter(WebDriver driver, String filename) {
		// WaitTool.waitDOMReady(driver, 3);
		log.info("Save Footer");
		String content = "PenawaranPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[1]";
		String tab11 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[2]";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "";
		String tabpph = "//div[contains(@class, 'title') and text()[contains(.,'PPh')]]";


		// WebElement temp = driver.findElement(By.xpath(tabpph));
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

		// pastikan footer sudah tampil
		WaitTool.waitForElementVisible(driver,
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@id,'summary-panel')]"), 500);

		content = content 
				+ "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount");

		//untuk PPN
		String PPN = "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]";
		if(WebElementTool.isElementExists(driver, By.xpath(PPN)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab1).replace("\r\n", " ")
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab11);
		} else {
			content = content 
					+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, "ppn");
		}
		
		//untuk PPNBM
		String PPNBM = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]";
		if(WebElementTool.isElementExists(driver, By.xpath(PPNBM)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[1]").replace("\r\n", " ")
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[2]");
		}
		
		content = content 
		+ "Total Biaya : "
		+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab2) + "Total : "
		+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab3);
		
		//untuk PPh
		String PPH = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]";
		if(WebElementTool.isElementExists(driver, By.xpath(PPH)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab4);
		} else {
			content = content 
					+ "PPh : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, "pph");
		}
		
		content = content
				+ "\r\n";
AccTool.writeTextFile(filename, content);
}

	public static void saveFooterPPN11(WebDriver driver, String filename) {
		// WaitTool.waitDOMReady(driver, 3);
		log.info("Save Footer");
		String content = "PenawaranPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "";
		String tabpph = "//div[@class='title' and text()[contains(.,'PPh')]]";

		// WebElement temp = driver.findElement(By.xpath(tabpph));
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

		// pastikan footer sudah tampil
//		WaitTool.waitForElementVisible(driver,
//				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//div[@class='trans-summary']"), 500);
		
		WaitTool.waitForElementVisible(driver,
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@class,'summary-panel')]"), 500);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab1)
				+ "Total Biaya : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab2) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab3) + "PPh : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab4) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	// Tambah tab PPH untuk menyimpan PPH 22 14 Januari 2019 -- diperbaiki
	// kembali tgl 27 maret 2020

	public static void saveFooterpph22(WebDriver driver, String filename) {
		// WaitTool.waitDOMReady(driver, 3);
		log.info("Save Footer");
		String content = "PenawaranPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		// String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab2 = "//div[text()='Total']/following-sibling::div";
		// String tab4 = "//div[text()='PPh']/following-sibling::div";
		// String tab3 = "//div[text()='PPh 22 1,5%']/following-sibling::div";
		String tab3 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";

		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@class,'summary-panel')]"), 3);
		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab1) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab2) + "PPh 22  : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab3)

				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooterpph22ppn11(WebDriver driver, String filename) {
		// WaitTool.waitDOMReady(driver, 3);
		log.info("Save Footer");
		String content = "PenawaranPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		// String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab2 = "//div[text()='Total']/following-sibling::div";
		// String tab4 = "//div[text()='PPh']/following-sibling::div";
		// String tab3 = "//div[text()='PPh 22 1,5%']/following-sibling::div";
		String tab3 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";

//		WaitTool.waitForElementVisible(getWebDriver(),
//				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//div[@class='trans-summary']"), 3);
		
		WaitTool.waitForElementVisible(driver,
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@class,'summary-panel')]"), 500);
		
		
		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab1) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab2) + "PPh 22  : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab3)

				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	// Footer untuk PPH 23 (1 april 2019)

	public static void saveFooterpph23(WebDriver driver, String filename) {
		// WaitTool.waitDOMReady(driver, 3);
		log.info("Save Footer");
		String content = "PenawaranPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";
		// String tab5 = "//div[text()='PPh 22 1,5% ']/following-sibling::div";

//		WaitTool.waitForElementVisible(getWebDriver(),
//				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//div[@class='trans-summary']"), 3);
		
		WaitTool.waitForElementVisible(driver,
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@class,'summary-panel')]"), 500);
		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab1)
				+ "Total Biaya : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab2) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab3) + "PPh 23 : "
				// + AccTool.getTextValue(driver,
				// AccurateModule.PENAWARAN_PENJUALAN, tab4)
				// + "PPh 22 1,5% : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab4) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooterpph23ppn11(WebDriver driver, String filename) {
		// WaitTool.waitDOMReady(driver, 3);
		log.info("Save Footer");
		String content = "PenawaranPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";
		// String tab5 = "//div[text()='PPh 22 1,5% ']/following-sibling::div";

		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@class,'summary-panel')]"), 3);
		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab1)
				+ "Total Biaya : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab2) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab3) + "PPh 23 : "
				// + AccTool.getTextValue(driver,
				// AccurateModule.PENAWARAN_PENJUALAN, tab4)
				// + "PPh 22 1,5% : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab4) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooterPPh22danPPh23(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
		// WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab2 = "//div[text()='Total']/following-sibling::div";
		// String tab3 = "//div[text()='PPh 22 2%']/following-sibling::div";
		String tab3 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";

		// pastikan pph22 dan pph23 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@class,'summary-panel')]"), 3);
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@class,'summary-panel')]"), 3);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab1) + "PPh 22 : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab3) + "PPh 23 : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab4) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab2) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooterPPh22danPPh23ppn11(WebDriver driver, String filename) {
		log.info("Faktur Penjualan Save Footer");
		// WaitTool.delay(1000);
		WaitTool.checkPageIsReady(driver);

		String content = "FakturPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab2 = "//div[text()='Total']/following-sibling::div";
		// String tab3 = "//div[text()='PPh 22 2%']/following-sibling::div";
		String tab3 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";

		// pastikan pph22 dan pph23 sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@class,'summary-panel')]"), 3);
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//*[contains(@class,'summary-panel')]"), 3);

		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab1) + "PPh 22 : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab3) + "PPh 23 : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab4) + "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab2) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveData(WebDriver driver, String filename) {

		log.info("PenawaranPenjualan.SaveData");

		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		String tab = "";
		String content = "PenawaranPenjualan.SaveIsi : " + "\r\n";

		switch (tab.toLowerCase()) {
		case "header":
			content = content + "Header" + "\r\n" + "Dipesan Oleh : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.LOOKUP, "customer",
							tab)
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.DATEPICKER,
							"transDate", tab)
					+ "Nomor : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.TEXTFIELD, "number",
							tab)
					+ "Diskon : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN,
							ElementType.NUMBERFIELD, "itemCashDiscount", tab)
					+ "\r\n";
			break;
		case "detail barang":
			tab = w + "//*[contains(@id,'tab-item')]";
			content = content + "Detail Barang" + "\r\n"
					+ AccTool.getGridValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab) + "\r\n";
			break;
		case "biaya lain":
			tab = w + "//*[contains(@id,'tab-expense')]";
			content = content + "Biaya Lain" + "\r\n"
					+ AccTool.getGridValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab) + "\r\n";
			break;
		case "info lain":
			tab = w + "//*[contains(@id,'tab-otherheader')]";
			content = content + "Info Lain" + "\r\n" + "Syarat Pembayaran : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.LOOKUP,
							"paymentTerm", tab)
					+ "Alamat : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.TEXTAREA,
							"toAddress", tab)
					+ "Keterangan : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.TEXTAREA,
							"description", tab)
					+ "Kena Pajak : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.CHECKBOX, "taxable",
							tab)
					+ "Total Termasuk Pajak : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.CHECKBOX,
							"inclusiveTax", tab)
					+ "Tutup Penawaran : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.CHECKBOX,
							"manualClosed", tab)
					+ "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN,
							ElementType.COMBOBOX, "branch", tab)

					+ "\r\n";
			break;
		}

		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetail(WebDriver driver, PenawaranPenjualanParam param) {
		log.info("PenawaranPenjualan.SaveDetail");

		String tab = "";
		String content = "PenawaranPenjualan.SaveDetail : " + "\r\n";

		switch (param.tab.toLowerCase()) {
		case "barang":
			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			content = content + "\r\n" + "Nama : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.TEXTFIELD,
							"detailName", tab)
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
							"quantity", tab)
					+ "Harga : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
							"unitPrice", tab)
					+ "Diskon Persen : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
							"itemDiscPercent", tab)
					+ "Diskon : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
							"itemCashDiscount", tab)
					+ "Penjual : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.LOOKUP,
							"salesmanList", tab)
					+ "Departemen : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.LOOKUP, "department",
							tab)
					+ "Proyek : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.LOOKUP,
							"project", tab)
					+ "\r\n";

			tab = "//div[starts-with(@id,'tab-notes')]";
			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			content = content + "Keterangan" + "\r\n" + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN,
					ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";
			break;

		case "biaya lain":
			tab = "//div[starts-with(@id,'tab-detailexpense')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
			content = content + "Biaya Lain" + "\r\n" + "Nama : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.TEXTFIELD,
							"expenseName", tab)
					+ "Jumlah : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.NUMBERFIELD,
							"expenseAmount", tab)
					+ "Departemen : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.LOOKUP, "department",
							tab)
					+ "Proyek : " + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN, ElementType.LOOKUP,
							"project", tab)
					+ "\r\n";

			tab = "//div[starts-with(@id,'tab-expensenotes')]";
			AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
			content = content + "Keterangan" + "\r\n" + AccTool.getTextValue(driver, AccurateModule.PENAWARAN_PENJUALAN,
					ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";
			break;
		}

		AccTool.writeTextFile(param.filename, content);
	}

	public static void klikTabInfoLainnya(WebDriver driver, PenawaranPenjualanParam param) {
		AccTool.click(driver,
				AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}

	public static void klikTabBiayaLainnya(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-expense')]");
	}
	
	public static void klikTabRincianBarang(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-item')]");
	}

	public static void klikTabInformasiPesanan(WebDriver driver, PenawaranPenjualanParam param) {
		AccTool.click(driver, AccurateModule.PENAWARAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-summary')]");
	}

	public static void klikProsesPesan(WebDriver driver) {
		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name='btnProcess']");
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pesanan']");
	}

	public static void klikProsesPengiriman(WebDriver driver) {
		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnProcess']");
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pengiriman']");
	}

	public static void klikProsesFaktur(WebDriver driver) {
		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnProcess']");
		AccTool.click(getWebDriver(), w + "//a[text() = 'Faktur']");
	}

	public static void ambilFavorit(WebDriver driver, PenawaranPenjualanParam param) {
//		AccTool.dropDown(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN.getXpath(),
//				"//div[contains(@class, 'offset4 span8')]/div[1]", "Favorit");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
		
		//ui baru
				String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();
				AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//				WaitTool.delay(500);

				// pastikan drop down sudah visible
				WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENAWARAN_PENJUALAN.getXpath()
						+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-memorize-transaction')]"), 3);
				AccTool.click(getWebDriver(), w + "//a[text() = 'Favorit']");

//				WaitTool.delay(500);

				// pastikan window popup cari pengiriman sudah visible
				WaitTool.waitForElementVisible(getWebDriver(),
						By.xpath("//div[contains(@id, 'copy-memorize-transaction')]//input[@name='lookup']"), 3);
				if (param.search != null)
					AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
	}

	public static void klikLanjutTabFavorit(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'copy-memorize-transaction')]//*[@name='btnNext']");
	}

	public static void saveListDetailBarang(WebDriver driver, String filename) {
		log.info("Pengeluaran.SaveList");

		String content = " PenawaranPenjualan.SaveListDetailBarang" + "\r\n";
		String tab = "//*[contains(@id,'tab-item')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	public static void saveListBiayaLainnya(WebDriver driver, String filename) {
		log.info("PenawaranPenjualan.SaveListBiayaLain");

		String content = "PenawaranPenjualan.SaveListBiayaLain " + "\r\n";
		String tab = "//*[contains(@id,'tab-expense')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.PENAWARAN_PENJUALAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	// dibuat tanggal 14 mei 2018
	// close detail barang
	public static void klikTutupPopUpRincianDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	// dibuat tanggal 14 mei 2018
	// close detail biaya lainnya
	public static void klikTutupPopUpRincianBiayaLainnya(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikHapusPenjual(WebDriver driver, String keyword) {
		AccTool.clearLookup2(getWebDriver(), "@name='salesmanList'", keyword);
	}

	public static void klikUbahPenjual(WebDriver driver, PenawaranPenjualanParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PENAWARAN_PENJUALAN.getXpath(),
				"//div[contains(@class, 'span1')]/div[1]", "Ubah Tenaga Penjual");

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

	public static void ubahTarifPPN(WebDriver driver, PenawaranPenjualanParam param) {
		log.info("PenawaranPenjualan.UbahTarifPPN");

		String w = AccurateModule.PENAWARAN_PENJUALAN.getXpath();

		String u = "";

		AccTool.click(getWebDriver(), w + "//*[@name='btnPpnPercent']");
		if (param.tarifppn != null)
			AccTool.combobox(driver, u, "@name='tax1Rate'", param.tarifppn);
		AccTool.click(getWebDriver(), "//div[starts-with(@id,'accurate__input-ppn-percentage')]//*[@name='btnNext']");
	}

}