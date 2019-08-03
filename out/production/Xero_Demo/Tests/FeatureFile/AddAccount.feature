Feature: Add Account
@account
  Scenario: Successful Login with Valid Credentials
    Given User Login in System
    When Perform Authentication Operation
    And Create new Organisation
    Then Add Account in orgnaisation
    And Close the browser
