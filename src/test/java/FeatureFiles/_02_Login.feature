
Feature: Login functionality

  @Accounts @Smoke @Regression
  Scenario Outline: Login with invalid email and password
    Given Navigate to Homepage
    When Click on the element in the DialogContent
      | homepageSignInButton |
    And Enter e-mail as "<email>" and password as "<password>" then click sign in button
    Then User fails to login
    Examples:
      | email                    | password  |
      |                          |           |
      | sleconte0@whitehouse.gov |           |
      |                          | fE9+qySfu |
      | zwalklot2@irs.gov        | vM0.X/fyp |

  @Accounts @Smoke @Regression
  Scenario: Login with valid email and password

    Given Navigate to Homepage
    When Click on the element in the DialogContent
      | homepageSignInButton |
    And Enter e-mail "velicabbar2@gmail.com" and password "velicabbar1234" then click sign in button
