package com.cpssoft.web.test.accurate.tool;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pembayaran.PembayaranParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PembayaranTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PembayaranTool.class);

	public static void klikBtnHapusListDataPembayaran(WebDriver driver) {
		String path = "//*[contains(@id,'detail-other-payment')]//button[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnLanjutPembayaran(WebDriver driver) {
		String path = "//*[contains(@id,'detail-other-payment')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnLanjutPembayaranAmbilFavorit(WebDriver driver) {
		String path = "//*[contains(@id,'copy-memorize-transaction')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnLanjutAmbilPembayaranBeban(WebDriver driver) {
		String path = "//*[contains(@id,'accurate__general-ledger__outstanding-expense-for-payment')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnLanjutAmbilPembayaranGaji(WebDriver driver) {
		String path = "//*[contains(@id,'accurate__cash-bank__outstanding-employee-payment-for-payment')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnLanjutAmbilPPhPembelian(WebDriver driver) {
		String path = "//*[contains(@id,'accurate__vendor__outstanding-purchase-pph-for-payment')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnLanjutAmbilPPhPenjualan(WebDriver driver) {
		String path = "//*[contains(@id,'accurate__customer__outstanding-sales-pph-for-payment')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void pilihDetailPembayaran(WebDriver driver, PembayaranParam param) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//div[@class='grid-canvas']/div["
				+ param.urutan + "]");
	}

	//baris ke 1
	public static void klikRincianPembayaran1(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//*[@class='grid-canvas']/div[1]");
	}

	//baris ke 2
	public static void klikRincianPembayaran2(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//*[@class='grid-canvas']/div[2]");
	}
	
	//baris ke 3
	public static void klikRincianPembayaran3(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//*[@class='grid-canvas']/div[3]");
	}
	
	//baris ke 4
	public static void klikRincianPembayaran4(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//*[@class='grid-canvas']/div[4]");
	}
	
	//baris ke 5
	public static void klikRincianPembayaran5(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//*[@class='grid-canvas']/div[5]");
	}

	//baris ke 6
	public static void klikRincianPembayaran6(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//*[@class='grid-canvas']/div[6]");
	}

	public static void klikRincianPembayaranBiayaLain1(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//*[@class='grid-canvas']/div[1]");
	}

	public static void klikRincianPembayaranBiayaLain2(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//*[@class='grid-canvas']/div[2]");
	}

	public static void klikRincianPembayaranBiayaLain3(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-other-payment-grid-list')]//*[@class='grid-canvas']/div[3]");
	}

	public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMBAYARAN.getXpath() + "//a[contains(@href,'#tab-otherheader')]");
	}

	public static void klikAmbilPencatatanBeban(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Beban");
		
		if(param.tanggalAwalJatuhTempo != null) {
			AccTool.datePicker(driver, "", "@name='dueFromDate'", param.tanggalAwalJatuhTempo);
			AccTool.waitProgressBar(driver);
		}
		
		if(param.tanggalAKhirJatuhTempo != null) {
			AccTool.datePicker(driver, "", "@name='dueFromTo'", param.tanggalAKhirJatuhTempo);
			AccTool.waitProgressBar(driver);
		}
		String path = "//div[.='Pencatatan Beban']/ancestor::div[@class='caption']/following-sibling::div[@class='content']//*[@class = 'input-control checkbox no-margin']//span[1]";
		String path2 = "//div[.='Pencatatan Beban']/ancestor::div[@class='caption']/following-sibling::div[@class='content']//*[@class = 'input-control checkbox no-margin']//span[1]";
		AccTool.click(driver, path);
		AccTool.click(driver, path2);
		
	}

	public static void klikAmbilPencatatanBebanPopUp(WebDriver driver) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Beban");
	}

	public static void centangBeban(WebDriver driver, String[] nomorbeban) {
		AccTool.click(driver, "//div[contains(@id,'copy-expense-grid')]//span[@class='check']");
		if (nomorbeban != null) {
			for (int i = 0; i <= nomorbeban.length; i++) {
				String window = "//div[contains(@id,'copy-expense-grid')]";
				AccTool.click(driver, window + "//div[contains(@class,'r1') and text()='" + nomorbeban[i]
						+ "']//preceding-sibling::div[contains(@class,'r0')]//span[@class='check checkbox-grid']");
				i++;
			}
		}
	}

	// untuk centang semua pencatatan gaji yg ada
	public static void klikAmbilPencatatanGaji(WebDriver driver, PembayaranParam param)  {
		String tab = "//*[starts-with(@id,'accurate__cash-bank__outstanding-employee-payment-for-payment')]";
		
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		
		if (param.cariPencatatanGaji != null) {			
		AccTool.textField(driver,"", "@name='searchSalary'", param.cariPencatatanGaji );		
		driver.findElement(By.xpath("//input[@name='searchSalary']")).sendKeys(Keys.ENTER);
		}
		
		

		if (param.periodeBulanAmbilGaji != null) {
			WaitTool.delay(1000);
			AccTool.combobox(driver, tab, "@name='paymentMonth'", param.periodeBulanAmbilGaji);	}	
		
		if (param.periodeTahunAmbilGaji != null) {
			WaitTool.delay(1000);
			AccTool.combobox(driver, tab, "@name='paymentYear'", param.periodeTahunAmbilGaji);}
		
		String path = "//div[.='Pencatatan Gaji']/ancestor::div[@class='caption']/following-sibling::div[@class='content']//*[@class = 'input-control checkbox no-margin']//span[1]";
		String path2 = "//div[.='Pencatatan Gaji']/ancestor::div[@class='caption']/following-sibling::div[@class='content']//*[@class = 'input-control checkbox no-margin']//span[1]";
		AccTool.click(driver, path);
		AccTool.click(driver, path2);
	}

	// untuk centang gaji dan ppn di baris pertama
	public static void klikAmbilPencatatanGaji1(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[0]");
	}

	// untuk centang gaji dan ppn di baris kedua
	public static void klikAmbilPencatatanGaji2(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[1]");
	}

	// untuk centang gaji dan ppn di baris ketiga
	public static void klikAmbilPencatatanGaji3(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[2]");
	}

	// untuk centang gaji dan ppn di baris keempat
	public static void klikAmbilPencatatanGaji4(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[3]");
	}

	// untuk centang gaji dan ppn di baris kelima
	public static void klikAmbilPencatatanGaji5(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[4]");
	}

	// untuk centang gaji dan ppn di baris keenam
	public static void klikAmbilPencatatanGaji6(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[5]");
	}

	// untuk centang gaji dan ppn di baris ketujuh
	public static void klikAmbilPencatatanGaji7(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[6]");
	}

	// untuk centang gaji dan ppn di baris kedelapan
	public static void klikAmbilPencatatanGaji8(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[7]");
	}

	// untuk centang gaji dan ppn di baris kesembilan
	public static void klikAmbilPencatatanGaji9(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[8]");
	}

	// untuk centang gaji dan ppn di baris kesepuluh
	public static void klikAmbilPencatatanGaji10(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[9]");
	}

	// untuk centang gaji dan ppn di baris kesebelas
	public static void klikAmbilPencatatanGaji11(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Pencatatan Gaji");
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-expense-grid')]//*[@class = 'grid-canvas']/div[10]");
	}

	// hanya untuk baris pertama
	public static void klikRincianPembayaranGaji1(WebDriver driver, PembayaranParam param) {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'detail-other-payment-grid-list')]//*[@class = 'grid-canvas']/div[1]");
	}

	// hanya untuk baris kedua
	public static void klikRincianPembayaranGaji2(WebDriver driver, PembayaranParam param) {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'detail-other-payment-grid-list')]//*[@class = 'grid-canvas']/div[2]");
	}

	// hanya untuk baris ketiga
	public static void klikRincianPembayaranGaji3(WebDriver driver, PembayaranParam param) {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'detail-other-payment-grid-list')]//*[@class = 'grid-canvas']/div[3]");
	}

	// hanya untuk baris keempat
	public static void klikRincianPembayaranGaji4(WebDriver driver, PembayaranParam param) {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'detail-other-payment-grid-list')]//*[@class = 'grid-canvas']/div[4]");
	}

	public static void klikAmbilFavorit(WebDriver driver, PembayaranParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PEMBAYARAN.getXpath(), "//div[contains(@class, 'span12')]/div[1]",
				"Favorit");
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name=''", param.search);
	}

	// dibuat tanggal 20 februari 2018 untuk menutup pop up rincian pembayaran

	public static void klikTutupPopUpRincianPembayaran(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void isiForm(WebDriver driver, PembayaranParam param) {
		log.info("Pembayaran.IsiForm");

		String w = AccurateModule.PEMBAYARAN.getXpath();

		if (param.kasbank != null) {
			AccTool.lookup(driver, w, "@name='bank'", param.kasbank);
			AccTool.waitProgressBar(driver);
		}
		if (param.kurs != null)
			AccTool.numberField(driver, w, "@name='rate'", param.kurs);
		if (param.nocek != null)
			AccTool.textField(driver, w, "@name='chequeNo'", param.nocek);
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);

	}

	public static void isiDetail(WebDriver driver, PembayaranParam param) {
		log.info("Pembayaran.IsiDetail");

		String w = AccurateModule.PEMBAYARAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-detail')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-detail')]");
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}

	public static void isiInfoLain(WebDriver driver, PembayaranParam param) {
		log.info("Pembayaran.IsiInfoLain");

		String w = AccurateModule.PEMBAYARAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		if (param.nocek != null){
			AccTool.textField(driver, w, "@name='chequeNo'", param.nocek);
			AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
			if (param.tglcek != null)
				AccTool.datePicker(driver, w, "@name='chequeDate'", param.tglcek);
		}
		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.catatan);
		if (param.penerima != null)
			AccTool.textarea(driver, tab, "@name='payee'", param.penerima);
		if (param.cbvoid != null)
			AccTool.checkbox(driver, tab, "@name='voidCheq'", param.cbvoid);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);

	}

	public static void detailPembayaran(WebDriver driver, PembayaranParam param) {
		log.info("Pembayaran.detailPembayaran");

		String tab = "";

		if (param.tab != null)
			switch ((param.tab).toLowerCase()) {

			case "rincian pembayaran":
				tab = "//*[contains(@id,'tab-detailexpense')]";

				AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
				if (param.nilai != null) {
					AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
					AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
					WaitTool.delay(500);
				}
				if (param.departemenmandatory != null)
					AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
				if (param.proyekmandatory != null)
					AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
				break;
			//ui lama
//			case "catatan":
//				tab = "//div[starts-with(@id,'tab-notes')]";
//				AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
//				if (param.catatan != null)
//					AccTool.textarea(driver, tab, "@name='memo'", param.catatan);
//				break;
				
			//ui baru
			case "catatan":
				log.info("isi infolainnya");
				String tab1 = "//*[contains(@id,'tab-customfield')]";
				AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
				if (param.departemen != null)
					AccTool.lookup(driver, tab1, "@name='department'", param.departemen);
				if (param.proyek != null)
					AccTool.lookup(driver, tab1, "@name='project'", param.proyek);		
				if (param.catatan != null)
					AccTool.textarea(driver, tab1, "@name='memo'", param.catatan);
				break;
			}
	}

	public static void saveData(WebDriver driver, PembayaranParam param, String filename) {
		log.info("Pembayaran.SaveData");

		String w = param.w;
		String tab = "";
		String content = "Pembayaran.SaveData : " + "\r\n";

		switch (param.tab.toLowerCase()) {
		case "header":
			content = content 
					+ "Kas Bank : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.LOOKUP, "bank", tab)
					+ "No Cek : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.TEXTFIELD, "chequeNo", tab)
					+ "Tanggal Cek : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.DATEPICKER, "chequeDate", tab)
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.DATEPICKER, "transDate", tab)
					+ "No Bukti : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.TEXTFIELD, "number", tab)
					+ "\r\n";
			break;
		case "detail":
			AccTool.click(driver, w + "//a[contains(@href,'tab-detail')]");
			tab = w + "//*[contains(@id,'tab-detail')]";
			content = content + "Detail" + "\r\n" + AccTool.getGridValue(driver, AccurateModule.PEMBAYARAN, tab)
					+ "\r\n";
			break;

		case "info lain":
			AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
			tab = w + "//*[contains(@id,'tab-otherheader')]";
			content = content + "Info Lain" + "\r\n" + "Catatan : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.TEXTAREA, "description", tab)
					+ "\r\n";
			break;
		}

		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveHeader(WebDriver driver, String filename) {
		log.info("Pembayaran.SaveHeader");

		String tab = "";
		String content = "Pembayaran.SaveHeader : " + "\r\n";
		content = content 
				+ "Kas Bank : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.LOOKUP, "bank", tab)
				+ "Kurs : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.NUMBERFIELD, "rate", tab)
				+ "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.DATEPICKER, "transDate", tab)
				+ "No Bukti : "	
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.TEXTFIELD, "number", tab);
		
				String noTransakasi = "//*[contains(@id,'header-panel')]//*[contains(@class,'text-panel-disabled') and text()='V O I D']";
				if (WebElementTool.isElementExists(driver, By.xpath(noTransakasi))) {
					content = content 
							+ AccTool.getTextValue(driver,  "//*[contains(@id,'header-panel')]//*[contains(@class,'text-panel-disabled') and text()='V O I D']");


				}	
				content = content 
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetail(WebDriver driver, String filename) {
		log.info("Pembayaran.SaveDetail");

		String content = "Pembayaran.SaveDetail : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");

		content = content
				+ "Nilai : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amount", tab)
				+ "Departemen :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span") + "\r\n";
		//uilama
//		tab = "//div[starts-with(@id,'tab-notes')]";//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//uibaru
		tab = "//*[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//a[contains(@id,'tabcustomfield')]");
		
		String dept = "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
			content = content + "Departemen :"
		        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span");
		}
		
		String proy = "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
			content = content+ "Proyek :"
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span");
		}
		
		content = content
				+ "Catatan :"
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "memo", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveForm(WebDriver driver, String filename) {
		log.info("Pembayaran.SaveForm");

		String tab = "";
		String content = "Pembayaran.SaveForm : " + "\r\n";

		content = content
				+ "Kas Bank : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.LOOKUP, "bank", tab)
				+ "No Cek : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.TEXTFIELD, "chequeNo", tab)
				+ "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.DATEPICKER, "transDate", tab)
				+ "No Bukti : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.TEXTFIELD, "number", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveListDetailPembayaran(WebDriver driver, String filename) {
		log.info("Pembayaran.SaveListDetailPembayaran");
		String tab = "";
		String content = "Pembayaran.SaveListDetailPembayaran : " + "\r\n";
		tab = "//*[contains(@id,'tab-detail')]";
		content = content 
				+ AccTool.getGridValue(driver, AccurateModule.PEMBAYARAN, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveInfoLain(WebDriver driver, String filename) {
		log.info("Pembayaran.SaveInfoLain");

		AccTool.click(driver, AccurateModule.PEMBAYARAN.getXpath() + "//*[contains(@href,'tab-otherheader')]");
		String tab = "//*[contains(@id,'tab-otherheader')]";
		String content = "Pembayaran.SaveInfoLain : " + "\r\n";
		content = content
				+ "No Cek : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.TEXTFIELD, "chequeNo", tab)
				+ "Tanggal Cek : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.DATEPICKER, "chequeDate", tab)
				+ "Catatan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "description", tab)
				+ "Penerima : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "payee", tab)
				+ "Void : "
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "voidCheq", tab);
//				+ "Cabang : "
//				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "branch", tab)
				
				//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN, ElementType.SUMMARY, "branchListOption", tab);
				}
				
//				content = content + "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.TEXTAREA, "description")
				content = content
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
		

//	public static void saveListRincianPembayaran(WebDriver driver, String filename) {
//		log.info("Pembayaran.saveListRincianPembayaran");
//
//		String content = "Pembayaran.SaveListRincianPembayaran : " + "\r\n";
//		String tab = "//*[contains(@id,'tab-detail')]";
//		content = content
//				+ AccTool.getGridValue(driver, AccurateModule.PEMBAYARAN, tab)
//				+ "\r\n";
//		AccTool.writeTextFile(filename, content);
//	}

	public static void isiRincianPembayaran(WebDriver driver, PembayaranParam param) {
		log.info("Pembayaran.IsiRincian");

		log.info("Rincian Penerimaan");

		String tab = "//div[starts-with(@id,'tab-detailexpense')]";

		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");

		if (param.nilai != null)
			AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
	}
	
	public static void isiDetailTransaksiFavorit(WebDriver driver,PembayaranParam param)
	{
		String w ="//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]";
		if(param.namafavorit != null)
			AccTool.textField(driver, w, "@name='name'", param.namafavorit);	
		if(param.aksesgrupcabangfavorit != null)
			AccTool.lookup(driver, w, "@name='useUserRoleAccessList'", param.aksesgrupcabangfavorit);	
		if(param.aksespenggunafavorit != null)
			AccTool.textField(driver, w, "@name='useUserAccessList'", param.aksespenggunafavorit);	
//		if (param.Komentar != null)				
//	    AccTool.textarea(driver, a, "@name='comment'", param.Komentar);	
		
	}
	
	public static void editNilaiBayar(WebDriver driver,PembayaranParam param)
	{
		log.info("PembayarannGaji.EditNilai");

		String tab= "//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");

		AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
	}

}
