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

public class PerusahaanPreferensiPersetujuan extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PerusahaanPreferensiPersetujuan.class);

	private String TARGET_FILE = "Perusahaan - Preferensi - Persetujuan.txt";

	@Test
	public void isiPreferensiPersetujuan() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.cbpenawaranpenjualan= true;
		param.cbpesananpenjualan= true;
		param.cbpengirimanpesanan= true;
		param.cbfakturpenjualan= true;
		param.cbpenerimaanpelanggan= true;
		param.cbreturpenjualan= true;
		param.cbpermintaanpembelian= true;
		param.cbpesananpembelian= true;
		param.cbpenerimaanbarang= true;
		param.cbfakturpembelian= true;
		param.cbpembayaranpemasok= true;
		param.cbreturpembelian= true;
		param.cbpenyesuaianhargajual= true;
		param.cbhargapemasok= true;
		param.cbpenyesuaianpersediaan= true;
		param.cbpindahbarang= true;
		param.cbpekerjaanpesanan= true;
		param.cbpenyelesaianpesanan= true;
		param.cbpindahasset= true;
		param.cbpembayaran= true;
		param.cbpenerimaan= true;
		param.cbtransferbank= true;
		param.cbbayargaji= true;
		PreferensiTool.isiPersetujuan(getWebDriver(), param);
		PreferensiTool.saveIsiPersetujuan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	@Test(dependsOnMethods = "isiPreferensiPersetujuan")
	public void editPreferensiPersetujuan() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.cbpenawaranpenjualan= false;
		param.cbpesananpenjualan= false;
		param.cbpengirimanpesanan= false;
		param.cbfakturpenjualan= false;
		param.cbpenerimaanpelanggan= false;
		param.cbreturpenjualan= false;
		param.cbpermintaanpembelian= false;
		param.cbpesananpembelian= false;
		param.cbpenerimaanbarang= false;
		param.cbfakturpembelian= false;
		param.cbpembayaranpemasok= false;
		param.cbreturpembelian= false;
		param.cbpenyesuaianhargajual= false;
		param.cbhargapemasok= false;
		param.cbpenyesuaianpersediaan= false;
		param.cbpindahbarang= false;
		param.cbpekerjaanpesanan= false;
		param.cbpenyelesaianpesanan= false;
		param.cbpindahasset= false;
		param.cbpembayaran= false;
		param.cbpenerimaan= false;
		param.cbtransferbank= false;
		param.cbbayargaji= false;
		PreferensiTool.isiPersetujuan(getWebDriver(), param);
		PreferensiTool.saveIsiPersetujuan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = "editPreferensiPersetujuan")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
