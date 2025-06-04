package StepDefinations;

import io.cucumber.java.en.Given;

import static Pages.LoginPage.enterEmail;

public class LoginPageSteps {

    @Given("^I am a amazon user login with '(.*)'$")
    public void login(String email) {
//        enterEmail(email);
    }
}
