package com.testrestapi;

/**
 * Class containing methods for testing 
 * fields for test methods
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class ParamValidator {
	
	/**
	 * Method to check that the string is not empty
	 * 
	 * @param checkString - checked string
	 * @return true - in case the string is not empty
	 * 		false - in case the string is empty
	 */
	public static boolean checkStringNotEmpty(String checkString) {		
		return checkString != null && !checkString.isEmpty();
	}
	
	/**
	 * Method to check that the string
	 * matches to the date format 'YYYY-MM-DD'
	 * 
	 * @param releaseDate - checked string
	 * @return true - in case the string matches the format
	 * 		false - in case the string doesn't match the format
	 */
	public static boolean checkReleaseDateFormat(String releaseDate) {		
		try {
			DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
	        fmt.parseLocalDate(releaseDate);
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
		
	}
	
	/**
	 * Method to check that the string
	 * matches to the format 'D.D.D.DDD',
	 * where D is digit 0-9
	 * 
	 * @param serverVersion - checked string
	 * @return true - in case the string matches the format
	 * 		false - in case the string doesn't match the format
	 */
	public static boolean checkServerVersionFormat(String serverVersion) {
		Pattern p = Pattern.compile("^(\\d\\.\\d\\.\\d\\.[0-9]{3})$"); 
        Matcher m = p.matcher(serverVersion);  
        return m.matches();
	}
	
	/**
	 * Method to check that the string
	 * matches to the format 12 character hash-string
	 * 
	 * @param serverRevision - checked string
	 * @return true - in case the string matches the format
	 * 		false - in case the string doesn't match the format
	 */
	public static boolean checkServerRevisionFormat(String serverRevision) {
		Pattern p = Pattern.compile("^[a-fA-F0-9]{12}$"); 
        Matcher m = p.matcher(serverRevision);  
        return m.matches();
	}
}
