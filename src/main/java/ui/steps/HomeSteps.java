package ui.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.pages.Home;

public class HomeSteps {

    private Home home;

    public HomeSteps(WebDriver driver) {
        home = new Home(driver);
    }

    public void setLocation(String location) {
        home.open();
        home.getSearchInputElement();
        home.fillInSearchForm(location);
        home.clickOnSearchResult();
    }
}
