package StepDefinations;

import Pages.*;
import io.cucumber.java.en.*;

import static Utilities.BrowserDriver.driver;

public class GoogleAPISteps {

    GoogleAPI googleApi = new GoogleAPI(driver);

    @Given("^I '(.*)' place$")
    public void api(String requestType) {
        googleApi.google_api(requestType);
    }

    @Given("^Retrieve '(.*)' from response$")
    public void retriveRequiredPrams(String requiredParam) {
        googleApi.retrieveRequiredPrams(requiredParam);
    }
}