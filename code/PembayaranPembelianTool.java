package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pembayaranpemasok.PembayaranPemasokParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PembayaranPembelianTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PembayaranPemasokParam.class);

	public static void klikRincianPembayaran1(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-invoice-grid-list')]//div[@class='grid-canvas']/div[1]");
	}

	public static void klikRincianPembayaran2(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-invoice-grid-list')]//div[@class='grid-canvas']/div[2]");
	}

	public static void klikRincianPembayaran3(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-invoice-grid-list')]//div[@class='grid-canvas']/div[3]");
	}

	public static void klikRincianPembayaran4(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-invoice-grid-list')]//div[@class='grid-canvas']/div[4]");
	}

	public static void klikRincianPembayaran5(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-invoice-grid-list')]//div[@class='grid-canvas']/div[5]");
	}

	public static void klikBtnLanjutAmbilFaktur(WebDriver driver) {
		String path = "//div[contains(@id,'accurate__vendor__outstanding-invoice-for-payment')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnLanjutPembayaranPembelian(WebDriver driver) {
		String path = "//div[contains(@id,'detail-invoice')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikHitungNilaiCek(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMBAYARAN_PEMASOK.getXpath() + "//button[@name='btnCalculate']");
		AccTool.waitProgressBar(driver);
	}

	public static void klikDistribusiNilaiCek(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMBAYARAN_PEMASOK.getXpath() + "//button[@name='btnDistribute']");
		AccTool.waitProgressBar(driver);
	}

	public static void klikTambahDiskon(WebDriver driver) {
		AccTool.click(getWebDriver(), "//div[contains(@id,'detail-invoice')]//*[@name='btnAddDiscount']");
	}

	public static void klikHapusDiskon(WebDriver driver) {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'detail-discount-grid-list')]//div[@class='grid-canvas']/div[1]//*[@class='danger']");
	}

	public static void klikButtonAmbil(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMBAYARAN_PEMASOK.getXpath() + "//button[@name='btnGetFrom']");
	}

	public static void klikTabDiskonRincian(WebDriver driver){
		AccTool.click(driver, "//a[contains(@href,'#tab-discount')]");
	}
	
	public static void pilihDetailPembayaran(WebDriver driver, PembayaranPemasokParam param) {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'detail-invoice-grid-list')]//div[@class='grid-canvas']/div[" + param.urutan + "]");
	}

	public static void centangFaktur(WebDriver driver, String[] nomorfaktur) {
		AccTool.click(driver,
				"//div[contains(@id,'accurate__vendor__outstanding-invoice-for-payment')]//span[@class='check']");
		if (nomorfaktur != null) {
			for (int i = 0; i <= nomorfaktur.length; i++) {
				String window = "//div[contains(@id,'accurate__vendor__outstanding-invoice-for-payment')]";
				AccTool.click(driver, window + "//div[contains(@class,'r1') and text()='" + nomorfaktur[i]
						+ "']//preceding-sibling::div[contains(@class,'r0')]//span[@class='check checkbox-grid']");
				i++;
			}
		}
	}

	public static void detailFaktur(WebDriver driver, PembayaranPemasokParam param) {
		log.info("PembayaranPemasok.DetailFaktur");

		String tab = "";
		if (param.tab != null)
			switch ((param.tab).toLowerCase()) {

			case "faktur":
				tab = "//div[starts-with(@id,'tab-detailinvoice')]";
				AccTool.click(driver, tab);
				if (param.pembayaran != null)
					AccTool.numberField(driver, tab, "@name='paymentAmount'", param.pembayaran);
				if (param.pph != null)
					AccTool.checkbox(driver, tab, "@name='paidPph'", param.pph);
				break;

			case "informasi diskon":
				tab = "//div[starts-with(@id,'tab-discount')]";
				AccTool.click(driver, "//a[contains(@href,'#tab-discount')]");
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

	public static void isi(WebDriver driver, PembayaranPemasokParam param) {
		log.info("PembayaranPemasok.Isi");

		String w = AccurateModule.PEMBAYARAN_PEMASOK.getXpath();
		if (param.pembayaranke != null) {
			AccTool.lookup(driver, w, "@name='vendor'", param.pembayaranke);
			AccTool.waitProgressBar(driver);
			AccTool.waitProgressBar(driver);
		}
		if (param.matauang != null) {
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
			AccTool.waitProgressBar(driver);
		}
		if (param.tglpembayaran != null) {
			AccTool.datePicker(driver, w, "@name='transDate'", param.tglpembayaran);
			AccTool.waitProgressBar(driver);
		}
		if (param.bank != null) {
			AccTool.lookup(driver, w, "@name='bank'", param.bank);
			AccTool.waitProgressBar(driver);
		}
		if (param.kurs != null)
			AccTool.numberField(driver, w, "@name='rate'", param.kurs);

//		if (param.metode != null)
//			AccTool.combobox(driver, w, "@name='paymentMethod'", param.metode);
//		AccTool.waitProgressBar(driver);
		
//		if (param.nocek != null) {
//			AccTool.textField(driver, w, "@name='chequeNo'", param.nocek);
//			AccTool.click(getWebDriver(),
//					"//div[contains(@id, 'module-accurate__vendor__purchase-payment')]//label[@data-bind='text: ft.chequeNo.title']");
//		}
//		if (param.vendorbank != null) {
//			AccTool.lookup(driver, w, "@name='vendorBankAccount'", param.vendorbank);
//			AccTool.waitProgressBar(driver);
//		}
		
		if (param.tanggalcek != null)
			AccTool.datePicker(driver, w, "@name='chequeDate'", param.tanggalcek);
		
		if (param.nilaicek != null) {
			AccTool.numberField(driver, w, "@name='chequeAmount'", param.nilaicek);
//			AccTool.click(getWebDriver(),
//					"//div[contains(@id, 'module-accurate__vendor__purchase-payment')]//label[@data-bind='text: ft.chequeNo.title']");
		}
		if (param.penomoran != null)
			AccTool.textField(driver, w, "@name='typeAutoNumber'", param.penomoran);
		
		if (param.nobukti != null)
			AccTool.textField(driver, w, "@name='number'", param.nobukti);
	}

	public static void isiDetailFaktur(WebDriver driver, PembayaranPemasokParam param) {
		log.info("PembayaranPemasok.IsiDetailFaktur");

		String w = AccurateModule.PEMBAYARAN_PEMASOK.getXpath();
		String tab = "";

		AccTool.click(driver, w + "//a[contains(@href,'tab-invoice')]");
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailInvoice'", param.search);
			AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}

	public static void isiInfoLain(WebDriver driver, PembayaranPemasokParam param) {
		log.info("PembayaranPemasok.IsiInfoLain");

		String w = AccurateModule.PEMBAYARAN_PEMASOK.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		
		if (param.metode != null){
			AccTool.combobox(driver, w, "@name='paymentMethod'", param.metode);
		AccTool.waitProgressBar(driver);
		
		}
		
		if (param.nocek != null) {
			AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
			AccTool.textField(driver, w, "@name='chequeNo'", param.nocek);	
		}
		
		
		if (param.vendorbank != null) {
			AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
			AccTool.lookup(driver, w, "@name='vendorBankAccount'", param.vendorbank);
			AccTool.waitProgressBar(driver);
		}
		
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.cbvoid != null)
			AccTool.checkbox(driver, tab, "@name='voidCheq'", param.cbvoid);
		if (param.cbterekonsiliasi != null)
			AccTool.checkbox(driver, tab, "@name='reconciled'", param.cbterekonsiliasi);
		if(param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
	}

	public static void saveDetailFaktur(WebDriver driver, String filename) {
		log.info("PembayaranPemasok.SaveDetailFaktur");
		AccTool.click(driver, "//*[contains(@id,'detail-invoice')]//*[contains(@href ,'tab-discount')]");
		String content = "PembayaranPemasok.SaveDetailFaktur : " + "\r\n";
		String tab = "//div[contains(@id,'detailinvoice')]";
		content = content 
				+ "\r\n" 
				+ "Pembayaran : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "paymentAmount", tab) + "\r\n";
			
		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailDiskonFaktur(WebDriver driver, String filename) {

		log.info("PembayaranPemasok.SaveDetailDiskonFaktur");
		AccTool.click(driver, "//*[contains(@id,'detail-invoice')]//*[contains(@href ,'tab-discount')]");
		String content = "PembayaranPemasok.SaveDetailDiskonFaktur : " + "\r\n";
		String tab = "//div[contains(@id,'detail-invoice')]";
		content = content 
				+ "\r\n" 
				+ "Akun Diskon : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "account", tab) 
				+ "Diskon : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amount", tab) 
				+ "Keterangan Diskon : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "discountNotes", tab) 
				+ "Departemen : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab) 
				+ "Proyek : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab) 
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("PembayaranPemasok.SaveIsiHeader");

		String tab = "";
		String content = "PembayaranPemasok.SaveIsiHeader : " + "\r\n";
		content = content  
				+ "\r\n" 
				+ "Pembayaran Ke : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.LOOKUP, "vendor", tab)
				+ "Mata Uang : " 
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.SUMMARY, "text: formData.currency().code", tab)
				+ "Kurs : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.NUMBERFIELD, "rate", tab)
				+ "Bank : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.LOOKUP, "bank", tab)				
				+ "Vendor Bank : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.LOOKUP, "Account", tab)				
				+ "Nilai Cek : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.NUMBERFIELD, "chequeAmount", tab)
				+ "No Bukti # : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.TEXTFIELD, "number", tab)
				+ "Tanggal Pembayaran : " 
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.DATEPICKER, "transDate", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiDetailFaktur(WebDriver driver, String filename) {
		log.info("PembayaranPemasok.SaveIsiDetailFaktur");

		String tab = "";
		String content = "PembayaranPemasok.SaveIsiDetailFaktur : " + "\r\n";
		tab = "//*[contains(@id,'tab-invoice')]";
		content = content  
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailInfoLain(WebDriver driver, String filename) {
		log.info("PembayaranPemasok.SaveDetailInfoLain");

		//String tab = "";
		String content = "PembayaranPemasok.SaveDetailInfoLain : " + "\r\n";
//		AccTool.click(driver, AccurateModule.PEMBAYARAN_PEMASOK.getXpath() + "//*[contains(@class,'acc-icon-other-info')]");
		//ui baru
		AccTool.click(driver, AccurateModule.PEMBAYARAN_PEMASOK.getXpath() + "//*[contains(@class,'icn-transaction-header')]");
		String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		// tab = AccurateModule.PEMBAYARAN_PEMASOK.getXpath() +
		// "//*[contains(@id,'tab-otherheader')]";
		content = content  
				+ "\r\n"
				+ "Metode Bayar : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.COMBOBOX, "paymentMethod")
				+ "No Cek : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.TEXTFIELD, "chequeNo")
				+ "Tanggal Cek : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.DATEPICKER, "chequeDate")
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.TEXTAREA, "description")
				+ "Void : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.CHECKBOX, "voidCheq")
				+ "Terekonsilasi : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.CHECKBOX, "reconciled")
//				+ "Cabang : "
//				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.COMBOBOX, "branch") + "\r\n";
				;
				if(WebElementTool.isElementExists(driver, By.xpath(namacabang)))
				{
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.COMBOBOX, "branch") + "\r\n";
				} else {
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, ElementType.SUMMARY, "branchListOption") + "\r\n";
				}
				
		AccTool.writeTextFile(filename, content);
	}

	public static void saveList(WebDriver driver, String filename) {
		log.info("PembayaranPemasok.SaveList");
		
		String content = "PembayaranPemasok.SaveList : " + "\r\n";
		String tab = "//*[contains(@id,'tab-invoice')]";
		
		content = content + AccTool.getGridValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooter(WebDriver driver, String filename) {

		String content = "PembayaranPemasok.SaveFooter : " + "\r\n";
//		String tab = "//div[text()='Nilai Pembayaran	']/following-sibling::div";
		String tab = "//div[contains(text(), 'Nilai Pembayaran')]/following-sibling::div";
		String tab1 = "//div[text()='Nilai Bayar']/following-sibling::div";
		String tab2 = "//div[text()='Diskon']/following-sibling::div";
		String tab3 = "//div[text()='Faktur Dibayar']/following-sibling::div";

		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());

		content = content 
				+ "\r\n" 
				+ "Nilai Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, tab) 
				+ "Nilai Bayar : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, tab1) 
				+ "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, tab2) 
				+ "Faktur Dibayar : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_PEMASOK, tab3) 
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	/* simpan list grid diskon */
	public static void saveListDiskon(WebDriver driver, String filename) {
		AccTool.click(driver, "//a[contains(@href,'#tab-discount')]");
		log.info("PembayaranPembelian.SaveListDiskon");
		String grid = "";
		String content = "PembayaranPembelian.SaveListDiskon : " + "\r\n";
		grid = "//*[contains(@id,'tab-discount')]";
		
		content = content 
				+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikButtonCloseTabFaktur(WebDriver driver) {
		String path = "//*[text()='Faktur']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikTabFaktur(WebDriver driver) {
		String w = AccurateModule.PEMBAYARAN_PEMASOK.getXpath();
		AccTool.click(driver, w + "//a[contains(@href,'tab-invoice')]");
	}
}
