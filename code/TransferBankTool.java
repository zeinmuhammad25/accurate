package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.transferbank.TransferBankParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class TransferBankTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(TransferBankTool.class);

	public static void rincianTransferBank1(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-bank-transfer-grid-list')]//div[@class='grid-canvas']/div[1]");
	}
	
	public static void rincianTransferBank2(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-bank-transfer-grid-list')]//div[@class='grid-canvas']/div[2]");
	}
	
	public static void klikBtnLanjutTranferBankBiayaTranfer (WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-bank-transfer')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 15);
	}
	
	public static void klikBtnHapusTransferBankBiayaTransfer (WebDriver driver){
		String path = "//*[contains(@id,'detail-bank-transfer')]//button[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 15);
	}
	
	public static void isiForm(WebDriver driver, TransferBankParam param) {
		log.info("Penerimaan.IsiForm");

		String w = AccurateModule.TRANSFER_BANK.getXpath();
		
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);		
	}

	public static void isiTransferUang(WebDriver driver, TransferBankParam param) {
		log.info("TransferBank.IsiTransferUang");
		
		String w = param.w;	
		String tab = w + "//*[contains(@id,'tab-transfer')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-transfer')]");
		
		if (param.dari != null) {
			AccTool.lookup(driver, tab, "@name='fromBank'", param.dari);
			AccTool.waitProgressBar(driver);
		}
		if (param.ke != null) {
			AccTool.lookup(driver, tab, "@name='toBank'", param.ke);
			AccTool.waitProgressBar(driver);
		}
		if (param.nilaidari != null) {
			AccTool.numberField(driver, tab, "@name='fromBankAmount'", param.nilaidari);
			AccTool.waitProgressBar(driver);
		}
		if (param.nilaihasil != null)
			AccTool.numberField(driver, tab, "@name='toBankAmount'", param.nilaihasil);

		if (param.kursdari != null)
			AccTool.numberField(driver, tab, "@name='fromBankRate'", param.kursdari);
		if (param.kurske != null)
			AccTool.numberField(driver, tab, "@name='toBankRate'", param.kurske);
		if (param.akunselisih != null)
			AccTool.lookup(driver, tab, "@name='differenceAccount'", param.akunselisih);
		if (param.cabangdari != null)
			AccTool.lookup(driver, tab, "@name='branchId'", param.cabangdari);
		if (param.cabangke != null)
			AccTool.lookup(driver, tab, "@name='toBranchId'", param.cabangke);
	}

	public static void isiBiayaTransfer(WebDriver driver, TransferBankParam param) {
		log.info("TransferBank.IsiBiayaTransfer");
		
		String w = param.w;	
		String tab = w + "//*[contains(@id,'tab-detail-')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-detail-')]");
				
		AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
		AccTool.scrollRowDetail(driver, tab, param.scroll);
	}
	
	public static void IsiInfoLain(WebDriver driver, TransferBankParam param) {
		log.info("TransferBank.IsiInfoLain");
		
		String w = param.w;	
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		
		if(param.catatan !=null)
			AccTool.textarea(driver, tab, "@name='description'", param.catatan);
		if(param.cabang != null)
			AccTool.combobox(getWebDriver(), tab, "@name='branch'", param.cabang);
	}
	
	public static void detailBiayaTransfer(WebDriver driver, TransferBankParam param) {
		log.info("TransferBank.DetailBiayaTransfer");

		String tab = "";
		
		if (param.tab != null)
			switch ((param.tab).toLowerCase()) {
			
			case "biaya transfer":
				tab = "//div[starts-with(@id,'tab-detailexpense')]";
				
				AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
				if (param.nama != null)
					AccTool.textField(driver, tab, "@name='expenseName'", param.nama);
				if (param.nilai != null)
					AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
				if (param.departemenmandatory != null)	
					AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
				if (param.proyekmandatory != null)
					AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
				break;
				
			case "catatan":
				tab = "//*[starts-with(@id,'tab-customfield')]";
				//ui lama
//				AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
				//ui baru
				AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
				
				if (param.departemen != null)	
					AccTool.lookup(driver, tab, "@name='department'", param.departemen);
				if (param.proyek != null)
					AccTool.lookup(driver, tab, "@name='project'", param.proyek);
				if (param.catatan != null)
					AccTool.textarea(driver, tab, "@name='memo'", param.catatan);
				break;
		}
	}	
	
	
	public static void saveData(WebDriver driver,  String filename) {
		log.info("TransferBank.SaveData");

		String tab = "";
		String content = "TransferBank.SaveData : " + "\r\n";

		switch (tab.toLowerCase()) {
		case "header":
			content = content
					+ "Nomor : "
					+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "number", tab)
					+ "Tanggal : "		
					+ AccTool.getTextValue(driver, ElementType.DATEPICKER, "transDate", tab) + "\r\n";
			break;
		case "transfer uang":
			AccTool.click(driver, "//a[contains(@href,'tab-transfer')]");
			content = content
					+ "Dari : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "fromBank", tab)
					+ "Nilai Dari : "		
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "fromBankAmount", tab)
					+ "Ke : "		
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "toBank", tab)
					+ "Kurs : "		
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "toBankRate", tab)
					+ "Nilai Ke : "		
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "toBankAmount", tab)
					+ "\r\n";
			break;
		case "biaya transfer":
			AccTool.click(driver, "//a[contains(@href,'tab-detail-')]");
			tab = "//*[contains(@id,'tab-detail-')]";
			content = content 
					+ AccTool.getGridValue(driver, AccurateModule.TRANSFER_BANK, tab) + "\r\n";
			break;

		case "info lain":
			AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
			tab = "//*[contains(@id,'tab-otherheader')]";
			content = content
					+ "Catatan :"
					+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "description", tab)
					+ "Cabang : "
					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "branch", tab)
					+ "Cabang : "
					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "branch", tab)
					+ "Terekonsiliasi Bank awal : "
					+ AccTool.getTextValue(driver, ElementType.LABEL, "fromReconciled()", tab)
					+ "Terekonsiliasi Bank akhir : "
					+ AccTool.getTextValue(driver, ElementType.LABEL, "fromReconciled()", tab)
					+ "\r\n";
			break;
		}

		AccTool.writeTextFile(filename,  content);
	}


	public static void saveDetailBiayaTransfer(WebDriver driver,  String filename) {
		log.info("TransferBank.SaveDetailBiayaTransfer");

		String tab = "";
		String content = "TransferBank.SaveDetailBiayaTransfer : \r\n";
		
		tab = "//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		content = content
				+ "Nama :"
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab)
				+ "Nilai :"
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amount", tab)
				+ "Departemen :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span") + "\r\n";	
//		tab = "//*[contains(@id,'tabcustomfield')]";
		//uibaru
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui lama
		AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
		tab = "//*[contains(@id,'tab-customfield')]";
		content = content
				+ "Departemen :"
				+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek :"
				+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span") 
				+ "Catatan :"
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "memo", tab) + "\r\n";

		AccTool.writeTextFile(filename,  content);
	}

	public static void saveHeader(WebDriver driver,  String filename) {
		log.info("TransferBank.SaveHeader");

		String tab = "";
		String content = "TransferBank.SaveHeader : " + "\r\n";					
					String noTransakasi = "//div[@class='text-panel-disabled text-truncate']";
					if (WebElementTool.isElementExists(driver, By.xpath(noTransakasi))) {
						content = content 
						+ "Nomor : "
								+ AccTool.getTextValue(driver, "//div[@class='text-panel-disabled text-truncate']");
					} else {
						content = content
						+ "Nomor : "
								+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK,
										ElementType.TEXTFIELD, "number", tab);
					}	
		content = content		
					+ "Tanggal : "		
					+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK,
							ElementType.DATEPICKER, "transDate", tab) + "\r\n";
					AccTool.writeTextFile(filename,  content);
				}
	
	public static void saveDetailTransferBank(WebDriver driver,  String filename) {
		log.info("TransferBank.SaveDetailTransferBank");

		String tab = "";
		String content = "TransferBank.SaveDetailTransferBank : " + "\r\n";
		content = content
					+ "Dari : "
					+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK,
							ElementType.LOOKUP, "fromBank", tab)
					+ "Dari Cabang : "
					+ AccTool.getTextValue(driver,"//div[input[@name='branchId']]/ul/li/label/span")
					+ "Nilai : "		
					+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK,
							ElementType.NUMBERFIELD, "fromBankAmount", tab)
					+ "Kurs Dari : "		
					+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK,
							ElementType.NUMBERFIELD, "fromBankRate", tab)
					+ "Ke : "		
					+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK,
							ElementType.LOOKUP, "toBank", tab)
					+ "Ke Cabang : "		
					+ AccTool.getTextValue(driver,"//div[input[@name='toBranchId']]/ul/li/label/span")
					+ "Kurs Ke : "		
					+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK,
							ElementType.NUMBERFIELD, "toBankRate", tab)
					+ "Nilai Ke : "		
					+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK,
							ElementType.NUMBERFIELD, "toBankAmount", tab)
					+ "Akun Selisih : "		
					+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK,
							ElementType.LOOKUP, "differenceAccount", tab)
				    + "\r\n";
		AccTool.writeTextFile(filename,  content);
	}
		
	public static void saveInfoLain(WebDriver driver,  String filename)
	{
		log.info("TransferBank.saveInfoLain");
		
		String content = "TransferBank.SaveInfoLainnya : " + "\r\n";
		//ui lama
//		AccTool.click(driver, AccurateModule.TRANSFER_BANK.getXpath()
//				+ "//*[contains(@class,'acc-icon-other-info')]");
		//ui baru
		AccTool.click(driver, AccurateModule.TRANSFER_BANK.getXpath()
				+ "//*[@class='icn-transaction-header']");	
		
		content = content
				+ "Catatan : "
				+ AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK, ElementType.TEXTAREA, "description");
				 String namacabang = "//*[contains(@data-bind,'text: acc.staticData.branchListOption()')]";
		        if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.TRANSFER_BANK, ElementType.SUMMARY, "text: acc.staticData.branchListOption()");
		        }
		        content = content + "\r\n";
		AccTool.writeTextFile(filename,  content);
	}
	
	// Klik tab transfer uang
	public static void klikTabTransferUang(WebDriver driver){
		AccTool.click(driver, "//a[contains(@href,'tab-transfer-')]");
	}
		
	// Klik tab biaya transfer
	public static void klikTabBiayaTransfer(WebDriver driver){
		AccTool.click(driver, "//a[contains(@href,'tab-detail-')]");
	}
	
	// Klik tab Info Lain
	public static void klikTabInfoLain(WebDriver driver){
		AccTool.click(driver, "//a[contains(@href,'tab-otherheader-')]");
	}
	
	//Tutup Pop up Biaya transfer
	public static void klikTutupPopUpRincianBiayaTransfer(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void saveListBiayaTransfer(WebDriver driver, String filename) {
		log.info("TransferBank.SaveListBiayaTransfer");

		String tab = "";
		String content = "TransferBank.SaveListBiayaTransfer : " + "\r\n";
		tab = "//*[contains(@id,'tab-detail')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.TRANSFER_BANK, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

}
