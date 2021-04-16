package com.blaze.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.blaze.pages.BasePage;

public class HomePage extends BasePage {

	public String windowTitle = "BlazeDemo";

	public HomePage(EventFiringWebDriver driver) {
		super(driver);
	}

	@FindBy(name = "fromPort")
	private WebElement drpDnDeparureCity;

	@FindBy(name = "toPort")
	private WebElement drpDnDestinationCity;

	@FindBy(xpath = "//input[@value='Find Flights']")
	private WebElement btnFindFlights;

	public void selectCities(String from, String to) {
		selectByText(drpDnDeparureCity, from);
		selectByText(drpDnDestinationCity, to);
		btnFindFlights.click();
	}

}
