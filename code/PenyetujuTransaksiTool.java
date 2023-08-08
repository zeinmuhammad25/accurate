package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penyetujutransaksi.PenyetujuTransaksiParam;

public class PenyetujuTransaksiTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PenyetujuTransaksiTool.class);

	public static void isiPenyetujuTransaksi(WebDriver driver, PenyetujuTransaksiParam param) {
		log.info("PenyetujuTransaksiIsi");

		String w = AccurateModule.PENYETUJU_TRANSAKSI.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Penyetuju Transaksi']");

		if (param.tipetransaksi != null)
			AccTool.combobox(driver, tab, "@name='transactionType'", param.tipetransaksi);

		if (param.nilaiminimal != null)
			AccTool.numberField(driver, tab, "@name='minimalAmount'", param.nilaiminimal);

		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);

		if (param.disetujuioleh != null)
			AccTool.lookup(driver, tab, "@name='userList'", param.disetujuioleh);

		if (param.dengansyarat != null)
			AccTool.combobox(driver, tab, "@name='approvalUserType'", param.dengansyarat);
	}

	

	public static void saveIsiPenyetujuTransaksi(WebDriver driver, String filename) {
		String w = AccurateModule.PENYETUJU_TRANSAKSI.getXpath();
		String tab = "";
		String content = "PenyetujuTransaksi.SaveIsiPenyetujuTransaksi : " + "\r\n";

		AccTool.click(driver, w + "//a[text()='Penyetuju Transaksi']");
		tab = "//*[contains(@id,'tab-general')]";
		content = content
				+ "Tipe Transaksi	: "
				+ AccTool.getTextValue(driver, AccurateModule.PENYETUJU_TRANSAKSI,
						ElementType.COMBOBOX, "transactionType", tab)
				+ "Untuk Nilai Minimal : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYETUJU_TRANSAKSI,
						ElementType.NUMBERFIELD, "minimalAmount", tab)
				+ "Cabang : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYETUJU_TRANSAKSI,
						ElementType.COMBOBOX, "branch", tab)
				+ "Disetujui Oleh : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYETUJU_TRANSAKSI,
						ElementType.LOOKUP, "userList", tab)
				+ "Dengan Syarat : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYETUJU_TRANSAKSI,
						ElementType.COMBOBOX, "approvalUserType", tab)+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	

	//Isi penyetuju transaksi lebih dari 1
	
	public static void isiPenyetujuTransaksi2(WebDriver driver, PenyetujuTransaksiParam param) {
		log.info("PenyetujuTransaksiIsi");

		String w = AccurateModule.PENYETUJU_TRANSAKSI.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Penyetuju Transaksi']");

		if (param.tipetransaksi != null)
			AccTool.combobox(driver, tab, "@name='transactionType'", param.tipetransaksi);

		if (param.nilaiminimal != null)
			AccTool.numberField(driver, tab, "@name='minimalAmount'", param.nilaiminimal);

		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);

		if (param.disetujuioleh != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='userList'", param.disetujuioleh);

		if (param.dengansyarat != null)
			AccTool.combobox(driver, tab, "@name='approvalUserType'", param.dengansyarat);
	}


	
}
