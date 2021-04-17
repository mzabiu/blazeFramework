package com.spacex.testcases;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.blaze.framework.utils.AllureLogger;
import com.blaze.framework.utils.CommonUtils;
import com.blaze.framework.utils.FrameworkConstants;
import com.blaze.framework.utils.ReadExcelDataApi;
import com.blaze.framework.utils.ReadPropertiesFile;
import com.blaze.reporting.MyLog;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * 
 * @author Zabiulla_Pro
 *
 */
public abstract class BaseTestApi extends CommonUtils implements FrameworkConstants {

	protected static RequestSpecification requestSpec;
	protected static ResponseSpecification responseSpec;

	public Map<String, String> configPropertyData;

	@BeforeSuite(alwaysRun = true)
	public void setBaseURI(ITestContext context) {

		context.setAttribute("api.validation", true);
		configPropertyData = ReadPropertiesFile.getProperties();
		AllureLogger.logToAllure("The base URI is : " + configPropertyData.get(BASE_URI));
		requestSpec = new RequestSpecBuilder().setBaseUri(configPropertyData.get(BASE_URI)).build();
		MyLog.logInfo("Request Specification is :" + requestSpec);
	}

	@DataProvider(name = "DataFromExcel")
	public Object[][] data() throws Exception {
		ReadExcelDataApi xl = new ReadExcelDataApi("spaceX", this.getClass().getSimpleName());
		return xl.getTestdata();
	}
}