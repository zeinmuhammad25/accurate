package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.barangpergudang.BarangPerGudangParam;
import com.cpssoft.web.test.accurate.gudang.GudangParam;
import com.cpssoft.web.test.accurate.stokbarangpergudang.StokBarangPerGudangParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.BarangJasaTool;
import com.cpssoft.web.test.accurate.tool.BarangPerGudangTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.GudangTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
public class PraOtomPersediaanStokBarangPerGudang extends AbstractAccurateTestCase {
	static Logger log = LogManager
			.getLogger(PraOtomPersediaanStokBarangPerGudang.class);

	private String TARGET_FILE = "PraOtomasi Persediaan - Stok Barang Per Gudang.txt";

	@Test
	public void isiGudang() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GUDANG);
		GudangParam param = new GudangParam();		
		param.nama = "Coba";
		GudangTool.isiForm(getWebDriver(), param);
		GudangTool.SaveData(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.GUDANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		param.nama = "Baru";
		GudangTool.isiForm(getWebDriver(), param);
		GudangTool.SaveData(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.GUDANG);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GUDANG);
	}
	
	@Test(dependsOnMethods = "isiGudang")
	public void isiBarangJasa() 
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		BarangJasaParam param = new BarangJasaParam();
		
		param.namabarang = "Item 1";
		param.jenisitem = "Persediaan";
		BarangJasaTool.isiUmum(getWebDriver(), param);
		BarangJasaTool.saveIsiUmum(getWebDriver(), TARGET_FILE);
		
		//tab saldo
		BarangJasaTool.isiSaldo(getWebDriver());
		NavigationTool.tambahSaldoBarang(getWebDriver(), AccurateModule.BARANG_JASA);
		BarangJasaParam saldo  = new BarangJasaParam();
		saldo.gudangsaldo = "Utama";
		saldo.tanggalsaldo = "01032015";
		saldo.kuantitassaldo = "5";
		saldo.biayasatuan = "2000";
		BarangJasaTool.detailSaldo(getWebDriver(), saldo);
		BarangJasaTool.saveDetailSaldo(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-open-balance')]");
		
		//tab saldo
		NavigationTool.tambahSaldoBarang(getWebDriver(), AccurateModule.BARANG_JASA);
		saldo.gudangsaldo = "Coba";
		saldo.tanggalsaldo = "02032015";
		saldo.kuantitassaldo = "6";
		saldo.biayasatuan = "3000";
		BarangJasaTool.detailSaldo(getWebDriver(), saldo);
		BarangJasaTool.saveDetailSaldo(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-open-balance')]");
		
		//tab saldo
		NavigationTool.tambahSaldoBarang(getWebDriver(), AccurateModule.BARANG_JASA);
		saldo.gudangsaldo = "Baru";
		saldo.tanggalsaldo = "03032015";
		saldo.kuantitassaldo = "7";
		saldo.biayasatuan = "4000";
		BarangJasaTool.detailSaldo(getWebDriver(), saldo);
		BarangJasaTool.saveDetailSaldo(getWebDriver(), TARGET_FILE);
		NavigationTool.klikButtonLanjut(getWebDriver(), "//div[starts-with(@id,'detail-open-balance')]");

		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.BARANG_JASA);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = "isiBarangJasa")
	public void barangPerGudang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_PER_GUDANG);
		
		BarangPerGudangParam param = new BarangPerGudangParam();
		param.sortby = "Barang";
		param.search = "Item 1";
		param.daritanggal = "01012015";
		param.sampaitanggal = "30122015";
		BarangPerGudangTool.isiForm(getWebDriver(), param);
		NavigationTool.klikPerbaruiData(getWebDriver(), AccurateModule.BARANG_PER_GUDANG);
		BarangPerGudangTool.saveList( getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_PER_GUDANG);	
	}

	@Test(dependsOnMethods = "barangPerGudang")
	public void hapusBarangJasa()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.BARANG_JASA, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.BARANG_JASA, "Item 1");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.BARANG_JASA);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BARANG_JASA);
	}
	
	@Test(dependsOnMethods = "hapusBarangJasa")
	public void hapusGudang()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.GUDANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.GUDANG, "Coba");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GUDANG);
	}
	
	@Test(dependsOnMethods = "hapusGudang")
	public void hapusGudang2()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.GUDANG, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.GUDANG, "Baru");
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.GUDANG);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.GUDANG);
	}
	
	@Test(dependsOnMethods = "hapusGudang2")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
