@ShoppingTest
Feature: AmazonShoppingTest

@Purchase65inchTV
Scenario Outline: Check that User can purchase a random TV from the search result
Given I am on the Landing screen
Then I tap on the "Sign in" button on Landing screen
Then I should be navigated to the "Welcome" screen
Then I enter the "<Email_Id>" in the text field on Welcome screen
When I tap on the "Continue" button on the Welcome screen
Then I should be navigated to the "Login" screen
Then I enter the "<Password>" in the text field on Login screen
When I tap on the "Login" button on Login screen
Then I should be navigated to the "Home" screen
#Then I enter the"<Product>" in search box
#Then I purchase the random product from list
#When I go to the Checkout screen
#Then I should see the purchased "Product" on Checkout screen

Examples:
|Email_Id     |Password     |Product   |
|Your email id|Your password|65-inch TV|


#Can't perform commented steps as Amazon has disabled buy and add to cart button
