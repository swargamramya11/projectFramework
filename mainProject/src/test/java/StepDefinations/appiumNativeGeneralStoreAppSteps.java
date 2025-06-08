package StepDefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import static Pages.appiumNativeGeneralStoreApp.*;

public class appiumNativeGeneralStoreAppSteps {

    @Given("^I enter data in below field$")
    public void IEnterData(DataTable dataTable) {
        iEnterData(dataTable);
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

    @Given("Get price of all products in cart$")
    public void get_Price_Of_All_Products() {
        getPriceOfAllProducts();
    }

    @Given("Verify total price$")
    public void verify_Total_Price() {
        verifyTotalPrice();
    }

    @Given("I click '(.*)' checkbox$")
    public void i_Click_On_Checkbox(String option) {
        iClickOnCheckbox(option);
    }

    @Given("Get all contexts$")
    public void get_All_Contexts() {
        getAllContexts();
    }

    @Given("Navigate to required '(.*)' context page$")
    public void navigate_To_Required_Context_Page(String pageName) {
        navigateToRequiredContextPage(pageName);
    }

    @Given("I press '(.*)' in mobile$")
    public void i_Press_Required_Button(String buttonName) {
        iPressRequiredButton(buttonName);
    }
}
