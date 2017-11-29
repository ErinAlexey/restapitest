package com.testrestapi;

/**
 * Class containing Data Providers for tests
 */

import static io.restassured.RestAssured.get;

import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestDataProvider {
	static {
		RestAssured.baseURI = "https://platform.devtest.ringcentral.com";
	}
	
	static String releaseDate = get("/restapi/v1.0").path("releaseDate");
	static String serverVersion = get("/restapi").path("serverVersion");
	static String serverRevision = get("/restapi").path("serverRevision");
	
	/**
	 * Data Provider containing data for 
	 * testParameterFormat from PositiveTest class
	 */
	@DataProvider(name="getTestFormatData")
	public static Object[][] getTestData(){		
		return new Object[][] {
			{ParamValidator.checkReleaseDateFormat(releaseDate),
				true, "Field Release Date have value: " + releaseDate
				+ ". Field must be in YYYY-MM-DD format"},
			{ParamValidator.checkServerVersionFormat(serverVersion),
					true, "Field Server Version have value: " + serverVersion
				+ ". Field must be in D.D.D.DDD format"},
			{ParamValidator.checkServerRevisionFormat(serverRevision),
					true, "Field Server Revision have value: " + serverRevision
				+ ". Field must be in format 12-character hash string"}
		};
	}
	
	/**
	 * Data Provider containing data for
	 * testParameterNotEmpty from PositiveTest class
	 */
	@DataProvider(name="getTestNotEmptyData")
	public static Object[][] getTestNotEmptyData(){	
		return new Object[][] {
			{releaseDate, true, "Release Date"},
			{serverVersion, true, "Server Version"},
			{serverRevision, true, "Server Revision"}
		};
	}
	
	/**
	 * Data Provider containing data for
	 * testAvailablePage from NegativeTest class
	 */
	@DataProvider(name="getTestAvailablePage")
	public static Object[][] getTestAvailablePage () {
		Response res_1 = get("/restapi/v2.0");
		Response res_2 = get("/restapi/v1.0/releaseDate");
		return new Object[][] {
			{res_1, 404, "/restapi/v2.0"},
			{res_2, 401, "/restapi/v1.0/releaseDate"}
		};
	}
}
