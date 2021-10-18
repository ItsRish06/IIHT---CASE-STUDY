@search
Feature: SwagLabs Search Functionality


  Scenario: To validate that user can filter products by Name (A to Z) category
    Given  User is on homepage
    When User selects Name (A to Z) category
    Then  User should be able to successfully sort products by Name (A to Z) category.


  Scenario: To validate that user can sort products by Name (Z to A) category
    Given  User is on homepage
    When User selects Name (Z to A) category
    Then  User should be able to successfully sort products by Name (Z to A) category.


  Scenario: To validate that user can sort products by Price (low to high) category
    Given  User is on homepage
    When User selects Price (low to high) category
    Then  User should be able to successfully sort products by Price (low to high) category.

  Scenario: To validate that user can sort products by Price (high to low) category
    Given  User is on homepage
    When User selects Price (high to low) category
    Then  User should be able to successfully sort products by Price (high to low) category.

  Scenario: To validate that add to cart button is functional.
    Given  User is on homepage
    When User clicks on a product
    And User clicks on add to cart button
    And  User clicks on cart button
    Then  User should be able to successfully see the product in their cart.
