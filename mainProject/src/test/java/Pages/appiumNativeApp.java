package Pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import static Utilities.BrowserDriver.driver;

public class appiumNativeApp {


    public static void iselectRequiredOption(String option) {
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

    public static void LongPressForGestures(String option) {
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                        "duration", 2000));
    }
}
