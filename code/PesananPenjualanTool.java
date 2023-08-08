package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penawaranpenjualan.PenawaranPenjualanParam;
import com.cpssoft.web.test.accurate.pengirimanpesanan.PengirimanPesananParam;
import com.cpssoft.web.test.accurate.pesananpenjualan.PesananPenjualanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PesananPenjualanTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PesananPenjualanTool.class);

	public static void isiForm(WebDriver driver, PesananPenjualanParam param) {
		log.info("PesananPenjualan.Isi");

		String w = AccurateModule.PESANAN_PENJUALAN.getXpath();

		if (param.dipesanoleh != null){
			AccTool.lookup(driver, w, "@name='customer'", param.dipesanoleh);
			AccTool.waitProgressBar(driver);
		}
		if (param.matauang != null)
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
		if (param.tanggal != null){
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
			AccTool.waitProgressBar(driver);
		}
		if (param.kurs != null){
			AccTool.numberField(driver, w, "@name='rate'", param.kurs);
			WaitTool.delay(100);
		}
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if (param.diskon != null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskon);
	}

	public static void isiDetailBarang(WebDriver driver, PesananPenjualanParam param) {
		log.info("PesananPenjualan.IsiDetailBarang");

		String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-item')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-item')]");

		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}

	//5 November 2018 tambah tutup pesanan
	
	public static void isiInfoLain(WebDriver driver, PesananPenjualanParam param) {
		log.info("PesananPenjualan.IsiInfoLain");

		String tab = AccurateModule.PESANAN_PENJUALAN.getXpath() + "//*[contains(@id,'tab-otherheader')]";
		String tab1 = AccurateModule.PESANAN_PENJUALAN.getXpath() + "//*[contains(@href,'tab-otherheader')]";
		AccTool.click(driver, tab1);

		if (param.alamat != null)
			AccTool.textarea(driver, tab, "@name='toAddress'", param.alamat);
		if (param.cbkenapajak != null)
			AccTool.checkbox(driver, tab, "@name='taxable'", param.cbkenapajak);
		if (param.cbtermasukpajak != null)
			AccTool.checkbox(driver, tab, "@name='inclusiveTax'", param.cbtermasukpajak);
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
		if(param.tutuppesanan != null)
			AccTool.checkbox(driver, "", "@data-bind='metroCheckbox: {}, checked: formData.manualClosed'", param.tutuppesanan);	
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
		
		//karakter 1
		try{
			WebElement combobox = driver.findElement(By.xpath("//div[@class='trans-detail-tab frame-left-tab frames']//select[1]"));
			if (param.karakter1 != null)
				AccTool.combobox(driver, tab, "@name='charField1'", param.karakter1);
			log.info("Try done");
		}catch(NoSuchElementException z) {
		
			if (param.karakter1 != null)
				AccTool.lookup(driver, tab, "@name='charField1'", param.karakter1);
			log.info("Catch done");
		}
	
		  //karakter 2
		try{
			WebElement combobox = driver.findElement(By.xpath("//div[@class='trans-detail-tab frame-left-tab frames']//select[1]"));
		
			if (param.karakter2 != null)
				AccTool.combobox(driver, tab, "@name='charField2'", param.karakter2);
			
			log.info("if done");
		}catch(NoSuchElementException z) {
			if (param.karakter2 != null)
				AccTool.lookup(driver, tab, "@name='charField2'", param.karakter2);			
			
			log.info("Catch done");
		}
	}
	
	// 26 juli 2019 tambah tutup item di pesanan penjualan
	
	public static void klikTutupItem(WebDriver driver) {
		AccTool.click(driver, "//div[starts-with(@id,'tab-detailitem')]//*[@class = 'input-control checkbox no-margin']");
	}
	
	
	public static void klikTabBiayaLainnya(WebDriver driver) {
		String tab =AccurateModule.PESANAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-expense')]";
		WaitTool.waitForElementClickable(driver, By.xpath(tab), 7);
		AccTool.click(driver, AccurateModule.PESANAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-expense')]");
	}

	public static void klikLanjutItem(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 20);
		AccTool.waitLoadingMask(driver);
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikTutupPopUpRincianDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikLanjutDiskonBawah(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__input-percentage')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);
	}

	public static void klikLanjutPenawaran(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'copy-sales-quotation')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);
	}

	public static void klikLanjutBiaya(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);
		
	}

	public static void klikHapusItem(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[@name='btnDelete']");
		AccTool.waitProgressBar(driver);
	}

	public static void klikHapusBiaya(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[@name='btnDelete']");
		AccTool.waitProgressBar(driver);
	}

	public static void isiBiayaLain(WebDriver driver, PesananPenjualanParam param) {
		log.info("PesananPenjualan.IsiBiayaLain");

		String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-expense')]";
		
		AccTool.click(driver, AccurateModule.PESANAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-expense')]");
		
		if (param.search != null)
			AccTool.lookup(driver, w, "@name='searchDetailAccount'", param.search);
			AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}

	public static void detailBarang(WebDriver driver, PesananPenjualanParam param) {
		String tab = "";

		switch ((param.tab).toLowerCase()) {
		case "detail barang":
			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			if (param.nama != null)
				AccTool.textField(driver, tab, "@name='detailName'", param.nama);
			//WaitTool.delay(100);
			WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
			if (param.kuantitas != null){
				//WaitTool.delay(100);
//				WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 1);
				AccTool.numberField(getWebDriver(), tab, "@name='quantity'", param.kuantitas);
				AccTool.click(getWebDriver(), "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(getWebDriver());
			}
		   
			if (param.unit != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
			if(param.harga != null) {
				AccTool.numberField(getWebDriver(), tab, "@name='unitPrice'", param.harga);
//				AccTool.click(getWebDriver(), "//a[contains(@href,'tab-detailitem')]");
				//WaitTool.delay(300);
//				WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 1);
				AccTool.waitLoaderMedium(getWebDriver());
			}
			if (param.gudang != null)
				AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
			if(param.diskonpersen != null){
				AccTool.numberField(driver, tab, "@name='itemDiscPercent'", param.diskonpersen);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
				}
			if (param.diskon != null)
				AccTool.numberField(driver, tab, "@name='itemCashDiscount'", param.diskon);
			if (param.ppn != null)
				AccTool.checkbox(getWebDriver(), tab, "@name='useTax1'", param.ppn);
			if (param.ppnbm != null)
				AccTool.checkbox(getWebDriver(), tab, "@name='useTax2'", param.ppnbm);
			if (param.departemenmandatory != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if (param.proyekmandatory != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
			 if (param.gudang != null)
					AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
			if (param.penjual != null)
				AccTool.lookupWithoutClear(driver, tab, "@name='salesmanList'", param.penjual);
			
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
			
			//if(param.tutupitem != null)
			//	AccTool.checkbox(driver, "//div[starts-with(@id,'tab-detailitem')]", "@data-bind='metroCheckbox: {}, checked: formData.manualClosed'", param.tutupitem);	
			break;
			
		case "infolain":
			tab = "//div[starts-with(@id,'tab-customfield')]";
			AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");

				//karakter 1
			try{
				WebElement lookup = driver.findElement(By.xpath("//div[@class='mask-wrapper']//div[@class='frame-tab-popup frames']//div[@class='row no-margin']/div[1]//input"));
			
				if (param.karakter1 != null)
					AccTool.lookup(driver, tab, "@name='charField1'", param.karakter1);
				log.info("if done");
			}catch(NoSuchElementException z) {
								
				if (param.karakter1 != null)
					AccTool.combobox(driver, tab, "@name='charField1'", param.karakter1);
			}
		
			  //karakter 2
			try{
				WebElement lookup = driver.findElement(By.xpath("//div[@class='mask-wrapper']//div[@class='frame-tab-popup frames']/div[@class='frame active']//input[1]"));
			
				if (param.karakter2 != null)
					AccTool.lookup(driver, tab, "@name='charField2'", param.karakter2);
				log.info("if done");
			}catch(NoSuchElementException z) {
								
				if (param.karakter2 != null)
					AccTool.combobox(driver, tab, "@name='charField2'", param.karakter2);
			}
//		case "keterangan":
//			tab = "//div[starts-with(@id,'tab-notes')]";
//			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
//			if (param.keterangan != null)
//				AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
//			break;
			
		//ui baru
		case "keterangan":
			tab = "//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]";
			AccTool.click(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tabcustomfield')]");
			if (param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if (param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
			break;
		}
	}
	
	
	
	public static void saveAtributTambahanInfoLainnya(WebDriver driver, String filename) {
		log.info("save InfoLain");
		String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		String content = "PesananPenjualan.saveAtributTambahanInfoLainnya ; " + "\r\n";
		
		content = content + "\r\n";
				
				String atribut1 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved1')]";
				if (WebElementTool.isElementExists(driver, By.xpath(atribut1))) {
					content = content + "Karakter 1 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField1",tab);	
				} 
//				else {
//					content = content + "Karakter 1 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField1",tab);
//				}
				
				String atribut2 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved2')]";
				if (WebElementTool.isElementExists(driver, By.xpath(atribut2))) {
					content = content + "Karakter 2 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField2",tab);	
				} 
//				else {
//					content = content + "Karakter 2 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField2",tab);
//				}
				
				String atribut3 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved3')]";
				if (WebElementTool.isElementExists(driver, By.xpath(atribut3))) {
					content = content + "Karakter 3 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField3",tab);
				} 
//				else {
//					content = content + "Karakter 3 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField3",tab);
//				}
				
				String atribut4 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved4')]";
				if (WebElementTool.isElementExists(driver, By.xpath(atribut4))) {
					content = content + "Karakter 4 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField4",tab);
				}
//				else {
//					content = content + "Karakter 4 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField4",tab);
//				}
				
				String atribut5 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved5')]";
				if (WebElementTool.isElementExists(driver, By.xpath(atribut5))) {
					content = content + "Karakter 5 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField5",tab);
				} 
//				else {
//					content = content + "Karakter 5 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField5",tab);
//				}
				
				String atribut6 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved6')]";
				if (WebElementTool.isElementExists(driver, By.xpath(atribut6))) {
					content = content + "Karakter 6 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField6",tab);
				}
//				else {
//					content = content + "Karakter 6 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField6",tab);
//				}
				
				String atribut7 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved7')]";		
				if (WebElementTool.isElementExists(driver, By.xpath(atribut7))) {
					content = content + "Karakter 7 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField7",tab);
				} 
//				else {
//					content = content + "Karakter 7 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField7",tab);
//				}
				
				String atribut8 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved8')]";	
				if (WebElementTool.isElementExists(driver, By.xpath(atribut8))) {
					content = content + "Karakter 8 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField8",tab);
				} 
//				else {
//					content = content + "Karakter 8 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField8",tab);
//				}
				
				String atribut9 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved9')]";	
				if (WebElementTool.isElementExists(driver, By.xpath(atribut9))) {
					content = content + "Karakter 9 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField9",tab);
				}
//				else {
//					content = content + "Karakter 9 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField9",tab);
//				}
				
				String atribut10 = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomCharReserved10')]";	
				if (WebElementTool.isElementExists(driver, By.xpath(atribut10))) {
					content = content + "Karakter 10 : "
							+ AccTool.getTextValue(driver, ElementType.LOOKUP, "charField10",tab);
				} 
//				else {
//					content = content + "Karakter 10 : "
//							+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField10",tab);
//				}
				
				String angka = "//div[starts-with(@id,'tab-otherheader')]//label[contains(@data-bind,'salesOrderCustomNumericReserved')]";	
				if (WebElementTool.isElementExists(driver, By.xpath(angka))) {
				content = content 
					+ "Angka 1 : "
					+ AccTool.getTextValue(driver, ElementType.TEXTFIELD,
							"numericField1", tab)
					+ "Angka 2 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"numericField2", tab)
					+ "Angka 3 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"numericField3", tab)
					+ "Angka 4 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"numericField4", tab)
					+ "Angka 5 : " 
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD, 
							"numericField5", tab)
					+ "Angka 6 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"numericField6", tab)
					+ "Angka 7 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"numericField7", tab)
					+ "Angka 8 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"numericField8", tab)
					+ "Angka 9 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"numericField9", tab)
					+ "Angka 10 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"numericField10", tab)
					+ "Tanggal 1 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"dateField1", tab)
					+ "Tanggal 2 : "
					+ AccTool.getTextValue(driver,  ElementType.TEXTFIELD,
							"dateField2", tab);
				}
				content = content 
					+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}


	public static void detailBiayaLainnya(WebDriver driver, PesananPenjualanParam param) {
		log.info("PesananPenjualan.detailBiayaLainnya");
		String tab = "";

		if (param.tab != null)
			switch ((param.tab).toLowerCase()) {

			case "biaya lain":
				tab = "//*[contains(@id,'tab-detailexpense')]";
				AccTool.click(driver, "//*[contains(@id,'tabdetailexpense')]");
				if (param.namabiaya != null)
					AccTool.textField(driver, tab, "@name='expenseName'", param.namabiaya);
				if (param.jumlah != null)
					AccTool.numberField(driver, tab, "@name='expenseAmount'", param.jumlah);
				//WaitTool.delay(100);
				WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
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

	public static void saveDetailBarang(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveDetailBarang");

		String tab = "";
		String content = "PesananPenjualan.SaveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
//		AccTool.click(driver, "//a[contains(@id,'tab-detailitem')]");
		content = content + "\r\n" + "Nama : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab) + "Kuantitas : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) + "Harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab) + "Diskon Persen : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemDiscPercent", tab) + "Diskon : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab) + "Penjual : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "salesmanList", tab)
				+ "Departemen : " + AccTool.getTextValue(driver,  "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek : " + AccTool.getTextValue(driver,  "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span");
		
		// Gudang ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
				String namagudang = "//*[contains(@id,'tab-detailitem')]//div[input[@name='warehouse']]";
				if (WebElementTool.isElementExists(driver, By.xpath(namagudang))) {
				content = content + "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab);
				} else {
				content = content + "Gudang : "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.warehouse().name", tab);
				}
				
				content = content 
						+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	//menyimpan stok dapat dijual
	public static void saveDetailBarang2(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveDetailBarang");

		String tab = "";
		String content = "PesananPenjualan.SaveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		content = content + "\r\n" 
				+ "Nama : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab) 
				+ "Kuantitas : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
				+ "Harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab) 
				+ "Diskon Persen : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab) 
				+ "Total Harga : "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.totalPrice())", tab)
				+ "Stok Dapat Dijual : "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "availableStockUnit", tab)  
				+ "Departemen : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab) 
				+ "Proyek : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab);
		
			// Gudang ada 2 kondisi, berupa Lookup atau DIV-SUMMARY
			String namagudang = "//*[contains(@id,'tab-detailitem')]//div[input[@name='warehouse']]";
			if (WebElementTool.isElementExists(driver, By.xpath(namagudang))) {
			content = content + "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab);
			} else {
			content = content + "Gudang : "
			+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.warehouse().name", tab);
			}
		
			content = content 
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	//menyimpan detail barang multisatuan
	public static void saveDetailBarangSatuan(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveDetailBarang");

		String tab = "";
		String content = "PesananPenjualan.SaveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
//		AccTool.click(driver, "//a[contains(@id,'tab-detailitem')]");
		
		String stok = "//span[contains(@data-bind, 'formData.availableStockUnit')]";
		if(WebElementTool.isElementExists(driver, By.xpath(stok)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//span[contains(@data-bind, 'formData.availableStockUnit')]/preceding-sibling::span").replace(",", " : ")
					+ AccTool.getTextValue(driver, "//span[contains(@data-bind, 'formData.availableStockUnit')]");
		}
		
		content = content 
				+ "\r\n" + "Nama : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab) + "Kuantitas : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)+ "Satuan : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemUnit", tab) + "Harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab) + "Diskon Persen : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemDiscPercent", tab) + "Diskon : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab) + "Penjual : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "salesmanList", tab)
				+ "Departemen : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab) 
				+ "Proyek : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab) 
				+ "\r\n";
				
		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailBarangManufaktur(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveDetailBarang");

		String tab = "";
		String content = "PesananPenjualan.SaveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content + "\r\n" + "Nama : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab) + "Kuantitas : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) + "Harga : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab) + "Diskon Persen : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemDiscPercent", tab) + "Diskon : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab) + "Penjual : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "salesmanList", tab)+ "Departemen : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab) + "Proyek : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab)
				+ "Rencana Produksi : "
				+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'viewManufactureOrder')]/div[1]")
				+ "Progres Rencana Produksi : "
				+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'viewManufactureOrder')]/div[2]")
				+ "\r\n";
				
		AccTool.writeTextFile(filename, content);
	}
	
public static void saveAtributTambahanRincianBarangMandatory(WebDriver driver, String filename) {
		
		String content = "PesananPenjualan.saveAtributTambahanRincianBarangMandatory ; " + "\r\n";
		
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
	
public static void saveAtributTambahanRincianBarang(WebDriver driver, String filename) {

	String content = "PesananPenjualan.saveAtributTambahanRincianBarang ; " + "\r\n";

	String tab = "//div[starts-with(@id,'details-tab')]//div[starts-with(@id,'tab-customfield')]";
	AccTool.click(driver, "//*[starts-with(@id,'details-tab')]//*[starts-with(@id,'tabcustomfield')]");
	content = content + "\r\n";

	String atribut1 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved1')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut1))) {
		content = content + "Karakter 1 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField1", tab);
	} 
//	else {
//		content = content + "Karakter 1 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField1", tab);
//	}
	String atribut2 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved2')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut2))) {
		content = content + "Karakter 2 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField2", tab);

	}
//	else {
//		content = content + "Karakter 2 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField2", tab);
//	}
	String atribut3 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved3')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut3))) {
		content = content + "Karakter 3 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField3", tab);
	} 
//	else {
//		content = content + "Karakter 3 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField3", tab);
//	}
	String atribut4 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved4')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut4))) {
		content = content + "Karakter 4 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField4", tab);
	} 
//	else {
//		content = content + "Karakter 4 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField4", tab);
//	}
	String atribut5 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved5')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut5))) {
		content = content + "Karakter 5 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField5", tab);
	} 
//	else {
//		content = content + "Karakter 5 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField5", tab);
//	}
	String atribut6 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved6')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut6))) {
		content = content + "Karakter 6 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField6", tab);
	} 
//	else {
//		content = content + "Karakter 6 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField6", tab);
//	}
	String atribut7 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved7')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut7))) {
		content = content + "Karakter 7 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField7", tab);
	}
//	else {
//		content = content + "Karakter 7 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField7", tab);
//	}
	String atribut8 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved8')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut8))) {
		content = content + "Karakter 8 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField8", tab);
	}
//	else {
//		content = content + "Karakter 8 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField8", tab);
//	}
	String atribut9 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved9')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut9))) {
		content = content + "Karakter 9 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField9", tab);
	}
//	else {
//		content = content + "Karakter 9 : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField9", tab);
//	}
	String atribut10 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved10')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut10))) {
		content = content + "Karakter 10 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField10", tab);
	} 
//	else {
//		content = content + "Karakter 10 : "
//				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField10", tab);
//	}
	String atribut11 = "//div[starts-with(@id,'tab-customfield')]//*[contains(@data-bind,'detailTransactionCustomCharReserved11')]";
	if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
		content = content + "Karakter 11 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField11", tab);
	} 
//	else {
//		content = content + "Karakter 11 : "
//				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField11", tab);
//	}

	if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
		content = content + "Karakter 12 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField12", tab);
	}
//	else {
//		content = content + "Karakter 12 : "
//				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField12", tab);
//	}
	if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
		content = content + "Karakter 13 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField13", tab);
	} 
//	else {
//		content = content + "Karakter 13 : "
//				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField13", tab);
//	}

	if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
		content = content + "Karakter 14 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField14", tab);
	}
//	else {
//		content = content + "Karakter 14 : "
//				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField14", tab);
//	}
	if (WebElementTool.isElementExists(driver, By.xpath(atribut11))) {
		content = content + "Karakter 15 : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "charField15", tab);
	} 
//	else {
//		content = content + "Karakter 15 : "
//				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "charField15", tab);
//	}

	
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
	
	public static void saveKeteranganDetailBarang(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveDetailBarang");

		String tab = "//*[starts-with(@id,'detail-item')]//*[contains(@id,'customfield-item')]";
		String content = "PesananPenjualan.SaveKeteranganDetailBarang : " + "\r\n";
		AccTool.click(driver, "//*[starts-with(@id,'detail-item')]//*[starts-with(@id,'tabcustomfield')]");
		content = content  
				+ "Departemen : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab) 
				+ "Proyek : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab) 
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";
		
		String atribut = "//div[contains(@data-bind,'viewManufactureOrder')]/div[1]";
		if (WebElementTool.isElementExists(driver, By.xpath(atribut))) {
			content = content
					+ "Rencana Produksi : "
					+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'viewManufactureOrder')]/div[1]")
					+ "Progres Rencana Produksi : "
					+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'viewManufactureOrder')]/div[2]")
					+ "\r\n";
		}

		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailBiayaLain(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveDetailBiayaLain");

		String tab = "";
		String content = "PesananPenjualan.SaveDetailBiayaLain : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		content = content + "\r\n" + "Nama : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab) + "Jumlah : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "expenseAmount", tab) 
				+ "Departemen : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span") 
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveKeteranganDetailBiayaLain(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveDetailBiayaLain");

		String content = "PesananPenjualan.SaveDetailBiayaLain :";
		String tab = "//*[starts-with(@id,'expenses-tab')]//*[contains(@id,'customfield-expense')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
		//ui baru
		AccTool.click(driver, "//*[starts-with(@id,'expenses-tab')]//*[starts-with(@id,'tabcustomfield')]");	
		content = content   + "\r\n"
				+ "Departemen : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab) 
				+ "Proyek : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab)
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveIsiHeader");
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.PESANAN_PENJUALAN.getXpath()+"//*[contains(@id,'header-panel')]"), 500);
		String tab = "";
		String content = "PesananPenjualan.SaveHeader : " + "\r\n";
		content = content +  "\r\n" + "Dipesan Oleh : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.LOOKUP, "customer", tab)
				+ "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.SUMMARY, "text: formData.currency().code", tab)
				+ "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.DATEPICKER, "transDate",tab)
				+ "Kurs : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD, "rate", tab);
				
				String nofaktur = "//div[@class='input-control text']/input[@name='number']";
				if (WebElementTool.isElementVisible(driver, By.xpath(nofaktur))) {
					content = content + "Nomor : "
							+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.TEXTFIELD, "number", tab);
					}
				else {
					content = content  + "Nomor : "
							+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'text: formData.number')]");
					}
				
			content = content	
				
				+ "Diskon : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiDetailBarang(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveIsiDetailBarang");

		String tab = "";
		String content = "PesananPenjualan.SaveDetailBarang : " + "\r\n";
		tab = "//*[contains(@id,'tab-item')]";
		content = content  + "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PESANAN_PENJUALAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiBiayaLain(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveIsiBiayaLain");

		String tab = "";
		String content = "PesananPenjualan.SaveBiayaLain : " + "\r\n";
		tab = "//*[contains(@id,'tab-expense')]";
		content = content + "\r\n" + AccTool.getGridValue(driver, AccurateModule.PESANAN_PENJUALAN, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiInfoLain(WebDriver driver, String filename) {
		log.info("PesananPembelian.SaveIsiInfoLain");

		String tab = "//*[contains(@id,'tab-otherheader')]";
		String content = "PesananPenjualan.SaveInfoLain : " + "\r\n";

		content = content + "\r\n" + "Alamat : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.TEXTAREA, "toAddress", tab)
				+ "Kena Pajak : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.CHECKBOX, "taxable", tab)
				+ "Termasuk Pajak : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.CHECKBOX, "inclusiveTax",
						tab)
				+ "Tanggal Pengiriman : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.DATEPICKER, "shipDate",
						tab)
				+ "Pengiriman : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.LOOKUP, "shipment", tab)
				+ "Syarat Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.LOOKUP, "paymentTerm", tab)
				+ "FOB : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.LOOKUP, "fob", tab)
				+ "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.TEXTAREA,
						"description", tab);
		   String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
	        if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
	            content = content + "Cabang : "
	                    + AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.COMBOBOX, "branch", tab);
	        } else {
	            content = content + "Cabang : "
	                    + AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.SUMMARY, "branchListOption", tab);
	        }
			    content = content
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void klikAmbilPenawaran(WebDriver driver, PesananPenjualanParam param) {
//		AccTool.dropDown(driver, AccurateModule.PESANAN_PENJUALAN.getXpath(), "//div[@class='offset4 span8']/div[1]",
//				"Penawaran");
//		if (param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-quotation')]", "@name='lookup'", param.search);
		
		//ui baru
				String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
				AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//				WaitTool.delay(500);

				// pastikan drop down sudah visible
				WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PESANAN_PENJUALAN.getXpath()
						+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-sales-quotation')]"), 3);
				AccTool.click(getWebDriver(), w + "//a[text() = 'Penawaran']");

//				WaitTool.delay(500);

				// pastikan window popup cari pengiriman sudah visible
				WaitTool.waitForElementVisible(getWebDriver(),
						By.xpath("//div[contains(@id, 'copy-sales-quotation')]//input[@name='lookup']"), 3);
				if (param.search != null)
					AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-quotation')]", "@name='lookup'", param.search);
	}

	public static void klikAmbilFavorit(WebDriver driver, PesananPenjualanParam param) {
//		AccTool.dropDown(driver, AccurateModule.PESANAN_PENJUALAN.getXpath(), "//div[@class='offset4 span8']/div[1]",
//				"Favorit");
//		if (param.tab != null)
//			switch (param.tab.toLowerCase()) {
//			case "detail barang":
//				String xpath = "//div[contains(@id,'copy-memorize-transaction')]//a[text()='Detail Barang']";
//				AccTool.click(driver, xpath);
//				if (param.search != null)
//					AccTool.lookup(driver, "//div[contains(@id,'copy-memorize-transaction')]", "@name='lookup'",
//							param.search);
				
				//ui baru
				String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
				AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//				WaitTool.delay(500);

				// pastikan drop down sudah visible
				WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PESANAN_PENJUALAN.getXpath()
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
	
	public static void klikProsesPengiriman(WebDriver driver)
	{
		String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnProcess']");
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pengiriman']");
		AccTool.waitLoadingMask(driver);
	}

	public static void klikProsesFaktur(WebDriver driver) {
		String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnProcess']");
		AccTool.click(getWebDriver(), w + "//a[text() = 'Faktur']");
		AccTool.waitLoadingMask(driver);
	}

	public static void klikProsesUangMuka(WebDriver driver) {
//		AccTool.dropDown(driver, AccurateModule.PESANAN_PENJUALAN.getXpath(), "//div[@class='offset4 span8']/div[2]",
//				"Uang Muka");
		String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnProcess']");
		AccTool.click(getWebDriver(), w + "//a[text() = 'Uang Muka']");
		AccTool.waitLoadingMask(driver);

	}

	public static void klikTabDetailBarang(WebDriver driver, PesananPenjualanParam param) {
		AccTool.click(driver, AccurateModule.PESANAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-item')]");
	}

	public static void klikTabInfoLainnya(WebDriver driver) // PesananPenjualanParam
															// //param)
	{
		AccTool.click(driver, AccurateModule.PESANAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}

	public static void klikTabBiayaLainnya(WebDriver driver, PesananPenjualanParam param) {
		AccTool.click(driver, AccurateModule.PESANAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-expense')]");
	}

	public static void klikTabInformasiPesanan(WebDriver driver, PesananPenjualanParam param) {
		AccTool.click(driver, AccurateModule.PESANAN_PENJUALAN.getXpath() + "//a[contains(@href, '#tab-summary')]");
	}

	public static void saveList(WebDriver driver, String filename) {
		log.info("PesananPenjualan.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "PesananPenjualan.SaveListPesanan : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.PESANAN_PENJUALAN, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooter(WebDriver driver, String filename) {
		log.info("Save Footer");
		String content = "PesananPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[1]";
		String tab11 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[2]";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
//		String tab4 = "//div[text()='PPh']/following-sibling::div";
		String tab4 ="";
		String tabpph = "//div[contains(@class, 'title') and text()[contains(.,'PPh')]]";
		
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
		}else {
			log.info("tidak masuk exists");
			
			tab4 = "//div[text()='PPh']/following-sibling::div";
		}
		
		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());
		
		//pastikan footer sudah tampil
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.PESANAN_PENJUALAN.getXpath()+"//*[contains(@id,'summary-panel')]"), 500);
		
		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab)
		+ "Diskon : "
		+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD,
				"itemCashDiscount");

		//untuk PPN
		String PPN = "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]";
		if(WebElementTool.isElementExists(driver, By.xpath(PPN)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@class, 'title inline-block') and 		text()[contains(.,'PPN')]]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab1).replace("\r\n", " ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab11);
		} else {
			content = content 
					+ "PPN 10% : " 
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab1);
		}
		
		String PPNBM = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]";
		if(WebElementTool.isElementExists(driver, By.xpath(PPNBM)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[1]").replace("\r\n", " ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[2]");
		}
		
		content = content 
		+ "Total Biaya : "
		+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab2) + "Total : "
		+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab3);
		
		//untuk PPh
		String PPH = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]";
		if(WebElementTool.isElementExists(driver, By.xpath(PPH)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab4);
		} else {
			content = content 
					+ "PPh : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab4);
		}
		
		content = content
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveFooterPPN11(WebDriver driver, String filename) {
		log.info("Save saveFooterPPN11");
		String content = "PesananPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
//		String tab4 = "//div[text()='PPh']/following-sibling::div";
		String tab4 ="";
		String tabpph ="//div[@class='title' and text()[contains(.,'PPh')]]";
		
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
		}else {
			log.info("tidak masuk exists");
			
			tab4 = "//div[text()='PPh']/following-sibling::div";
		}
		
		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());
		
		//pastikan footer sudah tampil
//		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.PESANAN_PENJUALAN.getXpath()+"//div[@class='trans-summary']"), 500);
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.PESANAN_PENJUALAN.getXpath()+"//*[contains(@class,'summary-panel')]"), 500);
		
		content = content + "Sub Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab1)
				+ "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab2)
				+ "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab3)
				+ "PPh : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab4)	
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	//Footer untuk PPH 23 (1 april 2019)
	
	public static void saveFooterpph23(WebDriver driver, String filename) {
		log.info("Save Footer");
		String content = "PesananPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";
		
		
		WaitTool.waitForElementClickable(driver, By.xpath(tab), 6);
		content = content + "Sub Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab1)
				+ "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab2)
				+ "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab3)
				+ "PPh 23 : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab4)	
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveFooterpph23ppn11(WebDriver driver, String filename) {
		log.info("Save Footer");
		String content = "PesananPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab2 = "//div[text()='Total Biaya']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		String tab4 = "//div[text()='PPh 23']/following-sibling::div";
		
		
		WaitTool.waitForElementClickable(driver, By.xpath(tab), 6);
		content = content + "Sub Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab1)
				+ "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab2)
				+ "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab3)
				+ "PPh 23 : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab4)	
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	

	public static void isiDiskon(WebDriver driver, PesananPenjualanParam param) {
		log.info("PesananPenjualan.IsiDiskon");

		String w = AccurateModule.PESANAN_PENJUALAN.getXpath();

		String u = "";

		if (param.diskonpop != null)
			AccTool.click(getWebDriver(), w + "//*[@name='btnDiscPercent']");
		AccTool.textField(driver, u, "@name='discountPercent'", param.diskonpop);

	}

	public static void saveListDetailBarang(WebDriver driver, String filename) {
		log.info("PesananPenjualan.saveListDetailBarang");

		String content = "PesananPenjualan.SaveListDetailBarang : " + "\r\n";
		String tab = "//*[contains(@id,'tab-item')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.PESANAN_PENJUALAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	//17 mei 2018
	
	public static void klikButtonCloseTabDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	
	//16 mei 2019 (untuk penggunaan barang pph22)
	public static void saveFooterPPH22(WebDriver driver, String filename) {
		log.info("Save Footer");
		String content = "PesananPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		//String tab4 = "//div[text()='PPh 22 2%']/following-sibling::div";
		String tab4 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";
		
		
		WaitTool.waitForElementClickable(driver, By.xpath(tab), 6);
		content = content + "Sub Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 10% : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab1)
				+ "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab3)
				+ "PPh 22 : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab4)	
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveFooterPPH22PPN11(WebDriver driver, String filename) {
		log.info("Save Footer");
		String content = "PesananPenjualan.saveFooter ; " + "\r\n";

		String tab = "//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab3 = "//div[text()='Total']/following-sibling::div";
		//String tab4 = "//div[text()='PPh 22 2%']/following-sibling::div";
		String tab4 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";
		
		
		WaitTool.waitForElementClickable(driver, By.xpath(tab), 6);
		content = content + "Sub Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab)
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD,
						"itemCashDiscount")
				+ "PPN 11% : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab1)
				+ "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab3)
				+ "PPh 22 : "
				+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab4)	
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	//17 mei 2019 (untuk penggunaan barang pph22 dan pph23)
		public static void saveFooterPPH22dan23(WebDriver driver, String filename) {
			log.info("Save Footer");
			String content = "PesananPenjualan.saveFooter ; " + "\r\n";

			String tab = "//div[text()='Sub Total']/following-sibling::div";
			String tab1 = "//div[text()='PPN 10%']/following-sibling::div";
			String tab3 = "//div[text()='Total']/following-sibling::div";
			//String tab4 = "//div[text()='PPh 22 2%']/following-sibling::div";
			String tab4 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";
			String tab5 = "//div[text()='PPh 23']/following-sibling::div";
			
			
			WaitTool.waitForElementClickable(driver, By.xpath(tab), 6);
			content = content + "Sub Total : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab)
					+ "Diskon : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD,
							"itemCashDiscount")
					+ "PPN 10% : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab1)
					+ "Total : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab3)
					+ "PPh 22 : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab4)
					+ "PPh 23: "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab5)	
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}
		
		public static void saveFooterPPH22dan23PPN11(WebDriver driver, String filename) {
			log.info("Save Footer");
			String content = "PesananPenjualan.saveFooter ; " + "\r\n";

			String tab = "//div[text()='Sub Total']/following-sibling::div";
			String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
			String tab3 = "//div[text()='Total']/following-sibling::div";
			//String tab4 = "//div[text()='PPh 22 2%']/following-sibling::div";
			String tab4 = "//div[contains(text(), 'PPh 22 ')]/following-sibling::div";
			String tab5 = "//div[text()='PPh 23']/following-sibling::div";
			
			
			WaitTool.waitForElementClickable(driver, By.xpath(tab), 6);
			content = content + "Sub Total : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab)
					+ "Diskon : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, ElementType.NUMBERFIELD,
							"itemCashDiscount")
					+ "PPN 11% : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab1)
					+ "Total : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab3)
					+ "PPh 22 : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab4)
					+ "PPh 23: "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PENJUALAN, tab5)	
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}
		
		//klik hapus penjual di detail barang
		public static void klikHapusPenjual (WebDriver driver, String keyword) {
			AccTool.clearLookup2(getWebDriver(), "@name='salesmanList'", keyword);
		}
		
		//klik hapus gudang di detail barang
		public static void klikHapusGudang (WebDriver driver, String keyword) {
			AccTool.clearLookup2(getWebDriver(), "@name='warehouse'", keyword);
		}
		
		//27 februari 2020 klik list
		
		public static void klikListBaris() 
		{
			AccTool.click(getWebDriver(), "//div[contains(@id,'module-grid-list')]//div[@class='grid-canvas']/div[1]");

		}
		
		
		public static void klikListBaris1() 
		{
			AccTool.click(getWebDriver(), "//*[contains(@class,'ui-widget-content slick-row odd')]");

		}
		
		public static void klikListBaris2() 
		{
			AccTool.click(getWebDriver(), "//*[contains(@class,'ui-widget-content slick-row even')]");

		}
		
		public static void ubahTarifPPN(WebDriver driver, PesananPenjualanParam param) {
			log.info("PesananPenjualan.UbahTarifPPN");

			String w = AccurateModule.PESANAN_PENJUALAN.getXpath();

			String u = "";
			
			AccTool.click(getWebDriver(), w + "//*[@name='btnPpnPercent']");
			if (param.tarifppn != null)
				AccTool.combobox(driver, u, "@name='tax1Rate'", param.tarifppn);
			AccTool.click(getWebDriver(),"//div[starts-with(@id,'accurate__input-ppn-percentage')]//*[@name='btnNext']");
			
		}
		public static void klikUbahPenjual(WebDriver driver, PesananPenjualanParam param) {
			AccTool.dropDown(getWebDriver(), AccurateModule.PESANAN_PENJUALAN.getXpath(),
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
		
		
		public static void saveIsiInfoPesanan(WebDriver driver, String filename)
		{
			log.info("PesananPenjualan.saveIsiInfoPesanan");
			

			if (WebElementTool.isElementVisible(driver, By.xpath("//*[contains(@class,'icn-transaction-info')]"))) {
				String xpath4 = "//*[contains(@class,'icn-transaction-info')]";
	        	AccTool.click(driver, xpath4);
			} else {
	            WaitTool.delay(200);
	        } 
	        		
//			
			//String tab = "";
			String content = "PesananPenjualan.SaveIsiInfoPermintaan : " + "\r\n";
			String rp = "Rp ";
			//tab = AccurateModule.PERMINTAAN_BARANG.getXpath() + "//*[contains(@id,'#tab-summary')]";
			content = content
					+ "Total : "+ rp + AccTool.getTextValue(driver,  "//*[contains(@data-bind,'formData.totalAmount')]")
					+ "Uang Muka : " + rp + AccTool.getTextValue(driver,  "//*[contains(@data-bind,'formData.totalDownPayment')]")
					+ "Uang Muka Terpakai : " + rp + AccTool.getTextValue(driver,  "//*[contains(@data-bind,'formData.totalDownPaymentUsed')]")
					+ "Sisa Uang Muka : " + rp + AccTool.getTextValue(driver,  "//*[contains(@data-bind,'formData.availableDownPayment')]")
					+ "Status : " + AccTool.getTextValue(driver,  "//*[contains(@data-bind,'doShowTransactionHistoryStatus')]")
					+ "Diproses Oleh : " 
					+ "\r\n"	
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'data.historyNumber')]")
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'data.historyDate')]")
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}
		
		public static void klikUbahGudang(WebDriver driver, PesananPenjualanParam param) {		
			String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
			AccTool.click(getWebDriver(), w + "//*[@class='icon-copy']");
//			WaitTool.delay(500);

			// pastikan drop down sudah visible
			WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PESANAN_PENJUALAN.getXpath()
					+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'setWarehouseDetail')]"), 3);
			AccTool.click(getWebDriver(), w + "//a[text() = 'Ubah Gudang']");

			// pastikan window popup cari pengiriman sudah visible
			WaitTool.waitForElementVisible(getWebDriver(),
					By.xpath("//input[@name='warehouse']"), 3);
			if (param.search != null)
				AccTool.lookup(driver, "//*[starts-with(@id,'accurate__inventory__set-warehouse-detail')]", "@name='warehouse'", param.search);
		}
		
		public static void klikLanjutUbahGudang(WebDriver driver) {
			AccTool.click(getWebDriver(), "//*[contains(@id,'tab-set-warehouse')]//*[@name='btnSet']");
			AccTool.waitProgressBar(getWebDriver());

		}
		
		public static void klikUbahGudangMasal(WebDriver driver, PesananPenjualanParam param) {		
			String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
			AccTool.click(getWebDriver(), w + "//*[@class='icon-copy']");
//			WaitTool.delay(500);

			// pastikan drop down sudah visible
			WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PESANAN_PENJUALAN.getXpath()
					+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'setWarehouseDetail')]"), 3);
			AccTool.click(getWebDriver(), w + "//a[text() = 'Ubah Gudang']");

			// pastikan window popup cari pengiriman sudah visible
			WaitTool.waitForElementVisible(getWebDriver(),
					By.xpath("//input[@name='warehouse']"), 3);
			if (param.search != null)
				AccTool.lookup(driver, "//*[starts-with(@id,'accurate__inventory__set-warehouse-detail')]", "@name='warehouse'", param.search);
		}
		
		public static void klikUbahGudangMasalTanpaPilihGudang(WebDriver driver) {		
			String w = AccurateModule.PESANAN_PENJUALAN.getXpath();
			AccTool.click(getWebDriver(), w + "//*[@class='icon-copy']");
//			WaitTool.delay(500);

			// pastikan drop down sudah visible
			WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PESANAN_PENJUALAN.getXpath()
					+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'setWarehouseDetail')]"), 3);
			AccTool.click(getWebDriver(), w + "//a[text() = 'Ubah Gudang']");

			// pastikan window popup cari pengiriman sudah visible
			WaitTool.waitForElementVisible(getWebDriver(),
					By.xpath("//input[@name='warehouse']"), 3);
		}


		public static void klikLanjutUbahGudangMasal(WebDriver driver) {
			AccTool.click(getWebDriver(), "//*[@name='btnSet']");
			AccTool.waitProgressBar(getWebDriver());

		}

		public static void cekButtonUbahMasal(WebDriver driver , String filename) {
			String button = "//*[@class='icon-copy']";
			String result = "tersedia terdapat button ubah masal";
			String warn = "tidak terdapat button ubah masal";	
			
			if (driver.findElements(By.xpath(button)).size() > 0) {
				log.info(result);
				result =  "\r\n" + result + "\r\n" + "\r\n";
				AccTool.writeTextFile(filename, result);
	        } else {
	        	log.info(warn);
				warn = "\r\n" + warn + "\r\n" + "\r\n";
				AccTool.writeTextFile(filename, warn);
			}
			WaitTool.delay(500);
		}
		
}
