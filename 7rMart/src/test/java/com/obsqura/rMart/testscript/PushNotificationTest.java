package com.obsqura.rMart.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rMart.pages.LoginPage;
import com.obsqura.rMart.pages.MenuSelectionPage;
import com.obsqura.rMart.pages.PushNotificationPage;
import retry.Retry;
import utilities.ExcelUtility;

public class PushNotificationTest extends Base
{
	@Test(retryAnalyzer = Retry.class,description="Verify user is able to send Push Notification")
	public void verifyUserIsAbleToSendNotification()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnPushNotification();		
		PushNotificationPage pushNotificationPage = new PushNotificationPage(driver);
		pushNotificationPage.enterTitle().enterDescripiton().clickOnSaveButton();
		assertTrue(pushNotificationPage.isAlertDisplayed(), "User not able to send notification");
	}

}