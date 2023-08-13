package com.preetham.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v112.v112Domains;
import org.openqa.selenium.interactions.Actions;

import com.preetham.common.BaseClass;

public class TeamMenuNavigation extends BaseClass {

    /**
     * constructor to handle the driver
     * @param driver
     */
    public TeamMenuNavigation(WebDriver driver){
        this.driver = driver;
    }

    //Team Menu Navigator Locators
    String teamMenuNavigatorLocator = ".NavBar_nav__U9xyc";
    String teamMenuLinksLocators = ".NavBar_menu__yO4Am .menu-item";
    String teamMenuSubLinks = ".NavDropdown_list__Phy7G[role='menuitem'] ";
    String teamHomePageLogoLocator = ".NavLogo_navLogoImage__QYndT";

    public void verifyTeamNavigationMenuIsDisplayed(){
        waitForPresenceOfElements(teamMenuNavigatorLocator);
    }

    /**
     * Selects main link from Team Menu Navigation bar
     * 
     */
    public void selectMainLinks(String linkName){
        waitForDisplay(teamMenuNavigatorLocator);
        List<WebElement> mainLinkElements = driver.findElements(By.cssSelector(teamMenuLinksLocators));
        for(WebElement element:mainLinkElements){
            System.out.println("Team Main Link: "+element.getText());
            //Performing the mouse hover action on the target element.
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
            if (element.getText().contentEquals(linkName)){
                element.click();
                break;
            }
        }

    }

    /**
     * Selects sub category link from Team Menu Navigation bar
     * 
     */
    public void selectSubCategoryLinks(String mainLink, String subLink){
        waitForDisplay(teamMenuNavigatorLocator);
        List<WebElement> mainLinkElements = driver.findElements(By.cssSelector(teamMenuLinksLocators));
        for(WebElement element:mainLinkElements){
            System.out.println("Team Main Link: "+element.getText());
            
            //Performing the mouse hover action on the target element.
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

            List<WebElement> subElements =  element.findElements(By.cssSelector(teamMenuSubLinks));
            for (WebElement subElement: subElements ){
                System.out.println("Team Sub Link: "+subElement.getText());
                if(subElement.getText().contentEquals(subLink)){
                    subElement.click();
                    break;
                }
            }
        }
    }

    /**
     * Navigates to Team Home Page by clicking on logo
     * 
     */
    public void navigateToTeamHomePage(){
        waitForDisplay(teamMenuNavigatorLocator);
        waitForPresenceOfElements(teamHomePageLogoLocator);
        WebElement teamLogoElement = waitForClick(teamHomePageLogoLocator);
        teamLogoElement.click();
    }
    
}
