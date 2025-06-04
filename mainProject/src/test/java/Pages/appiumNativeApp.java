package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Utilities.BrowserDriver.getWebDriver;
import static Utilities.ReusableMethods.*;

public class appiumNativeApp {
    static By wifiCheckbox = By.id("android:id/checkbox");
    static By wifiTextbox = By.id("android:id/edit");
    static By wifiSetting = By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]");
    static By alertTitle = By.id("android:id/alertTitle");
    static By longPresselement = By.xpath("//android.widget.TextView[@text='People Names']");
    static By firstPhotoElement = By.xpath("(//android.widget.ImageView)[1]");
    static By sourceToDrag = By.id("io.appium.android.apis:id/drag_dot_1");
    static By resultOfDrag = By.id("io.appium.android.apis:id/drag_result_text");

    public static void iselectRequiredOption(String option) {
        threadSleep(2000);
        getWebDriver().findElement(AppiumBy.accessibilityId(option)).click();
    }

    public static void selectCheckbox(String option) {
        clickElement(wifiCheckbox);
    }

    public static void IClickOnWifiSettings(String option) {
        switch (option) {
            case "WiFi settings":
                clickElement(wifiSetting);
                Assert.assertEquals(getText(alertTitle), option);
                break;
            case "Ok":
                clickElementWithIndex(AppiumBy.className("android.widget.Button"), 1);
                break;
        }
    }

    public static void iEnterDataInTextBox(String option) {
        enterData(wifiTextbox, option);
    }

    public static void performRequiredAction(String operationToBePerformed, String element) {
        switch (operationToBePerformed) {
            case "Long Press":
                longPressAction(longPresselement);
                break;
            case "Scroll":
                getWebDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
                break;
            case "Swipe":
                Assert.assertEquals(getAttribute(firstPhotoElement, "focusable"), "true");
                swipeAction(firstPhotoElement, "left");
                Assert.assertEquals(getAttribute(firstPhotoElement, "focusable"), "false");
                break;
            case "Drag and Drop":
                dragAndDropAction(sourceToDrag, 619, 560);
                threadSleep(2000);
                Assert.assertEquals(getText(resultOfDrag), "Dropped!");
                break;
        }
    }
}
