package com.cpssoft.web.test.framework;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.cpssoft.web.util.ReflectionUtil;

import io.appium.java_client.android.AndroidDriver;

public class BaseTestCase<T> {
	private static final Logger log = LogManager.getLogger(BaseTestCase.class);

	protected static final String DEFAULT_PROVIDER = "defaultProvider";

	@DataProvider
	@SuppressWarnings("unchecked")
	protected Object[][] defaultProvider(ITestContext context) {
		Class<T> clazz = (Class<T>) ReflectionUtil.getGenericClass(getClass(), 0);
		return handleParameters(context, clazz);
	}

	protected Object[][] handleParameters(ITestContext context,
			@SuppressWarnings("rawtypes") Class paramClass) {
		List<Object> objectParam = new ArrayList<Object>();

		// Auto add web driver as first parameter;
		objectParam.add(getWebDriver(context));
		// Auto add android driver as first parameter;
		objectParam.add(getAndroidDriver(context));

		if (paramClass != null) {
			Object paramObj;
			try {
				paramObj = paramClass.newInstance();

				// Handling param input
				Map<String, String> configParams = context.getCurrentXmlTest().getAllParameters();
				if (configParams != null) {
					for (Entry<String, String> entry : configParams.entrySet()) {
						try {
							Field field = paramClass.getField(entry.getKey());
							if (field != null) {
								field.set(paramObj, entry.getValue());
							}
						} catch (NoSuchFieldException | SecurityException e) {
							log.warn("Field not exists: " + entry.getKey());
						}
					}
				}
				objectParam.add(paramObj);
			} catch (InstantiationException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return new Object[][] { objectParam.toArray() };
	}

	private static WebDriver getWebDriver(ITestContext context) {
		return (WebDriver) context.getAttribute("webDriver");
	}
	
	private static AndroidDriver<?> getAndroidDriver(ITestContext context) {
		return (AndroidDriver<?>) context.getAttribute("driver");
	}

}
