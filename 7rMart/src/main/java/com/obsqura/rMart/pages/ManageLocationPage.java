package com.obsqura.rMart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageLocationPage 
{
public WebDriver driver;
	
	public ManageLocationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']") private WebElement countrySelectField;
	@FindBy(xpath = "//select[@id='st_id']") private WebElement stateSelectField;
	@FindBy(xpath = "//input[@id='location']") private WebElement enterLocationField;
	@FindBy(xpath = "//input[@id='delivery']") private WebElement enterdeliveryChargeField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement alertMessage;

	public ManageLocationPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageLocationPage selectContryFromDropDown()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(countrySelectField, ExcelUtility.getString(0, 0,"ManageLocation"));
		return this;
	}
	public ManageLocationPage selectStateFromDropDown()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(stateSelectField, ExcelUtility.getString(1, 0,"ManageLocation"));
		return this;
	}
	public ManageLocationPage enterLocation()
	{
		enterLocationField.sendKeys(ExcelUtility.getString(2, 0, "ManageLocation"));
		return this;
	}
	public ManageLocationPage enterDeliveryCharge()
	{
		enterdeliveryChargeField.sendKeys(ExcelUtility.getNumeric(3, 0,"ManageLocation"));
		return this;
	}
	public ManageLocationPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean isSuccessAlertDisplayed()
	{
		return alertMessage.isDisplayed();
	}

}
