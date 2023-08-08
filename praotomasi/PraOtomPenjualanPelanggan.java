package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pelanggan.PelangganParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PelangganTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPenjualanPelanggan extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPenjualanPelanggan.class);
	
	private String TARGET_FILE = "PraOtomasi Penjualan - Pelanggan.txt";
	
	@Test()
	public void BuatPelangganBaru()
	{
		AccTool.deleteTextFile(TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PELANGGAN);

		PelangganParam param = new PelangganParam();
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PELANGGAN);

		param.nama = "123";
		param.no = "Costumer 1";
		PelangganTool.isiForm(getWebDriver(), param);
		PelangganTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PELANGGAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PELANGGAN);
	}
	
	
	@Test(dependsOnMethods = { "BuatPelangganBaru" })
	public void editPelanggan()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PELANGGAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PELANGGAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PELANGGAN, "123");
		
		PelangganParam param = new PelangganParam();

		param.nama = "The Little Mermaid dwells in an underwater kingdom with her father "
				+ "(the sea king or mer-king), her grandmother, and her five sisters. ";
		param.telepon = "The Little Mermaid dwells in an underwater kingdom with her father"
				+ " (the sea king or mer-king), her grandmother, and her five sisters. ";
		param.faksimili = "The Little Mermaid dwells in an underwater kingdom with her father"
				+ " (the sea king or mer-king), her grandmother, and her five sisters. ";
		param.email = "email123456789@gmail.com";
		param.web = "The Little Mermaid dwells in an underwater kingdom with her father"
				+ " (the sea king or mer-king), her grandmother, and her five sisters. Her"
				+ " five sisters are each born one year apart. When a mermaid turns 15, she is"
				+ " permitted to swim to the surface to watch the world above";
		param.penagihanjalan = "The Little Mermaid dwells in an underwater kingdom with her"
				+ " father (the sea king or mer-king), her grandmother, and her five sisters."
				+ " Her five sisters are each born one year apart. When a mermaid turns 15, she is"
				+ " permitted to swim to the surface to watch the world above";
		param.penagihankota = "The Little Mermaid dwells in an underwater kingdom with her father "
				+ "(the sea king or mer-king), her grandmother, and her five sisters. ";
		param.penagihanpropinsi = "The Little Mermaid dwells in an underwater kingdom with her father"
				+ " (the sea king or mer-king), her grandmother, and her five sisters. ";
		param.penagihankodepos = "The Little Mermaid dwells in an underwater kingdom with her father "
				+ "(the sea king or mer-king), her grandmother, and her five sisters. ";
		param.penagihannegara = "The Little Mermaid dwells in an underwater kingdom with her father"
				+ " (the sea king or mer-king), her grandmother, and her five sisters. ";		
		PelangganTool.isiForm(getWebDriver(), param);
		PelangganTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		PelangganTool.klikTabKontak(getWebDriver());
		PelangganParam kontak = new PelangganParam();
		NavigationTool.tambahKontak(getWebDriver(), AccurateModule.PELANGGAN);
		kontak.sapaan = "Bapak";
		kontak.nama = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.jabatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.email = "email123456789@gmail.com";
		kontak.handphone = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.teleponbisnis = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. ";
		kontak.faksimili = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. ";
		kontak.teleponrumah = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. ";
		kontak.pinbbm = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.web = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid "
				+ "turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become"
				+ " old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid"
				+ " listens longingly to their various descriptions of the surface and of human beings.";
		PelangganTool.detailKontak(getWebDriver(), kontak);
		PelangganTool.saveDetailKontak(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-contact')]");
		
		PelangganTool.klikTabPenjualan(getWebDriver());
		PelangganParam penjualan = new PelangganParam();
		penjualan.defaultpenjual = "Brad Pitt";
		penjualan.defaultdiskon = "99999999999";
		penjualan.defaultdeskripsi = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or"
				+ " mer-king), her grandmother, and her five sisters. Her five sisters are each born one year apart. When "
				+ "a mermaid turns 15, she is permitted to swim to the surface to watch the world above, ";
		penjualan.cbkonsinyasi = true;
		PelangganTool.isiPenjualan(getWebDriver(), penjualan);
		PelangganTool.saveIsiPenjualan(getWebDriver(), TARGET_FILE);
		
		PelangganTool.klikTabPajak(getWebDriver());
		PelangganParam pajak = new PelangganParam();
		pajak.cbtotaltermasukpajak = true;
		pajak.npwp = "111111111111111";
		pajak.nppkp = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		//pajak.tipepajak = "Ekspor JKP";
		pajak.cbsamadenganpenagihan = true;
		PelangganTool.isiPajak(getWebDriver(), pajak);
		PelangganTool.saveIsiPajak(getWebDriver(), TARGET_FILE);
		
		PelangganTool.klikTabSaldo(getWebDriver());
		NavigationTool.tambahSaldo(getWebDriver(), AccurateModule.PELANGGAN);
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-open-balance')]//span[@class='toggle-slider round']");

		PelangganParam saldo = new PelangganParam();
		saldo.matauang = "Rupiah";
		saldo.nomorsaldo = "Test-OB1";
		saldo.syaratpembayaran = "c.o.d";
		saldo.tanggal = "03042016";
		saldo.jumlah = "999999999999";
		saldo.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid "
				+ "turns 15, she is permitted to swim to the surface to watch the world above";
		PelangganTool.isiSaldo(getWebDriver(), saldo);
//		PelangganTool.saveIsiSaldo(getWebDriver(), TARGET_FILE);
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-open-balance')]//*[text()='Jumlah']");

		PelangganTool.saveDetailSaldo(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-open-balance')]");
		
		PelangganTool.klikTabLainlain(getWebDriver());
		PelangganParam lainlain = new PelangganParam();
		lainlain.cbfakturbelumlunas = true;
		lainlain.nilaifakturbelumlunas = "999";
		lainlain.cbtotalpiutangpesanan = true;
		lainlain.nilaitotalpiutangpesanan = "999999999999";
		lainlain.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns"
				+ " 15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year.";
		PelangganTool.isiLainLain(getWebDriver(), lainlain);
		PelangganTool.saveIsiLainlain(getWebDriver(), TARGET_FILE);	
		WaitTool.delay(1000);

		WaitTool.delay(1000);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PELANGGAN);
		WaitTool.delay(1000);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PELANGGAN);
	}
			
	@Test(dependsOnMethods = { "editPelanggan" })
	public void hapusPelanggan() throws AWTException
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PELANGGAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PELANGGAN, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PELANGGAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PELANGGAN, "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), her grandmother, and her five");
		
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PELANGGAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PELANGGAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PELANGGAN);
	}
	
	@Test(dependsOnMethods = { "hapusPelanggan" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
