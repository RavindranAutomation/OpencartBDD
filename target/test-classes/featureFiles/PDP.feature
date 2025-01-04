Feature: PDP verification functionality


  @Regression @Master
  Scenario: User verifies the pdp details of the product
    Given User opens the Application
    When User enters valid product "iMac" into Search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results
    When User clicks on product image
    Then User should get product related details
