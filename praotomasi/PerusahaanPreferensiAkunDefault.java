package com.cpssoft.web.test.accurate.praotomasi;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;;
import com.cpssoft.web.test.accurate.tool.PreferensiTool;

public class PerusahaanPreferensiAkunDefault extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PerusahaanPreferensiAkunDefault .class);

	private String TARGET_FILE = "Perusahaan - Preferensi - AkunDefault.txt";
	
	@Test
	public void akunDefault()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.tab = "Isi Akun Perkiraan";
		param.persediaan = "Persediaan";
		param.penjualan = "Penjualan";
		param.returpenjualan = "Retur Penjualan";
		param.diskonpenjualan = "Diskon Penjualan";
		param.barangterkirim = "Persediaan Terkirim";
		param.bebanpokokpenjualan = "Beban Pokok Penjualan";
		param.returpembelian = "Persediaan";
		param.beban = "Beban Operasional Lainnya";
		param.barangbelumtertagih = "Hutang Pembelian Belum Ditagih";
		param.ekuitassaldoawal = "Equitas Saldo Awal";
		param.labaditahan = "Laba Ditahan";
		param.pajakpenghasilan = "Laba/Rugi Terealisasi IDR";
		param.akunpenyesuaian = "Equitas Saldo Awal";
		param.biaya = "Equitas Saldo Awal";
		param.selisihbiaya = "Diskon Penjualan IDR";
		param.akundiskon = "Diskon Penjualan IDR";
		PreferensiTool.isiAkunPerkiraan(getWebDriver(), param);
		PreferensiTool.saveIsiAkunPerkiraan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
//		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PREFERENSI);
	}
	
	@Test(dependsOnMethods = "akunDefault")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
