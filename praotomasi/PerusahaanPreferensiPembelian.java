package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PreferensiTool;

public class PerusahaanPreferensiPembelian extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PerusahaanPreferensiPembelian.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Pembelian.txt";

	@Test
	public void isiPreferensiPembelia() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.selisihbiaya = "Beban Operasional Lainnya";
		param.jurnalselisih = "Tanggal Tagihan Biaya";
		param.perbaruitagih = true;
		param.jgnperbaruitagih = false;
		param.perbaruitgltagihpertama = false;
		param.akunselisihbarang = "Diskon Penjualan IDR";
		PreferensiTool.isiPembelian(getWebDriver(), param);
		PreferensiTool.saveIsiPembelian(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	@Test(dependsOnMethods = "isiPreferensiPembelia")
	public void editPreferensiPembelia() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.selisihbiaya = "110504";
		param.jurnalselisih = "Tanggal Faktur Pembelian";
		param.perbaruitagih = false;
		param.jgnperbaruitagih = true;
		param.perbaruitgltagihpertama = false;
		param.akunselisihbarang = "720004";
		PreferensiTool.isiPembelian(getWebDriver(), param);
		PreferensiTool.saveIsiPembelian(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = "editPreferensiPembelia")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
