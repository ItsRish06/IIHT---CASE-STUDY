@OpenMRS
Feature: MedicalRecordSystem

Scenario: URL should be working
Given user has opened the browser
When user enters the url
Then application login page should open

Scenario: User should be able to login
Given user is on the login page
When user enters username and password 
And selects location
Then user should be able to login

Scenario: Permissions should be according to the location selected
Given user selects particular location 
When clicks on login
Then statement should be displayed logged in as selected location

Scenario: User should be able to find patient records
Given user has logged in 
When user clicks on Find patient Record
Then records should be displayed
And user should be able to search by id or name

Scenario: User should be able to register a patient
Given user clicks on Register a patient
When user enters patient information 
Then patient should be registered



 
