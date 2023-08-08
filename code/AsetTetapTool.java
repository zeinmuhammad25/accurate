package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.asettetap.AsetTetapParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class AsetTetapTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(AsetTetapTool.class);

	public static void kliklanjutbiaya(WebDriver driver) {
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-expenditure')]");
	}

	public static void detailAkun(WebDriver driver, AsetTetapParam param) {
		log.info("asettetap.DetailAkun");
		String w = "//div[starts-with(@id,'detail-expenditure')]";
		// AccTool.click(driver, w);

		switch (param.tab.toLowerCase()) {
		case "pengeluaran":
			String tab = w + "//*[contains(@id,'tab-detailexpenditure')]";
			AccTool.click(driver, tab);

			if (param.deskripsi != null)
				AccTool.textField(driver, w, "@name='detailName'", param.deskripsi);

			if (param.jumlah != null)
				AccTool.numberField(driver, w, "@name='amount'", param.jumlah);
			break;
		case "catatan":
//			"//*[contains(@id,'tab-notes')]"
			tab = w + "//a[contains(@href,'tab-notes')]";
			AccTool.click(driver, tab);

			if (param.catatan != null)
				AccTool.textarea(driver, w, "@name='notes'", param.catatan);
			break;
		}
	}

	public static void isi(WebDriver driver, AsetTetapParam param) {
		log.info("asettetap.Isi");

		String w = AccurateModule.ASET_TETAP.getXpath();

		if (param.penomoran != null)
			AccTool.textField(driver, w, "@name='number'", param.penomoran);

		if (param.keterangan != null)
			AccTool.textField(driver, w, "@name='description'", param.keterangan);

		if (param.tanggalbeli != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggalbeli);

		if (param.tanggalpakai != null)
			AccTool.datePicker(driver, w, "@name='usageDate'", param.tanggalpakai);
	}

	public static void isiAkun(WebDriver driver, AsetTetapParam param) {
		log.info("asettetap.IsiAkun");

		String w = AccurateModule.ASET_TETAP.getXpath();
		String tab = w + "//*[contains(@id,'tab-expenditure')]";

		AccTool.click(driver, "//a[contains(@href,'tab-expenditure')]");

		if (param.searchakun != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.searchakun);

		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
	}

	public static void isiInfoLain(WebDriver driver, AsetTetapParam param) {
		log.info("asettetap.IsiInfoLain");

		String w = AccurateModule.ASET_TETAP.getXpath();
		String tab = w + "//*[contains(@id,'tab-account')]";

		AccTool.click(driver, "//a[contains(@href,'tab-account')]");

		if (param.kategoriaset != null)
			AccTool.lookup(driver, tab, "@name='faType'", param.kategoriaset);

		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);

		if (param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);

		if (param.lokasiawal != null)
			AccTool.lookup(driver, tab, "@name='location'", param.lokasiawal);

		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='notes'", param.catatan);

		if (param.cbpajak != null)
			AccTool.checkbox(driver, tab, "@name='fiscalFa'", param.cbpajak);

		if (param.fiskalaset != null)
			AccTool.lookup(driver, tab, "@name='fiscalFaType'", param.fiskalaset);
	}

	public static void isiInfoUmum(WebDriver driver, AsetTetapParam param) {
		log.info("asettetap.IsiInformasiUmum");

		String w = AccurateModule.ASET_TETAP.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w);

		if (param.cbasettidakberwujud != null)
			AccTool.checkbox(driver, tab, "@name='intangible'", param.cbasettidakberwujud);

		if (param.metodepenyusutan != null)
			AccTool.combobox(driver, tab, "@name='depreciationMethod'", param.metodepenyusutan);

		if (param.akunaset != null)
			AccTool.lookup(driver, tab, "@name='assetAccount'", param.akunaset);

		if (param.akunakumulasipenyusutan != null)
			AccTool.lookup(driver, tab, "@name='acmDepreciationAccount'", param.akunakumulasipenyusutan);

		if (param.akunbebanpenyusutan != null)
			AccTool.lookup(driver, tab, "@name='depreciationAccount'", param.akunbebanpenyusutan);

		if (param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);

		if (param.umurasettahun != null)
			AccTool.numberField(driver, tab, "@name='estimatedLifeYear'", param.umurasettahun);

		if (param.umurasetbulan != null)
			AccTool.numberField(driver, tab, "@name='estimatedLifeMonth'", param.umurasetbulan);

		if (param.nilaisisa != null)
			AccTool.numberField(driver, tab, "@name='residu'", param.nilaisisa);
	}

	public static void saveDetail(WebDriver driver, String filename) {
		log.info("asettetap.SaveDetail");

		String tab = "";
		String content = "AsetTetap.SaveDetail : " + "\r\n";
		tab = "//*[contains(@id,'tab-detailexpenditure')]";
		AccTool.click(driver, tab);
		content = content + "\r\n" + "Deskripsi		: "
				+ AccTool.getTextValue(driver, AccurateModule.UMUM, ElementType.TEXTFIELD, "detailName")
//					+AccTool.getTextValuePop(driver, AccurateModule.ASET_TETAP, ElementType.TEXTFIELD, "detailName", tab)
				+ "Jumlah	: "
				+ AccTool.getTextValue(driver, AccurateModule.UMUM, ElementType.NUMBERFIELD, "amount", tab)
//					+AccTool.getTextValuePop(driver, AccurateModule.ASET_TETAP, ElementType.NUMBERFIELD, "amount", tab)
				+ "\r\n";

//			tab = "//div[starts-with(@id,'tab-notes')]";
//			AccTool.click(driver, tab);
//			content = content
//					+ "Keterangan"
//					+ "\r\n"
//					+ "Catatan	: "
//					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.TEXTAREA,
//							"notes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiHeader(WebDriver driver, String filename) {
		String xpath = "//div[contains(@data-bind, 'text: formData.transDate')]";
		boolean exists = false;
		List<WebElement> tglBeliDisable = driver.findElements(By.xpath(xpath));
		log.info("Tgl beli disable: " + tglBeliDisable.size());
		exists = tglBeliDisable.size() > 0;

		if (exists) {
			String content = "AsetTetap.SaveHeader : " + "\r\n";
			content = content + "Kode Aset	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.TEXTFIELD, "number")
					+ "Nama	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.TEXTFIELD, "description")
					+ "Tanggal Beli	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.SUMMARY,
							"text: formData.transDate")
					+ "Tanggal Pakai	: " + AccTool.getTextValue(driver, AccurateModule.ASET_TETAP,
							ElementType.SUMMARY, "text: formData.usageDate")
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		} else {
			String content = "AsetTetap.SaveHeader : " + "\r\n";
			content = content + "Kode Aset	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.TEXTFIELD, "number")
					+ "Nama	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.TEXTFIELD, "description")
					+ "Tanggal Beli	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.DATEPICKER, "transDate")
					+ "Tanggal Pakai	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.DATEPICKER, "usageDate")
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}

	}

	public static void saveIsiInformasiUmum(WebDriver driver, String filename) {
		String xpath = "//div[contains(@data-bind, 'text: formData.depreciationMethodName')]";
		boolean exists = false;
		List<WebElement> metodeDepresiasiDisable = driver.findElements(By.xpath(xpath));
		log.info("Metode Depresiasi disable: " + metodeDepresiasiDisable.size());
		exists = metodeDepresiasiDisable.size() > 0;

		if (exists) {
			String content = "AsetTetap.SaveInformasiUmum : " + "\r\n";
			String tab = null;
			AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-general')]");
			tab = "//*[contains(@id,'tab-general')]";
			content = content + "Aset Tidak Berwujud	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP,
							"//div/div[label[text()='Aset Tidak Berwujud']]/following-sibling::div/div")
					+ "Metode Penyusutan	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.SUMMARY,
							"text: formData.depreciationMethodName", tab)
					+ "Akun Aset	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "assetAccount", tab)
					+ "Akun Akumulasi Penyusutan	: "
					+ AccTool.getTextValue(
							driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "acmDepreciationAccount", tab)
					+ "Akun Beban Penyusutan	: "
					+ AccTool.getTextValue(
							driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "depreciationAccount", tab)
					+ "Kuantitas	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.SUMMARY,
							"text: app.util.parseNumber(formData.quantityAvailable()", tab)
					+ "Umur Aset Tahun	: " + AccTool.getTextValue(driver, AccurateModule.ASET_TETAP,
							ElementType.SUMMARY, "text: app.util.parseNumber(formData.estimatedLifeYear())", tab)
					+ "Umur Aset Bulan	: " + AccTool.getTextValue(driver, AccurateModule.ASET_TETAP,
							ElementType.SUMMARY, "text: app.util.parseNumber(formData.estimatedLifeMonth())", tab)
					+ "Rasio	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.SUMMARY,
							"text: app.util.parseNumber(formData.depreciationRate())", tab)
					+ "Nilai Sisa	: " + AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.SUMMARY,
							"text: app.util.parseNumber(formData.residu())", tab)
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		} else {
			String content = "AsetTetap.SaveInformasiUmum : " + "\r\n";
			String tab = null;
			AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-general')]");
			tab = "//*[contains(@id,'tab-general')]";
			content = content + "Aset Tidak Berwujud	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.CHECKBOX, "intangible", tab)
					+ "Metode Penyusutan	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.COMBOBOX,
							"depreciationMethod", tab)
					+ "Akun Aset	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "assetAccount", tab)
					+ "Akun Akumulasi Penyusutan	: "
					+ AccTool.getTextValue(
							driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "acmDepreciationAccount", tab)
					+ "Akun Beban Penyusutan	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "depreciationAccount",
							tab)
					+ "Kuantitas	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Umur Aset Tahun	: "
					+ AccTool.getTextValue(
							driver, AccurateModule.ASET_TETAP, ElementType.NUMBERFIELD, "estimatedLifeYear", tab)
					+ "Umur Aset Bulan	: "
					+ AccTool.getTextValue(
							driver, AccurateModule.ASET_TETAP, ElementType.NUMBERFIELD, "estimatedLifeMonth", tab)
					+ "Rasio	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.SUMMARY,
							"text: app.util.parseNumber(formData.depreciationRate())", tab)
					+ "Nilai Sisa	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.NUMBERFIELD, "residu", tab)
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}
	}

	public static void saveIsiInformasiUmumEdit(WebDriver driver, String filename) {
		String content = "asettetap.SaveInformasiUmum : " + "\r\n";
		String tab = null;

		AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-general')]");
		tab = "//*[contains(@id,'tab-general')]";
		content = content + "Metode Penyusutan	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LABEL, "depreciationMethodName",
						tab)
				+ "Akun Aset	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "assetAccount", tab)
				+ "Akun Akumulasi Penyusutan	: "
				+ AccTool.getTextValue(
						driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "acmDepreciationAccount", tab)
				+ "Akun Beban Penyusutan	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "depreciationAccount",
						tab)
				+ "Kuantitas	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LABEL, "quantityAvailable()", tab)
				+ "Umur Aset Tahun	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LABEL, "estimatedLifeYear()", tab)
				+ "Umur Aset Bulan	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LABEL, "estimatedLifeMonth()",
						tab)
				+ "Nilai Sisa	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LABEL, "residu()", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveListAkun(WebDriver driver, String filename) {
		String content = "AsetTetap.SaveListAkun : " + "\r\n";

		AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-expenditure')]");
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.ASET_TETAP, "//*[contains(@id,'tab-expenditure')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiInfoLain(WebDriver driver, String filename) {
		String content = "AsetTetap.SaveInfoLain : " + "\r\n";
		String tab = null;
		AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-account')]");
		tab = "//*[contains(@id,'tab-account')]";
		content = content + "Kategori Aset	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "faType", tab);
		String namacabang = "//*[contains(@id,'tab-account')]//select[@name = 'branch']";
		if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
			content = content + "Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.COMBOBOX, "branch", tab);
		} else {
			content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.ASET_TETAP,
					ElementType.SUMMARY, "branchListOption", tab);
		}

		content = content + "Departemen	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "department", tab)
				+ "Lokasi Awal Aset	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "location", tab)
				+ "Catatan	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.TEXTAREA, "notes", tab);
		String pajak = "//div[starts-with(@id, 'tab-account')]//input[@name='fiscalFa']";
		if (WebElementTool.isElementExists(driver, By.xpath(pajak))) {
			content = content + "Pajak	: "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.CHECKBOX, "fiscalFa", tab);
		} else {
			content = content + "Penyusutan Terakhir : "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.SUMMARY,
							"text: formData.lastJournalDate", tab)
					+ "Pajak : " + AccTool.getTextValue(driver, AccurateModule.ASET_TETAP,
							"//div/div[label[text()='Pajak']]/following-sibling::div/div");
		}
		content = content + "Tipe Aset Pajak	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "fiscalFaType", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveListPengeluaran(WebDriver driver, String filename) {
		log.info("Pengeluaran.saveListAkun");

		String content = "\r\n";
		String tab = "//*[contains(@id,'tab-expenditure')]";
		content = content + AccTool.getGridValue(driver, AccurateModule.ASET_TETAP, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveAll(WebDriver driver, String filename) {
		String content = "asettetap.SaveInfoLain : " + "\r\n";
		String tab = null;
		String tab1 = null;

		AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-account')]");
		tab = "//*[contains(@id,'tab-account')]";
		content = content

				+ "Kategori Aset	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "faType", tab);
		String namacabang = "//*[contains(@id,'tab-account')]//select[@name = 'branch']";
		if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
			content = content + "Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.COMBOBOX, "branch", tab);
		} else {
			content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.ASET_TETAP,
					ElementType.SUMMARY, "branchListOption", tab);
		}

		content = content + "Departemen	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "department", tab)
				+ "Lokasi Awal Aset	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "location", tab)
				+ "Catatan	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.TEXTAREA, "notes", tab)
				+ "Pajak	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.CHECKBOX, "fiscalFa", tab)
				+ "Tipe Aset Pajak	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "fiscalFaType", tab)
				+ "\r\n";

		AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-expenditure')]");
		content = content + "asettetap.SaveDetailAkun" + "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.ASET_TETAP, "//*[contains(@id,'tab-expenditure')]")
				+ "\r\n";

		AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-general')]");
		tab1 = "//*[contains(@id,'tab-general')]";
		content = content + "asettetap.SaveInfoUmum" + "\r\n" + "Aset Tidak Berwujud	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.CHECKBOX, "intangible", tab1)
				+ "Metode Penyusutan	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.COMBOBOX, "depreciationMethod",
						tab1)
				+ "Akun Aset	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "assetAccount", tab1)
				+ "Akun Akumulasi Penyusutan	: "
				+ AccTool.getTextValue(
						driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "acmDepreciationAccount", tab1)
				+ "Akun Beban Penyusutan	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.LOOKUP, "depreciationAccount",
						tab1)
				+ "Kuantitas	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.NUMBERFIELD, "quantity", tab1)
				+ "Umur Aset Tahun	: "
				+ AccTool.getTextValue(
						driver, AccurateModule.ASET_TETAP, ElementType.NUMBERFIELD, "estimatedLifeYear", tab1)
				+ "Umur Aset Bulan	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.NUMBERFIELD, "estimatedLifeMonth",
						tab1)
				+ "Nilai Sisa	: "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.NUMBERFIELD, "residu", tab1)
				+ "\r\n";

		AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-location')]");
		content = content + "asettetap.SaveLokasiAset" + "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.ASET_TETAP, "//*[contains(@id,'tab-location')]") + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveListLokasiAset(WebDriver driver, String filename) {
		String content = "AsetTetap.SaveLokasiAset	: " + "\r\n";

		AccTool.click(driver, AccurateModule.ASET_TETAP.getXpath() + "//a[contains(@href,'tab-location')]");
		content = content + AccTool.getGridValue(driver, AccurateModule.ASET_TETAP, "//*[contains(@id,'tab-location')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveFooter(WebDriver driver, String filename) {
		WaitTool.delay(1000);
		String content = "AsetTetap.SaveFooter : " + "\r\n";
		String tab = "//div[text()='Total Aset']/following-sibling::div";
		String tab1 = "//div[text()='Nilai Buku']/following-sibling::div";

		content = content + "Total Aset : " + "Rp "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.SPAN, "parsenumber", tab)
				+ "Nilai Buku : " + "Rp "
				+ AccTool.getTextValue(driver, AccurateModule.ASET_TETAP, ElementType.SPAN, "parsenumber", tab1)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveList(WebDriver driver, String filename) {
		log.info("AsetTetap.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String nodata_xpath = "//div[@class='grid-canvas']//div[text()='Belum ada data']";
		String content = "AsetTetap.SaveList : " + "\r\n";
		boolean exists = false;

		List<WebElement> nodata = driver
				.findElements(By.xpath(AccurateModule.ASET_TETAP.getXpath() + tab + nodata_xpath));
		exists = nodata.size() > 0;
		if (exists) {
			content = content + "BELUM ADA DATA" + "\r\n";
		} else {
			content = content + AccTool.getGridValue(driver, AccurateModule.ASET_TETAP, tab) + "\r\n";
		}

		AccTool.writeTextFile(filename, content);
	}

}
