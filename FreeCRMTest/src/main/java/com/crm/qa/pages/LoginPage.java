package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.Testbase;

public class LoginPage extends Testbase{

	//Page Factory -OR
	@FindBy(name="email")
	WebElement username;


	@FindBy(name="password")
WebElement password;

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement LoginBtn;

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public HomePage LoginValidate(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn=wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn.click();
		return new HomePage();

}
}
