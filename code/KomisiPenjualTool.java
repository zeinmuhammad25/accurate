package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.komisipenjual.KomisiPenjualParam;

public class KomisiPenjualTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(KomisiPenjualTool.class);

	public static void isiForm(WebDriver driver, KomisiPenjualParam param) {
		log.info("KomisiPenjual.Isi");

		String w = AccurateModule.KOMISI_PENJUAL.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Komisi Penjual']");

		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);
		if (param.berlakuuntukbarang != null)
			AccTool.combobox(driver, tab, "@name='optionItemTarget'", param.berlakuuntukbarang);
		if (param.namakategori != null)
			AccTool.lookup(driver, tab, "@name='itemCategoryTarget'", param.namakategori);
		if (param.namabarang != null)
			AccTool.lookup(driver, tab, "@name='itemTarget'", param.namabarang);
		if (param.daripemasokutama != null)
			AccTool.combobox(driver, tab, "@name='optionVendorTarget'", param.daripemasokutama);
		if (param.namapemasok != null)
			AccTool.lookup(driver, tab, "@name='vendorTarget'", param.namapemasok);
		if (param.tanpabatasandansyarat != null)
			AccTool.radioButton(driver, tab, "@name='rbrequirement' and @value ='NONE'", param.tanpabatasandansyarat);
		if (param.nilaipenjualan != null)
			AccTool.radioButton(driver, tab, "@name='rbrequirement' and @value ='AMOUNT_FROM_TO'",
					param.nilaipenjualan);
		if (param.nilaiantara != null)
			AccTool.numberField(driver, tab, "@name='requirementAmountFrom'", param.nilaiantara);
		if (param.nilaisampaidengan != null)
			AccTool.numberField(driver, tab, "@name='requirementAmountTo'", param.nilaisampaidengan);
		if (param.kuantitaspenjualan != null)
			AccTool.radioButton(driver, tab, "@name='rbrequirement' and @value ='QUANTITY_FROM_TO'",
					param.kuantitaspenjualan);
		if (param.kuantitasantara != null)
			AccTool.numberField(driver, tab, "@name='requirementQuantityFrom'", param.kuantitasantara);
		if (param.kuantitassampaidengan != null)
			AccTool.numberField(driver, tab, "@name='requirementQuantityTo'", param.kuantitassampaidengan);
		if (param.kuantitasterjual != null)

//			AccTool.moveToElementAndClick(driver, "//label[.='Akan mendapat komisi']");
			AccTool.radioButton(driver, tab, "@name='rbrequirement' and @value ='QUANTITY_MINIMUM'",
					param.kuantitasterjual);
		if (param.perunit != null)
			AccTool.numberField(driver, tab, "@name='requirementQuantityMinimum'", param.perunit);
		if (param.akanmendapatkomisi != null)
			AccTool.combobox(driver, tab, "@name='gain'", param.akanmendapatkomisi);
		if (param.nilaipersen != null)
			AccTool.numberField(driver, tab, "@name='gainAmountPercent'", param.nilaipersen);
		if (param.daripersen != null)
			AccTool.combobox(driver, tab, "@name='gainCalculatedBy'", param.daripersen);
		if (param.nilaitetap != null)
			AccTool.numberField(driver, tab, "@name='gainAmountFixed'", param.nilaitetap);
		if (param.darinilaitetap != null)
			AccTool.combobox(driver, tab, "@name='gainMultiplyBy'", param.darinilaitetap);
		if (param.cbpertama != null)
			AccTool.checkbox(driver, tab, "@name='forLevel1'", param.cbpertama);
		if (param.cbkedua != null)
			AccTool.checkbox(driver, tab, "@name='forLevel2'", param.cbkedua);
		if (param.cbketiga != null)
			AccTool.checkbox(driver, tab, "@name='forLevel3'", param.cbketiga);
		if (param.cbkeempat != null)
			AccTool.checkbox(driver, tab, "@name='forLevel4'", param.cbkeempat);
		if (param.cbkelima != null)
			AccTool.checkbox(driver, tab, "@name='forLevel5'", param.cbkelima);
	}

	public static void isiLainLain(WebDriver driver, KomisiPenjualParam param) {
		log.info("KomisiPenjual.IsiLainLain");

		String w = AccurateModule.KOMISI_PENJUAL.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, w + "//a[text()='Lain-lain']");

		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='memo'", param.catatan);
		if (param.cbnonaktif != null)
			AccTool.checkbox(driver, tab, "@name='suspended'", param.cbnonaktif);
	}

	public static void saveData(WebDriver driver, String filename) {
		log.info("KomisiPenjual.SaveData");

		String tab = "//*[contains(@id,'tab-general')]";
		String content = "Komisi Penjual .SaveIsiUmum : " + "\r\n";

		content = content + "\r\n" + "Nama perhitungan komisi : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.TEXTFIELD, "name", tab)
				+ "Komisi berlaku untuk barang : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.COMBOBOX, "optionItemTarget",
						tab)
				+ "Nama Kategori : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.LOOKUP, "itemCategoryTarget",
						tab)
				+ "Nama Barang : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.LOOKUP, "itemTarget", tab)
				+ "Dari pemasok utama : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.COMBOBOX,
						"optionVendorTarget", tab)
				+ "Tanpa Batasan Dan Syarat : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.RADIOBUTTON,
						"rbrequirement:NONE", tab)
				+ "Nilai Penjualan : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.RADIOBUTTON,
						"rbrequirement:AMOUNT_FROM_TO", tab)
				+ "Nilai Penjualan Antara : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.NUMBERFIELD,
						"requirementAmountFrom", tab)
				+ "Nilai penjualan Sampai Dengan : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.NUMBERFIELD,
						"requirementAmountTo", tab)
				+ "Kuantitas Penjualan : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.RADIOBUTTON,
						"rbrequirement:QUANTITY_FROM_TO", tab)
				+ "Kuantitas Penjualan Antara : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.NUMBERFIELD,
						"requirementQuantityFrom", tab)
				+ "Kuantitas Penjualan Sampai Dengan : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.NUMBERFIELD,
						"requirementQuantityTo", tab)
				+ "Kuantitas Terjual Per : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.RADIOBUTTON,
						"rbrequirement:QUANTITY_MINIMUM", tab)
				+ "Unit : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.NUMBERFIELD,
						"requirementQuantityMinimum", tab)
				+ "Akan Mendapat Komisi : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.COMBOBOX, "gain", tab)
				+ "Nilai Persen : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.NUMBERFIELD,
						"gainAmountPercent", tab)
				+ "Dari Persen : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.COMBOBOX, "gainCalculatedBy",
						tab)
//				+ "Nilai Tetap : "
//				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.NUMBERFIELD,
//						"gainAmountFixed", tab)
//				+ "Dari Nilai Tetap : "
//				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.COMBOBOX, "gainMultiplyBy",
//						tab)
				+ "Pertama : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.CHECKBOX, "forLevel1", tab)
				+ "Kedua : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.CHECKBOX, "forLevel2", tab)
				+ "Ketiga : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.CHECKBOX, "forLevel3", tab)
				+ "Keempat : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.CHECKBOX, "forLevel4", tab)
				+ "Kelima : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.CHECKBOX, "forLevel5", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
			

	}

	public static void saveLainLain(WebDriver driver, String filename) {
		log.info("KomisiPenjual.SaveData");

		String tab = "//*[contains(@id,'tab-others')]";
		String content = "Komisi Penjual .Save Lain Lain : " + "\r\n";
		
		AccTool.click(driver, "//a[text()='Lain-lain']");

		content = content + "Lain-Lain" + "\r\n" + "Catatan : "
				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.TEXTAREA, "memo", tab)
				+ "Non Aktif : "
//				+ AccTool.getTextValue(driver, AccurateModule.KOMISI_PENJUAL, ElementType.CHECKBOX, "suspended", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
		
	}

}
