package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.akunperkiraan.AkunPerkiraanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class AkunPerkiraanTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(AkunPerkiraanParam.class);

	public static void isiForm(WebDriver driver, AkunPerkiraanParam param) {
		log.info("AkunPerkiraan.Isi");

		String w = AccurateModule.AKUN_PERKIRAAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, AccurateModule.AKUN_PERKIRAAN.getXpath() + "//a[text()='Informasi Umum']");

		if (param.tipe != null)
			AccTool.combobox(driver, tab, "@name='accountType'", param.tipe);
		if (param.cbsubakun != null)
			AccTool.checkbox(driver, tab, "@name='sub'", param.cbsubakun);
		if (param.namasubakun != null)
			AccTool.lookup(driver, tab, "@name='parent'", param.namasubakun);
		if (param.penomoran != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.penomoran);
		if (param.cbno != null)
			AccTool.checkbox(driver, tab, "@name='subAutoNo'", param.cbno);
		if (param.no != null)
			AccTool.textField(driver, tab, "@name='no'", param.no);
		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);
		if (param.matauang != null)
			AccTool.lookup(driver, tab, "@name='currency'", param.matauang);		
	}
	
	public static void isiSaldoAwal(WebDriver driver, AkunPerkiraanParam param) {
		log.info("AkunPerkiraan.Isi");

		String w = AccurateModule.AKUN_PERKIRAAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-balance')]";

		AccTool.click(driver, AccurateModule.AKUN_PERKIRAAN.getXpath() + "//a[text()='Saldo']");

		if (param.cabangsaldo != null)
			AccTool.lookup(driver, tab, "@name='branchId'", param.cabangsaldo);
		if (param.saldoawal != null){
			AccTool.numberField(driver, tab, "@name='openBalance'", param.saldoawal);
		
		AccTool.click(getWebDriver(),
				"//div[starts-with(@id, 'tab-balance')]");
		//WaitTool.delay(300);
		WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
	}		

		if (param.tanggalob != null)
			AccTool.datePicker(driver, tab, "@name='asOf'", param.tanggalob);
		if (param.kurs != null)
			AccTool.numberField(driver, tab, "@name='rate'", param.kurs);
		

	}
	

	public static void isiLainLain(WebDriver driver, AkunPerkiraanParam param) {
		log.info("AkunPerkiraan.IsiLainLain");

		String w = AccurateModule.AKUN_PERKIRAAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, AccurateModule.AKUN_PERKIRAAN.getXpath() + "//a[text()='Lain-lain']");

		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='memo'", param.catatan);
		
		if (param.cbsemuapengguna != null)
			AccTool.checkbox(getWebDriver(), tab, "@name='usedAllUser'", param.cbsemuapengguna);

		if (param.aksesgrup != null)
			AccTool.lookup(driver, tab, "@name='useUserRoleAccessList'", param.aksesgrup);

		if (param.aksesuser != null)
			AccTool.lookup(driver, tab, "@name='useUserAccessList'", param.aksesuser);

		if (param.cbfiskal != null)
			AccTool.checkbox(driver, tab, "@name='fiscal'", param.cbfiskal);

		if (param.cbnonaktif != null)
			AccTool.checkbox(driver, tab, "@name='suspended'", param.cbnonaktif);

	}

	public static void saveIsiLain(WebDriver driver, String filename) {
		log.info("AkunPerkiraan.SaveIsi");

		AccTool.click(driver, AccurateModule.AKUN_PERKIRAAN.getXpath() + "//a[text()='Lain-lain']");
		String tab = "//*[contains(@id,'tab-others')]";
		String content = "AkunPerkiraan.SaveLainLain : " + "\r\n";
		content = content 
				+ "Catatan : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.TEXTAREA, "memo", tab)
				+ "Akses Grup/Cabang : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.LOOKUP,
						"useUserRoleAccessList", tab)
				+ "Akses User : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.LOOKUP,
						"useUserAccessList", tab)
				+ "Non Aktif : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.CHECKBOX, "suspended", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveList(WebDriver driver, String filename) {
		log.info("AkunPerkiraan.SaveList");
		String tab = "//div[starts-with(@class,'module-list form-color')]";
		String content = "AkunPerkiraan.SaveList : " + "\r\n";
		content = content + AccTool.getGridValue(driver, AccurateModule.AKUN_PERKIRAAN, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void isiSubAkun(WebDriver driver, AkunPerkiraanParam param) {
		log.info("AkunPerkiraan.IsiSubAkun");

		String w = AccurateModule.AKUN_PERKIRAAN.getXpath();

		String tab = w + "//*[contains(@id,'tab-general')]";

		// AccTool.click(driver, w + "//a[contains(@href,'tab-general')]");

		AccTool.lookup(driver, tab, "@name='parent'", param.search);
		AccTool.scrollRowDetail(driver, tab, param.scroll);
	}

	public static void cariList(WebDriver driver, AkunPerkiraanParam param) {
		log.info("AkunPerkiraan.carilist");

		String a = "//*[contains(@id,'module-accurate__general-ledger__glaccount')]";

		if (param.cari != null)
			AccTool.textField(driver, a, "@name='keyword'", param.cari);
		AccTool.waitLoadingMask(getWebDriver());
	}

	public static void klikTipeAkun() {
		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__dynamic-filter')]//*[text()='Tipe Akun']");
		
	}

	public static void klikListKasBank() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Kas & Bank']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);

	}

	public static void klikListPiutangUsaha() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Piutang Usaha']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListAsetLancarLainnya() {
		
//		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Aset Lancar Lainnya']");
		AccTool.click(getWebDriver(), "//ul[@class='no-padding']/li[contains(.,'Aset Lancar Lainnya')]");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1500);
	}

	public static void klikListAsetTetap() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Aset Tetap']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListAkumulasiPenyusutan() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Akumulasi Penyusutan']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListPersediaan() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Persediaan']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListAsetLainnya() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Aset Lainnya']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListHutangUsaha() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Utang Usaha']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListKewajibanJangkaPendek() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Liabilitas Jangka Pendek']");
		WaitTool.delay(5000);
		//AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListKewajibanJangkaPanjang() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Liabilitas Jangka Panjang']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListBebanPokokPenjualan() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Beban Pokok Penjualan']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListModal() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Modal']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListBeban() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Beban']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListBebanLainnya() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Beban Lainnya']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListPendapatan() {
//		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Pendapatan']");
		AccTool.click(getWebDriver(), "//span[.='Pendapatan']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikListPendapatanLainnya() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Pendapatan Lainnya']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");
//		WaitTool.delay(1200);
	}

	public static void klikiconCari() {
		AccTool.click(getWebDriver(),
				"//*[contains(@id,'module-accurate__general-ledger__glaccount')]//*[@name ='keyword']");
		AccTool.waitLoadingMask(getWebDriver());

	}

	public static void klikTabLainLain(WebDriver driver) {
		AccTool.click(driver, AccurateModule.AKUN_PERKIRAAN.getXpath() + "//a[contains(@href, '#tab-others')]");
	}

	public static void saveIsiUmum(WebDriver driver, String filename) {
		log.info("AkunPerkiraan.SaveInformasiUmum");

		// String w = param.w;
		String tab = "//*[contains(@id,'tab-general')]";
		String content = "AkunPerkiraan.SaveInformasiUmum : " + "\r\n";

		AccTool.click(driver, AccurateModule.AKUN_PERKIRAAN.getXpath() + "//a[text()='Informasi Umum']");
		content = content 
				+ "Tipe Akun : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.SUMMARY, "text: formData.accountTypeName", tab)
				+ "Sub Akun : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.CHECKBOX, "sub", tab)
				+ "Nama Sub Akun : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.LOOKUP, "parent", tab)
				+ "No : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.TEXTFIELD, "no", tab)
				+ "Nama : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.TEXTFIELD, "name", tab)
				+ "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN,ElementType.SUMMARY, "text: formData.currency().name", tab);
//				+ "Saldo Awal : "
//				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.NUMBERFIELD, "openBalance",tab)
//				+ "per Tgl : "
//				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.DATEPICKER, "asOf", tab)
				String saldo = "//*[contains(@id,'tab-general')]//*[text()='Saldo']";
				if (WebElementTool.isElementExists(driver, By.xpath(saldo))) {
					content = content 
							
				+ "Saldo : " 
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.SPAN,
						"text: app.util.parseNumberBalance(formData.balance())", tab);}
				content = content+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	// dibuat pada tanggal 11 Agustus 2017, karena ada tc yg save nya ga pakai
	// kolom kurs
	// tanggal 28 feb 2018 ada perubahan di field mata uang & Tipe akun jadi span
	public static void saveIsiUmumPakaiKurs(WebDriver driver, String filename) {
		log.info("AkunPerkiraan.SaveIsi");

		// String w = param.w;
		String tab = "//*[contains(@id,'tab-general')]";
		String content = "AkunPerkiraan.SaveIsiUmum : " + "\r\n";

		AccTool.click(driver, AccurateModule.AKUN_PERKIRAAN.getXpath() + "//a[text()='Informasi Umum']");
		content = content + "Informasi Umum" + "\r\n" + "Tipe Akun : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.SUMMARY, "text: formData.accountTypeName", tab)
				+ "No : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.TEXTFIELD, "no", tab)
				+ "Nama : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.TEXTFIELD, "name", tab)
//				+ "Saldo Awal : "
//				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.NUMBERFIELD, "openBalance",
//						tab)
				+ "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.SUMMARY, "text: formData.currency().name", tab)
//				+ "OB : "
//				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.NUMBERFIELD, "openBalance",
//						tab)
//				+ "Kurs : "
//				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.NUMBERFIELD, "rate", tab)
//				+ "Tanggal OB : "
//				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.DATEPICKER, "asOf", tab)
				+ "Sub Akun : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.CHECKBOX, "sub", tab)
				+ "Nama Sub Akun : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.LOOKUP, "parent", tab)							
				+ "Saldo : " 
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.SPAN,
						"text: app.util.parseNumberBalance(formData.balance())", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiSaldoAwal(WebDriver driver, String filename) {
		log.info("AkunPerkiraan.SaveIsi");

		// String w = param.w;
		String tab = "//*[contains(@id,'tab-balance')]";
		String content = "AkunPerkiraan.SaveIsiSaldoAwal : " + "\r\n";

		AccTool.click(driver, AccurateModule.AKUN_PERKIRAAN.getXpath() + "//a[text()='Saldo']");
		
		String cabang = "//*[contains(@id,'tab-balance')]//div[input[@name='branchId']]";
		if (WebElementTool.isElementExists(driver, By.xpath(cabang))) {
			content = content 
					+ "Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.LOOKUP, "branchId",tab);}
		content = content				
				+ "Saldo Awal : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.NUMBERFIELD, "openBalance",
						tab)				
//				+ "Kurs : "
//				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.NUMBERFIELD, "rate", tab)
				+ "per Tgl : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.DATEPICKER, "asOf", tab)
				+ "Saldo : " 
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.SPAN,
						"text: app.util.parseNumberBalance(formData.balance())", tab);
//				+ "\r\n";
				String kurs = "//*[contains(@id,'tab-balance')]//div[input[@name='rate']]";
				if (WebElementTool.isElementExists(driver, By.xpath(kurs))) {
					content = content 
							+ "Kurs : "
							+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "rate", tab);}
				content = content + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void isihistory(WebDriver driver, AkunPerkiraanParam param) {
		String tab = "//div[starts-with(@id,'tab-history')]";

		AccTool.click(driver, AccurateModule.AKUN_PERKIRAAN.getXpath() + "//a[contains(@href, 'tab-history')]");

		if (param.daritanggal != null)
			AccTool.datePicker(driver, tab, "@name='fromDate'", param.daritanggal);
		if (param.sampaitanggal != null)
			AccTool.datePicker(driver, tab, "@name='toDate'", param.sampaitanggal);
		
	}
	
	public static void klikRefreshHistory(WebDriver driver, AccurateModule module) {
		
		String tab = AccurateModule.AKUN_PERKIRAAN.getXpath() + "//div[starts-with(@id,'tab-history')]";
		AccTool.click(driver, tab + "//button[@name='btnRefresh']");
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath("//div[starts-with(@id,'tab-history')]"), 10);
		AccTool.waitGridMask(driver, true);
		AccTool.waitLoadingMask(driver);
	}
	
	public static void SaveListHistory(WebDriver driver, String filename) {
		log.info("Mutasi Akun Pekiraan.SaveList");

		String content = "AkunPerkiraan.SaveMutasiAkun : " + "\r\n";
		String tab = "//*[contains(@id,'tab-history')]";
		content = content 
				+ "\r\n"
				+ "Dari Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.DATEPICKER, "fromDate", tab)
				+ "Sampai Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.AKUN_PERKIRAAN, ElementType.DATEPICKER, "toDate", tab)
				+ "\r\n" 
				+ "Detail : " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.AKUN_PERKIRAAN, tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);

	}
	
	public static void klikKosongkanPilihan() {
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()=' Kosongkan Pilihan']");
		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
		AccTool.click(getWebDriver(), "//*[contains(@class,'text-panel')]");

	}
	
}