package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.perintahstokopname.PerintahStokOpnameParam;
import com.cpssoft.web.test.framework.tools.WaitTool;


public class PerintahStokOpnameTool extends AbstractAccurateTestCase{
	
	static Logger log = LogManager.getLogger(PerintahStokOpnameTool.class);

	public static void isiForm (WebDriver driver,PerintahStokOpnameParam param)
	{
		log.info("PerintahStokOpname.IsiHeader");
		
		String w = AccurateModule.PERINTAH_STOK_OPNAME.getXpath();	
		
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if(param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if(param.tanggalspk != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggalspk);
		
	}
	
	
	public static void isidetail (WebDriver driver,PerintahStokOpnameParam param)
	{
		log.info("PerintahStokOpname.DetailPerintahStokOpname");

			String tab = "//div[starts-with(@id,'tab-otherheader')]";
			AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
			
			if (param.cabang != null)
				AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
			if (param.departemen != null)
				AccTool.lookupWithoutClear(driver, tab, "@name='department'", param.departemen);
			if (param.tanggal != null)
				AccTool.datePicker(driver, tab, "@name='startDate'", param.tanggal);
			if (param.penanggungjawab != null)
				AccTool.textField(driver, tab, "@name='personCharged'", param.penanggungjawab);
			if (param.dikerjakanoleh != null)
				AccTool.lookupWithoutClear(driver, tab, "@name='userList'", param.dikerjakanoleh);
			if (param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
			if (param.gudang != null)
				AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
			if (param.kategoribarang != null)
				AccTool.lookupWithoutClear(driver, tab, "@name='itemCategoryList'", param.kategoribarang);
			if (param.pemasok != null)
				AccTool.lookupWithoutClear(driver, tab, "@name='vendorList'", param.pemasok);		
	}
	
	
	public static void SaveIsiHeader(WebDriver driver,  String fileName)
	{
		log.info("Save Isi Header: " + fileName);

		String content = "PerintahStokOpname.SaveIsiHeader: " + "\r\n";
		String tab ="";

		content = content
				+ "Tanggal SPK : "
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.DATEPICKER, "transDate", tab)
				+ "Status : "
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.SUMMARY, "text: formData.statusName", tab)
				+ "No.SPK : "
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.TEXTFIELD, "number", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(fileName,  content);
	}
	
	
	public static void SaveIsiDetail(WebDriver driver,  String fileName)
	{
		log.info("Save Detail PSO : " + fileName);

		String content = "PerintahStokOpname.SaveDetailPSO : " + "\r\n";
		String tab ="";
		
		content = content
				+ "Cabang : " 
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.SUMMARY, "text: formData.branchName", tab)
				+ "Departemen : " 
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.LOOKUP, "department", tab)
				+ "Tanggal Mulai : " 
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.SUMMARY, "text: formData.startDate", tab)
				+ "Penanggung Jawab : " 
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.TEXTFIELD, "personCharged", tab)
				+ "Dikerjakan Oleh : " 
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.LOOKUP, "userList", tab)
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.TEXTAREA, "description", tab) 
				+ "Gudang : "
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.SUMMARY, "text: formData.warehouse().name", tab) 
				+ "Kategori Barang : "
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.LOOKUP, "itemCategoryList", tab)
				+ "Pemasok Barang : "
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.LOOKUP, "vendorList", tab) 
				+ "\r\n";
				
				AccTool.writeTextFile(fileName,  content);
	}

	
	public static void KlikButtonProsesOpname(WebDriver driver , AccurateModule module){

		AccTool.click(driver, AccurateModule.PERINTAH_STOK_OPNAME.getXpath() + "//button[@name = 'btnProcessAdjustment']");
		
	}
	

	public static void KlikButtonOkProsesOpname(WebDriver driver , AccurateModule module){

		String path = "//*[contains(@id,'confirm-dialog')]//*[@name ='btnOk']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void saveHasilHitung(WebDriver driver,  String fileName)
	{
		log.info("PerintahStokOpname.SaveHasilHitung");
		
		String tab = "";
		AccTool.click(driver, AccurateModule.PERINTAH_STOK_OPNAME.getXpath() + "//a[contains(@href, 'tab-item')]");
		String content = "PerintahStokOpname.SaveHasilHitung : " + "\r\n";
		tab = "//*[contains(@id,'tab-item')]";
		content = content 
				+ "Daftar Barang" 
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, tab) + "\r\n";
		AccTool.writeTextFile(fileName,  content);
	}
	public static void isiHeader (WebDriver driver,PerintahStokOpnameParam param)
	{
		log.info("PerintahStokOpname.IsiHeader");
		
		String w = AccurateModule.PERINTAH_STOK_OPNAME.getXpath();	
		
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if(param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		if(param.tanggalspk != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggalspk);
	
}
	public static void saveIsiHeaderNoManual(WebDriver driver,  String fileName)
	{
		log.info("Save Isi Header: " + fileName);

		String content = "PerintahStokOpname.SaveIsiHeader : " + "\r\n";
		String tab ="";

		content = content
				+ "Tanggal SPK : "
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.DATEPICKER, "transDate",
						tab)
				+ "No.SPK : "
				+ AccTool.getTextValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, ElementType.TEXTFIELD, "number", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(fileName,  content);
	}
	public static void saveList(WebDriver driver,  String fileName)
	{
		log.info("PerintahStokOpname.SaveList");

	String content = "PerintahStokOpname.SaveList : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-item')]";
	content = content 
			+ AccTool.getGridValue(driver, AccurateModule.PERINTAH_STOK_OPNAME,tab) + "\r\n";
	AccTool.writeTextFile(fileName,  content);

	}
	
	public static void klikTabItem(){

		AccTool.click(getWebDriver(), "//a[contains(@href,'#tab-item')]");
		
	}
	
	public static void klikTabInfoDetail(){

		AccTool.click(getWebDriver(), "//a[contains(@href,'#tab-otherheader')]");
		
	}
	
	public static void klikTabInfoHasilStokOpname(){

		AccTool.click(getWebDriver(), "//a[contains(@href,'#tab-summary')]");
		
	}
	
	public static void saveListInfoHSO(WebDriver driver,  String fileName)
	{
		log.info("PerintahStokOpname.SaveInfoHSO");
		
		String tab = "";
		AccTool.click(driver, AccurateModule.PERINTAH_STOK_OPNAME.getXpath() + "//a[contains(@href, 'tab-summary')]");
		String content = "PerintahStokOpname.SaveInfoHSO : " + "\r\n";
		tab = "//*[contains(@id,'tab-summary')]";
		content = content 
				+ "Daftar Hasil Stok Opname" 
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PERINTAH_STOK_OPNAME, tab) + "\r\n";
		AccTool.writeTextFile(fileName,  content);
	}
}
