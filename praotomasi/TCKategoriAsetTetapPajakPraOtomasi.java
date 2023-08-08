package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategoriasettetappajak.KategoriAsetTetapPajakParam;
import com.cpssoft.web.test.accurate.praotomasi.TCKategoriAsetTetapPajakPraOtomasi;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
//import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KategoriAsetTetapPajakTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class TCKategoriAsetTetapPajakPraOtomasi extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(TCKategoriAsetTetapPajakPraOtomasi.class);

	private String TARGET_FILE = "Aset-KategoriAsetTetapPajak.txt";

	@Test
	public void buatBaru() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(),
				AccurateModule.KATEGORI_ASET_TETAP_PAJAK);

		// Buat Data Baru
		log.info("Buat data baru");
		KategoriAsetTetapPajakParam param = new KategoriAsetTetapPajakParam();
		param.nama = "pajakcb1";
		param.perkiraanumur = "999";		
		param.metodepenyusutan = "Tidak Terdepresiasi";
		KategoriAsetTetapPajakTool.isi(getWebDriver(), param);
		NavigationTool.klikSimpanData(getWebDriver(),AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		log.info("simpan notifikasi");
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK,
				"Data Baru");
		
		NavigationTool.cariList(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK,
				"pajakcb1");
		
		log.info("simpan list ");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, TARGET_FILE);
		log.info("simpan list berhasil");

		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "pajakcb1");

		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		log.info("simpan isi KATEGORI ASET");
		
		param.nama ="pajakcb2";
		param.perkiraanumur = "1";
		param.metodepenyusutan = "Tidak Terdepresiasi";
		KategoriAsetTetapPajakTool.isi(getWebDriver(),param);
		NavigationTool.klikSimpanData(getWebDriver(),AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK,
				"pajakcb2");
		log.info("simpan list ");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, TARGET_FILE);
		log.info("simpan list berhasil");
		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "pajakcb2");
		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		log.info("simpan isi KATEGORI ASET");
		
		param.nama ="pajakcb3";
		param.perkiraanumur = "999";
		param.metodepenyusutan = "Metode Garis Lurus";
		KategoriAsetTetapPajakTool.isi(getWebDriver(),param);
		NavigationTool.klikSimpanData(getWebDriver(),AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK,
				"pajakcb3");
		log.info("simpan list ");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, TARGET_FILE);
		log.info("simpan list berhasil");
		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "pajakcb3");
		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		log.info("simpan isi KATEGORI ASET");
		
		param.nama ="pajakcb4";
		param.perkiraanumur = "1";
		param.metodepenyusutan = "Metode Garis Lurus";
		KategoriAsetTetapPajakTool.isi(getWebDriver(),param);
		NavigationTool.klikSimpanData(getWebDriver(),AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK,
				"pajakcb4");
		log.info("simpan list ");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, TARGET_FILE);
		log.info("simpan list berhasil");
		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "pajakcb4");
		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		log.info("simpan isi KATEGORI ASET");
		
		param.nama ="pajakcb5";
		param.perkiraanumur = "999";
		param.metodepenyusutan = "Metode Saldo Menurun";
		KategoriAsetTetapPajakTool.isi(getWebDriver(),param);
		NavigationTool.klikSimpanData(getWebDriver(),AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK,
				"pajakcb5");
		log.info("simpan list ");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, TARGET_FILE);
		log.info("simpan list berhasil");
		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "pajakcb5");
		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		log.info("simpan isi KATEGORI ASET");
		
		param.nama ="pajakcb6";
		param.perkiraanumur = "1";
		param.metodepenyusutan = "Metode Saldo Menurun";
		KategoriAsetTetapPajakTool.isi(getWebDriver(),param);
		NavigationTool.klikSimpanData(getWebDriver(),AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK,
				"pajakcb6");
		log.info("simpan list ");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, TARGET_FILE);
		log.info("simpan list berhasil");
		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "pajakcb6");
		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		log.info("simpan isi KATEGORI ASET");
		
		param.nama ="pajakcb7";
		param.perkiraanumur = "999";
		param.metodepenyusutan = "Metode Angka Tahun";
		KategoriAsetTetapPajakTool.isi(getWebDriver(),param);
		NavigationTool.klikSimpanData(getWebDriver(),AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK,
				"pajakcb7");
		log.info("simpan list ");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, TARGET_FILE);
		log.info("simpan list berhasil");
		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "pajakcb7");
		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		log.info("simpan isi KATEGORI ASET");
		
		param.nama ="pajakcb8";
		param.perkiraanumur = "1";
		param.metodepenyusutan = "Metode Angka Tahun";
		KategoriAsetTetapPajakTool.isi(getWebDriver(),param);
		NavigationTool.klikSimpanData(getWebDriver(),AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK,
				"pajakcb8");
		log.info("simpan list ");
		GeneralTool.simpanListData(getWebDriver(), AccurateModule.KATEGORI_ASET_TETAP_PAJAK, TARGET_FILE);
		log.info("simpan list berhasil");
		NavigationTool.cariListData(getWebDriver(),
				AccurateModule.KATEGORI_ASET_TETAP_PAJAK, "pajakcb8");
		KategoriAsetTetapPajakTool.saveIsi(getWebDriver(), TARGET_FILE);
		log.info("simpan isi KATEGORI ASET");
		
		param.nama ="Bangunan Permanen";
		param.perkiraanumur = "999";
		param.metodepenyusutan = "Metode Garis Lurus";
		KategoriAsetTetapPajakTool.isi(getWebDriver(),param);
		NavigationTool.klikSimpanData(getWebDriver(),AccurateModule.KATEGORI_ASET_TETAP_PAJAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		
	}
}
