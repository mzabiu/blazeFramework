package com.api.testcases.launchpads;

import static io.restassured.RestAssured.given; //import this

import org.testng.annotations.Test;

import com.blaze.framework.utils.AllureLogger;
import com.spacex.testcases.BaseTestApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetLaunchPadsTestCases extends BaseTestApi {

	@Test(groups = { "regression", "smoke",
			"critical" }, dataProvider = "DataFromExcel", description = "To retrieve the details of the booking IDs")
	public void getLaunchPads(String ID, String name, String fullName, String locality, String region, String rockets,
			String status, String timezone) {

		/*******************************************************
		 * Send a GET request to /booking/{id} and check that the response has HTTP
		 * status code 200 response header validation
		 ******************************************************/

		// Sending the GET request for a specific booking id and receiving the response
		AllureLogger.logToAllure("Getting the response for the launchPads from test data excel");
		Response response = given().spec(requestSpec).when().get("/launchpads/" + ID);

		// Verify the response code
		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");

		// To log the response to report
		logResponseAsString(response);
		System.out.println("response is " + response.getStatusCode());

		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println(jsonPathEvaluator.get("id"));
		Assert.assertSame(jsonPathEvaluator.get("id").equals(ID), true);

		// Using the POJO class
		AllureLogger.logToAllure("Asserting of response body with the data from test data excel");

		// Reader header of a give name. In this line we will get
		// Header named Content-Type
		Assert.assertEquals(response.header("Content-Type").equals("application/json; charset=utf-8"), true);
		AllureLogger.logToAllure("Content-Type value: " + response.header("Content-Type"));

		// Header named Content-Encoding
		String acceptLanguage = response.header("Content-Encoding");

		AllureLogger.logToAllure(acceptLanguage);
	}
}
