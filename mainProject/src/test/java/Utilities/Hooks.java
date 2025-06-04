package Utilities;

import io.cucumber.java.*;

import java.io.*;

import static Utilities.BrowserDriver.*;
import static Utilities.ReusableMethods.*;

public class Hooks {

    public static BrowserDriver driver;

    @Before
    public void setup() throws IOException {
        System.out.println("Before");
        Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe");
        driver = new BrowserDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        System.out.println("After");

        if (scenario.isFailed()) {
            scenario.attach(takesScreenshotAsByte(), "image/png", scenario.getName());
        }

        close();
    }
}