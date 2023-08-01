package com.obsqura.rMart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='username']") WebElement userNameFiled;
	@FindBy(xpath = "//input[@name='password']") WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") WebElement signInButton;
	@FindBy(xpath = "//li[text()='Dashboard']") WebElement homePage;
	@FindBy(xpath = "//div[contains(@class,'-dismissible')]") private WebElement alertMessage;
	 
	public LoginPage enterUsernameOnUsernameField(String userName)
	{
		userNameFiled.sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPasswrodOnPasswrodField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	
	public LoginPage clickOnSignInButton()
	{
		signInButton.click();
		return this;
	}
	
	public boolean isHomePageDisplayed()
	{
		return homePage.isDisplayed();
	}
	
	public boolean isAlertMessageDisplayedAfterEnteringInvalidCredentials()
	{
		return alertMessage.isDisplayed();
	}

}
