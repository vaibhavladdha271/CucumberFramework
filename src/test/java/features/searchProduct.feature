Feature: Search and place the order for Products
@SearchOrder
Scenario Outline: Search experience for product search in Home page and Offers page
Given User is on Greenkart landing page
When user searched with shortname <Name> and extracted actual name of product
Then User searched for <Name> in offers to check if product exists

Examples:
| Name |
| Tom |
| Beet |