package com.cpssoft.web.test.accurate.tool;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebDriverTool;
import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.akunperkiraan.AkunPerkiraanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class ModoboaTool {
	private static final Logger log = Logger.getLogger(ModoboaTool.class);

	public static void loginUser(WebDriver driver, String email, String password) throws AWTException {
		AccTool.waitLoadingMask(driver);
		// Isi form login
		AccTool.textField(driver, "", "@name='username'", email);
		AccTool.textField(driver, "", "@name='password'", password);
		
		WaitTool.waitForElementPresent(driver, By.xpath("//button[text()='Log in']"), 20);
		AccTool.click(driver, "//button[text()='Log in']");
		
		WaitTool.delay(2000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		
		// Cek apakah login berhasil ui baru
		log.info("Tunggu hingga tampil halaman web mail...");
		WaitTool.waitForElementPresent(driver, By.xpath("//a[@name='webmail']"), 20);
		WaitTool.delay(2000);
		log.info("Berhasil login");

	}
	
	public static void klikWebmail(WebDriver driver) {
		AccTool.click(driver, "//a[@name='webmail']");
		WaitTool.waitForElementVisible(driver,
				By.xpath("//ul[@class='nav nav-sidebar']"), 10);
	}
	
	public static void klikInbox(WebDriver driver) {
		AccTool.click(driver, "//a[@href='INBOX']");
		WaitTool.waitForElementVisible(driver,
				By.xpath("//div[@id='emails']/div[1]"), 10);
	}
	
	public static void klikEmailInboxTeratas(WebDriver driver) {
		AccTool.click(driver, "//div[@id='emails']/div[1]");
		WaitTool.delay(2000);	
	}
	
	public static void ubahKeAktifasiLink(WebDriver driver) {
		AccTool.click(driver, "//button[@title='Display options']");
		WaitTool.waitForElementVisible(driver,
				By.xpath("//a[@name='activate_links']"), 10);
		AccTool.click(driver, "//a[@name='activate_links']");
		WaitTool.delay(1000);	
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'/webmail/getmailcontent')]")));
		AccTool.click(driver, "//a[.='Link Verifikasi']");
		
		WaitTool.delay(3000);
	}
	
	public static void pindahWindowAccurate(WebDriver driver) {
		int ctr = 3;
		do {
			try {
				WebDriverTool.switchToWindow(driver, "/account.accurate.test1/");
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
	}
	
	public static void resetPassword(WebDriver driver, String passwordBaru, String verifyPassword)  {
		AccTool.waitLoadingMask(driver);
		// Isi form lupa password
		AccTool.textField(driver, "", "@id='newPassword'", passwordBaru);
		AccTool.textField(driver, "", "@id='verifyNewPassword'", verifyPassword);
		
		WaitTool.waitForElementPresent(driver, By.xpath("//button[@name='btnResetPassword']"), 20);
		AccTool.click(driver, "//button[@name='btnResetPassword']");
		
		WaitTool.waitForElementPresent(driver, By.xpath("//button[text()='OK']"), 20);
		AccTool.click(driver, "//button[text()='OK']");
		
		log.info("halaman pindah ke halaman login accurate");
		WaitTool.waitForElementPresent(driver, By.xpath("//form[@id='login-form']"), 20);
		log.info("Reset Password berhasil");

	}
}
