package Stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@After
	public void tearDown() throws IOException
	{
		testContextSetup.testBase.webDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
//			File src=testContextSetup.genericUtils.takesScreenShot();
			File src=((TakesScreenshot) testContextSetup.testBase.webDriverManager() ).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(src);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
