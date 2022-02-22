package com.crm.qa.Testcases;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.CreateNewEventPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.WelcomePage;
import com.crm.qa.util.TestUtil;

public class CreateNewEventTest extends Testbase {
	LoginPage LoginPage;
	HomePage HomePage;
	WelcomePage WelcomePage;
	CalenderPage CalenderPage;
	CreateNewEventPage CreateNewEventPage;
	TestUtil TestUtil;
	 String SheetName = "EventCalender";
//	 ReadObject object=new ReadObject();
	public CreateNewEventTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		TestUtil=new TestUtil();
		LoginPage=new LoginPage();
		HomePage=new HomePage();
		WelcomePage=new WelcomePage();
		CalenderPage=new CalenderPage();
		CreateNewEventPage=new CreateNewEventPage();
		WelcomePage.ValidateTitle();
        WelcomePage.logInClick();
        HomePage=LoginPage.LoginValidate(prop.getProperty("username"), prop.getProperty("password"));
        CalenderPage=HomePage.CalenderIconClick();
        CreateNewEventPage=CalenderPage.ClickCreateCalenderBtn();


	}
	@SuppressWarnings("resource")
	@DataProvider(name="Hybrid Data")
	public Object[][] getCRMTestData() throws IOException
	{
		Object[][] Object=com.crm.qa.util.TestUtil.getTestData(SheetName);
		return Object;
	}
	/*	File file=new File();
		FileInputStream InputStream=new FileInputStream("/Users/muralisubramani/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/testdata/EventCalender.xlsx");
		XSSFWorkbook CRMWorkbook=null;
		CRMWorkbook =new XSSFWorkbook(InputStream);
		XSSFSheet CRMSheet = CRMWorkbook.getSheet(SheetName);
		int rowCount=CRMSheet.getLastRowNum()-CRMSheet.getFirstRowNum();
		Object=new Object[rowCount][3];
		 for (int i = 0; i < rowCount; i++) {
		        //Loop over all the rows
		        XSSFRow row = CRMSheet.getRow(i+1);
		        //Create a loop to print cell values in a row
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		            //Print excel data in console
		            Object[i][j] = row.getCell(j).toString();

		        }
		 }
		 return Object;
	}
		/*XSSFCell data=null;
		try {
			data = TestUtil.getTestData(SheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;*/

	@Test(dataProvider="Hybrid Data")
	public void CreateNewEventPageTest(String Title,String Description)
	{
		//CreateNewEventPage.CreateNewEvent("Automation","Use this opportunity");
		CreateNewEventPage.CreateNewEvent(Title,Description);
	}
	@AfterMethod
	public void TearDown()
	{

	}
}

