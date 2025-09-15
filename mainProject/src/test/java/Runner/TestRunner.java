package Runner;

import Utilities.Retry;
import io.cucumber.testng.*;
import org.testng.annotations.*;

import java.io.IOException;

import static Utilities.BrowserDriver.*;
import static Utilities.Props.*;
import static Utilities.ReusableMethods.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"Utilities", "StepDefinations"},
        tags = "@Regression",
        plugin = {"pretty", "html:target/cucumber-reports",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failedRerun.txt"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios",
            retryAnalyzer = Retry.class
    )

    @Override
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
    }

    @BeforeSuite
    public static void beforeSuite() throws IOException {
        System.out.println("Before Suite");
        deleteRequiredFolder("\\target\\allure");

        if (deviceType.contains("mobile")) {
            startAppiumServer();
        } else if (deviceType.contains("grid")) {
            startHub();
            startNode();
        }

        threadSleep(10000);
    }

    @AfterSuite
    public static void afterSuite() throws IOException {
        System.out.println("After Suite");

        if (deviceType.contains("mobile")) {
            stopAppiumServer();
        } else if (deviceType.contains("grid")) {
            stopNode();
            threadSleep(10000);
            stophub();
        }

        generateAllureReport();
    }
}