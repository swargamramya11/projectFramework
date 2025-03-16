package Utilities;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;

import java.io.IOException;

import static Utilities.BrowserDriver.close;
import static Utilities.ReusableMethods.takesScreenshotAsByte;

public class Hooks {

    public static BrowserDriver driver;
    public static  Scenario scenario;

    @Before
    public void setup() throws IOException {
        System.out.println("Before");
        Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe");
        driver =  new BrowserDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("After");

        if(scenario.isFailed()) {
            scenario.attach(takesScreenshotAsByte(), "image/png", scenario.getName());
        }

        close();
    }
}
