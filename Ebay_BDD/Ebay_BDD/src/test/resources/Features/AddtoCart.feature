Feature: check user is able to add item in the cart
Scenario: User adding item to cart
Given ebay home page is open in the default browser
When User serach item in the serachbox
And new window opens and user clicks on add to cart button
Then User able to add item to cart