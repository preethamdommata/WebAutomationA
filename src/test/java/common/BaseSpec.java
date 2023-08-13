package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.preetham.pages.NBATopMenuNavigation;
import com.preetham.pages.TeamDetailsPage;
import com.preetham.pages.TeamFooterNavigation;
import com.preetham.pages.TeamHomePage;
import com.preetham.pages.TeamMenuNavigation;
import com.preetham.pages.TeamSchedulePage;
import com.preetham.pages.TeamTicketsPage;
import com.preetham.utils.Utils;

public class BaseSpec {
    // private String BASEURL = System.getProperty("baseUrl");
    // private String BROWSER = System.getProperty("browser");

    // private String BASEURL = "https://www.nba.com/warriors/";
    private String BASEURL = "https://www.nba.com/celtics/";
    private String BROWSER = "Chrome";

    public WebDriver driver;
    // public HomePage homePage;
    // public FlightSearchPage searchPage;

    public TeamHomePage homePage;
    public NBATopMenuNavigation nbaNavigationMenu;
    public TeamMenuNavigation teamMenuNavigation;
    public TeamDetailsPage teamDetailsPage;
    public TeamSchedulePage teamSchedulePage;
    public TeamTicketsPage teamTicketsPage;
    public TeamFooterNavigation footerNavigation;
    public Utils utils;
    // public 

    @BeforeClass
    public void setUp(){
        intilizeBrowser();
        homePage = new TeamHomePage(driver);
        nbaNavigationMenu = new NBATopMenuNavigation(driver);
        teamMenuNavigation = new TeamMenuNavigation(driver);
        teamDetailsPage = new TeamDetailsPage(driver);
        teamSchedulePage = new TeamSchedulePage(driver);
        teamTicketsPage = new TeamTicketsPage(driver);
        footerNavigation = new TeamFooterNavigation(driver);
        utils = new Utils(driver);
    }

    @BeforeMethod
    public void set(){
        driver.manage().window().maximize();
        driver.get(BASEURL);
    }

    @AfterMethod
    public void clean(){
        driver.manage().deleteAllCookies();
    }

    /**
     * Intilizes the driver accordingly
     */
    public void intilizeBrowser(){

        System.out.println(BROWSER);
        System.out.println(BASEURL);

        if(BROWSER.equalsIgnoreCase("chrome")){
            driver  = new ChromeDriver();
        }
        else if(BROWSER.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(BASEURL);

    }

    public void takeScreenShot(String filename){
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+filename+".jpg");
		try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("Screenshot saved successfully");
    }
}
