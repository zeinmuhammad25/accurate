package com.cpssoft.web.test.accurate.praotomasi;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.TransferBankTool;
import com.cpssoft.web.test.accurate.transferbank.TransferBankParam;
import com.cpssoft.web.test.framework.tools.WaitTool;

public class PraOtomKasBankTransferBank extends AbstractAccurateTestCase{
	static Logger Log = LogManager.getLogger(PraOtomKasBankTransferBank.class);
	
	private String TARGET_FILE = "PraOtomasi Kas Bank - Transfer Bank.txt";

	@Test()
	public void buatTransferBank()
	{
		//hapus target lama
		Log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);
		
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.TRANSFER_BANK);
		
		TransferBankParam param = new TransferBankParam();
		NavigationTool.klikButtonPensil(getWebDriver(), AccurateModule.TRANSFER_BANK);
		
		param.tanggal = "30012015";
		param.no = "BT.01";
		TransferBankTool.isiForm(getWebDriver(), param);
		TransferBankTool.saveHeader(getWebDriver(), TARGET_FILE);
		
		param.dari = "Bank";
		param.ke = "Kas Kecil";
		param.nilaidari = "1000";
		TransferBankTool.isiTransferUang(getWebDriver(), param);
		//TransferBankTool.saveDetailTransferBank(getWebDriver(), TARGET_FILE);
		
		param.tab = "Info Lainnya";
		param.catatan = "One Little Panda";
		TransferBankTool.IsiInfoLain(getWebDriver(), param);
		//TransferBankTool.saveInfoLain(getWebDriver(), TARGET_FILE);
		
			
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.TRANSFER_BANK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.TRANSFER_BANK);
	}

	@Test(dependsOnMethods = { "buatTransferBank" })
	public void saveTransferBank()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.TRANSFER_BANK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.TRANSFER_BANK, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.TRANSFER_BANK, "BT.01");
		TransferBankTool.saveDetailTransferBank(getWebDriver(), TARGET_FILE);
		TransferBankTool.klikTabInfoLain(getWebDriver());
		TransferBankTool.saveInfoLain(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.TRANSFER_BANK);
	}
	
	@Test(dependsOnMethods = { "saveTransferBank" })
	public void editTransferBank()
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.TRANSFER_BANK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.TRANSFER_BANK, "Data Baru");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.TRANSFER_BANK, "BT.01");
		TransferBankParam param = new TransferBankParam();
		
		param.tanggal = "05022015";
		param.no = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters";
		TransferBankTool.isiForm(getWebDriver(), param);
		TransferBankTool.saveHeader(getWebDriver(), TARGET_FILE);
		
		param.dari = "Bank";
		param.ke = "Kas Kecil";
		param.nilaidari= "9999999999999999999999";
		param.cabangdari = "Cabang1";
		param.cabangke = "Kantor Pusat";
		TransferBankTool.isiTransferUang(getWebDriver(), param);
		TransferBankTool.saveDetailTransferBank(getWebDriver(), TARGET_FILE);
		
		param.tab = "biaya transfer";
		param.search = "Persediaan Terkirim";
		TransferBankTool.isiBiayaTransfer(getWebDriver(), param);
		param.tab = "biaya transfer";
		param.nilai = "9999999999999999999999";
		TransferBankTool.detailBiayaTransfer(getWebDriver(), param);
				
		param.tab = "Catatan";
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid turns 15,"
				+ " she is permitted to swim to the surface to watch the world above, and when the sisters become old enough, "
				+ "each of them visits the upper world every year. As each of them returns, the Little Mermaid listens "
				+ "longingly to their various descriptions of the surface and of human beings.";
		TransferBankTool.detailBiayaTransfer(getWebDriver(), param);
		TransferBankTool.saveDetailBiayaTransfer(getWebDriver(), TARGET_FILE);
		TransferBankTool.klikBtnLanjutTranferBankBiayaTranfer(getWebDriver());
		
//		TransferBankTool.klikTabInfoLainnya(getWebDriver());
		param.tab = "Info Lainnya";
		param.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid"
				+ " turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters "
				+ "become old enough, each of them visits the upper world every year. As each of them returns, the Little"
				+ " Mermaid listens longingly to their various descriptions of the surface and of human beings.";
//		param.cabang = "Cabang1";
		TransferBankTool.IsiInfoLain(getWebDriver(), param);
		TransferBankTool.saveInfoLain(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.TRANSFER_BANK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.TRANSFER_BANK);
	}
	
	@Test(dependsOnMethods = { "editTransferBank" })
	public void hapusTransferBank() throws AWTException
	{
		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.TRANSFER_BANK);
		NavigationTool.klikTutupTabData(getWebDriver(), AccurateModule.TRANSFER_BANK, "Data Baru");
		
		//cetak list
		NavigationTool.klikCetakList(getWebDriver(), AccurateModule.TRANSFER_BANK);
		NavigationTool.cekPrintPreviewList(getWebDriver(), TARGET_FILE);
		NavigationTool.cariList(getWebDriver(), AccurateModule.TRANSFER_BANK, "The Little Mermaid dwells in an underwater kingdom");
		NavigationTool.cariListData(getWebDriver(), AccurateModule.TRANSFER_BANK, "The Little Mermaid dwells in an underwater kingdom");
		//cetak form
		NavigationTool.klikCetakForm(getWebDriver(), AccurateModule.TRANSFER_BANK);
		NavigationTool.cekPrintPreviewForm(getWebDriver(), TARGET_FILE);
		//cek email
		//NavigationTool.klikEmailForm(getWebDriver(), AccurateModule.TRANSFER_BANK);
		//NavigationTool.cekKirimEmailForm(getWebDriver(), TARGET_FILE);
		//cek dokumen
		NavigationTool.klikDokumen(getWebDriver(), AccurateModule.TRANSFER_BANK);
		NavigationTool.cekUploadDokumen(getWebDriver(), getDirectory(), "document.xls", TARGET_FILE);
		//cek komentar
		NavigationTool.klikKomentar(getWebDriver(), AccurateModule.TRANSFER_BANK);
		NavigationTool.cekKomentarForm(getWebDriver(), TARGET_FILE);
		
		WaitTool.delay(1000);
		NavigationTool.klikHapusData(getWebDriver(), AccurateModule.TRANSFER_BANK);
		NavigationTool.klikKonfirmasiYa(getWebDriver());
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.TRANSFER_BANK);
	}

	@Test(dependsOnMethods = { "hapusTransferBank" })
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
