@login
Feature: To validate Login functionality of LIMS

  Background: 
    Given User in Login page

  Scenario: Validating the Login page with invalid username and invalid password
    When User enters invalid username and invalid password
    Then Verifying toast message Invalid username and Invalid password

  Scenario: Validating the Login page with valid username and invalid password
    When User enters valid username and invalid password
    Then Verifying toast message Invalid username and Invalid password

  Scenario: Validating the Login page with invalid username and valid password
    When User enters invalid username and valid password
    Then Verifying toast message Invalid username and Invalid password

  Scenario: Validating the Login page with empty username and valid password
    When User enters empty username and valid password
    Then Verifying toast message Enter the username

  Scenario: Validating the Login page with empty username and invalid password
    When User enters empty username and invalid password
    Then Verifying toast message Enter the username

  Scenario: Validating the Login page with valid username and empty password
    When User enters valid username and empty password
    Then Verifying toast message Enter the password

  Scenario: Validating the Login page with invalid username and empty password
    When User enters invalid username and empty password
    Then Verifying toast message Enter the password

  Scenario: Validating the Login page with empty username and empty password
    When User enters empty username and empty password
    Then Verifying toast message Enter the username

  Scenario: Validating the Login page with valid username and valid password
    When User enters valid username and valid password
    And User confirming that he is home page

  Scenario: Validating the Logout of Lims application
    When User enters valid username and valid password
    And User confirming that he is home page
    And User tring to close the browser and validating the popup
    And User clicks cancel button
    And User clicks Leave button

  Scenario: Validating the logout of LIMS application with one user and logging in with another user
    When User enters valid username and valid password
    And User confirming that he is home page
    And User should logout from app
    And User enters another valid username and password
    And User confirming that he is home page

  @12
  Scenario: Validating the logout of LIMS application as a user with LIMS user role  in multiple tabs.
    When User enters valid username and valid password
    And User opens another tab
    And User in Login page
    And User again enters valid username and valid password
    And User should logout from app
    And User again goes to first tab
    And User clicks some options and Verify user is logged out

  @13
  Scenario: Validating the logout of LIMS application as two different users in same window.
    When User enters valid username and valid password
    And User opens another tab
    And User in Login page
    And User enters another valid username and password
    And User should logout from app
    And User again goes to first tab
    And User clicks some options and Validate user is not logged out

  @14
  Scenario: Validating the logout of LIMS application as same users in multiple windows.
    When User enters valid username and valid password
    And User opens another WINDOW
    And User in Login page
    And User again enters valid username and valid password
    And User should logout from app
    And User again goes to first WINDOW
    And User clicks some options and Verify user is logged out

  @15
  Scenario: Validating the logout of LIMS application as two different users in multiple windows.
    When User enters valid username and valid password
    And User opens another WINDOW
    And User in Login page
    And User enters another valid username and password
    And User should logout from app
    And User again goes to first WINDOW
    And User clicks some options and Validate user is not logged out
