package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class GooglePage extends Testbase{

	//Object factory
	@FindBy(xpath="//input[@class='gLFyf gsfi']")
	WebElement GSearch;

	@FindBy(xpath="//input[@value='Google Search']")
	WebElement GSearchBtn;

	public GooglePage()
	{
		PageFactory.initElements(driver, this);
	}
	public void SearchText(String Text)
	{
		GSearch.sendKeys(Text);
		GSearchBtn.click();

	}
}
