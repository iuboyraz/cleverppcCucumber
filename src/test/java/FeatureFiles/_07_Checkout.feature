
Feature: Checkout functionality

  @Products @Checkout @Payment @Smoke @Regression
  Scenario: User checkouts the cart, shipment and payment processes.

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
    And User validates if the total product prices are the same with the total products amount
    And User validates if the shipping price is 7 Usd
    And User validates if the total price with the shipping is the same in total
    And User validates if the total price with the shipping plus tax is the same with the tax included total
    And User verifies delivery and invoice addresses
    When Click on the element in the DialogContent
      | checkoutButton1 |
      | checkoutButton2 |
    And User verifies shipment method
    When Click on the element in the DialogContent
      | checkoutButton3 |
    Then User should verify terms of service checkbox message and close message
    When Click on the element in the DialogContent
      | termsOfServiceCheckBox |
    When Click on the element in the DialogContent
      | checkoutButton3 |
    When Click on the element in the DialogContent
      | payPal |
    Then User should verify PayPal message
    And Navigate to back page
    When Click on the element in the DialogContent
      | payWithCreditCard |
    Then User should verify pay with credit card message
    And Navigate to back page
    When Click on the element in the DialogContent
      | payByBankWire |
    Then User should verify bank wire payment message
    And User validates if the total price plus the shipping plus the tax is the same with the bank wire total payment
    When Click on the element in the DialogContent
      | confirmMyOrderButton |
    Then User should verify order is comleted message
    And User should verify order reference message
    When Click on the element in the DialogContent
      | viewYourOrderHistoryButton |
    Then User saves order reference



















