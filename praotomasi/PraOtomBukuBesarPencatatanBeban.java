package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pencatatanbeban.PencatatanBebanParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PencatatanBebanTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomBukuBesarPencatatanBeban extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomBukuBesarPencatatanBeban.class);

	private String TARGET_FILE = "PraOtomasi Buku Besar - Pencatatan Beban.txt";

	@Test()
	public void buatPencatatanBeban()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);

		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		
		PencatatanBebanParam param = new PencatatanBebanParam();
		
		param.tab = "Header";
		param.hutangbeban = "PPN Keluaran";
		param.nobeban = "Beban.01";
		param.tanggal = "03032015";
//		param.jatuhtempo = "03042015";
		PencatatanBebanTool.isiHeader(getWebDriver(), param);
		PencatatanBebanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.search = "Beban Iklan";
		PencatatanBebanTool.isiRincian(getWebDriver(), param);
		param.tab = "Rincian Beban";
		param.nilai = "1000";
//		param.departemen = "Dept 1";
		PencatatanBebanTool.detailRincianBeban(getWebDriver(), param);
		param.tab = "Catatan";
		param.catatan = "Catatan";
		param.departemen = "Dept 1";
		PencatatanBebanTool.detailRincianBeban(getWebDriver(), param);
		PencatatanBebanTool.saveRincianBeban(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//*[contains(@id, 'detail-expense-accrual')]");
		
		param.tab = "Info Lainnya";
		param.catatan = "Catatan";
		param.jatuhtempo = "03042015";
		PencatatanBebanTool.isiInfoLain(getWebDriver(), param);
		PencatatanBebanTool.saveInfoLainnya(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
	}
	
	@Test(dependsOnMethods = { "buatPencatatanBeban" })
	public void editPencatatanBeban()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENCATATAN_BEBAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENCATATAN_BEBAN, "Beban.01");

		PencatatanBebanParam param = new PencatatanBebanParam();
		
		param.tab = "Header";
		param.hutangbeban = "PPN Keluaran";
		param.nobeban = "Beban.01Beban.01Beban.01Beban.01Beban.01Beban.01Beban.01Beban.01Beban.01Beban.01";
		PencatatanBebanTool.isiHeader(getWebDriver(), param);
		PencatatanBebanTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PENCATATAN_BEBAN, "Beban Iklan");
		param.tab = "Rincian Beban";
		param.nilai = "99999999999999";
//		param.departemen = "Dept 1";
		PencatatanBebanTool.detailRincianBeban(getWebDriver(), param);
		param.tab = "Catatan";
		param.departemen = "Dept 1";
		param.catatan = "Catatan Beban Catatan Beban Catatan Beban Catatan Beban Catatan Beban Catatan Beban Catatan Beban"
				+ "Catatan BebanCatatan Beban Catatan Beban Catatan Beban Catatan Beban Catatan Beban Catatan Beban ";
		PencatatanBebanTool.detailRincianBeban(getWebDriver(), param);
		PencatatanBebanTool.saveRincianBeban(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//*[contains(@id, 'detail-expense-accrual')]");
		
		param.tab = "Info Lainnya";
		param.catatan = "Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya "
				+ "Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya "
				+ "Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya "
				+ "Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya "
				+ "Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya "
				+ "Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya Catatan Lainnya ";
		PencatatanBebanTool.isiInfoLain(getWebDriver(), param);
		PencatatanBebanTool.saveInfoLainnya(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
	}
	
	@Test(dependsOnMethods = { "editPencatatanBeban" })
	public void hapusPencatatanBeban() throws AWTException 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENCATATAN_BEBAN, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.PENCATATAN_BEBAN, "Beban.01Beban.01Beban.01Beban.01Beban.01Beban.01Be");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENCATATAN_BEBAN, "Beban.01Beban.01Beban.01Beban.01Beban.01Beban.01Be");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		//NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		//NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		WaitTool.delay(100);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENCATATAN_BEBAN);
	}
	
	
	@Test(dependsOnMethods = { "hapusPencatatanBeban" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
