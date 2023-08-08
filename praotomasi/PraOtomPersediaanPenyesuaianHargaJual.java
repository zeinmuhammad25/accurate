package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.penyesuaianhargajual.PenyesuaianHargaJualParam;
import com.cpssoft.web.test.accurate.satuanbarang.SatuanBarangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.BarangJasaTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PenyesuaianHargaJualTool;
import com.cpssoft.web.test.accurate.tool.SatuanBarangTool;
import com.cpssoft.web.test.framework.tools.WaitTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPersediaanPenyesuaianHargaJual extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanPenyesuaianHargaJual.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Penyesuaian Harga Jual.txt";

	@Test()
	public void isiSatuanBarang() 
	{
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
	public void isiBarangJasa() {
		

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
		param.jenisitem = "Persediaan";
		param2.satuan = "Coba";
		BarangJasaTool.isiUmum(getWebDriver(), param2);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = { "isiBarangJasa" })
	public void isiPenyesuaianHargaJual()
	{
		log.info("Buat Penyesuaian");
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		
		PenyesuaianHargaJualParam header = new PenyesuaianHargaJualParam();
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		header.kategoriharga = "Umum";
		header.no = "SPA.001";
		header.mulaiberlaku = "01022015";
		PenyesuaianHargaJualTool.isiForm(getWebDriver(), header);
		PenyesuaianHargaJualTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		PenyesuaianHargaJualParam detail = new PenyesuaianHargaJualParam();
		detail.searchitem = "Tahu";
		PenyesuaianHargaJualTool.isiDetail(getWebDriver(), detail);
		detail.tab = "detail barang";
		detail.satuan ="Coba";
		detail.hargabaru = "7000";
		PenyesuaianHargaJualTool.detailBarang(getWebDriver(), detail);
		PenyesuaianHargaJualTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		PenyesuaianHargaJualTool.klikButtonLanjutTabDetailBarang(getWebDriver());
		
		WaitTool.delay(1000);		
		
		detail.tab = "Info Lainnya";
		detail.keterangan = "penyesuaianpersediaanTC";
		PenyesuaianHargaJualTool.isiInfoLain(getWebDriver(), detail);
		PenyesuaianHargaJualTool.saveInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
	}
	
	@Test(dependsOnMethods = { "isiPenyesuaianHargaJual" })
	public void editPenyesuaianHargaJual()
	{
		log.info("Edit Penyesuaian");
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL, "penyesuaianpersediaanTC");
		
		
		PenyesuaianHargaJualParam detail = new PenyesuaianHargaJualParam();
		detail.searchitem = "Tempe";
		PenyesuaianHargaJualTool.isiDetail(getWebDriver(), detail);
		detail.tab = "detail barang";
		detail.satuan ="Coba";
		detail.hargabaru = "9000";
		PenyesuaianHargaJualTool.detailBarang(getWebDriver(), detail);
		PenyesuaianHargaJualTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		PenyesuaianHargaJualTool.klikButtonLanjutTabDetailBarang(getWebDriver());
		WaitTool.delay(1000);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
	}
	
	@Test(dependsOnMethods = { "editPenyesuaianHargaJual" })
	public void cekNavPenyesuaianHargaJual() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL, "penyesuaianpersediaanTC");
		//cetak form
		//NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		//NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		//NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		//NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
	}
	
	@Test(dependsOnMethods = { "cekNavPenyesuaianHargaJual" })
	public void hapusPenyesuaianHargaJual()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL, "penyesuaianpersediaanTC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL);
	}
	
	@Test(dependsOnMethods = { "hapusPenyesuaianHargaJual" })
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
	public void hapusSatuanBarang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.SATUAN_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.SATUAN_BARANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.SATUAN_BARANG, "Coba");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.SATUAN_BARANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.SATUAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "hapusSatuanBarang" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
