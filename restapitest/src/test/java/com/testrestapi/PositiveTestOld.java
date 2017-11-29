package com.testrestapi;

/**
 * Test class containing test methods
 * to test the serverVersion, serverRevision,
 * and releaseDate fields when the data
 * is correctly entered. All fields must
 * be non-empty and match to the formats
 * provided for these fields.
 */

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testrestapi.ParamValidator;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class PositiveTestOld {
	
	/**
	 * Test for checking that the 
	 * releaseDate field is not empty
	 */
	@Test(description="Сheck that the field releaseDate not empty", enabled=false)
	public void testReleaseDateNotNull () {
		String res = get("/restapi/v1.0")
				.path("releaseDate");		
		Assert.assertTrue(ParamValidator.checkStringNotEmpty(res), 
				"Field Release Date is empty");
	}
	
	/**
	 * Test for checking that the Release Date 
	 * field in the format 'YYYY-MM-DD'
	 */
	@Test(description="Сheck that the field releaseDate matches the format 'YYYY-MM-DD'", enabled=false)
	public void testReleaseDateFormat () {		
		String res = get("/restapi/v1.0")
				.path("releaseDate");
		Assert.assertTrue(ParamValidator.checkReleaseDateFormat(res),
				"Field Release Date have value = " + res
				+ " and not in YYYY-MM-DD format");		
	}
	
	/**
	 * Test for checking that the 
	 * Server Version field is not empty
	 */
	@Test(description="Сheck that the field serverVersion not empty", enabled=false)
	public void testServerVersionNotNull () {
		String res = get("/restapi")
				.path("serverVersion");
		Assert.assertTrue(ParamValidator.checkStringNotEmpty(res),
				"Field Server Version is empty");
	}
	
	/**
	 * Test for checking that the Server Version 
	 * field in the format 'D.D.D.DDD'
	 */
	@Test(description="Сheck that the field serverVersion matches the format 'D.D.D.DDD'", enabled=false)
	public void testServerVersionFormat () {		
		String res = get("/restapi")
				.path("serverVersion");
		Assert.assertTrue(ParamValidator.checkServerVersionFormat(res),
				"Field Server Version have value = " + res
				+ " and not in D.D.D.DDD format");		
	}
	
	/**
	 * Test for checking that the 
	 * Server Revision field is not empty
	 */
	@Test(description="Сheck that the field serverRevision not empty", enabled=false)
	public void testServerRevisionNotNull () {
		String res = get("/restapi")
				.path("serverRevision");
		Assert.assertTrue(ParamValidator.checkStringNotEmpty(res),
				"Field Server Revision is empty");
	}
	
	/**
	 * Test for checking that the Server Revision 
	 * field in the format 12 character hash-string
	 */
	@Test(description="Сheck that the field serverRevision matches the format: 12-character hash string", enabled=false)
	public void testServerRevisionFormat () {		
		String res = get("/restapi")
				.path("serverRevision");
		Assert.assertTrue(ParamValidator.checkServerRevisionFormat(res),
				"Field Server Revision have value = " + res
				+ " and not in format 12-character hash string");		
	}
}
