package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.gudang.GudangParam;
import com.cpssoft.web.test.accurate.pindahbarang.PindahBarangParam;
import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.BarangJasaTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.GudangTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PindahBarangTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPersediaanPindahBarang extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanPindahBarang.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Pindah Barang.txt";

	@Test
	public void isiBarangJasa() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		BarangJasaParam param = new BarangJasaParam();
		
		param.namabarang = "Tahu";
		BarangJasaTool.isiUmum(getWebDriver(), param);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		BarangJasaParam param2 = new BarangJasaParam();
		
		param2.namabarang = "Tempe";
		BarangJasaTool.isiUmum(getWebDriver(), param2);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = { "isiBarangJasa" })
	public void isiGudang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GUDANG);
		GudangParam param = new GudangParam();
		
		param.nama = "Coba";
		GudangTool.isiForm(getWebDriver(), param);
		GudangTool.SaveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.GUDANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GUDANG);
	}
	
//	sudah tidak terpakai, tidak ada lagi jurnal selisih pindah barang
//	@Test(dependsOnMethods = "isiBarangJasa")
//	public void akunDefault()
//	{
//		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
//		PreferensiParam param = new PreferensiParam();
//		
//		param.selisihpindahbarang = "Beban Pokok Penjualan";
//		PreferensiTool.isiAkunPerkiraan(getWebDriver(), param);
//		PreferensiTool.saveIsiAkunPerkiraan(getWebDriver(), TARGET_FILE);
//		
//		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
//		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
//	}
	
	@Test(dependsOnMethods = { "isiGudang" })
	public void isiPindahBarang() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PINDAH_BARANG);
		PindahBarangParam param = new PindahBarangParam();
		
		param.proses = "Kirim Barang";
		param.tanggal = "01012015";
		param.gudang = "Utama";
		param.gudangtujuan = "Coba";
		PindahBarangTool.isiForm(getWebDriver(), param);
		PindahBarangTool.SaveIsiHeaderKirimBarang(getWebDriver(), TARGET_FILE);
		
		param.searchitem = "tahu";
		PindahBarangTool.isiDetailBarang(getWebDriver(), param);
		param.tab = "detail barang";
		param.namabarang = "Tahu";
		param.kuantitas = "5";
		PindahBarangTool.detailBarang(getWebDriver(), param);
		PindahBarangTool.saveDetail(getWebDriver(), TARGET_FILE);
		PindahBarangTool.klikButtonLanjutDetailBarang(getWebDriver());
		
		PindahBarangParam param2 = new PindahBarangParam();
		param2.tab="keterangan";
		param2.keterangan ="pindahbarangTC";
		PindahBarangTool.isiInfoLain(getWebDriver(), param2);
		PindahBarangTool.SaveInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PINDAH_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		WaitTool.delay(500);
		//AccTool.getNotification(getWebDriver()); //pastikan notif tersisa ditutup
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PINDAH_BARANG);
	}
	
	@Test(dependsOnMethods = { "isiPindahBarang" })
	public void editPindahBarang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PINDAH_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PINDAH_BARANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PINDAH_BARANG, "pindahbarangTC");
		PindahBarangParam param = new PindahBarangParam();
		
		param.searchitem = "Tempe";
		PindahBarangTool.isiDetailBarang(getWebDriver(), param);
		param.tab = "Detail barang";
		param.namabarang = "Tempe";
		param.kuantitas = "3";
		PindahBarangTool.detailBarang(getWebDriver(), param);
		PindahBarangTool.saveDetail(getWebDriver(), TARGET_FILE);
		PindahBarangTool.klikButtonLanjutDetailBarang(getWebDriver());
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PINDAH_BARANG);
		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		WaitTool.delay(1000); //harus ada delay kalau tidak salah ambil notif
		//AccTool.getNotification(getWebDriver()); //pastikan notif tersisa ditutup
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PINDAH_BARANG);
	}
	
	@Test(dependsOnMethods = { "editPindahBarang" })
	public void cekNavPindahBarang() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PINDAH_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PINDAH_BARANG, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PINDAH_BARANG);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PINDAH_BARANG, "pindahbarangTC");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PINDAH_BARANG);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
//		//cek email sudah tidak ada field ini
//		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PINDAH_BARANG);
//		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PINDAH_BARANG);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PINDAH_BARANG);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PINDAH_BARANG);
	}
	
	@Test(dependsOnMethods = { "cekNavPindahBarang" })
	public void hapusPindahBarang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PINDAH_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PINDAH_BARANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PINDAH_BARANG, "pindahbarangTC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PINDAH_BARANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PINDAH_BARANG);
	}
	
	@Test(dependsOnMethods = { "hapusPindahBarang" })
	public void hapusBarangJasa()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.BARANG_JASA, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.BARANG_JASA, "Tahu");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = { "hapusBarangJasa" })
	public void hapusBarangJasa2()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.BARANG_JASA, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.BARANG_JASA, "Tempe");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = { "hapusBarangJasa2" })
	public void hapusGudang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.GUDANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.GUDANG, "Coba");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GUDANG);
	}
	@Test(dependsOnMethods = { "hapusGudang" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
