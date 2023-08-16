package com.obsqura.rMart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;

public class VerifyUsersPage 
{
	public WebDriver driver;
	
	public VerifyUsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[contains(@class,'btn-rounded')]") private WebElement searchOption;
	@FindBy ( xpath = "//input[@id='un']") private WebElement nameField;
	@FindBy (xpath = "//button[@name='Search']") private WebElement searchButton;
	@FindBy (xpath = "//table[contains(@class,'table-bordered')]//td") public WebElement tableValues;
	
	public VerifyUsersPage clickOnSearchBox()
	{
		searchOption.click();
		return this;
	}
	public VerifyUsersPage enterSearchValueOnNameField(String name)
	{
		nameField.sendKeys(name);
		return this;
	}
	public VerifyUsersPage clickOnSearchButton()
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,searchButton);
		searchButton.click();
		return this;
	}	

	public String isTheSearcNameExistsInTheVerifyUsersList() 
	{
		String str = tableValues.getText();
		return str;	
	}
}

