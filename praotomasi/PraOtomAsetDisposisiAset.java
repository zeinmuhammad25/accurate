package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

//import javax.swing.text.NavigationFilter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.asettetap.AsetTetapParam;
import com.cpssoft.web.test.accurate.disposisiasettetap.DisposisiAsetTetapParam;
import com.cpssoft.web.test.accurate.kategoriaset.KategoriAsetParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.AsetTetapTool;
import com.cpssoft.web.test.accurate.tool.DisposisiAsetTetapTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriAsetTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomAsetDisposisiAset extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomAsetDisposisiAset.class);

	private String TARGET_FILE = "PraOtomasi Aset Tetap - Disposisi Aset.txt";

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
	public void buatAsetBaru() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);

		// Buat Data Baru
		log.info("Buat data");
		AsetTetapParam param = new AsetTetapParam();
		param.keterangan = "Kendaraan";
		param.tanggalbeli = "01012013";
		param.tanggalpakai = "01012013";
		param.penomoran = "KD1";
		String w = AccurateModule.ASET_TETAP.getXpath();
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.ASET_TETAP);
		AsetTetapTool.isi(getWebDriver(), param);

		param.kuantitas = "5";
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
		//log.info("simpan list cabang");
		NavigationTool.cariList(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "Kendaraan");
		AsetTetapTool.saveIsiHeader(getWebDriver(), TARGET_FILE);
		AsetTetapTool.saveAll(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ASET_TETAP);
	}

	@Test(dependsOnMethods = "buatAsetBaru")
	public void Disposisi() {
		log.info("disposisi aset");

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		DisposisiAsetTetapParam param = new DisposisiAsetTetapParam();
		String w = AccurateModule.DISPOSISI_ASET_TETAP.getXpath();
		param.aset = "Kendaraan";
		param.tanggal = "01012013";
		param.penomoran = "kendaraan1";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		DisposisiAsetTetapTool.isi(getWebDriver(), param);
		DisposisiAsetTetapTool.saveIsiHeader(getWebDriver(), TARGET_FILE);

		param.kuantitas = "99999999999999999";
		param.akunlabarugi = "Beban Penyusutan Kendaraan";
		param.lokasiaset = "Kantor Pusat";
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns "
				+ "15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		param.cbasetdijual = false;
		DisposisiAsetTetapTool.isiInfoUmum(getWebDriver(), param);
		DisposisiAsetTetapTool.saveIsiInfoUmum(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikIndikatorEdit(getWebDriver());
		
		//edit qty jadi 1
		//NavigationTool.klikTutupTabDataPalingKiri(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP, "Data Baru");
		AccTool.click(getWebDriver(), w + "//a[@title='Informasi umum']");
		DisposisiAsetTetapParam param2 = new DisposisiAsetTetapParam();
		param2.kuantitas = "1";
		DisposisiAsetTetapTool.isiInfoUmum(getWebDriver(), param2);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
	}
	
	@Test(dependsOnMethods = "Disposisi")
	public void Disposisi2() {
		log.info("disposisi aset");

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		DisposisiAsetTetapParam param = new DisposisiAsetTetapParam();
		String w = AccurateModule.DISPOSISI_ASET_TETAP.getXpath();
		param.aset = "Kendaraan";
		param.tanggal = "01012013";
		param.penomoran = "kendaraan2";
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		DisposisiAsetTetapTool.isi(getWebDriver(), param);
		DisposisiAsetTetapTool.saveIsiHeader(getWebDriver(), TARGET_FILE);

		param.akunlabarugi = "Beban Penyusutan Kendaraan";
		param.lokasiaset = "Kantor Pusat";
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns "
				+ "15, she is permitted to swim to the surface to watch the world above, and when the sisters become old enough,"
				+ " each of them visits the upper world every year. As each of them returns, the Little Mermaid listens longingly"
				+ " to their various descriptions of the surface and of human beings.";
		param.cbasetdijual = true;
		param.harga = "5000000";
		param.akun = "Kas Kecil";
		DisposisiAsetTetapTool.isiInfoUmum(getWebDriver(), param);
		DisposisiAsetTetapTool.saveIsiInfoUmum(getWebDriver(), TARGET_FILE);

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
	}
	
	@Test(dependsOnMethods = "Disposisi2")
	public void hapusData() throws AWTException {
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP, "kendaraan2");
		
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		WaitTool.checkPageIsReady(getWebDriver());
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikPerbaruiData(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP, "kendaraan1");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DISPOSISI_ASET_TETAP);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.ASET_TETAP, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.ASET_TETAP, "KD1");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.ASET_TETAP);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.ASET_TETAP);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KATEGORI_ASET);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_ASET, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KATEGORI_ASET, "Coba");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.KATEGORI_ASET);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KATEGORI_ASET);
	}

	@Test(dependsOnMethods = "hapusData")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
