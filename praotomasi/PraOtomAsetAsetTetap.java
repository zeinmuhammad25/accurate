package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.asettetap.AsetTetapParam;
import com.cpssoft.web.test.accurate.kategoriaset.KategoriAsetParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AsetTetapTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriAsetTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;

public class PraOtomAsetAsetTetap extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomAsetAsetTetap.class);

	private String TARGET_FILE = "PraOtomasi Aset - Aset Tetap.txt";

	@Test()
	public void buatKategoriAset()
	{
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_ASET);
		KategoriAsetParam aset = new KategoriAsetParam();
		
		aset.nama = "Coba";
		KategoriAsetTool.isi(getWebDriver(), aset);
		KategoriAsetTool.saveIsi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KATEGORI_ASET);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
	    NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET);
	}
	
	@Test(dependsOnMethods = "buatKategoriAset")
	public void buatBaru() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);

		// Buat Data Baru
		log.info("Buat data");
		AsetTetapParam param = new AsetTetapParam();
		param.penomoran = "KD1";
		param.keterangan = "Kendaraan";
		param.tanggalbeli = "01012013";
		param.tanggalpakai = "01012013";
		String w = AccurateModule.ASET_TETAP.getXpath();
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.ASET_TETAP);
		AsetTetapTool.isi(getWebDriver(), param);

		param.kuantitas = "1";
		param.umurasettahun = "4";
		param.metodepenyusutan = "Metode Garis Lurus";
		param.akunaset = "Kendaraan";
		param.akunakumulasipenyusutan = "Akumulasi Penyusutan Kendaraan";
		param.akunbebanpenyusutan = "beban penyusutan kendaraan";
		AsetTetapTool.isiInfoUmum(getWebDriver(), param);
		AsetTetapTool.saveIsiInformasiUmum(getWebDriver(), TARGET_FILE);

		param.kategoriaset = "Coba";
		AsetTetapTool.isiInfoLain(getWebDriver(), param);
		AsetTetapTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);

		 param.searchakun = "Perlengkapan Kantor";
		 AsetTetapTool.isiAkun(getWebDriver(), param);
		 param.tab = "pengeluaran";
		 param.jumlah="22555666";
		 AsetTetapTool.detailAkun(getWebDriver(), param);
		 NavigationTool.klikButtonLanjut(getWebDriver(),
		 "//div[starts-with(@id,'detail-expenditure')]");
		 AccTool.click(getWebDriver(),"//*[contains(@id,'detail-expenditure-grid-list')]//div[@class='grid-canvas']/div[1]");
		 AccTool.click(getWebDriver(),"//*[contains(@id,'detail-expenditure')]//*[text()='Lanjut']");
		 AsetTetapTool.saveListPengeluaran(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.ASET_TETAP);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, "Data Baru");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.ASET_TETAP, TARGET_FILE);
		log.info("simpan list cabang");
		NavigationTool.cariList(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		AsetTetapTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		AsetTetapTool.saveAll(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ASET_TETAP);

	}

	@Test(dependsOnMethods = "buatBaru")
	public void editAset() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");

		// Buat Data Baru
		log.info("edit  data");
		AsetTetapParam param = new AsetTetapParam();
		// param.keterangan = "Kendaraan";
		param.tanggalbeli = "02022015";
		param.tanggalpakai = "02022015";
		param.penomoran = "AsetTetap01AsetTetap01AsetTetap01AsetTetap01AsetTetap01AsetTetap01AsetTetap01";
		AsetTetapTool.isi(getWebDriver(), param);

		param.cbasettidakberwujud = true;
		param.kuantitas = "99999999999999999";
		param.metodepenyusutan = "Tidak Terdepresiasi";
		param.akunaset = "Kendaraan";

		AsetTetapTool.isiInfoUmum(getWebDriver(), param);
		AsetTetapTool.saveIsiInformasiUmum(getWebDriver(), TARGET_FILE);

		param.kategoriaset = "Coba";
		param.departemen = "Dept 1";
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns "
				+ "15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		AsetTetapTool.isiInfoLain(getWebDriver(), param);
		AsetTetapTool.saveIsiInfoLain(getWebDriver(), TARGET_FILE);

		
		param.searchakun = "Asuransi Dibayar Dimuka";
		AsetTetapTool.isiAkun(getWebDriver(), param);

		param.tab = "pengeluaran";
		param.jumlah = "9999999999999999999";
		AsetTetapTool.detailAkun(getWebDriver(), param);
		param.tab = "catatan";
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns "
				+ "15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		AsetTetapTool.detailAkun(getWebDriver(), param);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-expenditure')]");
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-expenditure-grid-list')]//div[@class='grid-canvas']/div[1]");
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-expenditure')]//*[text()='Lanjut']");
		AsetTetapTool.saveListPengeluaran(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.ASET_TETAP);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.ASET_TETAP, TARGET_FILE);
		log.info("simpan list cabang");
		NavigationTool.cariList(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		AsetTetapTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		AsetTetapTool.saveAll(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ASET_TETAP);
	}
	
	@Test(dependsOnMethods = { "editAset" })
	public void cekNavAsetTetap() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, "Data Baru");

		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
	
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ASET_TETAP);
	}

	@Test(dependsOnMethods = "cekNavAsetTetap")
	public void hapusAset() {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);
		log.info("Hapus Aset");
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, "Data Baru");
		NavigationTool.klikPerbaruiData(getWebDriver(), AccurateModule.ASET_TETAP);
		//String tabJurnal = AccTool.getTextValue(getWebDriver(), AccurateModule.ASET_TETAP, ElementType.LABEL, "", "");
		//log.info(tabJurnal);
		//NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, tabJurnal.trim());

		NavigationTool.cariList(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.ASET_TETAP);
		//WaitTool.delay(1000);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		//WaitTool.delay(1000);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ASET_TETAP);
	}
	
	@Test(dependsOnMethods = { "hapusAset" })
	public void hapusKategoriAset() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_ASET);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_ASET, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_ASET, "Coba");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_ASET);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET);
	}
	
	@Test(dependsOnMethods = "hapusKategoriAset")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
