package com.obsqura.rMart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class AdminUsersPage 
{
public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")private WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@name='Create']")private WebElement saveButton;
	@FindAll(@FindBy(xpath = "//table[contains(@class,'table-sm')]//td")) private List<WebElement> tableData;
	
	public AdminUsersPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public AdminUsersPage enterUserName()
	{
		userNameField.sendKeys(ExcelUtility.getString(1, 0,"AdminUsers"));
		return this;
	}	
	public AdminUsersPage enterPassword()
	{
		passwordField.sendKeys(ExcelUtility.getString(2, 0,"AdminUsers"));
		return this;
	}	
	public AdminUsersPage selectValueFromUserTypeDropDown()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(userTypeDropDown,ExcelUtility.getString(0, 0,"AdminUsers"));
		return this;
	}
	public AdminUsersPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean isNewUserAdded()
	{
		PageUtility pageUtility = new PageUtility();
		boolean isUserAddedInList = pageUtility.isListContainsText(tableData, ExcelUtility.getString(1, 0,"AdminUsers"));
		return isUserAddedInList;
	}
}
