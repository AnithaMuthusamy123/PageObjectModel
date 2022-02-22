package com.crm.qa.Testcases;

/*import com.crm.qa.pages.CommentsPage;
import com.crm.qa.pages.MoneyPage;

import org.openqa.selenium.support.ui.ExpectedConditions;*/
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.CreateNewEventPage;
//import com.crm.qa.pages.PhonePage;
//import com.crm.qa.pages.FilePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.pages.TaskIconPage;
//import com.crm.qa.pages.UsersPage;
import com.crm.qa.pages.WelcomePage;


public class CalenderPageTest extends Testbase{

	CalenderPage CalenderPage;
	WelcomePage WelcomePage;
	LoginPage LoginPage;
	HomePage HomePage;
	CreateNewEventPage CreateNewEventPage;

public CalenderPageTest()
{
	super();
}

@BeforeMethod()
public void setUp()
{
	initialization();
	CalenderPage =new CalenderPage();
	CreateNewEventPage=new CreateNewEventPage();
	 WelcomePage = new WelcomePage();
     LoginPage=new LoginPage();
     WelcomePage.ValidateTitle();
     WelcomePage.logInClick();
     HomePage=LoginPage.LoginValidate(prop.getProperty("username"), prop.getProperty("password"));
     CalenderPage=HomePage.CalenderIconClick();



}

@Test(priority=2)
public void CalenderPageValidationTest()
{
	String CalenderPageTitle =CalenderPage.CalenderPageValidate();
	Assert.assertEquals(CalenderPageTitle,"Cogmento CRM");


}

@Test(priority=1)
public void CalenderCreateBtnTest()
{

CreateNewEventPage=CalenderPage.ClickCreateCalenderBtn();

}
@AfterMethod
public void TearDown()
{

}



}


