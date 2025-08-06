Feature: Search and place order for product

@test2
Scenario Outline: Search experience for product search in both home and offers page

Given User is on GreenCart landing page
When user search with shortname <Name> and extracted actual name of product
Then user search for <Name> shortname in offers page
And validate same product name in product page and offer page

Examples:
|Name	|
|Tom	|
|Beet	|