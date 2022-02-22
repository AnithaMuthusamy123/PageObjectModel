package com.crm.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.WelcomePage;

public class WelcomePageTest extends Testbase{
	WelcomePage WelcomePage;
	LoginPage LoginPage;

	public WelcomePageTest()
	{
		super();
	}

@BeforeMethod
public void SetUp()
{
		initialization();
		WelcomePage = new WelcomePage();
		LoginPage =new LoginPage();
}
     @Test(priority=1)
		public void ValidateWelcomePage()
	{

		String title= WelcomePage.ValidateTitle();
		Assert.assertEquals(title,"Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}
     @Test(priority=2)
     public void LogInBtnEnabled()
     {
    	//LoginPage =new LoginPage();

    	LoginPage= WelcomePage.logInClick();

     }
        @AfterMethod
       public void TearDown()
        {
    	 //driver.quit();
     }

}