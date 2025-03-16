package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static Utilities.ReusableMethods.getProp;

public class BrowserDriver {

    public static WebDriver driver;
    public static ChromeOptions options;

    public BrowserDriver() {
        launchBrowserAndNavigateToUrl();
    }

    public static void launchBrowserAndNavigateToUrl() {
        driver = new ChromeDriver(getChromeOptions());
        driver.get(getProp("url"));
    }

    public static WebDriver getWebDriver(){
        return driver;
    }

    public static ChromeOptions getChromeOptions() {
        options = new ChromeOptions();

        options.setPageLoadTimeout(Duration.of(10, ChronoUnit.SECONDS));
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.setAcceptInsecureCerts(true);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
//        options.addArguments("--headlss");
        return options;
    }

    public static void close(){
        driver.quit();
    }
}
