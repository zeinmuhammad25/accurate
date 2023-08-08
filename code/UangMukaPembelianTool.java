package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pesananpembelian.PesananPembelianParam;
import com.cpssoft.web.test.accurate.uangmukapembelian.UangMukaPembelianParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class UangMukaPembelianTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(UangMukaPembelianParam.class);
	

	public static void klikProsesPembayaran(WebDriver driver)
	{
//		AccTool.dropDown(getWebDriver(), AccurateModule.UANG_MUKA_PEMBELIAN.getXpath(),
//				"//div[@class='offset5 span7 text-right']/div[1]", "Pembayaran");
		
		String w = AccurateModule.UANG_MUKA_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
		WaitTool.delay(500);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pembayaran']");
		WaitTool.delay(500);
	}
	
	public static void klikTabInfoLainnya(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.UANG_MUKA_PEMBELIAN.getXpath() +
				"//a[contains(@href, '#tab-otherheader')]");
	}
	
	public static void isiForm(WebDriver driver, UangMukaPembelianParam param)
	{
		log.info("UangMukaPembelian.Isi");
		
		String w = AccurateModule.UANG_MUKA_PEMBELIAN.getXpath();
		if (param.pemasok != null) {
			AccTool.lookup(driver, w, "@name='vendor'", param.pemasok);
			AccTool.waitProgressBar(driver);
			AccTool.waitProgressBar(driver);
		}
		if (param.matauang != null)
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
		if (param.tanggal != null) {
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
			AccTool.waitProgressBar(driver);
		}
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);		
		if (param.kursritel != null)
			AccTool.numberField(driver, w, "@name='rate'", param.kursritel);
		if (param.kurspajak != null) {
			AccTool.numberField(driver, w, "@name='fiscalRate'", param.kurspajak);
			AccTool.click(getWebDriver(), "//label[@data-bind='text: ft.transDate.title']");
			//WaitTool.delay(200);
			WaitTool.waitForElementClickable(driver, By.xpath(w), 1);
		}
		if (param.diskon != null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskon);
		
		AccTool.waitProgressBar(getWebDriver());
	}
	
	public static void isiInfoLain(WebDriver driver, UangMukaPembelianParam param)
	{
		log.info("UangMukaPembelian.IsiInfoLain");
		
		String w = AccurateModule.UANG_MUKA_PEMBELIAN.getXpath();	
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		
		if (param.nofaktur != null)
			AccTool.textField(driver, tab, "@name='billNumber'", param.nofaktur);	
		if(param.alamat != null)	
			AccTool.textarea(driver, tab, "@name='toAddress'", param.alamat);		
		if(param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if(param.akunhutang != null)
			AccTool.lookup(driver, tab, "@name='apAccount'", param.akunhutang);
		if(param.akunuangmuka != null)
			AccTool.lookup(driver, tab, "@name='downPaymentAccount'", param.akunuangmuka);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
	}
	
	public static void isiUangMuka(WebDriver driver, UangMukaPembelianParam param)
	{
		log.info("UangMukaPembelian.IsiUangMuka");
		
		String w = param.w;	
		String tab = w + "//*[contains(@id,'tab-downpayment')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-downpayment')]");
		if(param.nopesanan != null) {
			AccTool.lookup(driver, tab, "@name='orderDownPayment'", param.nopesanan);
			WaitTool.delay(1000);
		}
		if(param.uangmuka != null) {
			AccTool.numberField(driver, tab, "@name='inputDownPayment'", param.uangmuka);	
			WaitTool.delay(1000);
		}
		if(param.kenapajak != null)
			AccTool.checkbox(driver, tab, "@name='taxable'", param.kenapajak);
		if(param.ppn != null)
			AccTool.lookup(driver, tab, "@name='tax1'", param.ppn);
		if(param.totaltermasukpajak != null)
			AccTool.checkbox(driver, tab, "@name='inclusiveTax'", param.totaltermasukpajak);
		if(param.syaratpembayaran != null)
			AccTool.lookup(driver, tab, "@name='paymentTerm'", param.syaratpembayaran);
	}
	
	public static void saveIsiHeader(WebDriver driver, String filename)
	{
		log.info("UangMukaPembelian.SaveIsiHeader: " + "\r\n");
//		String tab = "//label[@data-bind='text: ft.vendor.title']";
//		WaitTool.delay(1000);
		String tab = "";
		String content = "UangMukaPembelian.SaveHeader : " + "\r\n";
		
//		AccTool.click(getWebDriver(), tab);
		
		content = content
				+ "Pemasok : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.LOOKUP, "vendor", tab)
				+ "Tanggal : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.DATEPICKER, "transDate", tab)
				+ "Penomoran : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.TEXTFIELD, "number", tab)
				+ "Mata Uang : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SUMMARY, "text: formData.currency().code")
				+ "Kurs Rtl : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.NUMBERFIELD, "rate", tab)
				+ "Kurs Pjk : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.NUMBERFIELD, "fiscalRate", tab)
				+ "Diskon : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.NUMBERFIELD, "itemCashDiscount", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiUangMuka(WebDriver driver, String filename)
	{
		log.info("UangMukaPembelian.SaveIsiUangMuka");
	//	String tab = "";
		String content = "UangMukaPembelian.SaveIsiUangMuka : " + "\r\n";
	//	tab = AccurateModule.UANG_MUKA_PEMBELIAN.getXpath() + "//*[contains(@id,'tab-downpayment')]";
		AccTool.click(getWebDriver(), "//*[contains(@href,'tab-downpayment')]");
		AccTool.waitProgressBar(getWebDriver());
		content = content
				+ "Nomor Pesanan : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.LOOKUP, "orderDownPayment")
				+ "Uang Muka : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.NUMBERFIELD, "inputDownPayment")
				+ "Kena Pajak : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.CHECKBOX, "taxable")
				+ "Total Termasuk Pajak : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.CHECKBOX, "inclusiveTax")
				+ "Syarat Pembayaran : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.LOOKUP, "paymentTerm")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
		
	}
	
	public static void saveIsiInfoLain(WebDriver driver, String filename)
	{
		log.info("UangMukaPembelian.SaveIsiInfoLain");
		String tab = "";
		String content = "UangMukaPembelian.SaveIsiInfoLainnya : " + "\r\n";
		tab = "//*[contains(@id,'tab-otherheader')]";
		content = content
				+ "No Faktur : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.TEXTFIELD, "billNumber", tab)
				+ "Alamat : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.TEXTAREA, "toAddress", tab)
				+ "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.TEXTAREA, "description", tab);
	
		//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
		String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
			content = content + "Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.COMBOBOX, "branch", tab);
		} else {
			content = content + "Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SUMMARY, "branchListOption", tab);
		}
		
		content = content + "Akun Hutang : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.LOOKUP, "apAccount", tab)
				+ "Akun Uang Muka : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.LOOKUP, "downPaymentAccount", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiNilaiFaktur(WebDriver driver, String filename)
	{
		log.info("UangMukaPembelian.SaveIsiNilaiFaktur");
		String tab = "";
		String content = "UangMukaPembelian.SaveIsiNilaiFaktur : " + "\r\n";
		tab = "//*[contains(@id,'tab-summary')]";
		content = content
				+ "Total : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.totalAmount())")
				+ "Uang Muka Terpakai : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.downPaymentUsed())")
				+ "Sisa Uang Muka : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.availableDownPayment())")
				+ "Pembayaran : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.primePayment())")
				+ "Bayar PPN : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.taxPayment())")
				+ "Hutang : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.primeOwing())")
				+ "Hutang Pajak : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.taxOwing())")
				+ "Status : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, ElementType.SPAN, "text: formData.statusName()")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveLIst(WebDriver driver, String filename)
	{
		log.info("UangMukaPembelian.SaveList");
		
		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "UangMukaPembelian.SaveList : " + "\r\n";
		
		content = content + AccTool.getGridValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveFooter(WebDriver driver, String filename){
		
		log.info("Save Footer");
		String content = "UangMukaPembelian.saveFooter: " + "\r\n";
		
		String tab ="//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()[contains(.,'PPN')]]/following-sibling::div/span[1]";
		String tab11 = "//div[text()[contains(.,'PPN')]]/following-sibling::div/span[2]";
		String tab3 ="//div[text()='Total']/following-sibling::div";
		
		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());
		
		content = content
				+ "Sub Total : "
				+ AccTool.getTextValue(driver,AccurateModule.UANG_MUKA_PEMBELIAN,tab );
		
				//untuk PPN
				String PPN = "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]";
				if(WebElementTool.isElementExists(driver, By.xpath(PPN)))
				{
					content = content 
							+ AccTool.getTextValue(driver, "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, tab1).replace("\r\n", " ")
							+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, tab11);
				} else {
					content = content 
							+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PEMBELIAN, "ppn");
				}
				
				content = content 
				+ "Total : "
				+ AccTool.getTextValue(driver,AccurateModule.UANG_MUKA_PEMBELIAN,tab3 )
				+ "\r\n";
		AccTool.writeTextFile(filename, content);		
	}
	
	public static void ubahTarifPPN(WebDriver driver, UangMukaPembelianParam param) {
		log.info("PenawaranPenjualan.UbahTarifPPN");

		String w = AccurateModule.UANG_MUKA_PEMBELIAN.getXpath();

		String u = "";

		AccTool.click(getWebDriver(), w + "//*[@name='btnPpnPercent']");
		if (param.tarifppn != null)
			AccTool.combobox(driver, u, "@name='tax1Rate'", param.tarifppn);
		AccTool.click(getWebDriver(), "//div[starts-with(@id,'accurate__input-ppn-percentage')]//*[@name='btnNext']");
	}
}
