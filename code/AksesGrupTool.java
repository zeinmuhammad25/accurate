package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.aksesgrup.AksesGrupParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class AksesGrupTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(AksesGrupTool.class);

	public static String w = AccurateModule.AKSES_GRUP.getXpath();

	public static void isiForm(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiForm");

		// String w = AccurateModule.AKSES_GRUP.getXpath();

		if (param.nama != null)
			AccTool.textField(driver, w, "@name='name'", param.nama);
		if (param.pengguna != null)
			AccTool.lookup(driver, w, "@name='userList'", param.pengguna);
	}

	public static void isiPerusahaan(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiPerusahaan");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";
		String menuHakAkses = privilegecontainer + hakakses;
		String tabHakAksesPerusahaan = w + "//*[contains(@class,'icon icn-privilege-company')]";
//		String greyline = "//div[@id='module-accurate__company__access-privilege']//*[@class='row no-margin text-panel-silver']";
		//ui baru
		String greyline = "//div[@id='module-accurate__company__access-privilege']//*[contains(@id,'checkbox-privilege')]";


		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(tabHakAksesPerusahaan), 5);

		AccTool.click(driver, AccurateModule.AKSES_GRUP.getXpath() + "//a[text()='Hak Akses']");
		AccTool.click(driver, tabHakAksesPerusahaan);

		if (param.hakakses.equalsIgnoreCase("")) {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, greyline, "@name='enabledAll'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, greyline, "@name='createAll'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, greyline, "@name='editAll'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, greyline, "@name='deleteAll'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, greyline, "@name='viewAll'", param.cblihat);
		} else {

			if (param.cbaktif != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='enable'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='create'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='edit'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='delete'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='view'", param.cblihat);

		}
	}

	public static void isiBukuBesar(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiBukuBesar");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";
		String menuHakAkses = privilegecontainer + hakakses;
		String tabHakAksesBukuBesar = w + "//a[@class='index-privilege-tab-option-text' and text()='Buku Besar']";
		String greyline = "//div[@id='module-accurate__company__access-privilege']//*[@class='row no-margin text-panel-silver']";

		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(tabHakAksesBukuBesar), 5);
		
		AccTool.click(driver, AccurateModule.AKSES_GRUP.getXpath() + "//a[text()='Hak Akses']");
		AccTool.click(driver, tabHakAksesBukuBesar);

		if (param.hakakses.equalsIgnoreCase("")) {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, greyline, "@name='enabledAll'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, greyline, "@name='createAll'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, greyline, "@name='editAll'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, greyline, "@name='deleteAll'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, greyline, "@name='viewAll'", param.cblihat);
		} else {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='enable'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='create'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='edit'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='delete'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='view'", param.cblihat);
		}
	}

	public static void isiKasBank(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiKasBank");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";
		String menuHakAkses = privilegecontainer + hakakses;
		String tabHakAksesKasBank = w + "//a[@class='index-privilege-tab-option-text' and text()='Kas/Bank']";
		String greyline = "//div[@id='module-accurate__company__access-privilege']//*[@class='row no-margin text-panel-silver']";

		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(tabHakAksesKasBank), 5);
		
		AccTool.click(driver, AccurateModule.AKSES_GRUP.getXpath() + "//a[text()='Hak Akses']");
		AccTool.click(driver, tabHakAksesKasBank);

		if (param.hakakses.equalsIgnoreCase("")) {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, greyline, "@name='enabledAll'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, greyline, "@name='createAll'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, greyline, "@name='editAll'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, greyline, "@name='deleteAll'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, greyline, "@name='viewAll'", param.cblihat);
		} else {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='enable'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='create'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='edit'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='delete'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='view'", param.cblihat);
		}
	}

	public static void isiPenjualan(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiPenjualan");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";
		String menuHakAkses = privilegecontainer + hakakses;
		String tabHakAksesPenjualan = w + "//a[@class='index-privilege-tab-option-text' and text()='Penjualan']";
		String greyline = "//div[@id='module-accurate__company__access-privilege']//*[@class='row no-margin text-panel-silver']";

		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(tabHakAksesPenjualan), 5);
		
		AccTool.click(driver, AccurateModule.AKSES_GRUP.getXpath() + "//a[text()='Hak Akses']");
		AccTool.click(driver, tabHakAksesPenjualan);

		if (param.hakakses.equalsIgnoreCase("")) {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, greyline, "@name='enabledAll'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, greyline, "@name='createAll'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, greyline, "@name='editAll'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, greyline, "@name='deleteAll'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, greyline, "@name='viewAll'", param.cblihat);
		} else {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='enable'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='create'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='edit'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='delete'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='view'", param.cblihat);
		}
	}

	public static void isiPembelian(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiPembelian");

		AccTool.click(driver, AccurateModule.AKSES_GRUP.getXpath() + "//a[text()='Hak Akses']");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";
		String menuHakAkses = privilegecontainer + hakakses;
		String tabHakAksesPembelian = w + "//a[@class='index-privilege-tab-option-text' and text()='Pembelian']";
		String greyline = "//div[@id='module-accurate__company__access-privilege']//*[@class='row no-margin text-panel-silver']";
		
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(tabHakAksesPembelian), 5);

		AccTool.click(driver, AccurateModule.AKSES_GRUP.getXpath() + "//a[text()='Hak Akses']");
		AccTool.click(driver, tabHakAksesPembelian);

		if (param.hakakses.equalsIgnoreCase("")) {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, greyline, "@name='enabledAll'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, greyline, "@name='createAll'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, greyline, "@name='editAll'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, greyline, "@name='deleteAll'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, greyline, "@name='viewAll'", param.cblihat);
		} else {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='enable'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='create'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='edit'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='delete'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='view'", param.cblihat);
		}
	}

	public static void isiPersediaan(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiPersediaan");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";
		String menuHakAkses = privilegecontainer + hakakses;
		String tabHakAksesPersediaan = w + "//a[@class='index-privilege-tab-option-text' and text()='Persediaan']";
		String greyline = "//div[@id='module-accurate__company__access-privilege']//*[@class='row no-margin text-panel-silver']";
		
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(tabHakAksesPersediaan), 5);

		AccTool.click(driver, AccurateModule.AKSES_GRUP.getXpath() + "//a[text()='Hak Akses']");
		AccTool.click(driver, tabHakAksesPersediaan);

		if (param.hakakses.equalsIgnoreCase("")) {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, greyline, "@name='enabledAll'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, greyline, "@name='createAll'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, greyline, "@name='editAll'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, greyline, "@name='deleteAll'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, greyline, "@name='viewAll'", param.cblihat);
		} else {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='enable'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='create'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='edit'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='delete'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='view'", param.cblihat);
		}
	}

	public static void isiAsetTetap(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiAsetTetap");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";
		String menuHakAkses = privilegecontainer + hakakses;
		String tabHakAksesAssetTetap = w + "//a[@class='index-privilege-tab-option-text' and text()='Asset Tetap']";
		String greyline = "//div[@id='module-accurate__company__access-privilege']//*[@class='row no-margin text-panel-silver']";
		
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(tabHakAksesAssetTetap), 5);

		AccTool.click(driver, AccurateModule.AKSES_GRUP.getXpath() + "//a[text()='Hak Akses']");
		AccTool.click(driver, tabHakAksesAssetTetap);

		if (param.hakakses.equalsIgnoreCase("")) {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, greyline, "@name='enabledAll'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, greyline, "@name='createAll'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, greyline, "@name='editAll'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, greyline, "@name='deleteAll'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, greyline, "@name='viewAll'", param.cblihat);
		} else {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='enable'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='create'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='edit'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='delete'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='view'", param.cblihat);
		}
	}

	public static void isiTarget(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiTarget");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";
		String menuHakAkses = privilegecontainer + hakakses;
		String tabHakAksesTarget = w + "//a[@class='index-privilege-tab-option-text' and text()='Target']";
		String greyline = "//div[@id='module-accurate__company__access-privilege']//*[@class='row no-margin text-panel-silver']";
		
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(tabHakAksesTarget), 5);

		AccTool.click(driver, AccurateModule.AKSES_GRUP.getXpath() + "//a[text()='Hak Akses']");
		AccTool.click(driver, tabHakAksesTarget);

		if (param.hakakses.equalsIgnoreCase("")) {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, greyline, "@name='enabledAll'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, greyline, "@name='createAll'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, greyline, "@name='editAll'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, greyline, "@name='deleteAll'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, greyline, "@name='viewAll'", param.cblihat);
		} else {
			if (param.cbaktif != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='enable'", param.cbaktif);
			if (param.cbbuat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='create'", param.cbbuat);
			if (param.cbubah != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='edit'", param.cbubah);
			if (param.cbhapus != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='delete'", param.cbhapus);
			if (param.cblihat != null)
				AccTool.checkbox(driver, menuHakAkses, "@value='view'", param.cblihat);
		}
	}

	public static void isiKalender(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiKalender");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";

		if (!hakakses.equals("")) {
			AccTool.click(driver, w + "//a[@class='index-privilege-tab-option-text' and text()='Kalender']");

			AccTool.checkbox(driver, privilegecontainer + hakakses, "@value='enable'", param.cbaktif);
		}
	}

	public static void isiWidget(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiWidget");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";

		AccTool.click(driver, w + "//a[@class='index-privilege-tab-option-text' and text()='Widget']");

		if (!hakakses.equals("")) {
			AccTool.checkbox(driver, privilegecontainer + hakakses, "//div[contains(@class,'r0') and text()='"
					+ param.hakakses + "']/following-sibling::div[contains(@class,'r0')]//span[@class='check']",
					param.cbaktif);
		}
	}

	public static void isiLaporan(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiLaporan");

		String privilegecontainer = "//div[@class='index-privilege-content-inner']";
		String hakakses = "//div[div[label[text()='" + param.hakakses + "']]]";

		AccTool.click(driver, w + "//a[@class='index-privilege-tab-option-text' and text()='Laporan']");

		if (!hakakses.equals("")) {
			AccTool.checkbox(driver, privilegecontainer + hakakses, "//div[contains(@class,'r0') and text()='"
					+ param.hakakses + "']/following-sibling::div[contains(@class,'r0')]//span[@class='check']",
					param.cbaktif);
		}
	}

	public static void isiManufaktur(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiManufaktur");

		String tab = w + "//div[contains(@id,'tab-manufacture')]";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		if (!hakakses.equals("")) {
			AccTool.click(driver, w + "//a[contains(@href,'tab-manufacture')]");

			AccTool.checkbox(driver, tab + hakakses, "@value='enable'", param.cbaktif);
			AccTool.checkbox(driver, tab + hakakses, "@value='create'", param.cbbuat);
			AccTool.checkbox(driver, tab + hakakses, "@value='edit'", param.cbubah);
			AccTool.checkbox(driver, tab + hakakses, "@value='delete'", param.cbhapus);
			AccTool.checkbox(driver, tab + hakakses, "@value='view'", param.cblihat);
		}
	}

	public static void isiProyek(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.IsiProyek");

		String tab = w + "//div[contains(@id,'tab-project')]";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		if (!hakakses.equals("")) {
			AccTool.click(driver, w + "//a[contains(@href,'tab-project')]");

			AccTool.checkbox(driver, tab + hakakses, "@value='enable'", param.cbaktif);
			AccTool.checkbox(driver, tab + hakakses, "@value='create'", param.cbbuat);
			AccTool.checkbox(driver, tab + hakakses, "@value='edit'", param.cbubah);
			AccTool.checkbox(driver, tab + hakakses, "@value='delete'", param.cbhapus);
			AccTool.checkbox(driver, tab + hakakses, "@value='view'", param.cblihat);
		}
	}

	public static void saveData(WebDriver driver, String filename) {
		log.info("AksesGrup.SaveData");

		String content = "AksesGrup.SaveData : " + "\r\n";
		content = content + "Nama Hak Akses	:"
				+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.TEXTFIELD, "name", "")
				+ "Nama Pengguna	:"
				+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.LOOKUP, "emailList", "") + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiPerusahaan(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiPerusahaan");

		String tab = w + "//div[contains(@id,'tab-company')]";
		String content = "AksesGrup.SaveIsiPerusahaan : " + "\r\n";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		switch (param.hakakses.toLowerCase()) {
		case "mata uang":
			content = content + "Mata Uang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "departemen":
			content = content + "Departemen" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "cabang":
			content = content + "Cabang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "pajak":
			content = content + "Pajak" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "syarat pembayaran":
			content = content + "Syarat Pembayaran" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "karyawan":
			content = content + "Karyawan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "gaji/tunjangan":
			content = content + "Gaji/Tunjangan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "komisi penjual":
			content = content + "Komisi Penjual" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "pengiriman":
			content = content + "Pengiriman" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "fob":
			content = content + "FOB" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "alamat":
			content = content + "Alamat" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP,
					ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "kontak":
			content = content + "Kontak" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable",
							tab + hakakses)
					+ "Hak Edit	:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"edit", tab + hakakses)
					+ "\r\n";
			break;
		case "penomoran":
			content = content + "Penomoran" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "mengisi nomor transaksi secara langsung":
			content = content + "Mengisi Nomor Transaksi secara langsung" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "rancangan formulir":
			content = content + "Rancangan Formulir" + "\r\n" + "Hak Edit	:" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses) + "\r\n";
			break;
		case "desain cetakan":
			content = content + "Desain Cetakan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "rekaman transaksi":
			content = content + "Rekaman Transaksi" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "perulangan transaksi":
			content = content + "Perulangan Transaksi" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "log aktifitas":
			content = content + "Log Aktifitas" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "preferensi":
			content = content + "Preferensi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "penyetuju transaksi":
			content = content + "Penyetuju Transaksi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "proses akhir bulan":
			content = content + "Proses Akhir Bulan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "spt masa":
			content = content + "SPT Masa" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;

		case "all":
			content = content + "Mata Uang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Departemen" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Cabang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Pajak" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Syarat Pembayaran" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Karyawan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "Hak Lihat:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "view", tab + hakakses)
					+ "\r\n" + "Gaji/Tunjangan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Komisi Penjual" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Pengiriman" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "FOB" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Alamat" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n" + "Kontak" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable",
							tab + hakakses)
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "\r\n" + "Penomoran" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Mengisi Nomor Transaksi secara langsung" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n" + "Rancangan Formulir" + "\r\n" + "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "\r\n" + "Desain Cetakan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "Rekaman Transaksi" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "Hak Lihat:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "view", tab + hakakses)
					+ "\r\n" + "Perulangan Transaksi" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "Hak Lihat:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "view", tab + hakakses)
					+ "\r\n" + "Log Aktifitas" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n" + "Preferensi" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n" + "Penyetuju Transaksi" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n" + "Proses Akhir Bulan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", tab + hakakses)
					+ "\r\n" + "SPT Masa" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;

		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiBukuBesar(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiBukuBesar");

		String tab = w + "//div[contains(@id,'tab-general_ledger')]";
		String content = "AksesGrup.SaveIsiBukuBesar : " + "\r\n";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		switch (param.hakakses.toLowerCase()) {
		case "akun perkiraan":
			content = content + "Akun Perkiraan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "jurnal umum":
			content = content + "Jurnal Umum" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "histori akun":
			content = content + "Histori Akun" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;

		case "all":
			hakakses = "//div[div/label[contains(text(),'Akun Perkiraan')]]";
			content = content + "Akun Perkiraan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Jurnal Umum')]]";
			content = content + "Jurnal Umum" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Histori Akun')]]";
			content = content + "Histori Akun" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiKasBank(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiKasBank");

		String tab = w + "//div[contains(@id,'tab-cash_bank')]";
		String content = "AksesGrup.SaveIsiKasBank : " + "\r\n";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		switch (param.hakakses.toLowerCase()) {
		case "pembayaran":
			content = content + "Pembayaran" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "pembayaran gaji":
			content = content + "Pembayaran Gaji" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "penerimaan":
			content = content + "Penerimaan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "transfer kas/bank":
			content = content + "Transfer Kas/Bank" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "buku bank":
			content = content + "Buku Bank" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "rekonsiliasi bank":
			content = content + "Rekonsiliasi Bank" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;

		case "all":
			hakakses = "//div[div/label[contains(text(),'Pembayaran')]]";
			content = content + "Pembayaran" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pembayaran Gaji')]]";
			content = content + "Pembayaran Gaji" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Penerimaan')]]";
			content = content + "Penerimaan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Transfer Kas/Bank')]]";
			content = content + "Transfer Kas/Bank" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Buku Bank')]]";
			content = content + "Buku Bank" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Rekonsiliasi Bank')]]";
			content = content + "Rekonsiliasi Bank" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiPenjualan(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiPenjualan");

		String tab = w + "//div[contains(@id,'tab-customer')]";
		String content = "AksesGrup.SaveIsiPenjualan : " + "\r\n";
		String hakakses = "//div[div/label[starts-with(text(),'" + param.hakakses + "')]]";

		switch (param.hakakses.toLowerCase()) {
		case "kategori pelanggan":
			content = content + "Kategori Pelanggan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "kategori harga":
			content = content + "Kategori Harga" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "pelanggan":
			content = content + "Pelanggan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "penawaran penjualan":
			content = content + "Penawaran Penjualan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "pesanan penjualan":
			content = content + "Pesanan Penjualan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "pengiriman pesanan":
			content = content + "Pengiriman Pesanan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "faktur penjualan":
			content = content + "Faktur Penjualan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "retur penjualan":
			content = content + "Retur Penjualan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "penerimaan pelanggan":
			content = content + "Penerimaan Pelanggan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "buat pesanan tanpa permintaan ":
			content = content + "Buat Pesanan Tanpa Permintaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "buat pengiriman tanpa permintaan atau pesanan":
			content = content + "Buat Pengiriman Tanpa Permintaan atau Pesanan" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			break;
		case "buat faktur tanpa permintaan, pesanan atau pengiriman":
			content = content + "Buat Faktur Tanpa Permintaan, Pesanan atau Pengiriman" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			break;
		case "mengirimkan barang melebihi pesanan":
			content = content + "Mengirimkan Barang Melebihi Pesanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "histori piutang":
			content = content + "Histori Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;

		case "mencetak faktur":
			content = content + "Mencetak Faktur" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "mengubah harga jual":
			content = content + "Mengubah Harga Jual" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "menjual di bawah harga beli/minimum":
			content = content + "Menjual di bawah harga beli/minimum" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "menjual melebihi limit piutang":
			content = content + "Menjual Melebihi Limit Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "buat pesanan melebihi stok yang dapat dijual":
			content = content + "Buat Pesanan melebihi stok yang dapat dijual" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			break;
		case "cetak ulang faktur":
			content = content + "Cetak Ulang Faktur" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "cetak ulang pengiriman":
			content = content + "Cetak Ulang Pengiriman" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;

		case "all":
			hakakses = "//div[div/label[contains(text(),'Kategori Pelanggan')]]";
			content = content + "Kategori Pelanggan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Kategori Harga')]]";
			content = content + "Kategori Harga" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pelanggan')]]";
			content = content + "Pelanggan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Penawaran Penjualan')]]";
			content = content + "Penawaran Penjualan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pesanan Penjualan')]]";
			content = content + "Pesanan Penjualan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pengiriman Pesanan')]]";
			content = content + "Pengiriman Pesanan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Faktur Penjualan')]]";
			content = content + "Faktur Penjualan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Retur Penjualan')]]";
			content = content + "Retur Penjualan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Penerimaan Pelanggan')]]";
			content = content + "Penerimaan Pelanggan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Buat Pesanan Tanpa Permintaan')]]";
			content = content + "Buat Pesanan Tanpa Permintaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Buat Pengiriman Tanpa Permintaan atau Pesanan')]]";
			content = content + "Buat Pengiriman Tanpa Permintaan atau Pesanan" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Buat Faktur Tanpa Permintaan, Pesanan atau Pengiriman')]]";
			content = content + "Buat Faktur Tanpa Permintaan, Pesanan atau Pengiriman" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Mengirimkan Barang Melebihi Pesanan')]]";
			content = content + "Mengirimkan Barang Melebihi Pesanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Histori Piutang')]]";
			content = content + "Histori Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pengingat Piutang')]]";
			content = content + "Mencetak Faktur" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Mencetak Faktur')]]";
			content = content + "Mengubah Harga Jual" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Mengubah Harga Jual')]]";
			content = content + "Menjual di bawah harga beli/minimum" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Menjual Dibawah Harga Beli')]]";
			content = content + "Menjual Melebihi Limit Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Menjual Melebihi Limit Piutang')]]";
			content = content + "Buat Pesanan melebihi stok yang dapat dijual" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Cetak Ulang Faktur')]]";
			content = content + "Cetak Ulang Faktur" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Cetak Ulang Pengiriman')]]";
			content = content + "Cetak Ulang Pengiriman" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiPembelian(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiPembelian");

		String tab = w + "//div[contains(@id,'tab-vendor')]";
		String content = "AksesGrup.SaveIsiPembelian : " + "\r\n";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		switch (param.hakakses.toLowerCase()) {
		case "kategori pemasok":
			content = content + "Kategori Pemasok" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "pemasok":
			content = content + "Pemasok" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "permintaan pembelian":
			content = content + "Permintaan Pembelian" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "pesanan pembelian":
			content = content + "Pesanan Pembelian" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "penerimaan barang":
			content = content + "Penerimaan Barang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "faktur pembelian":
			content = content + "Faktur Pembelian" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "pembayaran pemasok":
			content = content + "Pembayaran Pemasok" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "retur pembelian":
			content = content + "Retur Pembelian" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "buat pesanan pembelian tanpa permintaan":
			content = content + "Buat Pesanan Pembelian Tanpa Permintaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "buat penerimaan tanpa permintaan atau pesanan":
			content = content + "Buat Penerimaan Tanpa Permintaan Atau Pesanan" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			break;
		case "buat tagihan tanpa permintaan, pesanan atau penerimaan":
			content = content + "Buat Tagihan tanpa Permintaan, Pesanan atau Penerimaan" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			break;
		case "menerima barang melebihi pesanan":
			content = content + "Menerima Barang Melebihi Pesanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "mengubah harga beli":
			content = content + "Mengubah Harga Beli" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "histori hutang":
			content = content + "Histori Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "pengingat hutang":
			content = content + "Pengingat Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;

		case "all":
			hakakses = "//div[div/label[contains(text(),'Kategori Pemasok')]]";
			content = content + "Kategori Pemasok" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pemasok')]]";
			content = content + "Pemasok" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Permintaan Pembelian')]]";
			content = content + "Permintaan Pembelian" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pesanan Pembelian')]]";
			content = content + "Pesanan Pembelian" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Penerimaan Barang')]]";
			content = content + "Penerimaan Barang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Faktur Pembelian')]]";
			content = content + "Faktur Pembelian" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pembayaran Pemasok')]]";
			content = content + "Pembayaran Pemasok" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Retur Pembelian')]]";
			content = content + "Retur Pembelian" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Buat Pesanan Pembelian Tanpa Permintaan')]]";
			content = content + "Buat Pesanan Pembelian Tanpa Permintaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Buat Penerimaan Tanpa Permintaan Atau Pesanan')]]";
			content = content + "Buat Penerimaan Tanpa Permintaan Atau Pesanan" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Buat Tagihan tanpa Permintaan, Pesanan atau Penerimaan')]]";
			content = content + "Buat Tagihan tanpa Permintaan, Pesanan atau Penerimaan" + "\r\n" + "Aktif :" + AccTool
					.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Menerima Barang Melebihi Pesanan')]]";
			content = content + "Menerima Barang Melebihi Pesanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Mengubah Harga Beli')]]";
			content = content + "Mengubah Harga Beli" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Histori Hutang')]]";
			content = content + "Histori Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pengingat Hutang')]]";
			content = content + "Pengingat Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiPersediaan(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiPersediaan");

		String tab = w + "//div[contains(@id,'tab-inventory')]";
		String content = "AksesGrup.SaveIsiPersediaan : " + "\r\n";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		switch (param.hakakses.toLowerCase()) {
		case "kategori barang":
			content = content + "Kategori Barang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "satuan barang":
			content = content + "Satuan Barang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "gudang":
			content = content + "Gudang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "barang & jasa":
			content = content + "Barang & Jasa" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "pindah barang":
			content = content + "Pindah Barang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "pekerjaan pesanan":
			content = content + "Pekerjaan Pesanan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "penyelesaian pesanan":
			content = content + "Penyelesaian Pesanan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "penyesuaian persediaan":
			content = content + "Penyesuaian Persediaan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "penyesuaian harga":
			content = content + "Penyesuaian Harga" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "harga pemasok":
			content = content + "Harga Pemasok" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			break;
		case "histori stok barang":
			content = content + "Histori Stok Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "mengganti akun barang":
			content = content + "Mengganti Akun Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "ganti nama/deskripsi barang di transaksi":
			content = content + "Ganti Nama/Deskripsi barang di Transaksi" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "mengeluarkan barang melebihi stok":
			content = content + "Mengeluarkan barang melebihi stok" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "pengingat stok barang":
			content = content + "Pengingat Stok Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;

		case "all":
			hakakses = "//div[div/label[contains(text(),'Kategori Barang')]]";
			content = content + "Kategori Barang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Satuan Barang')]]";
			content = content + "Satuan Barang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Gudang')]]";
			content = content + "Gudang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Barang & Jasa')]]";
			content = content + "Barang & Jasa" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pindah Barang')]]";
			content = content + "Pindah Barang" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pekerjaan Pesanan')]]";
			content = content + "Pekerjaan Pesanan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Penyelesaian Pesanan')]]";
			content = content + "Penyelesaian Pesanan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Penyesuaian Persediaan')]]";
			content = content + "Penyesuaian Persediaan" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Penyesuaian Harga')]]";
			content = content + "Penyesuaian Harga" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Harga Pemasok')]]";
			content = content + "Harga Pemasok" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "Hak Lihat:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"view", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Histori Stok Barang')]]";
			content = content + "Histori Stok Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Mengganti Akun Barang')]]";
			content = content + "Mengganti Akun Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Ganti Nama/Deskripsi barang di Transaksi')]]";
			content = content + "Ganti Nama/Deskripsi barang di Transaksi" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Mengeluarkan barang melebihi stok')]]";
			content = content + "Mengeluarkan barang melebihi stok" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pengingat Stok Barang')]]";
			content = content + "Pengingat Stok Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiAsetTetap(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiAsetTetap");

		String tab = w + "//div[contains(@id,'tab-fixed_asset')]";
		String content = "AksesGrup.SaveIsiAssetTetap : " + "\r\n";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		switch (param.hakakses.toLowerCase()) {
		case "kategori aset":
			content = content + "Kategori Aset" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "kategori aset pajak":
			content = content + "Kategori Aset Pajak" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "pindah aset":
			content = content + "Pindah Aset" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "aset tetap":
			content = content + "Aset Tetap" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "perubahan aset":
			content = content + "Perubahan Aset" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "disposisi aset":
			content = content + "Disposisi Aset" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			break;
		case "aset per lokasi":
			content = content + "Aset per Lokasi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "all":
			hakakses = "//div[div/label[contains(text(),'Kategori Aset')]]";
			content = content + "Kategori Aset" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Kategori Aset Pajak')]]";
			content = content + "Kategori Aset Pajak" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Pindah Aset')]]";
			content = content + "Pindah Aset" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Aset Tetap')]]";
			content = content + "Aset Tetap" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Perubahan Aset')]]";
			content = content + "Perubahan Aset" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit",
							tab + hakakses)
					+ "Hak Hapus:" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"delete", tab + hakakses)
					+ "\r\n";
			hakakses = "//div[div/label[contains(text(),'Disposisi Aset')]]";
			content = content + "Disposisi Aset" + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", tab + hakakses)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", tab + hakakses)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete",
							tab + hakakses)
					+ "\r\n" + "Aset per Lokasi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
							AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";
			break;
		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiTarget(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiTarget");

		String tab = w + "//div[contains(@id,'tab-budget_target')]";
		String content = "AksesGrup.SaveIsiTarget : " + "\r\n";
		String hakakses = "";
		String xpath = "";

		AccTool.click(driver, w + "//a[contains(@href,'tab-budget_target')]");

		switch (param.hakakses.toLowerCase()) {
		case "all":
			hakakses = "Anggaran Beban & Pendapatan";
			xpath = tab + "//div[div/label[contains(text(),'" + hakakses + "')]]";
			content = content + hakakses + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", xpath)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", xpath)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", xpath)
					+ "Hak Lihat:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "view", xpath)
					+ "\r\n";

			hakakses = "Target Penjualan";
			xpath = tab + "//div[div/label[contains(text(),'" + hakakses + "')]]";
			content = content + hakakses + "\r\n" + "Hak Buat	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "create", xpath)
					+ "Hak Edit	:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "edit", xpath)
					+ "Hak Hapus:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "delete", xpath)
					+ "Hak Lihat:"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "view", xpath)
					+ "\r\n";
			break;
		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiKalender(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiKalender");

		String tab = w + "//div[contains(@id,'tab-reminder_calendar')]";
		String content = "AksesGrup.SaveIsiKalender : " + "\r\n";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-reminder_calendar')]");

		switch (param.hakakses.toLowerCase()) {
		case "kalender transaksi terjadwal":
			content = content + "Kalender Transaksi Terjadwal" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "kalender jatuh tempo piutang":
			content = content + "Kalender Jatuh Tempo Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "kalender jatuh tempo hutang":
			content = content + "Kalender Jatuh Tempo Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "kalender jadwal pengiriman pesanan":
			content = content + "Kalender Jadwal Pengiriman Pesanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "kalender jadwal penerimaan pembelian":
			content = content + "Kalender Jadwal Penerimaan Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(
					driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;
		case "kalender jatuh tempo no. produksi":
			content = content + "Kalender Jatuh Tempo No. Produksi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses) + "\r\n";
			break;

		case "all":
			content = content + "Kalender Transaksi Terjadwal" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n" + "Kalender Jatuh Tempo Piutang" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n" + "Kalender Jatuh Tempo Hutang" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n" + "Kalender Jadwal Pengiriman Pesanan" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n" + "Kalender Jadwal Penerimaan Pembelian" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable",
							tab + hakakses)
					+ "\r\n" + "Kalender Jatuh Tempo No. Produksi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
							AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "enable", tab + hakakses)
					+ "\r\n";

			break;
		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiWidget(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiWidget");

		String tab = w + "//div[contains(@id,'tab-widget')]";
		String content = "AksesGrup.SaveIsiWidget : " + "\r\n";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-widget')]");

		switch (param.hakakses.toLowerCase()) {
		case "keberhasilan penawaran":
			content = content + "keberhasilan penawaran" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "permintaan pembelian":
			content = content + "permintaan pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ketersediaan kas":
			content = content + "ketersediaan kas" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan penjual":
			content = content + "penjualan penjual" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "barang paling laku":
			content = content + "barang paling laku" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan barang":
			content = content + "penjualan barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "hutang usaha":
			content = content + "hutang usaha" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan bulan ini":
			content = content + "penjualan bulan ini" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "beban perusahaan":
			content = content + "beban perusahaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "barang perlu dipesan":
			content = content + "barang perlu dipesan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "pesanan pembelian":
			content = content + "pesanan pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "jumlah pelanggan":
			content = content + "jumlah pelanggan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan pelanggan":
			content = content + "penjualan pelanggan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "transaksi penjualan":
			content = content + "transaksi penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba cabang":
			content = content + "laba cabang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "pesanan penjualan":
			content = content + "pesanan penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba/rugi tahun ini":
			content = content + "laba/rugi tahun ini" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "performa penjual":
			content = content + "performa penjual" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan per hari":
			content = content + "penjualan per hari" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "aset saat ini":
			content = content + "aset saat ini" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "pelanggan berutang":
			content = content + "pelanggan berutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan cabang":
			content = content + "penjualan cabang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "all": // belom selesai
			content = content + "Keberhasilan Penawaran" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
							"//div[contains(@class,'r0') and " + "text()='" + param.hakakses
									+ "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n" + "\r\n";

			break;
		}
		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveIsiLaporan(WebDriver driver, AksesGrupParam param) {
		log.info("AksesGrup.SaveIsiLaporan");

		String tab = w + "//div[contains(@id,'tab-report')]";
		String content = "AksesGrup.SaveIsiLaporan : " + "\r\n";
		String hakakses = "//div[div/label[contains(text(),'" + param.hakakses + "')]]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-report')]");

		switch (param.hakakses.toLowerCase()) {
		// Keuangan
		case "laba/rugi (standar)":
			content = content + "laba/rugi (standar)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "neraca (standar)":
			content = content + "neraca (standar)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba/rugi (multi periode)":
			content = content + "laba/rugi (multi periode)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "neraca (multi periode)":
			content = content + "neraca (multi periode)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "arus kas (tak langsung)":
			content = content + "Arus Kas (Tak Langsung)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "proyeksi ketersediaan kas":
			content = content + "Proyeksi Ketersediaan Kas" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba/rugi (perbandingan periode)":
			content = content + "Laba/Rugi (Perbandingan Periode)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba/rugi (kuartal)":
			content = content + "Laba/Rugi (Kuartal)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba/rugi (perbandingan anggaran)":
			content = content + "Laba/Rugi (Perbandingan Anggaran)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba/rugi per cabang":
			content = content + "Laba/Rugi per Cabang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba/rugi per departemen":
			content = content + "Laba/Rugi per Departemen" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "neraca (perbandingan periode)":
			content = content + "Neraca (Perbandingan Periode)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "neraca (porsi)":
			content = content + "Neraca (Porsi)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "neraca (induk skontro)":
			content = content + "Neraca (Induk Skontro)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "arus kas (langsung)":
			content = content + "Arus Kas (Langsung)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian arus kas (langsung)":
			content = content + "Rincian Arus Kas (Langsung)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "fokus keuangan":
			content = content + "Fokus Keuangan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba ditahan":
			content = content + "Laba Ditahan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "perubahan ekuitas pemilik":
			content = content + "Perubahan Ekuitas Pemilik" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik perbandingan nilai akun":
			content = content + "Grafik Perbandingan Nilai Akun" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik pendapatan berbanding biaya":
			content = content + "Grafik Pendapatan berbanding Biaya" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik harta bersih":
			content = content + "Grafik Harta Bersih" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik rasio likuiditas":
			content = content + "Grafik Rasio Likuiditas" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik pengembalian aset":
			content = content + "Grafik Pengembalian Aset" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik pengembalian pada modal":
			content = content + "Grafik Pengembalian pada Modal" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Buku Besar
		case "keseluruhan jurnal":
			content = content + "Keseluruhan Jurnal" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ringkasan buku besar":
			content = content + "Ringkasan Buku Besar" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "histori buku besar":
			content = content + "Histori Buku Besar" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian buku besar":
			content = content + "Rincian Buku Besar" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian jurnal akun":
			content = content + "Rincian Jurnal Akun" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba/rugi terrealisasi":
			content = content + "Laba/Rugi Terrealisasi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "laba/rugi tidak terrealisasi":
			content = content + "Laba/Rugi Tidak Terrealisasi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "jurnal umum":
			content = content + "Jurnal Umum" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar akun perkiraan":
			content = content + "Daftar Akun Perkiraan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Kas&Bank
		case "histori bank":
			content = content + "Histori Bank" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ringkasan pembayaran per bank":
			content = content + "Ringkasan Pembayaran per Bank" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ringkasan penerimaan per bank":
			content = content + "Ringkasan Penerimaan per Bank" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian gaji per karyawan":
			content = content + "Rincian Gaji per Karyawan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "giro mundur (belum jatuh tempo)":
			content = content + "Giro Mundur (Belum Jatuh Tempo)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "arus kas per akun":
			content = content + "Arus Kas per Akun" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian pembayaran per bank":
			content = content + "Rincian Pembayaran per Bank" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian penerimaan per bank":
			content = content + "Rincian Penerimaan per Bank" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "pajak penghasilan karyawan":
			content = content + "Pajak Penghasilan Karyawan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "porsi gaji karyawan":
			content = content + "Porsi Gaji Karyawan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "gaji karyawan per tahun":
			content = content + "Gaji Karyawan per Tahun" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar kas":
			content = content + "Daftar Kas" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ringkasan daftar pembayaran":
			content = content + "Ringkasan Daftar Pembayaran" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ringkasan daftar penerimaan":
			content = content + "Ringkasan Daftar Penerimaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Piutang
		case "faktur belum lunas":
			content = content + "Faktur Belum Lunas" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "umur piutang":
			content = content + "Umur Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "buku besar pembantu piutang":
			content = content + "Buku Besar Pembantu Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "histori piutang":
			content = content + "Histori Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rata-rata pembayaran pelanggan":
			content = content + "Rata-rata Pembayaran Pelanggan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian umur piutang":
			content = content + "Rincian Umur Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik umur piutang":
			content = content + "Grafik Umur Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian buku besar pembantu piutang":
			content = content + "Rincian Buku Besar Pembantu Piutang" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "pernyataan piutang":
			content = content + "Pernyataan Piutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik rata-rata pembayaran pelanggan":
			content = content + "Grafik Rata-rata Pembayaran Pelanggan" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "pembayaran faktur":
			content = content + "Pembayaran Faktur" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penerimaan pelanggan":
			content = content + "Penerimaan Pelanggan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar pelanggan":
			content = content + "Daftar Pelanggan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Penjualan
		case "penjualan per pelanggan":
			content = content + "Penjualan per Pelanggan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan per barang":
			content = content + "Penjualan per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan barang per pelanggan":
			content = content + "Penjualan Barang per Pelanggan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan pelanggan per barang":
			content = content + "Penjualan Pelanggan per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ringkasan komisi penjual per periode":
			content = content + "Ringkasan Komisi Penjual per Periode" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "histori proses penjualan":
			content = content + "Histori Proses Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ringkasan komisi penjual per faktur":
			content = content + "Ringkasan Komisi Penjual per Faktur" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "ringkasan penjualan per pelanggan":
			content = content + "Ringkasan Penjualan per Pelanggan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ringkasan penjualan per barang":
			content = content + "Ringkasan Penjualan per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan per cabang":
			content = content + "Penjualan per Cabang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penjualan barang per cabang":
			content = content + "Penjualan Barang per Cabang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "retur penjualan per barang":
			content = content + "Retur Penjualan per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik penjualan bulanan":
			content = content + "Grafik Penjualan Bulanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "porsi penjualan per pelanggan":
			content = content + "Porsi Penjualan per Pelanggan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "porsi penjualan per barang":
			content = content + "Porsi Penjualan per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penawaran per pelanggan (belum proses)":
			content = content + "Penawaran per Pelanggan (Belum Proses)" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "penawaran per barang (belum proses)":
			content = content + "Penawaran per Barang (Belum Proses)" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "pesanan per pelanggan (belum proses)":
			content = content + "Pesanan per Pelanggan (Belum Proses)" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "pesanan per barang (belum proses)":
			content = content + "Pesanan per Barang (Belum Proses)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "uang muka penjualan":
			content = content + "Uang Muka Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian komisi penjual per faktur":
			content = content + "Rincian Komisi Penjual per Faktur" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian komisi penjual per periode":
			content = content + "Rincian Komisi Penjual per Periode" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "target penjualan barang":
			content = content + "Target Penjualan Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "target penjualan per kategori":
			content = content + "Target Penjualan per Kategori" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "target penjualan penjual":
			content = content + "Target Penjualan Penjual" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "target penjualan per bulan":
			content = content + "Target Penjualan per Bulan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar penawaran penjualan":
			content = content + "Daftar Penawaran Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian penawaran penjualan":
			content = content + "Rincian Penawaran Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar pesanan penjualan":
			content = content + "Daftar Pesanan Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian pesanan penjualan":
			content = content + "Rincian Pesanan Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar pengiriman pesanan":
			content = content + "Daftar Pengiriman Pesanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian pengiriman pesanan":
			content = content + "Rincian Pengiriman Pesanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar faktur penjualan":
			content = content + "Daftar Faktur Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian faktur penjualan":
			content = content + "Rincian Faktur Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik penjualan":
			content = content + "Grafik Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar retur penjualan":
			content = content + "Daftar Retur Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian retur penjualan":
			content = content + "Rincian Retur Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar komisi penjual":
			content = content + "Daftar Komisi Penjual" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Hutang
		/*
		 * case "faktur belum lunas": content = content + "Faktur Belum Lunas" + "\r\n"
		 * + "Aktif :" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP,
		 * ElementType.CHECKBOX, "//div[contains(@class,'r0') and " +
		 * "text()='"+param.hakakses+"']//following-sibling::input[@type='checkbox']",
		 * tab + hakakses) + "\r\n"; break;
		 */
		case "umur hutang":
			content = content + "Umur Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "buku besar pembantu hutang":
			content = content + "Buku Besar Pembantu Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "histori hutang":
			content = content + "Histori Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian umur hutang":
			content = content + "Rincian Umur Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian buku besar pembantu hutang":
			content = content + "Rincian Buku Besar Pembantu Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "grafik umur hutang":
			content = content + "Grafik Umur Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "pernyataan hutang":
			content = content + "Pernyataan Hutang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		/*
		 * case "pembayaran faktur": content = content + "Pembayaran Faktur" + "\r\n" +
		 * "Aktif :" + AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP,
		 * ElementType.CHECKBOX, "//div[contains(@class,'r0') and " +
		 * "text()='"+param.hakakses+"']//following-sibling::input[@type='checkbox']",
		 * tab + hakakses) + "\r\n"; break;
		 */
		case "pembayaran pemasok":
			content = content + "Pembayaran Pemasok" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar pemasok":
			content = content + "Daftar Pemasok" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Pembelian
		case "pembelian per pemasok":
			content = content + "Pembelian per Pemasok" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "pembelian per barang":
			content = content + "Pembelian per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "uang muka pembelian":
			content = content + "Uang Muka Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "histori proses pembelian":
			content = content + "Histori Proses Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian pembelian per pemasok":
			content = content + "Rincian Pembelian per Pemasok" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian pembelian per barang":
			content = content + "Rincian Pembelian per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "retur pembelian per barang":
			content = content + "Retur Pembelian per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "permintaan per barang (belum proses)":
			content = content + "Permintaan per Barang (Belum Proses)" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "pesanan per pemasok (belum proses)":
			content = content + "Pesanan per Pemasok (Belum Proses)" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		/*
		 * case "pesanan per barang (belum proses)": content = content +
		 * "Pesanan per Barang (Belum Proses)" + "\r\n" + "Aktif :" +
		 * AccTool.getTextValue(driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX,
		 * "//div[contains(@class,'r0') and " +
		 * "text()='"+param.hakakses+"']//following-sibling::input[@type='checkbox']",
		 * tab + hakakses) + "\r\n"; break;
		 */
		case "daftar permintaan pembelian":
			content = content + "Daftar Permintaan Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian permintaan pembelian":
			content = content + "Rincian Permintaan Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar pesanan pembelian":
			content = content + "Daftar Pesanan Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian pesanan pembelian":
			content = content + "Rincian Pesanan Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar penerimaan barang":
			content = content + "Daftar Penerimaan Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian penerimaan barang":
			content = content + "Rincian Penerimaan Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar faktur pembelian":
			content = content + "Daftar Faktur Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian faktur pembelian":
			content = content + "Rincian Faktur Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar retur pembelian":
			content = content + "Daftar Retur Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian retur pembelian":
			content = content + "Rincian Retur Pembelian" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Persediaan
		case "nilai persediaan":
			content = content + "Nilai Persediaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ketersediaan stok penjualan":
			content = content + "Ketersediaan Stok Penjualan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "umur persediaan":
			content = content + "Umur Persediaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian nilai persediaan":
			content = content + "Rincian Nilai Persediaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian ketersediaan stok penjualan":
			content = content + "Rincian Ketersediaan Stok Penjualan" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "rincian umur persediaan":
			content = content + "Rincian Umur Persediaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "kartu stok persediaan":
			content = content + "Kartu Stok Persediaan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "barang grup":
			content = content + "Barang Grup" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "perubahan harga per barang":
			content = content + "Perubahan Harga per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penyesuaian stok barang":
			content = content + "Penyesuaian Stok Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar barang dan jasa":
			content = content + "Daftar Barang dan Jasa" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Gudang
		case "kuantitas barang per gudang":
			content = content + "Kuantitas Barang per Gudang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "mutasi per barang":
			content = content + "Mutasi per Barang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "mutasi per gudang":
			content = content + "Mutasi per Gudang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "ringkasan mutasi gudang":
			content = content + "Ringkasan Mutasi Gudang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "stok nomor seri/produksi":
			content = content + "Stok Nomor Seri/Produksi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "stok nomor seri/produksi per gudang":
			content = content + "Stok Nomor Seri/Produksi per Gudang" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "lembar penghitungan stok":
			content = content + "Lembar Penghitungan Stok" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rincian transfer antar gudang":
			content = content + "Rincian Transfer Antar Gudang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar gudang":
			content = content + "Daftar Gudang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "mutasi nomor seri/produksi":
			content = content + "Mutasi Nomor Seri/Produksi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "histori nomor seri/produksi":
			content = content + "Histori Nomor Seri/Produksi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "sisa umur per nomor produksi":
			content = content + "Sisa Umur per Nomor Produksi" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "perbedaan jumlah barang dengan nomor seri/produksi":
			content = content + "Perbedaan Jumlah Barang dengan Nomor Seri/Produksi" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;

		// Pekerjaan Pesanan
		case "bahan dan biaya pekerjaan per bulan":
			content = content + "Bahan dan Biaya Pekerjaan per Bulan" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "histori pekerjaan pesanan":
			content = content + "Histori Pekerjaan Pesanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "penyelesaian barang/biaya per bulan":
			content = content + "Penyelesaian Barang/Biaya per Bulan" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "rincian jurnal pekerjaan pesanan":
			content = content + "Rincian Jurnal Pekerjaan Pesanan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Aset Tetap
		case "daftar aset tetap":
			content = content + "Daftar Aset Tetap" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "histori aset":
			content = content + "Histori Aset" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "jurnal aset":
			content = content + "Jurnal Aset" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "perbedaan penyusutan":
			content = content + "Perbedaan Penyusutan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "histori lokasi aset":
			content = content + "Histori Lokasi Aset" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "detil aset tetap":
			content = content + "Detil Aset Tetap" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "histori perubahan aset":
			content = content + "Histori Perubahan Aset" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar kategori aset tetap pajak":
			content = content + "Daftar Kategori Aset Tetap Pajak" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		// Pajak
		case "daftar ppn/ppnbm keluaran":
			content = content + "Daftar PPN/PPnBM Keluaran" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar ppn/ppnbm masukan":
			content = content + "Daftar PPN/PPnBM Masukan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "rekonsiliasi ppn lebih/kurang bayar":
			content = content + "Rekonsiliasi PPN Lebih/Kurang Bayar" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "daftar bukti potong pph23 pembelian":
			content = content + "Daftar Bukti Potong PPh23 Pembelian" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;
		case "daftar bukti potong pph23 penjualan":
			content = content + "Daftar Bukti Potong PPh23 Penjualan" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;

		// Pemeriksaan
		case "selisih saldo akun persediaan dengan nilai barang":
			content = content + "Selisih Saldo Akun Persediaan dengan Nilai Barang" + "\r\n" + "Aktif :"
					+ AccTool.getTextValue(
							driver, AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and "
									+ "text()='" + param.hakakses + "']//following-sibling::input[@type='checkbox']",
							tab + hakakses)
					+ "\r\n";
			break;

		// Lain-lain
		case "daftar mata uang":
			content = content + "Daftar Mata Uang" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar fob":
			content = content + "Daftar FOB" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar pajak":
			content = content + "Daftar Pajak" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar pengiriman":
			content = content + "Daftar Pengiriman" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;
		case "daftar karyawan":
			content = content + "Daftar Karyawan" + "\r\n" + "Aktif :" + AccTool.getTextValue(driver,
					AccurateModule.AKSES_GRUP, ElementType.CHECKBOX, "//div[contains(@class,'r0') and " + "text()='"
							+ param.hakakses + "']//following-sibling::input[@type='checkbox']",
					tab + hakakses) + "\r\n";
			break;

		}
		AccTool.writeTextFile(param.filename, content);
	}

}
