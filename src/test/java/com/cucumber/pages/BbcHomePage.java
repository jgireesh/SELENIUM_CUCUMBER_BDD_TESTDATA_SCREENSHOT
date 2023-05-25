package com.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.cucumber.utils.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.cucumber.utils.BasePage.driver;
import static com.cucumber.utils.ConfigUtils.getASpecificProperty;
import static com.cucumber.utils.TestDataParams.*;

public class BbcHomePage {
    String url = getASpecificProperty("url");
    HashSet<String> fixtureOpponents = new HashSet<>();
    List<String> lastTeamsOfLeague = new ArrayList<>();
    TestDataStore dataStore = new TestDataStore();
    ScreenshotUtils screenshotUtils = new ScreenshotUtils(driver);

    public void navigateToUrl(){
        driver.get(url);
        dataStore.setStringValue(BASE_URL.name(), url);
        driver.manage().window().maximize();
        screenshotUtils.takeScreenshot();
    }

    public void pickLastListTeamsFromLeague(int noOfLastItems){
        driver.navigate().to(url+"/football/premier-league/table");
        dataStore.setStringValue(TestDataParams.SECONDARY_URL.name(),url+"/football/premier-league/table");
        System.out.println("****************************************************************************************************************");
        for(int teams=0;teams<noOfLastItems;teams++){
            String teamName = driver.findElement(By.xpath("(//a[@href='#football-table-key']/following::tbody[1]/tr[last()-"+teams+"]/td/following::a/span)[2]")).getText();
            lastTeamsOfLeague.add(teamName.trim());
        }
        screenshotUtils.takeScreenshot();
        System.out.println("Last half of the teams of Premium leagues are "+"\n"+ lastTeamsOfLeague);
        System.out.println("****************************************************************************************************************");
    }


    public void pickTeamsNextFixtures(String teamName){
        driver.navigate().to(url+"/football/teams/"+teamName);
        dataStore.setStringValue(TestDataParams.TEAM_NAME.name(),teamName);
        screenshotUtils.takeScreenshot();
        List<WebElement> teams = driver.findElements(By.xpath("//*[@class='ssrcss-1o2c2fj-CarouselList eovm8903']/li/following::div[@aria-hidden='true']/following-sibling::span[1]"));
        for(WebElement ele: teams){
            fixtureOpponents.add(ele.getText().trim());
        }
        System.out.println("******************************************* Fixture List *******************************************************");
        System.out.println(fixtureOpponents);
        screenshotUtils.takeScreenshot();
        System.out.println("****************************************************************************************************************");
    }

    public void findEasyTeam(){
        System.out.println("************************** Easy based on bottom half of league (Order by Easiest) ******************************");
        for (String team:fixtureOpponents){
            if(lastTeamsOfLeague.contains(team)){
                System.out.println(team);
                dataStore.setStringValue(TestDataParams.EASY_TEAM_NAME.name(),team);
                screenshotUtils.takeScreenshot();
            }
        }
        System.out.println("****************************************************************************************************************");
        System.out.println(dataStore.getStringValue(BASE_URL.name()));
        System.out.println(dataStore.getStringValue(SECONDARY_URL.name()));
        System.out.println(dataStore.getStringValue(TEAM_NAME.name()));
        System.out.println(dataStore.getStringValue(EASY_TEAM_NAME.name()));
    }
}
