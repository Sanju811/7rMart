package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rMart.pages.LoginPage;
import com.obsqura.rMart.pages.ManageDeliveryBoyPage;
import com.obsqura.rMart.pages.MenuSelectionPage;

import retry.Retry;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base
{
		@Test(retryAnalyzer = Retry.class,description="Verify whether the user is able to submit the manage user boy with entering all the field values")
		public void verifyUserIsAbleToAddManageDeliveryBoyDetailsByFillingAllField()
		{
			String userName = ExcelUtility.getString(1, 0,"LoginPage");
			String password = ExcelUtility.getString(1, 0,"LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();		
			MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
			menuSelectionPage.clickOnManageDeliveryBoy();			
			ManageDeliveryBoyPage manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
			manageDeliveryBoyPage.clickOnNewButton().enterName().enterEmail().enterPhoneNumber().enterAddressField().enterUserName().enterPassword().clickOnSaveButton();
			assertTrue(manageDeliveryBoyPage.isNewDeliveryBoyAdded(), "User is not able to add ManageDeliveryBoy details by filling all field");
		}
	}
