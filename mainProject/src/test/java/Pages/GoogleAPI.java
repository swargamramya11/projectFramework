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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GoogleAPI {

    WebDriver driver;
    String jsonPath = "C:\\Users\\swarg\\framework\\projectFramework\\mainProject\\src\\test\\resources\\JSON files\\complex.json";

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

    public void complexJSON() throws IOException {
        JsonPath js = new JsonPath(new String(Files.readAllBytes(Paths.get(jsonPath))));

//Print No of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println("No of courses returned by API: " + count);

//Print Purchase Amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount: " + totalAmount);

//Print Title of the first course
        String titleFirstCourse = js.get("courses[0].title");
        System.out.println("Title of the first course: " + titleFirstCourse);

//Print All course titles and their respective Prices
        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + " - Course Price: " + js.get("courses[" + i + "].price").toString());
            System.out.println(i + 1 + " - Course title: " + js.get("courses[" + i + "].title").toString());
        }

//Print no of copies sold by RPA Course
        System.out.println("***************** Print no of copies sold by RPA Course ******************");

        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA")) {
                System.out.println("No of copies sold by RPA Course: " + js.get("courses[" + i + "].copies"));
                break;
            }
        }

//Sum of prices validation
        System.out.println("***************** Sum of prices validation ******************");

        int sum = 0;
        for (int i = 0; i < count; i++) {
            int price = js.getInt("courses[" + i + "].price");
            int copies = js.getInt("courses[" + i + "].copies");
            int amount = price * copies;
            System.out.println("Amount: " + amount);
            sum = sum + amount;
        }

        System.out.println("Sum of Prices: " + sum);
        Assert.assertEquals(sum, js.getInt("dashboard.purchaseAmount"));
    }
}