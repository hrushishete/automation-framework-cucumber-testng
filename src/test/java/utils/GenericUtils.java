package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericUtils {

	WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void windowSwitch()
	{
		Set<String> set1=driver.getWindowHandles();
	    Iterator<String> it1=set1.iterator();
	    String paraentWindow=it1.next();
	    String childWindow=it1.next();
	    driver.switchTo().window(childWindow);
	}
	
	public File takesScreenShot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}

}
