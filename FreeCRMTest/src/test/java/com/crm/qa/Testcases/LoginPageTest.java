package com.crm.qa.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.WelcomePage;
public class LoginPageTest extends Testbase{
	LoginPage LoginPage;
	HomePage HomePage;
	WelcomePage WelcomePage;
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		LoginPage=new LoginPage();
		HomePage=new HomePage();
        WelcomePage=new WelcomePage();
        WelcomePage.logInClick();

	}

	@Test
	public void LogInValidation()
	{
		HomePage = LoginPage.LoginValidate(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void TearDown()
	{
	}



}
