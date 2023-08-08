package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pengguna.PenggunaParam;

public class PenggunaTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PenggunaTool.class);

	public static void isiPengguna(WebDriver driver, PenggunaParam param) {
		log.info("pengguna.IsiPengguna");

		String w = AccurateModule.PENGGUNA.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//a[text()='Pengguna']");

		if (param.emailorhp != null)
			AccTool.textField(driver, tab, "@name='account'", param.emailorhp);

		if (param.jenisoperator != null)
			AccTool.radioButton(driver, tab, "@value='user'", param.jenisoperator);
		
		if (param.jenisadministrator != null)
			AccTool.radioButton(driver, tab, "@value='admin'", param.jenisadministrator);

		if (param.aksesgrup != null)
			AccTool.lookup(driver, tab, "@name='userRoleAccessList'", param.aksesgrup);

		if (param.aksescabang != null)
			AccTool.lookup(driver, tab, "@name='userBranchList'", param.aksescabang);

	}

	public static void saveIsiPengguna(WebDriver driver, String filename) {
		String w = AccurateModule.PENGGUNA.getXpath();
		String tab = "";
//		String content = "Pengguna.SaveIsiPengguna : " + "\r\n";
		
		AccTool.click(driver, w + "//a[text()='Pengguna']");
		tab = "//*[contains(@id,'tab-general')]";
		
		String xpath = "//label[text()='Akses Grup']";
		boolean exists = false;
		List<WebElement> listAksesGrupCabang= driver.findElements(By.xpath(xpath));
		log.info("List AksesGrupCabang: " + listAksesGrupCabang.size());
		exists = listAksesGrupCabang.size() > 0;
		
		if(exists){
			String content = "Pengguna.SaveIsiPengguna : " + "\r\n";
			
			content = content
					+ "Nama : "
					+ AccTool.getTextValue(driver,
							ElementType.SUMMARY, "text: formData.name", tab)
					+ "Email / No HP : "
					+ AccTool.getTextValue(driver,
							ElementType.SUMMARY, "text: formData.email", tab)
					+ "Jenis Akses : "
					+ AccTool.getTextValue(driver,
							ElementType.SUMMARY, "text: formData.levelTypeDescription", tab)
					+ "Akses Grup : "
					+ AccTool.getTextValue(driver, AccurateModule.PENGGUNA,
							ElementType.LOOKUP, "userRoleAccessList", tab)
					+ "Akses Cabang : "
					+ AccTool.getTextValue(driver, AccurateModule.PENGGUNA,
							ElementType.LOOKUP, "userBranchList", tab)
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}else{
			String content = "Pengguna.SaveIsiPengguna : " + "\r\n";
			content = content
					+ "Nama : "
					+ AccTool.getTextValue(driver,
							ElementType.SUMMARY, "text: formData.name", tab)
					+ "Email / No HP : "
					+ AccTool.getTextValue(driver,
							ElementType.SUMMARY, "text: formData.email", tab)
					+ "Jenis Akses : "
					+ AccTool.getTextValue(driver,
							ElementType.SUMMARY, "text: formData.levelTypeDescription", tab)
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}

	}
}
