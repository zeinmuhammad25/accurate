package com.cpssoft.web.test.accurate.tool;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.formulaproduksi.FormulaProduksiParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class FormulaProduksiTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(FormulaProduksiParam.class);
	
	public static void klikTabTahapan(WebDriver driver){
		AccTool.click(driver, "//*[contains(@class,'icn-transaction-stage')]");
	}
	
	
	public static void klikTabBarang(WebDriver driver){
		AccTool.click(driver, "//a[contains(@href,'tab-item')]");
	}
	
	public static void klikTabBiaya(WebDriver driver){
		AccTool.click(driver, "//*[contains(@class,'icn-transaction-expense')]");
	}
	
	public static void klikTabHasil(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-extra-finish-good')]");
	}
	
	public static void klikTabInfoLain(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
	}
	
	public static void klikTabBahanBaku(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-item')]");
	}
	
	public static void klikOKPopUpWarning(WebDriver driver) {
		
		String path = "//*[@name='btnOk']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	
	// konfirmasi tutup tab data saat ada data terisi
	public static void klikOKPadaWarningTutupTab(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'confirm-dialog')]//*[@name='btnOk']");
		WaitTool.delay(1000);
	}
	
	public static void klikTutupPopupDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Bahan Baku']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTahapan(WebDriver driver, AccurateModule module, String name){
		String tab = module.getXpath() + "//div[text()='" + name + "']";
		AccTool.click(driver, tab);

	}
	
	
	public static void klikHapusAkunPerkiraan(WebDriver driver, AccurateModule module, String keyword) {
		String tab = AccurateModule.FORMULA_PRODUKSI.getXpath();
		AccTool.clearLookup(getWebDriver(), tab, "@name='secondQulityProduct'", keyword);
	}
	
	public static void klikTutupPopupDetailBiaya(WebDriver driver) {
		String path = "//*[text()='Rincian Biaya']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTutupPopupDetailHasil(WebDriver driver) {
		String path = "//*[text()='Rincian Produk Lainnya']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikLanjutTahapan(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-process')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		AccTool.waitProgressBar(getWebDriver());
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}

	public static void klikLanjutDetailBarang(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-material')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		AccTool.waitProgressBar(getWebDriver());
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	
	//tanpa disappear
	public static void klikLanjutBarang(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-material')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		AccTool.waitProgressBar(getWebDriver());
	}
	
	public static void klikLanjutBiaya(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikLanjutHasil(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-extra-finish-good')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);
	}
	
	public static void klikRancanganFormulir(WebDriver driver){
		AccTool.click(driver, "//*[contains(@id,'btn-form-template--')]");
	}
	
	public static void klikHapusTahapan(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-process')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	
	public static void klikHapusDetailBarang(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-material')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	

	public static void klikHapusDetailBiaya(WebDriver driver) {
		
		String path = "//*[contains(@id,'detail-expense')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 10);
	}
	
	
	public static void klikHapusHasilLainnya(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-extra-finish-good')]//*[@name='btnDelete']");
		AccTool.waitProgressBar(driver);
	}
	

	
	public static void klikAmbilFormula(WebDriver driver, FormulaProduksiParam param) {
		AccTool.dropDown(getWebDriver(), AccurateModule.FORMULA_PRODUKSI.getXpath(), 
				"//div[contains(@class, 'span12')]/div[1]", "Formula Produksi");
		if(param.searchitem != null)
			AccTool.lookup(driver, "//div[contains(@id, 'copy-bill-of-material')]", "@name='lookup'", param.searchitem);
	}
	
	public static void klikLanjutAmbilFormula(WebDriver driver) {
		AccTool.click(getWebDriver(), "//*[contains(@id,'copy-bill-of-material')]//*[@name='btnNext']");
		AccTool.waitProgressBar(driver);

	}
	public static void klikListGridDetailForm(WebDriver driver, AccurateModule modul, String keyword) {
	
		String tab = "//div[starts-with(@id, 'detail-extra-finish-good-grid-list')]";
		AccTool.clickCell(driver, modul.getXpath() + tab , keyword);
	}
	
	
	public static void klikHapusIsiTahapan(WebDriver driver, String keyword) {
		AccTool.clearLookup2(getWebDriver(), "@name='processCategory'", keyword);
	}

	
	public static void isiHeader (WebDriver driver,FormulaProduksiParam param){
		
		String tab = "";
		
			AccTool.lookup(driver, tab, "@name='item'", param.produk);
		if(param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		if(param.satuan != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuan);	
		if(param.no != null)
			AccTool.textField(driver, tab, "@name='number'", param.no);	
	}	
	
	
	public static void isiTahapan (WebDriver driver, FormulaProduksiParam param) {
		
		String tab = "//div[starts-with(@id,'tab-process')]";
		AccTool.click(driver, "//*[contains(@href,'tab-process')]");

		if (param.searchitem != null)
			AccTool.lookup(driver, tab, "@name='searchProcessCategory'", param.searchitem);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}
	
	
	public static void isiDetailBahanBaku (WebDriver driver, FormulaProduksiParam param) {
		
		String tab = "//div[starts-with(@id,'tab-item')]";
		AccTool.click(driver, "//*[contains(@href,'tab-item')]");

		if (param.searchitem != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}
	
	
	public static void isiDetailBiaya(WebDriver driver, FormulaProduksiParam param) {
		
		String tab = "//div[starts-with(@id,'tab-expense')]";
		AccTool.click(driver, "//*[contains(@href,'tab-expense')]");

		if (param.searchitem != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}
	
	
	public static void isiDetailHasilSampingan(WebDriver driver, FormulaProduksiParam param) {
		
		String tab = "//div[starts-with(@id,'tab-extra-finish-good')]";
		AccTool.click(driver, "//*[contains(@href,'tab-extra-finish-good')]");

		if (param.searchitem != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.searchitem);
		AccTool.waitLoadingMask(driver);
		if (param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
		AccTool.waitLoadingMask(driver);
	}
	
	
	public static void detailTahapan(WebDriver driver, FormulaProduksiParam param) {
		
		String tab = "//div[starts-with(@id,'detail-process')]";
	//	AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		
		if (param.tahapan != null)
			AccTool.combobox(driver, tab, "@name='sortNumber'", param.tahapan);
		if (param.subkon != null)
			AccTool.checkbox(driver, tab, "@name='subcon'", param.subkon);
	
	}
	
	public static void detailBarang(WebDriver driver, FormulaProduksiParam param) {
		
		String tab = "//div[starts-with(@id,'tab-detailitem')]";
	//	AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		
		if (param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		if (param.satuandetail != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuandetail);
		if (param.tahapanbahanbaku != null)
			AccTool.lookup(driver, tab, "@name='processCategory'", param.tahapanbahanbaku);
	
	}
	
	public static void isiKeteranganBarang(WebDriver driver, FormulaProduksiParam param)
	{
		
		String tab = "//div[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
		if(param.keterangandetail != null)
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangandetail);
	}
	
	public static void isiKeteranganBiaya(WebDriver driver, FormulaProduksiParam param)
	{
		
		String tab = "//*[starts-with(@id,'detail-expense')]//*[starts-with(@id,'tab-customfield')]";
//		AccTool.click(driver, "//div[starts-with(@id, 'detail-expense')]//a[contains(@href, 'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[starts-with(@id,'detail-expense')]//a[starts-with(@id,'tabcustomfield')]");
		if(param.keterangandetail != null)
			
			AccTool.textarea(driver, tab, "@name='expenseNotes'", param.keterangandetail);
	}
	
	public static void isiKeteranganHasil(WebDriver driver, FormulaProduksiParam param)
	{
		
		String tab = "//*[starts-with(@id,'detail-extra-finish-good')]//*[starts-with(@id,'tab-customfield')]";
//		AccTool.click(driver, "//div[starts-with(@id, 'detail-extra-finish-good-')]//a[contains(@href, 'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[starts-with(@id,'detail-extra-finish-good')]//*[starts-with(@id,'tabcustomfield')]");
		
		if(param.keterangandetail != null)
			
			AccTool.textarea(driver, tab, "@name='expenseNotes'", param.keterangandetail);
	}
	
	
	public static void detailBiaya(WebDriver driver, FormulaProduksiParam param) {
			
		String tab = "//div[starts-with(@id,'tab-detailitem')]";

		if (param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		if (param.satuandetail != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuandetail);
		if (param.tahapanbiaya != null)
			AccTool.lookup(driver, tab, "@name='processCategory'", param.tahapanbiaya);
	}
	
	public static void detailHasil(WebDriver driver, FormulaProduksiParam param) {
		
		String tab = "//div[starts-with(@id,'tab-detailitem')]";

		if (param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
		if (param.satuandetail != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.satuandetail);
		if (param.porsi != null)
			AccTool.numberField(driver, tab, "@name='portion'", param.porsi);
	}
	
	public static void isiInfoLainnya(WebDriver driver, FormulaProduksiParam param) {
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		
			if (param.cabang != null)
				AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
			if (param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
			if (param.kualitasprodukkedua != null)
				AccTool.lookupWithoutClear(driver, tab, "@name='secondQulityProduct'", param.kualitasprodukkedua);
			
		}
	
	//kualitas kedua dihapus ketika insert data baru
	public static void isiInfoLainnya2(WebDriver driver, FormulaProduksiParam param) {
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-otherheader')]");
		
			if (param.cabang != null)
				AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
			if (param.keterangan != null)
				AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
			if (param.kualitasprodukkedua != null)
				AccTool.lookup(driver, tab, "@name='secondQulityProduct'", param.kualitasprodukkedua);
			
			
		}
	
	public static void saveIsiPopup(WebDriver driver, String fileName) {
		
		String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
		String content = "Formula Produksi.Warning : " + "\r\n";
		content = content
				+ "Notifikasi"
				+ "\r\n"
				+ AccTool.getTextValue(driver, 
						ElementType.REPORT, " ", tab)+ "\r\n";
			
		AccTool.writeTextFile(fileName, content);
	}
	
	public static void saveIsiHeader(WebDriver driver, String fileName) {

		String tab = "";
		String content = "Formula Produksi.SaveHeader : " + "\r\n";
		content = content

				+ "\r\n" 
				+ "Produk : "
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, ElementType.LOOKUP, "item", tab)
				+ "Kuantitas : "
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, ElementType.NUMBERFIELD, "quantity", tab)
				+ "Satuan : "
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, ElementType.LOOKUP, "itemUnit", tab)
				+ "No. Batch  : "
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, ElementType.TEXTFIELD, "number", tab)
				+ "\r\n";
		
		AccTool.writeTextFile(fileName, content);
	}
	
	public static void saveIsiFooter(WebDriver driver, String fileName) {

		String tab ="//div[text()='Biaya']/following-sibling::div";
		String tab2 ="//div[text()='Bahan Baku']/following-sibling::div";
		String tab3 ="//div[text()='Total']/following-sibling::div";
		String tab4 ="//div[text()='Produk']/following-sibling::div";
		String tab5 ="//div[text()='Produk lainnya']/following-sibling::div";
		String content = "Formula Produksi.SaveFooter : " + "\r\n";
		content = content

				+ "\r\n" 
				+ "Total Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, tab)
				+ "Total Bahan Baku : "
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, tab2)
				+ "Total : "
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, tab3)
				+ "Total Produk  : "
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, tab4)
				+ "Total Produk Lainnya  : "
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, tab5)
				+ "\r\n";
		
		AccTool.writeTextFile(fileName, content);
	}
	
	public static void SaveListDetail(WebDriver driver, String fileName) {

		AccTool.click(driver, AccurateModule.FORMULA_PRODUKSI.getXpath() + "//*[contains(@href,'tab-item')]");
		String tab = "//*[contains(@id,'tab-item')]";
		String content = "FormulaProduksi.SaveListBahanBaku : " + "\r\n";
		content = content 
			
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.FORMULA_PRODUKSI, tab)
				+ "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
	
	
	public static void SaveListDetailBiaya(WebDriver driver, String fileName) {

		AccTool.click(driver, AccurateModule.FORMULA_PRODUKSI.getXpath() + "//*[contains(@href,'tab-expense')]");
		String tab = "//*[contains(@id,'tab-expense')]";
		String content = "FormulaProduksi.SaveListBiayaProduksi : " + "\r\n";
		content = content 
			
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.FORMULA_PRODUKSI, tab)
				+ "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
	
	
	public static void SaveListDetailHasil(WebDriver driver, String fileName) {

		AccTool.click(driver, AccurateModule.FORMULA_PRODUKSI.getXpath() + "//*[contains(@href,'tab-extra-finish-good')]");
		String tab = "//*[contains(@id,'tab-extra-finish-good')]";
		String content = "FormulaProduksi.SaveListHasilSampingan : " + "\r\n";
		content = content 
			
				+ "\r\n" 
				+ AccTool.getGridValue(driver, AccurateModule.FORMULA_PRODUKSI, tab)
				+ "\r\n";

		AccTool.writeTextFile(fileName, content);
	}
	
	public static void saveDetailBarang(WebDriver driver, String filename)
	{
		log.info("SaveDetailBarang");
		
		String tab ="";
		String tab2 ="";
		String content = "FormulaProduksi.saveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'detail-material')]";
		AccTool.click(driver, "//div[starts-with(@id,'detail-material')]//a[contains(@href,'tab-detailitem')]");
			content = content
					+ "\r\n"
					+ "Nama Barang : "
					+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.item().name')]")
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
					+ "Harga Standar : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.standardCost())", tab)
					+ "Total Harga : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.totalStandardCost())", tab)
					+ "\r\n";
		
			tab2 = "//div[starts-with(@id,'detail-material')]";
			AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
			content = content
					+ "Catatan	: "
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "detailNotes", tab2) 
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailBarang2(WebDriver driver, String filename)
	{
		log.info("SaveDetailBarang");
		
		String tab ="";
		
		String content = "FormulaProduksi.saveDetailBarang : " + "\r\n";
		tab = "//div[starts-with(@id,'detail-material')]";
		AccTool.click(driver, "//div[starts-with(@id,'detail-material')]//a[contains(@href,'tab-detailitem')]");
			content = content
					+ "\r\n"
					+ "Nama Barang : "
					+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.item().name')]")
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
					+ "Harga Standar : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.standardCost())", tab)
					+ "Total Harga : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.totalStandardCost())", tab)
					+ "Tahapan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "processCategory", tab)
					+ "\r\n";
		
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveKeteranganDetailBarang(WebDriver driver, String filename) {
		
//		AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'detail-material')]//*[contains(@id,'tabcustomfield')]");

		
		String tab = "//*[contains(@id,'detail-material')]//*[contains(@id,'tab-customfield')]";
		String content = "FOrmulaProduksi.SaveKeteranganDetailBarang : " + "\r\n";
		content = content  + "\r\n"
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "detailNotes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveDetailBiaya(WebDriver driver, String filename)
	{
		log.info("SaveDetailBiaya");
		
		String tab ="";
		String tab2 ="";
		String content = "FormulaProduksi.saveDetailBiaya : " + "\r\n";
		tab = "//div[starts-with(@id,'detail-expense')]";
		AccTool.click(driver, "//div[starts-with(@id,'detail-expense')]//a[contains(@href,'tab-detailitem')]");
			content = content
					+ "\r\n"
					+ "Nama Biaya : "
					+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.item().name')]")
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
					+ "Harga Standar : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.standardCost())", tab)
					+ "Total Harga : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.totalStandardCost())", tab)
					+ "\r\n";
		
			tab2 = "//div[starts-with(@id,'tab-customfield')]";
			AccTool.click(driver, "//div[starts-with(@id,'detail-expense')]//a[contains(@href,'tab-customfield')]");
			content = content
					+ "Catatan	: "
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "detailNotes", tab2) 
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailBiaya2(WebDriver driver, String filename)
	{
		log.info("SaveDetailBiaya");
		
		String tab ="";
		String tab2 ="";
		String content = "FormulaProduksi.saveDetailBiaya : " + "\r\n";
		tab = "//div[starts-with(@id,'detail-expense')]";
		AccTool.click(driver, "//div[starts-with(@id,'detail-expense')]//a[contains(@href,'tab-detailitem')]");
			content = content
					+ "\r\n"
					+ "Nama Biaya : "
					+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.item().name')]")
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
					+ "Harga Standar : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.standardCost())", tab)
					+ "Total Harga : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.totalStandardCost())", tab)
					+ "Tahapan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "processCategory", tab)
					+ "\r\n";
		
			tab2 = "//div[starts-with(@id,'tab-customfield')]";
			AccTool.click(driver, "//div[starts-with(@id,'detail-expense')]//a[contains(@href,'tab-customfield')]");
			content = content
					+ "Catatan	: "
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "detailNotes", tab2) 
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveKeteranganDetailBiaya(WebDriver driver, String filename) {
		
		String tab = "//div[starts-with(@id, 'detail-expense')]//div[starts-with(@id, 'tab-customfield')]";
		AccTool.click(driver, "//div[starts-with(@id, 'detail-expense')]//*[starts-with(@id, 'tabcustomfield')]");
		
		String content = "FormulaProduksi.SaveKeteranganDetailBiaya : " + "\r\n";
		content = content  + "\r\n"
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailHasil(WebDriver driver, String filename)
	{
		
		String tab ="";
		String tab2 ="";
		String content = "FormulaProduksi.saveDetailHasil : " + "\r\n";
		tab = "//div[starts-with(@id,'detail-extra-finish-good')]";
		AccTool.click(driver, "//div[starts-with(@id,'detail-extra-finish-good')]//a[contains(@href,'tab-detailitem')]");
			content = content
					+ "\r\n"
					+ "Nama Barang : "
					+ AccTool.getTextValue(driver, "//div[contains(@data-bind,'formData.item().name')]")
					+ "Kuantitas : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
					+ "Satuan : "
					+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
					+ "Porsi : "
					+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "portion", tab)
					+ "Harga Standar : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.standardCost())", tab)
					+ "Total Harga : "
					+ AccTool.getTextValue(driver, ElementType.SPAN, "text: app.util.parseNumber(formData.totalStandardCost())", tab)
					+ "\r\n";
		
			tab2 = "//*[starts-with(@id,'detail-extra-finish-good')]//*[starts-with(@id,'tab-customfield')]";
//			AccTool.click(driver, "//div[starts-with(@id,'detail-extra-finish-good')]//a[contains(@href,'tab-notes')]");
			//ui baru
			AccTool.click(driver, "//*[starts-with(@id,'detail-extra-finish-good')]//*[starts-with(@id,'tabcustomfield')]");
			content = content
					+ "Catatan	: "
					+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "expenseNotes", tab2) 
					+ "\r\n";
			
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveKeteranganDetailHasil(WebDriver driver, String filename) {
		
		String tab = "//*[starts-with(@id,'detail-extra-finish-good')]//*[starts-with(@id, 'tab-customfield')]";
//		AccTool.click(driver, "//div[starts-with(@id, 'detail-extra-finish-good-')]//a[contains(@href, 'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[starts-with(@id,'detail-extra-finish-good')]//*[starts-with(@id,'tabcustomfield')]");
					
		String content = "FormulaProduksi.SaveKeteranganDetailHasil : " + "\r\n";
		content = content  + "\r\n"
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	
	
	public static void saveIsiInfoLain(WebDriver driver, String filename)
	{
		log.info("FormulaProduksi.SaveIsiInfoLain");
		
		String tab = "";
		String content = "FormulaProduksi.SaveIsiInfoLain : " + "\r\n";
		tab ="//*[contains(@id,'tab-otherheader')]";
				//Cabang ada 2 kondisi, kantor pusat saja, atau lebih dari 1 cabang, beda kondisi
				String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
				if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, ElementType.COMBOBOX, "branch", tab);
				} else {
					content = content + "Cabang : "
							+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, ElementType.SUMMARY, "branchListOption", tab);
				}
				
				content = content 
				+ "Kualitas Produk Kedua : " 
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, ElementType.LOOKUP, "secondQulityProduct")
				+ "Keterangan : " 
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, ElementType.TEXTAREA, "description")
				+ "\r\n";
				
				
		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveTahapan(WebDriver driver, String fileName) {

		AccTool.click(driver, AccurateModule.FORMULA_PRODUKSI.getXpath() + "//*[contains(@href,'tab-process')]");
		String tab = "//*[contains(@id,'tab-process')]";
		String content = "FormulaProduksi.SaveTahapan : " + "\r\n";
		content = content 
			
				+ "\r\n" 
				+ AccTool.getTextValue(driver, AccurateModule.FORMULA_PRODUKSI, tab)
				+ "\r\n";

		AccTool.writeTextFile(fileName, content);
	}

}
