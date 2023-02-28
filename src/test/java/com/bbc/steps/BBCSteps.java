package com.bbc.steps;

import com.bbc.pages.BbcHomePage;
import com.bbc.utils.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class BBCSteps extends BasePage {

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
