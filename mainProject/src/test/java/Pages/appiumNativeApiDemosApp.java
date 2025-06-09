package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Assert;

import java.util.List;

import static Utilities.BrowserDriver.*;
import static Utilities.ReusableMethods.*;

public class appiumNativeApiDemosApp {

    WebDriver driver;

    public appiumNativeApiDemosApp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "android:id/checkbox")
    WebElement wifiCheckbox;
    @FindBy(id = "android:id/edit")
    WebElement wifiTextbox;
    @FindBy(xpath = "//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]")
    WebElement wifiSetting;
    @FindBy(id = "android:id/alertTitle")
    WebElement alertTitle;
    @FindBy(xpath = "//android.widget.TextView[@text='People Names']")
    WebElement longPresselement;
    @FindBy(xpath = "(//android.widget.ImageView)[1]")
    WebElement firstPhotoElement;
    @FindBy(id = "io.appium.android.apis:id/drag_dot_1")
    WebElement sourceToDrag;
    @FindBy(id = "io.appium.android.apis:id/drag_result_text")
    WebElement resultOfDrag;
    @AndroidFindBy(className = "android.widget.Button")
    List<WebElement> okButton;

    public void iselectRequiredOption(String option) {
        threadSleep(2000);
        getWebDriver().findElement(AppiumBy.accessibilityId(option)).click();
    }

    public void selectCheckbox(String option) {
        clickElement(wifiCheckbox);
    }

    public void IClickOnWifiSettings(String option) {
        switch (option) {
            case "WiFi settings":
                landScape();
                clickElement(wifiSetting);
                Assert.assertEquals(getText(alertTitle), option);
                break;
            case "Ok":
                clickElementWithIndex(okButton, 1);
                pressBack();
                pressHome();
                break;
        }
    }

    public void iEnterDataInTextBox(String option) {
        enterData(wifiTextbox, option);
        setClipBoardData("Rahul Wifi");
        enterData(wifiTextbox, getClipBoardData());
        pressEnter();
    }

    public void performRequiredAction(String operationToBePerformed, String element) {
        switch (operationToBePerformed) {
            case "Long Press":
                longPressAction(longPresselement);
                break;
            case "Scroll":
                scrollDownToParticularElement(element);
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

    public void navigateToRequiredPageDirectly(String pageName) {
        switch (pageName) {
            case "3. Preference dependencies":
                String ac = "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies";
                startActivity(ac);
        }
    }
}