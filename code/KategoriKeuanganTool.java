package com.cpssoft.web.test.accurate.tool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.kategorikeuangan.KategoriKeuanganParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class KategoriKeuanganTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(KategoriKeuanganTool.class);

	public static void isiKategoriKeuangan(WebDriver driver, AccurateModule module, KategoriKeuanganParam param) {
		log.info("KategoriKeuangan.isiDataKustomisasi");

		String w = module.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";

		AccTool.click(driver, w + "//ul[@class='tabs']//a[contains(@href, 'tab-general')]");
		if (param.nama != null)
			AccTool.textField(driver, tab, "@name='name'", param.nama);
	}

	public static void isiDaftarPengguna(WebDriver driver, AccurateModule module, KategoriKeuanganParam param) {
		log.info("KategoriKeuangan.isiDaftarPengguna");

		String w = module.getXpath();
		String tab = w + "//*[contains(@id,'tab-others')]";

		AccTool.click(driver, w + "//ul[@class='tabs']//a[contains(@href, 'tab-others')]");

		if (param.semua != null)
			AccTool.checkbox(getWebDriver(), tab, "@name='usedAllUser'", param.semua);

		if (param.grupcabang != null)
			AccTool.lookup(driver, tab, "@name='useUserRoleAccessList'", param.grupcabang);

		if (param.pengguna != null)
			AccTool.lookup(driver, tab, "@name='useUserAccessList'", param.pengguna);
	}

	public static void saveIsiKategoriKeuangan(WebDriver driver, AccurateModule module, String filename) {
		String w = module.getXpath();
		String tab = "";
		String content = "KategoriKeuangan.saveIsiKategoriKeuangan : " + "\r\n";

		AccTool.click(driver, w + "//ul[@class='tabs']//a[contains(@href, 'tab-general')]");
		tab = "//*[contains(@id,'tab-general')]";
		content = content + "Nama	: " + AccTool.getTextValue(driver, module, ElementType.TEXTFIELD, "name", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	public static void saveIsiDaftarPengguna(WebDriver driver, AccurateModule module, String filename) {
		String w = module.getXpath();
		String tab = "";
		String content = "KategoriKeuangan.saveIsiDaftarPengguna : " + "\r\n";

		AccTool.click(driver, w + "//ul[@class='tabs']//a[contains(@href, 'tab-others')]");
		tab = "//*[contains(@id,'tab-others')]";
		content = content + "Semua Pengguna : "
				+ AccTool.getTextValue(driver, module, ElementType.CHECKBOX, "usedAllUser", tab) + "Grup / Cabang : "
				+ AccTool.getTextValue(driver, module, ElementType.LOOKUP, "useUserRoleAccessList", tab) + "Pengguna : "
				+ AccTool.getTextValue(driver, module, ElementType.LOOKUP, "useUserAccessList", tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}

	private static void lookupKategoriKeuangan(WebDriver driver, String name, String value) {
		String w = "//div[@class='dialog-form']//div[starts-with(@id, 'tab-customfield')]";
		String xpath = w + "//div[label[text()='" + name
				+ "']]/../div//input[starts-with(@name, 'dataClassification')]";

		if (value != null) {
			String input = xpath;
			String result = input + "/../following-sibling::ul[@class='lookup-search-result']";

			// Jika lookup sudah terisi, akan dikosongkan dulu
			AccTool.clearLookupKategoriKeuangan(driver, name);

			AccTool.click(driver, input);
			WaitTool.waitForElementVisible(driver, By.xpath(input), 1);
			WebElementTool.sendKeys(driver, By.xpath(input), value);
			// WaitTool.delay(200);
			WaitTool.waitForElementVisible(driver, By.xpath(input), 1);

			// Check nilai apakah sama dgn yg kita mau
			WebElement element = driver.findElement(By.xpath(input));
			String insertedValue = element.getAttribute("value");
			if (insertedValue.equals(value) == false) {
				// Failed, must send characters one at a time
				log.info("Yang diketik salah = " + insertedValue + " harusnya = " + value);
				AccTool.click(driver, input);
				WaitTool.waitForElementVisible(driver, By.xpath(input), 1);
				element.clear();

				int i;
				for (i = 0; i < value.length(); i++) {
					element.sendKeys("" + value.charAt(i));
				}
			}

			// Wait for lookup to finish the lookup
			By loadingImage = By.xpath(input + "/following-sibling::img[@class='loader-image']");
			try {
				WaitTool.waitForElementVisible(driver, loadingImage, 1);
			} catch (TimeoutException e) {
				// Ignore
				log.debug("No loading image appeared after waiting 1s in lookup: " + input);
			}
			WaitTool.waitForElementDisapear(driver, loadingImage, 40);

			// Klik lookup search list
			WaitTool.waitForElementClickable(driver, By.xpath(result), 100);
			AccTool.click(driver, result + "/li[1]");
			WaitTool.waitForElementDisapear(driver, By.xpath(result), 100);
			AccTool.waitProgressBar(driver);
		}

	}
	
	private static void lookupKategoriKeuanganBiaya(WebDriver driver, String name, String value) {
		String w = "//div[starts-with(@id, 'detail-expense')]//div[starts-with(@id, 'tab-customfield')]";
		String xpath = w + "//div[label[text()='" + name
				+ "']]/../div//input[starts-with(@name, 'dataClassification')]";

		if (value != null) {
			String input = xpath;
			String result = input + "/../following-sibling::ul[@class='lookup-search-result']";

			// Jika lookup sudah terisi, akan dikosongkan dulu
			AccTool.clearLookupKategoriKeuangan(driver, name);

			AccTool.click(driver, input);
			WaitTool.waitForElementVisible(driver, By.xpath(input), 1);
			WebElementTool.sendKeys(driver, By.xpath(input), value);
			// WaitTool.delay(200);
			WaitTool.waitForElementVisible(driver, By.xpath(input), 1);

			// Check nilai apakah sama dgn yg kita mau
			WebElement element = driver.findElement(By.xpath(input));
			String insertedValue = element.getAttribute("value");
			if (insertedValue.equals(value) == false) {
				// Failed, must send characters one at a time
				log.info("Yang diketik salah = " + insertedValue + " harusnya = " + value);
				AccTool.click(driver, input);
				WaitTool.waitForElementVisible(driver, By.xpath(input), 1);
				element.clear();

				int i;
				for (i = 0; i < value.length(); i++) {
					element.sendKeys("" + value.charAt(i));
				}
			}

			// Wait for lookup to finish the lookup
			By loadingImage = By.xpath(input + "/following-sibling::img[@class='loader-image']");
			try {
				WaitTool.waitForElementVisible(driver, loadingImage, 1);
			} catch (TimeoutException e) {
				// Ignore
				log.debug("No loading image appeared after waiting 1s in lookup: " + input);
			}
			WaitTool.waitForElementDisapear(driver, loadingImage, 40);

			// Klik lookup search list
			WaitTool.waitForElementClickable(driver, By.xpath(result), 100);
			AccTool.click(driver, result + "/li[1]");
			WaitTool.waitForElementDisapear(driver, By.xpath(result), 100);
			AccTool.waitProgressBar(driver);
		}

	}
	
	
	//isi detail transaksi ini dijalankan per lookup
	public static void isiDetailTransaksi(WebDriver driver, String name, String value) {
		String w = "//div[@class='dialog-form']//div[starts-with(@id, 'tab-customfield')]";
		String xpath = w + "//div[label[text()='" + name
				+ "']]/../div//input[starts-with(@name, 'dataClassification')]";


//		String tabInfoLain = "//form[starts-with(@class, 'detail-form')]//ul[@class='tabs']//li[a[contains(@href, 'tab-customfield')]]";
		String tabInfoLain = "//*[contains(@id,'detail-item')]//*[contains(@id,'tabcustomfield')]";
		
		AccTool.click(driver, tabInfoLain);

		WaitTool.waitForElementPresent(driver, By.xpath(xpath), 3);
		lookupKategoriKeuangan(driver, name, value);
	}
	
	
	public static void isiDetailTransaksiBiaya(WebDriver driver, String name, String value) {
		String w = "//*[starts-with(@id, 'expenses-tab')]//*[starts-with(@id, 'tab-customfield')]";
		String xpath = w + "//div[label[text()='" + name
				+ "']]/../div//input[starts-with(@name, 'dataClassification')]";

		String tabInfoLain = "//*[contains(@id,'detail-expense')]//*[contains(@id,'tabcustomfield')]";

		AccTool.click(driver, tabInfoLain);

		WaitTool.waitForElementPresent(driver, By.xpath(xpath), 3);
		lookupKategoriKeuanganBiaya(driver, name, value);
	}
	
	public static void saveList(WebDriver driver, AccurateModule module, String filename) {

		String tab = "//div[starts-with(@class,'module-list')]";
		String content = "KategoriKeuangan.SaveList : " + "\r\n";

		content = content + AccTool.getGridValue(driver, module, tab) + "\r\n";
		AccTool.writeTextFile(filename, content);

	}
}
