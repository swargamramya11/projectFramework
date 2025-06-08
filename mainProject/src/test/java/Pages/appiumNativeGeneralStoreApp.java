package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Utilities.BrowserDriver.*;
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

    public static void iEnterData(String name) {
        threadSleep(4000);
        enterData(yourName, name);
        hideKeyBoard();
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
                break;
            case "Cart":
                clickElement(cartButton);
                break;
        }
    }

    public static void iVerifyToastErrorMessage() {
        String toastMessage1 = getAttribute(toastMessage, "name");
        Assert.assertEquals(toastMessage1, "Please enter your name");
    }

    public static void getAllElements(String productName) {
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
}