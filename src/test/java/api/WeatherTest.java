package api;

import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class WeatherTest extends ApiTestBase {

    @Test
    public void verifyGetWeatherByCityName() {
        Response response = REQUEST.given().param("q", "Pushcha-Voditsa").get();
        verifyGetWeatherResponse(response);
    }

    @Test
    public void verifyGetWeatherByLatLong() {
        Response response = REQUEST.given().params("lat", "50.45466", "lon", "30.5238").get();
        verifyGetWeatherResponse(response);
    }

    @Test
    public void verifyGetWeatherById() {
        Response response = REQUEST.given().param("id", "696050").get();
        verifyGetWeatherResponse(response);
    }

    private void verifyGetWeatherResponse(Response response) {
        response.then().body("id", is(696050),
                "name", is("Pushcha-Voditsa"),
                "sys", hasEntry("country", "UA"));
    }
}
