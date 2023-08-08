package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class BarangJasaTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(BarangJasaParam.class);

	public static void klikTabGambar(WebDriver driver) {
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Gambar']");
	}

	public static void klikTabUmum(WebDriver driver) {
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Umum']");
	}

	public static void klikTabJualBeli(WebDriver driver) {
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()= 'Penjualan / Pembelian']");
	}

	public static void klikTabSaldo(WebDriver driver) {
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[contains(@href,'tab-stock')]");

	}

	public static void klikTabLainlain(WebDriver driver) {
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()= 'Lain-lain']");

	}

	public static void klikTabAkun(WebDriver driver) {
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()= 'Akun']");
	}
	
	public static void klikTabNoSeri(WebDriver driver) {
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()= 'No Seri/Produksi']");
	}
	
	public static void klikTabSerialNumberBarang(WebDriver driver)
	{
		AccTool.click(driver, "//a[contains(@href, '#tab-serial-number')]");
	}
	
	
	public static void klikButtonLanjutTabDetailSaldo(WebDriver driver) {
		String path = "//div[starts-with(@id,'detail-open-balance')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	// untuk menghapus jika ada field saldo ngga diisi sehingga popup ngga ilang
	public static void klikButtonLanjutTabDetailSaldo2(WebDriver driver) {
		String path = "//div[starts-with(@id,'detail-open-balance')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
		
	}
	
	public static void klikButtonCloseTabDetailSaldo(WebDriver driver) {
		String path = "//*[text()='Saldo Awal']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikButtonHapusTabDetailSaldo(WebDriver driver) {
		String path = "//*[contains(@id,'detail-open-balance')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		AccTool.waitLoaderMedium(driver);
		
	}
	
	public static void klikButtonLanjutTabDetailSerialNumber(WebDriver driver) {
		WaitTool.delay(3500);
		String path = "//div[starts-with(@id,'detail-open-balance')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
//		WaitTool.delay(2000);
	}
	// klik next menunggu popup ilang
	public static void klikButtonLanjutTabDetailSerialNumber2(WebDriver driver) {
		String path = "//div[starts-with(@id,'detail-open-balance')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(getWebDriver(), By.xpath("//div[starts-with(@id,'detail-open-balance')]" + "//button[@name='btnNext']"), 6);
		
	}
	
	public static void klikButtonLanjutTabDetailBatchNumber(WebDriver driver) {
		String path = "//div[starts-with(@id,'detail-open-balance')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
	
	}

	public static void klikDetailSaldoAwal1(WebDriver diver){
		AccTool.click(getWebDriver(), "//*[contains(@id,'opening-balance-grid-list')]//*[@class='grid-canvas']/div[1]");
	}
	
	public static void klikDetailSaldoAwal2(WebDriver diver){
		AccTool.click(getWebDriver(), "//*[contains(@id,'opening-balance-grid-list')]//*[@class='grid-canvas']/div[2]");
	}
	
	public static void klikDetailSaldoAwal3(WebDriver diver){
		AccTool.click(getWebDriver(), "//*[contains(@id,'opening-balance-grid-list')]//*[@class='grid-canvas']/div[3]");
	}
	
	public static void klikButtonLanjutRincianGrup(WebDriver driver) {
		String path = "//div[starts-with(@id,'detail-group')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikRefreshMutasi(WebDriver driver, AccurateModule module) {
		String tab = AccurateModule.BARANG_JASA.getXpath() + "//div[starts-with(@id,'tab-history')]";
		AccTool.click(driver, tab + "//button[@name='btnRefresh']");
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath("//div[starts-with(@id,'tab-history')]"), 10);
		AccTool.waitGridMask(driver, true);
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikRefreshNoseri(WebDriver driver, AccurateModule module) {
		String tab = AccurateModule.BARANG_JASA.getXpath() + "//div[starts-with(@id,'tab-serialnumber')]";
		AccTool.click(driver, tab + "//button[@name='btnRefreshSnHistory']");
		AccTool.waitGridMask(driver);
		AccTool.waitLoadingMask(driver);
	}

	
	public static void klikRefreshGudang(WebDriver driver, AccurateModule module) {
		String tab = AccurateModule.BARANG_JASA.getXpath() + "//div[starts-with(@id,'tab-warehouse')]";
		AccTool.click(driver, tab + "//button[@name='btnRefreshWarehouseHistory']");
		AccTool.waitGridMask(getWebDriver());
		AccTool.waitLoadingMask(driver);
	}
	
	
	public static void klikBtnNoSeriBerurutan(WebDriver driver, BarangJasaParam param) {
		log.info("Penerimaan Barang. Isi No Seri Berurutan");
		
		AccTool.dropDown(driver, "//div[contains(@id, 'tab-serial-number')]", 
				"", " Nomor Seri berurutan");
	}
	
	

	public static void klikBtnBuatIsiNoSeriBerurutan(WebDriver driver, BarangJasaParam param) {
		String path = "//*[contains(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]//*[@name='btnCreateSn']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	
	public static void klikButtonHapusRincianGrup(WebDriver driver) {
		String path = "//*[contains(@id,'detail-group')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 50);
		
	}
	
	public static void klikHapusPajak1(WebDriver driver) {
		AccTool.clearLookup(getWebDriver(),"", "@name='tax1'");
	}
	
	public static void klikHapusPajak2(WebDriver driver) {
		AccTool.clearLookup(getWebDriver(),"", "@name='tax2'");
	}
	
	public static void klikHapusPajak3(WebDriver driver) {
		AccTool.clearLookup(getWebDriver(),"", "@name='tax3'");
	}
	
	public static void klikHapusPajak4(WebDriver driver) {
		AccTool.clearLookup(getWebDriver(),"", "@name='tax4'");
	}
	
	public static void klikButtonImporSn(WebDriver driver, String impor) {
        String xpath = "//*[contains(@id,'detail-open-balance')]//*[@name='btnImportSn']";
        AccTool.click(driver, xpath);
        
        WaitTool.delay(1000);
        String xpath2 ="//a[contains(.,'"+ impor +"')]";
        AccTool.click(driver, xpath2);
    }
	
	
	public static void selectPCS(WebDriver driver) {
		Select multiSatuan = new Select(driver.findElement(By.xpath("//select[@name='historyValueType']")));
		multiSatuan.selectByVisibleText("Multi Satuan");
		
	}

	public static void isiAkun(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.IsiLainLain");

		String w = AccurateModule.BARANG_JASA.getXpath();
		String tab = w + "//*[contains(@id,'tab-glaccount')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Lain-lain']");
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-glaccount')]");

		if (param.persediaan != null)
			AccTool.lookup(driver, tab, "@name='inventoryGlAccount'", param.persediaan);

		if (param.penjualan != null)
			AccTool.lookup(driver, tab, "@name='salesGlAccount'", param.penjualan);

		if (param.returpenjualan != null)
			AccTool.lookup(driver, tab, "@name='salesRetGlAccount'", param.returpenjualan);

		if (param.diskonpenjualan != null)
			AccTool.lookup(driver, tab, "@name='salesDiscountGlAccount'", param.diskonpenjualan);

		if (param.barangterkirim != null)
			AccTool.lookup(driver, tab, "@name='goodTransitGlAccount'", param.barangterkirim);

		if (param.hargapokokpenjualan != null)
			AccTool.lookup(driver, tab, "@name='cogsGlAccount'", param.hargapokokpenjualan);

		if (param.returpembelian != null)
			AccTool.lookup(driver, tab, "@name='purchaseRetGlAccount'", param.returpembelian);

		if (param.barangbelumtertagih != null)
			AccTool.lookup(driver, tab, "@name='unBilledGlAccount'", param.barangbelumtertagih);
	}

	
	public static void isiRincianGrup(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.IsiRincianGrup");

		String w = AccurateModule.BARANG_JASA.getXpath();
		String tab = w + "//*[contains(@id,'tab-itemgroup')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Rincian Grup']");
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-itemgroup')]");

		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if (param.cetak != null)
			AccTool.checkbox(driver, tab, "@name= 'printDetailGroup'", param.cetak);
	}

	
	public static void detailRincianGrup(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.detailRincianGrup");
		
		String w = "//div[starts-with(@id,'detail-group')]";
		if (param.namagrup != null)
			AccTool.textField(driver, w, "@name='detailName'", param.namagrup);
		if (param.kuantitasgrup != null)
			AccTool.numberField(driver, w, "@name='quantity'", param.kuantitasgrup);
		if (param.satuangrup != null)
			AccTool.lookup(driver, w, "@name='itemUnit'", param.satuangrup);
	}


	public static void isiJualBeli(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.IsiJualBeli");

		String w = AccurateModule.BARANG_JASA.getXpath();
		String tab = w + "//*[contains(@id,'tab-sales-purchase')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Penjualan / Pembelian']");
//		WaitTool.delay(1000); //delay supaya tidak mengisi default diskon sembarangan
		WaitTool.waitForElementVisible(driver, By.xpath(tab), 5);
		
		if (param.hargagrosir != null)
			AccTool.checkbox(driver, tab, "@name='useWholesalePrice'", param.hargagrosir);
		
		if (param.defaultdiskon != null)
			AccTool.textField(driver, tab, "@name='defaultDiscount'", param.defaultdiskon);

		if (param.centangdef != null)
			AccTool.checkbox(driver, tab, "@name='calculateGroupPrice'", param.centangdef);
		
		if (param.defhargajual != null)
			AccTool.numberField(driver, tab, "@name='unitPrice'", param.defhargajual);

		if (param.defhargaunit2 != null)
			AccTool.numberField(driver, tab, "@name='unit2Price'", param.defhargaunit2);

		if (param.defhargaunit3 != null)
			AccTool.numberField(driver, tab, "@name='unit3Price'", param.defhargaunit3);

		if (param.defhargaunit4 != null)
			AccTool.numberField(driver, tab, "@name='unit4Price'", param.defhargaunit4);

		if (param.defhargaunit5 != null)
			AccTool.numberField(driver, tab, "@name='unit5Price'", param.defhargaunit5);
		
		if (param.cbsubstitusi != null)
			AccTool.checkbox(driver, tab, "@name='substituted'", param.cbsubstitusi);
		
		if (param.namasubstitusi != null)
			AccTool.lookup(driver, tab, "@name='substitutedItem'", param.namasubstitusi);

		if (param.pemasokutama != null)
			AccTool.lookup(driver, tab, "@name='preferedVendor'", param.pemasokutama);

		if (param.satuanbeli != null)
			AccTool.lookup(driver, tab, "@name='vendorUnit'", param.satuanbeli);
		
		if (param.satuankontrol != null)
			AccTool.checkbox(driver, tab, "@name='controlQuantity'", param.satuankontrol);
		
		if (param.hargabeli != null)
			AccTool.numberField(driver, tab, "@name='vendorPrice'", param.hargabeli);

		if (param.minimumbeli != null)
			AccTool.numberField(driver, tab, "@name='minimumQuantity'", param.minimumbeli);
		
		if (param.minimumstok != null)
			AccTool.numberField(driver, tab, "@name='minimumQuantityReorder'", param.minimumstok);

		if (param.pajak4 != null)
			AccTool.lookup(driver, tab, "@name='tax4'", param.pajak4);
		
		if (param.pajak1 != null)
			AccTool.lookup(driver, tab, "@name='tax1'", param.pajak1);

		if (param.pajak2 != null)
			AccTool.lookup(driver, tab, "@name='tax2'", param.pajak2);

		if (param.pajak3 != null)
			AccTool.lookup(driver, tab, "@name='tax3'", param.pajak3);

		if (param.dpp != null)
			AccTool.combobox(driver, tab, "@name='percentTaxable'", param.dpp);
		
	}
	
	
	public static void isiLainLain(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.IsiLainLain");

		String w = AccurateModule.BARANG_JASA.getXpath();
		String tab = w + "//*[contains(@id,'tab-miscellaneous')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Lain-lain']");
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-miscellaneous')]");
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='notes'", param.catatan);
		if (param.cbnonaktif != null)
			AccTool.checkbox(driver, tab, "@name='suspended'", param.cbnonaktif);		
		if (param.harusisinomorseri != null)
			AccTool.checkbox(driver, tab, "@name='forceSN'", param.harusisinomorseri);
		if (param.isinomornostok != null)
			AccTool.checkbox(driver, tab, "@name='deliverHasNoStockSN'", param.isinomornostok);
	}

	public static void isiSaldo(WebDriver driver) {
		log.info("BarangJasa.IsiSaldo");
		String xpath = "//*[contains(@href,'tab-info')]";
		if (WebElementTool.isElementExists(driver, By.xpath(xpath))) {
			AccTool.click(driver,  "//*[contains(@href,'tab-info')]");
		} 	else {
			AccTool.click(driver,  "//*[contains(@href,'tab-stock')]");
		}

//		AccTool.click(driver,  "//button[@name='btnAddOpenBalance']");a
	}

	public static void detailMutasi(WebDriver driver, BarangJasaParam param) {
		String tab = "//div[starts-with(@id,'tab-history')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[contains(@href, 'tab-history')]");

		if (param.search != null)
			AccTool.lookup(driver, tab, "@name='formData.account'", param.search);
		if (param.daritanggal != null)
			AccTool.datePicker(driver, tab, "@name='fromDate'", param.daritanggal);
		if (param.sampaitanggal != null)
			AccTool.datePicker(driver, tab, "@name='toDate'", param.sampaitanggal);
	}
	
	public static void satuanMutasi(WebDriver driver, BarangJasaParam param) {
		String tab = "//div[starts-with(@id,'tab-history')]";

	//	AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[contains(@href, 'tab-history')]");
		if (param.satuanmutasi != null)
			AccTool.combobox(driver, tab, "@name='historyValueType'", param.satuanmutasi);
	}

	public static void cariNoseri(WebDriver driver, BarangJasaParam param) {
		String tab = "//div[starts-with(@id,'tab-serialnumber')]";
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='No.Seri']");
		if (param.pertanggal != null)
			AccTool.datePicker(driver, tab, "@name='snAsOf'", param.pertanggal);
	}


	public static void detailGudang(WebDriver driver, BarangJasaParam param) {
		String tab = "//div[starts-with(@id,'tab-warehouse')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-warehouse')]");

		if (param.tanggalgudang != null)
			AccTool.datePicker(driver, tab, "@name='asOfDate'", param.tanggalgudang);
	}

	

	public static void isiUmum(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.IsiUmum");

		String tab = "//div[starts-with(@id,'tab-general')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Umum']");
		//AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-general')]");

		if (param.kategoriitem != null)
			AccTool.lookup(driver, tab, "@name='itemCategory'", param.kategoriitem);
		if (param.penomoran != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.penomoran);
		if (param.itemno != null)
			AccTool.textField(driver, tab, "@name='no'", param.itemno);
		if (param.namabarang != null)
			AccTool.textField(driver, tab, "@name='name'", param.namabarang);
		if (param.jenisitem != null)
			AccTool.combobox(driver, tab, "@name='itemType'", param.jenisitem);
		if (param.satuan != null)
			AccTool.lookup(driver, tab, "@name='unit1'", param.satuan);
		if (param.satuan2 != null)
			AccTool.lookup(driver, tab, "@name='unit2'", param.satuan2);
		if (param.ratio2 != null)
			AccTool.numberField(driver, tab, "@name='ratio2'", param.ratio2);
		if (param.satuan3 != null)
			AccTool.lookup(driver, tab, "@name='unit3'", param.satuan3);
		if (param.ratio3 != null)
			AccTool.numberField(driver, tab, "@name='ratio3'", param.ratio3);
		if (param.satuan4 != null)
			AccTool.lookup(driver, tab, "@name='unit4'", param.satuan4);
		if (param.ratio4 != null)
			AccTool.numberField(driver, tab, "@name='ratio4'", param.ratio4);
		if (param.satuan5 != null)
			AccTool.lookup(driver, tab, "@name='unit5'", param.satuan5);		
		if (param.ratio5 != null)
			AccTool.numberField(driver, tab, "@name='ratio5'", param.ratio5);
		if (param.upc != null)
			AccTool.textField(driver, tab, "@name='upcNo'", param.upc);
	
		if (param.akunbebanproduksi != null)
			AccTool.lookup(driver, tab, "@name='inventoryGlAccount'", param.akunbebanproduksi);
		if (param.cbnoseri != null)
			AccTool.checkbox(driver, tab, "@name='manageSN'", param.cbnoseri);
		if (param.nomorunik != null)
			AccTool.radioButton(driver, tab, "@value='UNIQUE'", param.nomorunik);
		if (param.nomorproduksi != null)
			AccTool.radioButton(driver, tab, "@value='BATCH'", param.nomorproduksi);
		if (param.cbtglkadaluarsa != null)
			AccTool.checkbox(driver, tab, "@name='manageExpired'", param.cbtglkadaluarsa);
	}
	
	public static void isiUmumManufaktur(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.IsiUmum");

		String tab = "//div[starts-with(@id,'tab-general')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Umum']");
		//AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-general')]");

		if (param.kategoriitem != null)
			AccTool.lookup(driver, tab, "@name='itemCategory'", param.kategoriitem);
		if (param.penomoran != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.penomoran);
		if (param.itemno != null)
			AccTool.textField(driver, tab, "@name='no'", param.itemno);
		if (param.namabarang != null)
			AccTool.textField(driver, tab, "@name='name'", param.namabarang);
		if (param.jenisitem != null)
			AccTool.combobox(driver, tab, "@name='itemType'", param.jenisitem);
		if (param.bahanbaku != null)
			AccTool.checkbox(driver, tab, "@name='materialProduced'", param.bahanbaku);
		if (param.diproduksi != null)
			AccTool.checkbox(driver, tab, "@name='itemProduced'", param.diproduksi);
		if (param.satuan != null)
			AccTool.lookup(driver, tab, "@name='unit1'", param.satuan);
		if (param.satuan2 != null)
			AccTool.lookup(driver, tab, "@name='unit2'", param.satuan2);
		if (param.ratio2 != null)
			AccTool.numberField(driver, tab, "@name='ratio2'", param.ratio2);
		if (param.satuan3 != null)
			AccTool.lookup(driver, tab, "@name='unit3'", param.satuan3);
		if (param.ratio3 != null)
			AccTool.numberField(driver, tab, "@name='ratio3'", param.ratio3);
		if (param.satuan4 != null)
			AccTool.lookup(driver, tab, "@name='unit4'", param.satuan4);
		if (param.ratio4 != null)
			AccTool.numberField(driver, tab, "@name='ratio4'", param.ratio4);
		if (param.satuan5 != null)
			AccTool.lookup(driver, tab, "@name='unit5'", param.satuan5);		
		if (param.ratio5 != null)
			AccTool.numberField(driver, tab, "@name='ratio5'", param.ratio5);
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
		if (param.upc != null)
			AccTool.textField(driver, tab, "@name='upcNo'", param.upc);
		if (param.cbsubstitusi != null)
			AccTool.checkbox(driver, tab, "@name='substituted'", param.cbsubstitusi);
		if (param.namasubstitusi != null)
			AccTool.lookup(driver, tab, "@name='substitutedItem'", param.namasubstitusi);
		if (param.akunbebanproduksi != null)
			AccTool.lookup(driver, tab, "@name='inventoryGlAccount'", param.akunbebanproduksi);
	}
	
	public static void detailSaldo(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.DetailSaldo");
		String w = "//div[starts-with(@id,'detail-open-balance')]";
		AccTool.click(driver, w);
		
		if (param.cabangsaldo != null)
			AccTool.combobox(driver, w, "@name='branch'", param.cabangsaldo);
		if (param.gudangsaldo != null)
			AccTool.lookup(driver, w, "@name='warehouse'", param.gudangsaldo);
		if (param.tanggalsaldo != null)
			AccTool.datePicker(driver, w, "@name='asOf'", param.tanggalsaldo);
		if (param.kuantitassaldo != null) {
			AccTool.numberField(driver, w, "@name='quantity'", param.kuantitassaldo);
		//	AccTool.click(driver, w);
			//WaitTool.delay(300);
			WaitTool.waitForElementClickable(driver, By.xpath(w), 1);
		}
		if (param.satuansaldo != null)
			AccTool.lookup(driver, w, "@name='itemUnit'", param.satuansaldo);
		if (param.biayasatuan != null) {
			AccTool.numberField(driver, w, "@name='unitCost'", param.biayasatuan);
			AccTool.click(driver, w);
			//WaitTool.delay(300);
			WaitTool.waitForElementClickable(driver, By.xpath(w), 1);
		}
	}
	
	
	public static void detailNoSeri(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.DetailNOSERI");
		
		String tab =  "//div[starts-with(@id,'tab-serial-number')]";
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
		
		if (param.kuantitasnoseri != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.kuantitasnoseri);
		if (param.noseri != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.noseri);
		if (param.tglkadaluarsa != null)
			AccTool.datePicker(driver, tab, "@name='expiredDateSn'", param.tglkadaluarsa);
	}
	
	public static void isiNoSeriBerurutan(WebDriver driver, BarangJasaParam param) {
		log.info("Penerimaan Barang. Isi No Seri Berurutan");
		
		String tab =  "//div[starts-with(@id,'accurate__inventory__input-consecutive-serial-number-dialog')]";
		
		if (param.noseri != null)
			AccTool.textField(driver, tab, "@name='textField'", param.noseri);
		if (param.urut != null)
			AccTool.numberField(driver, tab, "@name='consecutiveCount'", param.urut);
		if (param.stok != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.stok);
		if (param.tglexpired != null)
			AccTool.datePicker(driver, tab, "@name='expiredDate'", param.tglexpired);
	}
	
	public static void saveIsiUmum(WebDriver driver, String filename) {
		log.info("barangjasa.SaveIsiUmum");

		String tab = "//*[contains(@id,'tab-general')]";
		String content = "BarangJasa.SaveIsiUmum : " ;
		WaitTool.waitForElementPresent(driver, By.xpath("//*[contains(@id,'tab-general')]"), 10);
		content = content 
				+ "\r\n"
				//nama Barang
				+ AccTool.getTextValue(driver, "//input[@name='name']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.TEXTFIELD, "name", tab)
				//Kategori Barang
				+ AccTool.getTextValue(driver, "//input[@name='itemCategory']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "itemCategory", tab);		

				//Jenis barang ada 2 kondisi, bisa combobox, bisa disabled
				String jenisbarang = "//*[contains(@id,'tab-general')]//select[@name = 'itemType']";
				if (WebElementTool.isElementExists(driver, By.xpath(jenisbarang))) {
					content = content 
							//Jenis Barang
							+ AccTool.getTextValue(driver, "//select[@name='itemType']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.COMBOBOX, "itemType", tab);
				} else {
					content = content 
							//Jenis Barang
							+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.itemTypeName')]/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.SUMMARY, "text: formData.itemTypeName", tab);
				}
				
				content = content
				//kode barang
				+ AccTool.getTextValue(driver, "//span[contains(@data-bind,'Kode Barang')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.TEXTFIELD, "no", tab);			
						
				String upcBarcode = "//input[@name='upcNo']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]";
				if (WebElementTool.isElementExists(driver, By.xpath(upcBarcode))) {
					content = content 
							//upc/barcode
							+ AccTool.getTextValue(driver, "//*[contains(@id,'upcNoLabel')]/span").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.TEXTFIELD, "upcNo", tab);
				}
				
				content = content
				//satuan text yang di awal
				+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-general')]//*[contains(text(),'Satuan')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "unit1", tab); 
				
				String unit2 = "//input[@name='ratio2']/preceding-sibling::input";
				if (WebElementTool.isElementExists(driver, By.xpath(unit2))) {
					content = content 
							+ "Satuan 2 : "
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "unit2", tab) 
							+ "Rasio 2 : "
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.OTHER, null ,"//input[@name='ratio2']/preceding-sibling::input") 
							+ "Satuan 3 : "
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "unit3", tab) 
							+ "Rasio 3 : "
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.OTHER, null ,"//input[@name='ratio3']/preceding-sibling::input") 
							+ "Satuan 4 : "
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "unit4", tab) 
							+ "Rasio 4 : "
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.OTHER, null ,"//input[@name='ratio4']/preceding-sibling::input") 
							+ "Satuan 5 : "
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "unit5", tab) 
							+ "Rasio 5 : "
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.OTHER, null ,"//input[@name='ratio5']/preceding-sibling::input");
				}
				
				String noSeriProduksi = "//*[contains(@id,'tab-general')]//*[contains(text(),'Seri/Produksi')]";
				if (WebElementTool.isElementExists(driver, By.xpath(noSeriProduksi))) {
					content = content 		
							//aktifkan no seri produksi
							+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-general')]//*[contains(text(),'Seri/Produksi')]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.CHECKBOX, "manageSN", tab);
				}
				
				String noUnik = "//*[contains(@value,'UNIQUE')]";
				if (WebElementTool.isElementExists(driver, By.xpath(noUnik))) {
					content = content 		
							//nomor unik
							+ AccTool.getTextValue(driver, "//input[@value='UNIQUE']/ancestor::label").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "sntype:UNIQUE", tab);
				}
				
				String tglKadaluarsa =  AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "sntype:BATCH", tab);
				String noProduksi = "//input[@value='BATCH']/ancestor::label";
				if (WebElementTool.isElementExists(driver, By.xpath(noProduksi))) {
					content = content 		
							//nomor produksi
							+ AccTool.getTextValue(driver, "//input[@value='BATCH']/ancestor::label").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "sntype:BATCH", tab);
				}
				
				if (tglKadaluarsa.contains("true")) {
					content = content 		
							//tanggal kadaluarsa
							+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-general')]//*[contains(text(),'tanggal kadaluarsa')]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.CHECKBOX, "manageExpired", tab);
				}
				
				content = content	
						+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	
	
	public static void saveIsiJualBeli(WebDriver driver, String filename) {
		log.info("barangjasa.SaveIsiJualBeli");
		String tab = "//*[contains(@id,'tab-sales-purchase')]";
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Penjualan / Pembelian']");
		String content = "BarangJasa.SavePenjualan/Pembelian : " ;
		String HargaJual2 = "//*[contains(@id,'unit2PriceLabel')]";
		String HargaJual3 = "//*[contains(@id,'unit3PriceLabel')]";
		String HargaJual4 = "//*[contains(@id,'unit4PriceLabel')]";
		String HargaJual5 = "//*[contains(@id,'unit5PriceLabel')]";
		String PPNBM = "//*[contains(@id,'tab-sales')]//input[@name='tax2']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]";
		String PPH = "//*[contains(@id,'tab-sales')]//input[@name='tax4']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]";
		String PPHTax3 = "//*[contains(@id,'tab-sales')]//input[@name='tax3']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]";
		String dasarPengenaanPPN = "//*[contains(@id,'tab-sales')]//*[@name='percentTaxable']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]";
		String substitusiDengan = "//input[@name='substitutedItem']/preceding-sibling::ul//span";
		String satuanKontrol = "//input[@name='controlQuantity']/ancestor::label[1]";
		String checkBoxDihitungSatuanGrup = "//input[@name='calculateGroupPrice']/ancestor::label";
		String hargaSatuanGrup = "//*[contains(@id,'calculateGroupPriceLabel')]";
		String menerapkanHargaGrosir = "//*[@class='icn-transaction-header']/preceding-sibling::span";
		
		content = content 
				+ "\r\n"
				//informasi penjualan
				+ AccTool.getTextValue(driver, "//span[.='Informasi Penjualan']")
				//default diskon (%)
				+ AccTool.getTextValue(driver, "//input[@name='defaultDiscount']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.TEXTFIELD, "defaultDiscount", tab);
				//sebelumnya pake garga satuan group diatas
				if(WebElementTool.isElementExists(driver, By.xpath("//label[contains(text(),'Def. Hrg. Jual Satuan #1')]")))
				{
					content = content 
						//Def Harga Jual 1
						+ AccTool.getTextValue(driver, "//label[contains(text(),'Def. Hrg. Jual Satuan #1')]").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.NUMBERFIELD, "unitPrice", tab);		
				} 
//				else {
//					content = content 
//							//Def Harga Jual 1
//							+ AccTool.getTextValue(driver, "//*[contains(@id,'unitPriceLabel')]").replace("\r\n", " : ")
//							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.NUMBERFIELD, "unitPrice", tab);
//				}
		
				if(WebElementTool.isElementExists(driver, By.xpath(checkBoxDihitungSatuanGrup)))
				{
					content = content 
						//checkboxharga diambil dari rincian grup
						+ AccTool.getTextValue(driver, "//input[@name='calculateGroupPrice']/ancestor::label").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.CHECKBOX, "calculateGroupPrice", tab);				
				}
		
				if(WebElementTool.isElementExists(driver, By.xpath("//label[contains(text(),'Def. Hrg. Jual Satuan #2')]")))
				{
					content = content 
						//Def Harga Jual 2
						+ AccTool.getTextValue(driver, "//label[contains(text(),'Def. Hrg. Jual Satuan #2')]").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.NUMBERFIELD, "unit2Price", tab);					
				}
				if(WebElementTool.isElementExists(driver, By.xpath("//label[contains(text(),'Def. Hrg. Jual Satuan #3')]")))
				{
					content = content 
						//Def Harga Jual 3
						+ AccTool.getTextValue(driver, "//label[contains(text(),'Def. Hrg. Jual Satuan #3')]").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.NUMBERFIELD, "unit3Price", tab);		
				}				
				if(WebElementTool.isElementExists(driver, By.xpath("//label[contains(text(),'Def. Hrg. Jual Satuan #4')]")))
				{
					content = content 
						//Def Harga Jual 4
						+ AccTool.getTextValue(driver, "//label[contains(text(),'Def. Hrg. Jual Satuan #4')]").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.NUMBERFIELD, "unit4Price", tab)	;
				}	
				
				if(WebElementTool.isElementExists(driver, By.xpath("//label[contains(text(),'Def. Hrg. Jual Satuan #5')]")))
				{
					content = content 
						//Def Harga Jual 5
						+ AccTool.getTextValue(driver, "//label[contains(text(),'Def. Hrg. Jual Satuan #5')]").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.NUMBERFIELD, "unit5Price", tab);
				}
				
				if(WebElementTool.isElementExists(driver, By.xpath("//span[contains(text(),'Menerapkan Harga')]")))
				{
					content = content 
						///menerapkan harga/diskon grosir
						+ AccTool.getTextValue(driver, "//span[contains(text(),'Menerapkan Harga')]").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.CHECKBOX, "useWholesalePrice", tab);
				}
				
				content = content						
						+ "Substitusi : "
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.CHECKBOX, "substituted", tab);
						
				if(WebElementTool.isElementExists(driver, By.xpath(substitusiDengan)))
				{
					content = content 
							//substitusi dengan
							+ AccTool.getTextValue(driver, "//*[contains(text(),'Substitusi')]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "substitutedItem", tab).replace("\r\n", " ")
							+ "\r\n"
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, "//*[contains(@data-bind,'data.item.name')]")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, "//*[contains(@data-bind,'data.stock')]");					
				}
				
				String informasiPembelian = "//span[.='Informasi Pembelian']";
				if(WebElementTool.isElementExists(driver, By.xpath(informasiPembelian)))
				{
					content = content 			
							//informasi Pembelian
							+ "\r\n"		
							+ AccTool.getTextValue(driver, "//span[.='Informasi Pembelian']")
							//Pemasok Utama
							+ AccTool.getTextValue(driver, "//input[@name='preferedVendor']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "preferedVendor", tab)
							//Satuan Beli
							+ AccTool.getTextValue(driver, "//input[@name='vendorUnit']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "vendorUnit", tab);
							
							if(WebElementTool.isElementExists(driver, By.xpath(satuanKontrol)))
							{
								content = content 
										//satuan kontrol
										+ AccTool.getTextValue(driver, "//input[@name='controlQuantity']/ancestor::label[1]").replace("\r\n", " : ")
										+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.CHECKBOX, "controlQuantity", tab);
							}
							
							content = content 
							//Harga Beli
							+ AccTool.getTextValue(driver, "//input[@name='vendorPrice']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.NUMBERFIELD, "vendorPrice", tab)
							//Minimum Beli
							+ AccTool.getTextValue(driver, "//input[@name='minimumQuantity']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.NUMBERFIELD, "minimumQuantity", tab);
							
							String maksimumStok = "//input[@name='minimumQuantityReorder']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]";
							if (WebElementTool.isElementExists(driver, By.xpath(maksimumStok))) {
								content = content 
										//Batas maksimum stok
										+ AccTool.getTextValue(driver, "//input[@name='minimumQuantityReorder']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
										+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.NUMBERFIELD, "minimumQuantityReorder", tab);
							}					
				}
				
			String pajakPenjualanPembelian = "//*[contains(@id,'tab-sales')]//*[contains(@class,'title-group')]//span[contains(text(),'Pajak')]";	
			if (WebElementTool.isElementExists(driver, By.xpath(pajakPenjualanPembelian))) {
				content = content 
						//Pajak Penjualan dan Pembelian
						+ "\r\n"
						+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-sales')]//*[contains(@class,'title-group')]//span[contains(text(),'Pajak')]")
						//PPN
						+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-sales')]//input[@name='tax1']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "tax1", tab);
						
						if (WebElementTool.isElementExists(driver, By.xpath(PPNBM))) {
							content = content 
									//PPNBM
									+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-sales')]//input[@name='tax2']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
									+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "tax2", tab);
						}
						
						if (WebElementTool.isElementExists(driver, By.xpath(PPHTax3))) {
							content = content 
									//PPH tax3 (exp : pph deviden)
									+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-sales')]//input[@name='tax3']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
									+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "tax3", tab);
						}
						
						if (WebElementTool.isElementExists(driver, By.xpath(PPH))) {
							content = content 
									//PPH
									+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-sales')]//input[@name='tax4']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
									+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "tax4", tab);
						}
						
						if (WebElementTool.isElementExists(driver, By.xpath(dasarPengenaanPPN))) {
							content = content 
									//Dasar Pengenaan PPN(%)
									+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-sales')]//*[@name='percentTaxable']/ancestor::div[@class='row no-margin']/div/label[contains(@class,'indent')]").replace("\r\n", " : ")
									+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.COMBOBOX, "percentTaxable", tab);
						}
				}		
				
				content = content 
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiSaldo(WebDriver driver, String filename) {
		log.info("barangjasa.SaveIsiSaldo");
		String tab = "//*[contains(@id,'tab-stock')]";
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[contains(@href,'tab-stock')]");
		String content = "BarangJasa.saveStok : " + "\r\n";
		String i = AccurateModule.BARANG_JASA.getXpath() + "//div[text()='Belum ada data']";
		String multiSatuan = "//div[contains(@data-bind,'formData.balanceInUnit')]";
		boolean exists = driver.findElements(By.xpath(i)).size() > 0;

		if (exists) {
			content = content 
					+ AccTool.getTextValue(driver, "//b[text()='Stok Awal']")
					+ "\r\n" 
					+ AccTool.getTextValue(driver, "//div[text()='Belum ada data']")
					+ "\r\n"
					//kuantitas
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'app.util.parseNumber(formData.balance())')]/ancestor::div[2]//label[contains(text(),'Kuantitas')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.SUMMARY, "balance()") ;
					
					if (WebElementTool.isElementExists(driver, By.xpath(multiSatuan))) {
						content = content 
								//Nilai Satuan multi
								+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.balanceInUnit')]/ancestor::div[2]//label[contains(@data-bind,'formData.unit1().name')]").replace("\r\n", " : ")					
								+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.balanceInUnit')]");
					}
			
					content = content
					//Nilai Satuan
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'formData.balanceUnitCost')]/ancestor::div[2]//label").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.SUMMARY, "balanceUnitCost()")
					//Beban pokok
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'formData.balanceTotalCost')]/ancestor::div[2]//label").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.SUMMARY, "balanceTotalCost()") + "\r\n";
			AccTool.writeTextFile(filename, content);

		} else {
			content = content 
					+ AccTool.getTextValue(driver, "//b[text()='Stok Awal']")
					+ "\r\n" 
					+ AccTool.getGridValue(driver, AccurateModule.BARANG_JASA, tab)
					+ "\r\n" 
					//kuantitas
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'app.util.parseNumber(formData.balance())')]/ancestor::div[2]//label[contains(text(),'Kuantitas')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.SUMMARY, "balance()") ;
					
					if (WebElementTool.isElementExists(driver, By.xpath(multiSatuan))) {
						content = content 
								//Nilai Satuan multi
								+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.balanceInUnit')]/ancestor::div[2]//label[contains(@data-bind,'formData.unit1().name')]").replace("\r\n", " : ")					
								+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.balanceInUnit')]");
					}
					
					content = content
					//Nilai Satuan
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'formData.balanceUnitCost')]/ancestor::div[2]//label").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.SUMMARY, "balanceUnitCost()")
					//Beban pokok
					+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'formData.balanceTotalCost')]/ancestor::div[2]//label").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.SUMMARY, "balanceTotalCost()")+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}
	}

	public static void saveDetailSaldo(WebDriver driver, String filename) {
		log.info("BarangJasa.SaveDetailSaldo");
		
		String tab = "//*[starts-with(@id,'tab-opening-balance')]";
		String content = "BarangJasa.SaveDetailSaldo : " + "\r\n";
//		WaitTool.delay(500); 
		WaitTool.waitForElementVisible(driver, By.xpath(tab), 5);
		
		//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
		String namacabang = "//*[starts-with(@id,'tab-opening-balance')]//select[@name = 'branch']";
		if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-opening-balance')]//*[@name='branch']/ancestor::div[@class='row no-margin']//label").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, ElementType.COMBOBOX, "branch", tab);
		} else {
			content = content 
					+ AccTool.getTextValue(driver, "//label[text()='Cabang']").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver,  ElementType.SUMMARY, "branchListOption",tab);
		}
		
		content = content 
				//gudang
				+ AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-opening-balance')]//*[@for='warehouse']").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-opening-balance')]//div[contains(@data-bind,'warehouse')]")
				//tanggal
				+ AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-opening-balance')]//*[@for='asOf']").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, ElementType.DATEPICKER, "asOf", tab) 
				//kuantitas
				+ AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-opening-balance')]//*[@for='quantity']").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab) 
				//satuan
				+ AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-opening-balance')]//input[@name='itemUnit']/ancestor::div[@class='row no-margin']/div/label").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
				//biaya satuan
				+ AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-opening-balance')]//*[@for='unitCost']").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitCost", tab)
				//total biaya
				+ AccTool.getTextValue(driver, "//label[text()='Total Biaya']").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver,  "//span[contains(@data-bind,'acc.staticData.defaultCurrency().symbol')]").replace("\r\n", ". ")
				+ AccTool.getTextValue(driver,  "//span[contains(@data-bind,'app.util.parseNumber(formData.totalCost())')]");
				
				content = content
						+ "\r\n";
				
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiLain(WebDriver driver, String filename) {
		log.info("barangjasa.SaveIsiLain");
		String tab = "//*[contains(@id,'tab-miscellaneous')]";
		String content = "BarangJasa.SaveLain-lain : ";
		AccTool.click(driver, "//*[contains(@data-bind,'tab-miscellaneous')]");
		
		content = content 
				+ "\r\n"
				//InfoLainnya
				+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-miscellaneous')]//*[contains(text(),'Lainnya')]");
		//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
		String namacabang = "//*[contains(@id,'tab-miscellaneous')]//select[@name = 'branch']";
		if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
				content = content 
					//dipakai di cabang
					+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-miscellaneous')]//*[contains(text(),'Dipakai')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.COMBOBOX, "branch", tab);
				} else {
				content = content 
					//dipakai di cabang
					+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-miscellaneous')]//*[contains(text(),'Dipakai')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.SUMMARY, "branchListOption", tab);
					}
		
		content = content 
				//catatan
				+ AccTool.getTextValue(driver, "//*[contains(@id,'notesLabel')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.TEXTAREA, "notes", tab)
				//nonaktif
				+ AccTool.getTextValue(driver, "//*[contains(@id,'suspendedLabel')]").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.CHECKBOX, "suspended", tab)
				+ "\r\n";
		
		String dimensi = "//*[contains(@id,'tab-miscellaneous')]//*[contains(text(),'Dimensi')]";
		if (WebElementTool.isElementExists(driver, By.xpath(dimensi))) {
				content = content 
					//Dimensi & Berat	
					+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-miscellaneous')]//*[contains(text(),'Dimensi')]")
					//panjang
					+ AccTool.getTextValue(driver, "//*[contains(@id,'dimDepthLabel')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.TEXTAREA, "dimDepth", tab)
					//Lebar
					+ AccTool.getTextValue(driver, "//*[contains(@id,'dimWidthLabel')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.TEXTAREA, "dimWidth", tab)
					//Tinggi
					+ AccTool.getTextValue(driver, "//*[contains(@id,'dimHeightLabel')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.TEXTAREA, "dimHeight", tab)	
					//Tinggi
					+ AccTool.getTextValue(driver, "//*[contains(@id,'weightLabel')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.TEXTAREA, "weight", tab);
			} 						
				
			content = content  
				+ "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	// barang jenis persediaan
	public static void saveIsiAkun(WebDriver driver, String filename) {
		log.info("barangjasa.SaveIsiAkun");
		String path = "//*[contains(@data-bind,'tab-glaccount')]";
		AccTool.click(driver, path);
		String tab = "//*[contains(@id,'tab-glaccount')]";
		String persediaan = "//input[@name='inventoryGlAccount']/ancestor::div[@class='row no-margin']/div/label";
		String penjualan = "//input[@name='salesGlAccount']/ancestor::div[@class='row no-margin']/div/label";
		String returPenjualan = "//input[@name='salesRetGlAccount']/ancestor::div[@class='row no-margin']/div/label";
		String diskonPenjualan = "//input[@name='salesDiscountGlAccount']/ancestor::div[@class='row no-margin']/div/label";
		String barangTerkirim = "//input[@name='goodTransitGlAccount']/ancestor::div[@class='row no-margin']/div/label";
		String hargaPokokPenjualan = "//input[@name='cogsGlAccount']/ancestor::div[@class='row no-margin']/div/label";
		String returPembelian = "//input[@name='purchaseRetGlAccount']/ancestor::div[@class='row no-margin']/div/label";
		String pembelianBelumTertagih  = "//input[@name='unBilledGlAccount']/ancestor::div[@class='row no-margin']/div/label";
		
		String content = "BarangJasa.SaveAkun : ";
		content = content 
				+ "\r\n";
				
				if (WebElementTool.isElementExists(driver, By.xpath(persediaan))) {
				content = content 
					//persediaan
					+ AccTool.getTextValue(driver, "//input[@name='inventoryGlAccount']/ancestor::div[@class='row no-margin']/div/label").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "inventoryGlAccount", tab);
				}
				
				if (WebElementTool.isElementExists(driver, By.xpath(penjualan))) {
				content = content 
						//penjualan
						+ AccTool.getTextValue(driver, "//input[@name='salesGlAccount']/ancestor::div[@class='row no-margin']/div/label").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "salesGlAccount", tab);
				}
				
				if (WebElementTool.isElementExists(driver, By.xpath(returPenjualan))) {
					content = content 
						//retur Penjualan
						+ AccTool.getTextValue(driver, "//input[@name='salesRetGlAccount']/ancestor::div[@class='row no-margin']/div/label").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "salesRetGlAccount", tab);
				}
				
				if (WebElementTool.isElementExists(driver, By.xpath(diskonPenjualan))) {
					content = content 
						//diskon penjualan
						+ AccTool.getTextValue(driver, "//input[@name='salesDiscountGlAccount']/ancestor::div[@class='row no-margin']/div/label").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "salesDiscountGlAccount", tab);
				}
				
				if (WebElementTool.isElementExists(driver, By.xpath(barangTerkirim))) {
					content = content 
						//Barang Terkirim
						+ AccTool.getTextValue(driver, "//input[@name='goodTransitGlAccount']/ancestor::div[@class='row no-margin']/div/label").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "goodTransitGlAccount", tab);
				}
				
				if (WebElementTool.isElementExists(driver, By.xpath(hargaPokokPenjualan))) {
					content = content 
						//Harga Pokok Penjualan
						+ AccTool.getTextValue(driver, "//input[@name='cogsGlAccount']/ancestor::div[@class='row no-margin']/div/label").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "cogsGlAccount", tab);
				}
				
				if (WebElementTool.isElementExists(driver, By.xpath(returPembelian))) {
					content = content 
						//Retur Pembelian
						+ AccTool.getTextValue(driver, "//input[@name='purchaseRetGlAccount']/ancestor::div[@class='row no-margin']/div/label").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "purchaseRetGlAccount", tab);
				}
				
				if (WebElementTool.isElementExists(driver, By.xpath(pembelianBelumTertagih))) {
					content = content 
							//Pembelian Belum Tertagih 
							+ AccTool.getTextValue(driver, "//input[@name='unBilledGlAccount']/ancestor::div[@class='row no-margin']/div/label").replace("\r\n", " : ")
							+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.LOOKUP, "unBilledGlAccount", tab);
				}
				
				content = content 
				+ "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	public static void SaveListMutasi(WebDriver driver, String filename) {
		log.info("BarangJasaMutasi.SaveList");

		String content = "BarangJasa.SaveMutasiBarang : " + "\r\n";
		String tab = "//*[contains(@id,'tab-history')]";
		content = content 
				+ "\r\n"
				+ "Dari Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.DATEPICKER, "fromDate", tab)
				+ "Sampai Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.DATEPICKER, "toDate", tab)
				+ "\r\n" 
				+ "Detail : " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.BARANG_JASA, tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);

	}
	
	
	public static void SaveListGudang(WebDriver driver, String filename) {
		log.info("BarangJasaMutasi.SaveListGudang");

		String content = "BarangJasa.SaveListGudang : " + "\r\n";
		String tab = "//*[contains(@id,'tab-warehouse')]";
		content = content 
				+ "\r\n"
				+ "Per Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.DATEPICKER, "asOfDate", tab)
				+  "Detail : " 
				+ "\r\n" + AccTool.getGridValue(driver, AccurateModule.BARANG_JASA, tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);

	}
	
	public static void SaveIsiRincianGrup(WebDriver driver, String filename) {
		log.info("BarangJasaRincianGrup.SaveList");
		
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[text()='Rincian Grup']");
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-itemgroup')]");

		String content = "BarangJasa.SaveIsiRincianGrup : " ;
		String tab = "//*[contains(@id,'tab-itemgroup')]";
		content = content
				+ "\r\n" 
				//tampilan rincian saat dicetak
				+ AccTool.getTextValue(driver, "//input[@name='printDetailGroup']/ancestor::label").replace("\r\n", " : ")
				+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.CHECKBOX, "printDetailGroup", tab)
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.BARANG_JASA, tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
		
	}
		
	
	public static void SaveisiSerialNumber(WebDriver driver, String filename) {
			log.info("BarangJasaSerialNumber.SaveList");
			String i = AccurateModule.BARANG_JASA.getXpath() + "//div[contains(@id, 'tab-serialnumber')]//div[text()='Belum ada data']";
			String content = "SerialNumberBarang/Jasa : " + "\r\n";
			
			boolean exists = driver.findElements(By.xpath(i)).size() > 0;

			if (exists) {
				content = content + "No Seri / Produksi   : " + "\r\n" + "NULL" 
				+ "\r\n"
				+ "\r\n";
				AccTool.writeTextFile(filename, content);
		
			} else {
				
			String tab = "//div[contains(@id, 'tab-serialnumber')]";
			content = content
					+ "Per tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.BARANG_JASA, ElementType.DATEPICKER, "snAsOf", tab)
					+ "\r\n" 
					+ "Detail : " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, tab)
					+ "\r\n";

			AccTool.writeTextFile(filename, content);

		}
	}
	
	public static void saveIsiDetailSN(WebDriver driver, String filename) {
		log.info("BarangJasaSerialNumber.saveIsiDetailSN");

		String grid = "";
		String content = "Barang Jasa.saveIsiDetailSN  : " + "\r\n" ;	
		String i = AccurateModule.BARANG_JASA.getXpath() + "//div[contains(@id, 'tab-serial-number')]//div[text()='Belum ada data']";
		
		boolean exists = driver.findElements(By.xpath(i)).size() > 0;

		if (exists) {
			content = content 
			+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'tab-serial-number')]").replace("\r\n", ": ")
			+ AccTool.getTextValue(driver, "//div[contains(@id, 'tab-serial-number')]//div[text()='Belum ada data']");	
		} else {	
			grid = "//div[contains(@id, 'tab-serial-number')]";
			content = content
				+ "\r\n"
				+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'tab-serial-number')]").replace("\r\n", ": ")
				+ "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n";		
		}
		
		content = content
				+ "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	public static void saveIsiPopup(WebDriver driver, String fileName)
	{
		log.info("Save isi popup ");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	String content = "BarangJasa.Warning : " + "\r\n";
	content = content
			+ "Notifikasi"
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
	AccTool.writeTextFile(fileName, content);
	}


	public static void saveDetailNoSeriBerurutan(WebDriver driver,  String filename)
	{
		log.info("PenerimaanBarang.SaveDetailNoSeriBerurutan");
		
		String tab = "";
		String content = "Nomor Seri Berurutan  : " + "\r\n";

		tab = "//div[contains(@id, 'tab-serial-number')]";
		content = content
				+ "\r\n" 
				+ "No Seri/Produksi : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "textField", tab)
				+ "Diurutkan berulang sebanyak : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "consecutiveCount", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveList(WebDriver driver, String filename) {
		log.info("BarangJasa.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "BarangJasa.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.BARANG_JASA, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void pengaturanKolomList(WebDriver driver, String kolom, boolean checked) {
		String xpathModulBarangJasa = "//div[@id='module-accurate__inventory__item']";
		String buttonKolomSetting = "//button[@name='btnColumnSetting']";
		String xpathKolom = xpathModulBarangJasa + buttonKolomSetting + "/following-sibling::ul//label[span[text()='" + kolom + "']]";
			
		AccTool.click(driver, xpathModulBarangJasa + buttonKolomSetting);
		
		WebElement element = driver.findElement(By.xpath(xpathKolom + "/input"));
		WaitTool.waitForElementClickable(driver, By.xpath(xpathKolom),1);
				
		if (checked) {
			if (!element.isSelected()) {
				AccTool.click(driver, xpathKolom + "/span[1]");
			}			
		} else {
			if (element.isSelected()) {
				AccTool.click(driver, xpathKolom + "/span[1]");
			}
		}
		
		AccTool.click(driver, xpathModulBarangJasa + "//div[contains(@data-bind, 'getListRowCount()')]");
		//harus ada delay supaya scroll bar nya tidak hilang
		WaitTool.delay(500);		
	}
	
	public static void clickAktifkanNoSeri(WebDriver driver) {
		AccTool.click(driver, "//input[@name='manageSN']/following-sibling::span");
	}
	
	public static void clickTanggalKadaluarsa(WebDriver driver) {
		AccTool.click(driver, "//input[@name='manageExpired']/following-sibling::span");
	}

	public static void clickNomorProduksi(WebDriver driver) {
		AccTool.click(driver, "//input[@value='BATCH']/following-sibling::span");
	}
	
	//-----------------------------------------------------------------------------TAB VARAIAN-----------------------------------------------------------------------------//
	
	public static void klikTabVarian(WebDriver driver) {
		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//div[contains(@id,'tab-widget')]//a[contains(@data-bind,'tab-variant')]");
	}
	
	public static void isiVarian(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.isiVarian");

		String tab = "//div[starts-with(@id,'tab-widget')]//div[starts-with(@id,'tab-variant')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//div[contains(@id,'tab-widget')]//a[contains(@data-bind,'tab-variant')]");
		//AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-general')]");

		if (param.varian1 != null)
			AccTool.textField(driver, tab, "@name='variantLabel1'", param.varian1);
		if (param.varian2 != null)
			AccTool.textField(driver, tab, "@name='variantLabel2'", param.varian2);
		if (param.barangvarian != null)
			AccTool.lookup(driver, tab, "@name='unit3'", param.barangvarian);
	}
	
	public static void klikTambahOtomatisVarian(WebDriver diver){
		AccTool.click(getWebDriver(), "//*[contains(@name,'btnAddAutoVariant')]");
	}
	
	public static void klikUpdateVarian(WebDriver diver){
		AccTool.click(getWebDriver(), "//*[contains(@name,'btnUpdateName')]");
	}
	
	public static void isiDetailVarian(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.isiVarian");

		String tab = "//div[starts-with(@id,'detail-auto-variant')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//div[contains(@id,'tab-widget')]//a[contains(@data-bind,'tab-variant')]");
		//AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-general')]");
		
		if (param.namabarangdetailvarian != null)
			AccTool.textField(driver, tab, "@name='itemName'", param.namabarangdetailvarian);
		if (param.variandetail1 != null)
			AccTool.textField(driver, tab, "@name='variantDetail1'", param.variandetail1);
		if (param.variandetail2 != null)
			AccTool.textField(driver, tab, "@name='variantDetail2'", param.variandetail2);
		if (param.hargajualvarian != null)
			AccTool.numberField(driver, tab, "@name='unitPriceVariant'", param.hargajualvarian);
	}
	
	public static void klikLanjutDetailVarian(WebDriver diver){
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-variant')]//*[contains(@name,'btnNext')]");
	}
	
	public static void saveListDetailBarangVarian(WebDriver driver, String filename) {
		log.info("BarangJasa.saveListDetailBarangVarian");

		String content = "BarangJasa.saveListDetailBarangVarian : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-widget')]//div[starts-with(@id,'tab-variant')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.BARANG_JASA, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	//-----------------------------------------------------------------------------TAB Modifier-----------------------------------------------------------------------------//
	
	public static void isiModifier(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.isiModifier");

		String tab = "//div[starts-with(@id,'tab-itemgroupmodifier')]";

		AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//a[contains(@href,'tab-itemgroupmodifier')]");
		//AccTool.click(driver, AccurateModule.BARANG_JASA.getXpath() + "//*[contains(@href,'tab-general')]");
		
		if (param.barangmodifier != null)
			AccTool.lookup(driver, tab, "@name='unit3'", param.barangmodifier);
		if (param.cbhargajualmodifier != null)
			AccTool.checkbox(driver, tab, "@name= 'additionalCost'", param.cbhargajualmodifier);
		if (param.minpilihanmodifier != null)
			AccTool.numberField(driver, tab, "@name='minOptionModifier'", param.minpilihanmodifier);
		if (param.maxpilihanmodifier != null)
			AccTool.numberField(driver, tab, "@name='maxOptionModifier'", param.maxpilihanmodifier);
	}
	
	public static void isiDetailModifier(WebDriver driver, BarangJasaParam param) {
		log.info("BarangJasa.isiDetailModifier");

		String tab = "//div[@class='content']/div[starts-with(@id,'detail-group-modifier')]";

		if (param.namabarangmodifier != null)
			AccTool.textField(driver, tab, "@name='variantLabel1'", param.namabarangmodifier);
		if (param.kuantitasmodifier != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitasmodifier);
	}
	
	public static void klikLanjutRincianModifier(WebDriver diver){
		AccTool.click(getWebDriver(), "//div[@class='content']/div[starts-with(@id,'detail-group-modifier')]//*[contains(@name,'btnNext')]");
	}
	
	public static void saveListDetailBarangModifier(WebDriver driver, String filename) {
		log.info("BarangJasa.saveListDetailBarangModifier");

		String content = "BarangJasa.saveListDetailBarangModifier : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-itemgroupmodifier')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.BARANG_JASA, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
}
