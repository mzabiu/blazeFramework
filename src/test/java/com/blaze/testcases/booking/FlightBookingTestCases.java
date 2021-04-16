package com.blaze.testcases.booking;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blaze.pages.ConfirmationPage;
import com.blaze.pages.HomePage;
import com.blaze.pages.PurchasePage;
import com.blaze.pages.ReservePage;
import com.blaze.testcases.BaseTest;

public class FlightBookingTestCases extends BaseTest {

	@Test(groups = { "critical", "smoke", "sanity" }, description = "verifying the flightBooking funcitonality")
	public void verifyFlightBooking(Method m) {

		// Loading the test data from exceldata (Map<String, Map<String, String>> which
		// is loaded in before suite
		Map<String, String> testData = excelData.get(m.getName());

		String firstName = testData.get(EXCEL_FIRST_NAME);
		String address = testData.get(EXCEL_ADDRESS);
		String city = testData.get(EXCEL_CITY);
		String state = testData.get(EXCEL_STATE);
		String zipCode = testData.get(EXCEL_ZIPCODE);
		String cardType = testData.get(EXCEL_CARD_TYPE);
		String nameOncard = testData.get(EXCEL_NAME_ON_CARD);
		String airLine = testData.get(EXCEL_AIRLINES);
		String ccNumber = testData.get(EXCEL_CC_NUMBER);

		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(driver.getTitle(), homePage.windowTitle);

		// Selecting the from and to cities
		homePage.selectCities("Paris", "Rome");

		ReservePage reservePage = new ReservePage(driver);
		Assert.assertEquals(driver.getTitle(), reservePage.windowTitle);

		// selecting the required airlines. This is overloaded method
		reservePage.selectAirlines(airLine);

		PurchasePage purchasePage = new PurchasePage(driver);
		Assert.assertEquals(purchasePage.getTxtFirstName().isDisplayed(), true);

		// form filling
		purchasePage.getTxtFirstName().sendKeys(firstName);
		purchasePage.getTxtAddress().sendKeys(address);
		purchasePage.getTxtCity().sendKeys(city);
		purchasePage.getTxtState().sendKeys(state);
		purchasePage.getTxtZipcode().sendKeys(zipCode);
		purchasePage.selectByText(purchasePage.getDrpDnCardType(), cardType);
		purchasePage.getTxtCreditCardNumber().sendKeys(ccNumber);
		purchasePage.getTxtNameOnCard().sendKeys(nameOncard);
		purchasePage.getBtnPurchaseFlight().click();

		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		assertEquals(confirmationPage.getLblId().isDisplayed(), true);
		confirmationPage.verifyConfirmationId();
	}

}
