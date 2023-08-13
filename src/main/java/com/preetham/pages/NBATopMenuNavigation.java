package com.preetham.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.preetham.common.BaseClass;

public class NBATopMenuNavigation extends BaseClass{
    
    /**
     * constructor to handle the driver
     * @param driver
     */
    public NBATopMenuNavigation(WebDriver driver){
        this.driver = driver;
    }

    // Page locators
    String nbaMenuNavigationBarLocator = "ul[role='menubar']";
    String nbaMenuNavigationLinksLocators = ".flex ul li[role='menuitem'].ml-2.relative";
    String nbaMenuSubLinkLocators = ".mb-1>a";
    String nbaHomePageLogoLocator = "img[alt='NBA Logo']";

    /**
     *  Verifies NBA Menu is displayed
     *
     */
    public void waitForNBAMenuIsDisplayed(){
        waitForPresenceOfElements(nbaMenuNavigationBarLocator);
    }

    /**
     *  Selects NBA menu main Links directly
     *
     */
    public void selectMainLinks(String linkName){
        waitForDisplay(nbaMenuNavigationBarLocator);
        List<WebElement> mainLinkElements = driver.findElements(By.cssSelector(nbaMenuNavigationLinksLocators));
        for(WebElement element:mainLinkElements){
            System.out.println("Main Link: "+element.getText());
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
     *  Selects the Sub category links after hovering over the main link
     *
     */
    public void selectSubCategoryLinks(String mainLink, String subLink){
        waitForDisplay(nbaMenuNavigationBarLocator);
        List<WebElement> mainLinkElements = driver.findElements(By.cssSelector(nbaMenuNavigationLinksLocators));
        for(WebElement element:mainLinkElements){
            System.out.println("Main Link: "+element.getText());
            
            //Performing the mouse hover action on the target element.
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

            List<WebElement> subElements =  element.findElements(By.cssSelector(nbaMenuSubLinkLocators));
            for (WebElement subElement: subElements ){
                System.out.println("Sub Link: "+subElement.getText());
                if(subElement.getText().contentEquals(subLink)){
                    subElement.click();
                    break;
                }
            }
        }
    }

    /**
     *  Navigates the driver to NBA Home Page
     *
     */
    public void navigateToNBAHomePage(){
        waitForPresenceOfElements(nbaHomePageLogoLocator);
        WebElement NBALogoElement = waitForClick(nbaHomePageLogoLocator);
        NBALogoElement.click();
    }
}
