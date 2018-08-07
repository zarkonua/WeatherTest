package ui.steps;

import ui.pages.Forecast;
import ui.pages.Home;

public class HomeSteps {

    private static Home home = new Home();

    public Forecast setLocation(String location) {
        home.open();
        home.getSearchInputElement();
        home.fillInSearchForm(location);
        return home.clickOnSearchResult();
    }

    public void close() {
        home.close();
    }
}
