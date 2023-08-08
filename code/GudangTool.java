package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.gudang.GudangParam;

public class GudangTool extends AbstractAccurateTestCase {
	
	static Logger log = LogManager.getLogger(GudangParam.class);
	
	public static void isiForm(WebDriver driver, GudangParam param)
	{
		log.info("Gudang.IsiForm");
		
		String w = AccurateModule.GUDANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";
		String tab2 = w + "//*[contains(@id,'tab-address')]";
		
		if(param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", 
		param.nama);
		if(param.deskripsi != null)
			AccTool.textarea(driver, tab, "@name='description'", 
		param.deskripsi);
		if(param.penanggungjawab != null)
			AccTool.textField(driver, tab, "@name='pic'", 
		param.penanggungjawab);
		if (param.nonaktif != null)
			AccTool.checkbox(driver, tab, "@name='suspended'", param.nonaktif);
		if (param.rusak != null)
			AccTool.checkbox(driver, tab, "@name='scrapWarehouse'", param.rusak);
		
		if(param.jalan != null) {
			AccTool.click(driver, "//a[contains(@href,'tab-address')]");
			AccTool.textarea(driver, tab2, "@name='street'", 
		param.jalan);
		}
		if(param.kota != null) {
			AccTool.click(driver, "//a[contains(@href,'tab-address')]");
			AccTool.textField(driver, tab2, "@name='city'", 
		param.kota);
		}
		if(param.kodepos != null) {
			AccTool.click(driver, "//a[contains(@href,'tab-address')]");
			AccTool.textField(driver, tab2, "@name='zipCode'", 
		param.kodepos);
		}
		if(param.propinsi != null) {
			AccTool.click(driver, "//a[contains(@href,'tab-address')]");
			AccTool.textField(driver, tab2, "@name='province'", 
		param.propinsi);
		}
		if(param.negara != null) {
			AccTool.click(driver, "//a[contains(@href,'tab-address')]");
			AccTool.textField(driver, tab2, "@name='country'", 
		param.negara);
		}		
	}
	
	public static void SaveData(WebDriver driver, String fileName)
	{
		log.info("Save Isi: " + fileName);

		String content = "Gudang.SaveIsi : " + "\r\n";
		String tab ="//*[contains(@id,'tab-general')]";

		content = content
				+ "Nama : " 
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.TEXTFIELD, "name", tab)
				+ "Deskripsi " 
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.TEXTFIELD, "description", tab)
				+ "Penanggung Jawab : "
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.TEXTFIELD, "parent", tab) 
				+ "Alamat : "
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.TEXTFIELD, "address", tab) + "\r\n";
		AccTool.writeTextFile(fileName, content);
	}
	
	public static void SaveData2(WebDriver driver, String fileName)
	{
		log.info("Save Isi: " + fileName);

		String content = "Gudang.SaveIsi : " + "\r\n";
		String tab ="//*[contains(@id,'tab-general')]";

		content = content
				+ "Nama : " 
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.TEXTFIELD, "name", tab)
				+ "Deskripsi " 
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.TEXTFIELD, "description", tab)
				+ "Penanggung Jawab : "
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.TEXTFIELD, "parent", tab) 
				+ "Alamat : "
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.TEXTFIELD, "address", tab)
				+ "Gudang Barang Rusak : "
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.CHECKBOX, "scrapWarehouse", tab)
				+ "Non Aktif : "
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.CHECKBOX, "suspended", tab)+ "\r\n";
		AccTool.writeTextFile(fileName, content);
	}
	
	public static void isiDaftarPengguna(WebDriver driver, GudangParam param) {
		log.info("Gudang.IsiDaftarPengguna");

		String w = AccurateModule.GUDANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, w + "//a[text()='Pengguna']");

		if (param.semua != null)
			AccTool.checkbox(driver, tab, "@name='usedAllUser'", param.semua);
		if (param.grupataucabang != null)
			AccTool.lookup(driver, tab, "@name='useUserRoleAccessList'", param.grupataucabang);
		if (param.pengguna != null)
			AccTool.lookup(driver, tab, "@name='useUserAccessList'", param.pengguna);
	}
	
	public static void isiDaftarPenggunaTanpaClear(WebDriver driver, GudangParam param) {
		log.info("Gudang.IsiDaftarPengguna");

		String w = AccurateModule.GUDANG.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, w + "//a[text()='Pengguna']");

		if (param.semua != null)
			AccTool.checkbox(driver, tab, "@name='usedAllUser'", param.semua);
		if (param.grupataucabang != null)
			AccTool.lookup(driver, tab, "@name='useUserRoleAccessList'", param.grupataucabang);
		if (param.pengguna != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='useUserAccessList'", param.pengguna);
	}

	public static void saveDaftarPengguna(WebDriver driver, String filename) {
		String w = AccurateModule.GUDANG.getXpath();
		String tab = "";
		String content = "Gudang.SaveDaftarPengguna : " + "\r\n";

		AccTool.click(driver, w + "//a[text()='Pengguna']");
		tab = "//*[contains(@id,'tab-others')]";
		content = content + "Akses Pengguna" + "\r\n"
				+ "Semua Pengguna : "
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.CHECKBOX, "usedAllUser", tab)
				+ "User : "
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.LOOKUP, "useUserAccessList", tab)
				+ "Group/Cabang : "
				+ AccTool.getTextValue(driver, AccurateModule.GUDANG, ElementType.LOOKUP, "useUserRoleAccessList", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void klikDaftarPengguna(WebDriver driver) {
		AccTool.click(driver, AccurateModule.GUDANG.getXpath() + "//a[text()='Pengguna']");
	}
}
