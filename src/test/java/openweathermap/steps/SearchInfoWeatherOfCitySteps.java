package openweathermap.steps;

import openweathermap.utils.WeatherAPI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.Assertions;
import openweathermap.pages.SearchInfoWeatherOfCityPage;


public class SearchInfoWeatherOfCitySteps {

    SearchInfoWeatherOfCityPage searchPage;

    @Step("Open the website")
    public void openTheWebsite(){
        searchPage.open();
    }

    @Step("Search the city by click button: '{0}'")
    public void searchTheCityByClickButton(String keyword){
        searchPage.typeKeywordSearch(keyword);
        searchPage.searchByClickButton();
        Assertions.assertTrue(searchPage.clickResult(keyword));
    }

    @Step("Search the city  by key word enter: '{0}'")
    public void searchTheCityBySendKeyEnter(String keyword){
        searchPage.typeKeywordSearch(keyword);
        searchPage.searchBySendKeyEnter();
        Assertions.assertTrue(searchPage.clickResult(keyword));
    }

    @Step("Verify the city name is displayed correctly")
    public void verifyTheCityNameIsDisplayedCorrectly(String cityName){
        String actCityName = searchPage.getCityName();
        Assertions.assertEquals(cityName, actCityName);
    }

    @Step("Verify the current date is displayed correctly")
    public void verifyTheCurrentDateIsDisplayedCorrectly(String cityName)  {
/*
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d");
        String expDate = now.format(formatter);
*/
        WeatherAPI weatherAPI = new WeatherAPI();
        String expDate = weatherAPI.getLocalDate(cityName);
        String actDate = searchPage.getCurrentDate();
        Assertions.assertEquals(expDate, actDate);

    }

    @Step("Verify the temperature is displayed correctly")
    public void verifyTheTemperatureIsDisplayedCorrectly(String cityName){
        WeatherAPI weatherAPI = new WeatherAPI();
        int expTemperature = weatherAPI.getTemperature(cityName);
        int actTemperature = searchPage.getTemperature(cityName);
        Assertions.assertEquals(expTemperature, actTemperature);

    }

}
