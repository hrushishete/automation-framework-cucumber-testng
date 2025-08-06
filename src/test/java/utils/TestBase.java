package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase 
{
	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String propBrowser=prop.getProperty("driver");
		String sysBrowser=System.getProperty("browser");
		
		String browser= sysBrowser!=null ? sysBrowser : propBrowser;
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}

			driver.get(prop.getProperty("QAurl"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
			return driver;
	}
}
