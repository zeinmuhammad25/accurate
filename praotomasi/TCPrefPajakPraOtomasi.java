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

public class TCPrefPajakPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCPrefPajakPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Pajak.txt";

	@Test
	public void isiPreferensiPajak() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		
		PreferensiParam awal = new PreferensiParam();
		awal.namapersh = "coba nama";
		awal.tanggalpkp ="01012012";
		awal.nopengukuhan="700800";
		awal.tipeusaha="tipe saya";
		awal.npwp="123123";
		awal.klu="7654321";
		awal.pajakbarangmewah = false;
		awal.penghitunganpajak = false;
		
		PreferensiParam akhir = new PreferensiParam();
		awal.namapersh = "PT DIMAS";
		akhir.tanggalpkp ="01112015";
		akhir.nopengukuhan="700800999";
		akhir.tipeusaha="tipe gua banget";
		akhir.npwp="12312399";
		akhir.klu="7654321000";
		akhir.pajakbarangmewah = true;
		akhir.penghitunganpajak = true;
		akhir.jalan = "jalan saya";
		akhir.kota="kota saya";
		akhir.kodepos="15112";
		akhir.propinsi="propinsi saya";
		akhir.negara="negara saya";
		
		PreferensiTool.isiPajak(getWebDriver(), awal);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiPajak(getWebDriver(), TARGET_FILE);
		
		PreferensiTool.isiPajak(getWebDriver(), akhir);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiPajak(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);

	}

}
