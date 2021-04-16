package com.blaze.testcases.booking;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.blaze.pages.home.HomePage;
import com.blaze.testcases.BaseTest;

public class FlightBookingTestCases extends BaseTest {

	@Test
	public void verifyFlightBooking(Method m) {
		Map<String, String> testData = excelData.get(m.getName());

		String firstName = testData.get(EXCEL_FIRST_NAME);
		String address = testData.get(EXCEL_ADDRESS);
		String city = testData.get(EXCEL_CITY);
		String state = testData.get(EXCEL_STATE);
		String zipCode = testData.get(EXCEL_ZIPCODE);
		String cardType = testData.get(EXCEL_CARD_TYPE);
		String nameOncard = testData.get(EXCEL_NAME_ON_CARD);

		HomePage homePage = new HomePage(driver);
		homePage.selectCities("Paris", "Rome");

	}

}
