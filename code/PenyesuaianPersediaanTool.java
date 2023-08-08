package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penyesuaianpersediaan.PenyesuaianPersediaanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PenyesuaianPersediaanTool extends AbstractAccurateTestCase {
	static String w = AccurateModule.PENYESUAIAN_PERSEDIAAN.getXpath();

	static Logger log = LogManager.getLogger(PenyesuaianPersediaanTool.class);

	public static void klikButtonLanjutTabDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}

	
	public static void klikButtonLanjutTabDetailSerialNumber(WebDriver driver) {
		WaitTool.delay(100);
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
	}
	
	public static void klikButtonLanjutAmbilPindahBarang(WebDriver driver) {
		String path = "//*[contains(@id,'copy-item-transfer')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikAmbilPindahBarang(WebDriver driver, PenyesuaianPersediaanParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN.getXpath(),
				"//div[contains(@class, 'span12')]/div[1]", "Pemindahan Barang");
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-item-transfer')]", "@name='lookup'", param.search);
	}
	

	public static void klikAmbilFavorit(WebDriver driver, PenyesuaianPersediaanParam param) {
		AccTool.dropDown(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN.getXpath(),
				"//div[contains(@class, 'offset4 span8')]/div[1]", "Favorit");
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-memorize-transaction')]", "@name='lookup'", param.search);
	}
	
	
   public static void klikLanjutSalinFavorit() {
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'copy-memorize-transaction')]");
		WaitTool.waitForElementDisapear(getWebDriver(), By.xpath("//div[contains(@id,'copy-memorize-transaction')]"), 1);
	
	}
   
	public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}
	
	public static void klikTabSerialNumberBarang(WebDriver driver)
	{
		AccTool.click(driver, "//a[contains(@href, '#tab-serial-number')]");
	}
	
	public static void klikButtonDeleteDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTampilkanDetailData() {
		AccTool.click(getWebDriver(), "//*[contains(@id,'module-grid-list')]//*[@class='grid-canvas']/div[1]");

	}

	public static void klikiconcari() {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'module-accurate__inventory__item-adjustment')]//*[@name ='keyword']");

	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void carilist(WebDriver driver, PenyesuaianPersediaanParam param) {
		log.info("PenyesuaianPersediaan.carilist");

		String a = "//*[contains(@id,'module-accurate__inventory__item-adjustment')]";

		if (param.cari != null)
			AccTool.textField(driver, a, "@name='keyword'", param.cari);
	}
	
	public static void isiForm(WebDriver driver, PenyesuaianPersediaanParam param) {
		log.info("PenyesuaianPersediaan.Isi");

		String w = AccurateModule.PENYESUAIAN_PERSEDIAAN.getXpath();

		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
	}
	
	public static void isiDetailBarang(WebDriver driver, PenyesuaianPersediaanParam param) {
		log.info("PenyesuaianPersediaan.IsiDetailBarang");

		String tab = "//div[starts-with(@id,'tab-item')]";

		AccTool.click(driver, "//*[contains(@href,'tab-item')]");

		if (param.searchitem != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}


	public static void detailBarang(WebDriver driver, PenyesuaianPersediaanParam param) {
		log.info("PenyesuaianPersediaan.DetailBarang");

		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");


		if (param.namabarang != null)
			AccTool.textField(driver, tab, "@name='detailName'", param.namabarang);
		if (param.unit != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
		if (param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);		
		
		if (param.pengurangan != null){
			WaitTool.delay(200);
			AccTool.radioButton(driver, tab, "@value='ADJUSTMENT_OUT'", param.pengurangan);
		}
		if (param.penambahan != null){
			AccTool.radioButton(driver, tab, "@value='ADJUSTMENT_IN'", param.penambahan);
			AccTool.click(driver, "//label[.='Biaya Satuan']");
			if (param.biayasatuan != null)
				AccTool.numberField(driver, tab, "@name='unitCost'", param.biayasatuan);
			}

		if (param.gudang != null)
			AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
		if (param.departemenmandatory != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
		if (param.proyekmandatory != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
	}

	public static void isiketeranganBarang(WebDriver driver, PenyesuaianPersediaanParam param) {
		log.info("PenyesuaianPersediaan.DetailBarang");

		String tab = "//*[starts-with(@id,'tab-customfield')]";

		AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
		if (param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);
		if (param.proyek != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyek);
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);

	}

	public static void isiNoSeri(WebDriver driver, PenyesuaianPersediaanParam param) {
		log.info("Penyesuaian Persediaan. Isi No Seri");
		
		String tab =  "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
		
		if (param.kuantitassn != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.kuantitassn);
		if (param.nosn != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.nosn);
		if (param.tglkadaluarsa != null)
			AccTool.datePicker(driver, tab, "@name='expiredDateSn'", param.tglkadaluarsa);
	}
	
	public static void isiInfoLain(WebDriver driver, PenyesuaianPersediaanParam param) {
		log.info("PenyesuaianPersediaan.IsiInfoLain");

		String tab = "//div[starts-with(@id,'tab-otherheader')]";

		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
		if (param.akunpenyesuaian != null)
			AccTool.lookup(driver, tab, "@name='adjustmentAccount'", param.akunpenyesuaian);
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);

	}

	
	public static void saveList(WebDriver driver, String filename) {
		log.info("PenyesuaianPersediaan.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "Penyesuaian Persediaan.SaveList : " + "\r\n";
		content = content + AccTool.getGridValue(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("PenyesuaianPersediaan.SaveIsi");

		String tab = "";
		String content = "PenyesuaianPersediaan.SaveHeader: " + "\r\n";

		content = content 
			
				+ "\r\n"
				+ "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN, ElementType.DATEPICKER,
						"transDate", tab)
				+ "No Penyesuaian : " + AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN,
						ElementType.TEXTFIELD, "number", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	

	public static void saveListBarang(WebDriver driver, String filename) {
		log.info("PenyesuaianPersediaan.SaveIsi");

		String tab = "//*[contains(@id,'tab-item')]";
		String content = "PenyesuaianPersediaan.SaveListBarang : " + "\r\n";
		content = content
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveDetail(WebDriver driver, String filename) {
		log.info("PenyesuaianPersediaan.SaveDetail");

		String content = "PenyesuaianPersediaan.SaveDetailBarang : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content 
				+ "\r\n" 
				+ "Nama Barang : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab) 
				+ "Tipe Penyesuaian: "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailitem')]//div[contains(@data-bind,'ft.itemAdjustmentType')]//*[@class='text-panel-disabled']")
				+ "Kuantitas : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
				+ "Satuan : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
				+ "Biaya Satuan : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitCost", tab) 
				+ "Total Biaya : "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "totalCost", tab) 
				+ "Gudang : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab) 
				+ "Departemen :"
	        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
            	+ "Proyek :"
            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span")
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveKeteranganDetailBarang(WebDriver driver, String filename) {
		log.info("PenyesuaianPersediaan.SaveDetail");

		String content = "PenyesuaianPersediaan.SaveKeteranganDetailBarang : " + "\r\n";
		String tab = "//*[contains(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'tabcustomfield')]");
		content = content 
				+ "Departemen : "
	        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span").replace(",", "")
            	+ "Proyek : "
            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span")
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	

	public static void saveIsiInfoLain(WebDriver driver, String filename) {
		log.info("PenyesuaianPersediaan.SaveIsi");

		AccTool.click(driver,
				AccurateModule.PENYESUAIAN_PERSEDIAAN.getXpath() + "//*[contains(@href,'tab-otherheader')]");
		String tab = "//*[contains(@id,'tab-otherheader')]";
		String content = "PenyesuaianPersediaan.SaveIsiInfoLain : " + "\r\n";
		content = content 
			
				+ "\r\n"
				+ "Akun Penyesuaian : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN, ElementType.LOOKUP,
						"adjustmentAccount", tab)
				+ "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN,
						ElementType.TEXTAREA, "description", tab);
				//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_PERSEDIAAN, ElementType.SUMMARY, "branchListOption", tab);
				}
				content = content
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	
	public static void saveFooter(WebDriver driver,  String filename)
	{
		log.info("Save Footer");
		WaitTool.delay(500);
		
		String content = "PenyesuaianPersediaan.saveFooter ; " + "\r\n";
		
		String tab ="//div[text()='Total']/following-sibling::div";
		
		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());
		
		content = content
				+ "\r\n"
				+ "Total : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PENYESUAIAN_PERSEDIAAN,tab )
				+ "\r\n";
		AccTool.writeTextFile(filename,  content);		
	}
	
	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("PenyesuaianPersediaan.SaveIsiDetailSerialNumber");

		String grid = "";
		String content = "Nomor Seri Detail Barang  : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";
		content = content
				+ "\r\n"
				+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	public static void saveIsiPopup(WebDriver driver, String fileName)
	{
		log.info("Save isi popup ");

	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	WaitTool.waitForElementVisible(driver, By.xpath(tab), 10);
	String content = "Penyesuaian Persediaan.Warning : " + "\r\n";
	content = content
			+ "Notifikasi"
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
	
		
	AccTool.writeTextFile(fileName, content);
	}


}
