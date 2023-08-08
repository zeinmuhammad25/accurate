package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.returpenjualan.ReturPenjualanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.accurate.tool.ReturPenjualanTool;

public class PraOtomPenjualanRetur extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPenjualanRetur.class);
	
	private String TARGET_FILE = "PraOtomasi Penjualan - Retur Penjualan.txt";
	
	@Test()
	public void buatSRT()
	{
		//hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
		
		ReturPenjualanParam param = new ReturPenjualanParam();
		NavigationTool.klikButtonPensil(getWebDriver(),AccurateModule.RETUR_PENJUALAN);
		param.noretur = "PR-0123456789 PR-0123456789 PR";
		param.pelanggan = "ABC";
		param.tanggal = "01042022";
		param.tiperetur = "Tanpa Faktur";
		ReturPenjualanTool.isiForm(getWebDriver(), param);
		ReturPenjualanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.search = "ACCURATE 4 EE";
		ReturPenjualanTool.isiDetailBarang(getWebDriver(), param);
		
		param.tab = "detail barang";
//		param.kuantitas = "1";
		param.harga = "999999999999";
		param.pajak1 = true;
		param.gudang = "Utama";
		ReturPenjualanTool.detailBarang(getWebDriver(), param);
		param.tab = "keterangan";
		param.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ " Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 K"
				+ "eterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan "
				+ "0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ " Keterangan 01234";
		ReturPenjualanTool.detailBarang(getWebDriver(), param);
		ReturPenjualanTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		ReturPenjualanTool.klikLanjutItem(getWebDriver());
		
//		ReturPenjualanTool.klikTabInfoLainnya(getWebDriver());
		param.kenapajak = true;
		param.termasukpajak = true;
		param.alamat = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 012345678";
		param.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 012345678";
		ReturPenjualanTool.isiInfoLain(getWebDriver(), param);
		ReturPenjualanTool.saveIsiDetailInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
//		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "buatSRT" })
	public void cekNavRetur() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.RETUR_PENJUALAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.RETUR_PENJUALAN, "PR-0123456789 PR-0123456789 PR");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "cekNavRetur" })
	public void hapusSRT()
	{
		//hapus PRT
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.RETUR_PENJUALAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.RETUR_PENJUALAN, "PR-0123456789 PR-0123456789 PR");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.RETUR_PENJUALAN);
	}
	
	@Test(dependsOnMethods = { "hapusSRT" })
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
