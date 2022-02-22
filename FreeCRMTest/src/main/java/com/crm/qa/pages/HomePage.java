package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.Testbase;

public class HomePage extends Testbase{

	//Page Repository-OR
	@FindBy(xpath="//div[@class='right menu']//span")
	WebElement DisplayName;

	@FindBy(xpath="//div[@id='main-nav']//child::div[2]//a//i")
	WebElement CalenderIcon;

	@FindBy(xpath="//div[@id='main-nav']//child::div[3]//a//i")
	WebElement UsersIcon;


	@FindBy(xpath="//div[@id='main-nav']//child::div[4]//a//i")
	WebElement BuildingIcon;

	@FindBy(xpath="//div[@id='main-nav']//child::div[5]//a//i")
	WebElement moneyIcon;

	@FindBy(xpath="//div[@id='main-nav']//child::div[6]//a//i")
	WebElement TaskIcon;

	@FindBy(xpath="//div[@id='main-nav']//child::div[7]//a//i")
	WebElement CommentsIcon;

	@FindBy(xpath="//div[@id='main-nav']//child::div[8]//a//i")
	WebElement PhoneIcon;

	@FindBy(xpath="//div[@id='main-nav']//child::div[9]//a//i")
	WebElement FileIcon;

	//Initilizing the object
	public HomePage()
	{
		PageFactory.initElements(driver,this);

	}
	public boolean DisplayNameValidate()
	{
	return DisplayName.isDisplayed();

	}
	public String ValidatePageTitle()
	{
		String title = driver.getTitle();
		return title ;

	}

	public CalenderPage CalenderIconClick()
	{
		wait.until(ExpectedConditions.visibilityOf(CalenderIcon));
		CalenderIcon.click();
		return new CalenderPage();
	}
/*	public UsersPage UsersIconClick()
	{
		UsersIcon.click();
		return new UsersPage();
	}
	public BuildingPage BuildingIconClick()
	{
		BuildingIcon.click();
		return new BuildingPage();
	}
	public MoneyPage MoneyIconClick()
	{
		moneyIcon.click();
		return new MoneyPage();
	}
	public TaskIconPage TaskIconClick()
	{
		TaskIcon.click();
		return new TaskIconPage();
	}
	public CommentsPage CommentsIconClick()
	{
		CommentsIcon.click();
		return new CommentsPage();
	}
	public PhonePage PhoneIconClick()
	{
		PhoneIcon.click();
		return new PhonePage();
	}
	public FilePage FileIconClick()
	{
		FileIcon.click();
		return new FilePage();
	}
*/

}
