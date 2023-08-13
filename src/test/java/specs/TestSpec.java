package specs;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.preetham.pages.NBATopMenuNavigation;
import com.preetham.pages.TeamMenuNavigation;

import common.BaseSpec;

public class TestSpec extends BaseSpec{
    
    // Navigate to new Team Page from Celtics and navigate back to the main team page
    // 1. Navigate to Celtics Team Home Page.
    // 2. From NBA Teams dropdown navigate to another team page
    // 3. Verfify the title and URl of new Team Home Page
    // 4. Close the window and navigate back to Celtics Home Page
    @Test
    public void VerifyNavigatingToNewTeamHomePage(){
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "https://www.nba.com/celtics";
        String expectedTitle = "Celtics - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com";

        String expectedUrlSecondSite = "https://www.nba.com/bulls";
        String expectedTitleSecondSite = "Bulls - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com";

        homePage.acceptCookies();

        softAssert.assertEquals(homePage.getCurrentPageURL(), expectedUrl, "Current Team Home Page URL does not matches with expected URL.");
        softAssert.assertEquals(homePage.getCurrentPageTitle(), expectedTitle, "Current Team Home Page Title does not match with expected Title");

        String mainWindowHandle = utils.getCurrentWindowHandle();

        nbaNavigationMenu.selectSubCategoryLinks("Teams", "Chicago");
        homePage.waitForHomePage();
        String childWindowhandle = utils.getChildWindowHandle();

        softAssert.assertEquals(homePage.getCurrentPageURL(), expectedUrlSecondSite, "New Team Home Page URL does not matches with expected URL.");
        softAssert.assertEquals(homePage.getCurrentPageTitle(), expectedTitleSecondSite, "New Team Home Page Title does not match with expected Title");

        utils.closeAllWindowsExceptMainWindow(mainWindowHandle);

        softAssert.assertAll();
    }

    @Test
    public void VerifyHeroBannerStoriesCountOnHomePage(){
        SoftAssert softAssert = new SoftAssert();

        homePage.acceptCookies();
        List<WebElement> heroStories = homePage.getHeroStories();

        softAssert.assertEquals(heroStories.size(), 4, "Hero Card Stories are not matching to expected values on Team Home Page");
        softAssert.assertAll();
    }

    @Test
    public void VerifyTeamDetailsPage(){
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "https://www.nba.com/celtics/roster";
        String expectedTitle = "Roster | Team | Boston Celtics";

        homePage.acceptCookies();
        teamMenuNavigation.selectMainLinks("Team");

        softAssert.assertEquals(teamDetailsPage.getCurrentPageURL(), expectedUrl, "Team Details page URL does not matches with expected URL.");
        softAssert.assertEquals(teamDetailsPage.getCurrentPageTitle(), expectedTitle, "Team Details page Title does not match with expected Title");

        List<WebElement> teamPlayers = teamDetailsPage.getPlayersCards();
        softAssert.assertEquals(teamPlayers.size(), 17, "Number of Player cards are not matching with expected number of players on Team details Page");

        softAssert.assertAll();
    }

    @Test
    public void VerifyTeamDetailsPageByNavigatingThroughSubRoasterLink(){
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "https://www.nba.com/celtics/roster";
        String expectedTitle = "Roster | Team | Boston Celtics";

        homePage.acceptCookies();
        teamMenuNavigation.selectSubCategoryLinks("TEAM", "ROASTER");

        softAssert.assertEquals(teamDetailsPage.getCurrentPageURL(), expectedUrl, "Team Details page URL does not matches with expected URL.");
        softAssert.assertEquals(teamDetailsPage.getCurrentPageTitle(), expectedTitle, "Team Details page Title does not match with expected Title");

        List<WebElement> teamPlayers = teamDetailsPage.getPlayersCards();
        softAssert.assertEquals(teamPlayers.size(), 17, "Number of Player cards are not matching with expected number of players on Team details Page");

        softAssert.assertAll();
    }


    @Test
    public void VerifyTeamSchedulePage(){
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "https://www.nba.com/celtics/schedule";
        String expectedTitle = "Schedule | Boston Celtics";

        homePage.acceptCookies();
        teamMenuNavigation.selectMainLinks("Schedule");

        softAssert.assertEquals(teamSchedulePage.getCurrentPageURL(), expectedUrl, "Team Schedule page URL does not matches with expected URL.");
        softAssert.assertEquals(teamSchedulePage.getCurrentPageTitle(), expectedTitle, "Team Schedule page Title does not match with expected Title");

        List<WebElement> preSeasonGames = teamSchedulePage.getPreSeasonGames();
        softAssert.assertEquals(preSeasonGames.size(), 17, "Number of Preseason scheduled playoffs are not matching with expected number of playoffs on Team Schedule Page");

        softAssert.assertAll();
    }

    @Test
    public void VerifyTeamTicketsPage(){
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "https://www.nba.com/celtics/tickets";
        String expectedTitle = "Tickets | NBA.com";

        homePage.acceptCookies();
        teamMenuNavigation.selectMainLinks("Tickets");

        softAssert.assertEquals(teamTicketsPage.getCurrentPageURL(), expectedUrl, "Team Schedule page URL does not matches with expected URL.");
        softAssert.assertEquals(teamTicketsPage.getCurrentPageTitle(), expectedTitle, "Team Schedule page Title does not match with expected Title");

        softAssert.assertAll();
    }

    @AfterClass
    public void clean(){
        driver.quit();
    }

}
