package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.barangstokminimum.BarangStokMinimumParam;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.pemenuhanpesanan.PemenuhanPesananParam;
import com.cpssoft.web.test.accurate.rancanganformulir.RancanganFormulirParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

	
	public class PemenuhanPesananTool extends AbstractAccurateTestCase {

		static Logger log = LogManager.getLogger(PemenuhanPesananTool.class);

		public static void klikBtnRefresh(WebDriver driver){
			AccTool.click(getWebDriver(), "//*[contains(@name,'btnRefresh')]");
//			WaitTool.delay(500);
//			AccTool.waitLoadingMask(getWebDriver());
		}
		
		public static void klikTutupTabBarangPerluDipesan(WebDriver driver){
//			AccTool.click(getWebDriver(), "//*[button(@class,'btn-close')]");
			String path = "//div[contains(@class,'metro window-overlay')][contains(@style,'z-index')]//button[contains(@class,'btn-close')]";
			AccTool.click(driver, path);
			
//			WaitTool.delay(500);
//			AccTool.waitLoadingMask(getWebDriver());
		}
		
		public static void klikBtnPerluPesan(WebDriver driver) {
			String path = "//div[starts-with(@id,'module-accurate__inventory__backorder-inquiry')]" + "//button[@name='btnReorder']";
			AccTool.click(driver, path);
			AccTool.waitLoadingMask(getWebDriver());
		}
		public static void pilihGudang(WebDriver driver, PemenuhanPesananParam param) {
			log.info("PemenuhanPesanan.PilihGudang");

			String w = "";
//			AccTool.click(driver, AccurateModule.PEMENUHAN_PESANAN.getXpath() + "module-accurate__inventory__backorder-inquiry");

			if (param.pilihgudang != null)
				AccTool.combobox(getWebDriver(), w, "@name='warehouseId'", param.pilihgudang);
		}
		
		public static void pilihCabang(WebDriver driver, PemenuhanPesananParam param) {
			log.info("PemenuhanPesanan.PilihCabang");

			String w = "";
//			AccTool.click(driver, AccurateModule.PEMENUHAN_PESANAN.getXpath() + "module-accurate__inventory__backorder-inquiry");

			if (param.pilihcabang != null)
				AccTool.combobox(getWebDriver(), w, "@name='branchId'", param.pilihcabang);
		}

		public static void isiPemasok(WebDriver driver, PemenuhanPesananParam param) {
			log.info("PemenuhanPesanan.IsiPemasok");

			String w = "//div[contains(@id,'tab-backorder-inquiry-reorder')]";
			
//			AccTool.click(driver,"//a[contains(@id='accurate__inventory__backorder-inquiry-reorder')]");
			
			// String u = "";
			if (param.pilihpemasok != null) {
				AccTool.lookup(driver, w, "@name='vendorId'", param.pilihpemasok);
//				AccTool.waitLoaderMedium(driver);
//				AccTool.waitProgressBar(driver);
			}
		}
			
		
		public static void klikCentangListData1(WebDriver driver) {
			log.info("BarangStokMinimum.KlikCentang");
			AccTool.click(getWebDriver(), "//div[@id='minimum-stock-item-grid-list--10']//div[@class='input-control checkbox']//span['checkbox']");
		
		}
		public static void klikCentangListDataSemua(WebDriver driver) {
			log.info("BarangStokMinimum.KlikCentang");
			AccTool.click(getWebDriver(), "//div[@class='ui-state-default slick-header-column ui-sortable-handle']//div[@class='input-control checkbox no-margin']");
		
		}

		public static void saveListBarangPerluDipesan(WebDriver driver, String filename) {
			log.info("PemenuhanPesanan.SaveListBarangPerluDipesan");
//			String w = "";
			String content = "PemenuhanPesanan.SaveListBarangPerluDipesan : " + "\r\n";
			String tab = "//div[contains(@id,'tab-backorder-inquiry-reorder')]";
			content = content 
			+ AccTool.getGridValue(getWebDriver(), AccurateModule.UMUM, tab)
			+ "\r\n";
			AccTool.writeTextFile(filename, content);

		}
		
	}


