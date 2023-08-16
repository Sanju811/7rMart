package com.obsqura.rMart.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuSelectionPage 
{
    public WebDriver driver;
	
	public MenuSelectionPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll(@FindBy(xpath = "//nav[@class='mt-2']//p")) List<WebElement> menuList;
	@FindBy(xpath = "//li[@class='nav-item']//p[text() ='Dashboard']") private WebElement dashBoard;
	@FindBy(xpath = "//i[contains(@class,'fa-shopping-basket')]") private WebElement manageOrders;
	@FindBy(xpath = "//li[@class='nav-item']//p[text() ='groceries']") private WebElement groceries;
	@FindBy(xpath = "//i[contains(@class,'fa-money-bill-alt')]") private WebElement manageExpense;
	@FindBy(xpath = "(//i[contains(@class,'fa-circle')])[2]") private WebElement expenseCategorySubMenu;
	@FindBy(xpath = "(//i[contains(@class,'fa-circle')])[3]") private WebElement manageExpenseSubMenu;
	@FindBy(xpath = "//i[contains(@class,'fa-tasks')]") private WebElement manageProduct;
	@FindBy(xpath = "//i[contains(@class,'fa-user-check')]") private WebElement verifyUsers;
	@FindBy(xpath = "(//i[contains(@class,'fa-angle-left')])[3]") private WebElement manageUsers;
	@FindBy(xpath = "//i[contains(@class,'fa-bell')]") private WebElement pushNotification;
	@FindBy(xpath = "//a[@class='nav-link']//i[contains(@class,'fa-edit')]") private WebElement manageContent;
	@FindBy(xpath = "//i[contains(@class,'fa-map-marker')]") private WebElement manageLocation;
	@FindBy(xpath = "//i[contains(@class,'window-restore')]") private WebElement manageSlider;
	@FindBy(xpath = "//i[contains(@class,'window-minimize')]") private WebElement mobileSlider;
	@FindBy(xpath = "//i[contains(@class,'list-alt')]") private WebElement manageCategory;
	@FindBy(xpath = "(//i[contains(@class,'fa-circle')])[13]") private WebElement categorySubMenu;
	@FindBy(xpath = "//i[contains(@class,'fa-cubes')]") private WebElement manageOfferCode;
	@FindBy(xpath = "//i[contains(@class,'user-plus')]") private WebElement manageDeliveryBoy;
	@FindBy(xpath = "//i[contains(@class,'credit-card')]") private WebElement managePaymentMethod;
	@FindBy(xpath = "//i[contains(@class,'fa-users')]") private WebElement adminUsers;
	@FindBy(xpath = "//i[contains(@class,'sidebar-item-icon')]") private WebElement settings;
	
	
	public MenuSelectionPage clickOnDashBoard()
	{
		dashBoard.click();
		return this;
	}
	public MenuSelectionPage clickOnManageOrders()
	{
		manageOrders.click();
		return this;
	}
	public MenuSelectionPage clickOnGroceries()
	{
		groceries.click();
		return this;
	}
	public MenuSelectionPage clickOnManageExpense()
	{
		manageExpense.click();
		return this;
	}
	public MenuSelectionPage clickOnExpenseCategorySubMenu()
	{
		expenseCategorySubMenu.click();
		return this;
	}
	public MenuSelectionPage clickOnSubMenuManageExpense()
	{
		manageExpenseSubMenu.click();
		return this;
	}
	public MenuSelectionPage clickOnManageProduct()
	{
		manageProduct.click();
		return this;
	}
	public MenuSelectionPage clickOnVerifyUsers()
	{
		verifyUsers.click();
		return this;
	}
	public MenuSelectionPage clickOnManageUsers()
	{
		manageUsers.click();
		return this;
	}
	public MenuSelectionPage clickOnPushNotification()
	{
		pushNotification.click();
		return this;
	}
	public MenuSelectionPage clickOnManageContent()
	{
		manageContent.click();
		return this;
	}
	public MenuSelectionPage clickOnManageLocation()
	{
		manageLocation.click();
		return this;
	}
	public MenuSelectionPage clickOnManageSlider()
	{
		manageSlider.click();
		return this;
	}
	public MenuSelectionPage clickOnMobileSlider()
	{
		mobileSlider.click();
		return this;
	}
	public MenuSelectionPage clickOnManageCategory()
	{
		manageCategory.click();
		return this;
	}
	public MenuSelectionPage clickOnCategorySubMenuOfManageCategory()
	{
		JavascriptExecutor j = (JavascriptExecutor)driver; j.executeScript("scroll(0,500)");
		categorySubMenu.click();
		return this;
	}
	public MenuSelectionPage clickOnManageOfferCode() 
	{
		manageOfferCode.click();
		return this;
	}
	public MenuSelectionPage clickOnManageDeliveryBoy()
	{
		manageDeliveryBoy.click();
		return this;
	}
	public MenuSelectionPage clickOnManagePaymentMethod()
	{
		managePaymentMethod.click();
		return this;
	}
	public MenuSelectionPage clickOnAdminUsers() 
	{
		adminUsers.click();
		return this;
	}
	public MenuSelectionPage clickOnSettings()
	{
		settings.click();
		return this;
	}

}
