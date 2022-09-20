
Feature: 
  To validate Login functionality of LIMS

  Background: 
    Given User in Login page

  Scenario: 1
    
    Validating the Login page with invalid username and invalid password

    When User enters invalid username and invalid password

  Scenario: 2
    
    Validating the Login page with valid username and invalid password

    When User enters valid username and invalid password

  Scenario: 3
        
    Validating the Login page with invalid username and valid password

    When User enters invalid username and valid password

  Scenario: 4
    
    Validating the Login page with empty username and valid password

    When User enters empty username and valid password

  Scenario: 5
    
    Validating the Login page with empty username and invalid password

    When User enters empty username and invalid password

  Scenario: 6
    
    Validating the Login page with valid username and empty password

    When User enters valid username and empty password

  Scenario: 7
    
    Validating the Login page with invalid username and empty password

    When User enters invalid username and empty password

  Scenario: 8
    
    Validating the Login page with empty username and empty password

    When User enters empty username and empty password

  Scenario: 9
    
    Validating the Login page with valid username and valid password

    When User enters valid username and valid password

  Scenario: 10
    
    Validating the Logout of Lims application

    When User enters valid username and valid password
    And User confirming that he is home page
    And User tring to close the browser and validating the popup
    And User clicks cancel button
    And User clicks Leave button
    And User should logout from app

  Scenario: 11
    
    Validating the logout of LIMS application with one user and logging in with another user

    When User enters valid username and valid password
    And User confirming that he is home page
    And User should logout from app
    And User enters another valid username and password
    And User confirming that he is home page

  Scenario: 12
    
    Validating the logout of LIMS application as a user with LIMS user role  in multiple tabs.

    When User enters valid username and valid password
    And User opens another tab
    And User in Login page
    And User again enters valid username and valid password
    And User should logout from app
    And User again goes to first tab
    And User clicks some options

  Scenario: 13
    
    Validating the logout of LIMS application as two different users in same window.

    When User enters valid username and valid password
    And User opens another tab
    And User in Login page
    And User enters another valid username and password
    And User should logout from app
    And User again goes to first tab
    And User clicks some options
    And Validate user is not logged out

  Scenario: 14
    
    Validating the logout of LIMS application as same users in multiple windows.

    When User enters valid username and valid password
    And User opens another WINDOW
    And User in Login page
    And User again enters valid username and valid password
    And User should logout from app
    And User again goes to first WINDOW
    And User clicks some options

  Scenario: 15
    
    Validating the logout of LIMS application as two different users in multiple windows.

    When User enters valid username and valid password
    And User opens another WINDOW
    And User in Login page
    And User enters another valid username and password
    And User should logout from app
    And User again goes to first WINDOW
    And User clicks some options
    Then Validate user is not logged out
