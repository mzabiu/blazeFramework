package com.blaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.blaze.pages.BasePage;

public class ReservePage extends BasePage {

	public String windowTitle = "BlazeDemo - reserve";

	private String chooseThisFlight = "//td[text()='%flightName%']/preceding-sibling::td//input";

	public ReservePage(EventFiringWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void selectAirline(String airline, String time) {

	}

	public void selectAirlines(String airline) {
		String xpath = chooseThisFlight.replace("%flightName%", airline);
		getElement(By.xpath(xpath)).click();
	}

}
