package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	WebDriver driver;
	
	public OfferPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By topDeals=By.linkText("Top Deals");
	private By searchBox=By.id("search-field");
	private By productName=By.xpath("(//tbody/tr/td)[1]");
	
	public void topDealsClick()
	{
		driver.findElement(topDeals).click();
	}
	
	public void searchIteam(String product)
	{
		driver.findElement(searchBox).sendKeys(product);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
}
