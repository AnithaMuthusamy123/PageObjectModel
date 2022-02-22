package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.Testbase;

public class WelcomePage extends Testbase{

	//Pagefactory-OR
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement LogInBtn;

	@FindBy(xpath="//a[@href='https://register.freecrm.com/register/']//child::span[2]")
	WebElement SignUpBtn;

	//@FindBy()
//initializing the page object
	public WelcomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String ValidateTitle()
	{

		return driver.getTitle();

	}
	public LoginPage logInClick()
	{
		//WebElement w;
		LogInBtn = wait.until(ExpectedConditions.visibilityOf(LogInBtn));
		//w=wait.until(ExceptedConditions.)
		LogInBtn.click();

		return new LoginPage();
	}
	public RegistrationPage SignUpBtn()
	{
		SignUpBtn.click();
		return new RegistrationPage();
	}
}
