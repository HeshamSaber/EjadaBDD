Feature: User want to purchase highest price 2 products

  Scenario: purchase highest price 2 products
    Given I am on the login page
    And I logged in to Homepage
    And I add the highest price 2 products to cart
    And I validate the order is correctly at the cart
    And I click on the Proceed to checkout button
    And I fill requested info at the checkout page
    And I click on the Proceed to checkout overview button
    And I validate the order is correctly at the checkout overview page
    And I click on the Proceed to finish button
    Then I can validate the order
