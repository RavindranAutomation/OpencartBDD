Feature: Wishlist functionality

  Scenario: Verify wishlist page with search results product
    Given User opens the Application
    When User enters valid product "iMac" into Search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results
    When User clicks on the wishlish page link
    Then User should see the added product from the list
    And User should be clear the wishlist
