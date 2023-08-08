package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pajak.PajakParam;

public class PajakTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(PajakTool.class);

	public static void isi(WebDriver driver, PajakParam param) {
		log.info("pajak.Isi");

		String w = AccurateModule.PAJAK.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Pajak']");

		if(param.tipe != null)
			AccTool.combobox(driver, tab, "@name='taxType'", 
		param.tipe);
		
		if(param.tipePs4Ay2 != null)
			AccTool.combobox(driver, tab, "@name='pphPs4Type'", 
		param.tipePs4Ay2);
		
		if(param.tipepph15 != null)
			AccTool.combobox(driver, tab, "@name='pph15Type'", 
		param.tipepph15);
		
		if(param.tipepph != null)
			AccTool.combobox(driver, tab, "@name='pph23Type'", 
		param.tipepph);
		
		if(param.keterangan != null)
			AccTool.textField(driver, tab, "@name='description'", 
		param.keterangan);
		
		if(param.persentase != null)
			AccTool.numberField(driver, tab, "@name='rate'", 
		param.persentase);
		
		if(param.akunpajakpenjualan != null)
			AccTool.lookup(driver, tab, "@name='salesTaxGlAccount'", 
		param.akunpajakpenjualan);
		
		if(param.akunpajakpembelian != null)
			AccTool.lookup(driver, tab, "@name='purchaseTaxGlAccount'", 
		param.akunpajakpembelian);
	}
	
	public static void saveIsi(WebDriver driver, String filename) {
		log.info("Pajak.SaveIsi");
		
//		String w = AccurateModule.PAJAK.getXpath();
		String content = "Pajak.SaveIsi : " + "\r\n";

		content = content
				+ "Tipe	Pajak: "
				+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.COMBOBOX,
						"taxType")
				+ "Tipe	PPH23 : "
				+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.COMBOBOX,
						"pph23Type")	
				+ "Tipe	PPH Ps.4 Ayat 2: "
				+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.COMBOBOX,
						"pph15Type")	
				+ "Keterangan	: "
				+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.TEXTFIELD,
							"description")
				+ "Persentase	: "
				+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.NUMBERFIELD,
							"rate")
				+ "Akun Pajak Penjualan	: "
				+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.LOOKUP,
							"salesTaxGlAccount")
				+ "Akun Pajak Pembelian	: "
				+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.LOOKUP,
							"purchaseTaxGlAccount")
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiTipePPh15(WebDriver driver, String filename) {
		log.info("Pajak.SaveIsi");
				
//				String w = AccurateModule.PAJAK.getXpath();
				String content = "Pajak.SaveIsi : " + "\r\n";

				content = content
						+ "Tipe	Pajak: "
						+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.COMBOBOX,
								"taxType")
						+ "Tipe	PPH Ps.15: "
						+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.COMBOBOX,
								"pphPs4Type")	
						+ "Keterangan	: "
						+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.TEXTFIELD,
									"description")
						+ "Persentase	: "
						+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.NUMBERFIELD,
									"rate")
						+ "Akun Pajak Penjualan	: "
						+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.LOOKUP,
									"salesTaxGlAccount")
						+ "Akun Pajak Pembelian	: "
						+ AccTool.getTextValue(driver, AccurateModule.PAJAK, ElementType.LOOKUP,
									"purchaseTaxGlAccount")
						+ "\r\n";

				AccTool.writeTextFile(filename, content);
			}
}
