package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.pekerjaanpesanan.PekerjaanPesananParam;
import com.cpssoft.web.test.accurate.penyesuaianpersediaan.PenyesuaianPersediaanParam;
import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
import com.cpssoft.web.test.accurate.satuanbarang.SatuanBarangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.BarangJasaTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PekerjaanPesananTool;
import com.cpssoft.web.test.accurate.tool.PenyesuaianPersediaanTool;
import com.cpssoft.web.test.accurate.tool.PreferensiTool;
import com.cpssoft.web.test.accurate.tool.SatuanBarangTool;

public class PraOtomPersediaanPekerjaanPesanan extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanPekerjaanPesanan.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Pekerjaan Pesanan.txt";

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
	public void akunDefault()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		
		param.tab = "Isi Akun Perkiraan";
		param.biaya = "Beban Iklan";
		param.selisihbiaya = "Beban Komisi";
		PreferensiTool.isiAkunPerkiraan(getWebDriver(), param);
		PreferensiTool.saveIsiAkunPerkiraan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = { "akunDefault" })
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
		detail.unit ="Coba";
		detail.gudang = "Utama";
		PenyesuaianPersediaanTool.detailBarang(getWebDriver(), detail);
		PenyesuaianPersediaanTool.saveDetail(getWebDriver(), TARGET_FILE);
		PenyesuaianPersediaanTool.klikButtonLanjutTabDetailBarang(getWebDriver());
		
		detail.searchitem = "Tempe";
		PenyesuaianPersediaanTool.isiDetailBarang(getWebDriver(), detail);
		detail.tab = "detail barang";
		detail.penambahan = true;
		detail.kuantitas ="8";
		detail.biayasatuan = "3000";
		detail.unit ="Coba";
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
	public void createjobcosting(){
		log.info("Barangjasa.create jobcosting");
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		
		PekerjaanPesananParam header = new PekerjaanPesananParam();
		header.tanggal="01012015";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		header.no = "PP2016/03";
		PekerjaanPesananTool.isiForm(getWebDriver(), header);
		PekerjaanPesananTool.saveHeader(getWebDriver(), TARGET_FILE);
		
		PekerjaanPesananParam detail = new PekerjaanPesananParam();
		detail.search = "Tahu";
		PekerjaanPesananTool.isiDetailBarang(getWebDriver(), detail);
		detail.tab = "detail barang";
		//detail.tglpenambahan="01012015";
		detail.kuantitas = "5";
		PekerjaanPesananTool.detailBarang(getWebDriver(), detail);	
		PekerjaanPesananTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		PekerjaanPesananTool.klikButtonLanjutTabDetailBarang(getWebDriver());
		
		detail.tab="biaya lain";
		PekerjaanPesananParam lainnya = new PekerjaanPesananParam();
		lainnya.search = "Beban Listrik";
		PekerjaanPesananTool.isiBiayaLain(getWebDriver(), lainnya);
		//lainnya.tglbiaya="01012015";
		lainnya.jumlah="5000";
		PekerjaanPesananTool.detailBiayaLain(getWebDriver(), lainnya);
		PekerjaanPesananTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		PekerjaanPesananTool.klikButtonLanjutTabDetailBiaya(getWebDriver());
//		WaitTool.waitForElementDisapear(getWebDriver(), By.xpath("//*[contains(@id,'detail-expense')]//*[@name='btnNext']"), 5);
		
		PekerjaanPesananParam keterangan = new PekerjaanPesananParam();
		keterangan.tab = "info lainnya";
		keterangan.keterangan = "pekerjaanpesananTC";
		PekerjaanPesananTool.isiInfoLain(getWebDriver(), keterangan);
		PekerjaanPesananTool.saveInfoLainnya(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
        GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);	
        NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
	}
		
	@Test(dependsOnMethods = { "createjobcosting" })
	public void editJobCosting()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN, "pekerjaanpesananTC");
		
		PekerjaanPesananParam detail = new PekerjaanPesananParam();
		detail.search = "Tempe";
		PekerjaanPesananTool.isiDetailBarang(getWebDriver(), detail);
		detail.tab = "detail barang";
		detail.tglpenambahan="01012015";
		detail.kuantitas = "8";
		PekerjaanPesananTool.detailBarang(getWebDriver(), detail);		
		PekerjaanPesananTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		PekerjaanPesananTool.klikButtonLanjutTabDetailBarang(getWebDriver());
		
		detail.tab="biaya lain";
		PekerjaanPesananParam lainnya = new PekerjaanPesananParam();
		lainnya.search = "Diskon Penjualan IDR";
		PekerjaanPesananTool.isiBiayaLain(getWebDriver(), lainnya);
		lainnya.tglbiaya="01012015";
		lainnya.jumlah="9000";
		PekerjaanPesananTool.detailBiayaLain(getWebDriver(), lainnya);
		PekerjaanPesananTool.saveDetailBiayaLain(getWebDriver(), TARGET_FILE);
		PekerjaanPesananTool.klikButtonLanjutTabDetailBiaya(getWebDriver());
//		WaitTool.waitForElementDisapear(getWebDriver(), By.xpath("//*[contains(@id,'detail-expense')]//*[@name='btnNext']"), 5);
		
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
	}
	
	@Test(dependsOnMethods = { "editJobCosting" })
	public void cekNavJC() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN, "pekerjaanpesananTC");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		//NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		//NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
	}
	
	@Test(dependsOnMethods = { "cekNavJC" })
	public void hapusjobCosting()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN, "pekerjaanpesananTC");		
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
	}
	
	@Test(dependsOnMethods = { "hapusjobCosting" })
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
