package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.laporan.KategoriLaporan;
import com.cpssoft.web.test.accurate.laporan.LaporanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class LaporanTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(LaporanTool.class);
	
	static String reportContainer = "//div[contains(@class, 'index-report-tab-container')]";
	
	public static void bukaLaporan(WebDriver driver, KategoriLaporan kategori ,String namaLaporan){
		log.info("Buka Laporan " + namaLaporan);
		
		boolean cek_laporan = false;
		String xpathReport = "//h3/a[text()='"+namaLaporan+"']";
		
		WebElement element = driver.findElement(By.xpath(kategori.getXpath()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
		
		AccTool.click(getWebDriver(), kategori.getXpath());
		WaitTool.waitForElementPresent(driver, By.xpath(reportContainer + "//h2[text()='" + kategori.getId() + "']"), 10);
		
		//cek apakah harus klik "Semua Laporan... "
		List<WebElement> we_reportname = driver.findElements(By.xpath(reportContainer + xpathReport));
		cek_laporan = we_reportname.size() > 0;
		if (!cek_laporan){
			AccTool.click(getWebDriver(), reportContainer + "//div[@class='report-more']//a");
		}
		
		AccTool.click(getWebDriver(), reportContainer + xpathReport);
		
		AccTool.waitLoadingMask(driver);
		log.info("Laporan '"+ namaLaporan+ "' sudah dibuka");
		
	}
	
	public static void exportLaporanKeText(WebDriver driver, String filename){
		AccTool.changeReportSaveName(getWebDriver(), filename);
		
		AccTool.click(getWebDriver(), "//button[@name='btnExport']");
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath("//a[contains(@data-bind,'exportReportToTxt')]"), 10);
		WaitTool.delay(500);
		AccTool.click(getWebDriver(), "//a[contains(@data-bind,'exportReportToTxt')]");
		WaitTool.delay(1000);
		
	}
	
	public static void klikLanjutParameterRincianNilaiPersediaan(WebDriver driver){
//		WaitTool.delay(500);
		WaitTool.waitForElementClickable(driver, By.xpath("//button[@name='btnShowReport']"),10);
		AccTool.click(driver, "//button[@name='btnShowReport']");
		AccTool.waitLoadingMask(driver);		
	}
	
	public static void klikLanjutParameterKuantitasBarangPerGudang(WebDriver driver){
//		WaitTool.delay(500);
		WaitTool.waitForElementClickable(driver, By.xpath("//button[@name='btnShowReport']"),10);
		AccTool.click(driver, "//button[@name='btnShowReport']");
		AccTool.waitLoadingMask(driver);
		
	}
	
	public static void parameterRincianNilaiPersediaan(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.tanggaldari != null)
			AccTool.datePicker(driver, tab, "@name='startDate'",param.tanggaldari);
		
		if(param.tanggalsampai != null)
			AccTool.datePicker(driver, tab, "@name='endDate'",param.tanggalsampai);
		if(param.barangjasa != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramItem'", param.barangjasa);
	}

	public static void parameterRincianKetersediaanStokPenjualan(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.pertanggal != null)
			AccTool.datePicker(driver, tab, "@name='asOfDate'",param.pertanggal);
		
		if(param.namabarang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramItem'",param.namabarang);
		
	}
	
	public static void parameterKetersediaanStokPenjualan(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.pertanggal != null)
			AccTool.datePicker(driver, tab, "@name='asOfDate'",param.pertanggal);
		
		if(param.kategoribarang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramSelectionValue'",param.kategoribarang);
		
	}
	
	
	public static void parameterKuantitasBarangPerGudang(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.pertanggal != null)
			AccTool.datePicker(driver, tab, "@name='asOfDate'",param.pertanggal);
		
		if(param.cabang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramBranch'",param.cabang);
		if(param.gudang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramWarehouse'", param.gudang);
	}
	
	public static void parameterStokNoseriProduksi(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.pertanggal != null)
			AccTool.datePicker(driver, tab, "@name='asOfDate'",param.pertanggal);
		
		if(param.namabarang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramItem'",param.namabarang);
		
	}
	
	public static void parameterPekerjaanPesanan(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.daritanggal != null)
			AccTool.datePicker(driver, tab, "@name='startDate'",param.daritanggal);
		
		if(param.sampaitanggal != null)
			AccTool.datePicker(driver, tab, "@name='endDate'",param.sampaitanggal);
		
	}
	
	public static void parameterLaporanKeuangan(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.pertanggal != null)
			AccTool.datePicker(driver, tab, "@name='asOfDate'",param.pertanggal);
		if(param.tanggaldari != null)
			AccTool.datePicker(driver, tab, "@name='startDate'",param.tanggaldari);
		WaitTool.delay(500);
		if(param.tanggalsampai != null)
			AccTool.datePicker(driver, tab, "@name='endDate'",param.tanggalsampai);
		WaitTool.delay(500);
		if(param.tanggaldaricompare != null)
			AccTool.datePicker(driver, tab, "@name='startDateCompare'",param.tanggaldaricompare);
		if(param.tanggalsampaicompare != null)
			AccTool.datePicker(driver, tab, "@name='endDateCompare'",param.tanggalsampaicompare);
		if(param.cabang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramBranch'",param.cabang);
		if (param.hanyatampilkantotal != null)
			AccTool.checkbox(driver, tab, "@name=': $data.value'", param.hanyatampilkantotal);
	}
	
	public static void parameterLimitpelanggan(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.cabang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramBranch'",param.cabang);
	}
	

	public static void parameterPenawaranperPelanggan(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.daritanggal != null)
			AccTool.datePicker(driver, tab, "@name='startDate'",param.daritanggal);
		
		if(param.sampaitanggal != null)
			AccTool.datePicker(driver, tab, "@name='endDate'",param.sampaitanggal);
		
	}
	
	
	public static void parameterTanggal(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.daritanggal != null)
			AccTool.datePicker(driver, tab, "@name='startDate'",param.daritanggal);
		
		if(param.sampaitanggal != null)
			AccTool.datePicker(driver, tab, "@name='endDate'",param.sampaitanggal);
		
	}
	public static void parameterJurnalPerintahKerja(WebDriver driver, LaporanParam param){
		String tab = "";
		
		if(param.noperintah != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramItem'", param.noperintah);
	}
	
	public static void parameterLaporanPeriodeManufaktur(WebDriver driver, LaporanParam param){
		String w = "//div[starts-with(@id,'accurate__report__report-input')]";
		AccTool.click(driver, w);
		
		if(param.dariperiodebulan != null)
			AccTool.combobox(driver, w, "@name='periodStartMonth'", param.dariperiodebulan);
		AccTool.click(driver, w);
		WaitTool.delay(300);
		if(param.sampaiperiodebulan != null)
			AccTool.combobox(driver, w, "@name='periodEndMonth'", param.sampaiperiodebulan);
		if(param.dariperiodetahun != null)
			AccTool.numberField(driver, w, "@name='periodStartYear'", param.dariperiodetahun);
		if(param.sampaiperiodetahun != null)
			AccTool.numberField(driver, w, "@name='periodEndYear'", param.sampaiperiodetahun);
	}
	
	
	public static void klikHanyaTampilkanTotal() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Hanya Tampilkan Total']");
		AccTool.waitLoadingMask(getWebDriver());
		WaitTool.delay(1100);
	}
	
	public static void klikTampilkanAkunInduk() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Tampilkan Akun Induk']");
		AccTool.waitLoadingMask(getWebDriver());
		WaitTool.delay(1100);
	}
	
	public static void klikTampilkanAkunAnak() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Tampilkan Akun Anak']");
		AccTool.waitLoadingMask(getWebDriver());
		WaitTool.delay(1100);
	}
	
	public static void klikTampilkandatadenganSaldoNol() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Tampilkan data dengan Saldo Nol']");
		AccTool.waitLoadingMask(getWebDriver());
		WaitTool.delay(1100);
	}
	
	public static void klikTampilkanSaldoAkunInduk() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Tampilkan Saldo Akun Induk']");
		AccTool.waitLoadingMask(getWebDriver());
		WaitTool.delay(1100);
    }
	
	public static void klikButtonTampilkan(WebDriver driver){
		WaitTool.delay(500);
		WaitTool.waitForElementClickable(driver, By.xpath("//button[@name='btnShowReport']"),10);
		AccTool.click(driver, "//button[@name='btnShowReport']");
		
	}
	
	public static void klikSemuaLaporan(WebDriver driver){
		AccTool.click(getWebDriver(), "//*[contains(@class,'report-more')]");
		AccTool.waitLoadingMask(getWebDriver());
		WaitTool.delay(1100);
		
	}
	
	public static void klikHistoriPekerjaanPesanan() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'row no-margin index-report')]//*[text()='Pekerjaan Pesanan']");
		AccTool.click(getWebDriver(), "//*[contains(@class,'report-li-text')]//*[text()='Laporan Histori Pekerjaan Pesanan']");
		AccTool.waitLoadingMask(getWebDriver());
		WaitTool.delay(1100);
	}
	
	public static void parameterLaporanPeriode(WebDriver driver, LaporanParam param){
		String w = "//div[starts-with(@id,'accurate__report__report-input')]";
		AccTool.click(driver, w);
		
		if(param.dariperiodebulan != null)
			AccTool.combobox(driver, w, "@name='periodStartMonth'", param.dariperiodebulan);
		AccTool.click(driver, w);
		WaitTool.delay(300);
		if(param.sampaiperiodebulan != null)
			AccTool.combobox(driver, w, "@name='periodEndMonth'", param.sampaiperiodebulan);
		if(param.dariperiodetahun != null)
			AccTool.numberField(driver, w, "@name='periodStartYear'", param.dariperiodetahun);
		if(param.sampaiperiodetahun != null)
			AccTool.numberField(driver, w, "@name='periodEndYear'", param.sampaiperiodetahun);
		if(param.per != null)
			AccTool.numberField(driver, w, "@name='asOfYear'", param.per);
		if(param.periodebulan != null)
			AccTool.combobox(driver, w, "@name='periodMonth'", param.periodebulan);
		if(param.periodetahun != null)
			AccTool.numberField(driver, w, "@name='periodYear'", param.periodetahun);
		if(param.matauang != null)
			AccTool.lookupWithoutClear(driver, w, "@name='paramCurrency'",param.matauang);
	}
	
	public static void parameterTambahan(WebDriver driver, LaporanParam param){
		WaitTool.delay(500);
//		String w = "//*[contains(@href,'tab-report-parameter')]";	
		String tab = "//*[contains(@id,'tab-report-parameter')]";
//		AccTool.click(driver, w);

		if(param.departemen != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramDepartment'",param.departemen);
		if(param.cabang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramBranch'",param.cabang);
		if(param.gudang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramWarehouse'", param.gudang);
		if(param.proyek != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramProject'",param.proyek);
		if(param.kasbank != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramBank'",param.kasbank);
		WaitTool.delay(1000);
		if(param.barangjasa != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramItem'", param.barangjasa);
		if(param.pelanggan != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramCustomer'", param.pelanggan);
		if(param.tenagapenjual != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramSalesman'", param.tenagapenjual);
		if(param.pemasok != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramVendor'", param.pemasok);
		if(param.kategoribarang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramSelectionValue'", param.kategoribarang);
		if(param.noseriproduksi != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramSelectionValue'", param.noseriproduksi);
		if(param.pergudang != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramSelectionValue'", param.pergudang);
		if(param.nopekerjaanpesanan != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramSelectionValue'", param.nopekerjaanpesanan);
		if(param.asettetap != null)
			AccTool.lookupWithoutClear(driver, tab, "@name='paramItem'", param.asettetap);
	}
	
	public static void klikKolomParameter(WebDriver driver){
		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-widget')]//*[text()='Kolom']");
	}
	
	public static void klikTambahFilter(WebDriver driver){
		AccTool.click(getWebDriver(), "//*[contains(@id,'tab-data-filter')]//*[@name='btnAddFilter']");		
	}
	
	public static void klikSimpanFilterData(WebDriver driver){
		AccTool.click(getWebDriver(), "//*[contains(@id,'accurate__report__report-modify-filter')]//*[@name='btnSave']");		
	}
	
	public static void isiFilterData(WebDriver driver, LaporanParam param)
	{
		log.info("DaftarLaporan.IsiFIlterData");
		
		String w = "//div[starts-with(@id,'accurate__report__report-modify-filter')]";
		if(param.kolom != null)
		{
			switch (param.kolom.toLowerCase()) {
			
			case "tanggal":
				AccTool.combobox(driver, w, "@name='name'", "Tanggal");
				WaitTool.delay(500);
				if(param.nilai != null)
					AccTool.datePicker(driver, w, "@name='valueDate'", param.nilai);
				break;
				
			case "tipe transaksi jurnal":
				AccTool.combobox(driver, w, "@name='name'", "Tipe Transaksi Jurnal");
				WaitTool.delay(500);
				if(param.cbtipetransaksi != null)
					AccTool.checkbox(driver, w, "@name='transactionType'", param.cbtipetransaksi);
				break; 
				
			case "no bukti #":
			
				AccTool.combobox(driver, w, "@name='name'", "No Bukti #");
				if(param.nilai != null)
					AccTool.textField(driver, w, "@name='valueText'", param.nilai);			
				break;
				
			case "kode #":
				
				AccTool.combobox(driver, w, "@name='name'", "Kode #");
				if(param.nilai != null)
					AccTool.lookup(driver, w, "@name='accountNo'", param.nilai);			
				break;
				
            case "nama perkiraan":
				
				AccTool.combobox(driver, w, "@name='name'", "Nama Perkiraan");
				if(param.nilai != null)
					AccTool.lookup(driver, w, "@name='accountName'", param.nilai);			
				break;
				
            case "memo":
    			
				AccTool.combobox(driver, w, "@name='name'", "Memo");
				if(param.nilai != null)
					AccTool.textField(driver, w, "@name='valueText'", param.nilai);			
				break;
				
            case "debit":
    			
				AccTool.combobox(driver, w, "@name='name'", "Debit");
				if(param.nilai != null)
					AccTool.numberField(driver, w, "@name='valueNumeric'", param.nilai);			
				break;
				
            case "kredit":
    			
				AccTool.combobox(driver, w, "@name='name'", "Kredit");
				if(param.nilai != null)
					AccTool.numberField(driver, w, "@name='valueNumeric'", param.nilai);			
				break;
				
            case "prime debit":
    			
				AccTool.combobox(driver, w, "@name='name'", "Prime Debit");
				if(param.nilai != null)
					AccTool.numberField(driver, w, "@name='valueNumeric'", param.nilai);			
				break;
				
            case "prime credit":
    			
				AccTool.combobox(driver, w, "@name='name'", "Prime Credit");
				if(param.nilai != null)
					AccTool.numberField(driver, w, "@name='valueNumeric'", param.nilai);			
				break;
			}	

		if(param.operator != null)
			AccTool.combobox(driver, w, "@name='operator'", param.operator);		
		    AccTool.waitProgressBar(driver);
		
	}
	
	}
	
	public static void klikModifikasi(WebDriver driver){
		AccTool.click(getWebDriver(), "//button[@name='btnModifyReport']");
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.waitForElementClickable(getWebDriver(), By.xpath("//div[input[@name='keywordAvailableColumn']]"), 10);
		WaitTool.delay(500);
	}
	
	public static void cariKolom(WebDriver driver, String keywords) {

		String tab = "//div[starts-with(@id,'tab-available-columns')]";

		AccTool.textField(driver, tab, "@name='keywordAvailableColumn'", keywords);
		
		String xpath = "//li[@class='jstree-closed']";
		WaitTool.waitForElementVisible(driver, By.xpath(xpath), 30);
		WaitTool.delay(3000);	
	}
	
	public static void klikKolomData(WebDriver driver, String idKolom, String namaKolom) {
		String xpath = "//div[contains(@id,'available-columns')]//li[@id='"+ idKolom +"']//a[text()='"+namaKolom+"']";
		WaitTool.waitForElementVisible(driver, By.xpath(xpath), 30);
		WaitTool.delay(1000);	
		AccTool.doubleclick(getWebDriver(), xpath);
		WaitTool.delay(1000);
	}
	
	public static void klikSimpanModifikasi(WebDriver driver){
		AccTool.click(getWebDriver(), "//*[contains(@data-bind,'submitForm')]");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikRefresh(WebDriver driver){
		AccTool.click(getWebDriver(), "//button[@name='btnRefresh']");	
		AccTool.waitLoadingMask(driver);
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikCetakLaporan(WebDriver driver) {
		AccTool.click(getWebDriver(), "//button[@name='btnPrint']");
		WaitTool.delay(2000);
	}
	
	public static void cekPrintPreviewLaporan(WebDriver driver, String filename) {
		AccTool.waitLoadingMask(driver);
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(3));
		
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//String btnPrint = "//button[@name='btnPrint']";
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(btnPrint)));
		
		//WaitTool.delay(12000);
		driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
		
		String hasil = "";
		String jsPrint = "return document.querySelector('print-preview-app')" +
                ".shadowRoot.querySelector('print-preview-sidebar')" +
                ".shadowRoot.querySelector('print-preview-header')" +
                ".shadowRoot.querySelector('h1.title')";
      
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement printButton;       
        printButton = (WebElement) jse.executeScript(jsPrint);
        hasil = printButton.getText();
        //log.info(hasil);
        
		String result = "Berhasil membuka Print Preview Laporan";
		String warn = "Ada error ketika print laporan";

        if (hasil.equals("Print")) {
				//log.info("sudah ketemu");
				result = result + "\r\n";
				AccTool.writeTextFile(filename, result);
        } else {
				//log.warn("Terjadi error ketika print list");
				warn = warn + "\r\n";
				AccTool.writeTextFile(filename, warn);
		}
        
        String jsCancel = "return document.querySelector('print-preview-app')" +
                ".shadowRoot.querySelector('print-preview-sidebar')" +
                ".shadowRoot.querySelector('print-preview-button-strip')" +
                ".shadowRoot.querySelector('cr-button.cancel-button')";
        
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        WebElement cancelButton;       
        cancelButton = (WebElement) jse2.executeScript(jsCancel);
        cancelButton.click();  
        
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		WaitTool.delay(1000);
	}
	
	public static void klikMemorize(WebDriver driver){
		AccTool.click(getWebDriver(), "//button[@name='btnMemorize']");
		
		String xpath = "//*[contains(@id,'tab-memorize-report')]";
		WaitTool.waitForElementVisible(driver, By.xpath(xpath), 30);
	}
	
	public static void isiNamaMemorize(WebDriver driver, LaporanParam param){
		String tab = "//div[starts-with(@id,'accurate__report__save-memorize')]";
		if(param.namaMemorize != null)
		AccTool.textField(driver, tab, "@name='name'", param.namaMemorize);	
	}
	
	public static void klikLanjutMemorize(WebDriver driver){
		AccTool.click(getWebDriver(), "//button[@name='btnNext']");
	}

	public static void klikFavorit(WebDriver driver){
		AccTool.click(getWebDriver(), "//button[@name='btnFavorite']");
		WaitTool.delay(2000);
		AccTool.waitLoadingMask(driver);
	}
	
	public static void cekFavorit(WebDriver driver, String filename) {
		WaitTool.checkPageIsReady(driver);
		WaitTool.delay(2000);
		String iconFavorit = "//*[contains(@class,'darkBlue')]";
		String result = "Berhasil menambah ke Favorit";
		String warn = "Tidak berhasil menambah ke Favorit";
		
		if (WebElementTool.isElementVisible(driver, By.xpath(iconFavorit))) {
			log.info("masuk bener");
			result = result + "\r\n";
			AccTool.writeTextFile(filename, result);
        } else {
        	log.info("Terjadi error ketika add favorit");
			warn = warn + "\r\n";
			AccTool.writeTextFile(filename, warn);
		}
		WaitTool.delay(500);
	}
	
	public static void klikExportPDF(WebDriver driver){
		AccTool.dropDown(getWebDriver(), AccurateModule.DAFTAR_LAPORAN.getXpath(),
				"//div[contains(@class, 'span12')]", "PDF");
		WaitTool.delay(500);
		WaitTool.checkPageIsReady(getWebDriver());
	}
	
	public static void klikExportExcel(WebDriver driver){
		AccTool.dropDown(getWebDriver(), AccurateModule.DAFTAR_LAPORAN.getXpath(),
				"//div[contains(@class, 'span12')]", "Excel");
		WaitTool.delay(500);
		WaitTool.checkPageIsReady(getWebDriver());
	}
	
	public static void klikExportText(WebDriver driver){
		AccTool.dropDown(getWebDriver(), AccurateModule.DAFTAR_LAPORAN.getXpath(),
				"//div[contains(@class, 'span12')]", "Text");
		WaitTool.delay(500);
		WaitTool.checkPageIsReady(getWebDriver());
	}
	
	public static void klikExportMemorize(WebDriver driver){
		AccTool.dropDown(getWebDriver(), AccurateModule.DAFTAR_LAPORAN.getXpath(),
				"//div[contains(@class, 'span12')]", "Memorize");
		WaitTool.delay(500);
		WaitTool.checkPageIsReady(getWebDriver());
	}
	
	public static void expandFolderKolomModifikasi(WebDriver driver, String namaFolder){
		WaitTool.delay(500);
		String xpath = "//*[text()='" +namaFolder+ "']/preceding-sibling::ins";
		WaitTool.waitForElementVisible(driver, By.xpath(xpath), 30);
		AccTool.click(getWebDriver(), xpath);
		WaitTool.delay(200);
	}
	
	public static void klikKolomModifikasi(WebDriver driver, String namaKolom){
		String xpath = "//*[@class='ui-sortable-handle']//*[.='" + namaKolom + "']/ancestor::div[1]/preceding-sibling::div/div";
		
		AccTool.moveToElementAndClick(getWebDriver(), xpath);
	}
	
	public static void expandFolderKolomModifikasi(WebDriver driver,String idKolom, String namaFolder){
		String xpath = "//*[text()='" +namaFolder+ "']/ancestor::*[contains(@id, '" +idKolom+ "')]/ins";
		WaitTool.waitForElementVisible(driver, By.xpath(xpath), 30);
		WaitTool.delay(500);
		AccTool.moveToElementAndClick(getWebDriver(), xpath);
		WaitTool.delay(200);
	}
	
	public static void cekLaporanMemorize(WebDriver driver, String namaLaporan, String filename) {
		String laporan = "//h3/a[text()='"+namaLaporan+"']";
		
		String result = namaLaporan + " Tersedia pada memorize";
		String warn = namaLaporan + " Tidak tersedia pada memorize";	
		
		if (driver.findElements(By.xpath(laporan)).size() > 0) {
			log.info(result);
			result =  "\r\n" + result + "\r\n" + "\r\n";
			AccTool.writeTextFile(filename, result);
        } else {
        	log.info(warn);
			warn = "\r\n" + warn + "\r\n" + "\r\n";
			AccTool.writeTextFile(filename, warn);
		}
		WaitTool.delay(500);
	}
	
	public static void cekLaporanFavorit(WebDriver driver, String namaLaporan, String filename) {
		String laporan = "//h3/a[text()='"+namaLaporan+"']";
		String result = namaLaporan + " Tersedia pada Favorit";
		String warn = namaLaporan + " Tidak tersedia pada Favorit";	
		
		if (driver.findElements(By.xpath(laporan)).size() > 0) {
			log.info(result);
			result =  "\r\n" + result + "\r\n" + "\r\n";
			AccTool.writeTextFile(filename, result);
        } else {
        	log.info(warn);
			warn = "\r\n" + warn + "\r\n" + "\r\n";
			AccTool.writeTextFile(filename, warn);
		}
		WaitTool.delay(500);
	}
	
	public static void bukaKategoriLaporan(WebDriver driver, KategoriLaporan kategori ){
		log.info("Buka Laporan");
		
		WebElement element = driver.findElement(By.xpath(kategori.getXpath()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
		
		AccTool.click(getWebDriver(), kategori.getXpath());
		WaitTool.waitForElementPresent(driver, By.xpath(reportContainer + "//h2[text()='" + kategori.getId() + "']"), 10);
		
		AccTool.waitLoadingMask(driver);
		log.info("Kategori" + kategori + "Laporan sudah dibuka");
		
	}
	
	public static void hapusLaporanMemroize(WebDriver driver){
				
		AccTool.click(getWebDriver(),"//button[@name='btnDeleteMemorize']");
		WaitTool.waitForElementPresent(driver, By.xpath("//button[@name='btnOk']"), 10);
		
		AccTool.click(getWebDriver(),"//button[@name='btnOk']");
		
		AccTool.waitLoadingMask(driver);
		log.info("Berhasil Hapus");
		
	}
	
}
