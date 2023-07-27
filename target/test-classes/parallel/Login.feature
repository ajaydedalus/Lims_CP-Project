@login
Feature: To validate Login functionality of LIMS

  Scenario Outline: Validating the Login Functionality of LIMS
    Given User in Login page
    When user enter valid "<username>"and"<password>"
    And user click the login button

    Examples: 
      | username |  | password |
      | VM       |  | Pas123   |
      |ajay      |  |ajai133   |

