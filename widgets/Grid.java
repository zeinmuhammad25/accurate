package com.cpssoft.web.test.accurate.widgets;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.cpssoft.web.test.accurate.tool.AccTool;
import com.cpssoft.web.test.framework.tools.WaitTool;
import com.cpssoft.web.util.CompareUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Grid {
	private static final Logger log = LogManager.getLogger(Grid.class);
	protected WebDriver driver;
	protected String gridXpath;

	protected String gridJS = "var grid = $(document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).data('sgrid'); console.debug('Grid Object: ' + grid);";

	public Grid(WebDriver driver, String gridXpath) {
		this.driver = driver;
		this.gridXpath = gridXpath;

		log.debug("Grid Xpath: " + gridXpath);

		WaitTool.waitForElementClickable(driver, By.xpath(this.gridXpath + "//div[@class='grid-canvas']"), 20);
//		WaitTool.waitForElementPresent(driver, By.xpath(this.gridXpath + "//div[@class='grid-canvas']"), 20);
	}

	public int searchKeyword(String keyword) {
		waitLoading();
		int length = getDataLength();

		JSONArray columns = getColumnDefinition();
		for (int i = 0; i < length; i++) {
			JSONObject data = getData(i);
			for (int j = 0; j < columns.size(); j++) {
				JSONObject col = columns.getJSONObject(j);

				if (col.containsKey("field")) {
					String field = col.getString("field");
					String value = null;

					if (field.contains(".")) {
						String[] temp = field.split("\\.");
						if (data.containsKey(temp[0])) {
							JSONObject subData = data.getJSONObject(temp[0]);
							if (!subData.isNullObject()) {
								if (subData.containsKey(temp[1])) {
									value = subData.getString(temp[1]);
								}
							}
						}
					} else if (data.containsKey(col.getString("field"))) {
						value = data.getString(col.getString("field"));
					}

					if (value != null) {
						value = value.replaceAll("&nbsp;", "").trim();

						if (CompareUtil.equals(value, keyword)) {
							log.info("Keyword '" + keyword + "' found in grid row: " + i);
							return i;
						}
					}
				}
			}
		}

		throw new RuntimeException("Grid cannot find the keyword: " + keyword);
	}

	public void scrollTop(int row) {
		String javascript = gridJS + "grid.scrollRowToTop(arguments[1]); var data = grid.getDataItem(arguments[1]); return (typeof data != 'undefined' ? true :  false);";
		Boolean dataLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript(javascript, gridXpath, row);
		if (!dataLoaded)
			waitLoading();
	}

	public void scrollRow(int row) {
		String javascript = gridJS + "grid.scrollRowIntoView(arguments[1]); var data = grid.getDataItem(arguments[1]); return (typeof data != 'undefined' ? true :  false);";
		Boolean dataLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript(javascript, gridXpath, row);
		if (!dataLoaded)
			waitLoading();
	}

	public void scrollCell(int row, int col) {
		String javascript = gridJS + "grid.scrollCellIntoView(arguments[1], arguments[2]); var data = grid.getDataItem(arguments[1]); return (typeof data != 'undefined' ? true :  false);";
		Boolean dataLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript(javascript, gridXpath, row, col);
		if (!dataLoaded)
			waitLoading();
	}

	public void selectRow(int row) {
		selectCell(row, 0);
	}

	public void selectCell(int row, int col) {
		String javascript = gridJS + "grid.gotoCell(arguments[1], arguments[2]); var data = grid.getDataItem(arguments[1]); return (typeof data != 'undefined' ? true :  false);";
		Boolean dataLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript(javascript, gridXpath, row, col);
		if (!dataLoaded)
			waitLoading();
	}

	public int getDataLength() {
		String javascript = gridJS + "return grid.getData().length;";
		Object result = ((JavascriptExecutor) driver).executeScript(javascript, gridXpath);

		// jika gak ketemu
		if (result == null) {
			waitLoading();
			result = ((JavascriptExecutor) driver).executeScript(javascript, gridXpath);
		}
		if (result == null) {
			log.warn("masuk percobaan null ke 2 tunggu 5 detik");
			WaitTool.delay(5000);
			result = ((JavascriptExecutor) driver).executeScript(javascript, gridXpath);
		}

		return (int) Long.valueOf((long) result).intValue();
	}

	public JSONArray getData() {
		String javascript = gridJS
				+ "var data = grid.getData(); if($.isArray(data)) { return ko.toJSON(data); } else { var result = []; $.each(data, function(key, value) { if(key != 'length') { result[parseInt(key)] = value; } }); return ko.toJSON(result); };";
		Object result = ((JavascriptExecutor) driver).executeScript(javascript, gridXpath);

		if (result == null)
			throw new RuntimeException("Grid does not return list of data");

		JSONArray dataList = JSONArray.fromObject(result);
		JSONArray resultList = JSONArray.fromObject("[]");

		if (dataList.size() > 0) {
			JSONArray colDef = getColumnDefinition();

			for (int i = 0; i < dataList.size(); i++) {
				JSONObject oriData = dataList.getJSONObject(i);
				JSONObject data = JSONObject.fromObject("{}");
				for (int j = 0; j < colDef.size(); j++) {
					JSONObject col = colDef.getJSONObject(j);
					if (col.containsKey("field")) {
						String field = col.getString("field");

						if (field.contains(".")) {
							String[] temp = field.split("\\.");
							if (oriData.containsKey(temp[0])) {
								JSONObject oriSubData = oriData.getJSONObject(temp[0]);
								if (!oriSubData.isNullObject()) {
									if (oriSubData.containsKey(temp[1])) {
										data.put(field, oriSubData.get(temp[1]));
									}
								} else {
									data.put(field, oriSubData);
								}
							}
						} else if (oriData.containsKey(field)) {
							data.put(field, oriData.get(field));
						}
					}
				}

				resultList.add(data);
			}
		}

		return resultList;
	}

	public JSONArray getColumnDefinition() {
		String javascript = gridJS + "return ko.toJSON(grid.getColumns());";
		Object result = ((JavascriptExecutor) driver).executeScript(javascript, gridXpath);

		return JSONArray.fromObject(result);
	}

	public JSONObject getData(int row) {
		// int length = getDataLength();
		// if (row >= length)
		// throw new RuntimeException("Row " + row + " is not exists in the
		// grid");

		String getDataScript = "var data = grid.getDataItem(arguments[1]); return (typeof data != 'undefined' ? ko.toJSON(data) :  null);";

		// Scroll the grid
		String javascript = gridJS + "grid.scrollRowToTop(arguments[1]);" + getDataScript;
		Object result = ((JavascriptExecutor) driver).executeScript(javascript, gridXpath, row);

		// Wait for grid loading
		if (result == null) {
			waitLoading();

			// Get grid data
			javascript = gridJS + getDataScript;
			result = ((JavascriptExecutor) driver).executeScript(javascript, gridXpath, row);
			if (result == null)
				throw new RuntimeException("No grid data found in row: " + row);
		}

		//log.debug("Data " + row + ": " + result);

		JSONObject resultMap = JSONObject.fromObject(result);
		return resultMap;
	}

	public void waitLoading() {
		AccTool.waitGridMask(driver, true);
	}
}
