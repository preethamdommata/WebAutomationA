package com.preetham.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.preetham.common.BaseClass;

public class Utils extends BaseClass{

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public String getCurrentWindowHandle(){
        String currentWindowHandle = driver.getWindowHandle();
        return currentWindowHandle;
    }

    public String getChildWindowHandle(){
        String childWindowHandle = new String();
        String currentWindowHandle = getCurrentWindowHandle();
        Set<String> allWindowHandles = getAllWindowHandles();
        for(String windowHandle:allWindowHandles){
            if(!windowHandle.equalsIgnoreCase(currentWindowHandle)){
                childWindowHandle = windowHandle;
                break;
            }
        }
        driver.switchTo().window(childWindowHandle);
        return childWindowHandle;
    }

    public Set<String> getAllWindowHandles(){
        Set<String> allWindowHandles = driver.getWindowHandles();
        return allWindowHandles;
    }

    public void switchContextToWindow(String windowHandle){
        driver.switchTo().window(windowHandle);
    }

    public void closeAllWindowsExceptMainWindow(String mainWindowHandle){
        Set<String> allWindowHandles = getAllWindowHandles();
        for(String windowHandle:allWindowHandles){
            if (!windowHandle.equalsIgnoreCase(mainWindowHandle)){
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }
}
