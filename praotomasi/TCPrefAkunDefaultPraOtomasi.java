package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoripelanggan.KategoriPelangganPraOtomasi;
import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PreferensiTool;

public class TCPrefAkunDefaultPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(KategoriPelangganPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Default Akun.txt";

	@Test
	public void isiAkunDefault() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);

		// tentukan nilai yang mau diinput ke masing-masing field
		PreferensiParam default1 = new PreferensiParam();
		default1.persediaan = "Persediaan";
		default1.penjualan = "400001";
		default1.returpenjualan = "Retur Penjualan";
		default1.diskonpenjualan = "Diskon Penjualan";
		default1.barangterkirim = "Persediaan Terkirim";
		default1.bebanpokokpenjualan = "Beban Pokok Penjualan";
		default1.returpembelian = "Persediaan";
		default1.beban = "Beban Operasional Lainnya";
		default1.barangbelumtertagih = "Hutang Pembelian Belum Ditagih";
		default1.ekuitassaldoawal = "Equitas Saldo Awal";
		default1.labaditahan = "Laba Ditahan";
		default1.pajakpenghasilan = "Laba/Rugi Terealisasi IDR";
		default1.akunpenyesuaian = "Equitas Saldo Awal";
		default1.biayapenjualan = "Equitas Saldo Awal";
		default1.selisihbiaya = "Diskon Penjualan IDR";
		default1.akundiskon = "Diskon Penjualan IDR";

		// memasukan input ke field
		PreferensiTool.isiAkunPerkiraan(getWebDriver(), default1);

		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);

		PreferensiTool.saveIsiAkunPerkiraan(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);

	}

}
