package com.cpssoft.web.test.framework;

import java.util.HashMap;
import java.util.Map;

public enum TestArgs {
	NAME("-name"), FILE("-file"), DRIVER("-driver"), SELENIUM_HUB_URL("-seleniumhub"), BROWSER(
			"-browser"), BROWSER_VERSION("-browserversion"), PLATFORM("-platform"), PHANTOMJS_BIN(
			"-phantomjsbin"), CHROME_BIN("-chromebin"), RESOLUTION("-resolution"), IMPLICIT_WAIT(
			"-implicitwait"), TEST_CASE_PACKAGE("-tcpackage"), TEST_CASE("-tc"), URL("-url"), DATA(
			"-data");

	private final String id;

	private static final Map<String, TestArgs> lookup = new HashMap<String, TestArgs>();
	static {
		for (TestArgs d : TestArgs.values())
			lookup.put(d.getId(), d);
	}

	TestArgs(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static TestArgs get(String id) {
		return lookup.get(id);
	}
}
