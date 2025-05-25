package Utilities;

import io.appium.java_client.service.local.*;
import io.cucumber.java.*;

import java.io.*;

import static Utilities.BrowserDriver.*;
import static Utilities.Props.*;
import static Utilities.ReusableMethods.*;

public class Hooks {

    public static BrowserDriver driver;
    public static AppiumDriverLocalService service;
    public static ProcessBuilder hubBuilder;
    public static ProcessBuilder nodeBuilder;
    public static Process hubProcess;
    public static Process nodeProcess;

    @Before
    public void setup() throws IOException {
        System.out.println("Before");

        if (env.contains("mobile")) {
            service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\swarg\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).
                    withIPAddress("127.0.0.1").usingPort(4723).build();
            service.start();
        } else if (env.contains("grid")) {
//            Start hub
            hubBuilder = new ProcessBuilder(
                    "java",
                    "-jar",
                    seleniumServerPath,
                    "hub");
            hubBuilder.inheritIO();
            hubProcess = hubBuilder.start();
            System.out.println("Hub Started");

            threadSleep(10000);

//            Start Node
            nodeBuilder = new ProcessBuilder(
                    "java",
                    "-jar",
                    seleniumServerPath,
                    "node",
                    "--hub",
                    "http://localhost:4444");
            nodeBuilder.inheritIO();
            nodeProcess = nodeBuilder.start();
            System.out.println("Node Started");
        }

        threadSleep(10000);

        Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe");
        driver = new BrowserDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        System.out.println("After");

        if (!env.contains("mobile")) {
            if (scenario.isFailed()) {
                scenario.attach(takesScreenshotAsByte(), "image/png", scenario.getName());
            }
        }

        close();

        if (env.contains("mobile")) {
            service.stop();
        } else if (env.contains("grid")) {
            nodeProcess.destroy();
            threadSleep(10000);
            hubProcess.destroy();
        }
    }
}