package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By searchBox = By.xpath("//input[@type='search']");
	private By productName = By.className("product-name");
	private By addButton = By.xpath("//a[@class='increment']");
	private By addToCart= By.xpath("//button[contains(text(),'ADD TO CART')]");
	
	public void searchItem(String product)
	{
		driver.findElement(searchBox).sendKeys(product);
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void addButtonClick() {
		driver.findElement(addButton).click();
	}
	
	public void addToCartButtonClick()
	{
		driver.findElement(addToCart).click();
	}
}
