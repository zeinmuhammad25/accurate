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

public class TCPrefPembelianPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCPrefPembelianPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Pembelian.txt";

	@Test
	public void isiPreferensiPembelian() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam awal = new PreferensiParam();
		awal.selisihbiaya="Biaya Operasional Lainnya";
		awal.jurnalselisih="Tanggal Tagihan Biaya";
		awal.perbaruitagih=true;
		awal.jgnperbaruitagih=false;
		awal.perbaruitgltagihpertama=false;
		awal.akunselisihbarang="Diskon Penjualan IDR";
		
		PreferensiParam akhir = new PreferensiParam();
		akhir.selisihbiaya="110504";
		akhir.jurnalselisih="Tanggal Faktur Pembelian";
		akhir.perbaruitagih=false;
		akhir.jgnperbaruitagih=true;
		akhir.perbaruitgltagihpertama=false;
		akhir.akunselisihbarang="720401";
		
		PreferensiTool.isiPembelian(getWebDriver(), awal);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiPembelian(getWebDriver(), TARGET_FILE);
		
		PreferensiTool.isiPembelian(getWebDriver(), akhir);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiPembelian(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
			

	}

}
