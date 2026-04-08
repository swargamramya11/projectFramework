package Utilities;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.*;
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

    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    public static WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    public ChromeOptions options;
    public UiAutomator2Options uiOptions;
    public DesiredCapabilities gridCapabilities;
    public String chromeDriverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    public static String seleniumServerPath = System.getProperty("user.dir") + "\\src\\test\\resources\\gridFiles\\selenium-server-4.32.0.jar";
    public static String appiumServerPath = "C:\\Users\\swarg\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
    public static AppiumDriverLocalService service;
    public static ProcessBuilder hubBuilder;
    public static ProcessBuilder nodeBuilder;
    public static Process hubProcess;
    public static Process nodeProcess;

    public static void setDriver(WebDriver driver) {
        tdriver.set(driver);
    }

    public static WebDriver getDriver() {
        return tdriver.get();
    }

    public BrowserDriver() throws IOException {
        launchBrowserAndNavigateToUrl();
    }

    public void launchBrowserAndNavigateToUrl() throws IOException {
        WebDriver driver;
        URL url = new URL("http://0.0.0.0:4723");

        switch (deviceType) {
            case "desktop-windows":
                driver = new ChromeDriver(getChromeOptions());
                setDriver(driver);
                driver.get(getProp("url"));
                break;
            case "native-mobile":
                uiOptions = getUiAutomator2OptionsOfNativeApp();
                driver = new AndroidDriver(url, uiOptions);
                setDriver(driver);
                break;
            case "web-mobile":
                uiOptions = getUiAutomator2OptionsOfWebMobile();
                driver = new AndroidDriver(url, uiOptions);
                setDriver(driver);
                getDriver().get(getProp("url"));
                break;
            case "grid":
                gridCapabilities = gridCapabilities();

                driver = new RemoteWebDriver(new URL("http://localhost:4444"), gridCapabilities);
                setDriver(driver);
                getDriver().get(getProp("url"));
                getDriver().manage().window().maximize();
                break;
        }
    }

    public ChromeOptions getChromeOptions() {
        options = new ChromeOptions();

        if(deviceType.contains("grid")) {
            options.setBinary("C:\\Program Files\\Google\\Chrome\\Application.chrome.exe");
            String chromeVersion = System.getProperty("chrome.version");

            if (chromeVersion != null & !chromeVersion.isEmpty()) {
                options.setBrowserVersion(chromeVersion);
            }
        }

        options.setPageLoadTimeout(Duration.of(10, ChronoUnit.SECONDS));
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.setAcceptInsecureCerts(true);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
//        options.addArguments("--headless");
        return options;
    }

    private UiAutomator2Options getUiAutomator2OptionsOfWebMobile() {
        uiOptions = new UiAutomator2Options();
        uiOptions.setCapability("browserName", "Chrome");
        uiOptions.setDeviceName("RamyaEmulator");
        uiOptions.setChromedriverExecutable(chromeDriverPath);

        return uiOptions;
    }

    private UiAutomator2Options getUiAutomator2OptionsOfNativeApp() {
        uiOptions = new UiAutomator2Options();
        uiOptions.setDeviceName("RamyaEmulator");
        uiOptions.setApp(apkPath);
        uiOptions.setChromedriverExecutable(chromeDriverPath);

        return uiOptions;
    }

    private DesiredCapabilities gridCapabilities() {
        DesiredCapabilities gridCapabilities = new DesiredCapabilities();
        gridCapabilities.setBrowserName("chrome");

        return gridCapabilities;
    }

    public static void quitDriver() {
        if (!testingType.equals("api")) {
            getDriver().quit();
        }
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