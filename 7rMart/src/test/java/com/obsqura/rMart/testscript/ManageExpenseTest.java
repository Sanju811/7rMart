package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.obsqura.rMart.pages.LoginPage;
import com.obsqura.rMart.pages.ManageExpensePage;
import com.obsqura.rMart.pages.MenuSelectionPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageExpenseTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify user is  able to add expense record by filling all field")
	public void verifyUserIsAbleToAddExpenseRecordByFillingAllfield()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageExpense().clickOnSubMenuManageExpense();		
		ManageExpensePage manageExpensePage = new ManageExpensePage(driver);
		manageExpensePage.clickOnNewButton().selectUser().selectCategory().selectOrderId().selectPurchaseId()
		   .selectExpenseType().enterAmount().enterRemarks().uploadFile().clickOnSaveButton();
		boolean isAlertMessageDisplayed = manageExpensePage.alertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed, "User not  able to add expense record by filling all field");
	}

}
