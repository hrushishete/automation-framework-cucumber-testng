package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By cartIcon=By.xpath("//a[@class='cart-icon']");
	By checkOutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By applyButton=By.xpath("//button[contains(text(),'Apply')]");
	By placeOrder=By.xpath("//button[contains(text(),'Place Order')]");
	By enterPromoCode=By.className("promoCode");
	By checkoutProductName=By.className("product-name");
	
	public void cartClick()
	{
		driver.findElement(cartIcon).click();
	}
	
	public void checkOutClick()
	{
		driver.findElement(checkOutButton).click();
	}
	
	public String getProductName()
	{
		return driver.findElement(checkoutProductName).getText();
	}
	
	public void applyButtonClick()
	{
		driver.findElement(applyButton).click();
	}
	
	public void placeOrderClick()
	{
		driver.findElement(placeOrder).click();
	}
	
	public void enterPromo(String promo)
	{
		driver.findElement(enterPromoCode).sendKeys(promo);
	}
	
}
