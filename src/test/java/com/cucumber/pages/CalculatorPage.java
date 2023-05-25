package com.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.support.ui.Select;

import static com.cucumber.utils.BasePage.driver;
import static com.cucumber.utils.ConfigUtils.getASpecificProperty;

public class CalculatorPage {
    By calculatorHeading = By.xpath("//h1[contains(text(),'How much could I borrow?')]");
    By applicationTypeSingleElement = By.id("application_type_single");
    By applicationTypeJointElement = By.id("application_type_joint");
    By numOfDependentsElement = By.xpath("//select[@title='Number of dependants']");
    By propLikeToBuyHomeElement = By.id("borrow_type_home");
    By propLikeToBuyInvestmentElement = By.id("borrow_type_investment");
    By annualIncomeElement = By.xpath("//*[contains(text(),'Your annual income (before tax)')]/following::input[1]");
    By otherIncomeElement = By.xpath("//*[contains(text(),'Your annual other income (optional)')]/following::input[1]");
    By monthlyLvingExpElement = By.xpath("//*[contains(text(),'Monthly living expenses')]/following::input[1]");
    By currentHomeLoanMonthlyRepayElement = By.xpath("//*[contains(text(),'Current home loan monthly')]/following::input[1]");
    By otherLoanMonthlyRepayElement = By.xpath("//*[contains(text(),'Other loan monthly repayments')]/following::input[1]");
    By otherMonthlyCommitElement = By.xpath("//*[contains(text(),'Other monthly commitments')]/following::input[1]");
    By totalCredCardLimitsElement = By.xpath("//*[contains(text(),'Total credit card limits')]/following::input[1]");
    By workoutCalcBtnElement = By.id("btnBorrowCalculater");
    By startOverLinkElement = By.xpath("(//span[@class='icon icon_restart'])[1]");
    By borrowResultAmount = By.id("borrowResultTextAmount");
    By borrowerErrorTxt = By.className("borrow__error__text");

    String url = getASpecificProperty("url");

    public void navigateToUrl(){
        driver.get(url);
        driver.manage().window().maximize();
        Assert.assertTrue(driver.findElement(calculatorHeading).isDisplayed());
    }

    public void calculatorPageDetails(String applicationType, String numberOfDependants, String propertyLikeToBuy, String annualIncome, String annualOtherIncome, String monthlyLivingExp, String curHomeLnMnthyRep, String othLnMnthyRep, String othMnthyCommt, String totalCredCardLmts, String borrowingEstimate) throws InterruptedException {
        if(applicationType.toLowerCase().contains("single")) {
            driver.findElement(applicationTypeSingleElement).click();
        }
        else if(applicationType.toLowerCase().contains("joint")) {
            driver.findElement(applicationTypeJointElement).click();
        }
        else {
            throw new InvalidArgumentException("This should be either single or joint, please check feature file");
        }
        Select dependents = new Select(driver.findElement(numOfDependentsElement));
        dependents.selectByVisibleText(numberOfDependants);

        if(propertyLikeToBuy.toLowerCase().contains("home")) {
            driver.findElement(propLikeToBuyHomeElement).click();
        }
        else if(applicationType.toLowerCase().contains("joint")) {
            driver.findElement(propLikeToBuyInvestmentElement).click();
        }
        else {
            throw new InvalidArgumentException("This should be either home to live in or residential investment, please check feature file");
        }

        driver.findElement(annualIncomeElement).sendKeys(annualIncome);
        driver.findElement(otherIncomeElement).sendKeys(annualOtherIncome);
        driver.findElement(monthlyLvingExpElement).sendKeys(monthlyLivingExp);
        driver.findElement(currentHomeLoanMonthlyRepayElement).sendKeys(curHomeLnMnthyRep);
        driver.findElement(otherLoanMonthlyRepayElement).sendKeys(othLnMnthyRep);
        driver.findElement(otherMonthlyCommitElement).sendKeys(othMnthyCommt);
        driver.findElement(totalCredCardLimitsElement).sendKeys(totalCredCardLmts);

        driver.findElement(workoutCalcBtnElement).click();

        if(!borrowingEstimate.equalsIgnoreCase("0")) {
            Thread.sleep(5000);
            String amount = driver.findElement(borrowResultAmount).getText().trim().replace("$", "");
            System.out.println(amount);
            Assert.assertTrue(amount.equalsIgnoreCase(borrowingEstimate));
        }
        else {
            String errorText = driver.findElement(borrowerErrorTxt).getText();
            System.out.println(errorText);
            Assert.assertTrue(errorText.equalsIgnoreCase("Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."));
        }

    }

    public void startOverShouldClearFields(){
        driver.findElement(startOverLinkElement).click();
        Select dependents = new Select(driver.findElement(numOfDependentsElement));
        Assert.assertTrue(dependents.getFirstSelectedOption().getText().equalsIgnoreCase("0"));
        Assert.assertTrue(driver.findElement(annualIncomeElement).getAttribute("value").equalsIgnoreCase("0"));
        Assert.assertTrue(driver.findElement(otherIncomeElement).getAttribute("value").equalsIgnoreCase("0"));
        Assert.assertTrue(driver.findElement(monthlyLvingExpElement).getAttribute("value").equalsIgnoreCase("0"));
        Assert.assertTrue(driver.findElement(currentHomeLoanMonthlyRepayElement).getAttribute("value").equalsIgnoreCase("0"));
        Assert.assertTrue(driver.findElement(otherLoanMonthlyRepayElement).getAttribute("value").equalsIgnoreCase("0"));
        Assert.assertTrue(driver.findElement(otherMonthlyCommitElement).getAttribute("value").equalsIgnoreCase("0"));
        Assert.assertTrue(driver.findElement(totalCredCardLimitsElement).getAttribute("value").equalsIgnoreCase("0"));
    }
}
