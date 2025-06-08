package StepDefinations;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

import static Pages.appiumNativeGeneralStoreApp.*;

public class appiumNativeGeneralStoreAppSteps {

    @Given("^I enter '(.*)'$")
    public void IEnterData(String option) {
        iEnterData(option);
    }

    @Given("I select '(.*)' radio button$")
    public void iselectRadioButton(String option) {
        iSelectRadioButton(option);
    }

    @Given("I select '(.*)' from dropdown$")
    public void iselectDRopDown(String option) {
        iSelectDRopDown(option);
    }

    @Given("I click '(.*)' button$")
    public void iclickOnButton(String option) {
        iClickOnButton(option);
    }

    @Given("Verify toast error message$")
    public void verifyErrorMessage() {
        iVerifyToastErrorMessage();
    }

    @Given("Get all elements and add '(.*)' product to cart$")
    public void get_All_Elements(String productName) {
        getAllElements(productName);
    }

    @Given("I wait for '(.*)' title$")
    public void iwaitForElement(String title) {
        iWaitForElement(title);
    }
}
