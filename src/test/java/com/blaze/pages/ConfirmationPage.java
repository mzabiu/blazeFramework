package com.blaze.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.blaze.reporting.MyLog;

public class ConfirmationPage extends BasePage {

	String regexConfirmationId = "[0-9]+";

	public String windowTitle = "BlazeDemo Confirmation";

	public ConfirmationPage(EventFiringWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//td[text()='Id']/following-sibling::td")
	private WebElement lblId;

	public WebElement getLblId() {
		return lblId;
	}

	/**
	 * Method to check if the confirmation id matches the regex (all numbers)
	 * 
	 * @return
	 */
	public void verifyConfirmationId() {

		String confirmId = getLblId().getText().trim();

		if (confirmId == null || confirmId.isEmpty())
			throw new RuntimeException("Error while getting the confrimation id");

		Pattern pattern = Pattern.compile(regexConfirmationId);
		Matcher matcher = pattern.matcher(confirmId);

		if (matcher.matches())
			MyLog.onlyLog("The confirmation id is displayed: " + confirmId);
		else {
			MyLog.onlyLog("The confirmation id is NOT displayed: " + confirmId);
			throw new RuntimeException("The confirmation id is NOT displayed: " + confirmId);
		}

	}

}
