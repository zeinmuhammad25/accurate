package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pengambilanbahanbaku.PengambilanBahanBakuParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PengambilanBahanBakuTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(PengambilanBahanBakuParam.class);
	
	public static void klikAmbilTahapan(WebDriver driver, PengambilanBahanBakuParam param) {
		String w = AccurateModule.PENGAMBILAN_BAHAN_BAKU.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
		
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENGAMBILAN_BAHAN_BAKU.getXpath()
				+
				"//div[contains(@class, 'span1')]/div[1]"),5);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Bahan Tahapan']");
		
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath ("//div[contains(@id,'copy-process-stages')]//input[@name='lookup']"),3);
		if (param.caritahapan != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-process-stages')]", "@name='lookup'", param.caritahapan);
	}
	
	public static void klikLanjutTahapan(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-process-stages')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);

	}
	
	public static void klikTabRincianBarang(WebDriver driver){
		AccTool.click(driver, "//*[contains(@class,'tab-item')]");
	}
		
	public static void klikTabInfoLain(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
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
	
	public static void klikLanjutDetailBarang(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		AccTool.waitProgressBar(getWebDriver());
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	
	//tanpa disappear
	public static void klikLanjutBarang(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		AccTool.waitProgressBar(getWebDriver());
	}
		
	public static void klikHapusDetailBarang(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
				
	public static void klikTabSerialNumberBarang(WebDriver driver)
	{

		AccTool.click(driver, "//a[contains(@href, '#tab-serial-number')]");
	}
	
	
	public static void klikHapusGudang(WebDriver driver) {
		AccTool.clearLookup(getWebDriver(),"", "@name='warehouse'");
	}
	
	public static void klikButtonLanjutTabDetailSerialNumber(WebDriver driver) {
		WaitTool.delay(100);
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.delay(200);
	}
	
	public static void isiHeader (WebDriver driver,PengambilanBahanBakuParam param){
		
		String tab = " ";
		  
		if (param.ambil != null)
			AccTool.radioButton(driver, tab, "@value='ITEM_PICK'", param.ambil);
		if (param.retur != null)
			AccTool.radioButton(driver, tab, "@value='ITEM_RETURN'", param.retur);
		if(param.no != null)
			AccTool.textField(driver, tab, "@name='number'", param.no);	
		if(param.perintahkerja != null)
			AccTool.lookup(driver, tab, "@name='workOrder'", param.perintahkerja);	
		if(param.tanggal != null)
			AccTool.datePicker(driver, tab, "@name='transDate'", param.tanggal);	
	}	
		
	public static void isiDetailBarang (WebDriver driver, PengambilanBahanBakuParam param) {
		
		String tab = "//div[starts-with(@id,'tab-item')]";
		AccTool.click(driver, "//*[contains(@href,'tab-item')]");

		if (param.searchbarang != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchbarang);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}
			
	public static void detailBarang(WebDriver driver, PengambilanBahanBakuParam param) {
		
		String tab = "//div[starts-with(@id,'detail-item')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		
		if (param.namabarang != null)
			AccTool.textField(driver, tab, "@name='detailName'", param.namabarang);
		if (param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		if (param.gudang != null)
			AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
		if (param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);
		if (param.proyek != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyek);
	
		
		String tab2 = "//div[starts-with(@id,'detail-item')]";
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
		if(param.keterangandetail != null)
			AccTool.textarea(driver, tab2, "@name='detailNotes'", param.keterangandetail);
	}
	
	
	public static void isiNoSeri(WebDriver driver, PengambilanBahanBakuParam param) {
		
		String tab = "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");

		if (param.kuantitasnoseri != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.kuantitasnoseri);
		if (param.noseri != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.noseri);
	}
	
	public static void isiInfoLainnya(WebDriver driver, PengambilanBahanBakuParam param) {
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		
			if (param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
	}
	
	public static void saveIsiPopup(WebDriver driver, String fileName) {
		
		String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
		String content = "Pengambilan Bahan Baku.Warning : " + "\r\n";
		content = content
				+ "Notifikasi"
				+ "\r\n"
				+ AccTool.getTextValue(driver, 
						ElementType.REPORT, " ", tab)+ "\r\n";
			
		AccTool.writeTextFile(fileName, content);
	}
		
	public static void saveIsiHeader(WebDriver driver, String fileName) {

		String tab = "";
		String content = "PengambilanBahanBaku.SaveHeader : " + "\r\n";
		content = content

				+ "\r\n" 
				+ "Tipe  : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, ElementType.SUMMARY, "text: formData.materialSlipTypeName")
				+ "No batch#  : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, ElementType.TEXTFIELD, "number", tab)
				+ "Perintah kerja  : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, ElementType.SUMMARY, "text: formData.workOrder().number", tab)
				+ "Tanggal  : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, ElementType.TEXTFIELD, "transDate", tab)
				+ "Produk  : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, ElementType.SUMMARY, "text: formData.detailName", tab)
				+ "Kuatitas  : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, ElementType.SUMMARY, "text: formData.itemInUnit", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(fileName, content);
	}
	
	public static void SaveListDetail(WebDriver driver, String fileName) {

		AccTool.click(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU.getXpath() + "//*[contains(@href,'tab-item')]");
		String tab = "//*[contains(@id,'tab-item')]";
		String content = "PengambilanBahanBaku.SaveListBahanBaku : " + "\r\n";
		content = content 
			
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, tab)
				+ "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
	
	public static void saveDetailBarang(WebDriver driver, String filename)
	{
		log.info("SaveDetailBarang");
		
		String tab ="";
		String content = "PengambilanBahanBaku.saveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'detail-item')]";
		AccTool.click(driver, "//a[contains(@href,'detailitem')]");
			content = content
					+ "\r\n"
					+ "Nama barang : "
					+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: formData.itemUnit().name", tab)
					+ "Gudang : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
					+ "Departemen : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab)
					+ "Proyek : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab)
					+ "\r\n";
			
			//keterangan
			String tab2 = "//div[starts-with(@id,'detail-item')]";
			String content2 = "PengambilanBahanBaku.SaveKeteranganDetailBarang : " + "\r\n";
			AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
			content2 = content2
					+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab2)
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiInfoLain(WebDriver driver, String filename)
	{
		log.info("PengambilanBahanBaku.SaveIsiInfoLain");
		
		String tab = "";
		String content = "PengambilanBahanBaku.SaveIsiInfoLain : " + "\r\n";
		tab ="//*[contains(@id,'tab-otherheader')]";
//		content = content
				//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Berlaku di cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Berlaku di cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, ElementType.SUMMARY, "branchListOption", tab);
				}
				
				content = content + "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.PENGAMBILAN_BAHAN_BAKU, ElementType.TEXTAREA, "description")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
		
	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("PengambilanBahanBaku. SaveIsiDetailSerialNumber");

		
		String grid = "";
		String content = "Nomor Seri Barang : " + "\r\n";

		
		grid = "//div[contains(@id,'detail-item')]";
		content = content
				+ "\r\n" 
				+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
}
