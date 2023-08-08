package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pekerjaanpesanan.PekerjaanPesananParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;


public class PekerjaanPesananTool extends AbstractAccurateTestCase{
	static Logger log = LogManager.getLogger(PekerjaanPesananParam.class);
	static String w = AccurateModule.PEKERJAAN_PESANAN.getXpath();

	public static void KlikAmbilFavorit(WebDriver driver, String search)
	{
		String xpath = w + "//button[@name='btnGetFrom']";
		AccTool.click(driver, xpath);
		xpath = "//*[contains(@class,'dropdown-menu')]//*[contains(text(),'Favorit')]";
		AccTool.click(driver, xpath);
		if(search != null)
		{
			xpath = "//div[contains(@id, 'copy-memorize-transaction')]";
			AccTool.click(driver, xpath + "//input[@name='lookup']");
			AccTool.lookup(driver, xpath, "@name='lookup'", search);
		}
	}
	
	public static void klikButtonLanjutTabDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		AccTool.waitProgressBar(getWebDriver());
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 300);
	}
	
	//klik lanjut tanpa dissapear
	public static void klikButtonLanjutTabDetailBarang2(WebDriver driver) {
		String path = "//*[contains(@id,'detail-expense')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		
	}
	
	public static void klikButtonLanjutTabDetailBiaya(WebDriver driver) {
		String path = "//*[contains(@id,'detail-expense')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 700);
	}

	public static void klikButtonDeleteDetailBarang(WebDriver driver) {
		String path = "//*[contains(@id,'detail-item')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikButtonDeleteDetailBiaya(WebDriver driver) {
		String path = "//*[contains(@id,'detail-expense')]//*[@name='btnDelete']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikTabNoSeri(WebDriver driver) {
		log.info("PekerjaanPesanan.DetailNOSERI");
		AccTool.click(driver, "//a[contains(@href,'tab-serial-number')]");
	}
	
	
	// klik tab biaya lainnya
	public static void klikTabBiayaLainnya(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-expense')]");
	}
	
	
	// klik tab infolain
	public static void klikTabInfoLain(WebDriver driver){
		AccTool.click(driver, "//*[contains(@href,'tab-otherheader')]");
	}
	
	// klik tab info pekerjaan
	public static void klikTabInfoPekerjaan(WebDriver driver){
//		AccTool.click(driver, "//*[contains(@href,'tab-summary')]");
		AccTool.click(driver, "//*[contains(@data-bind, 'tab-otherheader')]");
	}
	
	public static void klikOKPopUpWarning(WebDriver driver) {
		String path = "//*[@name='btnOk']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikButtonCloseTabDetailBarang(WebDriver driver) {
		String path = "//*[text()='Rincian Barang']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}
	
	public static void klikButtonCloseTabDetailBiaya(WebDriver driver) {
		String path = "//*[text()='Biaya Lainnya']/parent::div//*[@class='btn-close']";
		AccTool.click(driver, path);
		
	}
	
	public static void klikLanjutIsiNoSeri(WebDriver driver) {
		String xpath = "//*[contains(@id,'detail-item')]//*[@name='btnNext']";
		AccTool.click(driver, xpath);
	}
	
	
	public static void isiDetailBarang (WebDriver driver,PekerjaanPesananParam param)
	{
		log.info("pekerjaanpesanan.IsiDetailBarang");
		
		String tab = "//div[starts-with(@id,'tab-item')]";
		AccTool.click(driver, "//*[contains(@href,'tab-item')]");
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailItem'", param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void detailBarang (WebDriver driver,PekerjaanPesananParam param)
	{
		log.info("pekerjaanpesanan.DetailBarang");

		String tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");	
		if(param.namabarang != null)
			AccTool.textField(driver, tab, "@name='detailName'", param.namabarang);
		if(param.kuantitas != null) {
			AccTool.numberField(driver, tab, "@name='quantity'", param.kuantitas);
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
//			WaitTool.delay(500);
		}	
		if(param.kuantitaskontrol != null) {
			AccTool.numberField(driver, tab, "@name='controlQuantity'", param.kuantitaskontrol);
			AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
//			WaitTool.delay(500);
		}
		if(param.unit != null)
			AccTool.lookup(driver, tab, "@name='itemUnit'", param.unit);
		if(param.gudang != null)
			AccTool.lookup(driver, tab, "@name='warehouse'", param.gudang);
		if(param.departemenmandatory != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
		if(param.proyekmandatory != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
		}
	
	
	public static void keteranganBarang(WebDriver driver, PekerjaanPesananParam param)
	{
		//isi window tab detail barang
		String tab = "//*[contains(@id,'details-tab')]//div[starts-with(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'detail-item')]//*[contains(@id,'tabcustomfield')]");
		if(param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);
		if(param.proyek != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyek);
		if(param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='detailNotes'", param.keterangan);
	}
	
	public static void detailBiayaLain (WebDriver driver,PekerjaanPesananParam param)
	{
		log.info("PekerjaanPesanan.DetailBiayaLain");

		String tab= "//div[starts-with(@id,'tab-detailexpense')]";
		
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");
		if(param.namabiaya != null)
			AccTool.textField(driver, tab, "@name='expenseName'", param.namabiaya);
		if(param.jumlah != null)
			AccTool.numberField(driver, tab, "@name='expenseAmount'",	param.jumlah);
		if(param.departemenmandatory != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
		if(param.proyekmandatory != null)	
			AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
		}
		
	
	public static void keteranganBiayaLain(WebDriver driver, PekerjaanPesananParam param)
	{
		log.info("PekerjaanPesanan.keteranganBiayaLain");
//		 isi window tab detail barang ui lama
//		String tab = "//div[starts-with(@id,'tab-expensenotes')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
//		if (param.keteranganlain != null)
//			AccTool.textarea(driver, tab, "@name='expenseNotes'", param.keteranganlain);
				
		//isi window tab detail barang ui baru
		String tab = "//*[contains(@id,'detail-expense')]//*[contains(@id,'tab-customfield')]";
		AccTool.click(driver, "//*[contains(@id,'detail-expense')]//*[contains(@id,'tabcustomfield')]");
		if(param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);
		if(param.proyek != null)	
			AccTool.lookup(driver, tab, "@name='project'", param.proyek);
		if (param.keteranganlain != null)
			AccTool.textarea(driver, tab, "@name='expenseNotes'", param.keteranganlain);
	}
	
	public static void Infolain(WebDriver driver, PekerjaanPesananParam param)
	{
		
		String tab = "//div[starts-with(@id,'tab-otherheader')]";
		AccTool.click(driver, "//a[contains(@href,'tab-otherheader')]");
		if(param.pelanggan != null)
			AccTool.textarea(driver, tab, "@name='customer'", param.pelanggan);
		if(param.keteranganinfolain != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keteranganinfolain);
		if(param.tutuppekerjaan != null)
			AccTool.checkbox(driver, tab, "@name='manualClosed'", param.tutuppekerjaan);
		if(param.cabang != null)
			AccTool.dropDown(driver, tab, "@name='branch'", param.cabang);
	}
	
	public static void isiForm (WebDriver driver,PekerjaanPesananParam param)
	{
		
		String w = AccurateModule.PEKERJAAN_PESANAN.getXpath();
		//String tab = w + "//*[contains(@id,'tab-general')]";
		
		if(param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		if(param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);	
							
	}	
	
	public static void isiBiayaLain (WebDriver driver,PekerjaanPesananParam param)
	{
		log.info("Pekerjaanpesanan.IsiBiayaLain");
		
		String tab = "//div[starts-with(@id,'tab-expense')]";;
		AccTool.click(driver, "//*[contains(@href,'tab-expense')]");
		
		if(param.search != null)
			AccTool.lookup (driver, tab, "@name='searchDetailAccount'", 
		param.search);
			AccTool.waitLoadingMask(driver);
		if (param.scroll !=null)
			AccTool.scrollRowDetail(driver, tab, param.scroll);
			AccTool.waitLoadingMask(driver);
				
	}
	
	public static void isiInfoLain (WebDriver driver,PekerjaanPesananParam param)
	{
		log.info("PekerjaanPesanan.IsiInfoLain");

		String w = AccurateModule.PEKERJAAN_PESANAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-otherheader')]";

		AccTool.click(driver, w + "//*[contains(@href,'tab-otherheader')]");
		
		if(param.pelanggan != null)
			AccTool.lookup (driver, tab, "@name='customer'", param.pelanggan);
		if(param.akunbiaya != null)
			AccTool.lookup (driver, tab, "@name='jobAccount'", param.akunbiaya);
		if(param.akunselisihbiaya != null)
			AccTool.lookup (driver, tab, "@name='differenceAccount'", param.akunselisihbiaya);
		if(param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.keterangan);
		if(param.tutuppekerjaan != null)
			AccTool.checkbox(driver, tab, "@name='manualClosed'", param.tutuppekerjaan);
		if(param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
	}
	
	
	public static void isiDetailNoSeri(WebDriver driver, PekerjaanPesananParam param) {
		log.info("PekerjaanPesanan. Isi No Seri");

		String tab = "//div[starts-with(@id,'tab-serial-number')]";

		if (param.kuantitassn != null)
			AccTool.numberField(driver, tab, "@name='quantitySn'", param.kuantitassn);
		if (param.nomorseri != null)
			AccTool.textField(driver, tab, "@name='numberSn'", param.nomorseri);
		if (param.tanggalkadaluarsa != null)
			AccTool.datePicker(driver, tab, "@name='expiredDateSn'", param.tanggalkadaluarsa);

	}
	
	public static void saveIsiDetailBarang(WebDriver driver, String filename)
	{
		log.info("PekerjaanPesanan.SaveIsiDetailBarang");

		String tab = "";
		String content = "PekerjaanPesanan.SaveIsi : " + "\r\n";
		tab = "//*[contains(@id,'tab-item')]";
		content = content + "Detail Barang" + "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PEKERJAAN_PESANAN, tab) + "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailBiayaLain (WebDriver driver, String filename)
	{
		log.info("PekerjaanPesanan.saveDetailBiayaLain");
		
		String content = "PekerjaanPesanan.SaveBiayaLain : " + "\r\n";
		String tab ="//div[starts-with(@id,'tab-detailexpense')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailexpense')]");

		content = content
				+ "\r\n"
				+ "Tanggal Penambahan : "
				+ AccTool.getTextValue(driver, ElementType.DATEPICKER, "expenseDate", tab)
				+ "Nama Biaya : "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "expenseName", tab)
				+ "Jumlah : "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "expenseAmount", tab)
				+ "Departemen :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek :"
				+ AccTool.getTextValue(driver, "//div[starts-with(@id,'tab-detailexpense')]//div[input[@name='project']]/ul/li/label/span")
				+ "\r\n";
		
		//ui lama
//		tab = "//div[starts-with(@id,'tab-expensenotes')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-expensenotes')]");
		
		//ui baru
		tab = "//*[contains(@id,'expenses-tab')]//*[contains(@id,'customfield-expense')]";
		AccTool.click(driver, "//*[contains(@id,'expenses-tab')]//*[contains(@id,'tabcustomfield')]");
		
		content = content
				+ "Departemen :"
				+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-expense')]//div[input[@name='department']]/ul/li/label/span")
				+ "Proyek :"
				+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-expense')]//div[input[@name='project']]/ul/li/label/span") 
				+ "Catatan	: "
				+ AccTool.getTextValue(driver, ElementType.TEXTAREA, "expenseNotes", tab) 
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveHeader (WebDriver driver, String filename)
	{
		log.info("PekerjaanPesanan.saveHeader");
		
		String content = "PekerjaanPesanan.SaveHeader : " + "\r\n";
		content = content
				+ "\r\n"
				+ "Tanggal : "
				+ AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.DATEPICKER, "transDate")
				+ "Penomoran : "
				+ AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.TEXTFIELD,	"number")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveInfoLainnya (WebDriver driver, String filename)
	{
		log.info("PekerjaanPesanan.saveInfoLainnya");
		
		String content = "PekerjaanPesanan.saveInfoLainnya :" + "\r\n";
		String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		String tab = "//*[contains(@id,'tab-otherheader')]";
		content = content
				+ "\r\n"
				+ "Referensi Pelanggan :"
				+ AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.LOOKUP, "customer", tab)
				+ "Akun Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.LOOKUP, "jobAccount", tab)
				+ "Akun Selisih Biaya : "
				+ AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.LOOKUP, "differenceAccount", tab)
				+ "Keterangan : "
				+ AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.TEXTAREA, "description", tab) 
				+ "Tutup Pekerjaan : "
				+ AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.CHECKBOX, "manualClosed", tab);
				if(WebElementTool.isElementExists(driver, By.xpath(namacabang)))
				{
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.COMBOBOX, "branch", tab) + "\r\n";
				} else {
					content = content + "Cabang : " + AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.SUMMARY, "branchListOption", tab) + "\r\n";
				}

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListDetailBarang(WebDriver driver, String filename) {
		String content = "PekerjaanPesanan.SaveListDetailBarang : " + "\r\n";
		
		content = content
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PEKERJAAN_PESANAN, "//*[contains(@id,'tab-item')]") + "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	//menghilangkan field yg tdk perlu
	public static void saveDetailBarang2(WebDriver driver, String filename) {
		log.info("PekerjaanPesanan.SaveDetailBarang");
		
		String tab = "";
		String content = "PekerjaanPesanan.SaveDetailBarang: " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content
				+ "\r\n"
				+ "Nama Barang :"
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas :"
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
				+ "Kuantitas Kontrol:"
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "controlQuantity", tab)
				+ "Satuan Kuantitas:"
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
				+ "Gudang :"
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
				+ "Departemen :"
	        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
            	+ "Proyek :"
            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span")
				+ "\r\n";

		tab = "//div[starts-with(@id,'tab-detailitem')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tabcustomfield')]");
		content = content
				+ "Departemen :"
	        	+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-item')]//div[input[@name='department']]/ul/li/label/span")
            	+ "Proyek :"
            	+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-item')]//div[input[@name='project']]/ul/li/label/span")
				+ "Catatan	: "
				+ AccTool.getTextValue(driver,ElementType.TEXTAREA, "detailNotes", tab) 
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveListBiayaLainnya(WebDriver driver, String filename) {
		String content = "PekerjaanPesanan.SaveListBiayaLainnya : " + "\r\n";
		
		content = content
				+ "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.PEKERJAAN_PESANAN, "//*[contains(@id,'tab-expense')]") + "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailBarang(WebDriver driver, String filename) {
		log.info("PekerjaanPesanan.SaveDetailBarang");
		
		String tab = "";
		String content = "PekerjaanPesanan.SaveDetailBarang: " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content
				+ "\r\n"
				+ "Tanggal Penambahan : "
				+ AccTool.getTextValue(driver, ElementType.DATEPICKER, "detailDate", tab)
				+ "Nama Barang :"
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Kuantitas :"
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "quantity", tab)
				+ "Kuantitas Kontrol:"
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "controlQuantity", tab)
				+ "Satuan Kuantitas:"
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "itemUnit", tab)
				+ "Gudang :"
				+ AccTool.getTextValue(driver, ElementType.LOOKUP, "warehouse", tab)
				+ "Departemen :"
	        	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='department']]/ul/li/label/span")
            	+ "Proyek :"
            	+ AccTool.getTextValue(driver, "//*[contains(@id,'tab-detailitem')]//div[input[@name='project']]/ul/li/label/span")
				+ "\r\n";

		tab = "//div[starts-with(@id,'tab-detailitem')]";
//		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
		//ui baru
		AccTool.click(driver, "//*[contains(@id,'details-tab')]//*[contains(@id,'tabcustomfield')]");

		content = content
				+ "Departemen :"
	        	+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-item')]//div[input[@name='department']]/ul/li/label/span")
            	+ "Proyek :"
            	+ AccTool.getTextValue(driver, "//*[contains(@id,'customfield-item')]//div[input[@name='project']]/ul/li/label/span")
				+ "Catatan	: "
				+ AccTool.getTextValue(driver, AccurateModule.PEKERJAAN_PESANAN, ElementType.TEXTAREA, "detailNotes", tab) 
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailBarangSebelumSimpan(WebDriver driver, String filename) {
		log.info("PekerjaanPesanan.SaveIsiDetail");
		
		String tab = "";
		String content = "PekerjaanPesanan.SaveDetailBarang: " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailitem')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailitem')]");
		content = content
				+ "\r\n"
				+ "Nama Barang :"
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD, "detailName", tab)
				+ "Stok tersedia:"
				+ AccTool.getTextValue(driver, ElementType.SPAN, "availableStock", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	
	
	public static void saveListRincianDetailBarang(WebDriver driver,String filename)
	{
		log.info("PekerjaanPesanan.saveListRincianDetailBarang");

	String content = "PekerjaanPesanan.SaveList : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-item')]";
	content = content
			+ "\r\n"
			+ AccTool.getGridValue(driver, AccurateModule.PEKERJAAN_PESANAN, tab) 
			+ "\r\n";
	AccTool.writeTextFile(filename, content);

	}
	
	
	
	public static void saveIsiDetailSerialNumber(WebDriver driver, String filename) {
		log.info("Pekerjaan Pesanan.SaveIsiDetailSerialNumber");

		String grid = "";
		String content = "Nomor Seri Detail Barang  : " + "\r\n";

		grid = "//div[contains(@id,'detail-item')]";
		content = content
				+ "\r\n"
				+ "Nomor Seri: " + "\r\n" + AccTool.getGridValue(driver, AccurateModule.UMUM, grid) + "\r\n" + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
	
	public static void saveNotifNoseri(WebDriver driver, String fileName)
	{
		log.info("PengisianNoSeri.SaveNotifNoSeri");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	WaitTool.waitForElementClickable(getWebDriver(), By.xpath(tab), 7);
	String content = "PekerjaanPesanan.SaveNotifNoSeri : " + "\r\n";
	content = content
			+ "\r\n"
			+ AccTool.getTextValue(driver, ElementType.REPORT, " ", tab)+ "\r\n";
		
        AccTool.writeTextFile(fileName, content);
     }
	

	public static void saveFooter(WebDriver driver,  String filename)
	{
		log.info("Save Footer");
//		WaitTool.delay(500);
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.PEKERJAAN_PESANAN.getXpath()+" //div[contains(@id, 'summary-panel')]"), 5);
		
		String content = "PekerjaanPesanan.SaveFooter : " + "\r\n";
		
		String tab ="//div[text()='Total Barang']/following-sibling::div";
		String tab1 ="//div[text()='Total Biaya']/following-sibling::div";
		String tab2 ="//div[text()='Total']/following-sibling::div";
		
		
		AccTool.click(getWebDriver(), tab2);
		AccTool.waitProgressBar(getWebDriver());
		
		content = content
				+ "\r\n"
				+ "Total Barang : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab )
				+ "Total Biaya : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab1 )
				+ "Total : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab2 )
				+ "\r\n";
		AccTool.writeTextFile(filename,  content);		
	}
	
	
	public static void saveFooterAddMaterialAdjusment(WebDriver driver,  String filename)
	{
		log.info("Save Footer");
//		WaitTool.delay(500);
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.PEKERJAAN_PESANAN.getXpath()+"//*[contains(@id,'summary-panel')]"), 5);
		
		String content = "PekerjaanPesanan.SaveFooter : " + "\r\n";
		
		String tab ="//div[text()='Total Barang']/following-sibling::div";
		String tab2 ="//div[text()='Tambahan Barang']/following-sibling::div";
		String tab3 ="//div[text()='Total Biaya']/following-sibling::div";
		String tab4 ="//div[text()='Tambahan Biaya']/following-sibling::div";
		String tab5 ="//div[text()='Total']/following-sibling::div";
		
		
		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());
		
		content = content
				+ "\r\n"
				+ "Total Barang : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab )
				+ "Tambahan Barang : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab2 )
				+ "Total Biaya : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab3 )
				+ "Tambahan Biaya : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab4 )
				+ "Total : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab5 )
				+ "\r\n";
		AccTool.writeTextFile(filename,  content);		
	}
	
	
	//untuk menyimpan footer jika hanya penambahanbahan baku barang
	public static void saveFooterAddMAItem(WebDriver driver,  String filename)
	{
		log.info("Save Footer");
//		WaitTool.delay(500);
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.PEKERJAAN_PESANAN.getXpath()+"//*[contains(@id,'summary-panel')]"), 5);
		
		String content = "PekerjaanPesanan.SaveFooter : " + "\r\n";
		
		String tab ="//div[text()='Total Barang']/following-sibling::div";
		String tab2 ="//div[text()='Tambahan Barang']/following-sibling::div";
		String tab3 ="//div[text()='Total Biaya']/following-sibling::div";
		String tab5 ="//div[text()='Total']/following-sibling::div";
		
		
		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());
		
		content = content
				+ "\r\n"
				+ "Total Barang : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab )
				+ "Tambahan Barang : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab2 )
				+ "Total Biaya : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab3 )
				+ "Total : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab5 )
				+ "\r\n";
		AccTool.writeTextFile(filename,  content);		
	}
	
	//untuk menyimpan footer jika hanya penambahanbahan baku biaya
	public static void saveFooterAddMAExpense(WebDriver driver,  String filename)
	{
		log.info("Save Footer");
//		WaitTool.delay(500);
		WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.PEKERJAAN_PESANAN.getXpath()+"//*[contains(@id,'summary-panel')]"), 5);
		
		String content = "PekerjaanPesanan.SaveFooter : " + "\r\n";
		
		String tab ="//div[text()='Total Barang']/following-sibling::div";
		String tab3 ="//div[text()='Total Biaya']/following-sibling::div";
		String tab4 ="//div[text()='Tambahan Biaya']/following-sibling::div";
		String tab5 ="//div[text()='Total']/following-sibling::div";
		
		
		AccTool.click(getWebDriver(), tab);
		AccTool.waitProgressBar(getWebDriver());
		
		content = content
				+ "\r\n"
				+ "Total Barang : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab )
				+ "Total Biaya : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab3 )
				+ "Tambahan Biaya : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab4 )
				+ "Total : "
				+ ""
				+ AccTool.getTextValue(driver,AccurateModule.PEKERJAAN_PESANAN,tab5 )
				+ "\r\n";
		AccTool.writeTextFile(filename,  content);		
	}
	
	public static void saveInfoPekerjaan(WebDriver driver, String filename)
	{
		log.info("PekerjaanPesanan.saveInfoPekerjaan");
	
		AccTool.click(driver, "//i[@class='icn-transaction-info']");
		
		String content = "PekerjaanPesanan.saveInfoPekerjaan:" + "\r\n";
		content = content
				+ "\r\n"
				+ "Tambahan Barang :"
				+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'totalItemAdjustment')]")
				+ "Tambahan Biaya : "
				+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'totalExpenseAdjustment')]")
				+ "Nilai Total : "
				+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'totalJobWithAdjustment')]");
		
		String a = "//*[contains(@data-bind,'formData.rollOver().number')]";
		if (WebElementTool.isElementVisible(driver, By.xpath(a))) {
			content = content + "Penyelesaian Pesanan :"
		        	+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'formData.rollOver().number')]");
		}
		
		String b = "//*[contains(@data-bind,'formData.rollOver().transDate')]";
		if (WebElementTool.isElementVisible(driver, By.xpath(b))) {
			content = content+ "Tgl Penyelesaian :"
	            	+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'formData.rollOver().transDate')]");
		}
		
		content = content
				+ "Status : "
				+ AccTool.getTextValue(driver, "//*[contains(@data-bind,'doShowTransactionHistoryStatus')]")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	
	public static void saveIsiPopup(WebDriver driver, String fileName)
	{
		log.info("Save isi popup ");
	
	String tab =  "//*[contains(@id,'error-dialog')]//*[@class='no-margin unstyled']//*[@class='fg-crimson']";
	String content = "PekerjaanPesanan.Warning : " + "\r\n";
	content = content
			+ "Notifikasi"
			+ "\r\n"
			+ AccTool.getTextValue(driver, 
					ElementType.REPORT, " ", tab)+ "\r\n";
		
	AccTool.writeTextFile(fileName, content);
	}
	
	
	public static void saveList(WebDriver driver, String filename) {
		log.info("Pekerjaan Pesanan.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "PekerjaanPesanan.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.PEKERJAAN_PESANAN, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	
}
	

