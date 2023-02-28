package com.bbc.pages;

import com.bbc.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.bbc.utils.BasePage.driver;
import static com.bbc.utils.ConfigUtils.getASpecificProperty;

public class BbcHomePage {
    String url = getASpecificProperty("url");
    HashSet<String> fixtureOpponents = new HashSet<>();
    List<String> lastTeamsOfLeague = new ArrayList<>();
    BasePage basePage = new BasePage();
    public void navigateToUrl(){
        basePage.getRemoteDriverDynamic().get(url);
        driver.manage().window().maximize();
    }

    public void pickLastListTeamsFromLeague(int noOfLastItems){
        driver.navigate().to(url+"/football/premier-league/table");
        System.out.println("****************************************************************************************************************");
        for(int teams=0;teams<noOfLastItems;teams++){
            String teamName = driver.findElement(By.xpath("(//a[@href='#football-table-key']/following::tbody[1]/tr[last()-"+teams+"]/td/following::a/span)[2]")).getText();
            lastTeamsOfLeague.add(teamName.trim());
        }
        System.out.println("Last half of the teams of Premium leagues are "+"\n"+ lastTeamsOfLeague);
        System.out.println("****************************************************************************************************************");
    }


    public void pickTeamsNextFixtures(String teamName){
        driver.navigate().to(url+"/football/teams/"+teamName);
        List<WebElement> teams = driver.findElements(By.xpath("//*[@class='ssrcss-1o2c2fj-CarouselList eovm8903']/li/following::div[@aria-hidden='true']/following-sibling::span[1]"));
        for(WebElement ele: teams){
            fixtureOpponents.add(ele.getText().trim());
        }
        System.out.println("******************************************* Fixture List *******************************************************");
        System.out.println(fixtureOpponents);
        System.out.println("****************************************************************************************************************");
    }

    public void findEasyTeam(){
        System.out.println("************************** Easy based on bottom half of league (Order by Easiest) ******************************");
        for (String team:fixtureOpponents){
            if(lastTeamsOfLeague.contains(team)){
                System.out.println(team);
            }
        }
        System.out.println("****************************************************************************************************************");
    }
}
