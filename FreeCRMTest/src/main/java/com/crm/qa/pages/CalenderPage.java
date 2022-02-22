package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.Testbase;

public class CalenderPage extends Testbase{


	@FindBy(xpath="//div[@class='ui fluid container']//button[@class='ui linkedin button']//i")
	WebElement CreateCalenderBtn;

	//@FindBy(xpath="//div[contains(@class,'ui header')]")
	//WebElement PageTitle;

	public CalenderPage()
	{
		PageFactory.initElements(driver,this);
	}

	public String CalenderPageValidate()
	{
		wait.until(ExpectedConditions.visibilityOf(CreateCalenderBtn));
		String Title=driver.getTitle();
		return Title;
	}
	public CreateNewEventPage ClickCreateCalenderBtn()
	{
		wait.until(ExpectedConditions.visibilityOf(CreateCalenderBtn));
		CreateCalenderBtn.click();
		//CreateCalenderBtn.click();
		return new CreateNewEventPage();

	}

}
