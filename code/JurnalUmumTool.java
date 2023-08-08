package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.jurnalumum.JurnalUmumParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;


public class JurnalUmumTool extends AbstractAccurateTestCase  {
	static Logger log = LogManager.getLogger(JurnalUmumParam.class);
	
	public static void detailJurnal(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.Detail");
		
		String tab= "//div[starts-with(@id,'tab-detailaccount')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailaccount')]");
					
			if (param.debit != null)
			AccTool.radioButton(driver, tab, "@value='Debit'", param.debit);
			if (param.kredit != null)
			AccTool.radioButton(driver, tab, "@value='Credit'", param.kredit);
			if (param.nilai != null) {
				AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
				AccTool.click(driver, "//a[contains(@href,'tab-detailaccount')]");
				WaitTool.delay(500);
			}
			if (param.pemasok != null)
			AccTool.radioButton(driver, tab, "@value='Vendor'", param.pemasok);
			if (param.pelanggan != null)
			AccTool.radioButton(driver, tab, "@value='CUSTOMER'", param.pelanggan);
			if (param.namapemasok != null)
			AccTool.lookup(driver, tab, "@name='vendor'", param.namapemasok);	
			if (param.namapelanggan != null)
			AccTool.lookup(driver, tab, "@name='customer'", param.namapelanggan);					
			if (param.departemenmandatory != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if (param.proyekmandatory != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);
	}
	
	
	public static void detailJurnalDebit0(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.Detaildebit");
		
		String tab= "//div[starts-with(@id,'tab-detailaccount')]";
			AccTool.click(driver, "//a[contains(@href,'tab-detailaccount')]");
					
			if (param.debit != null)
			AccTool.radioButton(driver, tab, "@value='Debit'", param.debit);
			if (param.kredit != null)
			AccTool.radioButton(driver, tab, "@value='Credit'", param.kredit);
			if (param.nilai != null)
			AccTool.numberField(driver, tab, "@name='amount'", param.nilai);
			if (param.pemasok != null)
			AccTool.radioButton(driver, tab, "@value='Vendor'", param.pemasok);
			if (param.pelanggan != null)
			AccTool.radioButton(driver, tab, "@value='CUSTOMER'", param.pelanggan);
			if (param.namapemasok != null)
			AccTool.lookup(driver, tab, "@name='vendor'", param.namapemasok);	
			if (param.namapelanggan != null)
			AccTool.lookup(driver, tab, "@name='customer'", param.namapelanggan);	
			if (param.departemenmandatory != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemenmandatory);
			if (param.proyekmandatory != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyekmandatory);				
	}
	
	public static void detailCatatan(WebDriver driver,JurnalUmumParam param)
	{
		String tab = "//div[starts-with(@id,'tab-customfield')]";		
			AccTool.click(driver, "//a[contains(@href,'tab-customfield')]");
			if (param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", param.departemen);
			if (param.proyek != null)
			AccTool.lookup(driver, tab, "@name='project'", param.proyek);	
			if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='memo'", param.catatan);	
	
		}		
	
	public static void isi(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.Isi");

		String w = AccurateModule.JURNAL_UMUM.getXpath();
		//String tab = w + "//*[contains(@id,'tab-general')]";
		
		if(param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", 
		param.tanggal);
		if(param.penomoran != null)
			AccTool.combobox(driver, w, "@name='typeAutoNumber'", 
		param.penomoran);
		if(param.no != null)
			AccTool.textField(driver, w, "@name='number'", 
		param.no);
	}
	
	public static void isiDetail(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.IsiDetail");
				
		String tab = "//div[starts-with(@id,'tab-detail')]";
		
		AccTool.click(driver, "//a[contains(@href,'tab-detail')]");
				
		AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
		AccTool.scrollRowDetail(driver, tab, param.scroll);
		
	}
	
	public static void isiInfoLain(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.IsiInfoLain");
		
		String w = AccurateModule.JURNAL_UMUM.getXpath();	
		String tab = w + "//*[contains(@id,'tab-otherheader')]";
		
		AccTool.click(driver, AccurateModule.JURNAL_UMUM.getXpath() + "//a[contains(@href,'tab-otherheader')]");
				
		AccTool.textarea(driver, tab, "@name='description'", param.keterangan);		
		if (param.cabang != null)
			AccTool.combobox(driver, tab, "@name='branch'", param.cabang);
		
	}
	
	public static void KlikAmbilFavorit(WebDriver driver,JurnalUmumParam param)
	{
		AccTool.dropDown(driver, AccurateModule.JURNAL_UMUM.getXpath(), 
				"//div[@class='offset6 span6']/div[1]", "Favorit");
		
				String xpath = "//div[contains(@id,'copy-memorize-transaction')]//a[text()='Detail Akun']";
				AccTool.click(driver, xpath);
				if(param.search != null)
					AccTool.lookup(driver, "//div[contains(@id,'copy-memorize-transaction')]", "@name='lookup'", param.search);			}

	public static void klikTambahkeFavorit(WebDriver driver, JurnalUmumParam param)
	{
		String w = AccurateModule.JURNAL_UMUM.getXpath() + "//*[@class='metro window-overlay']//*[@class='window shadow']//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]";
		AccTool.click(driver, AccurateModule.JURNAL_UMUM.getXpath() + "//*[@class='metro window-overlay']//*[@class='window shadow']//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]");	
		if(param.nama != null)
			AccTool.textField(driver, w, "@name='name'", param.nama);	
		if(param.grup != null)
			AccTool.lookup(driver, w, "@name='useUserRoleAccessList'", param.grup);	
		if(param.user != null)
			AccTool.textField(driver, w, "@name='useUserAccessList'", param.user);	
		}
	
	public static void saveAkun(WebDriver driver, String filename)
	{
		log.info("JurnalUmum.Saveakun");

		String tab = "";
		String content = "JurnalUmum.SaveAkun : " + "\r\n";

		tab = "//div[contains(@id,'detail-journal-voucher-grid-list')]";
		content = AccurateModule.JURNAL_UMUM + ": " + "\r\n";
		content = content + AccTool.getGridValue(driver, AccurateModule.JURNAL_UMUM , tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
		
	}
	
	/* save detail jurnal */
	public static void saveDetail(WebDriver driver,String filename){
		log.info("JurnalUmum.SaveDetail");
		
		String xpath = "//label[contains(@class, 'for-customer for-vendor for-employee required')]";
		boolean exists = false;
		List<WebElement> listVendorCust = driver.findElements(By.xpath(xpath));
		log.info("List Pemasok Pelanggan: " + listVendorCust.size());
		exists = listVendorCust.size() > 0;
		
		if(exists){
			//String tab = "";
			String tab = "//div[starts-with(@id,'tab-detailaccount')]";
			String content = "JurnalUmum.SaveDetail : " + "\r\n";

				content = content
						+ "DetailAkun"
						+ "\r\n"
						+ "Akun Perkiraan : "
					    +AccTool.getTextValue(driver,
					    		ElementType.SUMMARY, "glAccount().name", tab)
						+ "Debit : "
						+ AccTool.getTextValue(driver,
								ElementType.RADIOBUTTON, "DEBIT", tab)
						+ "Kredit :"
						+ AccTool.getTextValue(driver, 
								ElementType.RADIOBUTTON, "CREDIT", tab)
						+ "Nilai : "
					    +AccTool.getTextValue(driver,
					    		ElementType.NUMBERFIELD, "amount", tab)
					    + "Pemasok : "
					    +AccTool.getTextValue(driver,
					    		ElementType.RADIOBUTTON, "VENDOR", tab)
					    + "Pelanggan : "
					    +AccTool.getTextValue(driver,
					    		ElementType.RADIOBUTTON, "CUSTOMER", tab)
					    + "Karyawan : "
					    +AccTool.getTextValue(driver,
					    		ElementType.RADIOBUTTON, "EMPLOYEE", tab)
					    + "Nama Pemasok : "
					    +AccTool.getTextValue(driver,
					    		ElementType.LOOKUP, "vendor", tab)
					    + "Nama Pelanggan : "
					    +AccTool.getTextValue(driver,
					    		ElementType.LOOKUP, "customer", tab)
					    + "Nama Karyawan : "
					    +AccTool.getTextValue(driver,
					    		ElementType.LOOKUP, "employee", tab)
					    + "Departemen :"
						+ AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-detailaccount')]//div[input[@name='project']]/ul/li/label/span")
						+ "Proyek :"
						+ AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-detailaccount')]//div[input[@name='project']]/ul/li/label/span") + "\r\n";
				
				AccTool.writeTextFile(filename, content);
		}else{
			//String tab = "";
			String tab = "//div[starts-with(@id,'tab-detailaccount')]";
			String content = "JurnalUmum.SaveDetail : " + "\r\n";

				content = content
						+ "DetailAkun"
						+ "\r\n"
						+ "Akun Perkiraan : "
					    +AccTool.getTextValue(driver,
					    		ElementType.SUMMARY, "glAccount().name", tab)
						+ "Debit : "
						+ AccTool.getTextValue(driver,
								ElementType.RADIOBUTTON, "DEBIT", tab)
						+ "Kredit :"
						+ AccTool.getTextValue(driver, 
								ElementType.RADIOBUTTON, "CREDIT", tab)
						+ "Nilai : "
					    +AccTool.getTextValue(driver,
					    		ElementType.NUMBERFIELD, "amount", tab)
					    + "Departemen : "
					    + AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-detailaccount')]//div[input[@name='project']]/ul/li/label/span")
					    + "Proyek : "
					    + AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-detailaccount')]//div[input[@name='project']]/ul/li/label/span");
					    String namacab = "//*[contains(@data-bind,'text: formData.branch().name')]";
						if (WebElementTool.isElementExists(driver, By.xpath(namacab))) {
							content = content + "Cabang : "
									+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.branch().name", tab);
						}
						content = content+ "\r\n";
				
				AccTool.writeTextFile(filename, content);
		}		
	}	
	
	public static void saveCatatanDetail(WebDriver driver, String filename)
	{
		log.info("JurnalUmum.SaveCatatanDetail");
		
		String tab = "//div[starts-with(@id,'tab-customfield')]";
		String content = "JurnalUmum.SaveCatatanDetail : " + "\r\n";
		AccTool.click(driver, "//*[contains(@href,'tab-customfield')]");
		content = content
				 + "Departemen : "
				 + AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-customfield')]//div[input[@name='department']]/ul/li/label/span")
				 + "Proyek : "
				 + AccTool.getTextValue(driver, "//*[starts-with(@id,'tab-customfield')]//div[input[@name='project']]/ul/li/label/span")
				 + "Catatan : "
				 + AccTool.getTextValue(driver, ElementType.TEXTAREA, "memo", tab)
				 + "\r\n";
		
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiInfoLain(WebDriver driver, String filename)
	{
		log.info("JurnalUmum.SaveInfoLain");
		
		String tab = "//*[contains(@id,'tab-otherheader')]";
		String content = "JurnalUmum.SaveInfoLain : " + "\r\n";
		
		content = content
				+ "Keterangan : " + AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM, ElementType.TEXTAREA, "description", tab);
				 String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
		        if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM, ElementType.COMBOBOX, "branch", tab);
		        } else {
		            content = content + "Cabang : "
		                    + AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM, ElementType.SUMMARY, "branchListOption", tab);
		        }
		        content = content + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsi(WebDriver driver,String filename)
	{
		log.info("JurnalUmum.SaveHeader");

		String tab = "";
		String content = "JurnalUmum.SaveHeader : " + "\r\n";

		switch (tab.toLowerCase()) {
		case "header":
			content = content
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM,
							ElementType.DATEPICKER, "transDate", tab)
					+ "Nomor : "
					+ AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM,
							ElementType.TEXTFIELD, "number", tab) + "\r\n";
					
			break;
		case "detail":
			AccTool.click(driver, AccurateModule.JURNAL_UMUM.getXpath() + "//a[contains(@href,'tab-detail')]");
			tab =  "//*[contains(@id,'tab-detail')]";
			content = content 
					+ "Detail" 
					+ "\r\n"
					+ AccTool.getGridValue(driver, AccurateModule.JURNAL_UMUM, tab)+ "\r\n";
					
			break;

		case "info lain":
			AccTool.click(driver,AccurateModule.JURNAL_UMUM.getXpath() + "//a[contains(@href,'tab-otherheader')]");
			tab = "//*[contains(@id,'tab-otherheader')]";
			content = content
					+ "Info Lain"
					+ "\r\n"
					+ "Keterangan : "
					+ AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM,ElementType.TEXTAREA, "description", tab); 
					 String namacabang = "//*[contains(@id,'tab-otherheader')]//select[@name = 'branch']";
			        if (WebElementTool.isElementExists(driver, By.xpath(namacabang))) {
			            content = content + "Cabang : "
			                    + AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM, ElementType.COMBOBOX, "branch", tab);
			        } else {
			            content = content + "Cabang : "
			                    + AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM, ElementType.SUMMARY, "branchListOption", tab);
			        }
					
			break;
		}

		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveList(WebDriver driver,String filename)
	{
		log.info("JurnalUmum.SaveRincianJurnal");

	String content = "JurnalUmum.SaveRincianJurnal : " + "\r\n";
	String tab  = "//*[contains(@id,'tab-detail')]";
	content = content 
			+ AccTool.getGridValue(driver, AccurateModule.JURNAL_UMUM,tab) + "\r\n";
	AccTool.writeTextFile(filename, content);

	}

	
	public static void saveIsiHeader (WebDriver driver,String filename)
	{
		log.info("JurnalUmum.SaveIsiHeader");


		String tab = "";
		String content = "JurnalUmum.SaveHeader : " + "\r\n";

			content = content
					+ "Tanggal : "
					+ AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM,ElementType.DATEPICKER, "transDate", tab)
					+ "Tipe Transaksi : "
					+ AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM, ElementType.SUMMARY, "text: formData.transactionTypeName", tab)
					+ "Nomor : "
				    + AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM,ElementType.TEXTFIELD, "number", tab)
				    + "No. Trans : "
				    + AccTool.getTextValue(driver, "//*[contains(@data-bind,'formData.transNumber')]") + "\r\n";
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailAkunKasKecil (WebDriver driver,String filename)
	{
		log.info("JurnalUmum.SaveDetailAkunKasKecil");


		String tab = "";
		String content = "JurnalUmum.SaveDetailAkunKasKecil : " + "\r\n";

			content = content
					+ "DetailAkun"
					+ "\r\n"
					+ "Akun Perkiraan : "
				    +AccTool.getTextValue(driver,
				    		ElementType.TEXTFIELD, "name", tab)
					+ "Debit/Kredit : "
					+ AccTool.getTextValue(driver,
							ElementType.RADIOBUTTON, "metroRadio:{}, checked: formData.amountType", tab)
					+ "Nilai : "
				    +AccTool.getTextValue(driver,
				    		ElementType.NUMBERFIELD, "amount", tab)
				    + "Departemen : "
				    +AccTool.getTextValue(driver, 
				    		ElementType.LOOKUP, "department", tab) + "\r\n";
			AccTool.writeTextFile(filename, content);
	}
	
	public static void saveDetailAkunPiutangUsd (WebDriver driver,String filename)
	{
		log.info("JurnalUmum.saveDetailAkunPiutangUsd");


		String tab = "";
		String content = "JurnalUmum.saveDetailAkunPiutangUsd : " + "\r\n";

			content = content
					+ "DetailAkun"
					+ "\r\n"
					+ "Akun Perkiraan : "
				    +AccTool.getTextValue(driver,
				    		ElementType.TEXTFIELD, "name", tab)
				    + "Kurs (Rp): "
				    +AccTool.getTextValue(driver,
				    		ElementType.NUMBERFIELD, "rate", tab)
				    + "Debit : "
					+ AccTool.getTextValue(driver,
							ElementType.RADIOBUTTON, "DEBIT", tab)
					+ "Kredit :"
					+ AccTool.getTextValue(driver, 
							ElementType.RADIOBUTTON, "CREDIT", tab)
				    + "Pemasok/Pelanggan : "
					+ AccTool.getTextValue(driver,
							ElementType.RADIOBUTTON, "metroRadio:{}, checked: formData.amountType", tab)
					+ "Nilai (Rp) : "
				    +AccTool.getTextValue(driver,
				    		ElementType.NUMBERFIELD, "amount", tab)
					+ "Nilai ($) : "
				    +AccTool.getTextValue(driver,
				    		ElementType.NUMBERFIELD, "primeAmount", tab)
				    + "Departemen : "
				    +AccTool.getTextValue(driver, 
				    		ElementType.LOOKUP, "department", tab) + "\r\n";
			AccTool.writeTextFile(filename, content);
	}


	public static void klikCetak(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, module.getXpath() + "//i[@class='icon-printer']");
	}
	
	public static void klikCloseCetak(WebDriver driver, AccurateModule module) {
		AccTool.click(driver, module.getXpath() + "//button[@name='btnClose']");
	}
	
	public static void klikButtonTutupCetak(WebDriver driver, String xpath) {
		String path = xpath + "//button[@name='btnClose']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikDokumen(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, module.getXpath() + "//i[@class='icon-attachment']");
		AccTool.click(driver, module.getXpath() + "//*[text()='Dokumen']");
		
	}
	public static void klikKomentar(WebDriver driver, AccurateModule module) 
	{
//		AccTool.click(driver, module.getXpath() + "//i[@class='icon-attachment']");
//		AccTool.click(driver, module.getXpath() + "//*[text()='Komentar']");
		//ui baru
		AccTool.click(driver, module.getXpath() + "//*[@id='btnCommentAttachment']");
		AccTool.click(driver, module.getXpath() + "//*[text()='Komentar']");
	}
	
	public static void isiKomentar(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.IsiKomentar");
		String a ="//*[contains(@id,'accurate__company__comment')]";

		if (param.Komentar != null)				
	    AccTool.textarea(driver, a, "@name='comment'", param.Komentar);	
	}
	
	public static void saveKomentar(WebDriver driver, String filename)
	{
		log.info("JurnalUmum.SaveKomentar");
		String tab = "//*[contains(@id,'accurate__company__comment')]";
		String content = "JurnalUmum.SaveKomentar : " + "\r\n";
		content = content
				+ "Komentar : " 
				+ AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM, tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
		NavigationTool.klikSaveKomentar(getWebDriver(), "//*[contains(@id,'accurate__company__comment')]");
	}
	
	public static void isiDetailTransaksiFavorit(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.isiDetailTransaksiFavorit");
		String w ="//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]";
//		AccTool.click(driver, AccurateModule.JURNAL_UMUM.getXpath() + "//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]");	
		if(param.nama != null)
			AccTool.textField(driver, w, "@name='name'", param.nama);	
		if(param.grup != null)
			AccTool.lookup(driver, w, "@name='useUserRoleAccessList'", param.grup);	
		if(param.user != null)
			AccTool.textField(driver, w, "@name='useUserAccessList'", param.user);	
//		if (param.Komentar != null)				
//	    AccTool.textarea(driver, a, "@name='comment'", param.Komentar);	
		
	}
	
	public static void isiTransaksiBerulang (WebDriver driver, JurnalUmumParam param) {
		log.info("JurnalUmum.isiTransaksiBerulang");
		
			String w = "//*[contains(@id,'accurate__company__save-recurring-dialog')]";
			
			if(param.nama != null)
				AccTool.textField(driver, w, "@name='name'", 
			param.nama);
			
			if(param.Periode != null)
				AccTool.combobox(driver, w, "@name='perioda'", 
			param.Periode);
		    
			if(param.Berapakali != null)
				AccTool.deleteTextFile("5");
				AccTool.numberField(driver, w, "@name='count'", 
			param.Berapakali);
	}
	
	public static void saveLogAktifitas (WebDriver driver,String filename)
	{
		log.info("JurnalUmum.SaveLogAktifitas");


		String tab = "//*[contains(@id,'accurate__company__audit-list')]/div[1]";
		String content = "JurnalUmum.SaveLogAktifitas : " + "\r\n";

			content = content
					+ "Tanggal : "
				    +AccTool.getTextValue(driver,ElementType.DATEPICKER, "Tanggal", tab)
				    + "Pengguna: "
				    +AccTool.getTextValue(driver,ElementType.TEXTFIELD, "Pengguna", tab)+ "\r\n";					
			AccTool.writeTextFile(filename, content);
//			WaitTool.delay(1100);
	}
	public static void daritanggal(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.DariTanggal");
		String a ="//*[contains(@class,'text-left keep-open widget-body dropdown-menu')]";

		if (param.daritanggal != null)				
	    AccTool.textField(driver, a, "@name='startDate'", param.daritanggal);
//		AccTool.waitLoadingMask(getWebDriver());
	}
	public static void hinggatanggal(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.HinggaTanggal");
		String a ="//*[contains(@class,'text-left keep-open widget-body dropdown-menu')]";

		if (param.hinggatanggal != null)				
	    AccTool.textField(driver, a, "@name='endDate'", param.hinggatanggal);	
		AccTool.waitLoadingMask(getWebDriver());
	}
	public static void DurasiWaktu(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.DurasiWaktu");
		AccTool.click(driver,"//*[contains(@class,'input-control radio no-margin')]/parent::*/parent::*/parent::*[@class='grid fluid no-margin']/div[3]");
		String a ="//*[contains(@class,'text-left keep-open widget-body dropdown-menu')]";

		if (param.bulan != null)				
	    AccTool.radioButton(driver, a, "@value='month'", param.bulan);	
		if (param.hari != null)				
		    AccTool.radioButton(driver, a, "@value='day'", param.hari);
		if (param.minggu != null)				
		    AccTool.radioButton(driver, a, "@value='week'", param.minggu);
		
	}
	
	public static void jumlahdurasi(WebDriver driver,JurnalUmumParam param)
	{
		log.info("JurnalUmum.JumlahDurasi");
		String a ="//*[contains(@class,'grid fluid no-margin')]";

		if (param.jumlahdurasi != null)				
	    AccTool.numberField(driver, a, "@name='amount'", param.jumlahdurasi);	
	}
	public static void carilist(WebDriver driver, JurnalUmumParam param) {
		log.info("JurnalUmum.carilist");


		String a ="//*[contains(@id,'module-accurate__general-ledger__journal-voucher')]";
		
		if (param.cari != null)				
	    AccTool.textField(driver, a, "@name='keyword'", param.cari);
	}
	
	public static void klikLanjutTabDetailAkun(WebDriver driver, AccurateModule module) 
	{
		NavigationTool.klikButtonLanjut(driver, "//*[contains(@id,'detail-journal-voucher')]");

	}
	
	public static void klikNoTrans(WebDriver driver) 
	{
		AccTool.click(driver, "//*[contains(@class,'text-panel-value-link')]");

	}
	
	public static void klikDariTanggal(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'input-control radio')]");

	}
	
	public static void klikHinggaTanggal(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'text-left keep-open widget-body dropdown-menu')]//*[text()=' Hingga tanggal']");
//		AccTool.waitLoadingMask(getWebDriver());

	}

	public static void klikKosongkanPilihan(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'text-left keep-open widget-body dropdown-menu')]//*[text()=' Kosongkan Pilihan']");
	}
	
	public static void klikUpdate(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'text-left keep-open widget-body dropdown-menu')]//*[text()='Update']");
		AccTool.waitLoadingMask(driver);
	}
	
	public static void klikTutupLogAktifitas(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//div[text()='Log Aktifitas']/preceding-sibling::*");
		WaitTool.waitForElementDisapear(driver, By.xpath("//div[text()='Log Aktifitas']/preceding-sibling::*"), 6);
	}
	
	public static void klikTutupKomentar(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//div[text()='Komentar transaksi']/preceding-sibling::*");
        WaitTool.waitForElementDisapear(driver, By.xpath("//div[text()='Komentar transaksi']/preceding-sibling::*"), 6);
	}
	
	public static void klikAkunBaris1PadaListDetailJurnal(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'slick-cell l3 r3')]");

	}
	
	public static void klikEditAkunBaris2() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'detail-journal-voucher-grid-list')]//*[@class='grid-canvas']/div[2]");
       
	}
	
	
	public static void klikTipeTransaksi(WebDriver driver, AccurateModule module) 
	{
		 AccTool.click(driver, "//*[contains(@id,'accurate__dynamic-filter')]//*[text()='Tipe Transaksi']");
		 
	}
	
	public static void klikListAsetTetap(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'grid fluid no-margin')]//*[text()='Aset Tetap']");
//		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
	public static void klikListPenerimaanBarang(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'grid fluid no-margin')]//*[text()='Penerimaan Barang']");
//		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
	public static void klikListPembayaranPembelian() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Pembayaran Pembelian']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListReturPembelian() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Retur Pembelian']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListTransferBank() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Transfer Bank']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListFakturPenjualan() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Faktur Penjualan']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPerubahanAsetTetap() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Perubahan Aset Tetap']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPencatatanBeban() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Pencatatan Beban']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPenyelesaianPesanan() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Penyelesaian Pesanan']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListJurnalUmum() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Jurnal Umum']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListDisposisiAsetTetap() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Disposisi Aset Tetap']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPemindahanBarang() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Pemindahan Barang']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPenerimaan() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Penerimaan']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPengirimanPesanan() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Pengiriman Pesanan']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPenerimaanPenjualan() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Penerimaan Penjualan']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListFakturPembelian() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Faktur Pembelian']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPencatatanGaji() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Pencatatan Gaji']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPekerjaanPesanan() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Pekerjaan Pesanan']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPenyesuainPersediaan() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Penyesuaian Persediaan']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListPembayaran() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Pembayaran']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikListReturPenjualan() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'grid fluid no-margin')]//*[text()='Retur Penjualan']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
//		WaitTool.delay(1100);
	}
	
	public static void klikiconCari() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'module-accurate__general-ledger__journal-voucher')]//*[@name ='keyword']");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
        WaitTool.delay(1100);
	}
	
	public static void klikEditAkunBaris1() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@class,'slick-cell l3 r3 text-right')]");

	}
	
	public static void klikTabInfoLainnya(WebDriver driver)
	{
		AccTool.click(driver, AccurateModule.JURNAL_UMUM.getXpath() +
				"//a[contains(@href, '#tab-otherheader')]");
	}
		
	/* klik button close pop up detail*/
	public static void klikTutupPopUpDetailAkun(WebDriver driver){
		String path = "//*[@class='icon icon-pencil']/parent::*//*[@class='btn-close']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 7);
	}
	
	public static void klikBaris(WebDriver driver, Integer urutan) {
		String path = "//*[contains(@id,'tab-detail')]//div[contains(@class, 'slick-row')][" + urutan + "]";
		AccTool.click(driver, path);
	}
	
	 public static void saveFooter(WebDriver driver, String filename) {
			log.info("Save Footer");
//			WaitTool.delay(1000);
			String content = "JurnalUmum.SaveFooter ; " + "\r\n";
			String tab = "//div[text()='Total Debit']/following-sibling::div";
			String tab1 = "//div[text()='Total Credit']/following-sibling::div";
			
			//pastikan footer Total Debit & Total Credit sudah visible
			WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.JURNAL_UMUM.getXpath()+tab), 1);
			WaitTool.waitForElementVisible(driver, By.xpath(AccurateModule.JURNAL_UMUM.getXpath()+tab1), 1);
			
			content = content 
					+ "Total Debit : "
					+ ""
					+ AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM, tab)
					+ "Total Kredit : "
					+ ""
					+ AccTool.getTextValue(driver, AccurateModule.JURNAL_UMUM, tab1)
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}
	 
	public static void saveDetailPenyusutanAsetTetap(WebDriver driver,String filename){
			log.info("JurnalUmum.SaveDetailPenyusutanAsetTetap");
			
			String xpath = "//div[contains(@data-bind, 'formData.transactionDate')]";
			boolean exists = false;
			List<WebElement> listTanggal = driver.findElements(By.xpath(xpath));
			log.info("List tanggal penyusutan: " + listTanggal.size());
			exists = listTanggal.size() > 0;
			
			if(exists){
				//String tab = "";
				String tab = "//div[starts-with(@id,'tab-detailaccount')]";
				String content = "JurnalUmum.SaveDetailPenyusutanAsetTetap : " + "\r\n";

					content = content
							+ "DetailAkun"
							+ "\r\n"
							+ "Akun Perkiraan : "
						    +AccTool.getTextValue(driver,
						    		ElementType.SUMMARY, "glAccount().name", tab)
						    
							+ "Tanggal : "
						    +AccTool.getTextValue(driver,
						    		ElementType.SUMMARY, "formData.transactionDate", tab)
							+ "Debit : "
							+ AccTool.getTextValue(driver,
									ElementType.RADIOBUTTON, "DEBIT", tab)
							+ "Kredit :"
							+ AccTool.getTextValue(driver, 
									ElementType.RADIOBUTTON, "CREDIT", tab)
							+ "Nilai : "
						    +AccTool.getTextValue(driver,
						    		ElementType.NUMBERFIELD, "amount", tab)
						    + "Departemen : "
						    +AccTool.getTextValue(driver, 
						    		ElementType.LOOKUP, "department", tab)
						    + "Proyek : "
						    + AccTool.getTextValue(driver,
						    		ElementType.LOOKUP, "project", tab)
							+ "Cabang : "
						    +AccTool.getTextValue(driver,
						    		ElementType.SUMMARY, "formData.branch().name", tab)
						    + "\r\n";
					
					AccTool.writeTextFile(filename, content);
			}else{
				String tab = "//div[starts-with(@id,'tab-detailaccount')]";
				String content = "JurnalUmum.SaveDetailPenyusutanAsetTetap : " + "\r\n";

					content = content
							+ "DetailAkun"
							+ "\r\n"
							+ "Akun Perkiraan : "
						    +AccTool.getTextValue(driver,
						    		ElementType.SUMMARY, "glAccount().name", tab)
							+ "Debit : "
							+ AccTool.getTextValue(driver,
									ElementType.RADIOBUTTON, "DEBIT", tab)
							+ "Kredit :"
							+ AccTool.getTextValue(driver, 
									ElementType.RADIOBUTTON, "CREDIT", tab)
							+ "Nilai : "
						    +AccTool.getTextValue(driver,
						    		ElementType.NUMBERFIELD, "amount", tab)
						    + "Departemen : "
						    +AccTool.getTextValue(driver, 
						    		ElementType.LOOKUP, "department", tab)
						    + "Proyek : "
						    + AccTool.getTextValue(driver,
						    		ElementType.LOOKUP, "project", tab)
							+ "Cabang : "
						    +AccTool.getTextValue(driver,
						    		ElementType.SUMMARY, "formData.branch().name", tab)
						    + "\r\n";
					
					AccTool.writeTextFile(filename, content);
			}		
		}
	public static void klikSearch() 
	{
		AccTool.click(getWebDriver(), "//*[contains(@id,'module-accurate__general-ledger__journal-voucher')]//*[contains(@class ,'btn-search')]");
//		AccTool.waitLoadingMaskVisible(getWebDriver());
		AccTool.waitLoadingMask(getWebDriver());
        WaitTool.delay(1100);
	}

	public static void klikListBaris(WebDriver driver, int Urutan) {
		AccTool.click(getWebDriver(), "//div[contains(@id,'module-grid-list')]//div[@class='grid-canvas']/div["+ Urutan +"]");
		AccTool.waitLoadingMask(driver);
	}
	
}


