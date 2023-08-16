package com.obsqura.rMart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class LogOutPage 
{
	public WebDriver driver;
	
	public LogOutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@data-toggle='dropdown']")private WebElement adminButton;
	@FindBy(xpath = "//i[contains(@class,'fa-power-off')]//parent::a[@class='dropdown-item']")private WebElement logOutButton;
	@FindBy(xpath = "//p[@class='login-box-msg']")private WebElement loginMessage;
	
	public LogOutPage clickOnAdminButton()
	{
		adminButton.click();
		return this;
	}
	public LogOutPage clickOnLogOutButton()
	{
		logOutButton.click();
		return this;
	}
	public String checkForLoginMessage()
	{
		PageUtility pageUtility = new PageUtility();
		String messageDisplayed= pageUtility.getText(loginMessage);
		return messageDisplayed;
	}
	

}
