package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.uangmukapenjualan.UangMukaPenjualanParam;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class UangMukaPenjualanTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(UangMukaPenjualanTool.class);
	
	public static void klikTabInfoLainnya(WebDriver driver) //PesananPenjualanParam //param)
	{
		AccTool.click(driver, AccurateModule.UANG_MUKA_PENJUALAN.getXpath() +
				"//a[contains(@href, '#tab-otherheader')]");
	}

	public static void isiForm(WebDriver driver, UangMukaPenjualanParam param) {
		log.info("UangMukaPenjualan.Isi");

		String w = AccurateModule.UANG_MUKA_PENJUALAN.getXpath();
		
		if (param.pelanggan != null) {
			AccTool.lookup(driver, w, "@name='customer'", param.pelanggan);
			AccTool.waitProgressBar(driver);
		}	
		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if (param.matauang != null)
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
		    AccTool.waitProgressBar(driver);
		if (param.kursritel != null)
			AccTool.numberField(driver, w, "@name='rate'", param.kursritel);
		if (param.kurspajak != null)
			AccTool.numberField(driver, w, "@name='fiscalRate'", param.kurspajak);
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
//			NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN);
			AccTool.textField(driver, w, "@name='number'", param.no);
		if (param.diskon != null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskon);
	}

	public static void isiUangMuka(WebDriver driver, UangMukaPenjualanParam param) {
		log.info("UangMukaPenjualan.IsiUangMuka");

		String w = AccurateModule.UANG_MUKA_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-downpayment')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-downpayment')]");
		
		if (param.nopesanan != null)
			AccTool.lookup(driver, tab, "@name='orderDownPayment'",param.nopesanan );
		if (param.uangmuka != null)
			AccTool.numberField(driver, tab, "@name='inputDownPayment'", param.uangmuka);
		if (param.nopo != null)
			AccTool.textField(driver, tab, "@name='poNumber'", param.nopo);
		if (param.kenapajak != null)
			AccTool.checkbox(driver, tab, "@name='taxable'", param.kenapajak);
		if(param.ppn != null)
			AccTool.lookup(driver, tab, "@name='tax1'", param.ppn);
		if (param.totaltermasukpajak != null)
			AccTool.checkbox(driver, tab, "@name='inclusiveTax'", param.totaltermasukpajak);
//		if (param.syaratpembayaran != null)
//			AccTool.lookup(driver, tab, "@name='paymentTerm'", param.syaratpembayaran);
		
		
//		AccTool.click(driver,"//*[@class='acc-icon-detail']");
		//ui baru
		AccTool.click(driver,"//*[@class='icn-transaction-detail']");
		AccTool.waitProgressBar(driver);
		
	}


	public static void isiInfoLain(WebDriver driver, UangMukaPenjualanParam param) {
		log.info("UangMukaPenjualan.IsiInfoLain");

		String w = AccurateModule.UANG_MUKA_PENJUALAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		
		if (param.tanggalpajak != null)
			AccTool.datePicker(driver, tab, "@name='taxDate'", param.tanggalpajak);
		if (param.alamat != null)
			AccTool.textarea(driver, tab, "@name='toAddress'", param.alamat);
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.akunpiutang != null)
			AccTool.lookup(driver, tab, "@name='arAccount'", param.akunpiutang);
		if (param.akunuangmuka != null)
			AccTool.lookup(driver, tab, "@name='downPaymentAccount'", param.akunuangmuka);
		if(param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
		if (param.syaratpembayaran != null)
			AccTool.lookup(driver, tab, "@name='paymentTerm'", param.syaratpembayaran);
	}



	public static void saveHeader(WebDriver driver, String filename){
		log.info("save header");
		String content = "UangMukaPenjualan.SaveHeader : " + "\r\n";
		content = content
				+ "\r\n"
				+ "Pelanggan : "
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.LOOKUP, "customer")
				+ "Tanggal : "		
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.DATEPICKER, "transDate")
				+ "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,ElementType.SUMMARY, "text: formData.currency().code")
				+ "NO : "		
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.TEXTFIELD, "number")
				+"Kurs Ritel :"
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, ElementType.NUMBERFIELD, "rate")
				+"Kurs pajak :"
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, ElementType.NUMBERFIELD, "fiscalRate")
				
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveUangMuka(WebDriver driver, String filename){
		log.info("UangMuka");
		String content = "UangMukaPenjualan.saveDetailUangMuka : " + "\r\n";
		content = content
				+ "\r\n"
				+ "No Pesanan : "
				+ AccTool.getTextValue(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN,ElementType.SUMMARY, "text: formData.orderDownPayment")
//				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
//						ElementType.SPAN, "orderDownPayment")
				+ "Uang Muka : "		
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.NUMBERFIELD, "inputDownPayment")
				+ "No. PO:"
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, 
						ElementType.TEXTFIELD, "poNumber")
				+ "Kena Pajak : "		
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.CHECKBOX, "taxable")
				+ "Total Termasuk Pajak :"
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, 
						ElementType.CHECKBOX, "inclusiveTax")
				+ "Tanggal Faktur Pajak: "		
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.DATEPICKER, "taxDate")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	//Save Untuk yang pake PPN 
	public static void saveUangMukaPPN(WebDriver driver, String filename){
		log.info("UangMuka");
		String content = "UangMukaPenjualan.saveDetailUangMuka : " + "\r\n";
		content = content
				+ "\r\n"
				+ "No Pesanan : "
				+ AccTool.getTextValue(getWebDriver(), AccurateModule.UANG_MUKA_PENJUALAN,ElementType.SUMMARY, "text: formData.orderDownPayment")
//				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
//						ElementType.SPAN, "orderDownPayment")
				+ "Uang Muka : "		
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.NUMBERFIELD, "inputDownPayment")
				+ "No. PO:"
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, 
						ElementType.TEXTFIELD, "poNumber")
				+ "Kena Pajak : "		
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.CHECKBOX, "taxable")
				+ "ppn : "		
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.LOOKUP, "tax1")
				+ "Total Termasuk Pajak :"
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, 
						ElementType.CHECKBOX, "inclusiveTax")
				+ "Syarat Pembayaran :"
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, 
						ElementType.LOOKUP, "paymentTerm")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	
	
	
	public static void saveInfoLainnya(WebDriver driver, String filename){
		log.info("save Infolainnya");
		String w = AccurateModule.UANG_MUKA_PENJUALAN.getXpath();
		AccTool.click(driver, w + "//i[@class='icn-transaction-header']");
		
		String content = "UangMukaPenjualan.saveInfoLain : " + "\r\n";
		content = content
				+ "\r\n"
				+ "Syarat Pembayaran :"
				+ AccTool.getTextValue(driver, "//div[input[@name='paymentTerm']]/ul/li/label/span")
				+ "Alamat : "
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.TEXTAREA, "toAddress")
				+ "Keterangan:"
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, 
						ElementType.TEXTAREA, "description")
				+ "Cabang : "		
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN,
						ElementType.COMBOBOX, "branch")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveFooter(WebDriver driver, String filename){
		log.info("Save Footer");
		String content = "UangMukaPenjualan.saveFooter : " + "\r\n";
		
		String tab ="//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()[contains(.,'PPN')]]/following-sibling::div/span[1]";
		String tab11 = "//div[text()[contains(.,'PPN')]]/following-sibling::div/span[2]";
		String tab3 ="//div[text()='Total']/following-sibling::div";
		
		content = content
				+ "Sub Total : "
				+ AccTool.getTextValue(driver,AccurateModule.UANG_MUKA_PENJUALAN,tab );
		
				//untuk PPN
				String PPN = "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]";
				if(WebElementTool.isElementExists(driver, By.xpath(PPN)))
				{
					content = content 
							+ AccTool.getTextValue(driver, "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, tab1).replace("\r\n", " ")
							+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, tab11);
				} else {
					content = content 
							+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, "ppn");
				}
				
				content = content 
				+ "Total : "
				+ AccTool.getTextValue(driver,AccurateModule.UANG_MUKA_PENJUALAN,tab3 )
				+ "\r\n";
		AccTool.writeTextFile(filename, content);		
	}
	
	public static void saveFooterPPN11(WebDriver driver, String filename){
		log.info("Save Footer");
		String content = "UangMukaPenjualan.saveFooter : " + "\r\n";
		
		String tab ="//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//div[text()='PPN 11%']/following-sibling::div";
		String tab3 ="//div[text()='Total']/following-sibling::div";
		
		content = content
				+ "Sub Total : "
				+ AccTool.getTextValue(driver,AccurateModule.UANG_MUKA_PENJUALAN,tab )
				+ "PPN 11% : "
				+ AccTool.getTextValue(driver,AccurateModule.UANG_MUKA_PENJUALAN,tab1 )
				+ "Total : "
				+ AccTool.getTextValue(driver,AccurateModule.UANG_MUKA_PENJUALAN,tab3 )
				+ "\r\n";
		AccTool.writeTextFile(filename, content);		
	}
	
	public static void klikTabInformasiFaktur(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.UANG_MUKA_PENJUALAN.getXpath() +
				"//a[contains(@href, '#tab-summary')]");
	}
	
	public static void saveInformasiFaktur(WebDriver driver, String filename){
		log.info("Save Informasi Faktur");
		String content = "UangMukaPenjualan.saveInformasiFaktur : " + "\r\n";
		content = content
				+ "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, ElementType.SPAN, "totalAmount")
				+ "Uang Muka Terpakai : "
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, ElementType.SPAN, "downPaymentUsed")
				+ "Sisa Uang Muka : "
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, ElementType.SPAN, "availableDownPayment")
				+ "Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, ElementType.SPAN, "primeReceipt")
				+ "Piutang : "
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, ElementType.SPAN, "primeOwing")
				+ "Status : "
				+ AccTool.getTextValue(driver, AccurateModule.UANG_MUKA_PENJUALAN, "//*[contains(@data-bind,'text: formData.statusName()')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);		
	}
	
//17 mei 2018
	
		public static void klikProsesPembayaran(WebDriver driver) {

		AccTool.click(getWebDriver(), "//button[text()='Proses']");
		AccTool.click(getWebDriver(), "//a[text() = 'Pembayaran']");
	}
	
		public static void ubahTarifPPN(WebDriver driver, UangMukaPenjualanParam param) {
			log.info("UangMukaPenjualan.UbahTarifPPN");

			String w = AccurateModule.UANG_MUKA_PENJUALAN.getXpath();

			String u = "";
			
			AccTool.click(getWebDriver(), w + "//*[@name='btnPpnPercent']");
			if (param.tarifppn != null)
				AccTool.combobox(driver, u, "@name='tax1Rate'", param.tarifppn);
			AccTool.click(getWebDriver(),"//div[starts-with(@id,'accurate__input-ppn-percentage')]//*[@name='btnNext']");
			
		}
	
}
