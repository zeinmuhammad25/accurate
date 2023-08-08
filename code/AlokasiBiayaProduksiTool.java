package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.alokasibiayaproduksi.AlokasiBiayaProduksiParam;
import com.cpssoft.web.test.framework.tools.WaitTool;


public class AlokasiBiayaProduksiTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(AlokasiBiayaProduksiParam.class);
	
	public static void klikTabRincianBiaya(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-expense')]");
	}
		
	public static void klikTabRincianWO(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-work-order')]");
	}
	
	public static void klikTabInfoLain(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-costheader')]");
	}
	
	public static void klikAmbilBiaya(WebDriver driver) {

			AccTool.click(getWebDriver(), "//*[contains(@id,'tab-expense')]//*[@name='btnGetFrom']");
			AccTool.waitLoadingMask(getWebDriver());
		}
	
	public static void klikAmbilWO(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-work-order')]//*[@name='btnGetFrom']");
		AccTool.waitLoadingMask(getWebDriver());
	}
	
	 public static void klikPilihSemuaListBiaya(WebDriver driver) {
			
			String xpath = "//*[contains(@id,'accurate__fabrication__expense-cost-distribution')]//*[@class='input-control checkbox no-margin']";
			AccTool.click(getWebDriver(), xpath);
		}
	 
	 public static void klikPilihSemuaListWO(WebDriver driver) {
			
			String xpath = "//*[contains(@id,'accurate__fabrication__work-order-cost-distribution')]//*[@class='input-control checkbox no-margin']";
			AccTool.click(getWebDriver(), xpath);
		}
	
	public static void klikOKPopUpWarning(WebDriver driver) {
		
		String path = "//*[@name='btnOk']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	
	// konfirmasi tutup tab data saat ada data terisi
	public static void klikOKPadaWarningTutupTab(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'confirm-dialog')]//*[@name='btnOk']");
		WaitTool.delay(1000);
	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikLanjutDetailBiaya(WebDriver driver) {
		
		String path = "//*[contains(@id,'accurate__fabrication__expense-cost-distribution')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		AccTool.waitLoaderMedium(getWebDriver());
	}
	
    public static void klikHapusDetailBiaya(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-expense')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		AccTool.waitLoaderMedium(getWebDriver());
	}
	
	public static void klikLanjutDetailWO(WebDriver driver) {
		
		String path = "//*[contains(@id,'accurate__fabrication__work-order-cost-distribution')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		AccTool.waitLoaderMedium(getWebDriver());
	}
		
	public static void klikHapusDetailWO(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-work-order')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		AccTool.waitLoaderMedium(getWebDriver());
	}
	
	
	public static void klikLanjutBiaya(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-expense')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 30);
		
	}
						
	public static void isiHeader (WebDriver driver,AlokasiBiayaProduksiParam param){
		
		String tab = " ";
		  
		if (param.cabang != null)
			AccTool.combobox(getWebDriver(), tab, "@name='branch'", param.cabang);
		if (param.bulan != null)
			AccTool.combobox(getWebDriver(), tab, "@name='costMonth'", param.bulan);
		if (param.tahun != null)
			AccTool.combobox(getWebDriver(), tab, "@name='costYear'", param.tahun);
		if(param.no != null)
			AccTool.textField(driver, tab, "@name='number'", param.no);	
		if(param.penomoran != null)
			AccTool.lookup(driver, tab, "@name='workOrder'", param.penomoran);	
		if(param.tanggal != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.tanggal);	
	}	
					
	public static void isiDetailBiaya(WebDriver driver, AlokasiBiayaProduksiParam param) 
	{
		
		String tab = "//div[starts-with(@id,'detail-expense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		
		if (param.persentasealokasi != null)
			AccTool.numberField(driver, tab, "@name='allocationPercentage'", param.persentasealokasi);
		if (param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);
		if (param.proyek != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyek);
	
		
		String tab2 = "//div[starts-with(@id,'detail-expense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
		if(param.catatanbiaya != null)
			AccTool.textarea(driver, tab2, "@name='memo'", param.catatanbiaya);
	}
	
	public static void isiInfoLainnya(WebDriver driver, AlokasiBiayaProduksiParam param) {
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-costheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-costheader')]");
		
			if (param.catatan != null)
				AccTool.textarea(driver, tab, "@name='description'", param.catatan);
	}
	
	public static void saveIsiPopup(WebDriver driver, String fileName) {
		
		String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
		String content = "Alokasi Biaya Produksi" + "\r\n";
		content = content
				+ "Notifikasi :"
				+ "\r\n"
				+ AccTool.getTextValue(driver, 
						ElementType.REPORT, " ", tab)+ "\r\n";
			
		AccTool.writeTextFile(fileName, content);
	}
		
	public static void saveIsiHeader(WebDriver driver, String fileName) {

		String tab = "";
		String content = "AlokasiBiayaProduksi.SaveHeader : " + "\r\n";
		content = content

				+ "\r\n" 
				+ "Nomor Alokasi Biaya Produksi  : "
				+ AccTool.getTextValue(driver, AccurateModule.ALOKASI_BIAYA_PRODUKSI, ElementType.TEXTFIELD, "number", tab)
				+ "Cabang : "
				+ AccTool.getTextValue(driver, AccurateModule.ALOKASI_BIAYA_PRODUKSI, ElementType.SPAN, "text: costBranchName", tab)
				+ "Bulan  : "
				+ AccTool.getTextValue(driver, AccurateModule.ALOKASI_BIAYA_PRODUKSI, ElementType.SPAN, "text: formData.periodMonthName", tab)
				+ "Tanggal  : "
				+ AccTool.getTextValue(driver, AccurateModule.ALOKASI_BIAYA_PRODUKSI, ElementType.TEXTFIELD, "transDate", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(fileName, content);
	}
	
	 public static void saveListRincianBiaya(WebDriver driver, String filename) {
			log.info("AlokasiBiayaProduksi.SaveListRincianBiaya");

			String grid = "";
			String content = "AlokasiBiayaProduksi.SaveListRincianBiaya : " + "\r\n";
			grid = "//div[contains(@id, 'tab-expense')]";
			content = content
					+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
			AccTool.writeTextFile(filename, content);
		}
	
	 public static void saveListRincianWO(WebDriver driver, String filename) {
			log.info("AlokasiBiayaProduksi.SaveListRincianWO");

			String grid = "";
			String content = "AlokasiBiayaProduksi.SaveListRincianWO : " + "\r\n";
			grid = "//div[contains(@id, 'detail-work-order-grid-list')]";
			content = content
					+ AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";
			AccTool.writeTextFile(filename, content);
		}
	 
	public static void saveDetailBiaya(WebDriver driver, String filename)
	{
		log.info("SaveDetailBiaya");
		
		String tab ="";
		String content = "AlokasiBiayaProduksi.saveDetailBiaya : " + "\r\n";
		tab = "//div[starts-with(@id,'detail-expense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
			content = content
					+ "\r\n"
					+ "Nama beban : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: formData.account().name", tab)
					+ "Nilai : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.expenseAmount()",tab)
					+ "% Alokasi : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "allocationPercentage", tab)
					+ "Alokasi : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.allocationAmount()",tab)
					+ "Departemen : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab)
					+ "Proyek : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab)
					+ "\r\n";
			
			//Catatan Biaya
			String tab2 = "//div[starts-with(@id,'detail-expense')]";
			String content2 = "AlokasiBiayaProduksi.SaveCatatanBiaya : " + "\r\n";
			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			content2 = content2
					+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "memo", tab2)
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailWO(WebDriver driver, String filename)
	{
		log.info("SaveDetailWO");
		
		String tab ="";
		String content = "AlokasiBiayaProduksi.saveDetailWO : " + "\r\n";
		tab = "//div[starts-with(@id,'detail-work-order')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detail-work-order')]");
			content = content
					+ "\r\n"
					+ "No SPK : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.workOrder().number",tab)
					+ "Nilai Biaya : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber($data.allocationAmount)",tab)
					+ "Alokasi : "
					+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: app.util.parseNumber(formData.allocationAmount())",tab)
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiInfoLain(WebDriver driver, String filename)
	{
		log.info("AlokasiBiayaProduksi.SaveIsiInfoLain");
		
		String tab = "";
		String content = "AlokasiBiayaProduksi.SaveIsiInfoLain : " + "\r\n";
		tab ="//*[contains(@id,'tab-otherheader')]";				
				content = content 
				+ "Catatan : " 
				+ AccTool.getTextValue(driver, AccurateModule.ALOKASI_BIAYA_PRODUKSI, ElementType.TEXTAREA, "description",tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
		
	
}
