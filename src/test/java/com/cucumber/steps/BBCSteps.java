package com.cucumber.steps;

import com.cucumber.pages.BbcHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cucumber.utils.BasePage.driver;

public class BBCSteps {

    BbcHomePage homePage = new BbcHomePage();
    @Given("Navigate to BBC sports page")
    public void navigateToBBCSportsPage() {
        homePage.navigateToUrl();
    }

    @When("Get all last {int} teams from Premium league table")
    public void getAllLastTeamsFromPremiumLeagueTable(int teams) {
        homePage.pickLastListTeamsFromLeague(teams);
    }

    @Then("Get fixtures for the team {string}")
    public void getFixturesForTheTeam(String teamName) {
        homePage.pickTeamsNextFixtures(teamName);
    }

    @And("Print Easiest teams based on table")
    public void printEasiestTeamsBasedOnTable() {
        homePage.findEasyTeam();
    }

    @And("Close the application page")
    public void closeTheApplicationPage() {
        driver.quit();
    }
}
