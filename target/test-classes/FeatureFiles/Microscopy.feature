@smoke
Feature: Microscopy

  Scenario: Validating Microscopy screen under Result Management Menu
    Given User in Login page
    When User enters valid username and valid password
    And User selects CP order entry
    And User doing patient search with some criteria
    And User Creating a order for that patient
    And User clicks cancel
    And User clicks Menu
    And User clicks Result Management from menu
    And User clicks Microscopy under result management
    And User enters order LRN and retreiving the patient
    And User selects one template from the Report Template Dropdown
    And User verfifies patient banner details 
    And User Verifies the context icon displaying on left side of the screen
    And User Selects any reporting pathologist from the reporting pathologist field and enter some details on report editor and Click on SAVE AS option
		And User enters order LRN and retreiving the patient
		And User clicks on insert text blocks option
		And User click on Synoptic wizard option
		And User click on Diagnosis coding option
		And User click on Release AS option and selects Final report
		