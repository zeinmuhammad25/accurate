package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.karyawan.KaryawanParam;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class KaryawanTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(KaryawanTool.class);

	public static void klikBtnPenomoranOtomatisKaryawan(WebDriver driver) {
//		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-widget')]//button[@name='btnManualNumber']");
		//ui baru	
		AccTool.click(getWebDriver(), "//span[@class='toggle-slider round']");
		AccTool.waitLoaderMedium(getWebDriver());
	}

	public static void isi(WebDriver driver, KaryawanParam param) {
		log.info("Karyawan.Isi");

		String w = AccurateModule.KARYAWAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Karyawan']");

		if (param.sapaan != null)
			AccTool.combobox(driver, tab, "@name='salutation'", param.sapaan);

		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);

		if (param.jabatan != null)
			AccTool.textField(driver, tab, "@name='position'", param.jabatan);

		if (param.email != null)
			AccTool.textField(driver, tab, "@name='email'", param.email);

		if (param.handphone != null)
			AccTool.textField(driver, tab, "@name='mobilePhone'", param.handphone);

		if (param.teleponbisnis != null)
			AccTool.textField(driver, tab, "@name='workPhone'", param.teleponbisnis);

		if (param.teleponrumah != null)
			AccTool.textField(driver, tab, "@name='homePhone'", param.teleponrumah);

		if (param.pinbbm != null)
			AccTool.textField(driver, tab, "@name='bbmPin'", param.pinbbm);

		if (param.website != null)
			AccTool.textField(driver, tab, "@name='website'", param.website);

		if (param.id != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.id);

		if (param.no != null)
			AccTool.textField(driver, tab, "@name='number'", param.no);

		if (param.ktp != null)
			AccTool.textField(driver, tab, "@name='nikNo'", param.ktp);

		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);

		if (param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);

		if (param.cbpenjual != null)
			AccTool.checkbox(driver, tab, "@name='salesman'", param.cbpenjual);

		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='notes'", param.catatan);

		if (param.tanggalmasuk != null)
			AccTool.datePicker(driver, tab, "@name='joinDate'", param.tanggalmasuk);

		if (param.cbaktif != null)
			AccTool.checkbox(driver, tab, "@name='suspended'", param.cbaktif);
	}

	public static void klikAlamat(WebDriver driver) {
		AccTool.click(driver, AccurateModule.KARYAWAN.getXpath() + "//a[text()='Alamat']");
	}

	public static void isiAlamat(WebDriver driver, KaryawanParam param) {
		log.info("Karyawan.Isi");

		String w = AccurateModule.KARYAWAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-address')]";

		AccTool.click(driver, w + "//a[text()='Alamat']");

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

	public static void klikPajak(WebDriver driver) {
		AccTool.click(driver, AccurateModule.KARYAWAN.getXpath() + "//a[text()='Pajak Penghasilan']");
	}

	public static void isiPajak(WebDriver driver, KaryawanParam param) {
		log.info("karyawan.IsiPajak");

		String w = AccurateModule.KARYAWAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-tax')]";

		AccTool.click(driver, w + "//a[text()='Pajak Penghasilan']");

		if (param.cbkenapph != null)
			AccTool.checkbox(driver, tab, "@name='pph'", param.cbkenapph);

		if (param.nonpwp != null)
			AccTool.textField(driver, tab, "@name='npwpNo'", param.nonpwp);

		if (param.statuspekerja != null)
			AccTool.combobox(driver, tab, "@name='employeeWorkStatus'", param.statuspekerja);

		if (param.kenaptkp != null)
			AccTool.checkbox(driver, tab, "@name='calculatePtkp'", param.kenaptkp);

		if (param.statusptkp != null)
			AccTool.combobox(driver, tab, "@name='employeeTaxStatus'", param.statusptkp);

		if (param.pphbulan != null)
			AccTool.combobox(driver, tab, "@name='startMonthPayment'", param.pphbulan);

		if (param.pphtahun != null)
			AccTool.combobox(driver, tab, "@name='startYearPayment'", param.pphtahun);

		if (param.penghasilansebelumnya != null)
			AccTool.numberField(driver, tab, "@name='nettoIncomeBefore'", param.penghasilansebelumnya);

		if (param.pphsebelumnya != null)
			AccTool.numberField(driver, tab, "@name='pphBefore'", param.pphsebelumnya);

		if (param.resign != null)
			AccTool.checkbox(driver, tab, "@name='pph'", param.resign);

		if (param.gajibulanterakhir != null)
			AccTool.combobox(driver, tab, "@name='resignMonth'", param.gajibulanterakhir);

		if (param.gajitahunterakhir != null)
			AccTool.combobox(driver, tab, "@name='resignYear'", param.gajitahunterakhir);
	}

	public static void klikGaji(WebDriver driver) {
		AccTool.click(driver, AccurateModule.KARYAWAN + "//a[text()='Gaji/Tunjangan']");
	}

	public static void saveDetailKaryawan(WebDriver driver, String filename) {
		log.info("Karyawan.SaveDetailKaryawan");

		String tab = "//*[contains(@id,'tab-general')]";
		String content = "Karyawan.SaveDetailKaryawan : " + "\r\n";

		content = content + "Sapaan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.COMBOBOX, "salutation", tab)
				+ "Nama	: " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "name", tab)
				+ "Jabatan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "position", tab)
				+ "Email	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "email", tab)
				+ "Handphone	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "mobilePhone", tab)
				+ "Telepon Bisnis	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "workPhone", tab)
				+ "Telepon Rumah	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "homePhone", tab)
				+ "Pin BBM	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "bbmPin", tab)
				+ "Catatan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTAREA, "notes", tab)
				+ "Web Site	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "website", tab)
				+ "ID Karyawan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.COMBOBOX, "typeAutoNumber", tab)
				+ "ID Karyawan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "number", tab)
				+ "Tanggal Masuk	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.DATEPICKER, "joinDate", tab)
				+ "Cabang	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.COMBOBOX, "branch", tab)
				+ "Departemen	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.LOOKUP, "department", tab)
				+ "NO. KTP : "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "nikNo", tab)
				+ "Penjual :"
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.CHECKBOX, "salesman", tab)
				+ "Catatan :"
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTAREA, "notes", tab)
				+ "Non Aktif :"
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.CHECKBOX, "suspended", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);

	}

	public static void saveAlamat(WebDriver driver, String filename) {
		log.info("Karyawan.SaveAlamat");

		String tab = "//*[contains(@id,'tab-address')]";
		String content = "Karyawan.SaveAlamat : " + "\r\n";

		content = content + "Jalan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTAREA, "street", tab)
				+ "Kota	: " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "city", tab)
				+ "Kode Pos	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "zipCode", tab)
				+ "Propinsi	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "province", tab)
				+ "Negara	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "country", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void savePajak(WebDriver driver, String filename) {
		log.info("Karyawan.SavePajak");

		String tab = "//*[contains(@id,'tab-tax')]";
		String content = "Karyawan.SavePajak : " + "\r\n";
		
		content = content + "pph	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.CHECKBOX, "pph", tab)
				+ "NO NPWP	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "npwpNo", tab);
		
		//Status Pekerja ada 2 kondisi : Pegawai Tetap/Tidak dan Bukan Pegawai 
		String statuspekerja = tab + "//div[contains(@data-bind, 'employeeWorkStatusName')]";
		if (WebElementTool.isElementExists(driver, By.xpath(statuspekerja))) {
			content = content + "Status Pekerja : " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN,
					ElementType.SUMMARY, "employeeWorkStatus", tab);
		} else {
			content = content + "Status Pekerja : " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN,
					ElementType.COMBOBOX, "employeeWorkStatus", tab);
		}

		//Kena PTKP 2 Kondisi : Pegawai Tetap/Tidak dan Bukan Pegawai
		String kenaptkp = "//input[@name='calculatePtkp']";
		String kenaptkp2 = "//div[label[contains(text(),'Dikenakan PTKP')]]//following-sibling::div//span";
		if (WebElementTool.isElementExists(driver, By.xpath(kenaptkp))) {
			content = content + "kena PTKP : " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.CHECKBOX,
					"calculatePtkp", tab);
		} else {
			content = content + "kena PTKP : " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN, tab + kenaptkp2);		}
		
		content = content+ "Status PTKP	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.COMBOBOX, "employeeTaxStatus", tab);
				
		//PPh Mulai dihitung : Sudah ada pencatatan Gaji dan Belum ada
		String pphmulaihitung = tab + "//div[contains(@data-bind, 'startPaymentName')]";
		if (WebElementTool.isElementExists(driver, By.xpath(pphmulaihitung))) {
			content = content + "PPh mulai dihitung (Bulan) : " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN,
					ElementType.SUMMARY, "startPaymentName", tab);
		} else {
			content = content + "PPh mulai dihitung (Bulan) : " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN,
					ElementType.COMBOBOX, "startMonthPayment", tab);
		}
								
		content = content + "PPh mulai dihitung (Tahun)	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.COMBOBOX, "startYearPayment", tab);
				
		//Penghasilan Sebelumnya terdapat 2 kondisi : sebelum ada pencatatan gaji dan sesudah pencatatan gaji
		String penghasilanbefore = "//div[contains(@data-bind, 'nettoIncomeBefore')]";
		String penghasilanbefore2 = "//div[label[text()='Penghasilan Sebelumnya']]//following-sibling::div/div[1]/input[1]";
		if (WebElementTool.isElementVisible(driver, By.xpath(penghasilanbefore))) {
			content = content + "Penghasilan Sebelumnya	: " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.SUMMARY, "nettoIncomeBefore", tab);
		} else {
			content = content + "Penghasilan Sebelumnya	: " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN,ElementType.OTHER, null, tab + penghasilanbefore2);		
		}
		
		//PPh Sebelumnya terdapat 2 kondisi : sebelum ada pencatatan gaji dan sesudah pencatatan gaji
		String pphbefore = "//div[contains(@data-bind, 'pphBefore')]";
		String pphbefore2 = "//div[label[text()='PPh Sebelumnya']]//following-sibling::div/div[1]/input[1]";
		if (WebElementTool.isElementVisible(driver, By.xpath(pphbefore))) {
			content = content + "PPh Sebelumnya	: " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.SUMMARY, "pphBefore", tab);
		} else {
			content = content + "PPh Sebelumnya	: " + AccTool.getTextValue(driver, AccurateModule.KARYAWAN,ElementType.OTHER, null, tab + pphbefore2);		
		}
		
		content = content + "Resign	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.CHECKBOX, "pph", tab)
				+ "Gaji Terakhir (Bulan)	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.COMBOBOX, "resignMonth", tab)
				+ "Gaji Terakhir (Tahun)	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.COMBOBOX, "resignYear", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveGajiTunjangan(WebDriver driver, String filename) {
		log.info("Karyawan.SaveGajiTunjangan");

		String tab = "//*[contains(@id,'tab-address')]";
		String content = "Karyawan.SaveGajiTunjangan : " + "\r\n";

		content = content + "pph	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.CHECKBOX, "pph", tab)
				+ "NO NPWP	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.TEXTFIELD, "npwpNo", tab)
				+ "Status Pekerja	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.COMBOBOX, "employeeWorkStatus", tab)
				+ "Status PTKP	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.COMBOBOX, "employeeTaxStatus", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void isiGaji(WebDriver driver, KaryawanParam param) {
		log.info("karyawan.IsiGaji");

		String w = AccurateModule.KARYAWAN.getXpath();
		String tab = w + "//*[@class='general-tab-content frame active']//span[text()='" + param.gajitunjangan + "']";

		AccTool.click(driver, w + "//a[text()='Gaji/Tunjangan']");

		AccTool.checkboxDynamic(getWebDriver(), tab, param.komponengaji, param.cbkomponengaji);
	}

	public static void saveGaji(WebDriver driver, String filename, KaryawanParam param) {
		String tab = "//*[@class='general-tab-content frame active']//span[text()='" + param.gajitunjangan + "']";
		String content = "Karyawan.SaveGaji : " + "\r\n";

		content = content + "pph	: "
				+ AccTool.getTextValue(driver, AccurateModule.KARYAWAN, ElementType.CHECKBOX, "pph", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);

	}
}
