package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rMart.pages.LoginPage;
import com.obsqura.rMart.pages.MenuSelectionPage;
import com.obsqura.rMart.pages.MobileSliderPage;
import retry.Retry;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify user is able to add Slider informations by filling all fields",groups = {"regression"})
	public void verifyUserIsAbleToAddSliderInformationsByFillingAllFields()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnMobileSlider();		
		MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);
		mobileSliderPage.clickOnNewButton().clickOnCategorySelectDropDown().selectTextFromCategoryDropDown().clickOnChooseFileAndUploadFile().clickOnSaveButton();
		assertTrue(mobileSliderPage.isSuccessAlertMessageDisplayed(), "User not able to add Slider informations by filling all fields");
	}
}
