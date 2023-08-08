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

public class TCPrefPersetujuanPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCPrefPersetujuanPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Persetujuan.txt";

	@Test
	public void isiPreferensiPersetujuan() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		
		PreferensiParam aktif = new PreferensiParam();
		aktif.cbpenawaranpenjualan= true;
		aktif.cbpesananpenjualan= true;
		aktif.cbpengirimanpesanan= true;
		aktif.cbfakturpenjualan= true;
		aktif.cbpenerimaanpelanggan= true;
		aktif.cbreturpenjualan= true;
		aktif.cbpermintaanpembelian= true;
		aktif.cbpesananpembelian= true;
		aktif.cbpenerimaanbarang= true;
		aktif.cbfakturpembelian= true;
		aktif.cbpembayaranpemasok= true;
		aktif.cbreturpembelian= true;
		aktif.cbpenyesuaianhargajual= true;
		aktif.cbhargapemasok= true;
		aktif.cbpenyesuaianpersediaan= true;
		aktif.cbpindahbarang= true;
		aktif.cbpekerjaanpesanan= true;
		aktif.cbpenyelesaianpesanan= true;
		aktif.cbpindahasset= true;
		aktif.cbpembayaran= true;
		aktif.cbpenerimaan= true;
		aktif.cbtransferbank= true;
		aktif.cbbayargaji= true;
		
		PreferensiParam nonaktif = new PreferensiParam();
		nonaktif.cbpenawaranpenjualan= false;
		nonaktif.cbpesananpenjualan= false;
		nonaktif.cbpengirimanpesanan= false;
		nonaktif.cbfakturpenjualan= false;
		nonaktif.cbpenerimaanpelanggan= false;
		nonaktif.cbreturpenjualan= false;
		nonaktif.cbpermintaanpembelian= false;
		nonaktif.cbpesananpembelian= false;
		nonaktif.cbpenerimaanbarang= false;
		nonaktif.cbfakturpembelian= false;
		nonaktif.cbpembayaranpemasok= false;
		nonaktif.cbreturpembelian= false;
		nonaktif.cbpenyesuaianhargajual= false;
		nonaktif.cbhargapemasok= false;
		nonaktif.cbpenyesuaianpersediaan= false;
		nonaktif.cbpindahbarang= false;
		nonaktif.cbpekerjaanpesanan= false;
		nonaktif.cbpenyelesaianpesanan= false;
		nonaktif.cbpindahasset= false;
		nonaktif.cbpembayaran= false;
		nonaktif.cbpenerimaan= false;
		nonaktif.cbtransferbank= false;
		
		PreferensiTool.isiPersetujuan(getWebDriver(), aktif);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiPersetujuan(getWebDriver(), TARGET_FILE);
		
		PreferensiTool.isiPersetujuan(getWebDriver(), nonaktif);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiTool.saveIsiPersetujuan(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		
	}

}
