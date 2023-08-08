package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pencatatangaji.PencatatanGajiParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PencatatanGajiTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomBukuBesarPencatatanGaji extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomBukuBesarPencatatanGaji.class);

	private String TARGET_FILE = "PraOtomasi Buku Besar - Pencatatan Gaji.txt";

	@Test
	public void buatPencatatanGaji()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
		
		PencatatanGajiParam param = new PencatatanGajiParam();
		
		param.tab = "Header";
		param.tipepembayaran = "Bulanan";
		param.cabang = "Kantor Pusat";
		param.bulan = "Mei";
		param.tahun = "2017";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
		param.no = "Gaji.001";
		param.tanggal = "01062017";
		param.jatuhtempo = "30062017";
		PencatatanGajiTool.isiHeader(getWebDriver(), param);
//		PencatatanGajiTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		
		param.searchhutangbeban = "PPN Keluaran";
		param.catatan = "Catatan";
		PencatatanGajiTool.isiInfoLain(getWebDriver(), param);
//		PencatatanGajiTool.saveInfoLainnya(getWebDriver(), TARGET_FILE);
		
		param.search = "Brad Pitt";
		PencatatanGajiTool.searchKaryawan(getWebDriver(), param);
		
		param.tab = "rincian gaji";
//		param.tunjanganpensiun = "500";
		param.gajipokok = "15000000";
//		param.tunjanganpph = "";
//		param.tunjanganjabatan = "1500000";
//		param.tunjanganmakan = "1500000";
//		param.tunjangantransportasi = "1500000";
//		param.tunjangantelekomunikasi = "1500000";
//		param.tunjanganlembur = "1500000";
//		param.tunjanganpremiasuransi = "1500000";
//		param.potongangaji = "";
//		param.iuranbulanan = "";
//		param.iuranpensiun = "";
//		param.pengurangangaji = "";
		PencatatanGajiTool.isiRincianKaryawan(getWebDriver(), param);
//		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-employee-payment')]//button[@name='btnPphAllowance']");
//		PencatatanGajiTool.saveIsiRincianKaryawan(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//*[contains(@id, 'detail-employee-payment')]");
//		PencatatanGajiTool.saveListRincianGaji(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
	}
	
	@Test(dependsOnMethods = "buatPencatatanGaji")
	public void editPencatatanGaji()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENCATATAN_GAJI, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENCATATAN_GAJI, "Gaji.001");

		PencatatanGajiParam param = new PencatatanGajiParam();

		param.tab = "Header";
		param.no = "GajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGaji";
		PencatatanGajiTool.isiHeader(getWebDriver(), param);
		PencatatanGajiTool.saveHeader(getWebDriver(), TARGET_FILE);
		
		param.searchhutangbeban = "PPN Keluaran";
		param.catatan = "Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 "
				+ "Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 "
				+ "Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 "
				+ "Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 "
				+ "Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 Catatan123456789 ";
		PencatatanGajiTool.isiInfoLain(getWebDriver(), param);
		PencatatanGajiTool.saveInfoLainnya(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PENCATATAN_BEBAN, "Brad Pitt");
		
		param.tab = "rincian gaji";
//		param.tunjanganpensiun = "500";
		param.gajipokok = "99999999999999";
//		param.tunjanganpph = "";
//		param.tunjanganjabatan = "1500000";
//		param.tunjanganmakan = "1500000";
//		param.tunjangantransportasi = "1500000";
//		param.tunjangantelekomunikasi = "1500000";
//		param.tunjanganlembur = "1500000";
//		param.tunjanganpremiasuransi = "1500000";
//		param.potongangaji = "";
//		param.iuranbulanan = "";
//		param.iuranpensiun = "";
//		param.pengurangangaji = "";
		PencatatanGajiTool.isiRincianKaryawan(getWebDriver(), param);
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-employee-payment')]//button[@name='btnPphAllowance']");
		PencatatanGajiTool.saveRincianKaryawan(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//*[contains(@id, 'detail-employee-payment')]");
		PencatatanGajiTool.saveListRincianGaji(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
	}
	
	@Test(dependsOnMethods = "editPencatatanGaji")
	public void hapusPencatatanGaji() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PENCATATAN_GAJI, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PENCATATAN_GAJI, "GajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGajiGaji");
		WaitTool.delay(100);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PENCATATAN_GAJI);
	}
	
	
	@Test(dependsOnMethods = "hapusPencatatanGaji")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
