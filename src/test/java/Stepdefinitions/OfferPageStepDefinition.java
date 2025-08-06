package Stepdefinitions;

import org.testng.Assert;

import PageObjects.OfferPage;
import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

public TestContextSetup testContextSetup;
public OfferPage offerPage;
public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
	offerPage=testContextSetup.pageObjectManager.getOfferPage();
}
	
	
	@Then("^user search for (.+) shortname in offers page$")
	public void user_search_for_shortname_in_offers_page(String product) throws InterruptedException {
		
		offerPage.topDealsClick();
		testContextSetup.genericUtils.windowSwitch();
		
		offerPage.searchIteam(product);
	    Thread.sleep(2000);
	    
	    testContextSetup.offerPageProducatName=offerPage.getProductName();
	    System.out.println(testContextSetup.offerPageProducatName+" offer page product name");
	}
	
	
	@Then("validate same product name in product page and offer page")
	public void validate_same_product_name_in_product_page_and_offer_page() {
		Assert.assertEquals(testContextSetup.landingPageProductName, testContextSetup.offerPageProducatName);
	}
}
