package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.hargapemasok.HargaPemasokParam;
import com.cpssoft.web.test.accurate.pemasok.PemasokParam;
import com.cpssoft.web.test.accurate.satuanbarang.SatuanBarangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.BarangJasaTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.HargaPemasokTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PemasokTool;
import com.cpssoft.web.test.accurate.tool.SatuanBarangTool;

public class PraOtomPersediaanHargaPemasok extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanHargaPemasok.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Harga Pemasok.txt";

	@Test()
	public void isiSatuanBarang() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.SATUAN_BARANG);
		SatuanBarangParam param = new SatuanBarangParam();
		
		param.nama = "Coba";
		SatuanBarangTool.isiForm(getWebDriver(), param);
		SatuanBarangTool.SaveData(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.SATUAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.SATUAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "isiSatuanBarang" })
	public void isiBarangJasa() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		BarangJasaParam param = new BarangJasaParam();
		
		param.namabarang = "Tahu";
		param.jenisitem = "Persediaan";
		param.satuan = "Coba";
		BarangJasaTool.isiUmum(getWebDriver(), param);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		BarangJasaParam param2 = new BarangJasaParam();
		
		param2.namabarang = "Tempe";
		param2.jenisitem = "Persediaan";
		param2.satuan = "Coba";
		BarangJasaTool.isiUmum(getWebDriver(), param2);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = { "isiBarangJasa" })
	public void buatPemasok(){
		log.info("HargaPemasok.createpemasok");
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMASOK);
		PemasokParam pemasok = new PemasokParam();
		pemasok.nama = "Coba";
		PemasokTool.isiFormUmum(getWebDriver(), pemasok);
		PemasokTool.saveIsiInformasiUmum(getWebDriver(), TARGET_FILE);
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMASOK);
	}
	
	@Test(dependsOnMethods = { "buatPemasok" })
	public void buatHargapemasok(){
		log.info("HargaPemaasok.createhargapemasok");
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		HargaPemasokParam header = new HargaPemasokParam();
		header.pemasok = "Coba";
		header.mulaiberlaku ="01022015";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		header.no = "HargaPemasok-001";
		HargaPemasokTool.isiForm(getWebDriver(), header);
		HargaPemasokTool.saveHeader(getWebDriver(), TARGET_FILE);
		
		HargaPemasokParam detail = new HargaPemasokParam();
		detail.searchitem = "Tahu";
		HargaPemasokTool.isiDetail(getWebDriver(), detail);
		detail.tab = "detail barang";
		detail.hargabaru = "7000";
		HargaPemasokTool.detailBarang(getWebDriver(), detail);
		HargaPemasokTool.klikButtonLanjutDetailBarang(getWebDriver());
		HargaPemasokTool.saveDetail(getWebDriver(), TARGET_FILE);
		
		HargaPemasokParam keterangan = new HargaPemasokParam();
		keterangan.tab = "info lainnya";
		keterangan.keterangan = "hargapemasokTC";
		HargaPemasokTool.isiInfoLain(getWebDriver(), keterangan);
		HargaPemasokTool.saveHeader(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.HARGA_PEMASOK);
	}
	
	@Test(dependsOnMethods = { "buatHargapemasok" })
	public void editHargaPemasok()
	{
		log.info("Edit Penyesuaian");
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.HARGA_PEMASOK, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.HARGA_PEMASOK, "hargapemasokTC");
		
		HargaPemasokParam detail = new HargaPemasokParam();
		detail.searchitem = "Tempe";
		HargaPemasokTool.isiDetail(getWebDriver(), detail);
		detail.tab = "detail barang";
		detail.hargabaru = "9000";
		HargaPemasokTool.detailBarang(getWebDriver(), detail);
		HargaPemasokTool.klikButtonLanjutDetailBarang(getWebDriver());
		HargaPemasokTool.saveDetail(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.HARGA_PEMASOK);
	}
	
	@Test(dependsOnMethods = { "editHargaPemasok" })
	public void cekNavHargaPemasok() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.HARGA_PEMASOK, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.HARGA_PEMASOK, "hargapemasokTC");
		//cetak form
		//NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		//NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		//NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		//NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.HARGA_PEMASOK);
	}
	
	@Test(dependsOnMethods = { "cekNavHargaPemasok" })
	public void hapushargaPemasok()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.HARGA_PEMASOK, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.HARGA_PEMASOK, "hargapemasokTC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.HARGA_PEMASOK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.HARGA_PEMASOK);
	}
		
	@Test(dependsOnMethods = { "hapushargaPemasok" })
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
	public void hapusPemasok()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMASOK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PEMASOK, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PEMASOK, "Coba");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PEMASOK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMASOK);
	}
	
	@Test(dependsOnMethods = { "hapusPemasok" })
	public void hapusSatuan()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.SATUAN_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.SATUAN_BARANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.SATUAN_BARANG, "Coba");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.SATUAN_BARANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.SATUAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "hapusSatuan" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
