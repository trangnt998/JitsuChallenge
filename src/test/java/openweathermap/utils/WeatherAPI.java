package openweathermap.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherAPI {
    private static final String API_KEY = "cdac649307e985c680a4b043c613e809";

    public String getLocalDate(String cityName){
        Response response = RestAssured.given()
            .queryParam("q", cityName)
            .queryParam("appid", API_KEY)
            .queryParam("units", "metric")
            .when()
            .get("https://api.openweathermap.org/data/2.5/weather");

        int statusCode = response.getStatusCode();
        if (statusCode == 200) {
            long timestamp = response.jsonPath().getLong("dt");
            int timezoneOffset = response.jsonPath().getInt("timezone");

            Instant instant = Instant.ofEpochSecond(timestamp);
            ZoneId zoneId = ZoneId.ofOffset("UTC", java.time.ZoneOffset.ofTotalSeconds(timezoneOffset));
            ZonedDateTime cityDateTime = instant.atZone(zoneId);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d");
            return cityDateTime.format(formatter);
        } else {
            throw new RuntimeException("Failed to get city date, status: " + response.getStatusCode());
        }
    }



    public int getTemperature(String cityName){
        Response response = RestAssured.given()
            .queryParam("q", cityName)
            .queryParam("appid", API_KEY)
            .queryParam("units", "metric")
            .when()
            .get("https://api.openweathermap.org/data/2.5/weather");


        int statusCode = response.getStatusCode();
        if (statusCode == 200) {
            double temperature = response.jsonPath().getDouble("main.temp");
            return (int) Math.round(temperature);
        } else {
            throw new RuntimeException("Failed to get temperature. Status code: " + response.statusCode());
        }
    }

}
