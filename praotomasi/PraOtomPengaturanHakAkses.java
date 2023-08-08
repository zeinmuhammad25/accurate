package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.aksesgrup.AksesGrupParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AksesGrupTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPengaturanHakAkses extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomPengaturanHakAkses .class);

	private String TARGET_FILE = "PraOtomasi Pengaturan - HakAkses.txt";
	
	@Test
	public void buatHak()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.AKSES_GRUP);
		AksesGrupParam param = new AksesGrupParam();
		param.nama = "hak1";
		param.pengguna = "husni@cpssoft.com";
		AksesGrupTool.isiForm(getWebDriver(), param);
		
		AksesGrupParam param2 = new AksesGrupParam();
		param2.tab = "Perusahaan";
		param2.cbaktif = true;
		param2.cbbuat = true;
		param2.cbubah = true;
		param2.cbhapus = true;
		param2.cblihat = true;
		AksesGrupTool.isiPerusahaan(getWebDriver(), param2);
		AksesGrupTool.saveIsiPerusahaan(getWebDriver(), param2);
		
		AksesGrupParam param3 = new AksesGrupParam();
		param3.tab = "Perusahaan";
		param3.cbaktif = true;
		param3.cbbuat = true;
		param3.cbubah = true;
		param3.cbhapus = true;
		param3.cblihat = true;
		AksesGrupTool.isiBukuBesar(getWebDriver(), param3);
		AksesGrupTool.saveIsiBukuBesar(getWebDriver(), param3);
		
		AksesGrupParam param4 = new AksesGrupParam();
		param4.tab = "Kas Bank";
		param4.cbaktif = true;
		param4.cbbuat = true;
		param4.cbubah = true;
		param4.cbhapus = true;
		param4.cblihat = true;
		AksesGrupTool.isiKasBank(getWebDriver(), param4);
		AksesGrupTool.saveIsiKasBank(getWebDriver(), param4);
		
		AksesGrupParam param5 = new AksesGrupParam();
		param5.tab = "Pembelian";
		param5.cbaktif = true;
		param5.cbbuat = true;
		param5.cbubah = true;
		param5.cbhapus = true;
		param5.cblihat = true;
		AksesGrupTool.isiPembelian(getWebDriver(), param5);
		AksesGrupTool.saveIsiPembelian(getWebDriver(), param5);
		
		AksesGrupParam param6 = new AksesGrupParam();
		param6.tab = "Persediaan";
		param6.cbaktif = true;
		param6.cbbuat = true;
		param6.cbubah = true;
		param6.cbhapus = true;
		param6.cblihat = true;
		AksesGrupTool.isiPersediaan(getWebDriver(), param6);
		AksesGrupTool.saveIsiPersediaan(getWebDriver(), param6);
		
		AksesGrupParam param7 = new AksesGrupParam();
		param7.tab = "Aset Tetap";
		param7.cbaktif = true;
		param7.cbbuat = true;
		param7.cbubah = true;
		param7.cbhapus = true;
		param7.cblihat = true;
		AksesGrupTool.isiAsetTetap(getWebDriver(), param7);
		AksesGrupTool.saveIsiAsetTetap(getWebDriver(), param7);
		
		AksesGrupParam param8 = new AksesGrupParam();
		param8.tab = "Target";
		param8.cbaktif = true;
		param8.cbbuat = true;
		param8.cbubah = true;
		param8.cbhapus = true;
		param8.cblihat = true;
		AksesGrupTool.isiTarget(getWebDriver(), param8);
		AksesGrupTool.saveIsiTarget(getWebDriver(), param8);
		
		AksesGrupParam param9 = new AksesGrupParam();
		param9.tab = "Kalender";
		param9.cbaktif = true;
		param9.cbbuat = true;
		param9.cbubah = true;
		param9.cbhapus = true;
		param9.cblihat = true;
		AksesGrupTool.isiKalender(getWebDriver(), param9);
		AksesGrupTool.saveIsiKalender(getWebDriver(), param9);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.AKSES_GRUP);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.AKSES_GRUP);
	}
	
	@Test(dependsOnMethods = "buatHak")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
