package com.testrestapi;

/**
 * Test class containing test-methods
 * to test the serverVersion, serverRevision, 
 * and releaseDate fields with incorrectly 
 * entered data
 */

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testrestapi.ParamValidator;

import io.restassured.RestAssured;

public class NegativeTest {

	@BeforeClass
	public void setBaseUri () {
		RestAssured.baseURI = "https://platform.devtest.ringcentral.com";
	}
	
	@Test(description="Сheck that the field serverVersion doesn't matches the format 'D.D.D.DDD'")
	public void testServerVersionFormat () {		
		String res = get("/restapi")
				.path("serverVersion");
		Assert.assertFalse(ParamValidator.checkServerVersionFormat(res),
				"Field Server Version in D.D.D.DDD format");		
	}
	
	@Test(description="Сheck that the field serverRevision doesn't matches the format: 12-character hash string")
	public void testServerRevisionFormat () {		
		String res = get("/restapi")
				.path("serverRevision");
		Assert.assertFalse(ParamValidator.checkServerRevisionFormat(res),
				"Field Server Revision in format 12-character hash string");		
	}
}
