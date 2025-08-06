package Stepdefinitions;

import java.io.IOException;

import PageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	public TestContextSetup testContextSetup;
	public LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() throws IOException {
	}

	@When("^user search with shortname (.+) and extracted actual name of product$")
	public void user_search_with_shortname_and_extracted_actual_name_of_product(String product)
			throws InterruptedException {
		
		landingPage.searchItem(product);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split(" ")[0];
		System.out.println(testContextSetup.landingPageProductName + " Landing page product name");
	}
	
	@When("added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String item) {
		int i=Integer.parseInt(item)-1;
		while(i>0)
		{
			landingPage.addButtonClick();
			i--;
		}
		
		landingPage.addToCartButtonClick();
	}

}
