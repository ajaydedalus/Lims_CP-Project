@pr
Feature: CP order entry - PatientRegistration

  Scenario: Quick Registration for new patient
    Given User in Login page
    When User enters valid username and valid password
    And Click on Order Management menu, Click on CP order entry menu
    And User enters all the fields and saves the patient