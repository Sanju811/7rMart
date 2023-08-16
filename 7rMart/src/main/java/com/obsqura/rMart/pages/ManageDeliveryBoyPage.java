package com.obsqura.rMart.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageDeliveryBoyPage 
{
	public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']") private WebElement nameFeild;
	@FindBy(xpath = "//input[@id='email']") private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']") private WebElement phoneNumberField;
	@FindBy(xpath = "//textarea[@id='address']") private WebElement addressFiled;
	@FindBy(xpath = "//input[@id='username']") private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordField;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	@FindAll(@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td")) private List<WebElement> tableData;
	
	public ManageDeliveryBoyPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageDeliveryBoyPage enterName()
	{
		nameFeild.sendKeys(ExcelUtility.getString(0, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage enterEmail()
	{
		emailField.sendKeys(ExcelUtility.getString(1, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage enterPhoneNumber()
	{
		phoneNumberField.sendKeys(ExcelUtility.getNumeric(2, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage enterAddressField()
	{
		addressFiled.sendKeys(ExcelUtility.getString(3, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage enterUserName()
	{
		userNameField.sendKeys(ExcelUtility.getString(4, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage enterPassword()
	{
		passwordField.sendKeys(ExcelUtility.getString(5, 1,"ManageDeliveryBoy"));
		return this;
	}
	public ManageDeliveryBoyPage clickOnSaveButton()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollToElement(driver, saveButton);
		saveButton.click();
		return this;
	}
	public boolean isNewDeliveryBoyAdded()
	{
		PageUtility pageUtility = new PageUtility();
		boolean isDeliveryBoyAddedInList = pageUtility.isListContainsText(tableData, ExcelUtility.getString(0, 1,"ManageDeliveryBoy"));
		return isDeliveryBoyAddedInList;
	}

}
