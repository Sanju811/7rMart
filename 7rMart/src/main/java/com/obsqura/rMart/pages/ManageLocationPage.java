package com.obsqura.rMart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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
	@FindBy(xpath = "//a[contains(@class,'btn-primary') and @onclick='click_button(2)']") private WebElement searchOption;
	@FindBy(xpath = "//button[@value='sr']") private WebElement searchButton;
	@FindBy(xpath = "//a[text()='Cancel']") private WebElement cancelButton;
	@FindAll(@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td")) private List<WebElement> tableData;

	public ManageLocationPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageLocationPage selectCountryFromDropDown()
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
	public ManageLocationPage clickOnSearchOption()
	{
		searchOption.click();
		return this;
	}
	public ManageLocationPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	public ManageLocationPage clickOnCancelButton()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollToElement(driver, cancelButton);
		cancelButton.click();
		return this;
	}
	public boolean isLocationAddedInList()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		boolean isLocationAdded = pageUtility.isListContainsText(tableData, ExcelUtility.getString(1, 0, "ManageLocation"));
		return isLocationAdded;
	}
}
