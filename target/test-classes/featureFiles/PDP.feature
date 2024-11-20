Feature: PDP verification functionality

  Scenario: User verifies the product display page thumbnails
    Given User opens the Application
    When User enters valid product "iMac" into Search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results
    When User clicks on product image
    Then User should get thumbnail images

    
 Scenario: User verifies the pdp details of the product
   Given User opens the Application
    When User enters valid product "iMac" into Search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results
    When User clicks on product image
    Then User should get product related details
 