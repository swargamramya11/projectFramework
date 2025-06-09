package StepDefinations;

import Pages.LoginPage;
import io.cucumber.java.en.*;

import static Utilities.BrowserDriver.*;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage(driver);

    @Given("^I am a amazon user login with '(.*)'$")
    public void login(String email) {
        loginPage.enterEmail(email);
    }
}