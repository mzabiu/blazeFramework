package com.blaze.framework.utils;

import com.blaze.reporting.MyLog;

import io.qameta.allure.Step;

/**
 * 
 * @author Zabiulla_Pro
 *
 */
public class AllureLogger {

	private AllureLogger() {
		// hide default constructor for this util class
	}

	/**
	 * Uses the @Step annotation to log the given log message to Allure.
	 *
	 * @param message the message to log to the allure report
	 */
	@Step("{0}")
	public static void logToAllure(String message) {
		MyLog.logInfo("Logged to allure: " + message);
	}
}