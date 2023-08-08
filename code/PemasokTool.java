package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pemasok.PemasokParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PemasokTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PemasokParam.class);

	public static void klikBtnLanjutSaldo(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-open-balance')]//*[@name='btnNext']";
		AccTool.click(getWebDriver(), xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 10);
	
	}

	// public static void klikBtnLanjutSaldo(WebDriver driver) {
	// String path = "//div[starts-with(@id,'detail-open-balance')]" +
	// "//button[@name='btnNext']";
	// AccTool.click(driver, path);
	// WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	// }

	public static void klikButtonLanjutKontak(WebDriver driver) {
		String path = "//div[starts-with(@id,'detail-contact')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}

	public static void pilihDetailKontak(WebDriver driver, PemasokParam param) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'contact-grid-list')]//div[@class='grid-canvas']/div[" + param.urutan + "]");
	}

	public static void pilihDetailSaldo(WebDriver driver, PemasokParam param) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'opening-balance-grid-list')]//div[@class='grid-canvas']/div[" + param.urutan + "]");
	}

	public static void klikbtnHapusDetailKontak(WebDriver driver) {
		String path = "//*[contains(@id,'detail-contact')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
	}

	public static void klikbtnHapusDetailSaldo(WebDriver driver) {
		String path = "//*[contains(@id,'detail-open-balance')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikHapusAkunHutang() {
		AccTool.click(getWebDriver(), "//*[contains(text(),'Akun Utang')]/parent::div//following-sibling::div//*[@class='icon-cancel-2']");
	}

	public static void klikHapusAkunUangMuka() {
		AccTool.click(getWebDriver(), "//*[contains(text(),'Akun Uang muka')]/parent::div//following-sibling::div//*[@class='icon-cancel-2']");
	}

	public static void klikTabUmum(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMASOK.getXpath() + "//a[text()='Umum']");
	}

	public static void klikTabKontak(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMASOK.getXpath() + "//a[text()='Kontak']");
	}

	public static void klikTabPembelian(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMASOK.getXpath() + "//a[text()='Pembelian']");
	}

	public static void klikTabPajak(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMASOK.getXpath() + "//a[text()='Pajak']");
	}

	public static void klikTabSaldo(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMASOK.getXpath() + "//a[text()='Saldo Utang']");
	}

	public static void klikButtonClosePopUpKontak(WebDriver driver) {
		String path = "//*[text()='Kontak']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}

	public static void klikButtonClosePopUpSaldo(WebDriver driver) {
		String path = "//*[text()='Saldo Awal']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}

	public static void klikTabLainlain(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PEMASOK.getXpath() + "//a[text()='Lain-lain']");
	}

	public static void klikTabHutang(WebDriver driver) {
		AccTool.click(getWebDriver(), AccurateModule.PEMASOK.getXpath() + "//a[text()='Hutang']");
	}

	public static void klikRefreshHutang(WebDriver driver) {
		String tab = AccurateModule.PEMASOK.getXpath() + "//*[contains(@id, '#tab-history')]";
		AccTool.click(driver, tab + "//button[@name='btnRefresh']");
	}

	public static void klikButtonPensilSaldo(WebDriver driver) {
		String tab = "//*[contains(@id,'detail-open-balance')]";
		AccTool.click(driver, tab + "//*[contains(@class,'toggle-slider round')]");
	}

	public static void klikButtonPensilPemasok(WebDriver driver) {
		String tab = "//*[contains(@id,'tab-general')]";
		AccTool.click(driver, tab + "//*[contains(@class,'toggle-slider round')]");
		AccTool.click(driver, tab);
	}

	public static void isiFormUmum(WebDriver driver, PemasokParam param) {
		String w = AccurateModule.PEMASOK.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		// AccTool.click(driver, w + "//a[text()='Umum']");

		if (param.kategori != null)
			AccTool.lookup(driver, tab, "@name='category'", param.kategori);
		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);
		if (param.idpemasok != null)
			AccTool.textField(driver, tab, "@name='vendorNo'", param.idpemasok);
		if (param.teleponbisnis != null)
			AccTool.textField(driver, tab, "@name='workPhone'", param.teleponbisnis);
		if (param.handphone != null)
			AccTool.textField(driver, tab, "@name='mobilePhone'", param.handphone);
		if (param.faksimili != null)
			AccTool.textField(driver, tab, "@name='fax'", param.faksimili);
		if (param.email != null)
			AccTool.textField(driver, tab, "@name='email'", param.email);
		if (param.web != null)
			AccTool.textField(driver, tab, "@name='website'", param.web);
		if (param.kontakutama != null)
			AccTool.textField(driver, tab, "@name='mobilePhone'", param.kontakutama);
		if (param.matauang != null)
			AccTool.lookup(driver, tab, "@name='currency'", param.matauang);
		if (param.cbpenjualjasa != null)
			AccTool.checkbox(driver, "", "@name='serviceSeller'", param.cbpenjualjasa);
		if (param.dipakaidicabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.dipakaidicabang);
		if (param.penagihanjalan != null)
			AccTool.textarea(driver, tab, "@name='billStreet'", param.penagihanjalan);
		if (param.penagihankota != null)
			AccTool.textField(driver, tab, "@name='billCity'", param.penagihankota);
		if (param.penagihanpropinsi != null)
			AccTool.textField(driver, tab, "@name='billProvince'", param.penagihanpropinsi);
		if (param.penagihankodepos != null)
			AccTool.textField(driver, tab, "@name='billZipCode'", param.penagihankodepos);
		if (param.penagihannegara != null)
			AccTool.textField(driver, tab, "@name='billCountry'", param.penagihannegara);
	}


	public static void isiDetailKontak(WebDriver driver, PemasokParam param) {
		log.info("Pemasok.DetailKontak");

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
		if (param.teleponseluler != null)
			AccTool.textField(driver, w, "@name='mobilePhone'", param.teleponseluler);
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

		// String tab = "//*[contains(@id,'detail-contact')]";
		// if(param.nama != null)
		// AccTool.textField(driver, tab, "@name='name'", param.nama);
		// if(param.sapaan != null)
		// AccTool.combobox(driver, tab, "@name='salutation'", param.sapaan);
		// if(param.jabatan != null)
		// AccTool.textField(driver, tab, "@name='position'", param.jabatan);
		// if(param.teleponseluler != null)
		// AccTool.textField(driver, tab, "@name='mobilePhone'",
		// param.teleponseluler);
		// if(param.pinbbm != null)
		// AccTool.textField(driver, tab, "@name='bbmPin'", param.pinbbm);
		// if(param.email != null)
		// AccTool.textField(driver, tab, "@name='email'", param.email);
	}

	public static void isiDetailSaldo(WebDriver driver, PemasokParam param) {
		String w = "//div[starts-with(@id,'detail-open-balance')]";
		AccTool.click(driver, w);
		if (param.matauangsaldo != null)
			AccTool.lookup(driver, w, "@name='currency'", param.matauangsaldo);
		if (param.rate != null)
			AccTool.numberField(getWebDriver(), w, "@name='rate'", param.rate);
		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='asOf'", param.tanggal);
		if (param.nomor != null)
			AccTool.textField(driver, w, "@name='number'", param.nomor);
		if (param.syaratpembayaran != null)
			AccTool.lookup(driver, w, "@name='paymentTerm'", param.syaratpembayaran);
		if (param.jumlah != null)
			AccTool.numberField(driver, w, "@name='amount'", param.jumlah);
		if(param.cabang != null)
			AccTool.combobox(driver, w, "@name='branch'", param.cabang);
		if (param.keterangan != null)
			AccTool.textarea(driver, w, "@name='description'", param.keterangan);
		
//		AccTool.click(driver, "//div[starts-with(@id,'detail-open-balance')]//*[text()='Jumlah']");
	}

	public static void isiDetailPembelian(WebDriver driver, PemasokParam param) {
		String tab = AccurateModule.PEMASOK.getXpath() + "//*[contains(@id,'tab-purchase')]";
		if (param.cbpenjualjasa != null)
			AccTool.checkbox(driver, "", "@name='serviceSeller'", param.cbpenjualjasa);
		if (param.syaratpembayaran != null)
			AccTool.lookup(driver, tab, "@name='term'", param.syaratpembayaran);
		if (param.defaultdiskon != null)
		AccTool.textField(driver, tab, "@name='defaultPurchaseDisc'", param.defaultdiskon);
		if (param.defaultdeskripsi != null)
			AccTool.textarea(driver, tab, "@name='defaultInvoiceDesc'", param.defaultdeskripsi);
		if (param.akunhutang != null)
			AccTool.lookup(driver, tab, "@name='vendorPayableAccountList'", param.akunhutang);
		if (param.akunuangmuka != null)
			AccTool.lookup(driver, tab, "@name='vendorDownPaymentAccountList'", param.akunuangmuka);
	}

	public static void isiDetailPajak(WebDriver driver, PemasokParam param) {
		String tab = AccurateModule.PEMASOK.getXpath();
		// + "//*[contains(@id,'tab-purchase')]"

		if (param.cbtotaltermasukpajak != null)
			AccTool.checkbox(driver, "", "@name='defaultIncTax'", param.cbtotaltermasukpajak);
		if (param.npwp != null)
			AccTool.textField(driver, tab, "@name='npwpNo'", param.npwp);
		if (param.nppkp != null)
			AccTool.textField(driver, tab, "@name='pkpNo'", param.nppkp);
		if (param.tipepajak != null)
			AccTool.combobox(driver, tab, "@name='vendorTaxType'", param.tipepajak);
		if (param.kodedokumen != null)
			AccTool.combobox(driver, tab, "@name='documentCode'", param.kodedokumen);
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

	public static void IsiDetailLainLain(WebDriver driver, PemasokParam param) {
		String tab = AccurateModule.PEMASOK.getXpath() + "//*[contains(@id,'tab-others')]";
		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='notes'", param.catatan);
		if (param.cbnonaktif != null)
			AccTool.checkbox(driver, "", "@name='suspended'", param.cbnonaktif);
	}

	public static void isiDetailHutang(WebDriver driver, PemasokParam param) {
		String tab = AccurateModule.PEMASOK.getXpath() + "//*[contains(@id, '#tab-history')]";
		if (param.tglhutangdari != null)
			AccTool.datePicker(driver, tab, "fromDate", param.tglhutangdari);
		if (param.tglhutangsampai != null)
			AccTool.datePicker(driver, tab, "toDate", param.tglhutangsampai);
		if (param.matauanghutang != null)
			AccTool.combobox(driver, tab, "historyCurrencyId", param.matauanghutang);
	}

	public static void saveDetailKontak(WebDriver driver, String filename) {
		String tab = "//div[starts-with(@id,'detail-contact')]";
		String content = "Pemasok.SaveDetailKontak : " + "\r\n";
		content = content  + "Sapaan : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "salutation", tab) + "Nama : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "name", tab) + "Jabatan : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "position", tab) + "Email : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "email", tab) + "Handphone : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "mobilePhone", tab) + "Telepon Bisnis : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "workPhone", tab) + "Faksmili : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "fax", tab) + "Telepon Rumah : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "homePhone", tab) + "Pin BBM : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "bbmPin", tab) + "Web : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "website", tab) + "Catatan : " + AccTool.getTextValue(driver, ElementType.TEXTAREA, "notes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveDetailSaldo(WebDriver driver, String filename) {
		WaitTool.delay(1000);
		String tab = "//div[starts-with(@id,'detail-open-balance')]";
//		String namacabang = "//*[contains(@id,'detail-open-balance')]//select[@name = 'branch']";
		String content = "Pemasok.SaveDetailSaldo : " + "\r\n";
		content = content + "Mata Uang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "currency", tab) + "Tanggal : "
				+ AccTool.getTextValue(driver, ElementType.DATEPICKER, "asOf", tab) + "Nomor : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "number", tab) + "Syarat Pembayaran : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "paymentTerm", tab) + "Jumlah : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amount", tab) + "Kurs : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "rate", tab) + "Keterangan : " + AccTool.getTextValue(driver, ElementType.TEXTAREA, "description", tab)
				+ "Cabang : " + AccTool.getTextValue(driver, ElementType.COMBOBOX, "branch", tab) + "\r\n";
		
//		if(WebElementTool.isElementExists(driver, By.xpath(namacabang)))
//		{
//			content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.COMBOBOX, "branch", tab) + "\r\n";
//		} else {
//			content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.SUMMARY, "branchListOption", tab) + "\r\n";
//		}
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiInformasiUmum(WebDriver driver, String filename) {
		String tab = "//*[contains(@id,'tab-general')]" + "\r\n";
		String content = "Pemasok.SaveIsiInformasiUmum : " + "\r\n";
		content = content
		+ "Kategori : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.LOOKUP, "category", tab) 
		+ "ID Pemasok : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "vendorNo", tab) 
		+ "Nama : "	+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "name", tab) 
		+ "Email : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "email", tab) 
		+ "Telepon bisnis : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "workPhone", tab) 
		+ "Handphone : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "mobilePhone", tab) 
		+ "Faksimili : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "fax", tab) 
		+ "Web : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "website", tab) 
		+ "Mata Uang : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.LOOKUP, "currency", tab) 
		+ "Penjual Jasa : "	+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.CHECKBOX, "serviceSeller", tab);
		
		//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
		String namacabang = "//*[contains(@id,'tab-general')]//select[@name = 'branch']";
		if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
			content = content + "Dipakai di Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.COMBOBOX, "branch", tab);
		} else {
			content = content + "Dipakai di Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.SUMMARY, "vendorBranchName", tab);
		}
		content = content
				
		+ "Penagihan Jalan : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTAREA, "billStreet", tab) 
		+ "Penagihan Kota : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "billCity", tab) 
		+ "Penagihan Provinsi : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "billProvince", tab) 
		+ "Penagihan Kode Pos : "+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "billZipCode", tab) 
		+ "Penagihan Negara : "	+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "billCountry", tab)
		+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiKontak(WebDriver driver, String filename) {
		String tab = "//*[contains(@id,'tab-contact')]";
		String content = "Pemasok.SaveIsiKontak : " + "\r\n";
		content = content  + AccTool.getGridValue(driver, AccurateModule.PEMASOK, tab)+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiSaldo(WebDriver driver, String filename) {
		String content = "Pemasok.SaveIsiSaldo : " + "\r\n";
//		String saldo = "//label[contains(@data-bind, 'text: app.util.parseNumberBalance($data.balance)')]";
		String saldo = "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')]";
		String xpathsaldopemasok = AccurateModule.PEMASOK.getXpath() + saldo;

		List<WebElement> daftarSaldo = driver.findElements(By.xpath(xpathsaldopemasok));
		int n = daftarSaldo.size();

//		if (n == 1) {
//			content = content + AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balanceCode", "//div[@class='row no-margin'][4]") + " "
//					+ AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balance", "//div[@class='row no-margin'][4]//b")+ "\r\n";
//		}
//		if (n == 2) {
//			content = content + AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balanceCode", "//div[@class='row no-margin'][4]") + " "
//					+ AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balance", "//div[@class='row no-margin'][4]//b")+ "\r\n";
//			content = content + AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balanceCode", "//div[@class='row no-margin'][5]") + " "
//					+ AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balance", "//div[@class='row no-margin'][5]//b")+ "\r\n";
//		}
//		if (n == 3) {
//			content = content + AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balanceCode", "//div[@class='row no-margin'][4]") + " "
//					+ AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balance", "//div[@class='row no-margin'][4]//b")+ "\r\n";
//			content = content + AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balanceCode", "//div[@class='row no-margin'][5]") + " "
//					+ AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balance", "//div[@class='row no-margin'][5]//b")+ "\r\n";
//			content = content + AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balanceCode", "//div[@class='row no-margin'][6]") + " "
//					+ AccTool.getTextValue(getWebDriver(), AccurateModule.PEMASOK, ElementType.LABEL, "$data.balance", "//div[@class='row no-margin'][6]//b")+ "\r\n";
//		}
		
		if (n == 1) {
			content = content + AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][1]/div[3]") + " "
					+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][1]/div[2]")+ "\r\n";
		}
		if (n == 2) {
			content = content + AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][1]/div[3]") + " "
					+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][1]/div[2]")+ "\r\n";
			content = content + AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][2]/div[3]") + " "
					+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][2]/div[2]")+ "\r\n";
		}
		if (n == 3) {
			content = content + AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][1]/div[3]") + " "
					+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][1]/div[2]")+ "\r\n";
			content = content + AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][2]/div[3]") + " "
					+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][2]/div[2]")+ "\r\n";
			content = content + AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][3]/div[3]") + " "
					+ AccTool.getTextValue(getWebDriver(), "//div[contains(@id, 'tab-balance')]//div[contains(@class, 'ui-widget-content slick-row')][3]/div[2]")+ "\r\n";
		}

		AccTool.writeTextFile(filename, content);

	}

	public static void saveIsiPajak(WebDriver driver, String filename) {
		String tab = "//*[contains(@id,'tab-tax')]";
		String content = "Pemasok.SaveIsiPajak : " + "\r\n";
		content = content 
		// + "Pajak 1 : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK,
		// ElementType.LOOKUP, "tax1", tab)
		// + "Pajak 2 : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK,
		// ElementType.LOOKUP, "tax2", tab)
				+ "Total Termasuk Pajak : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.CHECKBOX, "defaultIncTax", tab) + "NPWP : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "npwpNo", tab) + "NPPKP : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "pkpNo", tab) + "Tipe Pajak : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.COMBOBOX, "vendorTaxType", tab) + "Kode Dokumen : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.COMBOBOX, "documentCode", tab) + "Sama Dengan Penagihan : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.CHECKBOX, "taxSameAsBill", tab) + "Pajak Jalan : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTAREA, "taxStreet", tab) + "Pajak Kota : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "taxCity", tab) + "Pajak Provinsi : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "taxProvince", tab) + "Pajak Kode Pos : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "taxZipCode", tab) + "Pajak Negara : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "taxCountry", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiPembelian(WebDriver driver, String filename) {
		//String tab = "//*[contains(@id,'tab-purchase')]";
		String content = "Pemasok.SaveIsiPembelian : " + "\r\n";
		content = content
		// + "Penjual Jasa : " + AccTool.getTextValue(driver,
		// AccurateModule.PEMASOK, ElementType.CHECKBOX, "serviceSeller", tab)
				+ "Syarat Pembayaran : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.LOOKUP, "term") 
				+ "Default Diskon (%) : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTFIELD, "defaultPurchaseDisc") 
				+ "Default Deskripsi : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTAREA, "defaultInvoiceDesc") 
				+ "Akun Hutang : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.LOOKUP, "vendorPayableAccountList") 
				+ "Akun Uang Muka : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.LOOKUP, "vendorDownPaymentAccountList")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiLainLain(WebDriver driver, String filename) {
		String tab = "//*[contains(@id,'tab-others')]";
		String content = "Pemasok.SaveIsiLainLain : " + "\r\n";
		content = content + "Catatan : " + AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.TEXTAREA, "notes", tab) + "Non Aktif Pemasok: "
				+ AccTool.getTextValue(driver, AccurateModule.PEMASOK, ElementType.CHECKBOX, "suspended", tab)+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiList(WebDriver driver, String filename) {
		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "Pemasok.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.PEMASOK, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListSaldo(WebDriver driver, String filename) {
		log.info("Pemasok.saveListSaldo");

		String content = "Pemasok.SaveListSaldo : " + "\r\n";
		String tab = "//*[contains(@id,'tab-balance')]";
		
		content = content + AccTool.getGridValue(driver, AccurateModule.PEMASOK, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveNotifErrorSaldo(WebDriver driver, String fileName)
	{	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
	String content = "PengisianNoSeri.SaveNotifNoSeri : " + "\r\n";
	content = content
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
        AccTool.writeTextFile(fileName, content);
     }
	
	public static void klikOKPopUpWarning(WebDriver driver) {
		String path = "//*[text()='Terjadi Permasalahan pada Pemrosesan']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
//		AccTool.click(driver, "//div[contains(@id, 'error-dialog')]//button[@name='btnOk' and text()='OK']");
//		String path = "//*[@name='btnOk']";
//		AccTool.click(driver, path);
//		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void pilihRekeningPemasok(WebDriver driver, PemasokParam param) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'bank-grid-list')]//div[@class='grid-canvas']/div[" + param.urutan + "]");
	}
	
	public static void klikBtnTambahRekeningPemasok(WebDriver driver) {
		String path = "//*[contains(@id,'tab-purchase')]//button[@name='btnAddBank']";
		AccTool.click(driver, path);
	}
	
	public static void klikBtnClosePopupTambahRekeningPemasok(WebDriver driver) {
		String path = "//*[text()='Rekening Bank']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	
	public static void klikBtnLanjutTambahRekeningPemasok(WebDriver driver) {
		String path = "//div[starts-with(@id,'detail-bank')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	
	public static void klikBtnHapusTambahRekeningPemasok(WebDriver driver) {
		String path = "//*[contains(@id,'detail-bank')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	
	public static void isiTambahRekeningPemasok(WebDriver driver, PemasokParam param) {
		String r = "//div[contains(@id, 'detail-bank')]//*[@class = 'container']";
		if (param.namabank != null)
			AccTool.lookup(driver, r, "@name='bank'", param.namabank);
		if (param.norek != null)
			AccTool.textField(driver, r, "@name='bankAccount'", param.norek);
		if (param.atasnama != null)
			AccTool.textField(driver, r, "@name='bankAccountName'", param.atasnama);
	}
	
	public static void saveIsiTambahRekeningPemasok(WebDriver driver, String filename) {
		String tab = "//div[contains(@id, 'detail-bank')]//*[@class = 'container']";
		String content = "Pemasok.SaveDetailRekeningBank : " + "\r\n";
		content = content
				+ "Nama Bank : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.bankName", tab)
				+ "No Rekening : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.bankAccount", tab)
				+ "Atas Nama : " + AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.bankAccountName", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikClearDefaultDiskon(WebDriver driver) {
		String path = "//*[contains(@id,'tab-purchase')]//button[@class='btn-clear']";
		AccTool.click(driver, path);
		WaitTool.delay(3000);
	}
}
