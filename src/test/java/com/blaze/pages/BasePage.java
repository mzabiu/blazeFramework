package com.blaze.pages;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.blaze.framework.utils.FrameworkConstants;

public class BasePage implements FrameworkConstants {

	public static Map<String, String> configData;
	static {
		configData = com.blaze.framework.utils.ReadPropertiesFile.getProperties();
	}

	public static Logger log = Logger.getLogger(BasePage.class.getName());

	public EventFiringWebDriver driver;

	/**
	 * constructor to intialize the driver
	 * 
	 * @param driver
	 * 
	 */

	public BasePage(EventFiringWebDriver driver) {
		this.driver = driver;
		init();
	}

	/**
	 * Method to initialize the web elements for a given page
	 */

	public void init() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getElement(By by) {
		return driver.findElement(by);
	}

	private Select getSelect(WebElement e) {
		return new Select(e);
	}

	public void selectByIndex(WebElement e, int index) {
		getSelect(e).selectByIndex(index);
	}

	public void selectByIndex(WebElement e, String value) {
		getSelect(e).selectByValue(value);
	}

	public void selectByText(WebElement e, String value) {
		getSelect(e).selectByVisibleText(value);
	}

}
