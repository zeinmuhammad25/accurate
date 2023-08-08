package com.cpssoft.web.test.framework;

import java.util.ArrayList;
import java.util.List;

public class TestSuiteDefinition {

	private String name;
	private List<TestCaseDefinition> testCaseList = new ArrayList<TestCaseDefinition>();

	public TestSuiteDefinition(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<TestCaseDefinition> getTestCaseList() {
		return testCaseList;
	}

	public void addTestCase(TestCaseDefinition testCase) {
		testCaseList.add(testCase);
	}

}
