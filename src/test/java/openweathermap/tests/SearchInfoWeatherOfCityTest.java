package openweathermap.tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import openweathermap.steps.SearchInfoWeatherOfCitySteps;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("weather")
public class SearchInfoWeatherOfCityTest {
    @Managed(uniqueSession = true)
    WebDriver driver;

    @Steps
    SearchInfoWeatherOfCitySteps searchSteps;

    @ParameterizedTest
    @CsvFileSource(resources = "/data/cityName.csv", numLinesToSkip = 1)
    @DisplayName(("Search information weather of a city by click button"))
    public void verifySearchInfoWeatherOfACityByClickButton(String keySearch) {

        searchSteps.openTheWebsite();
        searchSteps.searchTheCityByClickButton(keySearch);
        searchSteps.verifyTheCityNameIsDisplayedCorrectly(keySearch);
        searchSteps.verifyTheCurrentDateIsDisplayedCorrectly(keySearch);
        searchSteps.verifyTheTemperatureIsDisplayedCorrectly(keySearch);

        driver.quit();
    }


/*
    //If requirement
    @ParameterizedTest
    @CsvFileSource(resources = "/data/cityName.csv", numLinesToSkip = 1)
    @DisplayName(("Search information weather of a city by send key enter"))
    public void verifySearchInfoWeatherOfACityBySendKeyEnter(String keySearch) {

        searchSteps.openTheWebsite();
        searchSteps.searchTheCityBySendKeyEnter(keySearch);
        searchSteps.verifyTheCityNameIsDisplayedCorrectly(keySearch);
        searchSteps.verifyTheCurrentDateIsDisplayedCorrectly(keySearch);
        searchSteps.verifyTheTemperatureIsDisplayedCorrectly(keySearch);

        driver.quit();
    }

*/

}

