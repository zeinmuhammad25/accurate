package com.cpssoft.web.test.accurate.praotomasi;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomListAllReport extends AbstractAccurateTestCase {
	private static String TARGET_FILE = "Praotomasi List All Report.txt";
	static Logger log = LogManager.getLogger(PraOtomListAllReport.class);
	String content = "";

	public void saveReportPerCategory() {
		log.info("Masuk method save report");

		int n = 1;
		String container_xpath = "//div[contains(@class, 'index-report-tab-container')]";
		String xpath_daftar_laporan = "//div[contains(@class, 'index-report-tab-container-report')]/div[@class='report-li']/div/h3/a";

		WaitTool.waitForElementVisible(getWebDriver(), By.xpath(container_xpath), 10);
		List<WebElement> report_list = getWebDriver().findElements(By.xpath(xpath_daftar_laporan));
		int count_report = report_list.size();

		while (count_report > 0) {
			String xpath_per_index = "//div[contains(@class, 'index-report-tab-container-report')]/div[@class='report-li']["
					+ n + "]/div/h3/a";
			content = n + ". " + AccTool.getTextValue(getWebDriver(), xpath_per_index);
			AccTool.writeTextFile(TARGET_FILE, content);
			n++;
			count_report--;
		}

	}

	@Test
	public void bukaReport() {
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);

		int j = 1;
//		String xpath_kategori_laporan = "//ol[contains(@class, 'index-report-tab-option-list')]/li/a";
		//ui baru
		String xpath_kategori_laporan = "//div[contains(@class, 'index-report-tab-option-list')]/li/label/span[2]";

		
		WaitTool.waitForElementClickable(getWebDriver(), By.xpath(xpath_kategori_laporan), 1000);
		List<WebElement> kategori_list = getWebDriver().findElements(By.xpath(xpath_kategori_laporan));
		int count_kategori = kategori_list.size();

		while (count_kategori > 0) {
//			String xpath_per_kategori = "//ol[contains(@class, 'index-report-tab-option-list')]/li[" + j + "]/a";
			//ui baru
			String xpath_per_kategori = "//div[contains(@class, 'index-report-tab-option-list')]/li[" + j + "]/label/span[2]";
			AccTool.click(getWebDriver(), xpath_per_kategori);

			content = "\r\n" + "#################################################" + "\r\n" + "Kategori : "
					+ AccTool.getTextValue(getWebDriver(), xpath_per_kategori)
					+ "#################################################" + "\r\n";
			AccTool.writeTextFile(TARGET_FILE, content);

			saveReportPerCategory();
			j++;
			count_kategori--;
		}
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.DAFTAR_LAPORAN);
	}

	@Test(dependsOnMethods = "bukaReport")
	public void compareResult() {

		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}

}
