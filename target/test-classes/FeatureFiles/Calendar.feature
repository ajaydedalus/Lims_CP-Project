@cal
Feature: Calender 

  Scenario: Quick Registration for new patient
    Given User in Login page
    When User enters valid username and valid password
    And Click on Order Management menu, Click on CP order entry menu
		And Click order details tab and verify the calender