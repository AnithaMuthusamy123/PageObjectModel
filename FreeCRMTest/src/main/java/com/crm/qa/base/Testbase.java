package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;


	public Testbase()
	{
		prop=new  Properties();
		FileInputStream inp = null;
		try {
			inp = new FileInputStream("/Users/muralisubramani/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(inp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void initialization() {
		 String browserName=prop.getProperty("browser");
		 if(browserName.contentEquals("chrome"))
		 {
			   System.setProperty("WebDriver.chrome.driver", "/Users/muralisubramani/Desktop/SeleniumWebDrivers/chromedriver");

				driver= new ChromeDriver();


		 }
		 e_driver=new EventFiringWebDriver(driver);
		 eventListener=new WebEventListener();
		 e_driver.register(eventListener);
		 driver=e_driver;


		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		 driver.get(prop.getProperty("Url"));
		 wait= new WebDriverWait(driver,30);


	}

}
