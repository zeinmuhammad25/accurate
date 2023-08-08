package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.returpembelian.ReturPembelianParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
//import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.accurate.tool.ReturPembelianTool;

public class PraOtomPembelianRetur extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomPembelianRetur.class);
	
	private String TARGET_FILE = "PraOtomasi Pembelian - Retur Pembelian.txt";
	
	@Test()
	public void buatPRT()
	{
		//hapus target lama
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		
		ReturPembelianParam param = new ReturPembelianParam();
		
		NavigationTool.klikButtonPensil(getWebDriver(),AccurateModule.RETUR_PEMBELIAN);
		param.noretur = "PR-0123456789 PR-0123456789 PR";
		param.pemasok = "Vendor-Dimas";
		param.tanggal = "01042022";
		param.tiperetur = "Tanpa Faktur";
		ReturPembelianTool.isiForm(getWebDriver(), param);
		ReturPembelianTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.search = "ACCURATE 4 DE";
		ReturPembelianTool.isiDetailBarang(getWebDriver(), param);
		
		param.tab = "detail barang";
//		param.kuantitas = "1";
		param.harga = "999999999999";
		param.pajak1 = true;
		param.gudang = "Utama";
		ReturPembelianTool.detailBarang(getWebDriver(), param);
		param.tab = "keterangan";
		param.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ " Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 K"
				+ "eterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan "
				+ "0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789"
				+ " Keterangan 01234";
		ReturPembelianTool.detailBarang(getWebDriver(), param);
		ReturPembelianTool.saveDetailBarang(getWebDriver(), TARGET_FILE);
		ReturPembelianTool.klikBtnLanjutReturPembelian(getWebDriver());
				
		ReturPembelianTool.klikTabInfoLainnya(getWebDriver());
		param.kenapajak = true;
		param.termasukpajak = true;
		param.alamat = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 012345678";
		param.keterangan = "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 "
				+ "Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan 0123456789 Keterangan"
				+ " 0123456789 Keterangan 0123456789 Keterangan 012345678";
		ReturPembelianTool.isiInfoLain(getWebDriver(), param);
		ReturPembelianTool.saveIsiDetailInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);		
		NavigationTool.klikIndikatorLanjutkan(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "buatPRT" })
	public void cekNavPRT() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.RETUR_PEMBELIAN, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.RETUR_PEMBELIAN, "PR-0123456789 PR-0123456789 PR");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "cekNavPRT" })
	public void hapusPRT()
	{
		//hapus PRT
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.RETUR_PEMBELIAN, "Data Baru");
		NavigationTool.klikListData(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.RETUR_PEMBELIAN, "PR-0123456789 PR-0123456789 PR");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.RETUR_PEMBELIAN);
	}
	
	@Test(dependsOnMethods = { "hapusPRT" })
	public void executeFinal() 
	{
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
