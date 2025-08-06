package Stepdefinitions;

import org.testng.Assert;

import PageObjects.CheckoutPage;
import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition 
{
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("user proceeds to checkout and validate the Tom items in checkout page")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page() throws InterruptedException {
		Thread.sleep(2000);
		checkoutPage.cartClick();
		checkoutPage.checkOutClick();
		testContextSetup.checkoutProductName=checkoutPage.getProductName().split(" ")[0];
		System.out.println(testContextSetup.checkoutProductName+" checkout page product name");
		Assert.assertEquals(testContextSetup.landingPageProductName, testContextSetup.checkoutProductName);
	}
	
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		checkoutPage.enterPromo("hrushi");
		checkoutPage.applyButtonClick();
		checkoutPage.placeOrderClick();
	}
}
