package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoripemasok.KategoriPemasokParam;

public class KategoriPemasokTool extends AbstractAccurateTestCase {
	
	static Logger log = LogManager.getLogger(KategoriPemasokParam.class);
	
	public static void isiForm(WebDriver driver, KategoriPemasokParam param)
	{
		log.info("KategoriPemasok.IsiForm");
		
		String w = AccurateModule.KATEGORI_PEMASOK.getXpath();
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
	
	public static void saveData(WebDriver driver, String fileName)
	{
		log.info("Save Isi: " + fileName);

		String content = "KategoriPemasok.SaveIsi : " + "\r\n";
		//String tab ="";

		content = content
				+ "Nama : " 
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_PEMASOK, ElementType.TEXTFIELD, "name")
				+ "Sub Kategori : " 
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_PEMASOK, ElementType.CHECKBOX, "sub")
				+ "Kategori Default :"
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_PEMASOK, ElementType.CHECKBOX, "isDefault")
				+ "Nama Sub : "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_PEMASOK, ElementType.LOOKUP, "parent") + "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
}
