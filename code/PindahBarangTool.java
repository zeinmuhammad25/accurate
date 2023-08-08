package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pindahbarang.PindahBarangParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;


public class PindahBarangTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PindahBarangParam.class);

	public static void klikButtonLanjutDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikSerialNumber(WebDriver driver) {
		String path = "//*[contains(@id,'tab-serial-number')]//*[@class='grid-canvas']/div[8]//button";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikButtonLanjutTabDetailSerialNumber(WebDriver driver) {
		WaitTool.delay(100);
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.delay(200);
	}

	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikOKPopUpWarning(WebDriver driver) {
		String path = "//*[@name='btnOk']";
		WaitTool.waitForElementVisible(driver, By.xpath("//div[contains(@id, 'confirm-dialog')]"), 3);
		AccTool.click(driver, path);
		WaitTool.delay(1000);
	}

	// konfirmasi tutup tab data saat ada data terisi
	public static void klikOKPadaWarningTutupTab(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'confirm-dialog')]//*[@name='btnOk']");
		WaitTool.delay(1000);
	}

	public static void klikButtonLanjutAmbilSO(WebDriver driver) {
		String path = "//*[contains(@id,'copy-sales-order')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikButtonLanjutAmbilPR(WebDriver driver) {
		String path = "//*[contains(@id,'copy-purchase-requisition')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikButtonDeleteDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikAmbilKirimBarang(WebDriver driver, PindahBarangParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PINDAH_BARANG.getXpath(),
				"//div[contains(@class, 'offset4 span8')]/div[1]", "Pemindahan Barang");
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-item-transfer')]", "@name='lookup'", param.search);
	}

	public static void klikButtonLanjutAmbilPengiriman(WebDriver driver) {
		String path = "//*[contains(@id,'copy-item-transfer')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikAmbilPesanan(WebDriver driver, PindahBarangParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PINDAH_BARANG.getXpath(),
				"//div[contains(@class, 'offset4 span8')]/div[1]", "Pesanan");
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-sales-order')]", "@name='lookup'", param.search);
	}
	
	public static void klikAmbilPermintaan(WebDriver driver, PindahBarangParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.PINDAH_BARANG.getXpath(),
				"//div[contains(@class, 'offset4 span8')]/div[1]", "Permintaan");
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-purchase-requisition')]", "@name='lookup'", param.search);
	}
	
	public static void klikAmbilPermintaanKosong(WebDriver driver, PindahBarangParam param)
	{
		AccTool.dropDown(driver, AccurateModule.PINDAH_BARANG.getXpath(), 
				"//div[@class='offset4 span8']/div[1]", "Permintaan");
		if(param.search != null)
			AccTool.lookupWithoutClear(driver, "//div[contains(@id, 'copy-purchase-requisition')]", "@name='lookup'", param.search);
	}
	
	public static void klikTabSerialNumberBarang(WebDriver driver)
	{
		log.info("masuk sn");
		AccTool.click(driver, "//a[contains(@href, '#tab-serial-number')]");
	}

	public static void isiForm(WebDriver driver, PindahBarangParam param) {
		log.info("PindahBarang.IsiForm");

		String tab = AccurateModule.PINDAH_BARANG.getXpath();

		if (param.tanggal != null)
			AccTool.datePicker(driver, tab, "@name='transDate'", param.tanggal);
		if (param.proses != null)
			AccTool.combobox(driver, tab, "@name='itemTransferType'", param.proses);
		if (param.penomoran != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, tab, "@name='number'", param.no);
		if (param.gudang != null)
			AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
		if (param.gudangtujuan != null)
			AccTool.lookup(driver, tab, "@name='referenceWarehouse'", param.gudangtujuan);
		if (param.gudangpengirim != null)
			AccTool.lookup(driver, tab, "@name='referenceWarehouseName'", param.gudangpengirim);
	}

	public static void detailBarang(WebDriver driver, PindahBarangParam param) {
		log.info("PindahBarang.DetailBarang");

		String tab = "//div[starts-with(@id,'tab-detailitem')]";

		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");

		if (param.namabarang != null)
			AccTool.textField(driver, tab, "@name='detailName'", param.namabarang);
		WaitTool.delay(1000);
		if (param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		WaitTool.delay(1000);
		if (param.satuan != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);
	}

	public static void keteranganBarang(WebDriver driver, PindahBarangParam param) {
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
		String tab = "//div[starts-with(@id,'tab-customfield')]";
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
	}

	public static void isiDetailBarang(WebDriver driver, PindahBarangParam param) {
		log.info("PindahBarang.IsiDetailBarang");

		String tab = "//div[starts-with(@id,'tab-item')]";

		AccTool.click(driver, "//a[contains(@href,'tab-item')]");

		if (param.searchitem != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}

	public static void isiNoSeri(WebDriver driver, PindahBarangParam param) {
		log.info("PindahBarang.DetailNOSERI");

		String tab = "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");

		if (param.kuantitasnoseri != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.kuantitasnoseri);
		if (param.noseri != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.noseri);
	}

	public static void isiInfoLain(WebDriver driver, PindahBarangParam param) {
		log.info("PindahBarang.IsiInfoLain");

		String tab = "//div[starts-with(@id,'tab-otherheader')]";

		AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
		
		if (param.selisihakun != null)
			AccTool.lookup(driver, tab, "@name='differenceItemTransferAccount'", param.selisihakun);
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
	}

	public static void isiFavorit(WebDriver driver, PindahBarangParam param) {
		log.info("PindahBarang.IsinamaFavorit");

		String tab = "//div[starts-with(@id,'accurate__company__save-memorize-transaction-dialog')]";

		AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");

		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
	}

	public static void saveDetail(WebDriver driver, String filename) {
		log.info("PindahBarang.SaveDetail");

		String tab = "";
		String content = "PindahBarang.SaveDetail : " + "\r\n";

		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content

				+ "\r\n" 
				+ "Nama Barang : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " 
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
				+ "Satuan : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
				+ "Kts.Diterima : "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.processQuantityDesc", tab) + "\r\n";

		tab = "//div[starts-with(@id,'tabcustomfield')]";
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
		content = content +  "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailDariPermintaan(WebDriver driver, String filename) {
		log.info("PindahBarang.SaveDetail");

		String tab = "";
		String content = "PindahBarang.SaveDetail : " + "\r\n";

		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content

				+ "\r\n" 
				+ "Nama Barang : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " 
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
				+ "Satuan : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
				+ "No. Permintaan: "
				+ AccTool.getTextValue(driver, 
						"//div[starts-with(@id,'tab-detailitem')]//div[contains(@data-bind,'purchaseRequisition')]") + "\r\n";

		tab = "//div[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
		content = content 
				+  "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n"
				+ "No. Permintaan: "
				+ AccTool.getTextValue(driver, 
				"//div[starts-with(@id,'tab-customfield')]//div[contains(@data-bind,'purchaseRequisition')]") + "\r\n";


		AccTool.writeTextFile(filename, content);
	}

	
	public static void saveDetailDariPesanan(WebDriver driver, String filename) {
		log.info("PindahBarang.SaveDetail");

		String tab = "";
		String content = "PindahBarang.SaveDetail : " + "\r\n";

		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content

				+ "\r\n" 
				+ "Nama Barang : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " 
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
				+ "Satuan : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
				+ "No. Pesanan: "
				+ AccTool.getTextValue(driver, 
				"//div[starts-with(@id,'tab-customfield')]//div[contains(@data-bind,'salesOrder')]") + "\r\n";

		tab = "//div[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
		content = content +  "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n"
				+ "No. Pesanan: "
				+ AccTool.getTextValue(driver, 
				"//div[starts-with(@id,'tab-customfield')]//div[contains(@data-bind,'salesOrder')]") + "\r\n";


		AccTool.writeTextFile(filename, content);
	}

	public static void SaveIsiHeaderKirimBarang(WebDriver driver, String fileName) {
		log.info("PindahBarang.SaveIsiHeader");

		String tab = "";
		String content = "PindahBarang.SaveHeaderKirimBarang : " + "\r\n";
		content = content

				+ "\r\n" + "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.DATEPICKER, "transDate", tab)
				+ "Proses : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, "//div[@name='itemTransferType']")
				+ "Penomoran : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.TEXTFIELD, "number", tab)
				+ "Gudang  : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.LOOKUP, "warehouse", tab)
				+ "Gudang Tujuan : " + AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.LOOKUP,
						"referenceWarehouse", tab)
				+ "\r\n";
		AccTool.writeTextFile(fileName, content);
	}

	// gudang di disable
	public static void SaveIsiHeaderKirimBarangDiterimaSeluruhnya(WebDriver driver, String fileName) {
		log.info("PindahBarang.SaveIsiHeader");

		String tab = "";
		String content = "PindahBarang.SaveHeaderKirimBarang : " + "\r\n";
		content = content

				+ "\r\n" + "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.DATEPICKER, "transDate", tab)
				+ "Proses : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, "//div[@name='itemTransferType']")
				+ "Penomoran : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.TEXTFIELD, "number", tab)
				+ "Gudang  : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, "//div[contains(@data-bind,'warehouse')]")
				+ "Gudang Tujuan : " + AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG,
						"//div[contains(@data-bind,'referenceWarehouse')]")
				+ "\r\n";
		AccTool.writeTextFile(fileName, content);
	}

	public static void SaveIsiHeaderTerimaBarang(WebDriver driver, String fileName) {
		log.info("PindahBarang.SaveHeaderTerimaBarang");

		String tab = "";
		String content = "PindahBarang.SaveHeaderTerimaBarang : " + "\r\n";
		content = content

				+ "\r\n" + "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.DATEPICKER, "transDate", tab)
				+ "Proses : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, "//div[@name='itemTransferType']")
				+ "No Pengiriman : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG,
						"//div[contains(@data-bind,'fromItemTransfer')]")
				+ "Penomoran : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.TEXTFIELD, "number", tab)
				+ "Gudang  : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG,
						"//div[contains(@data-bind,'warehouseName')]")
				+ "Gudang Pengirim : " + AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG,
						"//div[contains(@data-bind,'referenceWarehouseName')]")
				+ "\r\n";
		AccTool.writeTextFile(fileName, content);
	}

	public static void SaveListDetail(WebDriver driver, String fileName) {
		log.info("PindahBarang.SaveIsiDetail");

		AccTool.click(driver, AccurateModule.PINDAH_BARANG.getXpath() + "//*[contains(@href,'tab-item')]");
		String tab = "//*[contains(@id,'tab-item')]";
		String content = "PindahBarang.SaveListDetail : " + "\r\n";
		content = content 
			
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.PINDAH_BARANG, tab)
				+ "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
	
	public static void saveList(WebDriver driver, String filename) {
		log.info("PindahBarang.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "PindahBarang.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.PINDAH_BARANG, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	

	public static void SaveInfoLain(WebDriver driver, String fileName) {
		log.info("PindahBarang.SaveInfoLain");
		AccTool.click(driver, AccurateModule.PINDAH_BARANG.getXpath() + "//*[contains(@href,'tab-otherheader')]");
		String tab = "//*[contains(@id,'tab-otherheader')]";
		String content = "PindahBarang.SaveInfoLain : " + "\r\n";
		content = content

				+ "\r\n" 
				+ "Selisih Akun : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, "differenceItemTransferAccount")
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.TEXTAREA, "description", tab);
				//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.SUMMARY, "branchListOption", tab);
				}
				content = content
				+ "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
	
	public static void saveRingkasanPengiriman(WebDriver driver, String fileName) {
		log.info("PindahBarang.SaveInfoLain");
		AccTool.click(driver, AccurateModule.PINDAH_BARANG.getXpath() + "//*[contains(@href,'tab-summary')]");
		String tab = "//*[contains(@id,'tab-summary')]";
		String content = "PindahBarang.SaveRingkasanPengiriman : " + "\r\n";
		content = content

				+ "\r\n" 
				+ "Penerimaan Barang: "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.SPAN, "text: formData.receiveHistory()()")
				+ "Status : "
				+ AccTool.getTextValue(driver, AccurateModule.PINDAH_BARANG, ElementType.SPAN, "text: formData.statusName()", tab)
				+ "\r\n";

		AccTool.writeTextFile(fileName, content);
	}

	public static void SaveNotifNoseri(WebDriver driver, String fileName) {
		log.info("PindahBarang.SaveNotifNoSeri");

		String tab = "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
		String content = "PindahBarang.SaveNotifNoSeri : " + "\r\n";
		content = content + "Notifikasi" + "\r\n" + AccTool.getTextValue(driver, ElementType.REPORT, " ", tab) + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}

	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("PindahBarang. SaveIsiDetailSerialNumber");

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
	String content = "PindahBarang.Warning : " + "\r\n";
	content = content
			+ "Notifikasi"
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
	AccTool.writeTextFile(fileName, content);
	}
	

}
