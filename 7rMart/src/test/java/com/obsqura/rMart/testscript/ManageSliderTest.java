package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rMart.pages.LoginPage;
import com.obsqura.rMart.pages.ManageSliderPage;
import com.obsqura.rMart.pages.MenuSelectionPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageSliderTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify user able to add manage slider details by filling all fields")
	public void verifyWhetherTheUserAbleToAddManageSliderDetailsByFillingAllFields()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageSlider();
		ManageSliderPage manageSilderPage = new ManageSliderPage(driver);
		manageSilderPage.clickOnNewButton().uploadFile().enterValueInLinkField().clickOnSaveButton().clickOnCancelButton();
		assertTrue(manageSilderPage.isSliderDetailsAddedInList(), "User not able to add manage slider details by filling all fields");	
	}
}
