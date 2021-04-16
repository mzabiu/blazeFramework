package com.blaze.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.blaze.pages.BasePage;

public class PurchasePage extends BasePage {

	public String windowTitle = "BlazeDemo Purchase";

	public PurchasePage(EventFiringWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "inputName")
	private WebElement txtFirstName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "city")
	private WebElement txtCity;

	@FindBy(id = "state")
	private WebElement txtState;

	@FindBy(id = "zipCode")
	private WebElement txtZipcode;

	@FindBy(id = "cardType")
	private WebElement drpDnCardType;

	@FindBy(id = "nameOnCard")
	private WebElement txtNameOnCard;

	@FindBy(xpath = "//input[@value='Purchase Flight']")
	private WebElement btnPurchaseFlight;

	@FindBy(id = "rememberMe")
	private WebElement chkRememberMe;

	@FindBy(id = "creditCardNumber")
	private WebElement txtCreditCardNumber;

	public WebElement getTxtCreditCardNumber() {
		return txtCreditCardNumber;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCity() {
		return txtCity;
	}

	public WebElement getTxtState() {
		return txtState;
	}

	public WebElement getTxtZipcode() {
		return txtZipcode;
	}

	public WebElement getDrpDnCardType() {
		return drpDnCardType;
	}

	public WebElement getTxtNameOnCard() {
		return txtNameOnCard;
	}

	public WebElement getBtnPurchaseFlight() {
		return btnPurchaseFlight;
	}

	public WebElement getChkRememberMe() {
		return chkRememberMe;
	}

}
