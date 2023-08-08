package com.cpssoft.web.test.accurate.tool;

import static com.cpssoft.web.test.framework.AbstractSeleniumTestCase.getWebDriver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pencatatangaji.PencatatanGajiParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PencatatanGajiTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(PencatatanGajiTool.class);

	public static void klikBtnTunjanganPensiunTHTJHT(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-employee-payment')]//div[label[text()='Tunjangan Pensiun/THT/JHT']]/following-sibling::div/button[@name='btnCalculateFeeRate']";
		AccTool.click(driver, path);
		WaitTool.waitForElementClickable(driver, By.xpath(path), 9);
		AccTool.waitLoaderMedium(driver);
	}

	public static void klikBtnPerhitunganPPhPencatatanGaji(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-employee-payment')]//button[@name='btnPphAllowance']";
		WaitTool.waitForElementClickable(driver, By.xpath(path), 9);
		AccTool.click(driver, path);
		AccTool.waitProgressBar(getWebDriver());
		AccTool.waitLoaderMedium(getWebDriver());
	}

	public static void klikBtnTunjanganPremiKesehatan(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-employee-payment')]//div[label[text()='Tunjangan Premi Kesehatan']]/following-sibling::div/button[@name='btnCalculateFeeRate']";
		AccTool.click(driver, path);
		WaitTool.waitForElementClickable(driver, By.xpath(path), 9);
		AccTool.waitLoaderMedium(driver);
	}

	public static void klikBtnIuranPensiun(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-employee-payment')]//div[label[text()='Iuran Pensiun/THT/JHT']]/following-sibling::div/button[@name='btnCalculateFeeRate']";
		AccTool.click(driver, path);
		WaitTool.waitForElementClickable(driver, By.xpath(path), 9);
		AccTool.waitLoaderMedium(driver);
	}

	public static void klikBtnPotonganPremiKesehatan(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-employee-payment')]//div[label[text()='Potongan Premi Kesehatan']]/following-sibling::div/button[@name='btnCalculateFeeRate']";
		AccTool.click(driver, path);
		WaitTool.waitForElementClickable(driver, By.xpath(path), 9);
		AccTool.waitLoaderMedium(driver);
	}

	public static void klikRefreshPage(WebDriver driver)
	{
		String path = "//a[contains(@href,'tab-detailemployee')]";
		AccTool.click(driver, path);
		AccTool.waitLoaderMedium(driver);
	}

	public static void klikBtnLanjutPencatatanGaji(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-employee-payment')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnLanjutPencatatanGajiFavorit(WebDriver driver)
	{
		String path = "//*[contains(@id,'copy-memorize-transaction')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBtnLanjutPencatatanGajiTambahFavorit(WebDriver driver)
	{
		String path = "//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]//button[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}

	public static void klikBtnPPhNonBulanan(WebDriver driver)
	{
		String path = "//*[contains(@id,'detail-employee-payment')]//button[@name='btnCalculatePphAmount']";
		WaitTool.waitForElementClickable(driver, By.xpath(path), 9);
		AccTool.click(driver, path);
		AccTool.waitLoaderMedium(driver);
	}

	public static void isiHeader(WebDriver driver, PencatatanGajiParam param) {
		log.info("PencatatanGaji.IsiHeader");

		String w = AccurateModule.PENCATATAN_GAJI.getXpath();
		
		if (param.tipepembayaran != null)
			AccTool.combobox(driver, w, "@name='employeePaymentType'", param.tipepembayaran);
		
		if (param.cabang != null)
			AccTool.combobox(driver, w, "@name='branch'", param.cabang);
		
		if (param.bulan != null)
			AccTool.combobox(driver, w, "@name='paymentMonth'", param.bulan);
		
		if (param.tahun != null)
			AccTool.combobox(driver, w, "@name='paymentYear'", param.tahun);
		
		if (param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", param.penomoran);
		
		if (param.no != null)
			AccTool.textField(driver, w, "@name='number'", param.no);
		
		if (param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", param.tanggal);
		
		if (param.jatuhtempo != null)
			AccTool.datePicker(driver, w, "@name='dueDate'", param.jatuhtempo);
	}

	public static void searchKaryawan(WebDriver driver, PencatatanGajiParam param) {
		log.info("PencatatanGaji.IsiSearchKaryawan");
		
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-detail')]";		
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-detail')]");
				
		AccTool.lookup(driver, tab, "@name='searchDetailEmployee'", param.search);			
		AccTool.scrollRowDetail(driver, tab, param.scroll);				
	}
	
	public static void isiInfoLain(WebDriver driver, PencatatanGajiParam param) {
		log.info("PencatanGaji.IsiInfoLain");
		
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-employeeheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-employeeheader')]");
		
		if (param.searchhutangbeban != null)
			AccTool.lookup(driver, tab, "@name='expensePayable'", param.searchhutangbeban);
			AccTool.waitLoadingMask(driver);
		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='description'", param.catatan);
			AccTool.waitLoadingMask(driver);
	}
	
	//28 mei 2018 --> isi akun PPH
	public static void isiInfoLain2(WebDriver driver, PencatatanGajiParam param) {
		log.info("PencatanGaji.IsiInfoLain");
		
		String w = param.w;
		String tab = w + "//*[contains(@id,'tab-employeeheader')]";
		
		AccTool.click(driver, w + "//a[contains(@href,'tab-employeeheader')]");
		
		if (param.searchakunPPH != null)
			AccTool.lookup(driver, tab, "@name='pphAccount'", param.searchakunPPH);
			AccTool.waitLoadingMask(driver);
		
	}
	public static void saveInfoLainnya(WebDriver driver,  String filename)
	{
		log.info("PencatatanGaji.saveInfolainnya");

	String content = "PencatatanGaji.SaveInfoLainnya : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-employeeheader')]";
	content = content 
			+ "Hutang Beban : "
			+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
					ElementType.LOOKUP, "expensePayable", tab)
			+ "Akun Hutang PPH : "
			+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
					ElementType.LOOKUP, "pphAccount", tab)
			
	        + "Catatan : "
	        + AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
			ElementType.TEXTAREA, "description", tab) + "\r\n"; 
	AccTool.writeTextFile(filename,  content);

	}
	
	
	public static void saveHeader(WebDriver driver,  String filename)
	{
		log.info("PencatatanGaji.SaveHeader");


		String tab = "";
		String content = "PencatatanGaji.SaveHeader : " + "\r\n";

		content = content
				+ "Tipe Pembayaran : "
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
						"//div[div[div[contains(@data-bind,'paymentBranchName')]]]/preceding-sibling::div/div/div[@class='text-panel-disabled']")
				+ "Cabang : "		
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
						"//div[contains(@data-bind,'paymentBranchName')]")
				+ "Bulan : "		
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
						"//div[contains(@data-bind,'periodMonthName')]")
//				+ "Tahun : "		
//				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
//						"//div[@class='text-panel-value']")
				+ "Penomoran : "		
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
						ElementType.TEXTFIELD, "typeAutoNumber", tab)
				+ "Nomor : "		
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
						ElementType.TEXTFIELD, "number", tab)
				+ "Tanggal : "		
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
						ElementType.DATEPICKER, "transDate", tab)
				+ "Tgl Jatuh Tempo : "		
				+ AccTool.getTextValue(driver, AccurateModule.PENCATATAN_GAJI,
						ElementType.TEXTFIELD, "dueDate", tab) + "\r\n";
			AccTool.writeTextFile(filename,  content);
	}
	
	public static void saveListRincianGaji(WebDriver driver,  String filename)
	{
		log.info("PencatatanGaji.saveListRincianGaji");

	String content = "PencatatanGaji.SaveListRincianGaji : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-detail')]";
	content = content 
			+ AccTool.getGridValue(driver, AccurateModule.PENCATATAN_GAJI,
					tab) + "\r\n";
	AccTool.writeTextFile(filename,  content);

	}
		
	//isi rincian untuk pegawai tetap dan pegawai tidak tetap
	public static void isiRincianKaryawan(WebDriver driver, PencatatanGajiParam param) {
		log.info("PencatatanGaji.IsiRincianKaryawan");

		log.info("Rincian Karyawan");

		String tab = "";
		if(param.tab != null)
		switch((param.tab).toLowerCase()){
		
		case "rincian gaji":
//			tab= "//div[starts-with(@id,'tab-detailemployee')]";
			
			AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
			if (param.tunjanganpensiun != null)
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[3]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjanganpensiun);
			if (param.gajipokok != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee--9--0')]//div[@class='grid fluid no-margin']/div[5]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[5]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.gajipokok);
				
			if (param.tunjanganpph != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[6]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[6]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjanganpph);
			
			if (param.tunjanganjabatan != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[7]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[7]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjanganjabatan);
				
			if (param.tunjanganmakan != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[8]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[8]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjanganmakan);
				
			if (param.tunjangantransportasi != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[9]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[9]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjangantransportasi);
				
			if (param.tunjangantelekomunikasi != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[10]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[10]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjangantelekomunikasi);
			
			if (param.tunjanganlembur != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[11]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[11]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjanganlembur);
			
			if (param.tunjanganpremiasuransi != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[12]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[12]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjanganpremiasuransi);
//				AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");

			if (param.tunjanganprogramjkk != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[13]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[13]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjanganprogramjkk);
				
			if (param.tunjanganprogramjkm != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[14]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[14]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjanganprogramjkm);		
				
				//an additional column
//			if (param.potongangaji != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[28]";
//				AccTool.numberField(driver, tab, "@name='employeeFee'", param.potongangaji);
			
			if (param.pengurangangaji != null)
				AccTool.moveToElementAndClick(getWebDriver(), "//label[.='Pengurangan Gaji']");

//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[30]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[30]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.pengurangangaji);
				
			if (param.iuranbulanan != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[31]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[31]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.iuranbulanan);
			
			if (param.potongancicilan != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[32]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[32]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.potongancicilan);	
				
			if (param.iuranpensiun != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[33]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[33]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.iuranpensiun);
			
			if (param.potonganpremikesehatan != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[34]";
				tab= "//div[contains(@id, 'tab-detailemployee')]/div/div[34]";
				AccTool.waitLoaderMedium(getWebDriver());
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.potonganpremikesehatan);
			break;
			
		case "catatan":
			tab = "//*[starts-with(@id,'tab-customfield')]";			
			
			AccTool.click(driver, "//*[starts-with(@id,'tabcustomfield')]");
			if(param.catatan != null)
				AccTool.textarea(driver, tab, "@name='memo'", param.catatan);			
			break;
		}
	}
	
	//isi rincian untuk bukan pegawai (beda di array)
	public static void isiRincianBukanKaryawan (WebDriver driver, PencatatanGajiParam param)
	{
		log.info("PencatatanGaji.IsiRincianBukanKaryawan");

		log.info("Rincian Bukan Karyawan");

		String tab = "";
		if(param.tab != null)
		switch((param.tab).toLowerCase()){
		
		case "rincian gaji":
//			tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']";
			
			AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
			if (param.gajipokok != null)
				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[3]";
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.gajipokok);
				
				break;
				
		case "catatan":
			tab = "//div[starts-with(@id,'tab-notes')]";			
			
			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
			if(param.catatan != null)
				AccTool.textarea(driver, tab, "@name='memo'", param.catatan);			
			break;
	}
}
	
	//save rincian untuk pegawai tetap dan pegawai tidak tetap
	public static void saveRincianKaryawan(WebDriver driver,  String filename)
	{
		log.info("PencatatanGaji.SaveRincianKaryawan");


		String tab = "";
		String tab5 = "";
		String tab6 = "";
		String tab7 = "";
		String tab8 = "";
		String tab9 = "";
		String tab10 = "";
		String tab11 = "";
		String tab12 = "";
		String tab13 = "";
		String tab14 = "";
		String tab29 = "";
		String tab30 = "";
		String tab31 = "";
		String tab32 = "";
		String tab33 = "";
		String tab34 = "";
		String tab36 = "";
		String tab37 = "";
		String tab38 = "";
		String content = "PencatatanGaji.SaveRincianKaryawan : " + "\r\n";
		
		tab= "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[3]";
		tab5 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[5]";
		tab6 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[6]";
		tab7 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[7]";
		tab8 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[8]";
		tab9 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[9]";
		tab10 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[10]";
		tab11 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[11]";
		tab12 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[12]";
		tab13 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[13]";
		tab14 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[14]";
		tab29 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[29]";
		tab30 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[30]";
		tab31 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[31]";
		tab32 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[32]";
		tab33 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[33]";
		tab34 = "//*[starts-with(@id,'tab-detailemployee')]/*[contains(@class,'grid fluid no-margin')]/div[34]";
		tab36 = "//div[starts-with(@id,'tab-detailemployee')]//span[contains(@data-bind,'formData.pphAmount()')]";
		tab37 = "//div[starts-with(@id,'tab-detailemployee')]//span[contains(@data-bind,'formData.exceedPphAmount()')]";
		tab38 = "//div[starts-with(@id,'tab-detailemployee')]//span[contains(@data-bind,'formData.amount()')]";
		
		AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
		content = content
				+ "Tunjangan Pensiun/THT/JHT : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab)

				+ "Gaji Pokok : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab5)

				+ "Tunjangan PPh : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab6)

				+ "Tunjangan Jabatan : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab7)

				+ "Tunjangan Makan : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab8)

				+ "Tunjangan Transportasi : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab9)

				+ "Tunjangan Telekomunikasi : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab10)
				
				+ "Tunjangan Lembur : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab11)

				+ "Tunjangan Premi Asuransi : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab12)
				
				+ "Tunjangan Program JKK : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab13)
				
				+ "Tunjangan Program JKM : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab14)

				+ "Potongan Gaji: "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab29)
				
				+ "Pengurangan Gaji : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab30)
				
				+ "Iuran Bulanan dan Lainnya : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab31)
				
				+ "Potongan Cicilan : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab32)
				
				+ "Iuran Pensiun/THT/JHT : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab33)

				+ "Potongan Premi Kesehatan : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab34)
				
				+ "Pajak Penghasilan : "
				+ AccTool.getTextValue(driver, 
						ElementType.REPORT, "employeeFee", tab36)

				+ "Kelebihan Pajak : "
				+ AccTool.getTextValue(driver, 
						ElementType.REPORT, "employeeFee", tab37)

				+ "Gaji Dibayarkan : "
				+ AccTool.getTextValue(driver, 
						ElementType.REPORT, "employeeFee", tab38)

				+ "\r\n";
			AccTool.writeTextFile(filename,  content);
	}
	
	//save rincian untuk bukan pegawai
	public static void saveRincianBukanKaryawan(WebDriver driver,  String filename)
	{
		log.info("PencatatanGaji.SaveRincianBukanKaryawan");
		
		String tab3 = "";
		String tab4 = "";
		String tab5 = "";
		String tab6 = "";
		String tab7 = "";
		
		tab3 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid no-margin')]/div[3]";
		tab4 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid no-margin')]/div[4]";
		tab5 = "//div[starts-with(@id,'tab-detailemployee')]//span[contains(@data-bind,'formData.pphAmount()')]";
		tab6 = "";
		tab7 = "//div[starts-with(@id,'tab-detailemployee')]//span[contains(@data-bind,'formData.amount()')]";
		
		String content = "PencatatanGaji.SaveRincianBukanKaryawan : " + "\r\n";
		
		AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
		content = content
				+ "Gaji Pokok : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab3)
				
				+ "Tunjangan PPh : "
				+ AccTool.getTextValue(driver, 
						ElementType.NUMBERFIELD, "employeeFee", tab4)

				+ "Pajak Penghasilan : "
				+ AccTool.getTextValue(driver, 
						ElementType.REPORT, "employeeFee", tab5)

				+ "No Bukti Potong : "
				+ AccTool.getTextValue(driver, 
						ElementType.TEXTFIELD, "pphNumber", tab6)

				+ "Gaji Dibayarkan : "
				+ AccTool.getTextValue(driver, 
						ElementType.REPORT, "employeeFee", tab7)

				+ "\r\n";
		AccTool.writeTextFile(filename,  content);
	}
	
	public static void isiGapokSaja(WebDriver driver,PencatatanGajiParam param)
	{
		log.info("PencatatanGaji.IsiGapok");
		
		String tab= "//div[starts-with(@id,'tab-detailemployee')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
			
		if (param.gajipokok != null)
			AccTool.numberField(driver, tab, "@name='employeeFee'", param.gajipokok);
		
	}
	
	//untuk baris pertama
	public static void klikRincianGaji1(WebDriver driver, PencatatanGajiParam param)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-employee-payment-grid-list')]//*[@class='grid-canvas']/div[1]");
	}
	
	//untuk baris 1,2,3,4,5
	public static void klikRincianGaji0(WebDriver driver, String rincike)
	{
		log.info("PencatatanGaji.AmbilRinciGaji");
		String tab = "//*[contains(@id,'detail-employee-payment-grid-list')]";
		String rinci = tab + "//*[@class='grid-canvas']/div[" + rincike + "]";
		
		AccTool.click(driver, rinci);
	}

	public static void klikButtonPph(WebDriver driver, PencatatanGajiParam param)
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-employee-payment')]//button[@name='btnPphAllowance']");
	}
	
	public static void klikTabInfoLain(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PENCATATAN_GAJI.getXpath()
				+ "//a[contains(@href,'tab-employeeheader')]");
	}
	
	public static void klikTabRincianKaryawan(WebDriver driver) {
		AccTool.click(driver, AccurateModule.PENCATATAN_GAJI.getXpath()
				+ "//a[contains(@href,'tab-detail')]");
	}
	
	public static void klikTutupPopUpRincianKaryawan(WebDriver driver) {
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
//	public static void klikPph (WebDriver driver, PencatatanGajiParam param)
//	{
//		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-employee-payment')]//button[@name='btnPphAllowance']");
//	}
	
	public static void klikProsesPembayaranGaji(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[@name='btnProcess']");
		AccTool.click(getWebDriver(), "//a[text() = 'Gaji']");
	}
	
	public static void klikProsesPembayaranPPH(WebDriver driver) {

		AccTool.click(getWebDriver(), "//*[@name='btnProcess']");
		AccTool.click(getWebDriver(), "//a[text() = 'PPh']");
	}

	//Edit Rincian Gaji
	public static void editGaji(WebDriver driver,PencatatanGajiParam param)
	{
		log.info("PencatatanGaji.EditGaji");

		String tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[5]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");

		AccTool.numberField(driver, tab, "@name='employeeFee'", param.gajipokok);
	}
	
	
	//isi rincian Non Bulanan untuk pegawai tetap dan pegawai tidak tetap
	public static void isiRincianNonBulanan(WebDriver driver, PencatatanGajiParam param) {
		log.info("PencatatanGaji.IsiRincianNonBulanan");

		log.info("Rincian NonBulanan");

		String tab = "";
		if(param.tab != null)
		switch((param.tab).toLowerCase()){
		
		case "rincian nonbulanan":			
			AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
			
			if (param.thr != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[3]";
				tab= "//div[starts-with(@id,'tab-detailemployee')]/div/div[3]";			
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.thr);

			if (param.bonus != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[4]";
				tab= "//div[starts-with(@id,'tab-detailemployee')]/div/div[4]";	
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.bonus);

			if (param.tunjanganpphnb != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[5]";
				tab= "//div[starts-with(@id,'tab-detailemployee')]/div/div[5]";	
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.tunjanganpphnb);

			if (param.rapelgaji != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[6]";
				tab= "//div[starts-with(@id,'tab-detailemployee')]/div/div[6]";	
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.rapelgaji);

			if (param.pajakpenghasilan != null)
//				tab= "//div[starts-with(@id,'tab-detailemployee')]//div[@class='grid fluid no-margin']/div[7]";
				tab= "//div[starts-with(@id,'tab-detailemployee')]/div/div[7]";	
				AccTool.numberField(driver, tab, "@name='pphAmount'", param.pajakpenghasilan);

//		case "catatan":
//			tab = "//div[starts-with(@id,'tab-notes')]";			
//			
//			AccTool.click(driver, "//a[contains(@href,'tab-notes')]");
//			if(param.catatan != null)
//				AccTool.textarea(driver, tab, "@name='memo'", param.catatan);			
//			break;
		}	
	}

	//save rincian Non Bulanan untuk pegawai
		public static void saveRincianNonBulananKaryawan(WebDriver driver,  String filename)
		{
			log.info("PencatatanGaji.SaveRincianNonBulananKaryawan");
			
			String tab3 = "";
			String tab4 = "";
			String tab5 = "";
			String tab6 = "";
			String tab7 = "";
			String tab8 = "";
			
			tab3 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[3]";
			tab4 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[4]";
			tab5 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[5]";
			tab6 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[6]";
			tab7 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[7]/div[2]/div/input[1]";
			tab8 = "//div[starts-with(@id,'tab-detailemployee')]//span[contains(@data-bind,'formData.amount()')]";
			
			String content = "PencatatanGaji.SaveRincianNonBulananKaryawan : " + "\r\n";
			
			AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
			content = content
					+ "Tunjangan Hari Raya : "
					+ AccTool.getTextValue(driver, 
							ElementType.NUMBERFIELD, "employeeFee", tab3)
					
					+ "Tunjangan Bonus : "
					+ AccTool.getTextValue(driver, 
							ElementType.NUMBERFIELD, "employeeFee", tab4)

					+ "Tunjangan PPh : "
					+ AccTool.getTextValue(driver, 
							ElementType.NUMBERFIELD, "employeeFee", tab5)

					+ "Rapel Gaji : "
					+ AccTool.getTextValue(driver, 
							ElementType.NUMBERFIELD, "employeeFee", tab6)

					+ "Pajak Penghasilan : "
					+ AccTool.getTextValue(driver, 
							ElementType.OTHER, "employeeFee", tab7)
					
					+ "Gaji Dibayarkan : "
					+ AccTool.getTextValue(driver, 
							ElementType.REPORT, "employeeFee", tab8)

					+ "\r\n";
			AccTool.writeTextFile(filename,  content);
		}

		//isi rincian Non Bulanan untuk bukan pegawai 
		public static void isiRincianNBBukanPegawai(WebDriver driver, PencatatanGajiParam param) {
			log.info("PencatatanGaji.isiRincianNBBukanPegawai");

			String tab= "//div[starts-with(@id,'tab-detailemployee')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
				
			if (param.gajipokok != null)
				AccTool.numberField(driver, tab, "@name='employeeFee'", param.gajipokok);
			}	

		//save rincian non bulanan untuk bukan pegawai 
		public static void saveRincianNBBukanKaryawan(WebDriver driver,  String filename)
		{
			log.info("PencatatanGaji.SaveRincianNBBukanKaryawan");
			
			String tab3 = "";
			String tab4 = "";
			String tab5 = "";
			String tab6 = "";
			String tab7 = "";
			
			tab3 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[3]";
			tab4 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[4]";
			tab5 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[5]";
			tab6 = "";
			tab7 = "//div[starts-with(@id,'tab-detailemployee')]//span[contains(@data-bind,'formData.amount()')]";
			
			String content = "PencatatanGaji.SaveRincianBukanKaryawan : " + "\r\n";
			
			AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
			content = content
					+ "Gaji Pokok : "
					+ AccTool.getTextValue(driver, 
							ElementType.NUMBERFIELD, "employeeFee", tab3)
					
					+ "Tunjangan PPh : "
					+ AccTool.getTextValue(driver, 
							ElementType.NUMBERFIELD, "employeeFee", tab4)

					+ "Pajak Penghasilan : "
					+ AccTool.getTextValue(driver, 
							ElementType.NUMBERFIELD, "pphAmount", tab5)

					+ "No Bukti Potong : "
					+ AccTool.getTextValue(driver, 
							ElementType.TEXTFIELD, "pphNumber", tab6)

					+ "Gaji Dibayarkan : "
					+ AccTool.getTextValue(driver, 
							ElementType.REPORT, "employeeFee", tab7)

					+ "\r\n";
			AccTool.writeTextFile(filename,  content);
		}

		//save rincian non bulanan untuk bukan pegawai (Komisaris dan Bersifat berkesinambungan)
		public static void saveRincianNBBukanKaryawan2(WebDriver driver,  String filename)
		{
			log.info("PencatatanGaji.SaveRincianNBBukanKaryawan2");
			
			String tab3 = "";
			String tab4 = "";
			String tab5 = "";
			String tab6 = "";
			
			tab3 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[3]";
			tab4 = "//div[starts-with(@id,'tab-detailemployee')]//div[starts-with(@class,'grid fluid')]/div[4]";
			tab5 = "";
			tab6 = "//div[starts-with(@id,'tab-detailemployee')]//span[contains(@data-bind,'formData.amount()')]";
			
			String content = "PencatatanGaji.SaveRincianBukanKaryawan : " + "\r\n";
			
			AccTool.click(driver, "//a[contains(@href,'tab-detailemployee')]");
			content = content
					+ "Honorarium : "
					+ AccTool.getTextValue(driver, 
							ElementType.NUMBERFIELD, "employeeFee", tab3)

					+ "Pajak Penghasilan : "
					+ AccTool.getTextValue(driver, 
							ElementType.NUMBERFIELD, "pphAmount", tab4)

					+ "No Bukti Potong : "
					+ AccTool.getTextValue(driver, 
							ElementType.TEXTFIELD, "pphNumber", tab5)

					+ "Gaji Dibayarkan : "
					+ AccTool.getTextValue(driver, 
							ElementType.REPORT, "employeeFee", tab6)

					+ "\r\n";
			AccTool.writeTextFile(filename,  content);
		}
		
		
	}
	

