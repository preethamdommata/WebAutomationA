package com.preetham.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.preetham.common.BaseClass;

public class TeamHomePage extends BaseClass{
    
    // HomePage Locators

    String accepCookiesButtonLocator = "#onetrust-accept-btn-handler";
    String allFooterListLinksLocator = "[data-testid='footer-list-item']";
    String nbaMenuNavigationBarLocator = "ul[role='menubar']";

    String tileHeroStoriesBannerBoard = ".TileHeroStories_tileHeroStoriesButton__ERoIz md:w-1/4";
    
    /**
     * constructor to handle the driver
     * @param driver
     */
    public TeamHomePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Waits until nba main menu navigation section is displayed
     * 
     */
    public void waitForHomePage(){
        waitForDisplay(nbaMenuNavigationBarLocator);
    }

    /**
     * Waits for the cookies button and accepts it
     * 
     */
    public void acceptCookies(){
        waitForPresenceOfElements(accepCookiesButtonLocator);
        WebElement acceptCookiesButtonElement = waitForClick(accepCookiesButtonLocator);
        acceptCookiesButtonElement.click();
        waitForElementNotVisible(accepCookiesButtonLocator);
    }

    /**
     * Returns hero stories tile elements
     * 
     */
    public List<WebElement> getHeroStories(){
        waitForDisplay(nbaMenuNavigationBarLocator);
        List<WebElement> heroStories = driver.findElements(By.cssSelector(tileHeroStoriesBannerBoard));
        return heroStories;
    }

    /**
     * Gets the Team Home page URL
     * 
     */
    public String getCurrentPageURL(){
        waitForDisplay(nbaMenuNavigationBarLocator);
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    /**
     * Gets the Team Home page Title
     * 
     */
    public String getCurrentPageTitle(){
        waitForDisplay(nbaMenuNavigationBarLocator);
        String currentPageTitle = driver.getTitle();
        return currentPageTitle;
    }



}
