package com.bbc.steps;

import com.bbc.pages.CalculatorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BorrowingCalcSteps{
    CalculatorPage calculatorPage = new CalculatorPage();

    @Given("Navigate to Borrowing Calculator Page")
    public void navigateToBorrowingCalculatorPage() {
        calculatorPage.navigateToUrl();
    }

    @When("Complete person financial details {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void completePersonFinancialDetails(String applicationType, String numberOfDependants, String propertyLikeToBuy, String annualIncome, String annualOtherIncome, String monthlyLivingExp, String curHomeLnMnthyRep, String othLnMnthyRep, String othMnthyCommt, String totalCredCardLmts, String borrowingEstimate) throws InterruptedException {
        calculatorPage.calculatorPageDetails(applicationType, numberOfDependants, propertyLikeToBuy, annualIncome, annualOtherIncome, monthlyLivingExp, curHomeLnMnthyRep, othLnMnthyRep, othMnthyCommt, totalCredCardLmts, borrowingEstimate);
    }
    @Then("Click on Start over should clear all fields")
    public void clickOnStartOverShouldClearAllFields(){
        calculatorPage.startOverShouldClearFields();
    }
}
