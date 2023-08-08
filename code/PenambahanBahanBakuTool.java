package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penambahanbahanbaku.PenambahanBahanBakuParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PenambahanBahanBakuTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(PenambahanBahanBakuParam.class);
	static String w = AccurateModule.PENAMBAHAN_BAHAN_BAKU.getXpath();
	
	public static void KlikAmbilFavorit(WebDriver driver, String search)
	{
		String xpath = w + "//button[@name='btnGetFrom']";
		AccTool.click(driver, xpath);
		xpath = "//*[contains(@class,'dropdown-menu')]//*[contains(text(),'Favorit')]";
		AccTool.click(driver, xpath);
		if(search != null)
		{
			xpath = "//div[contains(@id, 'copy-memorize-transaction')]";
			AccTool.click(driver, xpath + "//input[@name='lookup']");
			AccTool.lookup(driver, xpath, "@name='lookup'", search);
		}
	}
	
	public static void klikTabInfoLain(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
	}
	
	public static void klikButtonLanjutTabDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 20);
	}
	
	public static void klikButtonLanjutTabDetailBiaya(WebDriver driver) {
		String path = "//*[contains(@id,'detail-expense')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 20);
	}

	public static void klikButtonDeleteDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 20);
	}
	
	public static void klikButtonDeleteDetailBiaya(WebDriver driver) {
		String path = "//*[contains(@id,'detail-expense')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 20);
	}
	
	public static void klikRincianJCIA1(WebDriver driver){
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//*[@class='grid-canvas']/div[1]");
	}
	
	public static void klikTabBiayaLainnya(WebDriver driver)
	{
//		AccTool.click(driver,
//				"//a[contains(@href, '#tab-expense')]/*[@class='acc-icon-expense']");
		//ui baru
		AccTool.click(driver,
				"//i[contains(@class, 'icn-transaction-expense')]");
	}
	
	public static void klikTabNoSeri(WebDriver driver) {
		log.info("PenambahanBahanBaku.klikTabNoSeri");
		
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
	}
	

	public static void klikOKPopUpWarning(WebDriver driver) {
		String path = "//*[@name='btnOk']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikButtonCloseTabDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikButtonCloseTabDetailBiaya(WebDriver driver) {
		String path = "//*[text()='Biaya Lainnya']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikLanjutIsiNoSeri(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
	}
	
	public static void klikRancanganFormulir(WebDriver driver){
		AccTool.click(driver, "//*[contains(@id,'btn-form-template--')]");
	}
	
	public static void isiForm (WebDriver driver,PenambahanBahanBakuParam param)
	{
		log.info("IsiForm");
		
		String w = AccurateModule.PENAMBAHAN_BAHAN_BAKU.getXpath();
		if(param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if(param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);	
		if(param.tipe != null)
			AccTool.combobox(driver, w, "@name='materialAdjustmentType'", param.tipe);	
		if(param.nopekerjaan != null)
			AccTool.lookup(driver, w, "@name='jobOrder'", param.nopekerjaan);
		if(param.nopenambahan != null)
			AccTool.lookup(driver, w, "@name='pickAdjustment'", param.nopenambahan);
	}
	
	
	public static void isiDetailBarang (WebDriver driver,PenambahanBahanBakuParam param)
	{
		log.info("IsiDetailBarang");
		
		String tab = "//div[starts-with(@id,'tab-item')]";
		AccTool.click(driver, "//*[contains(@href,'tab-item')]");
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void detailBarang (WebDriver driver,PenambahanBahanBakuParam param)
	{
		log.info("DetailBarang");

		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");	
		if(param.namabarang != null)
			AccTool.textField(driver, tab, "@name='detailName'", param.namabarang);
		if(param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		if(param.satuan != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);
		if(param.ktskontrolkeluar != null)
			AccTool.numberField(driver, tab, "@name='controlQuantity'", param.ktskontrolkeluar);
		if(param.gudang != null)
			AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
		if(param.departemenmandatory != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
		if(param.proyekmandatory != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
	}
	
	public static void KeteranganBarang(WebDriver driver, PenambahanBahanBakuParam param)
	{
		log.info("KeteranganBarang");
		
		//isi window tab detail barang
		String tab = "//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[contains(@id,'tabcustomfield')]");
		if(param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);
		if(param.proyek != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyek);
		if(param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
	}
	
	
	public static void isiDetailBiaya(WebDriver driver, PenambahanBahanBakuParam param)
	{
		log.info("IsiDetailBiaya");
		
		String tab = "//div[starts-with(@id,'tab-expense')]";
		AccTool.click(driver, "//*[contains(@href,'tab-expense')]");

		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);				
				
	}
	
	public static void detailBiaya(WebDriver driver, PenambahanBahanBakuParam param)
	{
		log.info("DetailBiaya");
		
		String tab= "//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		if (param.namabiaya != null)
			AccTool.textField(driver, tab, "@name='expenseName'", param.namabiaya);
		if (param.jumlah != null)
			AccTool.numberField(driver, tab, "@name='expenseAmount'",	param.jumlah);
//		if (param.departemenbiaya != null)
//			AccTool.lookup(driver, tab, "@name='department'", param.departemenbiaya);
//		if (param.proyekbiaya != null)
//			AccTool.lookup(driver, tab, "@name='project'", param.proyekbiaya);
		//ui baru
		if (param.departemenbiayamandatory != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemenbiayamandatory);
		if (param.proyekbiayamandatory != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyekbiayamandatory);
	}
	
	public static void keteranganBiaya(WebDriver driver, PenambahanBahanBakuParam param)
	{
		log.info("KeteranganBiaya");
		
		String tab= "//*[contains(@id,'detail-expense')]//*[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[contains(@id,'tabcustomfield')]");
		if (param.departemenbiaya != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemenbiaya);
		if (param.proyekbiaya != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyekbiaya);
		if (param.keteranganbiaya != null)
			AccTool.textarea(driver, tab, "@name='expenseNotes'", param.keteranganbiaya);
	}
	
	public static void isiInfoLain(WebDriver driver, PenambahanBahanBakuParam param)
	{
		log.info("IsiInfoLain");
		
		String tab = "//div[starts-with(@id,'tab-otherheader')]";
		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
		
		if (param.keteranganinfolain != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keteranganinfolain);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
				
	}
	

	public static void isiNoSeri(WebDriver driver, PenambahanBahanBakuParam param) {
		log.info("PenambahanBahanBaku.isiNoseri");
		
		String tab =  "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
		
		if (param.jumlahsn != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.jumlahsn);
		if (param.sn != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.sn);
		if (param.tglkadaluarsa != null)
			AccTool.datePicker(driver, tab, "@name='expiredDateSn'", param.tglkadaluarsa);
	}
	
	
	public static void List(WebDriver driver, PenambahanBahanBakuParam param)
	{
		log.info("List");

		String w = param.w;	
		String tab = w + "//div[starts-with(@class,'module-list')]";
		
		AccTool.textField(driver, tab, "@name='keyword'", param.search);
		AccTool.scrollRow(driver, tab, param.scroll);		
				
	}
	
	public static void saveIsiHeader (WebDriver driver , String filename)
	{
		log.info("SaveIsiHeader");
		
		String tab = "";
		String content = "PenambahanBahanBaku.saveIsiHeader :"  + "\r\n";
			content = content
					+ "\r\n"
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, ElementType.DATEPICKER, "transDate", tab)
					+ "Nomor : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, ElementType.TEXTFIELD, "number", tab)
					+ "No Pekerjaan : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, "//div[contains(@data-bind,'formData.jobOrder()')]")
					+ "Tipe : "
					+ AccTool.getTextValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, "//div[@class='text-panel-disabled']").replace(",", "")
					+"\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveListDetailBarang (WebDriver driver , String filename)
	{
		log.info("SaveListDetailBarang");

		String content = "PenambahanBahanBaku.saveListDetailBarang :" + "\r\n";

		content = content 
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, "//*[contains(@id,'tab-item')]")+ "\r\n";
			
		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveDetailBarang(WebDriver driver, String filename)
	{
		log.info("SaveDetailBarang");
		
		String tab ="";
		String tab2 ="";
		String content = "PenambahanBahanBaku.saveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			content = content
					+ "\r\n"
					+ "Nama Barang : "
					+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Kts Kontrol Keluar : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "controlQuantity", tab)
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
					+ "Gudang : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
					+ "Departemen : " 
		        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
	            	+ "Proyek : "
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span")
					+ "\r\n";
		
			tab2 = "//*[contains(@id,'details-tab')]//div[starts-with(@id,'tab-customfield')]";
			AccTool.click(driver, "//*[contains(@id,'details-tab')]//a[contains(@id,'tabcustomfield')]");
			
			String dept = "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span";
			if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
				content = content + "Departemen : "
			        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span");
			}
			
			String proy = "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span";
			if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
				content = content+ "Proyek : "
		            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span");
			}
			
			content = content
					+ "\r\n"
					+ "Catatan	: "
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "detailNotes", tab2) 
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
	}
	
	//save datail barang sebelum simpan, untuk memyimpan stok tersedia digudang
	public static void saveDetailBarang2(WebDriver driver, String filename)
	{
		log.info("SaveDetailBarang");
		
		String tab ="";
		String content = "PenambahanBahanBaku.saveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			content = content
					+ "\r\n"
					+ "Stok Tersedia : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "availableStock", tab)
					+ "\r\n";
		
			AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveKeteranganBarang(WebDriver driver, String filename)
	{
		log.info("SaveIsiKeterangan");
		
		String tab = "";
		String content = "PenambahanBahanBaku.saveKeteranganBarang : " + "\r\n";	
		tab = "//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[contains(@id,'tabcustomfield')]");	
			content = content
					+ "\r\n"
					+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab)
					+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void SaveListBiaya (WebDriver driver , String filename)
	{
		log.info("SaveListBiaya");
		
		String content = "PenambahanBahanBaku.saveListBiaya : " + "\r\n";
		content = content  
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, "//*[contains(@id,'tab-expense')]")+ "\r\n";
			
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailBiaya(WebDriver driver, String filename)
	{
		log.info("SaveDetailBiaya");
		
		String tab = "//div[starts-with(@id,'tab-detailexpense')]";
		String content = "PenambahanBahanBaku.saveDetailBiaya : " + "\r\n";
	//	AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		content = content
			+ "\r\n"
			+ "Nama Biaya : "
			+ AccTool.getTextValue(driver, 
					ElementType.TEXTFIELD, "expenseName", tab)
			+ "Jumlah : "
			+ AccTool.getTextValue(driver, 
					ElementType.NUMBERFIELD, "expenseAmount", tab)
			+ "Departemen :"
			+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
			+ "Proyek :"
			+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span")
			+"\r\n";
		
		tab = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tabcustomfield')]");
		
		String dept = "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
			content = content + "Departemen : "
		        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span");
		}
		
		String proy = "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
			content = content+ "Proyek : "
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span");
		}
		
		content = content
				+ "Catatan	: "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab) 
				+ "\r\n";
			
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveKeteranganBiaya(WebDriver driver, String filename)
	{
		log.info("SaveIsiKeteranganBiaya");
		
		String tab = "";
		String content = "PenambahanBahanBaku.saveKeteranganBiaya : " + "\r\n";	
		tab = "//*[starts-with(@id,'detail-expense')]//*[starts-with(@id,'tab-customfield')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
		//ui baru
		AccTool.click(driver, "//*[starts-with(@id,'detail-expense')]//*[starts-with(@id,'tabcustomfield')]");		
			content = content
					+ "\r\n"
					+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab)
					+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveInfoLain (WebDriver driver, String filename)
	{
		log.info("SaveInfoLain");
		
		String content = "PenambahanBahanBaku.saveInfoLain : " + "\r\n";
		String tab = "//*[contains(@id,'tab-otherheader')]";
		String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		content = content
				+ "\r\n"
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, ElementType.TEXTAREA, "description", tab);
				if(WebElementTool.isElementExists(driver, By.xpath(namacabang)))
				{
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, ElementType.COMBOBOX, "branch", tab) + "\r\n";
				} else {
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, ElementType.SUMMARY, "branchListOption", tab) + "\r\n";
				}

		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("PenambahanBahanBaku.SaveIsiDetailSerialNumber");

		String grid = "";
		String content = "PenambahanBahanBaku.saveIsiDetailSerialNumber : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";
		content = content 
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	public static void saveNotifNoseri(WebDriver driver, String fileName)
	{
		log.info("PenambahanBahanBaku.SaveNotifNoSeri");
	
		String tab = "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
		String content = "PenambahanBahanBaku.SaveNotifNoSeri : " + "\r\n";
		content = content  
				+ "\r\n" 
				+ AccTool.getTextValue(driver, ElementType.REPORT, " ", tab) + "\r\n";

        AccTool.writeTextFile(fileName, content);
     }
	
	
	public static void saveIsiPopup(WebDriver driver, String fileName)
	{
		log.info("Save isi popup ");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	String content = "PenambahanBahanBaku.Warning : " + "\r\n";
	content = content
			+ "Notifikasi"
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
	AccTool.writeTextFile(fileName, content);
	}
	
	
	public static void saveList(WebDriver driver, String filename) {
		log.info("Penambahan Bahan Baku.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "PenambahanBahanBaku.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.PENAMBAHAN_BAHAN_BAKU, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	
}
