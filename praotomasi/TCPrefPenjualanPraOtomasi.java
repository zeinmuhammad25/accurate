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

public class TCPrefPenjualanPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCPrefPenjualanPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Penjualan.txt";

	@Test
	public void isiPreferensiPenjualan() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		
		PreferensiParam awal = new PreferensiParam();
		awal.cbrenewcostretur = true;
		
		PreferensiParam akhir = new PreferensiParam();
		akhir.cbrenewcostretur = false;
		
		PreferensiTool.isiPenjualan(getWebDriver(), awal);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiPenjualan(getWebDriver(), TARGET_FILE);
		
		PreferensiTool.isiPenjualan(getWebDriver(), akhir);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiPenjualan(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);

	}

}
