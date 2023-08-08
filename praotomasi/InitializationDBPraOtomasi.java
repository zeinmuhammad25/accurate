package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.akunperkiraan.AkunPerkiraanParam;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.cabang.CabangParam;
import com.cpssoft.web.test.accurate.departemen.DepartemenParam;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.general.GeneralParam;
import com.cpssoft.web.test.accurate.karyawan.KaryawanParam;
import com.cpssoft.web.test.accurate.matauang.MataUangParam;
import com.cpssoft.web.test.accurate.pajak.PajakParam;
import com.cpssoft.web.test.accurate.pelanggan.PelangganParam;
import com.cpssoft.web.test.accurate.pemasok.PemasokParam;
import com.cpssoft.web.test.accurate.pengiriman.PengirimanParam;
import com.cpssoft.web.test.accurate.penomoranpajak.PenomoranPajakParam;
import com.cpssoft.web.test.accurate.persiapandataperusahaan.PersiapanDataParam;
import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
import com.cpssoft.web.test.accurate.proyek.ProyekParam;
import com.cpssoft.web.test.accurate.satuanbarang.SatuanBarangParam;
import com.cpssoft.web.test.accurate.syaratpembayaran.SyaratPembayaranParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AkunPerkiraanTool;
import com.cpssoft.web.test.accurate.tool.BarangJasaTool;
import com.cpssoft.web.test.accurate.tool.CabangTool;
import com.cpssoft.web.test.accurate.tool.DepartemenTool;
import com.cpssoft.web.test.accurate.tool.FakturPenjualanTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KaryawanTool;
import com.cpssoft.web.test.accurate.tool.MarketplaceTool;
import com.cpssoft.web.test.accurate.tool.MataUangTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PajakTool;
import com.cpssoft.web.test.accurate.tool.PelangganTool;
import com.cpssoft.web.test.accurate.tool.PemasokTool;
import com.cpssoft.web.test.accurate.tool.PengirimanTool;
import com.cpssoft.web.test.accurate.tool.PenomoranPajakTool;
import com.cpssoft.web.test.accurate.tool.PersiapanDataPerusahaanTool;
import com.cpssoft.web.test.accurate.tool.PreferensiTool;
import com.cpssoft.web.test.accurate.tool.ProyekTool;
import com.cpssoft.web.test.accurate.tool.SatuanBarangTool;
import com.cpssoft.web.test.accurate.tool.SyaratPembayaranTool;
import com.cpssoft.web.test.accurate.tool.UserTool;

public class InitializationDBPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(InitializationDBPraOtomasi.class);

	private String TARGET_FILE = "InitializationDBPraOtomasi.txt";

	@Test()
	public void Step1() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		// Tutup Introduction
		log.info("tutup introduction");
		GeneralParam param = new GeneralParam();
		param.cbtidaktampil = true;
		UserTool.tutupIntroductionDB(getWebDriver(),
				param);
	}

	@Test(dependsOnMethods = "Step1")
	public void installAplikasiPusatLabaRugi() {
		// install dari Marketplace
		String nama_aplikasi = "Cost & Profit Center";
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.MARKETPLACE);
		// di awal otomasi marketplace, HARUS ada setFocusToMarketplaceFrame
		MarketplaceTool.setFocusToMarketplaceIFrame();
		MarketplaceTool.cariAplikasi(nama_aplikasi);
		MarketplaceTool.installAplikasi(nama_aplikasi);
		MarketplaceTool.konfirmasiInstall("Install");
		MarketplaceTool.setFocusBackToDefault();
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.MARKETPLACE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PREFERENSI);

	}
	
	@Test(dependsOnMethods = "installAplikasiPusatLabaRugi")
	public void installAplikasimulticabang() {
		// install dari Marketplace
		String nama_aplikasi = "Multi Branch";
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.MARKETPLACE);
		// di awal otomasi marketplace, HARUS ada setFocusToMarketplaceFrame
		MarketplaceTool.setFocusToMarketplaceIFrame();
		MarketplaceTool.cariAplikasi(nama_aplikasi);
		MarketplaceTool.installAplikasi(nama_aplikasi);
		MarketplaceTool.konfirmasiInstall("Install");
		MarketplaceTool.setFocusBackToDefault();
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.MARKETPLACE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.CABANG);
		
	}
	
	@Test(dependsOnMethods = "installAplikasimulticabang")
	public void Step1Setengah() {
		// isi preferensi bagian Pembelian
		log.info("ganti Format Desimal ke USD");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.PREFERENSI);
		
		PreferensiParam param1 = new PreferensiParam();
		param1.kota = "DKI";
		PreferensiTool.isiInfoPerusahaan(getWebDriver(), param1);

		PreferensiParam param = new PreferensiParam();
		param.formatdesimal = "Asing (9,999.9)";
		PreferensiTool.isiLainLain(getWebDriver(), param);

		NavigationTool.klikSimpanBawah(getWebDriver(),
				AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}

	@Test(dependsOnMethods = "Step1Setengah")
	public void Step2() {
		// Buat Mata Uang
		log.info("buat mata uang");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.MATA_UANG);

		MataUangParam param = new MataUangParam();
		param.nama = "USD";
		MataUangTool.isi(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.MATA_UANG);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.MATA_UANG);
	}

	@Test(dependsOnMethods = "Step2")
	public void buatCabang() {
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.CABANG);
		CabangParam cabangawal = new CabangParam();
		cabangawal.nama = "Cabang1";

		CabangTool.isiCabang(getWebDriver(), cabangawal);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.CABANG);
		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.CABANG);
	}

	@Test(dependsOnMethods = "buatCabang")
	public void Step3() {
		// Buat Departemen dan Proyek
		log.info("buat departemen");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.DEPARTEMEN);

		DepartemenParam param = new DepartemenParam();
		param.nama = "Parent Dept";
		DepartemenTool.isiDepartemen(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.DEPARTEMEN);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		DepartemenParam param2 = new DepartemenParam();
		param2.nama = "Dept 1";
		param2.cbsubdepartemen = true;
		param2.namasubdepartemen = "Parent Dept";
		DepartemenTool.isiDepartemen(getWebDriver(), param2);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.DEPARTEMEN);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		DepartemenParam param3 = new DepartemenParam();
		param3.nama = "Dept 2";
		DepartemenTool.isiDepartemen(getWebDriver(), param3);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.DEPARTEMEN);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.DEPARTEMEN);
		
		//buat Proyek
		log.info("buat proyek");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.PROYEK);

		ProyekParam param4 = new ProyekParam();
		//NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PROYEK);
		//param4.noproyek = "P1";
		param4.nama = "Proyek 1";
		param4.keterangan = "Proyek 1";
		ProyekTool.isiProyek(getWebDriver(), param4);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PROYEK);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.PROYEK);
	}

	@Test(dependsOnMethods = "Step3")
	public void Step4() {
		// Buat Syarat Pembayaran
		log.info("buat syarat pembayaran");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.SYARAT_PEMBAYARAN);

		SyaratPembayaranParam param = new SyaratPembayaranParam();
		param.jikamembayarantara = "5";
		param.akanmendapatdiskon = "15";
		param.masajatuhtempo = "30";
		SyaratPembayaranTool.isi(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.SYARAT_PEMBAYARAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// syarat ke 2
		param.jikamembayarantara = "10";
		param.akanmendapatdiskon = "5";
		param.masajatuhtempo = "30";
		SyaratPembayaranTool.isi(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.SYARAT_PEMBAYARAN);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.SYARAT_PEMBAYARAN);
	}

	@Test(dependsOnMethods = "Step4")
	public void Step5() {
		// Buat Pengiriman
		log.info("buat pengiriman");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.PENGIRIMAN);

		PengirimanParam param = new PengirimanParam();
		param.nama = "POS";
		PengirimanTool.isi(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PENGIRIMAN);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// syarat ke 2
		param.nama = "DHL";
		PengirimanTool.isi(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PENGIRIMAN);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.PENGIRIMAN);
	}

	@Test(dependsOnMethods = "Step5")
	public void Step6() {
		// Buat Pajak
		log.info("buat pajak");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.PAJAK);

		PajakParam param = new PajakParam();
		param.tipe = "Pajak Pertambahan Barang Mewah";
		param.keterangan = "PPnBM";
		param.persentase = "25";
		param.akunpajakpenjualan = "PPN Keluaran";
		param.akunpajakpembelian = "PPN Masukan";
		PajakTool.isi(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PAJAK);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.PAJAK);
	}

	@Test(dependsOnMethods = "Step6")
	public void Step7() {
		// Buat Penomoran Pajak
		log.info("buat penomoran pajak");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.PENOMORAN_PAJAK);

		PenomoranPajakParam param = new PenomoranPajakParam();
		param.darinomor = "0001500000001";
		param.sampainomor = "0001500001000";
		PenomoranPajakTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PENOMORAN_PAJAK);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.PENOMORAN_PAJAK);
	}

	@Test(dependsOnMethods = "Step7")
	public void Step8() {
		// Buat Pelanggan
		log.info("buat pelanggan");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.PELANGGAN);

		PelangganParam param = new PelangganParam();
		param.nama = "ABC";
		PelangganTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PELANGGAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// pelanggan ke 2
		param.nama = "Unilever USD";
		param.defmatauang = "USD";
		PelangganTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PELANGGAN);

		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.PELANGGAN);
	}

	@Test(dependsOnMethods = "Step8")
	public void Step9() {
		// Buat Pemasok
		log.info("buat pemasok");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.PEMASOK);

		PemasokParam param = new PemasokParam();
		param.nama = "Mayora";
		PemasokTool.isiFormUmum(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// pemasok ke 2
		param.nama = "Indofood USD";
		param.matauang = "USD";
		PemasokTool.isiFormUmum(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// pemasok ke 3
		PemasokParam param2 = new PemasokParam();
		param2.nama = "Vendor-Dimas";
		PemasokTool.isiFormUmum(getWebDriver(), param2);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// pemasok ke 4
		PemasokParam param3 = new PemasokParam();
		param3.nama = "Vendor-Dhanu";
		PemasokTool.isiFormUmum(getWebDriver(), param3);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.PEMASOK);
	}

	@Test(dependsOnMethods = "Step9")
	public void Step10() {
		// Buat Satuan Barang
		log.info("buat satuan barang");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.SATUAN_BARANG);

		SatuanBarangParam param = new SatuanBarangParam();
		param.nama = "Piece";
		SatuanBarangTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.SATUAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// satuan barang ke 2
		param.nama = "Pack";
		SatuanBarangTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.SATUAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// satuan barang ke 3
		param.nama = "Box";
		SatuanBarangTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.SATUAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// satuan barang ke 4
		param.nama = "Dus";
		SatuanBarangTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.SATUAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// satuan barang ke 5
		param.nama = "Gros";
		SatuanBarangTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.SATUAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.SATUAN_BARANG);
	}

	@Test(dependsOnMethods = "Step10")
	public void Step11() {
		// Buat Barang & Jasa
		log.info("buat barang & jasa");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.BARANG_JASA);

		BarangJasaParam param = new BarangJasaParam();
		param.namabarang = "Indomie";
		param.satuan = "Piece";
		BarangJasaTool.isiUmum(getWebDriver(), param);

		param.pajak1 = "Pajak Pertambahan Nilai";
		param.pajak2 = "PPnBM";
		BarangJasaTool.isiJualBeli(getWebDriver(), param);

		BarangJasaTool.isiSaldo(getWebDriver());
		NavigationTool.tambahSaldoBarang(getWebDriver(), AccurateModule.BARANG_JASA);

		param.kuantitassaldo = "20";
		param.biayasatuan = "1000";
		BarangJasaTool.detailSaldo(getWebDriver(), param);

		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-open-balance')]");

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// barang ke 2
		param.namabarang = "Plastik";
		param.jenisitem = "Non Persediaan";
		BarangJasaTool.isiUmum(getWebDriver(), param);

		param.pajak1 = "Pajak Pertambahan Nilai";
		param.pajak2 = "PPnBM";
		BarangJasaTool.isiJualBeli(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// barang ke 3
		param.namabarang = "Jasa Pasang";
		param.jenisitem = "Jasa";
		BarangJasaTool.isiUmum(getWebDriver(), param);

		BarangJasaParam param2 = new BarangJasaParam();
		param2.pajak1 = "Pajak Pertambahan Nilai";
		BarangJasaTool.isiJualBeli(getWebDriver(), param2);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// barang ke 4
		BarangJasaParam param3 = new BarangJasaParam();
		param3.namabarang = "Accurate 4 SE";
		BarangJasaTool.isiUmum(getWebDriver(), param3);

		param3.pajak1 = "Pajak Pertambahan Nilai";
		param3.defhargajual = "8000000";
		BarangJasaTool.isiJualBeli(getWebDriver(), param3);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// barang ke 5
		BarangJasaParam param4 = new BarangJasaParam();
		param4.namabarang = "Accurate 4 DE";
		BarangJasaTool.isiUmum(getWebDriver(), param4);

		param4.pajak1 = "Pajak Pertambahan Nilai";
		param4.defhargajual = "11000000";
		BarangJasaTool.isiJualBeli(getWebDriver(), param4);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// barang ke 6
		BarangJasaParam param5 = new BarangJasaParam();
		param5.namabarang = "Accurate 4 EE";
		BarangJasaTool.isiUmum(getWebDriver(), param5);

		param5.pajak1 = "Pajak Pertambahan Nilai";
		param5.defhargajual = "25000000";
		BarangJasaTool.isiJualBeli(getWebDriver(), param5);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		// barang SN
		BarangJasaParam tambah = new BarangJasaParam();
		tambah.namabarang = "Barang SN";
		tambah.satuan = "Pcs";
		tambah.cbnoseri = true;
		tambah.nomorunik = true;
		BarangJasaTool.isiUmum(getWebDriver(), tambah);

//		BarangJasaParam lain = new BarangJasaParam();
//		lain.cbnoseri = true;
//		lain.nomorunik = true;
//		BarangJasaTool.isiLainLain(getWebDriver(), lain);

		BarangJasaParam saldo = new BarangJasaParam();
		BarangJasaTool.isiSaldo(getWebDriver());
		NavigationTool.tambahSaldoBarang(getWebDriver(), AccurateModule.BARANG_JASA);
		saldo.tanggalsaldo = "10122016";
		saldo.gudangsaldo = "Utama";
		saldo.kuantitassaldo = "2";
		saldo.satuansaldo = "Pcs";
		saldo.biayasatuan = "12500";
		BarangJasaTool.detailSaldo(getWebDriver(), saldo);

		BarangJasaParam noseri = new BarangJasaParam();
		noseri.noseri = "A001";
		BarangJasaTool.detailNoSeri(getWebDriver(), noseri);
		BarangJasaTool.klikButtonLanjutTabDetailSerialNumber(getWebDriver());
		noseri.noseri = "A002";
		BarangJasaTool.detailNoSeri(getWebDriver(), noseri);
		BarangJasaTool.klikButtonLanjutTabDetailSerialNumber(getWebDriver());

		BarangJasaTool.klikButtonLanjutTabDetailSaldo(getWebDriver());
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}

	@Test(dependsOnMethods = "Step11")
	public void Step12() {
		// Buat Karyawan
		log.info("buat karyawan");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.KARYAWAN);

		KaryawanParam param = new KaryawanParam();
		param.nama = "Brad Pitt";
		param.cbpenjual = true;
		KaryawanTool.isi(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.KARYAWAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		// karyawan ke 2
		param.nama = "Julia Robert";
		param.cbpenjual = true;
		KaryawanTool.isi(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.KARYAWAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.KARYAWAN);
	}

	@Test(dependsOnMethods = "Step12")
	public void Step13() {
		// Buat Faktur Penjualan
		log.info("buat faktur penjualan");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.FAKTUR_PENJUALAN);

		NavigationTool.klikButtonPensil(getWebDriver(),
				AccurateModule.FAKTUR_PENJUALAN);

		FakturPenjualanParam param = new FakturPenjualanParam();
		param.pelanggan = "Unilever USD";
		param.kursritel = "14000";
		param.kurspajak = "15000";
		param.tanggal = "01042022";
		param.no = "SI1";
		FakturPenjualanTool.isiForm(getWebDriver(), param);

		param.search = "Indomie";
		FakturPenjualanTool.isiDetailBarang(getWebDriver(), param);

		param.tab = "Detail Barang";
		param.harga = "2000";
		param.kuantitas = "5";
		FakturPenjualanTool.detailBarang(getWebDriver(), param);

		NavigationTool.klikButtonLanjut(getWebDriver(),
				"//div[starts-with(@id, 'detail-item')]");

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.FAKTUR_PENJUALAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.FAKTUR_PENJUALAN);
	}

	@Test(dependsOnMethods = "Step13")
	public void Step14() {
		// Buat Akun Perkiraan
		log.info("buat akun perkiraan");
		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.AKUN_PERKIRAAN);

		AkunPerkiraanParam param = new AkunPerkiraanParam();
		param.tipe = "Kas & Bank";
		param.no = "BankIDR01";
		param.nama = "Bank IDR";
		AkunPerkiraanTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.AKUN_PERKIRAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		param.tipe = "Beban Pokok Penjualan";
		param.no = "SelisihBiaya01";
		param.nama = "Selisih Biaya";
		AkunPerkiraanTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.AKUN_PERKIRAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		param.tipe = "Beban Pokok Penjualan";
		param.no = "SelisihBarang01";
		param.nama = "Selisih Barang";
		AkunPerkiraanTool.isiForm(getWebDriver(), param);

		NavigationTool.klikSimpanData(getWebDriver(),
				AccurateModule.AKUN_PERKIRAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikTutupModule(getWebDriver(),
				AccurateModule.AKUN_PERKIRAAN);
	}

	@Test(dependsOnMethods = "Step14")
	public void Step15() {
		
		// buat pph 21 untuk pemasok
				NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PAJAK);
				
				PajakParam param = new PajakParam();
				param.tipe = "Pajak Penghasilan Ps.21";
				param.keterangan = "PPh 21";
				param.akunpajakpembelian = "Hutang Pembelian Belum Ditagih";
				PajakTool.isi(getWebDriver(), param);

				NavigationTool.klikSimpanData(getWebDriver(),
						AccurateModule.PAJAK);

				GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
				NavigationTool.klikTutupModule(getWebDriver(),
						AccurateModule.PAJAK);
				
	}

	@Test(dependsOnMethods = "Step15")
	public void Step16() {
		
		// isi preferensi bagian Pembelian
				log.info("isi preferensi bagian Pembelian");
				NavigationTool.klikMenuModul(getWebDriver(),
						AccurateModule.PREFERENSI);

				PreferensiParam param = new PreferensiParam();
				param.selisihbiaya = "Beban Iklan";
				param.akunselisihbarang = "Beban Komisi";
				PreferensiTool.isiPembelian(getWebDriver(), param);

				NavigationTool.klikSimpanBawah(getWebDriver(),
						AccurateModule.PREFERENSI);
				GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
	}
	
	@Test(dependsOnMethods = "Step16")
	public void Step17() 
	{
		// tutup persiapan data perusahaan
				log.info("tutup persiapan data perusahaan");

				PersiapanDataParam param = new PersiapanDataParam();
				param.cbtidaktampil = true;
				PersiapanDataPerusahaanTool.isiForm(getWebDriver(), param);
				//sudah tidak pakai ini
//				NavigationTool.klikTombolTutup(getWebDriver());

	}
	
	@Test(dependsOnMethods = "Step17")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
