Feature: Jira API testing

  Scenario: Import a list of US ticket in Jira
    Given I collect a list of US ticket from Jira
    Then The US list should be available successfully to displayed
