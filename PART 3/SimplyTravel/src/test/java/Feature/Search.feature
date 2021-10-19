@search
Feature: SimplyTravel Search Functionality


  Scenario: To validate that user can sort flights by Price Low to High category
    Given  User is on homepage
    When User selects Price Low to High category
    Then  User should be able to successfully sort flights by Price Low to High category


  Scenario: To validate that user can sort flights by Duration Low to High category
    Given  User is on homepage
    When User selects Duration Low to High category
    Then  User should be able to successfully sort flights by Duration Low to High category


  Scenario: To validate that user can sort flights by Departure Early category
    Given  User is on homepage
    When User selects Departure Early category
    Then  User should be able to successfully sort flights by Departure Early category

  Scenario: To validate that user can sort flights by Departure Delay category
    Given  User is on homepage
    When User selects Departure Delay category
    Then  User should be able to successfully sort flights by Departure Delay category

  Scenario: To validate that user can sort flights by Arrival Early category
    Given  User is on homepage
    When User selects Departure Arrival Early category
    Then  User should be able to successfully sort flights by Arrival Early category

  Scenario: To validate that user can sort flights by Arrival Delay category
    Given  User is on homepage
    When User selects Departure Arrival Delay category
    Then  User should be able to successfully sort flights by Arrival Delay category

  Scenario: To validate that user can search flights
    Given  User is on homepage
    When User selects Departure and Arrival location category
    Then  User should be able to successfully search flights

