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

public class TCPrefInformasiPerusahaanPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(TCPrefInformasiPerusahaanPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Informasi Perusahaan.txt";

	@Test
	public void isiInformasiPerusahaan() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);

		PreferensiParam awal = new PreferensiParam();
		awal.namapersh = "coba";
		awal.telepon = "021123456";
		awal.fax = "031778899";
		awal.email = "test@cpssoft.com";
		awal.jalan = "jalanjalanwae";
		awal.kota = "kota sopo";
		awal.kodepos = "54321";
		awal.propinsi = "propinsi mane";
		awal.negara = "indocafe";

		PreferensiParam akhir = new PreferensiParam();
		akhir.namapersh = "PT Dimas";
		akhir.telepon = "08989199915";
		akhir.fax = "08989199915";
		akhir.email = "dimas@cpssoft.com";
		akhir.jalan = "Pondok Arum Blok B11 no 20";
		akhir.kota = "Tangerang";
		akhir.kodepos = "15112";
		akhir.propinsi = "Banten";
		akhir.negara = "Indonesia";

		PreferensiTool.isiInfoPerusahaan(getWebDriver(), awal);

		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);

		PreferensiTool.saveIsiPerusahaan(getWebDriver(), TARGET_FILE);

		// aktifkan semua fitur
		PreferensiTool.isiInfoPerusahaan(getWebDriver(), akhir);

		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);

		PreferensiTool.saveIsiPerusahaan(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);

	}

}
