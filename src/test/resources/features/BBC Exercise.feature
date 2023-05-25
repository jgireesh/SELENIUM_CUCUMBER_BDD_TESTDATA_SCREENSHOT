Feature: Verification of Fixtures

  Background:
    Given Navigate to BBC sports page
    When Get all last 10 teams from Premium league table

  @bbcsport @UI
  Scenario: Verify Easiest team in premium league based on team
    Then Get fixtures for the team "arsenal"
    And Print Easiest teams based on table

  @bbcsports @UI
  Scenario Outline: Verify Easiest team in premium league based on teams
    Then Get fixtures for the team "<teamName>"
    And Print Easiest teams based on table
    Examples:
      | teamName          |
      | liverpool         |
      | tottenham-hotspur |