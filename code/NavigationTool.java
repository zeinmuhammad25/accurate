package com.cpssoft.web.test.accurate.tool;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class NavigationTool {
	private static final Logger log = Logger.getLogger(NavigationTool.class);
	public WebDriver driver = getWebDriver();

	public static void klikMenuModul(WebDriver driver, AccurateModule module) {
		log.info("VerticalMenu : " + module);

		String menuName = null;
		switch (module) {

		// module pengaturan
		case PREFERENSI:
			menuName = "Preferensi";
			break;
		case AKSES_GRUP:
			menuName = "Akses Grup";
			break;
		case PENOMORAN:
			menuName = "Penomoran";
			break;
		case PENOMORAN_PAJAK:
			menuName = "Penomoran Faktur Pajak";
			break;
		case RANCANGAN_FORMULIR:
			menuName = "Rancangan Formulir";
			break;
		case DESAIN_CETAKAN:
			menuName = "Desain Cetakan";
			break;
		case PENGGUNA:
			menuName = "Pengguna";
			break;
		case PENYETUJU_TRANSAKSI:
			menuName = "Penyetuju Transaksi";
			break;
		case MARKETPLACE:
			menuName = "Accurate Store";
			break;
		
		//Accurate POS
		case PENGATURAN_POS:
			menuName = "Pengaturan POS";
			break;
		case BIAYA:
			menuName = "Biaya";
			break;
		case TIPE_PENJUALAN:
			menuName = "Tipe Penjualan";
			break;

		// module perusahaan
		case MATA_UANG:
			menuName = "Mata Uang";
			break;
		case CABANG:
			menuName = "Cabang";
			break;
		case DEPARTEMEN:
			menuName = "Departemen";
			break;
		case PROYEK:
			menuName = "Proyek";
			break;
		case PAJAK:
			menuName = "Pajak";
			break;
		case SYARAT_PEMBAYARAN:
			menuName = "Syarat Pembayaran";
			break;
		case PENGIRIMAN:
			menuName = "Pengiriman";
			break;
		case FOB:
			menuName = "FOB";
			break;
		case GAJI_TUNJANGAN:
			menuName = "Gaji/Tunjangan";
			break;
		case KARYAWAN:
			menuName = "Karyawan";
			break;
		case TRANSAKSI_BERULANG:
			menuName = "Transaksi Berulang";
			break;
		case TRANSAKSI_FAVORIT:
			menuName = "Transaksi Favorit";
			break;
		case PROSES_AKHIR_BULAN:
			menuName = "Proses Akhir Bulan";
			break;
		case KONTAK:
			menuName = "Kontak";
			break;
		case ALAMAT:
			menuName = "Alamat";
			break;
		case REKAMAN_TRANSAKSI:
			menuName = "Transaksi Favorit";
			break;
		case LOG_AKTIVITAS:
			menuName = "Log Aktifitas";
			break;
		case PERSETUJUAN:
			menuName = "Persetujuan (Approval)";
			break;

		// module buku besar
		case AKUN_PERKIRAAN:
			menuName = "Akun Perkiraan";
			break;
		case JURNAL_UMUM:
			menuName = "Jurnal Umum";
			break;
		case ANGGARAN:
			menuName = "Anggaran";
			break;
		case HISTORI_AKUN:
			menuName = "Histori Akun";
			break;
		case PENCATATAN_BEBAN:
			menuName = "Pencatatan Beban";
			break;
		case PENCATATAN_GAJI:
			menuName = "Pencatatan Gaji";
			break;
		case LOG_AKTIVITAS_JURNAL:
			menuName = "Log Aktifitas Jurnal";
			break;

		// module kas bank
		case PEMBAYARAN:
			menuName = "Pembayaran";
			break;
		case PEMBAYARAN_GAJI:
			menuName = "Pembayaran Gaji";
			break;
		case PENERIMAAN:
			menuName = "Penerimaan";
			break;
		case TRANSFER_BANK:
			menuName = "Transfer Bank";
			break;
		case REKENING_KORAN:
			menuName = "Rekening Koran";
			break;
		case HISTORI_BANK:
			menuName = "Histori Bank";
			break;
		case REKONSILIASI_BANK:
			menuName = "Rekonsiliasi Bank";
			break;

		// module Penjualan
		case PENAWARAN_PENJUALAN:
			menuName = "Penawaran Penjualan";
			break;
		case PESANAN_PENJUALAN:
			menuName = "Pesanan Penjualan";
			break;
		case PENGIRIMAN_PESANAN:
			menuName = "Pengiriman Pesanan";
			break;
		case UANG_MUKA_PENJUALAN:
			menuName = "Uang Muka Penjualan";
			break;
		case FAKTUR_PENJUALAN:
			menuName = "Faktur Penjualan";
			break;
		case PENERIMAAN_PENJUALAN:
			menuName = "Penerimaan Penjualan";
			break;
		case RETUR_PENJUALAN:
			menuName = "Retur Penjualan";
			break;
		case KATEGORI_PELANGGAN:
			menuName = "Kategori Pelanggan";
			break;
		case KATEGORI_HARGA:
			menuName = "Kategori Penjualan";
			break;
		case PELANGGAN:
			menuName = "Pelanggan";
			break;
		case KOMISI_PENJUAL:
			menuName = "Komisi Penjual";
			break;
		case TARGET_PENJUALAN:
			menuName = "Target Penjualan";
			break;
		case TUKAR_FAKTUR:
			menuName = "Tukar Faktur";
			break;
		case KLAIM_PELANGGAN:
			menuName = "Klaim Pelanggan";
			break;
		case PENGEPAKAN_BARANG:
			menuName = "Pengepakan Barang";
			break;
		case SMARTLINK_ECOMMERCE:
			menuName = "SmartLink e-Commerce";
			break;

		// modul pembelian
		case PESANAN_PEMBELIAN:
			menuName = "Pesanan Pembelian";
			break;
		case PENERIMAAN_BARANG:
			menuName = "Penerimaan Barang";
			break;
		case UANG_MUKA_PEMBELIAN:
			menuName = "Uang Muka Pembelian";
			break;
		case FAKTUR_PEMBELIAN:
			menuName = "Faktur Pembelian";
			break;
		case PEMBAYARAN_PEMASOK:
			menuName = "Pembayaran Pembelian";
			break;
		case RETUR_PEMBELIAN:
			menuName = "Retur Pembelian";
			break;
		case KATEGORI_PEMASOK:
			menuName = "Kategori Pemasok";
			break;
		case PEMASOK:
			menuName = "Pemasok";
			break;
		case KLAIM_PEMASOK:
			menuName = "Klaim Pemasok";
			break;

		// module persediaan
		case PERMINTAAN_BARANG:
			menuName = "Permintaan Barang";
			break;
		case PINDAH_BARANG:
			menuName = "Pemindahan Barang";
			break;
		case PENYESUAIAN_PERSEDIAAN:
			menuName = "Penyesuaian Persediaan";
			break;
		case PEKERJAAN_PESANAN:
			menuName = "Pekerjaan Pesanan";
			break;
		case PENAMBAHAN_BAHAN_BAKU:
			menuName = "Penambahan Bahan Baku";
			break;
		case PENYELESAIAN_PESANAN:
			menuName = "Penyelesaian Pesanan";
			break;
		case BARANG_JASA:
			menuName = "Barang & Jasa";
			break;
		case GUDANG:
			menuName = "Gudang";
			break;
		case SATUAN_BARANG:
			menuName = "Satuan Barang";
			break;
		case KATEGORI_BARANG:
			menuName = "Kategori Barang";
			break;
		case PENYESUAIAN_HARGA_JUAL:
			menuName = "Penyesuaian Harga/Diskon";
			break;
		case HARGA_PEMASOK:
			menuName = "Harga Pemasok";
			break;
		case BARANG_PER_GUDANG:
			menuName = "Barang per Gudang";
			break;
		case PERINTAH_STOK_OPNAME:
			menuName = "Perintah Stok Opname";
			break;
		case HASIL_STOK_OPNAME:
			menuName = "Hasil Stok Opname";
			break;
		case PENGISIAN_NOMOR_SERI:
			menuName = "Pengisian Nomor Seri";
			break;
		case PEMENUHAN_PESANAN:
			menuName = "Pemenuhan Pesanan";
			break;
		case BARANG_STOK_MINIMUM:
			menuName = "Barang Stok Minimum";
			break;

		// module aset tetap
		case ASET_TETAP:
			menuName = "Aset Tetap";
			break;
		case KATEGORI_ASET:
			menuName = "Kategori Aset";
			break;
		case KATEGORI_ASET_TETAP_PAJAK:
			menuName = "Kategori Aset Tetap Pajak";
			break;
		case PERUBAHAN_ASET_TETAP:
			menuName = "Perubahan Aset Tetap";
			break;
		case DISPOSISI_ASET_TETAP:
			menuName = "Disposisi Aset Tetap";
			break;
		case PINDAH_ASET:
			menuName = "Pindah Aset";
			break;
		case ASET_PER_LOKASI:
			menuName = "Aset per Lokasi";
			break;

		// unknown
		// case REKAMAN_TRANSAKSI:
		// menuName = "Rekaman Transaksi";
		// break;
		case UPAH_PEKERJA:
			menuName = "Upah Pekerja";
			break;
		case GAJI:
			menuName = "Gaji";
			break;

		case DAFTAR_LAPORAN:
			menuName = "Daftar Laporan";
			break;

		// module pabrikasi
		case STANDAR_BIAYA_PRODUKSI:
			menuName = "Standar Biaya Produksi";
			break;

		case FORMULA_PRODUKSI:
			menuName = "Formula Produksi";
			break;

		case RENCANA_PRODUKSI:
			menuName = "Rencana Produksi";
			break;

		case PERINTAH_KERJA:
			menuName = "Perintah Kerja";
			break;

		case PENGAMBILAN_BAHAN_BAKU:
			menuName = "Pengambilan Bahan Baku";
			break;
			
		case PENYELESAIAN_BARANG_JADI:
			menuName = "Penyelesaian Barang Jadi";
			break;
			
		case ALOKASI_BIAYA_PRODUKSI:
			menuName = "Alokasi Biaya Produksi";
			break;
			
		case TAHAPAN_PROSES:
			menuName = "Tahapan Proses";
			break;
			
		case TAHAPAN_PRODUKSI:
			menuName = "Tahapan Produksi";
			break;

		default:
			break;
		}
		String index2;
		String nama2;
		String judul2;
		String index;
		String nama;
		
		//ui baru
		index2 = "//nav[@class='vertical-menu'] //div[contains(@class,'sub-menu')] //span[text()='"
				+ menuName
				+ "'] /ancestor::div[contains(@class, 'sub-menu')]/preceding-sibling::a[contains(@class, 'bg-hover-red-aol')]";
//		nama2 = "//nav[@class='vertical-menu'] //div[contains(@class,'sub-menu')] //span[text()='"
//				+ menuName + "']/ancestor::div[contains(@class,'tile-status')]";
		nama2 = "//nav[@class='vertical-menu'] //div[contains(@class,'sub-menu')] //span[text()='"
				+ menuName + "']";
		judul2 = "//span[text()='"+ menuName + "']/ancestor::li[contains(@class, 'no-margin')]//h3[contains(@class, 'fg-gray')]";
				
		//ui lama yang param index
		index = "//nav[@class='vertical-menu'] //div[contains(@class,'sub-menu')] //span[contains(@class,'name')][text()='"
				+ menuName
				+ "'] /ancestor::div[contains(@class, 'sub-menu')]/preceding-sibling::a[contains(@class, 'bg-hover-gray')]";
		nama = "//nav[@class='vertical-menu'] //div[contains(@class,'sub-menu')] //span[contains(@class,'name')][text()='"
				+ menuName + "'] /ancestor::div[contains(@class,'tile-status')]";

		log.info( index2  + menuName + " = locator pilih modul" );
		log.info( judul2  + menuName + " = locator click judul modul" );
		log.info( nama2  + menuName + " = locator masuk modul" );
//		 Tunggu loading mask hilang di ui Baru dicomment yang tidak dipakai
		AccTool.waitLoadingMask(driver);
		WaitTool.waitForElementVisible(driver, By.xpath(index2), 10);
		AccTool.click(driver, index2);		
		AccTool.click(driver, judul2);	
		WaitTool.waitForElementVisible(driver, By.xpath(nama2), 10);
		AccTool.click(driver, nama2);
		
		
		// Tunggu loading mask hilang di ui lama
//		AccTool.waitLoadingMask(driver);
//		WaitTool.waitForElementVisible(driver, By.xpath(index), 10);
//		AccTool.click(driver, index);
//		AccTool.click(driver, nama);

		log.info("Menu " + menuName + " sudah diklik");

		// tunggu sampai sub menu hilang
		WaitTool.waitForElementDisapear(driver, By.xpath("//div[contains(@class,'sub-menu')]"), 20);
		log.info("Sub Menu sudah hilang");

		// cek apakah menu tersebut sudah tampil
		WaitTool.waitForElementVisible(driver, By.xpath("//a[text()='" + menuName + "']"), 100);
		AccTool.waitLoadingMask(driver);
		AccTool.waitGridMask(driver);
		log.info("Menu " + menuName + " telah terbuka");

		// WaitTool.waitForElementDisapear(driver,
		// By.xpath("//div[@class='window-overlay'"), 2);
	}

	private WebDriver getWebDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void cariList(WebDriver driver, AccurateModule module, String keywords) {
		log.info("Cari List Data: " + module + ", Keywords: " + keywords);

		String tab = module.getXpath() + "//div[starts-with(@class,'module-list')]";

		AccTool.textField(driver, tab, "@name='keyword'", keywords);
		AccTool.waitGridMask(driver);
		klikListData(driver, module);
		AccTool.waitLoadingMask(driver);
		WaitTool.delay(1000);
		// AccTool.scrollRow(driver, tab, keywords);
	}

	public static void cariListKlik(WebDriver driver, AccurateModule module, String keywords) {
		log.info("Cari List Data: " + module + ", Keywords: " + keywords);

		String tab = module.getXpath() + "//div[starts-with(@class,'module-list')]";

		AccTool.textField(driver, tab, "@name='keyword'", keywords);
		AccTool.waitGridMask(driver);
		AccTool.scrollRow(driver, tab, keywords);

	}

	public static void cariListData(WebDriver driver, AccurateModule module, String keywords) {
		log.info("Cari List Data: " + module + ", Keywords: " + keywords);

		String tab = module.getXpath() + "//div[starts-with(@class,'module-list')]";

		AccTool.scrollRow(driver, tab, keywords);
		// AccTool.textField(driver, tab, "@name='keyword'", keywords);

	}

	// public static void cariListKlik(WebDriver driver, AccurateModule module,
	// String keywords) {
	// log.info("Cari List Data: " + module + ", Keywords: " + keywords);
	//
	// String tab = module.getXpath() +
	// "//div[starts-with(@class,'module-list')]";
	//
	// AccTool.textField(driver, tab, "@name='keyword'", keywords);
	// AccTool.scrollRow(driver, tab, keywords);
	// }

	public static void klikTutupModule(WebDriver driver, AccurateModule module) {
		String buttonClose = "//ul[contains(@class, 'module-switcher tabs')]//a[@href='#" + module.getId()
				+ "']/following-sibling::a";
		AccTool.waitProgressBar(driver);
		WaitTool.waitForElementClickable(driver, By.xpath(buttonClose), 1000);
		AccTool.click(driver, buttonClose);
		WaitTool.delay(300);
		if (!WebElementTool.isElementVisible(driver, By.xpath("//div[contains(@id,'confirm-dialog')]"))) {
			WaitTool.waitForElementDisapear(driver,
					By.xpath("//ul[contains(@class, 'module-switcher tabs')]//a[@href='#" + module.getId() + "']"), 10);
		}
	}

	public static void klikTutupModuleConfirm(WebDriver driver, AccurateModule module) {
		AccTool.waitProgressBar(driver);
		AccTool.click(driver, "//ul[contains(@class, 'module-switcher tabs')]//a[@href='#" + module.getId()
				+ "']/following-sibling::a");
	}

	public static void klikTutupTabData(WebDriver driver, AccurateModule module, String tabTitle) {
		WaitTool.delay(1500);
		AccTool.click(driver, module.getXpath() + "//*[label[span[contains(@title,'" + tabTitle
				+ "')]]]//i[contains(@class,'icon-cancel')]");
		WaitTool.delay(1000);
		AccTool.waitGridMask(driver, true);
		WaitTool.delay(1000);
		AccTool.waitLoadingMask(driver);
	}

	public static void klikListData(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnToggleList']");
		AccTool.waitGridMask(driver, true);
		WaitTool.delay(500);
		// klikPerbaruiData(driver, module); //sementara sampai dibenerin
		// masbenk
		// AccTool.waitGridMask(driver, true); //idem
	}

	public static void klikPerbaruiData(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnRefresh']");
	}

	public static void klikTambahData(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnAdd']");
	}
	
	public static void klikImporData(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnImport']");
		WaitTool.delay(2000);
	}
	
	public static void klikTombolImporFakturFile(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnImport']");
		WaitTool.waitForElementVisible(driver,
				By.xpath("//ul[@class='text-left dropdown-menu']//a[contains(@data-bind, 'importFromFile()')]"), 5);
		AccTool.click(driver,
				module.getXpath() + "//ul[@class='text-left dropdown-menu']//a[contains(@data-bind, 'importFromFile()')]");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void ImporPenjualanDariFile(WebDriver driver, String direktori, String filename, String filename2)
			throws AWTException {
		WaitTool.checkPageIsReady(driver);
		
		//pindah tab ke form Impor File
		NavigationTool.klikPindahTabModule(driver, AccurateModule.IMPOR_FAKTUR_FROM_FILE);

		// klik icon tambah
		driver.findElement(
				By.xpath("//div[starts-with(@id,'accurate__customer__sales-invoice-import-file')]//button[@class='btn-file']"))
				.click();
		WaitTool.delay(500); // cari tahu cara ganti delay ini

		// mengetikkan lokasi dan nama file dokumen, lalu klik Open
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection str = new StringSelection(
				System.getProperty("user.dir") + "\\master\\" + direktori + "\\" + filename);
		clipboard.setContents(str, null);
		WaitTool.delay(1000);
		
		//Get back the focus 
		((JavascriptExecutor) driver).executeScript("window.focus();");

		Robot robot = new Robot();
		//memastikan mouse click di window Open
		robot.mouseMove(200, 300); // move mouse point to specific location	
        robot.delay(1000);        // delay is to make code wait for mentioned milliseconds before executing next step	
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click	
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click	
        robot.delay(1500);
		//utk psatikan cursor di Open File
		robot.keyPress(KeyEvent.VK_TAB);
		WaitTool.delay(1000);
		robot.keyRelease(KeyEvent.VK_TAB);
		WaitTool.delay(1000);
		//utk psatikan cursor di field filename
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_N);
		WaitTool.delay(500);
		//utk paste lokasi dokumen
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		WaitTool.delay(500);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_O);
		//robot.keyPress(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		WaitTool.delay(1000);
		
		//klik Mulai Impor
		driver.findElement(
				By.xpath("//button[contains(@id, 'btnNext')]")).click();

		// menunggu progress bar = 100%
		AccTool.waitLoadingMask(driver);
		String tombolStop = "//div[starts-with(@id,'accurate__customer__sales-invoice-import-file')]//div[@class='import-wizard']//*[starts-with(@id,'stopImportBtn')]";
		WaitTool.waitForElementDisapear(driver, By.xpath(tombolStop), 20);
		
		// menunggu hasil impor masuk
		String hasilImpor = "//div[starts-with(@id,'accurate__customer__sales-invoice-import-file')]//div[@class='import-wizard']//h4[starts-with(@class,'fg-green')]";
		WaitTool.waitForElementVisible(driver, By.xpath(hasilImpor), 20);
		
		//tutup hasil impor
		driver.findElement(
				By.xpath("//button[contains(@id, 'btnNext')]")).click();
		
		//pindah tab ke Faktur Penjualan
		NavigationTool.klikPindahTabModule(driver, AccurateModule.FAKTUR_PENJUALAN);
		NavigationTool.klikListData(driver, AccurateModule.FAKTUR_PENJUALAN);
		
		// memastikan impor berhasil masuk list SI
		FakturPenjualanTool.saveList(driver, filename2);
		AccTool.waitLoadingMask(driver);
	}

	public static void klikCetakList(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnPrint']");
		WaitTool.delay(2000);

	}

	public static void klikCetakDaftarList(WebDriver driver, AccurateModule module) {
//		AccTool.click(driver, module.getXpath() + "//button[@name='btnPrint']");
//		WaitTool.waitForElementVisible(driver,
//				By.xpath("//ul[@class='text-left dropdown-menu']//a[contains(@data-bind, 'printList()')]"), 5);
//		AccTool.click(driver,
//				module.getXpath() + "//ul[@class='text-left dropdown-menu']//a[contains(@data-bind, 'printList()')]");
//		// WaitTool.delay(5000);
		
		//ui baru
		AccTool.click(driver, module.getXpath() + "//nav[@class='horizontal-menu']//button[@name='btnPrint']");
		WaitTool.delay(500);
		AccTool.click(driver, module.getXpath() + "//*[@class='icn-sub-menu-single']");
		WaitTool.delay(5000);
	}

	public static void cekPrintPreviewList(WebDriver driver, String filename) {

		AccTool.waitLoadingMask(driver);

		new WebDriverWait(driver, 20).until(ExpectedConditions.numberOfWindowsToBe(3));

		driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());

		String hasil = "";

		String jsPrint = "return document.querySelector('print-preview-app')"
				+ ".shadowRoot.querySelector('print-preview-sidebar')"
				+ ".shadowRoot.querySelector('print-preview-header')" + ".shadowRoot.querySelector('h1.title')";

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement printButton;
		printButton = (WebElement) jse.executeScript(jsPrint);
		hasil = printButton.getText();
		// log.info(hasil);

		String result = "Berhasil membuka Print Preview List";
		String warn = "Ada error ketika print list";

		if (hasil.equals("Print")) {
			// log.info("sudah ketemu");
			result = result + "\r\n";
			AccTool.writeTextFile(filename, result);
		} else {
			// log.warn("Terjadi error ketika print list");
			warn = warn + "\r\n";
			AccTool.writeTextFile(filename, warn);
		}

		String jsCancel = "return document.querySelector('print-preview-app')"
				+ ".shadowRoot.querySelector('print-preview-sidebar')"
				+ ".shadowRoot.querySelector('print-preview-button-strip')"
				+ ".shadowRoot.querySelector('cr-button.cancel-button')";
		// WebDriverWait wait = new WebDriverWait(driver, 3);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		WebElement cancelButton;
		cancelButton = (WebElement) jse2.executeScript(jsCancel);
		cancelButton.click();

		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		WaitTool.delay(1000);
	}

	public static void klikSimpanData(WebDriver driver, AccurateModule module) {
		// AccTool.click(driver, module.getXpath() +
		// "//i[@class='icon-floppy']/../..");
		// AccTool.waitLoadingMask(driver);
		// AccTool.waitProgressBar(driver);
		
		//ui lama
//		WaitTool.waitForElementClickable(driver, By.xpath(module.getXpath() + "//i[@class='icon-floppy']"), 6);
//		AccTool.click(driver, module.getXpath() + "//i[@class='icon-floppy']");
//		WaitTool.waitForElementDisapear(driver, By.xpath("//div[@class='ui-effects-transfer']"), 40);	
		
//		WaitTool.waitForElementClickable(driver, By.xpath(module.getXpath() + "//*[@id='[object Object]']"), 6);
//		AccTool.click(driver, module.getXpath() + "//*[@id='[object Object]']");
				
		//ui Baru
		if (WebElementTool.isElementVisible(driver, By.xpath("//*[@id='[object Object]']"))) {
			
		WaitTool.waitForElementClickable(driver, By.xpath(module.getXpath() + "//*[@id='[object Object]']"), 6);
		AccTool.click(driver, module.getXpath() + "//*[@id='[object Object]']");
		
		} else {
			
			WaitTool.waitForElementClickable(driver, By.xpath(module.getXpath() + "//*[@id='btnSave']"), 6);
			AccTool.click(driver, module.getXpath() + "//*[@id='btnSave']");
		}
//		String simpanbaru = "//a[contains(.,'Simpan')]";
//		if (WebElementTool.isElementVisible(driver, By.xpath(simpanbaru))) {
//			WaitTool.waitForElementPresent(driver, By.xpath(simpanbaru), 10);
//			AccTool.click(driver, simpanbaru);
//		}
		
		WaitTool.waitForElementDisapear(driver, By.xpath("//div[@class='ui-effects-transfer']"), 40);
	}
	
	public static void klikSimpanDraft(WebDriver driver, AccurateModule module) {
				
		WaitTool.waitForElementClickable(driver, By.xpath(module.getXpath() + "//div[starts-with(@class,'dropdown-toggle btn-dropdown')]"), 6);
		AccTool.click(driver, module.getXpath() + "//div[starts-with(@class,'dropdown-toggle btn-dropdown')]");	
		AccTool.click(driver, module.getXpath() + "//span[.='Sebagai Draf']");	
		WaitTool.waitForElementDisapear(driver, By.xpath("//div[@class='ui-effects-transfer']"), 40);
	}

	public static void klikCetakForm(WebDriver driver, AccurateModule module) {
		WaitTool.delay(1000);
//		AccTool.click(driver, module.getXpath() + "//i[@data-bind='css: computedIconClass' and @class='icon-printer']");
		//ui baru
		AccTool.click(driver, module.getXpath() + "//i[@id='btnPrint']");		
		WaitTool.waitForElementVisible(driver,
				By.xpath("//div[@class='module-tab-body selected']//i[@class='icn-report-print']"), 5);
		AccTool.click(driver, module.getXpath() + "//div[@class='module-tab-body selected']//i[@class='icn-report-print']");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikCetakFormLainnya(WebDriver driver, AccurateModule module) {
		WaitTool.delay(1000);
		AccTool.click(driver, module.getXpath() + "//i[@id='btnPrint']");		
		WaitTool.waitForElementVisible(driver,
				By.xpath("//div[@class='module-tab-body selected']//i[@class='icn-report-print']"), 5);
		AccTool.click(driver, module.getXpath() + "//div[@class='module-tab-body selected']//li[4]//i[@class='icn-report-print']");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikPilihKelompokData(WebDriver driver, AccurateModule module, String kelompok) {
		String xpath = "/html/body//div[@class='window shadow']//div[@class='caption']//button[@class='btn-close']";
		WaitTool.waitForElementPresent(driver, By.xpath(xpath), 10);
		log.info("buka combo box");
		AccTool.combobox(driver, "/html/body//div[starts-with(@id,'accurate__input-data-paging')]", "@name='page'",
				kelompok);
		log.info("selesai pilih");
		AccTool.click(driver,
				"/html/body//div[starts-with(@id,'accurate__input-data-paging')]//div[@class='row no-margin']/div[2]/button[@name='btnNext']");
		log.info("click");
		AccTool.waitLoadingMask(driver);
	}

	public static void klikPilihDesainCetakanForm(WebDriver driver, AccurateModule module, String desain) {
//		String xpath = "/html/body//div[@class='window shadow']//div[@class='caption']//button[@class='btn-close']";
//		WaitTool.waitForElementPresent(driver, By.xpath(xpath), 10);
		//wait ui baru

		String xpath = "//*[.='Layout']";
		WaitTool.waitForElementPresent(driver, By.xpath(xpath), 10);

//		AccTool.click(driver,
//				"/html/body//div[starts-with(@id,'accurate__company__select-print-layout')]//button[@class='button default']//span[text() = '"
//						+ desain + "']");
		
		//ui baru sudah menggunakan select
		AccTool.combobox(driver, "", "@name='printLayoutList'", desain);
		//mulai ui baru
		AccTool.click(driver, "//div[@class='span4 offset7']//button[@name='btnNext']");	
		AccTool.waitLoadingMask(driver);
	}

	public static void cekPrintPreviewForm(WebDriver driver, String filename) {
		String xpath = "//*[@id='print-preview']";

		WebElement notification = WaitTool.waitForElementPresent(driver, By.xpath(xpath), 60);
		String result = "Berhasil membuka Print Preview Form";
		try {
			AccTool.waitLoadingMask(driver);
			notification.findElement(By.xpath("//button[@id='print-preview-close']")).click();
			WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 5);
		} catch (Throwable t) {
			log.warn("Terjadi error ketika print form: " + t.getMessage());
		}
		log.info("Notifikasi: " + result);
		result = result + "\r\n";

		AccTool.writeTextFile(filename, result);
	}

	public static void klikEmailForm(WebDriver driver, AccurateModule module) {
		log.info("klikEmailForm");
//		AccTool.click(driver, module.getXpath() + "//i[@data-bind='css: computedIconClass' and @class='icon-printer']");
		AccTool.click(driver, module.getXpath() + "//i[@id='btnPrint']");	
		WaitTool.waitForElementVisible(driver,
				By.xpath("//ul[@class='text-left drop-left dropdown-menu']//span[text() = 'Email']"), 5);
		AccTool.click(driver, module.getXpath() + "//span[text() = 'Email']");
		AccTool.waitLoadingMask(driver);
	}

	public static void cekKirimEmailForm(WebDriver driver, String filename) {
		log.info("cekKirimEmailForm");
		String xpath = "//div[starts-with(@id,'accurate__company__email-transaction-dialog')]";

		WebElement notification = WaitTool.waitForElementPresent(driver, By.xpath(xpath), 60);
		String result = "Berhasil membuka Kirim Email";
		try {
			AccTool.waitLoadingMask(driver);
			// notification.findElement(By.xpath("//div[@class='window
			// shadow']//button[@class='btn-close']")).click();
			notification
					.findElement(By.xpath(xpath + "/parent::div//preceding-sibling::div//button[@class='btn-close']"))
					.click();
			// *[text()='Rincian Barang']/parent::div//*[@class='btn-close']
			WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 5);
		} catch (Throwable t) {
			log.warn("Terjadi error ketika email form: " + t.getMessage());
		}
		log.info("Notifikasi: " + result);
		result = result + "\r\n";

		AccTool.writeTextFile(filename, result);
	}

	public static void klikDokumen(WebDriver driver, AccurateModule module) {
		log.info("klikDokumen");
//		AccTool.click(driver, module.getXpath() + "//i[@class='icon-attachment']");
//		WaitTool.waitForElementVisible(driver,
//				By.xpath("//ul[@class='text-left drop-left dropdown-menu']//span[contains(text(), 'Dokumen')]"), 5);
//		WebElementTool.click(driver,
//				By.xpath("//ul[@class='text-left drop-left dropdown-menu']//span[contains(text(), 'Dokumen')]"));
//		AccTool.waitLoadingMask(driver);
		
		//ui baru
		AccTool.click(driver, module.getXpath() + "//i[@id='btnCommentAttachment']");	
		WaitTool.waitForElementVisible(driver,
				By.xpath("//i[@class='icn-sub-menu-attachment']"), 5);
		WebElementTool.click(driver,
				By.xpath("//i[@class='icn-sub-menu-attachment']"));
		AccTool.waitLoadingMask(driver);
	}

	public static void cekDokumenForm(WebDriver driver, String filename) {
		String xpath = "//div[text()= 'Dokumen Transaksi']";

		WebElement notification = WaitTool.waitForElementPresent(driver, By.xpath(xpath), 60);
		String result = "Berhasil membuka Dokumen Transaksi";
		try {
			AccTool.waitLoadingMask(driver);
			notification
					.findElement(By
							.xpath("//div[starts-with(@id,'accurate__company__attachment')]//button[@name='btnClose']"))
					.click();
			WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 5);
		} catch (Throwable t) {
			log.warn("Terjadi error ketika membuka dokumen form: " + t.getMessage());
		}
		log.info("Notifikasi: " + result);
		result = result + "\r\n";

		AccTool.writeTextFile(filename, result);
	}

	public static void cekUploadDokumen(WebDriver driver, String direktori, String filename, String filename2)
			throws AWTException {
		log.info("cekUploadDokumen");
		WaitTool.checkPageIsReady(driver);

		// isi nama file dokument, lalu klik icon tambah
		driver.findElement(
				By.xpath("//div[starts-with(@id,'accurate__company__attachment')]//input[@name='description']"))
				.sendKeys(filename);
		WaitTool.delay(1500);
		driver.findElement(
				By.xpath("//div[starts-with(@id,'accurate__company__attachment')]//button[@name='btnAddAttachment']"))
				.click();
		WaitTool.delay(500); // cari tahu cara ganti delay ini

		// mengetikkan lokasi dan nama file dokumen, lalu klik Open
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection str = new StringSelection(
				System.getProperty("user.dir") + "\\master\\" + direktori + "\\" + filename);
		clipboard.setContents(str, null);
		WaitTool.delay(1000);
		
		//Get back the focus 
		((JavascriptExecutor) driver).executeScript("window.focus();");

		Robot robot = new Robot();
		//memastikan mouse click di window Open
		robot.mouseMove(200, 300); // move mouse point to specific location	
        robot.delay(1000);        // delay is to make code wait for mentioned milliseconds before executing next step	
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click	
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click	
        robot.delay(1500);
		//utk psatikan cursor di Open File
		robot.keyPress(KeyEvent.VK_TAB);
		WaitTool.delay(1000);
		robot.keyRelease(KeyEvent.VK_TAB);
		WaitTool.delay(1000);
		//utk psatikan cursor di field filename
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_N);
		WaitTool.delay(500);
		//utk paste lokasi dokumen
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		WaitTool.delay(500);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_O);
		//robot.keyPress(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		WaitTool.delay(1000);

		// menunggu progress bar = 100%
		String progbar = "//div[starts-with(@id,'accurate__company__attachment')]//div[@class='progress-bar']//div[contains(@style,'width: 100%')]";
		//WaitTool.waitForElementPresent(driver, By.xpath(progbar), 20);
		
		try {
			WaitTool.waitForElementPresent(driver, By.xpath(progbar), 30);
		} catch (Throwable t) {
			log.warn("Terjadi error ketika upload file: " + t.getMessage());
		}

		// memastikan file dokumen masuk ke daftar dokumen
		String namafile = "//div[starts-with(@id,'accurate__company__attachment')]//div[@data-bind='foreach: attachments']//*[text() = '"
				+ filename + "']";
		String result = "Berhasil upload dokumen";
		String warn = "Tidak berhasil upload dokumen";

		if (driver.findElements(By.xpath(namafile)).size() > 0) {
			// log.info("masuk bener");
			result = result + "\r\n";
			AccTool.writeTextFile(filename2, result);
		} else {
			// log.info("Terjadi error ketika upload dokumen");
			warn = warn + "\r\n";
			AccTool.writeTextFile(filename2, warn);
		}
		AccTool.waitLoadingMask(driver);
		//ui lama
//		driver.findElement(
//				By.xpath("//div[starts-with(@id,'accurate__company__attachment')]//button[@name='btnClose']")).click();
		//ui baru
		driver.findElement(
		By.xpath("//div[.='Dokumen Transaksi']//button[@class='btn-close']")).click();
		AccTool.waitLoadingMask(driver);
	}

	public static void klikKomentar(WebDriver driver, AccurateModule module) {
		log.info("klikKomentar");
		//ui lama
//		AccTool.click(driver, module.getXpath() + "//i[@class='icon-attachment']");	
//		WaitTool.waitForElementVisible(driver,
//				By.xpath("//ul[@class='text-left drop-left dropdown-menu']//span[text() = 'Dokumen']"), 5);
//		WebElementTool.click(driver,
//				By.xpath("//ul[@class='text-left drop-left dropdown-menu']//span[text() = 'Komentar']"));
		
		//ui baru
		AccTool.click(driver, module.getXpath() + "//div[@class='module-tab-body selected']//i[@id='btnCommentAttachment']");
		WaitTool.waitForElementVisible(driver,
		By.xpath("//i[@class='icn-sub-menu-comment']"), 5);
		AccTool.click(driver, module.getXpath() + "//i[@class='icn-sub-menu-comment']");
	}

	public static void cekKomentarForm(WebDriver driver, String filename) {
		log.info("cekKomentarForm");
		String xpath = "//div[text()= 'Komentar transaksi']";
		//span[.='Komentar']
		WebElement notification = WaitTool.waitForElementPresent(driver, By.xpath(xpath), 60);
		String result = "Berhasil membuka Komentar Transaksi" + "\r\n";
		try {
			AccTool.waitLoadingMask(driver);
			notification
					.findElement(By
							.xpath("//div[text()= 'Komentar transaksi']/preceding-sibling::button[@class='btn-close']"))
					.click();
			WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 5);
		} catch (Throwable t) {
			log.warn("Terjadi error ketika membuka komentar form: " + t.getMessage());
		}
		log.info("Notifikasi: " + result);
		result = result + "\r\n";

		AccTool.writeTextFile(filename, result);
	}

	public static void klikSimpanBawah(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnSave']");
		AccTool.waitProgressBar(driver);
	}

	public static void klikHapusData(WebDriver driver, AccurateModule module) {
		//ui lama 
//		AccTool.click(driver, module.getXpath() + "//i[@class='icon-remove']");
		
		//ui baru
		AccTool.click(driver, module.getXpath() + "//i[@id='btnDelete']");
	}

	public static void klikKonfirmasiYa(WebDriver driver) {
		By confirmDialog = By.xpath("//div[contains(@id,'confirm-dialog')]");
		WaitTool.waitForElementVisible(driver, confirmDialog, 10);
		AccTool.click(driver, "//button[@name='btnOk' and text()='Ya']");
		WaitTool.waitForElementDisapear(driver, confirmDialog, 2);
		WaitTool.waitForElementDisapear(driver, By.xpath("//div[@class='ui-effects-transfer']"), 2);
		// AccTool.waitLoaderMedium(driver);
		WaitTool.delay(500);
	}

	public static void klikKonfirmasiLanjut(WebDriver driver) {
		AccTool.click(driver, "//div[contains(@id, 'confirm-dialog')]//button[text() = 'Lanjutkan']");
	}

	public static void klikErrorOK(WebDriver driver) {
		AccTool.click(driver, "//div[contains(@id, 'error-dialog')]//button[@name='btnOk' and text()='OK']");
		WaitTool.waitForElementDisapear(driver,
				By.xpath("//div[contains(@id, 'error-dialog')]//button[@name='btnOk' and text()='OK']"), 7);
	}
	
	public static void klikSelesai(WebDriver driver) {
		AccTool.click(driver, "//div[@class='span6 >            <button name= button default primary']");
		WaitTool.waitForElementDisapear(driver,By.xpath("//nav[@class='vertical-menu']"), 30);
	}

	public static void klikLanjutSetup(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnNext']");
	}

	public static void klikSelesaiSetup(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnFinish']");
	}

	public static void klikTutupNotifikasi(WebDriver driver) {
		WaitTool.waitForElementPresent(driver, By.xpath("/html/body/div[@class='metro notify-container']//i[contains(@class,'icon-cancel')]"), 10);
		AccTool.click(driver, "/html/body/div[@class='metro notify-container']//i[contains(@class,'icon-cancel')]");
	}

	public static void klikTombolLanjutkan(WebDriver driver) {
		AccTool.click(driver, "//button[@name='btnContinue']");
	}

	public static void klikSimpanDatabase(WebDriver driver) {
		AccTool.click(driver, "//div[starts-with(@id,'manage__database')]//button[@name='btnSave']");
	}

	public static void klikIndikatorLanjutkan(WebDriver driver) {
		WaitTool.delay(2000);
		AccTool.click(driver, "//div[contains(@class,'queue-indicator')]");
		WaitTool.waitForElementVisible(driver, By.xpath("//div[@class='queue-item']"), 40);
		AccTool.click(driver, "//div[@class='queue-content']//button[text()='Lanjutkan']");
		WaitTool.delay(2000);
	}

	public static void klikAmbilFavorit(WebDriver driver, AccurateModule module) {
		AccTool.dropDown(driver, module.getXpath(), "btnGetFrom", "Favorit");
	}

	public static void klikAmbilPencatatanGaji(WebDriver driver, AccurateModule module) {
		AccTool.dropDown(driver, module.getXpath(), "btnGetFrom", "Pencatatan Gaji");
	}

	public static void klikAmbilPencatatanBeban(WebDriver driver, AccurateModule module) {
		AccTool.dropDown(driver, module.getXpath(), "btnGetFrom", "Pencatatan Beban");
	}

	public static void tambahKontak(WebDriver driver, AccurateModule modul) {
		String path = modul.getXpath() + "//*[contains(@id,'tab-contact')]//button[@name='btnAddContact']";
		AccTool.click(driver, path);
	}

	public static void tambahSaldo(WebDriver driver, AccurateModule modul) {
		String path = modul.getXpath() + "//*[contains(@id,'tab-balance')]//button[@name='btnAddOpenBalance']";
		AccTool.click(driver, path);
		AccTool.waitLoadingMask(driver);
		AccTool.waitGridMask(driver);
	}

	public static void tambahSaldoBarang(WebDriver driver, AccurateModule modul) {
		
		String path = modul.getXpath() + "//*[contains(@id,'tab-info')]//button[@name='btnAddOpenBalance']";
		if (WebElementTool.isElementExists(driver, By.xpath(path))) {			
			AccTool.click(driver, path);
		} 	else {
			String path2 = modul.getXpath() + "//*[contains(@id,'tab-stock')]//button[@name='btnAddOpenBalance']";
			AccTool.click(driver, path2);
		}
	}

	public static void klikButtonLanjut(WebDriver driver, String xpath) {
		String path = xpath + "//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 60);
	}

	public static void klikButtonPensil(WebDriver driver, AccurateModule modul) {
//		String xpath = modul.getXpath() + "//i[contains(@class,'icon-pencil')]";
		String xpath = modul.getXpath() + "//span[@class='toggle-slider round']";
		AccTool.click(driver, xpath);
	}

	public static void klikBatalAntrian(WebDriver driver) {
		// WaitTool.waitForElementDisapear(driver,
		// By.xpath("//div[@class='ui-effects-transfer']"), 5);
		AccTool.click(driver, "//div[contains(@class,'queue-indicator')]");
		WaitTool.waitForElementVisible(driver, By.xpath("//div[@class='queue-item']"), 30);
		String xpath = "//div[@class='queue-content']/div[1]//button[@name='btnCancel']";
		WaitTool.waitForElementVisible(driver, By.xpath(xpath), 30);
//		WaitTool.waitForElementClickable(driver, By.xpath(xpath), 30);
		AccTool.click(driver, xpath);
	}

	public static void klikEditAntrian(WebDriver driver) {
		AccTool.click(driver, "//div[contains(@class,'queue-indicator')]");
		WaitTool.waitForElementVisible(driver, By.xpath("//div[@class='queue-item']"), 30);
		String xpath = "//div[@class='queue-content']/div[1]//button[@name='btnEdit']";
		WaitTool.waitForElementClickable(driver, By.xpath(xpath), 30);
		AccTool.click(driver, xpath);
	}

	public static void klikTombolTutup(WebDriver driver) {
		AccTool.click(driver, "//button[@name='btnClose']");
	}

	public static void klikListGridDetailFormOnly(WebDriver driver, AccurateModule modul, String keyword) {
		AccTool.clickCell(driver, modul.getXpath(), keyword);

	}

	public static void klikListGridDetailForm(WebDriver driver, AccurateModule modul, String keyword) {
		WaitTool.delay(1000);
		AccTool.clickCell(driver, modul.getXpath(), keyword);
		String path = "//button[@name='btnNext']";
		WaitTool.waitForElementClickable(driver, By.xpath(path), 10);
	}

	public static void klikListGridDetailFormBiayaLain(WebDriver driver, AccurateModule modul, String keyword) {
		AccTool.clickCell(driver, modul.getXpath(), keyword);
		AccTool.waitProgressBar(driver);
		String path = "//div[starts-with(@id,'detail-expense')]//button[@name='btnNext']";
		WaitTool.waitForElementClickable(driver, By.xpath(path), 50);
	}

	public static void klikListGridDetailFormBahanBaku(WebDriver driver, AccurateModule modul, String keyword) {
		AccTool.clickCell(driver, modul.getXpath(), keyword);
		String path = "//div[starts-with(@id,'detail-material')]//button[@name='btnNext']";
		WaitTool.waitForElementClickable(driver, By.xpath(path), 10);
	}
	
	public static void klikListGridDetailFormDP(WebDriver driver, AccurateModule modul, String keyword) {
		AccTool.clickCell(driver, modul.getXpath(), keyword);
		String path = "//div[starts-with(@id,'detail-down-payment')]//button[@name='btnNext']";
		WaitTool.waitForElementClickable(driver, By.xpath(path), 10);
	}

	public static void klikTutupWindowShadow(WebDriver driver, String xpath) {
		AccTool.click(driver, xpath + "//button[@class='btn-close']");
		WaitTool.delay(500);
	}

	public static void tambahKeFavorit(WebDriver driver, AccurateModule modul) {
//		String xpath = modul.getXpath() + "//div[@class='tile-content icon']/i[@class='icon-briefcase-2']";
		//ui baru
		String xpath = modul.getXpath() + "//*[@id='btnOthers']";
		log.info("dropdown xpath: " + xpath);
		AccTool.click(driver, xpath);

//		String xpath = modul.getXpath() + "//*[contains(@class,'dropdown-menu')]//span[contains(text(),'Tambah ke Favorit')]";
		//ui baru
		String xpath1 = "//*[contains(@class,'dropdown-menu')]//span[.='Tambah ke Favorit']";
		WaitTool.waitForElementVisible(driver, By.xpath(modul.getXpath() + xpath1), 5);
		AccTool.click(driver, modul.getXpath() + xpath1);
	}

	public static void tambahGambar(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnAddImage']");
	}

	public static void hapusListData(WebDriver driver, String xpath) {
		AccTool.click(driver, xpath + "//button[@name='btnDelete']");
		AccTool.waitProgressBar(driver);
		// AccTool.waitLoadingMask(driver);
	}

	public static void klikTutupDokumen(WebDriver driver, String xpath) {
		String path = xpath + "//button[@name='btnClose']";
		AccTool.click(driver, path);
		// WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikTutupKomentar(WebDriver driver, String xpath) {
		String path = xpath + "//button[@class='btn-close']";
		AccTool.click(driver, path);
	}

	public static void klikSaveKomentar(WebDriver driver, String xpath) {
		String path = xpath + "//button[@name='btnSave']";
		AccTool.click(driver, path);
	}

	public static void tambahKeTransaksiBerulang(WebDriver driver, AccurateModule modul) {
//		String xpath = modul.getXpath() + "//div[@class='tile-content icon']/i[@class='icon-briefcase-2']";
		//ui baru
		String xpath = modul.getXpath() + "//*[@id='btnOthers']";
		log.info("dropdown xpath: " + xpath);
		AccTool.click(driver, xpath);

		String xpath1 = "//*[contains(@class,'dropdown-menu')]//span[contains(text(),'Transaksi Berulang')]";
		WaitTool.waitForElementVisible(driver, By.xpath(modul.getXpath() + xpath1), 5);
		AccTool.click(driver, modul.getXpath() + xpath1);
	}

	public static void LihatLogAktivitas(WebDriver driver, AccurateModule modul) {
//		String xpath = modul.getXpath() + "//div[@class='tile-content icon']/i[@class='icon-briefcase-2']";
		//ui baru
		String xpath = modul.getXpath() + "//*[@id='btnOthers']";
		log.info("dropdown xpath: " + xpath);
		AccTool.click(driver, xpath);

		String xpath1 = "//*[contains(@class,'dropdown-menu')]//span[contains(text(),'Log Aktifitas')]";
		WaitTool.waitForElementVisible(driver, By.xpath(modul.getXpath() + xpath1), 5);
		AccTool.click(driver, modul.getXpath() + xpath1);
		AccTool.waitLoadingMask(driver);
	}

	public static void klikTanggalFilter(WebDriver driver, AccurateModule modul) {
		// klikListData(driver, modul);
		String xpath = modul.getXpath()
				+ "//*[contains(@id,'accurate__dynamic-filter')]//*[contains(text(),'Tanggal')]";
		AccTool.click(driver, xpath);
	}

	public static void klikDeleteSerialNumber(WebDriver driver, Integer urutan) {
		String path = "//*[contains(@id,'tab-serial-number')]//div[contains(@class, 'slick-row')][" + urutan
				+ "]//button[@class = 'danger']";
		AccTool.click(driver, path);
	}

	public static void klikPindahTabModule(WebDriver driver, AccurateModule module) {
		String namamodul = "//a[contains(@href, '" + module.getId() + "')]";
		AccTool.click(driver, namamodul);
	}

	public static void klikTampilkanLaporan(WebDriver driver) {
		AccTool.click(driver, "//div[contains(@id, 'accurate__report__report-input')]//button[@name='btnShowReport']");
	}

	public static void klikTuTupPopUpBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}

	// 23 Juli 2019 Penambahan klik =ajukan persetujuan & klikajukan untuk
	// persetujuan

	public static void klikAjukanPersetujuan(WebDriver driver, AccurateModule module) {
//		AccTool.click(driver, module.getXpath() + "//i[@class='icon-floppy']");
		//ui baru
		AccTool.click(driver, module.getXpath() + "//*[@id='btnSave']/ancestor::div[contains(@class,'btn-save')]//div[contains(@class,'dropdown-toggle btn-dropdown')]");
		
	
		String xpath1 = "//*[contains(@class,'dropdown-menu')]//span[contains(text(),'Ajukan Persetujuan')]";
		String xpath2 = "//*[contains(@class,'dropdown-menu')]//span[contains(text(),'Ajukan Persetujuan')]";
		WaitTool.waitForElementVisible(driver, By.xpath(module.getXpath() + xpath1), 5);
		AccTool.click(driver, module.getXpath() + xpath2);
	}

	public static void klikAjukan(WebDriver driver) {
//		String xpath = "//*[contains(@id,'approval-description')]//*[@name='btnSave']";
		//new ui
		String xpath = "//button[.='Ajukan']";

		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 6);
		AccTool.waitLoadingMask(driver);
		AccTool.waitProgressBar(driver);
	}

	// 30 Juli 2019 klik edit di indikator notifikasi

	public static void klikIndikatorEdit(WebDriver driver) {
		AccTool.click(driver, "//div[contains(@class,'queue-indicator')]");
		WaitTool.waitForElementVisible(driver, By.xpath("//div[@class='queue-item']"), 40);
		AccTool.click(driver, "//div[@class='queue-content']//button[text()='Edit']");
	}

	// 18 Oktober 2019 refresh browser untuk buat SI yang pakai approval yang lebih
	// dari 1
	public static void refreshBrowser(WebDriver driver) {
		driver.navigate().refresh();
		WaitTool.waitDOMReady(driver);
		Boolean isTabBeritaPresent = driver.findElements(By.xpath(
				"//ul[contains(@class, 'module-switcher tabs')]//a[@href='#module-accurate__company__news-page']"))
				.size() > 0;
		if (isTabBeritaPresent) {
			WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.BERITA.getXpath()), 5);
			NavigationTool.klikTutupModule(driver, AccurateModule.BERITA);
			log.info("tutup tab berita");
		}
	}

	// klik tab Data Baru paling kiri setelah klik edit di indikator notifikasi
	public static void klikTutupTabDataPalingKiri(WebDriver driver, AccurateModule module, String tabTitle) {
		AccTool.click(driver, module.getXpath() + "//div[contains(@class,'button large')][1]");
		WaitTool.delay(1000);
		AccTool.click(driver,
				module.getXpath() + "//div[contains(@class,'button large')][1]/label[span[contains(@title,'" + tabTitle
						+ "')]]/following-sibling::button/i[contains(@class,'icon-cancel')]");
		AccTool.waitGridMask(driver, true);
		AccTool.waitLoadingMask(driver);
	}

	public static void klikLogoAccurate(WebDriver driver) {
//		AccTool.click(driver, "//a[@class = 'element accurate-logo']");
		//new ui
		AccTool.click(driver, "//a[contains(@class,'element accurate-logo')]");
	}

	public static void klikTutupTabReportPalingKiri(WebDriver driver) {
		String button = "//div[contains(@id, 'accurate__report__report')]/div[@class='module-tab']/div[1]/button";
		WaitTool.waitForElementClickable(driver, By.xpath(button), 2);
		AccTool.click(driver, button);
	}

	public static void klikModulKategoriKeuangan(WebDriver driver, String menuName) {
		String index;
		String nama;

		index = "//nav[@class='vertical-menu'] //div[contains(@class,'sub-menu')] //span[text()='"
				+ menuName
				+ "'] /ancestor::div[contains(@class, 'sub-menu')]/preceding-sibling::a[contains(@class, 'bg-hover-red-aol')]";
		nama = "//nav[@class='vertical-menu'] //div[contains(@class,'sub-menu')] //span[text()='"
				+ menuName + "']";

		// Tunggu loading mask hilang
		AccTool.waitLoadingMask(driver);
		WaitTool.waitForElementVisible(driver, By.xpath(index), 10);
		AccTool.click(driver, index);
		AccTool.click(driver, nama);

		log.info("Menu " + menuName + " sudah diklik");

		// tunggu sampai sub menu hilang
		WaitTool.waitForElementDisapear(driver, By.xpath("//div[contains(@class,'sub-menu')]"), 20);
		log.info("Sub Menu sudah hilang");

		// cek apakah menu tersebut sudah tampil
		WaitTool.waitForElementVisible(driver, By.xpath("//a[text()='" + menuName + "']"), 100);
		AccTool.waitLoadingMask(driver);
		AccTool.waitGridMask(driver);
		log.info("Menu " + menuName + " telah terbuka");

		// WaitTool.waitForElementDisapear(driver,
		// By.xpath("//div[@class='window-overlay'"), 2);
	}

	public static void klikRancanganFormulir(WebDriver driver, AccurateModule module) {
		String w = module.getXpath();
		String button = w + "//button[starts-with(@id, 'btn-form-template')]";
		WaitTool.waitForElementClickable(driver, By.xpath(button), 5);
		AccTool.click(driver, button);
	}

	public static void klikImportFromXLS(WebDriver driver, AccurateModule module) {
		String w = module.getXpath();
		String buttonImport = w + "//button[@name='btnImport']";
		String importXLS = buttonImport + "/following-sibling::ul//a[contains(@data-bind, 'importXls()')]";
		WaitTool.waitForElementClickable(driver, By.xpath(buttonImport), 5);
		AccTool.click(driver, buttonImport);
		WaitTool.waitForElementClickable(driver, By.xpath(importXLS), 5);
		AccTool.click(driver, importXLS);
	}

	public static void klikBrowseAndSelectFile(WebDriver driver, String filename) {
		String getpath = System.getProperty("user.dir");
		String sourcedir = getpath + "\\sourcedir\\";
		String xlsfile = sourcedir + filename;
		String buttonbrowsefile = "//button[@class='btn-file']";
		log.info("path to file: " + xlsfile);

		WaitTool.waitForElementClickable(driver, By.xpath(buttonbrowsefile), 3);
		AccTool.click(driver, buttonbrowsefile);
		WaitTool.delay(700);

		StringSelection ss = new StringSelection(xlsfile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WaitTool.delay(700);
	}

	public static void klikUnggah(WebDriver driver) {
		String buttonUnggah = "//div[@class='import-wizard']//button[starts-with(@id, 'btnNext')]";
		WaitTool.waitForElementClickable(driver, By.xpath(buttonUnggah), 3);
		AccTool.click(driver, buttonUnggah);
		AccTool.waitLoadingMask(driver);
	}

	public static void klikMulaiImpor(WebDriver driver) {
		String w = AccurateModule.IMPOR_FAKTUR_PENJUALAN.getXpath();
		String buttonTutup = "//button[starts-with(@id, 'btnNext') and text()='Tutup']";
		String buttonMulaiImpor = w + "//button[starts-with(@id, 'btnNext')]";
		WaitTool.waitForElementClickable(driver, By.xpath(buttonMulaiImpor), 3);
		AccTool.click(driver, buttonMulaiImpor);
		WaitTool.waitForElementClickable(driver, By.xpath(buttonTutup), 600);
	}

	public static void clickCalculatorButton(WebDriver driver, String value) {
	
		ArrayList<String> keystrokes = new ArrayList<String>();
		String xpath = "//div[@class='calculator-popup']";
		if (value != null) {
			if (value.toLowerCase() == "bs") {
				AccTool.click(driver, xpath + "//button[@data-keystroke='BS']");
			}
			if (value.toLowerCase() == "ce") {
				AccTool.click(driver, xpath + "//button[@data-keystroke='CE']");
			}
			if (value.toLowerCase() == "ca") {
				AccTool.click(driver, xpath + "//button[@data-keystroke='CA']");
			}
			if (value.toLowerCase() == "close") {
				AccTool.click(driver, xpath + "//button[@data-keystroke='@X']");
			}
			if (value.toLowerCase() == "use") {
				AccTool.click(driver, xpath + "//button[@data-keystroke='@U']");
			}
			if (value.toLowerCase() == "erase") {
				AccTool.click(driver, xpath + "//button[@data-keystroke='@E']");
			} else {
				int value_length = value.length();
				for (int i = 0; i < (value_length - 1); i++) {
					keystrokes.add(value.substring(i, i + 1));
					switch (keystrokes.get(i)) {
					case "0":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_0']");
						break;
					case "1":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_1']");
						break;
					case "2":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_2']");
						break;
					case "3":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_3']");
						break;
					case "4":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_4']");
						break;
					case "5":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_5']");
						break;
					case "6":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_6']");
						break;
					case "7":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_7']");
						break;
					case "8":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_8']");
						break;
					case "9":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_9']");
						break;
					case ".":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_.']");
						break;
					case "+":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_+']");
						break;
					case "-":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_-']");
						break;
					case "*":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_*']");
						break;
					case "/":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_/']");
						break;
					case "=":
						AccTool.click(driver, xpath + "//button[@data-keystroke='_=']");
						break;
					}
				}
			}
		}
	}
	
	public static void klikOK(WebDriver driver) {
		AccTool.click(driver, "//div[contains(@id, 'info-dialog')]//button[@name='btnOk' and text()='OK']");
		WaitTool.waitForElementDisapear(driver,
				By.xpath("//div[contains(@id, 'info-dialog')]//button[@name='btnOk' and text()='OK']"), 7);
	}
	
	
	public static void klikListBarisUrutan(WebDriver driver, int urutan) {
		AccTool.click(driver, "//div[contains(@id,'module-grid-list')]//div[@class='grid-canvas']/div["+ urutan +"]");
		AccTool.waitLoadingMask(driver);
	}
	
	
	public static void klikLupapassword(WebDriver driver) {
		AccTool.click(driver, "//a[text()='Lupa Password?']");
		WaitTool.waitForElementVisible(driver,
				By.xpath("//input[@id='account']"), 7);
	}
	
	public static void inputEmailAkun(WebDriver driver, String email) {
		AccTool.textField(driver, "", "@name='account'", email);
	}
	
	public static void klikResetPassword(WebDriver driver) {
		AccTool.click(driver, "//button[.='Reset Password']");
		WaitTool.waitForElementVisible(driver,
				By.xpath("//h2[.='Informasi reset password']"), 7);
		AccTool.click(driver, "//button[.='OK']");
	}

}