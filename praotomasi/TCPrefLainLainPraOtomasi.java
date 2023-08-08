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

public class TCPrefLainLainPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCPrefLainLainPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Lain Lain.txt";

	@Test
	public void isiLainLain() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);

		PreferensiParam awal = new PreferensiParam();
		awal.rentangumurhutang = "10";
		awal.umurjatuhtempo = true;
		awal.umurtanggalfaktur = false;
		awal.rentangumurpersediaan = "20";
		awal.komisipenjualan = "Faktur sudah lunas";

		PreferensiParam akhir = new PreferensiParam();
		akhir.rentangumurhutang = "30";
		akhir.umurjatuhtempo = false;
		akhir.umurtanggalfaktur = true;
		akhir.rentangumurpersediaan = "30";
		akhir.komisipenjualan = "Faktur sudah lunas";

		PreferensiTool.isiLainLain(getWebDriver(), awal);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiLainLain(getWebDriver(), TARGET_FILE);

		PreferensiTool.isiLainLain(getWebDriver(), akhir);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiLainLain(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);

	}

}
