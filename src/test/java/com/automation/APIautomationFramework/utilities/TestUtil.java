package com.automation.APIautomationFramework.utilities;

import org.json.JSONObject;

import com.automation.APIautomationFramework.reports.ExtentListeners;

public class TestUtil {
	
	//to get the key
	public static boolean jsonHasKey(String json, String key) {
		ExtentListeners.testReport.get().info("Validating the presence of key "+key);
		JSONObject jsonObject = new JSONObject(json);
		return jsonObject.has(key);
		
	}
	
	//to get the value
	public static String getJsonKeyValue(String json, String key) {
		ExtentListeners.testReport.get().info("Validating the value of the key  "+key);
		JSONObject jsonObject = new JSONObject(json);
		return jsonObject.getString(key);
		
	}

}
