package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pelanggan.PelangganParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PelangganTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PelangganTool.class);

	public static void hapusSaldo(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-open-balance')]//*[@name='btnDelete']");
		WaitTool.waitForElementDisapear(driver, By.xpath("//*[contains(@id,'detail-open-balance')]//*[@name='btnDelete']"), 6);
	}

	public static void klikTulisanJumlah(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-open-balance')]//*[text()='Jumlah']");
	}

	public static void klikLanjutSaldo(WebDriver driver) {
		String xpath = "//*[starts-with(@id,'detail-open-balance')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 10);
	}

	public static void klikButtonLanjutAlamatLainnya(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-ship-address')]//*[@name='btnNext']");
	}

	public static void klikTabUmum(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PELANGGAN.getXpath() + "//a[text()='Umum']");
	}

	public static void klikTabKontak(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PELANGGAN.getXpath() + "//a[text()='Kontak']");
	}

	public static void klikTabPenjualan(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PELANGGAN.getXpath() + "//a[text()='Penjualan']");
	}

	public static void klikTabPajak(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PELANGGAN.getXpath() + "//a[text()='Pajak']");
	}

	public static void klikTabSaldo(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PELANGGAN.getXpath() + "//a[text()='Saldo Piutang']");
	}

	public static void klikTabPengiriman(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PELANGGAN.getXpath() + "//a[text()='Pengiriman']");
	}

	public static void klikTabLainlain(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PELANGGAN.getXpath() + "//a[text()='Lain-lain']");
	}

	public static void klikTabPiutang(WebDriver driver) {
		AccTool.click(getWebDriver(), AccurateModule.PELANGGAN.getXpath() + "//a[text()='Piutang']");
	}

	public static void klikRefreshPiutang(WebDriver driver, AccurateModule module) {
		String tab = AccurateModule.PELANGGAN.getXpath() + "//div [starts-with(@id, 'tab-history')]";
		AccTool.click(driver, tab + "//button[@name='btnRefresh']");
	}

	public static void klikGridBaris1(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'opening-balance-grid-list')]//*[@class='grid-canvas']/div[1]");
	}

	public static void klikGridBaris2(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'opening-balance-grid-list')]//*[@class='grid-canvas']/div[2]");
	}

	public static void klikGridBaris3(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'opening-balance-grid-list')]//*[@class='grid-canvas']/div[3]");
	}

	public static void klikGridBaris4(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'opening-balance-grid-list')]//*[@class='grid-canvas']/div[4]");
	}

	public static void klikButtonPensilSaldo(WebDriver driver) {
//		String tab = "//div[starts-with(@id,'detail-open-balance')]";
		AccTool.click(driver, "//div[contains(@id, 'detail-open-balance')]//span[contains(@class, 'toggle-slider round')]");
	}
	// 25 Juli 2018 untuk tutup detail saldo
	
	public static void klikButtonCloseTabDetailSaldo(WebDriver driver) {
		String path = "//*[text()='Piutang Awal']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}

	public static void isiForm(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.IsiForm");

		String w = AccurateModule.PELANGGAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Umum']");

		if (param.kategori != null)
			AccTool.lookup(driver, tab, "@name='category'", param.kategori);
		if (param.penomoran != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.penomoran);
		if (param.no != null)
			AccTool.textField(driver, tab, "@name='customerNo'", param.no);
		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);
		if (param.email != null)
			AccTool.textField(driver, tab, "@name='email'", param.email);
		if (param.telepon != null)
			AccTool.textField(driver, tab, "@name='workPhone'", param.telepon);
		if (param.faksimili != null)
			AccTool.textField(driver, tab, "@name='fax'", param.faksimili);
		if (param.web != null)
			AccTool.textField(driver, tab, "@name='website'", param.web);
		if (param.kontakutama != null)
			AccTool.textField(driver, tab, "@name='contact'", param.kontakutama);
		if (param.defmatauang != null)
			AccTool.lookup(driver, tab, "@name='currency'", param.defmatauang);
		if (param.cabangdipakai != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabangdipakai);
		if (param.penagihanjalan != null)
			AccTool.textarea(driver, tab, "@name='billStreet'", param.penagihanjalan);
		if (param.penagihankota != null)
			AccTool.textField(driver, tab, "@name='billCity'", param.penagihankota);
		if (param.penagihankodepos != null)
			AccTool.textField(driver, tab, "@name='billZipCode'", param.penagihankodepos);
		if (param.penagihanpropinsi != null)
			AccTool.textField(driver, tab, "@name='billProvince'", param.penagihanpropinsi);
		if (param.penagihannegara != null)
			AccTool.textField(driver, tab, "@name='billCountry'", param.penagihannegara);
	}

	public static void isiPengiriman(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.IsiPengiriman");

		String w = AccurateModule.PELANGGAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-ship-address')]";

		AccTool.click(driver, w + "//a[text()='Alamat Pengiriman']");

		if (param.cbsamadenganpenagihan != null)
			AccTool.checkbox(driver, tab, "@name='shipSameAsBill'", param.cbsamadenganpenagihan);
		if (param.pengirimanjalan != null)
			AccTool.textarea(driver, tab, "@name='shipStreet'", param.pengirimanjalan);
		if (param.pengirimankota != null)
			AccTool.textField(driver, tab, "@name='shipCity'", param.pengirimankota);
		if (param.pengirimankodepos != null)
			AccTool.textField(driver, tab, "@name='shipZipCode'", param.pengirimankodepos);
		if (param.pengirimanpropinsi != null)
			AccTool.textField(driver, tab, "@name='shipProvince'", param.pengirimanpropinsi);
		if (param.pengirimannegara != null)
			AccTool.textField(driver, tab, "@name='shipCountry'", param.pengirimannegara);
	}

	public static void isiAlamatLainnya(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.IsiPengiriman");

		// String w = AccurateModule.PELANGGAN.getXpath();
		// String tab = w + "//*[contains(@id,'tab-ship-address')]";
		String tab = "//*[contains(@id,'detail-ship-address')]";

		if (param.jalan != null)
			AccTool.textarea(driver, tab, "@name='street'", param.jalan);
		if (param.kota != null)
			AccTool.textField(driver, tab, "@name='city'", param.kota);
		if (param.kodepos != null)
			AccTool.textField(driver, tab, "@name='zipCode'", param.kodepos);
		if (param.propinsi != null)
			AccTool.textField(driver, tab, "@name='province'", param.propinsi);
		if (param.negara != null)
			AccTool.textField(driver, tab, "@name='country'", param.negara);
	}

	public static void isiKontak(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.DetailKontak");

		String tab = "//*[contains(@id,'tab-contact')]";

		// AccTool.click(driver, "//a[text()='Kontak']");

		if (param.namakontak != null)
			AccTool.textField(driver, tab, "@name='name'", param.namakontak);
		if (param.sapaan != null)
			AccTool.combobox(driver, tab, "@name='salutation'", param.sapaan);
		if (param.jabatan != null)
			AccTool.textField(driver, tab, "@name='position'", param.jabatan);
		if (param.handphone != null)
			AccTool.textField(driver, tab, "@name='mobilePhone'", param.handphone);
		if (param.pinbbm != null)
			AccTool.textField(driver, tab, "@name='bbmPin'", param.pinbbm);
		if (param.email != null)
			AccTool.textField(driver, tab, "@name='email'", param.email);

	}

	public static void isiPenjualan(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.IsiPenjualan");

		String w = AccurateModule.PELANGGAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-sales')]";

		AccTool.click(driver, w + "//a[text()='Penjualan']");

		if (param.kategoriharga != null)
			AccTool.lookup(driver, tab, "@name='priceCategory'", param.kategoriharga);
		if (param.kategoridiskon != null)
			AccTool.lookup(driver, tab, "@name='discountCategory'", param.kategoridiskon);
		if (param.syaratpembayaran != null)
			AccTool.lookup(driver, tab, "@name='term'", param.syaratpembayaran);
		if (param.defaultpenjual != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='salesmanList'", param.defaultpenjual);
		if (param.defaultdiskon != null)
			AccTool.textField(driver, tab, "@name='defaultSalesDisc'", param.defaultdiskon);
		if (param.defaultdeskripsi != null)
			AccTool.textField(driver, tab, "@name='defaultInvoiceDesc'", param.defaultdeskripsi);
		if (param.cbkonsinyasi != null)
			AccTool.checkbox(driver, tab, "@name='consignmentStore'", param.cbkonsinyasi);
		if (param.akunpiutang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='customerReceivableAccountList'", param.akunpiutang);
		if (param.akunuangmuka != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='customerDownPaymentAccountList'", param.akunuangmuka);
	}

	public static void isiPajak(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.IsiPajak");

		String w = AccurateModule.PELANGGAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-tax')]";

		AccTool.click(driver, w + "//a[text()='Pajak']");

		if (param.cbtotaltermasukpajak != null)
			AccTool.checkbox(driver, tab, "@name='defaultIncTax'", param.cbtotaltermasukpajak);
		if (param.npwp != null) {
			AccTool.textField(driver, tab, "@name='npwpNo'", param.npwp);
			AccTool.click(driver, w + "//a[text()='Pajak']");
			//WaitTool.delay(300);
			WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
		}
		if (param.nppkp != null)
			AccTool.textField(driver, tab, "@name='pkpNo'", param.nppkp);
		if (param.nonik != null)
			AccTool.textField(driver, tab, "@name='idCard'", param.nonik);
		if (param.tipepajak != null)
			AccTool.combobox(driver, tab, "@name='customerTaxType'", param.tipepajak);
		if (param.cbsamadenganpenagihan != null)
			AccTool.checkbox(driver, tab, "@name='taxSameAsBill'", param.cbsamadenganpenagihan);
		else {
			if (param.jalan != null)
				AccTool.textarea(driver, tab, "@name='taxStreet'", param.jalan);
			if (param.kota != null)
				AccTool.textField(driver, tab, "@name='taxCity'", param.kota);
			if (param.propinsi != null)
				AccTool.textField(driver, tab, "@name='taxProvince'", param.propinsi);
			if (param.kodepos != null)
				AccTool.textField(driver, tab, "@name='taxZipCode'", param.kodepos);
			if (param.negara != null)
				AccTool.textField(driver, tab, "@name='taxCountry'", param.negara);
		}
	}

	public static void isiSaldo(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.IsiSaldo");

		String tab = "//div[starts-with(@id,'detail-open-balance')]";

		AccTool.click(driver, tab);
		if (param.matauang != null)
			AccTool.lookup(driver, tab, "@name='currency'", param.matauang);
		if (param.rate != null)
			AccTool.numberField(getWebDriver(), tab, "@name='rate'", param.rate);
		if (param.tanggal != null)
			AccTool.datePicker(driver, tab, "@name='asOf'", param.tanggal);
		if (param.nomorsaldo != null)
			AccTool.textField(driver, tab, "@name='number'", param.nomorsaldo);
		if (param.syaratpembayaran != null)
			AccTool.lookup(driver, tab, "@name='paymentTerm'", param.syaratpembayaran);
		if (param.penomoransaldo != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.penomoransaldo);
		if (param.jumlah != null)
			AccTool.numberField(driver, tab, "@name='amount'", param.jumlah);
		if(param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		AccTool.click(driver, tab + "//*[text()='Jumlah']");
		
	}
	

	public static void isiLainLain(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.IsiLainLain");

		String tab = AccurateModule.PELANGGAN.getXpath() + "//*[contains(@id,'tab-others')]";

		// AccTool.click(driver, w + "//a[text()='Lain-lain']");

		if (param.cbfakturbelumlunas != null)
			AccTool.checkbox(driver, tab, "@name='customerLimitAge'", param.cbfakturbelumlunas);
		if (param.nilaifakturbelumlunas != null)
			AccTool.numberField(driver, tab, "@name='customerLimitAgeValue'", param.nilaifakturbelumlunas);
		if (param.cbtotalpiutangpesanan != null)
			AccTool.checkbox(driver, tab, "@name='customerLimitAmount'", param.cbtotalpiutangpesanan);
		if (param.nilaitotalpiutangpesanan != null)
			AccTool.numberField(driver, tab, "@name='customerLimitAmountValue'", param.nilaitotalpiutangpesanan);
		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='notes'", param.catatan);
		if (param.cbtidakaktiv != null)
			AccTool.checkbox(driver, tab, "@name='suspended'", param.cbtidakaktiv);		
		
		if (param.pelanggan != null) {
			AccTool.radioButton(driver, tab, "@name='groupCustomerLimit'", param.pelanggan);
			
			if (param.cblimitpelanggan != null) {
				AccTool.checkbox(driver, tab, "@name='customerLimitAge'", param.cblimitpelanggan);
				AccTool.click(driver,  "//a[.='Lain-lain']");
				if (param.limitpelanggan != null) {
					AccTool.numberField(driver,  "", "@name='customerLimitAgeValue'", param.limitpelanggan);
				}
				}
			if (param.cbtotalpiutang != null) {
				AccTool.checkbox(driver, tab, "@name='customerLimitAmount'", param.cbtotalpiutang);
				WaitTool.delay(500);
				if (param.totalpiutang != null) {
					AccTool.numberField(driver, tab, "@name='customerLimitAmountValue'", param.totalpiutang);
				}
				}
			}
		
		if (param.pelangganinduk != null) {
			AccTool.radioButton(driver, "//div[@class='general-tab-content frame active']/div[@class='grid fluid no-margin']//div[@class='grid fluid no-margin']/div[contains(.,'Tergabung ke Pelanggan Induk')]", "@name='groupCustomerLimit'", param.pelangganinduk);
			
			if (param.namapelangganinduk != null)
				AccTool.lookup(driver, tab, "@name='referenceCustomerLimit'", param.namapelangganinduk );
			}
		}

	public static void isiPengguna(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.IsiPengguna");

		String w = AccurateModule.PELANGGAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-users')]";

		AccTool.click(driver, w + "//a[text()='Pengguna']");

		if (param.cbsemuapengguna != null)
			AccTool.checkbox(driver, tab, "@name='usedAllUser'", param.cbsemuapengguna);
		if (param.grupcabang != null)
			AccTool.lookup(driver, tab, "@name='useUserRoleAccessList'", param.grupcabang);
		if (param.pengguna != null)
			AccTool.lookup(driver, tab, "@name='useUserAccessList'", param.pengguna);
	}

	public static void isiPiutang(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.IsiPiutang");

		String w = AccurateModule.PELANGGAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-history')]";

		AccTool.click(driver, w + "//a[text()='Piutang']");

		if (param.daritanggal != null)
			AccTool.datePicker(driver, tab, "@name='fromDate'", param.daritanggal);
		if (param.ketanggal != null)
			AccTool.datePicker(driver, tab, "@name='toDate'", param.ketanggal);
		if (param.matauang != null)
			AccTool.combobox(driver, tab, "@name='historyCurrencyId'", param.matauangpiutang);
	}

	public static void detailAlamat(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.DetailAlamat");

		String w = "//div[starts-with(@id,'detail-ship-address')]";
		AccTool.click(driver, w);

		if (param.jalan != null)
			AccTool.textarea(driver, w, "@name='street'", param.jalan);
		if (param.kota != null)
			AccTool.textField(driver, w, "@name='city'", param.kota);
		if (param.kodepos != null)
			AccTool.textField(driver, w, "@name='zipCode'", param.kodepos);
		if (param.propinsi != null)
			AccTool.textField(driver, w, "@name='province'", param.propinsi);
		if (param.negara != null)
			AccTool.textField(driver, w, "@name='country'", param.negara);
	}

	public static void detailKontak(WebDriver driver, PelangganParam param) {
		log.info("Pelanggan.DetailKontak");

		String w = "//div[starts-with(@id,'detail-contact')]";
		AccTool.click(driver, w);

		if (param.sapaan != null)
			AccTool.combobox(driver, w, "@name='salutation'", param.sapaan);
		if (param.nama != null)
			AccTool.textField(driver, w, "@name='name'", param.nama);
		if (param.jabatan != null)
			AccTool.textField(driver, w, "@name='position'", param.jabatan);
		if (param.email != null)
			AccTool.textField(driver, w, "@name='email'", param.email);
		if (param.handphone != null)
			AccTool.textField(driver, w, "@name='mobilePhone'", param.handphone);
		if (param.teleponbisnis != null)
			AccTool.textField(driver, w, "@name='workPhone'", param.teleponbisnis);
		if (param.faksimili != null)
			AccTool.textField(driver, w, "@name='fax'", param.faksimili);
		if (param.teleponrumah != null)
			AccTool.textField(driver, w, "@name='homePhone'", param.teleponrumah);
		if (param.pinbbm != null)
			AccTool.textField(driver, w, "@name='bbmPin'", param.pinbbm);
		if (param.web != null)
			AccTool.textField(driver, w, "@name='website'", param.web);
		if (param.catatan != null)
			AccTool.textarea(driver, w, "@name='notes'", param.catatan);
	}

	public static void isiDetailPiutang(WebDriver driver, PelangganParam param) {
		String tab = AccurateModule.PELANGGAN.getXpath() + "//*[contains(@id, '#tab-history')]";
		if (param.tglpiutangdari != null)
			AccTool.datePicker(driver, tab, "fromDate", param.tglpiutangdari);
		if (param.tglpiutangsampai != null)
			AccTool.datePicker(driver, tab, "toDate", param.tglpiutangsampai);
		if (param.matauangpiutang != null)
			AccTool.combobox(driver, tab, "historyCurrencyId", param.matauangpiutang);
	}

	public static void saveIsiUmum(WebDriver driver, String filename) {
		log.info("Pelanggan.SaveIsiUmum");

		String tab = "//*[contains(@id,'tab-general')]";
		String content = "Pelanggan.SaveInformasiUmum : " + "\r\n";

		content = content + "\r\n" + "Kategori : " + AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.LOOKUP, "category", tab) 
				+ "ID Pelanggan : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "customerNo", tab) 
				+ "Nama : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "name", tab) 
				+ "Email : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "email", tab) 
				+ "Telepon : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "workPhone", tab) 
				+ "Faximili : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "fax", tab) 
				+ "Website : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "website", tab) 
				+ "Mata Uang Utama : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.LOOKUP, "currency", tab);

				  String namacabang = "//*[contains(@id,'tab-general')]//select[@name = 'branch']";
		        	if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.COMBOBOX, "branch", tab);
		        } else {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.SUMMARY, "customerBranchName", tab);
		        }

		        content = content
		        + "Penagihan Jalan : "		
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTAREA, "billStreet", tab) 
				+ "Penagihan Kota : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "billCity", tab) 
				+ "Penagihan Kode Pos : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "billZipCode", tab) 
				+ "Penagihan Propinsi : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "billProvince", tab) 
				+ "Penagihan Negara : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "billCountry", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiPengiriman(WebDriver driver, String filename) {
		log.info("Pelanggan.SaveIsiPengiriman");

		String tab = "//*[contains(@id,'tab-ship-address')]";
		String content = "Pelanggan.SavePengiriman : " + "\r\n";

		content = content  + "\r\n" + "Sama Dengan Penagihan : " + AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.CHECKBOX, "shipSameAsBill", tab)
				+ "Pengiriman Jalan : " + AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTAREA, "shipStreet", tab) + "Pengiriman Kota : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "shipCity", tab) + "Pengiriman Kode Pos : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "shipZipCode", tab) + "Pengiriman Propinsi : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "shipProvince", tab) + "Pengiriman Negara : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "shipCountry", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiAlamatLainnya(WebDriver driver, String filename) {
		log.info("Pelanggan.SaveIsiPengiriman");

		String tab = "//*[contains(@id,'detail-ship-address')]";
		String content = "Pelanggan.SaveAlamatLainnya : " + "\r\n";
		content = content +  "\r\n" + "Jalan : " + AccTool.getTextValue(driver, ElementType.TEXTAREA, "street", tab) + "Kota : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "city", tab) + "Kode Pos : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "zipCode", tab) + "Propinsi : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "province", tab) + "Negara : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "country", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiKontak(WebDriver driver, String filename) {

		String tab = "//*[contains(@id,'tab-contact')]";
		String content = "Pelanggan.SaveKontak : " + "\r\n";
		content = content  + "\r\n" + AccTool.getGridValue(driver, AccurateModule.PEMASOK, tab);
		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailKontak(WebDriver driver, String filename) {
		String tab = "//div[starts-with(@id,'detail-contact')]";
		String content = "Pelanggan.SaveDetailKontak : " + "\r\n";
		content = content + "\r\n" + "\r\n" + "Sapaan : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "salutation", tab) + "Nama : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "name", tab) + "Jabatan : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "position", tab) + "Email : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "email", tab) + "Handphone : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "mobilePhone", tab) + "Telepon Bisnis : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "workPhone", tab) + "Faksmili : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "fax", tab) + "Telepon Rumah : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "homePhone", tab) + "Pin BBM : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "bbmPin", tab) + "Web : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "website", tab) + "Catatan : " + AccTool.getTextValue(driver, ElementType.TEXTAREA, "notes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiSaldo(WebDriver driver, String filename) {
		String tab = "//*[contains(@id,'tab-balance')]";
		String content = "Pelanggan.SaveSaldo : " + "\r\n";
		content = content  + "\r\n" + AccTool.getGridValue(driver, AccurateModule.PELANGGAN, tab);
		AccTool.writeTextFile(filename, content);
	}
	
	// 30 Juli 2018 tambah metod untuk OB
	
	public static void saveOB(WebDriver driver, String filename) {
		String tab = "//*[contains(@id,'tab-balance')]";
		String content = "SALDO "+ "\r\n";
		content = content  + "\r\n" 
		+ AccTool.getTextValue(driver, ElementType.LABEL, "text: $data.balanceCode", tab) 
		+ "\r\n" 
		+AccTool.getTextValue(driver, ElementType.LABEL, "text: app.util.parseNumberBalance($data.balance)", tab) + "\r\n"
		+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailSaldo(WebDriver driver, String filename) {
		String tab = "//div[starts-with(@id,'detail-open-balance')]";
		String content = "Pelanggan.SaveDetailSaldo : " + "\r\n";
		content = content + "\r\n" + "Mata Uang : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.currency().name", tab) + "Tanggal : "
				+ AccTool.getTextValue(driver, ElementType.DATEPICKER, "asOf", tab) + "Jumlah : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amount", tab) + "Keterangan : "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "description", tab)
				+ "Cabang : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "branch", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	public static void savePiutang(WebDriver driver, String filename) {
		log.info("Penjualan.SavePiutang");

		String content = "Penjualan.SaveListPiutang : " + "\r\n";
		String tab = "//*[contains(@id,'tab-history')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.PELANGGAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}

	public static void saveIsiPenjualan(WebDriver driver, String filename) {

		String tab = "//*[contains(@id,'tab-sales')]";
		String content = "Pelanggan.SavePenjualan : " + "\r\n";
		content = content + "\r\n" + "Kategori Harga : " + AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.LOOKUP, "priceCategory", tab) + "Syarat Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.LOOKUP, "term", tab) + "Penjual : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.LOOKUP, "salesmanList", tab) + "Diskon : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.NUMBERFIELD, "defaultSalesDisc", tab) + "Deskripsi : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "defaultInvoiceDesc", tab) + "Konsinyasi	: "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.CHECKBOX, "consignmentStore", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiPajak(WebDriver driver, String filename) {

		String tab = "//*[contains(@id,'tab-tax')]";
		String content = "Pelanggan.SavePajak : " + "\r\n";
		content = content

			    + "\r\n" + "Total Termasuk Pajak : " + AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.CHECKBOX, "defaultIncTax", tab) + "NPWP	: "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "npwpNo", tab) + "NPPKP : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "pkpNo", tab) + "NO NIK : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "idCard", tab) + "Tipe Pajak : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.COMBOBOX, "customerTaxType", tab) + "Sama Dengan Penagihan : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.CHECKBOX, "taxSameAsBill", tab) + "Pajak Jalan : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTAREA, "taxStreet", tab) + "Pajak Kota : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "taxCity", tab) + "Pajak Kode Pos : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "taxZipCode", tab) + "Pajak Propinsi : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "taxProvince", tab) + "Pajak Negara : "
				+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTFIELD, "taxCountry", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiLainlain(WebDriver driver, String filename) {

		String tab = "//*[contains(@id,'tab-others')]";
		String content = "";
		String content1 = "";
		String content2 = "Pelanggan.saveIsiLainlain : " + "\r\n";
		String virtualAccount = "//span[contains(text(),'Virtual Account Pelanggan')]" ;

		content1 = content1 + "\r\n" 
					+ "Lain-lain" + "\r\n" 
					+ "Catatan : "
					+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.TEXTAREA, "notes", tab);
		
		String nonAktif = "//input[@name='suspended']";
			if (WebElementTool.isElementExists(driver, By.xpath(nonAktif))) {
				content1 = content1 + "Non Aktif : "
					+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.CHECKBOX, "suspended", tab) ;
		}	
			content1 =  content1 + "\r\n";

		
		if(WebElementTool.isElementExists(driver, By.xpath(virtualAccount)))
		{
			content = content 
					//nomor account pelanggan
					+ AccTool.getTextValue(driver, "//*[contains(@id,'customerNoVaLabel')]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "customerNoVa", tab);
			if(WebElementTool.isElementExists(driver, By.xpath("//*[contains(@id,'tab-others')]//div[3]//label[@class='inline-block']")))
			{
				content = content 
						//no va 1
						+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-others')]//div[3]//label[@class='inline-block']").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-others')]//div[3]//label[@class='inline-block']/ancestor::div[2]//*[contains(@class,'text-panel-disabled')]");		
			} 
			if(WebElementTool.isElementExists(driver, By.xpath("//*[contains(@id,'tab-others')]//div[4]//label[@class='inline-block']")))
			{
				content = content 
						//no va 2
						+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-others')]//div[4]//label[@class='inline-block']").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-others')]//div[4]//label[@class='inline-block']/ancestor::div[2]//*[contains(@class,'text-panel-disabled')]");		
			}
			if(WebElementTool.isElementExists(driver, By.xpath("//*[contains(@id,'tab-others')]//div[5]//label[@class='inline-block']")))
			{
				content = content 
						//no va 3
						+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-others')]//div[5]//label[@class='inline-block']").replace("\r\n", " : ")
						+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-others')]//div[5]//label[@class='inline-block']/ancestor::div[2]//*[contains(@class,'text-panel-disabled')]");		
			}
		}
		
		String perPelanggan =  AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "groupCustomerLimit:FALSE", tab);
		String tergabungPelanggan =  AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "groupCustomerLimit:TRUE", tab);
		
		String pembatasan = "//*[contains(text(),'Pembatasan Piutang Pelanggan')]";
		if(WebElementTool.isElementExists(driver, By.xpath(pembatasan)))
		{
			content = content 		
					+ AccTool.getTextValue(driver, "//*[contains(text(),'Pembatasan Piutang Pelanggan')]");
			
			if (perPelanggan.contains("true")) {
				content = content 		
						//jika ada faktur berumur
						+ "Per Pelanggan : "
						+ perPelanggan
						//jika ada faktur berumur
						+ "Jika ada faktur berumur lebih dari : "
						+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.CHECKBOX, "customerLimitAge", tab);
				if(WebElementTool.isElementExists(driver, By.xpath("//input[@name='customerLimitAgeValue']")))
				{
					content = content + ""
							+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.NUMBERFIELD, "customerLimitAgeValue", tab).replace("\r\n", " hari");
				} else {
					content = content + ""
							+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'parseNumber(formData.customerLimitAgeValue')]").replace("\r\n", " hari");
				}
				
				content = content 		
						//Jika total piutang
						+ "\r\n"
						+ "Jika total piutang & pesanan melebihi : "
						+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.CHECKBOX, "customerLimitAmount", tab);
				
				if(WebElementTool.isElementExists(driver, By.xpath("//input[@name='customerLimitAmountValue']")))
				{
					content = content + "Rp "
							+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.NUMBERFIELD, "customerLimitAmountValue", tab);
				} else {
					content = content + "Rp "
							+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'parseNumber(formData.customerLimitAmountValue')]");
				}
				
				if(WebElementTool.isElementExists(driver, By.xpath("//*[contains(text(),'Pelanggan-pelanggan yang tergabung')]")))
				{
					content = content + "\r\n"
							+ AccTool.getTextValue(driver, "//*[contains(text(),'Pelanggan-pelanggan yang tergabung')]")
							+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'parent.showCustomer')]");
				}
			}
			
			if (tergabungPelanggan.contains("true")) {
				content = content 		
					+ "Tergabung ke Pelanggan Induk : "
					+  tergabungPelanggan
					//look up nya 
					+ AccTool.getTextValue(driver, AccurateModule.PELANGGAN, ElementType.LOOKUP, "referenceCustomerLimit", tab);	
			}
		}

		AccTool.writeTextFile(filename, content2 + content + content1);
	}

	public static void klikHapusPenjual(WebDriver driver, String keyword) {
		AccTool.clearLookup2(getWebDriver(), "@name='salesmanList'", keyword);
	}
	
	public static void klikHapusPelangganInduk(WebDriver driver, String keyword) {
		AccTool.clearLookup2(getWebDriver(), "@name='referenceCustomerLimit'", keyword);
	}
}
