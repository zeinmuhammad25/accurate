package com.cpssoft.web.test.accurate.praotomasi;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cpssoft.web.test.accurate.AbstractAccurateTestCase;
import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.accurate.tool.AccurateModule;
import com.cpssoft.web.test.accurate.tool.NavigationTool;
import com.cpssoft.web.test.accurate.tool.KontakTool;
import com.cpssoft.web.test.accurate.tool.GeneralTool;
import com.cpssoft.web.test.accurate.kontak.KontakParam;

public class PraOtomPerusahaanKontak extends AbstractAccurateTestCase {
	static Logger log = LogManager.getLogger(PraOtomPerusahaanKontak.class);

	private String TARGET_FILE = "PraOtomasi Perusahaan - Kontak.txt";

	@Test
	public void tambahKontak() {
		// Hapus target lama
		log.info("Hapus target lama");
		AccTool.deleteTextFile(TARGET_FILE);

		NavigationTool.klikMenuModul(getWebDriver(), AccurateModule.KONTAK);
		NavigationTool.cariListData(getWebDriver(), AccurateModule.KONTAK, "ABC");

		KontakParam kontak = new KontakParam();
		
		kontak.sapaan = "Bapak";
//		kontak.nama = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
//				+ "her grandmother, and her five sisters. ";
		kontak.jabatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.email = "TheLittleMermaidn@gmail.com";
		kontak.handphone = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.teleponbisnis = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. ";
		kontak.faximili = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. ";
		kontak.teleponrumah = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king),"
				+ " her grandmother, and her five sisters. ";
		kontak.pinbbm = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		kontak.website = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. ";
		KontakTool.isi(getWebDriver(), kontak);
		KontakTool.saveIsiKontak(getWebDriver(), TARGET_FILE);
		
		KontakTool.klikLainnya(getWebDriver());
		KontakParam lainnya = new KontakParam();
		lainnya.catatan = "The Little Mermaid dwells in an underwater kingdom with her father (the sea king or mer-king), "
				+ "her grandmother, and her five sisters. Her five sisters are each born one year apart. When a mermaid "
				+ "turns 15, she is permitted to swim to the surface to watch the world above, and when the sisters become"
				+ " old enough, each of them visits the upper world every year. As each of them returns, the Little Mermaid"
				+ " listens longingly to their various descriptions of the surface and of human beings.";
		KontakTool.isiLainnya(getWebDriver(), lainnya);
		KontakTool.saveIsiLainnya(getWebDriver(), TARGET_FILE);
		
		NavigationTool.klikSimpanData(getWebDriver(), AccurateModule.KONTAK);
		GeneralTool.simpanNotifikasi(getWebDriver(), TARGET_FILE);
		NavigationTool.klikTutupModule(getWebDriver(), AccurateModule.KONTAK);		
	}
		
	@Test(dependsOnMethods = "tambahKontak")
	public void executeFinal() {
		AccTool.compareTextFile(TARGET_FILE, getDirectory());
	}
}
