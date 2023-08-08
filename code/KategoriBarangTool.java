package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoribarang.KategoriBarangParam;

public class KategoriBarangTool extends AbstractAccurateTestCase {
	
	static Logger log = LogManager.getLogger(KategoriBarangParam.class);
	
	public static void isiForm(WebDriver driver, KategoriBarangParam param)
	{
		log.info("KategoriBarang.IsiForm");
		
		String w = AccurateModule.KATEGORI_BARANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";
		
		if(param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);
		
		if(param.isDefault != null)
			AccTool.checkbox(driver, tab, "@name='isDefault'", param.isDefault);
		
		if(param.cbsubkategori != null)
			AccTool.checkbox(driver, tab, "@name='sub'", param.cbsubkategori);
		
		if (param.namasubkategori != null)
			AccTool.lookup(driver, tab, "@name='parent'", param.namasubkategori);
	}
	
	public static void isiAkun(WebDriver driver, KategoriBarangParam param)
	{
		
		String w = AccurateModule.KATEGORI_BARANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-glaccount')]";
		
		AccTool.click(driver, AccurateModule.KATEGORI_BARANG.getXpath() + "//a[text()='Akun']");
		AccTool.click(driver, AccurateModule.KATEGORI_BARANG.getXpath() + "//*[contains(@href,'tab-glaccount')]");
	
		if(param.persediaan != null)
			AccTool.lookup(driver, tab, "@name='inventoryGlAccount'", param.persediaan);
		if(param.beban != null)
			AccTool.lookup(driver, tab, "@name='expenseGlAccount'", param.beban);
		if(param.penjualan != null)
			AccTool.lookup(driver, tab, "@name='salesGlAccount'", param.penjualan);
		if (param.returpenjualan != null)
			AccTool.lookup(driver, tab, "@name='salesRetGlAccount'", param.returpenjualan);
		if(param.diskonpenjualan != null)
			AccTool.lookup(driver, tab, "@name='salesDiscountGlAccount'", param.diskonpenjualan);
		if(param.barangterkirim != null)
			AccTool.lookup(driver, tab, "@name='goodTransitGlAccount'", param.barangterkirim);
		if(param.bpp != null)
			AccTool.lookup(driver, tab, "@name='cogsGlAccount'", param.bpp);
		if (param.returpembelian != null)
			AccTool.lookup(driver, tab, "@name='purchaseRetGlAccount'", param.returpembelian);
		if (param.barangbelumtertagih != null)
			AccTool.lookup(driver, tab, "@name='unBilledGlAccount'", param.barangbelumtertagih);
	}
	
	public static void SaveData(WebDriver driver, String fileName)
	{
		log.info("Save Isi: " + fileName);

		String content = "KategoriBarang.SaveIsi : " + "\r\n";
		String tab ="";

		content = content
				+ "Nama : " 
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.TEXTFIELD, "name", tab)
				+ "Sub Kategori : " 
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.CHECKBOX, "sub", tab)
				+ "Nama Sub : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "parent", tab) + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
	
	
	public static void saveIsiAkun(WebDriver driver, String filename) {
		log.info("Save Account");
		String tab = "//*[contains(@id,'tab-glaccount')]";
		String content = "KategoriBarang.SaveAkun : " + "\r\n";
		content = content 
				+ "\r\n"
				+ "Persediaan : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "inventoryGlAccount",tab)
				+ "Beban : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "expenseGlAccount", tab)
				+ "Penjualan : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "salesGlAccount", tab)
				+ "Retur Penjualan : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "salesRetGlAccount", tab)
				+ "Diskon Penjualan : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "salesDiscountGlAccount",tab)
				+ "Barang Terkirim : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "goodTransitGlAccount",tab)
				+ "Beban Pokok Penjualan : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "cogsGlAccount", tab)
				+ "Retur Pembelian : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "purchaseRetGlAccount",tab)
				+ "Pembelian Belum Tertagih : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_BARANG, ElementType.LOOKUP, "unBilledGlAccount", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);

	}
}
