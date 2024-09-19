Feature: Place the order for products
@PlaceOrder
Scenario Outline: Search experience for product search in Home page and Offers page

Given User is on Greenkart landing page
When user searched with shortname <Name> and extracted actual name of product
And added "3" items of selected product to the cart
Then user proceeds to checkout page & validate the <Name> items in checkout page 
And user has entered the promo code and placed the order

Examples:
| Name |
| Tom |