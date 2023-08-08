package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penerimaanpenjualan.PenerimaanPenjualanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PenerimaanPenjualanTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PenerimaanPenjualanTool.class);

	public static void klikHitung(WebDriver driver) {
		String w = AccurateModule.PENERIMAAN_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnCalculate']");
		AccTool.waitProgressBar(driver);
	}

	public static void klikDistribusi(WebDriver driver) {
		String w = AccurateModule.PENERIMAAN_PENJUALAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnDistribute']");
		AccTool.waitProgressBar(driver);
	}

	public static void klikAmbil(WebDriver driver) {
		String w = AccurateModule.PENERIMAAN_PENJUALAN.getXpath();
//		WaitTool.delay(1000);
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1000);
	}

	public static void klikLanjutAmbil(WebDriver driver) {
		String xpath = "//div[contains(@id,'accurate__customer__outstanding-invoice-for-payment')]//button[@name='btnNext']";
		AccTool.click(getWebDriver(), xpath);
//		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 10);
		AccTool.waitProgressBar(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(2000);
	}
	
	public static void klikLanjutAmbilTukarFaktur(WebDriver driver) {
		String xpath = "//div[contains(@id,'copy-exchange-invoice')]//button[@name='btnNext']";
		AccTool.click(getWebDriver(), xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 10);
		AccTool.waitProgressBar(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1000);
	}

	public static void klikTambahDiskon(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[@name = 'btnAddDiscount']");
	}

	public static void klikTabInfoLain(WebDriver driver) {

		AccTool.click(getWebDriver(), "//a[contains(@href,'tab-otherheader')]");
	}
	public static void klikTabDiskon(WebDriver driver) {

		AccTool.click(getWebDriver(), "//a[contains(@href,'tab-discount')]");
	}

	public static void isiForm(WebDriver driver, PenerimaanPenjualanParam param) {
		log.info("PembayaranPenjualan.IsiForm");

		String w = AccurateModule.PENERIMAAN_PENJUALAN.getXpath();

		if (param.terimadari != null) {
			AccTool.lookup(driver, w, "@name='customer'", param.terimadari);
			AccTool.waitProgressBar(driver);
			AccTool.waitProgressBar(driver);
			String str1 = param.terimadari.toLowerCase();
			if (str1.contains("usd") || str1.contains("dolar") || str1.contains("dollar")) {
				AccTool.waitProgressBar(driver);
				AccTool.waitProgressBar(driver);
			}
//			WaitTool.delay(300);
		}
		if (param.bank != null) {
			AccTool.lookup(driver, w, "@name='bank'", param.bank);
			AccTool.waitProgressBar(driver);
			AccTool.waitProgressBar(driver);
		}
		
		if (param.metodebayar != null) {
	 		AccTool.combobox(driver, w, "@name='paymentMethod'", param.metodebayar);
	 		AccTool.waitLoadingMask(driver);
	    }
		
		if (param.matauang != null) {
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
			AccTool.waitProgressBar(driver);
			AccTool.waitProgressBar(driver);
//			WaitTool.delay(300);
		}
		if (param.kurs != null) {
			AccTool.numberField(driver, w, "@name='rate'", param.kurs);
			AccTool.click(getWebDriver(), "//div[contains(@id, 'module-accurate__customer__sales-receipt')]//label[@data-bind='text: ft.transDate.title']");
			AccTool.waitProgressBar(driver);
			AccTool.waitProgressBar(driver);
		}
		if (param.nocek != null) {
			AccTool.textField(driver, w, "@name='chequeNo'", param.nocek);
			AccTool.click(getWebDriver(), "//div[contains(@id, 'module-accurate__customer__sales-receipt')]//label[@data-bind='text: ft.transDate.title']");
		}
		if (param.nilaicek != null)
			AccTool.numberField(driver, w, "@name='chequeAmount'", param.nilaicek);
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if (param.tglpembayaran != null) {
			AccTool.datePicker(driver, w, "@name='transDate'", param.tglpembayaran);
			AccTool.waitProgressBar(driver);
		}
		if (param.tanggalcek != null)
			AccTool.datePicker(driver, w, "@name='chequeDate'", param.tanggalcek);
		if (param.kredit != null)
			AccTool.checkbox(driver, w, "@name='useCredit'", param.kredit);
		    AccTool.waitProgressBar(driver);
		if (param.returkredit != null)
			AccTool.checkbox(driver, w, "@name='returnOverpay'", param.returkredit);
		    AccTool.waitProgressBar(driver);

	}

	public static void isiDetailFaktur(WebDriver driver, PenerimaanPenjualanParam param) {
		log.info("PembayaranPenjualan.IsiDetailFaktur");

		String w = AccurateModule.PENERIMAAN_PENJUALAN.getXpath();

		String tab = w + "//*[contains(@id,'tab-invoice')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-invoice')]");

		AccTool.lookup(driver, tab, "@name='searchDetailInvoice'", param.search);
		AccTool.scrollRowDetail(driver, tab, param.scroll);
	}

	public static void isiInfoLain(WebDriver driver, PenerimaanPenjualanParam param) {
		log.info("PembayaranPenjualan.IsiInfoLain");

		String w = AccurateModule.PENERIMAAN_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");

		if (param.keterangan != null)
			AccTool.textarea(driver, "", "@name='description'", param.keterangan);
		if (param.cbvoid != null)
			AccTool.checkbox(driver, "", "@name='voidCheq'", param.cbvoid);
		if (param.cabang != null)
			AccTool.combobox(driver, "", "@name='branch'", param.cabang);
		if (param.metodebayar != null) {
	 		AccTool.combobox(driver, w, "@name='paymentMethod'", param.metodebayar);
	 		AccTool.waitLoadingMask(driver);
	    }
		if (param.nocek != null) 
			AccTool.textField(driver, w, "@name='chequeNo'", param.nocek);
		if (param.tanggalcek != null)
			AccTool.datePicker(driver, w, "@name='chequeDate'", param.tanggalcek);
	}

	public static void detailFaktur(WebDriver driver, PenerimaanPenjualanParam param) {
		log.info("PenerimaanPenjualan.DetailFaktur");

		String tab = "";

		switch ((param.tab).toLowerCase()) {
		case "faktur":
			tab = "//div[starts-with(@id,'tab-detailinvoice')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailinvoice')]");
			if (param.pembayaran != null)
				AccTool.numberField(driver, tab, "@name='paymentAmount'", param.pembayaran);
			if (param.cbpph23 != null)
				AccTool.checkbox(driver, tab, "@name='paidPph'", param.cbpph23);
			if (param.cbpphdisetorsendiri != null)
				AccTool.checkbox(driver, tab, "@name='selfPaidPph'", param.cbpphdisetorsendiri);
			if (param.nobuktipotong != null)
				AccTool.textField(driver, tab, "@name='pphNumber'", param.nobuktipotong);
			break;
		case "informasi diskon":
			tab = "//div[starts-with(@id,'tab-discount')]";
			AccTool.click(driver, "//a[contains(@href,'tab-discount')]");
			if (param.akundiskon != null)
				AccTool.lookup(driver, tab, "@name='account'", param.akundiskon);
			if (param.diskon != null)
				AccTool.numberField(driver, tab, "@name='amount'", param.diskon);
			if (param.keterangandiskon != null)
				AccTool.textarea(driver, tab, "@name='discountNotes'", param.keterangandiskon);
			if (param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if (param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);
			break;
		}
	}

	public static void klikLanjutInvoice(WebDriver driver) {

		String path = "//*[contains(@id,'detail-invoice')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		AccTool.waitProgressBar(getWebDriver());
	}

	public static void klikHapusInvoice(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-invoice')]//*[@name='btnDelete']");
	}
	
	public static void klikButtonCloseTabFaktur(WebDriver driver) {
		String path = "//*[text()='Faktur']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}

	public static void saveIsiHeader(WebDriver driver, String filename) {
		
		String tab = "";
		String content = "PenerimaanPenjualan.SaveHeader : " + "\r\n";
		content = content  
		        + "Terima Dari	: " 
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.LOOKUP, "customer") 
				+ "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.SUMMARY, "text: formData.currency().code", tab)
				+ "Kurs : " 
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.NUMBERFIELD, "rate")
				+ "Bank	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.LOOKUP, "bank") 
				+ "Nilai Pembayaran	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.NUMBERFIELD, "chequeAmount") 
				+ "Tanggal Bayar	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.DATEPICKER, "transDate") 
				+ "No Bukti	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.TEXTFIELD, "number") 
				+ "Pakai Kredit	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.CHECKBOX, "useCredit")
				+ "Retur Kredit	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.CHECKBOX, "returnOverpay") 
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooter(WebDriver driver, String filename) {
		String content = "PenerimaanPenjualan.SaveFooter : " + "\r\n";
//		String tab = "//div[text()='Nilai Pembayaran	']/following-sibling::div";
		String tab = "//div[contains(text(), 'Nilai Pembayaran')]/following-sibling::div";
		String tab1 = "//div[text()='Faktur Dibayar']/following-sibling::div";
		String tab2 = "//div[text()='Diskon']/following-sibling::div";
		String tab3 = "//div[text()='Lebih Bayar']/following-sibling::div";
		String tab4 = "//div[text()='Sisa Kredit']/following-sibling::div";
		content = content 
				+ "Nilai Pembayaran : " 
				+ "" 
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, tab) 
				+ "Faktur Dibayar : " 
				+ ""
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, tab1) 
//				+ "Diskon : "
//				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN,ElementType.NUMBERFIELD, "itemCashDiscount")
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, tab2) 
				+ "Lebih Bayar : " 
				+ ""
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, tab3)
				+ "Sisa Kredit : " 
				+ ""
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, tab4)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	// 23 september 2019 penambahan VOID di saveInfolain
	public static void saveInfolain(WebDriver driver, String filename) {
		String content = "PenerimaanPenjualan.SaveInfoLain : " + "\r\n";
//		AccTool.click(driver, AccurateModule.PENERIMAAN_PENJUALAN.getXpath() + "//*[contains(@class,'acc-icon-other-info')]");
		//ui baru
		AccTool.click(driver, AccurateModule.PENERIMAAN_PENJUALAN.getXpath() + "//*[contains(@class,'icn-transaction-header')]");
		String tab = "//*[contains(@id,'tab-otherheader')]";
		content = content 
				+ "Metode Bayar	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.COMBOBOX, "paymentMethod") 
				+ "No Cek	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.TEXTFIELD, "chequeNo") 
				+ "Tanggal Cek	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.DATEPICKER, "chequeDate") 
				+ "Keterangan	: " 
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.TEXTAREA, "description", tab)
				+ "VOID : "
		        + AccTool.getTextValue(driver,AccurateModule.PENERIMAAN_PENJUALAN, ElementType.CHECKBOX, "voidCheq", tab);
				  String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		        if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.COMBOBOX, "branch", tab);
		        } else {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, ElementType.SUMMARY, "branchListOption", tab);
		        }
		        content = content + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFaktur(WebDriver driver, String filename) {
		String content = "PenerimaanPenjualan.SaveBayarFaktur : " + "\r\n";
		AccTool.click(driver, "//*[contains(@id,'detail-invoice')]//*[contains(@href ,'tab-detailinvoice')]");
		String tab = "//*[contains(@id,'detail-invoice')]";
		content = content 
				+ "Faktur" 
				+ "Bayar	: " 
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "paymentAmount", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveInfoFakturPPH(WebDriver driver, String filename) {
		String content = "PenerimaanPenjualan.SaveInfoFakturPPH : " + "\r\n";
		String tab = "//*[contains(@id, 'tab-detailinvoice')]//*[contains(@class,'grid fluid')]";
		content = content 
				+ "Faktur" 
				+ "Dipotong PPH	: " 
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "paidPph", tab)
				+ "Nama Pajak	: " 
				+ AccTool.getTextValue(driver, ElementType.SPAN, "text: taxDescription", tab)
				+ "Nilai Pajak	: " 
				+ AccTool.getTextValue(driver, ElementType.SPAN,"text: app.util.parseNumber(taxAmount)", tab)
				+ "PPH disetor sendiri	: " 
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "selfPaidPph", tab)
				+ "No. Bukti Potong	: " 
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "pphNumber", tab)
				+ "Departemen : "
	            + AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab)
	            + "Proyek : "
                + AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDiskon(WebDriver driver, String filename) {
		String content = "PenerimaanPenjualan.SaveDiskon : " + "\r\n";
		AccTool.click(driver, "//*[contains(@id,'detail-invoice')]//*[contains(@href ,'tab-discount')]");
		String tab = "//*[contains(@id,'detail-invoice')]";
		content = content 
				+ "Akun Diskon	: " 
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "account", tab) 
				+ "Diskon	: "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amount", tab) 
				+ "Keterangan Diskon	: " 
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "discountNotes", tab);
				 
				String namadept = "//*[contains(@id,'detail-invoice')]//div[input[@name='department']]";
                if (WebElementTool.isElementExists(driver, By.xpath(namadept))) {
                content = content 
                + "Departemen : "
                + AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab);
                } else {
                content = content 
                + "Departemen : "
                + AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.department().name", tab);
                 }
                
                String namaproj = "//*[contains(@id,'detail-invoice')]//div[input[@name='project']]";
                if (WebElementTool.isElementExists(driver, By.xpath(namaproj))) {
                    content = content 
                + "Proyek : "
                + AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab);
                } else {
                    content = content 
                + "Proyek : "
                + AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.project().name", tab);
                }

                content = content + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void PilihSatu(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-copy-item')]//*[@class='grid-canvas']/div[1]");
	}

	public static void PilihDua(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-copy-item')]//*[@class='grid-canvas']/div[2]");
	}

	public static void PilihTiga(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-copy-item')]//*[@class='grid-canvas']/div[3]");
	}

	public static void PilihEmpat(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-copy-item')]//*[@class='grid-canvas']/div[4]");
	}

	public static void saveListDetail(WebDriver driver, String filename) {
		log.info("PenerimaanPenjualan.SaveListBarang");

		String tab = "";
		String content = "PenerimaanPenjualan.SaveGridDetailFaktur : " + "\r\n";
		tab = "//*[contains(@id,'tab-invoice')]";
		content = content  
				+ AccTool.getGridValue(driver, AccurateModule.PENERIMAAN_PENJUALAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void klikBaris1ListPembayaran(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__customer__outstanding-invoice-for-payment')]//*[@class='grid-canvas']/div[1]");
//		WaitTool.delay(500);
	}
	
	public static void klikBaris2ListPembayaran(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__customer__outstanding-invoice-for-payment')]//*[@class='grid-canvas']/div[2]");
//		WaitTool.delay(500);
	}
	//di buat tanggal 21 desember 2018 --> untuk pelanggan OB terkait cabang
	
	public static void klikBaris3ListPembayaran(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__customer__outstanding-invoice-for-payment')]//*[@class='grid-canvas']/div[3]");
//		WaitTool.delay(500);
	}
	
	public static void klikUncheckBarisListPembayaran(WebDriver driver, String value) {
		
		String xpath = "//*[contains(@id,'accurate__customer__outstanding-invoice-for-payment')]//*[@class='grid-canvas']/div/div[contains(text(),'" + value + "')]";
		AccTool.click(getWebDriver(), xpath);
//		WaitTool.delay(500);
	}
	
    public static void klikCheckSemuaListPembayaran(WebDriver driver) {
		
		String xpath = "//*[contains(@id,'accurate__customer__outstanding-invoice-for-payment')]//*[@class='input-control checkbox no-margin']";
		AccTool.click(getWebDriver(), xpath);
	}
	
	/* simpan list grid diskon */
	public static void saveListDiskon(WebDriver driver, String filename) {
		
		log.info("PembayaranPenjualan.SaveListDiskon");
		String grid = "";
		String content = "PenerimaanPenjualan.SaveListDiskon : " + "\r\n";
		grid = "//*[contains(@id,'tab-discount')]";
		
		content = content
				+ "Detail Diskon" 
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void pilihFakturBelumLunas(WebDriver driver) 
	{
		 AccTool.click(driver, "//*[contains(@class,'dropdown-menu place-left text-left')]//*[text()='Faktur Belum Lunas']");
		 AccTool.waitLoadingMask(driver);
	}
	
	public static void pilihTukarFaktur(WebDriver driver) 
	
	{
//		WaitTool.delay(1500);
		AccTool.click(driver, "//*[contains(@class,'dropdown-menu place-left text-left')]//*[text()='Tukar Faktur']");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void saveDaftarFakturBelumLunas(WebDriver driver, String filename) {
		log.info("PenerimaanPenjualan.SaveDaftarFakturBelumLunas");

		String grid = "";
		String content = "PenerimaanPenjualan.SaveDaftarFakturBelumLunas : " + "\r\n";
		grid = "//div[contains(@id, 'accurate__customer__outstanding-invoice-for-payment')]";
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void cariTukarFaktur(WebDriver driver, PenerimaanPenjualanParam param) {
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-exchange-invoice')]", "@name='lookup'", param.search);
	}
	
	public static void saveDaftarTukarFaktur(WebDriver driver, String filename) {
		log.info("PenerimaanPenjualan.SaveDaftarTukarFaktur");

		String grid = "";
		String content = "PenerimaanPenjualan.SaveDaftarTukarFaktur : " + "\r\n";
		grid = "//div[contains(@id, 'tab-copy-invoice')]";
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikListBaris(WebDriver driver) {
		// .click(getWebDriver(), "//*[contains(@class,'ui-widget-content slick-row
		// odd')]");
		AccTool.click(getWebDriver(), "//div[contains(@id,'module-grid-list')]//div[@class='grid-canvas']/div[1]");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikListBaris2(WebDriver driver) {
		AccTool.click(getWebDriver(), "//div[contains(@id,'module-grid-list')]//div[@class='grid-canvas']/div[2]");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikListBarisUrutan(WebDriver driver, int urutan) {
		AccTool.click(getWebDriver(), "//div[contains(@id,'module-grid-list')]//div[@class='grid-canvas']/div["+ urutan +"]");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikTabFaktur(WebDriver driver) {
		String w = AccurateModule.PENERIMAAN_PENJUALAN.getXpath();
		AccTool.click(driver, w + "//a[contains(@href,'tab-invoice')]");
	}
	
}