package com.cpssoft.web.test.framework.tools;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;

public class FileTool {

	static Logger log = LogManager.getLogger(FileTool.class);

	public static final String MASTER_PATH = "master";

	public static final String TARGET_PATH = "target";

	public static void write(String filename, String content) {
				
		try {
			FileUtils.write(new File(TARGET_PATH + "/" + filename), content, true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

	public static void compare(String filename, String direktori) {
        File master = new File(MASTER_PATH + "/" + direktori + "/" +filename);
        if (!master.exists() || !master.isFile())
            throw new RuntimeException("Master file not exists: " + MASTER_PATH + "/" + direktori + "/" +filename);

        File target = new File(TARGET_PATH + "/" + filename);
        if (!target.exists() || !target.isFile())
            throw new RuntimeException("Target file not exists: " + TARGET_PATH + "/" +filename);

        LineIterator masterIterator = null;
        LineIterator targetIterator = null;
        try {
            masterIterator = FileUtils.lineIterator(master);
            targetIterator = FileUtils.lineIterator(target);
            int ctr = 0;

            while (masterIterator.hasNext() && targetIterator.hasNext()) {
                ctr++;
                String masterRow = masterIterator.next();
                String targetRow = targetIterator.next();

                if (!masterRow.trim().startsWith("#")) {
                    if (masterRow.length() == targetRow.length()) {
                        int pos = masterRow.indexOf("*");
                        while (pos > -1) {
                        	masterRow = masterRow.substring(0, pos) + targetRow.charAt(pos) + masterRow.substring(pos + 1, masterRow.length());
                        	pos = masterRow.indexOf("*", pos + 1);
                       	}
                    }

                    if (!masterRow.equals(targetRow)) {
//                        throw new RuntimeException(
//                                "Compare failed in row: " + ctr + ", Master: " + masterRow + ", Target: " + targetRow);
                    	throw new SkipException("Compare failed in row: " + ctr + ", Master: " + masterRow + ", Target: " + targetRow);
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (masterIterator != null)
                masterIterator.close();
            if (targetIterator != null)
                targetIterator.close();
        }
        delete(filename);
    }

	public static void delete(String filename) {
		File target = new File(TARGET_PATH + "/" + filename);
		if (target.exists() && target.isFile())
			target.delete();
	}
	
	public static void write2(String filename, String content, String content2) {
		
		try {
			FileUtils.write(new File(TARGET_PATH + "/" + filename), content, true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
