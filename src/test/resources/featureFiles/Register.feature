Feature: Registration functionality

  @Sanity @Regression @Master
  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register Account page
    When User enters the values in the mandatory fields
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  @Sanity @Regression @Master
  Scenario: User creates a duplicate account
    Given User navigates to Register Account page
    When User enters the details into below fields with duplicate email
      | firstName | Ravi                   |
      | lastName  | Test                   |
      | email     | amotooricap4@gmail.com |
      | telephone |             1234567890 |
      | password  |                  12345 |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User should get a proper warning about duplicate email
