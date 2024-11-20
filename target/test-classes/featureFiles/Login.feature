Feature: Login functionality

  @Sanity @Regression @Master
  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters email address "<email>" into email field
    And User enters password "<pass>" into password field
    And User clicks on Login button
    Then User should get successfully logged in
    And User should logout

    Examples: 
      | email                     | pass       |
      | ravindrann10898@gmail.com | Test@12345 |
      | ravikn@yopmail.com        | Test@12345 |

  @Sanity @Regression @Master
  Scenario Outline: Login with invalid credentials
    Given User navigates to login page
    When User enters email address "<email>" into email field
    And User enters password "<pass>" into password field
    And User clicks on Login button
    Then User should not get successfully logged in

    Examples: 
      | email                  | pass      |
      | ravindn10898@gmail.com | Test@1345 |
      | ravik23n@yopmail.com   | Test@145  |
