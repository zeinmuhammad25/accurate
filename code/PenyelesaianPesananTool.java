package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penyelesaianpesanan.PenyelesaianPesananParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;


public class PenyelesaianPesananTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(PenyelesaianPesananParam.class);
	static String w = AccurateModule.PENYELESAIAN_PESANAN.getXpath();

	
	public static void klikButtonLanjutTabDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 300);
		AccTool.waitProgressBar(driver);
	}
	
	
	public static void klikButtonLanjutTabDetailBiaya(WebDriver driver) {
		String path = "//*[contains(@id,'detail-expense')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 100);
	}
	
	public static void klikButtonLanjutTabDetailSerialNumber(WebDriver driver) {
		WaitTool.delay(100);
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.delay(200);
		
	}
	
	public static void klikButtonDeleteDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikButtonDeleteDetailAkun(WebDriver driver) {
		String path = "//*[contains(@id,'detail-expense')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikRincianPenyelesaian1(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[1]");
	}
	
	
	public static void klikTabBiaya(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//a[contains(@href,'tab-detailexpense')]");
	}
	
	
	
	public static void klikOKPadaWarningTutupTab(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'confirm-dialog')]//*[@name='btnOk']");
		WaitTool.delay(1000);
	}

	
	public static void klikTabSerialNumberBarang(WebDriver driver)
	{
		log.info("masuk sn");
		AccTool.click(driver, "//a[contains(@href, '#tab-serial-number')]");
	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTabInfoLain(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
	}
	
	public static void isiForm(WebDriver driver, PenyelesaianPesananParam param)
	{
		log.info("penyelesaianpesanan.isiForm");
		
		String w = AccurateModule.PENYELESAIAN_PESANAN.getXpath();
		
		if (param.tanggal != null)
		AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if (param.nopembiayaan != null)
		AccTool.lookup(driver, w, "@name='jobOrder'", param.nopembiayaan);
		if (param.tipepenyelesaian != null)
		AccTool.combobox(driver, w, "@name='rollOverType'", param.tipepenyelesaian);
		if (param.penomoran != null)
		AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if(param.no != null)
		AccTool.textField(driver, w, "@name='number'", param.no);	
				
	}
	
	public static void isiDetailBarang (WebDriver driver,PenyelesaianPesananParam param)
	{
		log.info("penyelesaianpesanan.isiDetailBarang");
		
		String tab = "//div[starts-with(@id,'tab-item')]";
		AccTool.click(driver, "//*[contains(@href,'tab-item')]");
		
		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void detailBarang (WebDriver driver,PenyelesaianPesananParam param)
	{
			log.info("penyelesaianpesanan.detailBarang");

			String tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");	
			if (param.kuantitas != null) {
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
//				AccTool.click(getWebDriver(),
//						"//div[starts-with(@id, 'detail-item')]//label[@data-bind='text: ft.quantity.title']");
//				AccTool.waitLoaderMedium(driver);
//				WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
			}
			if (param.unit != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'",	param.unit);
			if (param.porsi != null)
			AccTool.numberField(driver, tab, "@name='portion'",	param.porsi);
			if (param.gudang != null) {
				AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
				AccTool.click(getWebDriver(),
						"//div[starts-with(@id, 'detail-item')]//label[@data-bind='text: ft.quantity.title']");
				AccTool.waitLoaderMedium(driver);
			}
	}
	
	
	
	public static void isiNoSeri(WebDriver driver, PenyelesaianPesananParam param) {
		log.info("PemyelesaianPesanan.DetailNOSERI");

		String tab = "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");

		if (param.kuantitasnoseri != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.kuantitasnoseri);
		if (param.noseri != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.noseri);
	}
	
	
	public static void isiDetailAkun(WebDriver driver, PenyelesaianPesananParam param)
	{
		log.info("penyelesaianpesanan.isiDetailAkun");
		
		String tab = "//div[starts-with(@id,'tab-expense')]";
		AccTool.click(driver, "//*[contains(@href,'tab-expense')]");

		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
			AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}

	public static void detailAkun(WebDriver driver, PenyelesaianPesananParam param)
	{
		log.info("penyelesaianpesanan.detailAkun");
		
		String tab= "//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		if (param.nama != null)
		AccTool.textField(driver, tab, "@name='expenseName'", param.nama);
		if (param.porsi != null)
		AccTool.numberField(driver, tab, "@name='portion'",	param.porsi);
		if (param.departemenmandatory != null)
		AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
		if (param.proyekmandatory != null)
		AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
	}
	
	public static void isiInfoLain(WebDriver driver, PenyelesaianPesananParam param)
	{
		log.info("penyelesaianpesanan.isiInfoLain");
		
		String tab = "//div[starts-with(@id,'tab-otherheader')]";
		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);		
	}
	
		
	public static void keteranganBarang(WebDriver driver, PenyelesaianPesananParam param)
	{
		log.info("penyelesaianpesanan.keteranganBarang");
		
//		isi window tab detail barang
		String tab = "//div[starts-with(@id,'tab-notes')]";
		AccTool.click(driver, "//*[contains(@id,'etail-item')]//*[starts-with(@id,'tab-customfield')]");
		if(param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
	}


	
	public static void keteranganAkun(WebDriver driver, PenyelesaianPesananParam param)
	{
		log.info("penyelesaianpesanan.keteranganAkun");
		
//		String tab= "//div[starts-with(@id,'tab-notes')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		
		//ui baru
		String tab = "//*[contains(@id,'detail-expense')]//*[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[contains(@id,'tabcustomfield')]");
		if (param.departemen != null)
		AccTool.lookup(driver, tab, "@name='department'", param.departemen);
		if (param.proyek != null)
		AccTool.lookup(driver, tab, "@name='project'", param.proyek);
		
		if (param.keterangan != null)
		AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
	}
		
		
	

	public static void List(WebDriver driver, PenyelesaianPesananParam param)
	{
		log.info("penyelesaianpesanan.list");

		String w = param.w;	
		String tab = w + "//div[starts-with(@class,'module-list')]";
		
		AccTool.textField(driver, tab, "@name='keyword'", param.search);
		AccTool.scrollRow(driver, tab, param.scroll);		
				
	}
	
	public static void saveDetailBarang(WebDriver driver, String filename)
	{
		log.info("PenyelesaianPesanan.saveDetailBarang");
		//WaitTool.delay(500);
		AccTool.waitProgressBar(driver);
		
		String tab ="";
		String content = "PenyelesaianPesanan.SaveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			content = content
					+ "\r\n"
					+ "Nama Barang : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.detailName", tab)
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Unit : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
					+ "Porsi % : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "portion", tab)
					+ "Alokasi Biaya : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "formData.allocationAmount", tab)
					+ "Gudang : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
					+ "\r\n";
		
			AccTool.writeTextFile(filename, content);
	}
			
	public static void saveIsiNotes(WebDriver driver, String filename) {
		log.info("PenyelesaianPesanan.saveIsiNotes");

		String tab = "";
		String content = "PenyelesaianPesanan.SaveIsiNotes : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-notes')]";
		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		content = content + "\r\n" + "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
			
	public static void saveIsiAkun(WebDriver driver, String filename) {
		log.info("PenyelesaianPesanan.saveIsiAkun");
		
		// String tab = "//div[starts-with(@id,'tab-detailexpense')]";
		String tab = "";
		String content = "PenyelesaianPesanan.SaveIsiAkun : " + "\r\n";
		AccTool.click(driver, "//*[contains(@id,'tabdetailexpense')]");
		content = content 
				+ "\r\n" 
				+ "Nama Biaya : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab) 
				+ "Porsi : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "portion", tab) 
				+ "Alokasi Biaya : "
				+ AccTool.getTextValue(driver, ElementType.LABEL, "formData.allocationAmount", tab)
				+ "Departemen :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span") + "\r\n";

		tab = "//*[starts-with(@id,'detail-expense')]//*[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[starts-with(@id,'detail-expense')]//*[starts-with(@id,'tabcustomfield')]");
		content = content 
				+ "Departemen :"
				+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek :"
				+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span") 
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
			
	
	public static void saveIsiHeader (WebDriver driver , String filename)
	{
		log.info("PenyelesaianPesanan.saveIsiHeader");
		
		String tab = "";
		String content = "Penyelesaian Pesanan.SaveIsiHeader : " + "\r\n";
		
			content = content
					+ "\r\n"
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_PESANAN, ElementType.DATEPICKER, "transDate", tab)
					+ "Nomor : "
					+ AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_PESANAN, ElementType.TEXTFIELD, "number", tab)
					+ "No Pekerjaan : "
					+ AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_PESANAN, "//div[contains(@data-bind,'formData.jobOrder()')]")
					+ "Tipe Penyelesaian : "
					+ AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_PESANAN, "//div[contains(@data-bind,'ft.rollOverType')]//*[@class='text-panel-disabled']")
					+"\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveInfoLain (WebDriver driver, String filename)
	{
		log.info("PenyelesaianPesanan.SaveInfoLain");
		
		String content = "PenyelesaianPesanan.saveInfoLain : " + "\r\n";
		String tab = "//*[contains(@id,'tab-otherheader')]";
		String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		content = content
				+ "\r\n"
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_PESANAN, ElementType.TEXTAREA, "description", tab);
				if(WebElementTool.isElementExists(driver, By.xpath(namacabang)))
				{
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_PESANAN, ElementType.COMBOBOX, "branch", tab) + "\r\n";
				} else {
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_PESANAN, ElementType.SUMMARY, "branchListOption", tab) + "\r\n";
				}

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListDetailBarang (WebDriver driver , String filename)
	{
		log.info("PenyelesaianPesanan.saveListDetail");
		
		AccTool.waitProgressBar(driver);
		String content = "PenyelesaianPesanan.SaveListDetailBarang : " + "\r\n";

		content = content 
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PENYELESAIAN_PESANAN, "//*[contains(@id,'tab-item')]")+ "\r\n";
			
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListAkun (WebDriver driver , String filename)
	{
		log.info("PenyelesaianPesanan.saveListDetailAkun");
		

		String content = "Penyelesaian Pesanan.SaveListDetailAkun : " + "\r\n";

		content = content 
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PENYELESAIAN_PESANAN, "//*[contains(@id,'tab-expense')]")
				+ "\r\n";
			
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveKeteranganDetailBarang(WebDriver driver, String filename) {
		
		log.info("PenyelesaianPesanan.saveKeteranganDetailBarang");
		
		String tab = "";
		String content = "PenyelesaianPesanan.SaveKeteranganDetailBarang : " + "\r\n";
		tab = "//*[contains(@id,'tab-otherheader')]";
		AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
		content = content
				+ "\r\n"
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYELESAIAN_PESANAN, ElementType.TEXTAREA, "description", tab) 
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveListRincianPenyelesaian(WebDriver driver,String filename)
	{
		log.info("PenyelesaianPesanan.saveListRincianPenyelesaian");

		String content = "PenyelesaianPesanan.SaveListRincianPenyelesaian : " + "\r\n";
		String tab = "//*[contains(@id,'tab-item')]";
		content = content
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PENYELESAIAN_PESANAN, tab) 
				+ "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	
	
	public static void SaveNotifNoseri(WebDriver driver, String fileName) {
		log.info("PenyelesaianPesanan.SaveNotifNoSeri");

		String tab = "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
		String content = "PenyelesaianPesanan.SaveNotifNoSeri : " + "\r\n";
		content = content + "Notifikasi" + "\r\n" + AccTool.getTextValue(driver, ElementType.REPORT, " ", tab) + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}

	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("PenyelesaianPesanan. SaveIsiDetailSerialNumber");

		String grid = "";
		String content = "Nomor Seri Detail Barang  : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";
		content = content
				+ "\r\n" 
				+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	public static void saveList(WebDriver driver, String filename) {
		log.info("Penyelesaian Pesanan.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "PenyelesaianPesanan.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.PENYELESAIAN_PESANAN, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	

		
}
