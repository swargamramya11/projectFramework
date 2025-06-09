package Pages;

import Utilities.apiUtilities.payLoad;
import io.restassured.RestAssured;

import static Utilities.GlobalVariables.Context.*;
import static Utilities.GlobalVariables.ScenarioContext.*;
import static Utilities.ReusableMethods.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleAPI {

    WebDriver driver;

    public GoogleAPI(WebDriver driver) {
        this.driver = driver;
    }

    public void google_api(String requestType) {
        //given - all input details
        //when - Submit the API -resource,http method
        //Then - validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        switch (requestType) {
            case "ADD":
                String response = given().log().all().queryParam("key", "qaclick123")
                        .header("Content-Type", "application/json")
                        .body(payLoad.AddPlace())
                        .when().post("maps/api/place/add/json")
                        .then().log().all().assertThat().statusCode(200)
                        .body("scope", equalTo("APP"))
                        .header("server", "Apache/2.4.52 (Ubuntu)")
                        .extract().response().asString();

                setContext(RESPONSE, response);
                System.out.println(response);
                break;
            case "UPDATE":
                given().log().all().queryParam("key", "qaclick123")
                        .header("Content-Type", "application/json")
                        .body(payLoad.UpdatePlace())
                        .when().put("maps/api/place/update/json")
                        .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
                break;
            case "GET":
                String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                        .queryParam("place_id", (String) getContext(PARAMS))
                        .when().get("maps/api/place/get/json")
                        .then().assertThat().log().all().statusCode(200)
                        .extract().response().asString();

                JsonPath js1 = rawToJson(getPlaceResponse);
                String actualAddress = js1.getString("address");
                System.out.println(actualAddress);
                Assert.assertEquals(actualAddress, (String) getContext(NEWADDRESS));
                break;
        }
    }

    public static String retrieveRequiredPrams(String requiredParam) {
        JsonPath js = new JsonPath((String) getContext(RESPONSE)); //for parsing Json
        String params = js.getString(requiredParam);
        setContext(PARAMS, params);
        return params;
    }
}