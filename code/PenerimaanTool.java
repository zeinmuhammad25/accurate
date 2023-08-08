package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penerimaan.PenerimaanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PenerimaanTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PenerimaanTool.class);
	
	public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PENERIMAAN.getXpath() + "//a[contains(@href,'#tab-otherheader')]");
	}

	public static void klikBtnLanjutPenerimaan(WebDriver driver) {
		String path = "//*[contains(@id,'detail-other-deposit')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnLanjutPenerimaanFavorit(WebDriver driver) {
		String path = "//*[contains(@id,'copy-memorize-transaction')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnLanjutPenerimaanTambahFavorit(WebDriver driver) {
		String path = "//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
// dibuat tanggal 12 maret 2018 untuk hapus list data penerimaan
	
			public static void klikBtnHapusListDataPenerimaan(WebDriver driver) {
				String path = "//*[contains(@id,'detail-other-deposit')]//button[@name='btnDelete']";
				AccTool.click(driver, path);
				WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
			}

	public static void isiForm(WebDriver driver, PenerimaanParam param) {
		log.info("Penerimaan.IsiForm");

		String w = AccurateModule.PENERIMAAN.getXpath();

		if (param.kasbank != null)
			AccTool.lookup(driver, w, "@name='bank'", param.kasbank);
		if (param.kurs != null)
			AccTool.numberField(driver, w, "@name='rate'", param.kurs);
//		if (param.nocek != null)
//			AccTool.textField(driver, w, "@name='chequeNo'", param.nocek);
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if (param.tanggalcek != null)
			AccTool.datePicker(driver, w, "@name='chequeDate'", param.tanggalcek);
	}

	public static void IsiDetail(WebDriver driver, PenerimaanParam param) {
		log.info("Penerimaan.IsiDetail");
		String tab = "//div[starts-with(@id,'tab-detail')]";

		AccTool.click(driver, "//a[contains(@href,'tab-detail')]");

		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}

	public static void IsiInfoLain(WebDriver driver, PenerimaanParam param) {
		log.info("Penerimaan.IsiInfoLain");

		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-otherheader')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		if (param.nocek != null){
			AccTool.textField(driver, w, "@name='chequeNo'", param.nocek);
			AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
			if (param.tanggalcek != null)
				AccTool.datePicker(driver, w, "@name='chequeDate'", param.tanggalcek);
		}
		
		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.catatan);
		if (param.pemberi != null)
			AccTool.textarea(driver, tab, "@name='payee'", param.pemberi);
		if (param.cbvoid != null)
			AccTool.checkbox(driver, tab, "@name='voidCheq'", param.cbvoid);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
//		if (param.tanggalcek != null)
//			AccTool.datePicker(driver, w, "@name='chequeDate'", param.tanggalcek);

	}

	public static void detailPenerimaan(WebDriver driver, PenerimaanParam param) {
		log.info("Penerimaan.detailPenerimaan");

		String tab = "";

		if (param.tab != null)
			switch ((param.tab).toLowerCase()) {

			case "rincian penerimaan":
				tab = "//div[starts-with(@id,'tab-detailexpense')]";

				AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
				if (param.ataspenerimaan != null)
					AccTool.textField(driver, tab, "@name='expenseName'", param.ataspenerimaan);
				if (param.nilai != null)
					AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
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
				tab = "//div[starts-with(@id,'tab-customfield')]";
				AccTool.click(driver, "//a[contains(@href,'tab-customfield')][.='Info lainnya']");
				if (param.departemen != null)
					AccTool.lookup(driver, tab, "@name='department'", param.departemen);
				if (param.proyek != null)
					AccTool.lookup(driver, tab, "@name='project'", param.proyek);
				if (param.catatan != null)
					AccTool.textarea(driver, tab, "@name='memo'", param.catatan);
				break;
			}
	}

	public static void saveData(WebDriver driver, PenerimaanParam param, String filename) {
		log.info("Penerimaan.SaveData");

		String w = param.w;
		String tab = "";
		String content = "Penerimaan.SaveData : " + "\r\n";

		switch (param.tab.toLowerCase()) {
		case "header":
			content = content + "Header" + "\r\n" + "Kas Bank : "
					+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.LOOKUP, "bank", tab)
					+ "No Cek : "
					+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.TEXTFIELD, "chequeNo", tab)
					+ "Tanggal Cek : "
					+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.DATEPICKER, "chequeDate", tab)
					+ "No Bukti : "
					+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.TEXTFIELD, "number", tab)
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.DATEPICKER, "transDate", tab)
					+ "\r\n";

			break;
		case "detail":
			AccTool.click(driver, w + "//a[contains(@href,'tab-detail')]");
			tab = w + "//*[contains(@id,'tab-detail')]";
			content = content + "Detail" + "\r\n" + AccTool.getGridValue(driver, AccurateModule.PENERIMAAN, tab)
					+ "\r\n";
			break;

		case "info lain":
			AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
			tab = w + "//*[contains(@id,'tab-otherheader')]";
			content = content + "Catatan :"
					+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.TEXTAREA, "description", tab)
					+ "Pemberi :"
					+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.TEXTAREA, "payee", tab)
					+ "V O I D :"
					+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.CHECKBOX, "voidCheq", tab)
					+ "Cabang :"
					+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.COMBOBOX, "branch", tab)
					+ "\r\n";

			break;
		}

		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveDetail(WebDriver driver, String filename) {
		log.info("Penerimaan.SaveDetail");

		String tab = "";
		String content = "Penerimaan.SaveDetail : " + "\r\n";

		tab = "//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		content = content + "Rincian Penerimaan" + "\r\n" + "Atas Penerimaan :"
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab) + "Nilai :"
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amount", tab) + "Departemen :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span") + "Proyek :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span") + "\r\n";
		//uilama
//		tab = "//div[starts-with(@id,'tab-notes')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//uiBaru
		tab = "//*[contains(@id,'tab-customfield')]";
		AccTool.click(driver, " //*[contains(@id,'tabcustomfield')]");
		
		
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

	public static void SaveHeader(WebDriver driver, String fileName) {
		log.info("Penerimaan.SaveHeader");

		String tab = "";
		String content = "Penerimaan.SaveHeaderPenerimaan : " + "\r\n";
		content = content
				+ "Kas Bank : "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.LOOKUP, "bank", tab)
				+ "Kurs : "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.NUMBERFIELD, "rate", tab)
//				+ "No Cek : "
//				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.TEXTFIELD, "chequeNo", tab)
//				+ "Tanggal Cek : "
//				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.DATEPICKER, "chequeDate", tab)
				+ "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.DATEPICKER, "transDate", tab)
				+ "No Bukti : "
				+ AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.TEXTFIELD, "number", tab)
				+ "\r\n";
		AccTool.writeTextFile(fileName, content);
	}

	public static void saveInfoLain(WebDriver driver, String filename) {
		log.info("Penerimaan.SaveInfoLain");

		AccTool.click(driver, AccurateModule.PENERIMAAN.getXpath() + "//*[contains(@href,'tab-otherheader')]");
		String tab = "//*[contains(@id,'tab-otherheader')]";
		String content = "Penerimaan.SaveInfoLain : " + "\r\n";
				String cheq = "//*[contains(@id,'tab-otherheader')]//div[input[@name='chequeDate']]";
		if (WebElementTool.isElementVisible(driver, By.xpath(cheq))) {
			content = content
					+ AccTool.getTextValue(driver, "//*[@data-bind='text: ft.chequeNo.title']").replace("\r\n", " : ") + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.TEXTFIELD, "chequeNo", tab)
					+ AccTool.getTextValue(driver, "//*[@data-bind='text: ft.chequeDate.title']").replace("\r\n", " : ") + AccTool.getTextValue(driver, AccurateModule.PENERIMAAN, ElementType.TEXTFIELD, "chequeDate", tab);
		}
		content = content
				+ "Catatan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "description", tab)
				+ "Pemberi : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "payee", tab)
				+ "VOID : "
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "voidCheq", tab) 
				+ "Cabang : "
				+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "branch", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void rincianpenerimaan(WebDriver driver, PenerimaanParam param) {
		log.info("Rincian Penerimaan");

		String tab = "//div[starts-with(@id,'tab-detailexpense')]";

		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");

		if (param.nilai != null)
			AccTool.numberField(driver, tab, "@name='amount'", param.nilai);

	}

	public static void saveListRincianPenerimaan(WebDriver driver, String filename) {
		log.info("Penerimaan.saveListRincianPenerimaan");

		String content = "Penerimaan.SaveListRincianPenerimaan : " + "\r\n";
		String tab = "//*[contains(@id,'tab-detail')]";
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.PENERIMAAN, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	// hanya untuk baris pertama
	public static void klikRincianPenerimaanBaris1(WebDriver driver) {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'detail-other-deposit-grid-list')]//*[@class = 'grid-canvas']/div[1]");
	}
	// hanya untuk baris kedua
	public static void klikRincianPenerimaanBaris2(WebDriver driver) {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'detail-other-deposit-grid-list')]//*[@class = 'grid-canvas']/div[2]");
	}
	// hanya untuk baris ketiga
		public static void klikRincianPenerimaanBaris3(WebDriver driver) {
			AccTool.click(getWebDriver(),
					"//*[contains(@id,'detail-other-deposit-grid-list')]//*[@class = 'grid-canvas']/div[3]");
		}


// dibuat tanggal 21 februari 2018 untuk menutup pop up rincian penerimaan

	public static void klikTutupPopUpRincianPenerimaan(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void isiDetailTransaksiFavorit(WebDriver driver,PenerimaanParam param)
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


}
