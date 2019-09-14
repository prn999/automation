
Feature: personal information

  Scenario: update personal details
    Given user is on the home page
    And navigate to sign in page
    And enter signin details
    And navigate to personal information
    And update personal details
    When they click save
    Then the changes are updated
