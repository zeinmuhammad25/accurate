package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;





import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
//import com.cpssoft.web.test.accurate.kategoripelanggan.KategoriPelangganParam;
//import com.cpssoft.web.test.accurate.matauang.Isi;
//import com.cpssoft.web.test.accurate.matauang.IsiDefaultAkun;
import com.cpssoft.web.test.accurate.kategoriasettetappajak.KategoriAsetTetapPajakParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class KategoriAsetTetapPajakTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(KategoriAsetTetapPajakTool.class);
	
	public static void isi(WebDriver driver, KategoriAsetTetapPajakParam param) {
		log.info("kategoriasettetappajak.Isi");
		
		String w = AccurateModule.KATEGORI_ASET_TETAP_PAJAK.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";
		
		AccTool.click(driver, w + "//a[text()='Informasi umum']");
		
		if(param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", 
		param.nama);	
		
		if(param.metodepenyusutan != null) {
			AccTool.combobox(driver, w, "@name='depreciationMethod'", 
		param.metodepenyusutan);
			AccTool.waitProgressBar(driver);
		}
		
		if(param.perkiraanumur != null)
			AccTool.numberField(driver, w, "@name='estimatedLife'", 
		param.perkiraanumur);
		
		if(param.tarifpenyusutan != null)
			AccTool.numberField(driver, w, "@name='rate'", 
		param.tarifpenyusutan);
	}
	
	public static void saveIsi(WebDriver driver, String filename) {
		log.info("kategoriasettetappajak.SaveKonten");
		
		WaitTool.delay(1000);

//		String w = AccurateModule.KATEGORI_ASET_TETAP_PAJAK.getXpath();
		//String tab = "//*[contains(@id,'tab-general')]/div";
		String content = "kategoriasettetappajak.SaveKonten : " + "\r\n";
		
		content = content
				+ "Nama	: "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_ASET_TETAP_PAJAK, ElementType.TEXTFIELD,
						"name")
				+ "Metode Penyusutan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_ASET_TETAP_PAJAK, ElementType.COMBOBOX,
						"depreciationMethod")
				+ "Perkiraan Umur	: "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_ASET_TETAP_PAJAK, ElementType.NUMBERFIELD,
						"estimatedLife")
				+ "Tarif Penyusutan	: "
				+ AccTool.getTextValue(driver, AccurateModule.KATEGORI_ASET_TETAP_PAJAK, ElementType.NUMBERFIELD,
						"rate")
				+ "\r\n";

		AccTool.writeTextFile(filename, content);

	}

}
