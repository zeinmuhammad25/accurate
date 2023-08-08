package com.cpssoft.web.test.accurate.tool;

import static com.cpssoft.web.test.framework.AbstractSeleniumTestCase.getWebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.framework.tools.WaitTool;

public class KolomLaporanTool {
	static Logger log = LogManager.getLogger(KolomLaporanTool.class);

	public static ArrayList<String> execute() {
		clearAllColumn();

		ArrayList<String> result = new ArrayList<String>();
		String fieldListXpath = "//div[starts-with(@id, 'available-columns')]//li";
		String leafLinkXpath = "/a[not(../ul)]";

		// Add All Leaf Link to result
		List<WebElement> tempList = getWebDriver().findElements(By.xpath(fieldListXpath + leafLinkXpath));
		for (WebElement element : tempList) {
			WebElement parentLiElement = element.findElement(By.xpath(".."));
			result.add(fieldListXpath + "[@id='" + parentLiElement.getAttribute("id") + "']/a");
		}

		return result;
	}

	public static void selectColumnPerBatch(int columnPerBatch) {
		log.info("Start gathering all report fields...");
		ArrayList<String> columnarray = KolomLaporanTool.execute();
		log.info("Report fields count: " + columnarray.size());
		int totalColumn = columnarray.size();
		int loopCount = totalColumn / columnPerBatch;
		int lastLoop = totalColumn % columnPerBatch;

		for (int i = 0; i < loopCount; i++) {
			int diff = Math.abs(loopCount - i);
			KolomLaporanTool.clearAllColumn();
			expandAllFolder();

			for (int j = totalColumn - (i * columnPerBatch) - 1; j > totalColumn - (i * columnPerBatch) - columnPerBatch
					- 1; j--) {
//				WaitTool.waitForElementClickable(getWebDriver(), By.xpath(columnarray.get(j)), 2);
				AccTool.moveToElementAndDoubleClick(getWebDriver(), columnarray.get(j));
				log.info("click index [" + j + "]");
			}

			log.info("********************** End of iteration #" + (i + 1) + " **********************");
			LaporanTool.klikSimpanModifikasi(getWebDriver());
			AccTool.waitLoadingMask(getWebDriver());

			if (diff > 1) {
				// log.info("masuk diff > 1");
				LaporanTool.klikModifikasi(getWebDriver());
			} else {
				// log.info("masuk diff = 0");
				if (lastLoop == 0) {
					NavigationTool.klikTutupTabReportPalingKiri(getWebDriver());
				} else {
					LaporanTool.klikModifikasi(getWebDriver());
				}
			}

		}
		if (lastLoop > 0) {
			KolomLaporanTool.clearAllColumn();
			expandAllFolder();
			for (int k = lastLoop; k > 0; k--) {
//				WaitTool.waitForElementClickable(getWebDriver(), By.xpath(columnarray.get(k - 1)), 2);
				AccTool.moveToElementAndDoubleClick(getWebDriver(), columnarray.get(k - 1));
				log.info("click index [" + (k - 1) + "]");
			}

			log.info("********************** End of Final Iteration **********************");
			LaporanTool.klikSimpanModifikasi(getWebDriver());
			AccTool.waitLoadingMask(getWebDriver());
//			WaitTool.delay(50000);
			NavigationTool.klikTutupTabReportPalingKiri(getWebDriver());
		}
	}

	public static ArrayList<String> addReportToArray() {
		ArrayList<String> result = new ArrayList<String>();

		String xpath_daftar_laporan = "//div[contains(@class, 'index-report-tab-container-report')]/div[@class='report-li']/div/h3/a";
		List<WebElement> report_list = getWebDriver().findElements(By.xpath(xpath_daftar_laporan));

		int count_report = report_list.size();
		for (int i = 1; i <= count_report; i++) {
			String xpath_per_index = "//div[contains(@class, 'index-report-tab-container-report')]/div[@class='report-li']["
					+ i + "]/div/h3/a";
			result.add(xpath_per_index);
		}
		return result;
	}

	public static void openReportByXpath(String xpath) {
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(xpath), 10);
		AccTool.moveToElementAndClick(getWebDriver(), xpath);
	}
	
	public static void openReportByXpath2(WebDriver driver, String xpath) {
		WaitTool.waitForElementPresent(getWebDriver(), By.xpath(xpath), 10);
		WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		AccTool.moveToElementAndClick(getWebDriver(), xpath);
	}

	public static void clearAllColumn() {
		String container = "//div[contains(@id, 'accurate__report__report-modify')]";
		String button = container + "//button[@name='btnDeleteAllColumn']";
		String avail_column = container + "//div[contains(@id, 'available-columns')]";

		while (checkColSelCount() > 0) {
			log.info("Column selected before click: " + checkColSelCount());
			WaitTool.waitForElementClickable(getWebDriver(), By.xpath(button), 2);
			AccTool.click(getWebDriver(), button);
			WaitTool.delay(200);
			WaitTool.waitForElementVisible(getWebDriver(), By.xpath(avail_column), 5);
			checkColSelCount();
			log.info("Column selected after click: " + checkColSelCount());
		}

	}

	public static void expandAllFolder() {
		String folderListXpath = "//div[starts-with(@id, 'available-columns')]//li/a[../ul]/preceding-sibling::ins[@class='jstree-icon']";

		List<WebElement> folderList = getWebDriver().findElements(By.xpath(folderListXpath));

		int folderCount = folderList.size();
		log.info("Report field folder count: " + folderCount);
		for (int i = 1; i <= folderCount; i++) {
			AccTool.moveToElementAndClick(getWebDriver(), "(" + folderListXpath + ")[" + i + "]");
		}
	}

	public static String getTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String result = dateFormat.format(date);

		return result;
	}

	public static void autoFillLookup() {
		String reqField = "//div[starts-with(@id, 'tab-report-parameter')]//div[label[@class='required']]";
		String emptyReqField = reqField
				+ "/following-sibling::div/div[contains(@class, 'lookupbox')]/input[not(../ul)]";
		String btnSearch = emptyReqField + "/following-sibling::button";
		String result = emptyReqField + "/../following-sibling::ul[@class='lookup-search-result']";

		List<WebElement> field = getWebDriver().findElements(By.xpath(emptyReqField));
		boolean isExists = field.size() > 0;

		try {
			if (isExists) {
				for (int i = 0; i < field.size(); i++) {
					AccTool.click(getWebDriver(), btnSearch);
					WaitTool.delay(300);
					WaitTool.waitForElementVisible(getWebDriver(), By.xpath(result), 3);
					AccTool.click(getWebDriver(), result + "/li[1]");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int checkColSelCount() {
		String column_selected = "//ul[contains(@class, 'report-selected-columns')]/li";
		List<WebElement> columnSelected = getWebDriver().findElements(By.xpath(column_selected));
		int count = columnSelected.size();
		return count;
	}

	public static void selectOneColumn(String idKolom, Boolean check) {
		String column_selected = "//ul[contains(@class, 'report-selected-columns')]/li";
		AccTool.checkbox(getWebDriver(), column_selected, "@id='" + idKolom + "'", check);
	}

}
