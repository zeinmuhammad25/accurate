package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.laporan.KategoriLaporan;
import com.cpssoft.web.test.accurate.laporan.LaporanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.LaporanTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;

public class PraOtomasiCekNavigasiLaporan extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomasiCekNavigasiLaporan.class);
	private static String TARGET_FILE = "PraOtomasiCekNavigasiLaporan.txt";
	
	@Test()
	public void cekLaporanKeuangan1(){
		log.info("Cek Navigasi Laporan");
		AccTool.deleteTextFile(TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.KEUANGAN, "Laba/Rugi (Standar)");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}


	@Test(dependsOnMethods = { "cekLaporanKeuangan1" })
	public void cekLaporanKeuangan2() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.KEUANGAN, "Neraca (Standar)");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekLaporanKeuangan2" })
	public void cekPusatLabaBiaya() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.PUSAT_LABA_BIAYA, "Laba/Rugi Departemen");
		LaporanParam param = new LaporanParam();
		param.departemen = "Dept 1";
		LaporanTool.parameterTambahan(getWebDriver(), param);
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}	
	
	@Test(dependsOnMethods = { "cekPusatLabaBiaya" })
	public void cekBukuBesar() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.BUKU_BESAR, "Keseluruhan Jurnal");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekBukuBesar" })
	public void cekKasBank() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.KAS_BANK, "Histori Bank");
		LaporanParam param = new LaporanParam();
		param.kasbank = "Kas Kecil";
		LaporanTool.parameterTambahan(getWebDriver(), param);
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}	
	
	@Test(dependsOnMethods = { "cekKasBank" })
	public void cekPiutang() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.PIUTANG, "Faktur Belum Lunas");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}	
	
	@Test(dependsOnMethods = { "cekPiutang" })
	public void cekPenjualan() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.PENJUALAN, "Penjualan per Pelanggan");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekPenjualan" })
	public void cekTenagaPenjual() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.TENAGA_PENJUAL, "Faktur Belum Lunas per Penjual");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekTenagaPenjual" })
	public void cekHutang() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.UTANG, "Faktur Belum Lunas");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekHutang" })
	public void cekPembelian() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.PEMBELIAN, "Pembelian per Pemasok");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekPembelian" })
	public void cekPersediaan() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.PERSEDIAAN, "Rincian Nilai Persediaan");
		LaporanParam param = new LaporanParam();
		param.barangjasa = "Indomie";
		LaporanTool.parameterTambahan(getWebDriver(), param);
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekPersediaan" })
	public void cekGudang() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.GUDANG, "Mutasi per Barang");
		LaporanParam param = new LaporanParam();
		param.barangjasa = "Accurate 4 DE";
		LaporanTool.parameterTambahan(getWebDriver(), param);
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekGudang" })
	public void cekPekerjaanPesanan() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.PEKERJAAN_PESANAN, "Histori Pekerjaan Pesanan");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekPekerjaanPesanan" })
	public void cekAsetTetap() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.ASET_TETAP, "Daftar Aset Tetap");
		
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekAsetTetap" })
	public void cekPajak() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.PAJAK, "Daftar PPN/PPnBM Keluaran");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekPajak" })
	public void cekPemeriksaan() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.PEMERIKSAAN, "Selisih Saldo Akun Persediaan dengan Nilai Barang");
		LaporanTool.klikButtonTampilkan(getWebDriver());
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekPemeriksaan" })
	public void cekLainLain() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
		LaporanTool.bukaLaporan(getWebDriver(), KategoriLaporan.LAIN_LAIN, "Daftar Mata Uang");
		
		//klik Modifikasi
		LaporanTool.klikModifikasi(getWebDriver());
		LaporanTool.klikSimpanModifikasi(getWebDriver());
		//klik Refresh
		LaporanTool.klikRefresh(getWebDriver());
		//klik Cetak
		LaporanTool.klikCetakLaporan(getWebDriver());
		LaporanTool.cekPrintPreviewLaporan(getWebDriver(), TARGET_FILE);
		//klik Memorize
		LaporanTool.klikMemorize(getWebDriver());
		LaporanTool.klikLanjutMemorize(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//klik Favorit
		LaporanTool.klikFavorit(getWebDriver());
		LaporanTool.cekFavorit(getWebDriver(), TARGET_FILE);
		LaporanTool.klikFavorit(getWebDriver());
		//klik Export to PDF
		LaporanTool.klikExportExcel(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}
	
	@Test(dependsOnMethods = { "cekLainLain" })
	public void compareResult() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
