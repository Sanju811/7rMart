package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertTrue;
import retry.Retry;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.rMart.pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	
	@Test(retryAnalyzer = Retry.class,description="verify User Is Able To Login Using Valid Credentials",groups = {"regression"})
	public void verifyUserIsAbleToLoginUsingValidCredenials()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isNavigatedToHomePage = loginPage.isHomePageDisplayed();
		assertTrue(isNavigatedToHomePage,"User not able to login with valid credentials");
	}
	
	@Test(retryAnalyzer = Retry.class,description="verifyUserIsNotAbleToLoginUsingValidUsernameAndInvalidPassword",groups = {"smoke"})
	@Parameters("password")
	public void verifyUserIsNotAbleToLoginUsingValidUsernameAndInvalidPassword(String password)
	{
		String username = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "Login using valid username and Invalid Password leads to Home page");
	}

	@Test(retryAnalyzer = Retry.class,description="verifyUserIsNotAbleToLoginUsingInvalidUsernameAndValidPassword", groups = {"regression","smoke"})
	public void verifyUserIsNotAbleToLoginUsingInvalidUsernameAndValidPassword()
	{
		String userName = ExcelUtility.getString(2, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "Login using invalid username and valid Password leads to Home page");
	}
	
	@Test(dataProvider ="LoginProvider", retryAnalyzer = Retry.class,description="verifyUserIsNotAbleToLoginUsingInvalidUsernameAndPassword")
	public void verifyUserIsNotAbleToLoginUsingInvalidUsernameAndPassword(String userName,String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "Login using invalid username and Password leads to Home page");
	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(2, 0,"LoginPage"), ExcelUtility.getString(2, 0,"LoginPage") },

		};
	}
	
	
}
