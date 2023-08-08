package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;





import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
//import com.cpssoft.web.test.accurate.kategoripelanggan.KategoriPelangganParam;
//import com.cpssoft.web.test.accurate.matauang.Isi;
//import com.cpssoft.web.test.accurate.matauang.IsiDefaultAkun;
import com.cpssoft.web.test.accurate.matauang.MataUangParam;

public class MataUangTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(MataUangTool.class);
	
	public static void isi(WebDriver driver, MataUangParam param) {
		log.info("matauang.Isi");
		
		String w = AccurateModule.MATA_UANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";		
		
		AccTool.click(driver, w + "//a[text()='Mata Uang']");
		
		AccTool.lookup(driver, tab, "@name='base'", param.nama);
	}
	
	public static void isiDefaultAkun(WebDriver driver, MataUangParam param) {
		log.info("matauang.IsiDefaultAkun");
		
		String w = AccurateModule.MATA_UANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-defaultaccount')]";
		
		AccTool.click(driver, w + "//a[text()='Default Akun']");
		
		if(param.hutang != null)
			AccTool.lookup(driver, tab, "@name='defaultApAccount'", 
		param.hutang);
		
		if(param.piutang != null)
			AccTool.lookup(driver, tab, "@name='defaultArAccount'", 
		param.piutang);
		
		if(param.uangmukapembelian != null)
			AccTool.lookup(driver, tab, "@name='defaultAdvPurchaseAccount'", 
		param.uangmukapembelian);
		
		if(param.uangmukapenjualan != null)
			AccTool.lookup(driver, tab, "@name='defaultAdvSalesAccount'", 
		param.uangmukapenjualan);
		
		if(param.diskonpenjualan != null)
			AccTool.lookup(driver, tab, "@name='defaultSalesDiscAccount'", 
		param.diskonpenjualan);
		
		if(param.labarugiterealisir != null)
			AccTool.lookup(driver, tab, "@name='defaultRealizeGlAccount'", 
		param.labarugiterealisir);
		
		if(param.labarugibelumterealisir != null)
			AccTool.lookup(driver, tab, "@name='defaultUnrealizeGlAccount'", 
		param.labarugibelumterealisir);	
		
	}
	
	public static void saveIsiMataUang(WebDriver driver, String filename) {
		log.info("matauang.SaveIsi");
		
		String w = AccurateModule.MATA_UANG.getXpath();
		String tab = "";		
		String content = "matauang.SaveIsi : " + "\r\n";

		AccTool.click(driver, w + "//a[text()='Mata Uang']");
		tab = "//*[contains(@id,'tab-general')]";
		content = content
				+ "Mata Uang"
				+ "\r\n"
				+ "Negara / Nama	: "
				+ AccTool.getTextValue(driver, AccurateModule.MATA_UANG, ElementType.LOOKUP,
						"base", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiDefaultAkun(WebDriver driver, String filename) {
		log.info("matauang.SaveIsi");
		
		String w = AccurateModule.MATA_UANG.getXpath();
		String tab = "";		
		String content = "matauang.SaveIsi : " + "\r\n";
		
			AccTool.click(driver, w + "//a[text()='Default Akun']");
			tab = "//div[contains(@id,'tab-defaultaccount')]";
			content = content
					+ "Default Akun"
					+ "\r\n"
					+ "Akun Hutang	: "
					+ AccTool.getTextValue(driver, AccurateModule.MATA_UANG, ElementType.LOOKUP,
							"defaultApAccount", tab)
					+ "Akun Piutang	: "
					+ AccTool.getTextValue(driver, AccurateModule.MATA_UANG, ElementType.LOOKUP,
							"defaultArAccount", tab)
					+ "Akun Uang Muka Pembelian	: "
					+ AccTool.getTextValue(driver, AccurateModule.MATA_UANG, ElementType.LOOKUP,
							"defaultAdvPurchaseAccount", tab)
					+ "Akun Uang Muka Penjualan	: "
					+ AccTool.getTextValue(driver, AccurateModule.MATA_UANG, ElementType.LOOKUP,
							"defaultAdvSalesAccount", tab)
					+ "Diskon Penjualan	: "
					+ AccTool.getTextValue(driver, AccurateModule.MATA_UANG, ElementType.LOOKUP,
							"defaultSalesDiscAccount", tab)
					+ "Akun Laba/Rugi Terealisir	: "
					+ AccTool.getTextValue(driver, AccurateModule.MATA_UANG, ElementType.LOOKUP,
							"defauldivealizeGlAccount", tab)
					+ "Akun Laba/Rugi Belum Terealisir	: "
					+ AccTool.getTextValue(driver, AccurateModule.MATA_UANG, ElementType.LOOKUP,
							"defaultUnrealizeGlAccount", tab)
					+ "\r\n";
		AccTool.writeTextFile(filename, content);

	}

}
