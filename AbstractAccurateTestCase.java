package com.cpssoft.web.test.accurate;

import com.cpssoft.web.test.framework.AbstractSeleniumTestCase;

public abstract class AbstractAccurateTestCase extends AbstractSeleniumTestCase {
	
	public String getDirectory() {
		String packageName = getClass().getPackage().getName();
		String directory = packageName.substring(packageName.lastIndexOf('.') + 1);
		
		return directory;
	}

}
