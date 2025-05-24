package Utilities;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static Utilities.Props.*;
import static Utilities.ReusableMethods.*;

public class BrowserDriver {

    public static WebDriver driver;
    public static AndroidDriver androidDriver;
    public static WebDriverWait webDriverWait;
    public static ChromeOptions options;
    public static UiAutomator2Options uiOptions;
    public static String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    public static String apkFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\apkFiles\\apk.apk";

    public BrowserDriver() throws MalformedURLException {
        launchBrowserAndNavigateToUrl();
    }

    public static void launchBrowserAndNavigateToUrl() throws MalformedURLException {
        URL url = new URL("http://0.0.0.0:4723");

        switch (env) {
            case "windows":
                driver = new ChromeDriver(getChromeOptions());
                driver.get(getProp("url"));
                break;
            case "native-mobile":
                uiOptions = getUiAutomator2OptionsOfNativeApp();
                androidDriver = new AndroidDriver(url, uiOptions);
                break;
            case "web-mobile":
                uiOptions = getUiAutomator2OptionsOfWebMobile();
                androidDriver = new AndroidDriver(url, uiOptions);
                androidDriver.get(getProp("url"));
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static ChromeOptions getChromeOptions() {
        options = new ChromeOptions();

        options.setPageLoadTimeout(Duration.of(10, ChronoUnit.SECONDS));
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.setAcceptInsecureCerts(true);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
//        options.addArguments("--headless");
        return options;
    }

    private static UiAutomator2Options getUiAutomator2OptionsOfWebMobile() {
        uiOptions = new UiAutomator2Options();
        uiOptions.setCapability("browserName", "Chrome");
        uiOptions.setDeviceName("RamyaEmulator");
        uiOptions.setChromedriverExecutable(chromeDriverPath);

        return uiOptions;
    }

    private static UiAutomator2Options getUiAutomator2OptionsOfNativeApp() {
        uiOptions = new UiAutomator2Options();
        uiOptions.setDeviceName("RamyaEmulator");
        uiOptions.setApp(apkFilePath);

        return uiOptions;
    }

    public static void close() {
        if (env.equals("windows")) {
            driver.quit();
        } else if (env.equals("native-mobile")) {

        } else if (env.equals("web-mobile")) {
            androidDriver.quit();
        }
    }
}