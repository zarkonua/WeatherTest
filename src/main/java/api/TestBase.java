package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public RequestSpecification REQUEST;

    public TestBase() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

            RestAssured.baseURI = props.getProperty("api.uri");
            RestAssured.port = Integer.valueOf(props.getProperty("api.port"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        REQUEST = RestAssured.given().contentType(ContentType.JSON).given().params("APPID", "b8549bf9ba0f8882ab75da63cb4981bd",
                "units", "imperial");
    }
}
