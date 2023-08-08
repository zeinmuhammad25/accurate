package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.disposisiasettetap.DisposisiAsetTetapParam;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class DisposisiAsetTetapTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(DisposisiAsetTetapTool.class);
	
	public static void isi(WebDriver driver, DisposisiAsetTetapParam param) {
		log.info("DisposisiAsetTetap.Isi");
		
		String w = AccurateModule.DISPOSISI_ASET_TETAP.getXpath();
		
		if(param.penomoran != null)
			AccTool.textField(driver, w, "@name='number'", 
		param.penomoran);		
		
		if(param.aset != null)
			AccTool.lookup(driver, w, "@name='fixedAsset'", 
		param.aset);
		
		if(param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", 
		param.tanggal);
	}
	
	public static void isiInfoUmum(WebDriver driver, DisposisiAsetTetapParam param) {
		log.info("DisposisiAsetTetap.IsiInformasiUmum");

		String w = AccurateModule.DISPOSISI_ASET_TETAP.getXpath();
		String tab = w + "//*[contains(@id,'tab-general')]";
		
		if(param.kuantitas != null)
			AccTool.numberField(driver, tab, "@name='quantity'", 
		param.kuantitas);
		
		if(param.lokasiaset != null)
			AccTool.lookup(driver, tab, "@name='location'", 
		param.lokasiaset);
		
		if(param.akunlabarugi != null)
			AccTool.lookup(driver, tab, "@name='gainLossAccount'", 
		param.akunlabarugi);
		
		if(param.catatan != null)
			AccTool.textarea(getWebDriver(), tab, "@name='description'",
		param.catatan);
		
		if(param.cbasetdijual != null)
			AccTool.checkbox(getWebDriver(), tab, "@name='sellingAsset'", 
				param.cbasetdijual);
					
		if(param.harga != null)
				AccTool.numberField(driver, tab, "@name='sellingPrice'", 
			param.harga);
					
		if(param.akun != null)
				AccTool.lookup(driver, tab, "@name='sellingAccount'", 
			param.akun);
	}
	
	public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("disposisiasettetap.SaveIsi");
		String xpath = "//span[contains(@data-bind, 'text: app.util.parseNumber(formData.lastQuantity())')]";
		boolean exists = false;
		List<WebElement> NSBuntuk = driver.findElements(By.xpath(xpath));
		log.info("Nilai sisa buku untuk: " + NSBuntuk.size());
		exists = NSBuntuk.size() > 0;
	
		if(exists){
			String content = "DisposisiAsetTetap.SaveHeader : " + "\r\n";
			content = content
					+ "Aset	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.LOOKUP,
							"fixedAsset")
					+ "Nomor#	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.TEXTFIELD,
							"number")
					+ "Tanggal	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.DATEPICKER,
							"transDate")
					+ "Penyusutan Terakhir	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.SPAN,
							"text: formData.lastDepreciationDate")
					+ "Nilai Sisa Buku	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.SPAN,
							"text: app.util.parseNumber(formData.lastBookValue())")+ "Untuk "+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.SPAN,
							"text: app.util.parseNumber(formData.lastQuantity())")
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}else{
			String content = "DisposisiAsetTetap.SaveHeader : " + "\r\n";
			content = content
					+ "Aset	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.LOOKUP,
							"fixedAsset")
					+ "Nomor#	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.TEXTFIELD,
							"number")
					+ "Tanggal	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.DATEPICKER,
							"transDate")
					+ "Penyusutan Terakhir	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.SPAN,
							"text: formData.lastDepreciationDate")
					+ "Nilai Sisa Buku	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.SPAN,
							"text: app.util.parseNumber(formData.lastBookValue())")
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}
	}
		
	
	public static void saveIsiInfoUmum(WebDriver driver, String filename) {
		log.info("DisposisiAsetTetap.SaveInfoUmum");

		String content = "DisposisiAsetTetap.SaveInfoUmum : " + "\r\n";
		String tab = "//*[contains(@id,'tab-general')]";
			content = content
					+ "Kuantitas	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.NUMBERFIELD,
							"quantity")
					+ "Akun Laba Rugi	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.LOOKUP,
							"gainLossAccount")
					+ "Lokasi Aset	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.LOOKUP,
							"location")
					+ "Catatan	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.TEXTAREA,
							"description")	
					+ "Aset Dijual	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.CHECKBOX,
							"sellingAsset")
					+ "Harga	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.NUMBERFIELD,
							"sellingPrice")
					+ "Akun	: "
					+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.LOOKUP,
							"sellingAccount");
					String inforekonsil = "//*[contains(@data-bind, 'text : formData.reconcileDate')]";
					if (WebElementTool.isElementExists(driver, By.xpath(inforekonsil))) {
						content = content
								+ AccTool.getTextValue(driver, "//label[.='Terekonsiliasi']")
								+ AccTool.getTextValue(driver, "//*[contains(@data-bind, 'text : formData.reconcileDate')]/preceding-sibling::span").replace( "\r\n", "")
								+ AccTool.getTextValue(driver, AccurateModule.DISPOSISI_ASET_TETAP, ElementType.SPAN, "text : formData.reconcileDate", tab);
					}

			content = content + "\r\n";
			AccTool.writeTextFile(filename, content);
	}
}
