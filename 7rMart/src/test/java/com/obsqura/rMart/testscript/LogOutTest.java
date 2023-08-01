package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rMart.pages.LogOutPage;
import com.obsqura.rMart.pages.LoginPage;

import retry.Retry;
import utilities.ExcelUtility;

public class LogOutTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify user is able to logout from the site")
	public void verifyUserIsAbleToLogoutFromTheSite()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();	
		LogOutPage logOutPage = new LogOutPage(driver);
		logOutPage.clickOnAdminButton();
		logOutPage.clickOnLogOutButton();
		assertTrue(logOutPage.checkForLoginMessage().equals("Sign in to start your session"),"User is not able Logout from the site");
	}

}
