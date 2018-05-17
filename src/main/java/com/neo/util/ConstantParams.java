
package com.neo.util;


public class ConstantParams 
{
	public static final String LOG4J_FILE = "log4j.properties";
	public static final String ENCODE_SHIFTJIS = "SHIFT_JIS";	/* Encode Shift_JIS */
	public static final String ENCODE_UTF8 = "UTF-8";			/* Encode UTF-8 */
	

	// Cookie expire date
	public static final int DEFAULT_COOKIE_EXPIRE_DATE = 86400;
	public static final int NON_EXPIRE_COOKIE = -1;

	// Error Code Mapping
	public static final String LIST_FORM_START_END_DATE_PARSE_ERROR = "001";
	public static final String LOGIN_USER_PASSWORD_NOT_COORECT = "002";
	public static final String LOGIN_FOR_LOGUT_SUCCESSFULL = "003";
	public static final String UN_DEFINED_SYSTEM_ERROR = "999";
	public static final String PAGE_NOT_FOUND = "404";
	
	public static final String ERROR_VIEW_NAME = "error";
	
	
	//API result
	public static final String ERROR_CODE = "error_code";
	public static final String TOTAL = "total";
	public static final String CONTENTS = "contents";
	public static final String SUCCESS = "0";
	public static final String NO_DATA = "1";
	public static final String SYSTEM_ERROR = "-1";
	public static final String PERMISSION_DENIED  = "403";
}
