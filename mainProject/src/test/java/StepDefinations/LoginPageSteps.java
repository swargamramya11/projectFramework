package StepDefinations;

import Pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static Utilities.BrowserDriver.*;
import static Utilities.ReusableMethods.*;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @Given("^I am a amazon user login with '(.*)'$")
    public void login(String email) {
        loginPage.contineShopping();
        loginPage.clickSignIn();
        loginPage.enterEmail(email);
        threadSleep(6000);
    }

    @Given("^verify below products")
    public void verification(DataTable dataTable) {
        List<List<String>> transposedDetails = dataTable.transpose().asLists();
        List<List<String>> detailsToBeVerified = dataTable.asLists();
        List<Map<String, String>> userDetails = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i <= transposedDetails.size() - 1; i++) {
            String fieldName = detailsToBeVerified.get(0).get(i);
            switch (fieldName) {

            }
        }
    }

    @Given("^I am on sample site$")
    public void login1() {
        enterData(getDriver().findElement(By.xpath("//input[@name ='firstName']")), "ramya");
        threadSleep(5000);
    }
}