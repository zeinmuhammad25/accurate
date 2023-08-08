package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.general.GeneralParam;
import com.cpssoft.web.test.accurate.kategoripelanggan.KategoriPelangganParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriPelangganTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.UserTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomDaftarAkun extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(PraOtomDaftarAkun.class);
	
	private String TARGET_FILE = "PraOtomasi Daftar Akun - Daftar.txt";

	@Test
	public void daftarAkun() 
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		UserTool.klikDaftarSekarang(getWebDriver());
		// harus selalu ganti param nama, email dan telephon
		GeneralParam user = new GeneralParam();
		user.nama = "Akun 17";
		user.email = "akun17@gmail.com";
		user.telepon = "0814103700017";
		user.password = "Akun123@";
		
		UserTool.isiDaftar(getWebDriver(), user);
		UserTool.klikSNK(getWebDriver());
		UserTool.pindahHalamanDaftar(getWebDriver());
		UserTool.klikDaftar(getWebDriver());
		UserTool.saveBerhasilDaftar(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = "daftarAkun")
	public void keluarDatabase() {
		GeneralParam param = new GeneralParam();
		param.menu = "Log Out";
		UserTool.menuUser(getWebDriver(), param);
	}
	
	@Test(dependsOnMethods = { "keluarDatabase" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
