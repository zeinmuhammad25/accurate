package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pengisiannomorseri.PengisianNomorSeriParam;
import com.cpssoft.web.test.accurate.pindahbarang.PindahBarangParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PengisianNomorSeriTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PengisianNomorSeriParam.class);

	public static void klikTabDetailBarang(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PENGISIAN_NOMOR_SERI.getXpath() + "//a[contains(@href, '#tab-item')]");
	}

	public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver,
				AccurateModule.PENGISIAN_NOMOR_SERI.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}

	// untuk submit no seri
	public static void klikLanjutIsiNoSeri(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
	}

	// klik lanjut kemudian pop up detail barang ditutup
	public static void klikLanjutItem(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 3);
		AccTool.waitProgressBar(driver);
		AccTool.waitLoadingMask(driver);
	}

	public static void klikButtonCloseTabDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikButtonPilihNoSeri(WebDriver driver)
	{
		String xpath = "//*[contains(@id,'accurate__inventory__select-serial-number-dialog')]//*[@name='btnSelect']";
		AccTool.click(driver, xpath);
	}
	
	public static void klikOKPopUpWarning(WebDriver driver) {
		String path = "//*[@name='btnOk']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikButtonImporSn(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnImportSn']";
		AccTool.click(driver, xpath);
	}
	
	public static void klikPilihNomorSeri(WebDriver driver) 
	{
		AccTool.click(getWebDriver(), "//a[contains(@href,'')]//i[@class='icon-list']");
		AccTool.waitLoadingMask(getWebDriver());
	}
	
	public static void klikSerialNumber(WebDriver driver, Integer urutan) {
		String path = "//*[contains(@id,'tab-serial-number')]//div[contains(@class, 'slick-row')][" + urutan
				+ "]//div[contains(@class, 'slick-cell l2 r2 text-right')]";
		AccTool.click(getWebDriver(), path);
	}
	
	public static void cekSemuaNomorSeri(WebDriver driver) 
	{
		String xpath = "//div[contains(@id, 'accurate__inventory__select-serial-number-dialog')]//div[contains(@class, 'grid fluid no-margin')]//div[contains(@class, 'row no-margin')][2]//label/span";
		AccTool.click(driver, xpath);
	}
	
	public static void pilihDetailItem(WebDriver driver, PengisianNomorSeriParam param)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-serial-number-entry-grid-list')]//div[@class='grid-canvas']/div["+param.urutan+"]");
	} 
	

	public static void isiHeader(WebDriver driver, PengisianNomorSeriParam param) {
		log.info("Pengisian No Seri. Isi Header");
		String tab = AccurateModule.PENGISIAN_NOMOR_SERI.getXpath();

		if (param.tipetransaksi != null)
			AccTool.combobox(driver, tab, "@name='transactionType'", param.tipetransaksi);
		if (param.penomoran != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, tab, "@name='number'", param.no);
		if (param.nomortransaksi != null)
			AccTool.lookup(driver, tab, "@name='module'", param.nomortransaksi);
		if (param.tanggal != null)
			AccTool.datePicker(driver, tab, "@name='transDate'", param.tanggal);

	}

	
	public static void isiDetail(WebDriver driver, PengisianNomorSeriParam param) {
		log.info("Pengisian No Seri. Isi Header");

		String tab = "//div[starts-with(@id,'tab-serial-number')]";

		if (param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.kuantitas);
		if (param.nomorseri != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.nomorseri);
		if (param.tanggalkadaluarsa != null)
			AccTool.datePicker(driver, tab, "@name='expiredDateSn'", param.tanggalkadaluarsa);

	}
	
	public static void isiInfoLain(WebDriver driver, PindahBarangParam param) {
		log.info("PengisianNoSeri.IsiInfoLain");

		String tab = "//div[starts-with(@id,'tab-otherheader')]";

		AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
		
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
	}

	public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("PengisianNoSeri.SaveIsiHeader");

		String tab = "";
		String content = "PengisianNoSeri.SaveHeader : " + "\r\n";
		content = content 
				+ "\r\n"
				+ "Tipe Transaksi: "
				+ AccTool.getTextValue(driver, AccurateModule.PENGISIAN_NOMOR_SERI,
						"//div[contains(@data-bind,'transactionTypeName')]")
				+ "Nomor #: "
				+ AccTool.getTextValue(driver, AccurateModule.PENGISIAN_NOMOR_SERI, ElementType.TEXTFIELD, "number",
						tab)
				+ "Nomor Transaksi : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGISIAN_NOMOR_SERI,
						"//div[contains(@data-bind,'formData.transNumber')]")
				+ "Tanggal : " + AccTool.getTextValue(driver, AccurateModule.PENGISIAN_NOMOR_SERI,
						ElementType.DATEPICKER, "transDate", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveList(WebDriver driver,  String filename)
	{
		log.info("PengisianNoSeri.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "PengisianNoSeri.SaveList : " + "\r\n";
		
		content = content + AccTool.getGridValue(driver, AccurateModule.PENGISIAN_NOMOR_SERI, tab) + "\r\n";

		AccTool.writeTextFile(filename,  content);
	}

	public static void saveListDetailBarang(WebDriver driver, String fileName) {
		log.info("Pengisian No Seri List Barang");

		AccTool.click(driver, AccurateModule.PENGISIAN_NOMOR_SERI.getXpath() + "//*[contains(@href,'tab-item')]");
		String tab = "//*[contains(@id,'tab-item')]";
		String content = "PengisianNomorSeri.ListBarang : " + "\r\n";
		content = content
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PENGISIAN_NOMOR_SERI, tab) + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}

	public static void saveIsiDetailBarang(WebDriver driver, String filename) {
		log.info("PengisianNoSeri.SaveIsiDetail");

		String grid = "";
		String content = "PengisianNomorSeri.DetailBarang  : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";
		content = content
				+ "\r\n"
				+ "Nama Barang : "
				+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'text: formData.detailName')]") + "\r\n"
				+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	
	public static void saveNotifNoseri(WebDriver driver, String fileName)
	{
		log.info("PengisianNoSeri.SaveNotifNoSeri");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
	String content = "PengisianNoSeri.SaveNotifNoSeri : " + "\r\n";
	content = content
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
        AccTool.writeTextFile(fileName, content);
     }

	public static void SaveInfoLain(WebDriver driver, String fileName) {
		log.info("PengisianNoSeri.SaveInfoLain");
		AccTool.click(driver, AccurateModule.PENGISIAN_NOMOR_SERI.getXpath() + "//*[contains(@href,'tab-otherheader')]");
		String tab = "//*[contains(@id,'tab-otherheader')]";
		String content = "PengisianNoSeri.SaveInfoLain : " + "\r\n";
		content = content

				+ "\r\n" 
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PENGISIAN_NOMOR_SERI, ElementType.TEXTAREA, "description", tab);
				
				//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PENGISIAN_NOMOR_SERI, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PENGISIAN_NOMOR_SERI, ElementType.SUMMARY, "branchListOption", tab);
				}
				content = content
				+ "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
	
	public static void isiNoSeriBerurutan(WebDriver driver, PengisianNomorSeriParam param) {
		log.info("Pengisian No Seri. Isi No Seri Berurutan");
		String tab = "//*[contains(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]";

		if (param.nomorseri != null)
			AccTool.textField(driver, tab, "@name='textField'", param.nomorseri);
		if (param.no != null)
			AccTool.numberField(driver, tab, "@name='consecutiveCount'", param.no);

	}
	
	public static void klikBuat(WebDriver driver) {
		String xpath = "//*[contains(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]//*[@name='btnCreateSn']";
		AccTool.click(driver, xpath);
	}
	
	public static void ubahKtsSnProduksi(WebDriver driver, PengisianNomorSeriParam param) {
		log.info("Pengisian No Seri.Ubah SN Produksi");

		String tab = "//div[starts-with(@id,'accurate__inventory__batch-edit-quantity')]";

		if (param.kuantitas != null)
			AccTool.click(getWebDriver(),"//div[starts-with(@id,'accurate__inventory__batch-edit-quantity')]//*[@class='btn-calculate']");
			AccTool.numberField(driver, tab, "@name='batchQuantity'", param.kuantitas);

	}
	
	public static void klikUbah(WebDriver driver) {
		String xpath = "//div[starts-with(@id,'accurate__inventory__batch-edit-quantity')]//*[@name='btnSubmit']";
		AccTool.click(driver, xpath);
	}
}
