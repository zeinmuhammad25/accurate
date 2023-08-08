package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penyesuaianhargajual.PenyesuaianHargaJualParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PenyesuaianHargaJualTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PenyesuaianHargaJualParam.class);

	public static void klikTabInfoLainnya(WebDriver driver) {
		AccTool.click(driver,
				AccurateModule.PENYESUAIAN_HARGA_JUAL.getXpath() + "//a[contains(@href, '#tab-otherheader')]");
	}

	public static void klikButtonLanjutTabDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 100);
	}

	public static void klikButtonLanjutAmbilBarangJasa(WebDriver driver) {
		String path = "//*[contains(@id,'accurate__inventory__item-for-selling-price')]" + "//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikAmbilBarangJasa(WebDriver driver, PenyesuaianHargaJualParam param) {
//		AccTool.dropDown(getWebDriver(), AccurateModule.PENYESUAIAN_HARGA_JUAL.getXpath(),
//				"//div[contains(@class, 'span4')]/div[1]", "Daftar Barang & Jasa");
		
		//ui baru
		String w = AccurateModule.PENYESUAIAN_HARGA_JUAL.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
		
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PENYESUAIAN_HARGA_JUAL.getXpath()
				+ "//a[.='Daftar Barang & Jasa']"), 3);
		AccTool.click(getWebDriver(), w + "//a[.='Daftar Barang & Jasa']");
		

		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'accurate__inventory__item-for-selling-price')]",
					"@name='itemCategory'", param.search);
	}

	public static void klikButtonCloseTabDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}

	
	public static void klikHapusBarang(WebDriver driver){
		String path = "//div[contains(@id, 'detail-item')]//*[@name='btnDelete']";
		AccTool.click(getWebDriver(), path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
		
	}
	
	public static void klikTampilkanList(WebDriver driver){
		AccTool.click(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL.getXpath()+ "//button[@name='btnShowAllColumn']");
	
		
	}
	
	public static void klikHapusSatuan (WebDriver driver) {
        String path = "//div[contains(@id, 'detail-item')]//*[@class='button mini info']";
		AccTool.click(getWebDriver(), path);
	
	}
	
	public static void pengaturanKolomList(WebDriver driver, String kolom, boolean checked) {
		String xpathModulSPA = "//div[@id='module-accurate__inventory__sellingprice-adjustment']";
		String buttonKolomSetting = "//button[@name='btnColumnSetting']";
		String xpathKolom = xpathModulSPA + buttonKolomSetting + "/following-sibling::ul//label[span[text()='" + kolom + "']]";
			
		AccTool.click(driver, xpathModulSPA + buttonKolomSetting);
		
		WebElement element = driver.findElement(By.xpath(xpathKolom + "/input"));
		WaitTool.waitForElementClickable(driver, By.xpath(xpathKolom),1);
				
		if (checked) {
			if (!element.isSelected()) {
				AccTool.click(driver, xpathKolom + "/span[1]");
			}			
		} else {
			if (element.isSelected()) {
				AccTool.click(driver, xpathKolom + "/span[1]");
			}
		}
		
		AccTool.click(driver, xpathModulSPA + "//div[contains(@data-bind, 'getListRowCount()')]");
		//harus ada delay supaya scroll bar nya tidak hilang
		WaitTool.delay(500);		
	}

	
	public static void isiForm(WebDriver driver, PenyesuaianHargaJualParam param) {
		log.info("PenyesuaianHargaJual.Isi");

		String tab = AccurateModule.PENYESUAIAN_HARGA_JUAL.getXpath();
		// String tab = w + "//*[contains(@id,'tab-general')]";

		if (param.kategoriharga != null)
			AccTool.lookup(driver, tab, "@name='priceCategory'", param.kategoriharga);
		
		if (param.tipepenyesuaian != null)
			AccTool.combobox(driver, tab, "@name='salesAdjustmentType'", param.tipepenyesuaian);
		
		if (param.mulaiberlaku != null)
			AccTool.datePicker(driver, tab, "@name='transDate'", param.mulaiberlaku);

		if (param.penomoran != null)
			AccTool.combobox(driver, tab, "@name='typeAutoNumber'", param.penomoran);

		if (param.no != null)
			AccTool.textField(driver, tab, "@name='number'", param.no);

		if (param.matauang != null)
			AccTool.lookup(driver, tab, "@name='currency'", param.matauang);

		if (param.berlakudicabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.berlakudicabang);

	}
	
	
	public static void detailBarang(WebDriver driver, PenyesuaianHargaJualParam param) {
		log.info("PenyesuaianHargaJual.DetailBarang");

		String tab = "//div[starts-with(@id,'tab-detailitem')]";

		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		if (param.satuan != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);
		if (param.hargabaru != null)
			AccTool.numberField(driver, tab, "@name='price'", param.hargabaru);
		if (param.hargaminimum != null)
			AccTool.numberField(driver, tab, "@name='minimumPrice'", param.hargaminimum);
		if (param.UntukKtsDiatas != null)
			AccTool.numberField(driver, tab, "@name='minQuantity'", param.UntukKtsDiatas);

	}
	
	public static void detailDiskon(WebDriver driver, PenyesuaianHargaJualParam param) {
		log.info("PenyesuaianHargaJual.DetailDiskon");

		String tab = "//div[starts-with(@id,'tab-detailitem')]";

		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		if (param.satuan != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);
		if (param.diskon != null)
			AccTool.numberField(driver, tab, "@name='itemDiscPercent'", param.diskon);
		if (param.UntukKtsDiatas != null)
			AccTool.numberField(driver, tab, "@name='minQuantity'", param.UntukKtsDiatas);

	}


	public static void isiDetail(WebDriver driver, PenyesuaianHargaJualParam param) {
		log.info("PenyesuaianHargaJual.IsiDetail");

		String tab = "//div[starts-with(@id,'tab-item')]";
		AccTool.click(driver, "//*[contains(@href,'tab-item')]");
		if (param.searchitem != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
			AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}

	public static void isiInfoLain(WebDriver driver, PenyesuaianHargaJualParam param) {
		log.info("PenyesuaianHargaJual.IsiInfoLain");

		String tab = "//div[starts-with(@id,'tab-otherheader')]";

		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
		if (param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);

	}

	public static void saveIsi(WebDriver driver, String filename) {
		log.info("PenyesuaianHargaJual.SaveIsi");

		String tab = "";
		String content = "PenyesuaianHargaJual.SaveHeader : " + "\r\n";
		content = content
		
				+ "\r\n"
				+ "Kategori Harga : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL, ElementType.LOOKUP, "priceCategory", tab);

        		//Tipe Penyesuaian ada 2 kondisi, sesudah atau sebelum disave
				String tipedata = "//select[@name = 'salesAdjustmentType']";
				if (WebElementTool.isElementExists(driver, By.xpath(tipedata))) {
					content = content + "Tipe Penyesuaian : "
							+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL, ElementType.COMBOBOX, "salesAdjustmentType", tab);
				} else {
					content = content + "Tipe Penyesuaian : "
							+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL,"//div[@name='salesAdjustmentType']");
				}
				content = content
				+ "Mulai Berlaku : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL, ElementType.DATEPICKER,"transDate", tab)
				+ "Mata Uang : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL, ElementType.LOOKUP, "currency",tab)
				+ "Penomoran : "
				+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL, ElementType.TEXTFIELD, "number",
						tab);
				//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Berlaku di Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Berlaku di Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL, ElementType.SUMMARY, "branchListOption", tab);
				}
				content = content
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}


	public static void saveListDetail(WebDriver driver, String filename) {
		log.info("PenyesuaianHargaJual.SaveList");

		AccTool.click(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL.getXpath() + "//*[contains(@href,'tab-item')]");
		String tab = "//*[contains(@id,'tab-item')]";
		String content = "PenyesuaianHargaJual.SaveListBarang : " + "\r\n";
		content = content 
		
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL, tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	
	public static void saveDetailBarang(WebDriver driver, String filename) {
		log.info("PenyesuaianHargaJual.SaveDetail");

		String tab = "";
		String content = "PenyesuaianHargaJual.SaveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content 
				+ "\r\n" 
				+ "Nama Barang : "
				+ AccTool.getTextValue(driver, ElementType.DIV, "itemName", tab) 
				+ "Satuan : "
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab) 
				+ "Harga Lama : "
				+ AccTool.getTextValue(driver, ElementType.SPAN, "formData.oldPrice", tab)
				+ "Harga Baru : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "price", tab) 
				+ "Harga Minimum : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "minimumPrice", tab) ;
	
		String grosir = "//input[@name = 'minQuantity']";
		if (WebElementTool.isElementExists(driver, By.xpath(grosir))) {
			content = content + "Untuk Kts Diatas : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "minQuantity", tab)+ "\r\n";
		} else {
			content = content
			+"\r\n";
		}
	
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailDiskon(WebDriver driver, String filename) {
		log.info("PenyesuaianHargaJual.SaveDetail");

		String tab = "";
		String content = "PenyesuaianHargaJual.SaveDetailDiskon : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content 
				+ "\r\n" 
				+ "Nama Barang : "
				+ AccTool.getTextValue(driver, ElementType.DIV, "itemName", tab) 
				+ "Diskon Lama: "
				+ AccTool.getTextValue(driver, ElementType.SPAN,"formData.oldItemDiscPercent", tab)
				+ "Diskon (%): "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab) ;
				
		String grosir = "//input[@name = 'minQuantity']";
				if (WebElementTool.isElementExists(driver, By.xpath(grosir))) {
					content = content + "Untuk Kts Diatas : "
							+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "minQuantity", tab)+ "\r\n";
				} else {
					content = content
					+"\r\n";
		}
	
		AccTool.writeTextFile(filename, content);
	}

	public static void saveInfoLain(WebDriver driver, String filename) {
		log.info("PenyesuaianHargaJual.SaveIsi");
		AccTool.click(driver,
				AccurateModule.PENYESUAIAN_HARGA_JUAL.getXpath() + "//*[contains(@href,'tab-otherheader')]");
		String tab = "//*[contains(@id,'tab-otherheader')]";
		String content = "PenyesuaianHargaJual.SaveInfoLain : " + "\r\n";
		content = content 
				+ "\r\n" 
				+ "Keterangan : " + AccTool.getTextValue(driver,
				AccurateModule.PENYESUAIAN_HARGA_JUAL, ElementType.TEXTAREA, "description", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	
	public static void saveIsiPopup(WebDriver driver, String fileName)
	{
		log.info("Save isi popup ");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	String content = "Penyesuaian Harga Jual.Warning : " + "\r\n";
	content = content
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
	AccTool.writeTextFile(fileName, content);
	}
	
	public static void saveList(WebDriver driver, String fileName) {

		
		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "Penyesuaian Harga.SaveList : " + "\r\n";
		content = content 
			
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.PENYESUAIAN_HARGA_JUAL, tab)
				+ "\r\n";
	
		AccTool.writeTextFile(fileName, content);
	}
	
	public static void klikListBarangUrutan(WebDriver driver, int urutan) {
		WaitTool.delay(1000);
		AccTool.click(driver, "//div[contains(@id,'detail-selling-price-grid-list')]//div[contains(@class,'grid-canvas')]/div["+ urutan +"]");
		String path = "//button[@name='btnNext']";
		WaitTool.waitForElementClickable(driver, By.xpath(path), 10);
	}
	
}
