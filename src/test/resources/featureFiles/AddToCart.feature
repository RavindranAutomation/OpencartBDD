Feature: Add to cart functionality

  Scenario: User adding product into cart from search results page
    Given User opens the Application
    When User enters valid product "iMac" into Search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results
    When User clicks on Add to cart button
    Then User should see "Success: You have added iMac to your shopping cart!" message
    When User clicks on CartButton
    Then User should see added product in the popup