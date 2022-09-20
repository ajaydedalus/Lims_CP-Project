
Feature: Cp flow

  Scenario: User is doing Cellular Pathology workflow
    Given User in Login page
    When User enters valid username and valid password
    And User selects CP order entry
    And User doing patient search with some criteria
    And User Creating a order for that patient
    And User searching the patient with OrderLrn and validating it
    And User changes workarea to specimen dissection
    And User selects Specimen dissection from Lab Processing dropdown
    And User enters Specimen LRN in the scan field and does search
    And User Scanning the same specimen agian and adding one more block in specimen dissection page
    And User changes the workarea to Embed
    And User selects the block processing worklist from Menu
    And User Scans the order LRN and validate the corresponding blocks for the order
    And User clicks some blocks,modifies edit values section and clicks save button
    And User Scans the specimen LRN and validate the corresponding blocks for the specimen
    And User changes the workarea to Microtome 1
    And User enters procedure processing worklist from menu
    And User scans the order LRN
    And USer selects some procedures, changing the status and Saved it
    And User Scans specimen Lrn
    And User scans the block Lrn
    And User clicks cancel
    And User Selects order verication from Menu
    And User enters order Lrn and Scans it
    And User selects some of the procedure from the grid and clicks Release button
    And User enters order Lrn and Scans it
    And User verifies the procedure is released for the patient
    And User clicks cancel
    And User selects Specimen Worklist from Menu
    And User keeps some criteria in status dropdown and applies filter
