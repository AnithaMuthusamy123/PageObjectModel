package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class RegistrationPage extends Testbase{


	@FindBy(xpath="//div[@class='ui input']//child::input[@id='email']")
	WebElement EmailAdress;

	@FindBy(xpath="//div[@class='ui input']//child::input[@id='phone_number']")
	WebElement PhNum;

	@FindBy(xpath="//div[@class='item active selected']")
	WebElement selectCountry;

	@FindBy(xpath="//div[@class='ui checkbox']//child::input[@id='terms']")
	WebElement AgreeChkBx;

	@FindBy(xpath="//div[@class='rc-anchor-center-item rc-anchor-checkbox-holder']//child::span//div[1]")
	WebElement NotRobotChkBox;

	@FindBy(xpath="//div[@class='field']//child::button")
	WebElement SignUpBtn;

	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	public HomePage Registeration(String email,int phno)
	{
		String ph=Integer.toString(phno);
		EmailAdress.sendKeys(email);
		PhNum.sendKeys(ph);

		return new HomePage();
	}
}

