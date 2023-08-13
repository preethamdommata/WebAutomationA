package com.preetham.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.preetham.common.BaseClass;

public class TeamDetailsPage extends BaseClass{

    /**
     * constructor to handle the driver
     * @param driver
     */
    public TeamDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators for Team Details Page
    String teamPlayersSection = ".roster-wrap";
    String teamPlayersHeroCards = ".player-wrap";
    String teamPlayerNameLocator = "p.player-name";


    /**
     * constructor to handle the driver
     * @param driver
     */
    public void verifyTeamDetaislAreDisplayed(){
        waitForPresenceOfElements(teamPlayersSection);
    }
    
    /**
     *  Gets the all the players card elements and returns it
     *
     */
    public List<WebElement> getPlayersCards(){
         waitForPresenceOfElements(teamPlayersSection);
        List<WebElement> playersElements = driver.findElements(By.cssSelector(teamPlayersHeroCards));
        return playersElements;
    }

    /**
     *  Selects a player card and clicks on it by playername
     *
     */
    public void selectPlayerByName(String playerNameToGet){
         waitForPresenceOfElements(teamPlayersSection);
        List<WebElement> playersElements = driver.findElements(By.cssSelector(teamPlayersHeroCards));
        for (WebElement player:playersElements){
            String playerName = player.findElement(By.cssSelector(teamPlayerNameLocator)).getText();
            if (playerName.contentEquals(playerNameToGet)){
                player.click();
            }
        }
    }

    /**
     * Gets the Team Details page URL
     * 
     */
    public String getCurrentPageURL(){
        waitForPresenceOfElements(teamPlayersSection);
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    /**
     * Gets the Team Details page title
     * 
     */
    public String getCurrentPageTitle(){
        waitForPresenceOfElements(teamPlayersSection);
        String currentPageTitle = driver.getTitle();
        return currentPageTitle;
    }
}
