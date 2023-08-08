package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.permintaanbarang.PermintaanBarangParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PermintaanBarangTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(PermintaanBarangParam.class);
	static String w = AccurateModule.PERMINTAAN_BARANG.getXpath();
		
	public static void klikButtonLanjutDetailBarang(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 3);
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikButtonDeleteDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void KlikAmbilBarangPerluDipesan(WebDriver driver)
	{
		String xpath = w + "//button[@name='btnGetFrom']";
		AccTool.click(driver, xpath);
		xpath = "//*[contains(@class,'dropdown-menu')]//*[contains(text(),'Barang perlu dipesan')]";
		AccTool.click(driver, xpath);
	}
	
	
	public static void KlikAmbilTahapan(WebDriver driver,String search)
	{
		String xpath = w + "//button[@name='btnGetFrom']";
		AccTool.click(driver, xpath);
		xpath = "//*[contains(@class,'dropdown-menu')]//*[contains(text(),'Tahapan')]";
		AccTool.click(driver, xpath);
		if(search != null)
		{
			xpath = "//div[contains(@id, 'copy-sub-con-process-stages')]";
			AccTool.click(driver, xpath + "//input[@name='lookup']");
			AccTool.lookup(driver, xpath, "@name='lookup'", search);
		}
	}
	
	public static void klikButtonLanjutAmbilTahapan(WebDriver driver) {
		String path = "//*[contains(@id,'copy-sub-con-process-stages')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTabInfoLainnya(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PERMINTAAN_BARANG.getXpath() +
				"//a[contains(@href, '#tab-otherheader')]");
	}
	
	public static void klikTabInfoLain(WebDriver driver)
	{
	
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
	}
	
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
	
	public static void Isi(WebDriver driver, PermintaanBarangParam param)
	{
		if(param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);		
		if(param.penomoran != null)
			AccTool.textField(driver, w, "@name='number'", param.penomoran);
		if(param.tipediminta != null)
			AccTool.combobox(driver, w, "@name='returnType'", param.tipediminta);
		if (param.kirimkegudang != null)
			AccTool.lookup(driver, w, "@name='warehouse'", param.kirimkegudang);
		
	}
	
	public static void IsiDetailFavorit(WebDriver driver, PermintaanBarangParam param)
	{
		if(param.namafavorit != null)
			AccTool.textField(driver, w, "@name='name'", param.namafavorit);
		if(param.aksespengguna != null)
			AccTool.checkbox(driver, w, "@name= 'usedAllUser'", param.aksespengguna);
		if(param.grupcabang !=null)
			AccTool.lookup(driver, w, "@name='useUserRoleAccessList'", param.grupcabang);
		if(param.pengguna !=null)
			AccTool.lookup(driver, w, "@name = 'useUserAccessList'", param.pengguna);
	}
	
	public static void IsiDetailBarang(WebDriver driver, PermintaanBarangParam param)
	{
		String tab = "//*[contains(@id,'tab-item')]";
		AccTool.click(driver, w + "//a[contains(@href,'tab-item')]");
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void detailBarang(WebDriver driver, PermintaanBarangParam param)
	{
		//isi window tab detail barang
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		if(param.tanggal != null)
			AccTool.datePicker(driver, tab, "@name='requiredDate'", param.tanggal);
		if(param.nama != null)
			AccTool.textField(driver, tab, "@name='detailName'", param.nama);
		if(param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		if(param.departemenmandatory != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
		if(param.proyekmandatory != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
	}
	
	public static void keteranganBarang(WebDriver driver, PermintaanBarangParam param)
	{
		//isi window tab detail barang
		String tab = "//*[starts-with(@id,'tab-customfield')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
		if(param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);
		if(param.proyek != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyek);
		if(param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
	}
	
	public static void isiInfoLain(WebDriver driver, PermintaanBarangParam param)
	{
		String w = AccurateModule.PERMINTAAN_BARANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		if(param.keterangan != null)
			AccTool.textarea(driver, "//div[starts-with(@id,'tab-otherheader')]", "@name='description'", param.keterangan);
		if(param.tutuppesanan != null)
			AccTool.checkbox(driver, "", "@data-bind='metroCheckbox: {}, checked: formData.manualClosed'", param.tutuppesanan);
		if (param.cabang != null)
			AccTool.combobox(driver, "", "@name='branch'", param.cabang);
	}
			
	public static void saveDetailBarang(WebDriver driver, String filename)
	{
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		String content = "PermintaanBarang.SaveDetailBarang : "+ "\r\n";
		
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content
				+ "Tanggal : " + AccTool.getTextValue(driver, ElementType.DATEPICKER, "requiredDate", tab)
				+ "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
                + "Departemen : "
        		+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
            	+ "Proyek : "
            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span");

		tab = "//*[contains(@id,'tab-customfield')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
		
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
				+ "Keterangan : " 
            	+ AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.TEXTAREA, "detailNotes", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiHeader(WebDriver driver, String filename)
	{
		String content = "PermintaanBarang.SaveIsiHeader : "+ "\r\n";
		String tab = "";
		
		content = content
				+ "Tanggal : " + AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.DATEPICKER, "transDate", tab)
				+ "Penomoran : " + AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.TEXTFIELD, "number", tab)
				+ "Tipe Diminta : " + AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.COMBOBOX, "returnType", tab)
				+ "Kirim Ke Gudang : " + AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.LOOKUP, "warehouse", tab) 
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiDetailBarang(WebDriver driver, String filename)
	{
		String content = "PermintaanBarang.SaveIsiDetailBarang : "+ "\r\n";
		String tab =  "//*[contains(@id,'tab-item')]";
		
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.PERMINTAAN_BARANG, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiInfoLain(WebDriver driver, String filename)
	{
		String content = "PermintaanBarang.SaveIsiInfoLain : "+ "\r\n";
		String tab = "//*[contains(@id,'tab-otherheader')]";
		
		content = content
				+ "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.TEXTAREA, "description", tab);
				
		//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.SUMMARY, "branchListOption", tab);
				}
				content = content	+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiInfoPermintaan(WebDriver driver, String filename)
	{
		log.info("PermintaanBarang.SaveIsiInfoPermintaan");
		

		if (WebElementTool.isElementVisible(driver, By.xpath("//*[contains(@class,'icn-transaction-info')]"))) {
			String xpath4 = "//*[contains(@class,'icn-transaction-info')]";
        	AccTool.click(driver, xpath4);
		} else {
            WaitTool.delay(200);
        } 
        		
//		
		//String tab = "";
		String content = "PermintaanBarang.SaveIsiInfoPermintaan : " + "\r\n";
		//tab = AccurateModule.PERMINTAAN_BARANG.getXpath() + "//*[contains(@id,'#tab-summary')]";
		content = content
				+ "Diproses Oleh : " 
				+ "\r\n"	
				+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'data.historyNumber')]")
				+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'data.historyDate')]")
				+ "Status : " + AccTool.getTextValue(driver,  "//*[contains(@data-bind,'doShowTransactionHistoryStatus')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
/*		
	public static void saveList(WebDriver driver,String filename)
	{
		log.info("PERMINTAAN_BARANG.SaveList");

		String content = " Permintaan Barang.SaveList : " + "\r\n";
		String tab  = "//*[contains(@id,'module-accurate__vendor__purchase-requisition')]";
		
		content = content 
				+ AccTool.getGridValue(driver, AccurateModule.PERMINTAAN_BARANG,
				tab) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	*/
	public static void saveList(WebDriver driver, String filename) {
		log.info("PermintaanBarang.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "Permintaan Barang.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.PERMINTAAN_BARANG, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveIsiFavorite(WebDriver driver, String filename)
	{
		String content = "PermintaanBarang.SaveTransaksiFavorit : "+ "\r\n";
		String tab = "";
		
		content = content
				+ "Nama Favorite : " + AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.TEXTFIELD, "name", tab)
				+ "Semua cabang : " + AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.CHECKBOX, "usedAllUser", tab)
				+ "Grup Cabang : " + AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.LOOKUP, "useUserRoleAccessList", tab)
				+ "Pengguna : " + AccTool.getTextValue(driver, AccurateModule.PERMINTAAN_BARANG, ElementType.LOOKUP, "useUserAccessList", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	public static void saveListDetailBarang(WebDriver driver,String filename)
	{
		log.info("PermintaanBarang.saveListDetailBarang");

	String content = "PermintaanBarang.SaveListDetailBarang : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-item')]";
	content = content 
			+ AccTool.getGridValue(driver, AccurateModule.PERMINTAAN_BARANG,
					tab) + "\r\n";
	AccTool.writeTextFile(filename, content);

	}

	public static void klikButtonCloseTabDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	
	
	}

