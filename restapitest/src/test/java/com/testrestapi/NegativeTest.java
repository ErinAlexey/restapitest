package com.testrestapi;

/**
 * Test class containing test-method
 * to test that the system correctly work 
 * when user try to load unavailable page
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegativeTest {

	/**
	 * Test for check that the system correctly work 
	 * when user try to load unavailable page
	 * 
	 * @param res - response from server
	 * @param exp - expected result
	 * @param uri - URI of page
	 */
	@Test(dataProvider = "getTestAvailablePage", 
			dataProviderClass = TestDataProvider.class)
	public void testAvailablePage (Response res, int exp, String uri) {
		int code = res.getStatusCode();
		Assert.assertEquals(code, exp);
		String msg = res.path("message");
		System.out.println("Page is unavailable. Error message: " + msg + ". URI: "
		+ RestAssured.baseURI + uri);
	}
}
