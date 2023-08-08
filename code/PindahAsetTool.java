package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pindahaset.PindahAsetParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PindahAsetTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(PindahAsetTool.class);
	public static void detailAset(WebDriver driver, PindahAsetParam param) {
		log.info("pindahaset.DetailAset");
		String tab = "";
		
		if (param.tab != null)
			switch ((param.tab).toLowerCase()) {
			case "detailaset":
				tab = "//*[contains(@id,'tab-detailasset')]";
				AccTool.click(driver, "//a[contains(@href,'tab-detailasset')]");
				AccTool.numberField(driver, tab, "@name='quantity'",param.kuantitas);
				break;
			
			case "keterangan":
				tab = "//div[starts-with(@id,'tab-notes')]";
				AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
				AccTool.textarea(driver, tab, "@name='detailNotes'", param.note);
				break;
			}
	}

	public static void klikNext(WebDriver driver) {
		String w = "//div[@class='window shadow']//div[starts-with(@id,'detail-asset')]";
		String B = w + "//button[@name='btnNext']";
		AccTool.click(driver, B);
	}
	
	public static void isi(WebDriver driver, PindahAsetParam param) {
		log.info("pindahaset.Isi");
		
		String w = AccurateModule.PINDAH_ASET.getXpath();			
		AccTool.click(driver, "//a[text()='Pindah Aset']");
		
		if(param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", 
		param.tanggal);
		
		if(param.alamatasal != null)
			AccTool.lookup(driver, w, "@name='fromLocation'", 
		param.alamatasal);
		
		if(param.alamattujuan != null)
			AccTool.lookup(driver, w, "@name='toLocation'", 
		param.alamattujuan);
		
		if(param.no != null)
			AccTool.textField(driver, w, "@name='number'", 
		param.no);
		
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", 
		param.penomoran);
	}
	
	public static void isiDetailAset(WebDriver driver, PindahAsetParam param) {
		log.info("pindahaset.IsiDetailAset");
		
		String tab =  "";
		AccTool.click(driver, "//*[contains(@href,'tab-asset')]");
		
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAsset'", 
		param.search);
			AccTool.waitLoadingMask(driver);		
	}
	
	public static void isiInfoLain(WebDriver driver, PindahAsetParam param) {
		log.info("pindahaset.IsiInfoLain");
		String w = AccurateModule.PINDAH_ASET.getXpath();	
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
		AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
	}
	
	public static void saveDetail(WebDriver driver, String filename) {
		log.info("pindahaset.SaveDetail");
		String content = "PindahAset.SaveDetail : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailasset')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailasset')]");
		content = content
				+ "Deskripsi Aset	: "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY,
						"text: formData.asset().description", tab)
				+ "Kuantitas	: "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD,
						"quantity", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("pindahaset.SaveIsi");
		String tab = "";
		String content = "PindahAset.SaveHeader : " + "\r\n";	
			content = content
					+ "Tanggal	: "
					+ AccTool.getTextValue(driver, AccurateModule.PINDAH_ASET, ElementType.DATEPICKER,
							"transDate", tab)
					+ "Alamat Asal	: "
					+ AccTool.getTextValue(driver, AccurateModule.PINDAH_ASET, ElementType.LOOKUP,
							"fromLocation", tab)
					+ "Alamat Tujuan	: "
					+ AccTool.getTextValue(driver, AccurateModule.PINDAH_ASET, ElementType.LOOKUP,
							"toLocation", tab)
					+ "No Pemindahan	: "
					+ AccTool.getTextValue(driver, AccurateModule.PINDAH_ASET, ElementType.TEXTFIELD,
							"number", tab)
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiDetailAset(WebDriver driver, String filename) {
		log.info("pindahaset.SaveIsi");
		
		String tab = "";
		String content = "PindahAset.SaveListDetailAset : " + "\r\n";

			tab =  "//*[contains(@id,'tab-asset')]";
			AccTool.click(driver, "//a[contains(@href,'tab-asset')]");
			content = content + "Detail Aset" + "\r\n"
					+ AccTool.getGridValue(driver, AccurateModule.PINDAH_ASET, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiInfoLainnya(WebDriver driver, String filename) {
		log.info("pindahaset.SaveIsi");
		
		String tab = "";
		String content = "PindahAset.SaveInfoLain : " + "\r\n";
			tab = "//*[contains(@id,'tab-otherheader')]";
			AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
			content = content
					+ "Keterangan	: "
					+ AccTool.getTextValue(driver, AccurateModule.PINDAH_ASET, ElementType.TEXTAREA,
							"description", tab)
					+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListAset(WebDriver driver, String filename){
		String content = "pindahaset.SaveListAset :" + "\n";
		content = content		
				+ "Aset Per Lokasi : "
				+ AccTool.getGridValue(driver, AccurateModule.PINDAH_ASET,"//*[contains(@class,'tab-asset')]");
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiPopup(WebDriver driver, String fileName)
	{
		log.info("pindahaset.SaveIsiPopUp :");
		
		String tab =  "//*[contains(@id,'error-dialog')]";
		String content = "BarangJasa.Warning : " + "\r\n";
		content = content
				+ "Notifikasi"
				+ "\r\n"
				+ AccTool.getTextValue(driver, 
						ElementType.REPORT, " ", tab)+ "\r\n";
			
		AccTool.writeTextFile(fileName, content);
	}
	
	public static void klikHapusAlamatAsal(WebDriver driver, String keyword) {
		AccTool.clearLookup2(getWebDriver(), "@name='fromLocation'", keyword);
	}
	
	public static void klikHapusAlamatTujuan(WebDriver driver, String keyword) {
		AccTool.clearLookup2(getWebDriver(), "@name='toLocation'", keyword);
	}
	
	public static void klikTutupPopupDetailAset(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void saveKeteranganDetailAset(WebDriver driver, String filename) {
		log.info("PindahAset.SaveKeteranganDetailAset");

		String tab = "//div[starts-with(@id,'tab-notes')]";
		String content = "PindahAset.SaveKeteranganDetailAset : " + "\r\n";
		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		content = content + "Keterangan : " 
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void klikHapusAset(WebDriver driver){
		AccTool.click(getWebDriver(), "//button[@name='btnDelete']");
		WaitTool.delay(500);
	}
}
