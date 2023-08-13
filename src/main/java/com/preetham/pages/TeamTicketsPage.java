package com.preetham.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.preetham.common.BaseClass;

public class TeamTicketsPage extends BaseClass{

    /**
     * constructor to handle the driver
     * @param driver
     */
    public TeamTicketsPage(WebDriver driver){
        this.driver = driver;
    }

    // Team Tickets Page locators
    String ticketTypeMembershipCardsLocator = ".CtaTile_container__NeLBG";
    String cardNameLocator = ".CtaTile_ctaTileName__pv28n";

    /**
     * Waits until the Tickets and membership cards are present
     */
    public void verifyTicketsPageIsDispalyed(){
        waitForPresenceOfElements(ticketTypeMembershipCardsLocator);
    }

    /**
     * Selects and clicks on Service card given the service name
     * @cardName - name of the card ex - RAFTERS MEMBERSHIPS
     */
    public void selectServiceTypeCard(String cardName){
        waitForPresenceOfElements(ticketTypeMembershipCardsLocator);
        List<WebElement> gameServices = driver.findElements(By.cssSelector(ticketTypeMembershipCardsLocator));
        for(WebElement service:gameServices){
            if(service.getText().contentEquals(cardName)){
                service.click();
                break;
            }
        }
    }

    /**
     * Gets the Tickets page URL
     * 
     */
    public String getCurrentPageURL(){
        waitForPresenceOfElements(ticketTypeMembershipCardsLocator);
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    /**
     * Gets the Tickets page title
     * 
     */
    public String getCurrentPageTitle(){
        waitForPresenceOfElements(ticketTypeMembershipCardsLocator);
        String currentPageTitle = driver.getTitle();
        return currentPageTitle;
    }
}
