package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static Utilities.BrowserDriver.driver;
import static Utilities.ReusableMethods.*;

public class appiumNativeApp {

    public static void iselectRequiredOption(String option) {
        threadSleep(2000);
        driver.findElement(AppiumBy.accessibilityId(option)).click();
    }

    public static void selectCheckbox(String option) {
        driver.findElement(By.id("android:id/checkbox")).click();
    }

    public static void IClickOnWifiSettings(String option) {
        switch (option) {
            case "WiFi settings":
                driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]")).click();
                String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
                Assert.assertEquals(alertTitle, option);
                break;
            case "Ok":
                driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
                break;
        }
    }

    public static void iEnterDataInTextBox(String option) {
        driver.findElement(By.id("android:id/edit")).sendKeys(option);
    }

    public static void performRequiredAction(String operationToBePerformed, String element) {
        switch (operationToBePerformed) {
            case "Long Press":
                WebElement longPresselement = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
                longPressAction(longPresselement);
                break;
            case "scroll":
                driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
                break;
            case "swipe":
                Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
                WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
                swipeAction(firstImage, "left");
                Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
                break;
            case "drag and drop":
                WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

                dragAndDropAction(source, 619, 560);

                threadSleep(2000);
                String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
                Assert.assertEquals(result, "Dropped!");
                break;
        }
    }
}
