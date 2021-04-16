package com.blaze.listeners;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.blaze.framework.utils.FrameworkConstants;
import com.blaze.framework.utils.ReadPropertiesFile;
import com.blaze.reporting.GenerateExcelReport;
import com.blaze.reporting.MyLog;

public class TestListeners implements ITestListener, FrameworkConstants {

	CopyOnWriteArrayList<Object[]> executionResult;

	DateTimeFormatter dtf;
	LocalDateTime lt;

	String testGroups = "";

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		testGroups = (String) result.getTestContext().getAttribute("groups");
		executionResult.add(new String[] { result.getName(), testGroups, getExecutionDate(), "", "Passed" });
	}

	public void onTestFailure(ITestResult result) {

		testGroups = (String) result.getTestContext().getAttribute("groups");
		EventFiringWebDriver driver = (EventFiringWebDriver) result.getTestContext().getAttribute("WebDriver");
		String path = takeScreenshot(driver, result.getMethod().getMethodName());

		MyLog.onlyReport("<a href='" + path + "'>Screen shot</a>");

		String hyperLink = "=HYPERLINK(\"file://" + path + "\", \"click here\")";
		executionResult.add(new String[] { result.getName(), testGroups, getExecutionDate(),
				result.getThrowable().toString(), "Failed", hyperLink });

	}

	public void onTestSkipped(ITestResult result) {
		testGroups = (String) result.getTestContext().getAttribute("groups");
		executionResult.add(new String[] { result.getName(), testGroups, "", "", "Skipped" });
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		lt = LocalDateTime.now();
		executionResult = new CopyOnWriteArrayList<Object[]>();

		// adding header for the excel report
		executionResult.add(new String[] { "TestCaseName", "Test Groups", "Test Case Executed", "Error Reason",
				"Execution Status", "Screen shot" });
	}

	public void onFinish(ITestContext context) {
		try {
			GenerateExcelReport.writeFileUsingPOI(new ArrayList<Object[]>(executionResult), getFileName("Result"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This will takestheSCreen
	 * 
	 * @param driver
	 * @param methodName
	 * @return
	 */

	private String takeScreenshot(EventFiringWebDriver driver, String methodName) {

		String fileName = getFileName(methodName) + ".png";

		File f = null;

		String dir = ReadPropertiesFile.getProperties().get(SCREENSHOT_PATH);
		new File(dir).mkdirs();

		String path = dir + fileName;
		try {
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			f = new File(path);
			FileUtils.copyFile(screenShot, f);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (f != null)
			return f.getAbsolutePath().toString();
		else
			return "error while capturing screen shot";
	}

	/**
	 * 
	 * Creating a unique screen shot name everytime
	 * 
	 * @param methodName
	 * @return
	 */
	private String getFileName(String methodName) {
		Date date = new Date();
		return methodName + "_" + date.toString().replace(":", "_").replace(",", "_");

	}

	private synchronized String getExecutionDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

}
