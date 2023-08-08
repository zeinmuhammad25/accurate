package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.barangjasa.BarangJasaParam;
import com.cpssoft.web.test.accurate.barangstokminimum.BarangStokMinimumParam;
import com.cpssoft.web.test.accurate.rancanganformulir.RancanganFormulirParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

	
	public class BarangStokMinimumTool extends AbstractAccurateTestCase {

		static Logger log = LogManager.getLogger(BarangStokMinimumTool.class);

		public static void klikbtnrefresh(WebDriver driver){
			AccTool.click(getWebDriver(), "//*[contains(@name,'btnRefresh')]");
//			WaitTool.delay(500);
//			AccTool.waitLoadingMask(getWebDriver());
		}
		public static void klikButtonPesan(WebDriver driver) {
			String path = "//div[starts-with(@id,'module-accurate__inventory__minimum-stock-item')]" + "//button[@name='btnReorder']";
			AccTool.click(driver, path);
			AccTool.waitLoadingMask(getWebDriver());
		}
		public static void pilihPemasok(WebDriver driver, BarangStokMinimumParam param) {
			log.info("BarangStokMinimum.PilihPemasok");

//			String w = AccurateModule.BARANG_STOK_MINIMUM.getXpath();
			String tab = "";

			AccTool.click(driver, AccurateModule.BARANG_STOK_MINIMUM.getXpath() + "//a[text()='Cari/Pilih Pemasok...']");

			if (param.pilihpemasok != null)
				AccTool.lookup(driver, tab, "@name='vendorId'", param.pilihpemasok);
		}
		
		public static void klikCentangListData1(WebDriver driver) {
			log.info("BarangStokMinimum.KlikCentang");
			AccTool.click(getWebDriver(), "//div[@id='module-accurate__inventory__minimum-stock-item']//div[@class='input-control checkbox']//span['checkbox']");
			
			
		}
		public static void klikCentangListDataSemua(WebDriver driver) {
			log.info("BarangStokMinimum.KlikCentang");
			AccTool.click(getWebDriver(), "//div[@class='ui-state-default slick-header-column ui-sortable-handle']//div[@class='input-control checkbox no-margin']");
		
		}

		
	}


