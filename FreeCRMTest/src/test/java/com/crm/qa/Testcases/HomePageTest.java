package com.crm.qa.Testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.CalenderPage;
//import com.crm.qa.pages.CommentsPage;
//import com.crm.qa.pages.FilePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.pages.MoneyPage;
//import com.crm.qa.pages.PhonePage;
//import com.crm.qa.pages.TaskIconPage;
////import com.crm.qa.pages.UsersPage;
import com.crm.qa.pages.WelcomePage;

public class HomePageTest extends Testbase{

	LoginPage LoginPage;
	HomePage HomePage;
	WelcomePage WelcomePage;
	CalenderPage CalenderPage;
	//CommentsPage commentsPage;
//	UsersPage UsersPage;
//	MoneyPage MoneyPage;
//	TaskIconPage TaskIconPage;
//	PhonePage PhonePage;
//	FilePage FilePage;


	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
        WelcomePage = new WelcomePage();
        LoginPage=new LoginPage();
        CalenderPage=new CalenderPage();
        WelcomePage.ValidateTitle();
        WelcomePage.logInClick();
        HomePage=LoginPage.LoginValidate(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void ValidateHomePageTitleTest()
	{

		String  HomePageTitle=HomePage.ValidatePageTitle();
		Assert.assertEquals(HomePageTitle,"Cogmento CRM","This is not Home page ");

	}
	@Test
	public void VerifyUserName()
	{
		Assert.assertTrue(HomePage.DisplayNameValidate());
	}
	@Test
	public void CalenderIconClickTest()
	{
		//driver.switchTo().frame(Calender))
		//wait.until(ExpectedConditions.visibilityOf(CalenderIcon));
		CalenderPage=HomePage.CalenderIconClick();
	}
	@AfterMethod
	public void TearDown()
	{
		//driver.quit();
	}
	}

