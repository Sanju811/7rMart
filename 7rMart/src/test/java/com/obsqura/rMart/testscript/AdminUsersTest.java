package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rMart.pages.AdminUsersPage;
import com.obsqura.rMart.pages.LoginPage;
import com.obsqura.rMart.pages.MenuSelectionPage;
import retry.Retry;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify User is able to add AdminUser information by filling all mandatoryField")
	public void verifyUserIsAbleToAddAdminUserInformationByfillingAllMandatoryField()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnAdminUsers();	
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickOnNewButton().enterUserName().enterPassword().selectValueFromUserTypeDropDown().clickOnSaveButton();
		assertTrue(adminUsersPage.isSuccessAlertDisplayed(),"User is not able to add AdminUser information by filling all mandatoryField");
	}

}
