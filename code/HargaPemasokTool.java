package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.hargapemasok.HargaPemasokParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class HargaPemasokTool extends AbstractAccurateTestCase  {
	static Logger log = LogManager.getLogger(HargaPemasokParam.class);


	public static void klikButtonLanjutDetailBarang(WebDriver driver) {
		String path = "//div[starts-with(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikButtonDeleteDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikAmbilBarang(WebDriver driver, HargaPemasokParam param)
	{
//		AccTool.dropDown(driver, AccurateModule.HARGA_PEMASOK.getXpath(), 
//				"//div[@class='span4']", "Daftar Barang & Jasa");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id,'accurate__inventory__item-for-vendor-price')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.HARGA_PEMASOK.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name='btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.HARGA_PEMASOK.getXpath()
			+ "//ul[contains(@class,'dropdown-menu')] //a[.='Daftar Barang & Jasa']"), 3);
		AccTool.click(getWebDriver(), w + "//a[.='Daftar Barang & Jasa']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
			By.xpath("//div[contains(@id,'accurate__inventory__item-for-vendor-price')]//input[@name='itemCategory']"), 3);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id,'accurate__inventory__item-for-vendor-price')]", "@name='itemCategory'", param.search);
	}
	
	public static void klikLanjutAmbilBarang(WebDriver driver)
	{

		String path = "//*[contains(@id,'accurate__inventory__item-for-vendor-price')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	

	
	public static void isiForm (WebDriver driver,HargaPemasokParam param)
	{
		String w = AccurateModule.HARGA_PEMASOK.getXpath();
		//String tab = w + "//*[contains(@id,'tab-general')]";
		
		AccTool.lookup(driver, w, "@name='vendor'", param.pemasok);
		
		if(param.mulaiberlaku != null)
			AccTool.datePicker(driver,w, "@name='transDate'", 
		param.mulaiberlaku);
		
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", 
		param.penomoran);
		
		if(param.no != null)
			AccTool.textField(driver,w, "@name='number'", 
		param.no);
		
		if(param.matauang != null)
			AccTool.lookup(driver, w, "@name='currency'", 
		param.matauang);
		
				
	}
	
	
	public static void isiDetail (WebDriver driver,HargaPemasokParam param)
	{
		log.info("HargaPemasok.IsiDetail");
		
		
		String tab =  "//div[starts-with(@id,'tab-item')]";
		AccTool.click(driver, "//*[contains(@href,'tab-item')]");
		
		AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
		AccTool.scrollRowDetail(driver, tab, param.scroll);				
				
	}
	
	public static void detailBarang (WebDriver driver,HargaPemasokParam param)
	{
		log.info("HargaPemasok.DetailBarang");
		
		String tab= "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);
			AccTool.numberField(driver,tab, "@name='price'", param.hargabaru);
	
		}
	
	public static void isiInfoLain (WebDriver driver,HargaPemasokParam param)
	{
		
		String w = AccurateModule.HARGA_PEMASOK.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, AccurateModule.HARGA_PEMASOK.getXpath() + "//*[contains(@href,'tab-otherheader')]");
		
		AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
				
				
	}
	
	public static void isiKategori (WebDriver driver,HargaPemasokParam param)
	{

		String tab =  "//*[contains(@id,'accurate__inventory__item-for-vendor-price')]";		
		
		if (param.kategori != null)
			AccTool.lookup(driver, tab, "@name='itemCategory'", param.kategori);
	}

	
	public static void saveHeader (WebDriver driver,String filename)
	{
		log.info("HargaPemasok.SaveIsiHeader");

		String tab = "";
		String content = "HargaPemasok.SaveHeader : " + "\r\n";
		
			content = content
					+ "\r\n"
					+ "Pemasok : "
					+ AccTool.getTextValue(driver, AccurateModule.HARGA_PEMASOK,
							ElementType.LOOKUP, "vendor", tab)
					+ "Mulai Berlaku : "
					+ AccTool.getTextValue(driver, AccurateModule.HARGA_PEMASOK,
							ElementType.DATEPICKER, "transDate", tab)
					+ "Penomoran : "
					+ AccTool.getTextValue(driver, AccurateModule.HARGA_PEMASOK,
							ElementType.TEXTFIELD, "number", tab)
					+ "Mata Uang : "
					+ AccTool.getTextValue(driver, AccurateModule.HARGA_PEMASOK, 
							ElementType.LOOKUP, "currency", tab)
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
		}
	
	public static void saveDetail (WebDriver driver,String filename)
	{
		log.info("HargaPemasok.SaveDetail");
		
		String tab =  "//*[contains(@id,'tab-item')]";
		String content = "HargaPemasok.SaveDetail : " + "\r\n";

		content = content
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.HARGA_PEMASOK, tab)+ "\r\n";

		AccTool.writeTextFile(filename, content);
		
	}
	
	public static void saveInfoLain (WebDriver driver,String filename)
	{
		log.info("HargaPemasok.SaveInfoLain");
		
		String tab =  "//*[contains(@id,'tab-otherheader')]";
		String content = "HargaPemasok.SaveInfolain: " + "\r\n";
		content = content
				+ "\r\n"
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.HARGA_PEMASOK,
						ElementType.TEXTAREA, "description", tab)+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiPopup(WebDriver driver, String fileName)
	{
		log.info("Save isi popup ");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	String content = "HargaPemasok.Warning : " + "\r\n";
	content = content
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
	AccTool.writeTextFile(fileName, content);
}
}

