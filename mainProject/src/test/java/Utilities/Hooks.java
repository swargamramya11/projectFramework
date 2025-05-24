package Utilities;

import io.appium.java_client.service.local.*;
import io.cucumber.java.*;

import java.io.*;
import java.net.URISyntaxException;

import static Utilities.BrowserDriver.*;
import static Utilities.Props.*;
import static Utilities.ReusableMethods.*;

public class Hooks {

    public static BrowserDriver driver;
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