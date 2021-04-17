package com.api.testcases.launchpads;

import static io.restassured.RestAssured.given; //import this

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.jsons.LaunchPadsJson;
import com.blaze.framework.utils.AllureLogger;
import com.spacex.testcases.BaseTestApi;

import io.restassured.response.Response;

public class GetLaunchPadsTestCases extends BaseTestApi {

	@Test(dataProvider = "DataFromExcel", description = "To retrieve the details of the booking IDs")
	public void getLaunchPads(String ID, String name, String fullName, String locality, String region, String rockets,
			String status) {

		AllureLogger.logToAllure("Starting the test to get booking details");
		/*******************************************************
		 * Send a GET request to /booking/{id} and check that the response has HTTP
		 * status code 200
		 ******************************************************/

		// Sending the GET request for a specific booking id and receiving the response
		AllureLogger.logToAllure("Getting the response for the launchPads from test data excel");
		Response response = given().spec(requestSpec).pathParam("id", ID).when().get("/launchpads/{id}");

		// Verify the response code
		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().spec(responseSpec);

		// To log the response to report
		logResponseAsString(response);

		// Using the POJO class
		AllureLogger.logToAllure("Asserting of response body with the data from test data excel");

		LaunchPadsJson launchPadsJson = response.as(LaunchPadsJson.class);

		Assert.assertEquals(launchPadsJson.getID(), ID);
		Assert.assertEquals(launchPadsJson.getFullName(), fullName);
		Assert.assertEquals(launchPadsJson.getLocality(), locality);
		Assert.assertEquals(launchPadsJson.getRegion(), region);
		Assert.assertEquals(launchPadsJson.getName(), name);
		Assert.assertEquals(launchPadsJson.getRockets(), rockets);

	}
}
