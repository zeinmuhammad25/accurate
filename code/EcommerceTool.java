package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.ecommerce.EcommerceParam;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class EcommerceTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(EcommerceTool.class);

	public static void isiTabUmum(WebDriver driver, EcommerceParam param) {
		log.info("Ecommerce.IsiTabUmum");

		String w = AccurateModule.SMARTLINK_ECOMMERCE.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Umum']");

		if (param.marketplace != null)
			AccTool.combobox(driver, tab, "@name='ecommerceType'", param.marketplace);
		if (param.namatoko != null)
			AccTool.textField(driver, tab, "@name='shopName'", param.namatoko);
		if (param.cabang != null)
			AccTool.lookup(driver, tab, "@name='branch'", param.cabang);
		if (param.kenaPPN != null)
			AccTool.checkbox(driver, tab, "@name='taxable'", param.kenaPPN);
		if (param.kasbank != null)
			AccTool.lookup(driver, tab, "@name='paymentBankAccount'", param.kasbank);
		if (param.rb_semuastatus != null)
			AccTool.radioButton(driver, tab, "@name='importDoneTransaction' and @value='true'", param.rb_semuastatus);
		if (param.rb_semuastatus != null)
			AccTool.radioButton(driver, tab, "@name='importDoneTransaction' and @value='false'", param.rb_semuastatus);
	}

	public static void isiTabOngkir(WebDriver driver, EcommerceParam param) {
		log.info("Ecommerce.IsiTabOngkir");

		String w = AccurateModule.SMARTLINK_ECOMMERCE.getXpath();
		String tab = w + "//*[contains(@id,'tab-courierfee')]";

		AccTool.click(driver, w + "//a[text()='Ongkir dan Fee']");
		// ongkir ecommerce
		if (param.cb_ongkoskirim != null)
			AccTool.checkbox(driver, tab, "@name='importCourierCost'", param.cb_ongkoskirim);
		if (param.akunpendapatan != null)
			AccTool.lookup(driver, tab, "@name='courierAccount'", param.akunpendapatan);
		if (param.exclude_namakurir != null)
			AccTool.textarea(driver, tab, "@name='courierRules'", param.exclude_namakurir);
		// biaya layanan ecommerce
		if (param.cb_biayalayanan != null)
			AccTool.checkbox(driver, tab, "@name='taxable'", param.cb_biayalayanan);
		if (param.persenbiaya != null)
			AccTool.numberField(driver, tab, "@name='feeRate'", param.persenbiaya);
		if (param.akunbiaya != null)
			AccTool.lookup(driver, tab, "@name='feeAccount'", param.akunbiaya);

	}

	public static void isiTabLain(WebDriver driver, EcommerceParam param) {
		log.info("Ecommerce.IsiTabLain");

		String w = AccurateModule.SMARTLINK_ECOMMERCE.getXpath();
		String tab = w + "//*[contains(@id,'tab-other')]";

		AccTool.click(driver, w + "//a[text()='Lainnya']");
		// kelompok gudang penjualan
		if (param.rb_gudang != null)
			AccTool.radioButton(driver, tab, "@value='false' and @name='autoWarehouse'", param.rb_gudang);
		if (param.gudang != null)
			AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
		if (param.rb_gudangotomatis != null)
			AccTool.radioButton(driver, tab, "@value='true' and @name='autoWarehouse'", param.rb_gudangotomatis);

		// kelompok penjualan atas pelanggan
		if (param.rb_pelanggan != null)
			AccTool.radioButton(driver, tab, "@value='false' and @name='ecommerceCustomer'", param.rb_pelanggan);
		if (param.pelanggan != null)
			AccTool.lookup(driver, tab, "@name='customer'", param.pelanggan);
		if (param.rb_pelanggansesuaiecommerce != null)
			AccTool.radioButton(driver, tab, "@value='true' and @name='ecommerceCustomer'",
					param.rb_pelanggansesuaiecommerce);
	}

	public static void saveIsiTabUmum(WebDriver driver, String filename) {
		String content = "SmartlinkEcommerce.saveIsiTabUmum ; " + "\r\n";
		String w = AccurateModule.SMARTLINK_ECOMMERCE.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Umum']");

		content = content + "Marketplace	: "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "ecommerceTypeName", tab) + "Nama Toko	: "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "shopName", tab) + "Cabang		: "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "branch", tab) + "Kena PPN		: "
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "taxable", tab) + "Kas Bank		: "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "paymentBankAccount", tab);

		content = content + "Status selesai: "
				+ AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "importDoneTransaction:true", tab)
				+ "Semua status	: "
				+ AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "importDoneTransaction:false", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiTabOngkir(WebDriver driver, String filename) {
		String content = "SmartlinkEcommerce.saveIsiTabOngkir ; " + "\r\n";
		String w = AccurateModule.SMARTLINK_ECOMMERCE.getXpath();
		String tab = w + "//*[contains(@id,'tab-courierfee')]";

		AccTool.click(driver, w + "//a[text()='Ongkir dan Fee']");
		content = content + "Ongkir ecommerce	: "
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "importCourierCost", tab);
		String akunpendapatan = tab + "//input[@name='courierAccount']";
		if (WebElementTool.isElementExists(driver, By.xpath(akunpendapatan))) {
			content = content + "Akun Pendapatan	: "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "courierAccount", tab);
		}
		String exclude_kurir = tab + "//textarea[@name='courierRules']";
		if (WebElementTool.isElementExists(driver, By.xpath(exclude_kurir))) {
			content = content + "Exclude Kurir		: "
					+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "courierRules", tab);
		}
		content = content + "Biaya Layanan	: "
				+ AccTool.getTextValue(driver, ElementType.CHECKBOX, "feeEcommerce", tab);
		String persenbiaya = tab + "//input[@name='feeRate']";
		if (WebElementTool.isElementExists(driver, By.xpath(persenbiaya))) {
			content = content + "Persen Biaya	: "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "feeRate", tab);
		}
		String akunbiaya = tab + "//input[@name='feeAccount']";
		if (WebElementTool.isElementExists(driver, By.xpath(akunbiaya))) {
			content = content + "Akun Biaya	: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "feeAccount", tab);
		}
		content = content + "\r\n";

	}

	public static void saveIsiTabLain(WebDriver driver, String filename) {
		String content = "SmartlinkEcommerce.saveIsiTabLain ; " + "\r\n";

		String w = AccurateModule.SMARTLINK_ECOMMERCE.getXpath();
		String tab = w + "//*[contains(@id,'tab-other')]";

		AccTool.click(driver, w + "//a[text()='Lainnya']");

		content = content + "Gudang Penjualan		: "
				+ AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "autoWarehouse:false", tab)
				+ "Gudang				: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
				+ "Gudang Otomatis		: "
				+ AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "autoWarehouse:true", tab)
				+ "Pelanggan Penjualan	: "
				+ AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "ecommerceCustomer:false", tab)
				+ "Pelanggan			: " + AccTool.getTextValue(driver, ElementType.LOOKUP, "customer", tab)
				+ "Pelanggan Otomatis	: "
				+ AccTool.getTextValue(driver, ElementType.RADIOBUTTON, "ecommerceCustomer:true", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void referensiImpor(WebDriver driver, EcommerceParam param) {
		log.info("Ecommerce.referensiImpor");

		String w = AccurateModule.IMPOR_FAKTUR_PENJUALAN.getXpath();

		if (param.ecommercesetting != null)
			AccTool.lookup(driver, w, "@name='ecommerceSetting'", param.ecommercesetting);
	}

	public static void saveHasilImport(WebDriver driver, String fileName) {
		log.info("Ecommerce.saveHasilImport");
		String content = "";

		String form = "//div[starts-with(@id, 'accurate__customer__sales-invoice-import')]";
		String tab = form + "//h3[@class='import-step-header']/following-sibling::div";

		String labelsukses = tab + "//div/h4[contains(@data-bind, 'importedSuccessMessage')]";
		String labelgagal = tab + "//div/h4[contains(@data-bind, 'importedErrorMessage')]";

		content = content + "Hasil Impor Data : " + "\r\n"
				+ AccTool.getTextValue(driver, AccurateModule.IMPOR_FAKTUR_PENJUALAN, labelsukses);

		if (WebElementTool.isElementExists(driver, By.xpath(labelgagal))) {
			content = content + AccTool.getTextValue(driver, AccurateModule.IMPOR_FAKTUR_PENJUALAN, labelgagal);
		}

		content = content + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}

	public static void mappingItemManual(WebDriver driver, EcommerceParam param) {
		log.info("Ecommerce.mappingItemManual");
		String w = AccurateModule.IMPOR_FAKTUR_PENJUALAN.getXpath();
		String xpath_itemawal = w + "//div[contains(@class, 'item-map-preference')]/div[div[1]/div[text()='"
				+ param.itemawal + "']]";
		String xpath_itemtujuan = xpath_itemawal + "/div[2]";

		if (param.itemtujuan != null)
			AccTool.lookupMapping(driver, xpath_itemtujuan, "@name='item'", param.itemtujuan);
	}

}
