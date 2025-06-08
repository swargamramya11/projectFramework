package Utilities;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static Utilities.Props.*;
import static Utilities.ReusableMethods.*;

public class BrowserDriver {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
    public static ChromeOptions options;
    public static UiAutomator2Options uiOptions;
    public static DesiredCapabilities gridCapabilities;
    public static String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    public static String seleniumServerPath = System.getProperty("user.dir") + "\\src\\test\\resources\\gridFiles\\selenium-server-4.32.0.jar";
    public static String appiumServerPath = "C:\\Users\\swarg\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
    public static AppiumDriverLocalService service;
    public static ProcessBuilder hubBuilder;
    public static ProcessBuilder nodeBuilder;
    public static Process hubProcess;
    public static Process nodeProcess;

    public BrowserDriver() throws IOException {
        launchBrowserAndNavigateToUrl();
    }

    public static void launchBrowserAndNavigateToUrl() throws IOException {
        URL url = new URL("http://0.0.0.0:4723");

        switch (deviceType) {
            case "windows":
                driver = new ChromeDriver(getChromeOptions());
                driver.get(getProp("url"));
                break;
            case "native-mobile":
                uiOptions = getUiAutomator2OptionsOfNativeApp();
                driver = new AndroidDriver(url, uiOptions);
                break;
            case "web-mobile":
                uiOptions = getUiAutomator2OptionsOfWebMobile();
                driver = new AndroidDriver(url, uiOptions);
                driver.get(getProp("url"));
                break;
            case "grid":
                gridCapabilities = gridCapabilities();

                driver = new RemoteWebDriver(new URL("http://localhost:4444"), gridCapabilities);
                driver.get(getProp("url"));
                driver.manage().window().maximize();
                break;
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
        uiOptions.setApp(apkPath);

        return uiOptions;
    }

    private static DesiredCapabilities gridCapabilities() {
        DesiredCapabilities gridCapabilities = new DesiredCapabilities();
        gridCapabilities.setBrowserName("chrome");

        return gridCapabilities;
    }

    public static void close() {
        driver.quit();
    }

    public static void startAppiumServer() {
        service = new AppiumServiceBuilder().withAppiumJS(new File(appiumServerPath)).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
    }

    public static void stopAppiumServer() {
        service.stop();
    }

    public static void startHub() throws IOException {
        hubBuilder = new ProcessBuilder("java", "-jar", seleniumServerPath, "hub");
        hubBuilder.inheritIO();
        hubProcess = hubBuilder.start();
        System.out.println("Hub Started");

        threadSleep(10000);
    }

    public static void stophub() {
        hubProcess.destroy();
    }

    public static void startNode() throws IOException {
        nodeBuilder = new ProcessBuilder("java", "-jar", seleniumServerPath, "node", "--hub", "http://localhost:4444");
        nodeBuilder.inheritIO();
        nodeProcess = nodeBuilder.start();
        System.out.println("Node Started");
    }

    public static void stopNode() {
        nodeProcess.destroy();
    }

    public static void generateAllureReport() throws IOException {
        String newDir = System.getProperty("user.dir") + "\\target\\allure";
        Runtime.getRuntime().exec("cmd.exe /c cd \"" + newDir + "\" & start cmd.exe /k \"allure generate --single-file allure-results --clean\"");
        threadSleep(10000);
        Runtime.getRuntime().exec("TASKKILL /F /IM cmd.exe");
    }
}