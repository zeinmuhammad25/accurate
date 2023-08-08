package com.cpssoft.web.test.accurate.tool;

import java.util.NoSuchElementException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.accuratepos.PengaturanPOSParam;
import com.cpssoft.web.test.accurate.cabang.CabangParam;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.accurate.penomoran.PenomoranParam;
import com.cpssoft.web.test.accurate.fakturpenjualan.FakturPenjualanParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PeranKaryawanPOSTool extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PeranKaryawanPOSTool.class);
	
	public static void saveCheckBoxBiaya(WebDriver driver, String filename) {
		log.info("PeranKaryawanPOS.saveCheckBoxBiaya");

		String content = "";
		String xpath = "//input[@name='allowExpense']";
		WaitTool.waitForElementPresent(driver, By.xpath(xpath), 10);
		
		WebElement radioButton = driver.findElement(By.xpath(xpath));
        boolean isSelected = radioButton.isSelected();

        if (isSelected) {
            content = "PeranKaryawanPOS.saveCheckBoxBiaya : " + "\r\n" + "True";
        } else {
            content = "PeranKaryawanPOS.saveCheckBoxBiaya : " + "\r\n" + "false";
        }
		content = content + "\r\n"
				
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	}
	
}
	

