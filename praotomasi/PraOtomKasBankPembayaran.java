package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pembayaran.PembayaranParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PembayaranTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomKasBankPembayaran extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomKasBankPembayaran.class);
	
	private String TARGET_FILE = "PraOtomasi Kas Bank - Pembayaran.txt";

	@Test()
	public void buatPembayaran() {
		// hapus target lama
		Log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		Log.info("Buat Pembayaran");
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMBAYARAN);

		PembayaranParam param = new PembayaranParam();

		param.tab = "Header";
		param.kasbank = "Kas Kecil";
//		param.nocek = "Cek.001";
//		param.tglcek = "30012015";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.PEMBAYARAN);
		param.no = "OP-01";
		param.tanggal = "30012015";
		PembayaranTool.isiForm(getWebDriver(), param);
		PembayaranTool.saveHeader(getWebDriver(), TARGET_FILE);

		param.search = "Persediaan";
		PembayaranTool.isiDetail(getWebDriver(), param);

		param.tab = "rincian pembayaran";
		param.nilai = "1000";
//		param.departemen = "Dept 1";
		PembayaranTool.detailPembayaran(getWebDriver(), param);

		param.tab = "catatan";
		param.catatan = "when if you say goodbye today";
		PembayaranTool.detailPembayaran(getWebDriver(), param);
		PembayaranTool.saveDetail(getWebDriver(), TARGET_FILE);
		PembayaranTool.klikBtnLanjutPembayaran(getWebDriver());
		PembayaranTool.saveListDetailPembayaran(getWebDriver(), TARGET_FILE);

		AccTool.click(getWebDriver(), "//a[contains(@href,'#tab-otherheader')]");
		param.catatan = "One Little Panda";
		param.penerima = "Twenty One Pilots";
		param.nocek = "Cek.001";
		param.tglcek = "30012015";
		PembayaranTool.isiInfoLain(getWebDriver(), param);
		PembayaranTool.saveInfoLain(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PEMBAYARAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMBAYARAN);
	}
	
	@Test(dependsOnMethods = { "buatPembayaran" })
	public void editPembayaran()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMBAYARAN);
		NavigationTool.klikTutupTabData( getWebDriver(), AccurateModule.PEMBAYARAN, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PEMBAYARAN, "One Little Panda" );

		PembayaranParam param = new PembayaranParam();

		param.tab = "Header";
		param.kasbank = "Kas Kecil";
//		param.nocek = "The Little Mermaid dwells in an underwater kingdom with her father (th"
//				+ "e sea king or mer-king), her grandmother, and her five sisters";
//		param.tglcek = "30012015";
		param.no = "The Little Mermaid dwells in an underwater kingdom with her father (the sea ki"
				+ "ng or mer-king), her grandmother, and her five sisters";
		param.tanggal = "30012015";
		PembayaranTool.isiForm(getWebDriver(), param);
		PembayaranTool.saveHeader(getWebDriver(), TARGET_FILE);

		NavigationTool.klikListGridDetailForm(getWebDriver(), AccurateModule.PEMBAYARAN, "Persediaan");

		param.tab = "rincian pembayaran";
		param.nilai = "9999999999999999999999";
//		param.departemen = "Dept 1";
		PembayaranTool.detailPembayaran(getWebDriver(), param);

		param.tab = "catatan";
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the"
				+ " sea king or mer-king), her grandmother, and her five sisters. Her five siste"
				+ "rs are each born one year apart. When a mermaid turns 15, she is permitted to"
				+ " swim to the surface to watch the world above, and when the sisters become old"
				+ " enough, each of them visits the upper world every year. As each of them retur"
				+ "ns, the Little Mermaid listens longingly to their various descriptions of the "
				+ "surface and of human beings.";
		PembayaranTool.detailPembayaran(getWebDriver(), param);
		PembayaranTool.saveDetail(getWebDriver(), TARGET_FILE);
		PembayaranTool.klikBtnLanjutPembayaran(getWebDriver());
		PembayaranTool.saveListDetailPembayaran(getWebDriver(), TARGET_FILE);

		AccTool.click(getWebDriver(), "//a[contains(@href,'#tab-otherheader')]");
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the s"
				+ "ea king or mer-king), her grandmother, and her five sisters. Her five sisters a"
				+ "re each born one year apart. When a mermaid turns 15, she is permitted to swim "
				+ "to the surface to watch the world above, and when the sisters become old enoug"
				+ "h, each of them visits the upper world every year. As each of them returns, the"
				+ " Little Mermaid listens longingly to their various descriptions of the surface a"
				+ "nd of human beings.";
		param.penerima = "The Little Mermaid dwells in an underwater kingdom with her father (the "
				+ "sea king or mer-king), her grandmother, and her five sisters. Her five sisters "
				+ "are each born one year apart. When a mermaid turns 15, she is permitted to swim "
				+ "to the surface to watch the world above, and when the sisters become old enough, "
				+ "each of them visits the upper world every year. As each of them returns, the Littl"
				+ "e Mermaid listens longingly to their various descriptions of the surface and of hu"
				+ "man beings.";
		param.nocek = "The Little Mermaid dwells in an underwater kingdom with her father (th"
				+ "e sea king or mer-king), her grandmother, and her five sisters";
		param.tglcek = "30012015";
		param.cbvoid = true;
		param.cabang = "Cabang1";
		PembayaranTool.isiInfoLain(getWebDriver(), param);
		PembayaranTool.saveInfoLain(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PEMBAYARAN);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMBAYARAN);
	}
	
	@Test(dependsOnMethods = { "editPembayaran" })
	public void hapusPembayaran() throws AWTException
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEMBAYARAN);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.PEMBAYARAN, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.PEMBAYARAN);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.PEMBAYARAN, "The Little Mermaid dwells in an underwater kingdom");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.PEMBAYARAN, "The Little Mermaid dwells in an underwater kingdom");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.PEMBAYARAN);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		//NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.PEMBAYARAN);
		//NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.PEMBAYARAN);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.PEMBAYARAN);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.PEMBAYARAN);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEMBAYARAN);
	}

	@Test(dependsOnMethods = { "hapusPembayaran" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
