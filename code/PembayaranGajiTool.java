package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pembayarangaji.PembayaranGajiParam;

public class PembayaranGajiTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PembayaranGajiTool.class);

	public static void isiForm(WebDriver driver, PembayaranGajiParam param) {
		log.info("PembayaranGaji.IsiForm");

		String w = AccurateModule.PEMBAYARAN_GAJI.getXpath();
		
		if (param.cabang != null)
			AccTool.combobox(driver, w, "@name='branch'", param.cabang);
		if (param.bulangaji != null)
			AccTool.combobox(driver, w, "@name='paymentMonth'", param.bulangaji);
		if (param.tahungaji != null)
			AccTool.combobox(driver, w, "@name='paymentYear'", param.tahungaji);
		if (param.nomorcek != null)
			AccTool.textField(driver, w, "@name='chequeNo'", param.nomorcek);
		if (param.kurs != null)
			AccTool.numberField(driver, w, "@name='rate'", param.kurs);
		if (param.nomorbuktiotom != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.nomorbuktiotom);
		if (param.nomorbuktimanual != null)
			AccTool.textField(driver, w, "@name='number'", param.nomorbuktimanual);
		if (param.tanggalcek != null)
			AccTool.datePicker(driver, w, "@name='chequeDate'", param.tanggalcek);
		if (param.kasbankakun != null)
			AccTool.lookup(driver, w, "@name='bank'", param.kasbankakun);
	}

	public static void isiDetailKaryawan(WebDriver driver, PembayaranGajiParam param) {
		log.info("PembayaranGaji.IsiRincianKaryawan");

		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-detail')]";		
		
		AccTool.click(driver, w + "//*[contains(@href,'tab-detail')]");

		AccTool.lookup(driver, tab, "@name='searchDetailEmployee'", param.searchkaryawan);
		AccTool.scrollRowDetail(driver, tab, param.scroll);				
	}
	
	public static void isiInfoLain(WebDriver driver, PembayaranGajiParam param) {
		log.info("PembayaranGaji.IsiInfoLain");
		
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-employeeheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-employeeheader')]");
				
		AccTool.textarea(driver, tab, "@name='description'", param.catataninfo);			
		AccTool.checkbox(driver, tab, "@name='voidCheq'", param.cbvoid);		
	}
	
	public static void detailKaryawan(WebDriver driver, PembayaranGajiParam param) {
		log.info("PembayaranGaji.DetailKaryawan");

		String tab = "";

		switch ((param.tab).toLowerCase()) {
		case "rincian gaji":
			tab = "//div[starts-with(@id,'tab-detailemployee')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");

			AccTool.numberField(driver, tab, "@name='employeeFee'",
					param.detgajipokok);
			break;
		case "catatan":
			tab = "//div[starts-with(@id,'tab-notes')]";
			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");

			AccTool.textarea(driver, tab, "@name='memo'", param.catatan);
			break;
		}

	}
	
	
	public static void saveData(WebDriver driver, PembayaranGajiParam param,  String filename) {
		log.info("PembayaranGaji.SaveIsi");

		String w = param.w;
		String tab = "";
		String content = "PembayaranGaji.SaveIsi : " + "\r\n";

		switch (param.tab.toLowerCase()) {
		case "header":
			content = content
					+ "Header"
					+ "\r\n"
					+ "Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.LOOKUP, "branch", tab)
					+ "Gaji Bulan : "		
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.COMBOBOX, "paymentMonth", tab)
					+ "Gaji Tahun : "		
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.COMBOBOX, "paymentYear", tab)
					+ "Nomor Cek : "		
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.TEXTFIELD, "chequeNo", tab)
					+ "Kurs : "		
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.NUMBERFIELD, "rate", tab)
					+ "Tanggal Cek : "		
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.DATEPICKER, "chequeDate", tab)
					+ "No Bukti : "		
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.TEXTFIELD, "number", tab) 
					+ "Tanggal Form : "		
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.DATEPICKER, "transDate", tab)
					+ "Kas/Bank : "		
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.LOOKUP, "bank", tab) + "\r\n";
			break;
		case "detail karyawan":
			AccTool.click(driver, w + "//a[contains(@href,'tab-detail')]");
			tab = w + "//*[contains(@id,'tab-detail')]";
			content = content + "Detail" + "\r\n"
					+ AccTool.getGridValue(driver, AccurateModule.PEMBAYARAN_GAJI, tab) + "\r\n";
			break;

		case "info lain":
			AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
			tab = w + "//*[contains(@id,'tab-otherheader')]";
			content = content
					+ "Info Lain"
					+ "\r\n"
					+ "Catatan : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.TEXTAREA, "description", tab)
					+ "Akun Hutang PPh : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.LOOKUP, "pphAccount", tab)
					+ "V O I D : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.CHECKBOX, "voidCheq", tab)
					+ "Reconciled : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.LABEL, "reconciled()", tab) + "\r\n";

			break;

		case "summary":
			AccTool.click(driver, w + "//a[contains(@href,'tab-summary')]");
			tab = w + "//*[contains(@id,'tab-summary')]";
			content = content
					+ "Ringkasan Pembayaran"
					+ "\r\n"
					+ "Gaji Pokok : "
					+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
							ElementType.LABEL, "parseNumber(amount)", tab) + "\r\n";
			break;
		}
		AccTool.writeTextFile(param.filename,  content);
	}

	public static void saveDetail(WebDriver driver, PembayaranGajiParam param,  String filename) {
		log.info("PembayaranGaji.SaveDetail");

		String tab = "";
		String content = "PembayaranGaji.SaveDetail : " + "\r\n";

		tab = "//div[starts-with(@id,'tab-detailemployee')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
		content = content
				+ "Rincian Gaji"
				+ "\r\n"
				+ "Gaji Pokok : "
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
						ElementType.NUMBERFIELD, "employeeFee", tab)
				+ "Pajak Penghasilan :"
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
						ElementType.LABEL, "pphAmount()", tab)
				+ "Gaji/Tunjangan :"
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
						ElementType.LABEL, "amount()", tab) + "\r\n";

		tab = "//div[starts-with(@id,'tab-notes')]";
		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		content = content
				+ "Catatan"
				+ "\r\n"
				+ AccTool.getTextValue(driver, AccurateModule.PEMBAYARAN_GAJI,
						ElementType.TEXTAREA, "memo", tab) + "\r\n";

		AccTool.writeTextFile(param.filename,  content);
	}
	
	public static void ambilPencatatanGaji (WebDriver driver, PembayaranGajiParam param)
	{
		String w = AccurateModule.PEMBAYARAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
		AccTool.click(getWebDriver(), w + "//a[text() = 'Pencatatan Gaji']");
	}
}
