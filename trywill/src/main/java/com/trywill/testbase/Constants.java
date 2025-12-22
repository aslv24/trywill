package com.trywill.testbase;

import com.trywill.reader.ConfigReader;

public class Constants {

	final public static String CHROME_DRIVER_KEY=ConfigReader.getValue("chrome.driver.key");
	final public static String CHROME_DRIVER_PATH=ConfigReader.getValue("chrome.driver.path");
	
	final public static String EDGE_DRIVER_KEY=ConfigReader.getValue("edge.driver.key");
	final public static String EDGE_DRIVER_PATH=ConfigReader.getValue("edge.driver.path");
	
	final public static String FIREFOX_DRIVER_KEY=ConfigReader.getValue("firefox.driver.key");
	final public static String FIREFOX_DRIVER_PATH=ConfigReader.getValue("firefox.driver.path");
	
	final public static long TIMEOUT_SHORT=10;
	final public static long TIMEOUT_MEDIUM=20;
	final public static long TIMEOUT_LONG=30;
	
	final public static String BASE_URL=ConfigReader.getValue("application.base.url");
	
	final public static String NEW_URL=ConfigReader.getValue("application.new.url");
	
	final public static String SCREENSHOT_DIR=ConfigReader.getValue("screenshot.path");
	
	final public static String IMAGE_FORMAT_PNG=".png";
	
	final public static String IMAGE_FORMAT_JPEG=".jpeg";
	
	final public static String REPORT_FORMAT=".html";
	
	final public static String REPORT_DIR=ConfigReader.getValue("report.path");
	
}
