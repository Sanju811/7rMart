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

public class ManageExpensePage 
{
public WebDriver driver;
	
	public ManageExpensePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//select[@name='user_id']") private WebElement userDropDown;
	@FindBy(xpath = "//select[@name='ex_cat']") private WebElement categoryDropDown;
	@FindBy(xpath = "//select[@name='order_id']") private WebElement orderIdDropDown;
	@FindBy(xpath = "//select[@name='purchase_id']") private WebElement purchaseIdDropDown;
	@FindBy(xpath = "//select[@name='ex_type']") private WebElement expenseTypeDropDown;
	@FindBy(xpath = "//input[@name='amount']") private WebElement amountField;
	@FindBy(xpath = "//textarea[@name='remarks']") private WebElement remarksField;
	@FindBy(xpath = "//input[@name='userfile']") private WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	@FindAll(@FindBy(xpath = "//table[contains(@class,'table-bordered')]//td")) private List<WebElement> tableData;

	public ManageExpensePage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageExpensePage selectUser()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(userDropDown, ExcelUtility.getString(0, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage selectCategory()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(categoryDropDown, ExcelUtility.getString(1, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage selectOrderId()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(orderIdDropDown, ExcelUtility.getNumeric(2, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage selectPurchaseId()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(purchaseIdDropDown, ExcelUtility.getNumeric(3, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage selectExpenseType()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(expenseTypeDropDown, ExcelUtility.getString(4, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage enterAmount()
	{
		amountField.sendKeys(ExcelUtility.getNumeric(5, 1, "ManageExpense"));
		return this;
	}
	public ManageExpensePage enterRemarks()
	{
		remarksField.sendKeys(ExcelUtility.getString(6, 1, "ManageExpense"));
		return this;
	}
	public ManageExpensePage uploadFile()
	{
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(chooseFileButton,GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
		return this;
	}
	public ManageExpensePage clickOnSaveButton()
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver, saveButton);
		saveButton.click();
		return this;
	}
	public boolean isExpenseDetailsAdded() throws InterruptedException
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.wait();
		PageUtility pageUtility = new PageUtility();
		boolean isExpenseAddedInList = pageUtility.isListContainsText(tableData, ExcelUtility.getString(1, 1,"ManageExpense"));
		return isExpenseAddedInList;
	}
	

}
