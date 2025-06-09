package Utilities.apiUtilities;

import static Pages.GoogleAPI.retrieveRequiredPrams;
import static Utilities.GlobalVariables.Context.NEWADDRESS;
import static Utilities.GlobalVariables.ScenarioContext.setContext;
import static Utilities.ReusableMethods.*;

public class payLoad {

    public static String AddPlace() {
        return "{\r\n" +
                "  \"location\": {\r\n" +
                "    \"lat\": -38.383494,\r\n" +
                "    \"lng\": 33.427362\r\n" +
                "  },\r\n" +
                "  \"accuracy\": 50,\r\n" +
                "  \"name\": \"" + createRandomString(8) + "\",\r\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
                "  \"address\": \"29, side layout, cohen 09\",\r\n" +
                "  \"types\": [\r\n" +
                "    \"shoe park\",\r\n" +
                "    \"shop\"\r\n" +
                "  ],\r\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                "  \"language\": \"French-IN\"\r\n" +
                "}\r\n" +
                "";
    }

    public static String UpdatePlace() {
        String newAddress = createRandomNumbers(2) + " " + createRandomString(4) + "Summer Walk, Africa";
        setContext(NEWADDRESS, newAddress);

        return "{\r\n" +
                "\"place_id\":\"" + retrieveRequiredPrams("place_id") + "\",\r\n" +
                "\"address\":\"" + newAddress + "\",\r\n" +
                "\"key\":\"qaclick123\"\r\n" +
                "}";
    }
}
