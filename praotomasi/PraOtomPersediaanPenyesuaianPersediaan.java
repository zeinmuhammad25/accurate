package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.penyesuaianpersediaan.PenyesuaianPersediaanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.BarangJasaTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PenyesuaianPersediaanTool;

public class PraOtomPersediaanPenyesuaianPersediaan extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanPenyesuaianPersediaan.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Penyesuaian Persediaan.txt";

	@Test()
	public void isiBarangJasa() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		BarangJasaParam param = new BarangJasaParam();
		
		param.namabarang = "Tahu";
		param.jenisitem = "Persediaan";
		param.satuan = "pcs";
		BarangJasaTool.isiUmum(getWebDriver(), param);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		BarangJasaParam param2 = new BarangJasaParam();
		
		param2.namabarang = "Tempe";
		param2.jenisitem = "Persediaan";
		param2.satuan = "pcs";
		BarangJasaTool.isiUmum(getWebDriver(), param2);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = { "isiBarangJasa" })
	public void isiPenyesuaianPersediaan()
	{
		log.info("Buat Penyesuaian");
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		
		PenyesuaianPersediaanParam header = new PenyesuaianPersediaanParam();
		header.tanggal = "01012015";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		header.no = "IA-2015/01";
		PenyesuaianPersediaanTool.isiForm(getWebDriver(), header);
		PenyesuaianPersediaanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		PenyesuaianPersediaanParam detail = new PenyesuaianPersediaanParam();
		detail.searchitem = "Tahu";
		PenyesuaianPersediaanTool.isiDetailBarang(getWebDriver(), detail);
		detail.tab = "detail barang";
		detail.penambahan = true;
		detail.kuantitas ="5";
		detail.biayasatuan = "2000";
		detail.unit ="pcs";
		detail.gudang = "Utama";
		PenyesuaianPersediaanTool.detailBarang(getWebDriver(), detail);
		PenyesuaianPersediaanTool.saveDetail(getWebDriver(), TARGET_FILE);
		PenyesuaianPersediaanTool.klikButtonLanjutTabDetailBarang(getWebDriver());
		
		detail.tab = "Info Lainnya";
		detail.keterangan = "penyesuaianpersediaanTC";
		PenyesuaianPersediaanTool.isiInfoLain(getWebDriver(),detail);
		PenyesuaianPersediaanTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
	}
	
	@Test(dependsOnMethods = { "isiPenyesuaianPersediaan" })
	public void editPenyesuaianPersediaan()
	{
		log.info("Edit Penyesuaian");
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN, "penyesuaianpersediaanTC");
		
		PenyesuaianPersediaanParam detail = new PenyesuaianPersediaanParam();
		detail.searchitem = "Tempe";
		PenyesuaianPersediaanTool.isiDetailBarang(getWebDriver(), detail);
		detail.tab = "detail barang";
		detail.penambahan = true;
		detail.kuantitas ="3";
		detail.biayasatuan = "3000";
		detail.unit ="pcs";
		detail.gudang = "Utama";
		PenyesuaianPersediaanTool.detailBarang(getWebDriver(), detail);
		PenyesuaianPersediaanTool.klikButtonLanjutTabDetailBarang(getWebDriver());
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN, "penyesuaianpersediaanTC");
		//PenyesuaianPersediaanTool.klikTampilkanDetailData();
		PenyesuaianPersediaanTool.saveListBarang(getWebDriver(), TARGET_FILE);
		//PenyesuaianPersediaanTool.klikButtonLanjutTabDetailBarang(getWebDriver());
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		//NavigationTool.klikKonfirmasiYa(getWebDriver());
	}
	
	@Test(dependsOnMethods = { "editPenyesuaianPersediaan" })
	public void cekNavIA() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN, "penyesuaianpersediaanTC");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		//NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		//NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
	}
	
	@Test(dependsOnMethods = { "cekNavIA" })
	public void hapusPenyesuaianPersediaan()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN, "penyesuaianpersediaanTC");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENYESUAIAN_PERSEDIAAN);
	}
	
	@Test(dependsOnMethods = { "hapusPenyesuaianPersediaan" })
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
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
