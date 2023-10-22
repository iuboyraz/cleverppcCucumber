
Feature: Register functionality

  @Accounts @Smoke @Regression
  Scenario: Register with empty email
    Given Navigate to Homepage
    When Click on the element in the DialogContent
      | homepageSignInButton |
      | registerCreateButton |
    Then User fails to register and gets invalid email address message

  @Accounts @Smoke @Regression
  Scenario: Register with existing email
    Given Navigate to Homepage
    When Click on the element in the DialogContent
      | homepageSignInButton |
    And Enter e-mail "alicabbar1234@gmail.com" and click create an account button
    Then User fails to register and gets already message

  @Accounts @Smoke @Regression
  Scenario: Register with new email
    Given Navigate to Homepage
    When Click on the element in the DialogContent
      | homepageSignInButton |
    And Enter e-mail "velicabbar2@gmail.com" and click create an account button
    Then User should accesses create an account page successfully
    When Click on the element in the DialogContent
      | registerButton |
    Then User gets error message
    And User sends the keys into the dialog box
      | firstnameInput | Veli |
    When Click on the element in the DialogContent
      | registerButton |
    Then User gets error message
    And User sends the keys into the dialog box
      | firstnameInput | Veli   |
      | lastnameInput  | Cabbar |
    When Click on the element in the DialogContent
      | registerButton |
    Then User gets error message
    And User sends the keys into the dialog box
      | firstnameInput   | Veli   |
      | lastnameInput    | Cabbar |
      | registerPassword | 1234   |
    When Click on the element in the DialogContent
      | registerButton |
    Then User gets error message
    And User sends the keys into the dialog box
      | firstnameInput   | Veli           |
      | lastnameInput    | Cabbar         |
      | registerPassword | velicabbar1234 |
    When Click on the element in the DialogContent
      | registerButton |
    Then User gets account has been created message





