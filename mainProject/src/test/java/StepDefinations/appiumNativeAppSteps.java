package StepDefinations;

import io.cucumber.java.en.*;

import static Pages.appiumNativeApp.*;

public class appiumNativeAppSteps {

    @Given("^I am on api demos app and click on '(.*)'$")
    public static void demo(String option) {
        iselectRequiredOption(option);
    }

    @Given("^I select '(.*)' checkbox$")
    public static void checkbox(String option) {
        selectCheckbox(option);
    }

    @Given("^I click on '(.*)'$")
    public static void iclickonwifisettings(String option) {
        IClickOnWifiSettings(option);
    }

    @Given("^I enter data in '(.*)'$")
    public static void ienterData(String option) {
        iEnterDataInTextBox(option);
    }

    @Given("^I '(.*)' to '(.*)'$")
    public static void perform_Required_Action(String operationToBePerformed, String element) {
        performRequiredAction(operationToBePerformed, element);
    }
}
