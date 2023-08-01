package com.obsqura.rMart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class MobileSliderPage 
{
	 public WebDriver driver;
		
		public MobileSliderPage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
		@FindBy (xpath = "//select[@id='cat_id']")private WebElement categorySelectDropDown;
		@FindBy (xpath = "//input[@id='main_img']") private WebElement chooseFileButton;
		@FindBy (xpath = "//button[@type='submit']") private WebElement saveButton;
		@FindBy (xpath = "//i[@class='icon fas fa-check']") private WebElement alertMessage;
				
		public MobileSliderPage clickOnNewButton()
		{
			newButton.click();
			return this;
		}
		public MobileSliderPage clickOnCategorySelectDropDown()
		{
			categorySelectDropDown.click();
			return this;
		}		
		public MobileSliderPage selectTextFromCategoryDropDown()
		{
			PageUtility pageUtility = new PageUtility();
			pageUtility.selectDropdownbyText(categorySelectDropDown,ExcelUtility.getString(0, 0,"MobileSlider"));
			return this;
		}
		
		public MobileSliderPage clickOnChooseFileAndUploadFile()
		{
			FileUploadUtility fileUploadUtility = new FileUploadUtility();
			fileUploadUtility.fileUploadUsingSendKeys(chooseFileButton,GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
			return this;
		}
		public MobileSliderPage clickOnSaveButton()
		{
			WaitUtility waitUtility = new WaitUtility();
			waitUtility.waitForElementClickable(driver, saveButton);
			saveButton.click();
			return this;
		}
		
		public boolean isSuccessAlertMessageDisplayed()
		{
			return alertMessage.isDisplayed();
		}
}
