package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContextSetup {
	public String landingPageProductName;
	public String offerPageProducatName;
	public String checkoutProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException
	{
		testBase=new TestBase();
		pageObjectManager=new PageObjectManager(testBase.webDriverManager());
		genericUtils=new GenericUtils(testBase.webDriverManager());
		
	}
}
