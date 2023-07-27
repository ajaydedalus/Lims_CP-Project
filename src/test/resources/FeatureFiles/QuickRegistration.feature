@smoke
Feature: CP order entry - Patient search with Lrn

  Scenario: Quick Registration for new patient
    Given User in Login page
    When User enters valid username and valid password
    And Click on Order Management menu, Click on CP order entry menu
    And User searches the patient with clinician name
    
    
    
