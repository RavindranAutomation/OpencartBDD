Feature: Checkout functionality

  Scenario: User navigate to Checkout page from shoppingcart page
    Given User opens the Application
    When User enters valid product "iMac" into Search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results
    When User clicks on Add to cart button
    Then User should see "Success: You have added iMac to your shopping cart!" message
    When User clicks shopping cart link from popup message
    Then User should be taken to the Shopping cart page
    And User clicks on the checkout button
    Then User should be taken to the Checkoutpage
