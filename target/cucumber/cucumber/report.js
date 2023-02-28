$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/BBC Exercise.feature");
formatter.feature({
  "name": "Verification of Fixtures",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Navigate to BBC sports page",
  "keyword": "Given "
});
formatter.match({
  "location": "BBCSteps.navigateToBBCSportsPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get all last 10 teams from Premium league table",
  "keyword": "When "
});
formatter.match({
  "location": "BBCSteps.getAllLastTeamsFromPremiumLeagueTable(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify Easiest team in premium league based on team",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@bbcsports"
    }
  ]
});
formatter.step({
  "name": "Get fixtures for the team \"arsenal\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BBCSteps.getFixturesForTheTeam(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Print Easiest teams based on table",
  "keyword": "And "
});
formatter.match({
  "location": "BBCSteps.printEasiestTeamsBasedOnTable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the application page",
  "keyword": "And "
});
formatter.match({
  "location": "BBCSteps.closeTheApplicationPage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify Easiest team in premium league based on teams",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@bbcsports"
    }
  ]
});
formatter.step({
  "name": "Get fixtures for the team \"\u003cteamName\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Print Easiest teams based on table",
  "keyword": "And "
});
formatter.step({
  "name": "Close the application page",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "teamName"
      ]
    },
    {
      "cells": [
        "liverpool"
      ]
    },
    {
      "cells": [
        "tottenham-hotspur"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Navigate to BBC sports page",
  "keyword": "Given "
});
formatter.match({
  "location": "BBCSteps.navigateToBBCSportsPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get all last 10 teams from Premium league table",
  "keyword": "When "
});
formatter.match({
  "location": "BBCSteps.getAllLastTeamsFromPremiumLeagueTable(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify Easiest team in premium league based on teams",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@bbcsports"
    }
  ]
});
formatter.step({
  "name": "Get fixtures for the team \"liverpool\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BBCSteps.getFixturesForTheTeam(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Print Easiest teams based on table",
  "keyword": "And "
});
formatter.match({
  "location": "BBCSteps.printEasiestTeamsBasedOnTable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the application page",
  "keyword": "And "
});
formatter.match({
  "location": "BBCSteps.closeTheApplicationPage()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Navigate to BBC sports page",
  "keyword": "Given "
});
formatter.match({
  "location": "BBCSteps.navigateToBBCSportsPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get all last 10 teams from Premium league table",
  "keyword": "When "
});
formatter.match({
  "location": "BBCSteps.getAllLastTeamsFromPremiumLeagueTable(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify Easiest team in premium league based on teams",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@bbcsports"
    }
  ]
});
formatter.step({
  "name": "Get fixtures for the team \"tottenham-hotspur\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BBCSteps.getFixturesForTheTeam(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Print Easiest teams based on table",
  "keyword": "And "
});
formatter.match({
  "location": "BBCSteps.printEasiestTeamsBasedOnTable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the application page",
  "keyword": "And "
});
formatter.match({
  "location": "BBCSteps.closeTheApplicationPage()"
});
formatter.result({
  "status": "passed"
});
});