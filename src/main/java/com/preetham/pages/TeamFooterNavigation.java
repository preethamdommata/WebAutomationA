package com.preetham.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.preetham.common.BaseClass;

public class TeamFooterNavigation extends BaseClass{

    /**
     * constructor to handle the driver
     * @param driver
     */
    public TeamFooterNavigation(WebDriver driver){
        this.driver = driver;
    }

    // Team Footer Navigation Locators
    String footerSectionsLocator = "footer h2";
    String allFooterListLinksLocator = "[data-testid='footer-list-item']";

    /**
     * Selects link from Footer links by link name
     *
     */
    public void selectFooterLinkByName(String linkName){
        waitForPresenceOfElements(footerSectionsLocator);
        List<WebElement> footerLinkElements = driver.findElements(By.cssSelector(allFooterListLinksLocator));
        for(WebElement footerLinkElement: footerLinkElements){
            if(footerLinkElement.getText().contentEquals(linkName)){
                footerLinkElement.click();
                break;
            }
        }
    }
}
