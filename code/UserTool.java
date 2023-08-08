package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.general.GeneralParam;
import com.cpssoft.web.test.accurate.setupawal.SetupAwalParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebDriverTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class UserTool extends AbstractAccurateTestCase {

	static Logger log = LogManager.getLogger(UserTool.class);

	static public final String DB_MANAGE_TITLE = "Accurate Online: Pengaturan Database ACCURATE";
	static public final String DB_MANAGE_TITLE2 = "Nucleus Platform: Pengaturan Database ACCURATE";

	public static void loginUser(WebDriver driver, String email, String password) {
		AccTool.waitLoadingMask(driver);
		// Isi form login
		AccTool.textField(driver, "", "@name='j_username'", email);
		AccTool.textField(driver, "", "@name='j_password'", password);
		
		WaitTool.waitForElementPresent(driver, By.xpath("//button[@name='btnLogin']"), 20);
		AccTool.click(driver, "//button[@name='btnLogin']");
		
		// Cek apakah login berhasil ui lama
//		log.info("Tunggu hingga tampil Pengaturan Database ACCURATE...");
//		WaitTool.wait(driver, ExpectedConditions.titleContains(DB_MANAGE_TITLE));
//		log.info("Cek title page: " + DB_MANAGE_TITLE);
//		Assert.assertEquals(driver.getTitle(), DB_MANAGE_TITLE, "Invalid page title: " + driver.getTitle());
//		log.info("Berhasil login");	
		
		// Cek apakah login berhasil ui baru
		log.info("Tunggu hingga tampil Pengaturan Database ACCURATE...");
		WaitTool.waitForElementPresent(driver, By.xpath("//*[@id='content']"), 20);
		WaitTool.delay(2000);
		log.info("Berhasil login");

	}

	public static void loginUserTest(WebDriver driver, String email, String password) {
		// Isi form login
		AccTool.textField(driver, "", "@name='j_username'", email);
		AccTool.textField(driver, "", "@name='j_password'", password);

	}

	public static void buatDBBaru(WebDriver driver, String dbAlias,GeneralParam param) {
		log.info("BuatDB");
		//ui lama
//		String xpath = "//div[div[span[text()='" + dbAlias + "']]]";
		//ui baru
//		String xpath = "//div[div[span[h3()='" + dbAlias + "']]]";
		String xpath = "//h3[text()='" + dbAlias + "']";


		boolean exists = false;
		do {
			// HAPUS DB KALAU MASIH ADA
			List<WebElement> databaseList = driver.findElements(By.xpath(xpath));
			log.info("Database list: " + databaseList.size());
			exists = databaseList.size() > 0;
			if (exists) {
				WaitTool.delay(2000);
				WaitTool.waitForElementClickable(driver, By.xpath(xpath + "/ancestor::div[contains(@class, 'card-db')]//a[@id='more-db']"), 20);
				WebElementTool.click(driver, By.xpath(xpath + "/ancestor::div[contains(@class, 'card-db')]//a[@id='more-db']"));
				WaitTool.waitForElementVisible(driver, By.xpath("//*[@class='dropdown-menu dropdown-menu-end show']"), 10);
				WaitTool.waitForElementVisible(driver, By.xpath("//*[@class='dropdown-menu dropdown-menu-end show']"), 10);
				AccTool.click(driver, "//*[@class='dropdown-menu dropdown-menu-end show']//a[.='Nonaktifkan Data']");

				AccTool.click(driver, "//*[.='Lanjutkan']");
				WaitTool.delay(1000);
				// Notification
//				String content = AccTool.getNotification(driver) + "\r\n";
//				log.info(content);
				WaitTool.delay(1000);

				AccTool.waitLoadingMask(driver);

			}
		} while (exists);

		// Mulai BUAT DB ui lama
//		WaitTool.waitForElementVisible(driver, By.xpath("//i[@class= 'icon-plus-2']"), 10);
//		AccTool.click(driver, "//i[@class= 'icon-plus-2']");
//		log.info("Tombol new DB telah ditekan");
		
		
		// Mulai BUAT DB ui baru di ui baru langsung terlempar ke 
		WaitTool.waitForElementVisible(driver, By.xpath("//*[contains(@class,'btn-danger')]"), 50);
		AccTool.click(driver, "//*[contains(@class,'btn-danger')]");
		log.info("Tombol new DB telah ditekan");

		AccTool.waitLoadingMask(driver);

		xpath = "//div[contains(@id,'manage__database')]";
		// di bawah ini buat nunggu elemen "alias" sampe bisa diklik
		AccTool.textField(driver,"//form[@id='database-form']", "@name='alias'", dbAlias);
		log.info("Nama " + dbAlias + " telah diinput");
		
		AccTool.combobox(driver, "//form[@id='database-form']", "@name='industryTypeId'",param.bidangUsaha);

		// AccTool.clickWindowButton(driver,
		// "//div[starts-with(@id,'manage__database')]", "Simpan");
		AccTool.click(driver, "//form[@id='database-form']//*[contains(@type,'submit')]");
		log.info("Tombol Simpan telah ditekan");

		WaitTool.delay(1000);
		AccTool.waitLoadingMask(driver);
		WaitTool.delay(1000);

		log.info("Tombol new DB telah ditekan");
		WaitTool.waitForElementVisible(driver, By.xpath("//button[@class='swal2-confirm order-2 btn btn-danger']"), 10);
		AccTool.click(driver, "//button[@class='swal2-confirm order-2 btn btn-danger']");
		
		int ctr = 3;
		do {
			try {
				WebDriverTool.switchToWindow(driver, "/accurate/");
				ctr = 0;
			} catch (Throwable t) {
				if (ctr > 0) {
					ctr--;
					log.warn("Fail switching to Accurate tab. Maybe the server is busy, will retry " + ctr + " times: "
							+ t.getMessage());
					WaitTool.delay(2000);
				} else {
					throw t;
				}
			}
		} while (ctr > 0);

		
		// Tunggu loading mask hilang
		AccTool.waitLoadingMask(driver);
		WaitTool.waitForElementVisible(driver, By.xpath("//div[@class='module-section first-setup']"), 1000);
	}

	public static void buatDBSample(WebDriver driver, String dbAlias) {
		log.info("BuatDB Sample");

		String xpath = "//div[div[span[text()='" + dbAlias + "']]]";
		boolean exists = false;
		do {
			// HAPUS DB KALAU MASIH ADA
			List<WebElement> databaseList = driver.findElements(By.xpath(xpath));
			log.info("Database list: " + databaseList.size());
			exists = databaseList.size() > 0;
			if (exists) {
				WaitTool.delay(2000);
				WaitTool.waitForElementVisible(driver, By.xpath(xpath + "//*[contains(@class,'dropdown-toggle')]"), 20);
				WebElementTool.click(driver, By.xpath(xpath + "//*[contains(@class,'dropdown-toggle')]"));
				WaitTool.waitForElementVisible(driver, By.xpath(xpath + "//ul[@class='dropdown-menu']"), 10);
				WaitTool.waitForElementVisible(driver, By.xpath(xpath + "//i[@class='icon-blocked']"), 10);
				AccTool.click(driver, xpath + "//i[@class='icon-blocked']");

				NavigationTool.klikKonfirmasiLanjut(driver);
				// WaitTool.delay(1000);
				// Notification
				String content = AccTool.getNotification(driver) + "\r\n";
				log.info(content);

				AccTool.waitLoadingMask(driver);

			}
		} while (exists);

		// Mulai COPY DB
		WaitTool.waitForElementVisible(driver, By.xpath("//i[@class= 'icon-plus-2']"), 10);
		AccTool.click(driver, "//i[@class= 'icon-plus-2']");
		log.info("Tombol new DB telah ditekan");

		AccTool.waitLoadingMask(driver);

		xpath = "//div[contains(@id,'manage__database')]";
		AccTool.click(driver, xpath + "//i[@class= 'icon-copy']");
		AccTool.click(driver, xpath + "//div[@class = 'frame active']//div[div[span[text() = '" + dbAlias + "']]]");
		AccTool.click(driver, xpath + "//input[@name= 'btnCreateSample']");

		AccTool.waitLoadingMask(driver);
		WaitTool.delay(1000);

		// --> ga jadi - bagian di bawah ini dicomment karena : ACC-7510
		// Cek apakah create DB berhasil
		WaitTool.waitForElementVisible(driver, By.xpath("//div[div[span[text()='" + dbAlias + "']]][1]"), 1000);
		log.info("DB berhasil dibuat");

	}
	
	public static void bukaDBBarusetUpAwal(WebDriver driver, String dbAlias) {
		log.info("BuatDB");

		// pilih Database ui lama
		String xpath = "//div[div[span[text()='" + dbAlias + "']] and contains(@data-bind,'database')][1]";
		//pilih database uibaru
		String xpath2 = "//div[div[h3[text()='" + dbAlias + "']]]";
		
		//click database ui lama
//		log.info(xpath);
//		WaitTool.waitForElementVisible(driver, By.xpath(xpath), 5);
//		log.info("click");
//		AccTool.click(driver, xpath);
		
		//click database ui baru
		log.info(xpath2);
		WaitTool.waitForElementVisible(driver, By.xpath(xpath2), 5);
		log.info("click");
		AccTool.click(driver, xpath2);
		
		int ctr = 3;
		do {
			try {
				WebDriverTool.switchToWindow(driver, "/accurate/");
				ctr = 0;
			} catch (Throwable t) {
				if (ctr > 0) {
					ctr--;
					log.warn("Fail switching to Accurate tab. Maybe the server is busy, will retry " + ctr + " times: "
							+ t.getMessage());
					WaitTool.delay(2000);
				} else {
					throw t;
				}
			}
		} while (ctr > 0);

		
		// Tunggu loading mask hilang
		AccTool.waitLoadingMask(driver);
		WaitTool.waitForElementVisible(driver, By.xpath("//div[@class='module-section first-setup']"), 1000);
	}

	public static void bukaDBBaru(WebDriver driver, String dbAlias) {
		log.info("BuatDB");

		// pilih Database
//		String xpath = "//div[div[span[text()='" + dbAlias + "']] and contains(@data-bind,'database')][1]";
		//ui baru
//		String xpath = "//div[div[h3[text()='" + dbAlias + "']]]";
		String xpath = "//div[h3[text()='" + dbAlias + "']]";
		log.info(xpath);
		WaitTool.waitForElementVisible(driver, By.xpath(xpath), 5);
		log.info("click");
		AccTool.click(driver, xpath);

		// Tunggu loading mask hilang
		AccTool.waitLoadingMask(driver);

		log.info("Pindah ke window DB ACCURATE...");
		// WebDriverTool.switchToWindow(driver, "/accurate/index.do");
		int ctr = 3;
		do {
			try {
				WebDriverTool.switchToWindow(driver, "/accurate/");
				ctr = 0;
			} catch (Throwable t) {
				if (ctr > 0) {
					ctr--;
					log.warn("Fail switching to Accurate tab. Maybe the server is busy, will retry " + ctr + " times: "
							+ t.getMessage());
					WaitTool.delay(2000);
				} else {
					throw t;
				}
			}
		} while (ctr > 0);

		log.info("Tunggu hingga tampil UI ACCURATE...");
		WaitTool.wait(driver, ExpectedConditions.titleContains(dbAlias));
		
		//ui Baru comment yang tidak dipakai
//		WaitTool.waitForElementVisible(driver, By.xpath("//div[@class='menu-toolbar']"), 1000);
		
		//ui Lama
		WaitTool.waitForElementVisible(driver, By.xpath("//nav[@class='vertical-menu']"), 1000);
		log.info("Berhasil masuk DB");

		Boolean isPresent = driver
				.findElements(By
						.xpath("//div[@class='window shadow']//div[contains(@id, 'accurate__company__introduction')]"))
				.size() > 0;
		if (isPresent) {
			AccTool.waitLoadingMask(driver);
			log.info("muncul introduction");
			driver.findElement(By.xpath("//div[contains(@id,'tab-introduction')]//span[@class='check']")).click();
			log.info("centang introduction");
			driver.findElement(By.xpath("//button[@type='submit' and @name='btnClose']")).click();
			log.info("tutup introduction");
			AccTool.waitLoadingMask(driver);

		}
		Boolean isTabBeritaPresent = driver.findElements(By.xpath(
				"//ul[contains(@class, 'module-switcher tabs')]//a[@href='#module-accurate__company__news-page']"))
				.size() > 0;
		if (isTabBeritaPresent) {
			WaitTool.waitForElementVisible(getWebDriver(), By.xpath(AccurateModule.BERITA.getXpath()), 5);
			NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.BERITA);
			log.info("tutup tab berita");
		}
	}

	public static void tutupIntroductionDB(WebDriver driver, GeneralParam param) {
		AccTool.waitLoadingMask(driver);
		String xpath = "//div[@class='window shadow']//div[contains(@id, 'accurate__company__introduction')]";

		if (WebElementTool.isElementExists(driver, By.xpath(xpath))) {
			log.info("IntroductionDB");
			// String xpath =
			// "//*[div[contains(@id,'accurate__company__introduction')]]";
			WaitTool.waitForElementVisible(driver, By.xpath(xpath), 10);
			AccTool.checkbox(driver, xpath, "@name='noIntroduction'", param.cbtidaktampil);
			// AccTool.clickWindowButton(driver, xpath, param.windowbutton);
			AccTool.click(driver, xpath + "//button[@name='btnClose']");
			AccTool.waitLoadingMask(driver);
		}
	}

	public static void klikIndikator(WebDriver driver, GeneralParam param) {
		log.info("KlikIndikator");

		AccTool.click(driver, "//div[contains(@class,'queue-indicator')]");
		// AccTool.clickButton(driver, "", param.button);

	}

	public static void menuDB(WebDriver driver, GeneralParam param) {
		log.info("MenuDB");

		WebDriverTool.switchToWindow(driver, "/manage");

		String xpath = "//div[div[span[text()='" + param.nama + "']]]";

		WebElementTool.click(driver, By.xpath(xpath + "//*[contains(@class,'dropdown-toggle')]"));

		switch ((param.menu).toLowerCase()) {
		case "non aktif data":
			AccTool.click(driver, xpath + "//i[@class='icon-blocked']");

			NavigationTool.klikKonfirmasiLanjut(driver); // klik Lanjutkan #1
			// Notification
			String content = AccTool.getNotification(driver) + "\r\n";
			log.info(content);
			if (param.filename != null) {
				AccTool.writeTextFile(param.filename, content);
			}
			AccTool.waitLoadingMask(driver);

			break;

		case "duplikasi data":
			AccTool.click(driver, xpath + "//i[@class='icon-copy']");
			NavigationTool.klikKonfirmasiLanjut(driver);
			AccTool.waitLoadingMask(driver);

			log.info("DB " + param.nama + " telah berhasil diduplikasi");

			break;
		}

	}

	public static void menuNucleus(WebDriver driver, GeneralParam param) {
		log.info("MenuNucleus");

		WebDriverTool.switchToWindow(driver, "/manage");

		String xpath = "//*[div[@class='user-id dropdown-toggle']]";

		WebElementTool.click(driver, By.xpath(xpath));

		// dropdown-menu
		String xpath2 = "//*[contains(@class,'dropdown-menu')]//*[contains(text(),'" + param.menu + "')]";
		WaitTool.waitForElementVisible(driver, By.xpath(xpath + xpath2), 5);
		WebElementTool.click(driver, By.xpath(xpath + xpath2));
	}

	public static void renameDB(WebDriver driver, String olddb, String newdb) {
		String xpath = "//div[div[span[text()='" + olddb + "']]]";
		WebElementTool.click(driver, By.xpath(xpath + "//*[contains(@class,'dropdown-toggle')]"));
		AccTool.click(driver, xpath + "//i[@class='icon-pencil']");
		WaitTool.waitForElementVisible(getWebDriver(), By.xpath("//div[@class='input-control text']"), 20);
		log.info("sudah visible");

		AccTool.textField(driver, "//div[@class='input-control text']", "@name='alias'", newdb);

		log.info("Nama " + newdb + " telah diinput");

		NavigationTool.klikSimpanDatabase(driver);
		log.info("Tombol Simpan telah ditekan");

		WaitTool.waitForElementVisible(driver, By.xpath("//div[div[span[text()='" + newdb + "']]][1]"), 1000);
		log.info("DB " + olddb + " telah dirubah menjadi " + newdb);

	}

	public static void menuUser(WebDriver driver, GeneralParam param) {
		log.info("MenuUser");

//		String xpath = "//*[div[@class='user-id dropdown-toggle']]";
//		WebElementTool.click(driver, By.xpath(xpath));
//		AccTool.dropDown(driver, xpath, "", param.menu);
		//ui baru
		
		if (WebElementTool.isElementExists(driver, By.xpath("//*[contains(@id,'dropdown-user')]"))) {
			String xpath4 = "//*[contains(@id,'dropdown-user')]";
        	AccTool.click(driver, xpath4);
        } else {
        	String xpath3 = "//*[contains(@id,'dropdown-user')]//span[2]";
        	AccTool.click(driver, xpath3);
        }
		
		String a = param.menu ;
		
		switch (a) {
		case "Area Penagihan":
			WebElementTool.click(driver, By.xpath("//a[contains(.,'Area Penagihan')]"));
			break;
		case "Area Developer":
			WebElementTool.click(driver, By.xpath("//a[contains(.,'Area Developer')]"));
			break;
		case "Profil Pengguna":
			WebElementTool.click(driver, By.xpath("//a[contains(.,'Profil Pengguna')]"));
			break;
		case "Ganti Password":
			WebElementTool.click(driver, By.xpath("//a[.='Ganti Password']"));
			break;
		case "Data Usaha Nonaktif":
			WebElementTool.click(driver, By.xpath("//a[.='Data Usaha Nonaktif']"));
			break;
		case "Log Out":
			WebElementTool.click(driver, By.xpath("//a[@href='/idp/logout']"));
			break;
		case "Keluar":
			WebElementTool.click(driver, By.xpath("//li[contains(.,'Keluar')]"));
			break;
		}
	}

	public static void refreshDB(WebDriver driver, GeneralParam param) {
		log.info("RefreshDB");

		driver.navigate().refresh();

		log.info("Tunggu hingga tampil UI ACCURATE...");
		WaitTool.waitForElementVisible(driver, By.xpath("//div[@class= 'navigation-bar-content']"), 5);
		log.info("Refresh DB berhasil");
	}

	public static void saveIndikator(WebDriver driver, GeneralParam param) {
		log.info("SaveIndikator");

		String w = "//div[@class='balloon bottom']//div[@class='queue-content']";

		String content = "General.SaveIndikator : " + "\r\n";
		content = content + "Isi Indikator : "
				+ AccTool.getTextValue(driver, AccurateModule.UMUM, ElementType.INDICATOR, "", w) + "\r\n";

		AccTool.writeTextFile(param.filename, content);
	}

	public static void saveWindow(WebDriver driver, GeneralParam param) {
		log.info("SaveWindow");

		String content = "SaveWindow : ";
		switch (param.window.toLowerCase()) {
		case "error":
			WebElement errorwindow = driver.findElement(By.xpath("//div[contains(@id,'error-dialog-')]//li"));
			content = content + param.window + "\r\n" + errorwindow.getText() + "\r\n" + "\r\n";
			log.info(content);
			break;

		case "confirmation":
			WebElement confirmwindow = driver.findElement(By.xpath("//div[contains(@id,'confirm-dialog-')]//li"));
			content = content + param.window + "\r\n" + confirmwindow.getText() + "\r\n" + "\r\n";
			log.info(content);
			break;
		}

		AccTool.writeTextFile(param.filename, content);
	}

	// Dibuat tanggal 2 Mei 2018 untuk kebutuhan cari db

	public static void CariDB(WebDriver driver, String keywords) {
		log.info(" Cari List Data: " + ", Keywords: " + keywords);
		String tab = "//*[@class='metro']";
		AccTool.textField(driver, tab, "@name='name'", keywords);
		// untuk klik enter pada keyboard
		driver.findElement(By.xpath("//body")).sendKeys(Keys.RETURN); // enter

	}

	// Dibuat tanggal 2 Mei 2018 untuk kebutuhan keluar db

	public static void menuKeluarNukleus(WebDriver driver, GeneralParam param) {
		log.info("MenuNucleus");

		WebDriverTool.switchToWindow(driver, "/manage");

		String xpath = "//*[div[@class='user-id dropdown-toggle']]";

		WebElementTool.click(driver, By.xpath(xpath));

		// dropdown-menu
		String xpath2 = "//*[contains(@class,'dropdown-menu')]//*[contains(@class,'icon-switch')]";
		WaitTool.waitForElementVisible(driver, By.xpath(xpath + xpath2), 5);
		WebElementTool.click(driver, By.xpath(xpath + xpath2));

	}
	
	public static void klikDaftarSekarang(WebDriver driver) {
		AccTool.click(driver, "//a[text()='Daftar Sekarang']");
		WaitTool.waitForElementVisible(driver, By.xpath("//h2[text()='Daftar Akun Accurate']"), 5);
	}
	
	public static void isiDaftar(WebDriver driver, GeneralParam param) {
		log.info("daftar.Isi");
		
		if (param.nama != null)
			AccTool.textField(driver, "", "@name='name'", param.nama);
		
		if (param.email != null)
			AccTool.textField(driver, "", "@name='email'", param.email);
		
		if (param.telepon!= null)
			AccTool.numberField(driver, "", "@name='mobile'", param.telepon);
		
		if (param.password!= null)
			AccTool.textField(driver, "", "@name='password'", param.password);	
	}
	
	public static void klikSNK(WebDriver driver) {
		AccTool.click(driver, "//input[@name='checkConfirm']");
	}
	
	public static void pindahHalamanDaftar(WebDriver driver) {
		WebDriverTool.switchToWindow(driver, "account.accurate.test2");
	}
	
	public static void klikDaftar(WebDriver driver) {
		WaitTool.waitForElementVisible(driver, By.xpath("//button[@name='btnRegister']"), 10);
		AccTool.click(driver, "//button[@name='btnRegister']");
	}
	
	public static void saveBerhasilDaftar(WebDriver driver, String filename) {
		log.info("save.BerhasilDaftar");
		
		WaitTool.waitForElementVisible(driver, By.xpath("//h3[text()='Selamat Datang']"), 10);
		String content = AccTool.getTextValue(driver, "//h3[text()='Selamat Datang']")
				+ AccTool.getTextValue(driver, "//h1[@class='fw-bolder mb-1']")
				+ AccTool.getTextValue(driver, "//p[text()='Anda sudah berhasil masuk ke Accurate Online untuk membuat data usaha klik tombol Buat Data Usaha di bawah ini']")
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
}
