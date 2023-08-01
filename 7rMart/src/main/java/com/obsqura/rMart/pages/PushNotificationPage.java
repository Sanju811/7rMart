package com.obsqura.rMart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class PushNotificationPage 
{
	public WebDriver driver;
	
	public PushNotificationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='title']") private WebElement enterTitleField;
	@FindBy(xpath = "//input[@id='description']") private WebElement enterDescriptionField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement sendButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement alertMessage;
	
	public PushNotificationPage enterTitle()
	{
		enterTitleField.sendKeys(ExcelUtility.getString(0, 0, "PushNotification"));
		return this;
	}
	public PushNotificationPage enterDescripiton()
	{
		enterDescriptionField.sendKeys(ExcelUtility.getString(0, 0, "PushNotification"));
		return this;
	}
	public PushNotificationPage clickOnSaveButton()
	{
		sendButton.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alertMessage.isDisplayed();
	}

}