package com.cpssoft.web.test.accurate.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cpssoft.web.test.accurate.widgets.Grid;
import com.cpssoft.web.test.accurate.widgets.WidgetsName;
import com.cpssoft.web.test.framework.tools.FileTool;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;
import com.cpssoft.web.util.CompareUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AccTool {
	static Logger log = LogManager.getLogger(AccTool.class);

	public static void textField(WebDriver driver, String module, String name, String value) {
		if (value != null) {
			String xpath = module + "//input[" + name + "]";
			log.info("Textfield xpath : " + xpath + ", Value: " + value);

			WaitTool.waitForElementVisible(driver, By.xpath(xpath), 20);
//			WaitTool.waitForElementClickable(driver, By.xpath(xpath), 30);
			AccTool.click(driver, xpath);
			WebElementTool.clearValue(driver, By.xpath(xpath));

			switch (value.toLowerCase()) {
			case "blank":
				break;
			default:
				WebElementTool.sendKeys(driver, By.xpath(xpath), value);
			}
		}
	}

	public static void textarea(WebDriver driver, String module, String name, String value) {
		if (value != null) {
			String xpath = module + "//textarea[" + name + "]";
			log.info("textarea xpath : " + xpath);

			WaitTool.waitForElementClickable(driver, By.xpath(xpath), 3);
			AccTool.click(driver, xpath);
			WebElementTool.clearValue(driver, By.xpath(xpath));

			switch (value.toLowerCase()) {
			case "blank":
				break;
			default:
				WebElementTool.sendKeys(driver, By.xpath(xpath), value);
			}

		}
	}

	/*
	 * public static void numberField(WebDriver driver, String module, String name,
	 * String value) { if (value != null) { String xpath = module + "//div[input[" +
	 * name + "]]/input[1]"; log.info("numberfield xpath : " + xpath); // WebElement
	 * element = driver.findElement(By.xpath(xpath));
	 * 
	 * WaitTool.waitForElementClickable(driver, By.xpath(xpath), 10);
	 * AccTool.click(driver, xpath); WebElementTool.clearValue(driver,
	 * By.xpath(xpath)); //WaitTool.delay(300);
	 * WaitTool.waitForElementClickable(driver, By.xpath(xpath), 1);
	 * WebElementTool.sendKeys(driver, By.xpath(xpath), value);
	 * //WaitTool.delay(300); WaitTool.waitForElementClickable(driver,
	 * By.xpath(xpath), 1);
	 * 
	 * } }
	 */

	public static void numberField(WebDriver driver, String module, String name, String value) {
		if (value != null) {
			int i = 0;
			String xpath = module + "//div[input[" + name + "]]/input[1]";
			log.info("numberfield xpath : " + xpath);
			WebElement element = driver.findElement(By.xpath(xpath));

			WaitTool.waitForElementClickable(driver, By.xpath(xpath), 3);
			AccTool.click(driver, xpath);
			WebElementTool.clearValue(driver, By.xpath(xpath));
			WaitTool.delay(300);
			String fieldValue = element.getAttribute("value");
			while (!fieldValue.isEmpty() || i > 1) {
				WebElementTool.clearValue(driver, By.xpath(xpath));
				WaitTool.delay(300);
				fieldValue = element.getAttribute("value");
				i++;
			}
			WebElementTool.sendKeys(driver, By.xpath(xpath), value);
			WaitTool.delay(300);
		}
	}

	public static void clearLookup(WebDriver driver, String xpathmodule, String xpathname) {
		clearLookup(driver, xpathmodule, xpathname, null);
	}

	public static void deleteLookup(WebDriver driver, AccurateModule module, String lookupname, String lookupvalue) {
		clearLookup(driver, module.getXpath(), lookupname, lookupvalue);
	}

	public static void deleteLookupValue(WebDriver driver, AccurateModule module, String lookupname,
			String lookupvalue) {
		clearLookup(driver, module.getXpath(), lookupname, lookupvalue);
	}

	public static void clearLookup(WebDriver driver, String xpathmodule, String xpathname, String lookupLabel) {
		String i = xpathmodule + "//div[input[" + xpathname + "]]/ul/li";

		if (!CompareUtil.isBlank(lookupLabel))
			i += "[label[text()='" + lookupLabel + "']]";

		if (WebElementTool.isElementExists(driver, By.xpath(i))) {
			boolean exists = false;
			try {
				WaitTool.nullifyImplicitWait(driver);
				do {
					List<WebElement> valueexists = driver.findElements(By.xpath(i));
					exists = valueexists.size() > 0;

					if (exists) {
						click(driver, i + "/button");
						// WaitTool.delay(200);
						WaitTool.waitForElementDisapear(driver, By.xpath(i + "/button"), 1);

						// supaya tidak nunggu implicit wait tiap kali close button
						WaitTool.nullifyImplicitWait(driver);
					}
				} while (exists);
			} finally {
				WaitTool.setDefaultImplicitWait(driver);
			}
			log.info("Lookup telah dikosongkan");
		}
	}

	// clear lookup untuk label yang terdapat span
	public static void clearLookup2(WebDriver driver, String lookupname, String lookupLabel) {
		String i = "//div[input[" + lookupname + "]]/ul/li";

		if (!CompareUtil.isBlank(lookupLabel))
			i += "[label[span[text()='" + lookupLabel + "']]]";

		if (WebElementTool.isElementExists(driver, By.xpath(i))) {
			boolean exists = false;
			try {
				WaitTool.nullifyImplicitWait(driver);
				do {
					List<WebElement> valueexists = driver.findElements(By.xpath(i));
					exists = valueexists.size() > 0;

					if (exists) {
						click(driver, i + "/button");
						// WaitTool.delay(200);
						WaitTool.waitForElementDisapear(driver, By.xpath(i + "/button"), 1);
						// supaya tidak nunggu implicit wait tiap kali close button
						WaitTool.nullifyImplicitWait(driver);
					}
				} while (exists);
			} finally {
				WaitTool.setDefaultImplicitWait(driver);
			}
			log.info("Lookup telah dikosongkan");
		}
	}

	public static void clearLookupKategoriKeuangan(WebDriver driver, String fieldKategoriKeuangan) {

		String i = "//div[starts-with(@id, 'tab-customfield')]//div[label[text()='"+fieldKategoriKeuangan+"']]/following-sibling::div//ul/li";
		if (WebElementTool.isElementExists(driver, By.xpath(i))) {
			boolean exists = false;
			try {
				WaitTool.nullifyImplicitWait(driver);
				do {
					List<WebElement> valueexists = driver.findElements(By.xpath(i));
					exists = valueexists.size() > 0;

					if (exists) {
						AccTool.moveToElementAndClick(driver, i + "/button");
//						click(driver, i + "/button");
						//WaitTool.delay(200);
						WaitTool.waitForElementDisapear(driver, By.xpath(i + "/button"), 1);
						
						// supaya tidak nunggu implicit wait tiap kali close button
						WaitTool.nullifyImplicitWait(driver);
					}
				} while (exists);
			} finally {
				WaitTool.setDefaultImplicitWait(driver);
			}
			log.info("Lookup telah dikosongkan");
		}
	}

	public static void lookup(WebDriver driver, String module, String name, String value) {
		if (value != null) {
			String input = module + "//input[" + name + "]";
			String result = module + "//div[div[input[" + name + "]]]/ul[@class='lookup-search-result']";

			// Jika lookup sudah terisi, akan dikosongkan dulu
			AccTool.clearLookup(driver, module, name);

			click(driver, input);
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
				click(driver, input);
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
			click(driver, result + "/li[1]");
			WaitTool.waitForElementDisapear(driver, By.xpath(result), 100);
			AccTool.waitProgressBar(driver);
		}
	}
	
	public static void lookupMapping(WebDriver driver, String module, String name, String value) {
		if (value != null) {
			String input = module + "//input[" + name + "]";
			String result = module + "[div[input["+ name +"]]]/ul[@class='lookup-search-result']";

			// Jika lookup sudah terisi, akan dikosongkan dulu
			AccTool.clearLookup(driver, module, name);

			click(driver, input);
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
				click(driver, input);
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
			click(driver, result + "/li[1]");
			WaitTool.waitForElementDisapear(driver, By.xpath(result), 100);
			AccTool.waitProgressBar(driver);
		}
	}
	
	// lookupNoClear ini untuk lookup, tapi tidak kosongin lookup yang sudah
	// terisi
	public static void lookupWithoutClear(WebDriver driver, String module, String name, String value) {
		if (value != null) {
			String input = module + "//input[" + name + "]";
			String result = module + "//div[div[input[" + name + "]]]/ul[@class='lookup-search-result']";

			click(driver, input);
			WebElementTool.sendKeys(driver, By.xpath(input), value);

			// Wait for lookup to finish the lookup
			By loadingImage = By.xpath(input + "/following-sibling::img[@class='loader-image']");
			try {
				WaitTool.waitForElementVisible(driver, loadingImage, 1);
			} catch (TimeoutException e) {
				// Ignore
				log.debug("No loading image appeared after waiting 1s in lookup: " + input);
			}
			WaitTool.waitForElementDisapear(driver, loadingImage, 20);

			// Klik lookup search list
			WaitTool.waitForElementClickable(driver, By.xpath(result), 20);
			click(driver, result + "/li[1]");
			WaitTool.waitForElementDisapear(driver, By.xpath(result), 20);
			AccTool.waitProgressBar(driver);
		}
	}

	public static void combobox(WebDriver driver, String module, String name, String value) {
		if (value != null) {
			String xpath = module + "//select[" + name + "]";
			log.info("combobox xpath : " + xpath);
			WebElement element = driver.findElement(By.xpath(xpath));
			Select droplist = new Select(element);
			droplist.selectByVisibleText(value);
		}
	}

	public static void checkbox(WebDriver driver, String module, String name, boolean checked) {
		String xpath = module + "//label[input[" + name + "]]";
		log.info("checkbox xpath: " + xpath);

		// untuk hak akses
		if (!xpath.contains("label")) {
			xpath = module + name;
		}

		WebElement element = driver.findElement(By.xpath(xpath + "/input"));

		if (checked) {
			if (!(element.isSelected()))
				click(driver, xpath + "/span");
		} else {
			if (element.isSelected())
				click(driver, xpath + "/span");
		}
	}

	public static void checkboxDynamic(WebDriver driver, String module, String name, boolean checked) {
		// String xpath = module + "//label[input[" + name + "]]";
		String xpath = "//div[contains(@id,'tab-salary')]//label/span[text()='" + name + "']/parent::*";
		log.info("checkbox xpath: " + xpath);
		// untuk hak akses
		if (!xpath.contains("label")) {
			xpath = name;
		}
		WebElement element = driver.findElement(By.xpath(xpath + "/input"));
		if (checked) {
			if (!(element.isSelected()))
				click(driver, xpath + "/span");
		} else {
			if (element.isSelected())
				click(driver, xpath + "/span");
		}
	}

	public static void radioButton(WebDriver driver, String module, String name, boolean checked) {
		String xpath = module + "//label[input[" + name + "]]";
		log.info("radiobutton xpath: " + xpath);

		WebElement element = driver.findElement(By.xpath(xpath + "/input"));

		if (checked && !(element.isSelected())) {
			click(driver, xpath + "/span");
		} else if (!checked && element.isSelected()) {
			click(driver, xpath + "/span");
		}
	}

	public static void dropDown(WebDriver driver, String module, String name, String value) {
		if (value != null) {
			String xpath = module + name + "//*[contains(@class,'dropdown-toggle')]";
			log.info("dropdown xpath: " + xpath);
			click(driver, xpath);
			// WaitTool.delay(500);
			WaitTool.waitForElementVisible(driver, By.xpath(xpath), 1);

			// dropdown-menu
			xpath = "//*[contains(@class,'dropdown-menu')]//*[contains(text(),'" + value + "')]";
			WaitTool.waitForElementVisible(driver, By.xpath(module + xpath), 5);
			WaitTool.delay(2000);
			click(driver, module + xpath);
		}
	}

	public static void datePicker(WebDriver driver, String module, String name, String value) {
		if (value != null) {
			String xpath = module + "//div[input[" + name + " and contains(@data-bind, 'metroDatepicker')]]";
			String calendar = xpath + "//div[contains(@class,'calendar')]";
			log.info("datepicker xpath: " + calendar);
			String tgl = value.substring(0, 2);
			String bln = value.substring(2, 4);
			String thn = value.substring(4, 8);

			if ("0".equals(tgl.substring(0, 1))) {
				tgl = tgl.substring(1, 2);
			}

			switch (bln) {
			case "01":
				bln = "Jan";
				break;
			case "02":
				bln = "Feb";
				break;
			case "03":
				bln = "Mar";
				break;
			case "04":
				bln = "Apr";
				break;
			case "05":
				bln = "May";
				break;
			case "06":
				bln = "Jun";
				break;
			case "07":
				bln = "Jul";
				break;
			case "08":
				bln = "Aug";
				break;
			case "09":
				bln = "Sep";
				break;
			case "10":
				bln = "Oct";
				break;
			case "11":
				bln = "Nov";
				break;
			case "12":
				bln = "Dec";
				break;
			default:
				bln = "Jan";
				break;
			}

			click(driver, xpath + "//button[@class='btn-date']");
			WaitTool.waitForElementVisible(driver, By.xpath(calendar), 5);
			click(driver, calendar + "//table//a[@class='btn-select-month']");
			click(driver, calendar + "//table//a[@class='btn-select-year']");

			String yearXpath = calendar + "//table//a[text()='" + thn + "']";
			int ctr = 0;
			// Make sure to find correct year by clicking previous year if not exists
			while (!WebElementTool.isElementExists(driver, By.xpath(yearXpath)) && ctr < 3) {
				click(driver, calendar + "//table//a[@class='btn-previous-year']");
				ctr++;
			}
			click(driver, yearXpath);

			click(driver, calendar + "//table//a[text()='" + bln + "']");
			click(driver, calendar + "//table//a[text()='" + tgl + "']");
		}
	}

	// public static void click(WebDriver driver, String xpath) {
	// try {
	// log.info("click xpath: " + xpath);
	// waitLoadingMask(driver);
	//
	// WebElementTool.click(driver, By.xpath(xpath));
	// } catch (Throwable e) {
	// // Try to wait for loadmask once again (maybe caused by element
	// // blur)
	// if (e.getMessage().contains("Element is not clickable")) {
	// AccTool.waitLoadingMask(driver);
	// WebElementTool.click(driver, By.xpath(xpath));
	// } else {
	// throw e;
	// }
	// }
	// }

	// /Coba kakdims

	public static void click(WebDriver driver, String xpath) {
		By by = By.xpath(xpath);
		try {
			// log.info("click xpath: " + xpath);
			waitLoadingMask(driver);
			// Tunggu loading diatas hilang
			AccTool.waitProgressBar(driver);
			WebElementTool.click(driver, by);
		} catch (Throwable e) {
			// Try to wait for loadmask once again (maybe caused by element
			// blur)
			if (e.getMessage().contains("Element is not clickable")) {
				AccTool.waitLoadingMask(driver);
				WebElementTool.click(driver, by);
			} else {
				throw e;
			}
		}
	}

	public static void doubleclick(WebDriver driver, String xpath) {
		By by = By.xpath(xpath);
		try {
			log.info("click xpath: " + xpath);
			waitLoadingMask(driver);
			// Tunggu loading diatas hilang
			AccTool.waitProgressBar(driver);
			WebElementTool.doubleClick(driver, by);
		} catch (Throwable e) {
			// Try to wait for loadmask once again (maybe caused by element
			// blur)
			if (e.getMessage().contains("Element is not clickable")) {
				AccTool.waitLoadingMask(driver);
				WebElementTool.doubleClick(driver, by);
			} else {
				throw e;
			}
		}
	}

	public static void moveToElementAndDoubleClick(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions builder = new Actions(driver);
		builder.moveToElement(element);
		WaitTool.delay(200);
		WaitTool.waitForElementClickable(driver, By.xpath(xpath), 3);
		doubleclick(driver, xpath);
		WaitTool.delay(300);
	}

	public static void moveToElementAndClick(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions builder = new Actions(driver);
		builder.moveToElement(element);
		WaitTool.delay(200);
		WaitTool.waitForElementClickable(driver, By.xpath(xpath), 3);
		click(driver, xpath);
		WaitTool.delay(200);
	}

	public static void waitLoadingMask(WebDriver driver) {
		// WaitTool.waitForElementDisapear(driver, By.cssSelector(".loadmask"), 600);
		WaitTool.waitForElementDisapear(driver, By.cssSelector(".busy-load-container"), 2000);
	}

	public static void waitLoadingMaskVisible(WebDriver driver) {
		WaitTool.waitForElementVisible(driver, By.cssSelector(".busy-load-container"), 5);
	}

	public static void waitGridMask(WebDriver driver) {
		waitGridMask(driver, false);
	}

	public static void waitGridMask(WebDriver driver, boolean waitMaskAppeared) {
		// By by =
		// By.xpath("//div[contains(@class,'grid-container')]/span[contains(@class,'loadmask-msg')]");
		By by = By.cssSelector(".busy-load-container");

		if (waitMaskAppeared) {
			try {
				WaitTool.waitForElementVisible(driver, by, 1);
			} catch (TimeoutException e) {
				// Ignore
				log.debug("No loading mask appeared in grid after waiting for 1s");
			}
		}

		WaitTool.waitForElementDisapear(driver, by, 600);
	}

	public static void waitProgressBar(WebDriver driver) {
		WaitTool.waitForElementDisapear(driver, By.xpath("//div[starts-with(@class,'module-body nprogress')]"), 60);
	}

	public static void waitLoaderMedium(WebDriver driver) {
		By loadingImage = By.xpath("//img[@src='loader-medium.gif']");
		try {
			WaitTool.waitForElementVisible(driver, loadingImage, 1);
		} catch (TimeoutException e) {
			// Ignore
			log.debug("No loading image appeared after waiting 1s");
		}
		WaitTool.waitForElementDisapear(driver, loadingImage, 60);
	}

	/**
	 * @deprecated use NavigationTool class instead.
	 */
	@Deprecated
	public static void clickButton(WebDriver driver, String xpath, String name) {
		if (name != null) {
			log.info("clickbutton : " + name);
			switch (name.toLowerCase()) {
			// -----DETAIL-----
			// case "simpan":
			// xpath = xpath + "//button[@name='btnSave']";
			// break;
			// case "save":
			// xpath = xpath + "//i[@class='icon-floppy']";
			// break;
			// case "tambahsaldo": // Pelanggan
			// case "tambahkontak": // Pelanggan
			// case "tambahdetail": // Penomoran
			// xpath = xpath
			// +
			// "//button[contains(@data-bind, 'metroButton') and contains
			// (@data-bind,'Tambah')]";
			// break;
			// case "hapus":
			// xpath = xpath + "//i[@class='icon-remove']";
			// break;
			case "cetak detail":
				xpath = xpath + "//i[@class='icon-printer']";
				break;
			// case "cetak printer":
			// xpath = xpath
			// +
			// "//ul[@class='text-left drop-left
			// dropdown-menu']//*[contains(text(),'"
			// + name + "')]";
			// break;

			// case "histori":
			// xpath = xpath + "//a[contains(@href, 'tab-history')]";
			// break;
			// case "rekaman":
			// xpath = xpath
			// + "//button[contains(@data-bind, 'copy-memorize-transaction')]";
			// break;
			case "faktur":
				xpath = xpath + "//button[contains(@data-bind, 'metroButton') and text()='Faktur')]";
				break;
			// case "%":
			// xpath = xpath
			// + "//button[contains(@data-bind, 'percentValue')]";
			// break;
			// case "recalculate":
			// xpath = xpath
			// + "//div[@class='module-body']//i[@class='icon-cycle']";
			// break;
			// case "tambah":
			// xpath = xpath + "//button[@title='Tambah']";
			// break;

			// -----HEADER----
			case "new":
				xpath = xpath + "//button[contains(@data-bind, 'addNew') and contains(@data-hint, 'Tambah')]";
				break;
			// case "list":
			// xpath = xpath + "//button[@data-hint='List']";
			// break;
			case "close":
				xpath = xpath + "//i[contains(@class,'icon-cancel')]";
				break;
			case "editno":
				xpath = xpath + "//i[contains(@class,'icon-pencil')]";
				break;

			// -----LIST-----
			case "expor":
				xpath = xpath + "//button[@data-hint='Expor Data']";
				break;
			case "cetak list":
				xpath = xpath + "//button[@data-hint='Cetak']";
				break;
			case "pengaturan":
				xpath = xpath + "//button[@data-hint='Pengaturan']";
				break;
			case "refresh":
				xpath = xpath + "//button[@data-hint='Perbaruhi']";
				break;
			case "tambah kriteria":
				xpath = xpath + "//button[@title='Tambah Kriteria']";
				break;

			// -----Notification-----
			// case "close notification":
			// xpath =
			// "/html/body/div[@class='metro
			// notify-container']//i[contains(@class,'icon-cancel')]";
			// break;

			// -----Indikator-----
			case "indikatorbatal":
				xpath = "//div[@class='queue-content']//button[text()='Batal']";
				break;
			case "indikatoredit":
				xpath = "//div[@class='queue-content']//button[text()='Edit']";
				break;
			case "indikatorlanjutkan":
				xpath = "//div[@class='queue-content']//button[text()='Lanjutkan']";
				break;

			// ----untuk klik tab persiapan data perusahaan
			// ----kadang2 tertutup form Dasbor
			case "fokuspersiapandata":
				xpath = "//a[@text='Persiapan Data Perusahaan']";
				break;

			default:
				xpath = xpath + "//*[contains(text(),'" + name + "')]";
			}
			click(driver, xpath);
		}

	}

	/**
	 * @deprecated use NavigationTool class instead.
	 */
	@Deprecated
	public static void clickWindowButton(WebDriver driver, String xpath, String name) {
		if (name != null) {
			log.info("clickwindow : " + name);
			switch (name.toLowerCase()) {
			case "ya":
				xpath = xpath + "//button[@name='btnOk' and text()='Ya']";
				break;
			case "ok":
				xpath = xpath + "//button[@name='btnOk' and text()='OK']";
				break;
			case "simpan":
				xpath = xpath + "//button[@name='btnSave']";
				break;
			// case "lanjutkan":
			// xpath = xpath + "//button[@name='btnContinue']";
			// break;
			case "lanjut":
				xpath = xpath + "//button[@name='btnNext']";
				break;
			case "batal":
				xpath = xpath + "//button[@name='btnCancel']";
				break;
			case "tutup":
				xpath = xpath + "//button[@name='btnClose']";
				break;
			// case "hapus": // ini untuk hapus detail grid
			// xpath = xpath + "//button[text()='Hapus']";
			// break;
			// case "tampilkan": // ini untuk filter report
			// xpath = xpath + "//*[text()='Tampilkan']";
			// break;

			default:
				xpath = xpath + "//button[text()='" + name + "']";
			}
			switch (name.toLowerCase()) {
			case "Simpan":
				WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 5);
			}

			click(driver, xpath);
		}
	}

	public static void clickCell(WebDriver driver, String xpath, String name) {
		if (name != null) {
			log.info("clickCell : " + name);
			xpath = xpath + "//div[text()='" + name + "' and contains (@class,'slick-cell')]";
			findCell(driver, xpath);

			WaitTool.waitForElementVisible(driver, By.xpath(xpath), 20);
			AccTool.click(driver, xpath);
			AccTool.waitLoadingMask(driver);
		}

	}
	
	private static boolean isCellExists(WebDriver driver, String xpath) {
		List<WebElement> element = driver.findElements(By.xpath(xpath));
		return element.size() > 0;
		
	}
	
	private static void findCell(WebDriver driver, String xpath) {
		log.info("masuk method findCell");
		String lastrow = "(//div[@class='slick-viewport'][1]/div[@class='grid-canvas']//div[contains(@class, 'r1')])[last()]";
		
		do {
			if (!isCellExists(driver, xpath)) {
				log.info("cek xpathcelltofind: " + xpath);

				WebElement element = driver.findElement(By.xpath(lastrow));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			} else {

				break;
			}
		}
		while(!isCellExists(driver, xpath));
	}

	/**
	 * @deprecated use {@link #getNotification(WebDriver driver)} instead.
	 */
	@Deprecated
	public static String getNotification(WebDriver driver, String value) {
		return value + getNotification(driver);
	}

	public static String getNotification(WebDriver driver) {
		String xpath = "/html/body/div[@class='metro notify-container']/div[contains(@class,'notify')]";

//		AccTool.waitLoadingMask(driver);
		WebElement notification = WaitTool.waitForElementPresent(driver, By.xpath(xpath), 150);
		String result = notification.getAttribute("textContent");
		try {
			AccTool.waitLoadingMask(driver); // tambahin biar staging ga error
			notification.findElement(By.xpath(".//i[contains(@class,'icon-cancel')]")).click();
			WaitTool.waitForElementDisapear(driver, By.xpath(xpath), 5);
		} catch (Throwable t) {
			log.warn("Unable to close notification: " + t.getMessage());
		}
		log.info("Notifikasi: " + result);
		return result + "\r\n";
	}

	@Deprecated
	public static String getTextValue(String tipe, WebDriver driver, String module, String name, String value) {
		throw new RuntimeException(
				"This method is deprecated, please switch to: getTextValue(WebDriver driver, AccurateModule module, ElementType type, String elementName, String additionalXpath)");
	}

	public static String getTextValue(WebDriver driver, AccurateModule module, ElementType type, String elementName) {
		return getTextValue(driver, module, type, elementName, null);
	}

	public static String getTextValue(WebDriver driver, ElementType type, String elementName, String additionalXpath) {
		return getTextValue(driver, null, type, elementName, additionalXpath);
	}

	public static String getTextValue(WebDriver driver, AccurateModule module, String additionalXpath) {
		return getTextValue(driver, module, null, null, additionalXpath);
	}

	public static String getTextValue(WebDriver driver, String additionalXpath) {
		return getTextValue(driver, null, null, null, additionalXpath);
	}

	public static String getTextValue(WebDriver driver, AccurateModule module, ElementType type, String elementName,
			String additionalXpath) {
		String modul = "";
		if (additionalXpath == null)
			additionalXpath = "";

		if (module == null)
			modul = "";
		else
			modul = module.getXpath();

		String xpath = null;

		if (type == null)
			xpath = modul + additionalXpath;
		else {
			switch (type) {
			case TEXTFIELD:
				xpath = modul + additionalXpath + "//div[@class='input-control text']/input[@name='" + elementName
						+ "']";
				break;

			case TEXTAREA:
				xpath = modul + additionalXpath + "//textarea[@name='" + elementName + "']";
				break;

			case CHECKBOX:
			case DATEPICKER:
				xpath = modul + additionalXpath + "//input[@name='" + elementName + "']";
				break;

			case NUMBERFIELD:
				xpath = modul + additionalXpath + "//div[input[@name='" + elementName
						+ "']]/input[contains(@data-bind,'Numberfield')]";
				break;

			case LOOKUP:
				xpath = modul + additionalXpath + "//div[input[@name='" + elementName + "']]/ul/li/label";
				break;

			case COMBOBOX:
				xpath = modul + additionalXpath + "//select[@name='" + elementName + "']";

				break;
			case LABEL:
				xpath = modul + additionalXpath + "//label[contains(@data-bind, '" + elementName + "')]";
				break;

			case DIV:
				xpath = modul + additionalXpath + "//div[@name='" + elementName + "']";
				break;

			case SPAN:
				xpath = modul + additionalXpath + "//span[contains(@data-bind, '" + elementName + "')]";
				break;

			case RADIOBUTTON:
				String temp[] = elementName.split(":");

				if (temp.length == 2) {
					xpath = modul + additionalXpath + "//input[@name='" + temp[0] + "' and @value='" + temp[1] + "']";
				} else {
					xpath = modul + additionalXpath + "//input[@value='" + elementName + "']";
				}
				break;
			case INDICATOR:
				xpath = modul + additionalXpath + "//ul[@class='messages']/li";
				break;
			case SUMMARY:
				xpath = modul + additionalXpath + "//div[contains(@data-bind, '" + elementName + "')]";
				break;
			case REPORT:
				xpath = modul + additionalXpath;
				break;

			case OTHER: // untuk ngakalin biar yang modul + additionalXpath bisa
						// masuk ke element.getAtttribute("value")
				xpath = modul + additionalXpath;
				break;
			default:
				xpath = modul + additionalXpath;
				break;
			}
		}

		List<WebElement> elementList = new ArrayList<WebElement>();
		try {
			WaitTool.nullifyImplicitWait(driver);
			elementList = driver.findElements(By.xpath(xpath));
		} catch (NoSuchElementException e) {

		} finally {
			WaitTool.setDefaultImplicitWait(driver);
		}

		StringJoiner result = new StringJoiner(",");
		for (WebElement element : elementList) {
			String textValue = getElementTextValue(driver, type, xpath, element);
			result.add(textValue);
		}

		return result.toString() + "\r\n";
	}

	private static String getElementTextValue(WebDriver driver, ElementType type, String xpath, WebElement element) {
		String result = "";

		if (element != null) {
			if (type == null)
				result = element.getText();
			else {
				switch (type) {
				case CHECKBOX:
				case RADIOBUTTON:
					result = String.valueOf(element.isSelected());
					break;
				case LOOKUP:
				case INDICATOR:
				case LABEL:
					result = element.getAttribute("textContent");
					break;
				case SPAN:
					result = element.getAttribute("textContent");
					break;
				case SUMMARY:
					result = element.getAttribute("textContent");
					break;
				case REPORT:
					result = element.getAttribute("textContent");
					break;
				case DIV:
					result = element.getAttribute("textContent");
					break;
				case COMBOBOX:
					Select combobox = new Select(driver.findElement(By.xpath(xpath)));
					result = combobox.getFirstSelectedOption().getText();
					break;
				// case OTHER:
				// result = element.getAttribute("textContent");
				// break;
				default:
					result = element.getAttribute("value");
				}
			}
		}
		return result;
	}

	public static void writeTextFile(String filename, String content) {
		FileTool.write(filename, content);
	}

	public static void deleteTextFile(String filename) {
		FileTool.delete(filename);
	}

	public static void compareTextFile(String filename, String direktori) {
		FileTool.compare(filename, direktori);
	}

	public static void scrollRow(WebDriver driver, String module, String value) {
		if (value != null) {
			log.info("scrollRow : " + value);
			String xpath = "//div[@class='grid-container']/div[starts-with(@data-bind,'slickGrid')]";

			Grid grid = new Grid(driver, module + xpath);
			int row = grid.searchKeyword(value);
			grid.selectRow(row);
			AccTool.waitLoadingMask(driver);
		}
	}

	public static void scrollRowDetail(WebDriver driver, String module, String value) {
		if (value != null) {
			String xpath = "//div[@class='grid-container']/div[starts-with(@data-bind,'slickGrid')]";

			Grid grid = new Grid(driver, module + xpath);
			int row = grid.searchKeyword(value);
			grid.selectCell(row, 1);
			AccTool.waitLoadingMask(driver);
		}
	}

	/**
	 * @deprecated use
	 *             {@link #getGridValue(WebDriver driver, AccurateModule module, String additionalXpath)}
	 *             instead.
	 */
	@Deprecated
	public static String getGridValue(WebDriver driver, String module) {
		throw new RuntimeException(
				"This method is deprecated, please switch to: getGridValue(WebDriver driver, AccurateModule module, String additionalXpath)");
	}

	public static String getGridValue(WebDriver driver, AccurateModule module, String additionalXpath) {
		if (additionalXpath == null)
			additionalXpath = "";

		String result = "";
		String xpath = "//div[@class='grid-container']/div[starts-with(@data-bind,'slickGrid')]";

		if (module == AccurateModule.UMUM) {

			Grid grid = new Grid(driver, module.getId() + additionalXpath + xpath);

			JSONArray gridData = grid.getData();
			log.info("Grid Data Size: " + gridData.size());

			for (int i = 0; i < gridData.size(); i++) {
				JSONObject data = gridData.getJSONObject(i);
				try {
					result = result + data.toString() + "\r\n";
					// log.info(i + ": " + result);
				} catch (Throwable t) {
					log.error("Error get Grid Data at index " + i + ": " + data + ", Error: " + t.getMessage(), t);
				}
			}
		} else {
			Grid grid = new Grid(driver, module.getXpath() + additionalXpath + xpath);

			JSONArray gridData = grid.getData();
			log.info("Grid Data Size: " + gridData.size());

			for (int i = 0; i < gridData.size(); i++) {
				JSONObject data = gridData.getJSONObject(i);
				try {
					result = result + data.toString() + "\r\n";
					// log.info(i + ": " + result);
				} catch (Throwable t) {
					log.error("Error get Grid Data at index " + i + ": " + data + ", Error: " + t.getMessage(), t);
				}
			}
		}

		return result;
	}

	public static String getWidgetValue(WebDriver driver, WidgetsName name) {

		String result = "";
		String xpath = null;
		String module = "";
		switch (name) {
		case HUTANG_USAHA:
			xpath = WidgetsName.HUTANG_USAHA.getXpath() + "//label/span[3]";
			break;

		default:
			xpath = module;
		}
		WebElement element = driver.findElement(By.xpath(xpath));
		result = element.getText();
		return result;
	}

	public static void changeReportSaveName(WebDriver driver, String name) {
		String javascript = "acc.report_export_text_filename = '" + name + "';";
		((JavascriptExecutor) driver).executeScript(javascript);
	}
	
	public static String getTextByCSS(WebDriver driver, String css) {
		return driver.findElement(By.cssSelector(css)).getText();
	}
	
	public static boolean elementExist(WebDriver driver, String xpath) {
		return driver.findElements(By.xpath(xpath)).size() > 0;
	}
	
	public static boolean elementExistCSS(WebDriver driver, String css) {
		return driver.findElements(By.cssSelector(css)).size() > 0;
	}

}
