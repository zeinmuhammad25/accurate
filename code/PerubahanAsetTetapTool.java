package com.cpssoft.web.test.accurate.tool;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.perubahanasettetap.PerubahanAsetTetapParam;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.test.framework.tools.WebElementTool;

public class PerubahanAsetTetapTool extends AbstractAccurateTestCase{
static Logger log = LogManager.getLogger(PerubahanAsetTetapTool.class);

	public static void kliklanjutbiaya(WebDriver driver){
		AccTool.click(getWebDriver(),"//*[contains(@id,'detail-edited')]//*[text()='Lanjut']");
		WaitTool.waitForElementDisapear(driver, By.xpath("//*[contains(@id,'detail-edited')]//*[text()='Lanjut']"), 3);
	}

	public static void detailPengeluaran(WebDriver driver, PerubahanAsetTetapParam param) {
		log.info("perubahanasettetap.DetailPengeluaran");
		String w = "//div[starts-with(@id,'detail-edited')]";
		// AccTool.click(driver, w);
		String aw = w + "//*[contains(@class,'detail-form')]";
		String tab = w + "//*[contains(@id,'tab-detail')]";
		
		AccTool.click(driver, tab);

		if(param.deskripsi != null)
			AccTool.textField(driver, w, "@name='detailName'", 
		param.deskripsi);
		if(param.jumlah != null)
			AccTool.numberField(driver, w, "@name='amount'", 
		param.jumlah);
		NavigationTool.klikButtonLanjut(getWebDriver(),aw);	
	}
	
	public static void isi(WebDriver driver, PerubahanAsetTetapParam param) {
		log.info("perubahanasettetap.Isi");
		
		String w = AccurateModule.PERUBAHAN_ASET_TETAP.getXpath();	
		
		if(param.jenisperubahan != null)
			AccTool.combobox(driver, w, "@name='editedType'", 
		param.jenisperubahan);	
		
		if(param.aset != null)
			AccTool.lookup(driver, w, "@name='fixedAsset'", 
		param.aset);
		
		if(param.penomoran != null)
			AccTool.textField(driver, w, "@name='number'",
		param.penomoran);	
	
		if(param.tanggal != null)
			AccTool.datePicker(driver, w, "@name='transDate'", 
		param.tanggal);
	}
	
	public static void isiInfoUmum(WebDriver driver, PerubahanAsetTetapParam param) {
		log.info("asettetap.IsiInformasiUmum");

		String w = AccurateModule.PERUBAHAN_ASET_TETAP.getXpath();
		String tab1 = w + "//*[contains(@href,'tab-general')]";
		String tab = w + "//*[contains(@id,'tab-general')]";
		
		AccTool.click(driver, tab1);
		if(param.metodepenyusutan != null)
			AccTool.combobox(driver, tab, "@name='newDepreciationMethod'", 
		param.metodepenyusutan);
	
/*		if(param.jenisperubahan != null)
			AccTool.combobox(driver, tab, "@name='editedType'", 
		param.jenisperubahan);*/
		
		if(param.umurasettahun != null)
			AccTool.numberField(driver, tab, "@name='estimatedLifeYear'", 
		param.umurasettahun);
		
		if(param.umurasetbulan != null)
			AccTool.numberField(driver, tab, "@name='estimatedLifeMonth'", 
		param.umurasetbulan);
		
		if(param.nilaisisa != null)
			AccTool.numberField(driver, tab, "@name='newResidu'", 
		param.nilaisisa);
		
		if(param.keterangan != null)
			AccTool.textarea(driver, tab, "@name='description'", 
		param.keterangan);
		
		AccTool.waitProgressBar(driver);
		AccTool.waitLoadingMask(driver);
		
	}
	
	public static void isiPengeluaran(WebDriver driver, PerubahanAsetTetapParam param) {
		log.info("PerubahanAsettetap.IsiPengeluaran");

		String w = AccurateModule.PERUBAHAN_ASET_TETAP.getXpath();
		String tab = w + "//*[contains(@id,'tab-account')]";		
		
		AccTool.click(driver, "//*[contains(@href,'tab-account')]");
		if(param.search != null)
			AccTool.lookup(driver, tab, "@name='searchDetailAccount'", 
		param.search);
			AccTool.waitLoadingMask(driver);
		if(param.scroll != null)
			AccTool.scrollRowDetail(driver, tab, 
		param.scroll);
			AccTool.waitLoadingMask(driver);
	}
	
	public static void isiInfoLainnya(WebDriver driver, PerubahanAsetTetapParam param){
		log.info("asettetap.isiInfoLainnya");
		
		String w = AccurateModule.PERUBAHAN_ASET_TETAP.getXpath();
		String tab = w + "//*[contains(@id,'tab-other')]";
		
		AccTool.click(driver, "//*[contains(@href,'tab-other')]");
		
		if(param.cbasettidakberwujud != null)
			AccTool.checkbox(driver, tab, "@name='newIntangible'", 
		param.cbasettidakberwujud);
		
		if(param.departemen != null)
			AccTool.lookup(driver, tab, "@name='department'", 
		param.departemen);
	
		if(param.akunaset != null)
			AccTool.lookup(driver, tab, "@name='assetAccount'", 
		param.akunaset);
	
		if(param.akunakumulasipenyusutan != null)
			AccTool.lookup(driver, tab, "@name='acmDepreciationAccount'", 
		param.akunakumulasipenyusutan);
	
		if(param.akunbebanpenyusutan != null)
			AccTool.lookup(driver, tab, "@name='depreciationAccount'", 
		param.akunbebanpenyusutan);
		
		if(param.cbapajak != null)
			AccTool.checkbox(driver, tab, "@name='newFiscalFa'", param.cbapajak);
					
		if(param.fiskalaset != null)
			AccTool.lookup(driver, tab, "@name='fiscalFaType'", param.fiskalaset);
	}
	
	public static void isiRevaluasi(WebDriver driver, PerubahanAsetTetapParam param) {
		log.info("asettetap.IsiRevaluasi");

		String w = AccurateModule.PERUBAHAN_ASET_TETAP.getXpath();
		String tab = w + "//*[contains(@id,'tab-revaluation')]";		
		
		AccTool.click(driver, "//*[contains(@href,'tab-revaluation')]");

		if(param.jumlahrevaluasi != null)
			AccTool.numberField(driver, tab, "@name='revaluationAmount'", 
		param.jumlahrevaluasi);
		
		if(param.akunlabarugi != null)
			AccTool.lookup(driver, tab, "@name='gainLossAccount'", 
		param.akunlabarugi);
	}
	
	public static void saveDetailPengeluaran(WebDriver driver, String filename) {
		log.info("perubahanasettetap.SaveDetail");
//		String w = "//*[@id='module-accurate__fixed-asset__fixed-asset-edited']";
		String content = "PerubahanAsetTetap.SaveDetailPengeluaran : " + "\r\n";
		String tab = "//div[starts-with(@id,'tab-detail')]";
//		AccTool.click(driver, tab);

		content = content
				+ "Deskripsi	: "
				+ AccTool.getTextValue(driver, ElementType.TEXTFIELD,
						"detailName", tab)
				+ "Jumlah	: "
				+ AccTool.getTextValue(driver, ElementType.NUMBERFIELD,
						"amount", tab)
				;
		AccTool.writeTextFile(filename, content);
	}
	
	public static void saveIsiHeader(WebDriver driver, String filename) {
		log.info("perubahanasettetap.SaveHeader");
		String xpath = "//div[contains(@data-bind, 'text: formData.transDate')]";
		boolean exists = false;
		List<WebElement> tglEditDisable = driver.findElements(By.xpath(xpath));
		log.info("Tgl perubahan disable: " + tglEditDisable.size());
		exists = tglEditDisable.size() > 0;
		
		if(exists){
			String content = "PerubahanAsetTetap.SaveHeader : " + "\r\n";
			content = content
					+ "\r\n"
					+ "Jenis Perubahan	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, 
							"//div/div[label[text()='Jenis Perubahan']]/following-sibling::div/div")
					+ "Aset	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
							"fixedAsset")
					+ "Nomor#	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.TEXTFIELD,
							"number")
					+ "Tanggal	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SUMMARY,
							"text: formData.transDate")
					+ "Penyusutan Terakhir	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SPAN,
							"text: formData.lastDepreciationDate")
					+ "Nilai Sisa Buku	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SPAN,
							"text: app.util.parseNumber(formData.lastBookValue())")
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}else{
			String content = "PerubahanAsetTetap.SaveHeader : " + "\r\n";
			content = content
					+ "\r\n"
					+ "Jenis Perubahan	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP,
							"//div/div[label[text()='Jenis Perubahan']]/following-sibling::div/div")
					+ "Aset	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
							"fixedAsset")
					+ "Nomor#	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.TEXTFIELD,
							"number")
					+ "Tanggal	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.DATEPICKER,
							"transDate")
					+ "Penyusutan Terakhir	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SPAN,
							"text: formData.lastDepreciationDate")
					+ "Nilai Sisa Buku	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SPAN,
							"text: app.util.parseNumber(formData.lastBookValue())")
					+ "\r\n";
			AccTool.writeTextFile(filename, content);
		}
	}
	
	public static void saveIsiInfoUmum(WebDriver driver, String filename) {
		log.info("perubahanasettetap.SaveInfoUmum");
				
			String tab = "";
			String xpath = "//div[contains(@data-bind, 'text: formData.depreciationMethodName')]";
			boolean exists = false;
			List<WebElement> metodeDeprDisable = driver.findElements(By.xpath(xpath));
			log.info("Metode Depr disable: " + metodeDeprDisable.size());
			exists = metodeDeprDisable.size() > 0;
			
			if(exists){
				String content = "PerubahanAsetTetap.SaveInfoUmum : " + "\r\n";
				tab = "//*[contains(@id,'tab-general')]";
				AccTool.click(driver, "//a[contains(@href,'tab-general')]");
				content = content
						+ "Metode Penyusutan	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SUMMARY,
								"text: formData.depreciationMethodName", tab)
						+ "Umur Aset Tahun	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SUMMARY,
								"text: app.util.parseNumber(formData.estimatedLifeYear())", tab)
						+ "Umur Aset Bulan	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SUMMARY,
								"text: app.util.parseNumber(formData.estimatedLifeMonth())", tab)
						+ "Nilai Sisa	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SPAN,
								"text: app.util.parseNumber(formData.newResidu())", tab)
						+ "Keterangan Perubahan	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.TEXTAREA,
								"description", tab)
						+ "\r\n";
				AccTool.writeTextFile(filename, content);

			}else{
				String content = "PerubahanAsetTetap.SaveInfoUmum : " + "\r\n";
				tab = "//*[contains(@id,'tab-general')]";
				AccTool.click(driver, "//a[contains(@href,'tab-general')]");
				content = content
						/*+ "Jenis Perubahan	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.COMBOBOX,
								"editedType", tab)*/
						+ "Metode Penyusutan	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.COMBOBOX,
								"newDepreciationMethod", tab)
						+ "Umur Aset Tahun	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.NUMBERFIELD,
								"estimatedLifeYear", tab)
						+ "Umur Aset Bulan	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.NUMBERFIELD,
								"estimatedLifeMonth", tab)
						+ "Nilai Sisa	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.NUMBERFIELD,
								"newResidu", tab)
						+ "Keterangan Perubahan	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.TEXTAREA,
								"description", tab)
						+ "\r\n";
				AccTool.writeTextFile(filename, content);
			}
		}
	
	public static void saveIsiRevaluasi(WebDriver driver, String filename) {
		log.info("perubahanasettetap.SaveRevaluasi");
	
			String tab = "";
			String xpath = "//span[contains(@data-bind, 'text: app.util.parseNumber(formData.revaluationAmount())')]";
			boolean exists = false;
			List<WebElement> jmlRevDisable = driver.findElements(By.xpath(xpath));
			log.info("Jml Rev disable: " + jmlRevDisable.size());
			exists = jmlRevDisable.size() > 0;
			
			if(exists){
				String content = "PerubahanAsetTetap.SaveRevaluasi : " + "\r\n";
				tab = "//*[contains(@id,'tab-revaluation')]";
				AccTool.click(driver, "//a[contains(@href,'tab-revaluation')]");
				content = content
						+ "Jumlah Revaluasi	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.SUMMARY,
								"text: app.util.parseNumber(formData.revaluationAmount())", tab)
						+ "Akun Laba Rugi	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
								"gainLossAccount", tab)
						+ "\r\n";
				AccTool.writeTextFile(filename, content);
			}else{
				String content = "PerubahanAsetTetap.SaveRevaluasi : " + "\r\n";
				tab = "//*[contains(@id,'tab-revaluation')]";
				AccTool.click(driver, "//a[contains(@href,'tab-revaluation')]");
				content = content
						+ "Jumlah Revaluasi	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.NUMBERFIELD,
								"revaluationAmount", tab)
						+ "Akun Laba Rugi	: "
						+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
								"gainLossAccount", tab)
						+ "\r\n";
				AccTool.writeTextFile(filename, content);
			}
	}
	
//	public static void saveIsiPengeluaran(WebDriver driver, String filename) {
//		log.info("perubahanasettetap.SavePengeluaran");
//				
//			String w = AccurateModule.PERUBAHAN_ASET_TETAP.getXpath();
//			String tab = "";
//			String content = "perubahanasettetap.SavePengeluaran : " + "\r\n";
//			
//			tab = "//*[contains(@id,'tab-account')]";
//			AccTool.click(driver, "//a[contains(@href,'tab-account')]");
//			content = content + "Detail Pengeluaran" + "\r\n"
//					+"Akun Pengeluaran:"
//					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
//							"searchDetailAccount", tab)
//					+ AccTool.getGridValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, tab) + "\r\n";
//
//		AccTool.writeTextFile(filename, content);
//	}

	public static void saveIsiInfoLainnya(WebDriver driver,String filename){
		log.info("perubahanasettetap.SaveInfoLainnya");
		String tab = "";

		String content = "PerubahanAsetTetap.SaveInfoLainnya :" + "\r\n";
		tab = "//*[contains(@id,'tab-other')]";
		AccTool.click(driver, "//a[contains(@href,'tab-other')]");
		String asetberwujud = "//div/div[label[text()='Aset Tidak Berwujud']]/following-sibling::div/div";
		String cbasetberwujud = asetberwujud + "/label/input[@name='newIntangible']";
		
		if (WebElementTool.isElementExists(driver, By.xpath(cbasetberwujud))) {
			content = content + "Aset Tidak Berwujud	: " + AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.CHECKBOX,
					"newIntangible", tab);
		}else {
			content = content + "Aset Tidak Berwujud	: "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, 
							"//div/div[label[text()='Aset Tidak Berwujud']]/following-sibling::div/div");
		}
		content = content
		+ "Departemen	: "
		+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
				"department", tab)
		+ "Akun Aset	: "
		+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
				"assetAccount", tab)
		+ "Akun Akumulasi Penyusutan	: "
		+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
				"acmDepreciationAccount", tab)
		+ "Akun Beban Penyusutan	: "
		+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
				"depreciationAccount", tab);
		String cbPajak = "//div/div[label[text()='Pajak']]/following-sibling::div/div/label/input[@name='newFiscalFa']";
		if (WebElementTool.isElementExists(driver, By.xpath(cbPajak))) {
			content = content + "Pajak : "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.CHECKBOX,
							"newFiscalFa", tab);
		} else {
			content = content + "Pajak : "
					+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, 
							"//div/div[label[text()='Pajak']]/following-sibling::div/div");
		}
		content = content
				+ "Kategori Pajak	: "
				+ AccTool.getTextValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP, ElementType.LOOKUP,
						"fiscalFaType", tab)
				+ "\r\n";
		AccTool.writeTextFile(filename, content);
	
	}
	public static void saveListPengeluaran(WebDriver driver,String filename){
		log.info("Pengeluaran.SaveList");
		String content = "PerubahanAsetTetap.SaveListPengeluaran :" + "\r\n";
		String tab  = "//*[contains(@id,'tab-account')]";
		AccTool.click(driver, "//a[contains(@href,'tab-account')]");
		content = content 
				+ AccTool.getGridValue(driver, AccurateModule.PERUBAHAN_ASET_TETAP,
						tab) + "\r\n";
		AccTool.writeTextFile(filename, content);
	}
}
