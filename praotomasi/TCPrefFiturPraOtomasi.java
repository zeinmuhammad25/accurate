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

public class TCPrefFiturPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCPrefFiturPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Fitur.txt";

	@Test
	public void nonaktifkanSemuaFitur() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);

		// tentukan nilai yang mau diinput ke masing-masing field
		PreferensiParam nonaktif = new PreferensiParam();
		nonaktif.cbcabang = false;
		nonaktif.cbmatauang = false;
		nonaktif.cbpajak = false;
		nonaktif.cbapproval = false;
		nonaktif.cbcatatasset = false;
		nonaktif.cbanggaran = false;
		nonaktif.cbtawarjual = false;
		nonaktif.cbreturjual = false;
		nonaktif.cbsalesman = false;
		nonaktif.cbsesuaiharga = false;
		nonaktif.fakturdimuka = false;
		nonaktif.cbsalesman = false;
		nonaktif.cbkonsinyasi = false;
		nonaktif.cbjasakirim = false;
		nonaktif.cbsyaratbayar = false;
		nonaktif.cbmintabarang = false;
		nonaktif.cbpesanbeli = false;
		nonaktif.cbdaftarhargapemasok = false;
		nonaktif.cbtagihandimuka = false;
		nonaktif.cbbiayabeli = false;
		nonaktif.cbmultigudang = false;
		nonaktif.cbmultibarang = false;
		nonaktif.cbnomorserial = false;
		nonaktif.cbprodsederhana = false;
		nonaktif.cbdepartemen = false;

		PreferensiParam aktif = new PreferensiParam();
		aktif.cbcabang = true;
		aktif.cbmatauang = true;
		aktif.cbpajak = true;
		aktif.cbapproval = true;
		aktif.cbcatatasset = true;
		aktif.cbanggaran = true;
		aktif.cbtawarjual = true;
		aktif.cbreturjual = true;
		aktif.cbsalesman = true;
		aktif.cbsesuaiharga = true;
		aktif.fakturdimuka = false;
		aktif.cbsalesman = true;
		aktif.cbkonsinyasi = true;
		aktif.cbjasakirim = true;
		aktif.cbsyaratbayar = true;
		aktif.cbmintabarang = true;
		aktif.cbpesanbeli = true;
		aktif.cbdaftarhargapemasok = true;
		aktif.cbtagihandimuka = true;
		aktif.cbbiayabeli = true;
		aktif.cbmultigudang = true;
		aktif.cbmultibarang = true;
		aktif.cbnomorserial = true;
		aktif.cbprodsederhana = true;
		aktif.cbdepartemen = true;

		// nonaktifkan semua fitur
		PreferensiTool.isiFitur(getWebDriver(), nonaktif);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiFitur(getWebDriver(), TARGET_FILE);

		// aktifkan semua fitur
		PreferensiTool.isiFitur(getWebDriver(), aktif);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiFitur(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);

	}

}
