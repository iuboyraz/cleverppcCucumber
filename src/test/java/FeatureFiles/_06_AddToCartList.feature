
Feature: Add to cart list functionality

  @Products @Cart @Regression
  Scenario: User adds randomly 3 dresses into the cart and verifies cart
    Given Navigate to Homepage
    When Click on the element in the DialogContent
      | homepageSignInButton |
    And Enter e-mail "alicabbar1234@gmail.com" and password "alicabbar123" then click sign in button
    Then User should login successfully
    When Click on the element in the DialogContent
      | dressesButton1 |
    Then User verifies dresses page
    And User randomly mouseover three of the products and clicks add to cart button
    When Click on the element in the DialogContent
      | cartButton |
    Then User verifies cart page
    And User verifies cart
    And User verifies product amount in the cart list












