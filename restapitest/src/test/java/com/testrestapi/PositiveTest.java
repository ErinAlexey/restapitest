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
import org.testng.annotations.Test;

import com.testrestapi.ParamValidator;

public class PositiveTest {

	/**
	 * Test for checking that the Server Revision, Server Version
	 * and Release Date fields is not empty
	 * 
	 * @param parameter - parameter for check
	 * @param expectedResult - expected result
	 * @param field - name of parameter
	 */
	@Test(dataProvider = "getTestNotEmptyData", 
			dataProviderClass = TestDataProvider.class)
	public void testParameterNotEmpty (String parameter, boolean expectedResult, String field) {
		Assert.assertEquals(ParamValidator.checkStringNotEmpty(parameter), expectedResult,
				"Field "+ field + " is empty");
	}

	/**
	 * Test for checking that the Server Revision, Server Version
	 * and Release Date fields in the required format
	 * 
	 * @param parameter - parameter for check
	 * @param expectedResult - expected result
	 * @param message - error message
	 */
	@Test(dataProvider = "getTestFormatData", 
			dataProviderClass = TestDataProvider.class)
	public void testParameterFormat (boolean parameter, boolean expectedResult, String message) {
		Assert.assertEquals(parameter, expectedResult, message);
	}
}
