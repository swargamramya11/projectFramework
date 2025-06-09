package StepDefinations;

import Pages.appiumNativeApiDemosApp;
import io.cucumber.java.en.*;

import static Utilities.BrowserDriver.driver;

public class appiumNativeApiDemosAppSteps {

    appiumNativeApiDemosApp apiDemosApp = new appiumNativeApiDemosApp(driver);

    @Given("^I am on api demos app and click on '(.*)'$")
    public void demo(String option) {
        apiDemosApp.iselectRequiredOption(option);
    }

    @Given("^I select '(.*)' checkbox$")
    public void checkbox(String option) {
        apiDemosApp.selectCheckbox(option);
    }

    @Given("^I click on '(.*)'$")
    public void iclickonwifisettings(String option) {
        apiDemosApp.IClickOnWifiSettings(option);
    }

    @Given("^I enter data in '(.*)'$")
    public void ienterData(String option) {
        apiDemosApp.iEnterDataInTextBox(option);
    }

    @Given("^I '(.*)' to '(.*)'$")
    public void perform_Required_Action(String operationToBePerformed, String element) {
        apiDemosApp.performRequiredAction(operationToBePerformed, element);
    }

    @Given("^I directly navigate to '(.*)'$")
    public void inavigateToRequiredPage(String pageName) {
        apiDemosApp.navigateToRequiredPageDirectly(pageName);
    }
}