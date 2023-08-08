package com.cpssoft.web.test.accurate.tool;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.penawaranpenjualan.PenawaranPenjualanParam;
//import com.cpssoft.web.test.accurate.pesananpembelian.List;
//import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.pesananpembelian.PesananPembelianParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PesananPembelianTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PesananPembelianParam.class);

	public static void pilihDetailPesanan(WebDriver driver, PesananPembelianParam param)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-item-grid-list')]//div[@class='grid-canvas']/div["+param.urutan+"]");
	} 
	
	public static void klikButtonLanjutDetailBarang(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 5);
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikButtonLanjutDetailBiayaLain(WebDriver driver) {
		AccTool.click(getWebDriver(), "//div[contains(@id,'detail-expense')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikbtnHapusItemPesananPembelian()
	{
		AccTool.click(getWebDriver(), "//div[contains(@id,'detail-item')]//*[@name='btnDelete']");
	}
	
	public static void pilihDetailBiaya(WebDriver driver, PesananPembelianParam param)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-expense-grid-list')]//div[@class='grid-canvas']/div["+param.urutan+"]");
	} 
	
	public static void klikbtnHapusBiayaLain(WebDriver driver)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-expense')]" + "//*[@name='btnDelete']");
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikButtonLanjutAmbilPermintaan(WebDriver driver) {
		String xpath = "//div[contains(@id,'copy-purchase-requisition')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
		WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 3);
	}
	
	public static void klikButtonLanjutAmbilBarangPerPemasok(WebDriver driver) {
		AccTool.click(getWebDriver(), "//div[contains(@id,'accurate__inventory__item-per-vendor')]//*[@name='btnNext']");
	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void isiHeader(WebDriver driver, PesananPembelianParam param)
	{
		log.info("PesananPembelian.Isi");
		String w = AccurateModule.PESANAN_PEMBELIAN.getXpath();
		
		if(param.pemasok != null) {
			AccTool.lookup(driver, w, "@name='vendor'", param.pemasok);
			AccTool.waitProgressBar(driver);
			AccTool.waitProgressBar(driver);
		}
		if(param.matauang != null)
			AccTool.combobox(driver, w, "@name='currency'", param.matauang);
		if(param.tanggal != null) {
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
			AccTool.waitProgressBar(driver);
		}
		if(param.kurs != null) {
			AccTool.numberField(driver, w, "@name='rate'", param.kurs);
			AccTool.click(getWebDriver(), w + "//label[@data-bind='text: ft.transDate.title']");
			//WaitTool.delay(500);
			WaitTool.waitForElementClickable(driver, By.xpath(w), 1);
		}
		if(param.penomoran != null)
			AccTool.textField(driver, w, "@name='number'", param.penomoran);
		if(param.diskon != null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskon);
	}
	
	public static void isiDetailBarang(WebDriver driver, PesananPembelianParam param)
	{
		String tab = AccurateModule.PESANAN_PEMBELIAN.getXpath() + "//*[contains(@id,'tab-item')]";	
		//WaitTool.waitForElementClickable(driver, By.xpath(tab + "//input[@name='searchDetailItem']"), 6);
		
		AccTool.click(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath() + "//a[contains(@href,'tab-item')]");
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void isiBiayaLainnya(WebDriver driver, PesananPembelianParam param)
	{

		String w = AccurateModule.PESANAN_PEMBELIAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-expense')]";
		AccTool.click(driver, w + "//a[contains(@href,'tab-expense')]");
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void detailBarang(WebDriver driver, PesananPembelianParam param)
	{
		String tab= "";
		
		switch((param.tab).toLowerCase()){
		case "detail barang":
			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			if(param.nama != null)
				AccTool.textField(driver, tab, "@name='detailName'", param.nama);					
			if(param.kuantitas != null) {
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
				//WaitTool.delay(500);
				WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
			}
			if(param.unit != null)
				AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
			if(param.harga != null) {
				AccTool.numberField(driver, tab, "@name='unitPrice'", param.harga);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
				//WaitTool.delay(500);
				WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
			}
			if(param.diskonpersen != null) {
				AccTool.numberField(driver, tab, "@name='itemDiscPercent'", param.diskonpersen);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
			}	
			if(param.diskon != null)
				AccTool.numberField(driver, tab, "@name='itemCashDiscount'", param.diskon);	
			if(param.ppn != null)
				AccTool.checkbox(getWebDriver(), tab, "@name='useTax1'", param.ppn);
			if(param.ppnbm != null)
				AccTool.checkbox(getWebDriver(), tab, "@name='useTax2'", param.ppnbm);
			if(param.gudang != null)
				AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
			if(param.departemenmandatory != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if(param.proyekmandatory != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);	
			break;
		case "keterangan":
			tab = "//*[contains(@id,'details-tab')]//*[contains(@id,'tab-customfield')]";			
//			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			//ui baru
			AccTool.click(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tabcustomfield')]");
			if(param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if(param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);	
			if(param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);		
			break;
		}
	}
	
	public static void isiDiskonBawahPersen(WebDriver driver, PesananPembelianParam param)
	{
		log.info("PesananPembelian.IsiDiskonBawah");
		String w = AccurateModule.PESANAN_PEMBELIAN.getXpath();
		
		if (param.diskonbawah!=null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskonbawah);
		if(param.diskonbawahpersen!=null) 
			AccTool.click(getWebDriver(), "//div[contains(@id,'module-accurate__vendor__purchase-order')]//*[@name='btnDiscPercent']");
			AccTool.textField(driver,"//*[@class='mask-wrapper']", "@name='discountPercent'", param.diskonbawahpersen);
			NavigationTool.klikButtonLanjut(getWebDriver(), "//div[contains(@id,'accurate__input-percentage')]");
			AccTool.waitProgressBar(driver);
			WaitTool.delay(500);			
	}
	
	public static void isiDiskonBawah(WebDriver driver, PesananPembelianParam param)
	{
		log.info("PesananPembelian.IsiDiskonBawah");
		String w = AccurateModule.PESANAN_PEMBELIAN.getXpath();
		
		if (param.diskonbawah!=null)
			AccTool.numberField(driver, w, "@name='itemCashDiscount'", param.diskonbawah);		
	}
	
	public static void saveIsiDiskonBawahPersen(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.SaveIsiDiskonBawah");
		
		String tab = "";
		String content = "PesananPembelian.SaveIsiDiskonBawah : " + "\r\n";
		content = content
				+ "Diskon Bawah : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.NUMBERFIELD, "itemCashDiscount", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void detailBiayaLainnya(WebDriver driver, PesananPembelianParam param)
	{
		log.info("PesananPembelian.DetailBiayaLain");
		String tab= "";
		
		if(param.tab != null)
		switch((param.tab).toLowerCase()){
		
		case "biaya lain":
			tab = "//*[contains(@id,'tab-detailexpense')]";
			AccTool.click(driver, "//*[contains(@id,'tabdetailexpense')]");
			if(param.nama != null)
				AccTool.textField(driver, tab, "@name='expenseName'", param.nama);					
			if(param.jumlah != null)
				AccTool.numberField(driver, tab, "@name='expenseAmount'", param.jumlah);	
			if(param.departemenmandatory != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if(param.proyekmandatory != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);				
			break;
			
		case "keterangan":
			tab = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]";			
//			AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
			//ui baru
			AccTool.click(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tabcustomfield')]");
			if(param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if(param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);	
			if(param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='expenseNotes'", param.keterangan);			
			break;
		}
	}
	
	public static void isiInfoLain(WebDriver driver, PesananPembelianParam param)
	{
		//String tab = AccurateModule.PESANAN_PEMBELIAN.getXpath() + "//a[contains(@href,'tab-otherheader')]";
		//AccTool.click(driver, tab);
		
		if(param.kenapajak != null)
		{
			AccTool.checkbox(driver, "", "@name='taxable'", param.kenapajak);
			if(param.totaltermasukpajak != null)
			{	
				log.info("masuk if totaltermasukpajak");
				AccTool.checkbox(driver, "", "@name='inclusiveTax'", param.totaltermasukpajak);
			}
		}
		if(param.alamat != null)
			AccTool.textarea(driver, "", "@name='toAddress'", param.alamat);	
		if(param.tglpengiriman != null)
			AccTool.datePicker(driver, "", "@name='shipDate'", param.tglpengiriman);
		if(param.pengiriman != null)
			AccTool.lookup(driver, "", "@name='shipment'", param.pengiriman);
		if(param.syaratpembayaran != null)
			AccTool.lookup(driver, "", "@name='paymentTerm'", param.syaratpembayaran);
		if(param.fob != null)
			AccTool.lookup(driver, "", "@name='fob'", param.fob);
		if (param.cabang != null)
			AccTool.combobox(driver, "", "@name='branch'", param.cabang);
		if(param.keterangan != null)
			AccTool.textarea(driver, "", "@name='description'", param.keterangan);	
		if(param.tutuppesanan != null)
			AccTool.checkbox(driver, "", "@data-bind='metroCheckbox: {}, checked: formData.manualClosed'", param.tutuppesanan);	
	}
	
	public static void klikAmbilBarangPerluDipesan(WebDriver driver)
	{
//		AccTool.dropDown(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath(), 
//				"//div[@class='offset4 span8']/div[1]", "Barang perlu dipesan");
		
		//ui baru
		String w = AccurateModule.PESANAN_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PESANAN_PEMBELIAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'getFromLackItem')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Barang perlu dipesan']");	
	}
	
	public static void klikAmbilBarangPerPemasok(WebDriver driver)
	{
//		AccTool.dropDown(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath(), 
//				"//div[@class='offset4 span8']/div[1]", "Barang per Pemasok");
		
		//ui baru
		String w = AccurateModule.PESANAN_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PESANAN_PEMBELIAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'getFromItemPerVendor')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Barang per Pemasok']");	
	}
	
	public static void klikAmbilPermintaan(WebDriver driver, PesananPembelianParam param)
	{
//		AccTool.dropDown(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath(), 
//				"//div[@class='offset4 span8']/div[1]", "Permintaan");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-purchase-requisition')]", "@name='lookup'", param.search);
		
		//ui baru
		String w = AccurateModule.PESANAN_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PESANAN_PEMBELIAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-purchase-requisition')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Permintaan']");

//		WaitTool.delay(500);

		// pastikan window popup cari pengiriman sudah visible
		WaitTool.waitForElementVisible(getWebDriver(),
				By.xpath("//div[contains(@id, 'copy-purchase-requisition')]//input[@name='lookup']"), 10);
		if (param.search != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-purchase-requisition')]", "@name='lookup'", param.search);
	}

	public static void klikAmbilPermintaanKosong(WebDriver driver, PesananPembelianParam param)
	{
		AccTool.dropDown(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath(), 
				"//div[@class='offset4 span8']/div[1]", "Permintaan");
		if(param.search != null)
			AccTool.lookupWithoutClear(driver, "//div[contains(@id, 'copy-purchase-requisition')]", "@name='lookup'", param.search);
	}

	public static void klikAmbilPermintaanFastTest(WebDriver driver)
	{
		AccTool.dropDown(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath(), 
				"//div[@class='offset4 span8']/div[1]", "Permintaan");
//		if(param.search != null)
//			AccTool.lookup(driver, "//div[contains(@id, 'copy-purchase-requisition')]", "@name='lookup'", param.search);
	}
	
	public static void klikAmbilFavorit(WebDriver driver, PesananPembelianParam param)
	{
//		AccTool.dropDown(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath(), 
//				"//div[@class='offset4 span8']/div[1]", "Favorit");
		
		//ui baru
		String w = AccurateModule.PESANAN_PEMBELIAN.getXpath();
		AccTool.click(getWebDriver(), w + "//*[@name = 'btnGetFrom']");
//		WaitTool.delay(500);

		// pastikan drop down sudah visible
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.PESANAN_PEMBELIAN.getXpath()
				+ "//ul[contains(@class,'dropdown-menu')]//a[contains(@data-bind, 'copy-memorize-transaction')]"), 3);
		AccTool.click(getWebDriver(), w + "//a[text() = 'Favorit']");
				
		if(param.tab != null)
			switch(param.tab.toLowerCase()){
			case "detail barang":
				String xpath = "//div[contains(@id,'copy-memorize-transaction')]//a[text()='Rincian Barang']";
				AccTool.click(driver, xpath);
				if(param.search != null)
					AccTool.lookup(driver, "//div[contains(@id,'copy-memorize-transaction')]", "@name='lookup'", param.search);
				break;
			case "biaya lainnya":
				xpath = "//div[contains(@id,'copy-memorize-transaction')]//a[text()='Biaya Lainnya']";
				AccTool.click(driver, xpath);
				if(param.search != null)
					AccTool.lookup(driver, "//div[contains(@id,'copy-memorize-transaction')]", "@name='lookup'", param.search);
				break;
			}
	}
	
	public static void klikProsesPenerimaan(WebDriver driver)
	{
		AccTool.dropDown(driver, "",
				"//div[@class='offset4 span8']/div[2]", "Penerimaan");
	}
	
	public static void klikProsesFaktur(WebDriver driver)
	{
		AccTool.dropDown(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath(),
				"//div[@class='offset4 span8']/div[2]", "Faktur");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikProsesUangMuka(WebDriver driver)
	{
		AccTool.dropDown(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath()+"//div[@class='offset4 span8']/div[2]",
				"", "Uang Muka");
	}
	
	public static void klikTabDetailBarang(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath() +
				"//a[contains(@href, '#tab-item')]");
	}
	
	public static void klikTabInfoLainBarang(WebDriver driver)
	{
	
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
	}
	
	public static void klikTabInfoLainnya(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath() +
				"//a[contains(@href, '#tab-otherheader')]");
	}
	
	public static void klikTabBiayaLainnya(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath() +
				"//a[contains(@href, '#tab-expense')]");
	}
	
	public static void klikTabInfoLainBiaya(WebDriver driver)
	{
	
//		AccTool.click(driver, "//a[contains(@href,'tab-customfieldexpense')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tabcustomfield')]");
	}
	
	public static void klikTabInformasiPesanan(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.PESANAN_PEMBELIAN.getXpath() +
				"//a[contains(@href, '#tab-summary')]");
	}
	
	public static void saveDetailBarang(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.SaveDetailBarang");
		WaitTool.delay(1000);

		String tab = "";
		String content = "PesananPembelian.SaveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		
		String css = "[data-bind='visible: ft.quantity.visible()'] [data-bind='text: name']";
		if (AccTool.elementExistCSS(driver, css)) {
			
			content = content
					+ "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
					+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Satuan : " + AccTool.getTextByCSS(driver, css) + "\r\n"
					+ "Harga : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab)
					+ "Diskon Persen : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab)
					+ "Diskon : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab)
					+ "Total Harga : " + AccTool.getTextValue(driver,  "//div[@class='text-panel-disabled text-panel-right-calculator text-right']")
					+ "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
					+ "Departemen : " + AccTool.getTextValue(driver,  "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
					+ "Proyek : " + AccTool.getTextValue(driver,  "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span")
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
			
		} else {
			
			content = content
					+ "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
					+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Harga : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab)
					+ "Diskon Persen : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab)
					+ "Diskon : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab)
					+ "Total Harga : " + AccTool.getTextValue(driver,  "//div[@class='text-panel-disabled text-panel-right-calculator text-right']")
					+ "Gudang : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
					+ "Departemen : " + AccTool.getTextValue(driver,  "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
					+ "Proyek : " + AccTool.getTextValue(driver,  "//div[starts-with(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span")
					+ "\r\n";
		
		AccTool.writeTextFile(filename, content);

		}
		String a = AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab);
		log.info(a);
	}
	
	public static void saveKeteranganDetailBarang(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.saveKeteranganDetailBarang");
		
		String tab = "//*[contains(@id,'detail-item')]//*[contains(@id,'tab-customfield')]";
		String content = "PesananPembelian.SaveKeteranganDetailBarang : " + "\r\n";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
//		//ui baru
		AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[contains(@id,'tabcustomfield')]");
		
		String dept = "//*[contains(@id,'details-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
			content = content + "Departemen :"
		        	+ AccTool.getTextValue(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span");
		}
		
		String proy = "//*[contains(@id,'details-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
			content = content+ "Proyek :"
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span");
		}
		
		content = content
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailBiayaLain(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.SaveDetailBiayaLain");
		
		String tab = "";
		String content = "PesananPembelian.SaveDetailBiayaLain : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		content = content
				+ "Nama : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab)
				+ "Jumlah : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "expenseAmount", tab)
				+ "Departemen : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek : "
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span") 
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveKeteranganDetailBiayaLain(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.SaveDetailBiayaLain");
		
		String tab = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]";
		String content = "PesananPembelian.SaveKeteranganDetailBiayaLain : " + "\r\n";
//		AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tabcustomfield')]");
		
		String dept = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(dept))) {
			content = content + "Departemen :"
		        	+ AccTool.getTextValue(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span");
		}
		
		String proy = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span";
		if (WebElementTool.isElementVisible(driver, By.xpath(proy))) {
			content = content+ "Proyek :"
	            	+ AccTool.getTextValue(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span");
		}
		
		content = content
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiHeader(WebDriver driver, String filename)
	{
		AccTool.click(getWebDriver(), "//label[contains(@data-bind,'text: ft.vendor.title')]");
		log.info("PesananPembelian.SaveIsiHeader");
		
		String tab = "";
		String content = "PesananPembelian.SaveIsiHeader : " + "\r\n";
		content = content
				+ "Pemasok : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.LOOKUP, "vendor", tab)
				+ "Mata Uang : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.SUMMARY, "text: formData.currency().code", tab)
				+ "Tanggal : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.DATEPICKER, "transDate", tab)
				+ "Kurs : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.NUMBERFIELD, "rate", tab)
				+ "Nomor : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.TEXTFIELD, "number", tab)
				+ "Diskon : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.NUMBERFIELD, "itemCashDiscount", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiDetailBarang(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.SaveIsiDetailBarang");
		
		String tab = "";
		String content = "PesananPembelian.SaveIsiDetailBarang : " + "\r\n";
		tab = "//*[contains(@id,'tab-item')]";
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiBiayaLain(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.SaveIsiBiayaLain");
		
		String tab = "";
		String content = "PesananPembelian.SaveIsiBiayaLain : " + "\r\n";
		tab = "//*[contains(@id,'tab-expense')]";
		content = content
				+ AccTool.getGridValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiInfoLain(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.SaveIsiInfoLain");
		
		String tab = "";
		String content = "PesananPembelian.SaveIsiInfoLain : " + "\r\n";
		tab ="//*[contains(@id,'tab-otherheader')]";
		content = content
				+ "Alamat : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.TEXTAREA, "toAddress")
				+ "Tanggal Pengiriman : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.DATEPICKER, "shipDate")
				+ "Pengiriman : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.LOOKUP, "shipment")
				+ "Syarat Pembayaran : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.LOOKUP, "paymentTerm")
				+ "FOB : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.LOOKUP, "fob");
				
				//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.SUMMARY, "branchListOption", tab);
				}
				
				content = content + "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.TEXTAREA, "description")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveIsiInfoPesanan(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.SaveIsiInfoPesanan");
		
		//String tab = "";
		String content = "PesananPembelian.SaveIsiInfoPesanan : " + "\r\n";
		//tab = AccurateModule.PESANAN_PEMBELIAN.getXpath() + "//*[contains(@id,'#tab-summary')]";
		content = content
				+ "Total : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.totalAmount())")
				+ "Uang Muka : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.totalDownPayment())")
//				+ "Diproses Oleh : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.SPAN, "text: formData.processHistory().length")
				+ "Uang Muka Terpakai/Retur : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.totalDownPaymentUsed())")
				+ "Sisa Uang Muka: " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.SPAN, "text: app.util.parseNumber(formData.availableDownPayment())")
				+ "Status : " + AccTool.getTextValue(driver, "//*[contains(@data-bind,'ShowTransactionHistoryStatus')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveList(WebDriver driver, String filename)
	{
		log.info("PesananPembelian.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "PesananPembelian.SaveList : " + "\r\n";
		
		content = content + AccTool.getGridValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab)+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	

	public static void saveFooter(WebDriver driver, String filename){

		log.info("Save Footer");
		WaitTool.delay(500);
		String content = "PesananPembelian.saveFooter ; " + "\r\n";//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div
		
		String tab ="//div[text()='Sub Total']/following-sibling::div";
		String tab1 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[1]";
		String tab11 = "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]/following-sibling::div/span[2]";
		String tab2 ="//div[text()='PPNBM 15%']/following-sibling::div";
		String tab3 ="//div[text()='Total']/following-sibling::div";
//		String tab4 ="//div[text()='PPh']/following-sibling::div";		
		String tab4 ="";
		String tabpph = "//div[contains(@class, 'title') and text()[contains(.,'PPh')]]";
		
//		WebElement temp = driver.findElement(By.xpath(tabpph));
		List<WebElement> temp = driver.findElements(By.xpath(tabpph));
		boolean exists = temp.size() > 0;
		
		if (exists) {
			WebElement temppph = driver.findElement(By.xpath(tabpph));
			String valuetabpph = temppph.getAttribute("textContent");
			log.info("cek cuyy " + tabpph);
			
			switch (valuetabpph) {
			case "PPh 4(2)" : 
				tab4 = "//div[text()='PPh 4(2)']/following-sibling::div";
				break;
			case "PPh 15" : 
				tab4 = "//div[text()='PPh 15']/following-sibling::div";
				break;
			case "PPh 23" : 
				tab4 = "//div[text()='PPh 23']/following-sibling::div";
				break;
			case "PPh 22 1%" :
			case "PPh 22 10%" :	
				tab4 = "//div[text()[contains(.,'PPh 22')]]/following-sibling::div";
				break;
			case "PPh 21" : 
				tab4 = "//div[text()='PPh 21']/following-sibling::div";
				break;
			}
		}else {
			log.info("tidak masuk exists");
			
			tab4 = "//div[text()='PPh']/following-sibling::div";
		}
				
		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());
		
		//pastikan footer sudah tampil
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.PESANAN_PEMBELIAN.getXpath()+"//*[contains(@id,'summary-panel')]"), 500);
		
		content = content + "Sub Total : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab)
		+ "Diskon : "
		+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, ElementType.NUMBERFIELD,
				"itemCashDiscount");

		//untuk PPN
		String PPN = "//*[contains(@class, 'title inline-block') and text()[contains(.,'PPN')]]";
		if(WebElementTool.isElementExists(driver, By.xpath(PPN)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@class, 'title inline-block') and 	text()[contains(.,'PPN')]]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab1).replace("\r\n", " ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab11);
		} else {
			content = content 
					+ "PPN 10% : " + AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, "ppn");
		}
		
		//untuk PPNBM
		String PPNBM = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]";
		if(WebElementTool.isElementExists(driver, By.xpath(PPNBM)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[1]").replace("\r\n", " ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPNBM')]]/following-sibling::div/span[2]");
		}
		
		content = content 
		+ "Total Biaya : "
		+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab2) + "Total : "
		+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab3);
		
		//untuk PPh
		String PPH = "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]";
		if(WebElementTool.isElementExists(driver, By.xpath(PPH)))
		{
			content = content 
					+ AccTool.getTextValue(driver, "//*[contains(@class, 'title label-no-wrap') and text()[contains(.,'PPh')]]").replace("\r\n", " : ")
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab4);
		} else {
			content = content 
					+ "PPh : "
					+ AccTool.getTextValue(driver, AccurateModule.PESANAN_PEMBELIAN, "pph");
		}
		
		content = content
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
		}
	
	
	public static void saveListDetailBarang(WebDriver driver,String filename)
	{
		log.info("PesananPembelian.saveListDetailBarang");

	String content = "PesananPembelian.SaveListDetailBarang : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-item')]";
	content = content 
			+ AccTool.getGridValue(driver, AccurateModule.PESANAN_PEMBELIAN,
					tab) + "\r\n";
	AccTool.writeTextFile(filename, content);

	}
	
	public static void klikButtonCloseTabDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikButtonCloseTabDetailBiayaLainnya(WebDriver driver) {
		String path = "//*[text()='Biaya Lainnya']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void saveListDetailBiaya(WebDriver driver,  String filename)
	{
		log.info("PesananPembelian.saveListDetailBiaya");

		String content = "PesananPembelian.SaveListDetailBiaya : " + "\r\n";
		String tab = "//*[contains(@id,'tab-expense')]";
		content = content
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PESANAN_PEMBELIAN, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikButtonPembelianAset(WebDriver driver){
		String xpath = "//button[@name='btnBuyFA']";
		String dialogkonfirm = "//div[contains(@id,'confirm-dialog')]";
		AccTool.click(driver, xpath);
		
		if (WebElementTool.isElementVisible(driver, By.xpath(dialogkonfirm))) {
			AccTool.click(driver, "//button[@name='btnOk' and text()='Ya']");
		}

	}
	
	public static void detailAset(WebDriver driver, PesananPembelianParam param){
		String tab= "";
		switch((param.tab).toLowerCase()){
		case "detail barang":
			tab = "//div[starts-with(@id,'tab-detailitem')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
			if(param.nama != null)
				AccTool.textField(driver, tab, "@name='detailName'", param.nama);					
			if(param.kuantitas != null) {
				AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
				//WaitTool.delay(500);
				WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
			}
			if(param.harga != null) {
				AccTool.numberField(driver, tab, "@name='unitPrice'", param.harga);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
				//WaitTool.delay(500);
				WaitTool.waitForElementClickable(driver, By.xpath(tab), 1);
			}
			if(param.diskonpersen != null) {
				AccTool.numberField(driver, tab, "@name='itemDiscPercent'", param.diskonpersen);
				AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
				AccTool.waitLoaderMedium(driver);
			}	
			if(param.diskon != null)
				AccTool.numberField(driver, tab, "@name='itemCashDiscount'", param.diskon);	
			if(param.ppn != null)
				AccTool.checkbox(getWebDriver(), tab, "@name='useTax1'", param.ppn);
			if(param.departemen != null)
				AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if(param.proyek != null)
				AccTool.lookup(driver, tab, "@name='project'", param.proyek);				
			break;
		case "keterangan":
			tab = "//div[starts-with(@id,'tab-notes')]";			
			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			if(param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);			
			break;
		}
	}

	public static void saveDetailAset(WebDriver driver, String filename){
		log.info("PesananPembelian.SaveDetailAset");
		WaitTool.delay(1000);
		
		String tab = "";
		String content = "PesananPembelian.SaveDetailAset : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content
				+ "Nama Aset : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
				+ "Harga : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "unitPrice", tab)
				+ "Diskon Persen : " + AccTool.getTextValue(driver, ElementType.TEXTFIELD, "itemDiscPercent", tab)
				+ "Diskon : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "itemCashDiscount", tab)
				+ "PPN : " + AccTool.getTextValue(driver, ElementType.CHECKBOX, "useTax1", tab)
				+ "Departemen : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "department", tab)
				+ "Proyek : " + AccTool.getTextValue(driver, ElementType.LOOKUP, "project", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void ubahTarifPPN(WebDriver driver, PesananPembelianParam param) {
		log.info("PenawaranPenjualan.UbahTarifPPN");

		String w = AccurateModule.PESANAN_PEMBELIAN.getXpath();

		String u = "";

		AccTool.click(getWebDriver(), w + "//*[@name='btnPpnPercent']");
		if (param.tarifppn != null)
			AccTool.combobox(driver, u, "@name='tax1Rate'", param.tarifppn);
		AccTool.click(getWebDriver(), "//div[starts-with(@id,'accurate__input-ppn-percentage')]//*[@name='btnNext']");
	}
	
	
}
