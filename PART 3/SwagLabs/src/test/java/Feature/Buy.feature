@buy
Feature: SwagLabs Buy Function


  Scenario: Test Buy PopUp Window
    Given b-User is into cart
    When b-User clicks Checkout
    Then b-User Gets page For Details

  Scenario Outline: Test online Payment Function
    Given b-User is on cart and Clicks checkout
    When b-User Enters <firstName> <lastName> <zipCode>
    And b-User Clicks Purchase
    Then b-Validate successful purchase
    Examples:
      |firstName|lastName|zipCode|
      |Rishab|Shetty|123456|
      |Alex|fern|212444|


  Scenario Outline: Test Buy Function with invalid data
    Given b-User is on cart and Clicks checkout
    When b-User Enters <firstName> <lastName> <zipCode>
    And b-User Clicks Purchase
    Then b-validate unsuccessful purchase
    Examples:
      |firstName|lastName|zipCode|
      |213|Shetty|123456|
      |Alex||WQE|
