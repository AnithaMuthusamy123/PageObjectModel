package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.Testbase;

public class CreateNewEventPage  extends Testbase{


		@FindBy(xpath="//div[contains(@class,'ui right corner')]//input")
	    WebElement Title;

	@FindBy(xpath="//textarea[@name='description']")
		WebElement Description;

		@FindBy(xpath="//div[@class='item']//child::button[2]//i")
		WebElement SaveBtn;

		//@FindBy

		public CreateNewEventPage()
		{
			PageFactory.initElements(driver, this);
		}





     public void CreateNewEvent(String EventTitle,String EventDescription)
		{
    	 Title.sendKeys(EventTitle);
       // Select select=new Select(Category);
        // select.selectByVisibleText(EventCategory);
    	Description.sendKeys(EventDescription);
         wait.until(ExpectedConditions.visibilityOf(SaveBtn));
         SaveBtn.click();

       }
}