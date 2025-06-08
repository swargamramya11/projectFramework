package Pages;

import io.appium.java_client.AppiumBy;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.*;

import static Utilities.BrowserDriver.*;
import static Utilities.GlobalVariables.Context.*;
import static Utilities.GlobalVariables.ScenarioContext.*;
import static Utilities.ReusableMethods.*;

public class appiumNativeGeneralStoreApp {
    static By yourName = By.id("com.androidsample.generalstore:id/nameField");
    static By country = By.id("android:id/text1");
    static By letsShop = By.id("com.androidsample.generalstore:id/btnLetsShop");
    static By toastMessage = By.xpath("(//android.widget.Toast)[1]");
    static By products = By.id("com.androidsample.generalstore:id/productName");
    static By addToCart = By.id("com.androidsample.generalstore:id/productAddCart");
    static By cartButton = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    static By cartTile = By.id("com.androidsample.generalstore:id/toolbar_title");
    static By productPrice = By.id("com.androidsample.generalstore:id/productPrice");
    static By totalPrice = By.id("com.androidsample.generalstore:id/totalAmountLbl");
    static By terms_Conditions = By.id("com.androidsample.generalstore:id/termsButton");
    static By closeButton = By.id("android:id/button1");
    static String termsAndConditionsCheckbox = "android.widget.CheckBox";
    static By proceedButton = By.id("com.androidsample.generalstore:id/btnProceed");
    static By searchBox = By.name("q");

    public static void iEnterData(DataTable dataTable) {
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

    public static void iSelectRadioButton(String radioButton) {
        threadSleep(5000);
        By gender = By.xpath("//android.widget.RadioButton[@text='" + radioButton + "']");
        clickElement(gender);
    }

    public static void iSelectDRopDown(String option) {
        clickElement(country);
        scrollDownToParticularElement(option);

        By countryOption = By.xpath("//android.widget.TextView[@text='" + option + "']");
        clickElement(countryOption);
    }

    public static void iClickOnButton(String option) {
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

    public static void iVerifyToastErrorMessage() {
        String toastMessage1 = getAttribute(toastMessage, "name");
        Assert.assertEquals(toastMessage1, "Please enter your name");
    }

    public static void getAllElements(String productName) {
        threadSleep(1000);
        scrollDownToParticularElement(productName);

        int productCount = driver.findElements(products).size();
        for (int i = 0; i < productCount; i++) {
            String productName1 = driver.findElements(products).get(i).getText();

            if (productName1.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(addToCart).get(i).click();
            }
        }
    }

    public static void iWaitForElement(String title) {
        threadSleep(3000);
        webDriverWait.until(ExpectedConditions.attributeContains(driver.findElement(cartTile), "text", title));
    }

    public static void getPriceOfAllProducts() {
        List<WebElement> productPrices = driver.findElements(productPrice);
        int count = productPrices.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++) {
            String amountString = productPrices.get(i).getText();
            Double price = getFormattedAmount(amountString);
            totalSum = totalSum + price;
        }
        setContext(TOTALSUM, totalSum);
    }

    public static void verifyTotalPrice() {
        String displaySum = getText(totalPrice);
        Double displayFormattedSum = getFormattedAmount(displaySum);
        Assert.assertEquals((Double) getContext(TOTALSUM), displayFormattedSum);
    }

    public static void iClickOnCheckbox(String option) {
        switch (option) {
            case "Terms and Conditions":
                driver.findElement(AppiumBy.className(termsAndConditionsCheckbox)).click();
                break;
        }
    }

    public static void getAllContexts() {
        threadSleep(6000);
        Set<String> contexts = getContextHandles();
        for (String contextName : contexts) {
            System.out.println(contextName);
        }
    }

    public static void navigateToRequiredContextPage(String pageName) {
        switch (pageName) {
            case "Web":
                navigateToContext("WEBVIEW_com.androidsample.generalstore");
                break;
            case "Native":
                navigateToContext("NATIVE_APP");
                break;
        }
    }

    public static void iPressRequiredButton(String buttonName) {
        switch (buttonName) {
            case "Back":
                pressBack();
                break;
        }
    }
}