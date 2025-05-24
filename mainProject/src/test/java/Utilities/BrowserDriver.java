package Utilities;

import io.appium.java_client.AppiumDriver;
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
    public static AppiumDriver appiumDriver;
    public static AndroidDriver androidDriver;
    public static WebDriverWait webDriverWait;
    public static ChromeOptions options;
    public static String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    public static String apkFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\apkFiles\\apk.apk";

    public BrowserDriver() throws MalformedURLException, URISyntaxException {
        launchBrowserAndNavigateToUrl();
    }

    public static void launchBrowserAndNavigateToUrl() throws MalformedURLException, URISyntaxException {
        if (env.equals("windows")) {
            driver = new ChromeDriver(getChromeOptions());
            threadSleep(6000);
            driver.get(getProp("url"));
        } else if (env.equals("native-mobile")) {
            UiAutomator2Options cap = getUiAutomator2OptionsOfNativeApp();

            URL url = new URL("http://0.0.0.0:4723");
            appiumDriver = new AndroidDriver(url, cap);
        } else if (env.equals("web-mobile")) {
            UiAutomator2Options capweb = getUiAutomator2OptionsOfWebMobile();

            URL url = new URL("http://0.0.0.0:4723");
            androidDriver = new AndroidDriver(url, capweb);

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
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("browserName", "Chrome");
        options.setDeviceName("RamyaEmulator");
        options.setChromedriverExecutable(chromeDriverPath);

        return options;
    }

    private static UiAutomator2Options getUiAutomator2OptionsOfNativeApp() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RamyaEmulator");
        options.setApp(apkFilePath);

        return options;
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