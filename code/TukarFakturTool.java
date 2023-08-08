package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.tukarfaktur.TukarFakturParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;


public class TukarFakturTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger( TukarFakturTool.class);

    public static void isiHeader(WebDriver driver, TukarFakturParam param){
	log.info("TukarFaktur.IsiHeader");
	
	String w = AccurateModule.TUKAR_FAKTUR.getXpath();
	
	if(param.matauang != null) {
		AccTool.combobox(driver, w, "@name='currency'", param.matauang);
		AccTool.waitProgressBar(driver);
	}
	if(param.tgltukar != null) {
		AccTool.datePicker(driver, w, "@name='collectDate'", param.tgltukar);
		AccTool.waitProgressBar(driver);
	}
	if(param.nomorotomatis != null){
		AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.nomorotomatis);
	}
    if(param.nomormanual != null){
	AccTool.textField(driver, w, "@name='number'", param.nomormanual);
    }
 }
    public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("TukarFaktur.SaveIsiHeader");

		String tab = "";
		String content = "TukarFaktur.SaveHeader : " + "\r\n";
		content = content 
		        + "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR,"//div[contains(@data-bind,'currency')]")
				+ "Tgl Tukar : "
				+ AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR, ElementType.DATEPICKER, "collectDate",tab)
				+ "Nomor : "
				+ AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR, ElementType.TEXTFIELD, "number",tab)
				+ "Tgl Dokumen : "
				+ AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR, ElementType.SUMMARY, "text: formData.transDate", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
   
    public static void klikButtonAmbil(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-invoice')]//*[@name='btnGetFromOutstanding']");
        AccTool.waitLoadingMask(getWebDriver());
	}
    
    public static void klikButtonLanjut(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__customer__outstanding-invoice-for-exchange-invoice')]//*[@name='btnNext']");
        AccTool.waitProgressBar(getWebDriver());
	}
    
    public static void klikButtonHapus(WebDriver driver) {

  		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-invoice')]//*[@name='btnDelete']");
          AccTool.waitProgressBar(getWebDriver());
  	}
    
    public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver, AccurateModule.TUKAR_FAKTUR.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}
    
    public static void isiInfoLain(WebDriver driver, TukarFakturParam param) {
		log.info("TukarFaktur.IsiInfoLain");

		String w = AccurateModule.TUKAR_FAKTUR.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");

		if (param.batal != null)
			AccTool.checkbox(driver, tab, "@name='cancelCollection'", param.batal);
		if (param.keterangan != null)
			AccTool.textarea(driver, "", "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
	}
    
    public static void saveDaftarFakturBelumLunas(WebDriver driver, String filename) {
		log.info("TukarFaktur.SaveDaftarFakturBelumLunas");

		String grid = "";
		String content = "TukarFaktur.SaveDaftarFakturBelumLunas : " + "\r\n";
		grid = "//div[contains(@id, 'accurate__customer__outstanding-invoice-for-exchange-invoice')]";
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
    
    public static void saveIsiRincianFaktur(WebDriver driver, String filename) {
		log.info("TukarFaktur.SaveIsiRincianFaktur");

		String tab = "";
		String content = "TukarFaktur.SaveRincianFaktur : " + "\r\n";
		tab = "//*[contains(@id,'tab-invoice')]";
		content = content 
				+ "Detail Faktur" 
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.TUKAR_FAKTUR, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
    
    public static void saveInfolain(WebDriver driver, String filename) {
		String content = "TukarFaktur.SaveInfoLain : " + "\r\n";
//		AccTool.click(driver, AccurateModule.TUKAR_FAKTUR.getXpath() + "//*[contains(@class,'acc-icon-other-info')]");
		//ui baru
		AccTool.click(driver, AccurateModule.TUKAR_FAKTUR.getXpath() + "//*[contains(@class,'icn-transaction-header')]");
		String tab = "//*[contains(@id,'tab-otherheader')]";
		content = content 
				+ "Keterangan	: " 
				+ AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR, ElementType.TEXTAREA, "description", tab)
		        + "Batal : "
		        + AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR, ElementType.CHECKBOX, "cancelCollection");
				  
		        String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				
		        if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
		content = content 
				+ "Cabang : "
		        + AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR, ElementType.COMBOBOX, "branch", tab);
		        } else {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR, ElementType.SUMMARY, "branchListOption", tab);
		        }
		        content = content + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
    
    public static void klikTabInformasiTukarFaktur(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.TUKAR_FAKTUR.getXpath() +
				"//a[contains(@href, '#tab-summary')]");
	}
    
    public static void saveInformasiTukarFaktur(WebDriver driver, String filename){
		log.info("Save Informasi Tukar Faktur");
		String content = "TukarFaktur.saveInformasiTukarFaktur : " + "\r\n";
		content = content
				+ "Status : "
				+ AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR, "//span[contains(@data-bind,'text: formData.statusName()')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);		
	}
    
    public static void saveFooter(WebDriver driver, String filename) {
		log.info("Save Footer");
		WaitTool.delay(1000);
		String content = "TukarFaktur.SaveFooter ; " + "\r\n";
		String tab = "//div[text()='Total Faktur']/following-sibling::div";

		content = content 
				+ "Total Faktur : "
				+ ""
				+ AccTool.getTextValue(driver, AccurateModule.TUKAR_FAKTUR, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
    
    public static void klikKomentar(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, module.getXpath() + "//i[@id='btnCommentAttachment']");
		AccTool.click(driver, module.getXpath() + "//*[text()='Komentar']");
	}
    
    public static void isiKomentar(WebDriver driver,TukarFakturParam param)
	{
		log.info("TukarFaktur.IsiKomentar");
		String a ="//*[contains(@id,'accurate__company__comment')]";

		if (param.komentar != null)				
	    AccTool.textarea(driver, a, "@name='comment'", param.komentar);	
	}
    
    public static void klikTutupKomentar(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//div[text()='Komentar transaksi']/preceding-sibling::*");
        WaitTool.waitForElementDisapear(driver, By.xpath("//div[text()='Komentar transaksi']/preceding-sibling::*"), 6);
	}

	public static void klikSaveKomentar(WebDriver driver) 
	{
		String path = "//*[contains(@id,'accurate__company__comment')]" + "//button[@name='btnSave']";
		AccTool.click(driver, path);
	}
}

