@register
Feature: SimplyTravel Registration Functionality

  Scenario: To validate the successful Navigation to SimplyTravel Signup page
    Given r-User enters SimplyTravel url
    Then r-User should be able to navigate to url successfully

  Scenario Outline: Test Signup Functionality
    Given r-User is on Signup Page
    When r-User enters <fullname> <email> <phoneNo> <address> <password> <cpassword>
    And r-User clicks on Signup Button
    Then r-User should be able to Register successfully
    Examples:
      |fullname|email|phoneNo|address|password|cpassword|
      |test12344|test123344@m.com|1233123456|asd44|asd44|asd44|
      |abc12344|abc123443@p.com|12123123456|sadd44|qwe44|qwe44|
