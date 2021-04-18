package com.blaze.testcases;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.blaze.framework.utils.CommonUtils;
import com.blaze.framework.utils.FrameworkConstants;
import com.blaze.framework.utils.ReadExcelTestData;
import com.blaze.framework.utils.ReadPropertiesFile;
import com.blaze.listeners.DriverListener;
import com.blaze.reporting.MyLog;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends CommonUtils implements FrameworkConstants {

	public Map<String, String> configPropertyData;
	public Map<String, HashMap<String, String>> excelData;

	public EventFiringWebDriver driver;
	public WebDriver driver1;

	boolean jenkinsRun = false;

	String appUrl;

	@BeforeSuite(alwaysRun = true)
	public void initialize(XmlTest testngXml, ITestContext context) throws Exception {

		context.setAttribute("api.validation", true);
		updateSuiteName(context.getSuite().getName());
		configPropertyData = ReadPropertiesFile.getProperties();
		excelData = ReadExcelTestData.getSuiteData("TestData", "Data");
		appUrl = configPropertyData.get(configPropertyData.get(BASEURL));
		if (System.getProperty("jenkins.buildurl") != null) {
			jenkinsRun = true;
			MyLog.logInfo(
					"The execution is triggered from jenkins and the url is " + System.getProperty("jenkins.buildurl"));
		} else
			MyLog.logInfo("This not a jenkins execution ");
	}

	@BeforeTest(alwaysRun = true)
	public void initDriver(XmlTest xmlData, ITestContext context) {

		String browserName = xmlData.getParameter("browser").toLowerCase().trim();

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();

			if (jenkinsRun) {
				MyLog.logInfo("The execution is triggered from jenkins and the url is "
						+ System.getProperty("jenkins.buildurl"));

				chromeOptions.setBinary(APP_DATA + "\\Local\\Google\\Chrome\\Application\\chrome.exe");
			}
			driver1 = new ChromeDriver(chromeOptions);
		} else if ((browserName.equalsIgnoreCase("edge"))) {
			System.setProperty("webdriver.edge.driver", "/src/main/resources/com/orangehrm/drivers/msedgedriver.exe");
			driver1 = new EdgeDriver();
		} else if ((browserName.equalsIgnoreCase("firefox"))) {
			WebDriverManager.firefoxdriver().setup();
			driver1 = new FirefoxDriver();
		} else {
			throw new RuntimeException("Please valid browser name");
		}

		driver = new EventFiringWebDriver(driver1);
		DriverListener listener = new DriverListener();
		driver.register(listener);
		driver.manage().window().maximize();
		int implicitWait = Integer.valueOf(configPropertyData.get(IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.get(appUrl);

		context.setAttribute("WebDriver", driver);
	}

	@AfterMethod(alwaysRun = true)
	public void gotoHomePage(Method m, ITestResult r) throws Exception {

		Reporter.setCurrentTestResult(r);
		driver.navigate().to(appUrl);

	}

	@BeforeMethod(alwaysRun = true)
	public void setLog(Method m, ITestResult r, ITestContext c) throws UnknownHostException {

		StringBuilder b = new StringBuilder();
		Reporter.setCurrentTestResult(r);

		MyLog.logInfo("============================== Starting Test case " + m.getName()
				+ "================================");
		MyLog.logInfo("The test case is executed on the machine name: " + InetAddress.getLocalHost().getHostName());

		// code to get the grouping of the test case
		for (String s : m.getAnnotation(Test.class).groups())
			b.append(s + ", ");
		c.setAttribute("groups", b.toString());
		MyLog.logInfo("Test grouping: " + b);
		MyLog.logInfo("The application url is " + driver.getCurrentUrl());

	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		MyLog.logInfo("Quiting the driver");
		driver.quit();
	}

}
