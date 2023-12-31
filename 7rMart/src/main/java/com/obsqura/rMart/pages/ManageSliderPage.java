package com.obsqura.rMart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageSliderPage
{
public WebDriver driver;
	
	public ManageSliderPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='main_img']") private WebElement fileUploadButton;
	@FindBy(xpath = "//input[@id='link']") private WebElement linkField;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	@FindAll(@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td")) private List<WebElement> tableData;
	@FindBy(xpath = "//a[text()='Cancel']") private WebElement cancelButton;
	
	public ManageSliderPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageSliderPage uploadFile()
	{
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(fileUploadButton, GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
		return this;
	}
	public ManageSliderPage enterValueInLinkField()
	{
		linkField.sendKeys(ExcelUtility.getString(0, 0, "ManageSlider"));
		return this;
	}
	public ManageSliderPage clickOnSaveButton()
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,saveButton);
		saveButton.click();
		return this;
	}
	public ManageSliderPage clickOnCancelButton()
	{
		cancelButton.click();
		return this;
	}
	public boolean isSliderDetailsAddedInList()
	{
		PageUtility pageUtility = new PageUtility();
		boolean isSliderAdded = pageUtility.isListContainsText(tableData, ExcelUtility.getString(0, 0, "ManageSlider"));
		return isSliderAdded;
	}


}
