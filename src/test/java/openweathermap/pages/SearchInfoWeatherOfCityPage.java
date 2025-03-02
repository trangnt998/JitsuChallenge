package openweathermap.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

@DefaultUrl("https://openweathermap.org/")
public class SearchInfoWeatherOfCityPage extends PageObject {
    @FindBy(xpath = "//div[@class='search']//input")
    private WebElementFacade searchBox;
    public void typeKeywordSearch(String keyword){
        searchBox.clear();
        searchBox.type(keyword);
    }

    @FindBy(xpath = "//div[@class='search']/button[@type='submit']")
    private WebElementFacade buttonSearch;
    public void searchByClickButton(){
        buttonSearch.click();
    }
    public void searchBySendKeyEnter(){
        buttonSearch.sendKeys(ENTER);
    }

    @FindBy(xpath = "//ul[@class='search-dropdown-menu']/li/span[1]")
    private List<WebElementFacade> dropdownListResults;
    public boolean clickResult(String cityName){
        for (WebElementFacade result : dropdownListResults) {
            if (result.waitUntilVisible().getText().equalsIgnoreCase(cityName)) {
                result.click();
                return true;
            }
        }
        System.out.println("City not found in the dropdown: " + cityName);
        return false;

    }

    @FindBy(xpath = "//div[@class='section-content']//h2")
    private WebElementFacade cityName;
    public String getCityName(){
        return cityName.waitUntilVisible().getText();
    }

    @FindBy(xpath = "//div[@class='section-content']//span[@class='orange-text']")
    private WebElementFacade dateTime;
    public String getCurrentDate() {
        String currentDateTime =  dateTime.waitUntilVisible().getText();
        return currentDateTime.split(",")[0];
    }

    @FindBy(xpath = "//span[@class='heading']")
    private WebElementFacade temperature;
    public int getTemperature(String cityName){
        String degrees = temperature.waitUntilVisible().getText();
        return Integer.parseInt(degrees.replaceAll("[^0-9-]",""));
    }
}
