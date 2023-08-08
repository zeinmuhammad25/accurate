package com.cpssoft.web.test.accurate.praotomasi;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.pekerjaanpesanan.PekerjaanPesananParam;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.KolomLaporanTool;
import com.cpssoft.web.test.accurate.tool.LaporanTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.PekerjaanPesananTool;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class OpenAllReportAndCheckModifColumn extends AbstractAccurateTestCase {
	private static String TARGET_FILE = "OpenAllReportAndCheckModifColumn.txt";
	static Logger log = LogManager.getLogger(OpenAllReportAndCheckModifColumn.class);
	String content = "";

	// OTOMASI INI UNTUK BUKA SEMUA REPORT DAN TAMPILKAN SEMUA KOLOM
	
	public void saveKolomPerReport(String Target) {
		log.info("Masuk method save report");
		String content = "FakturPenjualan.SaveIsiInfoLain : " + "\r\n";

		String container_xpath = "//div[starts-with(@id, 'tab-available-columns')]";
		String xpath_daftar_kolom = "//div[starts-with(@id, 'used-columns')]/li[@class='ui-sortable-handle']";

		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(container_xpath), 10);
		List<WebElement> report_list = getWebDriver().findElements(By.xpath(xpath_daftar_kolom));
		int count_report = report_list.size();

		while (count_report > 0) {
			String xpath_per_kolom = xpath_daftar_kolom + "//div/label[contains(@data-bind, 'attr: {for:')]";
			content = content + AccTool.getTextValue(getWebDriver(), xpath_per_kolom);
			AccTool.writeTextFile(Target, content);
			count_report--;
		}

	}
	
//	@Test
	public void createjobcosting(){
		log.info("Barangjasa.create jobcosting");
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
		PekerjaanPesananParam header = new PekerjaanPesananParam();
		header.tanggal="01012016";
		PekerjaanPesananTool.isiForm(getWebDriver(), header);
		
		PekerjaanPesananParam detail = new PekerjaanPesananParam();
		detail.search = "Indomie";
		PekerjaanPesananTool.isiDetailBarang(getWebDriver(), detail);
		PekerjaanPesananTool.klikButtonLanjutTabDetailBarang(getWebDriver());
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
        GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);	
        NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.PEKERJAAN_PESANAN);
	}

	@Test//(dependsOnMethods = "createjobcosting")
	public void execute() {
		AccTool.deleteTextFile(TARGET_FILE);
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);

		String xpath_kategori_laporan = "//ol[contains(@class, 'index-report-tab-option-list')]/li/a";
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath(xpath_kategori_laporan), 5);
		List<WebElement> kategori_list = getWebDriver().findElements(By.xpath(xpath_kategori_laporan));
		int count_kategori = kategori_list.size();

		// ini untuk loop per kategori report
		for (int i = 2; i <= count_kategori; i++) {
			String xpath_per_kategori = "//ol[contains(@class, 'index-report-tab-option-list')]/li[" + i + "]/a";
			//String xpath_per_kategori = "//ol[contains(@class, 'index-report-tab-option-list')]/li[17]/a";
			AccTool.click(getWebDriver(), xpath_per_kategori);

			content = "\r\n" + "#################################################" + "\r\n" + "Kategori : "
					+ AccTool.getTextValue(getWebDriver(), xpath_per_kategori)
					+ "#################################################" + "\r\n";
			AccTool.writeTextFile(TARGET_FILE, content);

			ArrayList<String> xpathReport = KolomLaporanTool.addReportToArray();
			boolean showReportExists = false;
			
			int jumlahreport = xpathReport.size();
			String content2 = "Total : "
					+ String.valueOf(jumlahreport) + "\r\n"
					+ "#################################################" + "\r\n";
			
			AccTool.writeTextFile(TARGET_FILE, content2);
			
			//StopWatch stopwatch = new StopWatch();
			//stopwatch.start();
			
			// ini untuk loop semua report per kategori
			for (int j = 0; j < xpathReport.size(); j++) {
				WebElement reportname = getWebDriver().findElement(By.xpath(xpathReport.get(j)));
				log.info("Report to test : " + reportname.getText());
				AccTool.writeTextFile(TARGET_FILE, "Nama Report : " + reportname.getText() + "\r\n");

				KolomLaporanTool.openReportByXpath2(getWebDriver(), xpathReport.get(j));
				AccTool.waitLoadingMask(getWebDriver());

				showReportExists = WebElementTool.isElementExists(getWebDriver(),
						By.xpath("//button[@name='btnShowReport']"));
				if (showReportExists) {
					KolomLaporanTool.autoFillLookup();
					LaporanTool.klikButtonTampilkan(getWebDriver());
				}

//				WaitTool.delay(500);
				WaitTool.waitForElementClickable(getWebDriver(), By.xpath("//button[@name='btnModifyReport']"), 3);
				LaporanTool.klikModifikasi(getWebDriver());
				log.info("Sudah klik Modifikasi");
				WebElementTool.isElementVisible(getWebDriver(),
						By.xpath("//div[starts-with(@id, 'accurate__report__report-modify')]"));
				
				//mulai save semua Kolom Modifikasi
				//saveKolomPerReport(TARGET_FILE);
				
				//log.info("Masuk method save report");

				String container_xpath = "//div[starts-with(@id, 'tab-available-columns')]";
				String xpath_daftar_kolom = "//div[starts-with(@id, 'used-columns')]//li[@class='ui-sortable-handle']";

				WaitTool.waitForElementVisible(getWebDriver(), By.xpath(container_xpath), 10);
				List<WebElement> report_list = getWebDriver().findElements(By.xpath(xpath_daftar_kolom));
				int count_report = report_list.size();
				//log.info(count_report);

				while (count_report > 0) {
					String xpath_per_kolom = xpath_daftar_kolom + "//div/label[contains(@data-bind, 'attr: {for:')]";
					//String xpath_per_kolom = xpath_daftar_kolom + "//div";
					//content = AccTool.getTextValue(getWebDriver(), ElementType.SUMMARY, "attr: {for: 'col-'+name}", xpath_per_kolom);
					content = AccTool.getTextValue(getWebDriver(), xpath_per_kolom) + "\r\n";
					//log.info("nama " + content);
					count_report--;
				}
				AccTool.writeTextFile(TARGET_FILE, content);
				
				LaporanTool.klikSimpanModifikasi(getWebDriver());
				AccTool.waitLoadingMask(getWebDriver());
				WaitTool.delay(1000);
				NavigationTool.klikTutupTabReportPalingKiri(getWebDriver());

//				WaitTool.delay(500);
				WaitTool.waitForElementVisible(getWebDriver(),
						By.xpath("//div[starts-with(@class, 'index-report-tab-container')]"), 5);
				String xpath_per_index = "//div[contains(@class, 'index-report-tab-container-report')]/div[@class='report-li']["
						+ (j + 1) + "]/div/h3/a";
				content = (j + 1) + ". [SUCCESS!] - " + AccTool.getTextValue(getWebDriver(), xpath_per_index);
				
				
				//AccTool.writeTextFile(TARGET_FILE, content);
			}
			//stopwatch.stop();
			//AccTool.writeTextFile(TARGET_FILE, stopwatch.toString() + "\r\n");
		}
	}
	
	@Test(dependsOnMethods = "execute")
	public void hapusTransaksi(){

		AccTool.compareTextFile(TARGET_FILE, getDirectory());

	}

}
