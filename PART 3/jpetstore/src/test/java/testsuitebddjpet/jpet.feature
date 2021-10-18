@Jpet_store_functionalities
Feature: To check Registration,login,search product and add to cart functionality

@Reg1
Scenario Outline: login with valid credantial
Given User is on home page
When User Provides valid <username> <new_pass> <rep_pass> <f_n> <l_N> <email> <phone> <add1> <add2> <city> <state> <zip> <country> credentials
Then Home page will open

Examples:
		|username|   new_pass    |  rep_pass  | f_n |    l_n    |            email           |  phone   |             add1           |        add2                |  city  |    state   |  zip |country|
		| OnkarN |  Onkar@2005   | Onkar@2005 |Onkar|Navindgikar|onkarnavindgikar18@gmail.com|3467185990|2B COURT COLONY VIJAPUR ROAD|2B COURT COLONY VIJAPUR ROAD| Solapur|Maharashtra |413004| India |


@login2
Scenario Outline: login with invalid credentials
When User enters valid <username> and invalid <pass>
Then Error message will display
When User enters invalid <username> and valid <pass>
Then Error message will display
Examples:
		|          username          |    pass   |
		|onkarnavindgikar18@gmail.com|hehehe@2000|
		
@login1
Scenario Outline: login with valid credantial
Given User is on login page
When User Provides valid <username> and <pass> and click box
Then Home page will open of pet

Examples:
		|         username           |   pass   |
		|onkarnavindgikar18@gmail.com|Onkar@2005|
			
			
@search
Scenario Outline: Search pet
Given User is on home page after login 
When User enter type of pet as <type>
Then Product list will display

@cart
Scenario: Show cart
Given User back on home page
When Click on cart
Then Cart is displayed
