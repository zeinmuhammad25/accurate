package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penerimaanbarang.PenerimaanBarangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PenerimaanBarangTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomPembelianPenerimaanBarang extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPembelianPenerimaanBarang.class);
	
	private String TARGET_FILE = "PraOtomasi Pembelian - Penerimaan Barang.txt";
	
	@Test()
	public void buatRI()
	{
		//hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		
		PenerimaanBarangParam param = new PenerimaanBarangParam();
		param.terimadari = "Vendor-Dimas";
		param.noterima = "NoTerima0123456789123456789123";
		param.tanggal = "28042022";
		PenerimaanBarangTool.isiForm(getWebDriver(), param);
		PenerimaanBarangTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.search = "ACCURATE 4 EE";
		PenerimaanBarangTool.isiDetailBarang(getWebDriver(), param);
		
		param.tab = "detail barang";
		param.nama = "ACCURATE 4 DE 0123456789012345678901234567890123456789012345678901234567890123"
				+ "4567890123456789012345678901234567890123456789012345678901234567890123456789012345"
				+ "67890123456789012345678901234567890123456789012345678901234567890123456789012345";
		param.kuantitas = "999999999999";
		PenerimaanBarangTool.detailBarang(getWebDriver(), param);
		PenerimaanBarangTool.saveDetail(getWebDriver(), TARGET_FILE);
		
		param.tab = "keterangan";
		param.keterangan = "Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan"
				+ " 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 0123456789Keterangan 012345";
		PenerimaanBarangTool.detailBarang(getWebDriver(), param);
		PenerimaanBarangTool.saveDetail(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'detail-item')]");
		AccTool.waitProgressBar(getWebDriver());
		
		PenerimaanBarangTool.klikTabInfoLainnya(getWebDriver());
		PenerimaanBarangParam param3 = new PenerimaanBarangParam();
		param3.tglpengiriman = "28042022";
		param3.pengiriman = "dhl";
		param3.fob = "Shipping Point";
		param3.alamat = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		param3.keterangan = "We recently learned that a third party had obtained access to a set of Tumblr user email addresses with salted and hashed passwords from early 2013, prior to the acquisition of Tumblr by Yahoo. As soon as we became aware of this, our security team thoroughly investigated the matter. Our analysis gives us no reason to believe that this information was used to access Tumblr accounts. As a precaution, however, we will be requiring affected Tumblr users to set a new password.";
		PenerimaanBarangTool.isiInfoLain(getWebDriver(), param3);
		PenerimaanBarangTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "buatRI" })
	public void editRI()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENERIMAAN_BARANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENERIMAAN_BARANG, "NoTerima0123456789123456789123");
		
		PenerimaanBarangParam param = new PenerimaanBarangParam();
		
		param.noterima = "RI-01";
		PenerimaanBarangTool.isiForm(getWebDriver(), param);
		PenerimaanBarangTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PENERIMAAN_BARANG, "ACCURATE 4 DE 0123456789"
				+ "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567"
				+ "89012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345"
				+ "67890123456789012345");
		NavigationTool.hapusListData(getWebDriver(), " //div[contains(@id,'detail-item')]");
		
		param.search = "ACCURATE 4 EE";
		PenerimaanBarangTool.isiDetailBarang(getWebDriver(), param);
		
		param.tab = "detail barang";
		param.kuantitas = "5";
		PenerimaanBarangTool.detailBarang(getWebDriver(), param);
		PenerimaanBarangTool.saveDetail(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), " //div[contains(@id,'detail-item')]");
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "editRI" })
	public void cekNavRI() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENERIMAAN_BARANG, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENERIMAAN_BARANG, "RI-01");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		//NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		//NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "cekNavRI" })
	public void hapusRI()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENERIMAAN_BARANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENERIMAAN_BARANG, "RI-01");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENERIMAAN_BARANG);
	}
	
	@Test(dependsOnMethods = { "hapusRI" })
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
