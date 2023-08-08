package com.cpssoft.web.test.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCaseDefinition {
	private String name;
	private String className;
	private List<String> includedGroupList = new ArrayList<String>();
	private List<String> excludedGroupList = new ArrayList<String>();
	private Map<String, String> parameters = new HashMap<String, String>();

	public TestCaseDefinition(String name, String className) {
		this.name = name;
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}

	public List<String> getIncludedGroupList() {
		return includedGroupList;
	}

	public List<String> getExcludedGroupList() {
		return excludedGroupList;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void addIncludedGroup(String group) {
		includedGroupList.add(group);
	}

	public void addExcludedGroup(String group) {
		excludedGroupList.add(group);
	}

	public void addParameter(String key, String value) {
		parameters.put(key, value);
	}

}
