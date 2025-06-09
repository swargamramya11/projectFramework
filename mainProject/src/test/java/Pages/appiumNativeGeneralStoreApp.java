package Pages;

import io.appium.java_client.pagefactory.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.*;

import static Utilities.BrowserDriver.*;
import static Utilities.GlobalVariables.Context.*;
import static Utilities.GlobalVariables.ScenarioContext.*;
import static Utilities.ReusableMethods.*;

public class appiumNativeGeneralStoreApp {

    WebDriver driver;

    public appiumNativeGeneralStoreApp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.androidsample.generalstore:id/nameField")
    WebElement yourName;
    @FindBy(id = "android:id/text1")
    WebElement country;
    @FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    WebElement letsShop;
    @FindBy(id = "(//android.widget.Toast)[1]")
    WebElement toastMessage;
    @FindBy(id = "com.androidsample.generalstore:id/productName")
    List<WebElement> products;
    @FindBy(id = "com.androidsample.generalstore:id/productAddCart")
    List<WebElement> addToCart;
    @FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    WebElement cartButton;
    @FindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    WebElement cartTile;
    @FindBy(id = "com.androidsample.generalstore:id/productPrice")
    List<WebElement> productPrice;
    @FindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    WebElement totalPrice;
    @FindBy(id = "com.androidsample.generalstore:id/termsButton")
    WebElement terms_Conditions;
    @FindBy(id = "android:id/button1")
    WebElement closeButton;
    @FindBy(id = "com.androidsample.generalstore:id/btnProceed")
    WebElement proceedButton;
    @FindBy(name = "q")
    WebElement searchBox;
    @AndroidFindBy(className = "android.widget.CheckBox")
    WebElement termsAndConditionsCheckbox;

    public void iEnterData(DataTable dataTable) {
        List<List<String>> transposedDetails = dataTable.transpose().asLists();
        List<List<String>> details = dataTable.asLists();
        List<Map<String, String>> userDetails = dataTable.asMaps(String.class, String.class);

//        String value = userDetails.getFirst().get("Your Name");
//        String valueq = userDetails.get(0).get("Your Name");

        for (int i = 0; i <= transposedDetails.size() - 1; i++) {
            switch (details.get(0).get(i)) {
                case "Your Name":
                    threadSleep(4000);
                    enterData(yourName, details.get(0).get(i));
                    hideKeyBoard();
                    break;
                case "Chrome Search":
                    enterData(searchBox, details.get(0).get(i));
                    clickEnter(searchBox);
                    break;
                default:
                    System.out.println("Missed case: " + details.get(0).get(i));
                    boolean fail = false;
                    Assert.assertTrue(fail);
                    break;
            }
        }
    }

    public void iSelectRadioButton(String radioButton) {
        threadSleep(5000);
        By gender = By.xpath("//android.widget.RadioButton[@text='" + radioButton + "']");
        clickElement(driver.findElement(gender));
    }

    public void iSelectDRopDown(String option) {
        clickElement(country);
        scrollDownToParticularElement(option);

        By countryOption = By.xpath("//android.widget.TextView[@text='" + option + "']");
        clickElement(driver.findElement(countryOption));
    }

    public void iClickOnButton(String option) {
        switch (option) {
            case "Let's Shop":
                clickElement(letsShop);
                threadSleep(2000);
                break;
            case "Cart":
                clickElement(cartButton);
                break;
            case "Terms and Conditions":
                longPressAction(terms_Conditions);
                break;
            case "Close":
                clickElement(closeButton);
                break;
            case "Proceed":
                clickElement(proceedButton);
                threadSleep(6000);
                break;
        }
    }

    public void iVerifyToastErrorMessage() {
        String toastMessage1 = getAttribute(toastMessage, "name");
        Assert.assertEquals(toastMessage1, "Please enter your name");
    }

    public void getAllElements(String productName) {
        threadSleep(1000);
        scrollDownToParticularElement(productName);

        int productCount = products.size();
        for (int i = 0; i < productCount; i++) {
            String productName1 = products.get(i).getText();

            if (productName1.equalsIgnoreCase("Jordan 6 Rings")) {
                addToCart.get(i).click();
            }
        }
    }

    public void iWaitForElement(String title) {
        threadSleep(3000);
        webDriverWait.until(ExpectedConditions.attributeContains(cartTile, "text", title));
    }

    public void getPriceOfAllProducts() {
        List<WebElement> productPrices = productPrice;
        int count = productPrice.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++) {
            String amountString = productPrices.get(i).getText();
            Double price = getFormattedAmount(amountString);
            totalSum = totalSum + price;
        }
        setContext(TOTALSUM, totalSum);
    }

    public void verifyTotalPrice() {
        String displaySum = getText(totalPrice);
        Double displayFormattedSum = getFormattedAmount(displaySum);
        Assert.assertEquals((Double) getContext(TOTALSUM), displayFormattedSum);
    }

    public void iClickOnCheckbox(String option) {
        switch (option) {
            case "Terms and Conditions":
//                driver.findElement(AppiumBy.className(termsAndConditionsCheckbox)).click();
                clickElement(termsAndConditionsCheckbox);
                break;
        }
    }

    public void getAllContexts() {
        threadSleep(6000);
        Set<String> contexts = getContextHandles();
        for (String contextName : contexts) {
            System.out.println(contextName);
        }
    }

    public void navigateToRequiredContextPage(String pageName) {
        switch (pageName) {
            case "Web":
                navigateToContext("WEBVIEW_com.androidsample.generalstore");
                break;
            case "Native":
                navigateToContext("NATIVE_APP");
                break;
        }
    }

    public void iPressRequiredButton(String buttonName) {
        switch (buttonName) {
            case "Back":
                pressBack();
                break;
        }
    }
}