package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rMart.pages.LoginPage;
import com.obsqura.rMart.pages.ManageLocationPage;
import com.obsqura.rMart.pages.MenuSelectionPage;
import utilities.ExcelUtility;
import retry.Retry;

public class ManageLocationTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify User is able to add location by filling all mandatory field")
	public void verifyUserIsAbletoAddLocationByFillingValuesInMandatoryField()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageLocation();
		
		ManageLocationPage manageLocationPage = new ManageLocationPage(driver);
		manageLocationPage.clickOnNewButton().selectContryFromDropDown().selectStateFromDropDown().enterLocation()
		.enterDeliveryCharge().clickOnSaveButton();
		assertTrue(manageLocationPage.isSuccessAlertDisplayed(), "User is not able to add location by filling all mandatory field");
			
	}

}
