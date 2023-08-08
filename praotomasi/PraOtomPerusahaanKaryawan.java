package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.KaryawanTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.karyawan.KaryawanParam;

public class PraOtomPerusahaanKaryawan extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomPerusahaanKaryawan.class);

	private String TARGET_FILE = "PraOtomasi Perusahaan-Karyawan.txt";

	@Test
	public void buatBaru() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KARYAWAN);

		log.info("Cari data");

		// Buat Data Baru
		log.info("Buat data baru");
		KaryawanParam param = new KaryawanParam();
		param.nama = "CobaCoba";
		param.sapaan = "Bapak";
		param.jabatan = "UFOO";
		param.email = "aa@a.a";
		param.handphone = "32524624";
		param.teleponbisnis = "293627";
		param.teleponrumah = "234567";
		param.pinbbm = "23456";
		param.website = "www.www.www";
		param.ktp = "123456";
		param.cbpenjual = true;
		param.catatan = "Catatan 123456 Catatan 123456 Catatan 123456 Catatan 123456 Catatan 123456 Catatan 123456 "
				+ "Catatan 123456 Catatan 123456 Catatan 123456Catatan 123456Catatan 123456 Catatan 123456";
		KaryawanTool.isi(getWebDriver(), param);
		KaryawanTool.saveDetailKaryawan(getWebDriver(), TARGET_FILE);
		KaryawanTool.klikAlamat(getWebDriver());

		param.jalan = "JalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalan"
				+ "JalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalanJalanaJalan";
		param.kota = "KotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKota"
				+ "KotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKotaKota";
		param.kodepos = "25345";
		param.propinsi = "propinsipropinsipropinsipropinsipropinsipropinsipropinsipropinsipropinsipropinsipropinsipropinsi"
				+ "propinsipropinsipropinsipropinsipropinsipropinsipropinsipropinsipropinsi";
		param.negara = "negaranegaranegaranegaranegaranegaranegaranegaranegaranegaranegaranegaranegaranegaranegaranegara"
				+ "negaranegaranegaranegaranegaranegaranegaranegaranegaranegaranegara";
		KaryawanTool.isiAlamat(getWebDriver(), param);
		KaryawanTool.saveAlamat(getWebDriver(), TARGET_FILE);
		KaryawanTool.klikPajak(getWebDriver());

		param.cbkenapph = true;
		param.nonpwp = "333333333333333";
		param.statuspekerja = "Pegawai Tetap";
		param.statusptkp = "Kawin (1 Tanggungan)";
		param.pphbulan = "April";
		param.pphtahun = "2015";
		KaryawanTool.isiPajak(getWebDriver(), param);
		KaryawanTool.savePajak(getWebDriver(), TARGET_FILE);

		// param.komponengaji = "Gaji Pokok";
		// param.cbkomponengaji = true;
		// KaryawanTool.isiGaji(getWebDriver(), param);

//		param.komponengaji = "Gaji Pokok";
//		param.cbkomponengaji = true;
//		KaryawanTool.isiGaji(getWebDriver(), param);
//
//		param.komponengaji = "Potongan Gaji";
//		param.cbkomponengaji = true;
//		KaryawanTool.isiGaji(getWebDriver(), param);
//
//		param.komponengaji = "Tunjangan Makan";
//		param.cbkomponengaji = true;
//		KaryawanTool.isiGaji(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KARYAWAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KARYAWAN);
	}
	
	@Test(dependsOnMethods = "buatBaru")
	public void hapuskaryawan() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KARYAWAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KARYAWAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KARYAWAN, "CobaCoba");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KARYAWAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KARYAWAN);
	}
	
	@Test(dependsOnMethods = "hapuskaryawan")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
