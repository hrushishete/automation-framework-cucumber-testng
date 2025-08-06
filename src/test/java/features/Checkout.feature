Feature: Place order for product

@test1
Scenario Outline: Place order and verify and checkout

Given User is on GreenCart landing page
When user search with shortname <Name> and extracted actual name of product
And added "3" items of the selected product to cart
Then user proceeds to checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
|Name	|
|Tom	|
