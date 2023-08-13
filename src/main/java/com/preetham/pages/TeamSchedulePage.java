package com.preetham.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.preetham.common.BaseClass;

public class TeamSchedulePage extends BaseClass{

    /**
     * constructor to handle the driver
     * @param driver
     */
    public TeamSchedulePage(WebDriver driver){
        this.driver = driver;
    }

    // Team Schedule page Locators
    String preSeasonScheduledGamesLocator = ".game[data-seasontype='pre']";
    String regularSeasonScheduledGamesLocator = ".game[data-seasontype='regular']";
    String schedulePageHeading = ".active[data-section='top'] h1";

    public void verifySchedulePageIsDisplayed(){
        waitForPresenceOfElements(schedulePageHeading);
    }

    /**
     * Returns all the pre season scheduled games elements 
     * 
     */
    public List<WebElement> getPreSeasonGames(){
        waitForPresenceOfElements(schedulePageHeading);
        List<WebElement> preSeasonGamesElements = driver.findElements(By.cssSelector(preSeasonScheduledGamesLocator));
        return preSeasonGamesElements;
    }

    /**
     * Returns all the Regular season scheduled games elements 
     * 
     */
    public List<WebElement> getRegularSeasonGames(){
        waitForPresenceOfElements(schedulePageHeading);
        List<WebElement> regularSeasonGamesElements = driver.findElements(By.cssSelector(regularSeasonScheduledGamesLocator));
        return regularSeasonGamesElements;
    }

    /**
     * Gets the Schedule page URL
     * 
     */
    public String getCurrentPageURL(){
        waitForPresenceOfElements(schedulePageHeading);
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    /**
     * Gets the Schedule page title
     * 
     */
    public String getCurrentPageTitle(){
        waitForPresenceOfElements(schedulePageHeading);
        String currentPageTitle = driver.getTitle();
        return currentPageTitle;
    }
    
}
