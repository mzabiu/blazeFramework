package com.blaze.framework.utils;

public interface FrameworkConstants {

	// current directory
	String CURRENT_DIR = System.getProperty("user.dir");
	String APP_DATA = System.getProperty("user.home");

	// excel parameters

	String EXCEL_FIRST_NAME = "FirstName";
	String EXCEL_ADDRESS = "Address";
	String EXCEL_CITY = "City";
	String EXCEL_STATE = "State";
	String EXCEL_ZIPCODE = "Zipcode";
	String EXCEL_CARD_TYPE = "CardType";
	String EXCEL_NAME_ON_CARD = "NameOncard";
	String EXCEL_AIRLINES = "Airlines";

	// variable names for config property files

	String BASEURL = "baseUrl";
	String SCREENSHOT_PATH = "screenshot.path";
	String LOGJ_PATH = "log4j.path";
	String TEST_DATA_PATH = "testdata.path";
	String IMPLICIT_WAIT_TIME = "implicit.wait";
	String WEBDRIVER_WAIT_TIME = "webdriver.wait";
	String DRIVERS_PATH = "driver.path";
	String CHROME_BINARY_PATH = "chrome.binary.path";

}
