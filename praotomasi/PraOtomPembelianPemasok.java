package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pemasok.PemasokParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PemasokTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPembelianPemasok extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPembelianPemasok.class);
	
	private String TARGET_FILE = "PraOtomasi Pembelian - Pemasok.txt";
	
	@Test
	public void BuatPemasok()
	{
		AccTool.deleteTextFile(TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMASOK);

		PemasokParam param = new PemasokParam();
		
		param.kategori = "Umum";
		param.nama = "Pemasok0123456789Pemasok0123456789Pemasok0123456789Pemasok0123456789Pemasok01"
				+ "23456789Pemasok0123456789Pemasok0123456789Pemaso";
		param.email = "email123456789@gmail.com";
		param.telepon = "Telepon0123456789Telepon0123456789Telepon012345678";
		param.teleponseluler = "Telepon0123456789Telepon0123456789Telepon012345678";
		param.faksimili = "Faksimili0123456789Faksimili0123456789Faksimili012";	
		param.web = "Web0123456789Web0123456789Web0123456789Web0123456789Web01234";
		param.kontakutama = "KontakUtama0123456789KontakUtama0123456789KontakUt";
		param.matauang = "IDR";
		param.penagihanjalan = "AlamatPenagihan0123456789AlamatPenagihan0123456789AlamatPenagihan012"
				+ "3456789AlamatPenagihan0123456789AlamatPenagihan0123456789AlamatPenagihan012345678"
				+ "9AlamatPenagihan0123456789AlamatPenagihan0123456789";
		param.penagihankota = "Kota123456789Kota123456789Kota123456789Kota1234567";
		param.penagihanpropinsi = "Propinsi0123456789Propinsi0123456789Propinsi012345";
		param.penagihankodepos = "KodePos012";
		param.penagihannegara = "Negara0123456789Negara0123456789Negara0123456789Ne";
		param.cbpenjualjasa = false;
		PemasokTool.isiFormUmum(getWebDriver(), param);
		PemasokTool.saveIsiInformasiUmum(getWebDriver(), TARGET_FILE);
		
		PemasokTool.klikTabKontak(getWebDriver());
		PemasokParam kontak = new PemasokParam();
		NavigationTool.tambahKontak(getWebDriver(), AccurateModule.PEMASOK);
		kontak.sapaan = "Bapak";
		kontak.nama = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.jabatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.email = "email121232473847@gmail.com";
		kontak.teleponseluler = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.telepon = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. ";
		kontak.faksimili = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. ";
		kontak.kontakutama = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
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
		PemasokTool.isiDetailKontak(getWebDriver(), kontak);
		PemasokTool.saveDetailKontak(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-contact')]");
		
		PemasokTool.klikTabPajak(getWebDriver());
		PemasokParam pajak = new PemasokParam();
		pajak.cbtotaltermasukpajak = true;
		pajak.npwp = "222222222222222";
		pajak.nppkp = "NPPKP0123456789NPPKP0123456789";
		//pajak.tipepajak = "Impor BKP";
		pajak.pajak1 = "Pajak Pertambahan Nilai";
		pajak.pajak2 = "PPnBM";
		pajak.cbsamadenganpenagihan = true;
		PemasokTool.isiDetailPajak(getWebDriver(), pajak);
		PemasokTool.saveIsiPajak(getWebDriver(), TARGET_FILE);
	

		PemasokTool.klikTabSaldo(getWebDriver());
		PemasokParam saldo = new PemasokParam();
		NavigationTool.tambahSaldo(getWebDriver(), AccurateModule.PEMASOK);
		saldo.matauangsaldo = "IDR";
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-open-balance')]//*[@class = 'toggle-switch round']");
		saldo.nomor = "Test-OB1";
		saldo.syaratpembayaran = "c.o.d";
		saldo.tanggal = "01012014";
		saldo.jumlah = "999999999999";
		saldo.keterangan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid "
				+ "turns 15, she is permitted to swim to the su";
		PemasokTool.isiDetailSaldo(getWebDriver(), saldo);
		PemasokTool.saveDetailSaldo(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-open-balance')]");

		PemasokTool.klikTabLainlain(getWebDriver());
		PemasokParam lainlain = new PemasokParam();
		lainlain.catatan = "Catatan0123456789Catatan0123456789Catatan0123456789Catatan0123456789Catatan012345"
				+ "6789Catatan0123456789Catatan0123456789Catatan0123456789Catatan0123456789Catatan0123456789Ca"
				+ "tatan0123456789Catatan0123456789Catatan0123456789Catatan0123456789Catatan0123456789Catatan0"
				+ "123456789Catatan0123456789Catatan0123456789Catatan0123456789Catatan0123456789Catatan0123456"
				+ "789Catatan0123456789Catatan0123456789Catatan0123456789Catatan0123456789Catatan0123456789Cat"
				+ "atan0123456789Catatan0123456789Catatan0123456789Catatan";
		PemasokTool.IsiDetailLainLain(getWebDriver(), lainlain);
		PemasokTool.saveIsiLainLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMASOK);
	
	}
	
	@Test(dependsOnMethods = "BuatPemasok")
	public void hapusPemasok() throws AWTException
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMASOK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PEMASOK, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PEMASOK);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PEMASOK, "Pemasok0123456789Pemasok0123456789Pemasok0123456789Pemasok0123456789Pemasok0123456789Pemasok0123456789Pemasok0123456789Pemaso");
		
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PEMASOK);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PEMASOK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMASOK);
	}
	
	@Test(dependsOnMethods = "hapusPemasok")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
