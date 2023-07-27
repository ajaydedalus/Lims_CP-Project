@cp
Feature: Cp Smoke Test

@cpLogin  
  Scenario: CP order entry - Placing a new order
    Given User in Login page
    When User enters valid username and valid password
    And Click on Order Management menu, Click on CP order entry menu
    And Search for the patient using the given name as Arun and Family name as R and click on Search
    And Select the patient from the Grid
    And Click on New Order button
    And Check for the Patient banner
    And Click on the down-arrow key
    And Select a value from the Location field drop-down or type few characters and select the value EX: BREH
    And Select a value from the Clinician field drop-down or type few characters (Ste) and select the value EX: SUB
    And Select a value from Patient category drop-down as NHS
    And Enter collection date and time
    And Enter the details in the following fields -	Clinical Comments,Clinical Diagnosis,Clinical question,Medical Intervention
    And In the SPECIMEN/BLOCK/PRCODURE pane click on Specimen
    And Click on Histology sub-discipline
    And Double click/Drag and drop on one of the specimen EX: Breast tissue
    And Drag and drop one more specimen from Histology sub-discipline Ex: Bone
    And In the SPECIMEN/BLOCK/PRCODURE pane click on Procedure group and select a procedure from histology sub-discipline
    And Double click on the second block LRN from popup
    And Delete one of the procedure added to the block by click on X in the procedure card
    And Click on Save button
 
  Scenario: Specimen Dissection - Scanning the Specimen
    Given Click on Laboratory processing menu and Click on Specimen dissection menu
    When User enters Specimen LRN in the scan field and does search
    And Check the details displaying in the Specimen dissection
    And On the First Block,Without entering other details, click on Save Blocks.
    And Click on No
    And Again Click on Save Block without entering Pieces, Displays warning , Click on Yes.
    And Again scan the Same Specimen LRN
    And For Block1,Enter all the details and	Verify that on selecting the block Corresponding procedure for that block will be displayed
    And Select Keep Setting check box and Click on click on Next
    And Now enter no.of Pieces on Block2 as One
    And Click on Save Block and scan the Same Specimen LRN
    And Select Disregard Unused Blocks check box and scan the Same Specimen LRN
    And Select All Tissue used check box and click on save blocks
    Then Scan the specimen Lrn again

  Scenario: Block Processing - Scan Block LRN
    Given User changes the workarea to Embed
    When User selects the block processing worklist from Menu
    And User Scans the order LRN and validate the corresponding blocks for the order
    And Verify Print Save Cancel and CAncel EDits button
    And Edit the values and verify the save and cancel Edits button
    And Click on Print button
    And Click on Save button in Block Processing screen

  Scenario: Procedure Processing - Scan a procedure
    Given Click on Laboratory processing menu and Click on Procedure processing worklist menu.
    When Scan with Procedure LRN and press ENTER key and Verify the columns in the grid.
    And Verify Print Save Cancel and CAncel EDits button
    And Edit the values and verify the save and cancel Edits button in Pp screen
		And Click on Print button in pp screen
		And Click on Save button in pp screen
		And Click on Assign button.
		Then Click on cancel button.
		
		Scenario: Order Verification - Search with order LRN
		Given Click on Laboratory processing menu and Click on Order verification menu.
		When Scan the Order LRN and hit enter key
		And Check for the verification and history tab
		And Double click under scanned column in grid
		And Check for Verify and Release button
		And Click on Release button
		And Scan the Order LRN and hit enter key
		And Check for the corresponding row under verified column
		And Validate Verify date has been updated against the respective procedure
		Then Click on the History tab
		
		
		Scenario: Microscopy-Saving and releasing the final report
		Given Click on Result Management menu, Click on Microscopy menu.  
		When Enter OR Scan LRN in Scan field and Press ENTER key
		And Check the patient details displaying in Microscopy screen
		And User Selects any reporting pathologist from the reporting pathologist field and enter some details on report editor and Click on SAVE AS option
		And User enters order LRN and retreiving the patient
		And User clicks on insert text blocks option
		And User click on Synoptic wizard option
		And User click on Diagnosis coding option
		And User click on Release AS option and selects Final report