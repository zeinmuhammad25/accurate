package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.preferensi.PreferensiParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PreferensiTool;

public class PraOtomPreferensiPembatasan extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPreferensiPembatasan.class);

	private String TARGET_FILE = "PraOtomasi Preferensi - Pembatasan.txt";

	@Test
	public void isiPembatasan() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		//berdasarrentangwaktu
		//peringati
		param.dasarrangewaktu = true;
		param.cbwarnrangewaktu = true;
		param.warnangkafromrange = "3";
		param.warnrangefromperiod = "Bulan";
		param.warnangkatorange = "5";
		param.warnrangetoperiod = "Bulan";
		//cegah
		param.cberrorperiod = false;
//		param.errorangkafrom = "333";
//		param.errorfromperiod = "Hari";
//		param.errorangkatorange = "555";
//		param.errortoperiod = "Hari";
		
		PreferensiTool.isiPembatasan(getWebDriver(), param);
		PreferensiTool.saveIsiPembatasan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = "isiPembatasan")
	public void editPembatasan1() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
		// Berdasarkan tanggal tertentu
		param.dasarspesifiktgl = true;
				// Peringati Jika
		param.cbwarnspecificdate = true;
		param.warntglsebelumspesifik = "02022015";
		param.warntglsesudahspesifik ="28022015";
				// Cegah Jika
		param.cberrorspecificdate = true;
		param.errortglsebelumspesifik = "03032015";
		param.errortglsesudahspesifik = "30032015";
		
		param.returfakturlunas = true;
		param.returtagihanlunas = true;
		
		PreferensiTool.isiPembatasan(getWebDriver(), param);
		PreferensiTool.saveIsiPembatasan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = "editPembatasan1")
	public void editPembatasan() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PREFERENSI);
		PreferensiParam param = new PreferensiParam();
	
		param.tidakdibatasi = true;
		param.returfakturlunas = false;
		param.returtagihanlunas = false;
		
		PreferensiTool.isiPembatasan(getWebDriver(), param);
		PreferensiTool.saveIsiPembatasan(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanBawah(getWebDriver(), AccurateModule.PREFERENSI);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	}
	
	@Test(dependsOnMethods = "editPembatasan")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
