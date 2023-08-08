package com.cpssoft.web.test.accurate.tool;

import java.util.NoSuchElementException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.accuratepos.PengaturanPOSParam;
import com.cpssoft.web.test.accurate.cabang.CabangParam;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.penomoran.PenomoranParam;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PengaturanPOSTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PengaturanPOSTool.class);

	public static void klikUbahPengaturanPOS(WebDriver driver) {
		AccTool.click(getWebDriver(),"//button[contains(text(),'Ubah pengaturan POS')]");
		WaitTool.delay(1000);
	}
	
	public static void isiInfoUtama(WebDriver driver, PengaturanPOSParam param) {
		log.info("PengaturanPOS.IsiInfoUtama");

		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-header')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-header')]");
		log.info("Klik Tab Utama");
		
		if (param.cabangpos != null)
			AccTool.combobox(driver, w, "@name='branch'", param.cabangpos);
		if (param.akunpembayaran != null)
			AccTool.lookup(driver, tab, "@name='cashAccount'", param.akunpembayaran);
		if (param.tipepembulatan != null)
			AccTool.combobox(driver, w, "@name='roundingUp'", param.tipepembulatan);
		if (param.satuanpembulatan != null)
			AccTool.combobox(driver, w, "@name='posRoundingType'", param.satuanpembulatan);
		if (param.akunpembulatan != null)
			AccTool.lookup(driver, tab, "@name='roundingAccount'", param.akunpembulatan);
		if (param.kategoribarang != null)
			AccTool.combobox(driver, w, "@name='allItemCategory'", param.kategoribarang);
		if (param.gudangstok != null)
			AccTool.lookup(driver, tab, "@name='warehouse'", param.gudangstok);
		if (param.akunpencatatanselisih != null)
			AccTool.lookup(driver, tab, "@name='diffAccount'", param.akunpencatatanselisih);
		if (param.cbpajak != null)
			AccTool.checkbox(driver, tab, "@name='memberDefaultIncTax'", param.cbpajak);
		if (param.cbsimpanpesanan != null)
			AccTool.checkbox(driver, tab, "@name='savingTransaction'", param.cbsimpanpesanan);	
		if (param.cbubahharga != null)
			AccTool.checkbox(driver, w, "@data-bind='formData.changingPrice'", param.cbubahharga);
		if (param.cbdiskonbarang_transaksi != null)
			AccTool.checkbox(driver, w, "@data-bind='formData.manualDiscount'", param.cbdiskonbarang_transaksi);
		if (param.cbtipepenjualan != null)
			AccTool.checkbox(driver, w, "@name='useSalesType'", param.cbtipepenjualan);
	}
	
	public static void isiInfoLainnya(WebDriver driver, PengaturanPOSParam param) {
		log.info("PengaturanPOS.isiinfolainnya");

		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		if (param.tipeservicecharge != null)
			AccTool.combobox(driver, w, "@name='posServiceChargeType'", param.tipeservicecharge);
		if (param.nilai != null)
			AccTool.numberField(driver, w, "@name='serviceChargeAmount'", param.nilai);
		if (param.akunservicecharge != null)
			AccTool.lookup(driver, w, "@name='searchDetailItem'", param.akunservicecharge);
		if (param.kategoriharga != null)
			AccTool.lookup(driver, tab, "@name='memberPriceCategoryList'", param.kategoriharga);
		if (param.katerogidiskon != null)
			AccTool.lookup(driver, tab, "@name='memberDiscountCategoryList'", param.katerogidiskon);
		if (param.gudang != null)
			AccTool.lookup(driver, tab, "@name='warehouseViewStockList'", param.gudang);
		if (param.pembatasanstock != null)
			AccTool.combobox(driver, tab, "@name='stockLimitatingType'", param.pembatasanstock);
	}
	
	public static void isiAkunDanPembayaranNonTunai(WebDriver driver) {
		log.info("PengaturanPOS.akunnontunai");

		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-payment-type')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-payment-type')]");
		
		String path = "//*[@name='btnAddPosSettingPaymentType']";
		AccTool.click(getWebDriver(), path);
	}

		
	public static void detailNonTunai(WebDriver driver, PengaturanPOSParam param) {
			log.info("PengaturanPOS.detailnontunai");
			
			String w = "//div[@class='metro window-overlay']";
			String tab = w + "//*[contains(@id,'detail-payment-type')]";
			
		if (param.tipepembayaran != null)
			AccTool.combobox(driver, tab, "@name='paymentType'", param.tipepembayaran);
		if (param.namabank != null)
			AccTool.textField(driver, tab, "@name='name'", param.namabank);
		if (param.akunbank != null)
			AccTool.lookup(driver, tab, "@name='bankAccount'", param.akunbank);
	}
	
	public static void klikBtnLanjutRincianAkunDanPembayaran(WebDriver driver)
		{
			String path = "//*[contains(@id,'detail-payment-type')]//*[@name='btnNext']";
			AccTool.click(getWebDriver(), path);
			WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		}
		
		
		
	public static void akunPembayaranEdit(WebDriver driver, PengaturanPOSParam param) {
		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-payment-type')]";
		if (param.namabank != null)
			AccTool.textField(driver, tab, "@name='name'", param.namabank);
		if (param.akunbank != null)
			AccTool.lookup(driver, tab, "@name='bankAccount'", param.akunbank);
//		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PENGATURAN_POS, "General Sales Invoice");
	}
	
	public static void klikTabKaryawanDanHak(WebDriver driver) {
		log.info("PengaturanPOS.klikTabKaryawanDanHak");

		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-employee-privilege')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-employee-privilege')]");
	}
	
	public static void klikButtonTambahPeran(WebDriver driver) {
		log.info("PengaturanPOS.klikButtonTambahPeran");
		
		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-employee-privilege')]";
		String xpath = "//button[@name='btnAddEmployeeRole']";
		
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(xpath), 10);
		AccTool.click(driver, tab + xpath);
	}
	
	
	public static void isiKaryawan(WebDriver driver, PengaturanPOSParam param) {
		log.info("PengaturanPOS.karyawan");

		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-employee-privilege')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-employee-privilege')]");
		
		if (param.namakaryawan != null)
			AccTool.lookup(driver, tab, "@name='searchDetailEmployee'", param.namakaryawan);
		
		
	}
	
	public static void detailKaryawan(WebDriver driver, PengaturanPOSParam param) {
		log.info("PengaturanPOS.detailkaryawan");

		String w = "//div[@class='metro window-overlay']";
		String tab = w + "//*[contains(@id,'detail-employee-role')]";
		
		if (param.cbtenagapenjual != null)
			AccTool.checkbox(driver, tab, "@name='salesman'", param.cbtenagapenjual);
		if (param.pilihhakakses != null)
			AccTool.lookup(driver, tab, "@name='posEmployeeRole'", param.pilihhakakses);
	}
	
	
	public static void klikBtnLanjutRincianKaryawanDanHak(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-employee-role')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikHapusPilihanHakAkses(WebDriver driver)
	{
		String path = "//div[contains(@class,'metro window-overlay')]//button[contains(@class,'button mini info')]";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTutupPopupKaryawanDanHak(WebDriver driver)
	{
		String path = "//div[contains(@class,'metro window-overlay')][contains(@style,'z-index')]//button[contains(@class,'btn-close')]";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	
	public static void peranKaryawanPOS(WebDriver driver, PengaturanPOSParam param) {
		log.info("PengaturanPOS.Peran");

		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-employee-privilege')]";

		AccTool.click(driver, w + "//a[contains(@name,'btnAddEmployeeRole')]");
//		WaitTool.waitForElementVisible(driver, By.xpath("//div[contains(@id,'detail-payment-type')]"), 10);
		AccTool.waitLoadingMask(driver);
		if (param.peran != null)
			AccTool.textField(driver, tab, "@name='name'", param.peran);
		if (param.cbdaftarpelanggan != null)
			AccTool.checkbox(driver, tab, "@name='allowCreateCustomer'", param.cbdaftarpelanggan);
		if (param.cbubahhargajual != null)
			AccTool.checkbox(driver, tab, "@name='allowEditPrice'", param.cbubahhargajual);
		if (param.cblihatstokbarang != null)
			AccTool.checkbox(driver, tab, "@name='allowViewStock'", param.cblihatstokbarang);
		if (param.cblihatriwayattransaksi != null)
			AccTool.checkbox(driver, tab, "@name='allowViewTransactionHistory'", param.cblihatriwayattransaksi);
		if (param.cblihatlaporan != null)
			AccTool.checkbox(driver, tab, "@name='allowViewReport'", param.cblihatlaporan);
		if (param.cbmengelolakaryawan != null)
			AccTool.checkbox(driver, tab, "@name='allowSupervisor'", param.cbmengelolakaryawan);
	}
	
	public static void editPeranKaryawanPOS(WebDriver driver, PengaturanPOSParam param) {
		log.info("PengaturanPOS.IsiInfoUtama");

		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-detailemployee')]";

		if (param.hakakses != null)
			AccTool.lookup(driver, tab, "@name='posEmployeeRole'", param.hakakses);
	}
	
	public static void klikTutupPopUpQRCode(WebDriver driver)
	{
		String path = "//div[@class='mask-wrapper']/div[13]//button[@class='btn-close']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnHapusRincianAkunDanPembayaran(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-payment-type')]//*[@name='btnDelete']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTabAkunDanPembayaran(WebDriver driver)
	{
		String path = "//i[@class='acc-icon-pos-setting-payment']";
		AccTool.click(getWebDriver(), path);
	}
	
	public static void pilihListPembayaranNonTunai(WebDriver driver, String name)
	{
		String path = "//div[.='" + name + "']";
		AccTool.click(getWebDriver(), path);

	}

	public static void saveListDaftarKaryawanPOS(WebDriver driver, String filename) {
		log.info("PengaturanPOSTool.saveListDaftarKaryawanPOS");

		String tab = "";
		String content = "PengaturanPOSTool.saveListDaftarKaryawanPOS : " + "\r\n";
		tab = "//*[contains(@id,'tab-employee-privilege')]";
		content = content  
				+ AccTool.getGridValue(driver, AccurateModule.PENGATURAN_POS, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveFormKaryawan(WebDriver driver, String filename) {
		log.info("PengaturanPOS.saveFormKaryawan");

		String tab = "//*[contains(@id,'tab-detailemployee')]";
		String content = "PengaturanPOS.saveFormKaryawan" + "\r\n";
		content = content 
				+ "\r\n"
				+ "Nama : "
				+ AccTool.getTextValue(driver, null, ElementType.DIV, "employeeName", tab)
				+ "Tenaga Penjual : "
				+ AccTool.getTextValue(driver, null, ElementType.DATEPICKER, "salesman", tab)
				+ "Hak Akses :"
				+ AccTool.getTextValue(driver, null, ElementType.SPAN, "text: name", tab)
				+ AccTool.getTextValue(driver, null, ElementType.DATEPICKER, "posEmployeeRole", tab);
				
		AccTool.writeTextFile(filename, content);
		
				}
	
	public static void klikTuTupFormKaryawanPOS(WebDriver driver) {
		String path = "//*[text()='Rincian Karyawan & Hak']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikPutuskanPerangkat(WebDriver driver) {
		String path = "//*[contains(@id,'accurate__company__pos-setting-qrcode')]//button[contains(@class, 'text-bold button')]";
		WaitTool.waitForElementPresent(driver, By.xpath(path), 10);
		AccTool.click(driver, path);
//		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
		
	
	
	public static String getQRCode(WebDriver driver) {
		
		String xpath = "//*[contains(@id,'accurate__company__pos-setting-qrcode')]//p[contains(@data-bind, 'formData.qrcode')]";
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(xpath), 20);
		
		String QR = AccTool.getTextValue(driver, xpath);
        String QRCode = QR.substring(0,6);
		
        log.info(QRCode);
		return QRCode;
		
	}
	
	
	public static void isiDesainStruk(WebDriver driver, PengaturanPOSParam param) {
		log.info("PengaturanPOS.isiDesainStruk");

		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-receipt-design')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-receipt-design')]");
		log.info("Klik Tab Desain Struk");
		
		if (param.namaoutlet != null)
			AccTool.textField(driver, w, "@name='receiptOutletName'", param.cabangpos);
		if (param.cbheader != null)
			AccTool.checkbox(driver, tab, "@name='useReceiptHeader'", param.cbheader);
		if (param.header != null)
			AccTool.textField(driver, w, "@name='receiptHeader'", param.header);
		if (param.cbfooter != null)
			AccTool.checkbox(driver, w, "@name='useReceiptFooter'", param.cbfooter);
		if (param.footer != null)
			AccTool.textField(driver, tab, "@name='receiptFooter'", param.footer);
		if (param.cbwhatsapp != null)
			AccTool.checkbox(driver, w, "@name='useReceiptWhatsapp'", param.cbwhatsapp);
		if (param.whatsapp != null)
			AccTool.textField(driver, tab, "@name='receiptWhatsapp'", param.whatsapp);
		if (param.cbinstagram != null)
			AccTool.checkbox(driver, tab, "@name='useReceiptInstagram'", param.cbinstagram);
		if (param.instagram != null)
			AccTool.textField(driver, tab, "@name='receiptInstagram'", param.instagram);
		if (param.cbfacebook != null)
			AccTool.checkbox(driver, tab, "@name='useReceiptFacebook'", param.cbfacebook);	
		if (param.facebook != null)
			AccTool.textField(driver, w, "@name='receiptFacebook'", param.facebook);
		if (param.cbwebsite != null)
			AccTool.checkbox(driver, w, "@name='useReceiptWebsite'", param.cbwebsite);
		if (param.website != null)
			AccTool.textField(driver, w, "@name='receiptWebsite'", param.website);
		if (param.cbOtomatisCetakStruk != null)
			AccTool.checkbox(driver, w, "@name='autoPrintReceipt'", param.cbOtomatisCetakStruk);
		if (param.cbOtomatisCetakKodeQR != null)
			AccTool.checkbox(driver, w, "@name='autoPrintQris'", param.cbOtomatisCetakKodeQR);
		
		}
	
	public static void isiPenomoran(WebDriver driver, PengaturanPOSParam param) {
		log.info("Penomoran.Isi");

		String w = AccurateModule.PENGATURAN_POS.getXpath();
//		String tab = w + "//ul[contains(@class,'tabs')]";		
		
		AccTool.click(driver, w + "//*[contains(@href,'tab-auto-number')]");
		
		if (param.tipepenomoran != null)
			AccTool.combobox(driver, w, "@name='autoNumberType'", param.tipepenomoran);
		if (param.jumlahdigit != null)
			AccTool.numberField(driver, w, "@name='autoNumberCounterDigit'", param.jumlahdigit);
		if (param.komponenpenomoran != null)
			AccTool.combobox(driver, w, "@name='autoNumberOpt'", param.komponenpenomoran);
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='autoNumberComponentList'", param.penomoran);
		
		}	
	
	//--tipe penjualan
	public static void isiTipePenjualan(WebDriver driver, PengaturanPOSParam param) {
		
		log.info("PengaturanPOS.isiTipePenjualan");
		String w = AccurateModule.PENGATURAN_POS.getXpath();
		String tab = w + "//*[contains(@id,'tab-sales-type'')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-sales-type')]");
		log.info("Isi Tipe Penjualan");
		
		if (param.tipepenjualan != null)
			AccTool.lookup(driver, tab, "@name='searchDetailSalesType'", param.tipepenjualan);
		
		log.info("Berhasil Cari Tipe Penjualan : " + param.tipepenjualan);
		
		}
	
	public static void klikTambahTipePenjualan(WebDriver driver) {
		
		log.info("PengaturanPOS.KlikTambahTipePenjualan");
		
		String path = "//*[@name='btnAddSalesType']";
		AccTool.click(getWebDriver(), path);
		
		log.info("Berhasil Klik Tambah Tipe Penjualan");
		
		}
	
	public static void saveListTipePenjualan(WebDriver driver, String filename) {
		log.info("PengaturanPOSTool.saveListTipePenjualan");

		String tab = "";
		String content = "PengaturanPOSTool.saveListTipePenjualan : " + "\r\n";
		tab = "//*[contains(@id,'detail-sales-type')]";
		content = content  
				+ AccTool.getGridValue(driver, AccurateModule.PENGATURAN_POS, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
		
		}
	
	
	}
	

