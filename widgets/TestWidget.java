package com.cpssoft.web.test.accurate.widgets;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualan163;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.WidgetTools;

public class TestWidget extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(FakturPenjualan163.class);
	private static String TARGET_FILE = "Widget.txt";
	
	@Test
	public void menampilkanKeseluruhanWidget(){
		AccTool.deleteTextFile(TARGET_FILE);
			
		WidgetTools.saveAllCardWidgetReady(getWebDriver(), TARGET_FILE);
		log.info("tambah widget 1");
		WidgetParam param = new WidgetParam();
		param.namaWidget= "Aset saat ini";
		WidgetTools.tambahWidget(getWebDriver(), param);
		
		log.info("tambah widget 2");
		WidgetParam param2 = new WidgetParam();
		param2.namaWidget= "Laba Cabang";
		WidgetTools.tambahWidget(getWebDriver(), param2);
		
		log.info("tambah widget 3");
		WidgetParam param3 = new WidgetParam();
		param3.namaWidget= "Barang Stok Minimum";
		WidgetTools.tambahWidget(getWebDriver(), param3);
		
		log.info("tambah widget 4");
		WidgetParam param4 = new WidgetParam();
		param4.namaWidget= "Faktur Terlewat";
		WidgetTools.tambahWidget(getWebDriver(), param4);
		
		log.info("tambah widget 5");
		WidgetParam param5 = new WidgetParam();
		param5.namaWidget= "Keberhasilan Penawaran";
		WidgetTools.tambahWidget(getWebDriver(), param5);
		
		log.info("tambah widget 6");
		WidgetParam param6 = new WidgetParam();
		param6.namaWidget= "Kegiatan Terlewat";
		WidgetTools.tambahWidget(getWebDriver(), param6);
		
		log.info("tambah widget 7");
		WidgetParam param8 = new WidgetParam();
		param8.namaWidget= "Ketersediaan Kas";
		WidgetTools.tambahWidget(getWebDriver(), param8);
		
		log.info("tambah widget 8");
		WidgetParam param9 = new WidgetParam();
		param9.namaWidget= "Pelanggan Berutang";
		WidgetTools.tambahWidget(getWebDriver(), param9);
		
		log.info("tambah widget 9");
		WidgetParam param10 = new WidgetParam();
		param10.namaWidget= "Penawaran Terabaikan";
		WidgetTools.tambahWidget(getWebDriver(), param10);
		
		log.info("tambah widget 10");
		WidgetParam param11 = new WidgetParam();
		param11.namaWidget= "Pengguna Aktif";
		WidgetTools.tambahWidget(getWebDriver(), param11);
		
		log.info("tambah widget 11");
		WidgetParam param12 = new WidgetParam();
		param12.namaWidget= "Penjualan Barang";
		WidgetTools.tambahWidget(getWebDriver(), param12);
		
		log.info("tambah widget 12");
		WidgetParam param13 = new WidgetParam();
		param13.namaWidget= "Penjualan Cabang";
		WidgetTools.tambahWidget(getWebDriver(), param13);
		
		log.info("tambah widget 13");
		WidgetParam param14 = new WidgetParam();
		param14.namaWidget= "Penjualan Pelanggan";
		WidgetTools.tambahWidget(getWebDriver(), param14);
		
		log.info("tambah widget 14");
		WidgetParam param15 = new WidgetParam();
		param15.namaWidget= "Penjualan Per Kategori";
		WidgetTools.tambahWidget(getWebDriver(), param15);
		
		log.info("tambah widget 15");
		WidgetParam param16 = new WidgetParam();
		param16.namaWidget= "Penjualan per Hari";
		WidgetTools.tambahWidget(getWebDriver(), param16);
		
		log.info("tambah widget 16");
		WidgetParam param17 = new WidgetParam();
		param17.namaWidget= "Performa Penjual";
		WidgetTools.tambahWidget(getWebDriver(), param17);
		
		log.info("tambah widget 17");
		WidgetParam param18 = new WidgetParam();
		param18.namaWidget= "Permintaan Barang";
		WidgetTools.tambahWidget(getWebDriver(), param18);
		
		log.info("tambah widget 18");
		WidgetParam param19 = new WidgetParam();
		param19.namaWidget= "Persetujuan Terproses";
		WidgetTools.tambahWidget(getWebDriver(), param19);
		
		log.info("tambah widget 19");
		WidgetParam param20 = new WidgetParam();
		param20.namaWidget= "Pertumbuhan Pelanggan";
		WidgetTools.tambahWidget(getWebDriver(), param20);
		
		log.info("tambah widget 20");
		WidgetParam param21 = new WidgetParam();
		param21.namaWidget= "Pesanan Pembelian";
		WidgetTools.tambahWidget(getWebDriver(), param21);
		
		log.info("tambah widget 21");
		WidgetParam param22 = new WidgetParam();
		param22.namaWidget= "Pesanan Penjualan";
		WidgetTools.tambahWidget(getWebDriver(), param22);
		
		log.info("tambah widget 22");
		WidgetParam param23 = new WidgetParam();
		param23.namaWidget= "Rekonsiliasi Bank";
		WidgetTools.tambahWidget(getWebDriver(), param23);
		
		WidgetTools.saveAllCardWidgetReady(getWebDriver(), TARGET_FILE);
	}
	
		@Test(dependsOnMethods = "menampilkanKeseluruhanWidget")
		public void simpanWidget(){
		
		WidgetTools.saveWidgetAktifitasTerakhir(getWebDriver(), TARGET_FILE);
		
		WidgetTools.saveWidgetKegiatanMendatang(getWebDriver(), TARGET_FILE);
		
		WidgetTools.saveWidgetLabaRugi(getWebDriver(), TARGET_FILE);
		
		WidgetTools.saveWidgetPenjualan(getWebDriver(), TARGET_FILE);
		
		WidgetTools.saveWidgetPembelian(getWebDriver(), TARGET_FILE);
		
		WidgetTools.saveBebanPerusahaan(getWebDriver(), TARGET_FILE);
		
		WidgetTools.saveAsetSaatIni(getWebDriver(), TARGET_FILE);
		}
		
		@Test(dependsOnMethods = "simpanWidget")
		public void hapusWidget(){
		log.info("hapus 1");
		WidgetTools.hapusWidget(getWebDriver(), "Aset saat ini");	
		
		log.info("hapus 2");
		WidgetTools.hapusWidget(getWebDriver(), "Laba Cabang");
		
		log.info("hapus 3");
		WidgetTools.hapusWidget(getWebDriver(), "Barang Stok Minimum");
		
		log.info("hapus 4");
		WidgetTools.hapusWidget(getWebDriver(), "Faktur Terlewat");
		
		log.info("hapus 5");
		WidgetTools.hapusWidget(getWebDriver(), "Keberhasilan Penawaran");
		
		log.info("hapus 6");
		WidgetTools.hapusWidget(getWebDriver(), "Kegiatan Terlewat");
		
		log.info("hapus 7");
		WidgetTools.hapusWidget(getWebDriver(), "Ketersediaan Kas");
		
		log.info("hapus 8");
		WidgetTools.hapusWidget(getWebDriver(), "Pelanggan Berutang");
		
		log.info("hapus 9");
		WidgetTools.hapusWidget(getWebDriver(), "Penawaran Terabaikan");
		
		log.info("hapus 10");
		WidgetTools.hapusWidget(getWebDriver(), "Pengguna Aktif");
		
		log.info("hapus 11");
		WidgetTools.hapusWidget(getWebDriver(), "Penjualan Barang");
		
		log.info("hapus 12");
		WidgetTools.hapusWidget(getWebDriver(), "Penjualan Cabang");
		
		log.info("hapus 13");
		WidgetTools.hapusWidget(getWebDriver(), "Penjualan Pelanggan");
		
		log.info("hapus 14");
		WidgetTools.hapusWidget(getWebDriver(), "Penjualan Per Kategori");
		
		log.info("hapus 15");
		WidgetTools.hapusWidget(getWebDriver(), "Penjualan per Hari");
		
		log.info("hapus 16");
		WidgetTools.hapusWidget(getWebDriver(), "Performa Penjual");
		
		log.info("hapus 17");
		WidgetTools.hapusWidget(getWebDriver(), "Permintaan Barang");
		
		log.info("hapus 18");
		WidgetTools.hapusWidget(getWebDriver(), "Persetujuan Terproses");
		
		log.info("hapus 19");
		WidgetTools.hapusWidget(getWebDriver(), "Pertumbuhan Pelanggan");
		
		log.info("hapus 20");
		WidgetTools.hapusWidget(getWebDriver(), "Pesanan Pembelian");
		
		log.info("hapus 21");
		WidgetTools.hapusWidget(getWebDriver(), "Pesanan Penjualan");
		
		log.info("hapus 22");
		WidgetTools.hapusWidget(getWebDriver(), "Rekonsiliasi Bank");

		WidgetTools.saveAllCardWidgetReady(getWebDriver(), TARGET_FILE);
		
	}
	
	@Test(dependsOnMethods = "hapusWidget")
	public void CompareData() {
		log.info("CompareData");

		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
