package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.anggaran.AnggaranParam;
import com.cpssoft.web.test.accurate.jurnalumum.JurnalUmumParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class AnggaranTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(AnggaranParam.class);

	public static void isiAkun(WebDriver driver, AnggaranParam param) {
		log.info("AnggaranTarget.Isi");

		String w = AccurateModule.ANGGARAN.getXpath();
		// String tab = w + "//*[contains(@id,'tab-general')]";

		if (param.tahun != null)
			AccTool.numberField(driver, w, "@name='budgetYear'", param.tahun);

		if (param.bulan != null)
			AccTool.combobox(driver, w, "@name='budgetMonth'", param.bulan);

		if (param.tipe != null) {
			switch (param.tipe.toLowerCase()) {

			case "per departemen":
				AccTool.combobox(driver, w, "@name='scopeType'", "Per Departemen");
				WaitTool.delay(500);
				if (param.searchdepartemen != null)
					AccTool.lookup(driver, w, "@name='department'", param.searchdepartemen);
				if (param.scrolldepartemen != null)
					AccTool.scrollRowDetail(driver, w, param.scrolldepartemen);
				break;

			case "per proyek":
				AccTool.combobox(driver, w, "@name='scopeType'", "Per Proyek");
				WaitTool.delay(500);
				if (param.searchproyek != null)
					AccTool.lookup(driver, w, "@name='project'", param.searchproyek);
				if (param.scrollproyek != null)
					AccTool.scrollRowDetail(driver, w, param.scrollproyek);
				break;

			case "umum":

				AccTool.combobox(driver, w, "@name='scopeType'", "Umum");

				break;
			}

		}

	}

	public static void detail(WebDriver driver, AnggaranParam param) {
		log.info("AnggaranTarget.Detail");

		String tab = "//div[starts-with(@id,'tab-detailaccount')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailaccount')]");

		if (param.anggarantarget != null)
			AccTool.numberField(driver, tab, "@name='amountPeriod'", param.anggarantarget);

	}

	public static void isiCatatan(WebDriver driver, AnggaranParam param) {
		log.info("AnggaranTarget.IsiCatatan");

		String w = AccurateModule.ANGGARAN.getXpath();
		String tab = w + "//*[contains(@id,'tab-notes')]";

		AccTool.click(driver, w + "//a[contains(@href,'tab-notes')]");

		if (param.penganalisa != null)
			AccTool.textField(driver, w, "@name='analystName'", param.penganalisa);
		if (param.catatan != null)
			AccTool.textarea(driver, tab, "@name='notes'", param.catatan);

	}

	public static void isiDetail(WebDriver driver, AnggaranParam param) {
		log.info("AnggaranTarget.IsiDetail");

		String w = AccurateModule.ANGGARAN.getXpath();
		String tab = w + "//div[contains(@id,'tab-account')]";

		AccTool.click(driver, AccurateModule.ANGGARAN.getXpath() + "//a[contains(@href, 'tab-account')]");

		AccTool.lookup(driver, tab, "@name='searchDetailAccount'", param.search);
		AccTool.scrollRowDetail(driver, tab, param.scroll);
	}

	public static void klikButtonLanjutDetailAnggaran(WebDriver driver) {
		String path = "//*[contains(@id,'detail-account')]//*[@name='btnNext']";
		AccTool.click(driver, path);
		WaitTool.waitForElementDisapear(driver, By.xpath(path), 500);
	}

	public static void List(WebDriver driver, AnggaranParam param) {
		log.info("AnggaranTarget.List");

		String w = AccurateModule.ANGGARAN.getXpath();
		String tab = w + "//div[starts-with(@class,'module-list')]";

		AccTool.textField(driver, tab, "@name='keyword'", param.search);
		AccTool.scrollRow(driver, tab, param.scroll);
	}

	public static void saveDetail(WebDriver driver, String filename) {
		log.info("AnggaranTarget.SaveDetail");

		String tab = "";
		String content = "AnggaranTarget.detail : " + "\r\n";
		tab = "//div[starts-with(@id,'tab-detailaccount')]";
		AccTool.click(driver, "//a[contains(@href,'tab-detailaccount')]");
		//
		// String tab = "//div[starts-with(@id,'tab-detailaccount')]";
		// String content = "AnggaranTarget.SaveDetail : " + "\r\n";

		content = content + "Beban / Pendapatan		: "
				+ AccTool.getTextValue(driver, ElementType.SUMMARY, "text: formData.account().name", tab)
				+ "Anggaran Target : " + AccTool.getTextValue(driver, ElementType.NUMBERFIELD, "amountPeriod", tab)
				+ "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("AnggaranTarget.SaveIsiHeader");

		String tab = "";
		String content = "Anggaran Target : Save Isi : " + "\r\n";
		content = content + "Header" + "\r\n" + "Tahun : "
				+ AccTool.getTextValue(driver, AccurateModule.ANGGARAN, ElementType.NUMBERFIELD, "budgetYear", tab)
				+ "Bulan : "
				+ AccTool.getTextValue(driver, AccurateModule.ANGGARAN, ElementType.COMBOBOX, "budgetMonth", tab)
				+ "Tipe : "
				+ AccTool.getTextValue(driver, AccurateModule.ANGGARAN, ElementType.COMBOBOX, "scopeType", tab)
				+ "Departemen : "
				+ AccTool.getTextValue(driver, AccurateModule.ANGGARAN, ElementType.LOOKUP, "department", tab)
				+ "Proyek : "
				+ AccTool.getTextValue(driver, AccurateModule.ANGGARAN, ElementType.LOOKUP, "project", tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	// public static void saveIsi (WebDriver driver,String filename)
	// {
	// log.info("AnggaranTarget.SaveIsi");
	//
	//
	// String content = "AnggaranTarget.SaveIsi : " + "\r\n";
	// String tab =
	// "//div[starts-with(@id,'c_0f66df1c-4c31-4583-b059-3b0562f83647--9--3')]";
	// content = content
	// + "Header"
	// + "\r\n"
	// + "Tahun : "
	// + AccTool.getTextValue(driver, AccurateModule.ANGGARAN,
	// ElementType.NUMBERFIELD, "budgetYear", tab)
	// + "Bulan : "
	// + AccTool.getTextValue(driver, AccurateModule.ANGGARAN,
	// ElementType.COMBOBOX, "budgetMonth",tab)
	// + "Tipe : "
	// + AccTool.getTextValue(driver, AccurateModule.ANGGARAN,
	// ElementType.COMBOBOX, "scopeType", tab)
	// + "Penganalisa : "
	// + AccTool.getTextValue(driver, AccurateModule.ANGGARAN,
	// ElementType.TEXTFIELD, "analystName", tab) + "\r\n";
	// AccTool.writeTextFile(filename, content);
	// }

	public static void saveIsiDetail(WebDriver driver, String filename) {
		log.info("AnggaranTarget.SaveIsiDetail");
		String content = "AnggaranTarget.SaveIsiDetail : " + "\r\n";
		// AccTool.click(driver, AccurateModule.ANGGARAN.getXpath() +
		// "//a[text()='tab-account']");
		content = content + "Detail" + "\r\n"
				+ AccTool.getGridValue(driver, AccurateModule.ANGGARAN, "//*[contains(@id,'tab-account')]") + "\r\n";

		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiLain(WebDriver driver, String filename) {
		log.info("AnggaranTarget.SaveIsiInfoLain");
		AccTool.click(driver, "//a[contains(@href,'tab-notes')]");

		// String tab = "";
		String content = "AnggaranTarget.SaveIsiInfoLain : " + "\r\n";
		// tab = AccurateModule.ANGGARAN.getXpath() +
		// "//*[contains(@id,'tab-otherheader')]";
		content = content + "Info Lain" + "\r\n" + "Penganalisa : "
				+ AccTool.getTextValue(driver, AccurateModule.ANGGARAN, ElementType.TEXTFIELD, "analystName")
				+ "Catatan : " + AccTool.getTextValue(driver, AccurateModule.ANGGARAN, ElementType.TEXTAREA, "notes")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	// public static void saveIsiLain (WebDriver driver,String filename)
	// {
	// log.info("AnggaranTarget.SaveIsiLain");
	//
	// String content = "AnggaranTarget.SaveIsiLain : " + "\r\n";
	// AccTool.click(driver, AccurateModule.ANGGARAN.getXpath() +
	// "//a[contains(@href,'tab-notes')]");
	// content = content
	// + "Info Lain"
	// + "\r\n"
	// + "Penganalisa : "
	// + AccTool.getTextValue(driver, AccurateModule.ANGGARAN,
	// ElementType.TEXTFIELD, "analystName", tab)
	// + "Catatan : "
	// + AccTool.getTextValue(driver, AccurateModule.ANGGARAN,
	// ElementType.TEXTAREA, "notes", "//*[contains(@id,'tab-notes')]")
	// + "\r\n";
	//
	//
	// AccTool.writeTextFile(filename, content);
	// }

	public static void isiDetailTransaksiFavorit(WebDriver driver, AnggaranParam param) {
		String w = "//*[contains(@id,'accurate__company__save-memorize-transaction-dialog')]";
		if (param.namafavorit != null)
			AccTool.textField(driver, w, "@name='name'", param.namafavorit);
		if (param.aksesgrupcabangfavorit != null)
			AccTool.lookup(driver, w, "@name='useUserRoleAccessList'", param.aksesgrupcabangfavorit);
		if (param.aksespenggunafavorit != null)
			AccTool.textField(driver, w, "@name='useUserAccessList'", param.aksespenggunafavorit);
		// if (param.Komentar != null)
		// AccTool.textarea(driver, a, "@name='comment'", param.Komentar);

	}

	// Untuk hapus akun di anggaran (23 mei 2019)

	public static void klikHapusAkun(WebDriver driver) {
		AccTool.click(driver, "//*[contains(@id,'detail-account')]//*[@name='btnDelete']");
		AccTool.waitLoadingMask(driver);
	}

	// filter di anggaran (11 juni 2019)

	public static void filterProyek(WebDriver driver, AnggaranParam param) {
		log.info("Anggaran.filterProyek");

		String xpathfilterproyek = "//div[@key='projectFilter']";
		String lookupproyek = xpathfilterproyek + "/following-sibling::div";
		AccTool.click(driver, xpathfilterproyek);

		WaitTool.delay(500);
		AccTool.lookupWithoutClear(driver, lookupproyek, "@name='lookup'", param.searchP);
		WaitTool.delay(200);
		AccTool.click(driver, xpathfilterproyek);
		
	}
	
	
	public static void filterDepartemen(WebDriver driver, AnggaranParam param) {
		log.info("Anggaran.filterDepartemen");

		String xpathfilterdepartment = "//div[@key='departmentFilter']";
		String lookupdepartment = xpathfilterdepartment + "/following-sibling::div";
		AccTool.click(driver, xpathfilterdepartment);

		WaitTool.delay(500);
		AccTool.lookupWithoutClear(driver, lookupdepartment, "@name='lookup'", param.searchD);
		WaitTool.delay(200);
		AccTool.click(driver, xpathfilterdepartment);
	}
	
	public static void klikTipeTransaksi(WebDriver driver, AccurateModule module) 
	{
		 AccTool.click(driver, "//*[contains(@id,'accurate__dynamic-filter')]//*[text()='Tipe']");
		 
	}
	
	public static void klikPerDepartemen(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'grid fluid no-margin')]//*[text()='Per Departemen']");
		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
	public static void klikPerProyek(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'grid fluid no-margin')]//*[text()='Per Proyek']");
		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
	public static void klikUmum(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'grid fluid no-margin')]//*[text()='Umum']");
		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
	
	public static void klikKosongkanPilihan(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'text-left keep-open widget-body dropdown-menu')]//*[text()=' Kosongkan Pilihan']");
	}
	
	

	public static void saveList(WebDriver driver, String filename) {
		log.info("Anggaran.SaveList");

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "Anggaran.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, AccurateModule.ANGGARAN, tab) + "\r\n";

		AccTool.writeTextFile(filename, content);
	}
	
	public static void klikSetting(WebDriver driver, AccurateModule module) 
	{
	
		AccTool.click(driver, "//*[contains(@name,'btnColumnSetting')]");
		 
	}
	
	
	public static void klikCbDepartemen(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'text-left keep-open column-select dropdown-menu')]//*[text()='Departemen']");
		
	}
	
	
	public static void klikTahun(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'text-left keep-open column-select dropdown-menu')]//*[text()='Tahun']");
		
//		WaitTool.delay(1100);
	}
	
	public static void klikBulan(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'input-control checkbox no-margin')]//*[text()='Bulan']");
		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
	public static void klikTipe(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'input-control checkbox no-margin')]//*[text()='Tipe']");
		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
	public static void klikPenganalisa(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'input-control checkbox no-margin')]//*[text()='Penganalisa']");
		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
	public static void klikCatatan(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'input-control checkbox no-margin')]//*[text()='Catatan']");
		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
	public static void klikProyek(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'input-control checkbox no-margin')]//*[text()='Proyek']");
		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	

	public static void klikDepartemen(WebDriver driver, AccurateModule module) 
	{
		AccTool.click(driver, "//*[contains(@class,'input-control checkbox no-margin')]//*[text()='Departemen']");
		AccTool.waitLoadingMaskVisible(driver);
		AccTool.waitLoadingMask(driver);
//		WaitTool.delay(1100);
	}
	
}
