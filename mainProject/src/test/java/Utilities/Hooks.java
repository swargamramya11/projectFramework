package Utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static Utilities.BrowserDriver.close;
import static Utilities.Props.env;
import static Utilities.ReusableMethods.takesScreenshotAsByte;

public class Hooks {

    public static BrowserDriver driver;
    public static Scenario scenario;
    public static AppiumDriverLocalService service;

    @Before
    public void setup() throws IOException, URISyntaxException {
        System.out.println("Before");

        if (env.contains("mobile")) {
            service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\swarg\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).
                    withIPAddress("127.0.0.1").usingPort(4723).build();
            service.start();
        }

        Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe");
        driver = new BrowserDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("After");

        if (!env.contains("mobile")) {
            if (scenario.isFailed()) {
                scenario.attach(takesScreenshotAsByte(), "image/png", scenario.getName());
            }
        }

        close();

        if (env.contains("mobile")) {
            service.stop();
        }
    }
}
