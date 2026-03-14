package StepDefinations;

import Pages.*;
import io.cucumber.java.en.*;

import java.io.IOException;

public class GoogleAPISteps {

    GoogleAPI googleApi = new GoogleAPI();

    @Given("^I '(.*)' place$")
    public void api(String requestType) {
        googleApi.google_api(requestType);
    }

    @Given("^Retrieve '(.*)' from response$")
    public void retriveRequiredPrams(String requiredParam) {
        googleApi.retrieveRequiredPrams(requiredParam);
    }

    @Given("^I perform all operations in Complex JSON$")
    public void complex_JSON() throws IOException {
        googleApi.complexJSON();
    }
}