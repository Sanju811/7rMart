package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.obsqura.rMart.pages.LoginPage;
import com.obsqura.rMart.pages.MenuSelectionPage;
import com.obsqura.rMart.pages.VerifyUsersPage;

import retry.Retry;
import utilities.ExcelUtility;

public class VerifyUsersTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="verify user is able to search existing users",priority=1)
	public void verifyUserIsAbleToSearchExistingUsers()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		String name = ExcelUtility.getString(0, 0,"VerifyUsers");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();	
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnVerifyUsers();		
		VerifyUsersPage verifyUsersPage = new VerifyUsersPage(driver);
		verifyUsersPage.clickOnSearchBox().enterSearchValueOnNameField(name).clickOnSearchButton();
		String actualResult = verifyUsersPage.isTheSearcNameExistsInTheVerifyUsersList();
		assertEquals(name, actualResult," user not able to search existing users");	
	}
	
	@Test(retryAnalyzer = Retry.class,description="Verify search for non Existing User shows nomatches found", priority=2)
	public void verifySearchForNonExistingUserShowsNoMatchesFound() throws InterruptedException
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		String name = ExcelUtility.getString(1, 0,"VerifyUsers");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnVerifyUsers();	
		VerifyUsersPage verifyUsersPage = new VerifyUsersPage(driver);
		verifyUsersPage.clickOnSearchBox().enterSearchValueOnNameField(name).clickOnSearchButton();
		String actualResult = verifyUsersPage.isTheSearcNameExistsInTheVerifyUsersList();
		assertEquals(name, actualResult,"Search for non existing user shows Matches");	
		
	}
}
