
Feature: Product list functionality

  @Products @Regression
  Scenario: User verifies dresses page and product amount

    Given Navigate to Homepage
    When Click on the element in the DialogContent
      | homepageSignInButton |
    And Enter e-mail "alicabbar1234@gmail.com" and password "alicabbar123" then click sign in button
    Then User should login successfully

    When Click on the element in the DialogContent
      | dressesButton1 |
    Then User verifies dresses page
    And User verifies product amount in the menu
    And User verifies items numbers
    And User verifies number of product list of the Dresses menu








