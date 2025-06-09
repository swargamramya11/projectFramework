package StepDefinations;

import Pages.appiumNativeGeneralStoreApp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import static Utilities.BrowserDriver.*;

public class appiumNativeGeneralStoreAppSteps {

    appiumNativeGeneralStoreApp general = new appiumNativeGeneralStoreApp(driver);

    @Given("^I enter data in below field$")
    public void IEnterData(DataTable dataTable) {
        general.iEnterData(dataTable);
    }

    @Given("I select '(.*)' radio button$")
    public void iselectRadioButton(String option) {
        general.iSelectRadioButton(option);
    }

    @Given("I select '(.*)' from dropdown$")
    public void iselectDRopDown(String option) {
        general.iSelectDRopDown(option);
    }

    @Given("I click '(.*)' button$")
    public void iclickOnButton(String option) {
        general.iClickOnButton(option);
    }

    @Given("Verify toast error message$")
    public void verifyErrorMessage() {
        general.iVerifyToastErrorMessage();
    }

    @Given("Get all elements and add '(.*)' product to cart$")
    public void get_All_Elements(String productName) {
        general.getAllElements(productName);
    }

    @Given("I wait for '(.*)' title$")
    public void iwaitForElement(String title) {
        general.iWaitForElement(title);
    }

    @Given("Get price of all products in cart$")
    public void get_Price_Of_All_Products() {
        general.getPriceOfAllProducts();
    }

    @Given("Verify total price$")
    public void verify_Total_Price() {
        general.verifyTotalPrice();
    }

    @Given("I click '(.*)' checkbox$")
    public void i_Click_On_Checkbox(String option) {
        general.iClickOnCheckbox(option);
    }

    @Given("Get all contexts$")
    public void get_All_Contexts() {
        general.getAllContexts();
    }

    @Given("Navigate to required '(.*)' context page$")
    public void navigate_To_Required_Context_Page(String pageName) {
        general.navigateToRequiredContextPage(pageName);
    }

    @Given("I press '(.*)' in mobile$")
    public void i_Press_Required_Button(String buttonName) {
        general.iPressRequiredButton(buttonName);
    }
}