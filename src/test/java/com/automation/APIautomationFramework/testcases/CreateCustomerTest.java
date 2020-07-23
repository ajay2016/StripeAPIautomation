package com.automation.APIautomationFramework.testcases;



import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.automation.APIautomationFramework.APIs.CreateCustomerAPI;
import com.automation.APIautomationFramework.base.BaseTest;
import com.automation.APIautomationFramework.reports.ExtentListeners;
import com.automation.APIautomationFramework.utilities.DataUtil;
import com.automation.APIautomationFramework.utilities.TestUtil;
import com.aventstack.extentreports.Status;

import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {
	
	

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void CreateCustomerAPIValid(Hashtable<String, String> data) {
		
		
		
		/*
		 * RestAssured.baseURI = "https://api.stripe.com"; RestAssured.basePath = "/v1";
		 */
		
		//Business logic is in APIs packages
		
		/*
		 * Response response = given().auth().basic(prop.getProperty("ValidSecretKey"),
		 * "") .formParam("name", data.get("name")) .formParam("email",
		 * data.get("email")).formParam("description", data.get("description"))
		 * .post(prop.getProperty("customerAPIEndPoint"));
		 * 
		 * 
		 */
		
		if (!DataUtil.isRunnable("CreateCustomerAPIValid") || data.get("Runmode").equals("N")) {
			
		//	test.log(Status.SKIP, "Test skipped since rumode is N");
			ExtentListeners.testReport.get().info("Test skipped since rumode is N");
			//ExtentListeners.testReport.get().skip("Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}
		ExtentListeners.testReport.get().info(data.toString());
		Response response = CreateCustomerAPI.createCustomerAPIwithValidKey(data);

		response.prettyPrint();

		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		String actual_id = TestUtil.getJsonKeyValue(response.asString(), "email");
		Assert.assertEquals(actual_id, data.get("email"));

	}
	

	@Test(dataProviderClass = DataUtil.class ,  dataProvider = "data")
	public void CreateCustomerAPIInvalid(Hashtable<String, String> data) {
		

		/*
		 * RestAssured.baseURI = "https://api.stripe.com"; RestAssured.basePath = "/v1";
		 */

		/*
		 * Response response =
		 * given().auth().basic(prop.getProperty("InvalidSecretKey"), "")
		 * .formParam("name", data.get("name")) .formParam("email",
		 * data.get("email")).formParam("description", data.get("description"))
		 * .post(prop.getProperty("customerAPIEndPoint"));
		 */
		
		if (!DataUtil.isRunnable("CreateCustomerAPIInvalid") || data.get("Runmode").equals("N")) {
			
			//	test.log(Status.SKIP, "Test skipped since rumode is N");
				ExtentListeners.testReport.get().info("Test skipped since rumode is N");
				//ExtentListeners.testReport.get().skip("Test skipped since rumode is N");
				throw new SkipException("Test skipped since rumode is N");

			}
		
		ExtentListeners.testReport.get().info(data.toString());
		Response response = CreateCustomerAPI.createCustomerAPIwithInvalidKey(data);
		response.prettyPrint();

		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	
}
