package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kontak.KontakParam;
import com.cpssoft.web.test.accurate.pelanggan.PelangganParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KontakTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PelangganTool;

public class TCKontakPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCKontakPraOtomasi.class);

	private String TARGET_FILE = "Perusahaan - Kontak.txt";

	@Test
	public void buatPelangganBaru() {

		PelangganParam pelanggan = new PelangganParam();
		pelanggan.nama = "CV Maju Terus Pantang Mundur";
		pelanggan.email = "email@maju-terus.com";
		pelanggan.teleponbisnis = "0215410646";
		pelanggan.handphone = "0811892437";
		pelanggan.faksimili = "0215410647";
		pelanggan.web = "http://www.maju-terus.com";
		pelanggan.penagihanjalan = "Alamat Maju Terus";
		pelanggan.penagihankota = "jakarta";
		pelanggan.penagihankodepos = "15112";
		pelanggan.penagihanpropinsi = "DKI Jakarta";
		pelanggan.penagihannegara = "Indonesia";

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PELANGGAN);
		PelangganTool.isiForm(getWebDriver(), pelanggan);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PELANGGAN);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PELANGGAN);
	}

	@Test(dependsOnMethods = "buatPelangganBaru")
	public void editKontak() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		KontakParam kontak1 = new KontakParam();
		kontak1.sapaan = "Bapak";
		kontak1.nama = "Nama Lengkap 0123456789 Nama Lengkap 0123456789 Nama Lengkap 0123456789 Nama Lengkap 0123456789 Nama Lengkap 0123456789 Nama ";
		kontak1.jabatan = "Jabatan 0123456789 Jabatan 0123456789 Jabatan 0123456789 Jabatan 0123456789 Jabatan 0123456789 Jabatan 0123456789 Jabatan 012";
		kontak1.email = "email kontak 0123456789 email kontak 0123456789 email kontak 0123456789 email kontak 0123456789 email kontak 0123456789 email";
		kontak1.handphone = "HP 0123456789 HP 0123456789 HP 0123456789 HP 0123456789 HP 0123456789 HP 0123456789 HP 0123456789 HP";
		kontak1.teleponbisnis = "telp bisnis 0123456789 telp bisnis 0123456789 telp bisnis 0123456789 telp bisnis 0123456789 telp bis";
		kontak1.faximili = "Fax 0123456789 Fax 0123456789 Fax 0123456789 Fax 0123456789 Fax 0123456789 Fax 0123456789 Fax 012345";
		kontak1.teleponrumah = "Telp rumah 0123456789 Telp rumah 0123456789 Telp rumah 0123456789 Telp rumah 0123456789 Telp rumah 0";
		kontak1.website = "website 0123456789 website 0123456789 website 0123456789 website 0123456789 website 0123456789 website 0123456789 website 0123456789 website 0123456789 website 0123456789 website 0123456789 website 01";
		kontak1.pinbbm = "bbm 0123456789 bbm 0";
		kontak1.catatan = "Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456789 Catatan 0123456";

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KONTAK);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KONTAK,
				"CV Maju Terus Pantang Mundur");
		KontakTool.saveIsiKontak(getWebDriver(), TARGET_FILE);
		log.info("Save #1");
		KontakTool.isi(getWebDriver(), kontak1);
		KontakTool.isiLainnya(getWebDriver(), kontak1);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KONTAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// edit lagi datanya, simpan
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KONTAK,
				TARGET_FILE);
		log.info("Save list #1");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KONTAK,
				"CV Maju Terus Pantang Mundur");
		KontakTool.saveIsiKontak(getWebDriver(), TARGET_FILE);
		log.info("Save #2");

		KontakParam kontakblank = new KontakParam();
		kontakblank.nama = "blank";
		kontakblank.jabatan = "blank";
		kontakblank.email = "blank";
		kontakblank.handphone = "blank";
		kontakblank.teleponbisnis = "blank";
		kontakblank.faximili = "blank";
		kontakblank.teleponrumah = "blank";
		kontakblank.website = "blank";
		kontakblank.pinbbm = "blank";

		KontakTool.isi(getWebDriver(), kontakblank);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KONTAK);
		GeneralTool.simpanPesanAntrian(getWebDriver(), TARGET_FILE);
		NavigationTool.klikBatalAntrian(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KONTAK);

		// hapus pelanggan
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PELANGGAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PELANGGAN,
				"Data Baru");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PELANGGAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PELANGGAN);

	}

}
