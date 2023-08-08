package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;

import com.cpssoft.web.test.accurate.hasilstokopname.HasilStokOpnameParam;
import com.cpssoft.web.test.framework.tools.WaitTool;


public class HasilStokOpnameTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(HasilStokOpnameParam.class);
	static String w = AccurateModule.HASIL_STOK_OPNAME.getXpath();
	
	public static void isiForm(WebDriver driver,HasilStokOpnameParam param)
	{
		log.info("HasilStokOpname.isi");
	
		if(param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", 
		param.tanggal);
		if(param.penomoran != null)
			AccTool.checkbox(driver, w, "@name='typeAutoNumber'", 
		param.penomoran);
		if(param.no != null)
			AccTool.textField(driver, w, "@name='number'", 
		param.no);
		if(param.perintah !=null)
			AccTool.lookup(driver, w, "@name='order'", param.perintah);
		
	}
	
	public static void IsiDetailBarang(WebDriver driver, HasilStokOpnameParam param)
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
	
	public static void detailBarang(WebDriver driver,HasilStokOpnameParam param)
	{
		log.info("HasilStokOpname.detailBarang");
		
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
	
		if(param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		if(param.satuan != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);
		
	}
		
	public static void infoLain (WebDriver driver,HasilStokOpnameParam param)
	{
		log.info("HasilStokOpname.infoLain");
		
		String tab = "//div[starts-with(@id,'tab-otherheader')]";
		AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
		
		if(param.keterangan !=null)
			AccTool.textarea(driver, tab, "@name='description'",param.keterangan);
	
	}
	
	public static void saveHeader(WebDriver driver,  String fileName)
	{
		log.info("Save Isi: " + fileName);

		String content = "Hasil StockOpname.SaveHeader : " + "\r\n";
		String tab ="";

		content = content
				+ "Tanggal Opname : " 
				+ AccTool.getTextValue(driver, AccurateModule.HASIL_STOK_OPNAME, ElementType.DATEPICKER, "transDate", tab)
				+ "Perintah Opname : " 
				+ AccTool.getTextValue(driver, AccurateModule.HASIL_STOK_OPNAME, ElementType.LOOKUP, "order", tab)
				+ "No. Opname : "
				+ AccTool.getTextValue(driver, AccurateModule.HASIL_STOK_OPNAME, ElementType.TEXTFIELD, "number", tab) + "\r\n";
				AccTool.writeTextFile(fileName,  content);
	}
	
	public static void saveDetail(WebDriver driver,  String fileName)
	{
		log.info("Save Detail: " + fileName);

		String content = "Hasil Stok Opname.SaveDetail : " + "\r\n";
		String tab ="";

		content = content
				+ "Kuantitas : " 
				+ AccTool.getTextValue(driver, AccurateModule.HASIL_STOK_OPNAME, ElementType.NUMBERFIELD, "quantity", tab)
				+ "Satuan : " 
				+ AccTool.getTextValue(driver, AccurateModule.HASIL_STOK_OPNAME, ElementType.LOOKUP, "itemUnit", tab)+ "\r\n";
				AccTool.writeTextFile(fileName,  content);
	}

	public static void saveList(WebDriver driver,  String fileName)
	{
		log.info("HasilStokOpname.SaveList");

	String content = "HasilStokOpname.SaveList : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-item')]";
	content = content 
			+ AccTool.getGridValue(driver, AccurateModule.HASIL_STOK_OPNAME,
					tab) + "\r\n";
	AccTool.writeTextFile(fileName,  content);
   
	}
	
	public static void detailBarangIsi(WebDriver driver,HasilStokOpnameParam param)
	{
		log.info("HasilStokOpname.detailBarang");
		
		String tab = "//div[starts-with(@id,'detail-item')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
	
		if(param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		if(param.satuan != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);
		
	}
	
	public static void klikLanjutTabDetailBarang(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item')]//*[@name ='btnNext']");
		WaitTool.waitForElementDisapear(getWebDriver(), By.xpath("//*[contains(@id,'detail-item')]//*[@name ='btnNext']"), 6);
        AccTool.waitLoaderMedium(getWebDriver());
	}
	
	public static void klikHapusTabDetailBarang() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item')]//*[@name ='btnDelete']");
		AccTool.waitLoaderMedium(getWebDriver());
	}
	
	public static void klikTabInfoLainnya(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.HASIL_STOK_OPNAME.getXpath() +
				"//a[contains(@href, '#tab-otherheader')]");
	}
	
	public static void isiKeterangan(WebDriver driver,HasilStokOpnameParam param)
	{
		log.info("HasilStokOpname.isi");
	
		if(param.keterangan != null)
			AccTool.textarea(driver, w, "@name='description'",param.keterangan); 
	}
	
	public static void simpanKeterangan(WebDriver driver,  String fileName)
	{
		log.info("Simpan Keterangan: " + fileName);

		String content = "HasilStockOpname.SaveKeterangan : " + "\r\n";
		String tab ="";

		content = content
				+ "Keterangan : " 
				+ AccTool.getTextValue(driver, AccurateModule.HASIL_STOK_OPNAME, ElementType.TEXTAREA, "description", tab) + "\r\n";
				AccTool.writeTextFile(fileName,  content);
	}
	
	public static void detailNoSeri(WebDriver driver, HasilStokOpnameParam param) {
		log.info("HasilStokOpname.DetailNOSERI");
		
		String tab =  "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
		if (param.noseri != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.noseri);
		
	}
	
	public static void saveisiSerialNumber(WebDriver driver, String filename) {
		log.info("HasilStokOpnameSerialNumber.SaveList");

		String content = "SerialNumberBarangStokOpname : " + "\r\n";
		String tab = "//*[contains(@id,'tab-serial-number')]";
		content = content 
				+ "\r\n" 
				+ "Detail : " 
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.HASIL_STOK_OPNAME, tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);

	}
	
	public static void klikTabNoSeri(WebDriver driver) {
		log.info("HasilStokOpname.DetailNOSERI");
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
	}
	
	public static void klikLanjutItemSN(WebDriver driver) {
//		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
//		AccTool.click(driver, xpath);
//		WaitTool.delay(500);
		
		//fungsinya sama persis dengan di FakturPenjualan
		FakturPenjualanTool.klikLanjutItemSN(getWebDriver());
	}
}
