package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.jurnalumum.JurnalUmumParam;
import com.cpssoft.web.test.accurate.pencatatanbeban.PencatatanBebanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PencatatanBebanTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PencatatanBebanTool.class);

	public static void pilihDetailBeban(WebDriver driver, PencatatanBebanParam param)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-expense-accrual-grid-list')]//div[@class='grid-canvas']/div["+param.urutan+"]");
	} 
	
	public static void klikButtonCloseTabRincianBeban(WebDriver driver) {
		String path = "//*[text()='Rincian Beban']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikbtnHapusRincianBeban()
	{
		AccTool.click(getWebDriver(), "//div[contains(@id,'detail-expense-accrual')]//*[@name='btnDelete']");
	}
	
	public static void klikButtonLanjutDetailBeban(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-expense-accrual')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
//		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 5);
//		AccTool.waitProgressBar(driver);
	}
	
	public static void isiHeader(WebDriver driver, PencatatanBebanParam param) {
		log.info("PencatatanBeban.IsiHeader");

		String w = AccurateModule.PENCATATAN_BEBAN.getXpath();
		
		if (param.hutangbeban != null) {
			AccTool.lookup(driver, w, "@name='expensePayable'", param.hutangbeban);
			AccTool.waitProgressBar(driver);
		}
		if (param.nobeban != null)
		AccTool.textField(driver, w, "@name='number'", param.nobeban);
		if (param.tanggal != null)
		AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if (param.penomoran != null)
		AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.jatuhtempo != null)
		AccTool.datePicker(driver, w, "@name='dueDate'", param.jatuhtempo);
	}

	public static void isiRincian(WebDriver driver, PencatatanBebanParam param) {
//		log.info("PencatatanBeban.IsiRincian");
//		
//		String w = param.w;
//		String tab = w + "//*[contains(@id,'tab-detail')]";		
//		
//		AccTool.click(driver, w + "//a[contains(@href,'tab-detail')]");
//				
//		AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);			
//		AccTool.scrollRowDetail(driver, tab, param.scroll);		
		
		String tab = AccurateModule.PENCATATAN_BEBAN.getXpath() + "//*[contains(@id,'tab-detail')]";	
//		WaitTool.waitForElementClickable(driver, By.xpath(tab + "//input[@name='searchDetailAccount']"), 6);
		
		AccTool.click(driver, AccurateModule.PENCATATAN_BEBAN.getXpath() + "//a[contains(@href,'tab-detail')]");
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
			WaitTool.delay(2000);
	}
	
	public static void klikTabInfoLainnya()
	{
		AccTool.click(getWebDriver(), "//a[contains(@href,'tab-otherheader')]");
	}
	
	public static void isiInfoLain(WebDriver driver, PencatatanBebanParam param) {
		log.info("PencatanBeban.IsiInfoLain");
		
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver,"//a[contains(@href,'tab-otherheader')]");
		//jatuh tempo param baru di ui baru
		if (param.jatuhtempo != null)
			AccTool.datePicker(driver, "", "@name='dueDate'", param.jatuhtempo);
		if (param.catatan != null)
			AccTool.textarea(driver, "", "@name='description'", param.catatan);
		if (param.cabang != null)
			AccTool.combobox(driver, "", "@name='branch'", param.cabang);
			
	}
	
	public static void detailRincianBeban(WebDriver driver, PencatatanBebanParam param) {
		log.info("PencatatanBeban.DetailRincianBeban");

		String tab = "";

		switch ((param.tab).toLowerCase()) {
		case "rincian beban":
			tab = "//*[contains(@id,'tab-detailexpense')]";
//			AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
			AccTool.click(driver, "//*[contains(@id,'tabdetailexpense')]");

			AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
			AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
			break;
		case "catatan":
			//ui baru
			tab = "//*[contains(@id,'tab-customfield')]";
			AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			AccTool.lookup(driver, tab, "@name='project'", param.proyek);
			AccTool.textarea(driver, tab, "@name='memo'", param.catatan);
			break;
		}
			}
	
	
	
	public static void savedata(WebDriver driver, PencatatanBebanParam param) {
		log.info("PencatatanBeban.SaveHeader");

		String w = param.w;
		String tab = "";
		String content = "PencatatanBeban.SaveHeader : " + "\r\n";

		switch (param.tab.toLowerCase()) {
		case "header":
			content = content
					+ "Hutang Beban : "
					+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
							ElementType.LOOKUP, "expensePayable", tab)
					+ "No Beban : "		
					+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
							ElementType.TEXTFIELD, "number", tab)
					+ "Tanggal : "		
					+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
							ElementType.DATEPICKER, "transDate", tab)
					+ "Tgl Jatuh Tempo : "		
					+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
							ElementType.TEXTFIELD, "dueDate", tab) + "\r\n";
			break;
		case "detail":
			AccTool.click(driver, w + "//a[contains(@href,'tab-detail')]");
			tab = w + "//*[contains(@id,'tab-detail')]";
			content = content + "PencatatanBeban.SaveDetail" + "\r\n"
					+ AccTool.getGridValue(driver, AccurateModule.PENCATATAN_BEBAN, tab) + "\r\n";
			break;

		case "info lain":
			AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
			tab = w + "//*[contains(@id,'tab-otherheader')]";
			content = content
					+ "Info Lain"
					+ "\r\n"
					+ "Catatan : "
					+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
							ElementType.TEXTAREA, "description", tab) + "\r\n";
			break;
		}

		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveRincianBeban(WebDriver driver, String filename) {
		log.info("PencatatanBeban.RincianBeban");

		String tab = "";
		String content = "PencatatanBeban.RincianBeban : " + "\r\n";

		tab = "//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		content = content
				+ "Nama : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab)
				+ "Nilai : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amount", tab)
				+ "Departemen :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span")
				+ "\r\n";

		tab = "//div[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
		content = content
				+ "Catatan :"
				+ "\r\n"
				+ "Departemen :"
				+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span")
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "memo", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	public static void saveIsiHeader(WebDriver driver,String filename)
	{
		log.info("PencatatanBeban.SaveIsiHeader");


		String tab = "";
		String content = "PencatatanBeban.SaveIsiHeader: " + "\r\n";

		content = content
				+ "Hutang Beban : "
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
						ElementType.LOOKUP, "expensePayable", tab)
				+ "No Beban : "		
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
						ElementType.TEXTFIELD, "number", tab)
				+ "Tanggal : "		
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
						ElementType.DATEPICKER, "transDate", tab)
				+ "Tgl Jatuh Tempo : "		
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
						ElementType.TEXTFIELD, "dueDate", tab) + "\r\n";
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListRincianBeban(WebDriver driver,String filename)
	{
		log.info("PencatatanBeban.saveListRincianBeban");

	String content = "PencatatanBeban.SaveListRincianBeban : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-detail')]";
	content = content 
			+ AccTool.getGridValue(driver, AccurateModule.PENCATATAN_BEBAN,
					tab) + "\r\n";
	AccTool.writeTextFile(filename, content);

	}
	public static void isiRincianBeban(WebDriver driver, PencatatanBebanParam param) {
		log.info("PencatatanBeban.IsiRincianBeban");

		log.info("Rincian Beban");

		String tab = "";
		
		tab= "//div[starts-with(@id,'detail-expense-accrual')]";

//			AccTool.click(driver, "//a[contains(@href,'detail-expense-accrual')]");
			if(param.beban != null)
			AccTool.textField(getWebDriver(), tab, "@name= 'expenseName'", param.beban);
			if (param.nilai != null)
			AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
			
			
//			tab = "//div[starts-with(@id,'tab-notes')]";
			//ui baru
			tab = "//div[starts-with(@id,'tab-customfield')]";

			AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");			
			if (param.catatan != null)
				AccTool.textarea(driver, tab, "@name='memo'", param.catatan);
			if (param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if (param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);
		
	}

	public static void saveInfoLainnya(WebDriver driver,String filename)
	{
		log.info("PencatatanBeban.saveInfolainnya");

	String content = "PencatatanBeban.SaveInfoLainnya : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-otherheader')]";
	content = content 
	        + "Catatan : "
	        + AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN,
			ElementType.TEXTAREA, "description", tab);
	
	      //Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
			String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
			if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
				content = content + "Cabang : "
						+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN, ElementType.COMBOBOX, "branch", tab);
			} else {
				content = content + "Cabang : "
						+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN, ElementType.SUMMARY, "branchListOption", tab);
			}
			content = content	+ "\r\n";
	AccTool.writeTextFile(filename, content);

	}
	
	public static void klikTabInformasiPesanan(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PENCATATAN_BEBAN.getXpath() +
				"//a[contains(@href, '#tab-summary')]");
	}
	
	public static void saveIsiInfoPencatatanBeban(WebDriver driver, String filename)
	{
		log.info("PencatatanBeban.SaveIsiInfoPencatatanBeban");
		
		//String tab = "";
		String content = "PencatatanBeban.SaveIsiInfoPencatatanBeban : " + "\r\n";
		//tab = AccurateModule.PENCATATAN_BEBAN.getXpath() + "//*[contains(@id,'#tab-summary')]";
		content = content
				+ "Dibayar : " + AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN, ElementType.SPAN, "text: app.util.parseNumber(formData.expensePayable())")
				+ "Status : " + AccTool.getTextValue(driver, AccurateModule.PENCATATAN_BEBAN, ElementType.SPAN, "text: formData.statusName()")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void isiDetailTransaksiFavorit(WebDriver driver, PencatatanBebanParam param)
	{
		log.info("PencatatanBeban.isiDetailTransaksiFavorit");
		String w ="//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]";
		if(param.nama != null)
			AccTool.textField(driver, w, "@name='name'", param.nama);	
		if(param.grup != null)
			AccTool.lookup(driver, w, "@name='useUserRoleAccessList'", param.grup);	
		if(param.user != null)
			AccTool.textField(driver, w, "@name='useUserAccessList'", param.user);	
//		if (param.Komentar != null)				
//	    AccTool.textarea(driver, a, "@name='comment'", param.Komentar);	
		
	}
	
	public static void klikProsesPembayaran(){
		AccTool.click(getWebDriver(), "//*[@name='btnProcess']");
		AccTool.click(getWebDriver(), "//a[text() = 'Pembayaran']");
	}

	public static void klikOKPopUpWarning(WebDriver driver) {		
		AccTool.click(driver, "//div[contains(@id, 'error-dialog')]//button[@name='btnOk' and text()='OK']");
		WaitTool.waitForElementDisapear(driver,
				By.xpath("//div[contains(@id, 'error-dialog')]//button[@name='btnOk' and text()='OK']"), 7);
	}
	
	public static void klikHapusDepartemen()
	{
		AccTool.click(getWebDriver(), "//div[@class='grid fluid no-margin']//div[3]//i[@class='icon-cancel-2']");
	}
	
	public static void klikHapusProyek()
	{
		AccTool.click(getWebDriver(), "//div[@class='grid fluid no-margin']//div[4]//i[@class='icon-cancel-2']");
	}
	
	public static void klikAmbilFavorit(WebDriver driver, PencatatanBebanParam param) {
		AccTool.dropDown(driver, AccurateModule.PENCATATAN_BEBAN.getXpath(),
				"//div[contains(@class, 'offset4 span8')]/div[1]", "Favorit");
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
	}

	  public static void klikLanjutSalinFavorit() {
			NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'copy-memorize-transaction')]");
			WaitTool.waitForElementDisapear(getWebDriver(), By.xpath("//div[contains(@id,'copy-memorize-transaction')]"), 1);
			//WaitTool.delay(500);
		}

	
	
}
