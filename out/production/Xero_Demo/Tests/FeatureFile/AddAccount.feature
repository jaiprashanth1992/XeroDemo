Feature: Addding ANZ Account
@addingAnzAccount
  Scenario: Adding an ANZ(NZ) account to manage my business successfully
    Given i am a Xero user and i am able to enter my login details
    When my TwoFA authentication is verified and successful login
    Then i should be able to create a new trial Organisation
    And i should be able to add my ANZ(NZ) account in the Xero Orgnaisation
    And i am able close the browser
